package com.avito.android.brandspace.items.categories;

import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/categories/CategoriesPresenterImpl;", "Lcom/avito/android/brandspace/items/categories/CategoriesPresenter;", "Lcom/avito/android/brandspace/items/categories/CategoriesItemView;", "view", "Lcom/avito/android/brandspace/items/categories/CategoriesItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/categories/CategoriesItemView;Lcom/avito/android/brandspace/items/categories/CategoriesItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesPresenterImpl implements CategoriesPresenter {
    public final BrandspacePresenter a;

    @Inject
    public CategoriesPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        this.a = brandspacePresenter;
    }

    public void bindView(@NotNull CategoriesItemView categoriesItemView, @NotNull CategoriesItem categoriesItem, int i) {
        Intrinsics.checkNotNullParameter(categoriesItemView, "view");
        Intrinsics.checkNotNullParameter(categoriesItem, "item");
        categoriesItemView.bind(categoriesItem.getCategories(), categoriesItem.getSelectedCategoryIndex(), new TabLayout.OnTabSelectedListener(this, categoriesItem) { // from class: com.avito.android.brandspace.items.categories.CategoriesPresenterImpl$bindView$1
            public final /* synthetic */ CategoriesPresenterImpl a;
            public final /* synthetic */ CategoriesItem b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                this.a.a.onCategoriesClicked(tab.getPosition(), this.b);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }
        });
    }
}
