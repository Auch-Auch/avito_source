package a2.a.a.z.a.g.q;

import java.util.concurrent.Callable;
import kotlin.Unit;
public final class c<V> implements Callable<Object> {
    public final /* synthetic */ String a;
    public final /* synthetic */ d b;

    public c(String str, d dVar) {
        this.a = str;
        this.b = dVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.b.a.b.loginWithOneTimeKey(this.b.b, this.a);
        return Unit.INSTANCE;
    }
}
