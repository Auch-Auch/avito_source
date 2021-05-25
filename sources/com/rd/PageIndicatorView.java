package com.rd;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.rd.IndicatorManager;
import com.rd.animation.type.AnimationType;
import com.rd.draw.controller.DrawController;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;
import com.rd.draw.data.PositionSavedState;
import com.rd.draw.data.RtlMode;
import com.rd.utils.CoordinatesUtils;
import com.rd.utils.DensityUtils;
import com.rd.utils.IdUtils;
public class PageIndicatorView extends View implements ViewPager.OnPageChangeListener, IndicatorManager.a, ViewPager.OnAdapterChangeListener, View.OnTouchListener {
    public static final Handler f = new Handler(Looper.getMainLooper());
    public IndicatorManager a;
    public DataSetObserver b;
    public ViewPager c;
    public boolean d;
    public Runnable e = new b();

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PageIndicatorView pageIndicatorView = PageIndicatorView.this;
            Handler handler = PageIndicatorView.f;
            pageIndicatorView.i();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PageIndicatorView.this.a.indicator().setIdle(true);
            PageIndicatorView pageIndicatorView = PageIndicatorView.this;
            pageIndicatorView.animate().cancel();
            pageIndicatorView.animate().alpha(0.0f).setDuration(250);
        }
    }

    public PageIndicatorView(Context context) {
        super(context);
        b(null);
    }

    public final void a(@Nullable ViewParent viewParent) {
        View findViewById;
        if (viewParent != null && (viewParent instanceof ViewGroup) && ((ViewGroup) viewParent).getChildCount() > 0) {
            int viewPagerId = this.a.indicator().getViewPagerId();
            ViewGroup viewGroup = (ViewGroup) viewParent;
            ViewPager viewPager = null;
            if (viewGroup.getChildCount() > 0 && (findViewById = viewGroup.findViewById(viewPagerId)) != null && (findViewById instanceof ViewPager)) {
                viewPager = (ViewPager) findViewById;
            }
            if (viewPager != null) {
                setViewPager(viewPager);
            } else {
                a(viewParent.getParent());
            }
        }
    }

    public final void b(@Nullable AttributeSet attributeSet) {
        if (getId() == -1) {
            setId(IdUtils.generateViewId());
        }
        IndicatorManager indicatorManager = new IndicatorManager(this);
        this.a = indicatorManager;
        indicatorManager.drawer().initAttributes(getContext(), attributeSet);
        Indicator indicator = this.a.indicator();
        indicator.setPaddingLeft(getPaddingLeft());
        indicator.setPaddingTop(getPaddingTop());
        indicator.setPaddingRight(getPaddingRight());
        indicator.setPaddingBottom(getPaddingBottom());
        this.d = indicator.isInteractiveAnimation();
        if (this.a.indicator().isFadeOnIdle()) {
            f();
        }
    }

    public final boolean c() {
        int ordinal = this.a.indicator().getRtlMode().ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 2 && TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1) {
            return true;
        }
        return false;
    }

    public void clearSelection() {
        Indicator indicator = this.a.indicator();
        indicator.setInteractiveAnimation(false);
        indicator.setLastSelectedPosition(-1);
        indicator.setSelectingPosition(-1);
        indicator.setSelectedPosition(-1);
        this.a.animate().basic();
    }

    public final boolean d() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    public final void e() {
        ViewPager viewPager;
        if (this.b == null && (viewPager = this.c) != null && viewPager.getAdapter() != null) {
            this.b = new a();
            try {
                this.c.getAdapter().registerDataSetObserver(this.b);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f() {
        Handler handler = f;
        handler.removeCallbacks(this.e);
        handler.postDelayed(this.e, this.a.indicator().getIdleDuration());
    }

    public final void g() {
        f.removeCallbacks(this.e);
        animate().cancel();
        animate().alpha(1.0f).setDuration(250);
    }

    public long getAnimationDuration() {
        return this.a.indicator().getAnimationDuration();
    }

    public int getCount() {
        return this.a.indicator().getCount();
    }

    public int getPadding() {
        return this.a.indicator().getPadding();
    }

    public int getRadius() {
        return this.a.indicator().getRadius();
    }

    public float getScaleFactor() {
        return this.a.indicator().getScaleFactor();
    }

    public int getSelectedColor() {
        return this.a.indicator().getSelectedColor();
    }

    public int getSelection() {
        return this.a.indicator().getSelectedPosition();
    }

    public int getStrokeWidth() {
        return this.a.indicator().getStroke();
    }

    public int getUnselectedColor() {
        return this.a.indicator().getUnselectedColor();
    }

    public final void h() {
        ViewPager viewPager;
        if (this.b != null && (viewPager = this.c) != null && viewPager.getAdapter() != null) {
            try {
                this.c.getAdapter().unregisterDataSetObserver(this.b);
                this.b = null;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void i() {
        ViewPager viewPager = this.c;
        if (viewPager != null && viewPager.getAdapter() != null) {
            int count = this.c.getAdapter().getCount();
            int currentItem = c() ? (count - 1) - this.c.getCurrentItem() : this.c.getCurrentItem();
            this.a.indicator().setSelectedPosition(currentItem);
            this.a.indicator().setSelectingPosition(currentItem);
            this.a.indicator().setLastSelectedPosition(currentItem);
            this.a.indicator().setCount(count);
            this.a.animate().end();
            j();
            requestLayout();
        }
    }

    public final void j() {
        if (this.a.indicator().isAutoVisibility()) {
            int count = this.a.indicator().getCount();
            int visibility = getVisibility();
            if (visibility != 0 && count > 1) {
                setVisibility(0);
            } else if (visibility != 4 && count <= 1) {
                setVisibility(4);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
        DataSetObserver dataSetObserver;
        if (this.a.indicator().isDynamicCount()) {
            if (!(pagerAdapter == null || (dataSetObserver = this.b) == null)) {
                pagerAdapter.unregisterDataSetObserver(dataSetObserver);
                this.b = null;
            }
            e();
        }
        i();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(getParent());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        h();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.a.drawer().draw(canvas);
    }

    @Override // com.rd.IndicatorManager.a
    public void onIndicatorUpdated() {
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Pair<Integer, Integer> measureViewSize = this.a.drawer().measureViewSize(i, i2);
        setMeasuredDimension(((Integer) measureViewSize.first).intValue(), ((Integer) measureViewSize.second).intValue());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.a.indicator().setInteractiveAnimation(this.d);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Indicator indicator = this.a.indicator();
        if (d() && indicator.isInteractiveAnimation() && indicator.getAnimationType() != AnimationType.NONE) {
            Pair<Integer, Float> progress = CoordinatesUtils.getProgress(indicator, i, f2, c());
            setProgress(((Integer) progress.first).intValue(), ((Float) progress.second).floatValue());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Indicator indicator = this.a.indicator();
        boolean d2 = d();
        int count = indicator.getCount();
        if (d2) {
            if (c()) {
                i = (count - 1) - i;
            }
            setSelection(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof PositionSavedState) {
            Indicator indicator = this.a.indicator();
            PositionSavedState positionSavedState = (PositionSavedState) parcelable;
            indicator.setSelectedPosition(positionSavedState.getSelectedPosition());
            indicator.setSelectingPosition(positionSavedState.getSelectingPosition());
            indicator.setLastSelectedPosition(positionSavedState.getLastSelectedPosition());
            super.onRestoreInstanceState(positionSavedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Indicator indicator = this.a.indicator();
        PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.setSelectedPosition(indicator.getSelectedPosition());
        positionSavedState.setSelectingPosition(indicator.getSelectingPosition());
        positionSavedState.setLastSelectedPosition(indicator.getLastSelectedPosition());
        return positionSavedState;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.a.indicator().isFadeOnIdle()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            g();
        } else if (action == 1) {
            f();
        }
        return false;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.drawer().touch(motionEvent);
        return true;
    }

    public void releaseViewPager() {
        ViewPager viewPager = this.c;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
            this.c.removeOnAdapterChangeListener(this);
            this.c = null;
        }
    }

    public void setAnimationDuration(long j) {
        this.a.indicator().setAnimationDuration(j);
    }

    public void setAnimationType(@Nullable AnimationType animationType) {
        this.a.onValueUpdated(null);
        if (animationType != null) {
            this.a.indicator().setAnimationType(animationType);
        } else {
            this.a.indicator().setAnimationType(AnimationType.NONE);
        }
        invalidate();
    }

    public void setAutoVisibility(boolean z) {
        if (!z) {
            setVisibility(0);
        }
        this.a.indicator().setAutoVisibility(z);
        j();
    }

    public void setClickListener(@Nullable DrawController.ClickListener clickListener) {
        this.a.drawer().setClickListener(clickListener);
    }

    public void setCount(int i) {
        if (i >= 0 && this.a.indicator().getCount() != i) {
            this.a.indicator().setCount(i);
            j();
            requestLayout();
        }
    }

    public void setDynamicCount(boolean z) {
        this.a.indicator().setDynamicCount(z);
        if (z) {
            e();
        } else {
            h();
        }
    }

    public void setFadeOnIdle(boolean z) {
        this.a.indicator().setFadeOnIdle(z);
        if (z) {
            f();
        } else {
            g();
        }
    }

    public void setIdleDuration(long j) {
        this.a.indicator().setIdleDuration(j);
        if (this.a.indicator().isFadeOnIdle()) {
            f();
        } else {
            g();
        }
    }

    public void setInteractiveAnimation(boolean z) {
        this.a.indicator().setInteractiveAnimation(z);
        this.d = z;
    }

    public void setOrientation(@Nullable Orientation orientation) {
        if (orientation != null) {
            this.a.indicator().setOrientation(orientation);
            requestLayout();
        }
    }

    public void setPadding(int i) {
        if (i < 0) {
            i = 0;
        }
        this.a.indicator().setPadding(DensityUtils.dpToPx(i));
        invalidate();
    }

    public void setProgress(int i, float f2) {
        Indicator indicator = this.a.indicator();
        if (indicator.isInteractiveAnimation()) {
            int count = indicator.getCount();
            if (count <= 0 || i < 0) {
                i = 0;
            } else {
                int i2 = count - 1;
                if (i > i2) {
                    i = i2;
                }
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 == 1.0f) {
                indicator.setLastSelectedPosition(indicator.getSelectedPosition());
                indicator.setSelectedPosition(i);
            }
            indicator.setSelectingPosition(i);
            this.a.animate().interactive(f2);
        }
    }

    public void setRadius(int i) {
        if (i < 0) {
            i = 0;
        }
        this.a.indicator().setRadius(DensityUtils.dpToPx(i));
        invalidate();
    }

    public void setRtlMode(@Nullable RtlMode rtlMode) {
        Indicator indicator = this.a.indicator();
        if (rtlMode == null) {
            indicator.setRtlMode(RtlMode.Off);
        } else {
            indicator.setRtlMode(rtlMode);
        }
        if (this.c != null) {
            int selectedPosition = indicator.getSelectedPosition();
            if (c()) {
                selectedPosition = (indicator.getCount() - 1) - selectedPosition;
            } else {
                ViewPager viewPager = this.c;
                if (viewPager != null) {
                    selectedPosition = viewPager.getCurrentItem();
                }
            }
            indicator.setLastSelectedPosition(selectedPosition);
            indicator.setSelectingPosition(selectedPosition);
            indicator.setSelectedPosition(selectedPosition);
            invalidate();
        }
    }

    public void setScaleFactor(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.3f) {
            f2 = 0.3f;
        }
        this.a.indicator().setScaleFactor(f2);
    }

    public void setSelected(int i) {
        Indicator indicator = this.a.indicator();
        AnimationType animationType = indicator.getAnimationType();
        indicator.setAnimationType(AnimationType.NONE);
        setSelection(i);
        indicator.setAnimationType(animationType);
    }

    public void setSelectedColor(int i) {
        this.a.indicator().setSelectedColor(i);
        invalidate();
    }

    public void setSelection(int i) {
        Indicator indicator = this.a.indicator();
        int count = this.a.indicator().getCount() - 1;
        if (i < 0) {
            i = 0;
        } else if (i > count) {
            i = count;
        }
        if (i != indicator.getSelectedPosition() && i != indicator.getSelectingPosition()) {
            indicator.setInteractiveAnimation(false);
            indicator.setLastSelectedPosition(indicator.getSelectedPosition());
            indicator.setSelectingPosition(i);
            indicator.setSelectedPosition(i);
            this.a.animate().basic();
        }
    }

    public void setStrokeWidth(float f2) {
        int radius = this.a.indicator().getRadius();
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else {
            float f3 = (float) radius;
            if (f2 > f3) {
                f2 = f3;
            }
        }
        this.a.indicator().setStroke((int) f2);
        invalidate();
    }

    public void setUnselectedColor(int i) {
        this.a.indicator().setUnselectedColor(i);
        invalidate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setViewPager(@Nullable ViewPager viewPager) {
        releaseViewPager();
        if (viewPager != null) {
            this.c = viewPager;
            viewPager.addOnPageChangeListener(this);
            this.c.addOnAdapterChangeListener(this);
            this.c.setOnTouchListener(this);
            this.a.indicator().setViewPagerId(this.c.getId());
            setDynamicCount(this.a.indicator().isDynamicCount());
            i();
        }
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public void setPadding(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.a.indicator().setPadding((int) f2);
        invalidate();
    }

    public void setRadius(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.a.indicator().setRadius((int) f2);
        invalidate();
    }

    public void setStrokeWidth(int i) {
        int dpToPx = DensityUtils.dpToPx(i);
        int radius = this.a.indicator().getRadius();
        if (dpToPx < 0) {
            dpToPx = 0;
        } else if (dpToPx > radius) {
            dpToPx = radius;
        }
        this.a.indicator().setStroke(dpToPx);
        invalidate();
    }

    public PageIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
    }

    @TargetApi(21)
    public PageIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b(attributeSet);
    }
}
