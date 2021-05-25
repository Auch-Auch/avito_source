package ru.sravni.android.bankproduct.domain.profile.entity.v2;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001\"B+\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\b¨\u0006#"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileMainDetailDomain;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain;", "component3", "id", "listMainDetail", "listAdditionalDetail", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListMainDetail", "c", "getListAdditionalDetail", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "GroupAdditionalDetailDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDetailedInfoDomain {
    @NotNull
    public final String a;
    @NotNull
    public final List<ProfileMainDetailDomain> b;
    @NotNull
    public final List<GroupAdditionalDetailDomain> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain;", "", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain$ItemAdditionalDetailDomain;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "ItemAdditionalDetailDomain", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class GroupAdditionalDetailDomain {
        @NotNull
        public final List<ItemAdditionalDetailDomain> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJR\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain$ItemAdditionalDetailDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "description", "id", "mask", "type", "value", "showInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain$ItemAdditionalDetailDomain;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Z", "getShowInfo", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDescription", "c", "getMask", "d", "getType", AuthSource.BOOKING_ORDER, "getId", "e", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ItemAdditionalDetailDomain {
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final String c;
            @NotNull
            public final String d;
            @Nullable
            public final String e;
            public final boolean f;

            public ItemAdditionalDetailDomain(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, boolean z) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "type");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = str5;
                this.f = z;
            }

            public static /* synthetic */ ItemAdditionalDetailDomain copy$default(ItemAdditionalDetailDomain itemAdditionalDetailDomain, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemAdditionalDetailDomain.a;
                }
                if ((i & 2) != 0) {
                    str2 = itemAdditionalDetailDomain.b;
                }
                if ((i & 4) != 0) {
                    str3 = itemAdditionalDetailDomain.c;
                }
                if ((i & 8) != 0) {
                    str4 = itemAdditionalDetailDomain.d;
                }
                if ((i & 16) != 0) {
                    str5 = itemAdditionalDetailDomain.e;
                }
                if ((i & 32) != 0) {
                    z = itemAdditionalDetailDomain.f;
                }
                return itemAdditionalDetailDomain.copy(str, str2, str3, str4, str5, z);
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

            @Nullable
            public final String component5() {
                return this.e;
            }

            public final boolean component6() {
                return this.f;
            }

            @NotNull
            public final ItemAdditionalDetailDomain copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, boolean z) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "type");
                return new ItemAdditionalDetailDomain(str, str2, str3, str4, str5, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ItemAdditionalDetailDomain)) {
                    return false;
                }
                ItemAdditionalDetailDomain itemAdditionalDetailDomain = (ItemAdditionalDetailDomain) obj;
                return Intrinsics.areEqual(this.a, itemAdditionalDetailDomain.a) && Intrinsics.areEqual(this.b, itemAdditionalDetailDomain.b) && Intrinsics.areEqual(this.c, itemAdditionalDetailDomain.c) && Intrinsics.areEqual(this.d, itemAdditionalDetailDomain.d) && Intrinsics.areEqual(this.e, itemAdditionalDetailDomain.e) && this.f == itemAdditionalDetailDomain.f;
            }

            @NotNull
            public final String getDescription() {
                return this.a;
            }

            @Nullable
            public final String getId() {
                return this.b;
            }

            @Nullable
            public final String getMask() {
                return this.c;
            }

            public final boolean getShowInfo() {
                return this.f;
            }

            @NotNull
            public final String getType() {
                return this.d;
            }

            @Nullable
            public final String getValue() {
                return this.e;
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
                int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                String str5 = this.e;
                if (str5 != null) {
                    i = str5.hashCode();
                }
                int i2 = (hashCode4 + i) * 31;
                boolean z = this.f;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ItemAdditionalDetailDomain(description=");
                L.append(this.a);
                L.append(", id=");
                L.append(this.b);
                L.append(", mask=");
                L.append(this.c);
                L.append(", type=");
                L.append(this.d);
                L.append(", value=");
                L.append(this.e);
                L.append(", showInfo=");
                return a.B(L, this.f, ")");
            }
        }

        public GroupAdditionalDetailDomain(@NotNull List<ItemAdditionalDetailDomain> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.a = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain$GroupAdditionalDetailDomain */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupAdditionalDetailDomain copy$default(GroupAdditionalDetailDomain groupAdditionalDetailDomain, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = groupAdditionalDetailDomain.a;
            }
            return groupAdditionalDetailDomain.copy(list);
        }

        @NotNull
        public final List<ItemAdditionalDetailDomain> component1() {
            return this.a;
        }

        @NotNull
        public final GroupAdditionalDetailDomain copy(@NotNull List<ItemAdditionalDetailDomain> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new GroupAdditionalDetailDomain(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GroupAdditionalDetailDomain) && Intrinsics.areEqual(this.a, ((GroupAdditionalDetailDomain) obj).a);
            }
            return true;
        }

        @NotNull
        public final List<ItemAdditionalDetailDomain> getItems() {
            return this.a;
        }

        public int hashCode() {
            List<ItemAdditionalDetailDomain> list = this.a;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.w(a.L("GroupAdditionalDetailDomain(items="), this.a, ")");
        }
    }

    public ProfileDetailedInfoDomain(@NotNull String str, @NotNull List<ProfileMainDetailDomain> list, @NotNull List<GroupAdditionalDetailDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
        Intrinsics.checkParameterIsNotNull(list2, "listAdditionalDetail");
        this.a = str;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDetailedInfoDomain copy$default(ProfileDetailedInfoDomain profileDetailedInfoDomain, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDetailedInfoDomain.a;
        }
        if ((i & 2) != 0) {
            list = profileDetailedInfoDomain.b;
        }
        if ((i & 4) != 0) {
            list2 = profileDetailedInfoDomain.c;
        }
        return profileDetailedInfoDomain.copy(str, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<ProfileMainDetailDomain> component2() {
        return this.b;
    }

    @NotNull
    public final List<GroupAdditionalDetailDomain> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileDetailedInfoDomain copy(@NotNull String str, @NotNull List<ProfileMainDetailDomain> list, @NotNull List<GroupAdditionalDetailDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
        Intrinsics.checkParameterIsNotNull(list2, "listAdditionalDetail");
        return new ProfileDetailedInfoDomain(str, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDetailedInfoDomain)) {
            return false;
        }
        ProfileDetailedInfoDomain profileDetailedInfoDomain = (ProfileDetailedInfoDomain) obj;
        return Intrinsics.areEqual(this.a, profileDetailedInfoDomain.a) && Intrinsics.areEqual(this.b, profileDetailedInfoDomain.b) && Intrinsics.areEqual(this.c, profileDetailedInfoDomain.c);
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final List<GroupAdditionalDetailDomain> getListAdditionalDetail() {
        return this.c;
    }

    @NotNull
    public final List<ProfileMainDetailDomain> getListMainDetail() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ProfileMainDetailDomain> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<GroupAdditionalDetailDomain> list2 = this.c;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDetailedInfoDomain(id=");
        L.append(this.a);
        L.append(", listMainDetail=");
        L.append(this.b);
        L.append(", listAdditionalDetail=");
        return a.w(L, this.c, ")");
    }
}
