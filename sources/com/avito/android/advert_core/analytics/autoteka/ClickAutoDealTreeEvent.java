package com.avito.android.advert_core.analytics.autoteka;

import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.AdvertDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/analytics/autoteka/ClickAutoDealTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/AdvertDetails;", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertDetails;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClickAutoDealTreeEvent extends TreeClickStreamEvent {
    public final AdvertDetails e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickAutoDealTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull AdvertDetails advertDetails) {
        super(0, treeClickStreamParent, 3196, 1);
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.e = advertDetails;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.e.getId());
        putParam(linkedHashMap, "cid", this.e.getCategoryId());
        return linkedHashMap;
    }
}
