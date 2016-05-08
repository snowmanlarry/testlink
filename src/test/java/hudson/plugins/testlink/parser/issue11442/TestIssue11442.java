/*
 * The MIT License
 *
 * Copyright (c) <2011> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.testlink.parser.issue11442;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.jvnet.hudson.test.Issue;

import hudson.tasks.junit.SuiteResult;
import hudson.tasks.junit.TestResult;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 0.1
 */
@Issue("11442")
public class TestIssue11442
{

	@Test
	public void testDisabledSuite() throws IOException 
	{
		final String inputFile = "hudson/plugins/testlink/parser/issue11442/TEST-test.TestMyName.xml";
		final ClassLoader cl = TestIssue11442.class.getClassLoader();
		final URL url = cl.getResource(inputFile);
		final File junitFile = new File( url.getFile() );
		TestResult testResult = new TestResult();
		testResult.parse(junitFile);
		
		boolean skipped = false;
		
		for(SuiteResult suite : testResult.getSuites()) {
			skipped = suite.getCases().get(0).isSkipped();
		}
		
		assertTrue(skipped);
	}
	
}
