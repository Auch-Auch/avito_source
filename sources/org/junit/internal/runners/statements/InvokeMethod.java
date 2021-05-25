package org.junit.internal.runners.statements;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
public class InvokeMethod extends Statement {
    public final FrameworkMethod a;
    public final Object b;

    public InvokeMethod(FrameworkMethod frameworkMethod, Object obj) {
        this.a = frameworkMethod;
        this.b = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        this.a.invokeExplosively(this.b, new Object[0]);
    }
}
