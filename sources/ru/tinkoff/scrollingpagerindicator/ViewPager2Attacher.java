package ru.tinkoff.scrollingpagerindicator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
public class ViewPager2Attacher extends AbstractViewPagerAttacher<ViewPager2> {
    public RecyclerView.AdapterDataObserver a;
    public RecyclerView.Adapter b;
    public ViewPager2.OnPageChangeCallback c;
    public ViewPager2 d;

    public class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ ScrollingPagerIndicator a;

        public a(ViewPager2Attacher viewPager2Attacher, ScrollingPagerIndicator scrollingPagerIndicator) {
            this.a = scrollingPagerIndicator;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.reattach();
        }
    }

    public class b extends ViewPager2.OnPageChangeCallback {
        public boolean a = true;
        public final /* synthetic */ ScrollingPagerIndicator b;

        public b(ScrollingPagerIndicator scrollingPagerIndicator) {
            this.b = scrollingPagerIndicator;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            this.a = i == 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            ViewPager2Attacher.this.updateIndicatorOnPagerScrolled(this.b, i, f);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            if (this.a) {
                ViewPager2Attacher viewPager2Attacher = ViewPager2Attacher.this;
                ScrollingPagerIndicator scrollingPagerIndicator = this.b;
                scrollingPagerIndicator.setDotCount(viewPager2Attacher.b.getItemCount());
                scrollingPagerIndicator.setCurrentPosition(viewPager2Attacher.d.getCurrentItem());
            }
        }
    }

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public void detachFromPager() {
        this.b.unregisterAdapterDataObserver(this.a);
        this.d.unregisterOnPageChangeCallback(this.c);
    }

    public void attachToPager(@NonNull ScrollingPagerIndicator scrollingPagerIndicator, @NonNull ViewPager2 viewPager2) {
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        this.b = adapter;
        if (adapter != null) {
            this.d = viewPager2;
            scrollingPagerIndicator.setDotCount(adapter.getItemCount());
            scrollingPagerIndicator.setCurrentPosition(this.d.getCurrentItem());
            a aVar = new a(this, scrollingPagerIndicator);
            this.a = aVar;
            this.b.registerAdapterDataObserver(aVar);
            b bVar = new b(scrollingPagerIndicator);
            this.c = bVar;
            viewPager2.registerOnPageChangeCallback(bVar);
            return;
        }
        throw new IllegalStateException("Set adapter before call attachToPager() method");
    }
}
