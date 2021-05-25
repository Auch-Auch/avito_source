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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b \b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bk\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bN\u0010OJ\u0010\u0010\u0004\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0005J\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0005J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020%HÖ\u0001¢\u0006\u0004\b,\u0010'J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020%HÖ\u0001¢\u0006\u0004\b1\u00102R\u001c\u0010\u001a\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b4\u0010\bR\"\u00105\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\u0012\n\u0004\b5\u00106\u0012\u0004\b8\u00109\u001a\u0004\b7\u0010\u0005R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b;\u0010\fR$\u0010<\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b<\u0010=\u0012\u0004\b@\u00109\u001a\u0004\b>\u0010?R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\bA\u0010\u0005R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u00106\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010DR\u001c\u0010\u0019\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\bE\u0010\bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\bF\u0010\u0005R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u00106\u001a\u0004\bG\u0010\u0005\"\u0004\bH\u0010DR\u001e\u0010!\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\bI\u0010\u0005R$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010J\u001a\u0004\bK\u0010\u0012R\u001e\u0010 \u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010L\u001a\u0004\bM\u0010\u0016¨\u0006P"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DescriptionParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Lcom/avito/android/remote/model/text/AttributedText;", "component5", "component6", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component7", "()Ljava/util/List;", "component8", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component9", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component10", "id", "required", "immutable", "motivation", "_value", "error", "constraints", "hint", "displayingOptions", InternalConstsKt.PLACEHOLDER, "copy", "(Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/DescriptionParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getImmutable", "title", "Ljava/lang/String;", "getTitle", "getTitle$annotations", "()V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "updatesForm", "Ljava/lang/Boolean;", "getUpdatesForm", "()Ljava/lang/Boolean;", "getUpdatesForm$annotations", "getId", "getError", "setError", "(Ljava/lang/String;)V", "getRequired", "getHint", "get_value", "set_value", "getPlaceholder", "Ljava/util/List;", "getConstraints", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "<init>", "(Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DescriptionParameter extends EditableParameter<String> implements TextParameter {
    public static final Parcelable.Creator<DescriptionParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private String _value;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @Nullable
    private final DisplayingOptions displayingOptions;
    @Nullable
    private String error;
    @SerializedName("hint")
    @Nullable
    private final String hint;
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
    @NotNull
    private final String title = "";
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DescriptionParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DescriptionParameter createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            AttributedText attributedText = (AttributedText) parcel.readParcelable(DescriptionParameter.class.getClassLoader());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Constraint) parcel.readParcelable(DescriptionParameter.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new DescriptionParameter(readString, z2, z, attributedText, readString2, readString3, arrayList, parcel.readString(), parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DescriptionParameter[] newArray(int i) {
            return new DescriptionParameter[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public DescriptionParameter(@NotNull String str, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable String str2, @Nullable String str3, @Nullable List<? extends Constraint> list, @Nullable String str4, @Nullable DisplayingOptions displayingOptions2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this._value = str2;
        this.error = str3;
        this.constraints = list;
        this.hint = str4;
        this.displayingOptions = displayingOptions2;
        this.placeholder = str5;
    }

    public static /* synthetic */ DescriptionParameter copy$default(DescriptionParameter descriptionParameter, String str, boolean z, boolean z2, AttributedText attributedText, String str2, String str3, List list, String str4, DisplayingOptions displayingOptions2, String str5, int i, Object obj) {
        return descriptionParameter.copy((i & 1) != 0 ? descriptionParameter.getId() : str, (i & 2) != 0 ? descriptionParameter.getRequired() : z, (i & 4) != 0 ? descriptionParameter.getImmutable() : z2, (i & 8) != 0 ? descriptionParameter.getMotivation() : attributedText, (i & 16) != 0 ? descriptionParameter.get_value() : str2, (i & 32) != 0 ? descriptionParameter.getError() : str3, (i & 64) != 0 ? descriptionParameter.getConstraints() : list, (i & 128) != 0 ? descriptionParameter.getHint() : str4, (i & 256) != 0 ? descriptionParameter.getDisplayingOptions() : displayingOptions2, (i & 512) != 0 ? descriptionParameter.getPlaceholder() : str5);
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static /* synthetic */ void getUpdatesForm$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final String component10() {
        return getPlaceholder();
    }

    public final boolean component2() {
        return getRequired();
    }

    public final boolean component3() {
        return getImmutable();
    }

    @Nullable
    public final AttributedText component4() {
        return getMotivation();
    }

    @Nullable
    public final String component5() {
        return get_value();
    }

    @Nullable
    public final String component6() {
        return getError();
    }

    @Nullable
    public final List<Constraint> component7() {
        return getConstraints();
    }

    @Nullable
    public final String component8() {
        return getHint();
    }

    @Nullable
    public final DisplayingOptions component9() {
        return getDisplayingOptions();
    }

    @NotNull
    public final DescriptionParameter copy(@NotNull String str, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable String str2, @Nullable String str3, @Nullable List<? extends Constraint> list, @Nullable String str4, @Nullable DisplayingOptions displayingOptions2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new DescriptionParameter(str, z, z2, attributedText, str2, str3, list, str4, displayingOptions2, str5);
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
        if (!(obj instanceof DescriptionParameter)) {
            return false;
        }
        DescriptionParameter descriptionParameter = (DescriptionParameter) obj;
        return Intrinsics.areEqual(getId(), descriptionParameter.getId()) && getRequired() == descriptionParameter.getRequired() && getImmutable() == descriptionParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), descriptionParameter.getMotivation()) && Intrinsics.areEqual(get_value(), descriptionParameter.get_value()) && Intrinsics.areEqual(getError(), descriptionParameter.getError()) && Intrinsics.areEqual(getConstraints(), descriptionParameter.getConstraints()) && Intrinsics.areEqual(getHint(), descriptionParameter.getHint()) && Intrinsics.areEqual(getDisplayingOptions(), descriptionParameter.getDisplayingOptions()) && Intrinsics.areEqual(getPlaceholder(), descriptionParameter.getPlaceholder());
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

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter, com.avito.android.remote.model.category_parameters.base.HasError
    @Nullable
    public String getError() {
        return this.error;
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

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        boolean required2 = getRequired();
        int i2 = 1;
        if (required2) {
            required2 = true;
        }
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = required2 ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        boolean immutable2 = getImmutable();
        if (!immutable2) {
            i2 = immutable2;
        }
        int i7 = (i6 + i2) * 31;
        AttributedText motivation2 = getMotivation();
        int hashCode2 = (i7 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        String str = get_value();
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String error2 = getError();
        int hashCode4 = (hashCode3 + (error2 != null ? error2.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode5 = (hashCode4 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        String hint2 = getHint();
        int hashCode6 = (hashCode5 + (hint2 != null ? hint2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        int hashCode7 = (hashCode6 + (displayingOptions2 != null ? displayingOptions2.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        if (placeholder2 != null) {
            i = placeholder2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter, com.avito.android.remote.model.category_parameters.base.HasError
    public void setError(@Nullable String str) {
        this.error = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DescriptionParameter(id=");
        L.append(getId());
        L.append(", required=");
        L.append(getRequired());
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", _value=");
        L.append(get_value());
        L.append(", error=");
        L.append(getError());
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(", hint=");
        L.append(getHint());
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
        parcel.writeString(this._value);
        parcel.writeString(this.error);
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.hint);
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.placeholder);
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
