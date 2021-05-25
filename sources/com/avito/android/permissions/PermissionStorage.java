package com.avito.android.permissions;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/avito/android/permissions/PermissionStorage;", "", "", "getWasStoragePermissionAsked", "()Z", "setWasStoragePermissionAsked", "(Z)V", "wasStoragePermissionAsked", "getWasStoragePermissionForeverDenied", "setWasStoragePermissionForeverDenied", "wasStoragePermissionForeverDenied", "getWasMicPermissionForeverDenied", "setWasMicPermissionForeverDenied", "wasMicPermissionForeverDenied", "getWasMicPermissionAsked", "setWasMicPermissionAsked", "wasMicPermissionAsked", "permissions_release"}, k = 1, mv = {1, 4, 2})
public interface PermissionStorage {
    boolean getWasMicPermissionAsked();

    boolean getWasMicPermissionForeverDenied();

    boolean getWasStoragePermissionAsked();

    boolean getWasStoragePermissionForeverDenied();

    void setWasMicPermissionAsked(boolean z);

    void setWasMicPermissionForeverDenied(boolean z);

    void setWasStoragePermissionAsked(boolean z);

    void setWasStoragePermissionForeverDenied(boolean z);
}
