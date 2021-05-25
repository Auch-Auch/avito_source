package com.google.mlkit.common.sdkinternal.model;

import a2.j.h.a.c.a.c;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzdx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
@KeepForSdk
public class RemoteModelDownloadManager {
    public static final GmsLogger m = new GmsLogger("ModelDownloadManager", "");
    @GuardedBy("RemoteModelDownloadManager.class")
    public static final Map<String, RemoteModelDownloadManager> n = new HashMap();
    @GuardedBy("this")
    public final LongSparseArray<a> a = new LongSparseArray<>();
    @GuardedBy("this")
    public final LongSparseArray<TaskCompletionSource<Void>> b = new LongSparseArray<>();
    public final MlKitContext c;
    public final DownloadManager d;
    public final RemoteModel e;
    public final ModelType f;
    public final zzdx g;
    public final SharedPrefManager h;
    public final ModelFileHelper i;
    public final ModelInfoRetrieverInterop j;
    public final RemoteModelFileManager k;
    public DownloadConditions l;

    @WorkerThread
    public class a extends BroadcastReceiver {
        public final long a;
        public final TaskCompletionSource<Void> b;

        public a(long j, TaskCompletionSource taskCompletionSource, c cVar) {
            this.a = j;
            this.b = taskCompletionSource;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            if (longExtra == this.a) {
                Integer downloadingModelStatusCode = RemoteModelDownloadManager.this.getDownloadingModelStatusCode();
                synchronized (RemoteModelDownloadManager.this) {
                    try {
                        RemoteModelDownloadManager.this.c.getApplicationContext().unregisterReceiver(this);
                    } catch (IllegalArgumentException e) {
                        RemoteModelDownloadManager.m.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e);
                    }
                    RemoteModelDownloadManager.this.a.remove(this.a);
                    RemoteModelDownloadManager.this.b.remove(this.a);
                }
                if (downloadingModelStatusCode != null) {
                    if (downloadingModelStatusCode.intValue() == 16) {
                        RemoteModelDownloadManager remoteModelDownloadManager = RemoteModelDownloadManager.this;
                        remoteModelDownloadManager.g.zza(false, remoteModelDownloadManager.e.getModelType(), RemoteModelDownloadManager.this.getFailureReason(Long.valueOf(longExtra)));
                        this.b.setException(RemoteModelDownloadManager.this.a(Long.valueOf(longExtra)));
                        return;
                    } else if (downloadingModelStatusCode.intValue() == 8) {
                        RemoteModelDownloadManager remoteModelDownloadManager2 = RemoteModelDownloadManager.this;
                        remoteModelDownloadManager2.g.zza(0, remoteModelDownloadManager2.e.getModelType(), 6);
                        this.b.setResult(null);
                        return;
                    }
                }
                RemoteModelDownloadManager remoteModelDownloadManager3 = RemoteModelDownloadManager.this;
                remoteModelDownloadManager3.g.zza(false, remoteModelDownloadManager3.e.getModelType(), 0);
                this.b.setException(new MlKitException("Model downloading failed", 13));
            }
        }
    }

    @VisibleForTesting
    public RemoteModelDownloadManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        this.c = mlKitContext;
        this.f = remoteModel.getModelType();
        this.e = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.d = downloadManager;
        if (downloadManager == null) {
            m.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.i = modelFileHelper;
        this.g = (zzdx) ((zzdx.zza) mlKitContext.get(zzdx.zza.class)).get(remoteModel);
        this.h = SharedPrefManager.getInstance(mlKitContext);
        this.j = modelInfoRetrieverInterop;
        this.k = remoteModelFileManager;
    }

    @KeepForSdk
    public static synchronized RemoteModelDownloadManager getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
            Map<String, RemoteModelDownloadManager> map = n;
            if (!map.containsKey(uniqueModelNameForPersist)) {
                map.put(uniqueModelNameForPersist, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop));
            }
            remoteModelDownloadManager = map.get(uniqueModelNameForPersist);
        }
        return remoteModelDownloadManager;
    }

    public final MlKitException a(Long l2) {
        String str;
        DownloadManager downloadManager = this.d;
        Cursor query = (downloadManager == null || l2 == null) ? null : downloadManager.query(new DownloadManager.Query().setFilterById(l2.longValue()));
        int i2 = 13;
        if (query == null || !query.moveToFirst()) {
            str = "Model downloading failed";
        } else {
            int i3 = query.getInt(query.getColumnIndex("reason"));
            if (i3 == 1006) {
                i2 = 101;
                str = "Model downloading failed due to insufficient space on the device.";
            } else {
                str = a2.b.a.a.a.o2(84, "Model downloading failed due to error code: ", i3, " from Android DownloadManager");
            }
        }
        return new MlKitException(str, i2);
    }

    public final synchronized Long b(@NonNull DownloadManager.Request request, @NonNull ModelInfo modelInfo) {
        DownloadManager downloadManager = this.d;
        if (downloadManager == null) {
            return null;
        }
        long enqueue = downloadManager.enqueue(request);
        GmsLogger gmsLogger = m;
        StringBuilder sb = new StringBuilder(53);
        sb.append("Schedule a new downloading task: ");
        sb.append(enqueue);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        this.h.setDownloadingModelInfo(enqueue, modelInfo);
        this.g.zza(0, false, modelInfo.getModelType(), 4);
        return Long.valueOf(enqueue);
    }

    @Nullable
    @WorkerThread
    public final synchronized Long c(@NonNull ModelInfo modelInfo, @NonNull DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.h.getDownloadingModelHash(this.e);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash == null || !downloadingModelHash.equals(modelInfo.getModelHash()) || downloadingModelStatusCode == null) {
            GmsLogger gmsLogger = m;
            gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
            removeOrCancelDownload();
            DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
            request.setDestinationUri(null);
            if (this.i.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
                gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
                this.g.zza(0, false, modelInfo.getModelType(), 9);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                request.setRequiresCharging(downloadConditions.isChargingRequired());
            }
            if (downloadConditions.isWifiRequired()) {
                request.setAllowedNetworkTypes(2);
            }
            return b(request, modelInfo);
        }
        Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
        if (!(downloadingModelStatusCode2 != null && (downloadingModelStatusCode2.intValue() == 8 || downloadingModelStatusCode2.intValue() == 16))) {
            this.g.zza(0, false, this.e.getModelType(), 5);
        }
        m.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
        return null;
    }

    public final synchronized TaskCompletionSource<Void> d(long j2) {
        TaskCompletionSource<Void> taskCompletionSource;
        taskCompletionSource = this.b.get(j2);
        if (taskCompletionSource == null) {
            taskCompletionSource = new TaskCompletionSource<>();
            this.b.put(j2, taskCompletionSource);
        }
        return taskCompletionSource;
    }

    @Nullable
    @WorkerThread
    public final synchronized ModelInfo e() throws MlKitException {
        boolean modelExistsLocally = modelExistsLocally();
        boolean z = false;
        if (modelExistsLocally) {
            this.g.zza(0, false, this.e.getModelType(), 8);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.j;
        if (modelInfoRetrieverInterop != null) {
            ModelInfo retrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.e);
            if (retrieveRemoteModelInfo == null) {
                return null;
            }
            MlKitContext mlKitContext = this.c;
            RemoteModel remoteModel = this.e;
            String modelHash = retrieveRemoteModelInfo.getModelHash();
            SharedPrefManager instance = SharedPrefManager.getInstance(mlKitContext);
            if (modelHash.equals(instance.getIncompatibleModelHash(remoteModel)) && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(instance.getPreviousAppVersion())) {
                m.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
            } else {
                z = true;
            }
            if (!modelExistsLocally) {
                this.h.clearLatestModelHash(this.e);
            }
            boolean z2 = !retrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.c).getLatestModelHash(this.e));
            if (z && (!modelExistsLocally || z2)) {
                return retrieveRemoteModelInfo;
            }
            if (modelExistsLocally && (z2 ^ z)) {
                return null;
            }
            String modelName = this.e.getModelName();
            StringBuilder sb = new StringBuilder(String.valueOf(modelName).length() + 46);
            sb.append("The model ");
            sb.append(modelName);
            sb.append(" is incompatible with TFLite runtime");
            throw new MlKitException(sb.toString(), 100);
        }
        throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[Catch:{ MlKitException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e A[Catch:{ MlKitException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086 A[Catch:{ MlKitException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[Catch:{ MlKitException -> 0x00bc }] */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.tasks.Task<java.lang.Void> ensureModelDownloaded() {
        /*
            r10 = this;
            com.google.android.gms.internal.mlkit_common.zzdx r0 = r10.g
            com.google.mlkit.common.sdkinternal.ModelType r1 = com.google.mlkit.common.sdkinternal.ModelType.UNKNOWN
            r2 = 0
            r3 = 1
            r0.zza(r2, r2, r1, r3)
            r0 = 0
            com.google.mlkit.common.sdkinternal.ModelInfo r1 = r10.e()     // Catch:{ MlKitException -> 0x0010 }
            r4 = r0
            goto L_0x0013
        L_0x0010:
            r1 = move-exception
            r4 = r1
            r1 = r0
        L_0x0013:
            r5 = 13
            java.lang.Integer r6 = r10.getDownloadingModelStatusCode()     // Catch:{ MlKitException -> 0x00bc }
            java.lang.Long r7 = r10.getDownloadingId()     // Catch:{ MlKitException -> 0x00bc }
            boolean r8 = r10.modelExistsLocally()     // Catch:{ MlKitException -> 0x00bc }
            if (r8 != 0) goto L_0x009b
            if (r6 == 0) goto L_0x002e
            int r8 = r6.intValue()     // Catch:{ MlKitException -> 0x00bc }
            r9 = 8
            if (r8 != r9) goto L_0x002e
            goto L_0x009b
        L_0x002e:
            if (r6 == 0) goto L_0x0044
            int r8 = r6.intValue()     // Catch:{ MlKitException -> 0x00bc }
            r9 = 16
            if (r8 != r9) goto L_0x0044
            com.google.mlkit.common.MlKitException r0 = r10.a(r7)     // Catch:{ MlKitException -> 0x00bc }
            r10.removeOrCancelDownload()     // Catch:{ MlKitException -> 0x00bc }
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x0044:
            if (r6 == 0) goto L_0x005b
            int r8 = r6.intValue()     // Catch:{ MlKitException -> 0x00bc }
            r9 = 4
            if (r8 == r9) goto L_0x005c
            int r8 = r6.intValue()     // Catch:{ MlKitException -> 0x00bc }
            r9 = 2
            if (r8 == r9) goto L_0x005c
            int r6 = r6.intValue()     // Catch:{ MlKitException -> 0x00bc }
            if (r6 != r3) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r3 = 0
        L_0x005c:
            if (r3 == 0) goto L_0x007b
            if (r7 == 0) goto L_0x007b
            java.lang.String r3 = r10.getDownloadingModelHash()     // Catch:{ MlKitException -> 0x00bc }
            if (r3 == 0) goto L_0x007b
            com.google.android.gms.internal.mlkit_common.zzdx r0 = r10.g     // Catch:{ MlKitException -> 0x00bc }
            com.google.mlkit.common.model.RemoteModel r1 = r10.e     // Catch:{ MlKitException -> 0x00bc }
            com.google.mlkit.common.sdkinternal.ModelType r1 = r1.getModelType()     // Catch:{ MlKitException -> 0x00bc }
            r3 = 5
            r0.zza(r2, r2, r1, r3)     // Catch:{ MlKitException -> 0x00bc }
            long r0 = r7.longValue()     // Catch:{ MlKitException -> 0x00bc }
            com.google.android.gms.tasks.Task r0 = r10.f(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x007b:
            if (r1 != 0) goto L_0x007e
            goto L_0x0084
        L_0x007e:
            com.google.mlkit.common.model.DownloadConditions r0 = r10.l     // Catch:{ MlKitException -> 0x00bc }
            java.lang.Long r0 = r10.c(r1, r0)     // Catch:{ MlKitException -> 0x00bc }
        L_0x0084:
            if (r0 != 0) goto L_0x0092
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch:{ MlKitException -> 0x00bc }
            java.lang.String r1 = "Failed to schedule the download task"
            r0.<init>(r1, r5, r4)     // Catch:{ MlKitException -> 0x00bc }
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x0092:
            long r0 = r0.longValue()     // Catch:{ MlKitException -> 0x00bc }
            com.google.android.gms.tasks.Task r0 = r10.f(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x009b:
            if (r1 == 0) goto L_0x00b7
            com.google.mlkit.common.model.DownloadConditions r2 = r10.l     // Catch:{ MlKitException -> 0x00bc }
            java.lang.Long r1 = r10.c(r1, r2)     // Catch:{ MlKitException -> 0x00bc }
            if (r1 == 0) goto L_0x00ae
            long r0 = r1.longValue()     // Catch:{ MlKitException -> 0x00bc }
            com.google.android.gms.tasks.Task r0 = r10.f(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x00ae:
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.m     // Catch:{ MlKitException -> 0x00bc }
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r3 = "Didn't schedule download for the updated model"
            r1.i(r2, r3)     // Catch:{ MlKitException -> 0x00bc }
        L_0x00b7:
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)     // Catch:{ MlKitException -> 0x00bc }
            return r0
        L_0x00bc:
            r0 = move-exception
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException
            java.lang.String r2 = "Failed to ensure the model is downloaded."
            r1.<init>(r2, r5, r0)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.ensureModelDownloaded():com.google.android.gms.tasks.Task");
    }

    public final Task<Void> f(long j2) {
        a aVar;
        synchronized (this) {
            aVar = this.a.get(j2);
            if (aVar == null) {
                aVar = new a(j2, d(j2), null);
                this.a.put(j2, aVar);
            }
        }
        this.c.getApplicationContext().registerReceiver(aVar, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler());
        return d(j2).getTask();
    }

    @Nullable
    @KeepForSdk
    public synchronized ParcelFileDescriptor getDownloadedFile() {
        Long downloadingId = getDownloadingId();
        DownloadManager downloadManager = this.d;
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptor = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            m.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptor;
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingId() {
        return this.h.getDownloadingModelId(this.e);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash() {
        return this.h.getDownloadingModelHash(this.e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Integer getDownloadingModelStatusCode() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.Long r0 = r9.getDownloadingId()     // Catch:{ all -> 0x0082 }
            android.app.DownloadManager r1 = r9.d     // Catch:{ all -> 0x0082 }
            r2 = 0
            if (r1 == 0) goto L_0x0080
            if (r0 != 0) goto L_0x000e
            goto L_0x0080
        L_0x000e:
            android.app.DownloadManager$Query r3 = new android.app.DownloadManager$Query     // Catch:{ all -> 0x0082 }
            r3.<init>()     // Catch:{ all -> 0x0082 }
            r4 = 1
            long[] r5 = new long[r4]     // Catch:{ all -> 0x0082 }
            r6 = 0
            long r7 = r0.longValue()     // Catch:{ all -> 0x0082 }
            r5[r6] = r7     // Catch:{ all -> 0x0082 }
            android.app.DownloadManager$Query r0 = r3.setFilterById(r5)     // Catch:{ all -> 0x0082 }
            android.database.Cursor r0 = r1.query(r0)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x003e
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "status"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ all -> 0x003c }
            int r1 = r0.getInt(r1)     // Catch:{ all -> 0x003c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r1 = move-exception
            goto L_0x0075
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r1 != 0) goto L_0x0048
            if (r0 == 0) goto L_0x0046
            r0.close()
        L_0x0046:
            monitor-exit(r9)
            return r2
        L_0x0048:
            int r3 = r1.intValue()
            r5 = 2
            if (r3 == r5) goto L_0x006d
            int r3 = r1.intValue()
            r5 = 4
            if (r3 == r5) goto L_0x006d
            int r3 = r1.intValue()
            if (r3 == r4) goto L_0x006d
            int r3 = r1.intValue()
            r4 = 8
            if (r3 == r4) goto L_0x006d
            int r3 = r1.intValue()
            r4 = 16
            if (r3 == r4) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r2 = r1
        L_0x006e:
            if (r0 == 0) goto L_0x0073
            r0.close()
        L_0x0073:
            monitor-exit(r9)
            return r2
        L_0x0075:
            if (r0 == 0) goto L_0x007f
            r0.close()     // Catch:{ all -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.internal.mlkit_common.zzan.zza(r1, r0)
        L_0x007f:
            throw r1
        L_0x0080:
            monitor-exit(r9)
            return r2
        L_0x0082:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.getDownloadingModelStatusCode():java.lang.Integer");
    }

    @KeepForSdk
    public int getFailureReason(Long l2) {
        int columnIndex;
        DownloadManager downloadManager = this.d;
        Cursor query = (downloadManager == null || l2 == null) ? null : downloadManager.query(new DownloadManager.Query().setFilterById(l2.longValue()));
        if (query == null || !query.moveToFirst() || (columnIndex = query.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return query.getInt(columnIndex);
    }

    @KeepForSdk
    @WorkerThread
    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            m.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId == null || downloadingModelHash == null) {
            m.d("ModelDownloadManager", "No new model is downloading.");
            removeOrCancelDownload();
            return false;
        }
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        GmsLogger gmsLogger = m;
        String valueOf = String.valueOf(downloadingModelStatusCode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Download Status code: ");
        sb.append(valueOf);
        gmsLogger.d("ModelDownloadManager", sb.toString());
        if (downloadingModelStatusCode == null) {
            removeOrCancelDownload();
            return false;
        } else if (!Objects.equal(downloadingModelStatusCode, 8) || zza(downloadingModelHash) == null) {
            return false;
        } else {
            return true;
        }
    }

    @KeepForSdk
    public boolean modelExistsLocally() throws MlKitException {
        return this.i.modelExistsLocally(this.e.getUniqueModelNameForPersist(), this.f);
    }

    @KeepForSdk
    public synchronized void removeOrCancelDownload() throws MlKitException {
        Long downloadingId = getDownloadingId();
        if (this.d != null) {
            if (downloadingId != null) {
                GmsLogger gmsLogger = m;
                String valueOf = String.valueOf(downloadingId);
                StringBuilder sb = new StringBuilder(valueOf.length() + 44);
                sb.append("Cancel or remove existing downloading task: ");
                sb.append(valueOf);
                gmsLogger.d("ModelDownloadManager", sb.toString());
                if (this.d.remove(downloadingId.longValue()) > 0 || getDownloadingModelStatusCode() == null) {
                    this.i.deleteTempFilesInPrivateFolder(this.e.getUniqueModelNameForPersist(), this.e.getModelType());
                    this.h.clearDownloadingModelInfo(this.e);
                }
            }
        }
    }

    @KeepForSdk
    public void setDownloadConditions(@NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.l = downloadConditions;
    }

    @KeepForSdk
    public synchronized void updateLatestModelHashAndType(@NonNull String str) throws MlKitException {
        this.h.setLatestModelHash(this.e, str);
        removeOrCancelDownload();
    }

    @Nullable
    public final File zza(String str) throws MlKitException {
        GmsLogger gmsLogger = m;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.g.zza(0, true, this.f, 6);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.k.moveModelToPrivateFolder(downloadedFile, str, this.e);
        } finally {
            removeOrCancelDownload();
        }
    }
}
