package a7.c.a.a.r.d.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, IAnalyticEventLogger> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public IAnalyticEventLogger invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein, "$receiver");
        return LibKodeinProviderKt.b;
    }
}
