package a2.g.r;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
public final class e implements InstallReferrerStateListener {
    public final /* synthetic */ InstallReferrerClient a;
    public final /* synthetic */ InstallReferrerUtil.Callback b;

    public e(InstallReferrerClient installReferrerClient, InstallReferrerUtil.Callback callback) {
        this.a = installReferrerClient;
        this.b = callback;
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    @AutoHandleExceptions
    public void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            try {
                String installReferrer = this.a.getInstallReferrer().getInstallReferrer();
                if (installReferrer != null && (installReferrer.contains("fb") || installReferrer.contains("facebook"))) {
                    this.b.onReceiveReferrerUrl(installReferrer);
                }
                InstallReferrerUtil.a();
            } catch (RemoteException unused) {
            }
        } else if (i == 2) {
            InstallReferrerUtil.a();
        }
    }
}
