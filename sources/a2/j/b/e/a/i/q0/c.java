package a2.j.b.e.a.i.q0;

import com.google.android.play.core.internal.z;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
public final class c implements Runnable {
    public final /* synthetic */ SplitInstallSessionState a;
    public final /* synthetic */ FakeSplitInstallManager b;

    public c(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.b = fakeSplitInstallManager;
        this.a = splitInstallSessionState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f.a((z<SplitInstallSessionState>) this.a);
    }
}
