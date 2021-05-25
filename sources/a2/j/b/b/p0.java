package a2.j.b.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
public final class p0 {
    @Nullable
    public final WifiManager a;
    @Nullable
    public WifiManager.WifiLock b;
    public boolean c;
    public boolean d;

    public p0(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            WifiManager wifiManager = this.a;
            if (wifiManager == null) {
                Log.w("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.b = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.c = z;
        b();
    }

    public final void b() {
        WifiManager.WifiLock wifiLock = this.b;
        if (wifiLock != null) {
            if (!this.c || !this.d) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }
}
