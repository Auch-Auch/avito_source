package com.avito.android.user_stats;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.UserStatsApi;
import com.avito.user_stats.model.UserStatsScreenData;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_stats/UserStatsInteractorImpl;", "Lcom/avito/android/user_stats/UserStatsInteractor;", "", "setSmbStatsWasVisited", "()V", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/user_stats/model/UserStatsScreenData;", "getUserStats", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/user_stats/UserStatsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/user_stats/UserStatsApi;", "userStatsApi", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "c", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "storage", "<init>", "(Lcom/avito/user_stats/UserStatsApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsInteractorImpl implements UserStatsInteractor {
    public final UserStatsApi a;
    public final SchedulersFactory3 b;
    public final SmbStatsTooltipSessionStorage c;

    @Inject
    public UserStatsInteractorImpl(@NotNull UserStatsApi userStatsApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SmbStatsTooltipSessionStorage smbStatsTooltipSessionStorage) {
        Intrinsics.checkNotNullParameter(userStatsApi, "userStatsApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(smbStatsTooltipSessionStorage, "storage");
        this.a = userStatsApi;
        this.b = schedulersFactory3;
        this.c = smbStatsTooltipSessionStorage;
    }

    @Override // com.avito.android.user_stats.UserStatsInteractor
    @NotNull
    public Single<TypedResult<UserStatsScreenData>> getUserStats() {
        return a.e2(this.b, this.a.getSmbStats(), "userStatsApi\n           …scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_stats.UserStatsInteractor
    public void setSmbStatsWasVisited() {
        this.c.setSmbStatsWasVisited();
    }
}
