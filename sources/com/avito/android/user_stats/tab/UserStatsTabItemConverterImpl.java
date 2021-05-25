package com.avito.android.user_stats.tab;

import com.avito.user_stats.model.UserStatsTabData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "Lcom/avito/user_stats/model/UserStatsTabData;", "tabData", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "convert", "(Lcom/avito/user_stats/model/UserStatsTabData;)Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabItemConverterImpl implements UserStatsTabItemConverter {
    @Override // com.avito.android.user_stats.tab.UserStatsTabItemConverter
    @NotNull
    public UserStatsTabItem convert(@NotNull UserStatsTabData userStatsTabData) {
        Intrinsics.checkNotNullParameter(userStatsTabData, "tabData");
        return new UserStatsTabItem(userStatsTabData.getTitle(), userStatsTabData.getId());
    }
}
