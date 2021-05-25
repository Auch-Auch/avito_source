package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0010\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\b\b\u0002\u0010&\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0013R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/CommercialBanner;", "Landroid/os/Parcelable;", "", "pageCdtm", "Lcom/avito/android/remote/model/LoadedNetworkBanner;", "banner", "copy", "(JLcom/avito/android/remote/model/LoadedNetworkBanner;)Lcom/avito/android/remote/model/CommercialBanner;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isLoaded", "()Z", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "adNetworkBannerItems", "Ljava/util/List;", "getAdNetworkBannerItems", "()Ljava/util/List;", "loadedNetworkBanner", "Lcom/avito/android/remote/model/LoadedNetworkBanner;", "getLoadedNetworkBanner", "()Lcom/avito/android/remote/model/LoadedNetworkBanner;", "", "uniqueId", "Ljava/lang/String;", "getUniqueId", "()Ljava/lang/String;", "getLoadedNetworkBannerItem", "()Lcom/avito/android/remote/model/AdNetworkBannerItem;", "loadedNetworkBannerItem", "samplingEnabled", "Z", "getSamplingEnabled", "J", "getPageCdtm", "()J", "<init>", "(Ljava/lang/String;Ljava/util/List;ZJLcom/avito/android/remote/model/LoadedNetworkBanner;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CommercialBanner implements Parcelable {
    public static final Parcelable.Creator<CommercialBanner> CREATOR = new Creator();
    @NotNull
    private final List<AdNetworkBannerItem<?>> adNetworkBannerItems;
    @Nullable
    private final LoadedNetworkBanner loadedNetworkBanner;
    private final long pageCdtm;
    private final boolean samplingEnabled;
    @NotNull
    private final String uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CommercialBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommercialBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AdNetworkBannerItem) parcel.readParcelable(CommercialBanner.class.getClassLoader()));
                readInt--;
            }
            return new CommercialBanner(readString, arrayList, parcel.readInt() != 0, parcel.readLong(), (LoadedNetworkBanner) parcel.readParcelable(CommercialBanner.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommercialBanner[] newArray(int i) {
            return new CommercialBanner[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.AdNetworkBannerItem<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public CommercialBanner(@NotNull String str, @NotNull List<? extends AdNetworkBannerItem<?>> list, boolean z, long j, @Nullable LoadedNetworkBanner loadedNetworkBanner2) {
        Intrinsics.checkNotNullParameter(str, "uniqueId");
        Intrinsics.checkNotNullParameter(list, "adNetworkBannerItems");
        this.uniqueId = str;
        this.adNetworkBannerItems = list;
        this.samplingEnabled = z;
        this.pageCdtm = j;
        this.loadedNetworkBanner = loadedNetworkBanner2;
    }

    @NotNull
    public final CommercialBanner copy(long j, @Nullable LoadedNetworkBanner loadedNetworkBanner2) {
        return new CommercialBanner(this.uniqueId, this.adNetworkBannerItems, this.samplingEnabled, j, loadedNetworkBanner2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<AdNetworkBannerItem<?>> getAdNetworkBannerItems() {
        return this.adNetworkBannerItems;
    }

    @Nullable
    public final LoadedNetworkBanner getLoadedNetworkBanner() {
        return this.loadedNetworkBanner;
    }

    @Nullable
    public final AdNetworkBannerItem<?> getLoadedNetworkBannerItem() {
        String str;
        Iterator<T> it = this.adNetworkBannerItems.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            String valueOf = String.valueOf(next.getId());
            LoadedNetworkBanner loadedNetworkBanner2 = this.loadedNetworkBanner;
            if (loadedNetworkBanner2 != null) {
                str = loadedNetworkBanner2.getId();
            }
            if (Intrinsics.areEqual(valueOf, str)) {
                str = next;
                break;
            }
        }
        return (AdNetworkBannerItem) str;
    }

    public final long getPageCdtm() {
        return this.pageCdtm;
    }

    public final boolean getSamplingEnabled() {
        return this.samplingEnabled;
    }

    @NotNull
    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean isLoaded() {
        LoadedNetworkBanner loadedNetworkBanner2 = this.loadedNetworkBanner;
        return loadedNetworkBanner2 != null && loadedNetworkBanner2.isLoaded();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uniqueId);
        Iterator n0 = a.n0(this.adNetworkBannerItems, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((AdNetworkBannerItem) n0.next(), i);
        }
        parcel.writeInt(this.samplingEnabled ? 1 : 0);
        parcel.writeLong(this.pageCdtm);
        parcel.writeParcelable(this.loadedNetworkBanner, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommercialBanner(String str, List list, boolean z, long j, LoadedNetworkBanner loadedNetworkBanner2, int i, j jVar) {
        this(str, list, (i & 4) != 0 ? false : z, (i & 8) != 0 ? 0 : j, (i & 16) != 0 ? null : loadedNetworkBanner2);
    }
}
