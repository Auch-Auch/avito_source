package com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemView;
import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemViewImpl;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonBlueprint;
import com.avito.android.brandspace.presenter.virtualitems.TabsLoader;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;", "Lcom/avito/android/brandspace/presenter/virtualitems/TabsLoader;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemViewImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/ItemBinder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "c", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "getPresenter", "()Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "presenter", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonBlueprint;", "tabSkeletonBlueprint", "<init>", "(Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonBlueprint;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TabLoaderBlueprint implements ItemBlueprint<CarouselLoaderItemView, TabsLoader> {
    @NotNull
    public final ItemBinder a;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<CarouselLoaderItemViewImpl> b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.brandspace_item_carousel, new a(this));
    @NotNull
    public final TabLoaderPresenter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, CarouselLoaderItemViewImpl> {
        public final /* synthetic */ TabLoaderBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TabLoaderBlueprint tabLoaderBlueprint) {
            super(2);
            this.a = tabLoaderBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemViewImpl invoke(android.view.ViewGroup r14, android.view.View r15) {
            /*
                r13 = this;
                android.view.ViewGroup r14 = (android.view.ViewGroup) r14
                android.view.View r15 = (android.view.View) r15
                java.lang.String r0 = "<anonymous parameter 0>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                java.lang.String r14 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r14)
                com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemViewImpl r14 = new com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemViewImpl
                com.avito.konveyor.adapter.SimpleAdapterPresenter r1 = new com.avito.konveyor.adapter.SimpleAdapterPresenter
                com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint r0 = r13.a
                com.avito.konveyor.ItemBinder r0 = r0.getItemBinder()
                com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint r2 = r13.a
                com.avito.konveyor.ItemBinder r2 = r2.getItemBinder()
                r1.<init>(r0, r2)
                com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint r0 = r13.a
                com.avito.konveyor.ItemBinder r3 = r0.getItemBinder()
                android.content.Context r0 = r15.getContext()
                java.lang.String r2 = "view.context"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                int r0 = com.avito.android.util.Contexts.getRealDisplayWidth(r0)
                com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint r2 = r13.a
                com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter r2 = r2.getPresenter()
                int r2 = r2.getMinimalCountOfTabSkeleton()
                int r0 = r0 / r2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
                r9 = 0
                r6 = 8
                r12 = 0
                r4 = 0
                r7 = 0
                r0 = r14
                r2 = r15
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                android.content.res.Resources r15 = r15.getResources()
                int r0 = com.avito.android.brandspace.R.dimen.brandspace_carousel_padding_top
                int r10 = r15.getDimensionPixelOffset(r0)
                android.view.View r6 = r14.itemView
                java.lang.String r15 = "itemView"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r15)
                r7 = 0
                r11 = 5
                r8 = r10
                com.avito.android.util.Views.changePadding$default(r6, r7, r8, r9, r10, r11, r12)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderBlueprint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public TabLoaderBlueprint(@NotNull TabLoaderPresenter tabLoaderPresenter, @NotNull TabSkeletonBlueprint tabSkeletonBlueprint) {
        Intrinsics.checkNotNullParameter(tabLoaderPresenter, "presenter");
        Intrinsics.checkNotNullParameter(tabSkeletonBlueprint, "tabSkeletonBlueprint");
        this.c = tabLoaderPresenter;
        this.a = new ItemBinder.Builder().registerItem(tabSkeletonBlueprint).build();
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
        return item instanceof TabsLoader;
    }

    /* Return type fixed from 'com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<CarouselLoaderItemView, TabsLoader> getPresenter() {
        return this.c;
    }
}
