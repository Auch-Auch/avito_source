package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import java.util.Set;
@KeepForSdk
public interface RemoteModelManagerInterface<RemoteT extends RemoteModel> {
    @KeepForSdk
    Task<Void> deleteDownloadedModel(RemoteT remotet);

    @KeepForSdk
    Task<Void> download(RemoteT remotet, DownloadConditions downloadConditions);

    @KeepForSdk
    Task<Set<RemoteT>> getDownloadedModels();

    @KeepForSdk
    Task<Boolean> isModelDownloaded(RemoteT remotet);
}
