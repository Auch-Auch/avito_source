package com.yandex.metrica.impl.ob;

import android.os.FileObserver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.File;
public class kt extends FileObserver {
    private final aby<File> a;
    private final File b;

    public kt(@NonNull File file, @NonNull aby<File> aby) {
        super(file.getAbsolutePath(), 8);
        this.a = aby;
        this.b = file;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, @Nullable String str) {
        if (i == 8 && !TextUtils.isEmpty(str)) {
            this.a.a(new File(this.b, str));
        }
    }
}
