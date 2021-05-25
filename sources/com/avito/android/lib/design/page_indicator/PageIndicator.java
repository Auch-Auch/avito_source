package com.avito.android.lib.design.page_indicator;

import a2.a.a.k1.a.e.a;
import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.page_indicator.DotParamsProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.GlobalAnimationsKt;
import com.avito.android.util.Parcels;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001tB\u0013\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k¢\u0006\u0004\bm\u0010nB\u001d\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u0012\b\u0010p\u001a\u0004\u0018\u00010o¢\u0006\u0004\bm\u0010qB%\b\u0016\u0012\b\u0010l\u001a\u0004\u0018\u00010k\u0012\b\u0010p\u001a\u0004\u0018\u00010o\u0012\u0006\u0010r\u001a\u00020\n¢\u0006\u0004\bm\u0010sJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0004\b#\u0010$J!\u0010*\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u001f\u0010-\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014¢\u0006\u0004\b-\u0010)J\u0017\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.H\u0014¢\u0006\u0004\b0\u00101J/\u00106\u001a\u00020\u00172\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0004\b9\u0010:J\u0019\u0010<\u001a\u00020\u00172\b\u0010;\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010ER\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010CR\u0016\u0010N\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010CR\u0016\u0010O\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010HR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010ER\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010WR\u0016\u0010Z\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ER\u0016\u0010\\\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010HR\u0016\u0010^\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010ER\u0016\u0010_\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010ER\u0016\u0010a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010CR\u0016\u0010b\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010ER\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010j\u001a\b\u0012\u0002\b\u0003\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006u"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "Landroid/view/View;", "Landroid/graphics/Paint;", "getBackgroundPaint", "()Landroid/graphics/Paint;", "", "getContentWidth", "()F", "getContentHeight", "getAnimationExtraSpace", "", FirebaseAnalytics.Param.INDEX, "c", "(I)Landroid/graphics/Paint;", "d", "(I)F", "i", "direction", AuthSource.BOOKING_ORDER, "(II)I", "desiredSize", "measureSpec", "f", "", AuthSource.SEND_ABUSE, "()V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "attachToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "attachToViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "pageCount", "setPageCount$components_release", "(I)V", "setPageCount", "page", "dx", "setSelectedPage$components_release", "(II)V", "setSelectedPage", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Landroid/animation/ValueAnimator;", "p", "Landroid/animation/ValueAnimator;", "moveAnimator", "e", "Landroid/graphics/Paint;", "selectedDotPaint", "F", "smallRadius", "r", "I", "", "s", "Z", "isHidden", "unselectedDotPaint", "backgroundPaint", "desiredDotCount", "j", "backgroundRectRadius", "", "o", "[F", "dotSizeDiff", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "backgroundRect", AuthSource.OPEN_CHANNEL_LIST, "animationDrawingOffset", VKApiConst.Q, "selectedIndex", "n", "animationPercent", "radius", g.a, "transparentPaint", "dotPadding", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider;", "k", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider;", "dotParamsProvider", "Lcom/avito/android/lib/design/page_indicator/AttachDelegate;", "l", "Lcom/avito/android/lib/design/page_indicator/AttachDelegate;", "delegate", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class PageIndicator extends View {
    public int a;
    public float b;
    public float c;
    public float d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final RectF i;
    public float j;
    public DotParamsProvider k;
    public AttachDelegate<?> l;
    public float m;
    public float n;
    public float[] o;
    public ValueAnimator p;
    public int q;
    public int r;
    public boolean s;

    public PageIndicator(@Nullable Context context) {
        super(context);
        this.a = 5;
        this.e = new Paint();
        this.f = new Paint();
        Paint paint = new Paint();
        paint.setColor(0);
        this.g = paint;
        this.h = new Paint();
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.j = getResources().getDimension(R.dimen.design_page_indicator_bg_rect_radius);
        this.k = new DotParamsProvider();
        this.o = new float[this.a];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0f…erateInterpolator()\n    }");
        this.p = ofFloat;
        this.r = -1;
        e(this, null, 0, 0, 6);
    }

    public static void e(PageIndicator pageIndicator, AttributeSet attributeSet, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        Integer valueOf = Integer.valueOf(i2);
        Integer num = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : R.attr.pageIndicator;
        Integer valueOf2 = Integer.valueOf(i3);
        if (valueOf2.intValue() > 0) {
            num = valueOf2;
        }
        TypedArray obtainStyledAttributes = pageIndicator.getContext().obtainStyledAttributes(attributeSet, R.styleable.PageIndicator, intValue, num != null ? num.intValue() : R.style.Design_Widget_PageIndicator);
        pageIndicator.a = obtainStyledAttributes.getInt(R.styleable.PageIndicator_dotCount, 5);
        float f2 = (float) 2;
        pageIndicator.b = obtainStyledAttributes.getDimension(R.styleable.PageIndicator_dotSize, obtainStyledAttributes.getResources().getDimension(R.dimen.design_page_indicator_dot_big_size)) / f2;
        pageIndicator.c = obtainStyledAttributes.getDimension(R.styleable.PageIndicator_smallDotSize, obtainStyledAttributes.getResources().getDimension(R.dimen.design_page_indicator_dot_small_size)) / f2;
        pageIndicator.d = obtainStyledAttributes.getDimension(R.styleable.PageIndicator_dotPadding, obtainStyledAttributes.getResources().getDimension(R.dimen.design_page_indicator_dot_offset));
        int i5 = R.styleable.PageIndicator_selectedDotColor;
        Context context = pageIndicator.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int color = obtainStyledAttributes.getColor(i5, Contexts.getColorByAttr(context, R.attr.blue));
        Paint paint = pageIndicator.e;
        paint.setColor(color);
        paint.setAntiAlias(true);
        int i6 = R.styleable.PageIndicator_unselectedDotColor;
        Context context2 = pageIndicator.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int color2 = obtainStyledAttributes.getColor(i6, Contexts.getColorByAttr(context2, R.attr.gray12));
        Paint paint2 = pageIndicator.f;
        paint2.setColor(color2);
        paint2.setAntiAlias(true);
        int color3 = obtainStyledAttributes.getColor(R.styleable.PageIndicator_backgroundColor, 0);
        Paint paint3 = pageIndicator.h;
        paint3.setColor(color3);
        paint3.setAntiAlias(true);
        int i7 = R.styleable.PageIndicator_android_paddingStart;
        if (!obtainStyledAttributes.hasValue(i7)) {
            i7 = R.styleable.PageIndicator_android_paddingLeft;
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i7, 0);
        int i8 = R.styleable.PageIndicator_android_paddingEnd;
        if (!obtainStyledAttributes.hasValue(i8)) {
            i8 = R.styleable.PageIndicator_android_paddingRight;
        }
        pageIndicator.setPadding(dimensionPixelOffset, obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PageIndicator_android_paddingTop, 0), obtainStyledAttributes.getDimensionPixelOffset(i8, 0), obtainStyledAttributes.getDimensionPixelOffset(R.styleable.PageIndicator_android_paddingBottom, 0));
        obtainStyledAttributes.recycle();
        if (pageIndicator.isInEditMode()) {
            pageIndicator.invalidate();
        }
    }

    private final float getAnimationExtraSpace() {
        return (this.b * ((float) 2)) + this.d;
    }

    private final Paint getBackgroundPaint() {
        boolean z = this.s;
        if (z) {
            return this.g;
        }
        if (!z) {
            return this.h;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final float getContentHeight() {
        return this.b * ((float) 2);
    }

    private final float getContentWidth() {
        return (((float) (this.k.getDotCount() - 1)) * this.d) + (((float) this.k.getDotCount()) * this.b * ((float) 2));
    }

    public static /* synthetic */ void setSelectedPage$components_release$default(PageIndicator pageIndicator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        pageIndicator.setSelectedPage$components_release(i2, i3);
    }

    public final void a() {
        float contentWidth = getContentWidth();
        float contentHeight = getContentHeight();
        float height = ((float) getHeight()) / 2.0f;
        RectF rectF = this.i;
        float width = (float) (getWidth() / 2);
        float f2 = (float) 2;
        float f3 = contentWidth / f2;
        rectF.left = (width - f3) - ((float) getPaddingLeft());
        float f4 = contentHeight / f2;
        rectF.top = (height - f4) - ((float) getPaddingTop());
        rectF.right = width + f3 + ((float) getPaddingRight());
        rectF.bottom = height + f4 + ((float) getPaddingBottom());
    }

    public final void attachToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        AttachDelegate<?> attachDelegate = this.l;
        if (attachDelegate != null) {
            attachDelegate.detachSelf();
        }
        RecyclerViewAttachDelegate recyclerViewAttachDelegate = new RecyclerViewAttachDelegate(this);
        recyclerViewAttachDelegate.attachSelf(recyclerView);
        Unit unit = Unit.INSTANCE;
        this.l = recyclerViewAttachDelegate;
    }

    public final void attachToViewPager(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        AttachDelegate<?> attachDelegate = this.l;
        if (attachDelegate != null) {
            attachDelegate.detachSelf();
        }
        ViewPagerAttachDelegate viewPagerAttachDelegate = new ViewPagerAttachDelegate(this);
        viewPagerAttachDelegate.attachSelf(viewPager);
        Unit unit = Unit.INSTANCE;
        this.l = viewPagerAttachDelegate;
    }

    public final int b(int i2, int i3) {
        int dotCount = (i2 - i3) % this.k.getDotCount();
        return dotCount < 0 ? this.k.getDotCount() - 1 : dotCount;
    }

    public final Paint c(int i2) {
        if (this.s) {
            return this.g;
        }
        if (this.k.isSelected(i2, this.q, this.r)) {
            return this.e;
        }
        return this.f;
    }

    public final float d(int i2) {
        return this.k.isSmall(i2, this.q, this.r) ? this.c : this.b;
    }

    public final int f(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i2 : size;
        }
        return Math.min(i2, size);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.i;
        float f2 = this.j;
        canvas.drawRoundRect(rectF, f2, f2, getBackgroundPaint());
        float f3 = (float) 2;
        float measuredWidth = ((((float) getMeasuredWidth()) - getContentWidth()) / f3) + this.b;
        float f4 = this.m;
        float f5 = measuredWidth + f4;
        if (f4 == 0.0f) {
            int dotCount = this.k.getDotCount();
            for (int i2 = 0; i2 < dotCount; i2++) {
                canvas.drawCircle((((this.b * f3) + this.d) * ((float) i2)) + f5, ((float) getHeight()) / f3, d(i2), c(i2));
            }
            return;
        }
        int dotCount2 = this.k.getDotCount();
        for (int i3 = 0; i3 < dotCount2; i3++) {
            int b2 = b(i3, this.r);
            float min = Math.min((this.o[i3] * this.n) + d(b2), this.b);
            Paint c2 = c(i3);
            int i4 = i3 - this.r;
            if (!(this.n < 0.25f && b2 != i4)) {
                canvas.drawCircle((((this.b * f3) + this.d) * ((float) i4)) + f5, ((float) getHeight()) / f3, min, c2);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(f((int) (((float) (getPaddingRight() + getPaddingLeft())) + getContentWidth() + getAnimationExtraSpace()), i2), f((int) (((float) (getPaddingBottom() + getPaddingTop())) + getContentHeight()), i3));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.k.restore(savedState.getProviderState$components_release());
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        return new SavedState(onSaveInstanceState, this.k.getState());
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a();
    }

    public final void setPageCount$components_release(int i2) {
        int min = Math.min(i2, this.a);
        int i3 = this.a;
        if (min < i3 && i2 >= i3) {
            min = i3;
        }
        this.k.updateParams(min, i2);
        this.o = new float[min];
        a();
        this.q = -1;
        this.s = min < 2;
        invalidate();
    }

    public final void setSelectedPage$components_release(int i2, int i3) {
        int i4 = this.q;
        if (i2 != i4) {
            int i5 = i2 - i4;
            int i6 = -1;
            boolean z = Math.abs(i5) > 1 || this.q == -1;
            this.q = i2;
            this.r = i3 < 0 ? 1 : -1;
            if (i3 == 0) {
                if (i5 <= 0) {
                    i6 = 1;
                }
                this.r = i6;
            }
            if (!z && this.k.isAnimationRequired(i2, this.r)) {
                int dotCount = this.k.getDotCount();
                for (int i7 = 0; i7 < dotCount; i7++) {
                    this.o[i7] = d(i7) - d(b(i7, this.r));
                }
                float animationExtraSpace = ((float) this.r) * getAnimationExtraSpace();
                if (this.p.isRunning()) {
                    GlobalAnimationsKt.setSafeRepeatCount(this.p, 1);
                    return;
                }
                this.p.removeAllUpdateListeners();
                this.p.addUpdateListener(new a(this, animationExtraSpace));
                GlobalAnimationsKt.setSafeRepeatCount(this.p, 0);
                this.p.start();
                return;
            }
            this.p.end();
            this.m = 0.0f;
            invalidate();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/PageIndicator$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "getProviderState$components_release", "()Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;", "providerState", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;Lcom/avito/android/lib/design/page_indicator/DotParamsProvider$State;)V", "source", "(Landroid/os/Parcel;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final DotParamsProvider.State a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/PageIndicator$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/page_indicator/PageIndicator$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
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
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable, @NotNull DotParamsProvider.State state) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            Intrinsics.checkNotNullParameter(state, "providerState");
            this.a = state;
        }

        @NotNull
        public final DotParamsProvider.State getProviderState$components_release() {
            return this.a;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, i);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.a = (DotParamsProvider.State) a2.b.a.a.a.z1(DotParamsProvider.State.class, parcel);
        }
    }

    public PageIndicator(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.pageIndicator);
        this.a = 5;
        this.e = new Paint();
        this.f = new Paint();
        Paint paint = new Paint();
        paint.setColor(0);
        this.g = paint;
        this.h = new Paint();
        this.i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.j = getResources().getDimension(R.dimen.design_page_indicator_bg_rect_radius);
        this.k = new DotParamsProvider();
        this.o = new float[this.a];
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(250L);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0f…erateInterpolator()\n    }");
        this.p = ofFloat;
        this.r = -1;
        e(this, attributeSet, 0, 0, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PageIndicator(@org.jetbrains.annotations.Nullable android.content.Context r4, @org.jetbrains.annotations.Nullable android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            int r1 = r0.intValue()
            r2 = 0
            if (r1 <= 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0019
            int r0 = r0.intValue()
            goto L_0x001b
        L_0x0019:
            int r0 = com.avito.android.lib.design.R.attr.pageIndicator
        L_0x001b:
            r3.<init>(r4, r5, r0)
            r4 = 5
            r3.a = r4
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r3.e = r4
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r3.f = r4
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r4.setColor(r2)
            r3.g = r4
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r3.h = r4
            android.graphics.RectF r4 = new android.graphics.RectF
            r0 = 0
            r4.<init>(r0, r0, r0, r0)
            r3.i = r4
            android.content.res.Resources r4 = r3.getResources()
            int r0 = com.avito.android.lib.design.R.dimen.design_page_indicator_bg_rect_radius
            float r4 = r4.getDimension(r0)
            r3.j = r4
            com.avito.android.lib.design.page_indicator.DotParamsProvider r4 = new com.avito.android.lib.design.page_indicator.DotParamsProvider
            r4.<init>()
            r3.k = r4
            int r4 = r3.a
            float[] r4 = new float[r4]
            r3.o = r4
            r4 = 2
            float[] r4 = new float[r4]
            r4 = {x0088: FILL_ARRAY_DATA  , data: [0, 1065353216} // fill-array
            android.animation.ValueAnimator r4 = android.animation.ValueAnimator.ofFloat(r4)
            r0 = 250(0xfa, double:1.235E-321)
            r4.setDuration(r0)
            android.view.animation.AccelerateInterpolator r0 = new android.view.animation.AccelerateInterpolator
            r0.<init>()
            r4.setInterpolator(r0)
            java.lang.String r0 = "ValueAnimator.ofFloat(0f…erateInterpolator()\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.p = r4
            r4 = -1
            r3.r = r4
            r4 = 4
            e(r3, r5, r6, r2, r4)
            return
            fill-array 0x0088: FILL_ARRAY_DATA  , data: [0, 1065353216]
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.page_indicator.PageIndicator.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
