package ru.sravni.android.bankproduct.network.profile.response.v2;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDocumentInfoRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;", "item", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;)V", "ItemResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDocumentInfoResponse {
    @SerializedName("item")
    @NotNull
    private final ItemResponse item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001e\u0010\u0007¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "toProfileDocumentInfoRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse$GroupDocumentInfoResponse;", "component3", "()Ljava/util/List;", "id", "title", "groups", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ljava/util/List;", "getGroups", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "GroupDocumentInfoResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ItemResponse {
        @SerializedName("groups")
        @NotNull
        private final List<GroupDocumentInfoResponse> groups;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse$GroupDocumentInfoResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo$GroupDocumentInfoRepo;", "toGroupDocumentInfoRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDocumentInfoRepo$GroupDocumentInfoRepo;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse;", "component2", "()Ljava/util/List;", "title", "listMainDetail", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse$ItemResponse$GroupDocumentInfoResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getListMainDetail", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class GroupDocumentInfoResponse {
            @SerializedName("items")
            @NotNull
            private final List<ProfileMainInfoResponse> listMainDetail;
            @SerializedName("title")
            @Nullable
            private final String title;

            public GroupDocumentInfoResponse(@Nullable String str, @NotNull List<ProfileMainInfoResponse> list) {
                Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
                this.title = str;
                this.listMainDetail = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDocumentInfoResponse$ItemResponse$GroupDocumentInfoResponse */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ GroupDocumentInfoResponse copy$default(GroupDocumentInfoResponse groupDocumentInfoResponse, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = groupDocumentInfoResponse.title;
                }
                if ((i & 2) != 0) {
                    list = groupDocumentInfoResponse.listMainDetail;
                }
                return groupDocumentInfoResponse.copy(str, list);
            }

            @Nullable
            public final String component1() {
                return this.title;
            }

            @NotNull
            public final List<ProfileMainInfoResponse> component2() {
                return this.listMainDetail;
            }

            @NotNull
            public final GroupDocumentInfoResponse copy(@Nullable String str, @NotNull List<ProfileMainInfoResponse> list) {
                Intrinsics.checkParameterIsNotNull(list, "listMainDetail");
                return new GroupDocumentInfoResponse(str, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GroupDocumentInfoResponse)) {
                    return false;
                }
                GroupDocumentInfoResponse groupDocumentInfoResponse = (GroupDocumentInfoResponse) obj;
                return Intrinsics.areEqual(this.title, groupDocumentInfoResponse.title) && Intrinsics.areEqual(this.listMainDetail, groupDocumentInfoResponse.listMainDetail);
            }

            @NotNull
            public final List<ProfileMainInfoResponse> getListMainDetail() {
                return this.listMainDetail;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                String str = this.title;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<ProfileMainInfoResponse> list = this.listMainDetail;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public final ProfileDocumentInfoRepo.GroupDocumentInfoRepo toGroupDocumentInfoRepo() {
                String str = this.title;
                List<ProfileMainInfoResponse> list = this.listMainDetail;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toProfileMainDetailRepo());
                }
                return new ProfileDocumentInfoRepo.GroupDocumentInfoRepo(str, arrayList);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("GroupDocumentInfoResponse(title=");
                L.append(this.title);
                L.append(", listMainDetail=");
                return a.w(L, this.listMainDetail, ")");
            }
        }

        public ItemResponse(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(str2, "title");
            Intrinsics.checkParameterIsNotNull(list, "groups");
            this.id = str;
            this.title = str2;
            this.groups = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDocumentInfoResponse$ItemResponse */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemResponse copy$default(ItemResponse itemResponse, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemResponse.id;
            }
            if ((i & 2) != 0) {
                str2 = itemResponse.title;
            }
            if ((i & 4) != 0) {
                list = itemResponse.groups;
            }
            return itemResponse.copy(str, str2, list);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final List<GroupDocumentInfoResponse> component3() {
            return this.groups;
        }

        @NotNull
        public final ItemResponse copy(@NotNull String str, @NotNull String str2, @NotNull List<GroupDocumentInfoResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(str2, "title");
            Intrinsics.checkParameterIsNotNull(list, "groups");
            return new ItemResponse(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemResponse)) {
                return false;
            }
            ItemResponse itemResponse = (ItemResponse) obj;
            return Intrinsics.areEqual(this.id, itemResponse.id) && Intrinsics.areEqual(this.title, itemResponse.title) && Intrinsics.areEqual(this.groups, itemResponse.groups);
        }

        @NotNull
        public final List<GroupDocumentInfoResponse> getGroups() {
            return this.groups;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<GroupDocumentInfoResponse> list = this.groups;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public final ProfileDocumentInfoRepo toProfileDocumentInfoRepo() {
            String str = this.id;
            String str2 = this.title;
            List<GroupDocumentInfoResponse> list = this.groups;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toGroupDocumentInfoRepo());
            }
            return new ProfileDocumentInfoRepo(str, str2, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemResponse(id=");
            L.append(this.id);
            L.append(", title=");
            L.append(this.title);
            L.append(", groups=");
            return a.w(L, this.groups, ")");
        }
    }

    public ProfileDocumentInfoResponse(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        this.item = itemResponse;
    }

    public static /* synthetic */ ProfileDocumentInfoResponse copy$default(ProfileDocumentInfoResponse profileDocumentInfoResponse, ItemResponse itemResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            itemResponse = profileDocumentInfoResponse.item;
        }
        return profileDocumentInfoResponse.copy(itemResponse);
    }

    @NotNull
    public final ItemResponse component1() {
        return this.item;
    }

    @NotNull
    public final ProfileDocumentInfoResponse copy(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        return new ProfileDocumentInfoResponse(itemResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ProfileDocumentInfoResponse) && Intrinsics.areEqual(this.item, ((ProfileDocumentInfoResponse) obj).item);
        }
        return true;
    }

    @NotNull
    public final ItemResponse getItem() {
        return this.item;
    }

    public int hashCode() {
        ItemResponse itemResponse = this.item;
        if (itemResponse != null) {
            return itemResponse.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileDocumentInfoResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
