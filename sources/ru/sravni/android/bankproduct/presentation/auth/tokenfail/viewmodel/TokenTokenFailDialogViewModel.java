package ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.token.ITokenInteractor;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower;
import ru.sravni.android.bankproduct.utils.snackbar.SnackbarData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/tokenfail/viewmodel/TokenTokenFailDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/auth/tokenfail/viewmodel/ITokenTokenFailDialogViewModel;", "", "clickButtonOk", "()V", "onCleared", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "subscription", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "getShowRefreshTokenDialogSignal", "()Landroidx/lifecycle/MutableLiveData;", "showRefreshTokenDialogSignal", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "e", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", g.a, "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "snackbarShower", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "f", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "tokenInteractor", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "h", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenTokenFailDialogViewModel extends ViewModel implements ITokenTokenFailDialogViewModel {
    @NotNull
    public final MutableLiveData<Boolean> c = new MutableLiveData<>();
    public final Disposable d;
    public final INavigator e;
    public final ITokenInteractor f;
    public final IBottomSnackbarShower g;
    public final IResourceProvider h;

    public static final class a<T> implements Consumer<HttpResponseStatus> {
        public final /* synthetic */ TokenTokenFailDialogViewModel a;

        public a(TokenTokenFailDialogViewModel tokenTokenFailDialogViewModel) {
            this.a = tokenTokenFailDialogViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(HttpResponseStatus httpResponseStatus) {
            HttpResponseStatus httpResponseStatus2 = httpResponseStatus;
            if (httpResponseStatus2 != HttpResponseStatus.SUCCESS) {
                HttpResponseStatus.Companion companion = HttpResponseStatus.Companion;
                if (companion.getUnauthorizedSet().contains(httpResponseStatus2)) {
                    this.a.f.clearToken();
                    this.a.getShowRefreshTokenDialogSignal().postValue(Boolean.TRUE);
                } else if (companion.getUnavailableSet().contains(httpResponseStatus2)) {
                    this.a.g.showBottomSnackbar(new SnackbarData(0, this.a.h.getString(R.string.snackbar_service_temporarily_unavailable)));
                }
            }
        }
    }

    public TokenTokenFailDialogViewModel(@NotNull INavigator iNavigator, @NotNull ITokenInteractor iTokenInteractor, @NotNull IBottomSnackbarShower iBottomSnackbarShower, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iTokenInteractor, "tokenInteractor");
        Intrinsics.checkParameterIsNotNull(iBottomSnackbarShower, "snackbarShower");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.e = iNavigator;
        this.f = iTokenInteractor;
        this.g = iBottomSnackbarShower;
        this.h = iResourceProvider;
        Disposable subscribe = iTokenInteractor.getTokenStatusChannel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "tokenInteractor.tokenSta…          }\n            }");
        this.d = subscribe;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel.ITokenTokenFailDialogViewModel
    public void clickButtonOk() {
        this.f.clearToken();
        this.e.exitFromProfile();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.dispose();
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel.ITokenRefreshDialogSignal
    @NotNull
    public MutableLiveData<Boolean> getShowRefreshTokenDialogSignal() {
        return this.c;
    }
}
