package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.video.VideoAdError;
public final class tl {
    @NonNull
    private final fo a;
    @NonNull
    private final fq b = new fq();

    public tl(@NonNull fo foVar) {
        this.a = foVar;
    }

    public final void a(@NonNull Context context, @NonNull final tj tjVar) {
        new aj(context, this.a).a(new aj.a() { // from class: com.yandex.mobile.ads.impl.tl.1
            @Override // com.yandex.mobile.ads.impl.aj.a
            public final void a() {
                tjVar.a();
            }

            @Override // com.yandex.mobile.ads.impl.aj.a
            public final void a(@NonNull sl slVar) {
                tjVar.a(VideoAdError.createInternalError("Internal state wasn't completely configured"));
            }
        });
    }
}
