package com.avito.android.shop.list.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ShopListScreen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.di.PerFragment;
import com.avito.android.floating_views.FloatingViewsPresenterImpl;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.analytic.ShopListTrackerImpl;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.shop.list.business.ShopListInteractorImpl;
import com.avito.android.shop.list.business.ShopListResultConverter;
import com.avito.android.shop.list.business.ShopListResultConverterImpl;
import com.avito.android.shop.list.business.ShopSearchParamsConverter;
import com.avito.android.shop.list.business.ShopSearchParamsConverterImpl;
import com.avito.android.shop.list.presentation.ShopListConverter;
import com.avito.android.shop.list.presentation.ShopListConverterImpl;
import com.avito.android.shop.list.presentation.ShopListDataChangeListener;
import com.avito.android.shop.list.presentation.ShopListDataChangeListenerImpl;
import com.avito.android.shop.list.presentation.ShopListPresenter;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import com.avito.android.shop.list.presentation.ShortcutNavigationItemConverter;
import com.avito.android.shop.list.presentation.ShortcutNavigationItemConverterImpl;
import com.avito.android.shop.list.presentation.item.ShopClickListener;
import com.avito.android.shop.list.presentation.item.ShopItem;
import com.avito.android.shop.list.presentation.item.ShopItemBlueprint;
import com.avito.android.shop.list.presentation.item.ShopItemPresenter;
import com.avito.android.shop.list.presentation.item.ShopItemPresenterImpl;
import com.avito.android.shop.list.presentation.item.ShopItemView;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u00043456B\t\b\u0002¢\u0006\u0004\b1\u00102J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020&2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0016H\u0001¢\u0006\u0004\b.\u0010/¨\u00067"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider$shop_release", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "gridPositionProvider", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider$shop_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/ui/adapter/AppendingListener;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$shop_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "Lcom/avito/android/shop/list/presentation/item/ShopItemBlueprint;", "shopItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$shop_release", "(Lcom/avito/android/shop/list/presentation/item/ShopItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$shop_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$shop_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$shop_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "<init>", "()V", "Dependencies", "InteractorState", "PresenterState", "Storage", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, Dependencies.class})
public final class ShopListModule {
    @NotNull
    public static final ShopListModule INSTANCE = new ShopListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 2\u0006\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020%H'¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u0004H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u0002002\u0006\u0010\u0012\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u000203H'¢\u0006\u0004\b5\u00106J\u0017\u0010:\u001a\u0002092\u0006\u00108\u001a\u000207H'¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListModule$Dependencies;", "", "Lcom/avito/android/shop/list/presentation/ShopListPresenterImpl;", "presenter", "Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "bindShopListPresenter", "(Lcom/avito/android/shop/list/presentation/ShopListPresenterImpl;)Lcom/avito/android/shop/list/presentation/ShopListPresenter;", "Lcom/avito/android/shop/list/business/ShopListInteractorImpl;", "interactor", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "bindShopListInteractor", "(Lcom/avito/android/shop/list/business/ShopListInteractorImpl;)Lcom/avito/android/shop/list/business/ShopListInteractor;", "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListenerImpl;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "bindShopListDataChangeListener", "(Lcom/avito/android/shop/list/presentation/ShopListDataChangeListenerImpl;)Lcom/avito/android/shop/list/presentation/ShopListDataChangeListener;", "Lcom/avito/android/shop/list/presentation/ShopListConverterImpl;", "converter", "Lcom/avito/android/shop/list/presentation/ShopListConverter;", "bindShopListConverter", "(Lcom/avito/android/shop/list/presentation/ShopListConverterImpl;)Lcom/avito/android/shop/list/presentation/ShopListConverter;", "Lcom/avito/android/shop/list/business/ShopSearchParamsConverterImpl;", "Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;", "bindShopSearchParamsConverter", "(Lcom/avito/android/shop/list/business/ShopSearchParamsConverterImpl;)Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;", "Lcom/avito/android/shop/list/business/ShopListResultConverterImpl;", "Lcom/avito/android/shop/list/business/ShopListResultConverter;", "bindShopListResultConverter", "(Lcom/avito/android/shop/list/business/ShopListResultConverterImpl;)Lcom/avito/android/shop/list/business/ShopListResultConverter;", "Lcom/avito/android/shop/list/presentation/item/ShopItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop/list/presentation/item/ShopItemView;", "Lcom/avito/android/shop/list/presentation/item/ShopItem;", "bindShopItemBlueprint", "(Lcom/avito/android/shop/list/presentation/item/ShopItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop/list/presentation/item/ShopItemPresenterImpl;", "Lcom/avito/android/shop/list/presentation/item/ShopItemPresenter;", "bindShopItemPresenter", "(Lcom/avito/android/shop/list/presentation/item/ShopItemPresenterImpl;)Lcom/avito/android/shop/list/presentation/item/ShopItemPresenter;", "Lcom/avito/android/shop/list/presentation/item/ShopClickListener;", "bindShopClickListener", "(Lcom/avito/android/shop/list/presentation/ShopListPresenter;)Lcom/avito/android/shop/list/presentation/item/ShopClickListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "bindAppendingListener", "(Lcom/avito/android/shop/list/presentation/ShopListPresenter;)Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverterImpl;", "Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "bindShortcutNavigationItemConverter", "(Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverterImpl;)Lcom/avito/android/shop/list/presentation/ShortcutNavigationItemConverter;", "Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "bindFloatingViewsPresenter", "(Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;)Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/shop/list/analytic/ShopListTrackerImpl;", "tracker", "Lcom/avito/android/shop/list/analytic/ShopListTracker;", "bindShopListTracker", "(Lcom/avito/android/shop/list/analytic/ShopListTrackerImpl;)Lcom/avito/android/shop/list/analytic/ShopListTracker;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        AppendingListener bindAppendingListener(@NotNull ShopListPresenter shopListPresenter);

