package ru.sravni.android.bankproduct.domain.scoring.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringDomain;", "", "Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;", "component1", "()Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "scoreStatus", "score", "providerTitle", "percentage", "message", "scoreUnitText", "copy", "(Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringDomain;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getScoreUnitText", "d", "I", "getPercentage", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;", "getScoreStatus", AuthSource.BOOKING_ORDER, "getScore", "e", "getMessage", "c", "getProviderTitle", "<init>", "(Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringDomain {
    @NotNull
    public final ScoringStatus a;
    public final int b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;

    public ScoringDomain(@NotNull ScoringStatus scoringStatus, int i, @NotNull String str, int i2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(scoringStatus, "scoreStatus");
        Intrinsics.checkParameterIsNotNull(str, "providerTitle");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(str3, "scoreUnitText");
        this.a = scoringStatus;
        this.b = i;
        this.c = str;
        this.d = i2;
        this.e = str2;
        this.f = str3;
    }

    public static /* synthetic */ ScoringDomain copy$default(ScoringDomain scoringDomain, ScoringStatus scoringStatus, int i, String str, int i2, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            scoringStatus = scoringDomain.a;
        }
        if ((i3 & 2) != 0) {
            i = scoringDomain.b;
        }
        if ((i3 & 4) != 0) {
            str = scoringDomain.c;
        }
        if ((i3 & 8) != 0) {
            i2 = scoringDomain.d;
        }
        if ((i3 & 16) != 0) {
            str2 = scoringDomain.e;
        }
        if ((i3 & 32) != 0) {
            str3 = scoringDomain.f;
        }
        return scoringDomain.copy(scoringStatus, i, str, i2, str2, str3);
    }

    @NotNull
    public final ScoringStatus component1() {
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
    public final ScoringDomain copy(@NotNull ScoringStatus scoringStatus, int i, @NotNull String str, int i2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(scoringStatus, "scoreStatus");
        Intrinsics.checkParameterIsNotNull(str, "providerTitle");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(str3, "scoreUnitText");
        return new ScoringDomain(scoringStatus, i, str, i2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScoringDomain)) {
            return false;
        }
        ScoringDomain scoringDomain = (ScoringDomain) obj;
        return Intrinsics.areEqual(this.a, scoringDomain.a) && this.b == scoringDomain.b && Intrinsics.areEqual(this.c, scoringDomain.c) && this.d == scoringDomain.d && Intrinsics.areEqual(this.e, scoringDomain.e) && Intrinsics.areEqual(this.f, scoringDomain.f);
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
    public final ScoringStatus getScoreStatus() {
        return this.a;
    }

    @NotNull
    public final String getScoreUnitText() {
        return this.f;
    }

    public int hashCode() {
        ScoringStatus scoringStatus = this.a;
        int i = 0;
        int hashCode = (((scoringStatus != null ? scoringStatus.hashCode() : 0) * 31) + this.b) * 31;
        String str = this.c;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.d) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ScoringDomain(scoreStatus=");
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
