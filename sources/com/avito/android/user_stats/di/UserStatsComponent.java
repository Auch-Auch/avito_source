package com.avito.android.user_stats.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.user_stats.UserStatsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsComponent;", "Lcom/avito/android/user_stats/di/UserStatsTabDependencies;", "Lcom/avito/android/user_stats/UserStatsFragment;", "fragment", "", "inject", "(Lcom/avito/android/user_stats/UserStatsFragment;)V", "Factory", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserStatsDependencies.class}, modules = {UserStatsModule.class, UserStatsTrackerModule.class})
@PerFragment
public interface UserStatsComponent extends UserStatsTabDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/user_stats/di/UserStatsDependencies;", "userStatsDependencies", "Lcom/avito/android/user_stats/di/UserStatsComponent;", "create", "(Landroidx/fragment/app/Fragment;Landroid/content/res/Resources;Lcom/avito/android/user_stats/di/UserStatsDependencies;)Lcom/avito/android/user_stats/di/UserStatsComponent;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        UserStatsComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Resources resources, @NotNull UserStatsDependencies userStatsDependencies);
    }

    void inject(@NotNull UserStatsFragment userStatsFragment);
}
