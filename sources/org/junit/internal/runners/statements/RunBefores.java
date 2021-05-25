package org.junit.internal.runners.statements;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
public class RunBefores extends Statement {
    public final Statement a;
    public final Object b;
    public final List<FrameworkMethod> c;

    public RunBefores(Statement statement, List<FrameworkMethod> list, Object obj) {
        this.a = statement;
        this.c = list;
        this.b = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        for (FrameworkMethod frameworkMethod : this.c) {
            invokeMethod(frameworkMethod);
        }
        this.a.evaluate();
    }

    public void invokeMethod(FrameworkMethod frameworkMethod) throws Throwable {
        frameworkMethod.invokeExplosively(this.b, new Object[0]);
    }
}
