package ru.tinkoff.scrollingpagerindicator;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
public class RecyclerViewAttacher implements ScrollingPagerIndicator.PagerAttacher<RecyclerView> {
    public ScrollingPagerIndicator a;
    public RecyclerView b;
    public LinearLayoutManager c;
    public RecyclerView.Adapter<?> d;
    public RecyclerView.OnScrollListener e;
    public RecyclerView.AdapterDataObserver f;
    public final boolean g;
    public final int h;
    public int i;
    public int j;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ ScrollingPagerIndicator a;

        public a(ScrollingPagerIndicator scrollingPagerIndicator) {
            this.a = scrollingPagerIndicator;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.setDotCount(RecyclerViewAttacher.this.d.getItemCount());
            RecyclerViewAttacher.this.f();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public final /* synthetic */ ScrollingPagerIndicator a;

        public b(ScrollingPagerIndicator scrollingPagerIndicator) {
            this.a = scrollingPagerIndicator;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            int a3;
            if (i == 0) {
                if ((RecyclerViewAttacher.this.a() != -1) && (a3 = RecyclerViewAttacher.this.a()) != -1) {
                    this.a.setDotCount(RecyclerViewAttacher.this.d.getItemCount());
                    if (a3 < RecyclerViewAttacher.this.d.getItemCount()) {
                        this.a.setCurrentPosition(a3);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            RecyclerViewAttacher.this.f();
        }
    }

    public RecyclerViewAttacher() {
        this.h = 0;
        this.g = true;
    }

    public final int a() {
        float f2;
        float f3;
        RecyclerView.ViewHolder findContainingViewHolder;
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            float x = childAt.getX();
            int measuredWidth = childAt.getMeasuredWidth();
            float e2 = e();
            if (this.g) {
                f3 = (((float) this.b.getMeasuredWidth()) - c()) / 2.0f;
                f2 = c();
            } else {
                f3 = (float) this.h;
                f2 = c();
            }
            float f4 = f2 + f3;
            if (this.c.getOrientation() == 1) {
                x = childAt.getY();
                measuredWidth = childAt.getMeasuredHeight();
                if (this.g) {
                    e2 = (((float) this.b.getMeasuredHeight()) - b()) / 2.0f;
                } else {
                    e2 = (float) this.h;
                }
                f4 = d();
            }
            if (x >= e2 && x + ((float) measuredWidth) <= f4 && (findContainingViewHolder = this.b.findContainingViewHolder(childAt)) != null && findContainingViewHolder.getAdapterPosition() != -1) {
                return findContainingViewHolder.getAdapterPosition();
            }
        }
        return -1;
    }

    public final float b() {
        int i2;
        if (this.j == 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.b.getChildCount()) {
                    break;
                }
                View childAt = this.b.getChildAt(i3);
                if (childAt.getMeasuredHeight() != 0) {
                    i2 = childAt.getMeasuredHeight();
                    this.j = i2;
                    break;
                }
                i3++;
            }
        }
        i2 = this.j;
        return (float) i2;
    }

    public final float c() {
        int i2;
        if (this.i == 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.b.getChildCount()) {
                    break;
                }
                View childAt = this.b.getChildAt(i3);
                if (childAt.getMeasuredWidth() != 0) {
                    i2 = childAt.getMeasuredWidth();
                    this.i = i2;
                    break;
                }
                i3++;
            }
        }
        i2 = this.i;
        return (float) i2;
    }

    public final float d() {
        float f2;
        float b2;
        if (this.g) {
            f2 = (((float) this.b.getMeasuredHeight()) - b()) / 2.0f;
            b2 = b();
        } else {
            f2 = (float) this.h;
            b2 = b();
        }
        return b2 + f2;
    }

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public void detachFromPager() {
        this.d.unregisterAdapterDataObserver(this.f);
        this.b.removeOnScrollListener(this.e);
        this.i = 0;
    }

    public final float e() {
        if (this.g) {
            return (((float) this.b.getMeasuredWidth()) - c()) / 2.0f;
        }
        return (float) this.h;
    }

    public final void f() {
        int childAdapterPosition;
        float f2;
        int i2;
        int i3;
        int childCount = this.c.getChildCount();
        View view = null;
        if (childCount != 0) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.c.getChildAt(i5);
                if (this.c.getOrientation() == 0) {
                    i3 = (int) childAt.getX();
                    if (childAt.getMeasuredWidth() + i3 < i4) {
                        if (((float) (childAt.getMeasuredWidth() + i3)) < e()) {
                        }
                    }
                } else {
                    i3 = (int) childAt.getY();
                    if (childAt.getMeasuredHeight() + i3 < i4) {
                        if (((float) (childAt.getMeasuredHeight() + i3)) < d()) {
                        }
                    }
                }
                view = childAt;
                i4 = i3;
            }
        }
        if (!(view == null || (childAdapterPosition = this.b.getChildAdapterPosition(view)) == -1)) {
            int itemCount = this.d.getItemCount();
            if (childAdapterPosition >= itemCount && itemCount != 0) {
                childAdapterPosition %= itemCount;
            }
            if (this.c.getOrientation() == 0) {
                f2 = e() - view.getX();
                i2 = view.getMeasuredWidth();
            } else {
                f2 = d() - view.getY();
                i2 = view.getMeasuredHeight();
            }
            float f3 = f2 / ((float) i2);
            if (f3 >= 0.0f && f3 <= 1.0f && childAdapterPosition < itemCount) {
                this.a.onPageScrolled(childAdapterPosition, f3);
            }
        }
    }

    public void attachToPager(@NonNull ScrollingPagerIndicator scrollingPagerIndicator, @NonNull RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new IllegalStateException("Only LinearLayoutManager is supported");
        } else if (recyclerView.getAdapter() != null) {
            this.c = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.b = recyclerView;
            this.d = recyclerView.getAdapter();
            this.a = scrollingPagerIndicator;
            a aVar = new a(scrollingPagerIndicator);
            this.f = aVar;
            this.d.registerAdapterDataObserver(aVar);
            scrollingPagerIndicator.setDotCount(this.d.getItemCount());
            f();
            b bVar = new b(scrollingPagerIndicator);
            this.e = bVar;
            this.b.addOnScrollListener(bVar);
        } else {
            throw new IllegalStateException("RecyclerView has not Adapter attached");
        }
    }

    public RecyclerViewAttacher(int i2) {
        this.h = i2;
        this.g = false;
    }
}
