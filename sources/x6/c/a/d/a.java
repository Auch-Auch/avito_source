package x6.c.a.d;

import org.junit.Assume;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
public class a extends Statement {
    public final /* synthetic */ Assignments a;
    public final /* synthetic */ FrameworkMethod b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Theories.TheoryAnchor d;

    public a(Theories.TheoryAnchor theoryAnchor, Assignments assignments, FrameworkMethod frameworkMethod, Object obj) {
        this.d = theoryAnchor;
        this.a = assignments;
        this.b = frameworkMethod;
        this.c = obj;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        Object[] methodArguments = this.a.getMethodArguments();
        if (!Theories.TheoryAnchor.a(this.d)) {
            Assume.assumeNotNull(methodArguments);
        }
        this.b.invokeExplosively(this.c, methodArguments);
    }
}
