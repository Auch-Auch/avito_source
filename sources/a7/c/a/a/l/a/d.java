package a7.c.a.a.l.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dashboard.DashBoardInteractor;
import ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.util.IStartBundleRepository;
import ru.sravni.android.bankproduct.utils.product.IProductUtil;
public final class d extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, DashBoardInteractor> {
    public static final d a = new d();

    public d() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public DashBoardInteractor invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new DashBoardInteractor((IDashBoardRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IDashBoardRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$1
        }), null), (IStartBundleRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IStartBundleRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IProductUtil) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductUtil>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgSimpleBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$1$$special$$inlined$instance$6
        }), null).invoke("domain"));
    }
}
