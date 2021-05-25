package com.avito.android.search.subscriptions.adapter;

import a2.g.r.g;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\u00101\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010+\u001a\u0004\u0018\u00010&¢\u0006\u0004\b2\u00103J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00101\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\f¨\u00064"}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "Lcom/avito/conveyor_item/Item;", "", "resetCount", "()V", "", "getCount", "()I", "", "f", "Ljava/lang/String;", "getSsid", "()Ljava/lang/String;", SearchSubscriptionsContract.Columns.SSID, "", "d", "J", "getLastUpdateTime", "()J", "lastUpdateTime", AuthSource.SEND_ABUSE, "getStringId", "stringId", "c", "getDescription", "description", "Lcom/avito/android/remote/model/SearchParams;", g.a, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "h", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "getEditAction", "()Lcom/avito/android/deep_linking/links/SaveSearchLink;", "editAction", "Lcom/avito/android/deep_linking/links/DeepLink;", "i", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "e", "I", "count", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/deep_linking/links/SaveSearchLink;Lcom/avito/android/deep_linking/links/DeepLink;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    public final long d;
    public int e;
    @Nullable
    public final String f;
    @Nullable
    public final SearchParams g;
    @Nullable
    public final SaveSearchLink h;
    @Nullable
    public final DeepLink i;

    public SearchSubscriptionItem(@NotNull String str, @Nullable String str2, @Nullable String str3, long j, int i2, @Nullable String str4, @Nullable SearchParams searchParams, @Nullable SaveSearchLink saveSearchLink, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = i2;
        this.f = str4;
        this.g = searchParams;
        this.h = saveSearchLink;
        this.i = deepLink;
    }

    public final int getCount() {
        return this.e;
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.i;
    }

    @Nullable
    public final String getDescription() {
        return this.c;
    }

    @Nullable
    public final SaveSearchLink getEditAction() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public final long getLastUpdateTime() {
        return this.d;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.g;
    }

    @Nullable
    public final String getSsid() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }

    public final void resetCount() {
        this.e = 0;
    }
}
