package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "title", "message", "confirmButtonText", "cancelButtonText", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getConfirmButtonText", "getTitle", "getMessage", "getCancelButtonText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ActionConfirmation implements Parcelable {
    public static final Parcelable.Creator<ActionConfirmation> CREATOR = new Creator();
    @SerializedName(alternate = {"cancelText"}, value = "cancel")
    @NotNull
    private final String cancelButtonText;
    @SerializedName(alternate = {"confirmText"}, value = "ok")
    @NotNull
    private final String confirmButtonText;
    @SerializedName("description")
    @NotNull
    private final String message;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ActionConfirmation> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionConfirmation createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ActionConfirmation(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ActionConfirmation[] newArray(int i) {
            return new ActionConfirmation[i];
        }
    }

    public ActionConfirmation(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.Z0(str2, "message", str3, "confirmButtonText", str4, "cancelButtonText");
        this.title = str;
        this.message = str2;
        this.confirmButtonText = str3;
        this.cancelButtonText = str4;
    }

    public static /* synthetic */ ActionConfirmation copy$default(ActionConfirmation actionConfirmation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionConfirmation.title;
        }
        if ((i & 2) != 0) {
            str2 = actionConfirmation.message;
        }
        if ((i & 4) != 0) {
            str3 = actionConfirmation.confirmButtonText;
        }
        if ((i & 8) != 0) {
            str4 = actionConfirmation.cancelButtonText;
        }
        return actionConfirmation.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final String component3() {
        return this.confirmButtonText;
    }

    @NotNull
    public final String component4() {
        return this.cancelButtonText;
    }

    @NotNull
    public final ActionConfirmation copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "confirmButtonText");
        Intrinsics.checkNotNullParameter(str4, "cancelButtonText");
        return new ActionConfirmation(str, str2, str3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionConfirmation)) {
            return false;
        }
        ActionConfirmation actionConfirmation = (ActionConfirmation) obj;
        return Intrinsics.areEqual(this.title, actionConfirmation.title) && Intrinsics.areEqual(this.message, actionConfirmation.message) && Intrinsics.areEqual(this.confirmButtonText, actionConfirmation.confirmButtonText) && Intrinsics.areEqual(this.cancelButtonText, actionConfirmation.cancelButtonText);
    }

    @NotNull
    public final String getCancelButtonText() {
        return this.cancelButtonText;
    }

    @NotNull
    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.confirmButtonText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cancelButtonText;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActionConfirmation(title=");
        L.append(this.title);
        L.append(", message=");
        L.append(this.message);
        L.append(", confirmButtonText=");
        L.append(this.confirmButtonText);
        L.append(", cancelButtonText=");
        return a.t(L, this.cancelButtonText, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.confirmButtonText);
        parcel.writeString(this.cancelButtonText);
    }
}
