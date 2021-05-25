package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public abstract class Verifier implements TestRule {

    public class a extends Statement {
        public final /* synthetic */ Statement a;

        public a(Statement statement) {
            this.a = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() throws Throwable {
            this.a.evaluate();
            Verifier.this.verify();
        }
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new a(statement);
    }

    public void verify() throws Throwable {
    }
}
