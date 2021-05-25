package com.avito.android.profile.password_change;

import a2.a.a.b2.f1.m;
import a2.a.a.b2.f1.n;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.PasswordChangeButtonClickEvent;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.profile.password_change.PasswordChangePresenter;
import com.avito.android.profile.password_change.business.PasswordChangeInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010[\u001a\u00020X\u0012\b\u0010a\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010!R\u0018\u0010H\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u00107R\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010^R\u0016\u0010`\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u00107¨\u0006d"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangePresenterImpl;", "Lcom/avito/android/profile/password_change/PasswordChangePresenter;", "", "c", "()V", "", "text", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/password_change/PasswordChangeView;", "view", "attachView", "(Lcom/avito/android/profile/password_change/PasswordChangeView;)V", "detachView", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "isVisible", "onVisibilityChange", "(Z)V", "", "resultCode", "onAuthResult", "(I)V", "Lio/reactivex/disposables/Disposable;", "l", "Lio/reactivex/disposables/Disposable;", "visibleDisposable", "d", "Z", "newPasswordHidden", "Lcom/avito/android/dialog/DialogPresenter;", "o", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "r", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "smartLockLoader", "Lcom/avito/android/analytics/Analytics;", "u", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/error_helper/ErrorHelper;", VKApiConst.Q, "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "h", "Ljava/lang/String;", "userLogin", "Lcom/avito/android/profile/password_change/PasswordChangeView;", "i", "smartLockUserLogin", "Lcom/avito/android/util/SchedulersFactory;", "p", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "s", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "smartLockSaver", AuthSource.OPEN_CHANNEL_LIST, "changePasswordDisposable", "j", "Ljava/lang/Boolean;", "restoredButtonState", "oldPasswordHidden", "Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "n", "Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "interactor", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Mode;", "t", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Mode;", "mode", "Lio/reactivex/disposables/CompositeDisposable;", "k", "Lio/reactivex/disposables/CompositeDisposable;", "viewDisposables", "f", "oldPassword", "Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;", VKApiConst.VERSION, "Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;", "resourceProvider", "e", "buttonEnabled", "Lcom/avito/android/profile/password_change/PasswordChangePresenter$Router;", a2.g.r.g.a, "newPassword", "state", "<init>", "(Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/authorization/smart_lock/SmartLockLoader;Lcom/avito/android/authorization/smart_lock/SmartLockSaver;Lcom/avito/android/profile/password_change/PasswordChangePresenter$Mode;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/profile/password_change/PasswordChangeResourceProvider;Lcom/avito/android/util/Kundle;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangePresenterImpl implements PasswordChangePresenter {
    public PasswordChangeView a;
    public PasswordChangePresenter.Router b;
    public boolean c;
    public boolean d;
    public boolean e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Boolean j;
    public final CompositeDisposable k;
    public Disposable l;
    public Disposable m;
    public final PasswordChangeInteractor n;
    public final DialogPresenter o;
    public final SchedulersFactory p;
    public final ErrorHelper q;
    public final SmartLockLoader r;
    public final SmartLockSaver s;
    public final PasswordChangePresenter.Mode t;
    public final Analytics u;
    public final PasswordChangeResourceProvider v;

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<Unit, Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final Boolean apply(Unit unit) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return Boolean.valueOf(((PasswordChangePresenterImpl) this.b).c);
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return Boolean.valueOf(((PasswordChangePresenterImpl) this.b).d);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public static final b f = new b(4);
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else if (i == 3) {
                Logs.error(th);
            } else if (i == 4) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                Boolean bool3 = ((PasswordChangePresenterImpl) this.b).j;
                if (bool3 != null) {
                    PasswordChangePresenterImpl.access$setButtonEnabled((PasswordChangePresenterImpl) this.b, bool3.booleanValue());
                    ((PasswordChangePresenterImpl) this.b).j = null;
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                PasswordChangePresenterImpl.access$setButtonEnabled((PasswordChangePresenterImpl) this.b, bool2.booleanValue());
            } else if (i == 1) {
                Boolean bool4 = bool;
                Intrinsics.checkNotNullExpressionValue(bool4, "isHidden");
                ((PasswordChangeView) this.b).setOldPasswordInputHidden(bool4.booleanValue());
            } else if (i == 2) {
                Boolean bool5 = bool;
                Intrinsics.checkNotNullExpressionValue(bool5, "isHidden");
                ((PasswordChangeView) this.b).setNewPasswordInputHidden(bool5.booleanValue());
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public d(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                PasswordChangePresenterImpl.access$onChangeButtonClick((PasswordChangePresenterImpl) this.b);
            } else if (i == 1) {
                PasswordChangePresenter.Router router = ((PasswordChangePresenterImpl) this.b).b;
                if (router != null) {
                    String str = ((PasswordChangePresenterImpl) this.b).i;
                    if (str == null) {
                        str = ((PasswordChangePresenterImpl) this.b).h;
                    }
                    router.openPasswordRecovery(str);
                }
            } else if (i == 2) {
                PasswordChangePresenterImpl passwordChangePresenterImpl = (PasswordChangePresenterImpl) this.b;
                passwordChangePresenterImpl.c = !passwordChangePresenterImpl.c;
            } else if (i == 3) {
                PasswordChangePresenterImpl passwordChangePresenterImpl2 = (PasswordChangePresenterImpl) this.b;
                passwordChangePresenterImpl2.d = !passwordChangePresenterImpl2.d;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class e<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public e(int i, Object obj) {
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
                ((PasswordChangePresenterImpl) this.b).g = str2;
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullExpressionValue(str3, "it");
                ((PasswordChangePresenterImpl) this.b).f = str3;
            } else {
                throw null;
            }
        }
    }

    public static final class f<T1, T2, R> implements BiFunction<String, String, Boolean> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public Boolean apply(String str, String str2) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str3, "oldPass");
            Intrinsics.checkNotNullParameter(str4, "newPass");
            boolean z = false;
            if (str3.length() > 0) {
                if (str4.length() > 0) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class g<T> implements Consumer<Unit> {
        public final /* synthetic */ PasswordChangePresenterImpl a;
        public final /* synthetic */ PasswordChangeView b;

        public g(PasswordChangePresenterImpl passwordChangePresenterImpl, PasswordChangeView passwordChangeView) {
            this.a = passwordChangePresenterImpl;
            this.b = passwordChangeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.b.hideKeyboard();
            PasswordChangePresenter.Router router = this.a.b;
            if (router != null) {
                router.leaveScreen();
            }
        }
    }

    public static final class h<T> implements Consumer<Boolean> {
        public final /* synthetic */ PasswordChangePresenterImpl a;

        public h(PasswordChangePresenterImpl passwordChangePresenterImpl) {
            this.a = passwordChangePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            PasswordChangeView passwordChangeView = this.a.a;
            if (passwordChangeView != null) {
                passwordChangeView.scrollToBottom();
            }
        }
    }

    public static final class i<T> implements Predicate<Boolean> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "it");
            return bool2.booleanValue();
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
        }
    }

    public static final class k<T> implements Consumer<String> {
        public final /* synthetic */ PasswordChangePresenterImpl a;

        public k(PasswordChangePresenterImpl passwordChangePresenterImpl) {
            this.a = passwordChangePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            this.a.h = str;
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public static final l a = new l();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    @Inject
    public PasswordChangePresenterImpl(@NotNull PasswordChangeInteractor passwordChangeInteractor, @NotNull DialogPresenter dialogPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorHelper errorHelper, @NotNull SmartLockLoader smartLockLoader, @NotNull SmartLockSaver smartLockSaver, @NotNull PasswordChangePresenter.Mode mode, @NotNull Analytics analytics, @NotNull PasswordChangeResourceProvider passwordChangeResourceProvider, @Nullable Kundle kundle) {
        String str;
        String string;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Intrinsics.checkNotNullParameter(passwordChangeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(smartLockLoader, "smartLockLoader");
        Intrinsics.checkNotNullParameter(smartLockSaver, "smartLockSaver");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(passwordChangeResourceProvider, "resourceProvider");
        this.n = passwordChangeInteractor;
        this.o = dialogPresenter;
        this.p = schedulersFactory;
        this.q = errorHelper;
        this.r = smartLockLoader;
        this.s = smartLockSaver;
        this.t = mode;
        this.u = analytics;
        this.v = passwordChangeResourceProvider;
        boolean z = true;
        this.c = (kundle == null || (bool3 = kundle.getBoolean("old_password_hidden")) == null) ? true : bool3.booleanValue();
        if (!(kundle == null || (bool2 = kundle.getBoolean("new_password_hidden")) == null)) {
            z = bool2.booleanValue();
        }
        this.d = z;
        this.e = (kundle == null || (bool = kundle.getBoolean("button_enabled")) == null) ? false : bool.booleanValue();
        String str2 = "";
        this.f = (kundle == null || (str = kundle.getString("old_password")) == null) ? str2 : str;
        if (!(kundle == null || (string = kundle.getString("new_password")) == null)) {
            str2 = string;
        }
        this.g = str2;
        Boolean bool4 = null;
        this.h = kundle != null ? kundle.getString("user_login") : null;
        this.i = kundle != null ? kundle.getString("smartlock_user_login") : null;
        this.j = kundle != null ? kundle.getBoolean("button_enabled") : bool4;
        this.k = new CompositeDisposable();
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.l = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.m = empty2;
    }

    public static final void access$handleLoadingState(PasswordChangePresenterImpl passwordChangePresenterImpl, LoadingState loadingState, String str) {
        PasswordChangeView passwordChangeView;
        PasswordChangeView passwordChangeView2;
        Objects.requireNonNull(passwordChangePresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            PasswordChangeView passwordChangeView3 = passwordChangePresenterImpl.a;
            if (passwordChangeView3 != null) {
                passwordChangeView3.showButtonProgress();
                return;
            }
            return;
        }
        boolean z = false;
        if (loadingState instanceof LoadingState.Loaded) {
            String str2 = passwordChangePresenterImpl.i;
            if (str2 == null) {
                str2 = passwordChangePresenterImpl.h;
            }
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                }
                if (z) {
                    String text = ((PasswordChangeResult) ((LoadingState.Loaded) loadingState).getData()).getText();
                    CompositeDisposable compositeDisposable = passwordChangePresenterImpl.k;
                    Disposable subscribe = InteropKt.toV2(passwordChangePresenterImpl.s.connectWithObservables()).subscribe(new a2.a.a.b2.f1.k(passwordChangePresenterImpl, text), a2.a.a.b2.f1.l.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "smartLockSaver.connectWi…Logs.error(it)\n        })");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                    passwordChangePresenterImpl.s.save(str2, str);
                    return;
                }
            }
            passwordChangePresenterImpl.a(((PasswordChangeResult) ((LoadingState.Loaded) loadingState).getData()).getText());
        } else if (loadingState instanceof LoadingState.Error) {
            PasswordChangeView passwordChangeView4 = passwordChangePresenterImpl.a;
            if (passwordChangeView4 != null) {
                passwordChangeView4.hideButtonProgress();
            }
            TypedError error = ((LoadingState.Error) loadingState).getError();
            if (error instanceof ErrorResult.IncorrectData) {
                PasswordChangeView passwordChangeView5 = passwordChangePresenterImpl.a;
                if (passwordChangeView5 != null) {
                    passwordChangeView5.setButtonEnabled(false);
                }
                passwordChangePresenterImpl.e = false;
                for (Map.Entry<String, String> entry : ((ErrorResult.IncorrectData) error).getMessages().entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    int hashCode = key.hashCode();
                    if (hashCode != -1378572616) {
                        if (hashCode == 1216985755 && key.equals(Preference.PASSWORD) && (passwordChangeView = passwordChangePresenterImpl.a) != null) {
                            passwordChangeView.showNewPasswordError(value);
                        }
                    } else if (key.equals("oldpass") && (passwordChangeView2 = passwordChangePresenterImpl.a) != null) {
                        passwordChangeView2.showOldPasswordError(value);
                    }
                }
            } else if (error instanceof ErrorResult.ErrorDialog) {
                UserDialog userDialog = ((ErrorResult.ErrorDialog) error).getUserDialog();
                CompositeDisposable compositeDisposable2 = passwordChangePresenterImpl.k;
                Disposable subscribe2 = passwordChangePresenterImpl.o.showDialog(userDialog).subscribe(new m(passwordChangePresenterImpl), n.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "dialogPresenter.showDial…error(it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (error instanceof ErrorResult.Unauthorized) {
                PasswordChangePresenter.Router router = passwordChangePresenterImpl.b;
                if (router != null) {
                    router.navigateToAuth();
                }
            } else if (error instanceof ErrorResult.Unauthenticated) {
                PasswordChangePresenter.Router router2 = passwordChangePresenterImpl.b;
                if (router2 != null) {
                    router2.navigateToAuth();
                }
            } else if (error instanceof ErrorResult.NetworkIOError) {
                PasswordChangeView passwordChangeView6 = passwordChangePresenterImpl.a;
                if (passwordChangeView6 != null) {
                    passwordChangeView6.showSnackbar(passwordChangePresenterImpl.q.recycle(error));
                }
            } else {
                PasswordChangeView passwordChangeView7 = passwordChangePresenterImpl.a;
                if (passwordChangeView7 != null) {
                    passwordChangeView7.showSnackbar(passwordChangePresenterImpl.v.getServerErrorText());
                }
            }
        }
    }

    public static final void access$onChangeButtonClick(PasswordChangePresenterImpl passwordChangePresenterImpl) {
        if (passwordChangePresenterImpl.t.isSessionsFlow()) {
            Analytics analytics = passwordChangePresenterImpl.u;
            String sessionIdHash = passwordChangePresenterImpl.t.getSessionIdHash();
            String loginType = passwordChangePresenterImpl.t.getLoginType();
            if (loginType == null) {
                loginType = "";
            }
            analytics.track(new PasswordChangeButtonClickEvent(sessionIdHash, loginType));
        }
        String str = passwordChangePresenterImpl.g;
        passwordChangePresenterImpl.m.dispose();
        Disposable subscribe = passwordChangePresenterImpl.n.changePassword(passwordChangePresenterImpl.f, passwordChangePresenterImpl.g, passwordChangePresenterImpl.t.getSessionIdHash(), passwordChangePresenterImpl.t.isSessionsFlow() ? passwordChangePresenterImpl.t.getSource() : null).observeOn(passwordChangePresenterImpl.p.mainThread()).subscribe(new a2.a.a.b2.f1.a(passwordChangePresenterImpl, str), new a2.a.a.b2.f1.b(passwordChangePresenterImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.changePasswor…ycle(it)) }\n            )");
        passwordChangePresenterImpl.m = subscribe;
    }

    public static final void access$setButtonEnabled(PasswordChangePresenterImpl passwordChangePresenterImpl, boolean z) {
        PasswordChangeView passwordChangeView = passwordChangePresenterImpl.a;
        if (passwordChangeView != null) {
            passwordChangeView.setButtonEnabled(z);
        }
        passwordChangePresenterImpl.e = z;
    }

    public final void a(String str) {
        PasswordChangeView passwordChangeView = this.a;
        if (passwordChangeView != null) {
            passwordChangeView.hideButtonProgress();
        }
        PasswordChangeView passwordChangeView2 = this.a;
        if (passwordChangeView2 != null) {
            passwordChangeView2.hideKeyboard();
        }
        if (this.t.isSessionsFlow()) {
            PasswordChangePresenter.Router router = this.b;
            if (router != null) {
                router.navigateToInfoScreen();
                return;
            }
            return;
        }
        PasswordChangePresenter.Router router2 = this.b;
        if (router2 != null) {
            router2.leaveWithSuccessMessage(str);
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void attachRouter(@NotNull PasswordChangePresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
        if (!(this.f.length() > 0)) {
            CompositeDisposable compositeDisposable = this.k;
            Disposable subscribe = InteropKt.toV2(this.r.connectWithObservables()).subscribe(new a2.a.a.b2.f1.g(this), a2.a.a.b2.f1.h.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "smartLockLoader.connectW…Logs.error(it)\n        })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            this.r.load(true);
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void attachView(@NotNull PasswordChangeView passwordChangeView) {
        Intrinsics.checkNotNullParameter(passwordChangeView, "view");
        if (this.t.isSessionsFlow()) {
            c();
        }
        this.a = passwordChangeView;
        CompositeDisposable compositeDisposable = this.k;
        Disposable subscribe = passwordChangeView.getNavigationClicks().subscribe(new g(this, passwordChangeView), b.e);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks\n  …error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.k;
        Disposable subscribe2 = passwordChangeView.getOldPasswordIconClicks().doOnNext(new d(2, this)).map(new a(0, this)).startWith((Observable<R>) ((R) Boolean.valueOf(this.c))).subscribe(new c(1, passwordChangeView), b.f);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.oldPasswordIconClic…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.k;
        Disposable subscribe3 = passwordChangeView.getNewPasswordIconClicks().doOnNext(new d(3, this)).map(new a(1, this)).startWith((Observable<R>) ((R) Boolean.valueOf(this.d))).subscribe(new c(2, passwordChangeView), b.b);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.newPasswordIconClic…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.k;
        Disposable subscribe4 = passwordChangeView.getButtonClicks().mergeWith(passwordChangeView.getActionDoneClicks()).subscribe(new d(0, this), b.c);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.buttonClicks.mergeW…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        Observable<String> distinctUntilChanged = passwordChangeView.getOldPasswordChanges().doOnNext(new e(1, this)).distinctUntilChanged();
        Observable<String> distinctUntilChanged2 = passwordChangeView.getNewPasswordChanges().doOnNext(new e(0, this)).distinctUntilChanged();
        CompositeDisposable compositeDisposable5 = this.k;
        Disposable subscribe5 = Observable.combineLatest(distinctUntilChanged, distinctUntilChanged2, f.a).subscribe(new c(0, this), b.d);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "Observable.combineLatest…ogs.error(it) }\n        )");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        passwordChangeView.setButtonEnabled(this.e);
        b();
        if (this.t.isSessionsFlow()) {
            CompositeDisposable compositeDisposable6 = this.k;
            Disposable subscribe6 = passwordChangeView.getForgotPasswordClicks().subscribe(new d(1, this));
            Intrinsics.checkNotNullExpressionValue(subscribe6, "view.forgotPasswordClick… userLogin)\n            }");
            DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            passwordChangeView.showViewsForSessionsFlow();
            return;
        }
        passwordChangeView.hideViewsForSessionsFlow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if ((r0.length() > 0) != false) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r4 = this;
            java.lang.String r0 = r4.h
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            io.reactivex.disposables.CompositeDisposable r0 = r4.k
            com.avito.android.profile.password_change.business.PasswordChangeInteractor r1 = r4.n
            io.reactivex.Observable r1 = r1.getUserLogin()
            com.avito.android.util.SchedulersFactory r2 = r4.p
            io.reactivex.Scheduler r2 = r2.mainThread()
            io.reactivex.Observable r1 = r1.observeOn(r2)
            com.avito.android.profile.password_change.PasswordChangePresenterImpl$k r2 = new com.avito.android.profile.password_change.PasswordChangePresenterImpl$k
            r2.<init>(r4)
            com.avito.android.profile.password_change.PasswordChangePresenterImpl$l r3 = com.avito.android.profile.password_change.PasswordChangePresenterImpl.l.a
            io.reactivex.disposables.Disposable r1 = r1.subscribe(r2, r3)
            java.lang.String r2 = "interactor.getUserLogin(….error(it)\n            })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.password_change.PasswordChangePresenterImpl.b():void");
    }

    public final void c() {
        PasswordChangePresenter.Router router;
        if (!this.n.isAuthorized()) {
            PasswordChangePresenter.Router router2 = this.b;
            if (router2 != null) {
                router2.navigateToAuth();
            }
        } else if ((this.t.getUserId() == null || (!Intrinsics.areEqual(this.t.getUserId(), this.n.getCurrentUserId()))) && (router = this.b) != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void detachView() {
        PasswordChangeView passwordChangeView = this.a;
        if (passwordChangeView != null) {
            passwordChangeView.onDestroyView();
        }
        this.k.clear();
        this.a = null;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void onAuthResult(int i2) {
        if (i2 != -1) {
            if (this.t.isSessionsFlow()) {
                PasswordChangePresenter.Router router = this.b;
                if (router != null) {
                    router.navigateToHomeScreen();
                    return;
                }
                return;
            }
            PasswordChangePresenter.Router router2 = this.b;
            if (router2 != null) {
                router2.leaveScreen();
            }
        } else if (this.t.isSessionsFlow()) {
            c();
            b();
        }
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("old_password_hidden", Boolean.valueOf(this.c)).putBoolean("new_password_hidden", Boolean.valueOf(this.d)).putBoolean("button_enabled", Boolean.valueOf(this.e)).putString("old_password", this.f).putString("new_password", this.g).putString("user_login", this.h).putString("smartlock_user_login", this.i);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangePresenter
    public void onVisibilityChange(boolean z) {
        if (this.t.isSessionsFlow()) {
            if (z) {
                PasswordChangeView passwordChangeView = this.a;
                if (passwordChangeView != null) {
                    Disposable subscribe = passwordChangeView.getKeyboardVisibilityChanges().debounce((long) this.v.getHideShowDelayMs(), TimeUnit.MILLISECONDS).observeOn(this.p.mainThread()).filter(i.a).subscribe(new h(this), j.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "it.keyboardVisibilityCha…w?.scrollToBottom() }) {}");
                    this.l = subscribe;
                    return;
                }
                return;
            }
            this.l.dispose();
        }
    }
}
