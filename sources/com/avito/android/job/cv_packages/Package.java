package com.avito.android.job.cv_packages;

import com.avito.android.deep_linking.links.DeepLink;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/job/cv_packages/Package;", "", "", FirebaseAnalytics.Param.DISCOUNT, "Ljava/lang/String;", "getDiscount", "()Ljava/lang/String;", "title", "getTitle", "price", "getPrice", "singlePrice", "getSinglePrice", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "originalPrice", "getOriginalPrice", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "job_release"}, k = 1, mv = {1, 4, 2})
public final class Package {
    @SerializedName("deeplink")
    @NotNull
    private final DeepLink deeplink;
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    @Nullable
    private final String discount;
    @SerializedName("original_price")
    @Nullable
    private final String originalPrice;
    @SerializedName("price")
    @NotNull
    private final String price;
    @SerializedName("single_price")
    @Nullable
    private final String singlePrice;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Package(@NotNull String str, @NotNull DeepLink deepLink, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intrinsics.checkNotNullParameter(str2, "price");
        this.title = str;
        this.deeplink = deepLink;
        this.price = str2;
        this.discount = str3;
        this.originalPrice = str4;
        this.singlePrice = str5;
    }

    @NotNull
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final String getDiscount() {
        return this.discount;
    }

    @Nullable
    public final String getOriginalPrice() {
        return this.originalPrice;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final String getSinglePrice() {
        return this.singlePrice;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Package(String str, DeepLink deepLink, String str2, String str3, String str4, String str5, int i, j jVar) {
        this(str, deepLink, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }
}
