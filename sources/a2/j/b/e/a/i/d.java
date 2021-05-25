package a2.j.b.e.a.i;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.ac;
import java.util.ArrayList;
import java.util.List;
public final class d implements Runnable {
    public final /* synthetic */ SplitInstallRequest a;
    public final /* synthetic */ f b;

    public d(f fVar, SplitInstallRequest splitInstallRequest) {
        this.b = fVar;
        this.a = splitInstallRequest;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ac acVar = this.b.b;
        List<String> moduleNames = this.a.getModuleNames();
        List<String> a3 = f.a(this.a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(moduleNames));
        }
        if (!((ArrayList) a3).isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(a3));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        acVar.a((ac) SplitInstallSessionState.a(bundle));
    }
}
