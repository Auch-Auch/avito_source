package ru.sravni.android.bankproduct.presentation.splash.viewmodel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.splash.ISplashInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenInteractor;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/presentation/splash/viewmodel/ISplashViewModel;", "", "Lru/sravni/android/bankproduct/domain/splash/ISplashInteractor;", "splashInteractor", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "tokenInteractor", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productDictionary", "", "init", "(Lru/sravni/android/bankproduct/domain/splash/ISplashInteractor;Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISplashViewModel {
    void init(@NotNull ISplashInteractor iSplashInteractor, @NotNull ITokenInteractor iTokenInteractor, @NotNull INavigator iNavigator, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IProductNameDictionary iProductNameDictionary);
}
