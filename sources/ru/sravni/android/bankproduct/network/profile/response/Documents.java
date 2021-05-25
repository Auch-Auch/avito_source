package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileDocumentRepo;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/Documents;", "", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "toDocListRepo", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/profile/response/Passport;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/Passport;", "passport", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/Passport;)Lru/sravni/android/bankproduct/network/profile/response/Documents;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/Passport;", "getPassport", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/Passport;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Documents {
    @SerializedName("passport")
    @NotNull
    private final Passport passport;

    public Documents(@NotNull Passport passport2) {
        Intrinsics.checkParameterIsNotNull(passport2, "passport");
        this.passport = passport2;
    }

    public static /* synthetic */ Documents copy$default(Documents documents, Passport passport2, int i, Object obj) {
        if ((i & 1) != 0) {
            passport2 = documents.passport;
        }
        return documents.copy(passport2);
    }

    @NotNull
    public final Passport component1() {
        return this.passport;
    }

    @NotNull
    public final Documents copy(@NotNull Passport passport2) {
        Intrinsics.checkParameterIsNotNull(passport2, "passport");
        return new Documents(passport2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof Documents) && Intrinsics.areEqual(this.passport, ((Documents) obj).passport);
        }
        return true;
    }

    @NotNull
    public final Passport getPassport() {
        return this.passport;
    }

    public int hashCode() {
        Passport passport2 = this.passport;
        if (passport2 != null) {
            return passport2.hashCode();
        }
        return 0;
    }

    @NotNull
    public final List<ProfileDocumentRepo> toDocListRepo() {
        return d.listOf(this.passport.toProfileDocumentRepo());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Documents(passport=");
        L.append(this.passport);
        L.append(")");
        return L.toString();
    }
}
