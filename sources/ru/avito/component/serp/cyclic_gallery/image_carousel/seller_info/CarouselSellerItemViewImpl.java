package ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.design.widget.RatioFrameLayout;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.FloatsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00108\u001a\u000205¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J!\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u001f\u0010\"\u001a\u00020\u00052\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u00107R\u0016\u0010B\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u00103R\u0018\u0010&\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u00103R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010L\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u00103¨\u0006O"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemViewImpl;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "name", "", "setName", "(Ljava/lang/String;)V", "", "lineCount", "setNameMaxLines", "(I)V", "", "rating", "setRating", "(Ljava/lang/Float;)V", "reviewCount", "setReviewCount", "sellerTypeName", "setSellerTypeName", "Lcom/avito/android/image_loader/Picture;", "image", "", "isShop", "setLogo", "(Lcom/avito/android/image_loader/Picture;Z)V", "hideLogo", "()V", "verification", "setExternalVerification", "hideExternalVerification", "setInternalVerification", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "sidePadding", "setPadding", "widthRatio", "setWidthRatio", "(F)V", "Lcom/avito/android/lib/design/rating/RatingBar;", "w", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingBar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "logoView", "Landroid/widget/TextView;", "y", "Landroid/widget/TextView;", "internalVerificationView", "Landroid/view/View;", ExifInterface.LONGITUDE_EAST, "Landroid/view/View;", "view", "B", "externalVerificationIconGroup", "Lcom/avito/android/design/widget/RatioFrameLayout;", "s", "Lcom/avito/android/design/widget/RatioFrameLayout;", "ratioContainer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "internalVerificationIconGroup", "u", "nameView", "C", "Ljava/lang/Float;", "x", "reviewCountView", "D", "Lkotlin/jvm/functions/Function0;", "z", "externalVerificationView", VKApiConst.VERSION, "ratingNumberView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselSellerItemViewImpl extends BaseViewHolder implements CarouselSellerItemView {
    public final View A;
    public final View B;
    public Float C;
    public Function0<Unit> D;
    public final View E;
    public final RatioFrameLayout s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final RatingBar w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CarouselSellerItemViewImpl a;

        public a(CarouselSellerItemViewImpl carouselSellerItemViewImpl) {
            this.a = carouselSellerItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.D;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselSellerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.E = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.RatioFrameLayout");
        this.s = (RatioFrameLayout) view;
        View findViewById = view.findViewById(R.id.logo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.logo)");
        this.t = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.seller_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.seller_name)");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_number);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.rating_number)");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.rating_score);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.rating_score)");
        this.w = (RatingBar) findViewById4;
        View findViewById5 = view.findViewById(R.id.rating_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.rating_text)");
        this.x = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.verification_internal);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.verification_internal)");
        this.y = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.verification_external);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.verification_external)");
        this.z = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.group_verification_internal);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.g…up_verification_internal)");
        this.A = findViewById8;
        View findViewById9 = view.findViewById(R.id.group_verification_external);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.g…up_verification_external)");
        this.B = findViewById9;
        view.setOnClickListener(new a(this));
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void hideExternalVerification() {
        Views.hide(this.z);
        Views.hide(this.B);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void hideLogo() {
        Views.hide(this.t);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CarouselSellerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setExternalVerification(@Nullable String str) {
        TextViews.bindText$default(this.z, str, false, 2, null);
        Views.show(this.B);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setInternalVerification(@Nullable String str) {
        boolean z2 = false;
        TextViews.bindText$default(this.y, str, false, 2, null);
        View view = this.A;
        if (str != null) {
            if (str.length() > 0) {
                z2 = true;
            }
        }
        Views.setVisible(view, z2);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setLogo(@Nullable Picture picture, boolean z2) {
        int i;
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.t.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "logoView.hierarchy");
        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
        if (roundingParams == null) {
            roundingParams = new RoundingParams();
        }
        Intrinsics.checkNotNullExpressionValue(roundingParams, "logoView.hierarchy.round…arams ?: RoundingParams()");
        if (z2) {
            roundingParams.setRoundAsCircle(false);
            roundingParams.setCornersRadius(this.E.getResources().getDimension(R.dimen.rich_snippet_seller_info_rounding_radius));
            Context context = this.E.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            roundingParams.setOverlayColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray4));
            this.t.getLayoutParams().width = this.E.getResources().getDimensionPixelSize(R.dimen.rich_snippet_seller_info_shop_logo_width);
        } else {
            roundingParams.setRoundAsCircle(true);
            this.t.getLayoutParams().width = this.E.getResources().getDimensionPixelSize(R.dimen.rich_snippet_seller_info_user_logo_width);
        }
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) this.t.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy2, "logoView.hierarchy");
        genericDraweeHierarchy2.setRoundingParams(roundingParams);
        SimpleDraweeView simpleDraweeView = this.t;
        if (z2) {
            i = R.drawable.ic_shop_28_gray;
        } else {
            i = R.drawable.ic_user_28_gray;
        }
        SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, picture, Views.getDrawable(this.E, i), null, 4, null);
        Views.show(this.t);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.u.setText(str);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setNameMaxLines(int i) {
        this.u.setMaxLines(i);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.E.setClickable(function0 != null);
        this.D = function0;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setPadding(int i) {
        Views.changePadding$default(this.E, i, 0, i, 0, 10, null);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setRating(@Nullable Float f) {
        TextViews.bindText$default(this.v, f != null ? FloatsKt.formatWithSeparator$default(f.floatValue(), null, 0, 3, null) : null, false, 2, null);
        if (f != null) {
            this.w.setFloatingRatingIsEnabled(true);
            this.w.setRating(f.floatValue());
            Views.show(this.w);
            return;
        }
        Views.hide(this.w);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setReviewCount(@Nullable String str) {
        TextViews.bindText$default(this.x, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setSellerTypeName(@Nullable String str) {
        TextViews.bindText$default(this.z, str, false, 2, null);
        Views.hide(this.B);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItemView
    public void setWidthRatio(float f) {
        if (!Intrinsics.areEqual(this.C, f)) {
            this.s.setRatio(f);
            this.s.requestLayout();
            this.C = Float.valueOf(f);
        }
    }
}
