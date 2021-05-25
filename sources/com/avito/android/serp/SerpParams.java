package com.avito.android.serp;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/serp/SerpParams;", "Lcom/avito/android/serp/Serp;", "Lcom/avito/android/serp/SerpParameters;", "component1", "()Lcom/avito/android/serp/SerpParameters;", "serpParameters", "copy", "(Lcom/avito/android/serp/SerpParameters;)Lcom/avito/android/serp/SerpParams;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/SerpParameters;", "getSerpParameters", "<init>", "(Lcom/avito/android/serp/SerpParameters;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpParams extends Serp {
    @NotNull
    public final SerpParameters a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerpParams(@NotNull SerpParameters serpParameters) {
        super(null);
        Intrinsics.checkNotNullParameter(serpParameters, "serpParameters");
        this.a = serpParameters;
    }

    public static /* synthetic */ SerpParams copy$default(SerpParams serpParams, SerpParameters serpParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            serpParameters = serpParams.a;
        }
        return serpParams.copy(serpParameters);
    }

    @NotNull
    public final SerpParameters component1() {
        return this.a;
    }

    @NotNull
    public final SerpParams copy(@NotNull SerpParameters serpParameters) {
        Intrinsics.checkNotNullParameter(serpParameters, "serpParameters");
        return new SerpParams(serpParameters);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SerpParams) && Intrinsics.areEqual(this.a, ((SerpParams) obj).a);
        }
        return true;
    }

    @NotNull
    public final SerpParameters getSerpParameters() {
        return this.a;
    }

    public int hashCode() {
        SerpParameters serpParameters = this.a;
        if (serpParameters != null) {
            return serpParameters.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SerpParams(serpParameters=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
