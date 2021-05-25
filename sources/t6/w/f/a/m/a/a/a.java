package t6.w.f.a.m.a.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
public final class a extends Lambda implements Function0<JvmBuiltIns.Settings> {
    public final /* synthetic */ JvmBuiltIns a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(JvmBuiltIns jvmBuiltIns) {
        super(0);
        this.a = jvmBuiltIns;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public JvmBuiltIns.Settings invoke() {
        Function0 access$getSettingsComputation$p = JvmBuiltIns.access$getSettingsComputation$p(this.a);
        if (access$getSettingsComputation$p != null) {
            JvmBuiltIns.Settings settings = (JvmBuiltIns.Settings) access$getSettingsComputation$p.invoke();
            JvmBuiltIns.access$setSettingsComputation$p(this.a, null);
            return settings;
        }
        throw new AssertionError("JvmBuiltins instance has not been initialized properly");
    }
}
