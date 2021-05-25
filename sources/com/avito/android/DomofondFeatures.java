package com.avito.android;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.AppFeatures;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.toggle.Feature;
import com.avito.android.util.DomofondBuildInfo;
import com.sumsub.sns.core.common.SNSConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\bn\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0013\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001R#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00078V@\u0016X\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\n\u0012\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\fR#\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b$\u0010\fR#\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\fR#\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\fR#\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\fR#\u00101\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\fR#\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b3\u0010\fR#\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b5\u0010\n\u001a\u0004\b6\u0010\fR#\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b8\u0010\n\u001a\u0004\b9\u0010\fR#\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b<\u0010\fR#\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b>\u0010\n\u001a\u0004\b?\u0010\fR#\u0010C\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bA\u0010\n\u001a\u0004\bB\u0010\fR#\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bD\u0010\n\u001a\u0004\bE\u0010\fR#\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bG\u0010\n\u001a\u0004\bH\u0010\fR#\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bK\u0010\fR#\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bN\u0010\fR#\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bP\u0010\n\u001a\u0004\bQ\u0010\fR#\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bS\u0010\n\u001a\u0004\bT\u0010\fR#\u0010X\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bV\u0010\n\u001a\u0004\bW\u0010\fR#\u0010[\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bY\u0010\n\u001a\u0004\bZ\u0010\fR#\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b\\\u0010\n\u001a\u0004\b]\u0010\fR#\u0010a\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b_\u0010\n\u001a\u0004\b`\u0010\fR#\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bb\u0010\n\u001a\u0004\bc\u0010\fR#\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\be\u0010\n\u001a\u0004\bf\u0010\fR#\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bh\u0010\n\u001a\u0004\bi\u0010\fR#\u0010m\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bk\u0010\n\u001a\u0004\bl\u0010\fR#\u0010p\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bn\u0010\n\u001a\u0004\bo\u0010\fR#\u0010s\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bq\u0010\n\u001a\u0004\br\u0010\fR#\u0010v\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bt\u0010\n\u001a\u0004\bu\u0010\fR#\u0010y\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bw\u0010\n\u001a\u0004\bx\u0010\fR#\u0010|\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\bz\u0010\n\u001a\u0004\b{\u0010\fR#\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\f\n\u0004\b}\u0010\n\u001a\u0004\b~\u0010\fR&\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\n\u001a\u0005\b\u0001\u0010\fR&\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\n\u001a\u0005\b\u0001\u0010\fR&\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\n\u001a\u0005\b\u0001\u0010\fR&\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\n\u001a\u0005\b\u0001\u0010\f¨\u0006\u0001"}, d2 = {"Lcom/avito/android/DomofondFeatures;", "Lcom/avito/android/AppFeatures;", "Lcom/avito/android/AppConfigurationToggles;", "Lcom/avito/android/ClickstreamToggles;", "Lcom/avito/android/RemoteToggles;", "Lcom/avito/android/StatsdToggles;", "Lcom/avito/android/AnalyticsToggles;", "Lcom/avito/android/toggle/Feature;", "", "t", "Lcom/avito/android/AppFeatures$FeatureDelegate;", "getCostAreaSquareMeter", "()Lcom/avito/android/toggle/Feature;", "costAreaSquareMeter", "H", "getFiltersDeeplink", "filtersDeeplink", "s", "getClickstream", "clickstream", "O", "getShowAdvertChart", "showAdvertChart", "e", "getMigration", "migration", "i", "getStatsdStrictMode", "statsdStrictMode", "", AuthSource.BOOKING_ORDER, "getAppVersionName", "getAppVersionName$annotations", "()V", "appVersionName", "o", "getReportNonFatalsToClickstream", "reportNonFatalsToClickstream", AuthSource.SEND_ABUSE, "getApiUrl", "apiUrl", "n", "getClickstreamStrictMode", "clickstreamStrictMode", VKApiConst.Q, "getClickstreamDeliveryImprovements", "clickstreamDeliveryImprovements", "k", "getRemoteToggles", "remoteToggles", "L", "getAdvertItemWeblink", "advertItemWeblink", "y", "getMapEqualsList", "mapEqualsList", "f", "getGuestFavorites", "guestFavorites", "c", "getSocialAuth", "socialAuth", "F", "getItemsCounter", "itemsCounter", "u", "getCommercialRentalType", "commercialRentalType", "M", "getCommercialAdfox", "commercialAdfox", "z", "getLeakCanaryEnabled", "leakCanaryEnabled", "h", "getStatsdApiUrl", "statsdApiUrl", ExifInterface.LONGITUDE_EAST, "getPushViaFCM", "pushViaFCM", "p", "getSendNonfatalWithStacktrace", "sendNonfatalWithStacktrace", "G", "getClickStreamEventsEnabled", "clickStreamEventsEnabled", "w", "getRateThisApp", "rateThisApp", "K", "getBuyerAnalytics", "buyerAnalytics", VKApiConst.VERSION, "getMapCaching", "mapCaching", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getRedesignSearchResults", "redesignSearchResults", "B", "getCrashOnLogsError", "crashOnLogsError", "l", "getRemoteTogglesMonitor", "remoteTogglesMonitor", g.a, "getLogAnalyticEvents", "logAnalyticEvents", "x", "getRatingScreen", "ratingScreen", "D", "getMapImprovedDrawing", "mapImprovedDrawing", "j", "getSendGraphiteEvents", "sendGraphiteEvents", "C", "getDeviceId", "deviceId", "d", "getPanorama", "panorama", "J", "getHidePhoneByFlag", "hidePhoneByFlag", "r", "getClickstreamTimerTrigger", "clickstreamTimerTrigger", AuthSource.OPEN_CHANNEL_LIST, "getRemoteTogglesFunctionalTestMonitor", "remoteTogglesFunctionalTestMonitor", "I", "getGetPhoneByRequest", "getPhoneByRequest", "N", "getNonFatalCrashesReporing", "nonFatalCrashesReporing", "P", "getStatsdGzip", "statsdGzip", "Lcom/avito/android/util/DomofondBuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/util/DomofondBuildInfo;)V", "features_release"}, k = 1, mv = {1, 4, 2})
public class DomofondFeatures extends AppFeatures implements AppConfigurationToggles, ClickstreamToggles, RemoteToggles, StatsdToggles, AnalyticsToggles {
    public static final /* synthetic */ KProperty[] Q = {a.v0(DomofondFeatures.class, "apiUrl", "getApiUrl()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "appVersionName", "getAppVersionName()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "socialAuth", "getSocialAuth()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "panorama", "getPanorama()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "migration", "getMigration()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "guestFavorites", "getGuestFavorites()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "logAnalyticEvents", "getLogAnalyticEvents()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "statsdApiUrl", "getStatsdApiUrl()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "statsdStrictMode", "getStatsdStrictMode()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "sendGraphiteEvents", "getSendGraphiteEvents()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "remoteToggles", "getRemoteToggles()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "remoteTogglesMonitor", "getRemoteTogglesMonitor()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "remoteTogglesFunctionalTestMonitor", "getRemoteTogglesFunctionalTestMonitor()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "clickstreamStrictMode", "getClickstreamStrictMode()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "reportNonFatalsToClickstream", "getReportNonFatalsToClickstream()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "sendNonfatalWithStacktrace", "getSendNonfatalWithStacktrace()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "clickstreamDeliveryImprovements", "getClickstreamDeliveryImprovements()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "clickstreamTimerTrigger", "getClickstreamTimerTrigger()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "clickstream", "getClickstream()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "costAreaSquareMeter", "getCostAreaSquareMeter()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "commercialRentalType", "getCommercialRentalType()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "mapCaching", "getMapCaching()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "rateThisApp", "getRateThisApp()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "ratingScreen", "getRatingScreen()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "mapEqualsList", "getMapEqualsList()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "leakCanaryEnabled", "getLeakCanaryEnabled()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "redesignSearchResults", "getRedesignSearchResults()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "crashOnLogsError", "getCrashOnLogsError()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "deviceId", "getDeviceId()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "mapImprovedDrawing", "getMapImprovedDrawing()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "pushViaFCM", "getPushViaFCM()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "itemsCounter", "getItemsCounter()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "clickStreamEventsEnabled", "getClickStreamEventsEnabled()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "filtersDeeplink", "getFiltersDeeplink()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "getPhoneByRequest", "getGetPhoneByRequest()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "hidePhoneByFlag", "getHidePhoneByFlag()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "buyerAnalytics", "getBuyerAnalytics()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "advertItemWeblink", "getAdvertItemWeblink()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "commercialAdfox", "getCommercialAdfox()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "nonFatalCrashesReporing", "getNonFatalCrashesReporing()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "showAdvertChart", "getShowAdvertChart()Lcom/avito/android/toggle/Feature;", 0), a.v0(DomofondFeatures.class, "statsdGzip", "getStatsdGzip()Lcom/avito/android/toggle/Feature;", 0)};
    @NotNull
    public final AppFeatures.FeatureDelegate A;
    @NotNull
    public final AppFeatures.FeatureDelegate B;
    @NotNull
    public final AppFeatures.FeatureDelegate C;
    @NotNull
    public final AppFeatures.FeatureDelegate D;
    @NotNull
    public final AppFeatures.FeatureDelegate E;
    @NotNull
    public final AppFeatures.FeatureDelegate F;
    @NotNull
    public final AppFeatures.FeatureDelegate G;
    @NotNull
    public final AppFeatures.FeatureDelegate H;
    @NotNull
    public final AppFeatures.FeatureDelegate I;
    @NotNull
    public final AppFeatures.FeatureDelegate J;
    @NotNull
    public final AppFeatures.FeatureDelegate K;
    @NotNull
    public final AppFeatures.FeatureDelegate L;
    @NotNull
    public final AppFeatures.FeatureDelegate M;
    @NotNull
    public final AppFeatures.FeatureDelegate N;
    @NotNull
    public final AppFeatures.FeatureDelegate O;
    @NotNull
    public final AppFeatures.FeatureDelegate P;
    @NotNull
    public final AppFeatures.FeatureDelegate a;
    @NotNull
    public final AppFeatures.FeatureDelegate b;
    @NotNull
    public final AppFeatures.FeatureDelegate c;
    @NotNull
    public final AppFeatures.FeatureDelegate d;
    @NotNull
    public final AppFeatures.FeatureDelegate e;
    @NotNull
    public final AppFeatures.FeatureDelegate f;
    @NotNull
    public final AppFeatures.FeatureDelegate g;
    @NotNull
    public final AppFeatures.FeatureDelegate h;
    @NotNull
    public final AppFeatures.FeatureDelegate i;
    @NotNull
    public final AppFeatures.FeatureDelegate j;
    @NotNull
    public final AppFeatures.FeatureDelegate k;
    @NotNull
    public final AppFeatures.FeatureDelegate l;
    @NotNull
    public final AppFeatures.FeatureDelegate m;
    @NotNull
    public final AppFeatures.FeatureDelegate n;
    @NotNull
    public final AppFeatures.FeatureDelegate o;
    @NotNull
    public final AppFeatures.FeatureDelegate p;
    @NotNull
    public final AppFeatures.FeatureDelegate q;
    @NotNull
    public final AppFeatures.FeatureDelegate r;
    @NotNull
    public final AppFeatures.FeatureDelegate s;
    @NotNull
    public final AppFeatures.FeatureDelegate t;
    @NotNull
    public final AppFeatures.FeatureDelegate u;
    @NotNull
    public final AppFeatures.FeatureDelegate v;
    @NotNull
    public final AppFeatures.FeatureDelegate w;
    @NotNull
    public final AppFeatures.FeatureDelegate x;
    @NotNull
    public final AppFeatures.FeatureDelegate y;
    @NotNull
    public final AppFeatures.FeatureDelegate z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DomofondFeatures(@NotNull DomofondBuildInfo domofondBuildInfo) {
        super(domofondBuildInfo);
        Intrinsics.checkNotNullParameter(domofondBuildInfo, "buildInfo");
        String apiUrl = domofondBuildInfo.getApiUrl();
        AvitoUnit avitoUnit = AvitoUnit.DOMOFOND;
        this.a = AppFeatures.createFeature$default(this, "API url", "api_url", apiUrl, null, false, avitoUnit, 8, null);
        this.b = AppFeatures.createFeature$default(this, "Версия приложения", "app_version_name", domofondBuildInfo.getVersionName(), null, false, avitoUnit, 8, null);
        Boolean bool = Boolean.FALSE;
        this.c = AppFeatures.createFeature$default(this, "Авторизация пользователя через социальные сети", "social_auth", bool, null, false, avitoUnit, 24, null);
        this.d = AppFeatures.createFeature$default(this, "Панорама на Yandex MapKit", "panorama", bool, null, false, avitoUnit, 24, null);
        Boolean bool2 = Boolean.TRUE;
        this.e = AppFeatures.createFeature$default(this, "Миграция избранного из локальной SQLite базы данных при обновлении африканского шедевра архитектуры до текущего приложения. Вынутое избранное во время миграции отправляется на сервер.", "migration", bool2, null, false, avitoUnit, 24, null);
        this.f = AppFeatures.createFeature$default(this, "Возможность добавления в избранное для гостей. Если false, то кнопка добавления в избранное будет скрыта для пользователей без авторизации.", "guest_favorites", bool2, null, false, avitoUnit, 24, null);
        this.g = AppFeatures.createFeature$default(this, "Логирование событий аналитики. Тэги Analytics, ClickStream", "log_analytic_events", Boolean.valueOf(domofondBuildInfo.isDebug()), null, false, avitoUnit, 8, null);
        this.h = AppFeatures.createFeature$default(this, "Statsd API url", "statsd_api_url", domofondBuildInfo.getStatsdApiUrl(), null, false, avitoUnit, 8, null);
        this.i = AppFeatures.createFeature$default(this, "Валидация событий реалтайм-аналитики", "statsd_strict_mode", Boolean.valueOf(domofondBuildInfo.isDebug()), null, false, avitoUnit, 8, null);
        this.j = AppFeatures.createFeature$default(this, "Отправлять события graphite", "send_graphite_analytic_events", bool2, null, false, avitoUnit, 8, null);
        this.k = AppFeatures.createFeature$default(this, "Использовать удаленные фичетоглы", "remote_toggles", bool2, null, false, avitoUnit, 8, null);
        this.l = AppFeatures.createFeature$default(this, "Мониторинг работы удаленных фичетоглов", "remote_toggle_monitor", bool, null, false, avitoUnit, 24, null);
        this.m = AppFeatures.createFeature$default(this, "Тогл для использования в функциональном тесте", "remote_toggle_functional_test_monitor", bool, null, false, avitoUnit, 24, null);
        this.n = AppFeatures.createFeature$default(this, "Валидация событий аналитики", "clickstream_strict_mode", Boolean.valueOf(domofondBuildInfo.isDebug()), null, false, avitoUnit, 8, null);
        this.o = AppFeatures.createFeature$default(this, "Отправлять Non-Fatal ошибки в clickstream", "reportNonFatalsToClickstream", bool, null, false, avitoUnit, 8, null);
        this.p = AppFeatures.createFeature$default(this, "Отправлять Non Fatal со стектрейсом", "sendNonfatalWithStacktrace", bool, null, false, avitoUnit, 8, null);
        this.q = AppFeatures.createFeature$default(this, "Эксперимент с уменьшением размера батча отправляемой статистики до 30.", "clickstreamDeliveryImprovements", bool, null, true, avitoUnit, 8, null);
        this.r = AppFeatures.createFeature$default(this, "Эксперимент с добавлением нового триггера - отправки событий раз в минуту жизни приложения.", "clickstreamTimerTrigger", bool, null, true, avitoUnit, 8, null);
        this.s = AppFeatures.createFeature$default(this, "Clickstream SDK", "clickstream-new-transport", bool, null, false, avitoUnit, 24, null);
        this.t = AppFeatures.createFeature$default(this, "Возможность фильтровать по квадратному метру в продаже", "cost_area_square_meter", bool, null, false, avitoUnit, 24, null);
        this.u = AppFeatures.createFeature$default(this, "Редизайн поля вида аренды для аренды коммерческой недвижимости", "commercial_rental_type", bool2, null, false, avitoUnit, 24, null);
        this.v = AppFeatures.createFeature$default(this, "Кеширование пинов на всех картах", "map_caching", bool, null, false, avitoUnit, 24, null);
        this.w = AppFeatures.createFeature$default(this, "Окно оценить приложение на главном экране", "rate_this_app", bool2, null, false, avitoUnit, 24, null);
        this.x = AppFeatures.createFeature$default(this, "Экран рейтингов о районах/городах и прочих местах обитания", "rating_screen", bool2, null, false, avitoUnit, 24, null);
        this.y = AppFeatures.createFeature$default(this, "Карта = список", "mapListPolygonSync", bool2, null, false, avitoUnit, 24, null);
        this.z = AppFeatures.createFeature$default(this, "Leak Canary", "leak_canary_enabled", Boolean.valueOf(domofondBuildInfo.isDebug()), null, false, avitoUnit, 8, null);
        this.A = AppFeatures.createFeature$default(this, "Редизайн поисковой выдачи", "redesignSearchResults", bool, null, true, avitoUnit, 8, null);
        this.B = AppFeatures.createFeature$default(this, "Crash on log error or warning", "crash_on_logs_error", Boolean.valueOf(domofondBuildInfo.isDebug()), null, false, avitoUnit, 8, null);
        this.C = AppFeatures.createFeature$default(this, "Device Id", SNSConstants.Preference.KEY_DEVICE_ID, "", null, false, avitoUnit, 8, null);
        this.D = AppFeatures.createFeature$default(this, "Корректное закрашивание выбранной области на карте", "mapImprovedDrawing", bool2, null, true, avitoUnit, 8, null);
        this.E = AppFeatures.createFeature$default(this, "Пуш через Firebase и Communications, а не через OneSignal", "pushViaCommunications", bool, null, true, avitoUnit, 8, null);
        this.F = AppFeatures.createFeature$default(this, "Счетчик результатов на фиильтрах", "itemsCounter", bool, null, true, avitoUnit, 8, null);
        this.G = AppFeatures.createFeature$default(this, "Включены события кликстрима", "clickstream-events-enabled", bool2, null, true, avitoUnit, 8, null);
        this.H = AppFeatures.createFeature$default(this, "Включен диплинк на поисковые фильтры", "filtersDeeplink", bool2, null, true, avitoUnit, 8, null);
        this.I = AppFeatures.createFeature$default(this, "Получаем телефон через отдельный запрос", "getPhoneByRequest", bool2, null, true, avitoUnit, 8, null);
        this.J = AppFeatures.createFeature$default(this, "Скрывать телефон при developmentContactHidePhone=true", "hidePhoneByFlag", bool2, null, true, avitoUnit, 8, null);
        this.K = AppFeatures.createFeature$default(this, "Новая байерская аналитика", "buyerAnalytics", bool, null, false, avitoUnit, 24, null);
        this.L = AppFeatures.createFeature$default(this, "Перевод со ссылки на объявление в приложение", "itemWebLink", bool, null, false, avitoUnit, 24, null);
        this.M = AppFeatures.createFeature$default(this, "Реклама Яндекса на выдаче и карточке", "commercialAdfox", bool2, null, false, avitoUnit, 24, null);
        this.N = AppFeatures.createFeature$default(this, "Репортинг нефатальных ошибок в консоль Firebase Crashlytics", "nonFatalCrashesReporing", bool2, null, false, avitoUnit, 24, null);
        this.O = AppFeatures.createFeature$default(this, "Показывать график на странице объявления", "showAdvertChart", bool, null, false, avitoUnit, 24, null);
        this.P = AppFeatures.createFeature$default(this, "Отправка gzip-ованных данных в аналитику", "statsd_gzip", bool, null, false, avitoUnit, 24, null);
    }

