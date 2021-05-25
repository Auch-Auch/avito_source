package com.google.maps.android.data.kml;

import com.facebook.internal.ServerProtocol;
public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        return "1".equals(str) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str);
    }
}
