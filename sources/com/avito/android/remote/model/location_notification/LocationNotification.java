package com.avito.android.remote.model.location_notification;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SerpElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001&BC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR(\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001e\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/location_notification/LocationNotification;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "confirmText", "Ljava/lang/String;", "getConfirmText", "()Ljava/lang/String;", "title", "getTitle", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;", "tooltipType", "Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;", "getTooltipType", "()Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;", "geoSessionId", "getGeoSessionId", "changeText", "getChangeText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;Ljava/lang/String;)V", "TooltipType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LocationNotification implements SerpElement {
    public static final Parcelable.Creator<LocationNotification> CREATOR = new Creator();
    @SerializedName("laasChangeButtonTitle")
    @Nullable
    private final String changeText;
    @SerializedName("laasConfirmButtonTitle")
    @Nullable
    private final String confirmText;
    @SerializedName("laasGeoSessionId")
    @Nullable
    private final String geoSessionId;
    @SerializedName("laasTitle")
    @Nullable
    private final String title;
    @SerializedName("laasTooltipType")
    @Nullable
    private final TooltipType tooltipType;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LocationNotification> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationNotification createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LocationNotification(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (TooltipType) Enum.valueOf(TooltipType.class, parcel.readString()) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LocationNotification[] newArray(int i) {
            return new LocationNotification[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/location_notification/LocationNotification$TooltipType;", "", "<init>", "(Ljava/lang/String;I)V", "CHANGE", "REGULAR", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum TooltipType {
        CHANGE,
        REGULAR
    }

    public LocationNotification() {
        this(null, null, null, null, null, 31, null);
    }

    public LocationNotification(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TooltipType tooltipType2, @Nullable String str4) {
        this.title = str;
        this.confirmText = str2;
        this.changeText = str3;
        this.tooltipType = tooltipType2;
        this.geoSessionId = str4;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getChangeText() {
        return this.changeText;
    }

    @Nullable
    public final String getConfirmText() {
        return this.confirmText;
    }

    @Nullable
    public final String getGeoSessionId() {
        return this.geoSessionId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final TooltipType getTooltipType() {
        return this.tooltipType;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.confirmText);
        parcel.writeString(this.changeText);
        TooltipType tooltipType2 = this.tooltipType;
        if (tooltipType2 != null) {
            parcel.writeInt(1);
            parcel.writeString(tooltipType2.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.geoSessionId);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationNotification(String str, String str2, String str3, TooltipType tooltipType2, String str4, int i, j jVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? TooltipType.REGULAR : tooltipType2, (i & 16) != 0 ? "" : str4);
    }
}
