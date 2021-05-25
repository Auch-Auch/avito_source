package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.IParamsCallback;
import java.util.Map;
public interface xm {
    void a(@NonNull IParamsCallback.Reason reason, Map<String, String> map);

    void a(Map<String, String> map);
}
