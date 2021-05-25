package l6.c0.a;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
public class c extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ FragmentStateAdapter.c a;

    public c(FragmentStateAdapter.c cVar) {
        this.a = cVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        this.a.b(false);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        this.a.b(false);
    }
}
