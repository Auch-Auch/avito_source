package com.avito.android.advert_stats.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert_stats.AdvertStatsRepository;
import com.avito.android.advert_stats.AdvertStatsRepositoryImpl;
import com.avito.android.advert_stats.AdvertStatsViewModel;
import com.avito.android.advert_stats.AdvertStatsViewModelFactory;
import com.avito.android.advert_stats.AdvertStatsViewModelImpl;
import com.avito.android.advert_stats.ExternalLinkRouter;
import com.avito.android.advert_stats.item.BarItemBlueprint;
import com.avito.android.advert_stats.item.BarItemPresenter;
import com.avito.android.advert_stats.item.OnBarItemClickListener;
import com.avito.android.advert_stats.item.PlotBlueprint;
import com.avito.android.advert_stats.item.PlotDimensionsProvider;
import com.avito.android.advert_stats.item.PlotDimensionsProviderImpl;
import com.avito.android.advert_stats.item.PlotItemPresenter;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.item.WeekItemBlueprint;
import com.avito.android.advert_stats.item.WeekPresenter;
import com.avito.android.advert_stats.item.details.StatDetailItemBlueprint;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerBlueprint;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenter;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerPresenterImpl;
import com.avito.android.advert_stats.item.hint.HintItemBlueprint;
import com.avito.android.advert_stats.item.period.PeriodItemBlueprint;
import com.avito.android.advert_stats.item.title.TitleItemBlueprint;
import com.avito.android.advert_stats.remote.AdvertStatsApi;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.analytics.di.BivrostStatisticsModule;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DayAndMonthDateFormatter;
import com.avito.android.util.DayOfWeekFormatter;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\b\u0001\u0001\u0001\u0001B\"\u0012\u0006\u0010y\u001a\u00020v\u0012\u0006\u0010}\u001a\u00020z\u0012\u0007\u0010\u0001\u001a\u00020~¢\u0006\u0006\b\u0001\u0010\u0001JO\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001e\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010%\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b#\u0010$J?\u00104\u001a\u00020\u00192\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u0017\u0010:\u001a\u0002072\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109J\u000f\u0010>\u001a\u00020;H\u0001¢\u0006\u0004\b<\u0010=J'\u0010C\u001a\u00020\u00042\u0006\u0010@\u001a\u00020?2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0007¢\u0006\u0004\bC\u0010DJ+\u0010K\u001a\u00020H2\u0006\u0010F\u001a\u00020E2\b\b\u0001\u0010G\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\bI\u0010JJ\u0017\u0010P\u001a\u00020E2\u0006\u0010M\u001a\u00020LH\u0001¢\u0006\u0004\bN\u0010OJ\u000f\u0010T\u001a\u00020QH\u0001¢\u0006\u0004\bR\u0010SJ3\u0010Z\u001a\u00020&2\u0006\u0010F\u001a\u00020U2\b\b\u0001\u0010G\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u00192\u0006\u0010W\u001a\u00020VH\u0001¢\u0006\u0004\bX\u0010YJ\u0017\u0010^\u001a\u00020\u00192\u0006\u0010[\u001a\u00020HH\u0001¢\u0006\u0004\b\\\u0010]J\u0019\u0010`\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b_\u0010\u001dJ\u0017\u0010c\u001a\u00020!2\u0006\u0010F\u001a\u00020LH\u0001¢\u0006\u0004\ba\u0010bJ\u001f\u0010h\u001a\u00020L2\u0006\u0010W\u001a\u00020V2\u0006\u0010e\u001a\u00020dH\u0001¢\u0006\u0004\bf\u0010gJ\u0017\u0010l\u001a\u00020d2\u0006\u0010i\u001a\u00020UH\u0001¢\u0006\u0004\bj\u0010kJ\u0017\u0010q\u001a\u00020V2\u0006\u0010n\u001a\u00020mH\u0001¢\u0006\u0004\bo\u0010pJ\u000f\u0010u\u001a\u00020rH\u0001¢\u0006\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "interactor", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "statItemsConverter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "advertStatsTracker", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "bivrostTutorialSessionStorage", "Lcom/avito/android/advert_stats/AdvertStatsViewModelFactory;", "providerViewModuleFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/advert_stats/AdvertStatsRepository;Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;)Lcom/avito/android/advert_stats/AdvertStatsViewModelFactory;", "factory", "Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "provideViewodel", "(Lcom/avito/android/advert_stats/AdvertStatsViewModelFactory;)Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$advert_stats_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideChartSectionAdapterPresenter$advert_stats_release", "provideChartSectionAdapterPresenter", "Lcom/avito/android/advert_stats/item/BarItemBlueprint;", "barItemBlueprint", "provideChartSectionItemBinder$advert_stats_release", "(Lcom/avito/android/advert_stats/item/BarItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideChartSectionItemBinder", "Lcom/avito/android/advert_stats/item/PlotBlueprint;", "plotBlueprint", "Lcom/avito/android/advert_stats/item/title/TitleItemBlueprint;", "titleItemBlueprint", "Lcom/avito/android/advert_stats/item/period/PeriodItemBlueprint;", "periodItemBlueprint", "Lcom/avito/android/advert_stats/item/details/StatDetailItemBlueprint;", "detailsItemBlueprint", "Lcom/avito/android/advert_stats/item/hint/HintItemBlueprint;", "hintItemBlueprint", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerBlueprint;", "newStatisticsBlueprint", "provideStatsItemBinder$advert_stats_release", "(Lcom/avito/android/advert_stats/item/PlotBlueprint;Lcom/avito/android/advert_stats/item/title/TitleItemBlueprint;Lcom/avito/android/advert_stats/item/period/PeriodItemBlueprint;Lcom/avito/android/advert_stats/item/details/StatDetailItemBlueprint;Lcom/avito/android/advert_stats/item/hint/HintItemBlueprint;Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideStatsItemBinder", "Ljava/util/Locale;", "locale", "Lcom/avito/android/util/DayOfWeekFormatter;", "provideWeekDayFormatter$advert_stats_release", "(Ljava/util/Locale;)Lcom/avito/android/util/DayOfWeekFormatter;", "provideWeekDayFormatter", "Lcom/avito/android/util/DayAndMonthDateFormatter;", "provideDayAndMonthDateformatter$advert_stats_release", "()Lcom/avito/android/util/DayAndMonthDateFormatter;", "provideDayAndMonthDateformatter", "Lcom/avito/android/advert_stats/remote/AdvertStatsApi;", "api", "Lcom/avito/android/Features;", "features", "providerInteractor", "(Lcom/avito/android/advert_stats/remote/AdvertStatsApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;)Lcom/avito/android/advert_stats/AdvertStatsRepository;", "Lcom/avito/android/advert_stats/item/WeekPresenter;", "presenter", "adapterPresenter", "Lcom/avito/android/advert_stats/item/WeekItemBlueprint;", "provideWeekItemBlueprint$advert_stats_release", "(Lcom/avito/android/advert_stats/item/WeekPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/advert_stats/item/WeekItemBlueprint;", "provideWeekItemBlueprint", "Lcom/avito/android/advert_stats/item/BarItemPresenter;", "barItemPresenter", "provideWeekPresenter$advert_stats_release", "(Lcom/avito/android/advert_stats/item/BarItemPresenter;)Lcom/avito/android/advert_stats/item/WeekPresenter;", "provideWeekPresenter", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "provideNewStatisticsPresenter$advert_stats_release", "()Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerPresenter;", "provideNewStatisticsPresenter", "Lcom/avito/android/advert_stats/item/PlotItemPresenter;", "Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "plotDimensionsProvider", "providePlotItemBlueprint$advert_stats_release", "(Lcom/avito/android/advert_stats/item/PlotItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;)Lcom/avito/android/advert_stats/item/PlotBlueprint;", "providePlotItemBlueprint", "weekItemBlueprint", "provideWeekItemBinder$advert_stats_release", "(Lcom/avito/android/advert_stats/item/WeekItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideWeekItemBinder", "provideWeekAdapterPresenter$advert_stats_release", "provideWeekAdapterPresenter", "provideBarItemBlueprint$advert_stats_release", "(Lcom/avito/android/advert_stats/item/BarItemPresenter;)Lcom/avito/android/advert_stats/item/BarItemBlueprint;", "provideBarItemBlueprint", "Lcom/avito/android/advert_stats/item/OnBarItemClickListener;", "barItemClickListener", "provideBarItemPresenter$advert_stats_release", "(Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;Lcom/avito/android/advert_stats/item/OnBarItemClickListener;)Lcom/avito/android/advert_stats/item/BarItemPresenter;", "provideBarItemPresenter", "plotItemPresenter", "provideOnBarItemClickListener$advert_stats_release", "(Lcom/avito/android/advert_stats/item/PlotItemPresenter;)Lcom/avito/android/advert_stats/item/OnBarItemClickListener;", "provideOnBarItemClickListener", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "providePlotDimensProvider$advert_stats_release", "(Lcom/avito/android/util/DeviceMetrics;)Lcom/avito/android/advert_stats/item/PlotDimensionsProvider;", "providePlotDimensProvider", "Landroid/content/res/Resources;", "provideResources$advert_stats_release", "()Landroid/content/res/Resources;", "provideResources", "Landroidx/appcompat/app/AppCompatActivity;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatActivity;", "activity", "Lcom/avito/android/advert_stats/ExternalLinkRouter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_stats/ExternalLinkRouter;", "router", "", "c", "Ljava/lang/String;", "itemId", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/avito/android/advert_stats/ExternalLinkRouter;Ljava/lang/String;)V", "ChartSectionAdapterPresenter", "ChartSectionItemBinder", "WeekItemBinder", "WeekItemPresenter", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertStatsListModule.class, StatsAnalyticsModule.class, BivrostStatisticsModule.class})
public final class AdvertStatsModule {
    public final AppCompatActivity a;
    public final ExternalLinkRouter b;
    public final String c;

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsModule$ChartSectionAdapterPresenter;", "", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ChartSectionAdapterPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsModule$ChartSectionItemBinder;", "", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ChartSectionItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsModule$WeekItemBinder;", "", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface WeekItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_stats/di/AdvertStatsModule$WeekItemPresenter;", "", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface WeekItemPresenter {
    }

