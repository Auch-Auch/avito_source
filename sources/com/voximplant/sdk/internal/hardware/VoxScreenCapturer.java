package com.voximplant.sdk.internal.hardware;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import com.voximplant.sdk.internal.Logger;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.ScreenCapturerAndroid;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoSource;
public class VoxScreenCapturer {
    public static VoxScreenCapturer e;
    public Context a;
    public VideoSource b;
    public SurfaceTextureHelper c;
    public ScreenCapturerAndroid d;

    public class a extends MediaProjection.Callback {
        public a(VoxScreenCapturer voxScreenCapturer) {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            Logger.i("VoxScreenCapturer: onStop");
        }
    }

    public static synchronized VoxScreenCapturer getInstance() {
        VoxScreenCapturer voxScreenCapturer;
        synchronized (VoxScreenCapturer.class) {
            if (e == null) {
                e = new VoxScreenCapturer();
            }
            voxScreenCapturer = e;
        }
        return voxScreenCapturer;
    }

    public VideoSource getScreenSharingVideoSource(PeerConnectionFactory peerConnectionFactory, EglBase eglBase) {
        VideoSource createVideoSource = peerConnectionFactory.createVideoSource(true);
        this.b = createVideoSource;
        if (createVideoSource == null) {
            Logger.w("VoxScreenCapturer: getScreenSharingVideoSource: video source is null");
            return null;
        }
        SurfaceTextureHelper create = SurfaceTextureHelper.create("SharingThread", eglBase.getEglBaseContext());
        this.c = create;
        ScreenCapturerAndroid screenCapturerAndroid = this.d;
        if (screenCapturerAndroid != null) {
            screenCapturerAndroid.initialize(create, this.a, this.b.getCapturerObserver());
        }
        startCapture();
        return this.b;
    }

    public void initialize(Context context, Intent intent) {
        this.a = context;
        this.d = new ScreenCapturerAndroid(intent, new a(this), this.a);
    }

    public void startCapture() {
        try {
            ScreenCapturerAndroid screenCapturerAndroid = this.d;
            if (screenCapturerAndroid != null) {
                screenCapturerAndroid.startCapture(720, 1280, 0);
            }
        } catch (IllegalStateException unused) {
            Logger.w("VoxScreenCapturer: startCapture: already started");
        }
    }

    public void stopCapture() {
        try {
            ScreenCapturerAndroid screenCapturerAndroid = this.d;
            if (screenCapturerAndroid != null) {
                screenCapturerAndroid.stopCapture();
                this.d.dispose();
                this.d = null;
            }
            SurfaceTextureHelper surfaceTextureHelper = this.c;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.dispose();
                this.c = null;
            }
            VideoSource videoSource = this.b;
            if (videoSource != null) {
                videoSource.dispose();
                this.b = null;
            }
        } catch (RuntimeException unused) {
            Logger.w("VoxScreenCapturer: stopCapture: already stopped");
        }
    }
}
