package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final String a = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    public class a implements Runnable {
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ BroadcastReceiver.PendingResult c;

        public a(ConstraintProxyUpdateReceiver constraintProxyUpdateReceiver, Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.a = intent;
            this.b = context;
            this.c = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = this.a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = this.a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = this.a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = this.a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                Logger.get().debug(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                PackageManagerHelper.setComponentEnabled(this.b, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                PackageManagerHelper.setComponentEnabled(this.b, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                PackageManagerHelper.setComponentEnabled(this.b, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                PackageManagerHelper.setComponentEnabled(this.b, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                this.c.finish();
            }
        }
    }

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            Logger.get().debug(a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
        } else {
            WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnBackgroundThread(new a(this, intent, context, goAsync()));
        }
    }
}
