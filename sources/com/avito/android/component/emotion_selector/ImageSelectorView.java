package com.avito.android.component.emotion_selector;

import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import com.avito.android.component.emotion_selector.ImageSelectorView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Parcels;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003Z[\\B'\b\u0007\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u0004¢\u0006\u0004\bX\u0010YJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JK\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000422\b\u0002\u0010\u0010\u001a,\u0012\b\u0012\u00060\tR\u00020\u0000\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0002\b\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u000e2\f\b\u0001\u0010\u0014\u001a\u00020\u0013\"\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0014¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0014¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0014¢\u0006\u0004\b2\u0010\u001aJ!\u00106\u001a\u00020)2\u0006\u00103\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R \u0010\u0014\u001a\f\u0012\b\u0012\u00060\tR\u00020\u00000=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010>R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010FR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0016\u0010L\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010FR$\u0010R\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006]"}, d2 = {"Lcom/avito/android/component/emotion_selector/ImageSelectorView;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "event", "", AuthSource.SEND_ABUSE, "(Landroid/view/MotionEvent;)I", FirebaseAnalytics.Param.INDEX, "Lkotlin/Function2;", "Lcom/avito/android/component/emotion_selector/ImageSelectorView$Image;", "", "Lkotlin/ParameterName;", "name", "scale", "", "Lkotlin/ExtensionFunctionType;", "changeScaleFunc", AuthSource.BOOKING_ORDER, "(ILkotlin/jvm/functions/Function2;)V", "", "images", "setImages", "([I)V", "leftPadding", "rightPadding", "setImagePaddings", "(II)V", "selectedScale", "unselectedScale", "setImageScale", "(FF)V", "Lcom/avito/android/component/emotion_selector/ImageSelectorView$ChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/component/emotion_selector/ImageSelectorView$ChangeListener;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "requestFocus", "(ILandroid/graphics/Rect;)Z", g.a, "F", "unselectedImageScale", "h", "Lcom/avito/android/component/emotion_selector/ImageSelectorView$ChangeListener;", "", "Ljava/util/List;", "f", "selectedImageScale", "Landroid/view/GestureDetector;", "i", "Landroid/view/GestureDetector;", "singleTapDetector", "d", "I", "tapImageIndex", "imagePaddingLeft", "c", "imagePaddingRight", "e", "selectedImageIndex", "value", "getSelectedNumber", "()I", "setSelectedNumber", "(I)V", "selectedNumber", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ChangeListener", "Image", "State", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageSelectorView extends View {
    public List<Image> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public ChangeListener h;
    public final GestureDetector i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/component/emotion_selector/ImageSelectorView$ChangeListener;", "", "", "selectedNumber", "", "fromUser", "", "onSelectedNumberChanged", "(IZ)V", "onStartTracking", "()V", "onStopTracking", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface ChangeListener {
        void onSelectedNumberChanged(int i, boolean z);

        void onStartTracking();

        void onStopTracking();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\fR\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\"\u0010+\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010\fR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\"\u00107\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0016\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010\u001d¨\u0006="}, d2 = {"Lcom/avito/android/component/emotion_selector/ImageSelectorView$Image;", "", "", "measure", "()V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "", "scale", "changeScale", "(F)V", "resultScale", "changeScaleSmoothly", "Landroid/view/MotionEvent;", "event", "", "contains", "(Landroid/view/MotionEvent;)Z", "", AuthSource.BOOKING_ORDER, "I", "getY", "()I", "setY", "(I)V", "y", "d", "F", "getPivotY", "()F", "setPivotY", "pivotY", "i", "intrinsicHeight", AuthSource.SEND_ABUSE, "getX", "setX", "x", "c", "getPivotX", "setPivotX", "pivotX", "Landroid/graphics/drawable/Drawable;", "j", "Landroid/graphics/drawable/Drawable;", "drawable", "f", "getHeight", "setHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "e", "getWidth", "setWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "h", "intrinsicWidth", g.a, "<init>", "(Lcom/avito/android/component/emotion_selector/ImageSelectorView;Landroid/graphics/drawable/Drawable;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public final class Image {
        public int a;
        public int b;
        public float c = 0.5f;
        public float d = 1.0f;
        public int e;
        public int f;
        public float g;
        public int h;
        public int i;
        public final Drawable j;
        public final /* synthetic */ ImageSelectorView k;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ Image a;

            public a(Image image) {
                this.a = image;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.g = ((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue();
                ImageSelectorView.access$invalidateOnAnimation(this.a.k);
            }
        }

        public Image(@NotNull ImageSelectorView imageSelectorView, Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.k = imageSelectorView;
            this.j = drawable;
            this.g = imageSelectorView.g;
        }

        public final void changeScale(float f2) {
            this.g = f2;
            ImageSelectorView.access$invalidateOnAnimation(this.k);
        }

        public final void changeScaleSmoothly(float f2) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.g, f2);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.setDuration(100L);
            ofFloat.addUpdateListener(new a(this));
            ofFloat.start();
        }

        public final boolean contains(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            int i2 = this.a - this.k.b;
            int i3 = this.k.c + this.a + this.e;
            int round = Math.round(motionEvent.getX());
            return i2 <= round && i3 >= round;
        }

        public final void draw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int round = Math.round(((float) this.h) * this.g);
            int round2 = Math.round(((float) this.i) * this.g);
            int round3 = Math.round(((float) this.a) - (((float) (round - this.e)) * this.c));
            int round4 = Math.round(((float) this.b) - (((float) (round2 - this.f)) * this.d));
            this.j.setBounds(round3, round4, round + round3, round2 + round4);
            this.j.draw(canvas);
        }

        public final int getHeight() {
            return this.f;
        }

        public final float getPivotX() {
            return this.c;
        }

        public final float getPivotY() {
            return this.d;
        }

        public final int getWidth() {
            return this.e;
        }

        public final int getX() {
            return this.a;
        }

        public final int getY() {
            return this.b;
        }

        public final void measure() {
            this.h = this.j.getIntrinsicWidth();
            this.i = this.j.getIntrinsicHeight();
            this.e = Math.round(this.k.g * ((float) this.h));
            this.f = Math.round(this.k.g * ((float) this.i));
        }

        public final void setHeight(int i2) {
            this.f = i2;
        }

        public final void setPivotX(float f2) {
            this.c = f2;
        }

        public final void setPivotY(float f2) {
            this.d = f2;
        }

        public final void setWidth(int i2) {
            this.e = i2;
        }

        public final void setX(int i2) {
            this.a = i2;
        }

        public final void setY(int i2) {
            this.b = i2;
        }
    }

    public static final class a extends Lambda implements Function2<Image, Float, Unit> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Image image, Float f) {
            Image image2 = image;
            float floatValue = f.floatValue();
            Intrinsics.checkNotNullParameter(image2, "$receiver");
            image2.changeScaleSmoothly(floatValue);
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public ImageSelectorView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ImageSelectorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageSelectorView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void access$invalidateOnAnimation(ImageSelectorView imageSelectorView) {
        Objects.requireNonNull(imageSelectorView);
        ViewCompat.postInvalidateOnAnimation(imageSelectorView);
    }

    public static /* synthetic */ void setImagePaddings$default(ImageSelectorView imageSelectorView, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = imageSelectorView.b;
        }
        if ((i4 & 2) != 0) {
            i3 = imageSelectorView.c;
        }
        imageSelectorView.setImagePaddings(i2, i3);
    }

    public static /* synthetic */ void setImageScale$default(ImageSelectorView imageSelectorView, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = imageSelectorView.f;
        }
        if ((i2 & 2) != 0) {
            f3 = imageSelectorView.g;
        }
        imageSelectorView.setImageScale(f2, f3);
    }

    public final int a(MotionEvent motionEvent) {
        int i2 = 0;
        for (Image image : this.a) {
            if (image.contains(motionEvent)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void b(int i2, Function2<? super Image, ? super Float, Unit> function2) {
        int i3 = this.e;
        if (i3 != i2) {
            Image image = (Image) CollectionsKt___CollectionsKt.getOrNull(this.a, i3);
            if (image != null) {
                function2.invoke(image, Float.valueOf(this.g));
            }
            Image image2 = (Image) CollectionsKt___CollectionsKt.getOrNull(this.a, i2);
            if (image2 != null) {
                function2.invoke(image2, Float.valueOf(this.f));
            }
            this.e = i2;
        }
    }

    public final int getSelectedNumber() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        T t;
        super.onMeasure(i2, i3);
        List<Image> list = this.a;
        int paddingLeft = getPaddingLeft();
        for (T t2 : list) {
            t2.measure();
            t2.setX(paddingLeft + this.b);
            t2.setY(getPaddingTop());
            paddingLeft = this.c + t2.getWidth() + t2.getX();
        }
        int paddingLeft2 = getPaddingLeft();
        Iterator<T> it = this.a.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            i4 += it.next().getWidth() + this.b + this.c;
        }
        int paddingRight = getPaddingRight() + paddingLeft2 + i4;
        int paddingTop = getPaddingTop();
        Iterator<T> it2 = this.a.iterator();
        if (!it2.hasNext()) {
            t = null;
        } else {
            T next = it2.next();
            if (it2.hasNext()) {
                int height = next.getHeight();
                do {
                    T next2 = it2.next();
                    int height2 = next2.getHeight();
                    if (height < height2) {
                        next = next2;
                        height = height2;
                    }
                } while (it2.hasNext());
            }
            t = next;
        }
        T t3 = t;
        setMeasuredDimension(View.resolveSizeAndState(paddingRight, i2, 0), View.resolveSizeAndState(getPaddingBottom() + paddingTop + (t3 != null ? t3.getHeight() : 0), i2, 0));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof State)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        State state = (State) parcelable;
        super.onRestoreInstanceState(state.getSuperState());
        b(state.getSelectedImageIndex(), a2.a.a.a.d.a.a);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        State state = new State(onSaveInstanceState);
        state.setSelectedImageIndex(this.e);
        return state;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r0 != 3) goto L_0x005a;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.view.GestureDetector r0 = r3.i
            boolean r0 = r0.onTouchEvent(r4)
            r1 = 1
            if (r0 == 0) goto L_0x000f
            return r1
        L_0x000f:
            int r0 = r4.getAction()
            if (r0 == 0) goto L_0x0046
            if (r0 == r1) goto L_0x0028
            r2 = 2
            if (r0 == r2) goto L_0x001e
            r4 = 3
            if (r0 == r4) goto L_0x0028
            goto L_0x005a
        L_0x001e:
            int r4 = r3.a(r4)
            com.avito.android.component.emotion_selector.ImageSelectorView$a r0 = com.avito.android.component.emotion_selector.ImageSelectorView.a.a
            r3.b(r4, r0)
            goto L_0x005a
        L_0x0028:
            android.view.ViewParent r4 = r3.getParent()
            if (r4 == 0) goto L_0x0032
            r0 = 0
            r4.requestDisallowInterceptTouchEvent(r0)
        L_0x0032:
            com.avito.android.component.emotion_selector.ImageSelectorView$ChangeListener r4 = r3.h
            if (r4 == 0) goto L_0x003b
            int r0 = r3.e
            r4.onSelectedNumberChanged(r0, r1)
        L_0x003b:
            com.avito.android.component.emotion_selector.ImageSelectorView$ChangeListener r4 = r3.h
            if (r4 == 0) goto L_0x0042
            r4.onStopTracking()
        L_0x0042:
            r4 = -1
            r3.d = r4
            goto L_0x005a
        L_0x0046:
            android.view.ViewParent r4 = r3.getParent()
            if (r4 == 0) goto L_0x004f
            r4.requestDisallowInterceptTouchEvent(r1)
        L_0x004f:
            int r4 = r3.e
            r3.d = r4
            com.avito.android.component.emotion_selector.ImageSelectorView$ChangeListener r4 = r3.h
            if (r4 == 0) goto L_0x005a
            r4.onStartTracking()
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.emotion_selector.ImageSelectorView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean requestFocus(int i2, @Nullable Rect rect) {
        Keyboards.hideKeyboard$default(this, false, 1, null);
        return true;
    }

    public final void setImagePaddings(int i2, int i3) {
        this.b = i2;
        this.c = i3;
        requestLayout();
        invalidate();
    }

    public final void setImageScale(float f2, float f3) {
        this.f = f2;
        this.g = f3;
        int i2 = 0;
        for (T t : this.a) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            t.changeScale(this.e == i2 ? this.f : this.g);
            i2 = i3;
        }
        requestLayout();
        invalidate();
    }

    public final void setImages(@DrawableRes @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "images");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            Drawable drawable = getContext().getDrawable(i2);
            Intrinsics.checkNotNull(drawable);
            Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(it)!!");
            arrayList.add(new Image(this, drawable));
        }
        this.a = arrayList;
        Image image = (Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        if (image != null) {
            image.setPivotX(0.0f);
        }
        requestLayout();
        invalidate();
    }

    public final void setListener(@Nullable ChangeListener changeListener) {
        this.h = changeListener;
    }

    public final void setSelectedNumber(int i2) {
        b(i2, a2.a.a.a.d.a.a);
        ChangeListener changeListener = this.h;
        if (changeListener != null) {
            changeListener.onSelectedNumberChanged(i2, false);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/component/emotion_selector/ImageSelectorView$State;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "I", "getSelectedImageIndex", "()I", "setSelectedImageIndex", "(I)V", "selectedImageIndex", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class State extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<State> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public int a = -1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/component/emotion_selector/ImageSelectorView$State$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/component/emotion_selector/ImageSelectorView$State;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, State> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public State invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new State(parcel2, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public State(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        public final int getSelectedImageIndex() {
            return this.a;
        }

        public final void setSelectedImageIndex(int i) {
            this.a = i;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public State(Parcel parcel, j jVar) {
            super(parcel);
            this.a = parcel.readInt();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageSelectorView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = CollectionsKt__CollectionsKt.emptyList();
        this.d = -1;
        this.e = -1;
        this.f = 1.0f;
        this.g = 0.7f;
        this.i = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this) { // from class: com.avito.android.component.emotion_selector.ImageSelectorView$singleTapDetector$1
            public final /* synthetic */ ImageSelectorView a;

            public static final class a extends Lambda implements Function2<ImageSelectorView.Image, Float, Unit> {
                public static final a a = new a();

                public a() {
                    super(2);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function2
                public Unit invoke(ImageSelectorView.Image image, Float f) {
                    ImageSelectorView.Image image2 = image;
                    float floatValue = f.floatValue();
                    Intrinsics.checkNotNullParameter(image2, "$receiver");
                    image2.changeScaleSmoothly(floatValue);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "event");
                Integer valueOf = Integer.valueOf(this.a.a(motionEvent));
                if (!(valueOf.intValue() != this.a.d)) {
                    valueOf = null;
                }
                int intValue = valueOf != null ? valueOf.intValue() : -1;
                this.a.b(intValue, a.a);
                ImageSelectorView.ChangeListener changeListener = this.a.h;
                if (changeListener != null) {
                    changeListener.onSelectedNumberChanged(intValue, true);
                }
                ImageSelectorView.ChangeListener changeListener2 = this.a.h;
                if (changeListener2 != null) {
                    changeListener2.onStopTracking();
                }
                this.a.d = -1;
                return true;
            }
        });
    }
}
