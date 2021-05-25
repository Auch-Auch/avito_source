package com.avito.android.remote.model.category_parameters.slot.residential_complex;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bo\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bF\u0010GJ\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u000bJ\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020'HÖ\u0001¢\u0006\u0004\b.\u0010)J \u00103\u001a\u0002022\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020'HÖ\u0001¢\u0006\u0004\b3\u00104R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u00105\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u00108R\u001e\u0010#\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b:\u0010\u0019R\u001c\u0010\"\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b<\u0010\tR\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u00105\u001a\u0004\b=\u0010\u000bR\u001c\u0010!\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b>\u0010\u000bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010?\u001a\u0004\b@\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010;\u001a\u0004\bA\u0010\tR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010B\u001a\u0004\bC\u0010\u0013R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\bD\u0010\u000bR\u001e\u0010 \u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\bE\u0010\u000b¨\u0006H"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getSelectedValue", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "", "hasValue", "()Z", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "", "component6", "()Ljava/util/List;", "component7", "component8", "component9", "Lcom/avito/android/remote/model/text/AttributedText;", "component10", "()Lcom/avito/android/remote/model/text/AttributedText;", "id", "title", "required", "updatesForm", "_value", ResidentialComplexModuleKt.VALUES, InternalConstsKt.PLACEHOLDER, "type", "immutable", "motivation", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSelect;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "get_value", "set_value", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Z", "getImmutable", "getId", "getType", "Ljava/lang/Boolean;", "getUpdatesForm", "getRequired", "Ljava/util/List;", "getValues", "getTitle", "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSelect extends EditableParameter<String> implements HasPlaceholder {
    public static final Parcelable.Creator<ResidentialComplexSelect> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private String _value;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final String type;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<SelectParameter.Value> values;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ResidentialComplexSelect> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResidentialComplexSelect createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(SelectParameter.Value.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new ResidentialComplexSelect(readString, readString2, z, bool, readString3, arrayList, parcel.readString(), parcel.readString(), parcel.readInt() != 0, (AttributedText) parcel.readParcelable(ResidentialComplexSelect.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ResidentialComplexSelect[] newArray(int i) {
            return new ResidentialComplexSelect[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResidentialComplexSelect(String str, String str2, boolean z, Boolean bool, String str3, List list, String str4, String str5, boolean z2, AttributedText attributedText, int i, j jVar) {
        this(str, str2, z, bool, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : str4, str5, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? null : attributedText);
    }

    public static /* synthetic */ ResidentialComplexSelect copy$default(ResidentialComplexSelect residentialComplexSelect, String str, String str2, boolean z, Boolean bool, String str3, List list, String str4, String str5, boolean z2, AttributedText attributedText, int i, Object obj) {
        return residentialComplexSelect.copy((i & 1) != 0 ? residentialComplexSelect.getId() : str, (i & 2) != 0 ? residentialComplexSelect.getTitle() : str2, (i & 4) != 0 ? residentialComplexSelect.getRequired() : z, (i & 8) != 0 ? residentialComplexSelect.getUpdatesForm() : bool, (i & 16) != 0 ? residentialComplexSelect.get_value() : str3, (i & 32) != 0 ? residentialComplexSelect.values : list, (i & 64) != 0 ? residentialComplexSelect.getPlaceholder() : str4, (i & 128) != 0 ? residentialComplexSelect.type : str5, (i & 256) != 0 ? residentialComplexSelect.getImmutable() : z2, (i & 512) != 0 ? residentialComplexSelect.getMotivation() : attributedText);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final AttributedText component10() {
        return getMotivation();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    public final boolean component3() {
        return getRequired();
    }

    @Nullable
    public final Boolean component4() {
        return getUpdatesForm();
    }

    @Nullable
    public final String component5() {
        return get_value();
    }

    @NotNull
    public final List<SelectParameter.Value> component6() {
        return this.values;
    }

    @Nullable
    public final String component7() {
        return getPlaceholder();
    }

    @NotNull
    public final String component8() {
        return this.type;
    }

    public final boolean component9() {
        return getImmutable();
    }

    @NotNull
    public final ResidentialComplexSelect copy(@NotNull String str, @NotNull String str2, boolean z, @Nullable Boolean bool, @Nullable String str3, @NotNull List<SelectParameter.Value> list, @Nullable String str4, @NotNull String str5, boolean z2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(str5, "type");
        return new ResidentialComplexSelect(str, str2, z, bool, str3, list, str4, str5, z2, attributedText);
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
        if (!(obj instanceof ResidentialComplexSelect)) {
            return false;
        }
        ResidentialComplexSelect residentialComplexSelect = (ResidentialComplexSelect) obj;
        return Intrinsics.areEqual(getId(), residentialComplexSelect.getId()) && Intrinsics.areEqual(getTitle(), residentialComplexSelect.getTitle()) && getRequired() == residentialComplexSelect.getRequired() && Intrinsics.areEqual(getUpdatesForm(), residentialComplexSelect.getUpdatesForm()) && Intrinsics.areEqual(get_value(), residentialComplexSelect.get_value()) && Intrinsics.areEqual(this.values, residentialComplexSelect.values) && Intrinsics.areEqual(getPlaceholder(), residentialComplexSelect.getPlaceholder()) && Intrinsics.areEqual(this.type, residentialComplexSelect.type) && getImmutable() == residentialComplexSelect.getImmutable() && Intrinsics.areEqual(getMotivation(), residentialComplexSelect.getMotivation());
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

    @Override // com.avito.android.remote.model.category_parameters.base.HasPlaceholder
    @Nullable
    public String getPlaceholder() {
        return this.placeholder;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final SelectParameter.Value getSelectedValue() {
        T t = null;
        if (getValue() == null) {
            return null;
        }
        Iterator<T> it = this.values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual(next.getId(), (String) getValue())) {
                t = next;
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

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @NotNull
    public final List<SelectParameter.Value> getValues() {
        return this.values;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public boolean hasValue() {
        CharSequence charSequence = (CharSequence) getValue();
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        boolean required2 = getRequired();
        int i2 = 1;
        if (required2) {
            required2 = true;
        }
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = required2 ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode3 = (i6 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        String str = get_value();
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        List<SelectParameter.Value> list = this.values;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode6 = (hashCode5 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        String str2 = this.type;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean immutable2 = getImmutable();
        if (!immutable2) {
            i2 = immutable2;
        }
        int i7 = (hashCode7 + i2) * 31;
        AttributedText motivation2 = getMotivation();
        if (motivation2 != null) {
            i = motivation2.hashCode();
        }
        return i7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ResidentialComplexSelect(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", required=");
        L.append(getRequired());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", _value=");
        L.append(get_value());
        L.append(", values=");
        L.append(this.values);
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", type=");
        L.append(this.type);
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.required ? 1 : 0);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this._value);
        Iterator n0 = a.n0(this.values, parcel);
        while (n0.hasNext()) {
            ((SelectParameter.Value) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.placeholder);
        parcel.writeString(this.type);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public String get_value() {
        return this._value;
    }

    public void set_value(@Nullable String str) {
        this._value = str;
    }

    public ResidentialComplexSelect(@NotNull String str, @NotNull String str2, boolean z, @Nullable Boolean bool, @Nullable String str3, @NotNull List<SelectParameter.Value> list, @Nullable String str4, @NotNull String str5, boolean z2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(str5, "type");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.updatesForm = bool;
        this._value = str3;
        this.values = list;
        this.placeholder = str4;
        this.type = str5;
        this.immutable = z2;
        this.motivation = attributedText;
    }
}
