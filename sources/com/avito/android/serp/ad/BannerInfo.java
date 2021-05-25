package com.avito.android.serp.ad;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.AdfoxBannerItem;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.LoadedNetworkBanner;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.remote.model.YandexBannerItem;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b'\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EBu\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\u00105\u001a\u0004\u0018\u00010\u0004\u0012\b\u00103\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u00101\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010@\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u001f\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00109\u001a\u00020\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u001f\u0012\b\b\u0002\u0010>\u001a\u00020\u0011¢\u0006\u0004\bC\u0010DJ\u0019\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010$\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001bR\u0019\u0010+\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#R\u0019\u0010/\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0010R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001bR\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001bR\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u001bR\u0019\u00109\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0013R\"\u0010>\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u00107\u001a\u0004\b;\u0010\u0013\"\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u001bR\u001c\u0010B\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\bA\u0010#¨\u0006F"}, d2 = {"Lcom/avito/android/serp/ad/BannerInfo;", "Landroid/os/Parcelable;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker$Item;", "", "", "", "toMap", "()Ljava/util/Map;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "hasAlidAndBannerCode", "()Z", "", "params", "key", "value", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "", "l", "J", "getLoadTime", "()J", "loadTime", "e", "partnerId", g.a, ChannelContext.System.TYPE, "i", "getPageCdtm", "pageCdtm", "j", "I", "getFallbackCount", "fallbackCount", "f", "statId", "d", "bannerCode", "c", "alid", "k", "Z", "getSamplingEnabled", "samplingEnabled", AuthSource.OPEN_CHANNEL_LIST, "getWasOpened", "setWasOpened", "(Z)V", "wasOpened", "h", "adSlot", "getTrackId", "trackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZJZ)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class BannerInfo implements Parcelable, ItemVisibilityTracker.Item {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<BannerInfo> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final BannerInfo n = new BannerInfo("", null, null, "", "", "", "", 0, 0, false, 0, false, 3968, null);
    public final long a;
    @NotNull
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final long i;
    public final int j;
    public final boolean k;
    public final long l;
    public boolean m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJI\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00168\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/serp/ad/BannerInfo$Companion;", "", "Lcom/avito/android/remote/model/AdNetworkBannerItem;", "bannerItem", "Lcom/avito/android/remote/model/CommercialBanner;", "commercialBanner", "Lcom/avito/android/serp/ad/BannerInfo;", "from", "(Lcom/avito/android/remote/model/AdNetworkBannerItem;Lcom/avito/android/remote/model/CommercialBanner;)Lcom/avito/android/serp/ad/BannerInfo;", "", "pageCdtm", "", "fallbackCount", "", "samplingEnabled", "loadTime", "wasOpened", "(Lcom/avito/android/remote/model/AdNetworkBannerItem;JIZJZ)Lcom/avito/android/serp/ad/BannerInfo;", "EMPTY", "Lcom/avito/android/serp/ad/BannerInfo;", "getEMPTY", "()Lcom/avito/android/serp/ad/BannerInfo;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ BannerInfo from$default(Companion companion, AdNetworkBannerItem adNetworkBannerItem, CommercialBanner commercialBanner, int i, Object obj) {
            if ((i & 2) != 0) {
                commercialBanner = null;
            }
            return companion.from(adNetworkBannerItem, commercialBanner);
        }

        @NotNull
        public final BannerInfo from(@Nullable AdNetworkBannerItem<?> adNetworkBannerItem, @Nullable CommercialBanner commercialBanner) {
            LoadedNetworkBanner loadedNetworkBanner;
            LoadedNetworkBanner loadedNetworkBanner2;
            LoadedNetworkBanner loadedNetworkBanner3;
            long j = 0;
            long pageCdtm = commercialBanner != null ? commercialBanner.getPageCdtm() : 0;
            int fallbackCount = (commercialBanner == null || (loadedNetworkBanner3 = commercialBanner.getLoadedNetworkBanner()) == null) ? 0 : loadedNetworkBanner3.getFallbackCount();
            boolean samplingEnabled = commercialBanner != null ? commercialBanner.getSamplingEnabled() : false;
            if (!(commercialBanner == null || (loadedNetworkBanner2 = commercialBanner.getLoadedNetworkBanner()) == null)) {
                j = loadedNetworkBanner2.getLoadTime();
            }
            return from(adNetworkBannerItem, pageCdtm, fallbackCount, samplingEnabled, j, (commercialBanner == null || (loadedNetworkBanner = commercialBanner.getLoadedNetworkBanner()) == null) ? false : loadedNetworkBanner.getWasOpened());
        }

        @NotNull
        public final BannerInfo getEMPTY() {
            return BannerInfo.n;
        }

        public Companion(j jVar) {
        }

        public static /* synthetic */ BannerInfo from$default(Companion companion, AdNetworkBannerItem adNetworkBannerItem, long j, int i, boolean z, long j2, boolean z2, int i2, Object obj) {
            return companion.from(adNetworkBannerItem, j, i, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 0 : j2, (i2 & 32) != 0 ? false : z2);
        }

        @NotNull
        public final BannerInfo from(@Nullable AdNetworkBannerItem<?> adNetworkBannerItem, long j, int i, boolean z, long j2, boolean z2) {
            if (adNetworkBannerItem instanceof YandexBannerItem) {
                String str = (String) ((YandexBannerItem) adNetworkBannerItem).getId();
                String alid = adNetworkBannerItem.getAlid();
                String bannerCode = adNetworkBannerItem.getBannerCode();
                YandexBannerItem yandexBannerItem = (YandexBannerItem) adNetworkBannerItem;
                String partnerId = yandexBannerItem.getPartnerId();
                String statId = yandexBannerItem.getStatId();
                String str2 = adNetworkBannerItem instanceof AdfoxBannerItem ? "adfox" : "yandex";
                StringBuilder L = a2.b.a.a.a.L("6_");
                L.append(StringsKt__StringsKt.removePrefix((String) yandexBannerItem.getId(), (CharSequence) "R-M-"));
                L.append('-');
                L.append(yandexBannerItem.getStatId());
                L.append("-rtb");
                return new BannerInfo(str, alid, bannerCode, partnerId, statId, str2, L.toString(), j, i, z, j2, z2);
            } else if (adNetworkBannerItem instanceof DfpBannerItem) {
                return new BannerInfo(((DfpBannerItem) adNetworkBannerItem).getId(), adNetworkBannerItem.getAlid(), adNetworkBannerItem.getBannerCode(), "", "", "dfp", ((DfpBannerItem) adNetworkBannerItem).getId(), j, i, z, j2, z2);
            } else {
                if (adNetworkBannerItem instanceof MyTargetBannerItem) {
                    String valueOf = String.valueOf(((MyTargetBannerItem) adNetworkBannerItem).getId().intValue());
                    String alid2 = adNetworkBannerItem.getAlid();
                    String bannerCode2 = adNetworkBannerItem.getBannerCode();
                    StringBuilder L2 = a2.b.a.a.a.L("9_");
                    L2.append(((MyTargetBannerItem) adNetworkBannerItem).getId().intValue());
                    return new BannerInfo(valueOf, alid2, bannerCode2, "", "", "myTarget", L2.toString(), j, i, z, j2, z2);
                }
                Logs.error$default(BannerInfoContainerKt.TAG, "EMPTY BannerInfo returned", null, 4, null);
                return getEMPTY();
            }
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, BannerInfo> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public BannerInfo invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new BannerInfo(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), parcel2.readString(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readLong(), parcel2.readInt(), ParcelsKt.readBool(parcel2), parcel2.readLong(), ParcelsKt.readBool(parcel2));
        }
    }

    public BannerInfo(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, long j2, int i2, boolean z, long j3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str4, "partnerId");
        Intrinsics.checkNotNullParameter(str5, "statId");
        Intrinsics.checkNotNullParameter(str6, ChannelContext.System.TYPE);
        Intrinsics.checkNotNullParameter(str7, "adSlot");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = j2;
        this.j = i2;
        this.k = z;
        this.l = j3;
        this.m = z2;
        this.a = ((long) str.hashCode()) + j2 + j3;
    }

    public final void a(Map<String, Object> map, String str, String str2) {
        if (str2.length() > 0) {
            map.put(str, str2);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getFallbackCount() {
        return this.j;
    }

    @NotNull
    public final String getId() {
        return this.b;
    }

    public final long getLoadTime() {
        return this.l;
    }

    public final long getPageCdtm() {
        return this.i;
    }

    public final boolean getSamplingEnabled() {
        return this.k;
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
    public long getTrackId() {
        return this.a;
    }

    public final boolean getWasOpened() {
        return this.m;
    }

    public final boolean hasAlidAndBannerCode() {
        return (this.c == null || this.d == null) ? false : true;
    }

    public final void setWasOpened(boolean z) {
        this.m = z;
    }

    @NotNull
    public final Map<String, Object> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(linkedHashMap, "adpartner", this.e);
        a(linkedHashMap, "block_id", this.b);
        a(linkedHashMap, "selling_system", this.g);
        a(linkedHashMap, "adslot", this.h);
        if (this.f.length() > 0) {
            linkedHashMap.put("statid", Integer.valueOf(Integer.parseInt(this.f)));
        }
        String str = this.c;
        if (str != null) {
            linkedHashMap.put("alid", str);
        }
        String str2 = this.d;
        if (str2 == null) {
            str2 = "app";
        }
        linkedHashMap.put("banner_code", str2);
        return linkedHashMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeLong(this.i);
        parcel.writeInt(this.j);
        ParcelsKt.writeBool(parcel, this.k);
        parcel.writeLong(this.l);
        ParcelsKt.writeBool(parcel, this.m);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, int i2, boolean z, long j3, boolean z2, int i3, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, (i3 & 128) != 0 ? 0 : j2, (i3 & 256) != 0 ? 0 : i2, (i3 & 512) != 0 ? false : z, (i3 & 1024) != 0 ? 0 : j3, (i3 & 2048) != 0 ? false : z2);
    }
}
