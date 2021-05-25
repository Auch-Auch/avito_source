package com.voximplant.sdk.internal.hardware;

import a2.b.a.a.a;
import a2.t.a.c.p0.l;
import a2.t.a.c.p0.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.voximplant.sdk.hardware.AudioDevice;
import com.voximplant.sdk.hardware.IAudioDeviceEventsListener;
import com.voximplant.sdk.hardware.IAudioFocusChangeListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.hardware.VoxAudioManager;
import com.voximplant.sdk.internal.hardware.VoxBluetoothManager;
import com.voximplant.sdk.internal.utils.VoxImplantUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
public class VoxAudioManager {
    public static VoxAudioManager t;
    public Context a = null;
    public AudioManager b;
    public b c;
    public int d = -2;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public AudioDevice h;
    public AudioDevice i;
    public AudioDevice j;
    public VoxBluetoothManager k;
    public List<AudioDevice> l = new ArrayList();
    public BroadcastReceiver m;
    public AudioManager.OnAudioFocusChangeListener n;
    public final Handler o;
    public IAudioFocusChangeListener p;
    public CopyOnWriteArrayList<IAudioDeviceEventsListener> q = new CopyOnWriteArrayList<>();
    public t r = new t();
    public boolean s = false;

    public enum b {
        UNINITIALIZED,
        PREINITIALIZED,
        RUNNING
    }

