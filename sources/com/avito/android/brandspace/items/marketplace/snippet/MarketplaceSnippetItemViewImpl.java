package com.avito.android.brandspace.items.marketplace.snippet;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.brandspace.R;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.BadgeBarsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00109\u001a\u000204¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010,R\u0019\u00109\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010;\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010=\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010,R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setAdvertPreviewImage", "(Lcom/avito/android/remote/model/Image;)V", "", "hasDelivery", "(Z)V", "", "text", "setAdvertName", "(Ljava/lang/String;)V", "price", "setPrice", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "setBadges", "(Ljava/util/List;)V", "", "any", "setTag", "(Ljava/lang/Object;)V", "oldPrice", "discountPercent", "setDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "t", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "sdvAdvertPreview", "Landroid/widget/TextView;", "y", "Landroid/widget/TextView;", "tvDiscountPercentage", "Landroid/widget/ImageView;", "u", "Landroid/widget/ImageView;", "ivHasDelivery", "x", "tvDiscount", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "w", "tvPrice", VKApiConst.VERSION, "tvName", "Landroid/view/ViewGroup;", "z", "Landroid/view/ViewGroup;", "vgMarketplaceDiscount", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSnippetItemViewImpl extends BaseViewHolder implements MarketplaceSnippetItemView {
    @NotNull
    public final View A;
    public final SimpleDraweeView s;
    public final CompactFlexibleLayout t;
    public final ImageView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final ViewGroup z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceSnippetItemViewImpl(@NotNull View view) {
        super(view);
        float[] cornersRadii;
        Intrinsics.checkNotNullParameter(view, "view");
        this.A = view;
        View findViewById = view.findViewById(R.id.sdv_advert_preview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.sdv_advert_preview)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.s = simpleDraweeView;
        View findViewById2 = view.findViewById(R.id.cfl_badgebar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.cfl_badgebar)");
        this.t = (CompactFlexibleLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_has_delivery);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.iv_has_delivery)");
        this.u = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_advert_name);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.tv_advert_name)");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_advert_price);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.tv_advert_price)");
        this.w = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_advert_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.tv_advert_discount)");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_advert_discount_percentage);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.t…vert_discount_percentage)");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.ill_advert_marketplace_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.i…ert_marketplace_discount)");
        this.z = (ViewGroup) findViewById8;
        View findViewById9 = view.findViewById(R.id.v_advert_preview_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById<View>(…v_advert_preview_overlay)");
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "sdvAdvertPreview.hierarchy");
        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
        if (!(roundingParams == null || (cornersRadii = roundingParams.getCornersRadii()) == null)) {
            Intrinsics.checkNotNullExpressionValue(cornersRadii, "sdvAdvertPreview.hierarc…s?.cornersRadii ?: return");
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            Paint paint = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setColor(ContextCompat.getColor(view.getContext(), com.avito.android.lib.design.R.color.expected_constant_black_alpha_4));
            shapeDrawable.setShape(new RoundRectShape(cornersRadii, null, null));
            findViewById9.setBackground(shapeDrawable);
        }
        Views.changePadding(simpleDraweeView, simpleDraweeView.getResources().getDimensionPixelSize(R.dimen.marketplace_snippet_vertical));
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy2, "hierarchy");
        genericDraweeHierarchy2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    }

    @NotNull
    public final View getView() {
        return this.A;
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void hasDelivery(boolean z2) {
        Views.setVisible(this.u, z2);
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setAdvertName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.v.setText(str);
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setAdvertPreviewImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).retainImage(true).noFadeAnimation(true).load();
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setBadges(@Nullable List<SerpBadge> list) {
        BadgeBarsKt.bindBadges$default(this.t, list, null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDiscount(@org.jetbrains.annotations.Nullable java.lang.String r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r6 = this;
            android.widget.TextView r0 = r6.y
            r0.setText(r8)
            android.widget.TextView r0 = r6.x
            r1 = 0
            if (r7 == 0) goto L_0x001e
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r7)
            android.text.style.StrikethroughSpan r3 = new android.text.style.StrikethroughSpan
            r3.<init>()
            int r4 = r7.length()
            r5 = 33
            r2.setSpan(r3, r1, r4, r5)
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            r0.setText(r2)
            android.view.ViewGroup r0 = r6.z
            r2 = 1
            if (r7 == 0) goto L_0x0034
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x002f
            r7 = 1
            goto L_0x0030
        L_0x002f:
            r7 = 0
        L_0x0030:
            if (r7 == 0) goto L_0x0034
            r7 = 1
            goto L_0x0035
        L_0x0034:
            r7 = 0
        L_0x0035:
            if (r7 == 0) goto L_0x004a
            if (r8 == 0) goto L_0x0046
            int r7 = r8.length()
            if (r7 <= 0) goto L_0x0041
            r7 = 1
            goto L_0x0042
        L_0x0041:
            r7 = 0
        L_0x0042:
            if (r7 == 0) goto L_0x0046
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            if (r7 == 0) goto L_0x004a
            r1 = 1
        L_0x004a:
            com.avito.android.util.Views.setVisible(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemViewImpl.setDiscount(java.lang.String, java.lang.String):void");
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setOnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.A.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "price");
        this.w.setText(str);
    }

    @Override // com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView
    public void setTag(@Nullable Object obj) {
        this.A.setTag(obj);
    }
}
