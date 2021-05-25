package a2.j.e.d.d.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
public class c {
    public final Float a;
    public final boolean b;

    public c(Float f, boolean z) {
        this.b = z;
        this.a = f;
    }

    public static c a(Context context) {
        Float f = null;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra != -1 && (intExtra == 2 || intExtra == 5)) {
                z = true;
            }
            int intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra3 = registerReceiver.getIntExtra("scale", -1);
            if (!(intExtra2 == -1 || intExtra3 == -1)) {
                f = Float.valueOf(((float) intExtra2) / ((float) intExtra3));
            }
        }
        return new c(f, z);
    }

    public int b() {
        Float f;
        if (!this.b || (f = this.a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
