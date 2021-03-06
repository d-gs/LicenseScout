/**
 * Copyright 2019 Association for the promotion of open-source insurance software and for the establishment of open interface standards in the insurance industry (Verein zur Förderung quelloffener Versicherungssoftware und Etablierung offener Schnittstellenstandards in der Versicherungsbranche)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aposin.licensescout.archive;

import org.aposin.licensescout.model.LSMessageDigest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link ArchiveIdentifierMessageDigest}.
 */
public class ArchiveIdentifierMessageDigestTest {

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#getMessageDigest()}.
     */
    @Test
    public void testConstructor2AndGetMessageDigest() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc", "05");
        Assert.assertEquals("getMessage()", new LSMessageDigest(new byte[] { 5 }), ai1.getMessageDigest());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#toString()}.
     */
    @Test
    public void testToString() {
        final ArchiveIdentifierMessageDigest ai = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertNotNull("toString()", ai.toString());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#hashCode()}.
     */
    @Test
    public void testHashCodeSame() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertEquals("hashCode()", ai1.hashCode(), ai2.hashCode());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#hashCode()}.
     */
    @Test
    public void testHashCodeDifferentArchiveType() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVASCRIPT, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertNotEquals("hashCode()", ai1.hashCode(), ai2.hashCode());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#hashCode()}.
     */
    @Test
    public void testHashCodeDifferentName() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "def",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertNotEquals("hashCode()", ai1.hashCode(), ai2.hashCode());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#hashCode()}.
     */
    @Test
    public void testHashCodeDifferentMessageDigest() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 2 }));
        Assert.assertNotEquals("hashCode()", ai1.hashCode(), ai2.hashCode());
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsSame() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = ai1;
        Assert.assertTrue("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsIdentical() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertTrue("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsNull() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = null;
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsObject() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final Object ai2 = new Object();
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsArchiveIdentifier() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifier ai2 = new ArchiveIdentifier(ArchiveType.JAVA, NameMatchingType.PATTERN, "abc") {
            // EMPTY
        };
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsDifferentArchiveType() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVASCRIPT, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsDifferentName() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "def",
                new LSMessageDigest(new byte[] { 1 }));
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsDifferentMessageDigest() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 2 }));
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

    /**
     * Test method for {@link ArchiveIdentifierMessageDigest#equals(Object)}.
     */
    @Test
    public void testEqualsDifferentNameAndMessageDigest() {
        final ArchiveIdentifierMessageDigest ai1 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "abc",
                new LSMessageDigest(new byte[] { 1 }));
        final ArchiveIdentifierMessageDigest ai2 = new ArchiveIdentifierMessageDigest(ArchiveType.JAVA, "def",
                new LSMessageDigest(new byte[] { 2 }));
        Assert.assertFalse("equals()", ai1.equals(ai2));
    }

}
