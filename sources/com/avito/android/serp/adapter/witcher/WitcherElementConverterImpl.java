package com.avito.android.serp.adapter.witcher;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherElementConverterImpl;", "Lcom/avito/android/serp/adapter/witcher/WitcherElementConverter;", "Lcom/avito/android/remote/model/WitcherElement;", "entity", "Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "convert", "(Lcom/avito/android/remote/model/WitcherElement;)Lcom/avito/android/serp/adapter/witcher/WitcherItem;", "", AuthSource.SEND_ABUSE, "I", "columnCount", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "d", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "viewedStatusResolver", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "c", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "favoriteStatusResolver", "<init>", "(ILcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/serp/adapter/FavoriteStatusResolver;Lcom/avito/android/serp/adapter/ViewedStatusResolver;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherElementConverterImpl implements WitcherElementConverter {
    public final int a;
    public final SerpAdvertConverter b;
    public final FavoriteStatusResolver c;
    public final ViewedStatusResolver d;

    public WitcherElementConverterImpl(int i, @NotNull SerpAdvertConverter serpAdvertConverter, @NotNull FavoriteStatusResolver favoriteStatusResolver, @NotNull ViewedStatusResolver viewedStatusResolver) {
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(favoriteStatusResolver, "favoriteStatusResolver");
        Intrinsics.checkNotNullParameter(viewedStatusResolver, "viewedStatusResolver");
        this.a = i;
        this.b = serpAdvertConverter;
        this.c = favoriteStatusResolver;
        this.d = viewedStatusResolver;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherElementConverter
    @NotNull
    public WitcherItem convert(@NotNull WitcherElement witcherElement) {
        String str;
        Intrinsics.checkNotNullParameter(witcherElement, "entity");
        List<SerpElement> items = witcherElement.getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (T t : items) {
            AdvertItem convert = t instanceof SerpAdvert ? this.b.convert(t, false, SerpDisplayType.Grid) : null;
            if (convert != null) {
                arrayList.add(convert);
            }
        }
        this.d.resolveSync(arrayList);
        this.c.resolveSync(arrayList);
        int i = this.a;
        String buttonText = witcherElement.getButtonText();
        String str2 = buttonText != null ? buttonText : "";
        String titleText = witcherElement.getTitleText();
        if (titleText != null) {
            str = titleText;
        } else {
            str = "";
        }
        DeepLink deepLink = witcherElement.getDeepLink();
        WitcherElement.SelectionType selectionType = witcherElement.getSelectionType();
        if (selectionType == null) {
            selectionType = WitcherElement.SelectionType.REGULAR;
        }
        return new WitcherItem(null, i, selectionType, deepLink, arrayList, str2, str, 1, null);
    }
}