    public static /* synthetic */ void getAppVersionName$annotations() {
    }

    @NotNull
    public Feature<Boolean> getAdvertItemWeblink() {
        return this.L.getValue(this, Q[37]);
    }

    @NotNull
    public Feature<String> getApiUrl() {
        return this.a.getValue(this, Q[0]);
    }

    @Override // com.avito.android.AppConfigurationToggles
    @NotNull
    public Feature<String> getAppVersionName() {
        return this.b.getValue(this, Q[1]);
    }

    @NotNull
    public Feature<Boolean> getBuyerAnalytics() {
        return this.K.getValue(this, Q[36]);
    }

    @NotNull
    public Feature<Boolean> getClickStreamEventsEnabled() {
        return this.G.getValue(this, Q[32]);
    }

    @NotNull
    public final Feature<Boolean> getClickstream() {
        return this.s.getValue(this, Q[18]);
    }

    @Override // com.avito.android.AnalyticsToggles
    @NotNull
    public Feature<Boolean> getClickstreamDeliveryImprovements() {
        return this.q.getValue(this, Q[16]);
    }

    @Override // com.avito.android.ClickstreamToggles
    @NotNull
    public Feature<Boolean> getClickstreamStrictMode() {
        return this.n.getValue(this, Q[13]);
    }

