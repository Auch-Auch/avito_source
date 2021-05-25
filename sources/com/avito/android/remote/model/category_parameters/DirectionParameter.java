package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Direction;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\rR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\nR\"\u0010*\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001c\u0010\u0011\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u00100\u001a\u0004\b1\u0010\u0006R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u00102\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u00105R\"\u00106\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b6\u0010+\u0012\u0004\b8\u0010/\u001a\u0004\b7\u0010-R\u001c\u0010\u0010\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u00100\u001a\u0004\b9\u0010\u0006¨\u0006<"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DirectionParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/Direction;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component4", "()Ljava/lang/Boolean;", "component5", "()Ljava/util/List;", "id", "title", "motivation", "updatesForm", "_value", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/DirectionParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getUpdatesForm", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "required", "Z", "getRequired", "()Z", "getRequired$annotations", "()V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "get_value", "set_value", "(Ljava/util/List;)V", "immutable", "getImmutable", "getImmutable$annotations", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DirectionParameter extends EditableParameter<List<? extends Direction>> {
    public static final Parcelable.Creator<DirectionParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private List<Direction> _value;
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

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DirectionParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DirectionParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(DirectionParameter.class.getClassLoader());
            ArrayList arrayList = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Direction) parcel.readParcelable(DirectionParameter.class.getClassLoader()));
                    readInt--;
                }
            }
            return new DirectionParameter(readString, readString2, attributedText, bool, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DirectionParameter[] newArray(int i) {
            return new DirectionParameter[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DirectionParameter(String str, String str2, AttributedText attributedText, Boolean bool, List list, int i, j jVar) {
        this(str, str2, attributedText, bool, (i & 16) != 0 ? null : list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.category_parameters.DirectionParameter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectionParameter copy$default(DirectionParameter directionParameter, String str, String str2, AttributedText attributedText, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = directionParameter.getId();
        }
        if ((i & 2) != 0) {
            str2 = directionParameter.getTitle();
        }
        if ((i & 4) != 0) {
            attributedText = directionParameter.getMotivation();
        }
        if ((i & 8) != 0) {
            bool = directionParameter.getUpdatesForm();
        }
        if ((i & 16) != 0) {
            list = directionParameter.get_value();
        }
        return directionParameter.copy(str, str2, attributedText, bool, list);
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
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

    @Nullable
    public final Boolean component4() {
        return getUpdatesForm();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.Direction>, java.util.List<com.avito.android.remote.model.Direction> */
    @Nullable
    public final List<Direction> component5() {
        return get_value();
    }

    @NotNull
    public final DirectionParameter copy(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable List<Direction> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new DirectionParameter(str, str2, attributedText, bool, list);
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
        if (!(obj instanceof DirectionParameter)) {
            return false;
        }
        DirectionParameter directionParameter = (DirectionParameter) obj;
        return Intrinsics.areEqual(getId(), directionParameter.getId()) && Intrinsics.areEqual(getTitle(), directionParameter.getTitle()) && Intrinsics.areEqual(getMotivation(), directionParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), directionParameter.getUpdatesForm()) && Intrinsics.areEqual(get_value(), directionParameter.get_value());
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
        AttributedText motivation2 = getMotivation();
        int hashCode3 = (hashCode2 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode4 = (hashCode3 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        List<? extends Direction> list = get_value();
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public /* bridge */ /* synthetic */ void set_value(List<? extends Direction> list) {
        set_value((List<Direction>) list);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DirectionParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", _value=");
        L.append(get_value());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.motivation, i);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        List<Direction> list = this._value;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Direction) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public DirectionParameter(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable List<Direction> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this._value = list;
        this.required = true;
    }

    /* Return type fixed from 'java.util.List<com.avito.android.remote.model.Direction>' to match base method */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public List<? extends Direction> get_value() {
        return this._value;
    }

    public void set_value(@Nullable List<Direction> list) {
        this._value = list;
    }
}
