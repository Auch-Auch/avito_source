package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
public class sh extends sg {
    public sh(String str) {
        super(a(str));
    }

    private static String a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        return UriUtil.HTTP_SCHEME.equals(parse.getScheme()) ? parse.buildUpon().scheme("https").build().toString() : str;
    }

    @Override // com.yandex.metrica.impl.ob.sg
    public boolean b() {
        return true;
    }
}
