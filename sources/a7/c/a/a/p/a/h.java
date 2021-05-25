package a7.c.a.a.p.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.featuretoggle.config.ToggleConfigMapKt;
import ru.sravni.android.bankproduct.repository.featuretoggle.FeatureToggleRouterRepository;
public final class h extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, FeatureToggleRouterRepository> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public FeatureToggleRouterRepository invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein, "$receiver");
        return new FeatureToggleRouterRepository(ToggleConfigMapKt.getFeatureToggleConfigMap());
    }
}
