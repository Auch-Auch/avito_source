package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bc\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0001\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\u0005J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b)\u0010$J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b.\u0010/R\u001c\u0010\u0017\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u00105R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u00106\u001a\u0004\b7\u0010\fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b8\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u00109\u001a\u0004\b:\u0010\u0005R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b;\u0010\fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\b=\u0010\u0014R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b>\u0010\u0005R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u00100\u001a\u0004\b?\u0010\bR\u001c\u0010\u0016\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b@\u0010\u0005¨\u0006C"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "component9", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component10", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "id", "title", "required", "immutable", "motivation", "updatesForm", MessengerShareContentUtility.SUBTITLE, "_value", TariffPackageInfoConverterKt.HEADER_STRING_ID, "displayingOptions", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)Lcom/avito/android/remote/model/category_parameters/BooleanParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getRequired", "Ljava/lang/Boolean;", "get_value", "set_value", "(Ljava/lang/Boolean;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getUpdatesForm", "Ljava/lang/String;", "getId", "getSubtitle", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "getHeader", "getImmutable", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BooleanParameter extends EditableParameter<Boolean> {
    public static final Parcelable.Creator<BooleanParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Boolean _value;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @Nullable
    private final String header;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName("required")
    private final boolean required;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final AttributedText subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BooleanParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BooleanParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(BooleanParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            AttributedText attributedText2 = (AttributedText) parcel.readParcelable(BooleanParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            return new BooleanParameter(readString, readString2, z2, z3, attributedText, bool, attributedText2, bool2, parcel.readString(), parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BooleanParameter[] newArray(int i) {
            return new BooleanParameter[i];
        }
    }

    public BooleanParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable AttributedText attributedText2, @Nullable Boolean bool2, @Nullable String str3, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this.subtitle = attributedText2;
        this._value = bool2;
        this.header = str3;
        this.displayingOptions = displayingOptions2;
    }

    public static /* synthetic */ BooleanParameter copy$default(BooleanParameter booleanParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, AttributedText attributedText2, Boolean bool2, String str3, DisplayingOptions displayingOptions2, int i, Object obj) {
        return booleanParameter.copy((i & 1) != 0 ? booleanParameter.getId() : str, (i & 2) != 0 ? booleanParameter.getTitle() : str2, (i & 4) != 0 ? booleanParameter.getRequired() : z, (i & 8) != 0 ? booleanParameter.getImmutable() : z2, (i & 16) != 0 ? booleanParameter.getMotivation() : attributedText, (i & 32) != 0 ? booleanParameter.getUpdatesForm() : bool, (i & 64) != 0 ? booleanParameter.subtitle : attributedText2, (i & 128) != 0 ? booleanParameter.get_value() : bool2, (i & 256) != 0 ? booleanParameter.header : str3, (i & 512) != 0 ? booleanParameter.displayingOptions : displayingOptions2);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final DisplayingOptions component10() {
        return this.displayingOptions;
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    public final boolean component3() {
        return getRequired();
    }

    public final boolean component4() {
        return getImmutable();
    }

    @Nullable
    public final AttributedText component5() {
        return getMotivation();
    }

    @Nullable
    public final Boolean component6() {
        return getUpdatesForm();
    }

    @Nullable
    public final AttributedText component7() {
        return this.subtitle;
    }

    @Nullable
    public final Boolean component8() {
        return get_value();
    }

    @Nullable
    public final String component9() {
        return this.header;
    }

    @NotNull
    public final BooleanParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable AttributedText attributedText2, @Nullable Boolean bool2, @Nullable String str3, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new BooleanParameter(str, str2, z, z2, attributedText, bool, attributedText2, bool2, str3, displayingOptions2);
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
        if (!(obj instanceof BooleanParameter)) {
            return false;
        }
        BooleanParameter booleanParameter = (BooleanParameter) obj;
        return Intrinsics.areEqual(getId(), booleanParameter.getId()) && Intrinsics.areEqual(getTitle(), booleanParameter.getTitle()) && getRequired() == booleanParameter.getRequired() && getImmutable() == booleanParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), booleanParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), booleanParameter.getUpdatesForm()) && Intrinsics.areEqual(this.subtitle, booleanParameter.subtitle) && Intrinsics.areEqual(get_value(), booleanParameter.get_value()) && Intrinsics.areEqual(this.header, booleanParameter.header) && Intrinsics.areEqual(this.displayingOptions, booleanParameter.displayingOptions);
    }

    @Nullable
    public final DisplayingOptions getDisplayingOptions() {
        return this.displayingOptions;
    }

    @Nullable
    public final String getHeader() {
        return this.header;
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
    public final AttributedText getSubtitle() {
        return this.subtitle;
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
        boolean immutable2 = getImmutable();
        if (!immutable2) {
            i2 = immutable2;
        }
        int i7 = (i6 + i2) * 31;
        AttributedText motivation2 = getMotivation();
        int hashCode3 = (i7 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode4 = (hashCode3 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        AttributedText attributedText = this.subtitle;
        int hashCode5 = (hashCode4 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        Boolean bool = get_value();
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.header;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            i = displayingOptions2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BooleanParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", required=");
        L.append(getRequired());
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", _value=");
        L.append(get_value());
        L.append(", header=");
        L.append(this.header);
        L.append(", displayingOptions=");
        L.append(this.displayingOptions);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.subtitle, i);
        Boolean bool2 = this._value;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.header);
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Boolean get_value() {
        return this._value;
    }

    public void set_value(@Nullable Boolean bool) {
        this._value = bool;
    }
}
