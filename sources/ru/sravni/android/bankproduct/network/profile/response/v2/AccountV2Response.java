package ru.sravni.android.bankproduct.network.profile.response.v2;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileV2Repo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;", "item", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;)Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;)V", "ItemResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AccountV2Response {
    @SerializedName("item")
    @NotNull
    private final ItemResponse item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0002#$B1\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b!\u0010\"J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\fR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\b¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo;", "toProfileRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$AccountDetailResponse;", "component1", "()Ljava/util/List;", "component2", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;", "component3", "()Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;", "cars", "documents", VKApiUserFull.PERSONAL, "copy", "(Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;)Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCars", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;", "getPersonal", "getDocuments", "<init>", "(Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;)V", "AccountDetailResponse", "Personal", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ItemResponse {
        @SerializedName("cars")
        @Nullable
        private final List<AccountDetailResponse> cars;
        @SerializedName("documents")
        @Nullable
        private final List<AccountDetailResponse> documents;
        @SerializedName(VKApiUserFull.PERSONAL)
        @Nullable
        private final Personal personal;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$AccountDetailResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo$AccountDetailRepo;", "toAccountDetailRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo$AccountDetailRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "id", "text", "title", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$AccountDetailResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getId", "getType", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class AccountDetailResponse {
            @SerializedName("id")
            @NotNull
            private final String id;
            @SerializedName("text")
            @NotNull
            private final String text;
            @SerializedName("title")
            @NotNull
            private final String title;
            @SerializedName("type")
            @Nullable
            private final String type;

            public AccountDetailResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
                a.a1(str, "id", str2, "text", str3, "title");
                this.id = str;
                this.text = str2;
                this.title = str3;
                this.type = str4;
            }

            public static /* synthetic */ AccountDetailResponse copy$default(AccountDetailResponse accountDetailResponse, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = accountDetailResponse.id;
                }
                if ((i & 2) != 0) {
                    str2 = accountDetailResponse.text;
                }
                if ((i & 4) != 0) {
                    str3 = accountDetailResponse.title;
                }
                if ((i & 8) != 0) {
                    str4 = accountDetailResponse.type;
                }
                return accountDetailResponse.copy(str, str2, str3, str4);
            }

            @NotNull
            public final String component1() {
                return this.id;
            }

            @NotNull
            public final String component2() {
                return this.text;
            }

            @NotNull
            public final String component3() {
                return this.title;
            }

            @Nullable
            public final String component4() {
                return this.type;
            }

            @NotNull
            public final AccountDetailResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
                Intrinsics.checkParameterIsNotNull(str, "id");
                Intrinsics.checkParameterIsNotNull(str2, "text");
                Intrinsics.checkParameterIsNotNull(str3, "title");
                return new AccountDetailResponse(str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AccountDetailResponse)) {
                    return false;
                }
                AccountDetailResponse accountDetailResponse = (AccountDetailResponse) obj;
                return Intrinsics.areEqual(this.id, accountDetailResponse.id) && Intrinsics.areEqual(this.text, accountDetailResponse.text) && Intrinsics.areEqual(this.title, accountDetailResponse.title) && Intrinsics.areEqual(this.type, accountDetailResponse.type);
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.id;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.text;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.title;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.type;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public final ProfileV2Repo.AccountDetailRepo toAccountDetailRepo() {
                return new ProfileV2Repo.AccountDetailRepo(this.id, this.text, this.title, this.type);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("AccountDetailResponse(id=");
                L.append(this.id);
                L.append(", text=");
                L.append(this.text);
                L.append(", title=");
                L.append(this.title);
                L.append(", type=");
                return a.t(L, this.type, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo$Personal;", "toPersonalRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileV2Repo$Personal;", "", "component1", "()Ljava/lang/String;", "name", "copy", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response$ItemResponse$Personal;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class Personal {
            @SerializedName("name")
            @Nullable
            private final String name;

            public Personal(@Nullable String str) {
                this.name = str;
            }

            public static /* synthetic */ Personal copy$default(Personal personal, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = personal.name;
                }
                return personal.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.name;
            }

            @NotNull
            public final Personal copy(@Nullable String str) {
                return new Personal(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Personal) && Intrinsics.areEqual(this.name, ((Personal) obj).name);
                }
                return true;
            }

            @Nullable
            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                String str = this.name;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public final ProfileV2Repo.Personal toPersonalRepo() {
                return new ProfileV2Repo.Personal(this.name);
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Personal(name="), this.name, ")");
            }
        }

        public ItemResponse(@Nullable List<AccountDetailResponse> list, @Nullable List<AccountDetailResponse> list2, @Nullable Personal personal2) {
            this.cars = list;
            this.documents = list2;
            this.personal = personal2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.AccountV2Response$ItemResponse */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemResponse copy$default(ItemResponse itemResponse, List list, List list2, Personal personal2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemResponse.cars;
            }
            if ((i & 2) != 0) {
                list2 = itemResponse.documents;
            }
            if ((i & 4) != 0) {
                personal2 = itemResponse.personal;
            }
            return itemResponse.copy(list, list2, personal2);
        }

        @Nullable
        public final List<AccountDetailResponse> component1() {
            return this.cars;
        }

        @Nullable
        public final List<AccountDetailResponse> component2() {
            return this.documents;
        }

        @Nullable
        public final Personal component3() {
            return this.personal;
        }

        @NotNull
        public final ItemResponse copy(@Nullable List<AccountDetailResponse> list, @Nullable List<AccountDetailResponse> list2, @Nullable Personal personal2) {
            return new ItemResponse(list, list2, personal2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemResponse)) {
                return false;
            }
            ItemResponse itemResponse = (ItemResponse) obj;
            return Intrinsics.areEqual(this.cars, itemResponse.cars) && Intrinsics.areEqual(this.documents, itemResponse.documents) && Intrinsics.areEqual(this.personal, itemResponse.personal);
        }

        @Nullable
        public final List<AccountDetailResponse> getCars() {
            return this.cars;
        }

        @Nullable
        public final List<AccountDetailResponse> getDocuments() {
            return this.documents;
        }

        @Nullable
        public final Personal getPersonal() {
            return this.personal;
        }

        public int hashCode() {
            List<AccountDetailResponse> list = this.cars;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<AccountDetailResponse> list2 = this.documents;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            Personal personal2 = this.personal;
            if (personal2 != null) {
                i = personal2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public final ProfileV2Repo toProfileRepo() {
            ProfileV2Repo.Personal personal2;
            List<AccountDetailResponse> list = this.cars;
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toAccountDetailRepo());
            }
            List<AccountDetailResponse> list2 = this.documents;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().toAccountDetailRepo());
            }
            Personal personal3 = this.personal;
            if (personal3 == null || (personal2 = personal3.toPersonalRepo()) == null) {
                personal2 = new ProfileV2Repo.Personal(null, 1, null);
            }
            return new ProfileV2Repo(arrayList, arrayList2, personal2);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemResponse(cars=");
            L.append(this.cars);
            L.append(", documents=");
            L.append(this.documents);
            L.append(", personal=");
            L.append(this.personal);
            L.append(")");
            return L.toString();
        }
    }

    public AccountV2Response(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        this.item = itemResponse;
    }

    public static /* synthetic */ AccountV2Response copy$default(AccountV2Response accountV2Response, ItemResponse itemResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            itemResponse = accountV2Response.item;
        }
        return accountV2Response.copy(itemResponse);
    }

    @NotNull
    public final ItemResponse component1() {
        return this.item;
    }

    @NotNull
    public final AccountV2Response copy(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        return new AccountV2Response(itemResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AccountV2Response) && Intrinsics.areEqual(this.item, ((AccountV2Response) obj).item);
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
        StringBuilder L = a.L("AccountV2Response(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
