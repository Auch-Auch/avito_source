package com.avito.android.notification_center.landing.unified.button;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR'\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "c", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "analyticParams", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/lang/String;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedButtonItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final DeepLink b;
    @Nullable
    public final Map<String, String> c;
    @NotNull
    public final String d;

    public UnifiedButtonItem(@NotNull String str, @NotNull DeepLink deepLink, @Nullable Map<String, String> map, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = deepLink;
        this.c = map;
        this.d = str2;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.c;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
    }
}
