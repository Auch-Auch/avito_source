package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.File;
public class an {
    @NonNull
    public File a(@NonNull Context context) {
        if (ax.a()) {
            return context.getNoBackupFilesDir();
        }
        return context.getFilesDir();
    }

    @NonNull
    public File b(@NonNull Context context) {
        return new File(a(context), "appmetrica_crashes");
    }

    @NonNull
    public File c(@NonNull Context context) {
        return new File(a(context), "YandexMetricaNativeCrashes");
    }

    @NonNull
    public File a(@NonNull String str) {
        return new File(str);
    }

    @NonNull
    public File a(@NonNull File file, @NonNull String str) {
        return new File(file, str);
    }
}
