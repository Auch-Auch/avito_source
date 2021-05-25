package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzadl;
    private final int zzdkj;
    private final String zzdln;
    private final String zzeqb;
    private final Bundle zzeqc;
    private final Bundle zzeqd;
    private final int zzeqe;
    private final boolean zzna;
    private final Location zznb;
    private final Context zzvr;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, String str3) {
        this.zzeqb = str;
        this.zzeqc = bundle;
        this.zzeqd = bundle2;
        this.zzvr = context;
        this.zzna = z;
        this.zznb = location;
        this.zzdkj = i;
        this.zzeqe = i2;
        this.zzadl = str2;
        this.zzdln = str3;
    }

    public String getBidResponse() {
        return this.zzeqb;
    }

    public Context getContext() {
        return this.zzvr;
    }

    public Location getLocation() {
        return this.zznb;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.zzadl;
    }

    public Bundle getMediationExtras() {
        return this.zzeqd;
    }

    public Bundle getServerParameters() {
        return this.zzeqc;
    }

    public String getWatermark() {
        return this.zzdln;
    }

    public boolean isTestRequest() {
        return this.zzna;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdkj;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzeqe;
    }
}
