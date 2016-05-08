/* 
 * The MIT License
 * 
 * Copyright (c) 2010 Bruno P. Kinoshita <http://www.kinoshita.eti.br>
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
package hudson.plugins.testlink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import hudson.util.FormValidation;

/**
 * Tests the TestLinkBuilderDescriptor class.
 * 
 * @see {@link TestLinkBuilderDescriptor}
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 2.1
 */
public class TestTestLinkBuilderDescriptor 
{
    
    @Rule public JenkinsRule j = new JenkinsRule();

    @Test
	public void testLinkBuilderDescriptor()
	{
		TestLinkBuilderDescriptor descriptor = new TestLinkBuilderDescriptor();
		assertEquals( descriptor.getDisplayName(), "Invoke TestLink" );
		
		FormValidation formVal = descriptor.doCheckMandatory("Test");
		assertNotNull( formVal );
		
		formVal = descriptor.doCheckMandatory(null);
		assertNotNull( formVal );
		assertNotNull( formVal.getMessage() );
		
		assertNotNull( descriptor.getInstallations() );
		assertTrue( descriptor.getInstallations().length == 0 );
	}
	
}
