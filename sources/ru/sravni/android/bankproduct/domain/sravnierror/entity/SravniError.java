package ru.sravni.android.bankproduct.domain.sravnierror.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b'\u0010(B;\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b'\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0000HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0000HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\tR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000b¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "", "", "component1", "()Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "component2", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "component3", "()Ljava/lang/Throwable;", "component4", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "domain", "errDescription", "error", "parent", "copy", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;Ljava/lang/Throwable;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Throwable;", "getError", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "getErrDescription", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "getParent", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;Ljava/lang/Throwable;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "code", "codeName", "description", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniError extends Throwable {
    @NotNull
    public final String a;
    @NotNull
    public final ErrorDescription b;
    @NotNull
    public final Throwable c;
    @Nullable
    public final SravniError d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SravniError(String str, ErrorDescription errorDescription, Throwable th, SravniError sravniError, int i, j jVar) {
        this(str, errorDescription, th, (i & 8) != 0 ? null : sravniError);
    }

    public static /* synthetic */ SravniError copy$default(SravniError sravniError, String str, ErrorDescription errorDescription, Throwable th, SravniError sravniError2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sravniError.a;
        }
        if ((i & 2) != 0) {
            errorDescription = sravniError.b;
        }
        if ((i & 4) != 0) {
            th = sravniError.c;
        }
        if ((i & 8) != 0) {
            sravniError2 = sravniError.d;
        }
        return sravniError.copy(str, errorDescription, th, sravniError2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final ErrorDescription component2() {
        return this.b;
    }

    @NotNull
    public final Throwable component3() {
        return this.c;
    }

    @Nullable
    public final SravniError component4() {
        return this.d;
    }

    @NotNull
    public final SravniError copy(@NotNull String str, @NotNull ErrorDescription errorDescription, @NotNull Throwable th, @Nullable SravniError sravniError) {
        Intrinsics.checkParameterIsNotNull(str, "domain");
        Intrinsics.checkParameterIsNotNull(errorDescription, "errDescription");
        Intrinsics.checkParameterIsNotNull(th, "error");
        return new SravniError(str, errorDescription, th, sravniError);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SravniError)) {
            return false;
        }
        SravniError sravniError = (SravniError) obj;
        return Intrinsics.areEqual(this.a, sravniError.a) && Intrinsics.areEqual(this.b, sravniError.b) && Intrinsics.areEqual(this.c, sravniError.c) && Intrinsics.areEqual(this.d, sravniError.d);
    }

    @NotNull
    public final String getDomain() {
        return this.a;
    }

    @NotNull
    public final ErrorDescription getErrDescription() {
        return this.b;
    }

    @NotNull
    public final Throwable getError() {
        return this.c;
    }

    @Nullable
    public final SravniError getParent() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ErrorDescription errorDescription = this.b;
        int hashCode2 = (hashCode + (errorDescription != null ? errorDescription.hashCode() : 0)) * 31;
        Throwable th = this.c;
        int hashCode3 = (hashCode2 + (th != null ? th.hashCode() : 0)) * 31;
        SravniError sravniError = this.d;
        if (sravniError != null) {
            i = sravniError.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Throwable, java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SravniError(domain=");
        L.append(this.a);
        L.append(", errDescription=");
        L.append(this.b);
        L.append(", error=");
        L.append(this.c);
        L.append(", parent=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SravniError(@NotNull String str, @NotNull ErrorDescription errorDescription, @NotNull Throwable th, @Nullable SravniError sravniError) {
        super(SravniErrorKt.access$getErrorMessage(str, errorDescription, sravniError), th);
        Intrinsics.checkParameterIsNotNull(str, "domain");
        Intrinsics.checkParameterIsNotNull(errorDescription, "errDescription");
        Intrinsics.checkParameterIsNotNull(th, "error");
        this.a = str;
        this.b = errorDescription;
        this.c = th;
        this.d = sravniError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SravniError(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull Throwable th, @Nullable SravniError sravniError) {
        this(str, new ErrorDescription(i, str2, str3, null, 8, null), th, sravniError);
        Intrinsics.checkParameterIsNotNull(str, "domain");
        Intrinsics.checkParameterIsNotNull(str2, "codeName");
        Intrinsics.checkParameterIsNotNull(str3, "description");
        Intrinsics.checkParameterIsNotNull(th, "error");
    }
}
