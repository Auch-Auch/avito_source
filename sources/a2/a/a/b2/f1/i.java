package a2.a.a.b2.f1;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class i<T> implements Consumer<Unit> {
    public final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        k kVar = this.a;
        kVar.a.a(kVar.b);
    }
}
