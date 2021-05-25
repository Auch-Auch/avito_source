package ru.sravni.android.bankproduct.domain.profile.entity.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0002#$B+\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ:\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\tR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0005¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$AccountDetailDomain;", "component1", "()Ljava/util/List;", "component2", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;", "component3", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;", "cars", "documents", VKApiUserFull.PERSONAL, "copy", "(Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;", "getPersonal", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDocuments", AuthSource.SEND_ABUSE, "getCars", "<init>", "(Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;)V", "AccountDetailDomain", "Personal", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileV2Domain {
    @NotNull
    public final List<AccountDetailDomain> a;
    @NotNull
    public final List<AccountDetailDomain> b;
    @NotNull
    public final Personal c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$AccountDetailDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "id", "text", "title", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$AccountDetailDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "d", "getType", "c", "getTitle", AuthSource.BOOKING_ORDER, "getText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class AccountDetailDomain {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;

        public AccountDetailDomain(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
            a.a1(str, "id", str2, "text", str3, "title");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public static /* synthetic */ AccountDetailDomain copy$default(AccountDetailDomain accountDetailDomain, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = accountDetailDomain.a;
            }
            if ((i & 2) != 0) {
                str2 = accountDetailDomain.b;
            }
            if ((i & 4) != 0) {
                str3 = accountDetailDomain.c;
            }
            if ((i & 8) != 0) {
                str4 = accountDetailDomain.d;
            }
            return accountDetailDomain.copy(str, str2, str3, str4);
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

        @Nullable
        public final String component4() {
            return this.d;
        }

        @NotNull
        public final AccountDetailDomain copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(str2, "text");
            Intrinsics.checkParameterIsNotNull(str3, "title");
            return new AccountDetailDomain(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AccountDetailDomain)) {
                return false;
            }
            AccountDetailDomain accountDetailDomain = (AccountDetailDomain) obj;
            return Intrinsics.areEqual(this.a, accountDetailDomain.a) && Intrinsics.areEqual(this.b, accountDetailDomain.b) && Intrinsics.areEqual(this.c, accountDetailDomain.c) && Intrinsics.areEqual(this.d, accountDetailDomain.d);
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }

        @Nullable
        public final String getType() {
            return this.d;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("AccountDetailDomain(id=");
            L.append(this.a);
            L.append(", text=");
            L.append(this.b);
            L.append(", title=");
            L.append(this.c);
            L.append(", type=");
            return a.t(L, this.d, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;", "", "", "component1", "()Ljava/lang/String;", "name", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileV2Domain$Personal;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Personal {
        @Nullable
        public final String a;

        public Personal(@Nullable String str) {
            this.a = str;
        }

        public static /* synthetic */ Personal copy$default(Personal personal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = personal.a;
            }
            return personal.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Personal copy(@Nullable String str) {
            return new Personal(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Personal) && Intrinsics.areEqual(this.a, ((Personal) obj).a);
            }
            return true;
        }

        @Nullable
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
            return a.t(a.L("Personal(name="), this.a, ")");
        }
    }

    public ProfileV2Domain(@NotNull List<AccountDetailDomain> list, @NotNull List<AccountDetailDomain> list2, @NotNull Personal personal) {
        Intrinsics.checkParameterIsNotNull(list, "cars");
        Intrinsics.checkParameterIsNotNull(list2, "documents");
        Intrinsics.checkParameterIsNotNull(personal, VKApiUserFull.PERSONAL);
        this.a = list;
        this.b = list2;
        this.c = personal;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileV2Domain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileV2Domain copy$default(ProfileV2Domain profileV2Domain, List list, List list2, Personal personal, int i, Object obj) {
        if ((i & 1) != 0) {
            list = profileV2Domain.a;
        }
        if ((i & 2) != 0) {
            list2 = profileV2Domain.b;
        }
        if ((i & 4) != 0) {
            personal = profileV2Domain.c;
        }
        return profileV2Domain.copy(list, list2, personal);
    }

    @NotNull
    public final List<AccountDetailDomain> component1() {
        return this.a;
    }

    @NotNull
    public final List<AccountDetailDomain> component2() {
        return this.b;
    }

    @NotNull
    public final Personal component3() {
        return this.c;
    }

    @NotNull
    public final ProfileV2Domain copy(@NotNull List<AccountDetailDomain> list, @NotNull List<AccountDetailDomain> list2, @NotNull Personal personal) {
        Intrinsics.checkParameterIsNotNull(list, "cars");
        Intrinsics.checkParameterIsNotNull(list2, "documents");
        Intrinsics.checkParameterIsNotNull(personal, VKApiUserFull.PERSONAL);
        return new ProfileV2Domain(list, list2, personal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileV2Domain)) {
            return false;
        }
        ProfileV2Domain profileV2Domain = (ProfileV2Domain) obj;
        return Intrinsics.areEqual(this.a, profileV2Domain.a) && Intrinsics.areEqual(this.b, profileV2Domain.b) && Intrinsics.areEqual(this.c, profileV2Domain.c);
    }

    @NotNull
    public final List<AccountDetailDomain> getCars() {
        return this.a;
    }

    @NotNull
    public final List<AccountDetailDomain> getDocuments() {
        return this.b;
    }

    @NotNull
    public final Personal getPersonal() {
        return this.c;
    }

    public int hashCode() {
        List<AccountDetailDomain> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<AccountDetailDomain> list2 = this.b;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Personal personal = this.c;
        if (personal != null) {
            i = personal.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileV2Domain(cars=");
        L.append(this.a);
        L.append(", documents=");
        L.append(this.b);
        L.append(", personal=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
