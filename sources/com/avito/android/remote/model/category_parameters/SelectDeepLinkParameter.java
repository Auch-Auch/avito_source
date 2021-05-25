package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B[\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005Jr\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0005J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b&\u0010!J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b+\u0010,R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010\u0005\"\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b1\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u0010\tR\u001c\u0010\u0016\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\b4\u0010\tR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u00105\u001a\u0004\b6\u0010\rR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b7\u0010\u0005R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b8\u0010\u0005R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b;\u0010\u0005¨\u0006>"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectDeepLinkParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "component9", "id", "title", "required", "immutable", "motivation", "updatesForm", "_value", InternalConstsKt.PLACEHOLDER, "deepLink", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/SelectDeepLinkParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "get_value", "set_value", "(Ljava/lang/String;)V", "getId", "Z", "getRequired", "getImmutable", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getTitle", "getPlaceholder", "Ljava/lang/Boolean;", "getUpdatesForm", "getDeepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SelectDeepLinkParameter extends EditableParameter<String> implements HasPlaceholder {
    public static final Parcelable.Creator<SelectDeepLinkParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private String _value;
    @SerializedName("deepLink")
    @NotNull
    private final String deepLink;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
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
    public static class Creator implements Parcelable.Creator<SelectDeepLinkParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectDeepLinkParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(SelectDeepLinkParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return new SelectDeepLinkParameter(readString, readString2, z2, z3, attributedText, bool, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectDeepLinkParameter[] newArray(int i) {
            return new SelectDeepLinkParameter[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectDeepLinkParameter(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, String str4, String str5, int i, j jVar) {
        this(str, str2, z, z2, attributedText, bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, str5);
    }

    public static /* synthetic */ SelectDeepLinkParameter copy$default(SelectDeepLinkParameter selectDeepLinkParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, String str4, String str5, int i, Object obj) {
        return selectDeepLinkParameter.copy((i & 1) != 0 ? selectDeepLinkParameter.getId() : str, (i & 2) != 0 ? selectDeepLinkParameter.getTitle() : str2, (i & 4) != 0 ? selectDeepLinkParameter.getRequired() : z, (i & 8) != 0 ? selectDeepLinkParameter.getImmutable() : z2, (i & 16) != 0 ? selectDeepLinkParameter.getMotivation() : attributedText, (i & 32) != 0 ? selectDeepLinkParameter.getUpdatesForm() : bool, (i & 64) != 0 ? selectDeepLinkParameter.get_value() : str3, (i & 128) != 0 ? selectDeepLinkParameter.getPlaceholder() : str4, (i & 256) != 0 ? selectDeepLinkParameter.deepLink : str5);
    }

    @NotNull
    public final String component1() {
        return getId();
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
    public final String component7() {
        return get_value();
    }

    @Nullable
    public final String component8() {
        return getPlaceholder();
    }

    @NotNull
    public final String component9() {
        return this.deepLink;
    }

    @NotNull
    public final SelectDeepLinkParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str5, "deepLink");
        return new SelectDeepLinkParameter(str, str2, z, z2, attributedText, bool, str3, str4, str5);
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
        if (!(obj instanceof SelectDeepLinkParameter)) {
            return false;
        }
        SelectDeepLinkParameter selectDeepLinkParameter = (SelectDeepLinkParameter) obj;
        return Intrinsics.areEqual(getId(), selectDeepLinkParameter.getId()) && Intrinsics.areEqual(getTitle(), selectDeepLinkParameter.getTitle()) && getRequired() == selectDeepLinkParameter.getRequired() && getImmutable() == selectDeepLinkParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), selectDeepLinkParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), selectDeepLinkParameter.getUpdatesForm()) && Intrinsics.areEqual(get_value(), selectDeepLinkParameter.get_value()) && Intrinsics.areEqual(getPlaceholder(), selectDeepLinkParameter.getPlaceholder()) && Intrinsics.areEqual(this.deepLink, selectDeepLinkParameter.deepLink);
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
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
        String str = get_value();
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode6 = (hashCode5 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        String str2 = this.deepLink;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectDeepLinkParameter(id=");
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
        L.append(", _value=");
        L.append(get_value());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", deepLink=");
        return a.t(L, this.deepLink, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
        parcel.writeString(this._value);
        parcel.writeString(this.placeholder);
        parcel.writeString(this.deepLink);
    }

    public SelectDeepLinkParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @NotNull String str5) {
        a.Z0(str, "id", str2, "title", str5, "deepLink");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this._value = str3;
        this.placeholder = str4;
        this.deepLink = str5;
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
