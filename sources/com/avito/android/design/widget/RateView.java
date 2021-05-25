package com.avito.android.design.widget;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Parcels;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0006&7ax\u0001B.\b\u0017\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\f\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010 H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010-R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010-R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010-R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b=\u0010-R3\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010*R\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010*R\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b-\u0010-R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u00101R\u0016\u0010U\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u00101R\u0016\u0010W\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u00101R\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\bX\u0010-R\u0016\u0010Z\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u00101R\u0016\u0010\\\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010-R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u00101R\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR&\u0010l\u001a\u0012\u0012\u0004\u0012\u00020h0gj\b\u0012\u0004\u0012\u00020h`i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010*R\u0016\u0010p\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010eR\u0016\u0010r\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010*R\u0016\u0010t\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u00101R\u0016\u0010u\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010-R\u0016\u0010w\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010PR\u0016\u0010y\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u00101R\u0016\u0010{\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u00101R\u0016\u0010}\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010-R'\u0010\u0001\u001a\u0012\u0012\u0004\u0012\u00020~0gj\b\u0012\u0004\u0012\u00020~`i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010kR\u0018\u0010\u0001\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00101R\u0018\u0010\u0001\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00101R\u0018\u0010\u0001\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u00101¨\u0006\u0001"}, d2 = {"Lcom/avito/android/design/widget/RateView;", "Landroid/view/View;", "", "progress", "", "setProgress", "(I)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setRate", "getRate", "()I", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "performClick", "()Z", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, "(Landroid/view/MotionEvent;)V", "Landroid/graphics/Paint;", "x", "Landroid/graphics/Paint;", "hintTextPaint", "C", "I", "MODE_ACTIVE", "", "h", "F", "rightInternalPadding", "f", "hintPadding", ExifInterface.LONGITUDE_EAST, "currentRate", AuthSource.BOOKING_ORDER, "circleSize", "w", "hintTextColor", "z", "thumbTextColor", "D", "maxRate", "H", "Lkotlin/jvm/functions/Function1;", "onRateChangeListener", "Landroid/graphics/drawable/Drawable;", "B", "Landroid/graphics/drawable/Drawable;", "thumbDrawable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "thumbTextPaint", "G", "Z", "isDragging", "k", "defaultPaint", "numberOfCircles", "Lcom/avito/android/design/widget/RateView$d;", "u", "Lcom/avito/android/design/widget/RateView$d;", "activeLinePaintParams", "e", "thumbPadding", "y", "thumbTextSize", "i", "strokeWidth", "J", "numberOfLines", "circleRadius", "l", "defaultColor", "Landroid/graphics/Rect;", "M", "Landroid/graphics/Rect;", "thumbTextRect", "c", "lineHeight", "Lcom/avito/android/design/widget/RateView$b;", "n", "Lcom/avito/android/design/widget/RateView$b;", "defaultCirclePaintParams", "Ljava/util/ArrayList;", "Lcom/avito/android/design/widget/RateView$a;", "Lkotlin/collections/ArrayList;", "K", "Ljava/util/ArrayList;", "circlesCoordinates", "t", "activeLinePaint", "s", "activeCirclePaintParams", "r", "activeCirclePaint", "j", "strokeHalfWidth", "mode", "o", "defaultLinePaintParams", "d", "lineHalfHeight", AuthSource.OPEN_CHANNEL_LIST, "defaultCircleRadius", "p", "activeColor", "Lcom/avito/android/design/widget/RateView$c;", "L", "linesCoordinates", g.a, "leftInternalPadding", VKApiConst.Q, "activeCircleRadius", VKApiConst.VERSION, "hintTextSize", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
@VisibleForTesting
public final class RateView extends View {
    public final Paint A;
    public final Drawable B;
    public final int C;
    public final int D;
    public int E;
    public int F;
    public boolean G;
    public Function1<? super Integer, Unit> H;
    public final int I;
    public final int J;
    public final ArrayList<a> K;
    public final ArrayList<c> L;
    public final Rect M;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final Paint k;
    public final int l;
    public final float m;
    public final b n;
    public final d o;
    public final int p;
    public final float q;
    public Paint r;
    public final b s;
    public Paint t;
    public final d u;
    public final float v;
    public final int w;
    public final Paint x;
    public final float y;
    public final int z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/avito/android/design/widget/RateView$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "I", "getRate", "()I", "setRate", "(I)V", "rate", AuthSource.SEND_ABUSE, "getMode", "setMode", "mode", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public int a;
        public int b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/RateView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/RateView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        public final int getMode() {
            return this.a;
        }

        public final int getRate() {
            return this.b;
        }

        public final void setMode(int i) {
            this.a = i;
        }

