package com.avito.android.remote.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/AdSize;", "", "", "serverName", "Ljava/lang/String;", "getServerName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SMALL", "SMALL_NEW", "BIG", "models_release"}, k = 1, mv = {1, 4, 2})
public enum AdSize {
    SMALL("small"),
    SMALL_NEW("small_new"),
    BIG("big");
    
    @NotNull
    private final String serverName;

    private AdSize(String str) {
        this.serverName = str;
    }

    @NotNull
    public final String getServerName() {
        return this.serverName;
    }
}
