package ru.sravni.android.bankproduct.mock.webclient;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStubInfo;", "", "", "component1", "()Ljava/lang/String;", "scoringListPath", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStubInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getScoringListPath", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringWebClientStubInfo {
    @NotNull
    public final String a;

    public ScoringWebClientStubInfo() {
        this(null, 1, null);
    }

    public ScoringWebClientStubInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scoringListPath");
        this.a = str;
    }

    public static /* synthetic */ ScoringWebClientStubInfo copy$default(ScoringWebClientStubInfo scoringWebClientStubInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scoringWebClientStubInfo.a;
        }
        return scoringWebClientStubInfo.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final ScoringWebClientStubInfo copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scoringListPath");
        return new ScoringWebClientStubInfo(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ScoringWebClientStubInfo) && Intrinsics.areEqual(this.a, ((ScoringWebClientStubInfo) obj).a);
        }
        return true;
    }

    @NotNull
    public final String getScoringListPath() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("ScoringWebClientStubInfo(scoringListPath="), this.a, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScoringWebClientStubInfo(String str, int i, j jVar) {
        this((i & 1) != 0 ? "mock/scoring/ScoringList.json" : str);
    }
}
