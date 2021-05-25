package com.avito.android.brandspace.items.categories;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/avito/android/brandspace/items/categories/CategoriesItemViewImpl$defaultTabLayoutListener$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "onTabUnselected", "onTabReselected", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesItemViewImpl$defaultTabLayoutListener$1 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ CategoriesItemViewImpl a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public CategoriesItemViewImpl$defaultTabLayoutListener$1(CategoriesItemViewImpl categoriesItemViewImpl) {
        this.a = categoriesItemViewImpl;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(@Nullable TabLayout.Tab tab) {
        TabLayout.OnTabSelectedListener access$getTabListener$p = CategoriesItemViewImpl.access$getTabListener$p(this.a);
        if (access$getTabListener$p != null) {
            access$getTabListener$p.onTabReselected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@Nullable TabLayout.Tab tab) {
        TabLayout.OnTabSelectedListener access$getTabListener$p = CategoriesItemViewImpl.access$getTabListener$p(this.a);
        if (access$getTabListener$p != null) {
            access$getTabListener$p.onTabSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        TabLayout.OnTabSelectedListener access$getTabListener$p = CategoriesItemViewImpl.access$getTabListener$p(this.a);
        if (access$getTabListener$p != null) {
            access$getTabListener$p.onTabUnselected(tab);
        }
    }
}
