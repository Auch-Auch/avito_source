package x6.d.a.n;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.BindingKodein;
import org.kodein.di.bindings.EagerSingleton;
import org.kodein.di.bindings.NoArgBindingKodeinWrap;
public final class c extends Lambda implements Function1<Unit, T> {
    public final /* synthetic */ EagerSingleton a;
    public final /* synthetic */ BindingKodein b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(EagerSingleton eagerSingleton, BindingKodein bindingKodein) {
        super(1);
        this.a = eagerSingleton;
        this.b = bindingKodein;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Unit unit) {
        Object access$get_instance$p;
        Intrinsics.checkParameterIsNotNull(unit, "<anonymous parameter 0>");
        Object access$get_lock$p = EagerSingleton.access$get_lock$p(this.a);
        EagerSingleton eagerSingleton = this.a;
        Object access$get_instance$p2 = EagerSingleton.access$get_instance$p(eagerSingleton);
        if (access$get_instance$p2 != null) {
            return access$get_instance$p2;
        }
        if (access$get_lock$p == null) {
            Object access$get_instance$p3 = EagerSingleton.access$get_instance$p(eagerSingleton);
            if (access$get_instance$p3 != null) {
                return access$get_instance$p3;
            }
            Object invoke = this.a.getCreator().invoke(new NoArgBindingKodeinWrap(this.b));
            EagerSingleton.access$set_instance$p(this.a, invoke);
            return invoke;
        }
        synchronized (access$get_lock$p) {
            access$get_instance$p = EagerSingleton.access$get_instance$p(eagerSingleton);
            if (access$get_instance$p == null) {
                access$get_instance$p = this.a.getCreator().invoke(new NoArgBindingKodeinWrap(this.b));
                EagerSingleton.access$set_instance$p(this.a, access$get_instance$p);
            }
        }
        return access$get_instance$p;
    }
}
