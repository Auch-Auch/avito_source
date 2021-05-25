package com.yandex.metrica.impl.ob;

import android.os.FileObserver;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.io.File;
public class lm {
    @NonNull
    private final FileObserver a;
    @NonNull
    private final File b;
    @NonNull
    private final aby<File> c;
    @NonNull
    private final act d;

    public lm(@NonNull File file, @NonNull aby<File> aby) {
        this(file, aby, as.a().k().i());
    }

    public void a() {
        this.d.a(new kx(this.b, this.c));
        this.a.startWatching();
    }

    public void b() {
        this.a.stopWatching();
    }

    private lm(@NonNull File file, @NonNull aby<File> aby, @NonNull act act) {
        this(new kt(file, aby), file, aby, act, new ku());
    }

    @VisibleForTesting
    public lm(@NonNull FileObserver fileObserver, @NonNull File file, @NonNull aby<File> aby, @NonNull act act, @NonNull ku kuVar) {
        this.a = fileObserver;
        this.b = file;
        this.c = aby;
        this.d = act;
        kuVar.a(file);
    }
}
