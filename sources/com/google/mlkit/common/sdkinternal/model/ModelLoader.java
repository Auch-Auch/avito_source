package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;
@KeepForSdk
@WorkerThread
public class ModelLoader {
    public static final GmsLogger b = new GmsLogger("ModelLoader", "");
    @NonNull
    public final ModelLoadingLogger a;
    @Nullable
    @KeepForSdk
    public final LocalModelLoader localModelLoader;
    @KeepForSdk
    public ModelLoadingState modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
    @Nullable
    @KeepForSdk
    @VisibleForTesting
    public final RemoteModelLoader remoteModelLoader;

    @KeepForSdk
    public interface ModelContentHandler {
        @KeepForSdk
        void constructModel(MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    @KeepForSdk
    public interface ModelLoadingLogger {
        @KeepForSdk
        void logErrorCodes(List<Integer> list);
    }

    @KeepForSdk
    public enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    @KeepForSdk
    public ModelLoader(@Nullable RemoteModelLoader remoteModelLoader2, @Nullable LocalModelLoader localModelLoader2, @NonNull ModelLoadingLogger modelLoadingLogger) {
        Preconditions.checkArgument((remoteModelLoader2 == null && localModelLoader2 == null) ? false : true, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader2;
        this.localModelLoader = localModelLoader2;
        this.a = modelLoadingLogger;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r4 = this;
            com.google.mlkit.common.sdkinternal.model.LocalModelLoader r0 = r4.localModelLoader
            if (r0 == 0) goto L_0x0030
            com.google.mlkit.common.model.LocalModel r0 = r0.getLocalModel()
            java.lang.String r0 = r0.getAssetFilePath()
            if (r0 == 0) goto L_0x0019
            com.google.mlkit.common.sdkinternal.model.LocalModelLoader r0 = r4.localModelLoader
            com.google.mlkit.common.model.LocalModel r0 = r0.getLocalModel()
            java.lang.String r0 = r0.getAssetFilePath()
            goto L_0x0031
        L_0x0019:
            com.google.mlkit.common.sdkinternal.model.LocalModelLoader r0 = r4.localModelLoader
            com.google.mlkit.common.model.LocalModel r0 = r0.getLocalModel()
            java.lang.String r0 = r0.getAbsoluteFilePath()
            if (r0 == 0) goto L_0x0030
            com.google.mlkit.common.sdkinternal.model.LocalModelLoader r0 = r4.localModelLoader
            com.google.mlkit.common.model.LocalModel r0 = r0.getLocalModel()
            java.lang.String r0 = r0.getAbsoluteFilePath()
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            com.google.mlkit.common.sdkinternal.model.RemoteModelLoader r1 = r4.remoteModelLoader
            if (r1 != 0) goto L_0x0038
            java.lang.String r1 = "unspecified"
            goto L_0x0040
        L_0x0038:
            com.google.mlkit.common.model.RemoteModel r1 = r1.getRemoteModel()
            java.lang.String r1 = r1.getUniqueModelNameForPersist()
        L_0x0040:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            r0 = 1
            r2[r0] = r1
            java.lang.String r0 = "Local model path: %s. Remote model name: %s. "
            java.lang.String r0 = java.lang.String.format(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.ModelLoader.a():java.lang.String");
    }

    public final synchronized boolean b(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        RemoteModelLoader remoteModelLoader2 = this.remoteModelLoader;
        if (remoteModelLoader2 != null) {
            try {
                MappedByteBuffer load = remoteModelLoader2.load();
                if (load != null) {
                    try {
                        modelContentHandler.constructModel(load);
                        b.d("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e) {
                        list.add(19);
                        throw e;
                    }
                } else {
                    b.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                    list.add(21);
                }
            } catch (MlKitException e2) {
                b.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e2;
            }
        }
        return false;
    }

    public final synchronized boolean c(ModelContentHandler modelContentHandler, List<Integer> list) throws MlKitException {
        MappedByteBuffer load;
        LocalModelLoader localModelLoader2 = this.localModelLoader;
        if (localModelLoader2 == null || (load = localModelLoader2.load()) == null) {
            return false;
        }
        try {
            modelContentHandler.constructModel(load);
            b.d("ModelLoader", "Local model source is loaded successfully");
            return true;
        } catch (RuntimeException e) {
            list.add(18);
            throw e;
        }
    }

    @KeepForSdk
    public synchronized boolean isRemoteModelLoaded() {
        return this.modelLoadingState == ModelLoadingState.REMOTE_MODEL_LOADED;
    }

    @KeepForSdk
    public synchronized void loadWithModelContentHandler(ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean z;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        Exception e = null;
        try {
            z = b(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e2) {
            exc = e2;
            z = false;
        }
        if (z) {
            this.a.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            z2 = c(modelContentHandler, arrayList);
        } catch (Exception e3) {
            e = e3;
        }
        if (z2) {
            this.a.logErrorCodes(arrayList);
            this.modelLoadingState = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.a.logErrorCodes(arrayList);
        this.modelLoadingState = ModelLoadingState.NO_MODEL_LOADED;
        if (exc != null) {
            String valueOf = String.valueOf(a());
            throw new MlKitException(valueOf.length() != 0 ? "Remote model load failed with the model options: ".concat(valueOf) : new String("Remote model load failed with the model options: "), 14, exc);
        } else if (e != null) {
            String valueOf2 = String.valueOf(a());
            throw new MlKitException(valueOf2.length() != 0 ? "Local model load failed with the model options: ".concat(valueOf2) : new String("Local model load failed with the model options: "), 14, e);
        } else {
            String valueOf3 = String.valueOf(a());
            throw new MlKitException(valueOf3.length() != 0 ? "Cannot load any model with the model options: ".concat(valueOf3) : new String("Cannot load any model with the model options: "), 14);
        }
    }
}
