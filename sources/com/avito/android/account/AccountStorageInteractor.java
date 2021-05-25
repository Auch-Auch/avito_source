package com.avito.android.account;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ'\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\tH'¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/account/AccountStateProvider;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ProfileInfo;", "profileInfo", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Maybe;", "currentProfileInfo", "()Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "currentSession", "profile", "Lio/reactivex/rxjava3/core/Completable;", "save", "(Lcom/avito/android/remote/model/ProfileInfo;Lcom/avito/android/remote/model/Session;)Lio/reactivex/rxjava3/core/Completable;", "clearAccount", "()Lio/reactivex/rxjava3/core/Completable;", "", "clearCache", "()V", "getProfileInfo", "()Lcom/avito/android/remote/model/ProfileInfo;", "getSession", "()Lcom/avito/android/remote/model/Session;", "Lcom/avito/android/account/BlockingAccountStorageInteractor;", "toBlocking", "()Lcom/avito/android/account/BlockingAccountStorageInteractor;", "Lkotlin/Function0;", "retrieveSessionFunction", "saveSessionBlocking", "(Lkotlin/jvm/functions/Function0;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface AccountStorageInteractor extends AccountStateProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements Predicate<ProfileInfo> {
            public static final a a = new a();

            @Override // io.reactivex.rxjava3.functions.Predicate
            public boolean test(ProfileInfo profileInfo) {
                return !Intrinsics.areEqual(profileInfo, ProfileInfo.Companion.getNULL());
            }
        }

        public static final class b<T> implements Predicate<Session> {
            public static final b a = new b();

            @Override // io.reactivex.rxjava3.functions.Predicate
            public boolean test(Session session) {
                return !Intrinsics.areEqual(session, Session.Companion.getNULL());
            }
        }

        @NotNull
        public static Single<Boolean> currentAuthorized(@NotNull AccountStorageInteractor accountStorageInteractor) {
            return AccountStateProvider.DefaultImpls.currentAuthorized(accountStorageInteractor);
        }

        @NotNull
        public static Maybe<ProfileInfo> currentProfileInfo(@NotNull AccountStorageInteractor accountStorageInteractor) {
            Maybe<ProfileInfo> filter = accountStorageInteractor.profileInfo().firstElement().filter(a.a);
            Intrinsics.checkNotNullExpressionValue(filter, "profileInfo()\n        .f… it != ProfileInfo.NULL }");
            return filter;
        }

        @NotNull
        public static Maybe<Session> currentSession(@NotNull AccountStorageInteractor accountStorageInteractor) {
            Maybe<Session> filter = accountStorageInteractor.session().firstElement().filter(b.a);
            Intrinsics.checkNotNullExpressionValue(filter, "session()\n        .first…er { it != Session.NULL }");
            return filter;
        }

        @NotNull
        public static Maybe<String> currentUserId(@NotNull AccountStorageInteractor accountStorageInteractor) {
            return AccountStateProvider.DefaultImpls.currentUserId(accountStorageInteractor);
        }

        public static /* synthetic */ Completable save$default(AccountStorageInteractor accountStorageInteractor, ProfileInfo profileInfo, Session session, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    profileInfo = null;
                }
                if ((i & 2) != 0) {
                    session = null;
                }
                return accountStorageInteractor.save(profileInfo, session);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }
    }

    @NotNull
    Completable clearAccount();

    void clearCache();

    @NotNull
    Maybe<ProfileInfo> currentProfileInfo();

    @NotNull
    Maybe<Session> currentSession();

    @NotNull
    ProfileInfo getProfileInfo();

    @Deprecated(message = "Use session")
    @Nullable
    Session getSession();

    @NotNull
    Observable<ProfileInfo> profileInfo();

    @NotNull
    Completable save(@Nullable ProfileInfo profileInfo, @Nullable Session session);

    void saveSessionBlocking(@NotNull Function0<Session> function0);

    @NotNull
    Observable<Session> session();

    @NotNull
    BlockingAccountStorageInteractor toBlocking();
}
