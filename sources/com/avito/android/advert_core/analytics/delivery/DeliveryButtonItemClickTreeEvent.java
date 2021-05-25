package com.avito.android.advert_core.analytics.delivery;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert_core/analytics/delivery/DeliveryButtonItemClickTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "h", "Ljava/lang/String;", "source", g.a, "categoryId", "e", BookingInfoActivity.EXTRA_ITEM_ID, "", "i", "Z", "isUserAuth", "f", ChannelContext.Item.USER_ID, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryButtonItemClickTreeEvent extends TreeClickStreamEvent {
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryButtonItemClickTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        super(0, treeClickStreamParent, 2483, 2);
        a.b1(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, ChannelContext.Item.USER_ID, str3, "categoryId", str4, "source");
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = z;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.e);
        putParam(linkedHashMap, "uid", this.f);
        putParam(linkedHashMap, "cid", this.g);
        putParam(linkedHashMap, "scrp", this.h);
        putParam(linkedHashMap, "is_user_auth", Boolean.valueOf(this.i));
        return linkedHashMap;
    }
}
