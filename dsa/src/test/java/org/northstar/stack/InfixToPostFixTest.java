package org.northstar.stack;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testEmptyExpression() throws Exception {
        assertEquals("", InfixToPostFix.infixToPostFix(""));
    }

    @Test
    public void testSingleOperand() throws Exception {
        assertEquals("a", InfixToPostFix.infixToPostFix("a"));
        assertEquals("1", InfixToPostFix.infixToPostFix("1"));
    }

    @Test
    public void testSingleOperator() throws Exception {
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("+"));
    }

    @Test
    public void testNestedParentheses() throws Exception {
        assertEquals("abc++", InfixToPostFix.infixToPostFix("(a+(b+c))"));
        assertEquals("abc++def+++", InfixToPostFix.infixToPostFix("((a+(b+c))+(d+(e+f)))"));
    }

    @Test
    public void testUnbalancedParentheses() {
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("(a+b"));
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("a+b)"));
    }

    @Test
    public void testConsecutiveOperators() throws Exception {
        assertEquals("ab+c+", InfixToPostFix.infixToPostFix("a+b+c"));
        assertEquals("abc*+", InfixToPostFix.infixToPostFix("a+b*c"));
        assertEquals("abc+*", InfixToPostFix.infixToPostFix("a*(b+c)"));
    }

    @Test
    public void testExpressionWithSpaces() throws Exception {
        assertEquals("ab+c+", InfixToPostFix.infixToPostFix("a + b + c"));
        assertEquals("abc*+", InfixToPostFix.infixToPostFix("a + b * c"));
    }

    @Test
    public void testExpressionWithMultiplePrecedence() throws Exception {
        assertEquals("abc*d/+", InfixToPostFix.infixToPostFix("a+b*c/d"));
        assertEquals("abcd*+e/+", InfixToPostFix.infixToPostFix("a+(b*c+d)/e"));
    }

    @Test
    public void testExpressionWithAllOperators() throws Exception {
        assertEquals("ab+c-d*", InfixToPostFix.infixToPostFix("(a+b-c)*d"));
        assertEquals("ab+cd-*", InfixToPostFix.infixToPostFix("(a+b)*(c-d)"));
    }

    @Test
    public void testExpressionWithInvalidCharacters() {
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("a@b+c"));
    }

    @Test
    public void testNullExpression() {
        assertThrows(NullPointerException.class, () -> InfixToPostFix.infixToPostFix(null));
    }

    @Test
    public void testExpressionWithOnlyParentheses() {
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("()"));
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("(())"));
    }

    @Test
    public void testExpressionWithNumbers() throws Exception {
        assertEquals("12+", InfixToPostFix.infixToPostFix("1+2"));
        assertEquals("123*+", InfixToPostFix.infixToPostFix("1+2*3"));
    }

    @Test
    public void testExpressionWithMixedAlphanumeric() throws Exception {
        assertEquals("a1+", InfixToPostFix.infixToPostFix("a+1"));
        assertEquals("1a+", InfixToPostFix.infixToPostFix("1+a"));
    }

    @Test
    public void testExpressionWithMultipleSameOperators() throws Exception {
        assertEquals("ab+c+d+", InfixToPostFix.infixToPostFix("a+b+c+d"));
        assertEquals("ab*c*d*", InfixToPostFix.infixToPostFix("a*b*c*d"));
    }

    @Test
    public void testExpressionWithComplexNestedOperators() throws Exception {
        assertEquals("ab+c*d+", InfixToPostFix.infixToPostFix("(a+b)*c+d"));
        assertEquals("abc+*d+", InfixToPostFix.infixToPostFix("a*(b+c)+d"));
    }

    @Test
    public void testExpressionWithLeadingTrailingSpaces() throws Exception {
        assertEquals("ab+", InfixToPostFix.infixToPostFix(" a + b "));
        assertEquals("abc*+", InfixToPostFix.infixToPostFix("  a + b * c  "));
    }

    @Test
    public void testExpressionWithMultipleSpacesBetweenOperators() throws Exception {
        assertEquals("ab+c+", InfixToPostFix.infixToPostFix("a +   b   +   c"));
        assertEquals("abc*+", InfixToPostFix.infixToPostFix("a   +   b   *   c"));
    }

    @Test
    public void testExpressionWithSpecialCharacters() {
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("a+b#c"));
        assertThrows(Exception.class, () -> InfixToPostFix.infixToPostFix("a+b$c"));
    }

    @Test
    public void testExpressionWithUnicodeCharacters() throws Exception {
        assertEquals("αβ+", InfixToPostFix.infixToPostFix("α+β"));
        assertEquals("αβγ*+", InfixToPostFix.infixToPostFix("α+β*γ"));
    }
}
