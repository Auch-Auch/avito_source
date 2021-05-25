package com.avito.android.design.widget;

import a2.g.r.g;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Parcels;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e*\u00018\u0018\u00002\u00020\u0001:\u0002N#B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\bH\u0010IB\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\bH\u0010\u0019B!\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010J\u001a\u00020\u0002¢\u0006\u0004\bH\u0010KB)\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010J\u001a\u00020\u0002\u0012\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0004\bH\u0010MJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00104\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u0010&R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010+R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010+R\u0018\u0010@\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010BR\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010+R\u0016\u0010G\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bF\u0010&¨\u0006O"}, d2 = {"Lcom/avito/android/design/widget/RecyclerPageIndicator;", "Landroid/widget/LinearLayout;", "", "getCurrentPosition", "()I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "setRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "", "dpValue", "dip2px", "(F)I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/animation/Animator;", AuthSource.BOOKING_ORDER, "(Landroid/content/Context;)Landroid/animation/Animator;", VKApiConst.POSITION, "d", "(I)V", "orientation", "backgroundDrawableId", "animator", AuthSource.SEND_ABUSE, "(IILandroid/animation/Animator;)V", "k", "Landroid/animation/Animator;", "animatorIn", "l", "immediateAnimatorOut", "o", "I", "itemCount", g.a, "animatorReverseResId", "i", "indicatorUnselectedBackgroundResId", "f", "animatorResId", "j", "animatorOut", "indicatorMargin", "h", "indicatorBackgroundResId", "com/avito/android/design/widget/RecyclerPageIndicator$pageListener$1", "p", "Lcom/avito/android/design/widget/RecyclerPageIndicator$pageListener$1;", "pageListener", "indicatorWidth", "n", "lastPosition", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/design/widget/IndicatorLayoutManager;", "Lcom/avito/android/design/widget/IndicatorLayoutManager;", "layoutManager", "e", "indicatorHeight", AuthSource.OPEN_CHANNEL_LIST, "immediateAnimatorIn", "<init>", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "IndicatorState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerPageIndicator extends LinearLayout {
    public RecyclerView a;
    public IndicatorLayoutManager b;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public int f = R.animator.scale_with_alpha;
    public int g;
    public int h;
    public int i;
    public Animator j;
    public Animator k;
    public Animator l;
    public Animator m;
    public int n;
    public int o;
    public final RecyclerPageIndicator$pageListener$1 p;

    public final class a implements Interpolator {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(RecyclerPageIndicator recyclerPageIndicator) {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerPageIndicator(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = R.drawable.white_radius;
        this.h = i2;
        this.i = i2;
        this.n = -1;
        this.p = new RecyclerPageIndicator$pageListener$1(this);
        c(context, null);
    }

    private final int getCurrentPosition() {
        IndicatorLayoutManager indicatorLayoutManager = this.b;
        if (indicatorLayoutManager != null) {
            return indicatorLayoutManager.findFirstCompletelyVisibleItemPosition();
        }
        return -1;
    }

    public final void a(int i2, @DrawableRes int i3, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i3);
        addView(view, this.d, this.e);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (i2 == 0) {
            int i4 = this.c;
            layoutParams2.leftMargin = i4;
            layoutParams2.rightMargin = i4;
        } else {
            int i5 = this.c;
            layoutParams2.topMargin = i5;
            layoutParams2.bottomMargin = i5;
        }
        view.setLayoutParams(layoutParams2);
        animator.setTarget(view);
        animator.start();
    }

    public final Animator b(Context context) {
        int i2 = this.g;
        if (i2 == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, this.f);
            Intrinsics.checkNotNullExpressionValue(loadAnimator, "AnimatorInflater.loadAni…r(context, animatorResId)");
            loadAnimator.setInterpolator(new a(this));
            return loadAnimator;
        }
        Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, i2);
        Intrinsics.checkNotNullExpressionValue(loadAnimator2, "AnimatorInflater.loadAni…xt, animatorReverseResId)");
        return loadAnimator2;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerPageIndicator);
            this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerPageIndicator_ci_width, -1);
            this.e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerPageIndicator_ci_height, -1);
            this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecyclerPageIndicator_ci_margin, -1);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.RecyclerPageIndicator_ci_animator, R.animator.scale_with_alpha);
            this.g = obtainStyledAttributes.getResourceId(R.styleable.RecyclerPageIndicator_ci_animator_reverse, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.RecyclerPageIndicator_ci_drawable, R.drawable.white_radius);
            this.h = resourceId;
            this.i = obtainStyledAttributes.getResourceId(R.styleable.RecyclerPageIndicator_ci_drawable_unselected, resourceId);
            obtainStyledAttributes.recycle();
        }
        int i2 = this.d;
        if (i2 < 0) {
            i2 = dip2px((float) 5);
        }
        this.d = i2;
        int i3 = this.e;
        if (i3 < 0) {
            i3 = dip2px((float) 5);
        }
        this.e = i3;
        int i4 = this.c;
        if (i4 < 0) {
            i4 = dip2px((float) 5);
        }
        this.c = i4;
        int i5 = this.f;
        if (i5 == 0) {
            i5 = R.animator.scale_with_alpha;
        }
        this.f = i5;
        Animator loadAnimator = AnimatorInflater.loadAnimator(context, i5);
        Intrinsics.checkNotNullExpressionValue(loadAnimator, "AnimatorInflater.loadAni…r(context, animatorResId)");
        this.j = loadAnimator;
        Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, this.f);
        Intrinsics.checkNotNullExpressionValue(loadAnimator2, "AnimatorInflater.loadAni…r(context, animatorResId)");
        this.l = loadAnimator2;
        if (loadAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immediateAnimatorOut");
        }
        loadAnimator2.setDuration(0);
        this.k = b(context);
        Animator b2 = b(context);
        this.m = b2;
        if (b2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immediateAnimatorIn");
        }
        b2.setDuration(0);
        int i6 = this.h;
        if (i6 == 0) {
            i6 = R.drawable.white_radius;
        }
        this.h = i6;
        int i7 = this.i;
        if (i7 != 0) {
            i6 = i7;
        }
        this.i = i6;
    }

    public final void d(int i2) {
        Animator animator = this.k;
        if (animator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animatorIn");
        }
        if (animator.isRunning()) {
            Animator animator2 = this.k;
            if (animator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorIn");
            }
            animator2.end();
            Animator animator3 = this.k;
            if (animator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorIn");
            }
            animator3.cancel();
        }
        View childAt = getChildAt(this.n);
        if (this.n >= 0 && childAt != null) {
            childAt.setBackgroundResource(this.i);
            Animator animator4 = this.k;
            if (animator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorIn");
            }
            animator4.setTarget(childAt);
            Animator animator5 = this.k;
            if (animator5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorIn");
            }
            animator5.start();
        }
        Animator animator6 = this.j;
        if (animator6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animatorOut");
        }
        if (animator6.isRunning()) {
            Animator animator7 = this.j;
            if (animator7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorOut");
            }
            animator7.end();
            Animator animator8 = this.j;
            if (animator8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorOut");
            }
            animator8.cancel();
        }
        View childAt2 = getChildAt(i2);
        if (childAt2 != null) {
            childAt2.setBackgroundResource(this.h);
            Animator animator9 = this.j;
            if (animator9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorOut");
            }
            animator9.setTarget(childAt2);
            Animator animator10 = this.j;
            if (animator10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animatorOut");
            }
            animator10.start();
        }
        this.n = i2;
    }

    public final int dip2px(float f2) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof IndicatorState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        IndicatorState indicatorState = (IndicatorState) parcelable;
        super.onRestoreInstanceState(indicatorState.getSuperState());
        int lastPosition = indicatorState.getLastPosition();
        if (this.n >= 0) {
            d(lastPosition);
        }
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        IndicatorState indicatorState = new IndicatorState(onSaveInstanceState);
        indicatorState.setLastPosition(this.n);
        return indicatorState;
    }

    public final void setRecycler(@NotNull RecyclerView recyclerView) {
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type com.avito.android.design.widget.IndicatorLayoutManager");
        IndicatorLayoutManager indicatorLayoutManager = (IndicatorLayoutManager) layoutManager;
        indicatorLayoutManager.setPageListener(this.p);
        this.b = indicatorLayoutManager;
        RecyclerView recyclerView2 = this.a;
        this.o = (recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null) ? 0 : adapter.getItemCount();
        removeAllViews();
        RecyclerView recyclerView3 = this.a;
        if (recyclerView3 != null) {
            RecyclerView.Adapter adapter2 = recyclerView3.getAdapter();
            int itemCount = adapter2 != null ? adapter2.getItemCount() : 0;
            if (itemCount > 0) {
                int orientation = getOrientation();
                int i2 = itemCount - 1;
                if (i2 >= 0) {
                    int i3 = 0;
                    while (true) {
                        if (getCurrentPosition() == i3) {
                            int i4 = this.h;
                            Animator animator = this.l;
                            if (animator == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("immediateAnimatorOut");
                            }
                            a(orientation, i4, animator);
                        } else {
                            int i5 = this.i;
                            Animator animator2 = this.m;
                            if (animator2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("immediateAnimatorIn");
                            }
                            a(orientation, i5, animator2);
                        }
                        if (i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        int i6 = this.n;
        if (i6 > 0) {
            d(i6);
        } else {
            d(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/design/widget/RecyclerPageIndicator$IndicatorState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "I", "getLastPosition", "setLastPosition", "(I)V", "lastPosition", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class IndicatorState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<IndicatorState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public int a = -1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/RecyclerPageIndicator$IndicatorState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/RecyclerPageIndicator$IndicatorState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, IndicatorState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public IndicatorState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new IndicatorState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IndicatorState(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        @Override // android.os.Parcelable, android.view.AbsSavedState
        public int describeContents() {
            return 0;
        }

        public final int getLastPosition() {
            return this.a;
        }

        public final void setLastPosition(int i) {
            this.a = i;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IndicatorState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a = parcel.readInt();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerPageIndicator(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        int i2 = R.drawable.white_radius;
        this.h = i2;
        this.i = i2;
        this.n = -1;
        this.p = new RecyclerPageIndicator$pageListener$1(this);
        c(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerPageIndicator(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        int i3 = R.drawable.white_radius;
        this.h = i3;
        this.i = i3;
        this.n = -1;
        this.p = new RecyclerPageIndicator$pageListener$1(this);
        c(context, attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerPageIndicator(@NotNull Context context, @NotNull AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        int i4 = R.drawable.white_radius;
        this.h = i4;
        this.i = i4;
        this.n = -1;
        this.p = new RecyclerPageIndicator$pageListener$1(this);
        c(context, attributeSet);
    }
}
