package com.avito.android.user_stats.di;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.user_stats.UserStatsInteractor;
import com.avito.android.user_stats.UserStatsInteractorImpl;
import com.avito.android.user_stats.UserStatsResourcesProvider;
import com.avito.android.user_stats.UserStatsResourcesProviderImpl;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.user_stats.UserStatsViewModelFactory;
import com.avito.android.user_stats.tab.ActiveMonthIndexHolder;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.android.user_stats.tab.UserStatsTabItemConverter;
import com.avito.android.user_stats.tab.UserStatsTabItemConverterImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsModule;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/user_stats/UserStatsViewModelFactory;", "factory", "Lcom/avito/android/user_stats/UserStatsViewModel;", "provideUserStats", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/user_stats/UserStatsViewModelFactory;)Lcom/avito/android/user_stats/UserStatsViewModel;", "<init>", "()V", "Declarations", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, UserStatsStorageModule.class})
public final class UserStatsModule {
    @NotNull
    public static final UserStatsModule INSTANCE = new UserStatsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsModule$Declarations;", "", "Lcom/avito/android/user_stats/UserStatsInteractorImpl;", "impl", "Lcom/avito/android/user_stats/UserStatsInteractor;", "bindInteractor", "(Lcom/avito/android/user_stats/UserStatsInteractorImpl;)Lcom/avito/android/user_stats/UserStatsInteractor;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelStoreOwner;", "bindViewModelStoreOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "bindSavedStateRegistryOwner", "(Landroidx/fragment/app/Fragment;)Landroidx/savedstate/SavedStateRegistryOwner;", "Lcom/avito/android/user_stats/UserStatsResourcesProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "bindResourcesProvider", "(Lcom/avito/android/user_stats/UserStatsResourcesProviderImpl;)Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverterImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "bindUserStatsTabItemConverter", "(Lcom/avito/android/user_stats/tab/UserStatsTabItemConverterImpl;)Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "Lcom/avito/android/user_stats/UserStatsViewModel;", "viewModel", "Lcom/avito/android/user_stats/tab/UserStatsProvider;", "bindUserStatsProvider", "(Lcom/avito/android/user_stats/UserStatsViewModel;)Lcom/avito/android/user_stats/tab/UserStatsProvider;", "Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "bindActiveMonthIndexHolder", "(Lcom/avito/android/user_stats/UserStatsViewModel;)Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ActiveMonthIndexHolder bindActiveMonthIndexHolder(@NotNull UserStatsViewModel userStatsViewModel);

        @PerFragment
        @Binds
        @NotNull
        UserStatsInteractor bindInteractor(@NotNull UserStatsInteractorImpl userStatsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        UserStatsResourcesProvider bindResourcesProvider(@NotNull UserStatsResourcesProviderImpl userStatsResourcesProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        SavedStateRegistryOwner bindSavedStateRegistryOwner(@NotNull Fragment fragment);

        @PerFragment
        @Binds
        @NotNull
        UserStatsProvider bindUserStatsProvider(@NotNull UserStatsViewModel userStatsViewModel);

        @PerFragment
        @Binds
        @NotNull
        UserStatsTabItemConverter bindUserStatsTabItemConverter(@NotNull UserStatsTabItemConverterImpl userStatsTabItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelStoreOwner bindViewModelStoreOwner(@NotNull Fragment fragment);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserStatsViewModel provideUserStats(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull UserStatsViewModelFactory userStatsViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(userStatsViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, userStatsViewModelFactory).get(UserStatsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…atsViewModel::class.java)");
        return (UserStatsViewModel) viewModel;
    }
}