    public class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            int intExtra = intent.getIntExtra("state", 0);
            int intExtra2 = intent.getIntExtra("microphone", 0);
            String stringExtra = intent.getStringExtra("name");
            StringBuilder L = a2.b.a.a.a.L("VoxAudioManager: WiredHeadsetReceiver.onReceive");
            L.append(VoxImplantUtils.getThreadInfo());
            L.append(": a=");
            L.append(intent.getAction());
            L.append(", s=");
            L.append(intExtra == 0 ? "unplugged" : "plugged");
            L.append(", m=");
            a2.b.a.a.a.n1(L, intExtra2 == 1 ? "mic" : "no mic", ", n=", stringExtra, ", sb=");
            L.append(isInitialStickyBroadcast());
            Logger.d(L.toString());
            VoxAudioManager voxAudioManager = VoxAudioManager.this;
            if (intExtra == 1) {
                z = true;
            }
            voxAudioManager.g = z;
            voxAudioManager.d();
        }
    }

    public VoxAudioManager() {
        Logger.d("VoxAudioManager: ctor");
        this.o = new Handler(Looper.getMainLooper());
        this.m = new c(null);
        this.c = b.UNINITIALIZED;
        this.h = AudioDevice.EARPIECE;
        StringBuilder L = a2.b.a.a.a.L("VoxAudioManager: mDefaultAudioDevice: ");
        L.append(this.h);
        Logger.d(L.toString());
        VoxImplantUtils.logDeviceInfo();
    }

    public static synchronized VoxAudioManager getInstance() {
        VoxAudioManager voxAudioManager;
        synchronized (VoxAudioManager.class) {
            if (t == null) {
                t = new VoxAudioManager();
            }
            voxAudioManager = t;
        }
        return voxAudioManager;
    }

    public final boolean a() {
        boolean z;
        if (Build.VERSION.SDK_INT < 23) {
            return this.b.isWiredHeadsetOn();
        }
        boolean isWiredHeadsetOn = this.b.isWiredHeadsetOn();
        AudioDeviceInfo[] devices = this.b.getDevices(3);
        if (devices == null || devices.length == 0) {
            z = false;
        } else {
            z = false;
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                int type = audioDeviceInfo.getType();
                StringBuilder L = a2.b.a.a.a.L("VoxAudioManager: hasWiredHeadset: audio device: ");
                L.append(audioDeviceInfo.getType());
                Logger.v(L.toString());
                if (type == 3) {
                    Logger.d("VoxAudioManager: hasWiredHeadset: found wired headset");
                } else if (type == 11) {
                    Logger.d("VoxAudioManager: hasWiredHeadset: found USB audio device");
                }
                z = true;
            }
        }
        Logger.i("VoxAudioManager: hasWiredHeadset: check by deprecated api: " + isWiredHeadsetOn + ", check by new api: " + z);
        if (isWiredHeadsetOn || z) {
            return true;
        }
        return false;
    }

    public final void b(AudioDevice audioDevice) {
        Logger.d("VoxAudioManager: setAudioDeviceInternal(device=" + audioDevice + ")");
        try {
            VoxImplantUtils.assertIsTrue(this.l.contains(audioDevice));
            if (this.c == b.RUNNING) {
                int ordinal = audioDevice.ordinal();
                if (ordinal == 0) {
                    c(false);
                } else if (ordinal == 1) {
                    c(false);
                } else if (ordinal == 3) {
                    c(true);
                } else if (ordinal != 4) {
                    Logger.e("VoxAudioManager: setAudioDeviceInternal: Invalid audio device selection");
                } else {
                    c(false);
                }
            } else {
                Logger.i("VoxAudioManager: setAudioDeviceInternal: audio device will be activate on call start");
                this.s = true;
            }
            this.i = audioDevice;
        } catch (AssertionError unused) {
            Logger.e("VoxAudioManager: setAudioDeviceInternal: device " + audioDevice + " is not available, setting default device");
        }
    }

    public final void c(boolean z) {
        if (this.b.isSpeakerphoneOn() != z) {
            this.b.setSpeakerphoneOn(z);
        }
    }

    public void d() {
        this.o.post(new Runnable() { // from class: a2.t.a.c.p0.p
            /* JADX WARNING: Removed duplicated region for block: B:84:0x0273  */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x027e  */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x02ac  */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x02f7  */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 782
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.p.run():void");
            }
        });
    }

    public void initialize(Context context) {
        Logger.d("VoxAudioManager: initialize");
        if (this.a == null) {
            this.a = context;
            this.b = (AudioManager) context.getSystemService("audio");
            StringBuilder L = a2.b.a.a.a.L("VoxBluetoothManager: create");
            L.append(VoxImplantUtils.getThreadInfo());
            Logger.d(L.toString());
            this.k = new VoxBluetoothManager(context, this);
        }
        AudioDevice audioDevice = AudioDevice.NONE;
        this.j = audioDevice;
        this.i = audioDevice;
        this.l.clear();
        d();
        this.c = b.PREINITIALIZED;
    }

    public void setDefaultAudioDevice(AudioDevice audioDevice) {
        this.o.post(new Runnable(audioDevice) { // from class: a2.t.a.c.p0.m
            public final /* synthetic */ AudioDevice b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VoxAudioManager voxAudioManager = VoxAudioManager.this;
                AudioDevice audioDevice2 = this.b;
                Objects.requireNonNull(voxAudioManager);
                int ordinal = audioDevice2.ordinal();
                if (ordinal != 1) {
                    if (ordinal != 3) {
                        Logger.e("VoxAudioManager: Invalid default audio device selection");
                    } else {
                        voxAudioManager.h = audioDevice2;
                    }
                } else if (voxAudioManager.a.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
                    voxAudioManager.h = audioDevice2;
                } else {
                    voxAudioManager.h = AudioDevice.SPEAKER;
                }
                StringBuilder L = a.L("VoxAudioManager: setDefaultAudioDevice(device=");
                L.append(voxAudioManager.h);
                L.append(")");
                Logger.d(L.toString());
                voxAudioManager.d();
            }
        });
    }

    public void setupAudioForCall() {
        l lVar = new AudioManager.OnAudioFocusChangeListener() { // from class: a2.t.a.c.p0.l
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i2) {
                VoxAudioManager voxAudioManager = VoxAudioManager.this;
                Objects.requireNonNull(voxAudioManager);
                String str = i2 != -3 ? i2 != -2 ? i2 != -1 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "AUDIOFOCUS_INVALID" : "AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE" : "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK" : "AUDIOFOCUS_GAIN_TRANSIENT" : "AUDIOFOCUS_GAIN" : "AUDIOFOCUS_LOSS" : "AUDIOFOCUS_LOSS_TRANSIENT" : "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
                Logger.d("VoxAudioManager: onAudioFocusChange: " + str);
                IAudioFocusChangeListener iAudioFocusChangeListener = voxAudioManager.p;
                if (iAudioFocusChangeListener != null) {
                    iAudioFocusChangeListener.onAudioFocusChange(i2);
                }
            }
        };
        this.n = lVar;
        if (this.b.requestAudioFocus(lVar, 0, 2) == 1) {
            Logger.d("VoxAudioManager: setupAudioForCall: Audio focus request granted for VOICE_CALL streams");
        } else {
            Logger.e("VoxAudioManager: setupAudioForCall: Audio focus request failed");
        }
        this.b.setMode(3);
        if (this.b.isMicrophoneMute()) {
            this.b.setMicrophoneMute(false);
        }
    }

    public void start(boolean z) {
        Logger.d("VoxAudioManager: start");
        b bVar = this.c;
        b bVar2 = b.RUNNING;
        if (bVar == bVar2) {
            Logger.e("VoxAudioManager: AudioManager is already active");
            return;
        }
        Logger.d("VoxAudioManager: AudioManager starts...");
        this.c = bVar2;
        this.d = this.b.getMode();
        this.e = this.b.isSpeakerphoneOn();
        this.f = this.b.isMicrophoneMute();
        StringBuilder L = a2.b.a.a.a.L("VoxAudioManager: start: speaker is on: ");
        L.append(this.e);
        L.append(", mic is muted: ");
        L.append(this.f);
        L.append(", audio mode is: ");
        L.append(this.d);
        Logger.i(L.toString());
        this.g = a();
        VoxBluetoothManager voxBluetoothManager = this.k;
        if (voxBluetoothManager != null) {
            voxBluetoothManager.h();
        }
        if (z) {
            setupAudioForCall();
        }
        this.r.a = true;
        d();
        Logger.d("VoxAudioManager: AudioManager started");
    }

    public void startHeadsetMonitoring() {
        Logger.i("VoxAudioManager: startHeadsetMonitoring");
        this.o.post(new Runnable() { // from class: a2.t.a.c.p0.q
            @Override // java.lang.Runnable
            public final void run() {
                VoxAudioManager voxAudioManager = VoxAudioManager.this;
                voxAudioManager.a.registerReceiver(voxAudioManager.m, new IntentFilter("android.intent.action.HEADSET_PLUG"));
                VoxBluetoothManager voxBluetoothManager = voxAudioManager.k;
                if (voxBluetoothManager != null) {
                    voxBluetoothManager.start();
                }
            }
        });
    }

    public void stop() {
        Logger.d("VoxAudioManager: stop");
        if (this.c != b.RUNNING) {
            StringBuilder L = a2.b.a.a.a.L("VoxAudioManager: Trying to stop AudioManager in incorrect state: ");
            L.append(this.c);
            Logger.e(L.toString());
            return;
        }
        VoxBluetoothManager voxBluetoothManager = this.k;
        if (voxBluetoothManager != null) {
            voxBluetoothManager.g();
            this.k.h();
        }
        this.c = b.PREINITIALIZED;
        c(this.e);
        boolean z = this.f;
        if (this.b.isMicrophoneMute() != z) {
            this.b.setMicrophoneMute(z);
        }
        this.b.setMode(this.d);
        Logger.i("VoxAudioManager: stop: speaker was on: " + this.e + ", mic was muted: " + this.f + ", audio mode was: " + this.d);
        t tVar = this.r;
        tVar.a = false;
        AudioDevice audioDevice = AudioDevice.NONE;
        this.j = audioDevice;
        Logger.i("AudioDeviceComparator: setUserSelectedAudioDevice: " + audioDevice);
        tVar.b = audioDevice;
        this.b.abandonAudioFocus(this.n);
        Logger.d("VoxAudioManager: Abandoned audio focus for VOICE_CALL streams");
        this.n = null;
        Logger.d("VoxAudioManager: AudioManager stopped");
    }

    public void stopHeadsetMonitoring() {
        Logger.i("VoxAudioManager: stopHeadsetMonitoring");
        this.o.post(new Runnable() { // from class: a2.t.a.c.p0.o
            @Override // java.lang.Runnable
            public final void run() {
                VoxAudioManager voxAudioManager = VoxAudioManager.this;
                try {
                    voxAudioManager.a.unregisterReceiver(voxAudioManager.m);
                } catch (IllegalArgumentException e2) {
                    StringBuilder L = a.L("VoxAudioManager: unregisterReceiver: ");
                    L.append(e2.getMessage());
                    Logger.e(L.toString());
                }
                VoxBluetoothManager voxBluetoothManager = voxAudioManager.k;
                if (voxBluetoothManager != null) {
                    voxBluetoothManager.d.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002a: INVOKE  
                          (wrap: android.os.Handler : 0x0023: IGET  (r1v1 android.os.Handler) = (r0v1 'voxBluetoothManager' com.voximplant.sdk.internal.hardware.VoxBluetoothManager) com.voximplant.sdk.internal.hardware.VoxBluetoothManager.d android.os.Handler)
                          (wrap: a2.t.a.c.p0.s : 0x0027: CONSTRUCTOR  (r2v0 a2.t.a.c.p0.s) = (r0v1 'voxBluetoothManager' com.voximplant.sdk.internal.hardware.VoxBluetoothManager) call: a2.t.a.c.p0.s.<init>(com.voximplant.sdk.internal.hardware.VoxBluetoothManager):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: a2.t.a.c.p0.o.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: CONSTRUCTOR  (r2v0 a2.t.a.c.p0.s) = (r0v1 'voxBluetoothManager' com.voximplant.sdk.internal.hardware.VoxBluetoothManager) call: a2.t.a.c.p0.s.<init>(com.voximplant.sdk.internal.hardware.VoxBluetoothManager):void type: CONSTRUCTOR in method: a2.t.a.c.p0.o.run():void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 23 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.t.a.c.p0.s, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                        	... 29 more
                        */
                    /*
                        this = this;
                        com.voximplant.sdk.internal.hardware.VoxAudioManager r0 = com.voximplant.sdk.internal.hardware.VoxAudioManager.this
                        android.content.BroadcastReceiver r1 = r0.m
                        android.content.Context r2 = r0.a     // Catch:{ IllegalArgumentException -> 0x000a }
                        r2.unregisterReceiver(r1)     // Catch:{ IllegalArgumentException -> 0x000a }
                        goto L_0x001f
                    L_0x000a:
                        r1 = move-exception
                        java.lang.String r2 = "VoxAudioManager: unregisterReceiver: "
                        java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
                        java.lang.String r1 = r1.getMessage()
                        r2.append(r1)
                        java.lang.String r1 = r2.toString()
                        com.voximplant.sdk.internal.Logger.e(r1)
                    L_0x001f:
                        com.voximplant.sdk.internal.hardware.VoxBluetoothManager r0 = r0.k
                        if (r0 == 0) goto L_0x002d
                        android.os.Handler r1 = r0.d
                        a2.t.a.c.p0.s r2 = new a2.t.a.c.p0.s
                        r2.<init>(r0)
                        r1.post(r2)
                    L_0x002d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.t.a.c.p0.o.run():void");
                }
            });
        }
    }
