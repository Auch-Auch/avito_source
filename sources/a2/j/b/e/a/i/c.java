package a2.j.b.e.a.i;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.ac;
public final class c implements Runnable {
    public final /* synthetic */ SplitInstallSessionState a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ac d;

    public c(ac acVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.d = acVar;
        this.a = splitInstallSessionState;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ac acVar = this.d;
        SplitInstallSessionState splitInstallSessionState = this.a;
        acVar.a((ac) new a(splitInstallSessionState.sessionId(), this.b, this.c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.b(), splitInstallSessionState.c(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.d()));
    }
}
