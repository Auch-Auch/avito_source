package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\f\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015Bu\u0012\u0006\u0010/\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010(\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010&\u001a\u00020\f\u0012\b\u00101\u001a\u0004\u0018\u00010\f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a\u0012\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010*¢\u0006\u0004\b3\u00104J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010R\u001c\u0010(\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010R*\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010R\u001e\u00101\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/YandexNativeBannerItem;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/remote/model/YandexBannerItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "alid", "Ljava/lang/String;", "getAlid", "()Ljava/lang/String;", "hash", "getHash", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", "contextTags", "Ljava/util/List;", "getContextTags", "()Ljava/util/List;", "bannerCode", "getBannerCode", "Lcom/avito/android/remote/model/Coordinates;", "location", "Lcom/avito/android/remote/model/Coordinates;", "getLocation", "()Lcom/avito/android/remote/model/Coordinates;", "statId", "getStatId", "partnerId", "getPartnerId", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "id", "getId", "query", "getQuery", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/util/List;Ljava/util/Map;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class YandexNativeBannerItem implements SerpElement, YandexBannerItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<YandexNativeBannerItem> CREATOR = Parcels.creator(YandexNativeBannerItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("alid")
    @Nullable
    private final String alid;
    @SerializedName("bannerCode")
    @Nullable
    private final String bannerCode;
    @SerializedName("contextTags")
    @NotNull
    private final List<String> contextTags;
    @SerializedName("hash")
    @Nullable
    private final String hash;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("location")
    @Nullable
    private final Coordinates location;
    @SerializedName("params")
    @Nullable
    private final Map<String, String> params;
    @SerializedName("partnerId")
    @NotNull
    private final String partnerId;
    @SerializedName("query")
    @Nullable
    private final String query;
    @SerializedName("statId")
    @NotNull
    private final String statId;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/YandexNativeBannerItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/YandexNativeBannerItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public YandexNativeBannerItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7, @Nullable Coordinates coordinates, @NotNull List<String> list, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, "partnerId");
        Intrinsics.checkNotNullParameter(str6, "statId");
        Intrinsics.checkNotNullParameter(list, "contextTags");
        this.id = str;
        this.alid = str2;
        this.bannerCode = str3;
        this.partnerId = str4;
        this.hash = str5;
        this.statId = str6;
        this.query = str7;
        this.location = coordinates;
        this.contextTags = list;
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

    @Override // com.avito.android.remote.model.YandexBannerItem
    @NotNull
    public List<String> getContextTags() {
        return this.contextTags;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @Nullable
    public String getHash() {
        return this.hash;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @Nullable
    public Coordinates getLocation() {
        return this.location;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @Nullable
    public Map<String, String> getParams() {
        return this.params;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @NotNull
    public String getPartnerId() {
        return this.partnerId;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @Nullable
    public String getQuery() {
        return this.query;
    }

    @Override // com.avito.android.remote.model.YandexBannerItem
    @NotNull
    public String getStatId() {
        return this.statId;
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
            parcel.writeString(getId());
            parcel.writeString(getAlid());
            parcel.writeString(getBannerCode());
            parcel.writeString(getPartnerId());
            parcel.writeString(getHash());
            parcel.writeString(getStatId());
            parcel.writeString(getQuery());
            parcel.writeParcelable(getLocation(), i);
            parcel.writeStringList(getContextTags());
            ParcelsKt.writeValueMap(parcel, getParams());
            parcel.writeLong(getUniqueId());
        }
    }

    @Override // com.avito.android.remote.model.AdNetworkBannerItem
    @NotNull
    public String getId() {
        return this.id;
    }
}
