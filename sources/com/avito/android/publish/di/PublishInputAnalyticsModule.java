package com.avito.android.publish.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTrackerImpl;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005¢\u0006\u0002\b\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/di/PublishInputAnalyticsModule;", "", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresentersSet", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "providePublishInputsAnalyticTracker", "(Lcom/avito/android/publish/analytics/PublishEventTracker;Ljava/util/Set;)Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishInputAnalyticsModule {
    @Provides
    @NotNull
    @PerFragment
    public final PublishInputsAnalyticTracker providePublishInputsAnalyticTracker(@NotNull PublishEventTracker publishEventTracker, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        return new PublishInputsAnalyticTrackerImpl(publishEventTracker, set);
    }
}
