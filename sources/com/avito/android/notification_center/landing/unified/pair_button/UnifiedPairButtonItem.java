package com.avito.android.notification_center.landing.unified.pair_button;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR'\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR'\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b¨\u0006\""}, d2 = {"Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;", "Lcom/avito/conveyor_item/Item;", "", "f", "Ljava/lang/String;", "getFirstText", "()Ljava/lang/String;", "firstText", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getFirstDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "firstDeepLink", g.a, "getSecondText", "secondText", "c", "getSecondDeepLink", "secondDeepLink", "", "e", "Ljava/util/Map;", "getSecondAnalyticParams", "()Ljava/util/Map;", "secondAnalyticParams", "d", "getFirstAnalyticParams", "firstAnalyticParams", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedPairButtonItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final DeepLink b;
    @NotNull
    public final DeepLink c;
    @Nullable
    public final Map<String, String> d;
    @Nullable
    public final Map<String, String> e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;

    public UnifiedPairButtonItem(@NotNull String str, @NotNull DeepLink deepLink, @NotNull DeepLink deepLink2, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(deepLink, "firstDeepLink");
        Intrinsics.checkNotNullParameter(deepLink2, "secondDeepLink");
        Intrinsics.checkNotNullParameter(str2, "firstText");
        Intrinsics.checkNotNullParameter(str3, "secondText");
        this.a = str;
        this.b = deepLink;
        this.c = deepLink2;
        this.d = map;
        this.e = map2;
        this.f = str2;
        this.g = str3;
    }

    @Nullable
    public final Map<String, String> getFirstAnalyticParams() {
        return this.d;
    }

    @NotNull
    public final DeepLink getFirstDeepLink() {
        return this.b;
    }

    @NotNull
    public final String getFirstText() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Map<String, String> getSecondAnalyticParams() {
        return this.e;
    }

    @NotNull
    public final DeepLink getSecondDeepLink() {
        return this.c;
    }

    @NotNull
    public final String getSecondText() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
