package com.avito.android.authorization.change_password;

import a2.g.r.g;
import com.avito.android.authorization.change_password.ChangePasswordPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.preferences.Preference;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\u00104\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\fJ#\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010 R\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0016\u0010$\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordPresenterImpl;", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "Lcom/avito/android/authorization/change_password/ChangePasswordView;", "view", "", "attachView", "(Lcom/avito/android/authorization/change_password/ChangePasswordView;)V", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "c", "", "", "messages", AuthSource.BOOKING_ORDER, "(Ljava/util/Map;)V", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/util/ErrorFormatter;", "j", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;", "disposables", "f", "Ljava/lang/String;", Preference.PASSWORD, g.a, "Ljava/util/Map;", "", "e", "Z", "isPasswordSaving", "Lcom/avito/android/authorization/change_password/ChangePasswordView;", "Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;", "h", "Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "state", "<init>", "(Lcom/avito/android/authorization/change_password/ChangePasswordInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/util/Kundle;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ChangePasswordPresenterImpl implements ChangePasswordPresenter {
    public ChangePasswordView a;
    public ChangePasswordPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public boolean e;
    public String f;
    public Map<String, String> g;
    public final ChangePasswordInteractor h;
    public final SchedulersFactory i;
    public final ErrorFormatter j;

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
                ChangePasswordPresenter.Router router = ((ChangePasswordPresenterImpl) this.b).b;
                if (router != null) {
                    router.leaveScreen();
                }
            } else if (i == 1) {
                ((ChangePasswordPresenterImpl) this.b).c();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ ChangePasswordPresenterImpl a;

        public b(ChangePasswordPresenterImpl changePasswordPresenterImpl) {
            this.a = changePasswordPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            ChangePasswordPresenterImpl changePasswordPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            changePasswordPresenterImpl.f = str2;
            this.a.a();
        }
    }

    public static final class c<T> implements Consumer<Disposable> {
        public final /* synthetic */ ChangePasswordPresenterImpl a;

        public c(ChangePasswordPresenterImpl changePasswordPresenterImpl) {
            this.a = changePasswordPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            ChangePasswordView changePasswordView = this.a.a;
            if (changePasswordView != null) {
                changePasswordView.showProgress();
            }
            ChangePasswordView changePasswordView2 = this.a.a;
            if (changePasswordView2 != null) {
                changePasswordView2.hideKeyboard();
            }
            this.a.e = true;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ ChangePasswordPresenterImpl a;

        public d(ChangePasswordPresenterImpl changePasswordPresenterImpl) {
            this.a = changePasswordPresenterImpl;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ChangePasswordView changePasswordView = this.a.a;
            if (changePasswordView != null) {
                changePasswordView.hideProgress();
            }
            ChangePasswordView changePasswordView2 = this.a.a;
            if (changePasswordView2 != null) {
                changePasswordView2.hidePasswordError();
            }
            this.a.e = false;
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ ChangePasswordPresenterImpl a;
        public final /* synthetic */ String b;

        public e(ChangePasswordPresenterImpl changePasswordPresenterImpl, String str) {
            this.a = changePasswordPresenterImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            ChangePasswordPresenter.Router router = this.a.b;
            if (router != null) {
                router.openLogin(this.b);
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChangePasswordPresenterImpl a;

        public f(ChangePasswordPresenterImpl changePasswordPresenterImpl) {
            this.a = changePasswordPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ChangePasswordPresenterImpl changePasswordPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            ChangePasswordPresenterImpl.access$handleError(changePasswordPresenterImpl, th2);
        }
    }

    @Inject
    public ChangePasswordPresenterImpl(@NotNull ChangePasswordInteractor changePasswordInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter, @Nullable Kundle kundle) {
        String str;
        Map<String, String> emptyMap;
        Boolean bool;
        Intrinsics.checkNotNullParameter(changePasswordInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        this.h = changePasswordInteractor;
        this.i = schedulersFactory;
        this.j = errorFormatter;
        this.e = (kundle == null || (bool = kundle.getBoolean("password_changing")) == null) ? false : bool.booleanValue();
        this.f = (kundle == null || (str = kundle.getString(Preference.PASSWORD)) == null) ? "" : str;
        this.g = (kundle == null || (emptyMap = kundle.getNonNullStringMap("messages")) == null) ? r.emptyMap() : emptyMap;
    }

    public static final void access$handleError(ChangePasswordPresenterImpl changePasswordPresenterImpl, Throwable th) {
        Objects.requireNonNull(changePasswordPresenterImpl);
        changePasswordPresenterImpl.g = r.emptyMap();
        TypedError typedError = null;
        TypedResultException typedResultException = (TypedResultException) (!(th instanceof TypedResultException) ? null : th);
        if (typedResultException != null) {
            typedError = typedResultException.getErrorResult();
        }
        if (typedError instanceof TypedError.ErrorMap) {
            changePasswordPresenterImpl.b(((TypedError.ErrorMap) typedError).getMessages());
            return;
        }
        ChangePasswordView changePasswordView = changePasswordPresenterImpl.a;
        if (changePasswordView != null) {
            changePasswordView.showError(changePasswordPresenterImpl.j.format(th));
        }
    }

    public final void a() {
        ChangePasswordView changePasswordView = this.a;
        if (changePasswordView != null) {
            changePasswordView.setSaveButtonEnabled(this.f.length() > 0);
        }
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter
    public void attachRouter(@NotNull ChangePasswordPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        if (this.e) {
            c();
        }
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter
    public void attachView(@NotNull ChangePasswordView changePasswordView) {
        Intrinsics.checkNotNullParameter(changePasswordView, "view");
        this.a = changePasswordView;
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = changePasswordView.navigationClicks().subscribe(new a(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…{ router?.leaveScreen() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = changePasswordView.saveClicks().subscribe(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.saveClicks().subscribe { savePassword() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = changePasswordView.passwordChanged().subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.passwordChanged().s…indSaveButton()\n        }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        changePasswordView.setPassword(this.f);
        a();
        b(this.g);
    }

    public final void b(Map<String, String> map) {
        ChangePasswordView changePasswordView;
        this.g = map;
        String str = (String) CollectionsKt___CollectionsKt.firstOrNull(map.values());
        if (str != null && (changePasswordView = this.a) != null) {
            changePasswordView.showPasswordError(str);
        }
    }

    public final void c() {
        String str = this.f;
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str != null) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.h.changePassword(str).observeOn(this.i.mainThread()).doOnSubscribe(new c(this)).doOnTerminate(new d(this)).subscribe(new e(this, str), new f(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.changePasswor…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("password_changing", Boolean.valueOf(this.e)).putString(Preference.PASSWORD, this.f).putStringMap("messages", this.g);
    }
}
