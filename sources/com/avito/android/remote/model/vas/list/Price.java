package com.avito.android.remote.model.vas.list;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Price;", "", "", "original", "Ljava/lang/String;", "getOriginal", "()Ljava/lang/String;", VKApiConst.SERVICES, "getServices", FirebaseAnalytics.Param.DISCOUNT, "getDiscount", "final", "getFinal", "economy", "getEconomy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Price {
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    @Nullable
    private final String discount;
    @SerializedName("economy")
    @Nullable
    private final String economy;
    @SerializedName("final")
    @NotNull

    /* renamed from: final  reason: not valid java name */
    private final String f9final;
    @SerializedName("original")
    @Nullable
    private final String original;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final String services;

    public Price(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str5, "final");
        this.original = str;
        this.discount = str2;
        this.services = str3;
        this.economy = str4;
        this.f9final = str5;
    }

    @Nullable
    public final String getDiscount() {
        return this.discount;
    }

    @Nullable
    public final String getEconomy() {
        return this.economy;
    }

    @NotNull
    public final String getFinal() {
        return this.f9final;
    }

    @Nullable
    public final String getOriginal() {
        return this.original;
    }

    @Nullable
    public final String getServices() {
        return this.services;
    }
}
