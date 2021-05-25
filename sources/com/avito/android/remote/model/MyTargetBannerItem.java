package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001%B9\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a¢\u0006\u0004\b#\u0010$J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/MyTargetBannerItem;", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "bannerCode", "Ljava/lang/String;", "getBannerCode", "()Ljava/lang/String;", "alid", "getAlid", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "id", "I", "getId", "()Ljava/lang/Integer;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetBannerItem implements AdNetworkBannerItem<Integer>, SerpElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MyTargetBannerItem> CREATOR = Parcels.creator(MyTargetBannerItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("alid")
    @Nullable
    private final String alid;
    @SerializedName("bannerCode")
    @Nullable
    private final String bannerCode;
    @SerializedName("id")
    private final int id;
    @SerializedName("params")
    @Nullable
    private final Map<String, String> params;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/MyTargetBannerItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/MyTargetBannerItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public MyTargetBannerItem(int i, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map) {
        this.id = i;
        this.alid = str;
        this.bannerCode = str2;
        this.params = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.AdNetworkBannerItem
    @Nullable
    public String getAlid() {
        return this.alid;
    }

    @Override // com.avito.android.remote.model.AdNetworkBannerItem
    @Nullable
    public String getBannerCode() {
        return this.bannerCode;
    }

    @Nullable
    public final Map<String, String> getParams() {
        return this.params;
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
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(getId().intValue());
        parcel.writeString(getAlid());
        parcel.writeString(getBannerCode());
        ParcelsKt.writeValueMap(parcel, this.params);
        parcel.writeLong(getUniqueId());
    }

    @Override // com.avito.android.remote.model.AdNetworkBannerItem
    @NotNull
    public Integer getId() {
        return Integer.valueOf(this.id);
    }
}
