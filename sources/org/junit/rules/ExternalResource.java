package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import x6.c.c.b;
public abstract class ExternalResource implements TestRule {
    public void after() {
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new b(this, statement);
    }

    public void before() throws Throwable {
    }
}
