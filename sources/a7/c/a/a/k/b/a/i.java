package a7.c.a.a.k.b.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.utils.lifecycles.IActivityLifecycleListenerContainer;
public final class i extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, IActivityLifecycleListenerContainer> {
    public static final i a = new i();

    public i() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public IActivityLifecycleListenerContainer invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return (IActivityLifecycleListenerContainer) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IActivityLifecycleListenerContainer>() { // from class: ru.sravni.android.bankproduct.di.buildlevel.debug.BuildProviderKt$debugBuildTypeKodeinModule$1$9$$special$$inlined$instance$1
        }), null);
    }
}
