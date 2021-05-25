package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;
@KeepForSdk
public class RemoteModelLoader {
    public static final GmsLogger i = new GmsLogger("RemoteModelLoader", "");
    @GuardedBy("RemoteModelLoader.class")
    public static final Map<String, RemoteModelLoader> j = new HashMap();
    public final MlKitContext a;
    public final RemoteModel b;
    public final RemoteModelDownloadManager c;
    public final RemoteModelFileManager d;
    public final zzdx e;
    public final RemoteModelLoaderHelper f;
    public final ModelType g;
    public boolean h = true;

    public RemoteModelLoader(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.d = remoteModelFileManager;
        this.e = (zzdx) ((zzdx.zza) MlKitContext.getInstance().get(zzdx.zza.class)).get(remoteModel);
        this.c = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.f = remoteModelLoaderHelper;
        this.a = mlKitContext;
        this.b = remoteModel;
        this.g = remoteModel.getModelType();
    }

    @KeepForSdk
    public static synchronized RemoteModelLoader getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, RemoteModelLoaderHelper remoteModelLoaderHelper, RemoteModelFileMover remoteModelFileMover) {
        RemoteModelLoader remoteModelLoader;
        synchronized (RemoteModelLoader.class) {
            String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
            Map<String, RemoteModelLoader> map = j;
            if (!map.containsKey(uniqueModelNameForPersist)) {
                map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
            }
            remoteModelLoader = map.get(uniqueModelNameForPersist);
        }
        return remoteModelLoader;
    }

    @Nullable
    @WorkerThread
    public final MappedByteBuffer a() throws MlKitException {
        String zza = this.d.zza();
        if (zza == null) {
            i.d("RemoteModelLoader", "No existing model file");
            return null;
        }
        try {
            return this.f.loadModelAtPath(zza);
        } catch (Exception e2) {
            this.d.zzb(new File(zza));
            SharedPrefManager.getInstance(this.a).clearLatestModelHash(this.b);
            throw new MlKitException("Failed to load an already downloaded model.", 14, e2);
        }
    }

    public final MappedByteBuffer b(File file) throws MlKitException {
        try {
            return this.f.loadModelAtPath(file.getAbsolutePath());
        } catch (Exception e2) {
            this.d.zzb(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e2);
        }
    }

    @KeepForSdk
    public RemoteModel getRemoteModel() {
        return this.b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.i     // Catch:{ all -> 0x00da }
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "Try to load newly downloaded model file."
            r0.d(r1, r2)     // Catch:{ all -> 0x00da }
            boolean r1 = r9.h     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r9.c     // Catch:{ all -> 0x00da }
            java.lang.Long r2 = r2.getDownloadingId()     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r3 = r9.c     // Catch:{ all -> 0x00da }
            java.lang.String r3 = r3.getDownloadingModelHash()     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x00be
            if (r3 != 0) goto L_0x001e
            goto L_0x00be
        L_0x001e:
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r4 = r9.c     // Catch:{ all -> 0x00da }
            java.lang.Integer r4 = r4.getDownloadingModelStatusCode()     // Catch:{ all -> 0x00da }
            if (r4 != 0) goto L_0x002d
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r9.c     // Catch:{ all -> 0x00da }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x00da }
            goto L_0x00ca
        L_0x002d:
            java.lang.String r5 = "RemoteModelLoader"
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00da }
            int r7 = r6.length()     // Catch:{ all -> 0x00da }
            int r7 = r7 + 22
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r8.<init>(r7)     // Catch:{ all -> 0x00da }
            java.lang.String r7 = "Download Status code: "
            r8.append(r7)     // Catch:{ all -> 0x00da }
            r8.append(r6)     // Catch:{ all -> 0x00da }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00da }
            r0.d(r5, r6)     // Catch:{ all -> 0x00da }
            int r5 = r4.intValue()     // Catch:{ all -> 0x00da }
            r6 = 8
            if (r5 != r6) goto L_0x00a2
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r9.c     // Catch:{ all -> 0x00da }
            java.io.File r2 = r2.zza(r3)     // Catch:{ all -> 0x00da }
            if (r2 == 0) goto L_0x00ca
            java.nio.MappedByteBuffer r4 = r9.b(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r5 = "RemoteModelLoader"
            java.lang.String r6 = "Moved the downloaded model to private folder successfully: "
            java.lang.String r7 = r2.getParent()     // Catch:{ all -> 0x00da }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00da }
            int r8 = r7.length()     // Catch:{ all -> 0x00da }
            if (r8 == 0) goto L_0x0078
            java.lang.String r6 = r6.concat(r7)     // Catch:{ all -> 0x00da }
            goto L_0x007e
        L_0x0078:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00da }
            r7.<init>(r6)     // Catch:{ all -> 0x00da }
            r6 = r7
        L_0x007e:
            r0.d(r5, r6)     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r5 = r9.c     // Catch:{ all -> 0x00da }
            r5.updateLatestModelHashAndType(r3)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00cb
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r1 = r9.d     // Catch:{ all -> 0x00da }
            boolean r1 = r1.zza(r2)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00cb
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r3 = "All old models are deleted."
            r0.d(r1, r3)     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager r1 = r9.d     // Catch:{ all -> 0x00da }
            java.io.File r1 = r1.zzc(r2)     // Catch:{ all -> 0x00da }
            java.nio.MappedByteBuffer r4 = r9.b(r1)     // Catch:{ all -> 0x00da }
            goto L_0x00cb
        L_0x00a2:
            int r1 = r4.intValue()     // Catch:{ all -> 0x00da }
            r3 = 16
            if (r1 != r3) goto L_0x00ca
            com.google.android.gms.internal.mlkit_common.zzdx r1 = r9.e     // Catch:{ all -> 0x00da }
            r3 = 0
            com.google.mlkit.common.sdkinternal.ModelType r4 = r9.g     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r5 = r9.c     // Catch:{ all -> 0x00da }
            int r2 = r5.getFailureReason(r2)     // Catch:{ all -> 0x00da }
            r1.zza(r3, r4, r2)     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r9.c     // Catch:{ all -> 0x00da }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x00da }
            goto L_0x00ca
        L_0x00be:
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "No new model is downloading."
            r0.d(r1, r2)     // Catch:{ all -> 0x00da }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r9.c     // Catch:{ all -> 0x00da }
            r1.removeOrCancelDownload()     // Catch:{ all -> 0x00da }
        L_0x00ca:
            r4 = 0
        L_0x00cb:
            if (r4 != 0) goto L_0x00d8
            java.lang.String r1 = "RemoteModelLoader"
            java.lang.String r2 = "Loading existing model file."
            r0.d(r1, r2)     // Catch:{ all -> 0x00da }
            java.nio.MappedByteBuffer r4 = r9.a()     // Catch:{ all -> 0x00da }
        L_0x00d8:
            monitor-exit(r9)
            return r4
        L_0x00da:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }
}
