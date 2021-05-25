package com.avito.android.user_stats.di;

import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.user_stats.tab.UserStatsTabFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabComponent;", "", "Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "fragment", "", "inject", "(Lcom/avito/android/user_stats/tab/UserStatsTabFragment;)V", "Factory", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserStatsTabDependencies.class}, modules = {UserStatsTabModule.class, UserStatsTabTrackerModule.class})
@PerFragment
public interface UserStatsTabComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsTabComponent$Factory;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "", "tabId", "Lcom/avito/android/user_stats/di/UserStatsTabDependencies;", "userStatsTabDependencies", "Lcom/avito/android/user_stats/di/UserStatsTabComponent;", "create", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Lcom/avito/android/user_stats/di/UserStatsTabDependencies;)Lcom/avito/android/user_stats/di/UserStatsTabComponent;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        UserStatsTabComponent create(@BindsInstance @NotNull ViewModelStoreOwner viewModelStoreOwner, @BindsInstance @UserStatsTabId @NotNull String str, @NotNull UserStatsTabDependencies userStatsTabDependencies);
    }

    void inject(@NotNull UserStatsTabFragment userStatsTabFragment);
}
