package com.avito.android.util;

import a2.b.a.a.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/UUIDRandomKeyProvider;", "Lcom/avito/android/util/RandomKeyProvider;", "", "generateKey", "()Ljava/lang/String;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class UUIDRandomKeyProvider implements RandomKeyProvider {
    @Override // com.avito.android.util.RandomKeyProvider
    @NotNull
    public String generateKey() {
        return a.I2("UUID.randomUUID().toString()");
    }
}
