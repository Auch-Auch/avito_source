package ru.sravni.android.bankproduct.domain.auth.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/domain/auth/entity/UserInfo;", "", "", "component1", "()Ljava/lang/String;", "name", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/auth/entity/UserInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class UserInfo {
    @NotNull
    public final String a;

    public UserInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.a = str;
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.a;
        }
        return userInfo.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final UserInfo copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return new UserInfo(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof UserInfo) && Intrinsics.areEqual(this.a, ((UserInfo) obj).a);
        }
        return true;
    }

    @NotNull
    public final String getName() {
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
        return a.t(a.L("UserInfo(name="), this.a, ")");
    }
}
