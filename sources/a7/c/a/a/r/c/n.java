package a7.c.a.a.r.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
public final class n extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, IPreviousModuleInfoController> {
    public static final n a = new n();

    public n() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public IPreviousModuleInfoController invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$22$$special$$inlined$instance$1
        }), null);
    }
}
