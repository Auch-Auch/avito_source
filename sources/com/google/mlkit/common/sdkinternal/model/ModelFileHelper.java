package com.google.mlkit.common.sdkinternal.model;

import a2.b.a.a.a;
import a2.j.h.a.c.a.b;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import java.io.File;
@KeepForSdk
public class ModelFileHelper {
    @KeepForSdk
    public static final int INVALID_INDEX = -1;
    public static final GmsLogger b = new GmsLogger("ModelFileHelper", "");
    @VisibleForTesting
    public static final String c = String.format("com.google.mlkit.%s.models", "automl");
    @VisibleForTesting
    public static final String d = String.format("com.google.mlkit.%s.models", "translate");
    @VisibleForTesting
    public static final String e = String.format("com.google.mlkit.%s.models", "base");
    public final MlKitContext a;

    public ModelFileHelper(MlKitContext mlKitContext) {
        this.a = mlKitContext;
    }

    @WorkerThread
    public final File a(@NonNull String str, @NonNull ModelType modelType, boolean z) throws MlKitException {
        File modelDirUnsafe = getModelDirUnsafe(str, modelType, z);
        if (!modelDirUnsafe.exists()) {
            GmsLogger gmsLogger = b;
            String valueOf = String.valueOf(modelDirUnsafe.getAbsolutePath());
            gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "model folder does not exist, creating one: ".concat(valueOf) : new String("model folder does not exist, creating one: "));
            if (!modelDirUnsafe.mkdirs()) {
                String valueOf2 = String.valueOf(modelDirUnsafe);
                throw new MlKitException(a.r2(valueOf2.length() + 31, "Failed to create model folder: ", valueOf2), 13);
            }
        } else if (!modelDirUnsafe.isDirectory()) {
            String valueOf3 = String.valueOf(modelDirUnsafe);
            throw new MlKitException(a.r2(valueOf3.length() + 71, "Can not create model folder, since an existing file has the same name: ", valueOf3), 6);
        }
        return modelDirUnsafe;
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void deleteAllModels(ModelType modelType, String str) {
        deleteRecursively(getModelDirUnsafe(str, modelType, false));
        deleteRecursively(getModelDirUnsafe(str, modelType, true));
    }

    @KeepForSdk
    @WorkerThread
    public boolean deleteRecursively(@Nullable File file) {
        boolean z;
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            z = true;
            for (File file2 : (File[]) Preconditions.checkNotNull(file.listFiles())) {
                z = z && deleteRecursively(file2);
            }
        } else {
            z = true;
        }
        return z && file.delete();
    }

    @KeepForSdk
    @WorkerThread
    public void deleteTempFilesInPrivateFolder(String str, ModelType modelType) throws MlKitException {
        File a3 = a(str, modelType, true);
        if (!deleteRecursively(a3)) {
            GmsLogger gmsLogger = b;
            String valueOf = String.valueOf(a3.getAbsolutePath());
            gmsLogger.e("ModelFileHelper", valueOf.length() != 0 ? "Failed to delete the temp labels file directory: ".concat(valueOf) : new String("Failed to delete the temp labels file directory: "));
        }
    }

    @KeepForSdk
    @WorkerThread
    public int getLatestCachedModelVersion(@NonNull File file) {
        File[] listFiles = file.listFiles();
        int i = -1;
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                try {
                    i = Math.max(i, Integer.parseInt(file2.getName()));
                } catch (NumberFormatException unused) {
                    GmsLogger gmsLogger = b;
                    String valueOf = String.valueOf(file2.getName());
                    gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "Contains non-integer file name ".concat(valueOf) : new String("Contains non-integer file name "));
                }
            }
        }
        return i;
    }

    @KeepForSdk
    @WorkerThread
    public File getModelDir(@NonNull String str, ModelType modelType) throws MlKitException {
        return a(str, modelType, false);
    }

    @KeepForSdk
    @WorkerThread
    public File getModelDirUnsafe(@NonNull String str, @NonNull ModelType modelType, boolean z) {
        String str2;
        int i = b.a[modelType.ordinal()];
        if (i == 1) {
            str2 = e;
        } else if (i == 2) {
            str2 = c;
        } else if (i == 3) {
            str2 = d;
        } else {
            String name = modelType.name();
            throw new IllegalArgumentException(a.s2(a.q0(name, 69), "Unknown model type ", name, ". Cannot find a dir to store the downloaded model."));
        }
        File file = new File(this.a.getApplicationContext().getNoBackupFilesDir(), str2);
        if (z) {
            file = new File(file, "temp");
        }
        return new File(file, str);
    }

    @KeepForSdk
    @WorkerThread
    public File getModelTempDir(@NonNull String str, ModelType modelType) throws MlKitException {
        return a(str, modelType, true);
    }

    @KeepForSdk
    @WorkerThread
    public File getTempFileInPrivateFolder(@NonNull String str, @NonNull ModelType modelType, @NonNull String str2) throws MlKitException {
        File a3 = a(str, modelType, true);
        if (!a3.exists() || !a3.isFile() || a3.delete()) {
            if (!a3.exists()) {
                GmsLogger gmsLogger = b;
                String valueOf = String.valueOf(a3.getAbsolutePath());
                gmsLogger.d("ModelFileHelper", valueOf.length() != 0 ? "Temp labels folder does not exist, creating one: ".concat(valueOf) : new String("Temp labels folder does not exist, creating one: "));
                if (!a3.mkdirs()) {
                    throw new MlKitException("Failed to create a directory to hold the AutoML model's labels file.", 13);
                }
            }
            return new File(a3, str2);
        }
        String valueOf2 = String.valueOf(a3.getAbsolutePath());
        throw new MlKitException(valueOf2.length() != 0 ? "Failed to delete the temp labels file: ".concat(valueOf2) : new String("Failed to delete the temp labels file: "), 13);
    }

    @KeepForSdk
    @WorkerThread
    public boolean modelExistsLocally(String str, ModelType modelType) throws MlKitException {
        String zza;
        if (modelType == ModelType.UNKNOWN || (zza = zza(str, modelType)) == null) {
            return false;
        }
        File file = new File(zza);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file, Constants.MODEL_FILE_NAME);
        if (modelType != ModelType.AUTOML) {
            return file2.exists();
        }
        if (file2.exists()) {
            File file3 = new File(file, Constants.AUTOML_IMAGE_LABELING_LABELS_FILE_NAME);
            File file4 = new File(file, Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME);
            if (file3.exists() && file4.exists()) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    public final String zza(String str, ModelType modelType) throws MlKitException {
        File modelDir = getModelDir(str, modelType);
        int latestCachedModelVersion = getLatestCachedModelVersion(modelDir);
        if (latestCachedModelVersion == -1) {
            return null;
        }
        String absolutePath = modelDir.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 12);
        sb.append(absolutePath);
        sb.append("/");
        sb.append(latestCachedModelVersion);
        return sb.toString();
    }

    @WorkerThread
    public final File zzb(@NonNull String str, @NonNull ModelType modelType) throws MlKitException {
        return a(str, modelType, true);
    }
}
