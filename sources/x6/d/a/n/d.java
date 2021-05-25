package x6.d.a.n;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.Multiton;
public final class d extends Lambda implements Function0<T> {
    public final /* synthetic */ Multiton.b.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Multiton.b.a aVar) {
        super(0);
        this.a = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        Function2 access$getCreator$p = Multiton.access$getCreator$p(this.a.a.a);
        BindingKodein bindingKodein = this.a.a.c;
        return (T) access$getCreator$p.invoke(new b(bindingKodein, bindingKodein.getContext()), this.a.b);
    }
}
