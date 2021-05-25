package com.avito.android.user_favorites.adapter.sellers;

import androidx.fragment.app.Fragment;
import com.avito.android.design.widget.tab.Tab;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.favorite_sellers.FavoriteSellersFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/user_favorites/adapter/sellers/SellersTabBlueprint;", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/user_favorites/adapter/sellers/SellersTab;", "item", "Landroidx/fragment/app/Fragment;", "onCreateFragment", "(Lcom/avito/android/user_favorites/adapter/sellers/SellersTab;)Landroidx/fragment/app/Fragment;", "Lcom/avito/android/design/widget/tab/Tab;", "", "isRelevantItem", "(Lcom/avito/android/design/widget/tab/Tab;)Z", "<init>", "()V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class SellersTabBlueprint implements TabBlueprint<SellersTab> {
    @Override // com.avito.android.design.widget.tab.TabBlueprint
    @Nullable
    public Fragment createFragment(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "item");
        return TabBlueprint.DefaultImpls.createFragment(this, tab);
    }

    @Override // com.avito.android.design.widget.tab.TabBlueprint
    public boolean isRelevantItem(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "item");
        return tab instanceof SellersTab;
    }

    @Nullable
    public Fragment onCreateFragment(@NotNull SellersTab sellersTab) {
        Intrinsics.checkNotNullParameter(sellersTab, "item");
        return FavoriteSellersFragmentKt.createFavoriteSellersFragmentIntent$default(true, null, null, sellersTab.getListBottomPaddingPx(), 6, null);
    }
}
