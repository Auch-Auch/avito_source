package com.avito.android.design.widget.shimmer;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0014\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\b~\u0001\u0001\u0001B\t\b\u0000¢\u0006\u0004\b}\u0010\nJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\nJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u00100\u001a\u00020)8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00105\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b1\u0010\u0013\u0012\u0004\b4\u0010\n\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001c\u0010;\u001a\u0002068\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0013\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R(\u0010D\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b@\u0010\u0013\u0012\u0004\bC\u0010\n\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R\"\u0010H\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0013\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\"\u0010L\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010\u001fR\"\u0010P\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bM\u0010\u001b\u001a\u0004\bN\u0010\u001d\"\u0004\bO\u0010\u001fR\u001c\u0010V\u001a\u00020Q8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\"\u0010Z\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0013\u001a\u0004\bX\u0010\u0015\"\u0004\bY\u0010\u0017R\"\u0010^\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0013\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R\"\u0010f\u001a\u00020_8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010l\u001a\u00020g8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\"\u0010p\u001a\u00020_8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bm\u0010a\u001a\u0004\bn\u0010c\"\u0004\bo\u0010eR\"\u0010t\u001a\u00020_8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bq\u0010a\u001a\u0004\br\u0010c\"\u0004\bs\u0010eR\"\u0010x\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bu\u0010\u0013\u001a\u0004\bv\u0010\u0015\"\u0004\bw\u0010\u0017R\"\u0010|\u001a\u00020)8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\by\u0010+\u001a\u0004\bz\u0010-\"\u0004\b{\u0010/¨\u0006\u0001"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer;", "", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "width$ui_components_release", "(I)I", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "height$ui_components_release", "", "updateColors$ui_components_release", "()V", "updateColors", "updatePositions$ui_components_release", "updatePositions", "viewWidth", "viewHeight", "updateBounds", "(II)V", "e", "I", "getHighlightColor$ui_components_release", "()I", "setHighlightColor$ui_components_release", "(I)V", "highlightColor", "", "j", "F", "getWidthRatio$ui_components_release", "()F", "setWidthRatio$ui_components_release", "(F)V", "widthRatio", "l", "getIntensity$ui_components_release", "setIntensity$ui_components_release", "intensity", AuthSource.OPEN_CHANNEL_LIST, "getDropoff$ui_components_release", "setDropoff$ui_components_release", "dropoff", "", "u", "J", "getRepeatDelay$ui_components_release", "()J", "setRepeatDelay$ui_components_release", "(J)V", "repeatDelay", g.a, "getShape$ui_components_release", "setShape$ui_components_release", "getShape$ui_components_release$annotations", "shape", "", AuthSource.SEND_ABUSE, "[F", "getPositions$ui_components_release", "()[F", "positions", "i", "getFixedHeight$ui_components_release", "setFixedHeight$ui_components_release", "fixedHeight", "d", "getDirection$ui_components_release", "setDirection$ui_components_release", "getDirection$ui_components_release$annotations", "direction", "f", "getBaseColor$ui_components_release", "setBaseColor$ui_components_release", "baseColor", "k", "getHeightRatio$ui_components_release", "setHeightRatio$ui_components_release", "heightRatio", "n", "getTilt$ui_components_release", "setTilt$ui_components_release", "tilt", "Landroid/graphics/RectF;", "c", "Landroid/graphics/RectF;", "getBounds$ui_components_release", "()Landroid/graphics/RectF;", "bounds", "s", "getRepeatMode$ui_components_release", "setRepeatMode$ui_components_release", "repeatMode", "h", "getFixedWidth$ui_components_release", "setFixedWidth$ui_components_release", "fixedWidth", "", "p", "Z", "getAutoStart$ui_components_release", "()Z", "setAutoStart$ui_components_release", "(Z)V", "autoStart", "", AuthSource.BOOKING_ORDER, "[I", "getColors$ui_components_release", "()[I", "colors", "o", "getClipToChildren$ui_components_release", "setClipToChildren$ui_components_release", "clipToChildren", VKApiConst.Q, "getAlphaShimmer$ui_components_release", "setAlphaShimmer$ui_components_release", "alphaShimmer", "r", "getRepeatCount$ui_components_release", "setRepeatCount$ui_components_release", "repeatCount", "t", "getAnimationDuration$ui_components_release", "setAnimationDuration$ui_components_release", "animationDuration", "<init>", "AlphaHighlightBuilder", "Builder", "ColorHighlightBuilder", "Direction", "Shape", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class Shimmer {
    @NotNull
    public final float[] a = new float[4];
    @NotNull
    public final int[] b = new int[4];
    @NotNull
    public final RectF c = new RectF();
    public int d;
    @ColorInt
    public int e = -1;
    @ColorInt
    public int f = 1291845631;
    public int g;
    public int h;
    public int i;
    public float j = 1.0f;
    public float k = 1.0f;
    public float l;
    public float m = 0.5f;
    public float n = 20.0f;
    public boolean o = true;
    public boolean p = true;
    public boolean q = true;
    public int r = -1;
    public int s = 1;
    public long t = 1000;
    public long u;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00008T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$AlphaHighlightBuilder;", "Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "getThis", "()Lcom/avito/android/design/widget/shimmer/Shimmer$AlphaHighlightBuilder;", "this", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            getMShimmer$ui_components_release().setAlphaShimmer$ui_components_release(true);
        }

        @Override // com.avito.android.design.widget.shimmer.Shimmer.Builder
        @NotNull
        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0007¢\u0006\u0004\b@\u0010AJ\u001d\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00028\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\u00028\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010\u001eJ\u0015\u0010$\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u001b¢\u0006\u0004\b$\u0010\u001eJ\u0015\u0010&\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u001b¢\u0006\u0004\b&\u0010\u001eJ\u0017\u0010(\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u001b¢\u0006\u0004\b(\u0010\u001eJ\u0017\u0010)\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u001b¢\u0006\u0004\b)\u0010\u001eJ\u0015\u0010,\u001a\u00028\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00028\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b.\u0010-J\u0015\u00100\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u0011¢\u0006\u0004\b0\u0010\u0014J\u0015\u00102\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0011¢\u0006\u0004\b2\u0010\u0014J\u0015\u00105\u001a\u00028\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00107\u001a\u00028\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\b7\u00106J\r\u00108\u001a\u00020\r¢\u0006\u0004\b8\u00109R\u001c\u0010<\u001a\u00020\r8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b;\u00109R\u0016\u0010?\u001a\u00028\u00008$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "T", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "consumeAttributes", "(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "Landroid/content/res/TypedArray;", AuthSource.SEND_ABUSE, "consumeAttributes$ui_components_release", "(Landroid/content/res/TypedArray;)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "Lcom/avito/android/design/widget/shimmer/Shimmer;", "other", "copyFrom", "(Lcom/avito/android/design/widget/shimmer/Shimmer;)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "", "direction", "setDirection", "(I)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "shape", "setShape", "fixedWidth", "setFixedWidth", "fixedHeight", "setFixedHeight", "", "widthRatio", "setWidthRatio", "(F)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "heightRatio", "setHeightRatio", "intensity", "setIntensity", "dropoff", "setDropoff", "tilt", "setTilt", "alpha", "setBaseAlpha", "setHighlightAlpha", "", "status", "setClipToChildren", "(Z)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "setAutoStart", "repeatCount", "setRepeatCount", "mode", "setRepeatMode", "", "millis", "setRepeatDelay", "(J)Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "setDuration", "build", "()Lcom/avito/android/design/widget/shimmer/Shimmer;", "Lcom/avito/android/design/widget/shimmer/Shimmer;", "getMShimmer$ui_components_release", "mShimmer", "getThis", "()Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "this", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Builder<T extends Builder<T>> {
        @NotNull
        public final Shimmer a = new Shimmer();

        @NotNull
        public final Shimmer build() {
            this.a.updateColors$ui_components_release();
            this.a.updatePositions$ui_components_release();
            return this.a;
        }

        @NotNull
        public final T consumeAttributes(@NotNull Context context, @NotNull AttributeSet attributeSet) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(attributeSet, "attrs");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, AuthSource.SEND_ABUSE);
            return consumeAttributes$ui_components_release(obtainStyledAttributes);
        }

        @NotNull
        public T consumeAttributes$ui_components_release(@NotNull TypedArray typedArray) {
            Intrinsics.checkNotNullParameter(typedArray, AuthSource.SEND_ABUSE);
            int i = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i)) {
                setClipToChildren(typedArray.getBoolean(i, this.a.getClipToChildren$ui_components_release()));
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i2)) {
                setAutoStart(typedArray.getBoolean(i2, this.a.getAutoStart$ui_components_release()));
            }
            int i3 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i3)) {
                setBaseAlpha(typedArray.getFloat(i3, 0.3f));
            }
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i4)) {
                setHighlightAlpha(typedArray.getFloat(i4, 1.0f));
            }
            int i5 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i5)) {
                setDuration((long) typedArray.getInt(i5, (int) this.a.getAnimationDuration$ui_components_release()));
            }
            int i6 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i6)) {
                setRepeatCount(typedArray.getInt(i6, this.a.getRepeatCount$ui_components_release()));
            }
            int i7 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i7)) {
                setRepeatDelay((long) typedArray.getInt(i7, (int) this.a.getRepeatDelay$ui_components_release()));
            }
            int i8 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i8)) {
                setRepeatMode(typedArray.getInt(i8, this.a.getRepeatMode$ui_components_release()));
            }
            int i9 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i9)) {
                int i10 = typedArray.getInt(i9, this.a.getDirection$ui_components_release());
                if (i10 == 0) {
                    setDirection(0);
                } else if (i10 == 1) {
                    setDirection(1);
                } else if (i10 == 2) {
                    setDirection(2);
                } else if (i10 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i11)) {
                int i12 = typedArray.getInt(i11, this.a.getShape$ui_components_release());
                if (i12 == 0) {
                    setShape(0);
                } else if (i12 != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i13 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i13)) {
                setDropoff(typedArray.getFloat(i13, this.a.getDropoff$ui_components_release()));
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i14)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i14, this.a.getFixedWidth$ui_components_release()));
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i15)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i15, this.a.getFixedHeight$ui_components_release()));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i16)) {
                setIntensity(typedArray.getFloat(i16, this.a.getIntensity$ui_components_release()));
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i17)) {
                setWidthRatio(typedArray.getFloat(i17, this.a.getWidthRatio$ui_components_release()));
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i18)) {
                setHeightRatio(typedArray.getFloat(i18, this.a.getHeightRatio$ui_components_release()));
            }
            int i19 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i19)) {
                setTilt(typedArray.getFloat(i19, this.a.getTilt$ui_components_release()));
            }
            return getThis();
        }

        @NotNull
        public final T copyFrom(@NotNull Shimmer shimmer) {
            Intrinsics.checkNotNullParameter(shimmer, "other");
            setDirection(shimmer.getDirection$ui_components_release());
            setShape(shimmer.getShape$ui_components_release());
            setFixedWidth(shimmer.getFixedWidth$ui_components_release());
            setFixedHeight(shimmer.getFixedHeight$ui_components_release());
            setWidthRatio(shimmer.getWidthRatio$ui_components_release());
            setHeightRatio(shimmer.getHeightRatio$ui_components_release());
            setIntensity(shimmer.getIntensity$ui_components_release());
            setDropoff(shimmer.getDropoff$ui_components_release());
            setTilt(shimmer.getTilt$ui_components_release());
            setClipToChildren(shimmer.getClipToChildren$ui_components_release());
            setAutoStart(shimmer.getAutoStart$ui_components_release());
            setRepeatCount(shimmer.getRepeatCount$ui_components_release());
            setRepeatMode(shimmer.getRepeatMode$ui_components_release());
            setRepeatDelay(shimmer.getRepeatDelay$ui_components_release());
            setDuration(shimmer.getAnimationDuration$ui_components_release());
            this.a.setBaseColor$ui_components_release(shimmer.getBaseColor$ui_components_release());
            this.a.setHighlightColor$ui_components_release(shimmer.getHighlightColor$ui_components_release());
            return getThis();
        }

        @NotNull
        public final Shimmer getMShimmer$ui_components_release() {
            return this.a;
        }

        @NotNull
        public abstract T getThis();

        @NotNull
        public final T setAutoStart(boolean z) {
            this.a.setAutoStart$ui_components_release(z);
            return getThis();
        }

        @NotNull
        public final T setBaseAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            Shimmer shimmer = this.a;
            shimmer.setBaseColor$ui_components_release((((int) (Math.min(1.0f, Math.max(0.0f, f)) * 255.0f)) << 24) | (shimmer.getBaseColor$ui_components_release() & ViewCompat.MEASURED_SIZE_MASK));
            return getThis();
        }

        @NotNull
        public final T setClipToChildren(boolean z) {
            this.a.setClipToChildren$ui_components_release(z);
            return getThis();
        }

        @NotNull
        public final T setDirection(int i) {
            this.a.setDirection$ui_components_release(i);
            return getThis();
        }

        @NotNull
        public final T setDropoff(float f) {
            if (f >= 0.0f) {
                this.a.setDropoff$ui_components_release(f);
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f);
        }

        @NotNull
        public final T setDuration(long j) {
            if (j >= 0) {
                this.a.setAnimationDuration$ui_components_release(j);
                return getThis();
            }
            throw new IllegalArgumentException(a.T2("Given a negative duration: ", j));
        }

        @NotNull
        public final T setFixedHeight(@Px int i) {
            if (i >= 0) {
                this.a.setFixedHeight$ui_components_release(i);
                return getThis();
            }
            throw new IllegalArgumentException(a.M2("Given invalid height: ", i));
        }

        @NotNull
        public final T setFixedWidth(@Px int i) {
            if (i >= 0) {
                this.a.setFixedWidth$ui_components_release(i);
                return getThis();
            }
            throw new IllegalArgumentException(a.M2("Given invalid width: ", i));
        }

        @NotNull
        public final T setHeightRatio(float f) {
            if (f >= 0.0f) {
                this.a.setHeightRatio$ui_components_release(f);
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f);
        }

        @NotNull
        public final T setHighlightAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            Shimmer shimmer = this.a;
            shimmer.setHighlightColor$ui_components_release((((int) (Math.min(1.0f, Math.max(0.0f, f)) * 255.0f)) << 24) | (shimmer.getHighlightColor$ui_components_release() & ViewCompat.MEASURED_SIZE_MASK));
            return getThis();
        }

        @NotNull
        public final T setIntensity(float f) {
            if (f >= 0.0f) {
                this.a.setIntensity$ui_components_release(f);
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f);
        }

        @NotNull
        public final T setRepeatCount(int i) {
            this.a.setRepeatCount$ui_components_release(i);
            return getThis();
        }

        @NotNull
        public final T setRepeatDelay(long j) {
            if (j >= 0) {
                this.a.setRepeatDelay$ui_components_release(j);
                return getThis();
            }
            throw new IllegalArgumentException(a.T2("Given a negative repeat delay: ", j));
        }

        @NotNull
        public final T setRepeatMode(int i) {
            this.a.setRepeatMode$ui_components_release(i);
            return getThis();
        }

        @NotNull
        public final T setShape(int i) {
            this.a.setShape$ui_components_release(i);
            return getThis();
        }

        @NotNull
        public final T setTilt(float f) {
            this.a.setTilt$ui_components_release(f);
            return getThis();
        }

        @NotNull
        public final T setWidthRatio(float f) {
            if (f >= 0.0f) {
                this.a.setWidthRatio$ui_components_release(f);
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00008T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$ColorHighlightBuilder;", "Lcom/avito/android/design/widget/shimmer/Shimmer$Builder;", "", "color", "setHighlightColor", "(I)Lcom/avito/android/design/widget/shimmer/Shimmer$ColorHighlightBuilder;", "setBaseColor", "Landroid/content/res/TypedArray;", AuthSource.SEND_ABUSE, "consumeAttributes$ui_components_release", "(Landroid/content/res/TypedArray;)Lcom/avito/android/design/widget/shimmer/Shimmer$ColorHighlightBuilder;", "consumeAttributes", "getThis", "()Lcom/avito/android/design/widget/shimmer/Shimmer$ColorHighlightBuilder;", "this", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            getMShimmer$ui_components_release().setAlphaShimmer$ui_components_release(false);
        }

        @Override // com.avito.android.design.widget.shimmer.Shimmer.Builder
        @NotNull
        public ColorHighlightBuilder getThis() {
            return this;
        }

        @NotNull
        public final ColorHighlightBuilder setBaseColor(@ColorInt int i) {
            getMShimmer$ui_components_release().setBaseColor$ui_components_release((i & ViewCompat.MEASURED_SIZE_MASK) | (getMShimmer$ui_components_release().getBaseColor$ui_components_release() & ViewCompat.MEASURED_STATE_MASK));
            return getThis();
        }

        @NotNull
        public final ColorHighlightBuilder setHighlightColor(@ColorInt int i) {
            getMShimmer$ui_components_release().setHighlightColor$ui_components_release(i);
            return getThis();
        }

        @Override // com.avito.android.design.widget.shimmer.Shimmer.Builder
        @NotNull
        public ColorHighlightBuilder consumeAttributes$ui_components_release(@NotNull TypedArray typedArray) {
            Intrinsics.checkNotNullParameter(typedArray, AuthSource.SEND_ABUSE);
            super.consumeAttributes$ui_components_release(typedArray);
            int i = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i)) {
                setBaseColor(typedArray.getColor(i, getMShimmer$ui_components_release().getBaseColor$ui_components_release()));
            }
            int i2 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i2)) {
                setHighlightColor(typedArray.getColor(i2, getMShimmer$ui_components_release().getHighlightColor$ui_components_release()));
            }
            return getThis();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$Direction;", "", "<init>", "()V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        @NotNull
        public static final Companion Companion = Companion.a;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$Direction$Companion;", "", "", "LEFT_TO_RIGHT", "I", "BOTTOM_TO_TOP", "TOP_TO_BOTTOM", "RIGHT_TO_LEFT", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public static final int BOTTOM_TO_TOP = 3;
            public static final int LEFT_TO_RIGHT = 0;
            public static final int RIGHT_TO_LEFT = 2;
            public static final int TOP_TO_BOTTOM = 1;
            public static final /* synthetic */ Companion a = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$Shape;", "", "<init>", "()V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Shape {
        @NotNull
        public static final Companion Companion = Companion.a;
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/shimmer/Shimmer$Shape$Companion;", "", "", "LINEAR", "I", "RADIAL", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public static final int LINEAR = 0;
            public static final int RADIAL = 1;
            public static final /* synthetic */ Companion a = new Companion();
        }
    }

    public static /* synthetic */ void getDirection$ui_components_release$annotations() {
    }

    public static /* synthetic */ void getShape$ui_components_release$annotations() {
    }

    public final boolean getAlphaShimmer$ui_components_release() {
        return this.q;
    }

    public final long getAnimationDuration$ui_components_release() {
        return this.t;
    }

    public final boolean getAutoStart$ui_components_release() {
        return this.p;
    }

    public final int getBaseColor$ui_components_release() {
        return this.f;
    }

    @NotNull
    public final RectF getBounds$ui_components_release() {
        return this.c;
    }

    public final boolean getClipToChildren$ui_components_release() {
        return this.o;
    }

    @NotNull
    public final int[] getColors$ui_components_release() {
        return this.b;
    }

    public final int getDirection$ui_components_release() {
        return this.d;
    }

    public final float getDropoff$ui_components_release() {
        return this.m;
    }

    public final int getFixedHeight$ui_components_release() {
        return this.i;
    }

    public final int getFixedWidth$ui_components_release() {
        return this.h;
    }

    public final float getHeightRatio$ui_components_release() {
        return this.k;
    }

    public final int getHighlightColor$ui_components_release() {
        return this.e;
    }

    public final float getIntensity$ui_components_release() {
        return this.l;
    }

    @NotNull
    public final float[] getPositions$ui_components_release() {
        return this.a;
    }

    public final int getRepeatCount$ui_components_release() {
        return this.r;
    }

    public final long getRepeatDelay$ui_components_release() {
        return this.u;
    }

    public final int getRepeatMode$ui_components_release() {
        return this.s;
    }

    public final int getShape$ui_components_release() {
        return this.g;
    }

    public final float getTilt$ui_components_release() {
        return this.n;
    }

    public final float getWidthRatio$ui_components_release() {
        return this.j;
    }

    public final int height$ui_components_release(int i2) {
        int i3 = this.i;
        return i3 > 0 ? i3 : Math.round(this.k * ((float) i2));
    }

    public final void setAlphaShimmer$ui_components_release(boolean z) {
        this.q = z;
    }

    public final void setAnimationDuration$ui_components_release(long j2) {
        this.t = j2;
    }

    public final void setAutoStart$ui_components_release(boolean z) {
        this.p = z;
    }

    public final void setBaseColor$ui_components_release(int i2) {
        this.f = i2;
    }

    public final void setClipToChildren$ui_components_release(boolean z) {
        this.o = z;
    }

    public final void setDirection$ui_components_release(int i2) {
        this.d = i2;
    }

    public final void setDropoff$ui_components_release(float f2) {
        this.m = f2;
    }

    public final void setFixedHeight$ui_components_release(int i2) {
        this.i = i2;
    }

    public final void setFixedWidth$ui_components_release(int i2) {
        this.h = i2;
    }

    public final void setHeightRatio$ui_components_release(float f2) {
        this.k = f2;
    }

    public final void setHighlightColor$ui_components_release(int i2) {
        this.e = i2;
    }

    public final void setIntensity$ui_components_release(float f2) {
        this.l = f2;
    }

    public final void setRepeatCount$ui_components_release(int i2) {
        this.r = i2;
    }

    public final void setRepeatDelay$ui_components_release(long j2) {
        this.u = j2;
    }

    public final void setRepeatMode$ui_components_release(int i2) {
        this.s = i2;
    }

    public final void setShape$ui_components_release(int i2) {
        this.g = i2;
    }

    public final void setTilt$ui_components_release(float f2) {
        this.n = f2;
    }

    public final void setWidthRatio$ui_components_release(float f2) {
        this.j = f2;
    }

    public final void updateBounds(int i2, int i3) {
        double max = (double) Math.max(i2, i3);
        int round = Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians((double) (this.n % 90.0f)))) - max)) / 2.0f) * 3;
        float f2 = (float) (-round);
        this.c.set(f2, f2, (float) (width$ui_components_release(i2) + round), (float) (height$ui_components_release(i3) + round));
    }

    public final void updateColors$ui_components_release() {
        int i2 = this.g;
        if (i2 == 0) {
            int[] iArr = this.b;
            int i3 = this.f;
            iArr[0] = i3;
            int i4 = this.e;
            iArr[1] = i4;
            iArr[2] = i4;
            iArr[3] = i3;
        } else if (i2 != 1) {
            int[] iArr2 = this.b;
            int i5 = this.f;
            iArr2[0] = i5;
            int i6 = this.e;
            iArr2[1] = i6;
            iArr2[2] = i6;
            iArr2[3] = i5;
        } else {
            int[] iArr3 = this.b;
            int i7 = this.e;
            iArr3[0] = i7;
            iArr3[1] = i7;
            int i8 = this.f;
            iArr3[2] = i8;
            iArr3[3] = i8;
        }
    }

    public final void updatePositions$ui_components_release() {
        int i2 = this.g;
        if (i2 == 0) {
            this.a[0] = Math.max(((1.0f - this.l) - this.m) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.l) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.l + 1.0f) + this.m) / 2.0f, 1.0f);
        } else if (i2 != 1) {
            this.a[0] = Math.max(((1.0f - this.l) - this.m) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.l) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.l + 1.0f) + this.m) / 2.0f, 1.0f);
        } else {
            float[] fArr = this.a;
            fArr[0] = 0.0f;
            fArr[1] = Math.min(this.l, 1.0f);
            this.a[2] = Math.min(this.l + this.m, 1.0f);
            this.a[3] = 1.0f;
        }
    }

    public final int width$ui_components_release(int i2) {
        int i3 = this.h;
        return i3 > 0 ? i3 : Math.round(this.j * ((float) i2));
    }
}
