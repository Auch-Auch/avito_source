package ru.sravni.android.bankproduct.presentation.splash.viewmodel;

import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.splash.AfterSplashScreen;
import ru.sravni.android.bankproduct.domain.splash.ISplashInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenInteractor;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.product.ProductUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\u0013J?\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u001f¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/presentation/splash/viewmodel/SplashViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/splash/viewmodel/ISplashViewModel;", "Lru/sravni/android/bankproduct/domain/splash/ISplashInteractor;", "splashInteractor", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "tokenInteractor", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productDictionary", "", "init", "(Lru/sravni/android/bankproduct/domain/splash/ISplashInteractor;Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;)V", "onCleared", "()V", "", "error", "c", "(Ljava/lang/Throwable;Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "f", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "subscription", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SplashViewModel extends ViewModel implements ISplashViewModel {
    public Disposable c;
    public IErrorLogger d;
    public IThrowableWrapper e;
    public IProductNameDictionary f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AfterSplashScreen.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            AfterSplashScreen afterSplashScreen = AfterSplashScreen.DASHBOARD;
            iArr[1] = 1;
            AfterSplashScreen afterSplashScreen2 = AfterSplashScreen.AUTH;
            iArr[2] = 2;
        }
    }

    public static final class a<T> implements Consumer<AfterSplashScreen> {
        public final /* synthetic */ SplashViewModel a;
        public final /* synthetic */ INavigator b;
        public final /* synthetic */ IErrorLogger c;
        public final /* synthetic */ IThrowableWrapper d;

        public a(SplashViewModel splashViewModel, INavigator iNavigator, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
            this.a = splashViewModel;
            this.b = iNavigator;
            this.c = iErrorLogger;
            this.d = iThrowableWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AfterSplashScreen afterSplashScreen) {
            SplashViewModel.access$nextScreenCame(this.a, afterSplashScreen, this.b, this.c, this.d);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ SplashViewModel a;
        public final /* synthetic */ INavigator b;
        public final /* synthetic */ IErrorLogger c;
        public final /* synthetic */ IThrowableWrapper d;

        public b(SplashViewModel splashViewModel, INavigator iNavigator, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
            this.a = splashViewModel;
            this.b = iNavigator;
            this.c = iErrorLogger;
            this.d = iThrowableWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            SplashViewModel splashViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(th2, "it");
            splashViewModel.c(th2, this.b, this.c, this.d);
        }
    }

    public static final void access$nextScreenCame(SplashViewModel splashViewModel, AfterSplashScreen afterSplashScreen, INavigator iNavigator, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
        Objects.requireNonNull(splashViewModel);
        if (afterSplashScreen != null) {
            int ordinal = afterSplashScreen.ordinal();
            if (ordinal == 1) {
                IProductNameDictionary iProductNameDictionary = splashViewModel.f;
                if (iProductNameDictionary == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("productDictionary");
                }
                String chatName = ((ProductDictionaryInfoDomain) iProductNameDictionary.get(ProductUtilKt.getCREDIT_AVITO_CHAT_NAME())).getChatName();
                IProductNameDictionary iProductNameDictionary2 = splashViewModel.f;
                if (iProductNameDictionary2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("productDictionary");
                }
                INavigator.DefaultImpls.route$default(iNavigator, R.id.action_splashFragment_to_chatFragment, UtilFunctionsKt.toSravniJson(new ChatInfo(chatName, null, ((ProductDictionaryInfoDomain) iProductNameDictionary2.get(ProductUtilKt.getCREDIT_AVITO_CHAT_NAME())).getTitle(), null, null, false, 48, null)), null, 4, null);
                return;
            } else if (ordinal == 2) {
                INavigator.DefaultImpls.route$default(iNavigator, R.id.action_splashFragment_to_avitoPhoneFragment, null, null, 6, null);
                return;
            }
        }
        splashViewModel.c(new UnknownNextAfterScreenException(), iNavigator, iErrorLogger, iThrowableWrapper);
    }

    public final void c(Throwable th, INavigator iNavigator, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
        iErrorLogger.logError(MessagePriority.ERROR, iThrowableWrapper.wrap(th));
        INavigator.DefaultImpls.route$default(iNavigator, R.id.action_splashFragment_to_profilePhoneFragment2, null, null, 6, null);
    }

    @Override // ru.sravni.android.bankproduct.presentation.splash.viewmodel.ISplashViewModel
    public void init(@NotNull ISplashInteractor iSplashInteractor, @NotNull ITokenInteractor iTokenInteractor, @NotNull INavigator iNavigator, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IProductNameDictionary iProductNameDictionary) {
        Intrinsics.checkParameterIsNotNull(iSplashInteractor, "splashInteractor");
        Intrinsics.checkParameterIsNotNull(iTokenInteractor, "tokenInteractor");
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productDictionary");
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
        this.f = iProductNameDictionary;
        iTokenInteractor.restoreTokenData();
        Disposable subscribe = iSplashInteractor.getNextScreenShow().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new a(this, iNavigator, iErrorLogger, iThrowableWrapper), new b(this, iNavigator, iErrorLogger, iThrowableWrapper));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "splashInteractor.nextScr…rWrapper) }\n            )");
        this.c = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
        }
        disposable.dispose();
        super.onCleared();
    }
}
