package com.avito.android.user_stats;

import a2.g.r.g;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_stats.tab.UserStatsTabItemConverter;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b*\u0010+J9\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "create", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "h", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "tabItemConverter", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", g.a, "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "resourcesProvider", "Lcom/avito/android/user_stats/UserStatsInteractor;", "d", "Lcom/avito/android/user_stats/UserStatsInteractor;", "interactor", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "f", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "j", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "tracker", "Lcom/avito/android/analytics/Analytics;", "i", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/savedstate/SavedStateRegistryOwner;", UrlParams.OWNER, "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Lcom/avito/android/user_stats/UserStatsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/user_stats/UserStatsResourcesProvider;Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/user_stats/tracker/UserStatsTracker;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsViewModelFactory extends AbstractSavedStateViewModelFactory {
    public final UserStatsInteractor d;
    public final SchedulersFactory3 e;
    public final TypedErrorThrowableConverter f;
    public final UserStatsResourcesProvider g;
    public final UserStatsTabItemConverter h;
    public final Analytics i;
    public final UserStatsTracker j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public UserStatsViewModelFactory(@NotNull SavedStateRegistryOwner savedStateRegistryOwner, @NotNull UserStatsInteractor userStatsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull UserStatsResourcesProvider userStatsResourcesProvider, @NotNull UserStatsTabItemConverter userStatsTabItemConverter, @NotNull Analytics analytics, @NotNull UserStatsTracker userStatsTracker) {
        super(savedStateRegistryOwner, null);
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(userStatsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(userStatsResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(userStatsTabItemConverter, "tabItemConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(userStatsTracker, "tracker");
        this.d = userStatsInteractor;
        this.e = schedulersFactory3;
        this.f = typedErrorThrowableConverter;
        this.g = userStatsResourcesProvider;
        this.h = userStatsTabItemConverter;
        this.i = analytics;
        this.j = userStatsTracker;
    }

    @Override // androidx.lifecycle.AbstractSavedStateViewModelFactory
    public <T extends ViewModel> T create(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "stateHandle");
        if (cls.isAssignableFrom(UserStatsViewModel.class)) {
            return new UserStatsViewModel(savedStateHandle, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
