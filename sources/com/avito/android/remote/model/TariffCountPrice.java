package com.avito.android.remote.model;

import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/TariffCountPrice;", "", "", "price", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "oldPrice", "getOldPrice", "Lcom/avito/android/remote/model/TariffCountPrice$Bonus;", TariffCountPayloadCreator.PAYLOAD_BONUS, "Lcom/avito/android/remote/model/TariffCountPrice$Bonus;", "getBonus", "()Lcom/avito/android/remote/model/TariffCountPrice$Bonus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/TariffCountPrice$Bonus;)V", "Bonus", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountPrice {
    @SerializedName(TariffCountPayloadCreator.PAYLOAD_BONUS)
    @Nullable
    private final Bonus bonus;
    @SerializedName("oldPrice")
    @Nullable
    private final String oldPrice;
    @SerializedName("price")
    @NotNull
    private final String price;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/TariffCountPrice$Bonus;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class Bonus {
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("title")
        @NotNull
        private final String title;

        public Bonus(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            this.title = str;
            this.description = str2;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }

    public TariffCountPrice(@NotNull String str, @Nullable String str2, @Nullable Bonus bonus2) {
        Intrinsics.checkNotNullParameter(str, "price");
        this.price = str;
        this.oldPrice = str2;
        this.bonus = bonus2;
    }

    @Nullable
    public final Bonus getBonus() {
        return this.bonus;
    }

    @Nullable
    public final String getOldPrice() {
        return this.oldPrice;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }
}
