package com.avito.android.brandspace.items.marketplace.carouselLoader;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonBlueprint;
import com.avito.android.brandspace.presenter.virtualitems.AddableItemsWithLoadingBrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.SnippetCarouselLoader;
import com.avito.android.brandspace.presenter.virtualitems.SnippetGridLoader;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;", "Lcom/avito/android/brandspace/presenter/virtualitems/AddableItemsWithLoadingBrandspaceItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "c", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "getPresenter", "()Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonBlueprint;", "skeletonBlueprint", "<init>", "(Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderPresenter;Lcom/avito/android/brandspace/items/marketplace/skeleton/SkeletonBlueprint;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselLoaderBlueprint implements ItemBlueprint<CarouselLoaderItemView, AddableItemsWithLoadingBrandspaceItem> {
    @NotNull
    public final ItemBinder a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CarouselLoaderItemViewImpl> b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.brandspace_item_carousel, new a(this));
    @NotNull
    public final CarouselLoaderPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CarouselLoaderItemViewImpl> {
        public final /* synthetic */ CarouselLoaderBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CarouselLoaderBlueprint carouselLoaderBlueprint) {
            super(2);
            this.a = carouselLoaderBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public CarouselLoaderItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            CarouselLoaderItemViewImpl carouselLoaderItemViewImpl = new CarouselLoaderItemViewImpl(new SimpleAdapterPresenter(this.a.getItemBinder(), this.a.getItemBinder()), view2, this.a.getItemBinder(), 0, Integer.valueOf(view2.getResources().getDimensionPixelOffset(R.dimen.marketplace_snippet_width)), 8, null);
            int dimensionPixelOffset = view2.getResources().getDimensionPixelOffset(R.dimen.brandspace_carousel_padding_top);
            View view3 = carouselLoaderItemViewImpl.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "itemView");
            Views.changePadding$default(view3, 0, dimensionPixelOffset, 0, 0, 13, null);
            return carouselLoaderItemViewImpl;
        }
    }

    @Inject
    public CarouselLoaderBlueprint(@NotNull CarouselLoaderPresenter carouselLoaderPresenter, @NotNull SkeletonBlueprint skeletonBlueprint) {
        Intrinsics.checkNotNullParameter(carouselLoaderPresenter, "presenter");
        Intrinsics.checkNotNullParameter(skeletonBlueprint, "skeletonBlueprint");
        this.c = carouselLoaderPresenter;
        this.a = new ItemBinder.Builder().registerItem(skeletonBlueprint).build();
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<CarouselLoaderItemViewImpl> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof SnippetCarouselLoader) || (item instanceof SnippetGridLoader);
    }

    /* Return type fixed from 'com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CarouselLoaderItemView, AddableItemsWithLoadingBrandspaceItem> getPresenter() {
        return this.c;
    }
}
