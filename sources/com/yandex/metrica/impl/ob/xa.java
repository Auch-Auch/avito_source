package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.YandexMetrica;
public class xa {
    @NonNull
    private static final wz a = new wz();

    @NonNull
    public static ay a() {
        return a;
    }

    public static void b(@NonNull Context context) {
        YandexMetrica.getReporter(context, "20799a27-fa80-4b36-b2db-0f8141f24180");
    }

    public static void a(@NonNull Context context) {
        a.a(context);
    }
}
