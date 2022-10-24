package org.northstar.stack;

import org.junit.Assert;
import org.junit.Test;

public class InfixToPostFixTest {

    @Test
    public void testExpression1() throws Exception {
        String testExpression = "a+b";
        Assert.assertEquals("ab+", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression2() throws Exception {
        String testExpression = "a-b";
        Assert.assertEquals("ab-", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression3() throws Exception {
        String testExpression = "a/b";
        Assert.assertEquals("ab/", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression4() throws Exception {
        String testExpression = "a*b";
        Assert.assertEquals("ab*", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression5() throws Exception {
        String testExpression = "a+b-c";
        Assert.assertEquals("ab+c-", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression6() throws Exception {
        String testExpression = "a/b-c";
        Assert.assertEquals("ab/c-", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression7() throws Exception {
        String testExpression = "a+b/c";
        Assert.assertEquals("abc/+", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression8() throws Exception {
        String testExpression = "A/B-C+D*E-A*C";
        Assert.assertEquals("AB/C-DE*+AC*-", InfixToPostFix.infixToPostFix(testExpression));
    }
    @Test
    public void testExpression9() throws Exception {
        String testExpression = "a/b/c";
        Assert.assertEquals("ab/c/", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression10() throws Exception {
        String testExpression = "x+y/(p+q)+n";
        Assert.assertEquals("xypq+/+n+", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression11() throws Exception {
        String testExpression = "a+b*c+x/y";
        Assert.assertEquals("abc*+xy/+", InfixToPostFix.infixToPostFix(testExpression));
    }

    @Test
    public void testExpression12() throws Exception {
        String testExpression = "((a+b-c)+d/e)";
        Assert.assertEquals("ab+c-de/+", InfixToPostFix.infixToPostFix(testExpression));
    }
}
