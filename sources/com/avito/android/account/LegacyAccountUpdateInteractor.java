package com.avito.android.account;

import com.avito.android.account.analytics.event.SuccessfulAuthenticationEvent;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0017\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b 0\u001e0\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR'\u0010#\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b 0\u001e0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/account/LegacyAccountUpdateInteractor;", "Lcom/avito/android/account/AccountUpdateInteractor;", "", "error", "", "notifyLogoutError", "(Ljava/lang/Throwable;)V", "notifyLoginError", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "Lcom/avito/android/remote/model/ProfileInfo;", "profile", "", "source", "Lio/reactivex/rxjava3/core/Completable;", "login", "(Lcom/avito/android/remote/model/Session;Lcom/avito/android/remote/model/ProfileInfo;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "", "isUserAction", "logout", "(ZLjava/lang/String;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "e", "Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "lastLoggedEmailStorage", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Lkotlin/jvm/JvmSuppressWildcards;", "d", "Ldagger/Lazy;", "lazyPlugins", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/account/SessionChangeTracker;", "c", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/SessionChangeTracker;Ldagger/Lazy;Lcom/avito/android/account/MutableLastLoggedEmailStorage;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyAccountUpdateInteractor implements AccountUpdateInteractor {
    public final Analytics a;
    public final AccountStorageInteractor b;
    public final SessionChangeTracker c;
    public final Lazy<Set<AuthorizationPlugin>> d;
    public final MutableLastLoggedEmailStorage e;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;

        public a(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor) {
            this.a = legacyAccountUpdateInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.a.track(new SuccessfulAuthenticationEvent());
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;
        public final /* synthetic */ Session b;
        public final /* synthetic */ String c;

        public b(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor, Session session, String str) {
            this.a = legacyAccountUpdateInteractor;
            this.b = session;
            this.c = str;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.c.trackSessionUpdate(this.b, this.c);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;
        public final /* synthetic */ ProfileInfo b;

        public c(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor, ProfileInfo profileInfo) {
            this.a = legacyAccountUpdateInteractor;
            this.b = profileInfo;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            String email = this.b.getEmail();
            if (email != null) {
                this.a.e.saveEmail(email);
            }
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;

        public d(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor) {
            this.a = legacyAccountUpdateInteractor;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            LegacyAccountUpdateInteractor.access$notifyLogin(this.a);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;

        public e(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor) {
            this.a = legacyAccountUpdateInteractor;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            LegacyAccountUpdateInteractor.access$notifyLogout(this.a);
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ LegacyAccountUpdateInteractor a;
        public final /* synthetic */ String b;

        public f(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor, String str) {
            this.a = legacyAccountUpdateInteractor;
            this.b = str;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.c.trackLogout(this.b);
        }
    }

    public LegacyAccountUpdateInteractor(@NotNull Analytics analytics, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull Lazy<Set<AuthorizationPlugin>> lazy, @NotNull MutableLastLoggedEmailStorage mutableLastLoggedEmailStorage) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(lazy, "lazyPlugins");
        Intrinsics.checkNotNullParameter(mutableLastLoggedEmailStorage, "lastLoggedEmailStorage");
        this.a = analytics;
        this.b = accountStorageInteractor;
        this.c = sessionChangeTracker;
        this.d = lazy;
        this.e = mutableLastLoggedEmailStorage;
    }

    public static final void access$notifyLogin(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor) {
        Set<AuthorizationPlugin> set = legacyAccountUpdateInteractor.d.get();
        Intrinsics.checkNotNullExpressionValue(set, "lazyPlugins.get()");
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            it.next().onLogin();
        }
    }

    public static final void access$notifyLogout(LegacyAccountUpdateInteractor legacyAccountUpdateInteractor) {
        Set<AuthorizationPlugin> set = legacyAccountUpdateInteractor.d.get();
        Intrinsics.checkNotNullExpressionValue(set, "lazyPlugins.get()");
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            it.next().onLogout();
        }
    }

    @Override // com.avito.android.account.AccountUpdateInteractor
    @NotNull
    public Completable login(@NotNull Session session, @NotNull ProfileInfo profileInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(session, SessionContract.SESSION);
        Intrinsics.checkNotNullParameter(profileInfo, "profile");
        Completable doOnComplete = this.b.save(profileInfo, session).doOnSubscribe(new a(this)).doOnComplete(new b(this, session, str)).doOnComplete(new c(this, profileInfo)).doOnComplete(new d(this));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "accountStorageInteractor…omplete { notifyLogin() }");
        return doOnComplete;
    }

    @Override // com.avito.android.account.AccountUpdateInteractor
    @NotNull
    public Completable logout(boolean z, @Nullable String str) {
        Completable doOnComplete = this.b.clearAccount().doOnComplete(new e(this)).doOnComplete(new f(this, str));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "accountStorageInteractor…ker.trackLogout(source) }");
        return doOnComplete;
    }

    @Override // com.avito.android.account.AccountUpdateInteractor
    public void notifyLoginError(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
    }

    @Override // com.avito.android.account.AccountUpdateInteractor
    public void notifyLogoutError(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        this.a.track(new NonFatalError("Logout error", th, null, 4, null));
    }
}
