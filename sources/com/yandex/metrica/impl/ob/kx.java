package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.io.File;
public class kx implements Runnable {
    @NonNull
    private final File a;
    @NonNull
    private final aby<File> b;

    public kx(@NonNull File file, @NonNull aby<File> aby) {
        this.a = file;
        this.b = aby;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] listFiles;
        if (this.a.exists() && this.a.isDirectory() && (listFiles = this.a.listFiles()) != null) {
            for (File file : listFiles) {
                this.b.a(file);
            }
        }
    }
}
