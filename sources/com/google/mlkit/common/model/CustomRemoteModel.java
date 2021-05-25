package com.google.mlkit.common.model;

import com.google.android.gms.common.annotation.KeepForSdk;
public final class CustomRemoteModel extends RemoteModel {
    @KeepForSdk
    public final RemoteModelSource getRemoteModelSource() {
        return null;
    }
}
