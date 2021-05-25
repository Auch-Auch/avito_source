package com.voximplant.sdk.internal.call;

import a2.t.a.c.n0.i2;
import android.content.Context;
import android.os.Build;
import com.voximplant.sdk.internal.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.webrtc.DefaultVideoDecoderFactory;
import org.webrtc.DefaultVideoEncoderFactory;
import org.webrtc.EglBase;
import org.webrtc.Logging;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SoftwareVideoDecoderFactory;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoderFactory;
import org.webrtc.VideoEncoderFactory;
import org.webrtc.audio.AudioDeviceModule;
import org.webrtc.audio.JavaAudioDeviceModule;
import x6.f.n0;
public class PCFactoryWrapper {
    public static final String[] d = {"D6503", "ONE A2005", "MotoG3", "MI NOTE LTE", "D5803", "Pixel", "Pixel XL", "Redmi Note 3", "Redmi Note 4", "SM-G900F", "g3_kt_kr", "SM-G930F", "Xperia SP", "Nexus 6", "ONE E1003", "One"};
    public static final String[] e = {"Nexus 10", "Nexus 9", "ONE A2005"};
    public static final String[] f = {"LeEco Le2"};
    public PeerConnectionFactory a = null;
    public EglBase b = null;
    public ArrayList<String> c = new ArrayList<>();

    public static class PeerConnectionFactoryParameters {
        public final boolean a;
        public final EglBase b;

        public PeerConnectionFactoryParameters(boolean z, boolean z2, boolean z3, EglBase eglBase) {
            this.a = z;
            this.b = eglBase;
        }
    }

    public final void a(Context context, PeerConnectionFactoryParameters peerConnectionFactoryParameters) {
        i2 i2Var;
        VideoEncoderFactory videoEncoderFactory;
        VideoDecoderFactory videoDecoderFactory;
        PeerConnectionFactory.InitializationOptions.Builder fieldTrials = PeerConnectionFactory.InitializationOptions.builder(context).setEnableInternalTracer(true).setFieldTrials("WebRTC-IntelVP8/Enabled/");
        synchronized (i2.class) {
            if (i2.a == null) {
                i2.a = new i2();
            }
            i2Var = i2.a;
        }
        PeerConnectionFactory.initialize(fieldTrials.setInjectableLogger(i2Var, peerConnectionFactoryParameters.a ? Logging.Severity.LS_INFO : Logging.Severity.LS_WARNING).createInitializationOptions());
        Logger.d("pcFactoryWrapper: Create peer connection factory.");
        String[] strArr = f;
        List asList = Arrays.asList(strArr);
        String str = Build.MODEL;
        boolean z = !asList.contains(str) && !Arrays.asList(d).contains(str) && JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
        boolean z2 = !Arrays.asList(strArr).contains(str) && !Arrays.asList(e).contains(str) && JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
        Logger.d("pcFactoryWrapper: use hardware aec: " + z + ", use hardware NS: " + z2);
        EglBase eglBase = peerConnectionFactoryParameters.b;
        if (eglBase != null) {
            this.b = eglBase;
        } else {
            try {
                this.b = n0.a();
            } catch (RuntimeException unused) {
                Logger.e("pcFactoryWrapper: Failed to create EglBase, hardware acceleration is not available");
            }
        }
        AudioDeviceModule createAudioDeviceModule = JavaAudioDeviceModule.builder(context).setUseHardwareAcousticEchoCanceler(z).setUseHardwareNoiseSuppressor(z2).createAudioDeviceModule();
        EglBase eglBase2 = this.b;
        if (eglBase2 != null) {
            videoEncoderFactory = new DefaultVideoEncoderFactory(eglBase2.getEglBaseContext(), true, false);
        } else {
            videoEncoderFactory = new SoftwareVideoEncoderFactory();
        }
        EglBase eglBase3 = this.b;
        if (eglBase3 != null) {
            videoDecoderFactory = new DefaultVideoDecoderFactory(eglBase3.getEglBaseContext());
        } else {
            videoDecoderFactory = new SoftwareVideoDecoderFactory();
        }
        this.a = PeerConnectionFactory.builder().setAudioDeviceModule(createAudioDeviceModule).setVideoEncoderFactory(videoEncoderFactory).setVideoDecoderFactory(videoDecoderFactory).createPeerConnectionFactory();
        for (VideoCodecInfo videoCodecInfo : videoEncoderFactory.getSupportedCodecs()) {
            this.c.add(videoCodecInfo.name);
        }
        createAudioDeviceModule.release();
        Logger.d("pcFactoryWrapper: Peer connection factory created.");
    }

    public void closePeerConnectionFactory() {
        EglBase eglBase = this.b;
        if (eglBase != null) {
            eglBase.release();
            this.b = null;
        }
        PeerConnectionFactory peerConnectionFactory = this.a;
        if (peerConnectionFactory != null) {
            peerConnectionFactory.dispose();
            this.a = null;
        }
        PeerConnectionFactory.stopInternalTracingCapture();
        PeerConnectionFactory.shutdownInternalTracer();
    }

    public void createPeerConnectionFactory(Context context, PeerConnectionFactoryParameters peerConnectionFactoryParameters) {
        this.a = null;
        a(context, peerConnectionFactoryParameters);
    }

    public List<String> getSupportedVideoCodecs() {
        return Collections.unmodifiableList(this.c);
    }
}
