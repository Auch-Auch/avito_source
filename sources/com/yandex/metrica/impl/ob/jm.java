package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.google.android.exoplayer2.offline.DownloadService;
public class jm extends jk {
    public jm(@NonNull fe feVar, @NonNull jt jtVar) {
        this(feVar, jtVar, new jx(feVar.y(), DownloadService.KEY_FOREGROUND));
    }

    @VisibleForTesting
    public jm(@NonNull fe feVar, @NonNull jt jtVar, @NonNull jx jxVar) {
        super(feVar, jtVar, jxVar, js.a(jy.FOREGROUND).a());
    }
}
