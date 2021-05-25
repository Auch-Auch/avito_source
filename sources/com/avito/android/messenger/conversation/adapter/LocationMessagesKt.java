package com.avito.android.messenger.conversation.adapter;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u000b\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "googleApiKey", "Landroid/net/Uri;", "createDefaultGoogleGeoBubbleSnippetUri", "(Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;)Landroid/net/Uri;", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "yandexApiKey", "createDefaultYandexGeoBubbleSnippetUri", "(Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;)Landroid/net/Uri;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "createGoogleGeoBubbleSnippetUri", "([Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;)Landroid/net/Uri;", "createYandexGeoBubbleSnippetUri", "([Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;)Landroid/net/Uri;", "", "MAP_SNIPPET_WITH_MARKERS_ZOOM", "Ljava/lang/String;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class LocationMessagesKt {
    @NotNull
    public static final String MAP_SNIPPET_WITH_MARKERS_ZOOM = "14";

    @NotNull
    public static final Uri createDefaultGoogleGeoBubbleSnippetUri(@NotNull GoogleApiKey googleApiKey) {
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("maps.googleapis.com").appendPath("maps").appendPath("api").appendPath("staticmap").appendQueryParameter("size", "512x384");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(61.385303d), Double.valueOf(98.44411d)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Uri build = appendQueryParameter.appendQueryParameter("center", format).appendQueryParameter("zoom", ExifInterface.GPS_MEASUREMENT_2D).appendQueryParameter("language", "ru").appendQueryParameter("region", "ru").appendQueryParameter("key", googleApiKey.getKey()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…Key.key)\n        .build()");
        return build;
    }

    @NotNull
    public static final Uri createDefaultYandexGeoBubbleSnippetUri(@NotNull YandexApiKey yandexApiKey) {
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("enterprise.static-maps.yandex.ru").appendPath("1.x").appendPath("").appendQueryParameter("l", "map").appendQueryParameter("key", yandexApiKey.getKey()).appendQueryParameter(VKApiConst.LANG, "ru_RU").appendQueryParameter("size", "512,384");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.UK, "%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(98.44411d), Double.valueOf(61.385303d)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        Uri build = appendQueryParameter.appendQueryParameter("ll", format).appendQueryParameter("z", ExifInterface.GPS_MEASUREMENT_2D).build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…e Russia\n        .build()");
        return build;
    }

    @NotNull
    public static final Uri createGoogleGeoBubbleSnippetUri(@NotNull GeoMarker[] geoMarkerArr, @NotNull GoogleApiKey googleApiKey) {
        Intrinsics.checkNotNullParameter(geoMarkerArr, "$this$createGoogleGeoBubbleSnippetUri");
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        boolean z = true;
        StringBuilder sb = new StringBuilder((geoMarkerArr.length * 2) + 1);
        int length = geoMarkerArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            GeoMarker geoMarker = geoMarkerArr[i];
            int i3 = i2 + 1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(geoMarker.getLatitude()), Double.valueOf(geoMarker.getLongitude())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            sb.append(format);
            if (i2 < geoMarkerArr.length - 1) {
                sb.append('|');
            }
            i++;
            i2 = i3;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("maps.googleapis.com").appendPath("maps").appendPath("api").appendPath("staticmap").appendQueryParameter("size", "512x384");
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter(ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "color:0x00AAFF|" + ((Object) sb)).appendQueryParameter("language", "ru").appendQueryParameter("region", "ru").appendQueryParameter("key", googleApiKey.getKey());
        if (geoMarkerArr.length > 1) {
            z = false;
        }
        if (z) {
            appendQueryParameter2 = appendQueryParameter2.appendQueryParameter("zoom", MAP_SNIPPET_WITH_MARKERS_ZOOM);
        }
        Uri build = appendQueryParameter2.build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…       }\n        .build()");
        return build;
    }

    @NotNull
    public static final Uri createYandexGeoBubbleSnippetUri(@NotNull GeoMarker[] geoMarkerArr, @NotNull YandexApiKey yandexApiKey) {
        Intrinsics.checkNotNullParameter(geoMarkerArr, "$this$createYandexGeoBubbleSnippetUri");
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        boolean z = true;
        StringBuilder sb = new StringBuilder((geoMarkerArr.length * 2) + 1);
        int length = geoMarkerArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            GeoMarker geoMarker = geoMarkerArr[i];
            int i3 = i2 + 1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.UK, "%.6f,%.6f,%s", Arrays.copyOf(new Object[]{Double.valueOf(geoMarker.getLongitude()), Double.valueOf(geoMarker.getLatitude()), "pm2lbl"}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            sb.append(format);
            if (i2 < geoMarkerArr.length - 1) {
                sb.append('~');
            }
            i++;
            i2 = i3;
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("enterprise.static-maps.yandex.ru").appendPath("1.x").appendPath("").appendQueryParameter("key", yandexApiKey.getKey()).appendQueryParameter("l", "map").appendQueryParameter("size", "512,384").appendQueryParameter(VKApiConst.LANG, "ru_RU").appendQueryParameter("pt", String.valueOf(sb));
        if (geoMarkerArr.length > 1) {
            z = false;
        }
        if (z) {
            appendQueryParameter = appendQueryParameter.appendQueryParameter("z", MAP_SNIPPET_WITH_MARKERS_ZOOM);
        }
        Uri build = appendQueryParameter.build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…       }\n        .build()");
        return build;
    }
}
