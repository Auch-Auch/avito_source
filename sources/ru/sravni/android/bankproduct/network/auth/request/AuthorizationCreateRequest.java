package ru.sravni.android.bankproduct.network.auth.request;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCreateRequest;", "", "", "component1", "()Ljava/lang/String;", "phone", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/auth/request/AuthorizationCreateRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AuthorizationCreateRequest {
    private final String phone;

    public AuthorizationCreateRequest(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        this.phone = str;
    }

    private final String component1() {
        return this.phone;
    }

    public static /* synthetic */ AuthorizationCreateRequest copy$default(AuthorizationCreateRequest authorizationCreateRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authorizationCreateRequest.phone;
        }
        return authorizationCreateRequest.copy(str);
    }

    @NotNull
    public final AuthorizationCreateRequest copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "phone");
        return new AuthorizationCreateRequest(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AuthorizationCreateRequest) && Intrinsics.areEqual(this.phone, ((AuthorizationCreateRequest) obj).phone);
        }
        return true;
    }

    public int hashCode() {
        String str = this.phone;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.t(a.L("AuthorizationCreateRequest(phone="), this.phone, ")");
    }
}
