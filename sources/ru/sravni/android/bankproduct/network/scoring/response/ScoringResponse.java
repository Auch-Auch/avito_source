package ru.sravni.android.bankproduct.network.scoring.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.scoring.entity.ScoringInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse;", "", "Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;", "component1", "()Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;", "item", "copy", "(Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;)Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringResponse {
    @SerializedName("item")
    @NotNull
    private final Item item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJP\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u0011\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\nR\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b#\u0010\nR\u001c\u0010\u0015\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b$\u0010\nR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\r¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;", "", "Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "toScoringRepo", "()Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Integer;", "component5", "component6", "score", "scoreUnitText", "providerTitle", "percentage", "message", "status", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/scoring/response/ScoringResponse$Item;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProviderTitle", "getScoreUnitText", "I", "getScore", "getMessage", "getStatus", "Ljava/lang/Integer;", "getPercentage", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Item {
        @SerializedName("message")
        @NotNull
        private final String message;
        @SerializedName("percentage")
        @Nullable
        private final Integer percentage;
        @SerializedName("providerTitle")
        @Nullable
        private final String providerTitle;
        @SerializedName("score")
        private final int score;
        @SerializedName("scoreUnitText")
        @NotNull
        private final String scoreUnitText;
        @SerializedName("status")
        @NotNull
        private final String status;

        public Item(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull String str3, @NotNull String str4) {
            a.a1(str, "scoreUnitText", str3, "message", str4, "status");
            this.score = i;
            this.scoreUnitText = str;
            this.providerTitle = str2;
            this.percentage = num;
            this.message = str3;
            this.status = str4;
        }

        public static /* synthetic */ Item copy$default(Item item, int i, String str, String str2, Integer num, String str3, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = item.score;
            }
            if ((i2 & 2) != 0) {
                str = item.scoreUnitText;
            }
            if ((i2 & 4) != 0) {
                str2 = item.providerTitle;
            }
            if ((i2 & 8) != 0) {
                num = item.percentage;
            }
            if ((i2 & 16) != 0) {
                str3 = item.message;
            }
            if ((i2 & 32) != 0) {
                str4 = item.status;
            }
            return item.copy(i, str, str2, num, str3, str4);
        }

        public final int component1() {
            return this.score;
        }

        @NotNull
        public final String component2() {
            return this.scoreUnitText;
        }

        @Nullable
        public final String component3() {
            return this.providerTitle;
        }

        @Nullable
        public final Integer component4() {
            return this.percentage;
        }

        @NotNull
        public final String component5() {
            return this.message;
        }

        @NotNull
        public final String component6() {
            return this.status;
        }

        @NotNull
        public final Item copy(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkParameterIsNotNull(str, "scoreUnitText");
            Intrinsics.checkParameterIsNotNull(str3, "message");
            Intrinsics.checkParameterIsNotNull(str4, "status");
            return new Item(i, str, str2, num, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return this.score == item.score && Intrinsics.areEqual(this.scoreUnitText, item.scoreUnitText) && Intrinsics.areEqual(this.providerTitle, item.providerTitle) && Intrinsics.areEqual(this.percentage, item.percentage) && Intrinsics.areEqual(this.message, item.message) && Intrinsics.areEqual(this.status, item.status);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final Integer getPercentage() {
            return this.percentage;
        }

        @Nullable
        public final String getProviderTitle() {
            return this.providerTitle;
        }

        public final int getScore() {
            return this.score;
        }

        @NotNull
        public final String getScoreUnitText() {
            return this.scoreUnitText;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public int hashCode() {
            int i = this.score * 31;
            String str = this.scoreUnitText;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.providerTitle;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num = this.percentage;
            int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
            String str3 = this.message;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.status;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode4 + i2;
        }

        @NotNull
        public final ScoringInfoRepo toScoringRepo() {
            int i = this.score;
            String str = this.status;
            String str2 = this.providerTitle;
            if (str2 == null) {
                str2 = "";
            }
            Integer num = this.percentage;
            return new ScoringInfoRepo(str, i, str2, num != null ? num.intValue() : 0, this.message, this.scoreUnitText);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(score=");
            L.append(this.score);
            L.append(", scoreUnitText=");
            L.append(this.scoreUnitText);
            L.append(", providerTitle=");
            L.append(this.providerTitle);
            L.append(", percentage=");
            L.append(this.percentage);
            L.append(", message=");
            L.append(this.message);
            L.append(", status=");
            return a.t(L, this.status, ")");
        }
    }

    public ScoringResponse(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        this.item = item2;
    }

    public static /* synthetic */ ScoringResponse copy$default(ScoringResponse scoringResponse, Item item2, int i, Object obj) {
        if ((i & 1) != 0) {
            item2 = scoringResponse.item;
        }
        return scoringResponse.copy(item2);
    }

    @NotNull
    public final Item component1() {
        return this.item;
    }

    @NotNull
    public final ScoringResponse copy(@NotNull Item item2) {
        Intrinsics.checkParameterIsNotNull(item2, "item");
        return new ScoringResponse(item2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ScoringResponse) && Intrinsics.areEqual(this.item, ((ScoringResponse) obj).item);
        }
        return true;
    }

    @NotNull
    public final Item getItem() {
        return this.item;
    }

    public int hashCode() {
        Item item2 = this.item;
        if (item2 != null) {
            return item2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScoringResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
