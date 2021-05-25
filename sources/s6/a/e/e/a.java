package s6.a.e.e;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
public final class a implements Callable {
    public final /* synthetic */ Function0 a;

    public a(Function0 function0) {
        this.a = function0;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.a.invoke();
    }
}
