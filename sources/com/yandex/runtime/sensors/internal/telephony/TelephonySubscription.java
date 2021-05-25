package com.yandex.runtime.sensors.internal.telephony;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
import com.yandex.runtime.logging.Logger;
public class TelephonySubscription {
    private static final String TAG = "com.yandex.runtime.sensors.internal.telephony.TelephonySubscription";
    private Context context;
    private NativeObject nativeObject = createPromise();
    private SignalStrengthListener signalStrengthListener;
    private TelephonyManager telephonyManager;

    public class SignalStrengthListener extends PhoneStateListener {
        private boolean signalReceived;

        private SignalStrengthListener() {
            this.signalReceived = false;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (!this.signalReceived) {
                this.signalReceived = true;
                TelephonySubscription.this.unsubscribe();
                try {
                    String networkTypeString = TelephonyUtils.getNetworkTypeString(TelephonySubscription.this.telephonyManager.getNetworkType());
                    GsmCellInfo gsmCellInfo = null;
                    if (networkTypeString != null) {
                        CellLocation cellLocation = TelephonySubscription.this.telephonyManager.getCellLocation();
                        GsmCellLocation gsmCellLocation = (cellLocation == null || !(cellLocation instanceof GsmCellLocation)) ? null : (GsmCellLocation) cellLocation;
                        if (gsmCellLocation != null && TelephonyUtils.isCidCorrect(gsmCellLocation.getCid()) && TelephonyUtils.isLacCorrect(gsmCellLocation.getLac())) {
                            gsmCellInfo = new GsmCellInfo(gsmCellLocation.getCid(), gsmCellLocation.getLac(), networkTypeString, signalStrength.getGsmSignalStrength());
                        }
                    }
                    TelephonySubscription.this.telephonyNetworkInfoAvailable(gsmCellInfo);
                } catch (Exception e) {
                    StringBuilder L = a.L("exception while handling signal strengths changed: ");
                    L.append(e.getMessage());
                    Logger.error(L.toString());
                }
            }
        }
    }

    public TelephonySubscription() {
        Context applicationContext = Runtime.getApplicationContext();
        this.context = applicationContext;
        this.telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        requestTelephonyNetworkInfo();
    }

    public static native NativeObject createPromise();

    private void requestTelephonyNetworkInfo() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.telephony.TelephonySubscription.2
            @Override // java.lang.Runnable
            public void run() {
                TelephonySubscription.this.signalStrengthListener = new SignalStrengthListener();
                try {
                    TelephonySubscription.this.telephonyManager.listen(TelephonySubscription.this.signalStrengthListener, 256);
                } catch (SecurityException e) {
                    StringBuilder L = a.L("exception while accessing signal strengths: ");
                    L.append(e.getMessage());
                    Logger.error(L.toString());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void unsubscribe() {
        try {
            this.telephonyManager.listen(this.signalStrengthListener, 0);
        } catch (SecurityException e) {
            StringBuilder L = a.L("exception while stopping signal strengths listen: ");
            L.append(e.getMessage());
            Logger.error(L.toString());
        }
    }

    public void cancel() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.telephony.TelephonySubscription.1
            @Override // java.lang.Runnable
            public void run() {
                TelephonySubscription.this.unsubscribe();
            }
        });
    }

    public native void telephonyNetworkInfoAvailable(GsmCellInfo gsmCellInfo);
}