        public final void setRate(int i) {
            this.b = i;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
        }
    }

    public static final class a {
        public final float a;
        public final float b;

        public a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }
    }

    public static final class b {
        public final float a;
        @NotNull
        public final Paint b;

        public b(float f, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.a = f;
            this.b = paint;
        }
    }

    public static final class c {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public c(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }
    }

    public static final class d {
        @NotNull
        public final Paint a;

        public d(@NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.a = paint;
        }
    }

    @JvmOverloads
    public RateView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public RateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RateView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        float dimension = getResources().getDimension(R.dimen.rate_view_circle_radius);
        this.a = dimension;
        float f2 = (float) 2;
        this.b = dimension * f2;
        float dimension2 = getResources().getDimension(R.dimen.rate_view_line_height);
        this.c = dimension2;
        this.d = dimension2 / f2;
        this.e = getResources().getDimension(R.dimen.rate_view_thumb_padding);
        this.f = getResources().getDimension(R.dimen.rate_view_hint_padding);
        this.g = getResources().getDimension(R.dimen.rate_view_internal_left_padding);
        this.h = getResources().getDimension(R.dimen.rate_view_internal_right_padding);
        float dimension3 = getResources().getDimension(R.dimen.rate_view_stroke_width);
        this.i = dimension3;
        float f3 = dimension3 / f2;
        this.j = f3;
        Paint paint = new Paint(1);
        this.k = paint;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int i3 = com.avito.android.lib.design.R.attr.gray28;
        int colorByAttr = Contexts.getColorByAttr(context2, i3);
        this.l = colorByAttr;
        float f4 = dimension - f3;
        this.m = f4;
        this.n = new b(f4, paint);
        this.o = new d(paint);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        int colorByAttr2 = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.blue);
        this.p = colorByAttr2;
        this.q = dimension;
        Paint paint2 = new Paint(1);
        this.r = paint2;
        this.s = new b(dimension, paint2);
        Paint paint3 = new Paint();
        this.t = paint3;
        this.u = new d(paint3);
        float dimension4 = getResources().getDimension(R.dimen.rate_view_hint_text_size);
        this.v = dimension4;
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        int colorByAttr3 = Contexts.getColorByAttr(context4, i3);
        this.w = colorByAttr3;
        Paint paint4 = new Paint(1);
        this.x = paint4;
        float dimension5 = getResources().getDimension(R.dimen.rate_view_thumb_text_size);
        this.y = dimension5;
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        int colorByAttr4 = Contexts.getColorByAttr(context5, com.avito.android.lib.design.R.attr.white);
        this.z = colorByAttr4;
        Paint paint5 = new Paint(1);
        this.A = paint5;
        Drawable drawable = getContext().getDrawable(R.drawable.ic_rate_view_thumb);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(R.dr…ble.ic_rate_view_thumb)!!");
        this.B = drawable;
        this.C = 1;
        this.D = 10;
        this.E = -1;
        this.F = 0;
        this.I = 11;
        this.J = 10;
        this.K = new ArrayList<>(11);
        this.L = new ArrayList<>(10);
        this.M = new Rect();
        paint.setColor(colorByAttr);
        paint.setStrokeWidth(dimension3);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint6 = this.r;
        paint6.setColor(colorByAttr2);
        paint6.setStyle(Paint.Style.FILL);
        Paint paint7 = this.t;
        paint7.setColor(colorByAttr2);
        paint7.setStrokeWidth(dimension3);
        paint7.setStyle(Paint.Style.STROKE);
        paint5.setColor(colorByAttr4);
        paint5.setTextSize(dimension5);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setTextAlign(Paint.Align.CENTER);
        paint4.setColor(colorByAttr3);
        paint4.setTextSize(dimension4);
        paint4.setStyle(Paint.Style.STROKE);
    }

    private final void setProgress(int i2) {
        if (this.E != i2) {
            this.E = i2;
            Function1<? super Integer, Unit> function1 = this.H;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
            invalidate();
        }
    }

    public final void a(MotionEvent motionEvent) {
        float f2;
        int round = Math.round(motionEvent.getX());
        float width = (float) getWidth();
        float paddingRight = (width - (this.g + this.h)) - ((float) (getPaddingRight() + getPaddingLeft()));
        float f3 = (float) round;
        if (f3 < this.g + ((float) getPaddingLeft())) {
            f2 = 0.0f;
        } else if (f3 > (width - this.h) - ((float) getPaddingRight())) {
            f2 = 1.0f;
        } else {
            f2 = (f3 - this.g) / paddingRight;
        }
        setProgress(Math.round(f2 * ((float) this.D)));
    }

    public final int getRate() {
        return this.E;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        d dVar;
        b bVar;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int i2 = this.I - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                a aVar = this.K.get(i3);
                Intrinsics.checkNotNullExpressionValue(aVar, "circlesCoordinates[i]");
                a aVar2 = aVar;
                if (this.F != this.C || i3 > this.E) {
                    bVar = this.n;
                } else {
                    bVar = this.s;
                }
                canvas.drawCircle(aVar2.a, aVar2.b, bVar.a, bVar.b);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        int i4 = this.J - 1;
        if (i4 >= 0) {
            int i5 = 0;
            while (true) {
                c cVar = this.L.get(i5);
                Intrinsics.checkNotNullExpressionValue(cVar, "linesCoordinates[i]");
                c cVar2 = cVar;
                if (this.F != this.C || i5 > this.E - 1) {
                    dVar = this.o;
                } else {
                    dVar = this.u;
                }
                canvas.drawLine(cVar2.a, cVar2.b, cVar2.c, cVar2.d, dVar.a);
                if (i5 == i4) {
                    break;
                }
                i5++;
            }
        }
        if (this.E != 0) {
            this.x.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("0", ((float) getPaddingLeft()) + this.g, (((float) (getHeight() - getPaddingBottom())) - this.c) - this.f, this.x);
        }
        if (this.E != this.D) {
            this.x.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(String.valueOf(this.D), ((float) (getWidth() - getPaddingRight())) - this.h, (((float) (getHeight() - getPaddingBottom())) - this.c) - this.f, this.x);
        }
        if (this.F == this.C) {
            a aVar3 = this.K.get(this.E);
            Intrinsics.checkNotNullExpressionValue(aVar3, "circlesCoordinates[currentRate]");
            a aVar4 = aVar3;
            int intrinsicWidth = (int) (aVar4.a - ((float) (this.B.getIntrinsicWidth() / 2)));
            int intrinsicHeight = (int) (((aVar4.b - ((float) this.B.getIntrinsicHeight())) - this.d) - this.e);
            int intrinsicWidth2 = (int) (aVar4.a + ((float) (this.B.getIntrinsicWidth() / 2)));
            this.B.setBounds(intrinsicWidth, intrinsicHeight, intrinsicWidth2, (int) ((aVar4.b - this.d) - this.e));
            this.B.draw(canvas);
            this.A.getTextBounds(String.valueOf(this.E), 0, String.valueOf(this.E).length(), this.M);
            int i6 = intrinsicWidth2 - intrinsicWidth;
            canvas.drawText(String.valueOf(this.E), (((float) i6) / 2.0f) + ((float) intrinsicWidth), (((float) (i6 - this.M.height())) / 2.0f) + ((float) intrinsicHeight) + ((float) this.M.height()), this.A);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        float intrinsicWidth = this.g + this.h + ((float) this.B.getIntrinsicWidth()) + ((float) (getPaddingRight() + getPaddingLeft()));
        float intrinsicHeight = ((float) this.B.getIntrinsicHeight()) + this.c + this.e + ((float) (getPaddingBottom() + getPaddingTop()));
        int i4 = 0;
        int resolveSizeAndState = View.resolveSizeAndState((int) intrinsicWidth, i2, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState((int) intrinsicHeight, i3, 0);
        float paddingRight = (((float) resolveSizeAndState) - (this.g + this.h)) - ((float) (getPaddingRight() + getPaddingLeft()));
        int i5 = this.I;
        float f2 = (paddingRight - (((float) i5) * this.b)) / ((float) (i5 - 1));
        int i6 = i5 - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                this.K.add(i7, new a(((this.b + f2) * ((float) i7)) + this.a + this.g + ((float) getPaddingLeft()), (((float) resolveSizeAndState2) - this.d) - ((float) getPaddingBottom())));
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        int i8 = this.J - 1;
        if (i8 >= 0) {
            while (true) {
                ArrayList<c> arrayList = this.L;
                float paddingLeft = this.b + this.g + ((float) getPaddingLeft());
                float f3 = (float) i4;
                float f4 = (float) resolveSizeAndState2;
                arrayList.add(i4, new c(((this.b + f2) * f3) + paddingLeft, (f4 - this.d) - ((float) getPaddingBottom()), ((this.b + f2) * f3) + paddingLeft + f2, (f4 - this.d) - ((float) getPaddingBottom())));
                if (i4 == i8) {
                    break;
                }
                i4++;
            }
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.F = savedState.getMode();
        this.E = savedState.getRate();
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.setMode(this.F);
        savedState.setRate(this.E);
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.G = true;
            int i2 = this.F;
            int i3 = this.C;
            if (i2 != i3) {
                this.F = i3;
            }
            a(motionEvent);
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3 && this.G) {
                    this.G = false;
                }
            } else if (this.G) {
                a(motionEvent);
            }
        } else if (this.G) {
            a(motionEvent);
            this.G = false;
            performClick();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public final void setOnRateChangeListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.H = function1;
    }

    public final void setRate(int i2) {
        setProgress(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RateView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
