package ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.login.ILoginAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.auth.IAuthInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import ru.sravni.android.bankproduct.utils.sms.ISmsChannel;
import ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b8\u00109J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/ProfileSmsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "i", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;", "f", "Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;", "smsTextReceiver", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "h", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "loginAnalytic", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "l", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "", g.a, "Ljava/lang/String;", "smsPrefixText", "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", "authInteractor", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "k", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "snackbarShower", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "c", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "j", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productDictionary", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;Ljava/lang/String;Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileSmsViewModelFactory implements ViewModelProvider.Factory {
    public final INavigator a;
    public final IAuthInteractor b;
    public final IKeyboardHider c;
    public final IErrorLogger d;
    public final IThrowableWrapper e;
    public final ISmsChannel f;
    public final String g;
    public final ILoginAnalytic h;
    public final IPreviousModuleInfo i;
    public final IProductNameDictionary j;
    public final IBottomSnackbarShower k;
    public final IResourceProvider l;

    public ProfileSmsViewModelFactory(@NotNull INavigator iNavigator, @NotNull IAuthInteractor iAuthInteractor, @NotNull IKeyboardHider iKeyboardHider, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ISmsChannel iSmsChannel, @NotNull String str, @NotNull ILoginAnalytic iLoginAnalytic, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IBottomSnackbarShower iBottomSnackbarShower, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iAuthInteractor, "authInteractor");
        Intrinsics.checkParameterIsNotNull(iKeyboardHider, "keyboardHider");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iSmsChannel, "smsTextReceiver");
        Intrinsics.checkParameterIsNotNull(str, "smsPrefixText");
        Intrinsics.checkParameterIsNotNull(iLoginAnalytic, "loginAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productDictionary");
        Intrinsics.checkParameterIsNotNull(iBottomSnackbarShower, "snackbarShower");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.a = iNavigator;
        this.b = iAuthInteractor;
        this.c = iKeyboardHider;
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
        this.f = iSmsChannel;
        this.g = str;
        this.h = iLoginAnalytic;
        this.i = iPreviousModuleInfo;
        this.j = iProductNameDictionary;
        this.k = iBottomSnackbarShower;
        this.l = iResourceProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new ProfileSmsViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }
}
