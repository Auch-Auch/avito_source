package a2.a.a.n3;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
public final class j implements Callable {
    public final /* synthetic */ Function0 a;

    public j(Function0 function0) {
        this.a = function0;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.invoke();
    }
}
