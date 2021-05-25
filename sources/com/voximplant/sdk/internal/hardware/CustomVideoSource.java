package com.voximplant.sdk.internal.hardware;

import android.content.Context;
import com.voximplant.sdk.hardware.ICustomVideoSource;
import com.voximplant.sdk.hardware.ICustomVideoSourceListener;
import com.voximplant.sdk.internal.Logger;
import org.webrtc.CustomCapturerAndroid;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoSource;
public class CustomVideoSource implements ICustomVideoSource, CustomCapturerAndroid.CustomCapturerAndroidListener {
    public VideoSource a;
    public CustomCapturerAndroid b = new CustomCapturerAndroid(this);
    public ICustomVideoSourceListener c;
    public int d;
    public SurfaceTextureHelper e;

    public CustomVideoSource() {
        Logger.i("CustomVideoSource");
    }

    public void close(boolean z) {
        int i;
        Logger.i("CustomVideoSource: close");
        if (z || (i = this.d) == 1) {
            this.b.stopCapture();
            VideoSource videoSource = this.a;
            if (videoSource != null) {
                videoSource.dispose();
                this.a = null;
            }
            SurfaceTextureHelper surfaceTextureHelper = this.e;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.dispose();
                this.e = null;
            }
            this.d = 0;
            Logger.i("CustomVideoSource: close: custom video source is disposed");
        } else if (i > 0) {
            this.d = i - 1;
            Logger.i("CustomVideoSource: close: custom video source is used in other call(s)");
        }
    }

    public VideoSource getVideoSource(PeerConnectionFactory peerConnectionFactory, EglBase eglBase, Context context) {
        Logger.i("CustomVideoSource: getVideoSource");
        if (this.e == null) {
            this.e = SurfaceTextureHelper.create("CaptureThread", eglBase.getEglBaseContext());
        }
        if (this.a == null) {
            this.a = peerConnectionFactory.createVideoSource(false);
        }
        this.b.initialize(this.e, context, this.a.getCapturerObserver());
        this.b.startCapture(0, 0, 0);
        this.d++;
        return this.a;
    }

    @Override // org.webrtc.CustomCapturerAndroid.CustomCapturerAndroidListener
    public void onStarted() {
        Logger.i("CustomVideoSource: onStarted");
        ICustomVideoSourceListener iCustomVideoSourceListener = this.c;
        if (iCustomVideoSourceListener != null) {
            iCustomVideoSourceListener.onStarted();
        }
    }

    @Override // org.webrtc.CustomCapturerAndroid.CustomCapturerAndroidListener
    public void onStopped() {
        Logger.i("CustomVideoSource: onStopped");
        ICustomVideoSourceListener iCustomVideoSourceListener = this.c;
        if (iCustomVideoSourceListener != null) {
            iCustomVideoSourceListener.onStopped();
        }
    }

    @Override // com.voximplant.sdk.hardware.ICustomVideoSource
    public void release() {
        Logger.i("CustomVideoSource: release");
        close(true);
    }

    @Override // com.voximplant.sdk.hardware.ICustomVideoSource
    public void sendFrame(byte[] bArr, int i, int i2) {
        if (this.d == 0) {
            Logger.w("CustomVideoSource: sendFrame: video source is not connected to the call. Please ensure that this video source is set to the call via ICall.useCustomVideoSource(ICustomVideoSource) API");
        } else {
            this.b.addFrame(bArr, i, i2);
        }
    }

    @Override // com.voximplant.sdk.hardware.ICustomVideoSource
    public void setCustomVideoSourceListener(ICustomVideoSourceListener iCustomVideoSourceListener) {
        Logger.i("CustomVideoSource: setCustomVideoSourceListener: " + iCustomVideoSourceListener);
        this.c = iCustomVideoSourceListener;
    }

    @Override // com.voximplant.sdk.hardware.ICustomVideoSource
    public void setSurfaceTextureHelper(SurfaceTextureHelper surfaceTextureHelper) {
        this.e = surfaceTextureHelper;
    }

    @Override // com.voximplant.sdk.hardware.ICustomVideoSource
    public void sendFrame(int i, int i2, int i3) {
        if (this.d == 0) {
            Logger.w("CustomVideoSource: sendFrame: video source is not connected to the call. Please ensure that this video source is set to the call via ICall.useCustomVideoSource(ICustomVideoSource) API");
        } else {
            this.b.addFrame(i, i2, i3);
        }
    }
}
