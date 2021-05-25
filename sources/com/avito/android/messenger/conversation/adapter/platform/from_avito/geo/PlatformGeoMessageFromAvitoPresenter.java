package com.avito.android.messenger.conversation.adapter.platform.from_avito.geo;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.IncomingMessagePresenter;
import com.avito.android.messenger.conversation.adapter.LocationMessagesKt;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoView;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/messenger/conversation/adapter/platform/from_avito/geo/PlatformGeoMessageFromAvitoView;Lcom/avito/android/messenger/conversation/ChannelItem$Message;I)V", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "googleApiKey", "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;", "incomingMessagePresenter", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "c", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "yandexApiKey", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/messenger/conversation/adapter/IncomingMessagePresenter;Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformGeoMessageFromAvitoPresenter implements ItemPresenter<PlatformGeoMessageFromAvitoView, ChannelItem.Message> {
    public final IncomingMessagePresenter a;
    public final GoogleApiKey b;
    public final YandexApiKey c;
    public final Features d;

    public PlatformGeoMessageFromAvitoPresenter(@NotNull IncomingMessagePresenter incomingMessagePresenter, @NotNull GoogleApiKey googleApiKey, @NotNull YandexApiKey yandexApiKey, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(incomingMessagePresenter, "incomingMessagePresenter");
        Intrinsics.checkNotNullParameter(googleApiKey, "googleApiKey");
        Intrinsics.checkNotNullParameter(yandexApiKey, "yandexApiKey");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = incomingMessagePresenter;
        this.b = googleApiKey;
        this.c = yandexApiKey;
        this.d = features;
    }

    public void bindView(@NotNull PlatformGeoMessageFromAvitoView platformGeoMessageFromAvitoView, @NotNull ChannelItem.Message message, int i) {
        PlatformGeoMessageFromAvitoView platformGeoMessageFromAvitoView2;
        String str;
        String str2;
        PlatformGeoMessageFromAvitoPresenter platformGeoMessageFromAvitoPresenter;
        String str3;
        Uri uri;
        GeoMarker[] markers;
        PlatformGeoMessageFromAvitoView platformGeoMessageFromAvitoView3;
        Uri uri2;
        Intrinsics.checkNotNullParameter(platformGeoMessageFromAvitoView, "view");
        Intrinsics.checkNotNullParameter(message, "item");
        this.a.bindView(platformGeoMessageFromAvitoView, message, i);
        MessageBody.SystemMessageBody.Platform.Bubble bubble = message.getBodyOrBubble().getBubble();
        if (!(bubble instanceof MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation)) {
            bubble = null;
        }
        MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation geoLocation = (MessageBody.SystemMessageBody.Platform.Bubble.GeoLocation) bubble;
        if (geoLocation != null) {
            boolean z = false;
            if (geoLocation.getMarkers() == null || (markers = geoLocation.getMarkers()) == null) {
                str2 = "zoom";
                str = "key";
                str3 = "ru";
                platformGeoMessageFromAvitoPresenter = this;
            } else {
                if (!(!(markers.length == 0))) {
                    str2 = "zoom";
                    platformGeoMessageFromAvitoPresenter = this;
                    str = "key";
                    str3 = "ru";
                } else {
                    GeoMarker[] markers2 = geoLocation.getMarkers();
                    if (markers2 != null) {
                        if (!(markers2.length == 0)) {
                            if (this.d.getYandexMapsInMessenger().invoke().booleanValue()) {
                                YandexApiKey yandexApiKey = this.c;
                                StringBuilder sb = new StringBuilder((markers2.length * 2) + 1);
                                int length = markers2.length;
                                int i2 = 0;
                                int i3 = 0;
                                while (i2 < length) {
                                    GeoMarker geoMarker = markers2[i2];
                                    int i4 = i3 + 1;
                                    String format = String.format(Locale.UK, "%.6f,%.6f,%s", Arrays.copyOf(new Object[]{Double.valueOf(geoMarker.getLongitude()), Double.valueOf(geoMarker.getLatitude()), "pm2lbl"}, 3));
                                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                                    sb.append(format);
                                    if (i3 < markers2.length - 1) {
                                        sb.append('~');
                                    }
                                    i2++;
                                    i3 = i4;
                                }
                                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").authority("enterprise.static-maps.yandex.ru").appendPath("1.x").appendPath("").appendQueryParameter("key", yandexApiKey.getKey()).appendQueryParameter("l", "map").appendQueryParameter("size", "512,384").appendQueryParameter(VKApiConst.LANG, "ru_RU").appendQueryParameter("pt", String.valueOf(sb));
                                if (markers2.length <= 1) {
                                    z = true;
                                }
                                if (z) {
                                    appendQueryParameter = appendQueryParameter.appendQueryParameter("z", LocationMessagesKt.MAP_SNIPPET_WITH_MARKERS_ZOOM);
                                }
                                uri2 = appendQueryParameter.build();
                                Intrinsics.checkNotNullExpressionValue(uri2, "Uri.Builder()\n        .s…       }\n        .build()");
                            } else {
                                GoogleApiKey googleApiKey = this.b;
                                StringBuilder sb2 = new StringBuilder((markers2.length * 2) + 1);
                                int length2 = markers2.length;
                                int i5 = 0;
                                int i6 = 0;
                                while (i5 < length2) {
                                    GeoMarker geoMarker2 = markers2[i5];
                                    int i7 = i6 + 1;
                                    String format2 = String.format("%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(geoMarker2.getLatitude()), Double.valueOf(geoMarker2.getLongitude())}, 2));
                                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                                    sb2.append(format2);
                                    if (i6 < markers2.length - 1) {
                                        sb2.append('|');
                                    }
                                    i5++;
                                    i6 = i7;
                                    length2 = length2;
                                    googleApiKey = googleApiKey;
                                }
                                Uri.Builder appendQueryParameter2 = new Uri.Builder().scheme("https").authority("maps.googleapis.com").appendPath("maps").appendPath("api").appendPath("staticmap").appendQueryParameter("size", "512x384").appendQueryParameter(ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "color:0x00AAFF|" + ((Object) sb2)).appendQueryParameter("language", "ru").appendQueryParameter("region", "ru").appendQueryParameter("key", googleApiKey.getKey());
                                if (markers2.length <= 1) {
                                    z = true;
                                }
                                if (z) {
                                    appendQueryParameter2 = appendQueryParameter2.appendQueryParameter("zoom", LocationMessagesKt.MAP_SNIPPET_WITH_MARKERS_ZOOM);
                                }
                                uri2 = appendQueryParameter2.build();
                                Intrinsics.checkNotNullExpressionValue(uri2, "Uri.Builder()\n        .s…       }\n        .build()");
                            }
                            SimplePicture simplePicture = new SimplePicture(uri2);
                            platformGeoMessageFromAvitoView3 = platformGeoMessageFromAvitoView;
                            platformGeoMessageFromAvitoView3.setMapImage(simplePicture);
                            platformGeoMessageFromAvitoView2 = platformGeoMessageFromAvitoView3;
                            platformGeoMessageFromAvitoView2.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
                            return;
                        }
                    }
                    platformGeoMessageFromAvitoView3 = platformGeoMessageFromAvitoView;
                    platformGeoMessageFromAvitoView2 = platformGeoMessageFromAvitoView3;
                    platformGeoMessageFromAvitoView2.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
                    return;
                }
            }
            if (platformGeoMessageFromAvitoPresenter.d.getYandexMapsInMessenger().invoke().booleanValue()) {
                Uri.Builder appendQueryParameter3 = new Uri.Builder().scheme("https").authority("enterprise.static-maps.yandex.ru").appendPath("1.x").appendPath("").appendQueryParameter("l", "map").appendQueryParameter(str, platformGeoMessageFromAvitoPresenter.c.getKey()).appendQueryParameter(VKApiConst.LANG, "ru_RU").appendQueryParameter("size", "512,384");
                String format3 = String.format(Locale.UK, "%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(98.44411d), Double.valueOf(61.385303d)}, 2));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, format, *args)");
                uri = appendQueryParameter3.appendQueryParameter("ll", format3).appendQueryParameter("z", ExifInterface.GPS_MEASUREMENT_2D).build();
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.Builder()\n        .s…e Russia\n        .build()");
            } else {
                GoogleApiKey googleApiKey2 = platformGeoMessageFromAvitoPresenter.b;
                Uri.Builder appendQueryParameter4 = new Uri.Builder().scheme("https").authority("maps.googleapis.com").appendPath("maps").appendPath("api").appendPath("staticmap").appendQueryParameter("size", "512x384");
                String format4 = String.format("%.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(61.385303d), Double.valueOf(98.44411d)}, 2));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                uri = appendQueryParameter4.appendQueryParameter("center", format4).appendQueryParameter(str2, ExifInterface.GPS_MEASUREMENT_2D).appendQueryParameter("language", str3).appendQueryParameter("region", str3).appendQueryParameter(str, googleApiKey2.getKey()).build();
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.Builder()\n        .s…Key.key)\n        .build()");
            }
            SimplePicture simplePicture2 = new SimplePicture(uri);
            platformGeoMessageFromAvitoView2 = platformGeoMessageFromAvitoView;
            platformGeoMessageFromAvitoView2.setMapImage(simplePicture2);
            platformGeoMessageFromAvitoView2.overrideMargins(message.getOverrideTopMarginDp(), message.getOverrideBottomMarginDp());
            return;
        }
        Uri uri3 = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri3, "Uri.EMPTY");
        platformGeoMessageFromAvitoView.setMapImage(new SimplePicture(uri3));
        Logs.debug$default("PlatformGeoMessageFromAvitoPresenter", "Unsupported bodyOrBubble: " + message.getBodyOrBubble(), null, 4, null);
    }
}
