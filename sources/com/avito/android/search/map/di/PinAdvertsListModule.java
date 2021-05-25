package com.avito.android.search.map.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.search.map.view.PinAdvertsListViewBinder;
import com.avito.android.search.map.view.PinAdvertsListViewBinderImpl;
import com.avito.android.search.map.view.adapter.AppendingRetryListener;
import com.avito.android.search.map.view.adapter.AppendingRetryListenerImpl;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.SellerPinItemBlueprint;
import com.avito.android.serp.adapter.SellerPinItemPresenter;
import com.avito.android.serp.adapter.SellerPinItemPresenterImpl;
import com.avito.android.serp.adapter.SerpItemAligner;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichSmallItemBlueprint;
import com.avito.android.ui_components.R;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010 \u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/search/map/di/PinAdvertsListModule;", "", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanSizeLookup$map_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanSizeLookup", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Landroid/content/res/Resources;", "resources", "provideSpanProvider$map_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "providePinAdvertsAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichSmallItemBlueprint;", "advertRichItemBlueprint", "Lcom/avito/android/serp/adapter/SellerPinItemBlueprint;", "sellerPinItemBlueprint", "providePinAdvertsItemBinder", "(Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichSmallItemBlueprint;Lcom/avito/android/serp/adapter/SellerPinItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "providePinAdvertsAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "<init>", "()V", "Declarations", "map_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PinAdvertsListModule {
    @NotNull
    public static final PinAdvertsListModule INSTANCE = new PinAdvertsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001dH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020$H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020(H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/search/map/di/PinAdvertsListModule$Declarations;", "", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinderImpl;", "binder", "Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "binPinAdvertsListViewBinder", "(Lcom/avito/android/search/map/view/PinAdvertsListViewBinderImpl;)Lcom/avito/android/search/map/view/PinAdvertsListViewBinder;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "binFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "binViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "Lcom/avito/android/serp/adapter/SellerPinItemBlueprint;", "blueprint", "bindSellerItemBlueprint", "(Lcom/avito/android/serp/adapter/SellerPinItemBlueprint;)Lcom/avito/android/serp/adapter/SellerPinItemBlueprint;", "Lcom/avito/android/serp/adapter/SellerPinItemPresenterImpl;", "Lcom/avito/android/serp/adapter/SellerPinItemPresenter;", "bindSellerItemPresenter", "(Lcom/avito/android/serp/adapter/SellerPinItemPresenterImpl;)Lcom/avito/android/serp/adapter/SellerPinItemPresenter;", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListenerImpl;", GeoContract.PROVIDER, "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "binAppendingRetryListener", "(Lcom/avito/android/search/map/view/adapter/AppendingRetryListenerImpl;)Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "bindSpannedGridPositionProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "Lcom/avito/android/serp/CommercialBannersInteractor;", "interactor", "bindSerpBannersInteractor", "(Lcom/avito/android/serp/CommercialBannersInteractor;)Lcom/avito/android/serp/CommercialBannersInteractor;", "Lcom/avito/android/serp/SerpItemProcessor;", "processor", "bindSerpItemProcessor", "(Lcom/avito/android/serp/SerpItemProcessor;)Lcom/avito/android/serp/SerpItemProcessor;", "Lcom/avito/android/serp/adapter/SerpItemAligner;", "aligner", "bindSerpItemAligner", "(Lcom/avito/android/serp/adapter/SerpItemAligner;)Lcom/avito/android/serp/adapter/SerpItemAligner;", "map_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        AppendingRetryListener binAppendingRetryListener(@NotNull AppendingRetryListenerImpl appendingRetryListenerImpl);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        FavoriteAdvertsPresenter binFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PinAdvertsListViewBinder binPinAdvertsListViewBinder(@NotNull PinAdvertsListViewBinderImpl pinAdvertsListViewBinderImpl);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        ViewedAdvertsPresenter binViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        SellerPinItemBlueprint bindSellerItemBlueprint(@NotNull SellerPinItemBlueprint sellerPinItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        SellerPinItemPresenter bindSellerItemPresenter(@NotNull SellerPinItemPresenterImpl sellerPinItemPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        CommercialBannersInteractor bindSerpBannersInteractor(@NotNull CommercialBannersInteractor commercialBannersInteractor);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        SerpItemAligner bindSerpItemAligner(@NotNull SerpItemAligner serpItemAligner);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        SerpItemProcessor bindSerpItemProcessor(@NotNull SerpItemProcessor serpItemProcessor);

        @Binds
        @NotNull
        @PerFragment
        @PinAdvertsList
        SpannedGridPositionProvider bindSpannedGridPositionProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @PinAdvertsList
    public static final SimpleRecyclerAdapter providePinAdvertsAdapter(@PinAdvertsList @NotNull AdapterPresenter adapterPresenter, @PinAdvertsList @NotNull ItemBinder itemBinder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, itemBinder, buildInfo, analytics);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @PinAdvertsList
    public static final ItemBinder providePinAdvertsItemBinder(@NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull AdvertRichSmallItemBlueprint advertRichSmallItemBlueprint, @NotNull SellerPinItemBlueprint sellerPinItemBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(advertRichSmallItemBlueprint, "advertRichItemBlueprint");
        Intrinsics.checkNotNullParameter(sellerPinItemBlueprint, "sellerPinItemBlueprint");
        return new ItemBinder.Builder().registerItem(advertItemListBlueprint).registerItem(advertRichSmallItemBlueprint).registerItem(sellerPinItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @PinAdvertsList
    public static final SerpSpanProvider provideSpanProvider$map_release(@PinAdvertsList @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SerpSpanProviderImpl(resources.getInteger(R.integer.serp_columns), spannedGridPositionProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @PinAdvertsList
    public static final GridLayoutManager.SpanSizeLookup provideSpanSizeLookup$map_release(@PinAdvertsList @NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @NotNull
    @PerFragment
    @PinAdvertsList
    public final AdapterPresenter providePinAdvertsAdapterPresenter(@PinAdvertsList @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }
}
