package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;
public class Fail extends Statement {
    public final Throwable a;

    public Fail(Throwable th) {
        this.a = th;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        throw this.a;
    }
}
