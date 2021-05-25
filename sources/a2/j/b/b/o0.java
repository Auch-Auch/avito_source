package a2.j.b.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
public final class o0 {
    @Nullable
    public final PowerManager a;
    @Nullable
    public PowerManager.WakeLock b;
    public boolean c;
    public boolean d;

    public o0(Context context) {
        this.a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            PowerManager powerManager = this.a;
            if (powerManager == null) {
                Log.w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.c = z;
        b();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void b() {
        PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock != null) {
            if (!this.c || !this.d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }
}
