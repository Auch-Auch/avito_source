package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001c\u001a\u00020\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/deep_linking/links/FormInput;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/InputType;", "identifier", "Lcom/avito/android/deep_linking/links/InputType;", "getIdentifier", "()Lcom/avito/android/deep_linking/links/InputType;", "", InternalConstsKt.PLACEHOLDER, "Ljava/lang/String;", "getPlaceholder", "()Ljava/lang/String;", "error", "getError", "title", "getTitle", "value", "getValue", "", "required", "Z", "getRequired", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/deep_linking/links/InputType;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FormInput implements Parcelable {
    public static final Parcelable.Creator<FormInput> CREATOR = new Creator();
    @SerializedName("error")
    @Nullable
    private final String error;
    @SerializedName("identifier")
    @NotNull
    private final InputType identifier;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("value")
    @Nullable
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FormInput> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FormInput createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FormInput(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), (InputType) Enum.valueOf(InputType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FormInput[] newArray(int i) {
            return new FormInput[i];
        }
    }

    public FormInput(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, @NotNull InputType inputType) {
        Intrinsics.checkNotNullParameter(inputType, "identifier");
        this.title = str;
        this.placeholder = str2;
        this.value = str3;
        this.required = z;
        this.error = str4;
        this.identifier = inputType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final InputType getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.placeholder);
        parcel.writeString(this.value);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeString(this.error);
        parcel.writeString(this.identifier.name());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormInput(String str, String str2, String str3, boolean z, String str4, InputType inputType, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, z, (i & 16) != 0 ? null : str4, inputType);
    }
}
