package x6.d.a.n;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.NoArgBindingKodeinWrap;
public final class h extends Lambda implements Function0<T> {
    public final /* synthetic */ i a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(i iVar) {
        super(0);
        this.a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        Function1 creator = this.a.a.a.getCreator();
        BindingKodein bindingKodein = this.a.a.c;
        return (T) creator.invoke(new NoArgBindingKodeinWrap(new b(bindingKodein, bindingKodein.getContext())));
    }
}
