package com.avito.android.authorization.reset_password;

import a2.a.a.b.h.d;
import a2.a.a.b.h.e;
import a2.a.a.b.h.f;
import a2.a.a.b.h.h;
import a2.g.r.g;
import com.avito.android.authorization.reset_password.ResetPasswordPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ResetPasswordResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b0\u00101J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordPresenterImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter;", "", "startLogin", "", "setStartLogin", "(Ljava/lang/String;)V", "Lcom/avito/android/authorization/reset_password/ResetPasswordView;", "view", "attachView", "(Lcom/avito/android/authorization/reset_password/ResetPasswordView;)V", "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "messages", AuthSource.SEND_ABUSE, "(Ljava/util/Map;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/reset_password/ResetPasswordPresenter$Router;", "e", "Ljava/lang/String;", "login", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "f", "Ljava/util/Map;", "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", g.a, "Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "interactor", "c", "disposables", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/authorization/reset_password/ResetPasswordView;", "state", "<init>", "(Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ResetPasswordPresenterImpl implements ResetPasswordPresenter {
    public ResetPasswordView a;
    public ResetPasswordPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public Map<String, String> f;
    public final ResetPasswordInteractor g;
    public final SchedulersFactory h;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ResetPasswordPresenterImpl.access$onCloseScreen((ResetPasswordPresenterImpl) this.b);
            } else if (i == 1) {
                ResetPasswordPresenterImpl.access$onResetPassword((ResetPasswordPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ ResetPasswordPresenterImpl a;

        public b(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
            this.a = resetPasswordPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            ResetPasswordPresenterImpl resetPasswordPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            resetPasswordPresenterImpl.e = str2;
            ResetPasswordPresenterImpl.access$checkResetPasswordButtonState(this.a);
        }
    }

    @Inject
    public ResetPasswordPresenterImpl(@NotNull ResetPasswordInteractor resetPasswordInteractor, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(resetPasswordInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.g = resetPasswordInteractor;
        this.h = schedulersFactory;
        String string = kundle != null ? kundle.getString("login") : null;
        this.e = string == null ? "" : string;
        this.f = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$checkResetPasswordButtonState(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        ResetPasswordView resetPasswordView = resetPasswordPresenterImpl.a;
        if (resetPasswordView != null) {
            resetPasswordView.setResetPasswordButtonEnabled(!m.isBlank(resetPasswordPresenterImpl.e));
        }
    }

    public static final void access$clearFieldErrors(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        Objects.requireNonNull(resetPasswordPresenterImpl);
        resetPasswordPresenterImpl.f = r.emptyMap();
    }

    public static final void access$handleResetPasswordCompleted(ResetPasswordPresenterImpl resetPasswordPresenterImpl, ResetPasswordResult resetPasswordResult) {
        ResetPasswordView resetPasswordView;
        Objects.requireNonNull(resetPasswordPresenterImpl);
        if (resetPasswordResult instanceof ResetPasswordResult.ViaCode) {
            ResetPasswordPresenter.Router router = resetPasswordPresenterImpl.b;
            if (router != null) {
                ResetPasswordResult.ViaCode viaCode = (ResetPasswordResult.ViaCode) resetPasswordResult;
                router.openCodeConfirmation(resetPasswordPresenterImpl.e, viaCode.getText(), viaCode.getCodeTimeout(), viaCode.getCodeLength());
            }
        } else if ((resetPasswordResult instanceof ResetPasswordResult.ViaLink) && (resetPasswordView = resetPasswordPresenterImpl.a) != null) {
            resetPasswordView.showUserDialog(((ResetPasswordResult.ViaLink) resetPasswordResult).getText(), new d(resetPasswordPresenterImpl));
        }
    }

    public static final void access$handleResetPasswordError(ResetPasswordPresenterImpl resetPasswordPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(resetPasswordPresenterImpl);
        if (typedError instanceof TypedError.ErrorMap) {
            resetPasswordPresenterImpl.a(((TypedError.ErrorMap) typedError).getMessages());
        } else if (typedError instanceof ErrorWithMessage.SimpleMessageError) {
            ResetPasswordView resetPasswordView = resetPasswordPresenterImpl.a;
            if (resetPasswordView != null) {
                resetPasswordView.showError(((ErrorWithMessage.SimpleMessageError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage.NetworkError) {
            ResetPasswordView resetPasswordView2 = resetPasswordPresenterImpl.a;
            if (resetPasswordView2 != null) {
                resetPasswordView2.showError(((ErrorWithMessage.NetworkError) typedError).getMessage());
            }
        } else {
            ResetPasswordView resetPasswordView3 = resetPasswordPresenterImpl.a;
            if (resetPasswordView3 != null) {
                resetPasswordView3.showUnknownError();
            }
        }
    }

    public static final void access$handleResetPasswordStarted(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        ResetPasswordView resetPasswordView = resetPasswordPresenterImpl.a;
        if (resetPasswordView != null) {
            resetPasswordView.hideKeyboard();
            resetPasswordView.showProgress();
            resetPasswordView.hideLoginError();
        }
    }

    public static final void access$onCloseScreen(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        ResetPasswordPresenter.Router router = resetPasswordPresenterImpl.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    public static final void access$onPhoneConfirmed(ResetPasswordPresenterImpl resetPasswordPresenterImpl, String str, String str2) {
        ResetPasswordPresenter.Router router = resetPasswordPresenterImpl.b;
        if (router != null) {
            router.openChangePassword(str, str2);
        }
    }

    public static final void access$onResetPassword(ResetPasswordPresenterImpl resetPasswordPresenterImpl) {
        CompositeDisposable compositeDisposable = resetPasswordPresenterImpl.c;
        Disposable subscribe = resetPasswordPresenterImpl.g.resetPassword(resetPasswordPresenterImpl.e).observeOn(resetPasswordPresenterImpl.h.mainThread()).doOnSubscribe(new e(resetPasswordPresenterImpl)).doAfterTerminate(new f(resetPasswordPresenterImpl)).subscribe(new a2.a.a.b.h.g(resetPasswordPresenterImpl), new h(resetPasswordPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.resetPassword…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void a(Map<String, String> map) {
        ResetPasswordView resetPasswordView;
        this.f = map;
        if ((!map.isEmpty()) && (resetPasswordView = this.a) != null) {
            resetPasswordView.showLoginError((String) CollectionsKt___CollectionsKt.first(map.values()));
        }
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    public void attachRouter(@NotNull ResetPasswordPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    public void attachView(@NotNull ResetPasswordView resetPasswordView) {
        Intrinsics.checkNotNullParameter(resetPasswordView, "view");
        this.a = resetPasswordView;
        if (resetPasswordView != null) {
            resetPasswordView.setLogin(this.e);
        }
        a(this.f);
        ResetPasswordView resetPasswordView2 = this.a;
        if (resetPasswordView2 != null) {
            resetPasswordView2.setResetPasswordButtonEnabled(!m.isBlank(this.e));
        }
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = resetPasswordView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…cribe { onCloseScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = resetPasswordView.resetPasswordClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.resetPasswordClicks…ibe { onResetPassword() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = resetPasswordView.loginChanges().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.loginChanges().subs…rdButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("login", this.e).putStringMap("messages", this.f);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordPresenter
    public void setStartLogin(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
    }
}