    @Override // com.avito.android.AnalyticsToggles
    @NotNull
    public Feature<Boolean> getClickstreamTimerTrigger() {
        return this.r.getValue(this, Q[17]);
    }

    @NotNull
    public Feature<Boolean> getCommercialAdfox() {
        return this.M.getValue(this, Q[38]);
    }

    @NotNull
    public Feature<Boolean> getCommercialRentalType() {
        return this.u.getValue(this, Q[20]);
    }

    @NotNull
    public Feature<Boolean> getCostAreaSquareMeter() {
        return this.t.getValue(this, Q[19]);
    }

    @Override // com.avito.android.AppConfigurationToggles
    @NotNull
    public Feature<Boolean> getCrashOnLogsError() {
        return this.B.getValue(this, Q[27]);
    }

    @Override // com.avito.android.AppConfigurationToggles
    @NotNull
    public Feature<String> getDeviceId() {
        return this.C.getValue(this, Q[28]);
    }

    @NotNull
    public Feature<Boolean> getFiltersDeeplink() {
        return this.H.getValue(this, Q[33]);
    }

    @NotNull
    public Feature<Boolean> getGetPhoneByRequest() {
        return this.I.getValue(this, Q[34]);
    }

    @NotNull
    public Feature<Boolean> getGuestFavorites() {
        return this.f.getValue(this, Q[5]);
    }

