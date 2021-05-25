package com.facebook.internal;

import a2.b.a.a.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import bolts.MeasurementEvent;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public class BoltsMeasurementEventListener extends BroadcastReceiver {
    public static BoltsMeasurementEventListener b;
    public Context a;

    public BoltsMeasurementEventListener(Context context) {
        this.a = context.getApplicationContext();
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        BoltsMeasurementEventListener boltsMeasurementEventListener = b;
        if (boltsMeasurementEventListener != null) {
            return boltsMeasurementEventListener;
        }
        BoltsMeasurementEventListener boltsMeasurementEventListener2 = new BoltsMeasurementEventListener(context);
        b = boltsMeasurementEventListener2;
        LocalBroadcastManager.getInstance(boltsMeasurementEventListener2.a).registerReceiver(boltsMeasurementEventListener2, new IntentFilter(MeasurementEvent.MEASUREMENT_EVENT_NOTIFICATION_NAME));
        return b;
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(this);
        } finally {
            super.finalize();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        StringBuilder L = a.L("bf_");
        L.append(intent.getStringExtra("event_name"));
        String sb = L.toString();
        Bundle bundleExtra = intent.getBundleExtra(MeasurementEvent.MEASUREMENT_EVENT_ARGS_KEY);
        Bundle bundle = new Bundle();
        for (String str : bundleExtra.keySet()) {
            bundle.putString(str.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str));
        }
        internalAppEventsLogger.logEvent(sb, bundle);
    }
}
