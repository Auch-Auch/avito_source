package a2.a.a.f1;

import io.reactivex.functions.Action;
import java.util.concurrent.atomic.AtomicBoolean;
public final class c implements Action {
    public final /* synthetic */ AtomicBoolean a;

    public c(AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.set(true);
    }
}
