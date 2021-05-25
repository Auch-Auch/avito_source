package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b!\u0010\"J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/SerpBannerContainer;", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "", "size", "Ljava/lang/String;", "getSize", "()Ljava/lang/String;", "", "enableEventSampling", "Ljava/lang/Boolean;", "getEnableEventSampling", "()Ljava/lang/Boolean;", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SerpBannerContainer implements SerpElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpBannerContainer> CREATOR = Parcels.creator(SerpBannerContainer$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("list")
    @NotNull
    private final List<SerpElement> elements;
    @SerializedName("enableEventSampling")
    @Nullable
    private final Boolean enableEventSampling;
    @SerializedName("size")
    @Nullable
    private final String size;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SerpBannerContainer$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SerpBannerContainer;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public SerpBannerContainer(@NotNull List<? extends SerpElement> list, @Nullable String str, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.elements = list;
        this.size = str;
        this.enableEventSampling = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<SerpElement> getElements() {
        return this.elements;
    }

    @Nullable
    public final Boolean getEnableEventSampling() {
        return this.enableEventSampling;
    }

    @Nullable
    public final String getSize() {
        return this.size;
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
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            ParcelsKt.writeOptimizedParcelableList$default(parcel, this.elements, 0, 2, null);
            parcel.writeString(this.size);
            ParcelsKt.writeOptBoolean(parcel, this.enableEventSampling);
            parcel.writeLong(getUniqueId());
        }
    }
}
