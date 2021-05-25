package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
public final class TabLayoutMediator {
    @NonNull
    public final TabLayout a;
    @NonNull
    public final ViewPager2 b;
    public final boolean c;
    public final boolean d;
    public final TabConfigurationStrategy e;
    @Nullable
    public RecyclerView.Adapter<?> f;
    public boolean g;
    @Nullable
    public b h;
    @Nullable
    public TabLayout.OnTabSelectedListener i;
    @Nullable
    public RecyclerView.AdapterDataObserver j;

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i);
    }

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            TabLayoutMediator.this.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            TabLayoutMediator.this.a();
        }
    }

    public static class b extends ViewPager2.OnPageChangeCallback {
        @NonNull
        public final WeakReference<TabLayout> a;
        public int b = 0;
        public int c = 0;

        public b(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z = false;
                boolean z2 = i3 != 2 || this.b == 1;
                if (!(i3 == 2 && this.b == 0)) {
                    z = true;
                }
                tabLayout.setScrollPosition(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.c;
                tabLayout.selectTab(tabLayout.getTabAt(i), i2 == 0 || (i2 == 2 && this.b == 0));
            }
        }
    }

    public static class c implements TabLayout.OnTabSelectedListener {
        public final ViewPager2 a;
        public final boolean b;

        public c(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull TabLayout.Tab tab) {
            this.a.setCurrentItem(tab.getPosition(), this.b);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, true, tabConfigurationStrategy);
    }

    public void a() {
        int min;
        this.a.removeAllTabs();
        RecyclerView.Adapter<?> adapter = this.f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.Tab newTab = this.a.newTab();
                this.e.onConfigureTab(newTab, i2);
                this.a.addTab(newTab, false);
            }
            if (itemCount > 0 && (min = Math.min(this.b.getCurrentItem(), this.a.getTabCount() - 1)) != this.a.getSelectedTabPosition()) {
                TabLayout tabLayout = this.a;
                tabLayout.selectTab(tabLayout.getTabAt(min));
            }
        }
    }

    public void attach() {
        if (!this.g) {
            RecyclerView.Adapter<?> adapter = this.b.getAdapter();
            this.f = adapter;
            if (adapter != null) {
                this.g = true;
                b bVar = new b(this.a);
                this.h = bVar;
                this.b.registerOnPageChangeCallback(bVar);
                c cVar = new c(this.b, this.d);
                this.i = cVar;
                this.a.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) cVar);
                if (this.c) {
                    a aVar = new a();
                    this.j = aVar;
                    this.f.registerAdapterDataObserver(aVar);
                }
                a();
                this.a.setScrollPosition(this.b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter;
        if (this.c && (adapter = this.f) != null) {
            adapter.unregisterAdapterDataObserver(this.j);
            this.j = null;
        }
        this.a.removeOnTabSelectedListener(this.i);
        this.b.unregisterOnPageChangeCallback(this.h);
        this.i = null;
        this.h = null;
        this.f = null;
        this.g = false;
    }

    public boolean isAttached() {
        return this.g;
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this(tabLayout, viewPager2, z, true, tabConfigurationStrategy);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, boolean z2, @NonNull TabConfigurationStrategy tabConfigurationStrategy) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.c = z;
        this.d = z2;
        this.e = tabConfigurationStrategy;
    }
}
