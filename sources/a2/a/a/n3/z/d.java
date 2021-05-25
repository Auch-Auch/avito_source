package a2.a.a.n3.z;

import io.reactivex.rxjava3.functions.Supplier;
import kotlin.jvm.functions.Function0;
public final class d implements Supplier {
    public final /* synthetic */ Function0 a;

    public d(Function0 function0) {
        this.a = function0;
    }

    @Override // io.reactivex.rxjava3.functions.Supplier
    public final /* synthetic */ Object get() {
        return this.a.invoke();
    }
}
