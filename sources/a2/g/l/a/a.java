package a2.g.l.a;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
public final class a implements NsdManager.RegistrationListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
        DeviceRequestsHelper.cleanUpAdvertisementService(this.b);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        if (!this.a.equals(nsdServiceInfo.getServiceName())) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.b);
        }
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
    }
}
