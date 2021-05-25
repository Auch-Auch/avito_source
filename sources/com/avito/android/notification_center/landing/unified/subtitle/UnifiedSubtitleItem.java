package com.avito.android.notification_center.landing.unified.subtitle;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bR'\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItem;", "Lcom/avito/conveyor_item/Item;", "", "", "c", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "analyticParams", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "d", "getButtonText", "buttonText", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "e", "getTitleText", "titleText", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedSubtitleItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final DeepLink b;
    @Nullable
    public final Map<String, String> c;
    @Nullable
    public final String d;
    @NotNull
    public final String e;

    public UnifiedSubtitleItem(@NotNull String str, @Nullable DeepLink deepLink, @Nullable Map<String, String> map, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str3, "titleText");
        this.a = str;
        this.b = deepLink;
        this.c = map;
        this.d = str2;
        this.e = str3;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.c;
    }

    @Nullable
    public final String getButtonText() {
        return this.d;
    }

    @Nullable
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
    public final String getTitleText() {
        return this.e;
    }
}
