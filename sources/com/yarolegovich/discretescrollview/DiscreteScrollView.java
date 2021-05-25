package com.yarolegovich.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager;
import com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.yarolegovich.discretescrollview.util.ScrollListenerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class DiscreteScrollView extends RecyclerView {
    public static final int NO_POSITION = -1;
    public DiscreteScrollLayoutManager E0;
    public List<ScrollStateChangeListener> F0;
    public List<OnItemChangedListener> G0;
    public boolean H0;

    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
        void onCurrentItemChanged(@Nullable T t, int i);
    }

    public interface ScrollListener<T extends RecyclerView.ViewHolder> {
        void onScroll(float f, int i, int i2, @Nullable T t, @Nullable T t2);
    }

    public interface ScrollStateChangeListener<T extends RecyclerView.ViewHolder> {
        void onScroll(float f, int i, int i2, @Nullable T t, @Nullable T t2);

        void onScrollEnd(@NonNull T t, int i);

        void onScrollStart(@NonNull T t, int i);
    }

    public class b implements DiscreteScrollLayoutManager.ScrollStateListener {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DiscreteScrollView.b0(DiscreteScrollView.this);
            }
        }

        public b(a aVar) {
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onCurrentViewFirstLayout() {
            DiscreteScrollView.this.post(new a());
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onDataSetChangeChangedPosition() {
            DiscreteScrollView.b0(DiscreteScrollView.this);
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onIsBoundReachedFlagChange(boolean z) {
            DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
            if (discreteScrollView.H0) {
                discreteScrollView.setOverScrollMode(z ? 0 : 2);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:17:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onScroll(float r12) {
            /*
                r11 = this;
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                java.util.List<com.yarolegovich.discretescrollview.DiscreteScrollView$ScrollStateChangeListener> r0 = r0.F0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                com.yarolegovich.discretescrollview.DiscreteScrollView r0 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                int r0 = r0.getCurrentItem()
                com.yarolegovich.discretescrollview.DiscreteScrollView r1 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager r1 = r1.E0
                int r2 = r1.A
                if (r2 != 0) goto L_0x001d
                int r1 = r1.C
            L_0x001b:
                r7 = r1
                goto L_0x0031
            L_0x001d:
                int r3 = r1.D
                r4 = -1
                if (r3 == r4) goto L_0x0024
                r7 = r3
                goto L_0x0031
            L_0x0024:
                int r1 = r1.C
                a2.v.a.a r2 = a2.v.a.a.b(r2)
                r3 = 1
                int r2 = r2.a(r3)
                int r1 = r1 + r2
                goto L_0x001b
            L_0x0031:
                if (r0 == r7) goto L_0x005a
                com.yarolegovich.discretescrollview.DiscreteScrollView r1 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r8 = r1.getViewHolder(r0)
                com.yarolegovich.discretescrollview.DiscreteScrollView r2 = com.yarolegovich.discretescrollview.DiscreteScrollView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r2.getViewHolder(r7)
                java.util.List<com.yarolegovich.discretescrollview.DiscreteScrollView$ScrollStateChangeListener> r1 = r1.F0
                java.util.Iterator r10 = r1.iterator()
            L_0x0045:
                boolean r1 = r10.hasNext()
                if (r1 == 0) goto L_0x005a
                java.lang.Object r1 = r10.next()
                com.yarolegovich.discretescrollview.DiscreteScrollView$ScrollStateChangeListener r1 = (com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollStateChangeListener) r1
                r2 = r12
                r3 = r0
                r4 = r7
                r5 = r8
                r6 = r9
                r1.onScroll(r2, r3, r4, r5, r6)
                goto L_0x0045
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollView.b.onScroll(float):void");
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onScrollEnd() {
            if (!DiscreteScrollView.this.G0.isEmpty() || !DiscreteScrollView.this.F0.isEmpty()) {
                DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
                int i = discreteScrollView.E0.C;
                RecyclerView.ViewHolder viewHolder = discreteScrollView.getViewHolder(i);
                if (viewHolder != null) {
                    for (ScrollStateChangeListener scrollStateChangeListener : DiscreteScrollView.this.F0) {
                        scrollStateChangeListener.onScrollEnd(viewHolder, i);
                    }
                    DiscreteScrollView.this.d0(viewHolder, i);
                }
            }
        }

        @Override // com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager.ScrollStateListener
        public void onScrollStart() {
            if (!DiscreteScrollView.this.F0.isEmpty()) {
                DiscreteScrollView discreteScrollView = DiscreteScrollView.this;
                int i = discreteScrollView.E0.C;
                RecyclerView.ViewHolder viewHolder = discreteScrollView.getViewHolder(i);
                if (viewHolder != null) {
                    for (ScrollStateChangeListener scrollStateChangeListener : DiscreteScrollView.this.F0) {
                        scrollStateChangeListener.onScrollStart(viewHolder, i);
                    }
                }
            }
        }
    }

    public DiscreteScrollView(Context context) {
        super(context);
        c0(null);
    }

    public static void b0(DiscreteScrollView discreteScrollView) {
        if (!discreteScrollView.G0.isEmpty()) {
            int i = discreteScrollView.E0.C;
            discreteScrollView.d0(discreteScrollView.getViewHolder(i), i);
        }
    }

    public void addOnItemChangedListener(@NonNull OnItemChangedListener<?> onItemChangedListener) {
        this.G0.add(onItemChangedListener);
    }

    public void addScrollListener(@NonNull ScrollListener<?> scrollListener) {
        addScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void addScrollStateChangeListener(@NonNull ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.F0.add(scrollStateChangeListener);
    }

    public final void c0(AttributeSet attributeSet) {
        int i;
        this.F0 = new ArrayList();
        this.G0 = new ArrayList();
        boolean z = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DiscreteScrollView);
            i = obtainStyledAttributes.getInt(R.styleable.DiscreteScrollView_dsv_orientation, 0);
            obtainStyledAttributes.recycle();
        } else {
            i = 0;
        }
        if (getOverScrollMode() != 2) {
            z = true;
        }
        this.H0 = z;
        DiscreteScrollLayoutManager discreteScrollLayoutManager = new DiscreteScrollLayoutManager(getContext(), new b(null), DSVOrientation.values()[i]);
        this.E0 = discreteScrollLayoutManager;
        setLayoutManager(discreteScrollLayoutManager);
    }

    public final void d0(RecyclerView.ViewHolder viewHolder, int i) {
        for (OnItemChangedListener onItemChangedListener : this.G0) {
            onItemChangedListener.onCurrentItemChanged(viewHolder, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        if ((r9 >= 0 && r9 < r1.S.getItemCount()) != false) goto L_0x005a;
     */
    @Override // androidx.recyclerview.widget.RecyclerView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            boolean r0 = super.fling(r8, r9)
            if (r0 == 0) goto L_0x006b
            com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager r1 = r7.E0
            com.yarolegovich.discretescrollview.DSVOrientation$c r2 = r1.F
            int r8 = r2.getFlingVelocity(r8, r9)
            boolean r9 = r1.N
            r2 = 1
            if (r9 == 0) goto L_0x001c
            int r9 = r1.M
            int r9 = r8 / r9
            int r9 = java.lang.Math.abs(r9)
            goto L_0x001d
        L_0x001c:
            r9 = 1
        L_0x001d:
            int r3 = r1.C
            a2.v.a.a r4 = a2.v.a.a.b(r8)
            int r9 = r4.a(r9)
            int r9 = r9 + r3
            com.yarolegovich.discretescrollview.RecyclerViewProxy r3 = r1.S
            int r3 = r3.getItemCount()
            int r4 = r1.C
            r5 = 0
            if (r4 == 0) goto L_0x0037
            if (r9 >= 0) goto L_0x0037
            r9 = 0
            goto L_0x003e
        L_0x0037:
            int r6 = r3 + -1
            if (r4 == r6) goto L_0x003e
            if (r9 < r3) goto L_0x003e
            r9 = r6
        L_0x003e:
            int r3 = r1.A
            int r8 = r8 * r3
            if (r8 < 0) goto L_0x0046
            r8 = 1
            goto L_0x0047
        L_0x0046:
            r8 = 0
        L_0x0047:
            if (r8 == 0) goto L_0x0059
            if (r9 < 0) goto L_0x0055
            com.yarolegovich.discretescrollview.RecyclerViewProxy r8 = r1.S
            int r8 = r8.getItemCount()
            if (r9 >= r8) goto L_0x0055
            r8 = 1
            goto L_0x0056
        L_0x0055:
            r8 = 0
        L_0x0056:
            if (r8 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r2 = 0
        L_0x005a:
            if (r2 == 0) goto L_0x0060
            r1.z(r9)
            goto L_0x0077
        L_0x0060:
            int r8 = r1.A
            int r8 = -r8
            r1.B = r8
            if (r8 == 0) goto L_0x0077
            r1.y()
            goto L_0x0077
        L_0x006b:
            com.yarolegovich.discretescrollview.DiscreteScrollLayoutManager r8 = r7.E0
            int r9 = r8.A
            int r9 = -r9
            r8.B = r9
            if (r9 == 0) goto L_0x0077
            r8.y()
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yarolegovich.discretescrollview.DiscreteScrollView.fling(int, int):boolean");
    }

    public int getCurrentItem() {
        return this.E0.C;
    }

    @Nullable
    public RecyclerView.ViewHolder getViewHolder(int i) {
        View findViewByPosition = this.E0.findViewByPosition(i);
        if (findViewByPosition != null) {
            return getChildViewHolder(findViewByPosition);
        }
        return null;
    }

    public void removeItemChangedListener(@NonNull OnItemChangedListener<?> onItemChangedListener) {
        this.G0.remove(onItemChangedListener);
    }

    public void removeScrollListener(@NonNull ScrollListener<?> scrollListener) {
        removeScrollStateChangeListener(new ScrollListenerAdapter(scrollListener));
    }

    public void removeScrollStateChangeListener(@NonNull ScrollStateChangeListener<?> scrollStateChangeListener) {
        this.F0.remove(scrollStateChangeListener);
    }

    public void setClampTransformProgressAfter(@IntRange(from = 1) int i) {
        if (i > 1) {
            DiscreteScrollLayoutManager discreteScrollLayoutManager = this.E0;
            discreteScrollLayoutManager.K = i;
            discreteScrollLayoutManager.n();
            return;
        }
        throw new IllegalArgumentException("must be >= 1");
    }

    public void setItemTransformer(DiscreteScrollItemTransformer discreteScrollItemTransformer) {
        this.E0.R = discreteScrollItemTransformer;
    }

    public void setItemTransitionTimeMillis(@IntRange(from = 10) int i) {
        this.E0.I = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof DiscreteScrollLayoutManager) {
            super.setLayoutManager(layoutManager);
            return;
        }
        throw new IllegalArgumentException(getContext().getString(R.string.dsv_ex_msg_dont_set_lm));
    }

    public void setOffscreenItems(int i) {
        DiscreteScrollLayoutManager discreteScrollLayoutManager = this.E0;
        discreteScrollLayoutManager.J = i;
        discreteScrollLayoutManager.x = discreteScrollLayoutManager.y * i;
        discreteScrollLayoutManager.S.requestLayout();
    }

    public void setOrientation(DSVOrientation dSVOrientation) {
        DiscreteScrollLayoutManager discreteScrollLayoutManager = this.E0;
        Objects.requireNonNull(discreteScrollLayoutManager);
        discreteScrollLayoutManager.F = dSVOrientation.a();
        discreteScrollLayoutManager.S.removeAllViews();
        discreteScrollLayoutManager.S.requestLayout();
    }

    public void setOverScrollEnabled(boolean z) {
        this.H0 = z;
        setOverScrollMode(2);
    }

    public void setSlideOnFling(boolean z) {
        this.E0.N = z;
    }

    public void setSlideOnFlingThreshold(int i) {
        this.E0.M = i;
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c0(attributeSet);
    }

    public DiscreteScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c0(attributeSet);
    }
}
