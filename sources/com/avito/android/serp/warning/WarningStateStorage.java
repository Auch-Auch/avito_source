package com.avito.android.serp.warning;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/warning/WarningStateStorage;", "", "", "id", "Lcom/avito/android/serp/warning/WarningState;", "getState", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "state", "", "setState", "(Ljava/lang/String;Lcom/avito/android/serp/warning/WarningState;)V", "", "isProcessed", "(Ljava/lang/String;)Z", "Lcom/avito/android/serp/warning/WarningStateStorageState;", "onSaveState", "()Lcom/avito/android/serp/warning/WarningStateStorageState;", "onRestoreState", "(Lcom/avito/android/serp/warning/WarningStateStorageState;)V", "name", "()Ljava/lang/String;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface WarningStateStorage {
    @NotNull
    WarningState getState(@NotNull String str);

    boolean isProcessed(@NotNull String str);

    @NotNull
    String name();

    void onRestoreState(@NotNull WarningStateStorageState warningStateStorageState);

    @NotNull
    WarningStateStorageState onSaveState();

    void setState(@NotNull String str, @NotNull WarningState warningState);
}
