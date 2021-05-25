package com.avito.android.lib.design.segmented_control;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.AttrRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.appearance.AppearanceChangeableView;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B7\b\u0007\u0012\u0006\u0010\u001a\u00020~\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0003¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010\u001a\u001a\u00020\u000526\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001c¢\u0006\u0004\b\u001a\u0010!J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0017¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0017¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010\u0007J\u000f\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u00101J\u0017\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u0010\r\u001a\u00020\u00032\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\b\r\u00109J\u0017\u0010:\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b:\u0010\u0007R\u0016\u0010<\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010AR\"\u0010D\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010C\u001a\u0004\bD\u0010'\"\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010;R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010;R\u0016\u0010S\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010;R\u0016\u0010U\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010;R\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010WR*\u0010^\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010Z0Yj\n\u0012\u0006\u0012\u0004\u0018\u00010Z`[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010;R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010;R\u0016\u0010g\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010;R\u0016\u0010i\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010?R$\u0010m\u001a\u00020\u00032\u0006\u0010j\u001a\u00020\u00038\u0006@BX\u000e¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010;R\u0018\u0010p\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010oR\u0016\u0010q\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010;R0\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@BX\u000e¢\u0006\f\n\u0004\b5\u0010r\u001a\u0004\bs\u0010tR\u0018\u0010w\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010cR\u0016\u0010y\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010;R\u0013\u0010{\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bz\u0010lR\u0016\u0010}\u001a\u00020a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010c¨\u0006\u0001"}, d2 = {"Lcom/avito/android/lib/design/segmented_control/SegmentedControl;", "Landroid/widget/RelativeLayout;", "Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "selectedPosition", "", "setItemsSelectedState", "(I)V", "", "changed", "l", "t", "r", AuthSource.BOOKING_ORDER, "onLayout", "(ZIIII)V", "", "", "segments", "setSegments", "(Ljava/util/List;I)V", "withAnimation", "setSelectedPosition", "(IZ)V", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSegmentClickListener", "(Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segmentPosition", "segmentText", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "performClick", "()Z", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "setAppearance", "e", "()V", "d", "Landroid/content/res/TypedArray;", "array", AuthSource.SEND_ABUSE, "(Landroid/content/res/TypedArray;)V", "", "x", "(F)I", "c", "I", "viewPaddingLeft", "", "k", "J", "hightlightAnimationDuration", "Ljava/lang/Float;", "lastXActionDown", "Z", "isAnimated", "setAnimated", "(Z)V", "segmentedControlWidth", "Landroid/animation/ValueAnimator;", "u", "Landroid/animation/ValueAnimator;", "moveAnimator", "Landroid/view/View;", "s", "Landroid/view/View;", "segmentedControl", "i", "itemCornerRadius", "n", "verticalTextOffset", AuthSource.OPEN_CHANNEL_LIST, "textHorizontalMarginRight", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "segmentedContainer", "Ljava/util/ArrayList;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lkotlin/collections/ArrayList;", "y", "Ljava/util/ArrayList;", "textItems", g.a, "viewPaddingBottom", "Landroid/content/res/ColorStateList;", VKApiConst.Q, "Landroid/content/res/ColorStateList;", "textColorStateList", "cornerRadius", "f", "viewPaddingTop", "j", "selectionSlidingAnimationDuration", "<set-?>", "getCurrentSelected", "()I", "currentSelected", "viewPaddingRight", "Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;", "onSegmentClickListener", "textHorizontalMarginLeft", "Ljava/util/List;", "getCurrentSegments", "()Ljava/util/List;", "currentSegments", "p", "backgroundControlColor", VKApiConst.VERSION, "textAppearanceId", "getSize", "size", "o", "backgroundContainerColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnSegmentClickListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class SegmentedControl extends RelativeLayout implements AppearanceChangeableView {
    @NotNull
    public List<String> a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;
    public ColorStateList o;
    public ColorStateList p;
    public ColorStateList q;
    public LinearLayout r;
    public View s;
    public int t;
    public ValueAnimator u;
    public int v;
    public OnSegmentClickListener w;
    public Float x;
    public ArrayList<AppCompatTextView> y;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/segmented_control/SegmentedControl$OnSegmentClickListener;", "", "", "segmentPosition", "", "segmentText", "", "onSegmentClick", "(ILjava/lang/String;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnSegmentClickListener {
        void onSegmentClick(int i, @NotNull String str);
    }

    public static final class a implements Runnable {
        public final /* synthetic */ SegmentedControl a;

        public a(SegmentedControl segmentedControl) {
            this.a = segmentedControl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e();
            this.a.d();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SegmentedControl a;

        public b(SegmentedControl segmentedControl) {
            this.a = segmentedControl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e();
            this.a.d();
            SegmentedControl.access$invalidateSegments(this.a);
            SegmentedControl segmentedControl = this.a;
            segmentedControl.setItemsSelectedState(segmentedControl.getCurrentSelected());
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SegmentedControl a;

        public c(SegmentedControl segmentedControl) {
            this.a = segmentedControl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e();
            this.a.d();
            SegmentedControl.access$invalidateSegments(this.a);
        }
    }

    @JvmOverloads
    public SegmentedControl(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public SegmentedControl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public SegmentedControl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SegmentedControl(Context context, AttributeSet attributeSet, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? R.attr.segmentedControl : i2, (i4 & 8) != 0 ? R.style.Design_Widget_SegmentedControl : i3);
    }

    public static final void access$invalidateSegments(SegmentedControl segmentedControl) {
        if (segmentedControl.r == null) {
            LinearLayout linearLayout = new LinearLayout(segmentedControl.getContext());
            linearLayout.setGravity(16);
            linearLayout.setOrientation(0);
            segmentedControl.r = linearLayout;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            segmentedControl.addView(linearLayout, layoutParams);
        }
        LinearLayout linearLayout2 = segmentedControl.r;
        if (linearLayout2 != null) {
            if (linearLayout2.getChildCount() != 0) {
                linearLayout2.removeAllViews();
            }
            segmentedControl.y.clear();
            int i2 = 0;
            for (T t2 : segmentedControl.a) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                boolean z = i2 == segmentedControl.b;
                AnimatedTextView animatedTextView = new AnimatedTextView(segmentedControl.getContext(), null, 0, 0, 14, null);
                animatedTextView.setAnimationDuration(segmentedControl.k);
                animatedTextView.setTextColorStateList(segmentedControl.q);
                TextViews.setTextAppearanceCompat(animatedTextView, segmentedControl.v);
                animatedTextView.setGravity(17);
                animatedTextView.setAnimated(segmentedControl.c);
                animatedTextView.setSingleLine();
                animatedTextView.setEllipsize(TextUtils.TruncateAt.END);
                animatedTextView.setSelected(z);
                animatedTextView.setText(t3);
                segmentedControl.y.add(i2, animatedTextView);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                layoutParams2.setMarginStart(segmentedControl.l);
                layoutParams2.setMarginEnd(segmentedControl.m);
                layoutParams2.bottomMargin = segmentedControl.n;
                linearLayout2.addView(animatedTextView, layoutParams2);
                i2 = i3;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setItemsSelectedState(int i2) {
        int i3 = 0;
        for (T t2 : this.y) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            if (t3 != null) {
                t3.setPressed(false);
                t3.setSelected(i3 == i2);
            }
            i3 = i4;
        }
    }

    public static /* synthetic */ void setSegments$default(SegmentedControl segmentedControl, List list, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        segmentedControl.setSegments(list, i2);
    }

    public static /* synthetic */ void setSelectedPosition$default(SegmentedControl segmentedControl, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        segmentedControl.setSelectedPosition(i2, z);
    }

    public final void a(TypedArray typedArray) {
        this.b = typedArray.getInt(R.styleable.SegmentedControl_segmentedControl_defaultSelected, this.b);
        setMinimumHeight(typedArray.getDimensionPixelOffset(R.styleable.SegmentedControl_android_minHeight, getMinimumHeight()));
        this.h = typedArray.getDimensionPixelOffset(R.styleable.SegmentedControl_segmentedControl_cornerRadius, this.h);
        this.i = typedArray.getDimensionPixelOffset(R.styleable.SegmentedControl_segmentedControl_itemCornerRadius, this.i);
        int i2 = R.styleable.SegmentedControl_android_paddingLeft;
        if (typedArray.hasValue(i2)) {
            this.d = typedArray.getLayoutDimension(i2, this.d);
        }
        int i3 = R.styleable.SegmentedControl_android_paddingRight;
        if (typedArray.hasValue(i3)) {
            this.e = typedArray.getLayoutDimension(i3, this.e);
        }
        int i4 = R.styleable.SegmentedControl_android_entries;
        if (typedArray.hasValue(i4)) {
            CharSequence[] textArray = typedArray.getTextArray(i4);
            Intrinsics.checkNotNullExpressionValue(textArray, "getTextArray(it)");
            ArrayList arrayList = new ArrayList(textArray.length);
            for (CharSequence charSequence : textArray) {
                arrayList.add(charSequence.toString());
            }
            this.a = arrayList;
        }
        int i5 = R.styleable.SegmentedControl_android_paddingTop;
        if (typedArray.hasValue(i5)) {
            this.f = typedArray.getLayoutDimension(i5, this.f);
        }
        int i6 = R.styleable.SegmentedControl_android_paddingBottom;
        if (typedArray.hasValue(i6)) {
            this.g = typedArray.getLayoutDimension(i6, this.g);
        }
        setMinimumHeight(typedArray.getDimensionPixelOffset(R.styleable.SegmentedControl_android_minHeight, getMinimumHeight()));
        int i7 = R.styleable.SegmentedControl_segmentedControl_containerColor;
        if (typedArray.hasValue(i7)) {
            ColorStateList colorStateList = typedArray.getColorStateList(i7);
            Intrinsics.checkNotNull(colorStateList);
            this.o = colorStateList;
        }
        int i8 = R.styleable.SegmentedControl_segmentedControl_backgroundColor;
        if (typedArray.hasValue(i8)) {
            this.p = typedArray.getColorStateList(i8);
        }
        int i9 = R.styleable.SegmentedControl_segmentedControl_textColor;
        if (typedArray.hasValue(i9)) {
            ColorStateList colorStateList2 = typedArray.getColorStateList(i9);
            Intrinsics.checkNotNull(colorStateList2);
            this.q = colorStateList2;
        }
        int i10 = R.styleable.Input_android_textAppearance;
        if (typedArray.hasValue(i10)) {
            this.v = typedArray.getResourceId(i10, 0);
        }
        int i11 = R.styleable.SegmentedControl_segmentedControl_textHorizontalInsetLeft;
        if (typedArray.hasValue(i11)) {
            this.l = typedArray.getDimensionPixelOffset(i11, this.l);
        }
        int i12 = R.styleable.SegmentedControl_segmentedControl_textHorizontalInsetRight;
        if (typedArray.hasValue(i12)) {
            this.m = typedArray.getDimensionPixelOffset(i12, this.m);
        }
        int i13 = R.styleable.SegmentedControl_segmentedControl_verticalTextOffset;
        if (typedArray.hasValue(i13)) {
            this.n = typedArray.getDimensionPixelOffset(i13, this.n);
        }
        int i14 = R.styleable.SegmentedControl_segmentedControl_selectionSlidingAnimationDuration;
        if (typedArray.hasValue(i14)) {
            this.j = (long) typedArray.getInt(i14, 0);
        }
        int i15 = R.styleable.SegmentedControl_segmentedControl_highlightAnimationDuration;
        if (typedArray.hasValue(i15)) {
            this.k = (long) typedArray.getInt(i15, 0);
        }
        setBackground(RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.o, null, this.h, null, 0, 0, 0, 122, null));
        setPadding(this.d, this.f, this.e, this.g);
    }

    public final int b(float f2) {
        int x2 = (int) ((f2 - getX()) / (((float) getWidth()) / ((float) this.a.size())));
        return x2 >= this.a.size() ? x2 - 1 : x2;
    }

    public final void c(int i2) {
        if (!(i2 < getSize())) {
            StringBuilder L = a2.b.a.a.a.L("Illegal selectedPosition. Maximum selected position = ");
            L.append(getSize() - 1);
            L.append(", selected = ");
            L.append(i2);
            throw new IllegalArgumentException(L.toString().toString());
        }
    }

    public final void d() {
        View view = this.s;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.width * this.b, 0, 0, 0);
            view.setLayoutParams(layoutParams2);
        }
    }

    public final void e() {
        if (getSize() != 0) {
            View view = this.s;
            if (view == null) {
                View view2 = new View(getContext());
                view2.setBackground(RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, this.p, null, this.i, null, 0, 0, 0, 122, null));
                Unit unit = Unit.INSTANCE;
                this.s = view2;
                this.t = (getWidth() - (this.d + this.e)) / getSize();
                int height = getHeight() - (this.f + this.g);
                View view3 = this.s;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.t, height);
                layoutParams.addRule(9, -1);
                addView(view3, layoutParams);
            } else if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                int width = (getWidth() - (this.d + this.e)) / getSize();
                this.t = width;
                layoutParams3.width = width;
                Unit unit2 = Unit.INSTANCE;
                view.setLayoutParams(layoutParams3);
            }
        }
    }

    @NotNull
    public final List<String> getCurrentSegments() {
        return this.a;
    }

    public final int getCurrentSelected() {
        return this.b;
    }

    public final int getSize() {
        return this.a.size();
    }

    public final boolean isAnimated() {
        return this.c;
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.s == null && z) {
            e();
            d();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new a(this));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Float f2;
        View view;
        Float f3;
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Float f4 = this.x;
        this.x = Float.valueOf(motionEvent.getX());
        if (motionEvent.getAction() == 0 && (f3 = this.x) != null) {
            int b2 = b(f3.floatValue());
            int i2 = 0;
            for (T t2 : this.y) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                if (t3 != null) {
                    t3.setPressed(i2 == b2);
                }
                i2 = i3;
            }
        }
        if (motionEvent.getAction() == 2 && (view = this.s) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            Intrinsics.checkNotNull(f4);
            float floatValue = ((float) ((RelativeLayout.LayoutParams) layoutParams).leftMargin) - f4.floatValue();
            Float f5 = this.x;
            Intrinsics.checkNotNull(f5);
            int roundToInt = t6.s.c.roundToInt(f5.floatValue() + floatValue);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
            layoutParams3.setMargins(roundToInt, 0, 0, 0);
            view.setLayoutParams(layoutParams3);
        }
        if (motionEvent.getAction() == 1 && (f2 = this.x) != null) {
            int b3 = b(f2.floatValue());
            setSelectedPosition(b3, true);
            OnSegmentClickListener onSegmentClickListener = this.w;
            if (onSegmentClickListener != null) {
                onSegmentClickListener.onSegmentClick(b3, this.a.get(b3));
            }
        }
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean performClick() {
        Float f2 = this.x;
        if (f2 != null) {
            int b2 = b(f2.floatValue());
            setSelectedPosition(b2, true);
            OnSegmentClickListener onSegmentClickListener = this.w;
            if (onSegmentClickListener != null) {
                onSegmentClickListener.onSegmentClick(b2, this.a.get(b2));
            }
        }
        return true;
    }

    public final void setAnimated(boolean z) {
        this.c = z;
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearance(int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(i2, R.styleable.SegmentedControl);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        post(new b(this));
    }

    @Override // com.avito.android.util.appearance.AppearanceChangeableView
    public void setAppearanceFromAttr(@AttrRes int i2) {
        AppearanceChangeableView.DefaultImpls.setAppearanceFromAttr(this, i2);
    }

    public final void setOnSegmentClickListener(@NotNull OnSegmentClickListener onSegmentClickListener) {
        Intrinsics.checkNotNullParameter(onSegmentClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = onSegmentClickListener;
    }

    public final void setSegments(@NotNull List<String> list, int i2) {
        Intrinsics.checkNotNullParameter(list, "segments");
        if (list.size() >= 2) {
            this.a = list;
            c(i2);
            this.b = i2;
            post(new c(this));
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Illegal segments count. Minimum size = 2, current = ");
        L.append(list.size());
        throw new IllegalArgumentException(L.toString().toString());
    }

    public final void setSelectedPosition(int i2, boolean z) {
        AppCompatTextView appCompatTextView;
        c(i2);
        for (T t2 : this.y) {
            if (t2 != null) {
                t2.setSelected(false);
            }
        }
        if (this.y.size() > i2 && (appCompatTextView = this.y.get(i2)) != null) {
            appCompatTextView.setSelected(true);
        }
        this.b = i2;
        if (z) {
            View view = this.s;
            if (view != null) {
                ValueAnimator valueAnimator = this.u;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ValueAnimator duration = ValueAnimator.ofInt(((RelativeLayout.LayoutParams) layoutParams).leftMargin, this.t * this.b).setDuration(this.j);
                duration.addListener(new AnimatorListenerAdapter(view, this) { // from class: com.avito.android.lib.design.segmented_control.SegmentedControl$animateMoveControl$$inlined$also$lambda$1
                    public final /* synthetic */ View a;
                    public final /* synthetic */ SegmentedControl b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@Nullable Animator animator) {
                        this.b.u = null;
                    }
                });
                duration.addUpdateListener(new a2.a.a.k1.a.i.a(view, this));
                duration.start();
                this.u = duration;
            }
        } else {
            d();
        }
        setItemsSelectedState(this.b);
    }

    public final void setOnSegmentClickListener(@NotNull Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = new OnSegmentClickListener(function2) { // from class: com.avito.android.lib.design.segmented_control.SegmentedControl$setOnSegmentClickListener$1
            public final /* synthetic */ Function2 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.design.segmented_control.SegmentedControl.OnSegmentClickListener
            public void onSegmentClick(int i2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "segmentText");
                this.a.invoke(Integer.valueOf(i2), str);
            }
        };
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SegmentedControl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = CollectionsKt__CollectionsKt.emptyList();
        this.c = true;
        this.j = 300;
        this.k = 300;
        this.o = Contexts.getColorStateListByAttr(context, R.attr.gray4);
        this.p = ContextCompat.getColorStateList(context, R.color.common_segmented_control_background);
        ColorStateList colorStateList = ContextCompat.getColorStateList(context, R.color.txt_segmented_control_item_text);
        Intrinsics.checkNotNull(colorStateList);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "ContextCompat.getColorSt…nted_control_item_text)!!");
        this.q = colorStateList;
        this.v = R.style.Design_TextAppearance_Avito_Body;
        this.y = new ArrayList<>();
        setGravity(16);
        setMinimumHeight(0);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SegmentedControl, i2, i3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "array");
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        post(new a2.a.a.k1.a.i.b(this));
    }
}
