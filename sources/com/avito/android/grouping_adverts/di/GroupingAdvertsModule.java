package com.avito.android.grouping_adverts.di;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.async_phone.AsyncPhoneAuthRouter;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.HeaderModule;
import com.avito.android.di.module.RichSnippetsModule;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsInteractor;
import com.avito.android.grouping_adverts.GroupingAdvertsInteractorImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsItemsFilter;
import com.avito.android.grouping_adverts.GroupingAdvertsItemsFilterImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenter;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenterImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsResourcesProvider;
import com.avito.android.grouping_adverts.GroupingAdvertsResourcesProviderImpl;
import com.avito.android.home.appending_item.loader.AppendingLoaderItemBlueprint;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.header.HeaderBlueprint;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemBlueprint;
import com.avito.android.serp.analytics.SerpAnalyticsInteractor;
import com.avito.android.serp.analytics.SerpAnalyticsInteractorImpl;
import com.avito.android.ui.adapter.AppendingHandler;
import com.avito.android.ui.adapter.GridLayoutNoLoaderAppendingHandler;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010(\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/grouping_adverts/di/GroupingAdvertsModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$grouping_adverts_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/serp/adapter/header/HeaderBlueprint;", "headerBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichSmallItemBlueprint;", "advertRichItemBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;", "loaderItemBluePrint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;", "advertXlRichBlueprint", "provideItemBinder$grouping_adverts_release", "(Lcom/avito/android/serp/adapter/header/HeaderBlueprint;Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichSmallItemBlueprint;Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/home/appending_item/loader/AppendingLoaderItemBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "groupingAdvertsPresenter", "Lcom/avito/android/ui/adapter/AppendingHandler;", "provideAppendingHandler$grouping_adverts_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;)Lcom/avito/android/ui/adapter/AppendingHandler;", "provideAppendingHandler", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "provideSerpAnalyticsInteractor$grouping_adverts_release", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/Features;)Lcom/avito/android/serp/analytics/SerpAnalyticsInteractor;", "provideSerpAnalyticsInteractor", "<init>", "()V", "Dependencies", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {HeaderModule.class, PhoneNumberFormatterModule.class, RichSnippetsModule.class, Dependencies.class})
public final class GroupingAdvertsModule {
    @NotNull
    public static final GroupingAdvertsModule INSTANCE = new GroupingAdvertsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0007H'¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H'¢\u0006\u0004\b,\u0010-J\u0017\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.H'¢\u0006\u0004\b1\u00102J\u001d\u00107\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00104\u001a\u000203H'¢\u0006\u0004\b7\u00108J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H'¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/avito/android/grouping_adverts/di/GroupingAdvertsModule$Dependencies;", "", "Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;", "handler", "Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "bindClickStreamLinkHandler", "(Lcom/avito/android/deep_linking/SimpleClickStreamLinkHandler;)Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "presenter", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "bindAdvertRichItemListener", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;)Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenterImpl;", "bindGroupingAdvertsPresenter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenterImpl;)Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractorImpl;", "interactor", "Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "bindGroupingAdvertsInteractor", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractorImpl;)Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "bindAdvertItemListener", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;", "bindGroupingAdvertsResourcesProvider", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProviderImpl;)Lcom/avito/android/grouping_adverts/GroupingAdvertsResourcesProvider;", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "groupingAdvertPresenter", "Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "bindAsyncPhoneAuthRouter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsPresenter;)Lcom/avito/android/async_phone/AsyncPhoneAuthRouter;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilterImpl;", "filter", "Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;", "bindGroupingItemsFilter", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilterImpl;)Lcom/avito/android/grouping_adverts/GroupingAdvertsItemsFilter;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "bindFavoriteConverterResourceProvider", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "Lcom/avito/android/util/AdvertPriceFormatter;", "priceFormatter", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "bindAdvertPriceFormatter", "(Lcom/avito/android/util/AdvertPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;", "convert", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "bindFavoriteAdvertItemConvert", "(Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;)Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        AdvertItemListener bindAdvertItemListener(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter);

        @Binds
        @NotNull
        @PerFragment
        Formatter<AdvertPrice> bindAdvertPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);

        @PerFragment
        @Binds
        @NotNull
        AdvertRichItemListener bindAdvertRichItemListener(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter);

        @PerFragment
        @Binds
        @NotNull
        AsyncPhoneAuthRouter bindAsyncPhoneAuthRouter(@NotNull GroupingAdvertsPresenter groupingAdvertsPresenter);

        @PerFragment
        @Binds
        @NotNull
        ClickStreamLinkHandler bindClickStreamLinkHandler(@NotNull SimpleClickStreamLinkHandler simpleClickStreamLinkHandler);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemConverter bindFavoriteAdvertItemConvert(@NotNull FavoriteAdvertItemConverterImpl favoriteAdvertItemConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        FavoriteAdvertItemConverterResourceProvider bindFavoriteConverterResourceProvider(@NotNull FavoriteAdvertItemConverterResourceProviderImpl favoriteAdvertItemConverterResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupingAdvertsInteractor bindGroupingAdvertsInteractor(@NotNull GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupingAdvertsPresenter bindGroupingAdvertsPresenter(@NotNull GroupingAdvertsPresenterImpl groupingAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupingAdvertsResourcesProvider bindGroupingAdvertsResourcesProvider(@NotNull GroupingAdvertsResourcesProviderImpl groupingAdvertsResourcesProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupingAdvertsItemsFilter bindGroupingItemsFilter(@NotNull GroupingAdvertsItemsFilterImpl groupingAdvertsItemsFilterImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$grouping_adverts_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AppendingHandler provideAppendingHandler$grouping_adverts_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GroupingAdvertsPresenter groupingAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(groupingAdvertsPresenter, "groupingAdvertsPresenter");
        GridLayoutNoLoaderAppendingHandler gridLayoutNoLoaderAppendingHandler = new GridLayoutNoLoaderAppendingHandler(spannedGridPositionProvider, false, 2, null);
        gridLayoutNoLoaderAppendingHandler.setAppendingListener(groupingAdvertsPresenter);
        return gridLayoutNoLoaderAppendingHandler;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$grouping_adverts_release(@NotNull HeaderBlueprint headerBlueprint, @NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull AdvertRichSmallItemBlueprint advertRichSmallItemBlueprint, @NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AppendingLoaderItemBlueprint appendingLoaderItemBlueprint, @NotNull AdvertXlRichItemBlueprint advertXlRichItemBlueprint) {
        Intrinsics.checkNotNullParameter(headerBlueprint, "headerBlueprint");
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(advertRichSmallItemBlueprint, "advertRichItemBlueprint");
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(appendingLoaderItemBlueprint, "loaderItemBluePrint");
        Intrinsics.checkNotNullParameter(advertXlRichItemBlueprint, "advertXlRichBlueprint");
        return new ItemBinder.Builder().registerItem(advertRichSmallItemBlueprint).registerItem(advertItemListBlueprint).registerItem(headerBlueprint).registerItem(advertItemGridBlueprint).registerItem(appendingLoaderItemBlueprint).registerItem(advertXlRichItemBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SerpAnalyticsInteractor provideSerpAnalyticsInteractor$grouping_adverts_release(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SerpAnalyticsInteractorImpl(analytics, treeStateIdGenerator, null, null, features);
    }
}
