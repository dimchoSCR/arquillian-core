/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.testng;

import org.jboss.arquillian.impl.TestResultImpl;
import org.jboss.arquillian.spi.TestResult;
import org.jboss.arquillian.spi.TestResult.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestListener
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 */
public class TestListener implements ITestListener
{

   private ITestContext context;
   
   /* (non-Javadoc)
    * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
    */
   @Override
   public void onFinish(ITestContext paramITestContext)
   {
      context = paramITestContext;
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
    */
   @Override
   public void onStart(ITestContext paramITestContext)
   {
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
    */
   @Override
   public void onTestFailedButWithinSuccessPercentage(ITestResult paramITestResult)
   {
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
    */
   @Override
   public void onTestFailure(ITestResult paramITestResult)
   {
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
    */
   @Override
   public void onTestSkipped(ITestResult paramITestResult)
   {
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
    */
   @Override
   public void onTestStart(ITestResult paramITestResult)
   {
   }

   /* (non-Javadoc)
    * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
    */
   @Override
   public void onTestSuccess(ITestResult paramITestResult)
   {
   }

   public TestResult getTestResult() 
   {
      if(context.getFailedTests().size() > 0) 
      {
         return new TestResultImpl(
               Status.FAILED, 
               context.getFailedTests().getAllResults().iterator().next().getThrowable());
      } 
      else if(context.getSkippedTests().size() > 0)
      {
         return new TestResultImpl(Status.SKIPPED);
      }
      return new TestResultImpl(Status.PASSED); 
   }
}