    @NotNull
    public Feature<Boolean> getHidePhoneByFlag() {
        return this.J.getValue(this, Q[35]);
    }

    @NotNull
    public Feature<Boolean> getItemsCounter() {
        return this.F.getValue(this, Q[31]);
    }

    @NotNull
    public Feature<Boolean> getLeakCanaryEnabled() {
        return this.z.getValue(this, Q[25]);
    }

    @Override // com.avito.android.AnalyticsToggles
    @NotNull
    public Feature<Boolean> getLogAnalyticEvents() {
        return this.g.getValue(this, Q[6]);
    }

    @NotNull
    public Feature<Boolean> getMapCaching() {
        return this.v.getValue(this, Q[21]);
    }

    @NotNull
    public Feature<Boolean> getMapEqualsList() {
        return this.y.getValue(this, Q[24]);
    }

    @NotNull
    public Feature<Boolean> getMapImprovedDrawing() {
        return this.D.getValue(this, Q[29]);
    }

    @NotNull
    public Feature<Boolean> getMigration() {
        return this.e.getValue(this, Q[4]);
    }

    @NotNull
    public Feature<Boolean> getNonFatalCrashesReporing() {
        return this.N.getValue(this, Q[39]);
    }

    @NotNull
    public Feature<Boolean> getPanorama() {
        return this.d.getValue(this, Q[3]);
    }