        @PerFragment
        @Binds
        @NotNull
        PersistableFloatingViewsPresenter bindFloatingViewsPresenter(@NotNull FloatingViewsPresenterImpl floatingViewsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopClickListener bindShopClickListener(@NotNull ShopListPresenter shopListPresenter);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<ShopItemView, ShopItem> bindShopItemBlueprint(@NotNull ShopItemBlueprint shopItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        ShopItemPresenter bindShopItemPresenter(@NotNull ShopItemPresenterImpl shopItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListConverter bindShopListConverter(@NotNull ShopListConverterImpl shopListConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListDataChangeListener bindShopListDataChangeListener(@NotNull ShopListDataChangeListenerImpl shopListDataChangeListenerImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListInteractor bindShopListInteractor(@NotNull ShopListInteractorImpl shopListInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListPresenter bindShopListPresenter(@NotNull ShopListPresenterImpl shopListPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListResultConverter bindShopListResultConverter(@NotNull ShopListResultConverterImpl shopListResultConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopListTracker bindShopListTracker(@NotNull ShopListTrackerImpl shopListTrackerImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopSearchParamsConverter bindShopSearchParamsConverter(@NotNull ShopSearchParamsConverterImpl shopSearchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ShortcutNavigationItemConverter bindShortcutNavigationItemConverter(@NotNull ShortcutNavigationItemConverterImpl shortcutNavigationItemConverterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListModule$InteractorState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InteractorState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListModule$PresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/list/di/ShopListModule$Storage;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Storage {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$shop_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$shop_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SpannedGridPositionProvider provideGridPositionProvider$shop_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new GridPositionProviderImpl(resources.getInteger(R.integer.shop_list_columns));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$shop_release(@NotNull ShopItemBlueprint shopItemBlueprint) {
        Intrinsics.checkNotNullParameter(shopItemBlueprint, "shopItemBlueprint");
        return new ItemBinder.Builder().registerItem(shopItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GridLayoutManager.SpanSizeLookup provideSpanLookup$shop_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SerpSpanProvider provideSpanProvider$shop_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull AppendingListener appendingListener, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        Intrinsics.checkNotNullParameter(resources, "resources");
        SerpSpanProviderImpl serpSpanProviderImpl = new SerpSpanProviderImpl(resources.getInteger(R.integer.shop_list_columns), spannedGridPositionProvider);
        serpSpanProviderImpl.setAppendingListener(appendingListener);
        return serpSpanProviderImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ScreenDiInjectTracker providesScreenDiInjectTracker$shop_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, ShopListScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(ShopListScreen.INSTANCE, timerFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, ShopListScreen.INSTANCE, timerFactory, null, 4, null);
    }
}
