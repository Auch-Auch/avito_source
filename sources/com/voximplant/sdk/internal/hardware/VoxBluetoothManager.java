package com.voximplant.sdk.internal.hardware;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.voximplant.sdk.internal.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
public class VoxBluetoothManager {
    public final Context a;
    public final VoxAudioManager b;
    public final BluetoothProfile.ServiceListener bluetoothServiceListener;
    public final AudioManager c;
    public final Handler d;
    public int e;
    public d f;
    public BluetoothAdapter g;
    public BluetoothHeadset h;
    public BluetoothDevice i;
    public final BroadcastReceiver j;
    public final Runnable k = new Runnable() { // from class: a2.t.a.c.p0.r
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0098 A[Catch:{ RuntimeException -> 0x00c8 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x009f A[Catch:{ RuntimeException -> 0x00c8 }] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r4 = this;
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager r0 = com.voximplant.sdk.internal.hardware.VoxBluetoothManager.this
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r1 = r0.f
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r2 = com.voximplant.sdk.internal.hardware.VoxBluetoothManager.d.UNINITIALIZED
                if (r1 == r2) goto L_0x00e8
                android.bluetooth.BluetoothHeadset r1 = r0.h
                if (r1 != 0) goto L_0x000e
                goto L_0x00e8
            L_0x000e:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00c8 }
                r1.<init>()     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = "VoxBluetoothManager: bluetoothTimeout: BT state="
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r2 = r0.f     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = ", attempts: "
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                int r2 = r0.e     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = ", SCO is on: "
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                boolean r2 = r0.e()     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r1 = r1.toString()     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.Logger.d(r1)     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r1 = r0.f     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r2 = com.voximplant.sdk.internal.hardware.VoxBluetoothManager.d.SCO_CONNECTING     // Catch:{ RuntimeException -> 0x00c8 }
                if (r1 == r2) goto L_0x0042
                goto L_0x00e8
            L_0x0042:
                android.bluetooth.BluetoothHeadset r1 = r0.h     // Catch:{ RuntimeException -> 0x00c8 }
                java.util.List r1 = r1.getConnectedDevices()     // Catch:{ RuntimeException -> 0x00c8 }
                int r2 = r1.size()     // Catch:{ RuntimeException -> 0x00c8 }
                r3 = 0
                if (r2 <= 0) goto L_0x0095
                java.lang.Object r1 = r1.get(r3)     // Catch:{ RuntimeException -> 0x00c8 }
                android.bluetooth.BluetoothDevice r1 = (android.bluetooth.BluetoothDevice) r1     // Catch:{ RuntimeException -> 0x00c8 }
                r0.i = r1     // Catch:{ RuntimeException -> 0x00c8 }
                android.bluetooth.BluetoothHeadset r2 = r0.h     // Catch:{ RuntimeException -> 0x00c8 }
                boolean r1 = r2.isAudioConnected(r1)     // Catch:{ RuntimeException -> 0x00c8 }
                if (r1 == 0) goto L_0x007b
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00c8 }
                r1.<init>()     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = "VoxBluetoothManager: SCO connected with "
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                android.bluetooth.BluetoothDevice r2 = r0.i     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = r2.getName()     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r1 = r1.toString()     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.Logger.d(r1)     // Catch:{ RuntimeException -> 0x00c8 }
                r1 = 1
                goto L_0x0096
            L_0x007b:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00c8 }
                r1.<init>()     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = "VoxBluetoothManager: SCO is not connected with "
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                android.bluetooth.BluetoothDevice r2 = r0.i     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = r2.getName()     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r1 = r1.toString()     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.Logger.d(r1)     // Catch:{ RuntimeException -> 0x00c8 }
            L_0x0095:
                r1 = 0
            L_0x0096:
                if (r1 == 0) goto L_0x009f
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r1 = com.voximplant.sdk.internal.hardware.VoxBluetoothManager.d.SCO_CONNECTED     // Catch:{ RuntimeException -> 0x00c8 }
                r0.f = r1     // Catch:{ RuntimeException -> 0x00c8 }
                r0.e = r3     // Catch:{ RuntimeException -> 0x00c8 }
                goto L_0x00a7
            L_0x009f:
                java.lang.String r1 = "VoxBluetoothManager: BT failed to connect after timeout"
                com.voximplant.sdk.internal.Logger.w(r1)     // Catch:{ RuntimeException -> 0x00c8 }
                r0.g()     // Catch:{ RuntimeException -> 0x00c8 }
            L_0x00a7:
                java.lang.String r1 = "VoxBluetoothManager: updateAudioDeviceState"
                com.voximplant.sdk.internal.Logger.d(r1)     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.hardware.VoxAudioManager r1 = r0.b     // Catch:{ RuntimeException -> 0x00c8 }
                r1.d()     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x00c8 }
                r1.<init>()     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r2 = "VoxBluetoothManager: bluetoothTimeout done: BT state="
                r1.append(r2)     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.hardware.VoxBluetoothManager$d r0 = r0.f     // Catch:{ RuntimeException -> 0x00c8 }
                r1.append(r0)     // Catch:{ RuntimeException -> 0x00c8 }
                java.lang.String r0 = r1.toString()     // Catch:{ RuntimeException -> 0x00c8 }
                com.voximplant.sdk.internal.Logger.d(r0)     // Catch:{ RuntimeException -> 0x00c8 }
                goto L_0x00e8
            L_0x00c8:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "VoxBluetoothManager: bluetoothTimeout: failed due to exception: "
                r1.append(r2)
                r1.append(r0)
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()
                java.lang.String r0 = java.util.Arrays.toString(r0)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                com.voximplant.sdk.internal.Logger.e(r0)
            L_0x00e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.r.run():void");
        }
    };

    public class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VoxBluetoothManager.this.f != d.UNINITIALIZED) {
                String action = intent.getAction();
                if (action != null && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                    StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_CONNECTION_STATE_CHANGED, s=");
                    L.append(VoxBluetoothManager.b(VoxBluetoothManager.this, intExtra));
                    L.append(", sb=");
                    L.append(isInitialStickyBroadcast());
                    L.append(", BT state: ");
                    L.append(VoxBluetoothManager.this.f);
                    Logger.d(L.toString());
                    if (intExtra == 2) {
                        VoxBluetoothManager voxBluetoothManager = VoxBluetoothManager.this;
                        voxBluetoothManager.e = 0;
                        VoxBluetoothManager.a(voxBluetoothManager);
                    } else if (intExtra == 0) {
                        VoxBluetoothManager.this.g();
                        VoxBluetoothManager.a(VoxBluetoothManager.this);
                    }
                } else if (action != null && action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                    StringBuilder L2 = a2.b.a.a.a.L("VoxBluetoothManager: BluetoothHeadsetBroadcastReceiver.onReceive: a=ACTION_AUDIO_STATE_CHANGED, s=");
                    L2.append(VoxBluetoothManager.b(VoxBluetoothManager.this, intExtra2));
                    L2.append(", sb=");
                    L2.append(isInitialStickyBroadcast());
                    L2.append(", BT state: ");
                    L2.append(VoxBluetoothManager.this.f);
                    Logger.d(L2.toString());
                    if (intExtra2 == 12) {
                        VoxBluetoothManager.this.d();
                        if (VoxBluetoothManager.this.f == d.SCO_CONNECTING) {
                            Logger.d("VoxBluetoothManager: +++ Bluetooth audio SCO is now connected");
                            VoxBluetoothManager voxBluetoothManager2 = VoxBluetoothManager.this;
                            voxBluetoothManager2.f = d.SCO_CONNECTED;
                            voxBluetoothManager2.e = 0;
                            VoxBluetoothManager.a(voxBluetoothManager2);
                        } else {
                            Logger.w("VoxBluetoothManager: Unexpected state BluetoothHeadset.STATE_AUDIO_CONNECTED");
                        }
                    } else if (intExtra2 == 11) {
                        Logger.d("VoxBluetoothManager: +++ Bluetooth audio SCO is now connecting...");
                    } else if (intExtra2 == 10) {
                        Logger.d("VoxBluetoothManager: +++ Bluetooth audio SCO is now disconnected");
                        if (isInitialStickyBroadcast()) {
                            Logger.d("VoxBluetoothManager: Ignore STATE_AUDIO_DISCONNECTED initial sticky broadcast.");
                            return;
                        }
                        VoxBluetoothManager voxBluetoothManager3 = VoxBluetoothManager.this;
                        voxBluetoothManager3.f = d.HEADSET_AVAILABLE_AUDIO_DISCONNECTED;
                        voxBluetoothManager3.e = 0;
                        VoxBluetoothManager.a(voxBluetoothManager3);
                    }
                }
                StringBuilder L3 = a2.b.a.a.a.L("VoxBluetoothManager: onReceive done: BT state=");
                L3.append(VoxBluetoothManager.this.f);
                Logger.d(L3.toString());
            }
        }
    }

    public class c implements BluetoothProfile.ServiceListener {
        public c(a aVar) {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            if (i == 1 && VoxBluetoothManager.this.f != d.UNINITIALIZED) {
                StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: BluetoothServiceListener.onServiceConnected: BT state=");
                L.append(VoxBluetoothManager.this.f);
                Logger.d(L.toString());
                VoxBluetoothManager voxBluetoothManager = VoxBluetoothManager.this;
                voxBluetoothManager.h = (BluetoothHeadset) bluetoothProfile;
                Logger.d("VoxBluetoothManager: updateAudioDeviceState");
                voxBluetoothManager.b.d();
                Logger.d("VoxBluetoothManager: onServiceConnected done: BT state=" + VoxBluetoothManager.this.f);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            if (i == 1 && VoxBluetoothManager.this.f != d.UNINITIALIZED) {
                StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: BluetoothServiceListener.onServiceDisconnected: BT state=");
                L.append(VoxBluetoothManager.this.f);
                Logger.d(L.toString());
                VoxBluetoothManager.this.g();
                VoxBluetoothManager voxBluetoothManager = VoxBluetoothManager.this;
                voxBluetoothManager.h = null;
                voxBluetoothManager.i = null;
                voxBluetoothManager.f = d.HEADSET_UNAVAILABLE;
                Logger.d("VoxBluetoothManager: updateAudioDeviceState");
                voxBluetoothManager.b.d();
                Logger.d("VoxBluetoothManager: onServiceDisconnected done: BT state=" + VoxBluetoothManager.this.f);
            }
        }
    }

    public enum d {
        UNINITIALIZED,
        ERROR,
        HEADSET_UNAVAILABLE,
        HEADSET_AVAILABLE,
        HEADSET_AVAILABLE_AUDIO_DISCONNECTED,
        SCO_DISCONNECTING,
        SCO_CONNECTING,
        SCO_CONNECTED
    }

    public VoxBluetoothManager(Context context, VoxAudioManager voxAudioManager) {
        Logger.d("VoxBluetoothManager: ctor");
        this.a = context;
        this.b = voxAudioManager;
        this.c = (AudioManager) context.getSystemService("audio");
        this.f = d.UNINITIALIZED;
        this.bluetoothServiceListener = new c(null);
        this.j = new b(null);
        this.d = new Handler(Looper.getMainLooper());
    }

    public static void a(VoxBluetoothManager voxBluetoothManager) {
        Objects.requireNonNull(voxBluetoothManager);
        Logger.d("VoxBluetoothManager: updateAudioDeviceState");
        voxBluetoothManager.b.d();
    }

    public static String b(VoxBluetoothManager voxBluetoothManager, int i2) {
        Objects.requireNonNull(voxBluetoothManager);
        if (i2 == 0) {
            return "BT_DISCONNECTED";
        }
        if (i2 == 1) {
            return "BT_CONNECTING";
        }
        if (i2 == 2) {
            return "BT_CONNECTED";
        }
        if (i2 == 3) {
            return "BT_DISCONNECTING";
        }
        switch (i2) {
            case 10:
                return "BT_AUDIO_DISCONNECTED";
            case 11:
                return "BT_AUDIO_CONNECTING";
            case 12:
                return "BT_AUDIO_CONNECTED";
            default:
                return "BT_INVALID";
        }
    }

    public final String c(int i2) {
        if (i2 == 0) {
            return "BA_DISCONNECTED";
        }
        if (i2 == 1) {
            return "BA_CONNECTING";
        }
        if (i2 == 2) {
            return "BA_CONNECTED";
        }
        if (i2 == 3) {
            return "BA_DISCONNECTING";
        }
        switch (i2) {
            case 10:
                return "BA_OFF";
            case 11:
                return "BA_TURNING_ON";
            case 12:
                return "BA_ON";
            case 13:
                return "BA_TURNING_OFF";
            default:
                return "BA_INVALID";
        }
    }

    public final void d() {
        Logger.d("VoxBluetoothManager: cancelTimer");
        this.d.removeCallbacks(this.k);
    }

    public final boolean e() {
        return this.c.isBluetoothScoOn();
    }

    @SuppressLint({"HardwareIds"})
    public final void f(BluetoothAdapter bluetoothAdapter) {
        StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: BluetoothAdapter: enabled=");
        L.append(bluetoothAdapter.isEnabled());
        L.append(", state=");
        L.append(c(bluetoothAdapter.getState()));
        L.append(", name=");
        L.append(bluetoothAdapter.getName());
        L.append(", address=");
        L.append(bluetoothAdapter.getAddress());
        Logger.d(L.toString());
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if (!bondedDevices.isEmpty()) {
            Logger.d("VoxBluetoothManager: paired devices:");
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                StringBuilder L2 = a2.b.a.a.a.L("VoxBluetoothManager:  name=");
                L2.append(bluetoothDevice.getName());
                L2.append(", address=");
                L2.append(bluetoothDevice.getAddress());
                Logger.d(L2.toString());
            }
        }
    }

    public void g() {
        this.e = 0;
        d dVar = this.f;
        if (dVar == d.SCO_CONNECTING || dVar == d.SCO_CONNECTED) {
            try {
                Logger.d("VoxBluetoothManager: stopScoAudio: BT state=" + this.f + ", SCO is on: " + e());
                d();
                this.c.stopBluetoothSco();
                this.c.setBluetoothScoOn(false);
                this.f = d.SCO_DISCONNECTING;
                Logger.d("VoxBluetoothManager: stopScoAudio done: BT state=" + this.f + ", SCO is on: " + e());
            } catch (RuntimeException e2) {
                Logger.e("VoxBluetoothManager: stopScoAudio: failed due to exception: " + e2 + Arrays.toString(e2.getStackTrace()));
            }
        } else {
            StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: stopScoAudio: skip due to invalid state ");
            L.append(this.f);
            Logger.d(L.toString());
        }
    }

    public List<BluetoothDevice> getConnectedBluetoothDevices() {
        return this.h.getConnectedDevices();
    }

    public d getState() {
        return this.f;
    }

    public void h() {
        if (this.f != d.UNINITIALIZED && this.h != null) {
            Logger.d("VoxBluetoothManager: updateDevice");
            List<BluetoothDevice> connectedBluetoothDevices = getConnectedBluetoothDevices();
            if (connectedBluetoothDevices.isEmpty()) {
                this.i = null;
                this.f = d.HEADSET_UNAVAILABLE;
                Logger.d("VoxBluetoothManager: No connected bluetooth headset");
            } else {
                BluetoothDevice bluetoothDevice = connectedBluetoothDevices.get(0);
                this.i = bluetoothDevice;
                this.f = d.HEADSET_AVAILABLE;
                if (!(bluetoothDevice == null || this.h == null)) {
                    StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: Connected bluetooth headset: name=");
                    L.append(this.i.getName());
                    L.append(", state=");
                    L.append(c(this.h.getConnectionState(this.i)));
                    L.append(", SCO audio=");
                    L.append(this.h.isAudioConnected(this.i));
                    Logger.d(L.toString());
                }
            }
            StringBuilder L2 = a2.b.a.a.a.L("VoxBluetoothManager: updateDevice done: BT state=");
            L2.append(this.f);
            Logger.d(L2.toString());
        }
    }

    public void start() {
        Logger.d("VoxBluetoothManager: start");
        if (!(this.a.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0)) {
            StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: Process (pid=");
            L.append(Process.myPid());
            L.append(") lacks BLUETOOTH permission");
            Logger.w(L.toString());
        } else if (this.f != d.UNINITIALIZED) {
            Logger.w("VoxBluetoothManager: Invalid BT state");
        } else {
            this.h = null;
            this.i = null;
            this.e = 0;
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                this.g = defaultAdapter;
                if (defaultAdapter == null) {
                    Logger.w("VoxBluetoothManager: Device does not support Bluetooth");
                } else if (!this.c.isBluetoothScoAvailableOffCall()) {
                    Logger.e("VoxBluetoothManager: Bluetooth SCO audio is not available off call");
                } else {
                    f(this.g);
                    if (!this.g.getProfileProxy(this.a, this.bluetoothServiceListener, 1)) {
                        Logger.e("VoxBluetoothManager: BluetoothAdapter.getProfileProxy(HEADSET) failed");
                        return;
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                    intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                    this.a.registerReceiver(this.j, intentFilter);
                    Logger.d("VoxBluetoothManager: HEADSET profile state: " + c(this.g.getProfileConnectionState(1)));
                    Logger.d("VoxBluetoothManager: Bluetooth proxy for headset profile has started");
                    this.f = d.HEADSET_UNAVAILABLE;
                    Logger.d("VoxBluetoothManager: start done: BT state=" + this.f);
                }
            } catch (RuntimeException e2) {
                Logger.e("VoxBluetoothManager: start: failed due to exception: " + e2 + Arrays.toString(e2.getStackTrace()));
            }
        }
    }
}
