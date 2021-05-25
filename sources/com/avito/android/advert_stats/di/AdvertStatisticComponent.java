package com.avito.android.advert_stats.di;

import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.di.PerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatisticComponent;", "", "Lcom/avito/android/advert_stats/AdvertStatsActivity;", "activity", "", "inject", "(Lcom/avito/android/advert_stats/AdvertStatsActivity;)V", "Builder", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AdvertStatsDependencies.class}, modules = {AdvertStatsModule.class})
@PerActivity
public interface AdvertStatisticComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatisticComponent$Builder;", "", "Lcom/avito/android/advert_stats/di/AdvertStatsDependencies;", "dependencies", "(Lcom/avito/android/advert_stats/di/AdvertStatsDependencies;)Lcom/avito/android/advert_stats/di/AdvertStatisticComponent$Builder;", "Lcom/avito/android/advert_stats/di/AdvertStatsModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/advert_stats/di/AdvertStatsModule;)Lcom/avito/android/advert_stats/di/AdvertStatisticComponent$Builder;", "Lcom/avito/android/advert_stats/di/AdvertStatisticComponent;", "build", "()Lcom/avito/android/advert_stats/di/AdvertStatisticComponent;", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AdvertStatisticComponent build();

        @NotNull
        Builder dependencies(@NotNull AdvertStatsDependencies advertStatsDependencies);

        @NotNull
        Builder module(@NotNull AdvertStatsModule advertStatsModule);
    }

    void inject(@NotNull AdvertStatsActivity advertStatsActivity);
}
