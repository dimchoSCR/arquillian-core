package org.jboss.arquillian.junit.scheduling.scheduler.changedfiles;

public class ChangedFilesSchedulerParamValues {
	private String workingDir;
	private String testDir;
	private boolean filterOnlyChangedFiles;
	
	public ChangedFilesSchedulerParamValues(String workingDir, String testDir, boolean filterOnlyChangedFiles) {
		this.workingDir = workingDir;
		this.testDir = testDir;
		this.filterOnlyChangedFiles = filterOnlyChangedFiles;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public String getTestDir() {
		return testDir;
	}

	public boolean getFilterFlag() {
		return filterOnlyChangedFiles;
	}
	
}
