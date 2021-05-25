package a7.c.a.a.o.a.b.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.analytic.v2.login.ILoginAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.auth.IAuthInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import ru.sravni.android.bankproduct.utils.sms.ISmsChannel;
import ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ProfileSmsViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ProfileSmsViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (ProfileSmsViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new ProfileSmsViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$2
        }), "MainNavigator"), (IAuthInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IKeyboardHider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardHider>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$5
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$6
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$7
        }), null).invoke("profile_sms"), (ISmsChannel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ISmsChannel>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (String) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$9
        }), "smsPrefix"), (ILoginAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ILoginAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$10
        }), null), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$11
        }), null), (IProductNameDictionary) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProductNameDictionary>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$12
        }), null), (IBottomSnackbarShower) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IBottomSnackbarShower>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$13
        }), null), (IResourceProvider) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IResourceProvider>() { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.di.PresentationProfileSmsProviderKt$presentationProfileSmsKodeinModule$1$1$$special$$inlined$instance$14
        }), null))).get(ProfileSmsViewModel.class);
    }
}
