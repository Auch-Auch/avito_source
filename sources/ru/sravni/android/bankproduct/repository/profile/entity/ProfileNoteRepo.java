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
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileNoteDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileNoteDomain;", "toDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/ProfileNoteDomain;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "component2", "()Ljava/util/List;", "companyName", "noteFields", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileNoteRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getNoteFields", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCompanyName", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileNoteRepo {
    @NotNull
    public final String a;
    @NotNull
    public final List<ProfileElementFieldRepo> b;

    public ProfileNoteRepo(@NotNull String str, @NotNull List<ProfileElementFieldRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "companyName");
        Intrinsics.checkParameterIsNotNull(list, "noteFields");
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.ProfileNoteRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileNoteRepo copy$default(ProfileNoteRepo profileNoteRepo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileNoteRepo.a;
        }
        if ((i & 2) != 0) {
            list = profileNoteRepo.b;
        }
        return profileNoteRepo.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<ProfileElementFieldRepo> component2() {
        return this.b;
    }

    @NotNull
    public final ProfileNoteRepo copy(@NotNull String str, @NotNull List<ProfileElementFieldRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "companyName");
        Intrinsics.checkParameterIsNotNull(list, "noteFields");
        return new ProfileNoteRepo(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileNoteRepo)) {
            return false;
        }
        ProfileNoteRepo profileNoteRepo = (ProfileNoteRepo) obj;
        return Intrinsics.areEqual(this.a, profileNoteRepo.a) && Intrinsics.areEqual(this.b, profileNoteRepo.b);
    }

    @NotNull
    public final String getCompanyName() {
        return this.a;
    }

    @NotNull
    public final List<ProfileElementFieldRepo> getNoteFields() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ProfileElementFieldRepo> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final ProfileNoteDomain toDomain() {
        String str = this.a;
        List<ProfileElementFieldRepo> list = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDomain());
        }
        return new ProfileNoteDomain(str, arrayList);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileNoteRepo(companyName=");
        L.append(this.a);
        L.append(", noteFields=");
        return a.w(L, this.b, ")");
    }
}
