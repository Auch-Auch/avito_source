package com.avito.android.favorite_sellers.adapter.advert_list;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite_sellers.adapter.advert_list.di.ForAdvertList;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BK\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u000e\b\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\t\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\b\b\u0001\u0010!\u001a\u00020\u001e¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\f¨\u0006'"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemView;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Ljavax/inject/Provider;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "d", "Ljavax/inject/Provider;", "favoritePresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "e", "viewedAdvertsPresenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "getPresenter", "()Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;", "presenter", "Lcom/avito/konveyor/ItemBinder;", "f", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "adapterPresenter", "<init>", "(Lcom/avito/android/favorite_sellers/adapter/advert_list/AdvertListItemPresenter;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Lcom/avito/konveyor/ItemBinder;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertListItemBlueprint implements ItemBlueprint<AdvertListItemView, AdvertListItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertListItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_list_item, new a(this));
    @NotNull
    public final AdvertListItemPresenter b;
    public final Provider<AdapterPresenter> c;
    public final Provider<FavoriteAdvertsPresenter> d;
    public final Provider<ViewedAdvertsPresenter> e;
    public final ItemBinder f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertListItemViewImpl> {
        public final /* synthetic */ AdvertListItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertListItemBlueprint advertListItemBlueprint) {
            super(2);
            this.a = advertListItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // kotlin.jvm.functions.Function2
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemViewImpl invoke(android.view.ViewGroup r8, android.view.View r9) {
            /*
                r7 = this;
                android.view.ViewGroup r8 = (android.view.ViewGroup) r8
                r5 = r9
                android.view.View r5 = (android.view.View) r5
                java.lang.String r9 = "<anonymous parameter 0>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
                java.lang.String r8 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r8)
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemViewImpl r8 = new com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemViewImpl
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint r9 = r7.a
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter r1 = r9.getPresenter()
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint r9 = r7.a
                javax.inject.Provider r9 = com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint.access$getAdapterPresenter$p(r9)
                java.lang.Object r9 = r9.get()
                java.lang.String r0 = "adapterPresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
                r2 = r9
                com.avito.konveyor.adapter.AdapterPresenter r2 = (com.avito.konveyor.adapter.AdapterPresenter) r2
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint r9 = r7.a
                javax.inject.Provider r9 = com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint.access$getFavoritePresenter$p(r9)
                java.lang.Object r9 = r9.get()
                java.lang.String r0 = "favoritePresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
                r3 = r9
                com.avito.android.favorite.FavoriteAdvertsPresenter r3 = (com.avito.android.favorite.FavoriteAdvertsPresenter) r3
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint r9 = r7.a
                javax.inject.Provider r9 = com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint.access$getViewedAdvertsPresenter$p(r9)
                java.lang.Object r9 = r9.get()
                java.lang.String r0 = "viewedAdvertsPresenter.get()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
                r4 = r9
                com.avito.android.advert.viewed.ViewedAdvertsPresenter r4 = (com.avito.android.advert.viewed.ViewedAdvertsPresenter) r4
                com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint r9 = r7.a
                com.avito.konveyor.ItemBinder r6 = com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint.access$getItemBinder$p(r9)
                r0 = r8
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemBlueprint.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public AdvertListItemBlueprint(@NotNull AdvertListItemPresenter advertListItemPresenter, @ForAdvertList @NotNull Provider<AdapterPresenter> provider, @ForAdvertList @NotNull Provider<FavoriteAdvertsPresenter> provider2, @ForAdvertList @NotNull Provider<ViewedAdvertsPresenter> provider3, @ForAdvertList @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(advertListItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(provider, "adapterPresenter");
        Intrinsics.checkNotNullParameter(provider2, "favoritePresenter");
        Intrinsics.checkNotNullParameter(provider3, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.b = advertListItemPresenter;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
        this.f = itemBinder;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdvertListItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdvertListItem;
    }

    /* Return type fixed from 'com.avito.android.favorite_sellers.adapter.advert_list.AdvertListItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertListItemView, AdvertListItem> getPresenter() {
        return this.b;
    }
}
