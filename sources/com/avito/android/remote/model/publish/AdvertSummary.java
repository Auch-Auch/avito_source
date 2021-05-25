package com.avito.android.remote.model.publish;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001!BA\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/publish/AdvertSummary;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "isAuto", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "price", "getPrice", "status", "getStatus", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "itemId", "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;)V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSummary implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertSummary> CREATOR = Parcels.creator(AdvertSummary$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("isAuto")
    @Nullable
    private final Boolean isAuto;
    @SerializedName("id")
    @NotNull
    private final String itemId;
    @SerializedName("price")
    @Nullable
    private final String price;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/publish/AdvertSummary$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/publish/AdvertSummary;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public AdvertSummary(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Image image2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.itemId = str;
        this.title = str2;
        this.price = str3;
        this.status = str4;
        this.image = image2;
        this.isAuto = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isAuto() {
        return this.isAuto;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.itemId);
        parcel.writeString(this.title);
        parcel.writeString(this.price);
        parcel.writeString(this.status);
        parcel.writeParcelable(this.image, i);
        ParcelsKt.writeNullableValue(parcel, this.isAuto);
    }
}
