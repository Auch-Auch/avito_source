package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.Sublocation;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 ¢\u0006\u0004\b8\u00109J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u00020\u00188\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010%\u001a\u00020\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b%\u0010\u000e\u0012\u0004\b'\u0010\u0012\u001a\u0004\b&\u0010\u0010R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010\u0012\u001a\u0004\b0\u00101R\u0019\u00104\u001a\u0002038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SubLocationParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/Sublocation;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "required", "Z", "getRequired", "()Z", "getRequired$annotations", "()V", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getId$annotations", "title", "getTitle", "", ResidentialComplexModuleKt.VALUES, "Ljava/util/List;", "getValues", "()Ljava/util/List;", "immutable", "getImmutable", "getImmutable$annotations", "_value", "Lcom/avito/android/remote/model/Sublocation;", "get_value", "()Lcom/avito/android/remote/model/Sublocation;", "set_value", "(Lcom/avito/android/remote/model/Sublocation;)V", "updatesForm", "Ljava/lang/Boolean;", "getUpdatesForm", "()Ljava/lang/Boolean;", "getUpdatesForm$annotations", "Lcom/avito/android/remote/model/Sublocation$Type;", "type", "Lcom/avito/android/remote/model/Sublocation$Type;", "getType", "()Lcom/avito/android/remote/model/Sublocation$Type;", "<init>", "(Lcom/avito/android/remote/model/Sublocation$Type;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Sublocation;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SubLocationParameter extends EditableParameter<Sublocation> {
    public static final Parcelable.Creator<SubLocationParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Sublocation _value;
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
    @NotNull
    private final Sublocation.Type type;
    @Nullable
    private final Boolean updatesForm;
    @NotNull
    private final List<Sublocation> values;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SubLocationParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubLocationParameter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Sublocation.Type type = (Sublocation.Type) parcel.readParcelable(SubLocationParameter.class.getClassLoader());
            String readString = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(SubLocationParameter.class.getClassLoader());
            Sublocation sublocation = (Sublocation) parcel.readParcelable(SubLocationParameter.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Sublocation) parcel.readParcelable(SubLocationParameter.class.getClassLoader()));
                readInt--;
            }
            return new SubLocationParameter(type, readString, attributedText, sublocation, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubLocationParameter[] newArray(int i) {
            return new SubLocationParameter[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubLocationParameter(Sublocation.Type type2, String str, AttributedText attributedText, Sublocation sublocation, List list, int i, j jVar) {
        this(type2, str, attributedText, (i & 8) != 0 ? null : sublocation, (i & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public static /* synthetic */ void getId$annotations() {
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
    }

    public static /* synthetic */ void getUpdatesForm$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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

    @NotNull
    public final Sublocation.Type getType() {
        return this.type;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @NotNull
    public final List<Sublocation> getValues() {
        return this.values;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.type, i);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.motivation, i);
        parcel.writeParcelable(this._value, i);
        Iterator n0 = a.n0(this.values, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((Sublocation) n0.next(), i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<? extends com.avito.android.remote.model.Sublocation> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubLocationParameter(@NotNull Sublocation.Type type2, @NotNull String str, @Nullable AttributedText attributedText, @Nullable Sublocation sublocation, @NotNull List<? extends Sublocation> list) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        this.type = type2;
        this.title = str;
        this.motivation = attributedText;
        this._value = sublocation;
        this.values = list;
        this.id = type2.getIdParam();
        this.required = true;
        this.updatesForm = Boolean.FALSE;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Sublocation get_value() {
        return this._value;
    }

    public void set_value(@Nullable Sublocation sublocation) {
        this._value = sublocation;
    }
}
