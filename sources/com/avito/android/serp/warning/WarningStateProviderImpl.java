package com.avito.android.serp.warning;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/warning/WarningStateProviderImpl;", "Lcom/avito/android/serp/warning/WarningStateProvider;", "", "id", "Lcom/avito/android/serp/warning/WarningState;", "getState", "(Ljava/lang/String;)Lcom/avito/android/serp/warning/WarningState;", "state", "", "setState", "(Ljava/lang/String;Lcom/avito/android/serp/warning/WarningState;)V", "Lcom/avito/android/serp/warning/WarningStateProviderState;", "onSaveState", "()Lcom/avito/android/serp/warning/WarningStateProviderState;", "", "Lcom/avito/android/serp/warning/WarningStateStorage;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "storages", "warningStateProviderState", "<init>", "(Ljava/util/List;Lcom/avito/android/serp/warning/WarningStateProviderState;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WarningStateProviderImpl implements WarningStateProvider {
    public final List<WarningStateStorage> a;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.serp.warning.WarningStateStorage> */
    /* JADX WARN: Multi-variable type inference failed */
    public WarningStateProviderImpl(@NotNull List<? extends WarningStateStorage> list, @Nullable WarningStateProviderState warningStateProviderState) {
        Intrinsics.checkNotNullParameter(list, "storages");
        this.a = list;
        if (warningStateProviderState != null) {
            for (WarningStateStorage warningStateStorage : list) {
                WarningStateStorageState warningStateStorageState = warningStateProviderState.get(warningStateStorage.name());
                if (warningStateStorageState != null) {
                    warningStateStorage.onRestoreState(warningStateStorageState);
                }
            }
        }
    }

    @Override // com.avito.android.serp.warning.WarningStateProvider
    @NotNull
    public WarningState getState(@NotNull String str) {
        WarningState state;
        Intrinsics.checkNotNullParameter(str, "id");
        List<WarningStateStorage> list = this.a;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.isProcessed(str)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((WarningStateStorage) obj).getState(str) == WarningState.HIDE) {
                arrayList2.add(obj);
            }
        }
        WarningStateStorage warningStateStorage = (WarningStateStorage) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        return (warningStateStorage == null || (state = warningStateStorage.getState(str)) == null) ? WarningState.SHOW : state;
    }

    @Override // com.avito.android.serp.warning.WarningStateProvider
    @NotNull
    public WarningStateProviderState onSaveState() {
        WarningStateProviderState warningStateProviderState = new WarningStateProviderState();
        for (T t : this.a) {
            warningStateProviderState.put(t.name(), t.onSaveState());
        }
        return warningStateProviderState;
    }

    @Override // com.avito.android.serp.warning.WarningStateProvider
    public void setState(@NotNull String str, @NotNull WarningState warningState) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(warningState, "state");
        List<WarningStateStorage> list = this.a;
        ArrayList<WarningStateStorage> arrayList = new ArrayList();
        for (T t : list) {
            if (t.isProcessed(str)) {
                arrayList.add(t);
            }
        }
        for (WarningStateStorage warningStateStorage : arrayList) {
            warningStateStorage.setState(str, warningState);
        }
    }
}
