package com.avito.android.serp.warning;

import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/serp/warning/TemporalWarningStateStorage;", "Lcom/avito/android/serp/warning/AbstractWarningStateStorage;", "", "id", "", "isProcessed", "(Ljava/lang/String;)Z", "Lcom/avito/android/serp/warning/WarningState;", "restoreState", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "state", "", "saveState", "(Ljava/lang/String;Lcom/avito/android/serp/warning/WarningState;)V", "Lcom/avito/android/serp/warning/WarningStateStorageState;", "onSaveState", "()Lcom/avito/android/serp/warning/WarningStateStorageState;", "onRestoreState", "(Lcom/avito/android/serp/warning/WarningStateStorageState;)V", "name", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "stateMap", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class TemporalWarningStateStorage extends AbstractWarningStateStorage {
    public final Map<String, WarningState> a = new HashMap();

    @Override // com.avito.android.serp.warning.WarningStateStorage
    public boolean isProcessed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return true;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    @NotNull
    public String name() {
        String name = TemporalWarningStateStorage.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this::class.java.name");
        return name;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    public void onRestoreState(@NotNull WarningStateStorageState warningStateStorageState) {
        Intrinsics.checkNotNullParameter(warningStateStorageState, "state");
        if (warningStateStorageState instanceof TemporalWarningStateStorageState) {
            this.a.clear();
            this.a.putAll(((TemporalWarningStateStorageState) warningStateStorageState).getMap());
        }
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    @NotNull
    public WarningStateStorageState onSaveState() {
        return new TemporalWarningStateStorageState(this.a);
    }

    @Override // com.avito.android.serp.warning.AbstractWarningStateStorage
    @NotNull
    public WarningState restoreState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        WarningState warningState = this.a.get(str);
        if (warningState != null) {
            return warningState;
        }
        return WarningState.SHOW;
    }

    @Override // com.avito.android.serp.warning.AbstractWarningStateStorage
    public void saveState(@NotNull String str, @NotNull WarningState warningState) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(warningState, "state");
        this.a.put(str, warningState);
    }
}
