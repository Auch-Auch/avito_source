package com.avito.android.di.module;

import android.app.Activity;
import com.avito.android.di.PerFragment;
import com.avito.android.lib.design.R;
import com.avito.android.serp.adapter.SerpShortcutBannerWidthProvider;
import com.avito.android.serp.adapter.ShortcutBannerBlueprint;
import com.avito.android.serp.adapter.ShortcutBannerItem;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenterImpl;
import com.avito.android.serp.adapter.ShortcutBannerItemView;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItem;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemBlueprint;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenter;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemPresenterImpl;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItem;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemBlueprint;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenter;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemPresenterImpl;
import com.avito.android.serp.adapter.location_notification.LocationNotificationItemView;
import com.avito.android.serp.adapter.map_banner.MapBannerItem;
import com.avito.android.serp.adapter.map_banner.MapBannerItemBlueprint;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenter;
import com.avito.android.serp.adapter.map_banner.MapBannerItemPresenterImpl;
import com.avito.android.serp.adapter.map_banner.MapBannerItemView;
import com.avito.android.serp.adapter.snippet.SnippetBlueprint;
import com.avito.android.serp.adapter.snippet.SnippetItem;
import com.avito.android.serp.adapter.snippet.SnippetPresenter;
import com.avito.android.serp.adapter.snippet.SnippetView;
import com.avito.android.serp.adapter.title.GroupTitleItem;
import com.avito.android.serp.adapter.title.GroupTitleItemBlueprint;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenter;
import com.avito.android.serp.adapter.title.GroupTitleItemPresenterImpl;
import com.avito.android.serp.adapter.title.GroupTitleItemView;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalFilterModule;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.avito.android.serp.adapter.warning.SerpWarningItemBlueprint;
import com.avito.android.serp.adapter.warning.SerpWarningItemPresenter;
import com.avito.android.serp.adapter.warning.SerpWarningItemPresenterImpl;
import com.avito.android.serp.adapter.warning.SerpWarningItemView;
import com.avito.android.serp.adapter.witcher.WitcherItem;
import com.avito.android.serp.adapter.witcher.WitcherItemBlueprint;
import com.avito.android.serp.adapter.witcher.WitcherItemView;
import com.avito.android.util.Contexts;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/di/module/SerpAdapterModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "shortcutBannerWidthProvider", "Landroid/app/Activity;", "activity", "Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;", "provideShortcutBannerItemPresenter", "(Ldagger/Lazy;Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;Landroid/app/Activity;)Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;", "<init>", "()V", "Declarations", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertItemModule.class, AdvertXlItemModule.class, AdsItemModule.class, SpanAdapterModule.class, HeaderModule.class, Declarations.class, VerticalFilterModule.class})
public final class SerpAdapterModule {
    @NotNull
    public static final SerpAdapterModule INSTANCE = new SerpAdapterModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\b\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\b\u001a\u00020$H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J#\u00100\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0\t2\u0006\u0010\b\u001a\u00020-H'¢\u0006\u0004\b0\u00101J#\u00105\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002040\t2\u0006\u0010\b\u001a\u000202H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u0010\u0003\u001a\u000207H'¢\u0006\u0004\b9\u0010:J#\u0010>\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\t2\u0006\u0010\b\u001a\u00020;H'¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020@H'¢\u0006\u0004\bB\u0010CJ#\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0\t2\u0006\u0010\b\u001a\u00020DH'¢\u0006\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/avito/android/di/module/SerpAdapterModule$Declarations;", "", "Lcom/avito/android/serp/adapter/SerpShortcutBannerWidthProvider;", "presenter", "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "bindShortcutBannerWidthProvider", "(Lcom/avito/android/serp/adapter/SerpShortcutBannerWidthProvider;)Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemView;", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "bindShortcutBannerBlueprint", "(Lcom/avito/android/serp/adapter/ShortcutBannerBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenterImpl;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenter;", "bindSerpWarningItemPresenter", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenterImpl;)Lcom/avito/android/serp/adapter/warning/SerpWarningItemPresenter;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItemView;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "bindSerpWarningItemBlueprint", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/title/GroupTitleItemPresenterImpl;", "Lcom/avito/android/serp/adapter/title/GroupTitleItemPresenter;", "bindGroupTitleItemPresenter", "(Lcom/avito/android/serp/adapter/title/GroupTitleItemPresenterImpl;)Lcom/avito/android/serp/adapter/title/GroupTitleItemPresenter;", "Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;", "Lcom/avito/android/serp/adapter/title/GroupTitleItemView;", "Lcom/avito/android/serp/adapter/title/GroupTitleItem;", "bindGroupTitleItemBlueprint", "(Lcom/avito/android/serp/adapter/title/GroupTitleItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenterImpl;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenter;", "bindEmptyPlaceholderItemPresenter", "(Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenterImpl;)Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemPresenter;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "bindEmptyPlaceholderItemBlueprint", "(Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/snippet/SnippetPresenter$Impl;", "Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "bindSnippetPresenter", "(Lcom/avito/android/serp/adapter/snippet/SnippetPresenter$Impl;)Lcom/avito/android/serp/adapter/snippet/SnippetPresenter;", "Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;", "Lcom/avito/android/serp/adapter/snippet/SnippetView;", "Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "bindSnippetBlueprint", "(Lcom/avito/android/serp/adapter/snippet/SnippetBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "bindWitcherItemBlueprint", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenterImpl;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenter;", "bindLocationNotificationPresenter", "(Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenterImpl;)Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemPresenter;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemBlueprint;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemView;", "Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItem;", "bindLocationNotificationItemBlueprint", "(Lcom/avito/android/serp/adapter/location_notification/LocationNotificationItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenterImpl;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenter;", "bindMapBannerItemPresenter", "(Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenterImpl;)Lcom/avito/android/serp/adapter/map_banner/MapBannerItemPresenter;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemView;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItem;", "bindMapBannerItemBlueprint", "(Lcom/avito/android/serp/adapter/map_banner/MapBannerItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<EmptyPlaceholderItemView, EmptyPlaceholderItem> bindEmptyPlaceholderItemBlueprint(@NotNull EmptyPlaceholderItemBlueprint emptyPlaceholderItemBlueprint);

