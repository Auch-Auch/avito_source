package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.AdvertListLink;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.search.map.view.PanelStateKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JG\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/GroupingIntentFactory;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "", "context", PanelStateKt.PANEL_EXPANDED, "sellerId", "Landroid/content/Intent;", "expandedItemsListIntent", "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/AdvertListLink;", "link", "advertItemListIntent", "(Lcom/avito/android/deep_linking/links/AdvertListLink;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface GroupingIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent expandedItemsListIntent$default(GroupingIntentFactory groupingIntentFactory, SearchParams searchParams, Area area, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                return groupingIntentFactory.expandedItemsListIntent(searchParams, (i & 2) != 0 ? null : area, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandedItemsListIntent");
        }
    }

    @NotNull
    Intent advertItemListIntent(@NotNull AdvertListLink advertListLink);

    @NotNull
    Intent expandedItemsListIntent(@NotNull SearchParams searchParams, @Nullable Area area, @Nullable String str, @Nullable String str2, @Nullable String str3);
}
