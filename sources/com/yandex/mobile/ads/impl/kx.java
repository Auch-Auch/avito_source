package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import com.yandex.mobile.ads.nativeads.av;
public final class kx extends kv<or, String> {
    /* Return type fixed from 'com.yandex.mobile.ads.impl.oq' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.kv
    @NonNull
    public final /* synthetic */ oq<or> a(@NonNull String str, @NonNull String str2) {
        return kv.a(str, Types.STRING, new or(av.a.TEXT, str2));
    }
}
