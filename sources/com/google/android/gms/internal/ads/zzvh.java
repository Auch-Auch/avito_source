package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
public final class zzvh {
    public static final zzvh zzchm = new zzvh();

    public static zzvc zza(Context context, zzyo zzyo) {
        List list;
        Context context2;
        zzuu zzuu;
        String str;
        Date birthday = zzyo.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzyo.getContentUrl();
        int gender = zzyo.getGender();
        Set<String> keywords = zzyo.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzyo.isTestDevice(context2);
        Location location = zzyo.getLocation();
        Bundle networkExtrasBundle = zzyo.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzyo.zzqr() != null) {
            zzuu = new zzuu(zzyo.zzqr().getAdString(), zzwe.zzpy().containsKey(zzyo.zzqr().getQueryInfo()) ? zzwe.zzpy().get(zzyo.zzqr().getQueryInfo()) : "");
        } else {
            zzuu = null;
        }
        boolean manualImpressionsEnabled = zzyo.getManualImpressionsEnabled();
        String publisherProvidedId = zzyo.getPublisherProvidedId();
        SearchAdRequest zzqm = zzyo.zzqm();
        zzzy zzzy = zzqm != null ? new zzzy(zzqm) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwe.zzpq();
            str = zzbat.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzyo.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzyv.zzqt().getRequestConfiguration();
        return new zzvc(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzyo.zzqp(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzzy, location, contentUrl, zzyo.zzqo(), zzyo.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzyo.zzqq())), zzyo.zzql(), str, isDesignedForFamilies, zzuu, Math.max(zzyo.zzqs(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(zzyo.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()), zzvg.zzchl), zzyo.zzqk());
    }

    public static zzatz zza(Context context, zzyo zzyo, String str) {
        return new zzatz(zza(context, zzyo), str);
    }
}
