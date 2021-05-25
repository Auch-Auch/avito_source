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
import ru.sravni.android.bankproduct.repository.profile.entity.v2.DetailedDocumentRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo;", "toDetailedDocumentRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group;", "component2", "()Ljava/util/List;", "id", "groups", "copy", "(Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getGroups", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Group", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DocumentResponse {
    @SerializedName("groups")
    @NotNull
    private final List<Group> groups;
    @SerializedName("id")
    @NotNull
    private final String id;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo$Group;", "toDetailedDocumentGroupRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo$Group;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group$Item;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "items", "title", "copy", "(Ljava/util/List;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "Item", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Group {
        @SerializedName("items")
        @NotNull
        private final List<Item> items;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J<\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001c\u0010\u0007R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group$Item;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo$Group$Item;", "toDetailedDocumentItemRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/DetailedDocumentRepo$Group$Item;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "description", "mask", "fullName", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/response/v2/DocumentResponse$Group$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getFullName", "getValue", "getMask", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class Item {
            @SerializedName("description")
            @NotNull
            private final String description;
            @SerializedName("fullName")
            @Nullable
            private final String fullName;
            @SerializedName("mask")
            @Nullable
            private final String mask;
            @SerializedName("value")
            @NotNull
            private final String value;

            public Item(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
                Intrinsics.checkParameterIsNotNull(str, "description");
                Intrinsics.checkParameterIsNotNull(str4, "value");
                this.description = str;
                this.mask = str2;
                this.fullName = str3;
                this.value = str4;
            }

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.description;
                }
                if ((i & 2) != 0) {
                    str2 = item.mask;
                }
                if ((i & 4) != 0) {
                    str3 = item.fullName;
                }
                if ((i & 8) != 0) {
                    str4 = item.value;
                }
                return item.copy(str, str2, str3, str4);
            }

            @NotNull
            public final String component1() {
                return this.description;
            }

            @Nullable
            public final String component2() {
                return this.mask;
            }

            @Nullable
            public final String component3() {
                return this.fullName;
            }

            @NotNull
            public final String component4() {
                return this.value;
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
                return Intrinsics.areEqual(this.description, item.description) && Intrinsics.areEqual(this.mask, item.mask) && Intrinsics.areEqual(this.fullName, item.fullName) && Intrinsics.areEqual(this.value, item.value);
            }

            @NotNull
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            public final String getFullName() {
                return this.fullName;
            }

            @Nullable
            public final String getMask() {
                return this.mask;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                String str = this.description;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mask;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.fullName;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.value;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public final DetailedDocumentRepo.Group.Item toDetailedDocumentItemRepo() {
                return new DetailedDocumentRepo.Group.Item(this.description, this.mask, this.fullName, this.value);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Item(description=");
                L.append(this.description);
                L.append(", mask=");
                L.append(this.mask);
                L.append(", fullName=");
                L.append(this.fullName);
                L.append(", value=");
                return a.t(L, this.value, ")");
            }
        }

        public Group(@NotNull List<Item> list, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.items = list;
            this.title = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.DocumentResponse$Group */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Group copy$default(Group group, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = group.items;
            }
            if ((i & 2) != 0) {
                str = group.title;
            }
            return group.copy(list, str);
        }

        @NotNull
        public final List<Item> component1() {
            return this.items;
        }

        @Nullable
        public final String component2() {
            return this.title;
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
            return Intrinsics.areEqual(this.items, group.items) && Intrinsics.areEqual(this.title, group.title);
        }

        @NotNull
        public final List<Item> getItems() {
            return this.items;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            List<Item> list = this.items;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.title;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public final DetailedDocumentRepo.Group toDetailedDocumentGroupRepo() {
            List<Item> list = this.items;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toDetailedDocumentItemRepo());
            }
            return new DetailedDocumentRepo.Group(arrayList, this.title);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Group(items=");
            L.append(this.items);
            L.append(", title=");
            return a.t(L, this.title, ")");
        }
    }

    public DocumentResponse(@NotNull String str, @NotNull List<Group> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        this.id = str;
        this.groups = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.DocumentResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentResponse copy$default(DocumentResponse documentResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentResponse.id;
        }
        if ((i & 2) != 0) {
            list = documentResponse.groups;
        }
        return documentResponse.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final List<Group> component2() {
        return this.groups;
    }

    @NotNull
    public final DocumentResponse copy(@NotNull String str, @NotNull List<Group> list) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(list, "groups");
        return new DocumentResponse(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentResponse)) {
            return false;
        }
        DocumentResponse documentResponse = (DocumentResponse) obj;
        return Intrinsics.areEqual(this.id, documentResponse.id) && Intrinsics.areEqual(this.groups, documentResponse.groups);
    }

    @NotNull
    public final List<Group> getGroups() {
        return this.groups;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Group> list = this.groups;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public final DetailedDocumentRepo toDetailedDocumentRepo() {
        String str = this.id;
        List<Group> list = this.groups;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDetailedDocumentGroupRepo());
        }
        return new DetailedDocumentRepo(str, arrayList);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DocumentResponse(id=");
        L.append(this.id);
        L.append(", groups=");
        return a.w(L, this.groups, ")");
    }
}
