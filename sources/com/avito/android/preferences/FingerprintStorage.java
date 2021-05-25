package com.avito.android.preferences;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/preferences/FingerprintStorage;", "", "", "isFingerprintAvailable", "()Z", "", "getFingerprint", "()Ljava/lang/String;", "setFingerprint", "(Ljava/lang/String;)V", "fingerprint", "core_release"}, k = 1, mv = {1, 4, 2})
public interface FingerprintStorage {
    @Nullable
    String getFingerprint();

    boolean isFingerprintAvailable();

    void setFingerprint(@Nullable String str);
}
