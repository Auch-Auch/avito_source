package com.avito.android.app;

import com.avito.android.util.Logs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/app/NoOpApplicationDelegate;", "Lcom/avito/android/app/ApplicationDelegate;", "", "initialize", "()V", "", "startUpTimeMs", "onStartUpFinished", "(J)V", "<init>", "application_release"}, k = 1, mv = {1, 4, 2})
public final class NoOpApplicationDelegate implements ApplicationDelegate {
    @Override // com.avito.android.app.ApplicationDelegate
    public void initialize() {
        Logs.debug$default("NoOpApplicationDelegate", "initialize", null, 4, null);
    }

    @Override // com.avito.android.app.ApplicationDelegate
    public void onStartUpFinished(long j) {
    }
}
