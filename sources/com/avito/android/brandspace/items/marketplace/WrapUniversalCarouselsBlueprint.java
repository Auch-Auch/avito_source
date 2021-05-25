package com.avito.android.brandspace.items.marketplace;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.items.carousel.WrapHeightCarouselItemViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselsBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView;", "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "c", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "getPresenter", "()Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "presenter", "Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;", "d", "Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;", "itemsBlueprints", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/brandspace/items/carousel/WrapHeightCarouselItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;Lcom/avito/android/brandspace/items/marketplace/WrapUniversalCarouselItemsBlueprints;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class WrapUniversalCarouselsBlueprint implements ItemBlueprint<CarouselItemView, CarouselItem> {
    @NotNull
    public final ItemBinder a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<WrapHeightCarouselItemViewImpl> b;
    @NotNull
    public final CarouselPresenter c;
    public final WrapUniversalCarouselItemsBlueprints d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, WrapHeightCarouselItemViewImpl> {
        public final /* synthetic */ WrapUniversalCarouselsBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(WrapUniversalCarouselsBlueprint wrapUniversalCarouselsBlueprint) {
            super(2);
            this.a = wrapUniversalCarouselsBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public WrapHeightCarouselItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new WrapHeightCarouselItemViewImpl(new SimpleAdapterPresenter(this.a.getItemBinder(), this.a.getItemBinder()), view2, this.a.getItemBinder(), false, null, 16, null);
        }
    }

    @Inject
    public WrapUniversalCarouselsBlueprint(@NotNull CarouselPresenter carouselPresenter, @NotNull WrapUniversalCarouselItemsBlueprints wrapUniversalCarouselItemsBlueprints) {
        Intrinsics.checkNotNullParameter(carouselPresenter, "presenter");
        Intrinsics.checkNotNullParameter(wrapUniversalCarouselItemsBlueprints, "itemsBlueprints");
        this.c = carouselPresenter;
        this.d = wrapUniversalCarouselItemsBlueprints;
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = wrapUniversalCarouselItemsBlueprints.getBlueprints().iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        Unit unit = Unit.INSTANCE;
        this.a = builder.build();
        this.b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.brandspace_item_carousel, new a(this));
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<WrapHeightCarouselItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRelevantItem(@org.jetbrains.annotations.NotNull com.avito.konveyor.blueprint.Item r6) {
        /*
            r5 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof com.avito.android.brandspace.items.carousel.CarouselItem
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x005c
            com.avito.android.brandspace.items.carousel.CarouselItem r6 = (com.avito.android.brandspace.items.carousel.CarouselItem) r6
            java.util.List r6 = r6.getItems()
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x001d
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x001b:
            r6 = 0
            goto L_0x0059
        L_0x001d:
            java.util.Iterator r6 = r6.iterator()
        L_0x0021:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = r6.next()
            com.avito.android.brandspace.presenter.BrandspaceItem r0 = (com.avito.android.brandspace.presenter.BrandspaceItem) r0
            com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselItemsBlueprints r3 = r5.d
            java.util.List r3 = r3.getBlueprints()
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x003f
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x003f
        L_0x003d:
            r0 = 0
            goto L_0x0056
        L_0x003f:
            java.util.Iterator r3 = r3.iterator()
        L_0x0043:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003d
            java.lang.Object r4 = r3.next()
            com.avito.konveyor.blueprint.ItemBlueprint r4 = (com.avito.konveyor.blueprint.ItemBlueprint) r4
            boolean r4 = r4.isRelevantItem(r0)
            if (r4 == 0) goto L_0x0043
            r0 = 1
        L_0x0056:
            if (r0 == 0) goto L_0x0021
            r6 = 1
        L_0x0059:
            if (r6 == 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r1 = 0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.WrapUniversalCarouselsBlueprint.isRelevantItem(com.avito.konveyor.blueprint.Item):boolean");
    }

    /* Return type fixed from 'com.avito.android.brandspace.items.carousel.CarouselPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CarouselItemView, CarouselItem> getPresenter() {
        return this.c;
    }
}
