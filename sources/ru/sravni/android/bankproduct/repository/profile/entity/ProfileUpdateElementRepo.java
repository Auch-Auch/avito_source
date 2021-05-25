package ru.sravni.android.bankproduct.repository.profile.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "newValue", "oldValue", MessageMetaInfo.COLUMN_PATH, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileUpdateElementRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNewValue", "c", "getPath", AuthSource.BOOKING_ORDER, "getOldValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileUpdateElementRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;

    public ProfileUpdateElementRepo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.a1(str, "newValue", str2, "oldValue", str3, MessageMetaInfo.COLUMN_PATH);
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static /* synthetic */ ProfileUpdateElementRepo copy$default(ProfileUpdateElementRepo profileUpdateElementRepo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileUpdateElementRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = profileUpdateElementRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = profileUpdateElementRepo.c;
        }
        return profileUpdateElementRepo.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
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
    public final ProfileUpdateElementRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "newValue");
        Intrinsics.checkParameterIsNotNull(str2, "oldValue");
        Intrinsics.checkParameterIsNotNull(str3, MessageMetaInfo.COLUMN_PATH);
        return new ProfileUpdateElementRepo(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileUpdateElementRepo)) {
            return false;
        }
        ProfileUpdateElementRepo profileUpdateElementRepo = (ProfileUpdateElementRepo) obj;
        return Intrinsics.areEqual(this.a, profileUpdateElementRepo.a) && Intrinsics.areEqual(this.b, profileUpdateElementRepo.b) && Intrinsics.areEqual(this.c, profileUpdateElementRepo.c);
    }

    @NotNull
    public final String getNewValue() {
        return this.a;
    }

    @NotNull
    public final String getOldValue() {
        return this.b;
    }

    @NotNull
    public final String getPath() {
        return this.c;
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
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileUpdateElementRepo(newValue=");
        L.append(this.a);
        L.append(", oldValue=");
        L.append(this.b);
        L.append(", path=");
        return a.t(L, this.c, ")");
    }
}
