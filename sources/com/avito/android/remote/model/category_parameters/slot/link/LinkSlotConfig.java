package com.avito.android.remote.model.category_parameters.slot.link;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "alert", "Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "getAlert", "()Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<LinkSlotConfig> CREATOR = new Creator();
    @SerializedName("alert")
    @Nullable
    private final LinkSlotAlert alert;
    @SerializedName("text")
    @NotNull
    private final AttributedText text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LinkSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LinkSlotConfig((AttributedText) parcel.readParcelable(LinkSlotConfig.class.getClassLoader()), parcel.readInt() != 0 ? LinkSlotAlert.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkSlotConfig[] newArray(int i) {
            return new LinkSlotConfig[i];
        }
    }

    public LinkSlotConfig(@NotNull AttributedText attributedText, @Nullable LinkSlotAlert linkSlotAlert) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.text = attributedText;
        this.alert = linkSlotAlert;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final LinkSlotAlert getAlert() {
        return this.alert;
    }

    @NotNull
    public final AttributedText getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.text, i);
        LinkSlotAlert linkSlotAlert = this.alert;
        if (linkSlotAlert != null) {
            parcel.writeInt(1);
            linkSlotAlert.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
