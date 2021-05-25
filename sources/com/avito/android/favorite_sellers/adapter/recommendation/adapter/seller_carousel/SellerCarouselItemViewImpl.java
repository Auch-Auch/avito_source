package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\bC\u0010DJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u001d\u0010\u001d\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u000eR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010:\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00105R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "subscribeClicks", "settingsClicks", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setUserAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setShopAvatar", "", "name", "setName", "(Ljava/lang/CharSequence;)V", "description", "setDescription", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;", "adverts", "setAdverts", "(Ljava/util/List;)V", "", "loading", "setSubscriptionButtonLoading", "(Z)V", "showSubscribeButton", "showSettingsButton", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "userAvatarView", "t", "shopAvatarView", "Lcom/avito/android/lib/design/button/Button;", "w", "Lcom/avito/android/lib/design/button/Button;", "subscribeButton", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "descriptionView", "x", "settingsButton", "u", "nameView", "z", "Lkotlin/jvm/functions/Function0;", "unbindListener", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlayView;", "y", "[Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlayView;", "advertViews", "<init>", "(Landroid/view/View;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCarouselItemViewImpl extends BaseViewHolder implements SellerCarouselItemView {
    public final View A;
    public final SimpleDraweeView s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final Button w;
    public final Button x;
    public final AdvertWithOverlayView[] y;
    public Function0<Unit> z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SellerCarouselItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.A = view;
        View findViewById = view.findViewById(R.id.user_avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_avatar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.btn_subscribe);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.w = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.btn_settings);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.x = (Button) findViewById6;
        View findViewById7 = view.findViewById(R.id.advert_image_container_1);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        View findViewById8 = view.findViewById(R.id.advert_image_container_2);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        View findViewById9 = view.findViewById(R.id.advert_image_container_3);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.y = new AdvertWithOverlayView[]{new AdvertWithOverlayView(findViewById7), new AdvertWithOverlayView(findViewById8), new AdvertWithOverlayView(findViewById9)};
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    @NotNull
    public Observable<Unit> clicks() {
        return InteropKt.toV3(RxView.clicks(this.A));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.z;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setAdverts(@NotNull List<AdvertWithOverlay> list) {
        Intrinsics.checkNotNullParameter(list, "adverts");
        AdvertWithOverlayView[] advertWithOverlayViewArr = this.y;
        int length = advertWithOverlayViewArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            advertWithOverlayViewArr[i].bind((AdvertWithOverlay) CollectionsKt___CollectionsKt.getOrNull(list, i2));
            i++;
            i2++;
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setName(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.u.setText(charSequence);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setShopAvatar(@Nullable Picture picture) {
        Views.conceal(this.s);
        Views.show(this.t);
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, null, 6, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setSubscriptionButtonLoading(boolean z2) {
        this.w.setLoading(z2);
        this.w.setEnabled(!z2);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.z = function0;
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void setUserAvatar(@Nullable Picture picture) {
        Views.conceal(this.t);
        Views.show(this.s);
        SimpleDraweeViewsKt.loadPicture$default(this.s, picture, null, null, 6, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    @NotNull
    public Observable<Unit> settingsClicks() {
        return InteropKt.toV3(RxView.clicks(this.x));
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void showSettingsButton() {
        Views.hide(this.w);
        Views.show(this.x);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    public void showSubscribeButton() {
        Views.show(this.w);
        Views.hide(this.x);
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemView
    @NotNull
    public Observable<Unit> subscribeClicks() {
        return InteropKt.toV3(RxView.clicks(this.w));
    }
}
