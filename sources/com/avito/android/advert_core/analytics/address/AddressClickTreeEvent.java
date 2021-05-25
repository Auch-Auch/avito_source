package com.avito.android.advert_core.analytics.address;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.AdjustParameters;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert_core/analytics/address/AddressClickTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/AdvertDetails;", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "f", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "geoFromBlock", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AddressClickTreeEvent extends TreeClickStreamEvent {
    public final AdvertDetails e;
    public final GeoFromBlock f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressClickTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull AdvertDetails advertDetails, @NotNull GeoFromBlock geoFromBlock) {
        super(0, treeClickStreamParent, 3197, 5);
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(geoFromBlock, "geoFromBlock");
        this.e = advertDetails;
        this.f = geoFromBlock;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "cid", this.e.getCategoryId());
        putParam(linkedHashMap, "iid", this.e.getId());
        AdjustParameters adjustParameters = this.e.getAdjustParameters();
        putParam(linkedHashMap, "mcid", adjustParameters != null ? adjustParameters.getMicroCategoryId() : null);
        putParam(linkedHashMap, WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, this.f.getValue());
        return linkedHashMap;
    }
}
