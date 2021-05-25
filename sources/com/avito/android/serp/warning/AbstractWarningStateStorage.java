package com.avito.android.serp.warning;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u000b\u0010\u0006J\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H$¢\u0006\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/warning/AbstractWarningStateStorage;", "Lcom/avito/android/serp/warning/WarningStateStorage;", "", "id", "Lcom/avito/android/serp/warning/WarningState;", "getState", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "state", "", "setState", "(Ljava/lang/String;Lcom/avito/android/serp/warning/WarningState;)V", "restoreState", "saveState", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractWarningStateStorage implements WarningStateStorage {
    @Override // com.avito.android.serp.warning.WarningStateStorage
    @NotNull
    public WarningState getState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (isProcessed(str)) {
            return restoreState(str);
        }
        throw new IllegalArgumentException(a.c3("Don't processed id ", str));
    }

    @NotNull
    public abstract WarningState restoreState(@NotNull String str);

    public abstract void saveState(@NotNull String str, @NotNull WarningState warningState);

    @Override // com.avito.android.serp.warning.WarningStateStorage
    public void setState(@NotNull String str, @NotNull WarningState warningState) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(warningState, "state");
        if (isProcessed(str)) {
            saveState(str, warningState);
            return;
        }
        throw new IllegalArgumentException(a.c3("Don't processed id ", str));
    }
}
