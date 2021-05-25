package com.avito.android.calls_shared.storage;

import com.avito.android.calls_shared.models.CallAvailabilityNotifiedState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/calls_shared/storage/CallStorageImpl;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "Lcom/avito/android/calls_shared/models/CallAvailabilityNotifiedState;", "value", "getCallAvailabilityNotifiedState", "()Lcom/avito/android/calls_shared/models/CallAvailabilityNotifiedState;", "setCallAvailabilityNotifiedState", "(Lcom/avito/android/calls_shared/models/CallAvailabilityNotifiedState;)V", "callAvailabilityNotifiedState", "", "getLastRegisteredPushToken", "()Ljava/lang/String;", "setLastRegisteredPushToken", "(Ljava/lang/String;)V", "lastRegisteredPushToken", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "", "getDeclinedCalls", "()I", "setDeclinedCalls", "(I)V", "declinedCalls", "getCanceledCalls", "setCanceledCalls", "canceledCalls", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "Companion", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallStorageImpl implements CallStorage {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Preferences a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/storage/CallStorageImpl$Companion;", "", "", "AVAILABILITY_NOTIFIED_STATE", "Ljava/lang/String;", "CANCELED_CALLS", "DECLINED_CALLS", "LAST_REGISTERED_PUSH_TOKEN", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Inject
    public CallStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    @NotNull
    public CallAvailabilityNotifiedState getCallAvailabilityNotifiedState() {
        String str = "";
        String string = this.a.getString("availability_notified_state", str);
        if (string != null) {
            str = string;
        }
        try {
            return CallAvailabilityNotifiedState.valueOf(str);
        } catch (IllegalArgumentException unused) {
            return CallAvailabilityNotifiedState.UNKNOWN;
        }
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public int getCanceledCalls() {
        return this.a.getInt("canceled_calls", 0);
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public int getDeclinedCalls() {
        return this.a.getInt("declined_calls", 0);
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    @NotNull
    public String getLastRegisteredPushToken() {
        String string = this.a.getString("last_reg_push_token", "");
        return string != null ? string : "";
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public void setCallAvailabilityNotifiedState(@NotNull CallAvailabilityNotifiedState callAvailabilityNotifiedState) {
        Intrinsics.checkNotNullParameter(callAvailabilityNotifiedState, "value");
        this.a.putString("availability_notified_state", callAvailabilityNotifiedState.name());
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public void setCanceledCalls(int i) {
        this.a.putInt("canceled_calls", i);
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public void setDeclinedCalls(int i) {
        this.a.putInt("declined_calls", i);
    }

    @Override // com.avito.android.calls_shared.storage.CallStorage
    public void setLastRegisteredPushToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.a.putString("last_reg_push_token", str);
    }
}
