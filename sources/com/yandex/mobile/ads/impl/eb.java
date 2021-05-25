package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.net.IDN;
public final class eb {
    public static String a(String str) {
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return str;
            }
            String ascii = IDN.toASCII(host);
            if (host.equals(ascii)) {
                return str;
            }
            Uri.Builder buildUpon = parse.buildUpon();
            StringBuilder sb = new StringBuilder();
            String userInfo = parse.getUserInfo();
            if (!TextUtils.isEmpty(userInfo)) {
                sb.append(userInfo);
                sb.append("@");
            }
            sb.append(ascii);
            int port = parse.getPort();
            if (port != -1) {
                sb.append(":");
                sb.append(port);
            }
            buildUpon.authority(sb.toString());
            return buildUpon.build().toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
