package com.avito.android.user_stats.tab;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "id", "Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "createUserStatsTabFragment", "(Ljava/lang/String;)Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "user-stats_release"}, k = 2, mv = {1, 4, 2})
public final class UserStatsTabFragmentKt {
    @NotNull
    public static final UserStatsTabFragment createUserStatsTabFragment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        UserStatsTabFragment userStatsTabFragment = new UserStatsTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab_id", str);
        userStatsTabFragment.setArguments(bundle);
        return userStatsTabFragment;
    }
}
