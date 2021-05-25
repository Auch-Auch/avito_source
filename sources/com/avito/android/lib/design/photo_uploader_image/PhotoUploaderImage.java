package com.avito.android.lib.design.photo_uploader_image;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.avito.android.util.drawable.ShapeStateDrawable;
import com.avito.android.util.drawable.StatefulShapeDrawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\b\u0007\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0017\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0017¢\u0006\u0006\b\u0001\u0010\u0001J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0013J7\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0006J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u0004*\u00020&2\b\b\u0001\u0010\u001e\u001a\u00020\u0017H\u0003¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0003¢\u0006\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R*\u00106\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010 R\u0016\u00109\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R*\u0010=\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u0010 R*\u0010A\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\b>\u00102\u001a\u0004\b?\u00104\"\u0004\b@\u0010 R\"\u0010I\u001a\u00020B8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010M\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\bJ\u00102\u001a\u0004\bK\u00104\"\u0004\bL\u0010 R*\u0010Q\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\bN\u00102\u001a\u0004\bO\u00104\"\u0004\bP\u0010 R\u0016\u0010S\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bR\u00108R\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bX\u00108R*\u0010]\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0012\n\u0004\bZ\u00102\u001a\u0004\b[\u00104\"\u0004\b\\\u0010 R$\u0010b\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b^\u0010.\u001a\u0004\b_\u0010`\"\u0004\ba\u0010%R\u0016\u0010d\u001a\u00020\"8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bc\u0010.R\u0016\u0010f\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\be\u00108R\u0018\u0010h\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010VR(\u0010n\u001a\u0004\u0018\u00010i2\b\u00100\u001a\u0004\u0018\u00010i8V@VX\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010VR\u0016\u0010v\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bu\u00108R\u0016\u0010x\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bw\u00108R\u0018\u0010z\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010VR-\u0010\u0001\u001a\u00020{2\u0006\u00100\u001a\u00020{8\u0006@FX\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\"\u0006\b\u0001\u0010\u0001R-\u0010\u0001\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@FX\u000e¢\u0006\u0014\n\u0004\b}\u00102\u001a\u0005\b\u0001\u00104\"\u0005\b\u0001\u0010 R\u0018\u0010\u0001\u001a\u00020&8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b\u0001\u00108R \u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/photo_uploader_image/PhotoUploaderImage;", "Landroidx/cardview/widget/CardView;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "Lcom/avito/android/design/ImageLoadable;", "", "showProgressBar", "()V", "showRemoveOverlay", "showContent", "showErrorOverlay", "", "showRetry", "showErrorActionsOverlay", "(Z)V", "visible", "setWarningBadgeVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setErrorClickedListener", "(Lkotlin/jvm/functions/Function0;)V", "setRetryClickedListener", "setRemoveClickedListener", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "(I)V", "c", "Landroid/view/View;", "view", "d", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "e", "(Landroid/widget/ImageView;I)V", "Landroid/content/res/TypedArray;", "array", AuthSource.BOOKING_ORDER, "(Landroid/content/res/TypedArray;)V", "p", "Landroid/view/View;", "errorActionsContainer", "value", "D", "I", "getWarningIconStyle", "()I", "setWarningIconStyle", "warningIconStyle", "k", "Landroid/widget/ImageView;", "overlayView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getActionsPadding", "setActionsPadding", "actionsPadding", "G", "getMajorRemoveIconStyle", "setMajorRemoveIconStyle", "majorRemoveIconStyle", "Lcom/avito/android/design/State;", "H", "Lcom/avito/android/design/State;", "getState", "()Lcom/avito/android/design/State;", "setState", "(Lcom/avito/android/design/State;)V", "state", "B", "getSpinnerStyle", "setSpinnerStyle", "spinnerStyle", ExifInterface.LONGITUDE_EAST, "getMinorRemoveIconStyle", "setMinorRemoveIconStyle", "minorRemoveIconStyle", "n", "warningIcon", "Landroid/content/res/ColorStateList;", "u", "Landroid/content/res/ColorStateList;", "overlayColor", AuthSource.OPEN_CHANNEL_LIST, "minorRemoveIcon", "C", "getErrorIconStyle", "setErrorIconStyle", "errorIconStyle", "y", "getImageContainerView", "()Landroid/view/View;", "setImageContainerView", "imageContainerView", "r", "minorRetryIconContainer", "l", "majorRemoveIcon", "w", "spinnerOverlayRipple", "Landroid/graphics/drawable/Drawable;", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "image", "Lcom/avito/android/lib/design/spinner/Spinner;", "s", "Lcom/avito/android/lib/design/spinner/Spinner;", "spinner", "x", "removeOverlayColor", "j", "imageView", "o", "errorIcon", VKApiConst.VERSION, "overlayRipple", "", "z", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "getMinorRetryIconStyle", "setMinorRetryIconStyle", "minorRetryIconStyle", VKApiConst.Q, "minorRetryIcon", "", "t", "Ljava/util/List;", "topViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploaderImage extends CardView implements AppearanceChangeableView, ImageLoadable {
    public int A;
    @StyleRes
    public int B;
    @StyleRes
    public int C;
    @StyleRes
    public int D;
    @StyleRes
    public int E;
    @StyleRes
    public int F;
    @StyleRes
    public int G;
    @NotNull
    public State H;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public View p;
    public ImageView q;
    public View r;
    public Spinner s;
    public List<? extends View> t;
    public ColorStateList u;
    public ColorStateList v;
    public ColorStateList w;
    public ColorStateList x;
    @Nullable
    public View y;
    public float z;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((Function0) this.b).invoke();
            } else if (i == 1) {
                ((Function0) this.b).invoke();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    @JvmOverloads
    public PhotoUploaderImage(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public PhotoUploaderImage(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public PhotoUploaderImage(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploaderImage(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.photoUploaderImage : i, (i3 & 8) != 0 ? R.style.Design_Widget_PhotoUploaderImage : i2);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void b(TypedArray typedArray) {
        Integer num;
        int i = R.styleable.PhotoUploaderImage_photoUploaderImage_cornerRadius;
        if (typedArray.hasValue(i)) {
            setCornerRadius(typedArray.getDimension(i, this.z));
            c();
        }
        int i2 = R.styleable.PhotoUploaderImage_photoUploaderImage_actionsPadding;
        if (typedArray.hasValue(i2)) {
            setActionsPadding(typedArray.getDimensionPixelSize(i2, this.A));
        }
        int i3 = R.styleable.PhotoUploaderImage_photoUploaderImage_spinnerStyle;
        if (typedArray.hasValue(i3)) {
            setSpinnerStyle(typedArray.getResourceId(i3, this.B));
        }
        int i4 = R.styleable.PhotoUploaderImage_photoUploaderImage_minorRemoveIcon;
        if (typedArray.hasValue(i4)) {
            ImageView imageView = this.m;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minorRemoveIcon");
            }
            imageView.setImageDrawable(typedArray.getDrawable(i4));
        }
        int i5 = R.styleable.PhotoUploaderImage_photoUploaderImage_minorRemoveIconStyle;
        int i6 = 0;
        if (typedArray.hasValue(i5)) {
            setMinorRemoveIconStyle(typedArray.getResourceId(i5, 0));
        }
        int i7 = R.styleable.PhotoUploaderImage_photoUploaderImage_minorRetryIcon;
        if (typedArray.hasValue(i7)) {
            ImageView imageView2 = this.q;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minorRetryIcon");
            }
            imageView2.setImageDrawable(typedArray.getDrawable(i7));
        }
        int i8 = R.styleable.PhotoUploaderImage_photoUploaderImage_minorRetryIconStyle;
        if (typedArray.hasValue(i8)) {
            setMinorRetryIconStyle(typedArray.getResourceId(i8, 0));
        }
        int i9 = R.styleable.PhotoUploaderImage_photoUploaderImage_majorRemoveIcon;
        if (typedArray.hasValue(i9)) {
            ImageView imageView3 = this.l;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
            }
            imageView3.setImageDrawable(typedArray.getDrawable(i9));
        }
        int i10 = R.styleable.PhotoUploaderImage_photoUploaderImage_majorRemoveIconStyle;
        if (typedArray.hasValue(i10)) {
            setMajorRemoveIconStyle(typedArray.getResourceId(i10, 0));
        }
        int i11 = R.styleable.PhotoUploaderImage_photoUploaderImage_errorIcon;
        if (typedArray.hasValue(i11)) {
            ImageView imageView4 = this.o;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
            }
            imageView4.setImageDrawable(typedArray.getDrawable(i11));
        }
        int i12 = R.styleable.PhotoUploaderImage_photoUploaderImage_errorIconStyle;
        if (typedArray.hasValue(i12)) {
            setErrorIconStyle(typedArray.getResourceId(i12, 0));
        }
        int i13 = R.styleable.PhotoUploaderImage_photoUploaderImage_warningIcon;
        if (typedArray.hasValue(i13)) {
            ImageView imageView5 = this.n;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("warningIcon");
            }
            imageView5.setImageDrawable(typedArray.getDrawable(i13));
        }
        int i14 = R.styleable.PhotoUploaderImage_photoUploaderImage_warningIconMargin;
        if (typedArray.hasValue(i14)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i14, 0);
            ImageView imageView6 = this.n;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("warningIcon");
            }
            Views.changeMargin(imageView6, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        }
        int i15 = R.styleable.PhotoUploaderImage_photoUploaderImage_warningIconStyle;
        if (typedArray.hasValue(i15)) {
            setWarningIconStyle(typedArray.getResourceId(i15, 0));
        }
        int i16 = R.styleable.PhotoUploaderImage_photoUploaderImage_backgroundColor;
        if (typedArray.hasValue(i16)) {
            ImageView imageView7 = this.j;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            }
            StatefulShapeDrawable statefulShapeDrawable = new StatefulShapeDrawable(new RectShape());
            statefulShapeDrawable.setColor(typedArray.getColorStateList(i16));
            Views.setBackgroundCompat(imageView7, statefulShapeDrawable);
        }
        int[] iArr = {R.styleable.PhotoUploaderImage_photoUploaderImage_overlayColor, R.styleable.PhotoUploaderImage_photoUploaderImage_rippleColor};
        while (true) {
            if (i6 >= 2) {
                num = null;
                break;
            }
            int i17 = iArr[i6];
            if (typedArray.hasValue(i17)) {
                num = Integer.valueOf(i17);
                break;
            }
            i6++;
        }
        if (num != null) {
            num.intValue();
            this.u = typedArray.getColorStateList(R.styleable.PhotoUploaderImage_photoUploaderImage_overlayColor);
            ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.PhotoUploaderImage_photoUploaderImage_rippleColor);
            this.v = colorStateList;
            this.w = colorStateList;
            this.x = this.u;
            ImageView imageView8 = this.k;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("overlayView");
            }
            Views.setBackgroundCompat(imageView8, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.u, this.v, 0, null, 0, 0, 0, 124, null));
        }
        int i18 = R.styleable.PhotoUploaderImage_photoUploaderImage_spinnerRippleColor;
        if (typedArray.hasValue(i18)) {
            this.w = typedArray.getColorStateList(i18);
        }
        int i19 = R.styleable.PhotoUploaderImage_photoUploaderImage_majorRemoveOverlay;
        if (typedArray.hasValue(i19)) {
            this.x = typedArray.getColorStateList(i19);
        }
    }

    public final void c() {
        float min = ((float) Math.min(getHeight(), getWidth())) / 2.0f;
        float f = this.z;
        if (min > f) {
            min = f;
        }
        setRadius(min);
    }

    public final void d(View view) {
        List<? extends View> list = this.t;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topViews");
        }
        ArrayList<View> arrayList = new ArrayList();
        for (T t2 : list) {
            if (!Intrinsics.areEqual(t2, view)) {
                arrayList.add(t2);
            }
        }
        for (View view2 : arrayList) {
            Views.conceal(view2);
        }
        Views.show(view);
    }

    @SuppressLint({"CustomViewStyleable"})
    public final void e(ImageView imageView, @StyleRes int i) {
        TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes(i, R.styleable.PhotoUploaderImage_Icon);
        ImageViewsKt.setImageTintListCompat(imageView, obtainStyledAttributes.getColorStateList(R.styleable.PhotoUploaderImage_Icon_photoUploaderImage_iconTint));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PhotoUploaderImage_Icon_photoUploaderImage_iconSize, 0);
        imageView.getLayoutParams().width = dimensionPixelSize;
        imageView.getLayoutParams().height = dimensionPixelSize;
        int i2 = R.styleable.PhotoUploaderImage_Icon_photoUploaderImage_iconBackgroundColor;
        ShapeStateDrawable.Companion companion = ShapeStateDrawable.Companion;
        Views.setBackgroundCompat(imageView, ShapeStateDrawable.Companion.invoke$default(companion, companion.getSHAPE_OVAL(), 0, 0, 0, 0, obtainStyledAttributes.getColorStateList(i2), obtainStyledAttributes.getColorStateList(R.styleable.PhotoUploaderImage_Icon_photoUploaderImage_iconRippleColor), 30, null));
        obtainStyledAttributes.recycle();
    }

    public final int getActionsPadding() {
        return this.A;
    }

    public final float getCornerRadius() {
        return this.z;
    }

    public final int getErrorIconStyle() {
        return this.C;
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public Drawable getImage() {
        ImageView imageView = this.j;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        return imageView.getDrawable();
    }

    @Override // com.avito.android.design.ImageLoadable
    @Nullable
    public View getImageContainerView() {
        return this.y;
    }

    public final int getMajorRemoveIconStyle() {
        return this.G;
    }

    public final int getMinorRemoveIconStyle() {
        return this.E;
    }

    public final int getMinorRetryIconStyle() {
        return this.F;
    }

    public final int getSpinnerStyle() {
        return this.B;
    }

    @Override // com.avito.android.design.ImageLoadable
    @NotNull
    public State getState() {
        return this.H;
    }

    public final int getWarningIconStyle() {
        return this.D;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        c();
    }

    public final void setActionsPadding(int i) {
        this.A = i;
        View view = this.p;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorActionsContainer");
        }
        Views.changePadding$default(view, i, 0, i, 0, 10, null);
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(@StyleRes int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i, R.styleable.PhotoUploaderImage);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        requestLayout();
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i);
    }

    public final void setCornerRadius(float f) {
        this.z = f;
        c();
    }

    public final void setErrorClickedListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            ImageView imageView = this.o;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
            }
            imageView.setOnClickListener(new b(function0));
            return;
        }
        ImageView imageView2 = this.o;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
        }
        imageView2.setOnClickListener(null);
    }

    public final void setErrorIconStyle(int i) {
        this.C = i;
        ImageView imageView = this.o;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
        }
        e(imageView, this.C);
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImage(@Nullable Drawable drawable) {
        ImageView imageView = this.j;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setImageContainerView(@Nullable View view) {
        this.y = view;
    }

    public final void setMajorRemoveIconStyle(int i) {
        this.G = i;
        ImageView imageView = this.l;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
        }
        e(imageView, this.G);
    }

    public final void setMinorRemoveIconStyle(int i) {
        this.E = i;
        ImageView imageView = this.m;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minorRemoveIcon");
        }
        e(imageView, this.E);
    }

    public final void setMinorRetryIconStyle(int i) {
        this.F = i;
        ImageView imageView = this.q;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minorRetryIcon");
        }
        e(imageView, this.F);
    }

    public final void setRemoveClickedListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            ImageView imageView = this.l;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
            }
            imageView.setOnClickListener(new a(0, function0));
            ImageView imageView2 = this.m;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minorRemoveIcon");
            }
            imageView2.setOnClickListener(new a(1, function0));
            return;
        }
        ImageView imageView3 = this.l;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
        }
        imageView3.setOnClickListener(null);
        ImageView imageView4 = this.m;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minorRemoveIcon");
        }
        imageView4.setOnClickListener(null);
    }

    public final void setRetryClickedListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            ImageView imageView = this.q;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("minorRetryIcon");
            }
            imageView.setOnClickListener(new c(function0));
            return;
        }
        ImageView imageView2 = this.q;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minorRetryIcon");
        }
        imageView2.setOnClickListener(null);
    }

    public final void setSpinnerStyle(int i) {
        this.B = i;
        Spinner spinner = this.s;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spinner");
        }
        spinner.setAppearance(i);
    }

    @Override // com.avito.android.design.ImageLoadable
    public void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.H = state;
    }

    public final void setWarningBadgeVisible(boolean z2) {
        ImageView imageView = this.n;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningIcon");
        }
        Views.setVisible(imageView, z2);
    }

    public final void setWarningIconStyle(int i) {
        this.D = i;
        ImageView imageView = this.n;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningIcon");
        }
        e(imageView, this.D);
    }

    public final void showContent() {
        ImageView imageView = this.k;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        Views.setBackgroundCompat(imageView, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, null, this.v, 0, null, 0, 0, 0, 125, null));
        ImageView imageView2 = this.k;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        imageView2.setClickable(false);
        List<? extends View> list = this.t;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topViews");
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Views.conceal(it.next());
        }
    }

    public final void showErrorActionsOverlay(boolean z2) {
        ImageView imageView = this.k;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        Views.setBackgroundCompat(imageView, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.u, null, 0, null, 0, 0, 0, 124, null));
        ImageView imageView2 = this.k;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        imageView2.setClickable(false);
        View view = this.r;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("minorRetryIconContainer");
        }
        Views.setVisible(view, z2);
        View view2 = this.p;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorActionsContainer");
        }
        d(view2);
    }

    public final void showErrorOverlay() {
        ImageView imageView = this.k;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        Views.setBackgroundCompat(imageView, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.u, null, 0, null, 0, 0, 0, 124, null));
        ImageView imageView2 = this.k;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        imageView2.setClickable(true);
        ImageView imageView3 = this.o;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
        }
        d(imageView3);
    }

    public final void showProgressBar() {
        ImageView imageView = this.k;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        Views.setBackgroundCompat(imageView, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.u, this.w, 0, null, 0, 0, 0, 124, null));
        ImageView imageView2 = this.k;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        imageView2.setClickable(false);
        Spinner spinner = this.s;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spinner");
        }
        d(spinner);
    }

    public final void showRemoveOverlay() {
        ImageView imageView = this.k;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        Views.setBackgroundCompat(imageView, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.x, null, 0, null, 0, 0, 0, 124, null));
        ImageView imageView2 = this.k;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayView");
        }
        imageView2.setClickable(true);
        ImageView imageView3 = this.l;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
        }
        d(imageView3);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c9: APUT  (r5v34 android.view.View[]), (0 ??[int, short, byte, char]), (r0v3 com.avito.android.lib.design.spinner.Spinner) */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PhotoUploaderImage(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhotoUploaderImage, i, i2);
        LayoutInflater.from(getContext()).inflate(obtainStyledAttributes.getResourceId(R.styleable.PhotoUploaderImage_photoUploaderImage_layout, R.layout.photo_uploader_image), (ViewGroup) this, true);
        setCardElevation(0.0f);
        setPreventCornerOverlap(false);
        setUseCompatPadding(false);
        setLayoutTransition(new LayoutTransition());
        View findViewById = findViewById(R.id.image_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.j = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.overlay_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.k = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.progress_bar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.spinner.Spinner");
        this.s = (Spinner) findViewById3;
        View findViewById4 = findViewById(R.id.big_delete_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.l = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.warning_icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.n = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.error_icon);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        this.o = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.error_actions_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.p = findViewById7;
        View findViewById8 = findViewById(R.id.minor_retry_icon);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.ImageView");
        this.q = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.minor_retry_icon_container);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.r = findViewById9;
        View findViewById10 = findViewById(R.id.minor_remove_icon);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.ImageView");
        this.m = (ImageView) findViewById10;
        View[] viewArr = new View[5];
        Spinner spinner = this.s;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spinner");
        }
        viewArr[0] = spinner;
        View view = this.p;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorActionsContainer");
        }
        viewArr[1] = view;
        ImageView imageView = this.o;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorIcon");
        }
        viewArr[2] = imageView;
        ImageView imageView2 = this.l;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("majorRemoveIcon");
        }
        viewArr[3] = imageView2;
        ImageView imageView3 = this.n;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningIcon");
        }
        viewArr[4] = imageView3;
        this.t = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.y = this;
        this.H = State.PLACEHOLDER;
    }
}
