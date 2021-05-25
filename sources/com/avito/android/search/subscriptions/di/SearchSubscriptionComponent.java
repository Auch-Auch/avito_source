package com.avito.android.search.subscriptions.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.di.PerFragment;
import com.avito.android.saved_searches.di.SavedSearchState;
import com.avito.android.search.subscriptions.SearchSubscriptionFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent;", "", "Lcom/avito/android/search/subscriptions/SearchSubscriptionFragment;", "activity", "", "inject", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionFragment;)V", "Builder", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SearchSubscriptionDependencies.class}, modules = {SearchSubscriptionModule.class, SearchSubscriptionsTrackerModule.class})
@PerFragment
public interface SearchSubscriptionComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "", "Lcom/avito/android/search/subscriptions/di/SearchSubscriptionDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/search/subscriptions/di/SearchSubscriptionDependencies;)Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "Landroid/content/Context;", "context", "withContext", "(Landroid/content/Context;)Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "Landroid/os/Bundle;", "presenterState", "withPresenterState", "(Landroid/os/Bundle;)Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withSavedSearchState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent$Builder;", "Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent;", "build", "()Lcom/avito/android/search/subscriptions/di/SearchSubscriptionComponent;", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SearchSubscriptionComponent build();

        @NotNull
        Builder dependentOn(@NotNull SearchSubscriptionDependencies searchSubscriptionDependencies);

        @BindsInstance
        @NotNull
        Builder withContext(@NotNull Context context);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withSavedSearchState(@SavedSearchState @NotNull Kundle kundle);
    }

    void inject(@NotNull SearchSubscriptionFragment searchSubscriptionFragment);
}
