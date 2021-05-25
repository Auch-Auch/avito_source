package com.avito.android.brandspace.items.marketplace.snippet;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.items.carousel.CarouselPresenter;
import com.avito.android.brandspace.items.carousel.WrapHeightCarouselItemViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetCarouselBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemView;", "Lcom/avito/android/brandspace/items/carousel/CarouselItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/brandspace/items/carousel/WrapHeightCarouselItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "c", "Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "getPresenter", "()Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;", "presenter", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetBlueprint;", "marketplaceItemSnippetBlueprint", "<init>", "(Lcom/avito/android/brandspace/items/carousel/CarouselPresenter;Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetBlueprint;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSnippetCarouselBlueprint implements ItemBlueprint<CarouselItemView, CarouselItem> {
    @NotNull
    public final ItemBinder a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<WrapHeightCarouselItemViewImpl> b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.brandspace_item_carousel, new a(this));
    @NotNull
    public final CarouselPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, WrapHeightCarouselItemViewImpl> {
        public final /* synthetic */ MarketplaceSnippetCarouselBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MarketplaceSnippetCarouselBlueprint marketplaceSnippetCarouselBlueprint) {
            super(2);
            this.a = marketplaceSnippetCarouselBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public WrapHeightCarouselItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            WrapHeightCarouselItemViewImpl wrapHeightCarouselItemViewImpl = new WrapHeightCarouselItemViewImpl(new SimpleAdapterPresenter(this.a.getItemBinder(), this.a.getItemBinder()), view2, this.a.getItemBinder(), false, Integer.valueOf(view2.getResources().getDimensionPixelOffset(R.dimen.marketplace_snippet_width)));
            int dimensionPixelOffset = view2.getResources().getDimensionPixelOffset(R.dimen.brandspace_carousel_padding_top);
            View view3 = wrapHeightCarouselItemViewImpl.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "itemView");
            Views.changePadding$default(view3, 0, dimensionPixelOffset, 0, 0, 13, null);
            return wrapHeightCarouselItemViewImpl;
        }
    }

    @Inject
    public MarketplaceSnippetCarouselBlueprint(@NotNull CarouselPresenter carouselPresenter, @NotNull MarketplaceSnippetBlueprint marketplaceSnippetBlueprint) {
        Intrinsics.checkNotNullParameter(carouselPresenter, "presenter");
        Intrinsics.checkNotNullParameter(marketplaceSnippetBlueprint, "marketplaceItemSnippetBlueprint");
        this.c = carouselPresenter;
        this.a = new ItemBinder.Builder().registerItem(marketplaceSnippetBlueprint).build();
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

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRelevantItem(@org.jetbrains.annotations.NotNull com.avito.konveyor.blueprint.Item r4) {
        /*
            r3 = this;
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.avito.android.brandspace.items.carousel.CarouselItem
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0035
            com.avito.android.brandspace.items.carousel.CarouselItem r4 = (com.avito.android.brandspace.items.carousel.CarouselItem) r4
            java.util.List r4 = r4.getItems()
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x001d
        L_0x001b:
            r4 = 1
            goto L_0x0032
        L_0x001d:
            java.util.Iterator r4 = r4.iterator()
        L_0x0021:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = r4.next()
            com.avito.android.brandspace.presenter.BrandspaceItem r0 = (com.avito.android.brandspace.presenter.BrandspaceItem) r0
            boolean r0 = r0 instanceof com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem
            if (r0 != 0) goto L_0x0021
            r4 = 0
        L_0x0032:
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetCarouselBlueprint.isRelevantItem(com.avito.konveyor.blueprint.Item):boolean");
    }

    /* Return type fixed from 'com.avito.android.brandspace.items.carousel.CarouselPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CarouselItemView, CarouselItem> getPresenter() {
        return this.c;
    }
}
