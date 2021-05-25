package a7.c.a.a.o.a.a.a;

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
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.ProfilePhoneViewModel;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.ProfilePhoneViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ProfilePhoneViewModel> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ProfilePhoneViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (ProfilePhoneViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$1
        }), null), new ProfilePhoneViewModelFactory((INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$2
        }), "MainNavigator"), (IAuthInteractor) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IAuthInteractor>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$3
        }), null), (IErrorLogger) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$4
        }), null), (IThrowableWrapper) noArgBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$5
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$6
        }), null).invoke("profile_phone"), (IPreviousModuleInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IPreviousModuleInfo>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$7
        }), null), (ILoginAnalytic) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ILoginAnalytic>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$8
        }), null), (String) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.presentation.auth.phone.di.PresentationProfilePhoneProviderKt$presentationProfilePhoneKodeinModule$1$1$$special$$inlined$instance$9
        }), "avitoDefaultSettedPhone"))).get(ProfilePhoneViewModel.class);
    }
}
