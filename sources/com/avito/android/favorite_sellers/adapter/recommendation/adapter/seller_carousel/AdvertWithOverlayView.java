package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import android.view.View;
import android.widget.TextView;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlayView;", "", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;", "advert", "", "bind", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "overlaySubtitleView", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "overlayContainer", "c", "overlayTitleView", "view", "<init>", "(Landroid/view/View;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertWithOverlayView {
    public final SimpleDraweeView a;
    public final View b;
    public final TextView c;
    public final TextView d;

    public AdvertWithOverlayView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.a = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.overlay_container);
        this.b = findViewById2;
        TextView textView = null;
        this.c = findViewById2 != null ? (TextView) findViewById2.findViewById(R.id.overlay_title) : null;
        this.d = findViewById2 != null ? (TextView) findViewById2.findViewById(R.id.overlay_subtitle) : textView;
    }

    public final void bind(@Nullable AdvertWithOverlay advertWithOverlay) {
        CharSequence charSequence = null;
        SimpleDraweeViewsKt.loadPicture$default(this.a, advertWithOverlay != null ? advertWithOverlay.getPicture() : null, null, null, 6, null);
        View view = this.b;
        CharSequence title = advertWithOverlay != null ? advertWithOverlay.getTitle() : null;
        Views.setVisible(view, !(title == null || m.isBlank(title)));
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(advertWithOverlay != null ? advertWithOverlay.getTitle() : null);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            if (advertWithOverlay != null) {
                charSequence = advertWithOverlay.getSubtitle();
            }
            textView2.setText(charSequence);
        }
    }
}
