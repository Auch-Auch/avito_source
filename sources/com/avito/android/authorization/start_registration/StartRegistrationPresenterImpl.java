package com.avito.android.authorization.start_registration;

import a2.a.a.b.k.c;
import a2.g.r.g;
import com.avito.android.authorization.reset_password.StartRegistrationView;
import com.avito.android.authorization.start_registration.StartRegistrationPresenter;
import com.avito.android.code_confirmation.RequestCodeInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Strings;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010.\u001a\u00020+\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b0\u00101J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/authorization/start_registration/StartRegistrationPresenterImpl;", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter;", "", "startLogin", "", "setStartLogin", "(Ljava/lang/String;)V", "Lcom/avito/android/authorization/reset_password/StartRegistrationView;", "view", "attachView", "(Lcom/avito/android/authorization/reset_password/StartRegistrationView;)V", "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "messages", AuthSource.SEND_ABUSE, "(Ljava/util/Map;)V", "Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;", g.a, "Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;", "interactor", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "f", "Ljava/util/Map;", "Lcom/avito/android/authorization/reset_password/StartRegistrationView;", "e", "Ljava/lang/String;", "login", "c", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/authorization/start_registration/StartRegistrationPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "state", "<init>", "(Lcom/avito/android/authorization/start_registration/StartRegistrationInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class StartRegistrationPresenterImpl implements StartRegistrationPresenter {
    public StartRegistrationView a;
    public StartRegistrationPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e;
    public Map<String, String> f;
    public final StartRegistrationInteractor g;
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
                StartRegistrationPresenterImpl.access$onCloseScreen((StartRegistrationPresenterImpl) this.b);
            } else if (i == 1) {
                StartRegistrationPresenterImpl.access$onRequestCode((StartRegistrationPresenterImpl) this.b);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ StartRegistrationPresenterImpl a;

        public b(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
            this.a = startRegistrationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            StartRegistrationPresenterImpl startRegistrationPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            startRegistrationPresenterImpl.e = str2;
            StartRegistrationPresenterImpl.access$checkButtonState(this.a);
        }
    }

    @Inject
    public StartRegistrationPresenterImpl(@NotNull StartRegistrationInteractor startRegistrationInteractor, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(startRegistrationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.g = startRegistrationInteractor;
        this.h = schedulersFactory;
        String string = kundle != null ? kundle.getString("login") : null;
        this.e = string == null ? "" : string;
        this.f = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$checkButtonState(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        StartRegistrationView startRegistrationView = startRegistrationPresenterImpl.a;
        if (startRegistrationView != null) {
            startRegistrationView.setContinueButtonEnabled(Strings.isPhone(startRegistrationPresenterImpl.e));
        }
    }

    public static final void access$clearFieldErrors(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        Objects.requireNonNull(startRegistrationPresenterImpl);
        startRegistrationPresenterImpl.f = r.emptyMap();
    }

    public static final void access$handleFieldError(StartRegistrationPresenterImpl startRegistrationPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(startRegistrationPresenterImpl);
        if (typedError instanceof TypedError.ErrorMap) {
            startRegistrationPresenterImpl.a(((TypedError.ErrorMap) typedError).getMessages());
        } else if (typedError instanceof ErrorWithMessage.SimpleMessageError) {
            StartRegistrationView startRegistrationView = startRegistrationPresenterImpl.a;
            if (startRegistrationView != null) {
                startRegistrationView.showError(((ErrorWithMessage.SimpleMessageError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage.NetworkError) {
            StartRegistrationView startRegistrationView2 = startRegistrationPresenterImpl.a;
            if (startRegistrationView2 != null) {
                startRegistrationView2.showError(((ErrorWithMessage.NetworkError) typedError).getMessage());
            }
        } else {
            StartRegistrationView startRegistrationView3 = startRegistrationPresenterImpl.a;
            if (startRegistrationView3 != null) {
                startRegistrationView3.showUnknownError();
            }
        }
    }

    public static final void access$handleRequestCompleted(StartRegistrationPresenterImpl startRegistrationPresenterImpl, CodeInfo codeInfo) {
        StartRegistrationPresenter.Router router = startRegistrationPresenterImpl.b;
        if (router != null) {
            router.openCodeConfirmation(startRegistrationPresenterImpl.e, codeInfo.getText(), codeInfo.getTimeout(), codeInfo.getLength());
        }
    }

    public static final void access$handleRequestStarted(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        StartRegistrationView startRegistrationView = startRegistrationPresenterImpl.a;
        if (startRegistrationView != null) {
            startRegistrationView.hideKeyboard();
            startRegistrationView.showProgress();
            startRegistrationView.hideLoginError();
        }
    }

    public static final void access$onCloseScreen(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        StartRegistrationPresenter.Router router = startRegistrationPresenterImpl.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    public static final void access$onPhoneConfirmed(StartRegistrationPresenterImpl startRegistrationPresenterImpl, String str, String str2, boolean z) {
        StartRegistrationPresenter.Router router = startRegistrationPresenterImpl.b;
        if (router != null) {
            router.finishStartRegistration(str, str2, z);
        }
    }

    public static final void access$onRequestCode(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        CompositeDisposable compositeDisposable = startRegistrationPresenterImpl.c;
        Disposable subscribe = RequestCodeInteractor.DefaultImpls.requestCode$default(startRegistrationPresenterImpl.g, startRegistrationPresenterImpl.e, null, 2, null).observeOn(startRegistrationPresenterImpl.h.mainThread()).doOnSubscribe(new a2.a.a.b.k.a(startRegistrationPresenterImpl)).doOnTerminate(new h1(0, startRegistrationPresenterImpl)).doAfterTerminate(new h1(1, startRegistrationPresenterImpl)).subscribe(new a2.a.a.b.k.b(startRegistrationPresenterImpl), new c(startRegistrationPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.requestCode(l…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void a(Map<String, String> map) {
        StartRegistrationView startRegistrationView;
        this.f = map;
        if ((!map.isEmpty()) && (startRegistrationView = this.a) != null) {
            startRegistrationView.showLoginError((String) CollectionsKt___CollectionsKt.first(map.values()));
        }
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    public void attachRouter(@NotNull StartRegistrationPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    public void attachView(@NotNull StartRegistrationView startRegistrationView) {
        Intrinsics.checkNotNullParameter(startRegistrationView, "view");
        this.a = startRegistrationView;
        if (startRegistrationView != null) {
            startRegistrationView.setLogin(this.e);
        }
        a(this.f);
        StartRegistrationView startRegistrationView2 = this.a;
        if (startRegistrationView2 != null) {
            startRegistrationView2.setContinueButtonEnabled(Strings.isPhone(this.e));
        }
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = startRegistrationView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…cribe { onCloseScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = startRegistrationView.continueClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.continueClicks().su…cribe { onRequestCode() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = startRegistrationView.loginChanges().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.loginChanges().subs…ckButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("login", this.e).putStringMap("messages", this.f);
    }

    @Override // com.avito.android.authorization.start_registration.StartRegistrationPresenter
    public void setStartLogin(@Nullable String str) {
        if (str == null || !Strings.isPhone(str)) {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.e = str;
    }
}
