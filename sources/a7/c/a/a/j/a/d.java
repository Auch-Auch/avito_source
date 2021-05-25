package a7.c.a.a.j.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.login.LoginAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
public final class d extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, LoginAnalytic> {
    public static final d a = new d();

    public d() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public LoginAnalytic invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new LoginAnalytic((IAnalyticEventLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAnalyticEventLogger>() { // from class: ru.sravni.android.bankproduct.analytic.di.AnalyticProviderKt$analyticKodeinModuleV2$1$4$$special$$inlined$instance$1
        }), null));
    }
}
