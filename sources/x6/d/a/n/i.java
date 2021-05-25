package x6.d.a.n;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.Reference;
import org.kodein.di.bindings.Singleton;
public final class i extends Lambda implements Function0<Reference<? extends T>> {
    public final /* synthetic */ Singleton.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Singleton.b bVar) {
        super(0);
        this.a = bVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Singleton.access$get_refMaker$p(this.a.a).make(new h(this));
    }
}
