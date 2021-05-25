package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import android.net.Uri;
import android.view.View;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemViewImpl;
import com.avito.android.image_loader.Picture;
import com.avito.android.server_time.TimeSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.model.VKAttachments;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001a\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0010H\u0001¢\u0006\u0004\b#\u0010\u0013J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0010H\u0001¢\u0006\u0004\b%\u0010\u0013J\u001a\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b'\u0010\u0017J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0001¢\u0006\u0004\b)\u0010\u0013J \u0010+\u001a\u00020\u00062\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0001¢\u0006\u0004\b+\u0010\u001bJ\u001a\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b-\u0010\u0017J \u0010.\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0001¢\u0006\u0004\b.\u0010\u001bJ\u0018\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b/\u00100J\u001a\u00102\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b2\u0010\u0017J\u001a\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b4\u0010\u0017J\u0018\u00105\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0001¢\u0006\u0004\b5\u0010\u0013J \u00106\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0001¢\u0006\u0004\b6\u0010\u001bJ\u001a\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b8\u0010\u0017J\u0018\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0014H\u0001¢\u0006\u0004\b:\u0010\u0017J \u0010;\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H\u0001¢\u0006\u0004\b;\u0010\u001bJ\u0018\u0010<\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0010H\u0001¢\u0006\u0004\b<\u0010\u0013¨\u0006E"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;", "status", "", "setStatus", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem$Status;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "onUnbind", "()V", "", "active", "setActive", "(Z)V", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "price", "setCurrentPrice", "", "time", "setDate", "(Ljava/lang/Long;)V", "isShowDelivery", "setDeliveryVisible", "isFavorite", "setFavorite", "location", "setLocation", "isVisible", "setMoreButtonVisible", "clickListener", "setMoreClickListener", VKAttachments.TYPE_NOTE, "setNote", "setOnFavoriteButtonClickListener", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "value", "setPreviousPrice", "shopName", "setShopName", "setSimilarButtonVisible", "setSimilarClickListener", "description", "setStatusDescription", "title", "setTitle", "setUnbindListener", "setViewedBadgeVisible", "Landroid/view/View;", "view", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class TestFavoriteAdvertItemViewHolder extends BaseViewHolder implements TestFavoriteAdvertItemView, FavoriteAdvertItemView {
    public final /* synthetic */ FavoriteAdvertItemViewImpl s;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FavoriteAdvertItem.Status.values();
            int[] iArr = new int[8];
            $EnumSwitchMapping$0 = iArr;
            iArr[6] = 1;
            iArr[5] = 2;
            iArr[2] = 3;
            iArr[1] = 4;
            iArr[7] = 5;
            iArr[3] = 6;
            iArr[4] = 7;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TestFavoriteAdvertItemViewHolder(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.s = new FavoriteAdvertItemViewImpl(view, timeSource, locale);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.s.getPictureUri(picture);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setActive(boolean z) {
        this.s.setActive(z);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setAddress(@Nullable String str) {
        this.s.setAddress(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.s.setClickListener(function0);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setCurrentPrice(@Nullable String str) {
        this.s.setCurrentPrice(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setDate(@Nullable Long l) {
        this.s.setDate(l);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setDeliveryVisible(boolean z) {
        this.s.setDeliveryVisible(z);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setFavorite(boolean z) {
        this.s.setFavorite(z);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setLocation(@Nullable String str) {
        this.s.setLocation(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setMoreButtonVisible(boolean z) {
        this.s.setMoreButtonVisible(z);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setMoreClickListener(@Nullable Function0<Unit> function0) {
        this.s.setMoreClickListener(function0);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setNote(@Nullable String str) {
        this.s.setNote(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        this.s.setOnFavoriteButtonClickListener(function0);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.s.setPicture(picture);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setPreviousPrice(@Nullable String str) {
        this.s.setPreviousPrice(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setShopName(@Nullable String str) {
        this.s.setShopName(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setSimilarButtonVisible(boolean z) {
        this.s.setSimilarButtonVisible(z);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setSimilarClickListener(@Nullable Function0<Unit> function0) {
        this.s.setSimilarClickListener(function0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    @Override // com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setStatus(@org.jetbrains.annotations.Nullable com.avito.android.favorites.adapter.advert.FavoriteAdvertItem.Status r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            goto L_0x0021
        L_0x0004:
            int r3 = r3.ordinal()
            switch(r3) {
                case 1: goto L_0x000c;
                case 2: goto L_0x000c;
                case 3: goto L_0x000c;
                case 4: goto L_0x000c;
                case 5: goto L_0x0013;
                case 6: goto L_0x001a;
                case 7: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0021
        L_0x000c:
            int r3 = com.avito.android.favorites.R.string.status_deleted
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0022
        L_0x0013:
            int r3 = com.avito.android.favorites.R.string.status_closed
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0022
        L_0x001a:
            int r3 = com.avito.android.favorites.R.string.status_expired
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0022
        L_0x0021:
            r3 = r0
        L_0x0022:
            if (r3 == 0) goto L_0x0037
            int r3 = r3.intValue()
            android.view.View r0 = r2.itemView
            java.lang.String r1 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.content.Context r0 = r0.getContext()
            java.lang.String r0 = r0.getString(r3)
        L_0x0037:
            r2.setStatusDescription(r0)
            return
            switch-data {1->0x000c, 2->0x000c, 3->0x000c, 4->0x000c, 5->0x0013, 6->0x001a, 7->0x000c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemViewHolder.setStatus(com.avito.android.favorites.adapter.advert.FavoriteAdvertItem$Status):void");
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setStatusDescription(@Nullable String str) {
        this.s.setStatusDescription(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s.setUnbindListener(function0);
    }

    @Override // com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView
    public void setViewedBadgeVisible(boolean z) {
        this.s.setViewedBadgeVisible(z);
    }
}
