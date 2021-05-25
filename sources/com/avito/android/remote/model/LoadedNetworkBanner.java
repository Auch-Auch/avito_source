package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B9\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\nR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/LoadedNetworkBanner;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "loadTime", "J", "getLoadTime", "()J", "", "isLoaded", "()Z", "fallbackCount", "I", "getFallbackCount", "Lcom/avito/android/remote/model/AdNetworkBanner;", "adNetworkBanner", "Lcom/avito/android/remote/model/AdNetworkBanner;", "getAdNetworkBanner", "()Lcom/avito/android/remote/model/AdNetworkBanner;", "wasOpened", "Z", "getWasOpened", "setWasOpened", "(Z)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/AdNetworkBanner;IJZ)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LoadedNetworkBanner implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<LoadedNetworkBanner> CREATOR = Parcels.creator(LoadedNetworkBanner$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final AdNetworkBanner adNetworkBanner;
    private final int fallbackCount;
    @NotNull
    private final String id;
    private final long loadTime;
    private boolean wasOpened;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/LoadedNetworkBanner$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/LoadedNetworkBanner;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public LoadedNetworkBanner(@NotNull String str, @Nullable AdNetworkBanner adNetworkBanner2, int i, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.adNetworkBanner = adNetworkBanner2;
        this.fallbackCount = i;
        this.loadTime = j;
        this.wasOpened = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdNetworkBanner getAdNetworkBanner() {
        return this.adNetworkBanner;
    }

    public final int getFallbackCount() {
        return this.fallbackCount;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getLoadTime() {
        return this.loadTime;
    }

    public final boolean getWasOpened() {
        return this.wasOpened;
    }

    public final boolean isLoaded() {
        return this.adNetworkBanner != null;
    }

    public final void setWasOpened(boolean z) {
        this.wasOpened = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeInt(this.fallbackCount);
        parcel.writeLong(this.loadTime);
        ParcelsKt.writeBool(parcel, this.wasOpened);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoadedNetworkBanner(String str, AdNetworkBanner adNetworkBanner2, int i, long j, boolean z, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? null : adNetworkBanner2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0 : j, (i2 & 16) != 0 ? false : z);
    }
}