        @Reusable
        @Binds
        @NotNull
        EmptyPlaceholderItemPresenter bindEmptyPlaceholderItemPresenter(@NotNull EmptyPlaceholderItemPresenterImpl emptyPlaceholderItemPresenterImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<GroupTitleItemView, GroupTitleItem> bindGroupTitleItemBlueprint(@NotNull GroupTitleItemBlueprint groupTitleItemBlueprint);

        @Reusable
        @Binds
        @NotNull
        GroupTitleItemPresenter bindGroupTitleItemPresenter(@NotNull GroupTitleItemPresenterImpl groupTitleItemPresenterImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<LocationNotificationItemView, LocationNotificationItem> bindLocationNotificationItemBlueprint(@NotNull LocationNotificationItemBlueprint locationNotificationItemBlueprint);

        @Reusable
        @Binds
        @NotNull
        LocationNotificationItemPresenter bindLocationNotificationPresenter(@NotNull LocationNotificationItemPresenterImpl locationNotificationItemPresenterImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<MapBannerItemView, MapBannerItem> bindMapBannerItemBlueprint(@NotNull MapBannerItemBlueprint mapBannerItemBlueprint);

        @Reusable
        @Binds
        @NotNull
        MapBannerItemPresenter bindMapBannerItemPresenter(@NotNull MapBannerItemPresenterImpl mapBannerItemPresenterImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<SerpWarningItemView, SerpWarningItem> bindSerpWarningItemBlueprint(@NotNull SerpWarningItemBlueprint serpWarningItemBlueprint);

        @Reusable
        @Binds
        @NotNull
        SerpWarningItemPresenter bindSerpWarningItemPresenter(@NotNull SerpWarningItemPresenterImpl serpWarningItemPresenterImpl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<ShortcutBannerItemView, ShortcutBannerItem> bindShortcutBannerBlueprint(@NotNull ShortcutBannerBlueprint shortcutBannerBlueprint);

        @Reusable
        @Binds
        @NotNull
        ShortcutBannerWidthProvider bindShortcutBannerWidthProvider(@NotNull SerpShortcutBannerWidthProvider serpShortcutBannerWidthProvider);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<SnippetView, SnippetItem> bindSnippetBlueprint(@NotNull SnippetBlueprint snippetBlueprint);

        @Reusable
        @Binds
        @NotNull
        SnippetPresenter bindSnippetPresenter(@NotNull SnippetPresenter.Impl impl);

        @Reusable
        @Binds
        @NotNull
        ItemBlueprint<WitcherItemView, WitcherItem> bindWitcherItemBlueprint(@NotNull WitcherItemBlueprint witcherItemBlueprint);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ShortcutBannerItemPresenter provideShortcutBannerItemPresenter(@NotNull Lazy<ShortcutBannerItemListener> lazy, @NotNull ShortcutBannerWidthProvider shortcutBannerWidthProvider, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(shortcutBannerWidthProvider, "shortcutBannerWidthProvider");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new ShortcutBannerItemPresenterImpl(lazy, shortcutBannerWidthProvider, Contexts.getColorByAttr(activity, R.attr.violet));
    }
}
