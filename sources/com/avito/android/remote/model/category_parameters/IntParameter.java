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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003Bs\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0006J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0006J\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b)\u0010\u0006J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020*HÖ\u0001¢\u0006\u0004\b1\u0010,J \u00106\u001a\u0002052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020*HÖ\u0001¢\u0006\u0004\b6\u00107R\u001c\u0010\u001d\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0006R\u001e\u0010!\u001a\u0004\u0018\u00010\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\u0010R$\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\b=\u0010\u0017R\u001c\u0010\u001f\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010>\u001a\u0004\b?\u0010\nR\u001c\u0010\u001e\u001a\u00020\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\b@\u0010\nR\u001e\u0010 \u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010A\u001a\u0004\bB\u0010\u000eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\bC\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u00108\u001a\u0004\bD\u0010\u0006R\u001e\u0010%\u001a\u0004\u0018\u00010\u00188\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010\u001aR\u001e\u0010&\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\bG\u0010\u0006R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010H\u001a\u0004\bI\u0010\u0013\"\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/IntParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "()Ljava/lang/Long;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component9", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component10", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component11", "id", "title", "required", "immutable", "motivation", "updatesForm", "hint", "_value", "constraints", "displayingOptions", InternalConstsKt.PLACEHOLDER, "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/IntParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/lang/Boolean;", "getUpdatesForm", "Ljava/util/List;", "getConstraints", "Z", "getImmutable", "getRequired", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getHint", "getId", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "getPlaceholder", "Ljava/lang/Long;", "get_value", "set_value", "(Ljava/lang/Long;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class IntParameter extends EditableParameter<Long> implements TextParameter {
    public static final Parcelable.Creator<IntParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Long _value;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
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
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<IntParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IntParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(IntParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            String readString3 = parcel.readString();
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((Constraint) parcel.readParcelable(IntParameter.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new IntParameter(readString, readString2, z2, z3, attributedText, bool, readString3, valueOf, arrayList, parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IntParameter[] newArray(int i) {
            return new IntParameter[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public IntParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable Long l, @Nullable List<? extends Constraint> list, @Nullable DisplayingOptions displayingOptions2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this.hint = str3;
        this._value = l;
        this.constraints = list;
        this.displayingOptions = displayingOptions2;
        this.placeholder = str4;
    }

    public static /* synthetic */ IntParameter copy$default(IntParameter intParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, Long l, List list, DisplayingOptions displayingOptions2, String str4, int i, Object obj) {
        return intParameter.copy((i & 1) != 0 ? intParameter.getId() : str, (i & 2) != 0 ? intParameter.getTitle() : str2, (i & 4) != 0 ? intParameter.getRequired() : z, (i & 8) != 0 ? intParameter.getImmutable() : z2, (i & 16) != 0 ? intParameter.getMotivation() : attributedText, (i & 32) != 0 ? intParameter.getUpdatesForm() : bool, (i & 64) != 0 ? intParameter.getHint() : str3, (i & 128) != 0 ? intParameter.get_value() : l, (i & 256) != 0 ? intParameter.getConstraints() : list, (i & 512) != 0 ? intParameter.getDisplayingOptions() : displayingOptions2, (i & 1024) != 0 ? intParameter.getPlaceholder() : str4);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final DisplayingOptions component10() {
        return getDisplayingOptions();
    }

    @Nullable
    public final String component11() {
        return getPlaceholder();
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
        return getHint();
    }

    @Nullable
    public final Long component8() {
        return get_value();
    }

    @Nullable
    public final List<Constraint> component9() {
        return getConstraints();
    }

    @NotNull
    public final IntParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable Long l, @Nullable List<? extends Constraint> list, @Nullable DisplayingOptions displayingOptions2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new IntParameter(str, str2, z, z2, attributedText, bool, str3, l, list, displayingOptions2, str4);
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
        if (!(obj instanceof IntParameter)) {
            return false;
        }
        IntParameter intParameter = (IntParameter) obj;
        return Intrinsics.areEqual(getId(), intParameter.getId()) && Intrinsics.areEqual(getTitle(), intParameter.getTitle()) && getRequired() == intParameter.getRequired() && getImmutable() == intParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), intParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), intParameter.getUpdatesForm()) && Intrinsics.areEqual(getHint(), intParameter.getHint()) && Intrinsics.areEqual(get_value(), intParameter.get_value()) && Intrinsics.areEqual(getConstraints(), intParameter.getConstraints()) && Intrinsics.areEqual(getDisplayingOptions(), intParameter.getDisplayingOptions()) && Intrinsics.areEqual(getPlaceholder(), intParameter.getPlaceholder());
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
        String hint2 = getHint();
        int hashCode5 = (hashCode4 + (hint2 != null ? hint2.hashCode() : 0)) * 31;
        Long l = get_value();
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode7 = (hashCode6 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        int hashCode8 = (hashCode7 + (displayingOptions2 != null ? displayingOptions2.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        if (placeholder2 != null) {
            i = placeholder2.hashCode();
        }
        return hashCode8 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("IntParameter(id=");
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
        L.append(", hint=");
        L.append(getHint());
        L.append(", _value=");
        L.append(get_value());
        L.append(", constraints=");
        L.append(getConstraints());
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
        parcel.writeString(this.hint);
        Long l = this._value;
        if (l != null) {
            a.I0(parcel, 1, l);
        } else {
            parcel.writeInt(0);
        }
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
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
        parcel.writeString(this.placeholder);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Long get_value() {
        return this._value;
    }

    public void set_value(@Nullable Long l) {
        this._value = l;
    }
}
