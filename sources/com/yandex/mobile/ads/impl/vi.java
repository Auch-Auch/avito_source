package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.vh;
import com.yandex.mobile.ads.video.models.common.Extension;
import java.util.List;
public final class vi {
    public static vh a(@NonNull List<Extension> list) {
        vh.a aVar = new vh.a();
        for (Extension extension : list) {
            String type = extension.getType();
            String value = extension.getValue();
            if ("PageID".equals(type)) {
                aVar.a(value);
            } else if ("SessionID".equals(type)) {
                aVar.b(value);
            }
        }
        return new vh(aVar, (byte) 0);
    }
}
