package com.avito.android.user_adverts.expired_count;

import a2.b.a.a.a;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CountResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_advert.UserAdvertsInfoCache;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.Logs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractorImpl;", "Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractor;", "", "forced", "Lio/reactivex/disposables/Disposable;", "updateExpiredCount", "(Z)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "userAdvertInfoStorage", "Lcom/avito/android/account/AccountStorageInteractor;", "c", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "d", "Lcom/avito/android/user_advert/UserAdvertsInfoCache;", "userAdvertsInfoCache", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "api", "<init>", "(Lcom/avito/android/user_adverts/remote/UserAdvertsApi;Lcom/avito/android/preferences/UserAdvertsInfoStorage;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/user_advert/UserAdvertsInfoCache;)V", "Companion", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsInfoInteractorImpl implements UserAdvertsInfoInteractor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static long e;
    public final UserAdvertsApi a;
    public final UserAdvertsInfoStorage b;
    public final AccountStorageInteractor c;
    public final UserAdvertsInfoCache d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts/expired_count/UserAdvertsInfoInteractorImpl$Companion;", "", "", "lastTryUpdateTimestamp", "J", "getLastTryUpdateTimestamp", "()J", "setLastTryUpdateTimestamp", "(J)V", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final long getLastTryUpdateTimestamp() {
            return UserAdvertsInfoInteractorImpl.e;
        }

        public final void setLastTryUpdateTimestamp(long j) {
            UserAdvertsInfoInteractorImpl.e = j;
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public UserAdvertsInfoInteractorImpl(@NotNull UserAdvertsApi userAdvertsApi, @NotNull UserAdvertsInfoStorage userAdvertsInfoStorage, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull UserAdvertsInfoCache userAdvertsInfoCache) {
        Intrinsics.checkNotNullParameter(userAdvertsApi, "api");
        Intrinsics.checkNotNullParameter(userAdvertsInfoStorage, "userAdvertInfoStorage");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(userAdvertsInfoCache, "userAdvertsInfoCache");
        this.a = userAdvertsApi;
        this.b = userAdvertsInfoStorage;
        this.c = accountStorageInteractor;
        this.d = userAdvertsInfoCache;
    }

    public static final void access$handleFailure(UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl, Throwable th) {
        Objects.requireNonNull(userAdvertsInfoInteractorImpl);
        Logs.error("Failed to update expired adverts count", th);
    }

    public static final void access$handleResult(UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(userAdvertsInfoInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult;
            if (ofResult.getResult() instanceof CountResult.Ok) {
                Object result = ofResult.getResult();
                Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.CountResult.Ok");
                int count = ((CountResult.Ok) result).getCount();
                userAdvertsInfoInteractorImpl.d.updateExpiredCount(count);
                userAdvertsInfoInteractorImpl.b.saveExpiredAdvertsCount(count);
                return;
            }
            userAdvertsInfoInteractorImpl.b.clear();
            e = 0;
            Logs.error$default("Unable to get expired adverts count for unauthorized user", null, 2, null);
        } else if (typedResult instanceof TypedResult.OfError) {
            e = 0;
            StringBuilder L = a.L("Failed to get expired adverts count: ");
            L.append(((TypedResult.OfError) typedResult).getError().getMessage());
            Logs.error$default(L.toString(), null, 2, null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        if (com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorKt.access$getMAX_SCHEDULED_INTERVAL_MS$p() < (java.lang.System.currentTimeMillis() - com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl.e)) goto L_0x0021;
     */
    @Override // com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractor
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.disposables.Disposable updateExpiredCount(boolean r10) {
        /*
            r9 = this;
            com.avito.android.account.AccountStorageInteractor r0 = r9.c
            com.avito.android.account.BlockingAccountStorageInteractor r0 = r0.toBlocking()
            boolean r0 = r0.isAuthorized()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000f
            goto L_0x0022
        L_0x000f:
            if (r10 == 0) goto L_0x0012
            goto L_0x0021
        L_0x0012:
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorKt.access$getMAX_SCHEDULED_INTERVAL_MS$p()
            long r7 = com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl.e
            long r3 = r3 - r7
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x0022
        L_0x0021:
            r1 = 1
        L_0x0022:
            if (r1 == 0) goto L_0x0043
            long r0 = java.lang.System.currentTimeMillis()
            com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl.e = r0
            com.avito.android.user_adverts.remote.UserAdvertsApi r10 = r9.a
            io.reactivex.rxjava3.core.Observable r10 = r10.getExpiredItemsCount()
            io.reactivex.Observable r10 = com.avito.android.util.rx3.InteropKt.toV2(r10)
            a2.a.a.i3.a.a r0 = new a2.a.a.i3.a.a
            r0.<init>(r9)
            a2.a.a.i3.a.b r1 = new a2.a.a.i3.a.b
            r1.<init>(r9)
            io.reactivex.disposables.Disposable r10 = r10.subscribe(r0, r1)
            goto L_0x0044
        L_0x0043:
            r10 = 0
        L_0x0044:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl.updateExpiredCount(boolean):io.reactivex.disposables.Disposable");
    }
}
