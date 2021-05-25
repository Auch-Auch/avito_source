package com.avito.android.serp.warning;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/serp/warning/PermanentWarningStateStorage;", "Lcom/avito/android/serp/warning/AbstractWarningStateStorage;", "", "id", "", "isProcessed", "(Ljava/lang/String;)Z", "Lcom/avito/android/serp/warning/WarningState;", "restoreState", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "state", "", "saveState", "(Ljava/lang/String;Lcom/avito/android/serp/warning/WarningState;)V", "Lcom/avito/android/serp/warning/WarningStateStorageState;", "onSaveState", "()Lcom/avito/android/serp/warning/WarningStateStorageState;", "onRestoreState", "(Lcom/avito/android/serp/warning/WarningStateStorageState;)V", "name", "()Ljava/lang/String;", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "processedIds", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class PermanentWarningStateStorage extends AbstractWarningStateStorage {
    public final Set<String> a = x.setOf("jobNearbyWarningItem");
    public final Preferences b;

    public PermanentWarningStateStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.b = preferences;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    public boolean isProcessed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.a.contains(str);
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    @NotNull
    public String name() {
        String name = PermanentWarningStateStorage.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this::class.java.name");
        return name;
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    public void onRestoreState(@NotNull WarningStateStorageState warningStateStorageState) {
        Intrinsics.checkNotNullParameter(warningStateStorageState, "state");
    }

    @Override // com.avito.android.serp.warning.WarningStateStorage
    @NotNull
    public WarningStateStorageState onSaveState() {
        return new WarningStateStorageState();
    }

    @Override // com.avito.android.serp.warning.AbstractWarningStateStorage
    @NotNull
    public WarningState restoreState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Preferences preferences = this.b;
        String string = preferences.getString("warning_" + str);
        if (string == null) {
            return WarningState.SHOW;
        }
        return WarningState.Companion.getWarningStateByValue(string);
    }

    @Override // com.avito.android.serp.warning.AbstractWarningStateStorage
    public void saveState(@NotNull String str, @NotNull WarningState warningState) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(warningState, "state");
        this.b.putString(a.c3("warning_", str), warningState.getValue());
    }
}
