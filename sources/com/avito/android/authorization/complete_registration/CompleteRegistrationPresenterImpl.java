package com.avito.android.authorization.complete_registration;

import com.avito.android.Features;
import com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter;
import com.avito.android.authorization.complete_registration.di.Hash;
import com.avito.android.authorization.complete_registration.di.Login;
import com.avito.android.authorization.complete_registration.di.PresenterState;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BI\b\u0007\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0001\u0010=\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\t\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001aR\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00100R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u001a¨\u0006A"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenterImpl;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "", "c", "()V", AuthSource.SEND_ABUSE, "", "", "messages", AuthSource.BOOKING_ORDER, "(Ljava/util/Map;)V", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;", "view", "attachView", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;)V", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;)V", "detachRouter", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;", "i", "Ljava/lang/String;", "login", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/Features;", "n", "Lcom/avito/android/Features;", "features", "name", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "k", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "interactor", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;", "", "f", "Z", "progress", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "d", Preference.PASSWORD, a2.g.r.g.a, "disposables", "e", "Ljava/util/Map;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "l", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLock", "j", "hash", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;Lcom/avito/android/authorization/smart_lock/SmartLockSaver;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class CompleteRegistrationPresenterImpl implements CompleteRegistrationPresenter {
    public CompleteRegistrationView a;
    public CompleteRegistrationPresenter.Router b;
    public String c;
    public String d;
    public Map<String, String> e;
    public boolean f;
    public final CompositeDisposable g;
    public final CompositeDisposable h;
    public final String i;
    public final String j;
    public final CompleteRegistrationInteractor k;
    public final SmartLockSaver l;
    public final SchedulersFactory m;
    public final Features n;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                ((CompleteRegistrationPresenterImpl) this.b).c = str2;
                ((CompleteRegistrationPresenterImpl) this.b).a();
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullExpressionValue(str3, "it");
                ((CompleteRegistrationPresenterImpl) this.b).d = str3;
                ((CompleteRegistrationPresenterImpl) this.b).a();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                CompleteRegistrationPresenterImpl.access$onCloseScreen((CompleteRegistrationPresenterImpl) this.b);
            } else if (i == 1) {
                ((CompleteRegistrationPresenterImpl) this.b).c();
            } else {
                throw null;
            }
        }
    }

    public static final class c<T> implements Consumer<Maybe<Unit>> {
        public final /* synthetic */ CompleteRegistrationPresenterImpl a;
        public final /* synthetic */ CompleteRegistrationPresenter.Router b;

        public c(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl, CompleteRegistrationPresenter.Router router) {
            this.a = completeRegistrationPresenterImpl;
            this.b = router;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Maybe<Unit> maybe) {
            Maybe<Unit> maybe2 = maybe;
            CompositeDisposable compositeDisposable = this.a.g;
            Intrinsics.checkNotNullExpressionValue(maybe2, "process");
            Disposable subscribe = InteropKt.toV2(maybe2).doOnSubscribe(new a2.a.a.b.c.a(this)).doFinally(new a2.a.a.b.c.b(this)).subscribe(new a2.a.a.b.c.c(this), new a2.a.a.b.c.d(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "process.toV2()\n         …      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final class d<T> implements Consumer<Disposable> {
        public final /* synthetic */ CompleteRegistrationPresenterImpl a;

        public d(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
            this.a = completeRegistrationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            CompleteRegistrationPresenterImpl.access$handleRegistrationStarted(this.a);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ CompleteRegistrationPresenterImpl a;

        public e(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
            this.a = completeRegistrationPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            CompleteRegistrationView completeRegistrationView = this.a.a;
            if (completeRegistrationView != null) {
                completeRegistrationView.hideProgress();
            }
            this.a.f = false;
        }
    }

    public static final class f<T> implements Consumer<AuthResult> {
        public final /* synthetic */ CompleteRegistrationPresenterImpl a;

        public f(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
            this.a = completeRegistrationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AuthResult authResult) {
            CompleteRegistrationPresenterImpl.access$handleRegistrationCompleted(this.a);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ CompleteRegistrationPresenterImpl a;

        public g(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
            this.a = completeRegistrationPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            CompleteRegistrationPresenterImpl.access$clearFieldErrors(this.a);
            if (th2 instanceof TypedResultException) {
                CompleteRegistrationPresenterImpl.access$handleRegistrationError(this.a, ((TypedResultException) th2).getErrorResult());
                return;
            }
            CompleteRegistrationView completeRegistrationView = this.a.a;
            if (completeRegistrationView != null) {
                completeRegistrationView.showUnknownError();
            }
        }
    }

    @Inject
    public CompleteRegistrationPresenterImpl(@Login @NotNull String str, @Hash @NotNull String str2, @NotNull CompleteRegistrationInteractor completeRegistrationInteractor, @NotNull SmartLockSaver smartLockSaver, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features, @PresenterState @Nullable Kundle kundle) {
        Map<String, String> emptyMap;
        Boolean bool;
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "hash");
        Intrinsics.checkNotNullParameter(completeRegistrationInteractor, "interactor");
        Intrinsics.checkNotNullParameter(smartLockSaver, "smartLock");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.i = str;
        this.j = str2;
        this.k = completeRegistrationInteractor;
        this.l = smartLockSaver;
        this.m = schedulersFactory;
        this.n = features;
        String str3 = null;
        String string = kundle != null ? kundle.getString("name") : null;
        String str4 = "";
        this.c = string == null ? str4 : string;
        str3 = kundle != null ? kundle.getString(Preference.PASSWORD) : str3;
        this.d = str3 != null ? str3 : str4;
        this.e = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
        this.f = (kundle == null || (bool = kundle.getBoolean("progress")) == null) ? false : bool.booleanValue();
        this.g = new CompositeDisposable();
        this.h = new CompositeDisposable();
    }

    public static final void access$clearFieldErrors(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
        Objects.requireNonNull(completeRegistrationPresenterImpl);
        completeRegistrationPresenterImpl.e = r.emptyMap();
    }

    public static final void access$handleRegistrationCompleted(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
        if (completeRegistrationPresenterImpl.n.getSmartLock().invoke().booleanValue()) {
            completeRegistrationPresenterImpl.l.save(completeRegistrationPresenterImpl.i, completeRegistrationPresenterImpl.d);
            return;
        }
        CompleteRegistrationPresenter.Router router = completeRegistrationPresenterImpl.b;
        if (router != null) {
            router.completeRegistration();
        }
    }

    public static final void access$handleRegistrationError(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(completeRegistrationPresenterImpl);
        if (typedError instanceof TypedError.ErrorMap) {
            completeRegistrationPresenterImpl.b(((TypedError.ErrorMap) typedError).getMessages());
        } else if (typedError instanceof ErrorWithMessage.SimpleMessageError) {
            CompleteRegistrationView completeRegistrationView = completeRegistrationPresenterImpl.a;
            if (completeRegistrationView != null) {
                completeRegistrationView.showError(((ErrorWithMessage.SimpleMessageError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage.NetworkError) {
            CompleteRegistrationView completeRegistrationView2 = completeRegistrationPresenterImpl.a;
            if (completeRegistrationView2 != null) {
                completeRegistrationView2.showError(((ErrorWithMessage.NetworkError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage.Unknown) {
            CompleteRegistrationView completeRegistrationView3 = completeRegistrationPresenterImpl.a;
            if (completeRegistrationView3 != null) {
                completeRegistrationView3.showError(((ErrorWithMessage.Unknown) typedError).getMessage());
            }
        } else {
            CompleteRegistrationView completeRegistrationView4 = completeRegistrationPresenterImpl.a;
            if (completeRegistrationView4 != null) {
                completeRegistrationView4.showUnknownError();
            }
        }
    }

    public static final void access$handleRegistrationStarted(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
        completeRegistrationPresenterImpl.f = true;
        CompleteRegistrationView completeRegistrationView = completeRegistrationPresenterImpl.a;
        if (completeRegistrationView != null) {
            completeRegistrationView.hideKeyboard();
            completeRegistrationView.showProgress();
            completeRegistrationView.hideNameError();
            completeRegistrationView.hidePasswordError();
        }
    }

    public static final void access$hideProgress(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
        CompleteRegistrationView completeRegistrationView = completeRegistrationPresenterImpl.a;
        if (completeRegistrationView != null) {
            completeRegistrationView.hideProgress();
        }
        CompleteRegistrationView completeRegistrationView2 = completeRegistrationPresenterImpl.a;
        if (completeRegistrationView2 != null) {
            completeRegistrationView2.hideKeyboard();
        }
    }

    public static final void access$onCloseScreen(CompleteRegistrationPresenterImpl completeRegistrationPresenterImpl) {
        CompleteRegistrationView completeRegistrationView = completeRegistrationPresenterImpl.a;
        if (completeRegistrationView != null) {
            completeRegistrationView.hideProgress();
        }
        CompleteRegistrationView completeRegistrationView2 = completeRegistrationPresenterImpl.a;
        if (completeRegistrationView2 != null) {
            completeRegistrationView2.hideKeyboard();
        }
        CompleteRegistrationPresenter.Router router = completeRegistrationPresenterImpl.b;
        if (router != null) {
            router.leaveScreen();
        }
    }

    public final void a() {
        CompleteRegistrationView completeRegistrationView = this.a;
        if (completeRegistrationView != null) {
            boolean z = true;
            if (!(!m.isBlank(this.c)) || !(!m.isBlank(this.d))) {
                z = false;
            }
            completeRegistrationView.setRegisterButtonEnabled(z);
        }
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter
    public void attachRouter(@NotNull CompleteRegistrationPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = InteropKt.toV2(this.l.connectWithObservables()).subscribe(new c(this, router));
        Intrinsics.checkNotNullExpressionValue(subscribe, "smartLock.connectWithObs…              )\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter
    public void attachView(@NotNull CompleteRegistrationView completeRegistrationView) {
        Intrinsics.checkNotNullParameter(completeRegistrationView, "view");
        this.a = completeRegistrationView;
        if (completeRegistrationView != null) {
            completeRegistrationView.setName(this.c);
            completeRegistrationView.setPassword(this.d);
        }
        b(this.e);
        a();
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = completeRegistrationView.navigationClicks().subscribe(new b(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…cribe { onCloseScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.h;
        Disposable subscribe2 = completeRegistrationView.registerClicks().subscribe(new b(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.registerClicks().subscribe { onRegister() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.h;
        Disposable subscribe3 = completeRegistrationView.nameChanges().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.nameChanges().subsc…erButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.h;
        Disposable subscribe4 = completeRegistrationView.passwordChanges().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.passwordChanges().s…erButtonState()\n        }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        if (this.f) {
            c();
        }
    }

    public final void b(Map<String, String> map) {
        CompleteRegistrationView completeRegistrationView;
        CompleteRegistrationView completeRegistrationView2;
        this.e = map;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int hashCode = key.hashCode();
            if (hashCode != 3373707) {
                if (hashCode == 1216985755 && key.equals(Preference.PASSWORD) && (completeRegistrationView = this.a) != null) {
                    completeRegistrationView.showPasswordError(value);
                }
            } else if (key.equals("name") && (completeRegistrationView2 = this.a) != null) {
                completeRegistrationView2.showNameError(value);
            }
        }
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.k.register(this.j, this.c, this.d).firstOrError().observeOn(this.m.mainThread()).doOnSubscribe(new d(this)).doOnTerminate(new e(this)).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.register(hash…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter
    public void detachRouter() {
        this.g.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter
    public void detachView() {
        this.h.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putString("name", this.c).putString(Preference.PASSWORD, this.d).putStringMap("messages", this.e).putBoolean("progress", Boolean.valueOf(this.f));
    }
}
