package ru.sravni.android.bankproduct.repository.profile.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileCommonDomain;
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ:\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "toDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDomain;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;", "component1", "()Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "component3", "profileCommon", "docList", "noteList", "copy", "(Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileRepo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getDocList", "c", "getNoteList", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;", "getProfileCommon", "<init>", "(Lru/sravni/android/bankproduct/repository/profile/entity/ProfileCommonRepo;Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileRepo {
    @NotNull
    public final ProfileCommonRepo a;
    @NotNull
    public final List<ProfileDocumentRepo> b;
    @NotNull
    public final List<ProfileNoteRepo> c;

    public ProfileRepo(@NotNull ProfileCommonRepo profileCommonRepo, @NotNull List<ProfileDocumentRepo> list, @NotNull List<ProfileNoteRepo> list2) {
        Intrinsics.checkParameterIsNotNull(profileCommonRepo, "profileCommon");
        Intrinsics.checkParameterIsNotNull(list, "docList");
        Intrinsics.checkParameterIsNotNull(list2, "noteList");
        this.a = profileCommonRepo;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.ProfileRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileRepo copy$default(ProfileRepo profileRepo, ProfileCommonRepo profileCommonRepo, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            profileCommonRepo = profileRepo.a;
        }
        if ((i & 2) != 0) {
            list = profileRepo.b;
        }
        if ((i & 4) != 0) {
            list2 = profileRepo.c;
        }
        return profileRepo.copy(profileCommonRepo, list, list2);
    }

    @NotNull
    public final ProfileCommonRepo component1() {
        return this.a;
    }

    @NotNull
    public final List<ProfileDocumentRepo> component2() {
        return this.b;
    }

    @NotNull
    public final List<ProfileNoteRepo> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileRepo copy(@NotNull ProfileCommonRepo profileCommonRepo, @NotNull List<ProfileDocumentRepo> list, @NotNull List<ProfileNoteRepo> list2) {
        Intrinsics.checkParameterIsNotNull(profileCommonRepo, "profileCommon");
        Intrinsics.checkParameterIsNotNull(list, "docList");
        Intrinsics.checkParameterIsNotNull(list2, "noteList");
        return new ProfileRepo(profileCommonRepo, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileRepo)) {
            return false;
        }
        ProfileRepo profileRepo = (ProfileRepo) obj;
        return Intrinsics.areEqual(this.a, profileRepo.a) && Intrinsics.areEqual(this.b, profileRepo.b) && Intrinsics.areEqual(this.c, profileRepo.c);
    }

    @NotNull
    public final List<ProfileDocumentRepo> getDocList() {
        return this.b;
    }

    @NotNull
    public final List<ProfileNoteRepo> getNoteList() {
        return this.c;
    }

    @NotNull
    public final ProfileCommonRepo getProfileCommon() {
        return this.a;
    }

    public int hashCode() {
        ProfileCommonRepo profileCommonRepo = this.a;
        int i = 0;
        int hashCode = (profileCommonRepo != null ? profileCommonRepo.hashCode() : 0) * 31;
        List<ProfileDocumentRepo> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ProfileNoteRepo> list2 = this.c;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public final ProfileDomain toDomain() {
        ProfileCommonDomain domain = this.a.toDomain();
        List<ProfileDocumentRepo> list = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDomain());
        }
        List<ProfileNoteRepo> list2 = this.c;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().toDomain());
        }
        return new ProfileDomain(domain, arrayList, arrayList2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileRepo(profileCommon=");
        L.append(this.a);
        L.append(", docList=");
        L.append(this.b);
        L.append(", noteList=");
        return a.w(L, this.c, ")");
    }
}
