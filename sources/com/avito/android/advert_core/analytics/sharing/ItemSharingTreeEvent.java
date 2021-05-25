package com.avito.android.advert_core.analytics.sharing;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b \u0010!J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/advert_core/analytics/sharing/ItemSharingTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "", "i", "Ljava/lang/Boolean;", "getAuthorized", "()Ljava/lang/Boolean;", "authorized", "h", "Ljava/lang/String;", "getPageType", "()Ljava/lang/String;", "pageType", "e", "getAdvertId", BookingInfoActivity.EXTRA_ITEM_ID, "f", "getUserId", ChannelContext.Item.USER_ID, "", g.a, "I", "getSocialNetworkId", "()I", "socialNetworkId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ItemSharingTreeEvent extends TreeClickStreamEvent {
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    public final int g;
    @NotNull
    public final String h;
    @Nullable
    public final Boolean i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemSharingTreeEvent(TreeClickStreamParent treeClickStreamParent, String str, String str2, int i2, String str3, Boolean bool, int i3, j jVar) {
        this(treeClickStreamParent, str, str2, i2, str3, (i3 & 32) != 0 ? null : bool);
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.e);
        putParam(linkedHashMap, "oid", this.f);
        putParam(linkedHashMap, AuthParamsKt.KEY_SOCIAL_ID, Integer.valueOf(this.g));
        putParam(linkedHashMap, "pagetype", this.h);
        putParam(linkedHashMap, "is_auth", this.i);
        return linkedHashMap;
    }

    @NotNull
    public final String getAdvertId() {
        return this.e;
    }

    @Nullable
    public final Boolean getAuthorized() {
        return this.i;
    }

    @NotNull
    public final String getPageType() {
        return this.h;
    }

    public final int getSocialNetworkId() {
        return this.g;
    }

    @NotNull
    public final String getUserId() {
        return this.f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemSharingTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull String str, @NotNull String str2, int i2, @NotNull String str3, @Nullable Boolean bool) {
        super(0, treeClickStreamParent, 308, 8);
        a.Z0(str, BookingInfoActivity.EXTRA_ITEM_ID, str2, ChannelContext.Item.USER_ID, str3, "pageType");
        this.e = str;
        this.f = str2;
        this.g = i2;
        this.h = str3;
        this.i = bool;
    }
}
