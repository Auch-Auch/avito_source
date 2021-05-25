package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class zzanv implements NativeMediationAdRequest {
    private final String zzadl;
    private final int zzcgw;
    private final boolean zzchh;
    private final int zzdkj;
    private final int zzdkk;
    private final zzadm zzdla;
    private final List<String> zzdlb = new ArrayList();
    private final Map<String, Boolean> zzdlc = new HashMap();
    private final Date zzmx;
    private final Set<String> zzmz;
    private final boolean zzna;
    private final Location zznb;

    public zzanv(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzadm zzadm, List<String> list, boolean z2, int i3, String str) {
        this.zzmx = date;
        this.zzcgw = i;
        this.zzmz = set;
        this.zznb = location;
        this.zzna = z;
        this.zzdkj = i2;
        this.zzdla = zzadm;
        this.zzchh = z2;
        this.zzdkk = i3;
        this.zzadl = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            this.zzdlc.put(split[1], Boolean.TRUE);
                        } else if ("false".equals(split[2])) {
                            this.zzdlc.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzdlb.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzyv.zzqt().zzqd();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcgw;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zznb;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        zzaac zzaac;
        if (this.zzdla == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdla.zzdcs).setImageOrientation(this.zzdla.zzbnj).setRequestMultipleImages(this.zzdla.zzbnl);
        zzadm zzadm = this.zzdla;
        if (zzadm.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzadm.zzbnm);
        }
        zzadm zzadm2 = this.zzdla;
        if (zzadm2.versionCode >= 3 && (zzaac = zzadm2.zzdct) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzaac));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzyv.zzqt().zzqe();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdlb;
        if (list != null) {
            return list.contains(ExifInterface.GPS_MEASUREMENT_2D) || this.zzdlb.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdlb;
        if (list != null) {
            return list.contains("1") || this.zzdlb.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzna;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdlb;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdkj;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzuf() {
        List<String> list = this.zzdlb;
        return list != null && list.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzug() {
        return this.zzdlc;
    }
}
