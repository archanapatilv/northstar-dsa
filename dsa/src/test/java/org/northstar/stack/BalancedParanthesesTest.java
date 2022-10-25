package org.northstar.stack;

import org.junit.Assert;
import org.junit.Test;

public class BalancedParanthesesTest {

    @Test
    public void testBalancedString1() throws Exception {
        String a = "a{bc}";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString2() throws Exception {
        String a = "a(bc)";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString3() throws Exception {
        String a = "a[bc]";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString4() throws Exception {
        String a = "a{bc{d}[e(fg)]c}cd";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString5() throws Exception {
        String a = "[ab]{cd}(ef)";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString6() throws Exception {
        String a = "abcd[]abcd{}abcd()";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString7() throws Exception {
        String a = "[(){}kk()]";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testBalancedString8() throws Exception {
        String a = "(ab[sd(xt{tt})])";
        Assert.assertTrue(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString1() throws Exception {
        String a = "a{";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString2() throws Exception {
        String a = "a(";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString3() throws Exception {
        String a = "a[";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString4() throws Exception {
        String a = "a{{]]";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString5() throws Exception {
        String a = "a(bc}]";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }

    @Test
    public void testUnBalancedString6() throws Exception {
        String a = "a{}[[]";
        Assert.assertFalse(new BalancedParantheses().isBalancedExpression(a));
    }
}
