package com.avito.android.viewed_items.adapter;

import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.viewed_items.di.ViewedItems;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/viewed_items/adapter/ViewedItemsListPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "getListener", "()Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsListPresenter implements ItemPresenter<FavoriteAdvertItemView, FavoriteAdvertItem> {
    @NotNull
    public final Lazy<FavoriteAdvertItemPresenter.Listener> a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) this.d;
                ((ViewedItemsListPresenter) this.c).getListener().get().onFavoriteItemClicked(favoriteAdvertItem, ViewedItemsListPresenter.access$createImage((ViewedItemsListPresenter) this.c, (FavoriteAdvertItemView) this.e, favoriteAdvertItem));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((ViewedItemsListPresenter) this.c).getListener().get().onRemoveItemClicked((FavoriteAdvertItem) this.d);
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((FavoriteAdvertItemView) this.b).setClickListener(null);
                ((FavoriteAdvertItemView) this.b).setOnFavoriteButtonClickListener(null);
                ((FavoriteAdvertItemView) this.b).setUnbindListener(null);
                ((FavoriteAdvertItemView) this.b).setMoreClickListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public ViewedItemsListPresenter(@ViewedItems @NotNull Lazy<FavoriteAdvertItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public static final Image access$createImage(ViewedItemsListPresenter viewedItemsListPresenter, FavoriteAdvertItemView favoriteAdvertItemView, FavoriteAdvertItem favoriteAdvertItem) {
        Objects.requireNonNull(viewedItemsListPresenter);
        return ImageKt.toSingleImage(favoriteAdvertItemView.getPictureUri(AvitoPictureKt.pictureOf$default(favoriteAdvertItem.getImage(), false, 0.0f, 1.5f, null, 20, null)));
    }

    @NotNull
    public final Lazy<FavoriteAdvertItemPresenter.Listener> getListener() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d8, code lost:
        if (r13 != null) goto L_0x00df;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView r11, @org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItem r12, int r13) {
        /*
            r10 = this;
            java.lang.String r13 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            java.lang.String r13 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
            com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a r13 = new com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a
            r1 = 0
            r0 = r13
            r2 = r11
            r3 = r10
            r4 = r12
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r11.setClickListener(r13)
            com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a r13 = new com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a
            r3 = 1
            r2 = r13
            r4 = r11
            r5 = r10
            r6 = r12
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            r11.setOnFavoriteButtonClickListener(r13)
            com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a r13 = new com.avito.android.viewed_items.adapter.ViewedItemsListPresenter$a
            r5 = 2
            r4 = r13
            r6 = r11
            r7 = r10
            r8 = r12
            r9 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            r11.setUnbindListener(r13)
            r13 = 0
            r11.setViewedBadgeVisible(r13)
            boolean r0 = r12.isFavorite()
            r11.setFavorite(r0)
            r11.setMoreButtonVisible(r13)
            com.avito.android.remote.model.Image r1 = r12.getImage()
            r2 = 0
            r3 = 0
            r4 = 1069547520(0x3fc00000, float:1.5)
            r5 = 0
            r6 = 20
            r7 = 0
            com.avito.android.image_loader.Picture r0 = com.avito.android.image_loader.AvitoPictureKt.pictureOf$default(r1, r2, r3, r4, r5, r6, r7)
            r11.setPicture(r0)
            java.lang.String r0 = r12.getTitle()
            r11.setTitle(r0)
            java.lang.String r0 = r12.getPrice()
            r11.setCurrentPrice(r0)
            java.lang.String r0 = r12.getPreviousPrice()
            r11.setPreviousPrice(r0)
            boolean r0 = r12.isDeliverable()
            r11.setDeliveryVisible(r0)
            java.lang.String r0 = r12.getShopName()
            r11.setShopName(r0)
            boolean r0 = r12.getActive()
            r1 = 0
            if (r0 == 0) goto L_0x0088
            long r2 = r12.getTime()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            goto L_0x0089
        L_0x0088:
            r0 = r1
        L_0x0089:
            r11.setDate(r0)
            java.lang.String r0 = r12.getNote()
            r11.setNote(r0)
            boolean r0 = r12.getActive()
            r11.setActive(r0)
            boolean r0 = r12.getActive()
            if (r0 == 0) goto L_0x00a4
            r11.setStatusDescription(r1)
            goto L_0x00ab
        L_0x00a4:
            java.lang.String r0 = r12.getStatusDescription()
            r11.setStatusDescription(r0)
        L_0x00ab:
            java.lang.String r0 = r12.getLocation()
            if (r0 == 0) goto L_0x00b7
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00b8
        L_0x00b7:
            r13 = 1
        L_0x00b8:
            if (r13 == 0) goto L_0x00e6
            java.lang.String r13 = r12.getSublocation()
            if (r13 == 0) goto L_0x00db
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r12.getOldLocation()
            r0.append(r2)
            java.lang.String r2 = ", "
            r0.append(r2)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            if (r13 == 0) goto L_0x00db
            goto L_0x00df
        L_0x00db:
            java.lang.String r13 = r12.getOldLocation()
        L_0x00df:
            r11.setAddress(r13)
            r11.setLocation(r1)
            goto L_0x00f4
        L_0x00e6:
            java.lang.String r13 = r12.getLocation()
            r11.setLocation(r13)
            java.lang.String r12 = r12.getAddress()
            r11.setAddress(r12)
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.viewed_items.adapter.ViewedItemsListPresenter.bindView(com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView, com.avito.android.favorites.adapter.advert.FavoriteAdvertItem, int):void");
    }
}
