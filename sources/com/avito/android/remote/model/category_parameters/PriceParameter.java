package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Be\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u0006J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\bJ\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ|\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\bJ\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020%HÖ\u0001¢\u0006\u0004\b,\u0010'J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020%HÖ\u0001¢\u0006\u0004\b1\u00102R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u0010\fR\"\u00105\u001a\u00020\u00048\u0016@\u0016XD¢\u0006\u0012\n\u0004\b5\u00106\u0012\u0004\b8\u00109\u001a\u0004\b7\u0010\u0006R$\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010:\u001a\u0004\b;\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010?R\u001c\u0010\u001a\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\b@\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010A\u001a\u0004\bB\u0010\u0012R\u001c\u0010\u001c\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\bC\u0010\u0006R$\u0010D\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bD\u0010<\u0012\u0004\bF\u00109\u001a\u0004\bE\u0010\bR\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010<\u001a\u0004\bG\u0010\bR\u001e\u0010!\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\bH\u0010\bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010I\u001a\u0004\bJ\u0010\u000f¨\u0006M"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/PriceParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "", "hasValue", "()Z", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "component4", "component5", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component6", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component7", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component8", "()Ljava/util/List;", "component9", "id", "title", "motivation", "required", "updatesForm", "displayingOptions", "_value", "constraints", InternalConstsKt.PLACEHOLDER, "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZLjava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/PriceParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "immutable", "Z", "getImmutable", "getImmutable$annotations", "()V", "Ljava/util/List;", "getConstraints", "Ljava/lang/String;", "get_value", "set_value", "(Ljava/lang/String;)V", "getTitle", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "getRequired", "hint", "getHint", "getHint$annotations", "getId", "getPlaceholder", "Ljava/lang/Boolean;", "getUpdatesForm", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZLjava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PriceParameter extends EditableParameter<String> implements TextParameter {
    public static final Parcelable.Creator<PriceParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private String _value;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
    @Nullable
    private final String hint;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @SerializedName("motivation")
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
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PriceParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(PriceParameter.class.getClassLoader());
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            DisplayingOptions createFromParcel = parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null;
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((Constraint) parcel.readParcelable(PriceParameter.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new PriceParameter(readString, readString2, attributedText, z2, bool, createFromParcel, readString3, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceParameter[] newArray(int i) {
            return new PriceParameter[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceParameter(String str, String str2, AttributedText attributedText, boolean z, Boolean bool, DisplayingOptions displayingOptions2, String str3, List list, String str4, int i, j jVar) {
        this(str, str2, attributedText, z, bool, displayingOptions2, (i & 64) != 0 ? null : str3, list, (i & 256) != 0 ? null : str4);
    }

    public static /* synthetic */ PriceParameter copy$default(PriceParameter priceParameter, String str, String str2, AttributedText attributedText, boolean z, Boolean bool, DisplayingOptions displayingOptions2, String str3, List list, String str4, int i, Object obj) {
        return priceParameter.copy((i & 1) != 0 ? priceParameter.getId() : str, (i & 2) != 0 ? priceParameter.getTitle() : str2, (i & 4) != 0 ? priceParameter.getMotivation() : attributedText, (i & 8) != 0 ? priceParameter.getRequired() : z, (i & 16) != 0 ? priceParameter.getUpdatesForm() : bool, (i & 32) != 0 ? priceParameter.getDisplayingOptions() : displayingOptions2, (i & 64) != 0 ? priceParameter.get_value() : str3, (i & 128) != 0 ? priceParameter.getConstraints() : list, (i & 256) != 0 ? priceParameter.getPlaceholder() : str4);
    }

    public static /* synthetic */ void getHint$annotations() {
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @Nullable
    public final AttributedText component3() {
        return getMotivation();
    }

    public final boolean component4() {
        return getRequired();
    }

    @Nullable
    public final Boolean component5() {
        return getUpdatesForm();
    }

    @Nullable
    public final DisplayingOptions component6() {
        return getDisplayingOptions();
    }

    @Nullable
    public final String component7() {
        return get_value();
    }

    @Nullable
    public final List<Constraint> component8() {
        return getConstraints();
    }

    @Nullable
    public final String component9() {
        return getPlaceholder();
    }

    @NotNull
    public final PriceParameter copy(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, boolean z, @Nullable Boolean bool, @Nullable DisplayingOptions displayingOptions2, @Nullable String str3, @Nullable List<? extends Constraint> list, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new PriceParameter(str, str2, attributedText, z, bool, displayingOptions2, str3, list, str4);
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
        if (!(obj instanceof PriceParameter)) {
            return false;
        }
        PriceParameter priceParameter = (PriceParameter) obj;
        return Intrinsics.areEqual(getId(), priceParameter.getId()) && Intrinsics.areEqual(getTitle(), priceParameter.getTitle()) && Intrinsics.areEqual(getMotivation(), priceParameter.getMotivation()) && getRequired() == priceParameter.getRequired() && Intrinsics.areEqual(getUpdatesForm(), priceParameter.getUpdatesForm()) && Intrinsics.areEqual(getDisplayingOptions(), priceParameter.getDisplayingOptions()) && Intrinsics.areEqual(get_value(), priceParameter.get_value()) && Intrinsics.areEqual(getConstraints(), priceParameter.getConstraints()) && Intrinsics.areEqual(getPlaceholder(), priceParameter.getPlaceholder());
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasConstraints
    @Nullable
    public List<Constraint> getConstraints() {
        return this.constraints;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.TextParameter
    @Nullable
    public DisplayingOptions getDisplayingOptions() {
        return this.displayingOptions;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.TextParameter
    @Nullable
    public String getHint() {
        return this.hint;
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

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public boolean hasValue() {
        CharSequence charSequence = (CharSequence) getValue();
        return !(charSequence == null || charSequence.length() == 0);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        AttributedText motivation2 = getMotivation();
        int hashCode3 = (hashCode2 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        boolean required2 = getRequired();
        if (required2) {
            required2 = true;
        }
        int i2 = required2 ? 1 : 0;
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode4 = (i5 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        int hashCode5 = (hashCode4 + (displayingOptions2 != null ? displayingOptions2.hashCode() : 0)) * 31;
        String str = get_value();
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode7 = (hashCode6 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        if (placeholder2 != null) {
            i = placeholder2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PriceParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", required=");
        L.append(getRequired());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(", _value=");
        L.append(get_value());
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.motivation, i);
        parcel.writeInt(this.required ? 1 : 0);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this._value);
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.placeholder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public PriceParameter(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, boolean z, @Nullable Boolean bool, @Nullable DisplayingOptions displayingOptions2, @Nullable String str3, @Nullable List<? extends Constraint> list, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.motivation = attributedText;
        this.required = z;
        this.updatesForm = bool;
        this.displayingOptions = displayingOptions2;
        this._value = str3;
        this.constraints = list;
        this.placeholder = str4;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public String get_value() {
        return this._value;
    }

    public void set_value(@Nullable String str) {
        this._value = str;
    }
}
