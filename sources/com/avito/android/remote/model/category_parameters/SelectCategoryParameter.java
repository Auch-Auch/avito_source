package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010,\u001a\u00020&\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00138\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u0012\u0004\b!\u0010\u0012\u001a\u0004\b \u0010\u0017R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00138\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u00020&8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectCategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/Category;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation$annotations", "()V", "", "immutable", "Z", "getImmutable", "()Z", "getImmutable$annotations", "_value", "Lcom/avito/android/remote/model/Category;", "get_value", "()Lcom/avito/android/remote/model/Category;", "set_value", "(Lcom/avito/android/remote/model/Category;)V", "required", "getRequired", "getRequired$annotations", "updatesForm", "Ljava/lang/Boolean;", "getUpdatesForm", "()Ljava/lang/Boolean;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Category;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SelectCategoryParameter extends EditableParameter<Category> {
    public static final Parcelable.Creator<SelectCategoryParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Category _value;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    private final boolean required;
    @NotNull
    private final String title = "";
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SelectCategoryParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectCategoryParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new SelectCategoryParameter(readString, bool, (Category) parcel.readParcelable(SelectCategoryParameter.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectCategoryParameter[] newArray(int i) {
            return new SelectCategoryParameter[i];
        }
    }

    public SelectCategoryParameter(@NotNull String str, @Nullable Boolean bool, @Nullable Category category) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.updatesForm = bool;
        this._value = category;
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getMotivation$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
    }

    public static /* synthetic */ void getTitle$annotations() {
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

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
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
        parcel.writeParcelable(this._value, i);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Category get_value() {
        return this._value;
    }

    public void set_value(@Nullable Category category) {
        this._value = category;
    }
}
