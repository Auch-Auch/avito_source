package com.avito.android.account;

import a2.g.r.g;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.preferences.MutableSessionStorage;
import com.avito.android.profile.MutableProfileInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.SessionContract;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.GuardedBy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00108\u001a\u000205¢\u0006\u0004\bH\u0010IJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J#\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0002¢\u0006\u0004\b$\u0010\u0018J\u000f\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010\u0018R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010-RD\u00104\u001a0\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00060\u0006 0*\u0017\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00060\u0006\u0018\u00010/¢\u0006\u0002\b10/¢\u0006\u0002\b18\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;RD\u0010>\u001a0\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00030\u0003 0*\u0017\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00030\u0003\u0018\u00010/¢\u0006\u0002\b10/¢\u0006\u0002\b18\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u00103R\u0018\u0010@\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/avito/android/account/AccountStorageInteractorImpl;", "Lcom/avito/android/account/AccountStorageInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ProfileInfo;", "profileInfo", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "", "authorized", "profile", "Lio/reactivex/rxjava3/core/Completable;", "save", "(Lcom/avito/android/remote/model/ProfileInfo;Lcom/avito/android/remote/model/Session;)Lio/reactivex/rxjava3/core/Completable;", "Lkotlin/Function0;", "retrieveSessionFunction", "", "saveSessionBlocking", "(Lkotlin/jvm/functions/Function0;)V", "getProfileInfo", "()Lcom/avito/android/remote/model/ProfileInfo;", "getSession", "()Lcom/avito/android/remote/model/Session;", "clearCache", "()V", "clearAccount", "()Lio/reactivex/rxjava3/core/Completable;", "", ChannelContext.Item.USER_ID, "isAuthorized", "()Z", "Lcom/avito/android/account/BlockingAccountStorageInteractor;", "toBlocking", "()Lcom/avito/android/account/BlockingAccountStorageInteractor;", "c", "(Lcom/avito/android/remote/model/Session;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "Ljava/lang/Object;", "lock", "Lcom/avito/android/profile/MutableProfileInfoStorage;", g.a, "Lcom/avito/android/profile/MutableProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/remote/model/ProfileInfo;", "profileInfoCache", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "sessionRelay", "Lcom/avito/android/util/BuildInfo;", "i", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/account/MutableLastUserStorage;", "h", "Lcom/avito/android/account/MutableLastUserStorage;", "lastUserStorage", "d", "profileInfoRelay", "Lcom/avito/android/remote/model/Session;", "sessionCache", "Lcom/avito/android/preferences/MutableSessionStorage;", "f", "Lcom/avito/android/preferences/MutableSessionStorage;", "sessionStorage", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "<init>", "(Lcom/avito/android/preferences/MutableSessionStorage;Lcom/avito/android/profile/MutableProfileInfoStorage;Lcom/avito/android/account/MutableLastUserStorage;Lcom/avito/android/util/BuildInfo;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class AccountStorageInteractorImpl implements AccountStorageInteractor {
    public final Object a = new Object();
    @GuardedBy("lock")
    public Session b;
    @GuardedBy("lock")
    public ProfileInfo c;
    public final BehaviorRelay<ProfileInfo> d = BehaviorRelay.createDefault(ProfileInfo.Companion.getNULL());
    public final BehaviorRelay<Session> e = BehaviorRelay.createDefault(Session.Companion.getNULL());
    public final MutableSessionStorage f;
    public final MutableProfileInfoStorage g;
    public final MutableLastUserStorage h;
    public final BuildInfo i;

    public static final class a<T, R> implements Function<Session, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Session session) {
            return Boolean.valueOf(!Intrinsics.areEqual(session, Session.Companion.getNULL()));
        }
    }

    public static final class b<V> implements Callable<Object> {
        public final /* synthetic */ AccountStorageInteractorImpl a;

        public b(AccountStorageInteractorImpl accountStorageInteractorImpl) {
            this.a = accountStorageInteractorImpl;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.f.removeSession();
            this.a.g.removeProfileInfo();
            this.a.clearCache();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements CompletableOnSubscribe {
        public final /* synthetic */ AccountStorageInteractorImpl a;
        public final /* synthetic */ ProfileInfo b;
        public final /* synthetic */ Session c;

        public c(AccountStorageInteractorImpl accountStorageInteractorImpl, ProfileInfo profileInfo, Session session) {
            this.a = accountStorageInteractorImpl;
            this.b = profileInfo;
            this.c = session;
        }

        @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
        public final void subscribe(CompletableEmitter completableEmitter) {
            ProfileInfo profileInfo = this.b;
            if (profileInfo != null) {
                AccountStorageInteractorImpl.access$saveProfileInfo(this.a, profileInfo);
            }
            Session session = this.c;
            if (session != null) {
                this.a.c(session);
            }
            completableEmitter.onComplete();
        }
    }

    public static final class d<T, R> implements Function<ProfileInfo, String> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(ProfileInfo profileInfo) {
            String userId = profileInfo.getUserId();
            return userId != null ? userId : "";
        }
    }

    public AccountStorageInteractorImpl(@NotNull MutableSessionStorage mutableSessionStorage, @NotNull MutableProfileInfoStorage mutableProfileInfoStorage, @NotNull MutableLastUserStorage mutableLastUserStorage, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(mutableSessionStorage, "sessionStorage");
        Intrinsics.checkNotNullParameter(mutableProfileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(mutableLastUserStorage, "lastUserStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.f = mutableSessionStorage;
        this.g = mutableProfileInfoStorage;
        this.h = mutableLastUserStorage;
        this.i = buildInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$saveProfileInfo(com.avito.android.account.AccountStorageInteractorImpl r3, com.avito.android.remote.model.ProfileInfo r4) {
        /*
            java.lang.Object r0 = r3.a
            monitor-enter(r0)
            com.avito.android.profile.MutableProfileInfoStorage r1 = r3.g     // Catch:{ all -> 0x003b }
            r1.saveProfileInfo(r4)     // Catch:{ all -> 0x003b }
            r3.c = r4     // Catch:{ all -> 0x003b }
            com.avito.android.account.MutableLastUserStorage r1 = r3.h     // Catch:{ all -> 0x003b }
            java.lang.String r2 = r4.getUserId()     // Catch:{ all -> 0x003b }
            r1.setUserId(r2)     // Catch:{ all -> 0x003b }
            r3.a()     // Catch:{ all -> 0x003b }
            com.avito.android.util.BuildInfo r3 = r3.i     // Catch:{ all -> 0x003b }
            boolean r3 = r3.isDebug()     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0039
            java.lang.String r3 = r4.getUserId()     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x002d
            int r3 = r3.length()     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = 0
            goto L_0x002e
        L_0x002d:
            r3 = 1
        L_0x002e:
            if (r3 != 0) goto L_0x0031
            goto L_0x0039
        L_0x0031:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "User id is null"
            r3.<init>(r4)     // Catch:{ all -> 0x003b }
            throw r3     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.account.AccountStorageInteractorImpl.access$saveProfileInfo(com.avito.android.account.AccountStorageInteractorImpl, com.avito.android.remote.model.ProfileInfo):void");
    }

    public final void a() {
        BehaviorRelay<ProfileInfo> behaviorRelay = this.d;
        ProfileInfo profileInfo = this.c;
        if (profileInfo == null) {
            profileInfo = ProfileInfo.Companion.getNULL();
        }
        behaviorRelay.accept(profileInfo);
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Observable<Boolean> authorized() {
        Observable<R> map = session().map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "session().map { it != Session.NULL }");
        return map;
    }

    public final void b() {
        BehaviorRelay<Session> behaviorRelay = this.e;
        Session session = this.b;
        if (session == null) {
            session = Session.Companion.getNULL();
        }
        behaviorRelay.accept(session);
    }

    public final void c(Session session) {
        synchronized (this.a) {
            if (this.i.isDebug()) {
                if (session.getRefreshToken() == null) {
                    throw new RuntimeException("Refresh token must not be null");
                }
            }
            this.b = session;
            this.f.saveSession(session);
            b();
        }
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Completable clearAccount() {
        Completable fromCallable = Completable.fromCallable(new b(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…       clearCache()\n    }");
        return fromCallable;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    public void clearCache() {
        this.b = null;
        this.c = null;
        b();
        a();
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Single<Boolean> currentAuthorized() {
        return AccountStorageInteractor.DefaultImpls.currentAuthorized(this);
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Maybe<ProfileInfo> currentProfileInfo() {
        return AccountStorageInteractor.DefaultImpls.currentProfileInfo(this);
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Maybe<Session> currentSession() {
        return AccountStorageInteractor.DefaultImpls.currentSession(this);
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Maybe<String> currentUserId() {
        return AccountStorageInteractor.DefaultImpls.currentUserId(this);
    }

    @Override // com.avito.android.account.AccountStateProvider
    @Nullable
    public String getCurrentUserId() {
        return getProfileInfo().getUserId();
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public ProfileInfo getProfileInfo() {
        ProfileInfo profileInfo;
        synchronized (this.a) {
            profileInfo = this.c;
            if (profileInfo == null) {
                profileInfo = this.g.getProfileInfo();
                this.c = profileInfo;
                a();
            }
        }
        return profileInfo;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @Nullable
    public Session getSession() {
        Session session;
        synchronized (this.a) {
            session = this.b;
            if (session == null) {
                session = this.f.getSession();
                if (session == null) {
                    session = Session.Companion.getNULL();
                }
                this.b = session;
                b();
            }
        }
        return session;
    }

    @Override // com.avito.android.account.AccountStateProvider
    public boolean isAuthorized() {
        Session session = getSession();
        if (session == null || !(!Intrinsics.areEqual(session, Session.Companion.getNULL()))) {
            return false;
        }
        return true;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Observable<ProfileInfo> profileInfo() {
        BehaviorRelay<ProfileInfo> behaviorRelay = this.d;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "profileInfoRelay");
        return behaviorRelay;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Completable save(@Nullable ProfileInfo profileInfo, @Nullable Session session) {
        Completable create = Completable.create(new c(this, profileInfo, session));
        Intrinsics.checkNotNullExpressionValue(create, "Completable.create { emi…er.onComplete()\n        }");
        return create;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    public void saveSessionBlocking(@NotNull Function0<Session> function0) {
        Intrinsics.checkNotNullParameter(function0, "retrieveSessionFunction");
        synchronized (this.a) {
            Session invoke = function0.invoke();
            if (invoke != null) {
                c(invoke);
            }
        }
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Observable<Session> session() {
        BehaviorRelay<Session> behaviorRelay = this.e;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "sessionRelay");
        return behaviorRelay;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public BlockingAccountStorageInteractor toBlocking() {
        return new BlockingAccountStorageInteractor(this) { // from class: com.avito.android.account.AccountStorageInteractorImpl$toBlocking$1
            public final /* synthetic */ AccountStorageInteractorImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            @Nullable
            public ProfileInfo getProfile() {
                return this.a.getProfileInfo();
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            @Nullable
            public String getPushToken() {
                Session session = this.a.getSession();
                if (session != null) {
                    return session.getPushToken();
                }
                return null;
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            @Nullable
            public String getRefreshToken() {
                Session session = this.a.getSession();
                if (session != null) {
                    return session.getRefreshToken();
                }
                return null;
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            @Nullable
            public String getSession() {
                Session session = this.a.getSession();
                if (session != null) {
                    return session.getSession();
                }
                return null;
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            @Nullable
            public String getUserId() {
                ProfileInfo profile = getProfile();
                if (profile != null) {
                    return profile.getUserId();
                }
                return null;
            }

            @Override // com.avito.android.account.BlockingAccountStorageInteractor
            public boolean isAuthorized() {
                return this.a.isAuthorized();
            }
        };
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Observable<String> userId() {
        Observable<R> distinctUntilChanged = profileInfo().map(d.a).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "profileInfo()\n        .m…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }
}
