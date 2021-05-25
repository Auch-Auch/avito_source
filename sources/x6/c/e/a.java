package x6.c.e;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
public class a implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ RunNotifier b;
    public final /* synthetic */ ParentRunner c;

    public a(ParentRunner parentRunner, Object obj, RunNotifier runNotifier) {
        this.c = parentRunner;
        this.a = obj;
        this.b = runNotifier;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.runChild(this.a, this.b);
    }
}
