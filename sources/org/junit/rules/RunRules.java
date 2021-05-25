package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class RunRules extends Statement {
    public final Statement a;

    public RunRules(Statement statement, Iterable<TestRule> iterable, Description description) {
        for (TestRule testRule : iterable) {
            statement = testRule.apply(statement, description);
        }
        this.a = statement;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        this.a.evaluate();
    }
}
