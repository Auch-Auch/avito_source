package ru.sravni.android.bankproduct.network.offer.entity.response;

import a2.b.a.a.a;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001$B-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ>\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u000bR\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\bR\u001c\u0010\u000f\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b!\u0010\u000b¨\u0006%"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "toOfferFilterRepo", "()Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "", "Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "component4", ErrorBundle.DETAIL_ENTRY, "filterIcon", "filterName", "title", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFilterName", "getTitle", "Ljava/util/List;", "getDetails", "getFilterIcon", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "DetailFilterResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferFilterResponse {
    @SerializedName(ErrorBundle.DETAIL_ENTRY)
    @NotNull
    private final List<DetailFilterResponse> details;
    @SerializedName("filterIcon")
    @NotNull
    private final String filterIcon;
    @SerializedName("filterName")
    @NotNull
    private final String filterName;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b$\u0010%J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ@\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b#\u0010\u0007¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo;", "toDetailFilterRepo", "()Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "", "Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse$ValueResponse;", "component4", "()Ljava/util/List;", "title", "valueType", "editable", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValueType", "Ljava/lang/Boolean;", "getEditable", "Ljava/util/List;", "getValues", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "ValueResponse", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class DetailFilterResponse {
        @SerializedName("editable")
        @Nullable
        private final Boolean editable;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("valueType")
        @NotNull
        private final String valueType;
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @NotNull
        private final List<ValueResponse> values;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse$ValueResponse;", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo$ValueRepo;", "toValueRepo", "()Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo$DetailRepo$ValueRepo;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "code", "title", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/offer/entity/response/OfferFilterResponse$DetailFilterResponse$ValueResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValue", "getTitle", "getCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class ValueResponse {
            @SerializedName("code")
            @NotNull
            private final String code;
            @SerializedName("title")
            @NotNull
            private final String title;
            @SerializedName("value")
            @NotNull
            private final String value;

            public ValueResponse(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                a.a1(str, "code", str2, "title", str3, "value");
                this.code = str;
                this.title = str2;
                this.value = str3;
            }

            public static /* synthetic */ ValueResponse copy$default(ValueResponse valueResponse, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valueResponse.code;
                }
                if ((i & 2) != 0) {
                    str2 = valueResponse.title;
                }
                if ((i & 4) != 0) {
                    str3 = valueResponse.value;
                }
                return valueResponse.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.code;
            }

            @NotNull
            public final String component2() {
                return this.title;
            }

            @NotNull
            public final String component3() {
                return this.value;
            }

            @NotNull
            public final ValueResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str, "code");
                Intrinsics.checkParameterIsNotNull(str2, "title");
                Intrinsics.checkParameterIsNotNull(str3, "value");
                return new ValueResponse(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ValueResponse)) {
                    return false;
                }
                ValueResponse valueResponse = (ValueResponse) obj;
                return Intrinsics.areEqual(this.code, valueResponse.code) && Intrinsics.areEqual(this.title, valueResponse.title) && Intrinsics.areEqual(this.value, valueResponse.value);
            }

            @NotNull
            public final String getCode() {
                return this.code;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                String str = this.code;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.title;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.value;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ValueResponse(code=");
                L.append(this.code);
                L.append(", title=");
                L.append(this.title);
                L.append(", value=");
                return a.t(L, this.value, ")");
            }

            @NotNull
            public final OfferFilterRepo.DetailRepo.ValueRepo toValueRepo() {
                return new OfferFilterRepo.DetailRepo.ValueRepo(this.code, this.title, this.value);
            }
        }

        public DetailFilterResponse(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @NotNull List<ValueResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "valueType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            this.title = str;
            this.valueType = str2;
            this.editable = bool;
            this.values = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.entity.response.OfferFilterResponse$DetailFilterResponse */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DetailFilterResponse copy$default(DetailFilterResponse detailFilterResponse, String str, String str2, Boolean bool, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = detailFilterResponse.title;
            }
            if ((i & 2) != 0) {
                str2 = detailFilterResponse.valueType;
            }
            if ((i & 4) != 0) {
                bool = detailFilterResponse.editable;
            }
            if ((i & 8) != 0) {
                list = detailFilterResponse.values;
            }
            return detailFilterResponse.copy(str, str2, bool, list);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final String component2() {
            return this.valueType;
        }

        @Nullable
        public final Boolean component3() {
            return this.editable;
        }

        @NotNull
        public final List<ValueResponse> component4() {
            return this.values;
        }

        @NotNull
        public final DetailFilterResponse copy(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @NotNull List<ValueResponse> list) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "valueType");
            Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
            return new DetailFilterResponse(str, str2, bool, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DetailFilterResponse)) {
                return false;
            }
            DetailFilterResponse detailFilterResponse = (DetailFilterResponse) obj;
            return Intrinsics.areEqual(this.title, detailFilterResponse.title) && Intrinsics.areEqual(this.valueType, detailFilterResponse.valueType) && Intrinsics.areEqual(this.editable, detailFilterResponse.editable) && Intrinsics.areEqual(this.values, detailFilterResponse.values);
        }

        @Nullable
        public final Boolean getEditable() {
            return this.editable;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getValueType() {
            return this.valueType;
        }

        @NotNull
        public final List<ValueResponse> getValues() {
            return this.values;
        }

        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.valueType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool = this.editable;
            int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
            List<ValueResponse> list = this.values;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public final OfferFilterRepo.DetailRepo toDetailFilterRepo() {
            String str = this.title;
            String str2 = this.valueType;
            Boolean bool = this.editable;
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            List<ValueResponse> list = this.values;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toValueRepo());
            }
            return new OfferFilterRepo.DetailRepo(str, str2, booleanValue, arrayList);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DetailFilterResponse(title=");
            L.append(this.title);
            L.append(", valueType=");
            L.append(this.valueType);
            L.append(", editable=");
            L.append(this.editable);
            L.append(", values=");
            return a.w(L, this.values, ")");
        }
    }

    public OfferFilterResponse(@NotNull List<DetailFilterResponse> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(list, ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "title");
        this.details = list;
        this.filterIcon = str;
        this.filterName = str2;
        this.title = str3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.offer.entity.response.OfferFilterResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferFilterResponse copy$default(OfferFilterResponse offerFilterResponse, List list, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = offerFilterResponse.details;
        }
        if ((i & 2) != 0) {
            str = offerFilterResponse.filterIcon;
        }
        if ((i & 4) != 0) {
            str2 = offerFilterResponse.filterName;
        }
        if ((i & 8) != 0) {
            str3 = offerFilterResponse.title;
        }
        return offerFilterResponse.copy(list, str, str2, str3);
    }

    @NotNull
    public final List<DetailFilterResponse> component1() {
        return this.details;
    }

    @NotNull
    public final String component2() {
        return this.filterIcon;
    }

    @NotNull
    public final String component3() {
        return this.filterName;
    }

    @NotNull
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final OfferFilterResponse copy(@NotNull List<DetailFilterResponse> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(list, ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkParameterIsNotNull(str, "filterIcon");
        Intrinsics.checkParameterIsNotNull(str2, "filterName");
        Intrinsics.checkParameterIsNotNull(str3, "title");
        return new OfferFilterResponse(list, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferFilterResponse)) {
            return false;
        }
        OfferFilterResponse offerFilterResponse = (OfferFilterResponse) obj;
        return Intrinsics.areEqual(this.details, offerFilterResponse.details) && Intrinsics.areEqual(this.filterIcon, offerFilterResponse.filterIcon) && Intrinsics.areEqual(this.filterName, offerFilterResponse.filterName) && Intrinsics.areEqual(this.title, offerFilterResponse.title);
    }

    @NotNull
    public final List<DetailFilterResponse> getDetails() {
        return this.details;
    }

    @NotNull
    public final String getFilterIcon() {
        return this.filterIcon;
    }

    @NotNull
    public final String getFilterName() {
        return this.filterName;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        List<DetailFilterResponse> list = this.details;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.filterIcon;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filterName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public final OfferFilterRepo toOfferFilterRepo() {
        String str = this.filterIcon;
        String str2 = this.filterName;
        String str3 = this.title;
        List<DetailFilterResponse> list = this.details;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toDetailFilterRepo());
        }
        return new OfferFilterRepo(arrayList, str, str2, str3);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferFilterResponse(details=");
        L.append(this.details);
        L.append(", filterIcon=");
        L.append(this.filterIcon);
        L.append(", filterName=");
        L.append(this.filterName);
        L.append(", title=");
        return a.t(L, this.title, ")");
    }
}
