package com.sumsub.sns.core.data.model.remote.response;

import a2.b.a.a.a;
import com.avito.android.remote.model.AvatarStatus;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.ReviewAnswerType;
import com.sumsub.sns.core.data.model.ReviewRejectType;
import com.sumsub.sns.core.data.model.ReviewStatusType;
import com.sumsub.sns.core.data.model.remote.Metavalue;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0016B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse;", "", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;", "component1", "()Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;", "data", "copy", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;", "getData", "<init>", "(Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;)V", "Data", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ListApplicantsResponse {
    @SerializedName("list")
    @Nullable
    private final Data data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;", "", "", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "Info", "Item", "RequiredIdDocs", "Review", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Data {
        @SerializedName("items")
        @Nullable
        private final List<Item> items;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J$\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J¾\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\u0004R0\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010-\u001a\u0004\b.\u0010\u0013R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b/\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b0\u0010\u0004R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b1\u0010\u0004R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b2\u0010\u0004R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b3\u0010\u0004R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b4\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b5\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b6\u0010\u0004R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b7\u0010\u0004R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b8\u0010\u0004R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b9\u0010\u0004¨\u0006<"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "", "", "component13", "()Ljava/util/List;", "country", "firstName", "lastName", "middleName", "legalName", "gender", "dob", "placeOfBirth", "countryOfBirth", "stateOfBirth", "nationality", "phone", "addresses", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPlaceOfBirth", "Ljava/util/List;", "getAddresses", "getNationality", "getGender", "getPhone", "getLegalName", "getMiddleName", "getCountry", "getFirstName", "getStateOfBirth", "getCountryOfBirth", "getLastName", "getDob", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Info {
            @SerializedName("addresses")
            @Nullable
            private final List<Map<String, String>> addresses;
            @SerializedName("country")
            @Nullable
            private final String country;
            @SerializedName("countryOfBirth")
            @Nullable
            private final String countryOfBirth;
            @SerializedName("dob")
            @Nullable
            private final String dob;
            @SerializedName("firstName")
            @Nullable
            private final String firstName;
            @SerializedName("gender")
            @Nullable
            private final String gender;
            @SerializedName("lastName")
            @Nullable
            private final String lastName;
            @SerializedName("legalName")
            @Nullable
            private final String legalName;
            @SerializedName("middleName")
            @Nullable
            private final String middleName;
            @SerializedName("nationality")
            @Nullable
            private final String nationality;
            @SerializedName("phone")
            @Nullable
            private final String phone;
            @SerializedName("placeOfBirth")
            @Nullable
            private final String placeOfBirth;
            @SerializedName("stateOfBirth")
            @Nullable
            private final String stateOfBirth;

            public Info() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.util.List<? extends java.util.Map<java.lang.String, java.lang.String>> */
            /* JADX WARN: Multi-variable type inference failed */
            public Info(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable List<? extends Map<String, String>> list) {
                this.country = str;
                this.firstName = str2;
                this.lastName = str3;
                this.middleName = str4;
                this.legalName = str5;
                this.gender = str6;
                this.dob = str7;
                this.placeOfBirth = str8;
                this.countryOfBirth = str9;
                this.stateOfBirth = str10;
                this.nationality = str11;
                this.phone = str12;
                this.addresses = list;
            }

            public static /* synthetic */ Info copy$default(Info info, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, int i, Object obj) {
                return info.copy((i & 1) != 0 ? info.country : str, (i & 2) != 0 ? info.firstName : str2, (i & 4) != 0 ? info.lastName : str3, (i & 8) != 0 ? info.middleName : str4, (i & 16) != 0 ? info.legalName : str5, (i & 32) != 0 ? info.gender : str6, (i & 64) != 0 ? info.dob : str7, (i & 128) != 0 ? info.placeOfBirth : str8, (i & 256) != 0 ? info.countryOfBirth : str9, (i & 512) != 0 ? info.stateOfBirth : str10, (i & 1024) != 0 ? info.nationality : str11, (i & 2048) != 0 ? info.phone : str12, (i & 4096) != 0 ? info.addresses : list);
            }

            @Nullable
            public final String component1() {
                return this.country;
            }

            @Nullable
            public final String component10() {
                return this.stateOfBirth;
            }

            @Nullable
            public final String component11() {
                return this.nationality;
            }

            @Nullable
            public final String component12() {
                return this.phone;
            }

            @Nullable
            public final List<Map<String, String>> component13() {
                return this.addresses;
            }

            @Nullable
            public final String component2() {
                return this.firstName;
            }

            @Nullable
            public final String component3() {
                return this.lastName;
            }

            @Nullable
            public final String component4() {
                return this.middleName;
            }

            @Nullable
            public final String component5() {
                return this.legalName;
            }

            @Nullable
            public final String component6() {
                return this.gender;
            }

            @Nullable
            public final String component7() {
                return this.dob;
            }

            @Nullable
            public final String component8() {
                return this.placeOfBirth;
            }

            @Nullable
            public final String component9() {
                return this.countryOfBirth;
            }

            @NotNull
            public final Info copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable List<? extends Map<String, String>> list) {
                return new Info(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Info)) {
                    return false;
                }
                Info info = (Info) obj;
                return Intrinsics.areEqual(this.country, info.country) && Intrinsics.areEqual(this.firstName, info.firstName) && Intrinsics.areEqual(this.lastName, info.lastName) && Intrinsics.areEqual(this.middleName, info.middleName) && Intrinsics.areEqual(this.legalName, info.legalName) && Intrinsics.areEqual(this.gender, info.gender) && Intrinsics.areEqual(this.dob, info.dob) && Intrinsics.areEqual(this.placeOfBirth, info.placeOfBirth) && Intrinsics.areEqual(this.countryOfBirth, info.countryOfBirth) && Intrinsics.areEqual(this.stateOfBirth, info.stateOfBirth) && Intrinsics.areEqual(this.nationality, info.nationality) && Intrinsics.areEqual(this.phone, info.phone) && Intrinsics.areEqual(this.addresses, info.addresses);
            }

            @Nullable
            public final List<Map<String, String>> getAddresses() {
                return this.addresses;
            }

            @Nullable
            public final String getCountry() {
                return this.country;
            }

            @Nullable
            public final String getCountryOfBirth() {
                return this.countryOfBirth;
            }

            @Nullable
            public final String getDob() {
                return this.dob;
            }

            @Nullable
            public final String getFirstName() {
                return this.firstName;
            }

            @Nullable
            public final String getGender() {
                return this.gender;
            }

            @Nullable
            public final String getLastName() {
                return this.lastName;
            }

            @Nullable
            public final String getLegalName() {
                return this.legalName;
            }

            @Nullable
            public final String getMiddleName() {
                return this.middleName;
            }

            @Nullable
            public final String getNationality() {
                return this.nationality;
            }

            @Nullable
            public final String getPhone() {
                return this.phone;
            }

            @Nullable
            public final String getPlaceOfBirth() {
                return this.placeOfBirth;
            }

            @Nullable
            public final String getStateOfBirth() {
                return this.stateOfBirth;
            }

            public int hashCode() {
                String str = this.country;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.firstName;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.lastName;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.middleName;
                int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                String str5 = this.legalName;
                int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                String str6 = this.gender;
                int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
                String str7 = this.dob;
                int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
                String str8 = this.placeOfBirth;
                int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
                String str9 = this.countryOfBirth;
                int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
                String str10 = this.stateOfBirth;
                int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
                String str11 = this.nationality;
                int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
                String str12 = this.phone;
                int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
                List<Map<String, String>> list = this.addresses;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode12 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Info(country=");
                L.append(this.country);
                L.append(", firstName=");
                L.append(this.firstName);
                L.append(", lastName=");
                L.append(this.lastName);
                L.append(", middleName=");
                L.append(this.middleName);
                L.append(", legalName=");
                L.append(this.legalName);
                L.append(", gender=");
                L.append(this.gender);
                L.append(", dob=");
                L.append(this.dob);
                L.append(", placeOfBirth=");
                L.append(this.placeOfBirth);
                L.append(", countryOfBirth=");
                L.append(this.countryOfBirth);
                L.append(", stateOfBirth=");
                L.append(this.stateOfBirth);
                L.append(", nationality=");
                L.append(this.nationality);
                L.append(", phone=");
                L.append(this.phone);
                L.append(", addresses=");
                return a.w(L, this.addresses, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Info(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, int i, j jVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) == 0 ? list : null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004JÄ\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104R\u001c\u0010!\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b6\u0010\rR\u001e\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b8\u0010\u0004R$\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u00109\u001a\u0004\b:\u0010\u0018R\u001e\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b;\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b<\u0010\u0004R\u001e\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010=\u001a\u0004\b>\u0010\u0013R\u001e\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b?\u0010\u0004R\u001e\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\b@\u0010\u0004R\u001e\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\bA\u0010\u0004R\u001e\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\bB\u0010\u0004R\u001e\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00107\u001a\u0004\bC\u0010\u0004R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\bD\u0010\u0004R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\bE\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\bF\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010G\u001a\u0004\bH\u0010\b¨\u0006K"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "component3", "()Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "component4", "component5", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "component6", "()Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "component7", "component8", "component9", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "component10", "()Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "component11", "", "Lcom/sumsub/sns/core/data/model/remote/Metavalue;", "component12", "()Ljava/util/List;", "component13", "component14", "component15", "createdAt", "inspectionId", "requiredIdDocs", "clientId", "externalUserId", AvatarStatus.REVIEW, "id", "env", "type", "info", VKApiConst.LANG, "metadata", "email", "key", "applicantPlatform", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "getReview", "Ljava/lang/String;", "getType", "Ljava/util/List;", "getMetadata", "getEmail", "getId", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "getInfo", "getKey", "getApplicantPlatform", "getEnv", "getLang", "getExternalUserId", "getCreatedAt", "getClientId", "getInspectionId", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "getRequiredIdDocs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item {
            @SerializedName("applicantPlatform")
            @Nullable
            private final String applicantPlatform;
            @SerializedName("clientId")
            @Nullable
            private final String clientId;
            @SerializedName("createdAt")
            @Nullable
            private final String createdAt;
            @SerializedName("email")
            @Nullable
            private final String email;
            @SerializedName("env")
            @Nullable
            private final String env;
            @SerializedName("externalUserId")
            @Nullable
            private final String externalUserId;
            @SerializedName("id")
            @NotNull
            private final String id;
            @SerializedName("info")
            @Nullable
            private final Info info;
            @SerializedName("inspectionId")
            @Nullable
            private final String inspectionId;
            @SerializedName("key")
            @Nullable
            private final String key;
            @SerializedName(VKApiConst.LANG)
            @Nullable
            private final String lang;
            @SerializedName("metadata")
            @Nullable
            private final List<Metavalue> metadata;
            @SerializedName("requiredIdDocs")
            @NotNull
            private final RequiredIdDocs requiredIdDocs;
            @SerializedName(AvatarStatus.REVIEW)
            @NotNull
            private final Review review;
            @SerializedName("type")
            @Nullable
            private final String type;

            public Item(@Nullable String str, @Nullable String str2, @NotNull RequiredIdDocs requiredIdDocs2, @Nullable String str3, @Nullable String str4, @NotNull Review review2, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable Info info2, @Nullable String str8, @Nullable List<Metavalue> list, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
                Intrinsics.checkNotNullParameter(requiredIdDocs2, "requiredIdDocs");
                Intrinsics.checkNotNullParameter(review2, AvatarStatus.REVIEW);
                Intrinsics.checkNotNullParameter(str5, "id");
                this.createdAt = str;
                this.inspectionId = str2;
                this.requiredIdDocs = requiredIdDocs2;
                this.clientId = str3;
                this.externalUserId = str4;
                this.review = review2;
                this.id = str5;
                this.env = str6;
                this.type = str7;
                this.info = info2;
                this.lang = str8;
                this.metadata = list;
                this.email = str9;
                this.key = str10;
                this.applicantPlatform = str11;
            }

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, RequiredIdDocs requiredIdDocs2, String str3, String str4, Review review2, String str5, String str6, String str7, Info info2, String str8, List list, String str9, String str10, String str11, int i, Object obj) {
                return item.copy((i & 1) != 0 ? item.createdAt : str, (i & 2) != 0 ? item.inspectionId : str2, (i & 4) != 0 ? item.requiredIdDocs : requiredIdDocs2, (i & 8) != 0 ? item.clientId : str3, (i & 16) != 0 ? item.externalUserId : str4, (i & 32) != 0 ? item.review : review2, (i & 64) != 0 ? item.id : str5, (i & 128) != 0 ? item.env : str6, (i & 256) != 0 ? item.type : str7, (i & 512) != 0 ? item.info : info2, (i & 1024) != 0 ? item.lang : str8, (i & 2048) != 0 ? item.metadata : list, (i & 4096) != 0 ? item.email : str9, (i & 8192) != 0 ? item.key : str10, (i & 16384) != 0 ? item.applicantPlatform : str11);
            }

            @Nullable
            public final String component1() {
                return this.createdAt;
            }

            @Nullable
            public final Info component10() {
                return this.info;
            }

            @Nullable
            public final String component11() {
                return this.lang;
            }

            @Nullable
            public final List<Metavalue> component12() {
                return this.metadata;
            }

            @Nullable
            public final String component13() {
                return this.email;
            }

            @Nullable
            public final String component14() {
                return this.key;
            }

            @Nullable
            public final String component15() {
                return this.applicantPlatform;
            }

            @Nullable
            public final String component2() {
                return this.inspectionId;
            }

            @NotNull
            public final RequiredIdDocs component3() {
                return this.requiredIdDocs;
            }

            @Nullable
            public final String component4() {
                return this.clientId;
            }

            @Nullable
            public final String component5() {
                return this.externalUserId;
            }

            @NotNull
            public final Review component6() {
                return this.review;
            }

            @NotNull
            public final String component7() {
                return this.id;
            }

            @Nullable
            public final String component8() {
                return this.env;
            }

            @Nullable
            public final String component9() {
                return this.type;
            }

            @NotNull
            public final Item copy(@Nullable String str, @Nullable String str2, @NotNull RequiredIdDocs requiredIdDocs2, @Nullable String str3, @Nullable String str4, @NotNull Review review2, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable Info info2, @Nullable String str8, @Nullable List<Metavalue> list, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
                Intrinsics.checkNotNullParameter(requiredIdDocs2, "requiredIdDocs");
                Intrinsics.checkNotNullParameter(review2, AvatarStatus.REVIEW);
                Intrinsics.checkNotNullParameter(str5, "id");
                return new Item(str, str2, requiredIdDocs2, str3, str4, review2, str5, str6, str7, info2, str8, list, str9, str10, str11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Item)) {
                    return false;
                }
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.createdAt, item.createdAt) && Intrinsics.areEqual(this.inspectionId, item.inspectionId) && Intrinsics.areEqual(this.requiredIdDocs, item.requiredIdDocs) && Intrinsics.areEqual(this.clientId, item.clientId) && Intrinsics.areEqual(this.externalUserId, item.externalUserId) && Intrinsics.areEqual(this.review, item.review) && Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.env, item.env) && Intrinsics.areEqual(this.type, item.type) && Intrinsics.areEqual(this.info, item.info) && Intrinsics.areEqual(this.lang, item.lang) && Intrinsics.areEqual(this.metadata, item.metadata) && Intrinsics.areEqual(this.email, item.email) && Intrinsics.areEqual(this.key, item.key) && Intrinsics.areEqual(this.applicantPlatform, item.applicantPlatform);
            }

            @Nullable
            public final String getApplicantPlatform() {
                return this.applicantPlatform;
            }

            @Nullable
            public final String getClientId() {
                return this.clientId;
            }

            @Nullable
            public final String getCreatedAt() {
                return this.createdAt;
            }

            @Nullable
            public final String getEmail() {
                return this.email;
            }

            @Nullable
            public final String getEnv() {
                return this.env;
            }

            @Nullable
            public final String getExternalUserId() {
                return this.externalUserId;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final Info getInfo() {
                return this.info;
            }

            @Nullable
            public final String getInspectionId() {
                return this.inspectionId;
            }

            @Nullable
            public final String getKey() {
                return this.key;
            }

            @Nullable
            public final String getLang() {
                return this.lang;
            }

            @Nullable
            public final List<Metavalue> getMetadata() {
                return this.metadata;
            }

            @NotNull
            public final RequiredIdDocs getRequiredIdDocs() {
                return this.requiredIdDocs;
            }

            @NotNull
            public final Review getReview() {
                return this.review;
            }

            @Nullable
            public final String getType() {
                return this.type;
            }

            public int hashCode() {
                String str = this.createdAt;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.inspectionId;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                RequiredIdDocs requiredIdDocs2 = this.requiredIdDocs;
                int hashCode3 = (hashCode2 + (requiredIdDocs2 != null ? requiredIdDocs2.hashCode() : 0)) * 31;
                String str3 = this.clientId;
                int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.externalUserId;
                int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Review review2 = this.review;
                int hashCode6 = (hashCode5 + (review2 != null ? review2.hashCode() : 0)) * 31;
                String str5 = this.id;
                int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
                String str6 = this.env;
                int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
                String str7 = this.type;
                int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
                Info info2 = this.info;
                int hashCode10 = (hashCode9 + (info2 != null ? info2.hashCode() : 0)) * 31;
                String str8 = this.lang;
                int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
                List<Metavalue> list = this.metadata;
                int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
                String str9 = this.email;
                int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
                String str10 = this.key;
                int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
                String str11 = this.applicantPlatform;
                if (str11 != null) {
                    i = str11.hashCode();
                }
                return hashCode14 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Item(createdAt=");
                L.append(this.createdAt);
                L.append(", inspectionId=");
                L.append(this.inspectionId);
                L.append(", requiredIdDocs=");
                L.append(this.requiredIdDocs);
                L.append(", clientId=");
                L.append(this.clientId);
                L.append(", externalUserId=");
                L.append(this.externalUserId);
                L.append(", review=");
                L.append(this.review);
                L.append(", id=");
                L.append(this.id);
                L.append(", env=");
                L.append(this.env);
                L.append(", type=");
                L.append(this.type);
                L.append(", info=");
                L.append(this.info);
                L.append(", lang=");
                L.append(this.lang);
                L.append(", metadata=");
                L.append(this.metadata);
                L.append(", email=");
                L.append(this.email);
                L.append(", key=");
                L.append(this.key);
                L.append(", applicantPlatform=");
                return a.t(L, this.applicantPlatform, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Item(String str, String str2, RequiredIdDocs requiredIdDocs2, String str3, String str4, Review review2, String str5, String str6, String str7, Info info2, String str8, List list, String str9, String str10, String str11, int i, j jVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, requiredIdDocs2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, review2, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, info2, str8, list, str9, str10, str11);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB9\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005JF\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0005R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "", "", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem;", "component1", "()Ljava/util/List;", "", "component2", "component3", "docSets", "includedCountries", "excludedCountries", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getDocSets", "getExcludedCountries", "getIncludedCountries", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "DocSetsItem", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class RequiredIdDocs {
            @SerializedName("docSets")
            @Nullable
            private final List<DocSetsItem> docSets;
            @SerializedName("excludedCountries")
            @Nullable
            private final List<String> excludedCountries;
            @SerializedName("includedCountries")
            @Nullable
            private final List<String> includedCountries;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007Jp\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0007R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\u0007R$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b%\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "component3", "component4", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", "component5", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$CustomField;", "component6", "idDocSetType", "types", "sides", "videoRequired", "fields", "customFields", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTypes", "getFields", "getSides", "Ljava/lang/String;", "getVideoRequired", "getCustomFields", "getIdDocSetType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
            public static final class DocSetsItem {
                @SerializedName("customFields")
                @Nullable
                private final List<ApplicantDataField.CustomField> customFields;
                @SerializedName("fields")
                @Nullable
                private final List<ApplicantDataField.Field> fields;
                @SerializedName("idDocSetType")
                @Nullable
                private final String idDocSetType;
                @SerializedName("subTypes")
                @Nullable
                private final List<IdentitySide> sides;
                @SerializedName("types")
                @Nullable
                private final List<String> types;
                @SerializedName("videoRequired")
                @Nullable
                private final String videoRequired;

                public DocSetsItem() {
                    this(null, null, null, null, null, null, 63, null);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.sumsub.sns.core.data.model.IdentitySide> */
                /* JADX WARN: Multi-variable type inference failed */
                public DocSetsItem(@Nullable String str, @Nullable List<String> list, @Nullable List<? extends IdentitySide> list2, @Nullable String str2, @Nullable List<ApplicantDataField.Field> list3, @Nullable List<ApplicantDataField.CustomField> list4) {
                    this.idDocSetType = str;
                    this.types = list;
                    this.sides = list2;
                    this.videoRequired = str2;
                    this.fields = list3;
                    this.customFields = list4;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$RequiredIdDocs$DocSetsItem */
                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ DocSetsItem copy$default(DocSetsItem docSetsItem, String str, List list, List list2, String str2, List list3, List list4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = docSetsItem.idDocSetType;
                    }
                    if ((i & 2) != 0) {
                        list = docSetsItem.types;
                    }
                    if ((i & 4) != 0) {
                        list2 = docSetsItem.sides;
                    }
                    if ((i & 8) != 0) {
                        str2 = docSetsItem.videoRequired;
                    }
                    if ((i & 16) != 0) {
                        list3 = docSetsItem.fields;
                    }
                    if ((i & 32) != 0) {
                        list4 = docSetsItem.customFields;
                    }
                    return docSetsItem.copy(str, list, list2, str2, list3, list4);
                }

                @Nullable
                public final String component1() {
                    return this.idDocSetType;
                }

                @Nullable
                public final List<String> component2() {
                    return this.types;
                }

                @Nullable
                public final List<IdentitySide> component3() {
                    return this.sides;
                }

                @Nullable
                public final String component4() {
                    return this.videoRequired;
                }

                @Nullable
                public final List<ApplicantDataField.Field> component5() {
                    return this.fields;
                }

                @Nullable
                public final List<ApplicantDataField.CustomField> component6() {
                    return this.customFields;
                }

                @NotNull
                public final DocSetsItem copy(@Nullable String str, @Nullable List<String> list, @Nullable List<? extends IdentitySide> list2, @Nullable String str2, @Nullable List<ApplicantDataField.Field> list3, @Nullable List<ApplicantDataField.CustomField> list4) {
                    return new DocSetsItem(str, list, list2, str2, list3, list4);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof DocSetsItem)) {
                        return false;
                    }
                    DocSetsItem docSetsItem = (DocSetsItem) obj;
                    return Intrinsics.areEqual(this.idDocSetType, docSetsItem.idDocSetType) && Intrinsics.areEqual(this.types, docSetsItem.types) && Intrinsics.areEqual(this.sides, docSetsItem.sides) && Intrinsics.areEqual(this.videoRequired, docSetsItem.videoRequired) && Intrinsics.areEqual(this.fields, docSetsItem.fields) && Intrinsics.areEqual(this.customFields, docSetsItem.customFields);
                }

                @Nullable
                public final List<ApplicantDataField.CustomField> getCustomFields() {
                    return this.customFields;
                }

                @Nullable
                public final List<ApplicantDataField.Field> getFields() {
                    return this.fields;
                }

                @Nullable
                public final String getIdDocSetType() {
                    return this.idDocSetType;
                }

                @Nullable
                public final List<IdentitySide> getSides() {
                    return this.sides;
                }

                @Nullable
                public final List<String> getTypes() {
                    return this.types;
                }

                @Nullable
                public final String getVideoRequired() {
                    return this.videoRequired;
                }

                public int hashCode() {
                    String str = this.idDocSetType;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    List<String> list = this.types;
                    int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                    List<IdentitySide> list2 = this.sides;
                    int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
                    String str2 = this.videoRequired;
                    int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
                    List<ApplicantDataField.Field> list3 = this.fields;
                    int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
                    List<ApplicantDataField.CustomField> list4 = this.customFields;
                    if (list4 != null) {
                        i = list4.hashCode();
                    }
                    return hashCode5 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("DocSetsItem(idDocSetType=");
                    L.append(this.idDocSetType);
                    L.append(", types=");
                    L.append(this.types);
                    L.append(", sides=");
                    L.append(this.sides);
                    L.append(", videoRequired=");
                    L.append(this.videoRequired);
                    L.append(", fields=");
                    L.append(this.fields);
                    L.append(", customFields=");
                    return a.w(L, this.customFields, ")");
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ DocSetsItem(String str, List list, List list2, String str2, List list3, List list4, int i, j jVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list3, (i & 32) != 0 ? null : list4);
                }
            }

            public RequiredIdDocs(@Nullable List<DocSetsItem> list, @Nullable List<String> list2, @Nullable List<String> list3) {
                this.docSets = list;
                this.includedCountries = list2;
                this.excludedCountries = list3;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$RequiredIdDocs */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ RequiredIdDocs copy$default(RequiredIdDocs requiredIdDocs, List list, List list2, List list3, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = requiredIdDocs.docSets;
                }
                if ((i & 2) != 0) {
                    list2 = requiredIdDocs.includedCountries;
                }
                if ((i & 4) != 0) {
                    list3 = requiredIdDocs.excludedCountries;
                }
                return requiredIdDocs.copy(list, list2, list3);
            }

            @Nullable
            public final List<DocSetsItem> component1() {
                return this.docSets;
            }

            @Nullable
            public final List<String> component2() {
                return this.includedCountries;
            }

            @Nullable
            public final List<String> component3() {
                return this.excludedCountries;
            }

            @NotNull
            public final RequiredIdDocs copy(@Nullable List<DocSetsItem> list, @Nullable List<String> list2, @Nullable List<String> list3) {
                return new RequiredIdDocs(list, list2, list3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RequiredIdDocs)) {
                    return false;
                }
                RequiredIdDocs requiredIdDocs = (RequiredIdDocs) obj;
                return Intrinsics.areEqual(this.docSets, requiredIdDocs.docSets) && Intrinsics.areEqual(this.includedCountries, requiredIdDocs.includedCountries) && Intrinsics.areEqual(this.excludedCountries, requiredIdDocs.excludedCountries);
            }

            @Nullable
            public final List<DocSetsItem> getDocSets() {
                return this.docSets;
            }

            @Nullable
            public final List<String> getExcludedCountries() {
                return this.excludedCountries;
            }

            @Nullable
            public final List<String> getIncludedCountries() {
                return this.includedCountries;
            }

            public int hashCode() {
                List<DocSetsItem> list = this.docSets;
                int i = 0;
                int hashCode = (list != null ? list.hashCode() : 0) * 31;
                List<String> list2 = this.includedCountries;
                int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                List<String> list3 = this.excludedCountries;
                if (list3 != null) {
                    i = list3.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("RequiredIdDocs(docSets=");
                L.append(this.docSets);
                L.append(", includedCountries=");
                L.append(this.includedCountries);
                L.append(", excludedCountries=");
                return a.w(L, this.excludedCountries, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ RequiredIdDocs(List list, List list2, List list3, int i, j jVar) {
                this((i & 1) != 0 ? null : list, list2, list3);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001:\u00016Bq\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b4\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0012J|\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010&\u001a\u0004\b'\u0010\u0012R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\u000eR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\u000bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b.\u0010\u000bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b/\u0010\u0004R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b0\u0010\u0012R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b1\u0010\u000bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\b3\u0010\u0007¨\u00067"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "", "", "component1", "()Ljava/lang/Integer;", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "component2", "()Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "component3", "", "component4", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "component5", "()Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "component6", "", "component7", "()Ljava/lang/Boolean;", "component8", "component9", "notificationFailureCnt", "reviewStatus", Constants.FirelogAnalytics.PARAM_PRIORITY, "createDate", "result", "reviewId", "reprocessing", "levelName", "autoChecked", "copy", "(Ljava/lang/Integer;Lcom/sumsub/sns/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getAutoChecked", "Ljava/lang/Integer;", "getPriority", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "getResult", "Ljava/lang/String;", "getReviewId", "getLevelName", "getNotificationFailureCnt", "getReprocessing", "getCreateDate", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "getReviewStatus", "<init>", "(Ljava/lang/Integer;Lcom/sumsub/sns/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "Result", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Review {
            @SerializedName("autoChecked")
            @Nullable
            private final Boolean autoChecked;
            @SerializedName("createDate")
            @Nullable
            private final String createDate;
            @SerializedName("levelName")
            @Nullable
            private final String levelName;
            @SerializedName("notificationFailureCnt")
            @Nullable
            private final Integer notificationFailureCnt;
            @SerializedName(Constants.FirelogAnalytics.PARAM_PRIORITY)
            @Nullable
            private final Integer priority;
            @SerializedName("reprocessing")
            @Nullable
            private final Boolean reprocessing;
            @SerializedName("reviewResult")
            @Nullable
            private final Result result;
            @SerializedName("reviewId")
            @Nullable
            private final String reviewId;
            @SerializedName("reviewStatus")
            @Nullable
            private final ReviewStatusType reviewStatus;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJR\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "component3", "()Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "", "component4", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "component5", "()Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "moderationComment", "clientComment", "reviewAnswer", "rejectLabels", "reviewRejectType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/core/data/model/ReviewRejectType;)Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review$Result;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getClientComment", "getModerationComment", "Ljava/util/List;", "getRejectLabels", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "getReviewAnswer", "Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "getReviewRejectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/core/data/model/ReviewRejectType;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
            public static final class Result {
                @SerializedName("clientComment")
                @Nullable
                private final String clientComment;
                @SerializedName("moderationComment")
                @Nullable
                private final String moderationComment;
                @SerializedName("rejectLabels")
                @Nullable
                private final List<String> rejectLabels;
                @SerializedName("reviewAnswer")
                @Nullable
                private final ReviewAnswerType reviewAnswer;
                @SerializedName("reviewRejectType")
                @Nullable
                private final ReviewRejectType reviewRejectType;

                public Result() {
                    this(null, null, null, null, null, 31, null);
                }

                public Result(@Nullable String str, @Nullable String str2, @Nullable ReviewAnswerType reviewAnswerType, @Nullable List<String> list, @Nullable ReviewRejectType reviewRejectType2) {
                    this.moderationComment = str;
                    this.clientComment = str2;
                    this.reviewAnswer = reviewAnswerType;
                    this.rejectLabels = list;
                    this.reviewRejectType = reviewRejectType2;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data$Review$Result */
                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Result copy$default(Result result, String str, String str2, ReviewAnswerType reviewAnswerType, List list, ReviewRejectType reviewRejectType2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = result.moderationComment;
                    }
                    if ((i & 2) != 0) {
                        str2 = result.clientComment;
                    }
                    if ((i & 4) != 0) {
                        reviewAnswerType = result.reviewAnswer;
                    }
                    if ((i & 8) != 0) {
                        list = result.rejectLabels;
                    }
                    if ((i & 16) != 0) {
                        reviewRejectType2 = result.reviewRejectType;
                    }
                    return result.copy(str, str2, reviewAnswerType, list, reviewRejectType2);
                }

                @Nullable
                public final String component1() {
                    return this.moderationComment;
                }

                @Nullable
                public final String component2() {
                    return this.clientComment;
                }

                @Nullable
                public final ReviewAnswerType component3() {
                    return this.reviewAnswer;
                }

                @Nullable
                public final List<String> component4() {
                    return this.rejectLabels;
                }

                @Nullable
                public final ReviewRejectType component5() {
                    return this.reviewRejectType;
                }

                @NotNull
                public final Result copy(@Nullable String str, @Nullable String str2, @Nullable ReviewAnswerType reviewAnswerType, @Nullable List<String> list, @Nullable ReviewRejectType reviewRejectType2) {
                    return new Result(str, str2, reviewAnswerType, list, reviewRejectType2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Result)) {
                        return false;
                    }
                    Result result = (Result) obj;
                    return Intrinsics.areEqual(this.moderationComment, result.moderationComment) && Intrinsics.areEqual(this.clientComment, result.clientComment) && Intrinsics.areEqual(this.reviewAnswer, result.reviewAnswer) && Intrinsics.areEqual(this.rejectLabels, result.rejectLabels) && Intrinsics.areEqual(this.reviewRejectType, result.reviewRejectType);
                }

                @Nullable
                public final String getClientComment() {
                    return this.clientComment;
                }

                @Nullable
                public final String getModerationComment() {
                    return this.moderationComment;
                }

                @Nullable
                public final List<String> getRejectLabels() {
                    return this.rejectLabels;
                }

                @Nullable
                public final ReviewAnswerType getReviewAnswer() {
                    return this.reviewAnswer;
                }

                @Nullable
                public final ReviewRejectType getReviewRejectType() {
                    return this.reviewRejectType;
                }

                public int hashCode() {
                    String str = this.moderationComment;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    String str2 = this.clientComment;
                    int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                    ReviewAnswerType reviewAnswerType = this.reviewAnswer;
                    int hashCode3 = (hashCode2 + (reviewAnswerType != null ? reviewAnswerType.hashCode() : 0)) * 31;
                    List<String> list = this.rejectLabels;
                    int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                    ReviewRejectType reviewRejectType2 = this.reviewRejectType;
                    if (reviewRejectType2 != null) {
                        i = reviewRejectType2.hashCode();
                    }
                    return hashCode4 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Result(moderationComment=");
                    L.append(this.moderationComment);
                    L.append(", clientComment=");
                    L.append(this.clientComment);
                    L.append(", reviewAnswer=");
                    L.append(this.reviewAnswer);
                    L.append(", rejectLabels=");
                    L.append(this.rejectLabels);
                    L.append(", reviewRejectType=");
                    L.append(this.reviewRejectType);
                    L.append(")");
                    return L.toString();
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Result(String str, String str2, ReviewAnswerType reviewAnswerType, List list, ReviewRejectType reviewRejectType2, int i, j jVar) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : reviewAnswerType, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : reviewRejectType2);
                }
            }

            public Review(@Nullable Integer num, @Nullable ReviewStatusType reviewStatusType, @Nullable Integer num2, @Nullable String str, @Nullable Result result2, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Boolean bool2) {
                this.notificationFailureCnt = num;
                this.reviewStatus = reviewStatusType;
                this.priority = num2;
                this.createDate = str;
                this.result = result2;
                this.reviewId = str2;
                this.reprocessing = bool;
                this.levelName = str3;
                this.autoChecked = bool2;
            }

            public static /* synthetic */ Review copy$default(Review review, Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, Result result2, String str2, Boolean bool, String str3, Boolean bool2, int i, Object obj) {
                return review.copy((i & 1) != 0 ? review.notificationFailureCnt : num, (i & 2) != 0 ? review.reviewStatus : reviewStatusType, (i & 4) != 0 ? review.priority : num2, (i & 8) != 0 ? review.createDate : str, (i & 16) != 0 ? review.result : result2, (i & 32) != 0 ? review.reviewId : str2, (i & 64) != 0 ? review.reprocessing : bool, (i & 128) != 0 ? review.levelName : str3, (i & 256) != 0 ? review.autoChecked : bool2);
            }

            @Nullable
            public final Integer component1() {
                return this.notificationFailureCnt;
            }

            @Nullable
            public final ReviewStatusType component2() {
                return this.reviewStatus;
            }

            @Nullable
            public final Integer component3() {
                return this.priority;
            }

            @Nullable
            public final String component4() {
                return this.createDate;
            }

            @Nullable
            public final Result component5() {
                return this.result;
            }

            @Nullable
            public final String component6() {
                return this.reviewId;
            }

            @Nullable
            public final Boolean component7() {
                return this.reprocessing;
            }

            @Nullable
            public final String component8() {
                return this.levelName;
            }

            @Nullable
            public final Boolean component9() {
                return this.autoChecked;
            }

            @NotNull
            public final Review copy(@Nullable Integer num, @Nullable ReviewStatusType reviewStatusType, @Nullable Integer num2, @Nullable String str, @Nullable Result result2, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Boolean bool2) {
                return new Review(num, reviewStatusType, num2, str, result2, str2, bool, str3, bool2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Review)) {
                    return false;
                }
                Review review = (Review) obj;
                return Intrinsics.areEqual(this.notificationFailureCnt, review.notificationFailureCnt) && Intrinsics.areEqual(this.reviewStatus, review.reviewStatus) && Intrinsics.areEqual(this.priority, review.priority) && Intrinsics.areEqual(this.createDate, review.createDate) && Intrinsics.areEqual(this.result, review.result) && Intrinsics.areEqual(this.reviewId, review.reviewId) && Intrinsics.areEqual(this.reprocessing, review.reprocessing) && Intrinsics.areEqual(this.levelName, review.levelName) && Intrinsics.areEqual(this.autoChecked, review.autoChecked);
            }

            @Nullable
            public final Boolean getAutoChecked() {
                return this.autoChecked;
            }

            @Nullable
            public final String getCreateDate() {
                return this.createDate;
            }

            @Nullable
            public final String getLevelName() {
                return this.levelName;
            }

            @Nullable
            public final Integer getNotificationFailureCnt() {
                return this.notificationFailureCnt;
            }

            @Nullable
            public final Integer getPriority() {
                return this.priority;
            }

            @Nullable
            public final Boolean getReprocessing() {
                return this.reprocessing;
            }

            @Nullable
            public final Result getResult() {
                return this.result;
            }

            @Nullable
            public final String getReviewId() {
                return this.reviewId;
            }

            @Nullable
            public final ReviewStatusType getReviewStatus() {
                return this.reviewStatus;
            }

            public int hashCode() {
                Integer num = this.notificationFailureCnt;
                int i = 0;
                int hashCode = (num != null ? num.hashCode() : 0) * 31;
                ReviewStatusType reviewStatusType = this.reviewStatus;
                int hashCode2 = (hashCode + (reviewStatusType != null ? reviewStatusType.hashCode() : 0)) * 31;
                Integer num2 = this.priority;
                int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
                String str = this.createDate;
                int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                Result result2 = this.result;
                int hashCode5 = (hashCode4 + (result2 != null ? result2.hashCode() : 0)) * 31;
                String str2 = this.reviewId;
                int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
                Boolean bool = this.reprocessing;
                int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
                String str3 = this.levelName;
                int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
                Boolean bool2 = this.autoChecked;
                if (bool2 != null) {
                    i = bool2.hashCode();
                }
                return hashCode8 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Review(notificationFailureCnt=");
                L.append(this.notificationFailureCnt);
                L.append(", reviewStatus=");
                L.append(this.reviewStatus);
                L.append(", priority=");
                L.append(this.priority);
                L.append(", createDate=");
                L.append(this.createDate);
                L.append(", result=");
                L.append(this.result);
                L.append(", reviewId=");
                L.append(this.reviewId);
                L.append(", reprocessing=");
                L.append(this.reprocessing);
                L.append(", levelName=");
                L.append(this.levelName);
                L.append(", autoChecked=");
                return a.o(L, this.autoChecked, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Review(Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, Result result2, String str2, Boolean bool, String str3, Boolean bool2, int i, j jVar) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : reviewStatusType, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str, result2, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : bool2);
            }
        }

        public Data() {
            this(null, 1, null);
        }

        public Data(@Nullable List<Item> list) {
            this.items = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse$Data */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = data.items;
            }
            return data.copy(list);
        }

        @Nullable
        public final List<Item> component1() {
            return this.items;
        }

        @NotNull
        public final Data copy(@Nullable List<Item> list) {
            return new Data(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Data) && Intrinsics.areEqual(this.items, ((Data) obj).items);
            }
            return true;
        }

        @Nullable
        public final List<Item> getItems() {
            return this.items;
        }

        public int hashCode() {
            List<Item> list = this.items;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.w(a.L("Data(items="), this.items, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(List list, int i, j jVar) {
            this((i & 1) != 0 ? null : list);
        }
    }

    public ListApplicantsResponse() {
        this(null, 1, null);
    }

    public ListApplicantsResponse(@Nullable Data data2) {
        this.data = data2;
    }

    public static /* synthetic */ ListApplicantsResponse copy$default(ListApplicantsResponse listApplicantsResponse, Data data2, int i, Object obj) {
        if ((i & 1) != 0) {
            data2 = listApplicantsResponse.data;
        }
        return listApplicantsResponse.copy(data2);
    }

    @Nullable
    public final Data component1() {
        return this.data;
    }

    @NotNull
    public final ListApplicantsResponse copy(@Nullable Data data2) {
        return new ListApplicantsResponse(data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ListApplicantsResponse) && Intrinsics.areEqual(this.data, ((ListApplicantsResponse) obj).data);
        }
        return true;
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        Data data2 = this.data;
        if (data2 != null) {
            return data2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ListApplicantsResponse(data=");
        L.append(this.data);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListApplicantsResponse(Data data2, int i, j jVar) {
        this((i & 1) != 0 ? null : data2);
    }
}
