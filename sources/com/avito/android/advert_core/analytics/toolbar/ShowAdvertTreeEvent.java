package com.avito.android.advert_core.analytics.toolbar;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingActivityKt;
import com.avito.android.remote.marketplace.AdvertMarketPlace;
import com.avito.android.remote.marketplace.InStock;
import com.avito.android.remote.model.AdjustParameters;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AdvertSeller;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/ShowAdvertTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/AdvertDetails;", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertDetails;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShowAdvertTreeEvent extends TreeClickStreamEvent {
    public final AdvertDetails e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShowAdvertTreeEvent(long j, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull AdvertDetails advertDetails) {
        super(j, treeClickStreamParent, 2649, 12);
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.e = advertDetails;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        InStock inStockTexts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "cid", this.e.getCategoryId());
        putParam(linkedHashMap, "oc", Boolean.valueOf(this.e.isFromCompany()));
        putParam(linkedHashMap, "mid", this.e.getMetroId());
        AdvertSeller seller = this.e.getSeller();
        String str = null;
        putParam(linkedHashMap, "oid", seller != null ? seller.getUserHashId() : null);
        putParam(linkedHashMap, "iid", this.e.getId());
        putParam(linkedHashMap, "lid", this.e.getLocationId());
        putParam(linkedHashMap, "sid", this.e.getShopId());
        AdjustParameters adjustParameters = this.e.getAdjustParameters();
        if (adjustParameters != null) {
            str = adjustParameters.getMicroCategoryId();
        }
        putParam(linkedHashMap, "mcid", str);
        putParam(linkedHashMap, DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, Boolean.valueOf(this.e.isMarketplace()));
        AdvertMarketPlace marketplaceData = this.e.getMarketplaceData();
        boolean z = true;
        if (marketplaceData == null || (inStockTexts = marketplaceData.getInStockTexts()) == null || !inStockTexts.getInStock()) {
            z = false;
        }
        putParam(linkedHashMap, "is_stock", Boolean.valueOf(z));
        return linkedHashMap;
    }
}
