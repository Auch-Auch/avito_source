package com.avito.android.user_adverts.tab_screens.advert_list.discount_banner;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", g.a, "I", "getSpanCount", "()I", "spanCount", "d", "getDiscountAmount", "discountAmount", "", "e", "Ljava/lang/Long;", "getDueDate", "()Ljava/lang/Long;", "dueDate", AuthSource.SEND_ABUSE, "getStringId", "stringId", "c", "getLimitDescription", "limitDescription", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/avito/android/deep_linking/links/DeepLink;I)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountBannerItem implements SerpItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final Long e;
    @NotNull
    public final DeepLink f;
    public final int g;

    public DiscountBannerItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Long l, @NotNull DeepLink deepLink, int i) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "limitDescription");
        Intrinsics.checkNotNullParameter(str4, "discountAmount");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = l;
        this.f = deepLink;
        this.g = i;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.f;
    }

    @NotNull
    public final String getDiscountAmount() {
        return this.d;
    }

    @Nullable
    public final Long getDueDate() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SerpItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getLimitDescription() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiscountBannerItem(String str, String str2, String str3, String str4, Long l, DeepLink deepLink, int i, int i2, j jVar) {
        this(str, str2, str3, str4, l, deepLink, (i2 & 64) != 0 ? 1 : i);
    }
}
