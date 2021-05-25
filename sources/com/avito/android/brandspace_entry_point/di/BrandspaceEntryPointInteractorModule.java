package com.avito.android.brandspace_entry_point.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractorImpl;
import com.avito.android.di.PerFragment;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/brandspace_entry_point/di/BrandspaceEntryPointInteractorModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;", "provideBrandspaceEntryPointAnalyticsInteractor", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)Lcom/avito/android/brandspace_entry_point/BrandspaceEntryPointAnalyticsInteractor;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BrandspaceEntryPointInteractorModule {
    @Provides
    @PerFragment
    @NotNull
    public final BrandspaceEntryPointAnalyticsInteractor provideBrandspaceEntryPointAnalyticsInteractor(@NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        return new BrandspaceEntryPointAnalyticsInteractorImpl(analytics, features);
    }
}
