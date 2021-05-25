package a7.c.a.a.o.b.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.main.IMainAnalytic;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.BottomNavigationViewModel;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.BottomNavigationViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, BottomNavigationViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public BottomNavigationViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (BottomNavigationViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt$presentationBottomNavigationKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new BottomNavigationViewModelFactory((IMainAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IMainAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt$presentationBottomNavigationKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt$presentationBottomNavigationKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IFeatureToggleRouterDomain) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IFeatureToggleRouterDomain>() { // from class: ru.sravni.android.bankproduct.presentation.bottomnavigation.di.PresentationBottomNavigationProviderKt$presentationBottomNavigationKodeinModule$1$1$$special$$inlined$instance$4
        }), null))).get(BottomNavigationViewModel.class);
    }
}
