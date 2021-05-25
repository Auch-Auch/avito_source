package a2.j.e.j;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;
public class i implements j {
    public final TaskCompletionSource<String> a;

    public i(TaskCompletionSource<String> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // a2.j.e.j.j
    public boolean a(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }

    @Override // a2.j.e.j.j
    public boolean b(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        return false;
    }
}
