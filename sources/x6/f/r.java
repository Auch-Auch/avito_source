package x6.f;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import org.webrtc.NetworkMonitorAutoDetect;
public final /* synthetic */ class r implements WifiP2pManager.GroupInfoListener {
    public final /* synthetic */ NetworkMonitorAutoDetect.WifiDirectManagerDelegate a;

    public /* synthetic */ r(NetworkMonitorAutoDetect.WifiDirectManagerDelegate wifiDirectManagerDelegate) {
        this.a = wifiDirectManagerDelegate;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.a.a(wifiP2pGroup);
    }
}
