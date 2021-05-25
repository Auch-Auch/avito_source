package a7.c.a.a.r.c;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.utils.permission.AppPermissionHepler;
import ru.sravni.android.bankproduct.utils.permission.IPermissionHelper;
import ru.sravni.android.bankproduct.utils.permission.PermissionSravniInfo;
public final class s extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, AppPermissionHepler> {
    public static final s a = new s();

    public s() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public AppPermissionHepler invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new AppPermissionHepler((IPermissionHelper) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPermissionHelper>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$3$$special$$inlined$instance$1
        }), null), (PermissionSravniInfo) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<PermissionSravniInfo>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$3$$special$$inlined$instance$2
        }), "appRequiredPermission"));
    }
}
