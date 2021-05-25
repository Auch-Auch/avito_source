package ru.sravni.android.bankproduct.repository.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Z", "mask", "maskPlaceholder", "regexp", "required", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMask", "d", "Z", "getRequired", AuthSource.BOOKING_ORDER, "getMaskPlaceholder", "c", "getRegexp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ContentElementValidateRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    public final boolean d;

    public ContentElementValidateRepo(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "mask");
        Intrinsics.checkParameterIsNotNull(str2, "maskPlaceholder");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public static /* synthetic */ ContentElementValidateRepo copy$default(ContentElementValidateRepo contentElementValidateRepo, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contentElementValidateRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = contentElementValidateRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = contentElementValidateRepo.c;
        }
        if ((i & 8) != 0) {
            z = contentElementValidateRepo.d;
        }
        return contentElementValidateRepo.copy(str, str2, str3, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final ContentElementValidateRepo copy(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "mask");
        Intrinsics.checkParameterIsNotNull(str2, "maskPlaceholder");
        return new ContentElementValidateRepo(str, str2, str3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentElementValidateRepo)) {
            return false;
        }
        ContentElementValidateRepo contentElementValidateRepo = (ContentElementValidateRepo) obj;
        return Intrinsics.areEqual(this.a, contentElementValidateRepo.a) && Intrinsics.areEqual(this.b, contentElementValidateRepo.b) && Intrinsics.areEqual(this.c, contentElementValidateRepo.c) && this.d == contentElementValidateRepo.d;
    }

    @NotNull
    public final String getMask() {
        return this.a;
    }

    @NotNull
    public final String getMaskPlaceholder() {
        return this.b;
    }

    @Nullable
    public final String getRegexp() {
        return this.c;
    }

    public final boolean getRequired() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContentElementValidateRepo(mask=");
        L.append(this.a);
        L.append(", maskPlaceholder=");
        L.append(this.b);
        L.append(", regexp=");
        L.append(this.c);
        L.append(", required=");
        return a.B(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentElementValidateRepo(String str, String str2, String str3, boolean z, int i, j jVar) {
        this(str, str2, str3, (i & 8) != 0 ? false : z);
    }
}
