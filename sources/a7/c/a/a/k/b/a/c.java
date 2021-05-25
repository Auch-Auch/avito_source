package a7.c.a.a.k.b.a;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.di.buildlevel.debug.DebugLogger;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
public final class c extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, List<? extends IErrorLogger>> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public List<? extends IErrorLogger> invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new IErrorLogger[]{(IErrorLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<DebugLogger>() { // from class: ru.sravni.android.bankproduct.di.buildlevel.debug.BuildProviderKt$debugBuildTypeKodeinModule$1$3$$special$$inlined$instance$1
        }), null), (IErrorLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.di.buildlevel.debug.BuildProviderKt$debugBuildTypeKodeinModule$1$3$$special$$inlined$instance$2
        }), "externalErrorLogger")});
    }
}
