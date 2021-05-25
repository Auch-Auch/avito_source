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
import ru.sravni.android.bankproduct.domain.profile.entity.v2.ProfileDetailedInfoDomain;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b#\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ:\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u000b¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "toProfileDetailedInfoDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileMainDetailRepo;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo;", "component3", "id", "listMainDetail", "listAdditionalDetail", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListMainDetail", "c", "getListAdditionalDetail", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "GroupAdditionalDetailRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDetailedInfoRepo {
    @NotNull
    public final String a;
    @NotNull
    public final List<ProfileMainDetailRepo> b;
    @NotNull
    public final List<GroupAdditionalDetailRepo> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain;", "toGroupAdditionalDetailDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo$ItemAdditionalDetailRepo;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "ItemAdditionalDetailRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class GroupAdditionalDetailRepo {
        @NotNull
        public final List<ItemAdditionalDetailRepo> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0014\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo$ItemAdditionalDetailRepo;", "", "Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain$ItemAdditionalDetailDomain;", "toProfileDetailedInfoGroupItemDomain", "()Lru/sravni/android/bankproduct/domain/profile/entity/v2/ProfileDetailedInfoDomain$GroupAdditionalDetailDomain$ItemAdditionalDetailDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "description", "id", "mask", "type", "value", "showInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo$ItemAdditionalDetailRepo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Z", "getShowInfo", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getId", AuthSource.SEND_ABUSE, "getDescription", "c", "getMask", "d", "getType", "e", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ItemAdditionalDetailRepo {
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

            public ItemAdditionalDetailRepo(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, boolean z) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "type");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = str5;
                this.f = z;
            }

            public static /* synthetic */ ItemAdditionalDetailRepo copy$default(ItemAdditionalDetailRepo itemAdditionalDetailRepo, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemAdditionalDetailRepo.a;
                }
                if ((i & 2) != 0) {
                    str2 = itemAdditionalDetailRepo.b;
                }
                if ((i & 4) != 0) {
                    str3 = itemAdditionalDetailRepo.c;
                }
                if ((i & 8) != 0) {
                    str4 = itemAdditionalDetailRepo.d;
                }
                if ((i & 16) != 0) {
                    str5 = itemAdditionalDetailRepo.e;
                }
                if ((i & 32) != 0) {
                    z = itemAdditionalDetailRepo.f;
                }
                return itemAdditionalDetailRepo.copy(str, str2, str3, str4, str5, z);
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
            public final ItemAdditionalDetailRepo copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, boolean z) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "type");
                return new ItemAdditionalDetailRepo(str, str2, str3, str4, str5, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ItemAdditionalDetailRepo)) {
                    return false;
                }
                ItemAdditionalDetailRepo itemAdditionalDetailRepo = (ItemAdditionalDetailRepo) obj;
                return Intrinsics.areEqual(this.a, itemAdditionalDetailRepo.a) && Intrinsics.areEqual(this.b, itemAdditionalDetailRepo.b) && Intrinsics.areEqual(this.c, itemAdditionalDetailRepo.c) && Intrinsics.areEqual(this.d, itemAdditionalDetailRepo.d) && Intrinsics.areEqual(this.e, itemAdditionalDetailRepo.e) && this.f == itemAdditionalDetailRepo.f;
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
            public final ProfileDetailedInfoDomain.GroupAdditionalDetailDomain.ItemAdditionalDetailDomain toProfileDetailedInfoGroupItemDomain() {
                return new ProfileDetailedInfoDomain.GroupAdditionalDetailDomain.ItemAdditionalDetailDomain(this.a, this.b, this.c, this.d, this.e, this.f);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ItemAdditionalDetailRepo(description=");
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

        public GroupAdditionalDetailRepo(@NotNull List<ItemAdditionalDetailRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.a = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo$GroupAdditionalDetailRepo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupAdditionalDetailRepo copy$default(GroupAdditionalDetailRepo groupAdditionalDetailRepo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = groupAdditionalDetailRepo.a;
            }
            return groupAdditionalDetailRepo.copy(list);
        }

        @NotNull
        public final List<ItemAdditionalDetailRepo> component1() {
            return this.a;
        }

        @NotNull
        public final GroupAdditionalDetailRepo copy(@NotNull List<ItemAdditionalDetailRepo> list) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new GroupAdditionalDetailRepo(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof GroupAdditionalDetailRepo) && Intrinsics.areEqual(this.a, ((GroupAdditionalDetailRepo) obj).a);
            }
            return true;
        }

        @NotNull
        public final List<ItemAdditionalDetailRepo> getItems() {
            return this.a;
        }

        public int hashCode() {
            List<ItemAdditionalDetailRepo> list = this.a;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public final ProfileDetailedInfoDomain.GroupAdditionalDetailDomain toGroupAdditionalDetailDomain() {
            List<ItemAdditionalDetailRepo> list = this.a;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toProfileDetailedInfoGroupItemDomain());
            }
            return new ProfileDetailedInfoDomain.GroupAdditionalDetailDomain(arrayList);
        }

        @NotNull
        public String toString() {
            return a.w(a.L("GroupAdditionalDetailRepo(items="), this.a, ")");
        }
    }

    public ProfileDetailedInfoRepo(@NotNull String str, @NotNull List<ProfileMainDetailRepo> list, @NotNull List<GroupAdditionalDetailRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
        Intrinsics.checkParameterIsNotNull(list2, "listAdditionalDetail");
        this.a = str;
        this.b = list;
        this.c = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileDetailedInfoRepo copy$default(ProfileDetailedInfoRepo profileDetailedInfoRepo, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileDetailedInfoRepo.a;
        }
        if ((i & 2) != 0) {
            list = profileDetailedInfoRepo.b;
        }
        if ((i & 4) != 0) {
            list2 = profileDetailedInfoRepo.c;
        }
        return profileDetailedInfoRepo.copy(str, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<ProfileMainDetailRepo> component2() {
        return this.b;
    }

    @NotNull
    public final List<GroupAdditionalDetailRepo> component3() {
        return this.c;
    }

    @NotNull
    public final ProfileDetailedInfoRepo copy(@NotNull String str, @NotNull List<ProfileMainDetailRepo> list, @NotNull List<GroupAdditionalDetailRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
        Intrinsics.checkParameterIsNotNull(list2, "listAdditionalDetail");
        return new ProfileDetailedInfoRepo(str, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDetailedInfoRepo)) {
            return false;
        }
        ProfileDetailedInfoRepo profileDetailedInfoRepo = (ProfileDetailedInfoRepo) obj;
        return Intrinsics.areEqual(this.a, profileDetailedInfoRepo.a) && Intrinsics.areEqual(this.b, profileDetailedInfoRepo.b) && Intrinsics.areEqual(this.c, profileDetailedInfoRepo.c);
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final List<GroupAdditionalDetailRepo> getListAdditionalDetail() {
        return this.c;
    }

    @NotNull
    public final List<ProfileMainDetailRepo> getListMainDetail() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ProfileMainDetailRepo> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<GroupAdditionalDetailRepo> list2 = this.c;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public final ProfileDetailedInfoDomain toProfileDetailedInfoDomain() {
        String str = this.a;
        List<ProfileMainDetailRepo> list = this.b;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toProfileMainDetailDomain());
        }
        List<GroupAdditionalDetailRepo> list2 = this.c;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().toGroupAdditionalDetailDomain());
        }
        return new ProfileDetailedInfoDomain(str, arrayList, arrayList2);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDetailedInfoRepo(id=");
        L.append(this.a);
        L.append(", listMainDetail=");
        L.append(this.b);
        L.append(", listAdditionalDetail=");
        return a.w(L, this.c, ")");
    }
}
