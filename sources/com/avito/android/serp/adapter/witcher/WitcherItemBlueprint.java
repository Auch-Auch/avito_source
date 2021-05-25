package com.avito.android.serp.adapter.witcher;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.di.module.WitcherAdapter;
import com.avito.android.di.module.WitcherFavoriteAdverts;
import com.avito.android.di.module.WitcherItemBinder;
import com.avito.android.di.module.WitcherViewedAdverts;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BI\b\u0007\u0012\u0006\u0010&\u001a\u00020!\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010 \u001a\u00020\u001d\u0012\b\b\u0001\u0010\u0010\u001a\u00020\r\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "d", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "witcherResourceProvider", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "f", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/util/DeviceMetrics;", "h", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", g.a, "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapter", "Lcom/avito/konveyor/ItemBinder;", "c", "Lcom/avito/konveyor/ItemBinder;", "itemsBinder", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "e", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/witcher/WitcherItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;Lcom/avito/android/util/DeviceMetrics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherItemBlueprint implements ItemBlueprint<WitcherItemView, WitcherItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<WitcherItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_item_witcher, new a(this));
    @NotNull
    public final WitcherItemPresenter b;
    public final ItemBinder c;
    public final WitcherResourceProvider d;
    public final ViewedAdvertsPresenter e;
    public final FavoriteAdvertsPresenter f;
    public final SimpleAdapterPresenter g;
    public final DeviceMetrics h;

    public static final class a extends Lambda implements Function2<ViewGroup, View, WitcherItemViewImpl> {
        public final /* synthetic */ WitcherItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WitcherItemBlueprint witcherItemBlueprint) {
            super(2);
            this.a = witcherItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v0, types: [com.avito.android.serp.adapter.witcher.WitcherItemPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.serp.adapter.witcher.WitcherItemViewImpl invoke(android.view.ViewGroup r10, android.view.View r11) {
            /*
                r9 = this;
                android.view.ViewGroup r10 = (android.view.ViewGroup) r10
                r1 = r11
                android.view.View r1 = (android.view.View) r1
                java.lang.String r11 = "<anonymous parameter 0>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
                java.lang.String r10 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r10)
                com.avito.android.serp.adapter.witcher.WitcherItemViewImpl r10 = new com.avito.android.serp.adapter.witcher.WitcherItemViewImpl
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.android.serp.adapter.witcher.WitcherItemPresenter r2 = r11.getPresenter()
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.konveyor.ItemBinder r3 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getItemsBinder$p(r11)
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.android.serp.adapter.witcher.WitcherResourceProvider r4 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getWitcherResourceProvider$p(r11)
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.android.advert.viewed.ViewedAdvertsPresenter r5 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getViewedAdvertsPresenter$p(r11)
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.android.favorite.FavoriteAdvertsPresenter r6 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getFavoriteAdvertsPresenter$p(r11)
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.konveyor.adapter.SimpleAdapterPresenter r7 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getAdapter$p(r11)
                com.avito.android.serp.adapter.witcher.WitcherItemBlueprint r11 = r9.a
                com.avito.android.util.DeviceMetrics r8 = com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.access$getDeviceMetrics$p(r11)
                r0 = r10
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.witcher.WitcherItemBlueprint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public WitcherItemBlueprint(@NotNull WitcherItemPresenter witcherItemPresenter, @WitcherItemBinder @NotNull ItemBinder itemBinder, @NotNull WitcherResourceProvider witcherResourceProvider, @WitcherViewedAdverts @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @WitcherFavoriteAdverts @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @WitcherAdapter @NotNull SimpleAdapterPresenter simpleAdapterPresenter, @NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(witcherItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemsBinder");
        Intrinsics.checkNotNullParameter(witcherResourceProvider, "witcherResourceProvider");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(simpleAdapterPresenter, "adapter");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.b = witcherItemPresenter;
        this.c = itemBinder;
        this.d = witcherResourceProvider;
        this.e = viewedAdvertsPresenter;
        this.f = favoriteAdvertsPresenter;
        this.g = simpleAdapterPresenter;
        this.h = deviceMetrics;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<WitcherItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof WitcherItem;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.witcher.WitcherItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<WitcherItemView, WitcherItem> getPresenter() {
        return this.b;
    }
}
