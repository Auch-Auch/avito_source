package com.avito.android.remote.model.search;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.q;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&¢\u0006\u0004\b\u000e\u0010\u000f\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue;", "Landroid/os/Parcelable;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "<init>", "()V", "InlineFilterDateRangeValue", "InlineFilterMultiSelectValue", "InlineFilterNumericRangeValue", "InlineFilterSelectIntValue", "InlineFilterSelectValue", "InlineFilterShortcutValue", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectIntValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterShortcutValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterNumericRangeValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class InlineFilterValue implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b.\u0010/J\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J(\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b$\u0010\u001fJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b)\u0010*R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u0015R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b-\u0010\u0015¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/Pair;", "", "formatFromToAsPair", "()Lkotlin/Pair;", "", "isEmpty", "()Z", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "Ljava/util/Date;", "component1", "()Ljava/util/Date;", "component2", "from", "to", "copy", "(Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterDateRangeValue;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Date;", "getFrom", "getTo", "<init>", "(Ljava/util/Date;Ljava/util/Date;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterDateRangeValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterDateRangeValue> CREATOR = new Creator();
        @SerializedName("from")
        @Nullable
        private final Date from;
        @SerializedName("to")
        @Nullable
        private final Date to;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterDateRangeValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterDateRangeValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InlineFilterDateRangeValue((Date) parcel.readSerializable(), (Date) parcel.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterDateRangeValue[] newArray(int i) {
                return new InlineFilterDateRangeValue[i];
            }
        }

        public InlineFilterDateRangeValue(@Nullable Date date, @Nullable Date date2) {
            super(null);
            this.from = date;
            this.to = date2;
        }

        public static /* synthetic */ InlineFilterDateRangeValue copy$default(InlineFilterDateRangeValue inlineFilterDateRangeValue, Date date, Date date2, int i, Object obj) {
            if ((i & 1) != 0) {
                date = inlineFilterDateRangeValue.from;
            }
            if ((i & 2) != 0) {
                date2 = inlineFilterDateRangeValue.to;
            }
            return inlineFilterDateRangeValue.copy(date, date2);
        }

        private final Pair<String, String> formatFromToAsPair() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = this.from;
            String str = "";
            String format = date == null ? str : simpleDateFormat.format(date);
            Date date2 = this.to;
            if (date2 != null) {
                str = simpleDateFormat.format(date2);
            }
            return new Pair<>(format, str);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            Pair<String, String> formatFromToAsPair = formatFromToAsPair();
            String component1 = formatFromToAsPair.component1();
            String component2 = formatFromToAsPair.component2();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = true;
            if (component1.length() > 0) {
                linkedHashMap.put("changedParamValueFrom", component1);
            }
            if (component2.length() <= 0) {
                z = false;
            }
            if (z) {
                linkedHashMap.put("changedParamValueTo", component2);
            }
            return linkedHashMap;
        }

        @Nullable
        public final Date component1() {
            return this.from;
        }

        @Nullable
        public final Date component2() {
            return this.to;
        }

        @NotNull
        public final InlineFilterDateRangeValue copy(@Nullable Date date, @Nullable Date date2) {
            return new InlineFilterDateRangeValue(date, date2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InlineFilterDateRangeValue)) {
                return false;
            }
            InlineFilterDateRangeValue inlineFilterDateRangeValue = (InlineFilterDateRangeValue) obj;
            return Intrinsics.areEqual(this.from, inlineFilterDateRangeValue.from) && Intrinsics.areEqual(this.to, inlineFilterDateRangeValue.to);
        }

        @Nullable
        public final Date getFrom() {
            return this.from;
        }

        @Nullable
        public final Date getTo() {
            return this.to;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Date date = this.from;
            int i = 0;
            int hashCode = (date != null ? date.hashCode() : 0) * 31;
            Date date2 = this.to;
            if (date2 != null) {
                i = date2.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            return this.from == null && this.to == null;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            if (str2 == null) {
                str2 = "yyyy-MM-dd";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
            Date date = this.from;
            String str3 = "";
            String format = date == null ? str3 : simpleDateFormat.format(date);
            Date date2 = this.to;
            if (date2 != null) {
                str3 = simpleDateFormat.format(date2);
            }
            return r.mapOf(TuplesKt.to(str + "[from]", format), TuplesKt.to(str + "[to]", str3));
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("InlineFilterDateRangeValue(from=");
            L.append(this.from);
            L.append(", to=");
            L.append(this.to);
            L.append(")");
            return L.toString();
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            Pair<String, String> formatFromToAsPair = formatFromToAsPair();
            return CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{formatFromToAsPair.component1(), formatFromToAsPair.component2()});
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.from);
            parcel.writeSerializable(this.to);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\"\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\"\u0010#R!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "component1", "selectedOptions", "copy", "(Ljava/util/List;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterMultiSelectValue;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSelectedOptions", "<init>", "(Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterMultiSelectValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterMultiSelectValue> CREATOR = new Creator();
        @Nullable
        private final List<String> selectedOptions;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterMultiSelectValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterMultiSelectValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InlineFilterMultiSelectValue(parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterMultiSelectValue[] newArray(int i) {
                return new InlineFilterMultiSelectValue[i];
            }
        }

        public InlineFilterMultiSelectValue(@Nullable List<String> list) {
            super(null);
            this.selectedOptions = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.search.InlineFilterValue$InlineFilterMultiSelectValue */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InlineFilterMultiSelectValue copy$default(InlineFilterMultiSelectValue inlineFilterMultiSelectValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = inlineFilterMultiSelectValue.selectedOptions;
            }
            return inlineFilterMultiSelectValue.copy(list);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            List<String> list = this.selectedOptions;
            if (!(list == null || list.isEmpty())) {
                return q.mapOf(TuplesKt.to("changedParamValueList", CollectionsKt___CollectionsKt.joinToString$default(this.selectedOptions, ",", null, null, 0, null, null, 62, null)));
            }
            return r.emptyMap();
        }

        @Nullable
        public final List<String> component1() {
            return this.selectedOptions;
        }

        @NotNull
        public final InlineFilterMultiSelectValue copy(@Nullable List<String> list) {
            return new InlineFilterMultiSelectValue(list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InlineFilterMultiSelectValue) && Intrinsics.areEqual(this.selectedOptions, ((InlineFilterMultiSelectValue) obj).selectedOptions);
            }
            return true;
        }

        @Nullable
        public final List<String> getSelectedOptions() {
            return this.selectedOptions;
        }

        @Override // java.lang.Object
        public int hashCode() {
            List<String> list = this.selectedOptions;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            List<String> list = this.selectedOptions;
            return list == null || list.isEmpty();
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<String> list = this.selectedOptions;
            int i = 0;
            if (!(list == null || list.isEmpty())) {
                for (T t : this.selectedOptions) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    linkedHashMap.put(str + '[' + i + ']', t);
                    i = i2;
                }
            } else {
                linkedHashMap.put(str, "");
            }
            return linkedHashMap;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.w(a.L("InlineFilterMultiSelectValue(selectedOptions="), this.selectedOptions, ")");
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            List<String> list = this.selectedOptions;
            return list != null ? list : CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeStringList(this.selectedOptions);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J(\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b!\u0010\u001cJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b&\u0010'R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b*\u0010\u0012¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterNumericRangeValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "", "component1", "()Ljava/lang/Long;", "component2", "from", "to", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterNumericRangeValue;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getTo", "getFrom", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterNumericRangeValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterNumericRangeValue> CREATOR = new Creator();
        @SerializedName("from")
        @Nullable
        private final Long from;
        @SerializedName("to")
        @Nullable
        private final Long to;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterNumericRangeValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterNumericRangeValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Long l = null;
                Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
                if (parcel.readInt() != 0) {
                    l = Long.valueOf(parcel.readLong());
                }
                return new InlineFilterNumericRangeValue(valueOf, l);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterNumericRangeValue[] newArray(int i) {
                return new InlineFilterNumericRangeValue[i];
            }
        }

        public InlineFilterNumericRangeValue(@Nullable Long l, @Nullable Long l2) {
            super(null);
            this.from = l;
            this.to = l2;
        }

        public static /* synthetic */ InlineFilterNumericRangeValue copy$default(InlineFilterNumericRangeValue inlineFilterNumericRangeValue, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = inlineFilterNumericRangeValue.from;
            }
            if ((i & 2) != 0) {
                l2 = inlineFilterNumericRangeValue.to;
            }
            return inlineFilterNumericRangeValue.copy(l, l2);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Long l = this.from;
            if (l != null) {
                linkedHashMap.put("changedParamValueIntFrom", String.valueOf(l.longValue()));
            }
            Long l2 = this.to;
            if (l2 != null) {
                linkedHashMap.put("changedParamValueIntTo", String.valueOf(l2.longValue()));
            }
            return linkedHashMap;
        }

        @Nullable
        public final Long component1() {
            return this.from;
        }

        @Nullable
        public final Long component2() {
            return this.to;
        }

        @NotNull
        public final InlineFilterNumericRangeValue copy(@Nullable Long l, @Nullable Long l2) {
            return new InlineFilterNumericRangeValue(l, l2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InlineFilterNumericRangeValue)) {
                return false;
            }
            InlineFilterNumericRangeValue inlineFilterNumericRangeValue = (InlineFilterNumericRangeValue) obj;
            return Intrinsics.areEqual(this.from, inlineFilterNumericRangeValue.from) && Intrinsics.areEqual(this.to, inlineFilterNumericRangeValue.to);
        }

        @Nullable
        public final Long getFrom() {
            return this.from;
        }

        @Nullable
        public final Long getTo() {
            return this.to;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Long l = this.from;
            int i = 0;
            int hashCode = (l != null ? l.hashCode() : 0) * 31;
            Long l2 = this.to;
            if (l2 != null) {
                i = l2.hashCode();
            }
            return hashCode + i;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            return this.from == null && this.to == null;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            return r.mapOf(TuplesKt.to(a.c3(str, "[from]"), String.valueOf(this.from)), TuplesKt.to(a.c3(str, "[to]"), String.valueOf(this.to)));
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("InlineFilterNumericRangeValue(from=");
            L.append(this.from);
            L.append(", to=");
            L.append(this.to);
            L.append(")");
            return L.toString();
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0016: APUT  (r0v1 java.lang.String[]), (0 ??[int, short, byte, char]), (r1v1 java.lang.String) */
        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            String str;
            String valueOf;
            String[] strArr = new String[2];
            Long l = this.from;
            String str2 = "";
            if (l == null || (str = String.valueOf(l.longValue())) == null) {
                str = str2;
            }
            strArr[0] = str;
            Long l2 = this.to;
            if (!(l2 == null || (valueOf = String.valueOf(l2.longValue())) == null)) {
                str2 = valueOf;
            }
            strArr[1] = str2;
            return CollectionsKt__CollectionsKt.listOf((Object[]) strArr);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long l = this.from;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            Long l2 = this.to;
            if (l2 != null) {
                a.I0(parcel, 1, l2);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0012J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0013\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0012¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectIntValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "", "component1", "()I", "selectedOption", "copy", "(I)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectIntValue;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getSelectedOption", "<init>", "(I)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterSelectIntValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterSelectIntValue> CREATOR = new Creator();
        private final int selectedOption;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterSelectIntValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterSelectIntValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InlineFilterSelectIntValue(parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterSelectIntValue[] newArray(int i) {
                return new InlineFilterSelectIntValue[i];
            }
        }

        public InlineFilterSelectIntValue(int i) {
            super(null);
            this.selectedOption = i;
        }

        public static /* synthetic */ InlineFilterSelectIntValue copy$default(InlineFilterSelectIntValue inlineFilterSelectIntValue, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = inlineFilterSelectIntValue.selectedOption;
            }
            return inlineFilterSelectIntValue.copy(i);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            int i = this.selectedOption;
            if (i != 0) {
                return q.mapOf(TuplesKt.to("changedParamValueInt", String.valueOf(i)));
            }
            return r.emptyMap();
        }

        public final int component1() {
            return this.selectedOption;
        }

        @NotNull
        public final InlineFilterSelectIntValue copy(int i) {
            return new InlineFilterSelectIntValue(i);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InlineFilterSelectIntValue) && this.selectedOption == ((InlineFilterSelectIntValue) obj).selectedOption;
            }
            return true;
        }

        public final int getSelectedOption() {
            return this.selectedOption;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.selectedOption;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            return this.selectedOption == 0;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            return q.mapOf(TuplesKt.to(str, String.valueOf(this.selectedOption)));
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.j(a.L("InlineFilterSelectIntValue(selectedOption="), this.selectedOption, ")");
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            int i = this.selectedOption;
            return i != 0 ? d.listOf(String.valueOf(i)) : CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.selectedOption);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0011¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "component1", "()Ljava/lang/String;", "selectedOption", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterSelectValue;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSelectedOption", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterSelectValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterSelectValue> CREATOR = new Creator();
        @Nullable
        private final String selectedOption;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterSelectValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterSelectValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InlineFilterSelectValue(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterSelectValue[] newArray(int i) {
                return new InlineFilterSelectValue[i];
            }
        }

        public InlineFilterSelectValue(@Nullable String str) {
            super(null);
            this.selectedOption = str;
        }

        public static /* synthetic */ InlineFilterSelectValue copy$default(InlineFilterSelectValue inlineFilterSelectValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = inlineFilterSelectValue.selectedOption;
            }
            return inlineFilterSelectValue.copy(str);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            String str = this.selectedOption;
            if (str == null) {
                str = "";
            }
            return q.mapOf(TuplesKt.to("changedParamValue", str));
        }

        @Nullable
        public final String component1() {
            return this.selectedOption;
        }

        @NotNull
        public final InlineFilterSelectValue copy(@Nullable String str) {
            return new InlineFilterSelectValue(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InlineFilterSelectValue) && Intrinsics.areEqual(this.selectedOption, ((InlineFilterSelectValue) obj).selectedOption);
            }
            return true;
        }

        @Nullable
        public final String getSelectedOption() {
            return this.selectedOption;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.selectedOption;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            String str = this.selectedOption;
            return str == null || str.length() == 0;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            String str3 = this.selectedOption;
            if (str3 == null) {
                str3 = "";
            }
            return q.mapOf(TuplesKt.to(str, str3));
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("InlineFilterSelectValue(selectedOption="), this.selectedOption, ")");
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            String str = this.selectedOption;
            return str != null ? d.listOf(str) : CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.selectedOption);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u0012¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterShortcutValue;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "isEmpty", "()Z", "", "filterId", "format", "", "queryMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "changedParamsMap", "()Ljava/util/Map;", "", "toStringList", "()Ljava/util/List;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/search/InlineFilterValue$InlineFilterShortcutValue;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InlineFilterShortcutValue extends InlineFilterValue {
        public static final Parcelable.Creator<InlineFilterShortcutValue> CREATOR = new Creator();
        @SerializedName("deeplink")
        @Nullable
        private final DeepLink deepLink;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InlineFilterShortcutValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterShortcutValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InlineFilterShortcutValue((DeepLink) parcel.readParcelable(InlineFilterShortcutValue.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InlineFilterShortcutValue[] newArray(int i) {
                return new InlineFilterShortcutValue[i];
            }
        }

        public InlineFilterShortcutValue(@Nullable DeepLink deepLink2) {
            super(null);
            this.deepLink = deepLink2;
        }

        public static /* synthetic */ InlineFilterShortcutValue copy$default(InlineFilterShortcutValue inlineFilterShortcutValue, DeepLink deepLink2, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink2 = inlineFilterShortcutValue.deepLink;
            }
            return inlineFilterShortcutValue.copy(deepLink2);
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> changedParamsMap() {
            return r.emptyMap();
        }

        @Nullable
        public final DeepLink component1() {
            return this.deepLink;
        }

        @NotNull
        public final InlineFilterShortcutValue copy(@Nullable DeepLink deepLink2) {
            return new InlineFilterShortcutValue(deepLink2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InlineFilterShortcutValue) && Intrinsics.areEqual(this.deepLink, ((InlineFilterShortcutValue) obj).deepLink);
            }
            return true;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Override // java.lang.Object
        public int hashCode() {
            DeepLink deepLink2 = this.deepLink;
            if (deepLink2 != null) {
                return deepLink2.hashCode();
            }
            return 0;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        public boolean isEmpty() {
            return this.deepLink == null;
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public Map<String, String> queryMap(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "filterId");
            return r.emptyMap();
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.m(a.L("InlineFilterShortcutValue(deepLink="), this.deepLink, ")");
        }

        @Override // com.avito.android.remote.model.search.InlineFilterValue
        @NotNull
        public List<String> toStringList() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.deepLink, i);
        }
    }

    private InlineFilterValue() {
    }

    public static /* synthetic */ Map queryMap$default(InlineFilterValue inlineFilterValue, String str, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return inlineFilterValue.queryMap(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMap");
    }

    @NotNull
    public abstract Map<String, String> changedParamsMap();

    public abstract boolean isEmpty();

    @NotNull
    public abstract Map<String, String> queryMap(@NotNull String str, @Nullable String str2);

    @NotNull
    public abstract List<String> toStringList();

    public /* synthetic */ InlineFilterValue(j jVar) {
        this();
    }
}
