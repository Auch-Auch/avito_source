package x6.c.a.c;

import java.util.List;
import org.junit.experimental.max.MaxCore;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
public class a extends Request {
    public final /* synthetic */ List a;

    /* renamed from: x6.c.a.c.a$a  reason: collision with other inner class name */
    public class C0693a extends Suite {
        public C0693a(a aVar, Class cls, List list) {
            super((Class<?>) null, list);
        }
    }

    public a(MaxCore maxCore, List list) {
        this.a = list;
    }

    @Override // org.junit.runner.Request
    public Runner getRunner() {
        try {
            return new C0693a(this, null, this.a);
        } catch (InitializationError e) {
            return new ErrorReportingRunner((Class<?>) null, e);
        }
    }
}
