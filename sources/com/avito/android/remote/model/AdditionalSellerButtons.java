package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/AdditionalSellerButtons;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/AdditionalSellerAdditionalButton;", "additional", "Lcom/avito/android/remote/model/AdditionalSellerAdditionalButton;", "getAdditional", "()Lcom/avito/android/remote/model/AdditionalSellerAdditionalButton;", "Lcom/avito/android/remote/model/AdditionalSellerMainButton;", "main", "Lcom/avito/android/remote/model/AdditionalSellerMainButton;", "getMain", "()Lcom/avito/android/remote/model/AdditionalSellerMainButton;", "<init>", "(Lcom/avito/android/remote/model/AdditionalSellerMainButton;Lcom/avito/android/remote/model/AdditionalSellerAdditionalButton;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalSellerButtons implements Parcelable {
    public static final Parcelable.Creator<AdditionalSellerButtons> CREATOR = new Creator();
    @SerializedName("additional")
    @Nullable
    private final AdditionalSellerAdditionalButton additional;
    @SerializedName("main")
    @NotNull
    private final AdditionalSellerMainButton main;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdditionalSellerButtons> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdditionalSellerButtons createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdditionalSellerButtons(AdditionalSellerMainButton.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? AdditionalSellerAdditionalButton.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdditionalSellerButtons[] newArray(int i) {
            return new AdditionalSellerButtons[i];
        }
    }

    public AdditionalSellerButtons(@NotNull AdditionalSellerMainButton additionalSellerMainButton, @Nullable AdditionalSellerAdditionalButton additionalSellerAdditionalButton) {
        Intrinsics.checkNotNullParameter(additionalSellerMainButton, "main");
        this.main = additionalSellerMainButton;
        this.additional = additionalSellerAdditionalButton;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdditionalSellerAdditionalButton getAdditional() {
        return this.additional;
    }

    @NotNull
    public final AdditionalSellerMainButton getMain() {
        return this.main;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.main.writeToParcel(parcel, 0);
        AdditionalSellerAdditionalButton additionalSellerAdditionalButton = this.additional;
        if (additionalSellerAdditionalButton != null) {
            parcel.writeInt(1);
            additionalSellerAdditionalButton.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdditionalSellerButtons(AdditionalSellerMainButton additionalSellerMainButton, AdditionalSellerAdditionalButton additionalSellerAdditionalButton, int i, j jVar) {
        this(additionalSellerMainButton, (i & 2) != 0 ? null : additionalSellerAdditionalButton);
    }
}
