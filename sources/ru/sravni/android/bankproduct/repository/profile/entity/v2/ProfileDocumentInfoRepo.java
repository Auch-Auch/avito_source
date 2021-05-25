package ru.sravni.android.bankproduct.repository.profile.entity.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001$B%\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0007¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "toProfileDocumentInfoDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo$GroupDocumentInfoRepo;", "component3", "()Ljava/util/List;", "id", "title", "groups", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "c", "Ljava/util/List;", "getGroups", AuthSource.SEND_ABUSE, "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "GroupDocumentInfoRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDocumentInfoRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final List<GroupDocumentInfoRepo> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo$GroupDocumentInfoRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain$GroupDocumentInfoDomain;", "toDetailedDocumentGroupDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain$GroupDocumentInfoDomain;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "component2", "()Ljava/util/List;", "title", "listMainDetail", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo$GroupDocumentInfoRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListMainDetail", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class GroupDocumentInfoRepo {
        @Nullable
        public final String a;
        @NotNull
        public final List<ProfileMainDetailRepo> b;

        public GroupDocumentInfoRepo(@Nullable String str, @NotNull List<ProfileMainDetailRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
            this.a = str;
            this.b = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo$GroupDocumentInfoRepo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupDocumentInfoRepo copy$default(GroupDocumentInfoRepo groupDocumentInfoRepo, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = groupDocumentInfoRepo.a;
            }
            if ((i & 2) != 0) {
                list = groupDocumentInfoRepo.b;
            }
            return groupDocumentInfoRepo.copy(str, list);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final List<ProfileMainDetailRepo> component2() {
            return this.b;
        }

        @NotNull
        public final GroupDocumentInfoRepo copy(@Nullable String str, @NotNull List<ProfileMainDetailRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
            return new GroupDocumentInfoRepo(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GroupDocumentInfoRepo)) {
                return false;
            }
            GroupDocumentInfoRepo groupDocumentInfoRepo = (GroupDocumentInfoRepo) obj;
            return Intrinsics.areEqual(this.a, groupDocumentInfoRepo.a) && Intrinsics.areEqual(this.b, groupDocumentInfoRepo.b);
        }

        @NotNull
        public final List<ProfileMainDetailRepo> getListMainDetail() {
            return this.b;
        }

        @Nullable
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<ProfileMainDetailRepo> list = this.b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public final ProfileDocumentInfoDomain.GroupDocumentInfoDomain toDetailedDocumentGroupDomain() {
            String str = this.a;
            List<ProfileMainDetailRepo> list = this.b;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toProfileMainDetailDomain());
            }
            return new ProfileDocumentInfoDomain.GroupDocumentInfoDomain(str, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GroupDocumentInfoRepo(title=");
            L.append(this.a);
            L.append(", listMainDetail=");
            return a.w(L, this.b, ")");
        }
    }

    public ProfileDocumentInfoRepo(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDocumentInfoRepo copy$default(ProfileDocumentInfoRepo profileDocumentInfoRepo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDocumentInfoRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = profileDocumentInfoRepo.b;
        }
        if ((i & 4) != 0) {
            list = profileDocumentInfoRepo.c;
        }
        return profileDocumentInfoRepo.copy(str, str2, list);
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
    public final List<GroupDocumentInfoRepo> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileDocumentInfoRepo copy(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        return new ProfileDocumentInfoRepo(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDocumentInfoRepo)) {
            return false;
        }
        ProfileDocumentInfoRepo profileDocumentInfoRepo = (ProfileDocumentInfoRepo) obj;
        return Intrinsics.areEqual(this.a, profileDocumentInfoRepo.a) && Intrinsics.areEqual(this.b, profileDocumentInfoRepo.b) && Intrinsics.areEqual(this.c, profileDocumentInfoRepo.c);
    }

    @NotNull
    public final List<GroupDocumentInfoRepo> getGroups() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<GroupDocumentInfoRepo> list = this.c;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public final ProfileDocumentInfoDomain toProfileDocumentInfoDomain() {
        String str = this.a;
        String str2 = this.b;
        List<GroupDocumentInfoRepo> list = this.c;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDetailedDocumentGroupDomain());
        }
        return new ProfileDocumentInfoDomain(str, str2, arrayList);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDocumentInfoRepo(id=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", groups=");
        return a.w(L, this.c, ")");
    }
}