    @NotNull
    public Feature<Boolean> getPushViaFCM() {
        return this.E.getValue(this, Q[30]);
    }

    @NotNull
    public Feature<Boolean> getRateThisApp() {
        return this.w.getValue(this, Q[22]);
    }

    @NotNull
    public Feature<Boolean> getRatingScreen() {
        return this.x.getValue(this, Q[23]);
    }

    @NotNull
    public Feature<Boolean> getRedesignSearchResults() {
        return this.A.getValue(this, Q[26]);
    }

    @Override // com.avito.android.RemoteToggles
    @NotNull
    public Feature<Boolean> getRemoteToggles() {
        return this.k.getValue(this, Q[10]);
    }

    @Override // com.avito.android.RemoteToggles
    @NotNull
    public Feature<Boolean> getRemoteTogglesFunctionalTestMonitor() {
        return this.m.getValue(this, Q[12]);
    }

    @Override // com.avito.android.RemoteToggles
    @NotNull
    public Feature<Boolean> getRemoteTogglesMonitor() {
        return this.l.getValue(this, Q[11]);
    }

    @Override // com.avito.android.ClickstreamToggles
    @NotNull
    public Feature<Boolean> getReportNonFatalsToClickstream() {
        return this.o.getValue(this, Q[14]);
    }

    @Override // com.avito.android.AnalyticsToggles
    @NotNull
    public Feature<Boolean> getSendGraphiteEvents() {
        return this.j.getValue(this, Q[9]);
    }

    @Override // com.avito.android.ClickstreamToggles
    @NotNull
    public Feature<Boolean> getSendNonfatalWithStacktrace() {
        return this.p.getValue(this, Q[15]);
    }

    @NotNull
    public Feature<Boolean> getShowAdvertChart() {
        return this.O.getValue(this, Q[40]);
    }

    @NotNull
    public Feature<Boolean> getSocialAuth() {
        return this.c.getValue(this, Q[2]);
    }

    @Override // com.avito.android.StatsdToggles
    @NotNull
    public Feature<String> getStatsdApiUrl() {
        return this.h.getValue(this, Q[7]);
    }

    @Override // com.avito.android.StatsdToggles
    @NotNull
    public Feature<Boolean> getStatsdGzip() {
        return this.P.getValue(this, Q[41]);
    }

    @Override // com.avito.android.StatsdToggles
    @NotNull
    public Feature<Boolean> getStatsdStrictMode() {
        return this.i.getValue(this, Q[8]);
    }
}
