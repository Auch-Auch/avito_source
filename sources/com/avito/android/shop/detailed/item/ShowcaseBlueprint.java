package com.avito.android.shop.detailed.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.R;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0001\u0010%\u001a\u00020\"\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/shop/detailed/item/ShowcaseBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/shop/detailed/item/ShowcaseItemView;", "Lcom/avito/android/shop/detailed/item/ShowcaseItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "e", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/konveyor/ItemBinder;", "f", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "getPresenter", "()Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;", "presenter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "d", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoritePresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/shop/detailed/item/ShowcaseItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/android/shop/detailed/item/ShowcaseItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/konveyor/ItemBinder;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShowcaseBlueprint implements ItemBlueprint<ShowcaseItemView, ShowcaseItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ShowcaseItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.showcase_item, new a(this));
    @NotNull
    public final ShowcaseItemPresenter b;
    public final AdapterPresenter c;
    public final FavoriteAdvertsPresenter d;
    public final ViewedAdvertsPresenter e;
    public final ItemBinder f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ShowcaseItemViewImpl> {
        public final /* synthetic */ ShowcaseBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShowcaseBlueprint showcaseBlueprint) {
            super(2);
            this.a = showcaseBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.avito.android.shop.detailed.item.ShowcaseItemPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.shop.detailed.item.ShowcaseItemViewImpl invoke(android.view.ViewGroup r8, android.view.View r9) {
            /*
                r7 = this;
                android.view.ViewGroup r8 = (android.view.ViewGroup) r8
                r5 = r9
                android.view.View r5 = (android.view.View) r5
                java.lang.String r9 = "<anonymous parameter 0>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
                java.lang.String r8 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
                com.avito.android.shop.detailed.item.ShowcaseItemViewImpl r8 = new com.avito.android.shop.detailed.item.ShowcaseItemViewImpl
                com.avito.android.shop.detailed.item.ShowcaseBlueprint r9 = r7.a
                com.avito.android.shop.detailed.item.ShowcaseItemPresenter r1 = r9.getPresenter()
                com.avito.android.shop.detailed.item.ShowcaseBlueprint r9 = r7.a
                com.avito.konveyor.adapter.AdapterPresenter r2 = com.avito.android.shop.detailed.item.ShowcaseBlueprint.access$getAdapterPresenter$p(r9)
                com.avito.android.shop.detailed.item.ShowcaseBlueprint r9 = r7.a
                com.avito.android.favorite.FavoriteAdvertsPresenter r3 = com.avito.android.shop.detailed.item.ShowcaseBlueprint.access$getFavoritePresenter$p(r9)
                com.avito.android.shop.detailed.item.ShowcaseBlueprint r9 = r7.a
                com.avito.android.advert.viewed.ViewedAdvertsPresenter r4 = com.avito.android.shop.detailed.item.ShowcaseBlueprint.access$getViewedAdvertsPresenter$p(r9)
                com.avito.android.shop.detailed.item.ShowcaseBlueprint r9 = r7.a
                com.avito.konveyor.ItemBinder r6 = com.avito.android.shop.detailed.item.ShowcaseBlueprint.access$getItemBinder$p(r9)
                r0 = r8
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.shop.detailed.item.ShowcaseBlueprint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public ShowcaseBlueprint(@NotNull ShowcaseItemPresenter showcaseItemPresenter, @ShopDetailedModule.ShowcaseAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @ShopDetailedModule.ShowcaseFavoritePresenter @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @ShopDetailedModule.ShowcaseViewedPresenter @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @ShopDetailedModule.ItemShowcaseItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(showcaseItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoritePresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.b = showcaseItemPresenter;
        this.c = adapterPresenter;
        this.d = favoriteAdvertsPresenter;
        this.e = viewedAdvertsPresenter;
        this.f = itemBinder;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ShowcaseItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ShowcaseItem;
    }

    /* Return type fixed from 'com.avito.android.shop.detailed.item.ShowcaseItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ShowcaseItemView, ShowcaseItem> getPresenter() {
        return this.b;
    }
}
