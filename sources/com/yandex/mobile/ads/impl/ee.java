package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.util.regex.Pattern;
public final class ee {
    private static final Pattern a = Pattern.compile("maps.yandex");

    public enum a {
        SMS_SCHEME("sms:"),
        MAIL_SCHEME("mailto:"),
        VOICE_MAIL_SCHEME("voicemail:"),
        TEL_SCHEME("tel:"),
        CALLTO("callto:"),
        FAX("fax:"),
        GEO_SCHEME("geo:"),
        MAP_SCHEME("map:"),
        MAPS_SCHEME("maps:"),
        GOOGLE_MARKET_SCHEME("market:"),
        GOOGLE_PLAY_SCHEME("play:"),
        GOOGLE_STREET_VIEW_SCHEME("google.streetview:"),
        GOOGLE_MARKET_HTTPS("https://market.android"),
        GOOGLE_MARKET_HTTP("http://market.android"),
        GOOGLE_PLAY_HTTPS("https://play.google"),
        GOOGLE_PLAY_HTTP("http://play.google"),
        MAP_HTTPS("https://map"),
        MAP_HTTP("http://map"),
        MAPS_HTTPS("https://maps"),
        MAPS_HTTP("http://maps"),
        YMOBMAPS("http://mobile.maps"),
        YSHORTMOBMAPS("http://m.maps"),
        YOIDMAPS("http://maps.yandex.ru"),
        MESSAGE("message:"),
        SIP("sip:"),
        SKYPE("skype:"),
        SMS("sms:"),
        GTALK("gtalk:"),
        SPOTIFY("spotify:"),
        LASTFM("lastfm:"),
        YSTORE("yastore:");
        
        public final String F;

        private a(String str) {
            this.F = str;
        }

        public static a[] a() {
            return new a[]{GOOGLE_MARKET_SCHEME, GOOGLE_PLAY_SCHEME, GOOGLE_MARKET_HTTPS, GOOGLE_MARKET_HTTP, GOOGLE_PLAY_HTTPS, GOOGLE_PLAY_HTTP};
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (z && e(str)) {
                intent.setPackage("ru.yandex.yandexmaps");
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a[] a3 = a.a();
            for (int i = 0; i < 6; i++) {
                if (str.startsWith(a3[i].F)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(String str) {
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean d(String str) {
        return !a(str) && URLUtil.isNetworkUrl(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (!parse.isHierarchical()) {
                return false;
            }
            String host = parse.getHost();
            if (TextUtils.isEmpty(parse.getQueryParameter("oid")) || !a.matcher(host).find()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a[] values = a.values();
            for (int i = 0; i < 31; i++) {
                if (str.startsWith(values[i].F)) {
                    return true;
                }
            }
        }
        return false;
    }
}
