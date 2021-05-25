package com.avito.android.user_stats.tab;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.model.UserStatsTabData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "interactor", "Lcom/avito/android/user_stats/UserStatsViewModel;", "e", "Lcom/avito/android/user_stats/UserStatsViewModel;", "userStatsViewModel", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/user_stats/model/UserStatsTabData;", "c", "Lcom/avito/user_stats/model/UserStatsTabData;", "tabModel", "<init>", "(Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/user_stats/model/UserStatsTabData;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/user_stats/UserStatsViewModel;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabViewModelFactory implements ViewModelProvider.Factory {
    public final UserStatsTabInteractor a;
    public final SchedulersFactory3 b;
    public final UserStatsTabData c;
    public final Analytics d;
    public final UserStatsViewModel e;

    @Inject
    public UserStatsTabViewModelFactory(@NotNull UserStatsTabInteractor userStatsTabInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable UserStatsTabData userStatsTabData, @NotNull Analytics analytics, @NotNull UserStatsViewModel userStatsViewModel) {
        Intrinsics.checkNotNullParameter(userStatsTabInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(userStatsViewModel, "userStatsViewModel");
        this.a = userStatsTabInteractor;
        this.b = schedulersFactory3;
        this.c = userStatsTabData;
        this.d = analytics;
        this.e = userStatsViewModel;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(UserStatsTabViewModel.class)) {
            return new UserStatsTabViewModel(this.a, this.b, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
