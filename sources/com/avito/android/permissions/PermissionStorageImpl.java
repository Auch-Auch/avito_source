package com.avito.android.permissions;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u000e\u0010\u0007R$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R$\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/permissions/PermissionStorageImpl;", "Lcom/avito/android/permissions/PermissionStorage;", "", "value", "getWasStoragePermissionForeverDenied", "()Z", "setWasStoragePermissionForeverDenied", "(Z)V", "wasStoragePermissionForeverDenied", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "getWasStoragePermissionAsked", "setWasStoragePermissionAsked", "wasStoragePermissionAsked", "getWasMicPermissionForeverDenied", "setWasMicPermissionForeverDenied", "wasMicPermissionForeverDenied", "getWasMicPermissionAsked", "setWasMicPermissionAsked", "wasMicPermissionAsked", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "Companion", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class PermissionStorageImpl implements PermissionStorage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Preferences a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/permissions/PermissionStorageImpl$Companion;", "", "", "WAS_MIC_PERMISSION_ASKED", "Ljava/lang/String;", "WAS_MIC_PERMISSION_FOREVER_DENIED", "WAS_STORAGE_PERMISSION_ASKED", "WAS_STORAGE_PERMISSION_FOREVER_DENIED", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public PermissionStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public boolean getWasMicPermissionAsked() {
        return this.a.getBoolean("was_mic_permission_asked", false);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public boolean getWasMicPermissionForeverDenied() {
        return this.a.getBoolean("was_mic_permission_forever_denied", false);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public boolean getWasStoragePermissionAsked() {
        return this.a.getBoolean("was_storage_permission_asked", false);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public boolean getWasStoragePermissionForeverDenied() {
        return this.a.getBoolean("was_storage_permission_forever_denied", false);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public void setWasMicPermissionAsked(boolean z) {
        this.a.putBoolean("was_mic_permission_asked", z);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public void setWasMicPermissionForeverDenied(boolean z) {
        this.a.putBoolean("was_mic_permission_forever_denied", z);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public void setWasStoragePermissionAsked(boolean z) {
        this.a.putBoolean("was_storage_permission_asked", z);
    }

    @Override // com.avito.android.permissions.PermissionStorage
    public void setWasStoragePermissionForeverDenied(boolean z) {
        this.a.putBoolean("was_storage_permission_forever_denied", z);
    }
}
