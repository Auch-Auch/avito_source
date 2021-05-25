package x6.c.c;

import java.util.ArrayList;
import org.junit.rules.ExternalResource;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
public class b extends Statement {
    public final /* synthetic */ Statement a;
    public final /* synthetic */ ExternalResource b;

    public b(ExternalResource externalResource, Statement statement) {
        this.b = externalResource;
        this.a = statement;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        this.b.before();
        ArrayList arrayList = new ArrayList();
        try {
            this.a.evaluate();
            try {
                this.b.after();
            } catch (Throwable th) {
                arrayList.add(th);
            }
        } catch (Throwable th2) {
            try {
                this.b.after();
            } catch (Throwable th3) {
                arrayList.add(th3);
            }
            throw th2;
        }
        MultipleFailureException.assertEmpty(arrayList);
    }
}
