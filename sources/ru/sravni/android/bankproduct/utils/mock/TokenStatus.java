package ru.sravni.android.bankproduct.utils.mock;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.token.entity.HttpResponseStatus;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/utils/mock/TokenStatus;", "", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "component1", "()Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "responseStatus", "copy", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)Lru/sravni/android/bankproduct/utils/mock/TokenStatus;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "getResponseStatus", "<init>", "(Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenStatus {
    @NotNull
    public final HttpResponseStatus a;

    public TokenStatus(@NotNull HttpResponseStatus httpResponseStatus) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "responseStatus");
        this.a = httpResponseStatus;
    }

    public static /* synthetic */ TokenStatus copy$default(TokenStatus tokenStatus, HttpResponseStatus httpResponseStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            httpResponseStatus = tokenStatus.a;
        }
        return tokenStatus.copy(httpResponseStatus);
    }

    @NotNull
    public final HttpResponseStatus component1() {
        return this.a;
    }

    @NotNull
    public final TokenStatus copy(@NotNull HttpResponseStatus httpResponseStatus) {
        Intrinsics.checkParameterIsNotNull(httpResponseStatus, "responseStatus");
        return new TokenStatus(httpResponseStatus);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof TokenStatus) && Intrinsics.areEqual(this.a, ((TokenStatus) obj).a);
        }
        return true;
    }

    @NotNull
    public final HttpResponseStatus getResponseStatus() {
        return this.a;
    }

    public int hashCode() {
        HttpResponseStatus httpResponseStatus = this.a;
        if (httpResponseStatus != null) {
            return httpResponseStatus.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TokenStatus(responseStatus=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
