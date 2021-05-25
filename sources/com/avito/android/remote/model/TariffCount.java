package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/TariffCount;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "isSelected", "Z", "()Z", "id", "getId", "Lcom/avito/android/remote/model/TariffCountPrice;", "countPrice", "Lcom/avito/android/remote/model/TariffCountPrice;", "getCountPrice", "()Lcom/avito/android/remote/model/TariffCountPrice;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/TariffCountPrice;Z)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCount {
    @SerializedName("countPrice")
    @Nullable
    private final TariffCountPrice countPrice;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("isSelected")
    private final boolean isSelected;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffCount(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable TariffCountPrice tariffCountPrice, boolean z) {
        a.Z0(str, "id", str2, "title", str3, "description");
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.countPrice = tariffCountPrice;
        this.isSelected = z;
    }

    @Nullable
    public final TariffCountPrice getCountPrice() {
        return this.countPrice;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
