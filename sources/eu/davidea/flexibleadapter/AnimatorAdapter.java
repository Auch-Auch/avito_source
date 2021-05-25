package eu.davidea.flexibleadapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import eu.davidea.flexibleadapter.utils.LayoutUtils;
import eu.davidea.flexibleadapter.utils.Logger;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
public abstract class AnimatorAdapter extends SelectableAdapter {
    public Interpolator h = new LinearInterpolator();
    public b i;
    public boolean j = true;
    public final SparseArray<Animator> k = new SparseArray<>();
    public int l = -1;
    public int m = -1;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;

    public class b extends RecyclerView.AdapterDataObserver {
        public boolean a;
        public Handler b = new Handler(Looper.getMainLooper(), new a());

        public class a implements Handler.Callback {
            public a() {
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                b.this.a = false;
                return true;
            }
        }

        public b(a aVar) {
        }

        public final void a() {
            this.a = !AnimatorAdapter.this.q;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            a();
        }
    }

    public enum c {
        ALPHA,
        SLIDE_IN_LEFT,
        SLIDE_IN_RIGHT,
        SLIDE_IN_BOTTOM,
        SLIDE_IN_TOP,
        SCALE
    }

    public class d implements Animator.AnimatorListener {
        public int a;

        public d(int i) {
            this.a = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorAdapter.this.k.remove(this.a);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public AnimatorAdapter(boolean z) {
        EnumSet.noneOf(c.class);
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = 100;
        this.t = 300;
        setHasStableIds(z);
        Logger logger = this.c;
        logger.i("Initialized with StableIds=" + z, new Object[0]);
        b bVar = new b(null);
        this.i = bVar;
        registerAdapterDataObserver(bVar);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0086: APUT  (r6v1 java.lang.Object[]), (6 ??[int, float, short, byte, char]), (r7v14 java.lang.String) */
    public final void animateView(RecyclerView.ViewHolder viewHolder, int i2) {
        String str;
        int i3;
        long j2;
        long j3;
        long j4;
        long j5;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            if (this.m < recyclerView.getChildCount()) {
                this.m = this.mRecyclerView.getChildCount();
            }
            if (this.p && this.l >= this.m) {
                this.o = false;
            }
            int findLastVisibleItemPosition = getFlexibleLayoutManager().findLastVisibleItemPosition();
            Logger logger = this.c;
            Object[] objArr = new Object[7];
            objArr[0] = Boolean.valueOf(this.o);
            objArr[1] = Boolean.valueOf(this.n);
            objArr[2] = Boolean.valueOf(this.isFastScroll);
            objArr[3] = Boolean.valueOf(this.i.a);
            objArr[4] = Integer.valueOf(this.l);
            objArr[5] = Integer.valueOf(this.m);
            if (!this.n) {
                StringBuilder L = a2.b.a.a.a.L(" Pos>LasVisPos=");
                L.append(i2 > findLastVisibleItemPosition);
                str = L.toString();
            } else {
                str = "";
            }
            objArr[6] = str;
            logger.v("isForwardEnabled=%s isReverseEnabled=%s isFastScroll=%s isNotified=%s mLastAnimatedPosition=%s mMaxChildViews=%s %s", objArr);
            if ((this.o || this.n) && !this.isFastScroll && (viewHolder instanceof FlexibleViewHolder) && !this.i.a && (isScrollableHeaderOrFooter(i2) || ((this.o && i2 > findLastVisibleItemPosition) || ((this.n && i2 < findLastVisibleItemPosition) || (i2 == 0 && this.m == 0))))) {
                int hashCode = viewHolder.itemView.hashCode();
                Animator animator = this.k.get(hashCode);
                if (animator != null) {
                    animator.end();
                }
                ArrayList arrayList = new ArrayList();
                ((FlexibleViewHolder) viewHolder).scrollAnimators(arrayList, i2, i2 >= findLastVisibleItemPosition);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(arrayList);
                animatorSet.setInterpolator(this.h);
                long j6 = this.t;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Animator animator2 = (Animator) it.next();
                    if (animator2.getDuration() != 300) {
                        j6 = animator2.getDuration();
                    }
                }
                this.c.v("duration=%s", Long.valueOf(j6));
                animatorSet.setDuration(j6);
                animatorSet.addListener(new d(hashCode));
                if (this.j) {
                    int findFirstCompletelyVisibleItemPosition = getFlexibleLayoutManager().findFirstCompletelyVisibleItemPosition();
                    int findLastCompletelyVisibleItemPosition = getFlexibleLayoutManager().findLastCompletelyVisibleItemPosition();
                    if (findFirstCompletelyVisibleItemPosition < 0 && i2 >= 0) {
                        findFirstCompletelyVisibleItemPosition = i2 - 1;
                    }
                    int i4 = i2 - 1;
                    if (i4 > findLastCompletelyVisibleItemPosition) {
                        findLastCompletelyVisibleItemPosition = i4;
                    }
                    int i5 = findLastCompletelyVisibleItemPosition - findFirstCompletelyVisibleItemPosition;
                    int i6 = this.m;
                    if (i6 == 0 || i5 < i4 || ((findFirstCompletelyVisibleItemPosition > 1 && findFirstCompletelyVisibleItemPosition <= i6) || (i2 > i6 && findFirstCompletelyVisibleItemPosition == -1 && this.mRecyclerView.getChildCount() == 0))) {
                        j2 = this.s;
                        if (i5 <= 1) {
                            j2 += this.r;
                        } else {
                            this.r = 0;
                        }
                        int spanCount = getFlexibleLayoutManager().getSpanCount();
                        if (spanCount > 1) {
                            j4 = this.r;
                            i3 = i5;
                            j5 = (long) (i2 % spanCount);
                            j3 = this.s;
                        } else {
                            i3 = i5;
                            this.c.v("Delay[%s]=%s FirstVisible=%s LastVisible=%s LastAnimated=%s VisibleItems=%s ChildCount=%s MaxChildCount=%s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(findFirstCompletelyVisibleItemPosition), Integer.valueOf(findLastCompletelyVisibleItemPosition), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.mRecyclerView.getChildCount()), Integer.valueOf(this.m));
                            animatorSet.setStartDelay(j2);
                        }
                    } else {
                        j4 = this.r;
                        j3 = (long) i2;
                        i3 = i5;
                        j5 = this.s;
                    }
                    Long.signum(j3);
                    j2 = j4 + (j3 * j5);
                    this.c.v("Delay[%s]=%s FirstVisible=%s LastVisible=%s LastAnimated=%s VisibleItems=%s ChildCount=%s MaxChildCount=%s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(findFirstCompletelyVisibleItemPosition), Integer.valueOf(findLastCompletelyVisibleItemPosition), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.mRecyclerView.getChildCount()), Integer.valueOf(this.m));
                    animatorSet.setStartDelay(j2);
                }
                animatorSet.start();
                this.k.put(hashCode, animatorSet);
                this.c.v("animateView    Scroll animation on position %s", Integer.valueOf(i2));
            }
            b bVar = this.i;
            if (bVar.a) {
                bVar.b.removeCallbacksAndMessages(null);
                Handler handler = bVar.b;
                handler.sendMessageDelayed(Message.obtain(handler), 200);
            }
            this.l = i2;
        }
    }

    public boolean isAnimationOnForwardScrollingEnabled() {
        return this.o;
    }

    public boolean isAnimationOnReverseScrollingEnabled() {
        return this.n;
    }

    @Deprecated
    public boolean isAnimationOnScrollingEnabled() {
        return this.o;
    }

    public boolean isOnlyEntryAnimation() {
        return this.p;
    }

    public abstract boolean isScrollableHeaderOrFooter(int i2);

    public AnimatorAdapter setAnimationDelay(@IntRange(from = 0) long j2) {
        this.c.i("Set animationDelay=%s", Long.valueOf(j2));
        this.s = j2;
        return this;
    }

    public AnimatorAdapter setAnimationDuration(@IntRange(from = 1) long j2) {
        this.c.i("Set animationDuration=%s", Long.valueOf(j2));
        this.t = j2;
        return this;
    }

    public AnimatorAdapter setAnimationEntryStep(boolean z) {
        this.c.i("Set animationEntryStep=%s", Boolean.valueOf(z));
        this.j = z;
        return this;
    }

    public AnimatorAdapter setAnimationInitialDelay(long j2) {
        this.c.i("Set animationInitialDelay=%s", Long.valueOf(j2));
        this.r = j2;
        return this;
    }

    public AnimatorAdapter setAnimationInterpolator(@NonNull Interpolator interpolator) {
        this.c.i("Set animationInterpolator=%s", LayoutUtils.getClassName(interpolator));
        this.h = interpolator;
        return this;
    }

    public AnimatorAdapter setAnimationOnForwardScrolling(boolean z) {
        this.c.i("Set animationOnForwardScrolling=%s", Boolean.valueOf(z));
        if (z) {
            this.p = false;
        }
        this.o = z;
        return this;
    }

    public AnimatorAdapter setAnimationOnReverseScrolling(boolean z) {
        this.c.i("Set animationOnReverseScrolling=%s", Boolean.valueOf(z));
        this.n = z;
        return this;
    }

    @Deprecated
    public AnimatorAdapter setAnimationOnScrolling(boolean z) {
        return setAnimationOnForwardScrolling(z);
    }

    public AnimatorAdapter setOnlyEntryAnimation(boolean z) {
        this.c.i("Set onlyEntryAnimation=%s", Boolean.valueOf(z));
        if (z) {
            this.o = true;
        }
        this.p = z;
        return this;
    }
}
