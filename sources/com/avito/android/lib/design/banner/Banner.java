package com.avito.android.lib.design.banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.close_button.CloseButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001aB1\b\u0007\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\b\u0002\u0010]\u001a\u00020\u0003\u0012\b\b\u0002\u0010^\u001a\u00020\u0003¢\u0006\u0004\b_\u0010`J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u00052\b\b\u0001\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u00052\b\b\u0001\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\u001fJ5\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0019\u0010=\u001a\u0002088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR(\u0010J\u001a\u0004\u0018\u00010\b2\b\u0010F\u001a\u0004\u0018\u00010\b8\u0006@BX\u000e¢\u0006\f\n\u0004\bG\u00106\u001a\u0004\bH\u0010IR\u0019\u0010P\u001a\u00020K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006b"}, d2 = {"Lcom/avito/android/lib/design/banner/Banner;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "", "visible", "setCloseButtonVisible", "(Z)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseButtonListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/content/res/ColorStateList;", "color", "rippleColor", "setBackground", "(Landroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "layoutRes", "styleAttr", "setContentByAttr", "(II)V", "styleRes", "setContentByRes", "marginLeft", "marginTop", "marginRight", "marginBottom", "setImageMargins", "(IIII)V", "Landroid/graphics/drawable/Drawable;", "image", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/widget/ImageView$ScaleType;", "scaleType", "setImageScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "Landroid/content/res/TypedArray;", "array", "overrideContentLayoutRes", "h", "(Landroid/content/res/TypedArray;Ljava/lang/Integer;)V", "r", "Landroid/view/View;", "crossAndImageContainer", "Lcom/avito/android/lib/design/banner/BannerContent;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/banner/BannerContent;", "getContent", "()Lcom/avito/android/lib/design/banner/BannerContent;", "content", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "p", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "backgroundShape", "Landroid/widget/ImageView;", "s", "Landroid/widget/ImageView;", "imageView", "<set-?>", "u", "getContentView", "()Landroid/view/View;", "contentView", "Lcom/avito/android/design/ImageLoadable;", "w", "Lcom/avito/android/design/ImageLoadable;", "getImageContainer", "()Lcom/avito/android/design/ImageLoadable;", "imageContainer", "Landroid/view/ViewGroup;", VKApiConst.Q, "Landroid/view/ViewGroup;", "container", "Lcom/avito/android/lib/design/close_button/CloseButton;", "t", "Lcom/avito/android/lib/design/close_button/CloseButton;", "closeButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ImageLoadableDelegate", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Banner extends LinearLayoutCompat implements AppearanceChangeableView {
    public ShapeAppearanceModel p;
    public ViewGroup q;
    public View r;
    public ImageView s;
    public CloseButton t;
    @Nullable
    public View u;
    @NotNull
    public final BannerContent v;
    @NotNull
    public final ImageLoadable w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/lib/design/banner/Banner$ImageLoadableDelegate;", "Lcom/avito/android/design/ImageLoadable;", "Landroid/view/View;", "c", "Landroid/view/View;", "getImageContainerView", "()Landroid/view/View;", "setImageContainerView", "(Landroid/view/View;)V", "imageContainerView", "Landroid/graphics/drawable/Drawable;", "value", AuthSource.SEND_ABUSE, "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", "Lcom/avito/android/design/State;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/State;", "getState", "()Lcom/avito/android/design/State;", "setState", "(Lcom/avito/android/design/State;)V", "state", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageLoadableDelegate implements ImageLoadable {
        @Nullable
        public Drawable a;
        @NotNull
        public State b = State.PLACEHOLDER;
        @Nullable
        public View c;

        @Override // com.avito.android.design.ImageLoadable
        @Nullable
        public Drawable getImage() {
            return this.a;
        }

        @Override // com.avito.android.design.ImageLoadable
        @Nullable
        public View getImageContainerView() {
            return this.c;
        }

        @Override // com.avito.android.design.ImageLoadable
        @NotNull
        public State getState() {
            return this.b;
        }

        @Override // com.avito.android.design.ImageLoadable
        public void setImage(@Nullable Drawable drawable) {
            this.a = drawable;
            View imageContainerView = getImageContainerView();
            if (!(imageContainerView instanceof ImageView)) {
                imageContainerView = null;
            }
            ImageView imageView = (ImageView) imageContainerView;
            if (imageView != null) {
                imageView.setImageDrawable(getImage());
                Views.setVisible(imageView, getImage() != null);
            }
        }

        @Override // com.avito.android.design.ImageLoadable
        public void setImageContainerView(@Nullable View view) {
            this.c = view;
        }

        @Override // com.avito.android.design.ImageLoadable
        public void setState(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.b = state;
        }
    }

    @JvmOverloads
    public Banner(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public Banner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public Banner(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Banner(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.banner : i, (i3 & 8) != 0 ? R.style.Design_Widget_Banner : i2);
    }

    public static void setImageMargins$default(Banner banner, int i, int i2, int i3, int i4, int i5, Object obj) {
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if ((i5 & 1) != 0) {
            ImageView imageView = banner.s;
            ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            i = marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0;
        }
        if ((i5 & 2) != 0) {
            ImageView imageView2 = banner.s;
            ViewGroup.LayoutParams layoutParams2 = imageView2 != null ? imageView2.getLayoutParams() : null;
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
            i2 = marginLayoutParams3 != null ? marginLayoutParams3.topMargin : 0;
        }
        if ((i5 & 4) != 0) {
            ImageView imageView3 = banner.s;
            ViewGroup.LayoutParams layoutParams3 = imageView3 != null ? imageView3.getLayoutParams() : null;
            if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams3 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams3;
            i3 = marginLayoutParams4 != null ? marginLayoutParams4.rightMargin : 0;
        }
        if ((i5 & 8) != 0) {
            ImageView imageView4 = banner.s;
            ViewGroup.LayoutParams layoutParams4 = imageView4 != null ? imageView4.getLayoutParams() : null;
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams4;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = marginLayoutParams;
            i4 = marginLayoutParams5 != null ? marginLayoutParams5.bottomMargin : 0;
        }
        banner.setImageMargins(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.container;
        if (valueOf != null && valueOf.intValue() == i2) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            this.q = (ViewGroup) view;
        } else {
            int i3 = R.id.image_container;
            if (valueOf == null || valueOf.intValue() != i3) {
                throw new UnsupportedOperationException("Operation addView isn't supported. You should use setContentByRes");
            }
            this.r = view;
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.widget.ImageView");
            this.s = imageView;
            this.w.setImageContainerView(imageView);
            CloseButton closeButton = (CloseButton) view.findViewById(R.id.close_button);
            Objects.requireNonNull(closeButton, "null cannot be cast to non-null type com.avito.android.lib.design.close_button.CloseButton");
            this.t = closeButton;
        }
        super.addView(view, i, layoutParams);
    }

    @NotNull
    public final BannerContent getContent() {
        return this.v;
    }

    @Nullable
    public final View getContentView() {
        return this.u;
    }

    @NotNull
    public final ImageLoadable getImageContainer() {
        return this.w;
    }

    public final void h(TypedArray typedArray, Integer num) {
        int i;
        int i2;
        int i3;
        int i4;
        ImageView imageView;
        ImageView imageView2;
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView3;
        ViewGroup.LayoutParams layoutParams2;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.Banner_banner_backgroundColor);
            ColorStateList colorStateList2 = typedArray.getColorStateList(R.styleable.Banner_banner_backgroundRipple);
            this.p = ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(R.styleable.Banner_banner_backgroundShape, 0), 0).build();
            setBackground(colorStateList, colorStateList2);
            int i5 = R.styleable.Banner_banner_contentMargin;
            if (typedArray.hasValue(i5)) {
                i4 = typedArray.getDimensionPixelSize(i5, 0);
                i3 = i4;
                i2 = i3;
                i = i2;
            } else {
                i4 = typedArray.getDimensionPixelSize(R.styleable.Banner_banner_contentMarginLeft, 0);
                i3 = typedArray.getDimensionPixelSize(R.styleable.Banner_banner_contentMarginTop, 0);
                i2 = typedArray.getDimensionPixelSize(R.styleable.Banner_banner_contentMarginRight, 0);
                i = typedArray.getDimensionPixelSize(R.styleable.Banner_banner_contentMarginBottom, 0);
            }
            viewGroup.setPadding(i4, i3, i2, i);
            CloseButton closeButton = this.t;
            if (closeButton != null) {
                closeButton.setAppearance(typedArray.getResourceId(R.styleable.Banner_banner_closeStyle, 0));
            }
            View inflate = LayoutInflater.from(new ContextThemeWrapper(getContext(), typedArray.getResourceId(R.styleable.Banner_banner_contentStyle, 0))).inflate(num != null ? num.intValue() : typedArray.getResourceId(R.styleable.Banner_banner_content, 0), viewGroup, false);
            this.u = inflate;
            this.v.attachView$components_release(inflate);
            viewGroup.removeAllViews();
            viewGroup.addView(this.u, 0);
            setImageMargins$default(this, 0, typedArray.getDimensionPixelOffset(R.styleable.Banner_banner_imageMarginTop, 0), typedArray.getDimensionPixelOffset(R.styleable.Banner_banner_imageMarginRight, 0), typedArray.getDimensionPixelOffset(R.styleable.Banner_banner_imageMarginBottom, 0), 1, null);
            setImageDrawable(typedArray.getDrawable(R.styleable.Banner_banner_image));
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R.styleable.Banner_banner_imageContainerMarginLeft, 0);
            View view = this.r;
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            ViewGroup.LayoutParams layoutParams3 = view != null ? view.getLayoutParams() : null;
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams3;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.leftMargin = dimensionPixelOffset;
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(typedArray.getResourceId(R.styleable.Banner_banner_imageStyle, 0), R.styleable.BannerImage);
            int i6 = R.styleable.BannerImage_android_minWidth;
            if (obtainStyledAttributes.hasValue(i6) && (imageView7 = this.s) != null) {
                imageView7.setMinimumWidth(obtainStyledAttributes.getDimensionPixelOffset(i6, 0));
            }
            int i7 = R.styleable.BannerImage_android_minHeight;
            if (obtainStyledAttributes.hasValue(i7) && (imageView6 = this.s) != null) {
                imageView6.setMinimumHeight(obtainStyledAttributes.getDimensionPixelOffset(i7, 0));
            }
            int i8 = R.styleable.BannerImage_android_maxWidth;
            if (obtainStyledAttributes.hasValue(i8) && (imageView5 = this.s) != null) {
                imageView5.setMaxWidth(obtainStyledAttributes.getDimensionPixelOffset(i8, 0));
            }
            int i9 = R.styleable.BannerImage_android_maxHeight;
            if (obtainStyledAttributes.hasValue(i9) && (imageView4 = this.s) != null) {
                imageView4.setMaxHeight(obtainStyledAttributes.getDimensionPixelOffset(i9, 0));
            }
            int i10 = R.styleable.BannerImage_android_width;
            if (!(!obtainStyledAttributes.hasValue(i10) || (imageView3 = this.s) == null || (layoutParams2 = imageView3.getLayoutParams()) == null)) {
                layoutParams2.width = obtainStyledAttributes.getDimensionPixelOffset(i10, 0);
            }
            int i11 = R.styleable.BannerImage_android_height;
            if (!(!obtainStyledAttributes.hasValue(i11) || (imageView2 = this.s) == null || (layoutParams = imageView2.getLayoutParams()) == null)) {
                layoutParams.height = obtainStyledAttributes.getDimensionPixelOffset(i11, 0);
            }
            int i12 = R.styleable.BannerImage_android_adjustViewBounds;
            if (obtainStyledAttributes.hasValue(i12) && (imageView = this.s) != null) {
                imageView.setAdjustViewBounds(obtainStyledAttributes.getBoolean(i12, false));
            }
            int i13 = R.styleable.BannerImage_android_scaleType;
            if (obtainStyledAttributes.hasValue(i13)) {
                int i14 = obtainStyledAttributes.getInt(i13, 0);
                ImageView imageView8 = this.s;
                if (imageView8 != null) {
                    imageView8.setScaleType(ImageView.ScaleType.values()[i14]);
                }
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("Banner hasn't been initialized yet");
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.Banner);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        h(obtainStyledAttributes, null);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setBackground(@Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        ShapeAppearanceModel shapeAppearanceModel = this.p;
        if (shapeAppearanceModel != null) {
            setBackground(ShapeStateDrawable.Companion.invoke$default(ShapeStateDrawable.Companion, shapeAppearanceModel, 0, 0, 0, 0, colorStateList, colorStateList2, 30, null));
        }
    }

    public final void setCloseButtonListener(@Nullable View.OnClickListener onClickListener) {
        CloseButton closeButton = this.t;
        if (closeButton != null) {
            closeButton.setOnClickListener(onClickListener);
        }
    }

    public final void setCloseButtonVisible(boolean z) {
        CloseButton closeButton = this.t;
        if (closeButton != null) {
            Views.setVisible(closeButton, z);
        }
    }

    public final void setContentByAttr(@LayoutRes int i, @AttrRes int i2) {
        setContentByRes(i, Contexts.getResourceIdByAttr(getContext(), i2));
    }

    public final void setContentByRes(@LayoutRes int i, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.Banner, 0, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        h(obtainStyledAttributes, Integer.valueOf(i));
        obtainStyledAttributes.recycle();
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            Views.setVisible(imageView2, drawable != null);
        }
    }

    public final void setImageMargins(int i, int i2, int i3, int i4) {
        ImageView imageView = this.s;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.topMargin = i2;
            marginLayoutParams2.bottomMargin = i4;
            marginLayoutParams2.leftMargin = i;
            marginLayoutParams2.rightMargin = i3;
        }
    }

    public final void setImageScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Banner(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.w = new ImageLoadableDelegate();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_banner, (ViewGroup) this, true);
        this.v = new BannerContent(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        h(obtainStyledAttributes, null);
        setCloseButtonVisible(obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_closeVisible, false));
        obtainStyledAttributes.recycle();
    }
}
