package org.jboss.arquillian.junit.scheduling.scheduler.changedfiles;

import java.util.Set;

import org.jboss.arquillian.junit.scheduling.scheduler.changedfiles.imports.GitChangesResolver;

public class ChangedFilesBuilder {
	private static Set<String> changedClasses;
	private String workingDir;
	
	public ChangedFilesBuilder(String workingDir) {
		this.workingDir = workingDir;
	}
	
	// Used for testing purposes only
	private static void set(Set<String> chClasses){
		changedClasses = chClasses;
	}
	
	public Set<String> build() throws Exception{
		if(changedClasses != null){
			return changedClasses;
		}
		
		return new GitChangesResolver(workingDir)
				.resolveChangedClasses();
	}
}
