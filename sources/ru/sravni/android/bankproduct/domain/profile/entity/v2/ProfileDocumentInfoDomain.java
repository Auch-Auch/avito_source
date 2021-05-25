package ru.sravni.android.bankproduct.domain.profile.entity.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain$GroupDocumentInfoDomain;", "component3", "()Ljava/util/List;", "id", "title", "groups", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getGroups", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "GroupDocumentInfoDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDocumentInfoDomain {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final List<GroupDocumentInfoDomain> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain$GroupDocumentInfoDomain;", "", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "component2", "()Ljava/util/List;", "title", "listMainDetail", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDocumentInfoDomain$GroupDocumentInfoDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListMainDetail", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class GroupDocumentInfoDomain {
        @Nullable
        public final String a;
        @NotNull
        public final List<ProfileMainDetailDomain> b;

        public GroupDocumentInfoDomain(@Nullable String str, @NotNull List<ProfileMainDetailDomain> list) {
            Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
            this.a = str;
            this.b = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain$GroupDocumentInfoDomain */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupDocumentInfoDomain copy$default(GroupDocumentInfoDomain groupDocumentInfoDomain, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = groupDocumentInfoDomain.a;
            }
            if ((i & 2) != 0) {
                list = groupDocumentInfoDomain.b;
            }
            return groupDocumentInfoDomain.copy(str, list);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final List<ProfileMainDetailDomain> component2() {
            return this.b;
        }

        @NotNull
        public final GroupDocumentInfoDomain copy(@Nullable String str, @NotNull List<ProfileMainDetailDomain> list) {
            Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
            return new GroupDocumentInfoDomain(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GroupDocumentInfoDomain)) {
                return false;
            }
            GroupDocumentInfoDomain groupDocumentInfoDomain = (GroupDocumentInfoDomain) obj;
            return Intrinsics.areEqual(this.a, groupDocumentInfoDomain.a) && Intrinsics.areEqual(this.b, groupDocumentInfoDomain.b);
        }

        @NotNull
        public final List<ProfileMainDetailDomain> getListMainDetail() {
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
            List<ProfileMainDetailDomain> list = this.b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GroupDocumentInfoDomain(title=");
            L.append(this.a);
            L.append(", listMainDetail=");
            return a.w(L, this.b, ")");
        }
    }

    public ProfileDocumentInfoDomain(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDocumentInfoDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDocumentInfoDomain copy$default(ProfileDocumentInfoDomain profileDocumentInfoDomain, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDocumentInfoDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = profileDocumentInfoDomain.b;
        }
        if ((i & 4) != 0) {
            list = profileDocumentInfoDomain.c;
        }
        return profileDocumentInfoDomain.copy(str, str2, list);
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
    public final List<GroupDocumentInfoDomain> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileDocumentInfoDomain copy(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoDomain> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        return new ProfileDocumentInfoDomain(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDocumentInfoDomain)) {
            return false;
        }
        ProfileDocumentInfoDomain profileDocumentInfoDomain = (ProfileDocumentInfoDomain) obj;
        return Intrinsics.areEqual(this.a, profileDocumentInfoDomain.a) && Intrinsics.areEqual(this.b, profileDocumentInfoDomain.b) && Intrinsics.areEqual(this.c, profileDocumentInfoDomain.c);
    }

    @NotNull
    public final List<GroupDocumentInfoDomain> getGroups() {
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
        List<GroupDocumentInfoDomain> list = this.c;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDocumentInfoDomain(id=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", groups=");
        return a.w(L, this.c, ")");
    }
}
