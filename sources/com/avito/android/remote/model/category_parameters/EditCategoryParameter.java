package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010(\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0013¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00138\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\f8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0018\u0010\u000e\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0010R*\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\u001b\u0010\u0015\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u001eR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u001c\u0010(\u001a\u00020\u00138\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/EditCategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/base/HasError;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "required", "Z", "getRequired", "()Z", "getRequired$annotations", "()V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "immutable", "getImmutable", "getImmutable$annotations", "error", "getError", "setError", "(Ljava/lang/String;)V", "getError$annotations", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation$annotations", "parentTitle", "getParentTitle", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class EditCategoryParameter extends CategoryParameter implements HasError {
    public static final Parcelable.Creator<EditCategoryParameter> CREATOR = new Creator();
    @Nullable
    private String error;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    @SerializedName("parentTitle")
    @NotNull
    private final String parentTitle;
    private final boolean required;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<EditCategoryParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EditCategoryParameter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new EditCategoryParameter(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EditCategoryParameter[] newArray(int i) {
            return new EditCategoryParameter[i];
        }
    }

    public EditCategoryParameter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "id", str2, "title", str3, "parentTitle");
        this.id = str;
        this.title = str2;
        this.parentTitle = str3;
    }

    public static /* synthetic */ void getError$annotations() {
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getMotivation$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    @Nullable
    public String getError() {
        return this.error;
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

    @NotNull
    public final String getParentTitle() {
        return this.parentTitle;
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

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    public boolean hasError() {
        return HasError.DefaultImpls.hasError(this);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    public void setError(@Nullable String str) {
        this.error = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.parentTitle);
    }
}
