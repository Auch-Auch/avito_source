package x6.c.d.a;

import java.util.List;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
public class a extends RunNotifier.a {
    public final /* synthetic */ List c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(RunNotifier runNotifier, List list, List list2) {
        super(list);
        this.c = list2;
    }

    @Override // org.junit.runner.notification.RunNotifier.a
    public void a(RunListener runListener) throws Exception {
        for (Failure failure : this.c) {
            runListener.testFailure(failure);
        }
    }
}
