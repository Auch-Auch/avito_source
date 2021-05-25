package ru.sravni.android.bankproduct.domain.profile.entity.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain;", "", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group;", "component2", "()Ljava/util/List;", "id", "groups", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getGroups", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Group", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDetailedDocumentDomain {
    @NotNull
    public final String a;
    @NotNull
    public final List<Group> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group;", "", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group$Item;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "items", "title", "copy", "(Ljava/util/List;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Group {
        @NotNull
        public final List<Item> a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group$Item;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "description", "mask", "fullName", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedDocumentDomain$Group$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDescription", "d", "getValue", "c", "getFullName", AuthSource.BOOKING_ORDER, "getMask", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class Item {
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final String c;
            @NotNull
            public final String d;

            public Item(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "value");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
            }

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.a;
                }
                if ((i & 2) != 0) {
                    str2 = item.b;
                }
                if ((i & 4) != 0) {
                    str3 = item.c;
                }
                if ((i & 8) != 0) {
                    str4 = item.d;
                }
                return item.copy(str, str2, str3, str4);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final String component4() {
                return this.d;
            }

            @NotNull
            public final Item copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "value");
                return new Item(str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Item)) {
                    return false;
                }
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.a, item.a) && Intrinsics.areEqual(this.b, item.b) && Intrinsics.areEqual(this.c, item.c) && Intrinsics.areEqual(this.d, item.d);
            }

            @NotNull
            public final String getDescription() {
                return this.a;
            }

            @Nullable
            public final String getFullName() {
                return this.c;
            }

            @Nullable
            public final String getMask() {
                return this.b;
            }

            @NotNull
            public final String getValue() {
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
                StringBuilder L = a.L("Item(description=");
                L.append(this.a);
                L.append(", mask=");
                L.append(this.b);
                L.append(", fullName=");
                L.append(this.c);
                L.append(", value=");
                return a.t(L, this.d, ")");
            }
        }

        public Group(@NotNull List<Item> list, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.a = list;
            this.b = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedDocumentDomain$Group */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Group copy$default(Group group, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = group.a;
            }
            if ((i & 2) != 0) {
                str = group.b;
            }
            return group.copy(list, str);
        }

        @NotNull
        public final List<Item> component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Group copy(@NotNull List<Item> list, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new Group(list, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Group)) {
                return false;
            }
            Group group = (Group) obj;
            return Intrinsics.areEqual(this.a, group.a) && Intrinsics.areEqual(this.b, group.b);
        }

        @NotNull
        public final List<Item> getItems() {
            return this.a;
        }

        @Nullable
        public final String getTitle() {
            return this.b;
        }

        public int hashCode() {
            List<Item> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Group(items=");
            L.append(this.a);
            L.append(", title=");
            return a.t(L, this.b, ")");
        }
    }

    public ProfileDetailedDocumentDomain(@NotNull String str, @NotNull List<Group> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        this.a = str;
        this.b = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedDocumentDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDetailedDocumentDomain copy$default(ProfileDetailedDocumentDomain profileDetailedDocumentDomain, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDetailedDocumentDomain.a;
        }
        if ((i & 2) != 0) {
            list = profileDetailedDocumentDomain.b;
        }
        return profileDetailedDocumentDomain.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<Group> component2() {
        return this.b;
    }

    @NotNull
    public final ProfileDetailedDocumentDomain copy(@NotNull String str, @NotNull List<Group> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        return new ProfileDetailedDocumentDomain(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDetailedDocumentDomain)) {
            return false;
        }
        ProfileDetailedDocumentDomain profileDetailedDocumentDomain = (ProfileDetailedDocumentDomain) obj;
        return Intrinsics.areEqual(this.a, profileDetailedDocumentDomain.a) && Intrinsics.areEqual(this.b, profileDetailedDocumentDomain.b);
    }

    @NotNull
    public final List<Group> getGroups() {
        return this.b;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Group> list = this.b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDetailedDocumentDomain(id=");
        L.append(this.a);
        L.append(", groups=");
        return a.w(L, this.b, ")");
    }
}
