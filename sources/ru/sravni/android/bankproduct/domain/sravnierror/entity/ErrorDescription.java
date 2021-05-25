package ru.sravni.android.bankproduct.domain.sravnierror.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R'\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000b¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()Ljava/util/Map;", "code", "codeName", "description", "keysForAnalyse", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCodeName", "c", "getDescription", AuthSource.SEND_ABUSE, "I", "getCode", "d", "Ljava/util/Map;", "getKeysForAnalyse", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ErrorDescription {
    public final int a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final Map<String, String> d;

    public ErrorDescription(int i, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "codeName");
        Intrinsics.checkParameterIsNotNull(str2, "description");
        Intrinsics.checkParameterIsNotNull(map, "keysForAnalyse");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorDescription copy$default(ErrorDescription errorDescription, int i, String str, String str2, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorDescription.a;
        }
        if ((i2 & 2) != 0) {
            str = errorDescription.b;
        }
        if ((i2 & 4) != 0) {
            str2 = errorDescription.c;
        }
        if ((i2 & 8) != 0) {
            map = errorDescription.d;
        }
        return errorDescription.copy(i, str, str2, map);
    }

    public final int component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final Map<String, String> component4() {
        return this.d;
    }

    @NotNull
    public final ErrorDescription copy(int i, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "codeName");
        Intrinsics.checkParameterIsNotNull(str2, "description");
        Intrinsics.checkParameterIsNotNull(map, "keysForAnalyse");
        return new ErrorDescription(i, str, str2, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorDescription)) {
            return false;
        }
        ErrorDescription errorDescription = (ErrorDescription) obj;
        return this.a == errorDescription.a && Intrinsics.areEqual(this.b, errorDescription.b) && Intrinsics.areEqual(this.c, errorDescription.c) && Intrinsics.areEqual(this.d, errorDescription.d);
    }

    public final int getCode() {
        return this.a;
    }

    @NotNull
    public final String getCodeName() {
        return this.b;
    }

    @NotNull
    public final String getDescription() {
        return this.c;
    }

    @NotNull
    public final Map<String, String> getKeysForAnalyse() {
        return this.d;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.d;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ErrorDescription(code=");
        L.append(this.a);
        L.append(", codeName=");
        L.append(this.b);
        L.append(", description=");
        L.append(this.c);
        L.append(", keysForAnalyse=");
        return a.x(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorDescription(int i, String str, String str2, Map map, int i2, j jVar) {
        this(i, str, str2, (i2 & 8) != 0 ? r.emptyMap() : map);
    }
}
