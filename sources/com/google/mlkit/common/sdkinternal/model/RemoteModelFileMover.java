package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.io.File;
@KeepForSdk
public interface RemoteModelFileMover {
    @KeepForSdk
    File getModelFileDestination() throws MlKitException;

    @KeepForSdk
    File moveAllFilesFromPrivateTempToPrivateDestination(File file) throws MlKitException;
}
