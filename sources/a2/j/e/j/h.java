package a2.j.e.j;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.installations.local.PersistedInstallationEntry;
public class h implements j {
    public final k a;
    public final TaskCompletionSource<InstallationTokenResult> b;

    public h(k kVar, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.a = kVar;
        this.b = taskCompletionSource;
    }

    @Override // a2.j.e.j.j
    public boolean a(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.a.b(persistedInstallationEntry)) {
            return false;
        }
        this.b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }

    @Override // a2.j.e.j.j
    public boolean b(PersistedInstallationEntry persistedInstallationEntry, Exception exc) {
        if (!persistedInstallationEntry.isErrored() && !persistedInstallationEntry.isNotGenerated() && !persistedInstallationEntry.isUnregistered()) {
            return false;
        }
        this.b.trySetException(exc);
        return true;
    }
}
