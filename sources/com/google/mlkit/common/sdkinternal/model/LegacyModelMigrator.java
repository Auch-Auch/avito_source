package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.model.LegacyModelMigrator;
import java.io.File;
import java.util.concurrent.Executor;
@KeepForSdk
public abstract class LegacyModelMigrator {
    public final TaskCompletionSource<Void> a = new TaskCompletionSource<>();
    public final Context b;
    public final Executor c;
    @KeepForSdk
    public final ModelFileHelper modelFileHelper;

    @KeepForSdk
    public LegacyModelMigrator(Context context, ModelFileHelper modelFileHelper2) {
        this.b = context;
        this.modelFileHelper = modelFileHelper2;
        this.c = MLTaskExecutor.workerThreadExecutor();
    }

    @KeepForSdk
    public static void deleteIfEmpty(File file) {
        if ((file.listFiles() == null || file.listFiles().length == 0) && !file.delete()) {
            String.valueOf(file).length();
        }
    }

    @KeepForSdk
    public static boolean isValidFirebasePersistenceKey(String str) {
        String[] split = str.split("\\+", -1);
        if (split.length != 2) {
            return false;
        }
        try {
            Base64Utils.decodeUrlSafeNoPadding(split[0]);
            Base64Utils.decodeUrlSafeNoPadding(split[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public static void migrateFile(File file, File file2) {
        if (file.exists()) {
            if (!file2.exists() && !file.renameTo(file2)) {
                String valueOf = String.valueOf(file);
                String valueOf2 = String.valueOf(file2);
                valueOf.length();
                valueOf2.length();
            }
            if (file.exists() && !file.delete()) {
                String.valueOf(file).length();
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public abstract String getLegacyModelDirName();

    @VisibleForTesting
    @KeepForSdk
    public File getLegacyRootDir() {
        return new File(this.b.getNoBackupFilesDir(), getLegacyModelDirName());
    }

    @KeepForSdk
    public Task<Void> getMigrationTask() {
        return this.a.getTask();
    }

    @KeepForSdk
    public abstract void migrateAllModelDirs(File file);

    @KeepForSdk
    public void start() {
        this.c.execute(new Runnable(this) { // from class: a2.j.h.a.c.a.a
            public final LegacyModelMigrator a;

            {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                LegacyModelMigrator legacyModelMigrator = this.a;
                File legacyRootDir = legacyModelMigrator.getLegacyRootDir();
                File[] listFiles = legacyRootDir.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        legacyModelMigrator.migrateAllModelDirs(file);
                    }
                    LegacyModelMigrator.deleteIfEmpty(legacyRootDir);
                }
                legacyModelMigrator.a.setResult(null);
            }
        });
    }
}
