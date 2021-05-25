package com.avito.android.remote.model.serp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/serp/Banner;", "", "Lcom/avito/android/remote/model/serp/BannerPayload;", "payload", "Lcom/avito/android/remote/model/serp/BannerPayload;", "getPayload", "()Lcom/avito/android/remote/model/serp/BannerPayload;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "closable", "Ljava/lang/Boolean;", "getClosable", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/serp/BannerPayload;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Banner {
    @SerializedName("closable")
    @Nullable
    private final Boolean closable;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("payload")
    @NotNull
    private final BannerPayload payload;

    public Banner(@NotNull String str, @NotNull BannerPayload bannerPayload, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(bannerPayload, "payload");
        this.id = str;
        this.payload = bannerPayload;
        this.closable = bool;
    }

    @Nullable
    public final Boolean getClosable() {
        return this.closable;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final BannerPayload getPayload() {
        return this.payload;
    }
}
