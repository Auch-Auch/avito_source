package com.google.mlkit.common.sdkinternal.model;

import android.annotation.SuppressLint;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.ModelUtils;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelValidator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
@KeepForSdk
public class RemoteModelFileManager {
    public static final GmsLogger h = new GmsLogger("RemoteModelFileManager", "");
    public final MlKitContext a;
    public final String b;
    public final ModelType c;
    public final ModelValidator d;
    public final RemoteModelFileMover e;
    public final SharedPrefManager f;
    public final ModelFileHelper g;

    @SuppressLint({"FirebaseLambdaLast"})
    public RemoteModelFileManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        String str;
        this.a = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.c = modelType;
        if (modelType == ModelType.TRANSLATE) {
            str = remoteModel.getModelNameForBackend();
        } else {
            str = remoteModel.getUniqueModelNameForPersist();
        }
        this.b = str;
        this.d = modelValidator;
        this.f = SharedPrefManager.getInstance(mlKitContext);
        this.g = modelFileHelper;
        this.e = remoteModelFileMover;
    }

    @NonNull
    @KeepForSdk
    public File getModelDirUnsafe(boolean z) {
        return this.g.getModelDirUnsafe(this.b, this.c, z);
    }

    @Nullable
    @KeepForSdk
    @WorkerThread
    public synchronized File moveModelToPrivateFolder(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull String str, @NonNull RemoteModel remoteModel) throws MlKitException {
        File file;
        boolean z;
        MlKitException mlKitException;
        zzdx zzdx = (zzdx) ((zzdx.zza) this.a.get(zzdx.zza.class)).get(remoteModel);
        file = new File(this.g.zzb(this.b, this.c), "to_be_validated_model.tmp");
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = autoCloseInputStream.read(bArr);
                        z = false;
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    autoCloseInputStream.close();
                    boolean zza = ModelUtils.zza(file, str);
                    if (zza) {
                        ModelValidator.ValidationResult validateModel = this.d.validateModel(file, remoteModel);
                        z = validateModel.isValid();
                        if (validateModel.getErrorCode().equals(ModelValidator.ValidationResult.ErrorCode.TFLITE_VERSION_INCOMPATIBLE)) {
                            String appVersion = CommonUtils.getAppVersion(this.a.getApplicationContext());
                            this.f.setIncompatibleModelInfo(remoteModel, str, appVersion);
                            GmsLogger gmsLogger = h;
                            String valueOf = String.valueOf(str);
                            gmsLogger.d("RemoteModelFileManager", valueOf.length() != 0 ? "Model is not compatible. Model hash: ".concat(valueOf) : new String("Model is not compatible. Model hash: "));
                            String valueOf2 = String.valueOf(appVersion);
                            gmsLogger.d("RemoteModelFileManager", valueOf2.length() != 0 ? "The current app version is: ".concat(valueOf2) : new String("The current app version is: "));
                        }
                    }
                    if (!zza || !z) {
                        if (!zza) {
                            GmsLogger gmsLogger2 = h;
                            String valueOf3 = String.valueOf(str);
                            gmsLogger2.d("RemoteModelFileManager", valueOf3.length() != 0 ? "Hash does not match with expected: ".concat(valueOf3) : new String("Hash does not match with expected: "));
                            zzdx.zza(25, true, this.c, 6);
                            mlKitException = new MlKitException("Hash does not match with expected", 102);
                        } else {
                            mlKitException = new MlKitException("Model is not compatible with TFLite run time", 100);
                        }
                        if (!file.delete()) {
                            GmsLogger gmsLogger3 = h;
                            String valueOf4 = String.valueOf(file.getAbsolutePath());
                            gmsLogger3.d("RemoteModelFileManager", valueOf4.length() != 0 ? "Failed to delete the temp file: ".concat(valueOf4) : new String("Failed to delete the temp file: "));
                        }
                        throw mlKitException;
                    }
                } catch (Throwable th) {
                    zzan.zza(th, th);
                }
            } catch (Throwable th2) {
                zzan.zza(th, th2);
            }
        } catch (IOException e2) {
            GmsLogger gmsLogger4 = h;
            String valueOf5 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf5.length() + 56);
            sb.append("Failed to copy downloaded model file to private folder: ");
            sb.append(valueOf5);
            gmsLogger4.e("RemoteModelFileManager", sb.toString());
            return null;
        }
        return this.e.moveAllFilesFromPrivateTempToPrivateDestination(file);
        throw th;
        throw th;
    }

    @WorkerThread
    public final synchronized boolean zza(@NonNull File file) throws MlKitException {
        File modelDir = this.g.getModelDir(this.b, this.c);
        if (!modelDir.exists()) {
            return false;
        }
        File[] listFiles = modelDir.listFiles();
        boolean z = true;
        for (File file2 : listFiles) {
            if (!file2.equals(file) && !this.g.deleteRecursively(file2)) {
                z = false;
            }
        }
        return z;
    }

    @WorkerThread
    public final synchronized void zzb(@NonNull File file) {
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (modelDirUnsafe.exists()) {
            for (File file2 : modelDirUnsafe.listFiles()) {
                if (file2.equals(file)) {
                    this.g.deleteRecursively(file);
                    return;
                }
            }
        }
    }

    @NonNull
    @WorkerThread
    public final synchronized File zzc(@NonNull File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.g.getModelDir(this.b, this.c).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        if (file.renameTo(file2)) {
            return file2;
        }
        return file;
    }

    @Nullable
    @WorkerThread
    public final synchronized String zza() throws MlKitException {
        return this.g.zza(this.b, this.c);
    }
}
