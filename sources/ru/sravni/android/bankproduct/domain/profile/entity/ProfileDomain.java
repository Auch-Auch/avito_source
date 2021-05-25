package ru.sravni.android.bankproduct.domain.profile.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileCommonDomain;", "component1", "()Lru/sravni/android/bankproduct/domain/profile/entity/ProfileCommonDomain;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDocumentDomain;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileNoteDomain;", "component3", "profileCommonDomain", "docList", "noteList", "copy", "(Lru/sravni/android/bankproduct/domain/profile/entity/ProfileCommonDomain;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileCommonDomain;", "getProfileCommonDomain", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDocList", "c", "getNoteList", "<init>", "(Lru/sravni/android/bankproduct/domain/profile/entity/ProfileCommonDomain;Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDomain {
    @NotNull
    public final ProfileCommonDomain a;
    @NotNull
    public final List<ProfileDocumentDomain> b;
    @NotNull
    public final List<ProfileNoteDomain> c;

    public ProfileDomain(@NotNull ProfileCommonDomain profileCommonDomain, @NotNull List<ProfileDocumentDomain> list, @NotNull List<ProfileNoteDomain> list2) {
        Intrinsics.checkParameterIsNotNull(profileCommonDomain, "profileCommonDomain");
        Intrinsics.checkParameterIsNotNull(list, "docList");
        Intrinsics.checkParameterIsNotNull(list2, "noteList");
        this.a = profileCommonDomain;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDomain copy$default(ProfileDomain profileDomain, ProfileCommonDomain profileCommonDomain, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            profileCommonDomain = profileDomain.a;
        }
        if ((i & 2) != 0) {
            list = profileDomain.b;
        }
        if ((i & 4) != 0) {
            list2 = profileDomain.c;
        }
        return profileDomain.copy(profileCommonDomain, list, list2);
    }

    @NotNull
    public final ProfileCommonDomain component1() {
        return this.a;
    }

    @NotNull
    public final List<ProfileDocumentDomain> component2() {
        return this.b;
    }

    @NotNull
    public final List<ProfileNoteDomain> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileDomain copy(@NotNull ProfileCommonDomain profileCommonDomain, @NotNull List<ProfileDocumentDomain> list, @NotNull List<ProfileNoteDomain> list2) {
        Intrinsics.checkParameterIsNotNull(profileCommonDomain, "profileCommonDomain");
        Intrinsics.checkParameterIsNotNull(list, "docList");
        Intrinsics.checkParameterIsNotNull(list2, "noteList");
        return new ProfileDomain(profileCommonDomain, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDomain)) {
            return false;
        }
        ProfileDomain profileDomain = (ProfileDomain) obj;
        return Intrinsics.areEqual(this.a, profileDomain.a) && Intrinsics.areEqual(this.b, profileDomain.b) && Intrinsics.areEqual(this.c, profileDomain.c);
    }

    @NotNull
    public final List<ProfileDocumentDomain> getDocList() {
        return this.b;
    }

    @NotNull
    public final List<ProfileNoteDomain> getNoteList() {
        return this.c;
    }

    @NotNull
    public final ProfileCommonDomain getProfileCommonDomain() {
        return this.a;
    }

    public int hashCode() {
        ProfileCommonDomain profileCommonDomain = this.a;
        int i = 0;
        int hashCode = (profileCommonDomain != null ? profileCommonDomain.hashCode() : 0) * 31;
        List<ProfileDocumentDomain> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ProfileNoteDomain> list2 = this.c;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDomain(profileCommonDomain=");
        L.append(this.a);
        L.append(", docList=");
        L.append(this.b);
        L.append(", noteList=");
        return a.w(L, this.c, ")");
    }
}
