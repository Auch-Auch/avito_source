package com.avito.android.user_stats;

import com.avito.android.remote.model.TypedResult;
import com.avito.user_stats.model.UserStatsScreenData;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_stats/UserStatsInteractor;", "", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/user_stats/model/UserStatsScreenData;", "getUserStats", "()Lio/reactivex/rxjava3/core/Single;", "", "setSmbStatsWasVisited", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface UserStatsInteractor {
    @NotNull
    Single<TypedResult<UserStatsScreenData>> getUserStats();

    void setSmbStatsWasVisited();
}
