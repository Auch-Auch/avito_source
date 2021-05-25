package com.google.mlkit.common.sdkinternal;

import a2.j.h.a.c.n;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.avito.android.util.preferences.Preference;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;
@KeepForSdk
public class SharedPrefManager {
    @KeepForSdk
    public static final Component<?> COMPONENT = Component.builder(SharedPrefManager.class).add(Dependency.required(MlKitContext.class)).add(Dependency.required(Context.class)).factory(n.a).build();
    @KeepForSdk
    @VisibleForTesting
    public static final String PREF_FILE = "com.google.mlkit.internal";
    public final Context a;

    public SharedPrefManager(@NonNull Context context) {
        this.a = context;
    }

    @KeepForSdk
    public static SharedPrefManager getInstance(@NonNull MlKitContext mlKitContext) {
        return (SharedPrefManager) mlKitContext.get(SharedPrefManager.class);
    }

    public final SharedPreferences a() {
        return this.a.getSharedPreferences(PREF_FILE, 0);
    }

    @KeepForSdk
    public synchronized void clearDownloadingModelInfo(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_type_%s", getDownloadingModelHash(remoteModel))).remove(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist())).apply();
    }

    @KeepForSdk
    public synchronized void clearIncompatibleModelInfo(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove(Preference.APP_VERSION).apply();
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void clearLatestModelHash(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).commit();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001a: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r6v2 java.lang.String) */
    @Nullable
    @KeepForSdk
    public synchronized String getCachedLocalModelHash(@NonNull LocalModel localModel, long j) {
        SharedPreferences a3;
        Object[] objArr;
        a3 = a();
        objArr = new Object[2];
        objArr[0] = localModel.getAbsoluteFilePath() != null ? localModel.getAbsoluteFilePath() : localModel.getAssetFilePath();
        objArr[1] = Long.valueOf(j);
        return a3.getString(String.format("cached_local_model_hash_%1s_%2s", objArr), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingModelId(@NonNull RemoteModel remoteModel) {
        long j = a().getLong(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist()), -1);
        if (j < 0) {
            return null;
        }
        return Long.valueOf(j);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getIncompatibleModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getLatestModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @KeepForSdk
    public synchronized String getMlSdkInstanceId() {
        String string = a().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        a().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    @KeepForSdk
    public synchronized long getModelDownloadBeginTimeMs(@NonNull RemoteModel remoteModel) {
        return a().getLong(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist()), 0);
    }

    @KeepForSdk
    public synchronized long getModelFirstUseTimeMs(@NonNull RemoteModel remoteModel) {
        return a().getLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), 0);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getPreviousAppVersion() {
        return a().getString(Preference.APP_VERSION, null);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001e: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r6v2 java.lang.String) */
    @KeepForSdk
    public synchronized void setCachedLocalModelHash(@NonNull LocalModel localModel, long j, @NonNull String str) {
        SharedPreferences.Editor edit = a().edit();
        Object[] objArr = new Object[2];
        objArr[0] = localModel.getAbsoluteFilePath() != null ? localModel.getAbsoluteFilePath() : localModel.getAssetFilePath();
        objArr[1] = Long.valueOf(j);
        edit.putString(String.format("cached_local_model_hash_%1s_%2s", objArr), str).apply();
    }

    @KeepForSdk
    public synchronized void setDownloadingModelInfo(long j, @NonNull ModelInfo modelInfo) {
        String modelNameForPersist = modelInfo.getModelNameForPersist();
        a().edit().putString(String.format("downloading_model_hash_%s", modelNameForPersist), modelInfo.getModelHash()).putLong(String.format("downloading_model_id_%s", modelNameForPersist), j).putLong(String.format("downloading_begin_time_%s", modelNameForPersist), SystemClock.elapsedRealtime()).apply();
    }

    @KeepForSdk
    public synchronized void setIncompatibleModelInfo(@NonNull RemoteModel remoteModel, @NonNull String str, @NonNull String str2) {
        a().edit().putString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).putString(Preference.APP_VERSION, str2).apply();
    }

    @KeepForSdk
    public synchronized void setLatestModelHash(@NonNull RemoteModel remoteModel, @NonNull String str) {
        a().edit().putString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).apply();
    }

    @KeepForSdk
    public synchronized void setModelFirstUseTimeMs(@NonNull RemoteModel remoteModel, long j) {
        a().edit().putLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), j).apply();
    }
}
