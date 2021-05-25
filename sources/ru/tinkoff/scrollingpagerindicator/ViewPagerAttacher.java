package ru.tinkoff.scrollingpagerindicator;

import android.database.DataSetObserver;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
public class ViewPagerAttacher extends AbstractViewPagerAttacher<ViewPager> {
    public DataSetObserver a;
    public ViewPager.OnPageChangeListener b;
    public ViewPager c;
    public PagerAdapter d;

    public class a extends DataSetObserver {
        public final /* synthetic */ ScrollingPagerIndicator a;

        public a(ViewPagerAttacher viewPagerAttacher, ScrollingPagerIndicator scrollingPagerIndicator) {
            this.a = scrollingPagerIndicator;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.a.reattach();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.reattach();
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public boolean a = true;
        public final /* synthetic */ ScrollingPagerIndicator b;

        public b(ScrollingPagerIndicator scrollingPagerIndicator) {
            this.b = scrollingPagerIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.a = i == 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            ViewPagerAttacher.this.updateIndicatorOnPagerScrolled(this.b, i, f);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.a) {
                ViewPagerAttacher viewPagerAttacher = ViewPagerAttacher.this;
                ScrollingPagerIndicator scrollingPagerIndicator = this.b;
                scrollingPagerIndicator.setDotCount(viewPagerAttacher.d.getCount());
                scrollingPagerIndicator.setCurrentPosition(viewPagerAttacher.c.getCurrentItem());
            }
        }
    }

    @Override // ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator.PagerAttacher
    public void detachFromPager() {
        this.d.unregisterDataSetObserver(this.a);
        this.c.removeOnPageChangeListener(this.b);
    }

    public void attachToPager(@NonNull ScrollingPagerIndicator scrollingPagerIndicator, @NonNull ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        this.d = adapter;
        if (adapter != null) {
            this.c = viewPager;
            scrollingPagerIndicator.setDotCount(adapter.getCount());
            scrollingPagerIndicator.setCurrentPosition(this.c.getCurrentItem());
            a aVar = new a(this, scrollingPagerIndicator);
            this.a = aVar;
            this.d.registerDataSetObserver(aVar);
            b bVar = new b(scrollingPagerIndicator);
            this.b = bVar;
            viewPager.addOnPageChangeListener(bVar);
            return;
        }
        throw new IllegalStateException("Set adapter before call attachToPager() method");
    }
}
