package a7.c.a.a.o.g.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.splash.ISplashInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenInteractor;
import ru.sravni.android.bankproduct.presentation.splash.viewmodel.SplashViewModel;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, SplashViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public SplashViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        SplashViewModel splashViewModel = (SplashViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).get(SplashViewModel.class);
        splashViewModel.init((ISplashInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISplashInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$2
        }), null), (ITokenInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$4
        }), "MainNavigator"), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$5
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$6
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$7
        }), null).invoke("splash"), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.splash.di.PresentationSplashProviderKt$presentationSplashKodeinModule$1$1$$special$$inlined$instance$8
        }), null));
        return splashViewModel;
    }
}
