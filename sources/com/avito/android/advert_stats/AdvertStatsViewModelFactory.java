package com.avito.android.advert_stats;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b,\u0010-J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/advert_stats/AdvertStatsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/ActivityIntentFactory;", "f", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "h", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "advertStatsTracker", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "d", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "itemsConverter", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "c", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "interactor", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemId", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "i", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "bivrostSessionStorage", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/advert_stats/AdvertStatsRepository;Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final SchedulersFactory b;
    public final AdvertStatsRepository c;
    public final StatisticsToItemsConverter d;
    public final DeepLinkIntentFactory e;
    public final ActivityIntentFactory f;
    public final Analytics g;
    public final AdvertStatsTracker h;
    public final BivrostTutorialSessionStorage i;

    public AdvertStatsViewModelFactory(@NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull AdvertStatsRepository advertStatsRepository, @NotNull StatisticsToItemsConverter statisticsToItemsConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Analytics analytics, @NotNull AdvertStatsTracker advertStatsTracker, @NotNull BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(advertStatsRepository, "interactor");
        Intrinsics.checkNotNullParameter(statisticsToItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertStatsTracker, "advertStatsTracker");
        Intrinsics.checkNotNullParameter(bivrostTutorialSessionStorage, "bivrostSessionStorage");
        this.a = str;
        this.b = schedulersFactory;
        this.c = advertStatsRepository;
        this.d = statisticsToItemsConverter;
        this.e = deepLinkIntentFactory;
        this.f = activityIntentFactory;
        this.g = analytics;
        this.h = advertStatsTracker;
        this.i = bivrostTutorialSessionStorage;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(AdvertStatsViewModelImpl.class)) {
            return new AdvertStatsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
