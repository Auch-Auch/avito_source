package a7.c.a.a.o.e.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.browser.IBrowserAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.NavigationViewModel;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.NavigationViewModelFactory;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
public final class c extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, NavigationViewModel> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public NavigationViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (NavigationViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new NavigationViewModelFactory((IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$3
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$4
        }), null).invoke("main"), (IPreviousModuleInfoController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfoController>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$5
        }), null), (IBrowserAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IBrowserAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$1$$special$$inlined$instance$6
        }), null))).get(NavigationViewModel.class);
    }
}