    public AdvertStatsModule(@NotNull AppCompatActivity appCompatActivity, @NotNull ExternalLinkRouter externalLinkRouter, @NotNull String str) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Intrinsics.checkNotNullParameter(externalLinkRouter, "router");
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = appCompatActivity;
        this.b = externalLinkRouter;
        this.c = str;
    }

    @Provides
    @Named(AdvertStatsModuleKt.STATS_ADAPTER_PRESENTER)
    @NotNull
    @PerActivity
    public final AdapterPresenter provideAdapterPresenter$advert_stats_release(@Named("STATS_ITEM_BINDER") @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final BarItemBlueprint provideBarItemBlueprint$advert_stats_release(@NotNull BarItemPresenter barItemPresenter) {
        Intrinsics.checkNotNullParameter(barItemPresenter, "presenter");
        return new BarItemBlueprint(barItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final BarItemPresenter provideBarItemPresenter$advert_stats_release(@NotNull PlotDimensionsProvider plotDimensionsProvider, @NotNull OnBarItemClickListener onBarItemClickListener) {
        Intrinsics.checkNotNullParameter(plotDimensionsProvider, "plotDimensionsProvider");
        Intrinsics.checkNotNullParameter(onBarItemClickListener, "barItemClickListener");
        return new BarItemPresenter(plotDimensionsProvider, onBarItemClickListener);
    }

    @Provides
    @NotNull
    @ChartSectionAdapterPresenter
    @PerActivity
    public final AdapterPresenter provideChartSectionAdapterPresenter$advert_stats_release(@ChartSectionItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @ChartSectionItemBinder
    @NotNull
    @PerActivity
    public final ItemBinder provideChartSectionItemBinder$advert_stats_release(@NotNull BarItemBlueprint barItemBlueprint) {
        Intrinsics.checkNotNullParameter(barItemBlueprint, "barItemBlueprint");
        return new ItemBinder.Builder().registerItem(barItemBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final DayAndMonthDateFormatter provideDayAndMonthDateformatter$advert_stats_release() {
        return new DayAndMonthDateFormatter();
    }

    @Provides
    @PerActivity
    @NotNull
    public final NewStatisticsBannerPresenter provideNewStatisticsPresenter$advert_stats_release() {
        return new NewStatisticsBannerPresenterImpl(this.b);
    }

    @Provides
    @PerActivity
    @NotNull
    public final OnBarItemClickListener provideOnBarItemClickListener$advert_stats_release(@NotNull PlotItemPresenter plotItemPresenter) {
        Intrinsics.checkNotNullParameter(plotItemPresenter, "plotItemPresenter");
        return plotItemPresenter;
    }

    @Provides
    @PerActivity
    @NotNull
    public final PlotDimensionsProvider providePlotDimensProvider$advert_stats_release(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Resources resources = this.a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return new PlotDimensionsProviderImpl(resources, deviceMetrics);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PlotBlueprint providePlotItemBlueprint$advert_stats_release(@NotNull PlotItemPresenter plotItemPresenter, @WeekItemPresenter @NotNull AdapterPresenter adapterPresenter, @WeekItemBinder @NotNull ItemBinder itemBinder, @NotNull PlotDimensionsProvider plotDimensionsProvider) {
        Intrinsics.checkNotNullParameter(plotItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(plotDimensionsProvider, "plotDimensionsProvider");
        return new PlotBlueprint(plotItemPresenter, adapterPresenter, itemBinder, plotDimensionsProvider);
    }

    @Provides
    @PerActivity
    @NotNull
    public final Resources provideResources$advert_stats_release() {
        Resources resources = this.a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return resources;
    }

    @Provides
    @Named(AdvertStatsModuleKt.STATS_ITEM_BINDER)
    @NotNull
    @PerActivity
    public final ItemBinder provideStatsItemBinder$advert_stats_release(@NotNull PlotBlueprint plotBlueprint, @NotNull TitleItemBlueprint titleItemBlueprint, @NotNull PeriodItemBlueprint periodItemBlueprint, @NotNull StatDetailItemBlueprint statDetailItemBlueprint, @NotNull HintItemBlueprint hintItemBlueprint, @NotNull NewStatisticsBannerBlueprint newStatisticsBannerBlueprint) {
        Intrinsics.checkNotNullParameter(plotBlueprint, "plotBlueprint");
        Intrinsics.checkNotNullParameter(titleItemBlueprint, "titleItemBlueprint");
        Intrinsics.checkNotNullParameter(periodItemBlueprint, "periodItemBlueprint");
        Intrinsics.checkNotNullParameter(statDetailItemBlueprint, "detailsItemBlueprint");
        Intrinsics.checkNotNullParameter(hintItemBlueprint, "hintItemBlueprint");
        Intrinsics.checkNotNullParameter(newStatisticsBannerBlueprint, "newStatisticsBlueprint");
        return new ItemBinder.Builder().registerItem(plotBlueprint).registerItem(titleItemBlueprint).registerItem(statDetailItemBlueprint).registerItem(periodItemBlueprint).registerItem(hintItemBlueprint).registerItem(newStatisticsBannerBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertStatsViewModel provideViewodel(@NotNull AdvertStatsViewModelFactory advertStatsViewModelFactory) {
        Intrinsics.checkNotNullParameter(advertStatsViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.a, advertStatsViewModelFactory).get(AdvertStatsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (AdvertStatsViewModel) viewModel;
    }

    @Provides
    @WeekItemPresenter
    @NotNull
    @PerActivity
    public final AdapterPresenter provideWeekAdapterPresenter$advert_stats_release(@WeekItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DayOfWeekFormatter provideWeekDayFormatter$advert_stats_release(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new DayOfWeekFormatter(locale);
    }

    @Provides
    @NotNull
    @WeekItemBinder
    @PerActivity
    public final ItemBinder provideWeekItemBinder$advert_stats_release(@NotNull WeekItemBlueprint weekItemBlueprint) {
        Intrinsics.checkNotNullParameter(weekItemBlueprint, "weekItemBlueprint");
        return new ItemBinder.Builder().registerItem(weekItemBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final WeekItemBlueprint provideWeekItemBlueprint$advert_stats_release(@NotNull WeekPresenter weekPresenter, @ChartSectionAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @ChartSectionItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(weekPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new WeekItemBlueprint(weekPresenter, adapterPresenter, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final WeekPresenter provideWeekPresenter$advert_stats_release(@NotNull BarItemPresenter barItemPresenter) {
        Intrinsics.checkNotNullParameter(barItemPresenter, "barItemPresenter");
        return new WeekPresenter();
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertStatsRepository providerInteractor(@NotNull AdvertStatsApi advertStatsApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertStatsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AdvertStatsRepositoryImpl(advertStatsApi, schedulersFactory, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertStatsViewModelFactory providerViewModuleFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull AdvertStatsRepository advertStatsRepository, @NotNull StatisticsToItemsConverter statisticsToItemsConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Analytics analytics, @NotNull AdvertStatsTracker advertStatsTracker, @NotNull BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(advertStatsRepository, "interactor");
        Intrinsics.checkNotNullParameter(statisticsToItemsConverter, "statItemsConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertStatsTracker, "advertStatsTracker");
        Intrinsics.checkNotNullParameter(bivrostTutorialSessionStorage, "bivrostTutorialSessionStorage");
        return new AdvertStatsViewModelFactory(this.c, schedulersFactory, advertStatsRepository, statisticsToItemsConverter, deepLinkIntentFactory, activityIntentFactory, analytics, advertStatsTracker, bivrostTutorialSessionStorage);
    }
}
