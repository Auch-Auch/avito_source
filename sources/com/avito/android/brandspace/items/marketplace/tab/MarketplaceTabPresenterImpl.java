package com.avito.android.brandspace.items.marketplace.tab;

import com.avito.android.brandspace.items.categories.CategoriesItemView;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabPresenter;", "Lcom/avito/android/brandspace/items/categories/CategoriesItemView;", "view", "Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/categories/CategoriesItemView;Lcom/avito/android/brandspace/items/marketplace/tab/MarketplaceTabsItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceTabPresenterImpl implements MarketplaceTabPresenter {
    public final BrandspacePresenter a;

    @Inject
    public MarketplaceTabPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        this.a = brandspacePresenter;
    }

    public void bindView(@NotNull CategoriesItemView categoriesItemView, @NotNull MarketplaceTabsItem marketplaceTabsItem, int i) {
        Intrinsics.checkNotNullParameter(categoriesItemView, "view");
        Intrinsics.checkNotNullParameter(marketplaceTabsItem, "item");
        List<String> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) marketplaceTabsItem.getTabs().keySet());
        Integer valueOf = Integer.valueOf(mutableList.indexOf(marketplaceTabsItem.getSelectedTab()));
        int i2 = 0;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        categoriesItemView.bind(mutableList, i2, new SimpleOnTabSelectedListener(this, marketplaceTabsItem) { // from class: com.avito.android.brandspace.items.marketplace.tab.MarketplaceTabPresenterImpl$bindView$1
            public final /* synthetic */ MarketplaceTabPresenterImpl a;
            public final /* synthetic */ MarketplaceTabsItem b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(@NotNull TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                this.a.a.onTabCategoriesClicked(tab.getPosition(), this.b);
            }
        });
    }
}
