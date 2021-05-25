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
import ru.sravni.android.bankproduct.domain.profile.entity.ProfileDocumentDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDocumentDomain;", "toDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/ProfileDocumentDomain;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/ProfileElementFieldRepo;", "component1", "()Ljava/util/List;", "documentFields", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/ProfileDocumentRepo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDocumentFields", "<init>", "(Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDocumentRepo {
    @NotNull
    public final List<ProfileElementFieldRepo> a;

    public ProfileDocumentRepo(@NotNull List<ProfileElementFieldRepo> list) {
        Intrinsics.checkParameterIsNotNull(list, "documentFields");
        this.a = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.ProfileDocumentRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDocumentRepo copy$default(ProfileDocumentRepo profileDocumentRepo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = profileDocumentRepo.a;
        }
        return profileDocumentRepo.copy(list);
    }

    @NotNull
    public final List<ProfileElementFieldRepo> component1() {
        return this.a;
    }

    @NotNull
    public final ProfileDocumentRepo copy(@NotNull List<ProfileElementFieldRepo> list) {
        Intrinsics.checkParameterIsNotNull(list, "documentFields");
        return new ProfileDocumentRepo(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ProfileDocumentRepo) && Intrinsics.areEqual(this.a, ((ProfileDocumentRepo) obj).a);
        }
        return true;
    }

    @NotNull
    public final List<ProfileElementFieldRepo> getDocumentFields() {
        return this.a;
    }

    public int hashCode() {
        List<ProfileElementFieldRepo> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public final ProfileDocumentDomain toDomain() {
        List<ProfileElementFieldRepo> list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDomain());
        }
        return new ProfileDocumentDomain(arrayList);
    }

    @NotNull
    public String toString() {
        return a.w(a.L("ProfileDocumentRepo(documentFields="), this.a, ")");
    }
}
