package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.io.File;
public class ku {
    public boolean a(@NonNull File file) {
        if (!file.exists()) {
            return b(file);
        }
        if (file.isDirectory()) {
            return true;
        }
        if (file.delete()) {
            return b(file);
        }
        return false;
    }

    public boolean b(@NonNull File file) {
        return file.mkdir();
    }
}
