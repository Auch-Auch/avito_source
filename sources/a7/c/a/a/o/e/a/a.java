package a7.c.a.a.o.e.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.main.MainNavigationController;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, MainNavigationController> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public MainNavigationController invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return new MainNavigationController((AppCompatActivity) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AppCompatActivity>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$1
        }), null), (INavigationViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigationViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$2
        }), null), (IKeyboardHider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardHider>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$6
        }), null).invoke("main"), (NavController) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<NavController>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$10$$special$$inlined$instance$7
        }), null));
    }
}
