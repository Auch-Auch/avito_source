package org.junit.rules;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class ExpectedException implements TestRule {
    public final x6.c.c.a a = new x6.c.c.a();
    public String b = "Expected test to throw %s";

    public class a extends Statement {
        public final Statement a;

        public a(Statement statement) {
            this.a = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            try {
                this.a.evaluate();
                if (ExpectedException.this.isAnyExceptionExpected()) {
                    ExpectedException expectedException = ExpectedException.this;
                    Assert.fail(String.format(expectedException.b, StringDescription.toString(expectedException.a.a())));
                }
            } catch (Throwable th) {
                ExpectedException expectedException2 = ExpectedException.this;
                if (expectedException2.isAnyExceptionExpected()) {
                    Assert.assertThat(th, expectedException2.a.a());
                    return;
                }
                throw th;
            }
        }
    }

    @Deprecated
    public static ExpectedException none() {
        return new ExpectedException();
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new a(statement);
    }

    public void expect(Matcher<?> matcher) {
        this.a.a.add(matcher);
    }

    public void expectCause(Matcher<?> matcher) {
        expect(ThrowableCauseMatcher.hasCause(matcher));
    }

    public void expectMessage(String str) {
        expectMessage(CoreMatchers.containsString(str));
    }

    @Deprecated
    public ExpectedException handleAssertionErrors() {
        return this;
    }

    @Deprecated
    public ExpectedException handleAssumptionViolatedExceptions() {
        return this;
    }

    public final boolean isAnyExceptionExpected() {
        return !this.a.a.isEmpty();
    }

    public ExpectedException reportMissingExceptionWithMessage(String str) {
        this.b = str;
        return this;
    }

    public void expectMessage(Matcher<String> matcher) {
        expect(ThrowableMessageMatcher.hasMessage(matcher));
    }

    public void expect(Class<? extends Throwable> cls) {
        expect(CoreMatchers.instanceOf(cls));
    }
}
