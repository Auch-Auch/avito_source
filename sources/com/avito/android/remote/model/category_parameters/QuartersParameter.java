package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.Quarter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IBS\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jd\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b!\u0010\bJ\u0010\u0010\"\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b-\u0010.R\u001c\u0010\u001a\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\u0012R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u00108R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\u0012\n\u0004\b<\u0010=\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\bC\u0010\u000bR\"\u0010D\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\u0012\n\u0004\bD\u0010=\u0012\u0004\bF\u0010A\u001a\u0004\bE\u0010?¨\u0006J"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/QuartersParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "Lcom/avito/android/remote/model/Quarter;", "getSelectedValue", "()Lcom/avito/android/remote/model/Quarter;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component5", "()Ljava/lang/Boolean;", "component6", "()Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "", "component7", "()Ljava/util/List;", "id", "attributeId", "title", "motivation", "updatesForm", "_value", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/QuartersParameter;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Ljava/lang/Boolean;", "getUpdatesForm", "Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "get_value", "set_value", "(Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;)V", "Ljava/util/List;", "getValues", "getId", "immutable", "Z", "getImmutable", "()Z", "getImmutable$annotations", "()V", "Ljava/lang/Integer;", "getAttributeId", "required", "getRequired", "getRequired$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;Ljava/util/List;)V", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
public final class QuartersParameter extends EditableParameter<Value> {
    public static final Parcelable.Creator<QuartersParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Value _value;
    @SerializedName("attrId")
    @Nullable
    private final Integer attributeId;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    private final boolean required;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<Quarter> values;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<QuartersParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final QuartersParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString2 = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(QuartersParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            Value createFromParcel = parcel.readInt() != 0 ? Value.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Quarter.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new QuartersParameter(readString, valueOf, readString2, attributedText, bool, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final QuartersParameter[] newArray(int i) {
            return new QuartersParameter[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/QuartersParameter$Value;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "to", "Ljava/lang/Integer;", "getTo", "()Ljava/lang/Integer;", "from", "getFrom", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value implements Parcelable {
        public static final Parcelable.Creator<Value> CREATOR = new Creator();
        @SerializedName("from")
        @Nullable
        private final Integer from;
        @SerializedName("to")
        @Nullable
        private final Integer to;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Value> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Integer num = null;
                Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                if (parcel.readInt() != 0) {
                    num = Integer.valueOf(parcel.readInt());
                }
                return new Value(valueOf, num);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value[] newArray(int i) {
                return new Value[i];
            }
        }

        public Value(@Nullable Integer num, @Nullable Integer num2) {
            this.to = num;
            this.from = num2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Integer getFrom() {
            return this.from;
        }

        @Nullable
        public final Integer getTo() {
            return this.to;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer num = this.to;
            if (num != null) {
                a.H0(parcel, 1, num);
            } else {
                parcel.writeInt(0);
            }
            Integer num2 = this.from;
            if (num2 != null) {
                a.H0(parcel, 1, num2);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuartersParameter(String str, Integer num, String str2, AttributedText attributedText, Boolean bool, Value value, List list, int i, j jVar) {
        this(str, (i & 2) != 0 ? -1 : num, str2, attributedText, bool, (i & 32) != 0 ? null : value, (i & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.category_parameters.QuartersParameter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuartersParameter copy$default(QuartersParameter quartersParameter, String str, Integer num, String str2, AttributedText attributedText, Boolean bool, Value value, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quartersParameter.getId();
        }
        if ((i & 2) != 0) {
            num = quartersParameter.attributeId;
        }
        if ((i & 4) != 0) {
            str2 = quartersParameter.getTitle();
        }
        if ((i & 8) != 0) {
            attributedText = quartersParameter.getMotivation();
        }
        if ((i & 16) != 0) {
            bool = quartersParameter.getUpdatesForm();
        }
        if ((i & 32) != 0) {
            value = quartersParameter.get_value();
        }
        if ((i & 64) != 0) {
            list = quartersParameter.values;
        }
        return quartersParameter.copy(str, num, str2, attributedText, bool, value, list);
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final Integer component2() {
        return this.attributeId;
    }

    @NotNull
    public final String component3() {
        return getTitle();
    }

    @Nullable
    public final AttributedText component4() {
        return getMotivation();
    }

    @Nullable
    public final Boolean component5() {
        return getUpdatesForm();
    }

    @Nullable
    public final Value component6() {
        return get_value();
    }

    @NotNull
    public final List<Quarter> component7() {
        return this.values;
    }

    @NotNull
    public final QuartersParameter copy(@NotNull String str, @Nullable Integer num, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable Value value, @NotNull List<Quarter> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        return new QuartersParameter(str, num, str2, attributedText, bool, value, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuartersParameter)) {
            return false;
        }
        QuartersParameter quartersParameter = (QuartersParameter) obj;
        return Intrinsics.areEqual(getId(), quartersParameter.getId()) && Intrinsics.areEqual(this.attributeId, quartersParameter.attributeId) && Intrinsics.areEqual(getTitle(), quartersParameter.getTitle()) && Intrinsics.areEqual(getMotivation(), quartersParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), quartersParameter.getUpdatesForm()) && Intrinsics.areEqual(get_value(), quartersParameter.get_value()) && Intrinsics.areEqual(this.values, quartersParameter.values);
    }

    @Nullable
    public final Integer getAttributeId() {
        return this.attributeId;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ParameterSlot
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getImmutable() {
        return this.immutable;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @Nullable
    public AttributedText getMotivation() {
        return this.motivation;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final Quarter getSelectedValue() {
        Value value = (Value) getValue();
        T t = null;
        if ((value != null ? value.getTo() : null) != null) {
            Iterator<T> it = this.values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Integer toInt = next.getToInt();
                Value value2 = (Value) getValue();
                if (Intrinsics.areEqual(toInt, value2 != null ? value2.getTo() : null)) {
                    t = next;
                    break;
                }
            }
            return t;
        }
        Value value3 = (Value) getValue();
        if ((value3 != null ? value3.getFrom() : null) == null) {
            return null;
        }
        Iterator<T> it2 = this.values.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next2 = it2.next();
            Integer fromInt = next2.getFromInt();
            Value value4 = (Value) getValue();
            if (Intrinsics.areEqual(fromInt, value4 != null ? value4.getFrom() : null)) {
                t = next2;
                break;
            }
        }
        return t;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @NotNull
    public final List<Quarter> getValues() {
        return this.values;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        Integer num = this.attributeId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String title2 = getTitle();
        int hashCode3 = (hashCode2 + (title2 != null ? title2.hashCode() : 0)) * 31;
        AttributedText motivation2 = getMotivation();
        int hashCode4 = (hashCode3 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode5 = (hashCode4 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        Value value = get_value();
        int hashCode6 = (hashCode5 + (value != null ? value.hashCode() : 0)) * 31;
        List<Quarter> list = this.values;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("QuartersParameter(id=");
        L.append(getId());
        L.append(", attributeId=");
        L.append(this.attributeId);
        L.append(", title=");
        L.append(getTitle());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", _value=");
        L.append(get_value());
        L.append(", values=");
        return a.w(L, this.values, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        Integer num = this.attributeId;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.title);
        parcel.writeParcelable(this.motivation, i);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Value value = this._value;
        if (value != null) {
            parcel.writeInt(1);
            value.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.values, parcel);
        while (n0.hasNext()) {
            ((Quarter) n0.next()).writeToParcel(parcel, 0);
        }
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Value get_value() {
        return this._value;
    }

    public void set_value(@Nullable Value value) {
        this._value = value;
    }

    public QuartersParameter(@NotNull String str, @Nullable Integer num, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable Value value, @NotNull List<Quarter> list) {
        a.c1(str, "id", str2, "title", list, ResidentialComplexModuleKt.VALUES);
        this.id = str;
        this.attributeId = num;
        this.title = str2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this._value = value;
        this.values = list;
        this.required = true;
    }
}
