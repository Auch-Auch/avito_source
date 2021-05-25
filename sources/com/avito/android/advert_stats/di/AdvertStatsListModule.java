package com.avito.android.advert_stats.di;

import com.avito.android.advert_stats.item.PlotItemPresenter;
import com.avito.android.advert_stats.item.PlotItemPresenterImpl;
import com.avito.android.advert_stats.item.StatisticDatesFormatter;
import com.avito.android.advert_stats.item.StatisticDatesFormatterImpl;
import com.avito.android.advert_stats.item.StatisticStringResourceProvider;
import com.avito.android.advert_stats.item.StatisticStringResourceProviderImpl;
import com.avito.android.advert_stats.item.StatisticsIconProvider;
import com.avito.android.advert_stats.item.StatisticsIconProviderImpl;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.item.StatisticsToItemsConverterImpl;
import com.avito.android.advert_stats.item.details.StatDetailItem;
import com.avito.android.advert_stats.item.details.StatDetailItemBlueprint;
import com.avito.android.advert_stats.item.details.StatDetailItemPresenter;
import com.avito.android.advert_stats.item.details.StatDetailItemView;
import com.avito.android.advert_stats.item.hint.HintItem;
import com.avito.android.advert_stats.item.hint.HintItemPresenter;
import com.avito.android.advert_stats.item.hint.HintItemPresenterImpl;
import com.avito.android.advert_stats.item.hint.HintItemView;
import com.avito.android.advert_stats.item.period.PeriodItem;
import com.avito.android.advert_stats.item.period.PeriodItemBlueprint;
import com.avito.android.advert_stats.item.period.PeriodItemPresenter;
import com.avito.android.advert_stats.item.period.PeriodItemView;
import com.avito.android.advert_stats.item.title.TitleItem;
import com.avito.android.advert_stats.item.title.TitleItemBlueprint;
import com.avito.android.advert_stats.item.title.TitleItemPresenter;
import com.avito.android.advert_stats.item.title.TitleItemView;
import com.avito.android.di.PerActivity;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b#\u0010$J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H'¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H'¢\u0006\u0004\b-\u0010.J#\u00103\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00042\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u0002052\u0006\u0010\n\u001a\u000205H'¢\u0006\u0004\b6\u00107J#\u0010;\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:0\u00042\u0006\u00100\u001a\u000208H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u0002082\u0006\u0010>\u001a\u00020=H'¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsListModule;", "", "Lcom/avito/android/advert_stats/item/title/TitleItemPresenter;", "titlePresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/title/TitleItemView;", "Lcom/avito/android/advert_stats/item/title/TitleItem;", "provideTitleItemPresenter", "(Lcom/avito/android/advert_stats/item/title/TitleItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/title/TitleItemBlueprint;", "itemBlueprint", "provideTitleBlueprint", "(Lcom/avito/android/advert_stats/item/title/TitleItemBlueprint;)Lcom/avito/android/advert_stats/item/title/TitleItemBlueprint;", "Lcom/avito/android/advert_stats/item/details/StatDetailItemPresenter;", "statDetailItemPresenter", "Lcom/avito/android/advert_stats/item/details/StatDetailItemView;", "Lcom/avito/android/advert_stats/item/details/StatDetailItem;", "provideDetailsItemPresenter", "(Lcom/avito/android/advert_stats/item/details/StatDetailItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/details/StatDetailItemBlueprint;", "blueprint", "provideDetailsItemBlueprint", "(Lcom/avito/android/advert_stats/item/details/StatDetailItemBlueprint;)Lcom/avito/android/advert_stats/item/details/StatDetailItemBlueprint;", "Lcom/avito/android/advert_stats/item/StatisticsIconProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/advert_stats/item/StatisticsIconProvider;", "provideStatisticIconProvider", "(Lcom/avito/android/advert_stats/item/StatisticsIconProviderImpl;)Lcom/avito/android/advert_stats/item/StatisticsIconProvider;", "Lcom/avito/android/advert_stats/item/StatisticStringResourceProviderImpl;", "Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "provideStatisticStringResourceProvider", "(Lcom/avito/android/advert_stats/item/StatisticStringResourceProviderImpl;)Lcom/avito/android/advert_stats/item/StatisticStringResourceProvider;", "Lcom/avito/android/advert_stats/item/StatisticDatesFormatterImpl;", "formatter", "Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "provideStatisticDatesFormatter", "(Lcom/avito/android/advert_stats/item/StatisticDatesFormatterImpl;)Lcom/avito/android/advert_stats/item/StatisticDatesFormatter;", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverterImpl;", "converterImpl", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "provideStatsConverter", "(Lcom/avito/android/advert_stats/item/StatisticsToItemsConverterImpl;)Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "Lcom/avito/android/advert_stats/item/PlotItemPresenterImpl;", "plotItemPresenter", "Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "providePlotItemPresenter", "(Lcom/avito/android/advert_stats/item/PlotItemPresenterImpl;)Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "Lcom/avito/android/advert_stats/item/period/PeriodItemPresenter;", "presenter", "Lcom/avito/android/advert_stats/item/period/PeriodItemView;", "Lcom/avito/android/advert_stats/item/period/PeriodItem;", "providePeriodItemPresenter", "(Lcom/avito/android/advert_stats/item/period/PeriodItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/period/PeriodItemBlueprint;", "providePeriodBlueprint", "(Lcom/avito/android/advert_stats/item/period/PeriodItemBlueprint;)Lcom/avito/android/advert_stats/item/period/PeriodItemBlueprint;", "Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;", "Lcom/avito/android/advert_stats/item/hint/HintItemView;", "Lcom/avito/android/advert_stats/item/hint/HintItem;", "provideHintItemBlueprint", "(Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/hint/HintItemPresenterImpl;", "hintItemPresenterImpl", "provideHintItemPresenter", "(Lcom/avito/android/advert_stats/item/hint/HintItemPresenterImpl;)Lcom/avito/android/advert_stats/item/hint/HintItemPresenter;", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertStatsListModule {
    @Binds
    @IntoSet
    @NotNull
    @PerActivity
    StatDetailItemBlueprint provideDetailsItemBlueprint(@NotNull StatDetailItemBlueprint statDetailItemBlueprint);

    @Binds
    @NotNull
    @PerActivity
    ItemPresenter<StatDetailItemView, StatDetailItem> provideDetailsItemPresenter(@NotNull StatDetailItemPresenter statDetailItemPresenter);

    @Binds
    @IntoSet
    @NotNull
    @PerActivity
    ItemPresenter<HintItemView, HintItem> provideHintItemBlueprint(@NotNull HintItemPresenter hintItemPresenter);

    @PerActivity
    @Binds
    @NotNull
    HintItemPresenter provideHintItemPresenter(@NotNull HintItemPresenterImpl hintItemPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    @PerActivity
    PeriodItemBlueprint providePeriodBlueprint(@NotNull PeriodItemBlueprint periodItemBlueprint);

    @Binds
    @NotNull
    @PerActivity
    ItemPresenter<PeriodItemView, PeriodItem> providePeriodItemPresenter(@NotNull PeriodItemPresenter periodItemPresenter);

    @PerActivity
    @Binds
    @NotNull
    PlotItemPresenter providePlotItemPresenter(@NotNull PlotItemPresenterImpl plotItemPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    StatisticDatesFormatter provideStatisticDatesFormatter(@NotNull StatisticDatesFormatterImpl statisticDatesFormatterImpl);

    @PerActivity
    @Binds
    @NotNull
    StatisticsIconProvider provideStatisticIconProvider(@NotNull StatisticsIconProviderImpl statisticsIconProviderImpl);

    @PerActivity
    @Binds
    @NotNull
    StatisticStringResourceProvider provideStatisticStringResourceProvider(@NotNull StatisticStringResourceProviderImpl statisticStringResourceProviderImpl);

    @PerActivity
    @Binds
    @NotNull
    StatisticsToItemsConverter provideStatsConverter(@NotNull StatisticsToItemsConverterImpl statisticsToItemsConverterImpl);

    @Binds
    @IntoSet
    @NotNull
    @PerActivity
    TitleItemBlueprint provideTitleBlueprint(@NotNull TitleItemBlueprint titleItemBlueprint);

    @Binds
    @NotNull
    @PerActivity
    ItemPresenter<TitleItemView, TitleItem> provideTitleItemPresenter(@NotNull TitleItemPresenter titleItemPresenter);
}
