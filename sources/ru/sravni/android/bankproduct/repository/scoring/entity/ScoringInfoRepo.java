package ru.sravni.android.bankproduct.repository.scoring.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JL\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "component4", "component5", "component6", "scoreStatus", "score", "providerTitle", "percentage", "message", "scoreUnitText", "copy", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getMessage", AuthSource.BOOKING_ORDER, "I", "getScore", "d", "getPercentage", "f", "getScoreUnitText", "c", "getProviderTitle", AuthSource.SEND_ABUSE, "getScoreStatus", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringInfoRepo {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;

    public ScoringInfoRepo(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "scoreStatus");
        Intrinsics.checkParameterIsNotNull(str2, "providerTitle");
        Intrinsics.checkParameterIsNotNull(str3, "message");
        Intrinsics.checkParameterIsNotNull(str4, "scoreUnitText");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = i2;
        this.e = str3;
        this.f = str4;
    }

    public static /* synthetic */ ScoringInfoRepo copy$default(ScoringInfoRepo scoringInfoRepo, String str, int i, String str2, int i2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = scoringInfoRepo.a;
        }
        if ((i3 & 2) != 0) {
            i = scoringInfoRepo.b;
        }
        if ((i3 & 4) != 0) {
            str2 = scoringInfoRepo.c;
        }
        if ((i3 & 8) != 0) {
            i2 = scoringInfoRepo.d;
        }
        if ((i3 & 16) != 0) {
            str3 = scoringInfoRepo.e;
        }
        if ((i3 & 32) != 0) {
            str4 = scoringInfoRepo.f;
        }
        return scoringInfoRepo.copy(str, i, str2, i2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final ScoringInfoRepo copy(@NotNull String str, int i, @NotNull String str2, int i2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "scoreStatus");
        Intrinsics.checkParameterIsNotNull(str2, "providerTitle");
        Intrinsics.checkParameterIsNotNull(str3, "message");
        Intrinsics.checkParameterIsNotNull(str4, "scoreUnitText");
        return new ScoringInfoRepo(str, i, str2, i2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScoringInfoRepo)) {
            return false;
        }
        ScoringInfoRepo scoringInfoRepo = (ScoringInfoRepo) obj;
        return Intrinsics.areEqual(this.a, scoringInfoRepo.a) && this.b == scoringInfoRepo.b && Intrinsics.areEqual(this.c, scoringInfoRepo.c) && this.d == scoringInfoRepo.d && Intrinsics.areEqual(this.e, scoringInfoRepo.e) && Intrinsics.areEqual(this.f, scoringInfoRepo.f);
    }

    @NotNull
    public final String getMessage() {
        return this.e;
    }

    public final int getPercentage() {
        return this.d;
    }

    @NotNull
    public final String getProviderTitle() {
        return this.c;
    }

    public final int getScore() {
        return this.b;
    }

    @NotNull
    public final String getScoreStatus() {
        return this.a;
    }

    @NotNull
    public final String getScoreUnitText() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        String str2 = this.c;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.d) * 31;
        String str3 = this.e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScoringInfoRepo(scoreStatus=");
        L.append(this.a);
        L.append(", score=");
        L.append(this.b);
        L.append(", providerTitle=");
        L.append(this.c);
        L.append(", percentage=");
        L.append(this.d);
        L.append(", message=");
        L.append(this.e);
        L.append(", scoreUnitText=");
        return a.t(L, this.f, ")");
    }
}
