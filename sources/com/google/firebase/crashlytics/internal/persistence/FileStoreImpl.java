package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
public class FileStoreImpl implements FileStore {
    public static final String FILES_PATH = ".com.google.firebase.crashlytics";
    public final Context a;

    public FileStoreImpl(Context context) {
        this.a = context;
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    public File getFilesDir() {
        File file = new File(this.a.getFilesDir(), FILES_PATH);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Logger.getLogger().w("Couldn't create file");
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    public String getFilesDirPath() {
        return new File(this.a.getFilesDir(), FILES_PATH).getPath();
    }
}
