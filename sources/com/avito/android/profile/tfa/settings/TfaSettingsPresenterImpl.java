package com.avito.android.profile.tfa.settings;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.tfa.settings.TfaSettingsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\b\u00105\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b6\u00107J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenterImpl;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter;", "Lcom/avito/android/profile/tfa/settings/TfaSettingsView;", "view", "", "attachView", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsView;)V", "detachView", "()V", "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "resultCode", "onAuthResult", "(I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/tfa/settings/TfaSettingsPresenter$Router;", "", "d", "Ljava/lang/String;", "warning", "Lio/reactivex/rxjava3/disposables/Disposable;", "f", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingDisposable", "Lcom/avito/android/error_helper/ErrorHelper;", "i", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/tfa/settings/TfaSettingsView;", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "", "c", "Z", "isEnabled", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;", g.a, "Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;", "interactor", "state", "<init>", "(Lcom/avito/android/profile/tfa/settings/TfaSettingsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/util/Kundle;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class TfaSettingsPresenterImpl implements TfaSettingsPresenter {
    public TfaSettingsView a;
    public TfaSettingsPresenter.Router b;
    public boolean c;
    public String d;
    public final CompositeDisposable e;
    public Disposable f;
    public final TfaSettingsInteractor g;
    public final SchedulersFactory3 h;
    public final ErrorHelper i;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ TfaSettingsPresenterImpl a;

        public b(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
            this.a = tfaSettingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            TfaSettingsPresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ TfaSettingsPresenterImpl a;

        public c(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
            this.a = tfaSettingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            TfaSettingsPresenterImpl tfaSettingsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            TfaSettingsPresenterImpl.access$onSwitcherToggled(tfaSettingsPresenterImpl, bool2.booleanValue());
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ TfaSettingsPresenterImpl a;

        public d(TfaSettingsPresenterImpl tfaSettingsPresenterImpl) {
            this.a = tfaSettingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            TfaSettingsPresenter.Router router = this.a.b;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                router.followDeepLink(deepLink2);
            }
        }
    }

    @Inject
    public TfaSettingsPresenterImpl(@NotNull TfaSettingsInteractor tfaSettingsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(tfaSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        this.g = tfaSettingsInteractor;
        this.h = schedulersFactory3;
        this.i = errorHelper;
        this.c = kundle != null ? kundle.getBoolean(TfaSettingsActivity.EXTRA_IS_ENABLED, false) : false;
        this.d = kundle != null ? kundle.getString("warning") : null;
        this.e = new CompositeDisposable();
    }

    public static final void access$handleTypedError(TfaSettingsPresenterImpl tfaSettingsPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(tfaSettingsPresenterImpl);
        if (typedError instanceof ErrorResult.Unauthorized) {
            TfaSettingsPresenter.Router router = tfaSettingsPresenterImpl.b;
            if (router != null) {
                router.navigateToAuth();
            }
        } else if (typedError instanceof ErrorResult.Unauthenticated) {
            TfaSettingsPresenter.Router router2 = tfaSettingsPresenterImpl.b;
            if (router2 != null) {
                router2.navigateToAuth();
            }
        } else {
            TfaSettingsView tfaSettingsView = tfaSettingsPresenterImpl.a;
            if (tfaSettingsView != null) {
                tfaSettingsView.showSnackbar(tfaSettingsPresenterImpl.i.recycle(typedError));
            }
        }
    }

    public static final void access$onSwitcherToggled(TfaSettingsPresenterImpl tfaSettingsPresenterImpl, boolean z) {
        TfaSettingsPresenter.Router router = tfaSettingsPresenterImpl.b;
        if (router != null) {
            router.setOkResult();
        }
        Disposable disposable = tfaSettingsPresenterImpl.f;
        if (disposable != null) {
            disposable.dispose();
        }
        tfaSettingsPresenterImpl.f = tfaSettingsPresenterImpl.g.setTfaEnabled(z).observeOn(tfaSettingsPresenterImpl.h.mainThread()).doOnSubscribe(new a2.a.a.b2.i1.a.a(tfaSettingsPresenterImpl)).doAfterTerminate(new a2.a.a.b2.i1.a.b(tfaSettingsPresenterImpl)).subscribe(new a2.a.a.b2.i1.a.c(tfaSettingsPresenterImpl), new a2.a.a.b2.i1.a.d(tfaSettingsPresenterImpl, z));
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    public void attachRouter(@NotNull TfaSettingsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    public void attachView(@NotNull TfaSettingsView tfaSettingsView) {
        Intrinsics.checkNotNullParameter(tfaSettingsView, "view");
        this.a = tfaSettingsView;
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = tfaSettingsView.getNavigationClicks().subscribe(new b(this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks.su…n() }) { Logs.error(it) }");
        Disposables.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.e;
        Disposable subscribe2 = tfaSettingsView.getSwitcherChanges().subscribe(new c(this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.switcherChanges.sub…it) }) { Logs.error(it) }");
        Disposables.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.e;
        Disposable subscribe3 = tfaSettingsView.getLinkClicks().subscribe(new d(this), a.d);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.linkClicks.subscrib…it) }) { Logs.error(it) }");
        Disposables.plusAssign(compositeDisposable3, subscribe3);
        tfaSettingsView.showToggleChecked(this.c);
        tfaSettingsView.bindWarning(this.d);
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    public void detachView() {
        this.e.clear();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f = null;
        this.a = null;
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    public void onAuthResult(int i2) {
        TfaSettingsPresenter.Router router;
        if (i2 != -1 && (router = this.b) != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.profile.tfa.settings.TfaSettingsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean(TfaSettingsActivity.EXTRA_IS_ENABLED, Boolean.valueOf(this.c)).putString("warning", this.d);
    }
}
