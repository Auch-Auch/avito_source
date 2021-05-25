package ru.sravni.android.bankproduct.network.profile.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileCommonRepo;
import ru.sravni.android.bankproduct.repository.profile.entity.ProfileElementFieldRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\r\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001d\u0010\u000b¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/Common;", "", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "toRepoElementList", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;", "toProfileCommonRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "component2", "email", "phone", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)Lru/sravni/android/bankproduct/network/profile/response/Common;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;", "getPhone", "getEmail", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;Lru/sravni/android/bankproduct/network/profile/response/AccountElementResponse;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Common {
    @SerializedName("email")
    @NotNull
    private final AccountElementResponse email;
    @SerializedName("phone")
    @NotNull
    private final AccountElementResponse phone;

    public Common(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "email");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, "phone");
        this.email = accountElementResponse;
        this.phone = accountElementResponse2;
    }

    public static /* synthetic */ Common copy$default(Common common, AccountElementResponse accountElementResponse, AccountElementResponse accountElementResponse2, int i, Object obj) {
        if ((i & 1) != 0) {
            accountElementResponse = common.email;
        }
        if ((i & 2) != 0) {
            accountElementResponse2 = common.phone;
        }
        return common.copy(accountElementResponse, accountElementResponse2);
    }

    private final List<ProfileElementFieldRepo> toRepoElementList() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new ProfileElementFieldRepo[]{this.email.toProfileElementFieldRepo("email"), this.phone.toProfileElementFieldRepo("phone")});
    }

    @NotNull
    public final AccountElementResponse component1() {
        return this.email;
    }

    @NotNull
    public final AccountElementResponse component2() {
        return this.phone;
    }

    @NotNull
    public final Common copy(@NotNull AccountElementResponse accountElementResponse, @NotNull AccountElementResponse accountElementResponse2) {
        Intrinsics.checkParameterIsNotNull(accountElementResponse, "email");
        Intrinsics.checkParameterIsNotNull(accountElementResponse2, "phone");
        return new Common(accountElementResponse, accountElementResponse2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Common)) {
            return false;
        }
        Common common = (Common) obj;
        return Intrinsics.areEqual(this.email, common.email) && Intrinsics.areEqual(this.phone, common.phone);
    }

    @NotNull
    public final AccountElementResponse getEmail() {
        return this.email;
    }

    @NotNull
    public final AccountElementResponse getPhone() {
        return this.phone;
    }

    public int hashCode() {
        AccountElementResponse accountElementResponse = this.email;
        int i = 0;
        int hashCode = (accountElementResponse != null ? accountElementResponse.hashCode() : 0) * 31;
        AccountElementResponse accountElementResponse2 = this.phone;
        if (accountElementResponse2 != null) {
            i = accountElementResponse2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final ProfileCommonRepo toProfileCommonRepo() {
        return new ProfileCommonRepo(toRepoElementList());
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Common(email=");
        L.append(this.email);
        L.append(", phone=");
        L.append(this.phone);
        L.append(")");
        return L.toString();
    }
}
