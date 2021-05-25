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
import ru.sravni.android.bankproduct.repository.profile.entity.v2.ProfileDetailedInfoRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;", "component1", "()Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;", "item", "copy", "(Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;", "getItem", "<init>", "(Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;)V", "ItemResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileDetailedInfoResponse {
    @SerializedName("item")
    @NotNull
    private final ItemResponse item;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ<\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001f\u0010\u000b¨\u0006#"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "toProfileDetailedInfoRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo;", "", "component1", "()Ljava/lang/String;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileMainInfoResponse;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse;", "component3", "id", VKApiUserFull.PERSONAL, "groups", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPersonal", "Ljava/lang/String;", "getId", "getGroups", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "ProfileGroupResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class ItemResponse {
        @SerializedName("groups")
        @NotNull
        private final List<ProfileGroupResponse> groups;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName(VKApiUserFull.PERSONAL)
        @Nullable
        private final List<ProfileMainInfoResponse> personal;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\b¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo;", "toGroupAdditionalDetailRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo;", "", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse$ProfileItemResponse;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "ProfileItemResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ProfileGroupResponse {
            @SerializedName("items")
            @NotNull
            private final List<ProfileItemResponse> items;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b&\u0010'J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJT\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b \u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b#\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse$ProfileItemResponse;", "", "Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo$ItemAdditionalDetailRepo;", "toItemAdditionalDetailRepo", "()Lru/sravni/android/bankproduct/repository/profile/entity/v2/ProfileDetailedInfoRepo$GroupAdditionalDetailRepo$ItemAdditionalDetailRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "description", "id", "mask", "type", "value", "showInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse$ProfileItemResponse;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getValue", "Ljava/lang/Boolean;", "getShowInfo", "getType", "getMask", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
            public static final class ProfileItemResponse {
                @SerializedName("description")
                @NotNull
                private final String description;
                @SerializedName("id")
                @Nullable
                private final String id;
                @SerializedName("mask")
                @Nullable
                private final String mask;
                @SerializedName("showInfo")
                @Nullable
                private final Boolean showInfo;
                @SerializedName("type")
                @NotNull
                private final String type;
                @SerializedName("value")
                @Nullable
                private final String value;

                public ProfileItemResponse(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable Boolean bool) {
                    Intrinsics.checkParameterIsNotNull(str, "description");
                    Intrinsics.checkParameterIsNotNull(str4, "type");
                    this.description = str;
                    this.id = str2;
                    this.mask = str3;
                    this.type = str4;
                    this.value = str5;
                    this.showInfo = bool;
                }

                public static /* synthetic */ ProfileItemResponse copy$default(ProfileItemResponse profileItemResponse, String str, String str2, String str3, String str4, String str5, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = profileItemResponse.description;
                    }
                    if ((i & 2) != 0) {
                        str2 = profileItemResponse.id;
                    }
                    if ((i & 4) != 0) {
                        str3 = profileItemResponse.mask;
                    }
                    if ((i & 8) != 0) {
                        str4 = profileItemResponse.type;
                    }
                    if ((i & 16) != 0) {
                        str5 = profileItemResponse.value;
                    }
                    if ((i & 32) != 0) {
                        bool = profileItemResponse.showInfo;
                    }
                    return profileItemResponse.copy(str, str2, str3, str4, str5, bool);
                }

                @NotNull
                public final String component1() {
                    return this.description;
                }

                @Nullable
                public final String component2() {
                    return this.id;
                }

                @Nullable
                public final String component3() {
                    return this.mask;
                }

                @NotNull
                public final String component4() {
                    return this.type;
                }

                @Nullable
                public final String component5() {
                    return this.value;
                }

                @Nullable
                public final Boolean component6() {
                    return this.showInfo;
                }

                @NotNull
                public final ProfileItemResponse copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable Boolean bool) {
                    Intrinsics.checkParameterIsNotNull(str, "description");
                    Intrinsics.checkParameterIsNotNull(str4, "type");
                    return new ProfileItemResponse(str, str2, str3, str4, str5, bool);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ProfileItemResponse)) {
                        return false;
                    }
                    ProfileItemResponse profileItemResponse = (ProfileItemResponse) obj;
                    return Intrinsics.areEqual(this.description, profileItemResponse.description) && Intrinsics.areEqual(this.id, profileItemResponse.id) && Intrinsics.areEqual(this.mask, profileItemResponse.mask) && Intrinsics.areEqual(this.type, profileItemResponse.type) && Intrinsics.areEqual(this.value, profileItemResponse.value) && Intrinsics.areEqual(this.showInfo, profileItemResponse.showInfo);
                }

                @NotNull
                public final String getDescription() {
                    return this.description;
                }

                @Nullable
                public final String getId() {
                    return this.id;
                }

                @Nullable
                public final String getMask() {
                    return this.mask;
                }

                @Nullable
                public final Boolean getShowInfo() {
                    return this.showInfo;
                }

                @NotNull
                public final String getType() {
                    return this.type;
                }

                @Nullable
                public final String getValue() {
                    return this.value;
                }

                public int hashCode() {
                    String str = this.description;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    String str2 = this.id;
                    int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                    String str3 = this.mask;
                    int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                    String str4 = this.type;
                    int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                    String str5 = this.value;
                    int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                    Boolean bool = this.showInfo;
                    if (bool != null) {
                        i = bool.hashCode();
                    }
                    return hashCode5 + i;
                }

                @NotNull
                public final ProfileDetailedInfoRepo.GroupAdditionalDetailRepo.ItemAdditionalDetailRepo toItemAdditionalDetailRepo() {
                    String str = this.description;
                    String str2 = this.id;
                    String str3 = this.mask;
                    String str4 = this.type;
                    String str5 = this.value;
                    Boolean bool = this.showInfo;
                    return new ProfileDetailedInfoRepo.GroupAdditionalDetailRepo.ItemAdditionalDetailRepo(str, str2, str3, str4, str5, bool != null ? bool.booleanValue() : false);
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("ProfileItemResponse(description=");
                    L.append(this.description);
                    L.append(", id=");
                    L.append(this.id);
                    L.append(", mask=");
                    L.append(this.mask);
                    L.append(", type=");
                    L.append(this.type);
                    L.append(", value=");
                    L.append(this.value);
                    L.append(", showInfo=");
                    return a.o(L, this.showInfo, ")");
                }
            }

            public ProfileGroupResponse(@NotNull List<ProfileItemResponse> list) {
                Intrinsics.checkParameterIsNotNull(list, "items");
                this.items = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDetailedInfoResponse$ItemResponse$ProfileGroupResponse */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ProfileGroupResponse copy$default(ProfileGroupResponse profileGroupResponse, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = profileGroupResponse.items;
                }
                return profileGroupResponse.copy(list);
            }

            @NotNull
            public final List<ProfileItemResponse> component1() {
                return this.items;
            }

            @NotNull
            public final ProfileGroupResponse copy(@NotNull List<ProfileItemResponse> list) {
                Intrinsics.checkParameterIsNotNull(list, "items");
                return new ProfileGroupResponse(list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ProfileGroupResponse) && Intrinsics.areEqual(this.items, ((ProfileGroupResponse) obj).items);
                }
                return true;
            }

            @NotNull
            public final List<ProfileItemResponse> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<ProfileItemResponse> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            @NotNull
            public final ProfileDetailedInfoRepo.GroupAdditionalDetailRepo toGroupAdditionalDetailRepo() {
                List<ProfileItemResponse> list = this.items;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toItemAdditionalDetailRepo());
                }
                return new ProfileDetailedInfoRepo.GroupAdditionalDetailRepo(arrayList);
            }

            @NotNull
            public String toString() {
                return a.w(a.L("ProfileGroupResponse(items="), this.items, ")");
            }
        }

        public ItemResponse(@NotNull String str, @Nullable List<ProfileMainInfoResponse> list, @NotNull List<ProfileGroupResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(list2, "groups");
            this.id = str;
            this.personal = list;
            this.groups = list2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDetailedInfoResponse$ItemResponse */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemResponse copy$default(ItemResponse itemResponse, String str, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemResponse.id;
            }
            if ((i & 2) != 0) {
                list = itemResponse.personal;
            }
            if ((i & 4) != 0) {
                list2 = itemResponse.groups;
            }
            return itemResponse.copy(str, list, list2);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @Nullable
        public final List<ProfileMainInfoResponse> component2() {
            return this.personal;
        }

        @NotNull
        public final List<ProfileGroupResponse> component3() {
            return this.groups;
        }

        @NotNull
        public final ItemResponse copy(@NotNull String str, @Nullable List<ProfileMainInfoResponse> list, @NotNull List<ProfileGroupResponse> list2) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(list2, "groups");
            return new ItemResponse(str, list, list2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemResponse)) {
                return false;
            }
            ItemResponse itemResponse = (ItemResponse) obj;
            return Intrinsics.areEqual(this.id, itemResponse.id) && Intrinsics.areEqual(this.personal, itemResponse.personal) && Intrinsics.areEqual(this.groups, itemResponse.groups);
        }

        @NotNull
        public final List<ProfileGroupResponse> getGroups() {
            return this.groups;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final List<ProfileMainInfoResponse> getPersonal() {
            return this.personal;
        }

        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<ProfileMainInfoResponse> list = this.personal;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<ProfileGroupResponse> list2 = this.groups;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public final ProfileDetailedInfoRepo toProfileDetailedInfoRepo() {
            List list;
            String str = this.id;
            List<ProfileMainInfoResponse> list2 = this.personal;
            if (list2 != null) {
                list = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    list.add(it.next().toProfileMainDetailRepo());
                }
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            List<ProfileGroupResponse> list3 = this.groups;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().toGroupAdditionalDetailRepo());
            }
            return new ProfileDetailedInfoRepo(str, list, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemResponse(id=");
            L.append(this.id);
            L.append(", personal=");
            L.append(this.personal);
            L.append(", groups=");
            return a.w(L, this.groups, ")");
        }
    }

    public ProfileDetailedInfoResponse(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        this.item = itemResponse;
    }

    public static /* synthetic */ ProfileDetailedInfoResponse copy$default(ProfileDetailedInfoResponse profileDetailedInfoResponse, ItemResponse itemResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            itemResponse = profileDetailedInfoResponse.item;
        }
        return profileDetailedInfoResponse.copy(itemResponse);
    }

    @NotNull
    public final ItemResponse component1() {
        return this.item;
    }

    @NotNull
    public final ProfileDetailedInfoResponse copy(@NotNull ItemResponse itemResponse) {
        Intrinsics.checkParameterIsNotNull(itemResponse, "item");
        return new ProfileDetailedInfoResponse(itemResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ProfileDetailedInfoResponse) && Intrinsics.areEqual(this.item, ((ProfileDetailedInfoResponse) obj).item);
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
        StringBuilder L = a.L("ProfileDetailedInfoResponse(item=");
        L.append(this.item);
        L.append(")");
        return L.toString();
    }
}
