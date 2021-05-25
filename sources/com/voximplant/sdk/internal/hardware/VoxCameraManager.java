package com.voximplant.sdk.internal.hardware;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Build;
import com.voximplant.sdk.hardware.CameraResolution;
import com.voximplant.sdk.hardware.ICameraEventsListener;
import com.voximplant.sdk.hardware.ICameraManager;
import com.voximplant.sdk.hardware.VideoQuality;
import com.voximplant.sdk.internal.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.EglBase;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoSource;
public class VoxCameraManager implements ICameraManager, CameraVideoCapturer.CameraEventsHandler, CameraVideoCapturer.CameraSwitchHandler {
    public static VoxCameraManager n;
    public Context a;
    public CameraVideoCapturer b;
    public VideoSource c;
    public CopyOnWriteArrayList<ICameraEventsListener> d = new CopyOnWriteArrayList<>();
    public int e = 0;
    public int f = 1;
    public int g = -1;
    public int h = 640;
    public int i = 480;
    public int j = 0;
    public boolean k;
    public SurfaceTextureHelper l;
    public final String[] m = {"GT-I9300", "GT-I9300T", "GT-I9305", "GT-I9305N", "GT-I9305T", "SHV-E210K", "SHV-E210L", "SHV-E210S", "SGH-T999", "SGH-T999L", "SGH-T999v", "SGH-T999Lv", "SGH-I747", "SGH-I747m", "SGH-N064", "SC-06D", "SGH-N035", "SC-03E", "SCH-J021", "SCL21", "SCH-R530", "SCH-I535", "SCH-S960L", "SCH-S968C", "GT-I9308", "SCH-I939", "GT-I9301I", "Nexus 7"};

    public VoxCameraManager(Context context) {
        this.a = context;
    }

    public static synchronized VoxCameraManager getInstance(Context context) {
        VoxCameraManager voxCameraManager;
        synchronized (VoxCameraManager.class) {
            if (n == null) {
                n = new VoxCameraManager(context);
            }
            voxCameraManager = n;
        }
        return voxCameraManager;
    }

    public final CameraVideoCapturer a(CameraEnumerator cameraEnumerator) {
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        int i2 = 0;
        if (this.f == 1) {
            int length = deviceNames.length;
            while (i2 < length) {
                String str = deviceNames[i2];
                if (cameraEnumerator.isFrontFacing(str)) {
                    Logger.i("VoxCameraManager: creating front facing capturer");
                    CameraVideoCapturer createCapturer = cameraEnumerator.createCapturer(str, this);
                    Logger.i("VoxCameraManager: front facing capturer is created");
                    return createCapturer;
                }
                i2++;
            }
        } else {
            int length2 = deviceNames.length;
            while (i2 < length2) {
                String str2 = deviceNames[i2];
                if (!cameraEnumerator.isFrontFacing(str2)) {
                    Logger.i("VoxCameraManager: creating back facing capturer");
                    CameraVideoCapturer createCapturer2 = cameraEnumerator.createCapturer(str2, this);
                    Logger.i("VoxCameraManager: back facing capturer is created");
                    return createCapturer2;
                }
                i2++;
            }
        }
        Logger.e("VoxCameraManager: createCameraCapture: failed to create camera capture, requested camera does not exist");
        return null;
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public void addCameraEventsListener(ICameraEventsListener iCameraEventsListener) {
        this.d.add(iCameraEventsListener);
    }

    public final CameraVideoCapturer b(Context context) {
        if (this.b != null) {
            Logger.w("VoxCameraManager: videoCapture already exists");
        } else {
            boolean contains = Arrays.asList(this.m).contains(Build.MODEL);
            if (contains) {
                Logger.i("VoxCameraManager: createVideoCapturer: using camera1enumerator, captureToTexture = false, blacklisted = " + contains);
                this.b = a(new Camera1Enumerator(false));
            } else if (Camera2Enumerator.isSupported(context)) {
                Logger.i("VoxCameraManager: createVideoCapturer: using camera2enumerator");
                this.b = a(new Camera2Enumerator(context));
            } else {
                Logger.i("VoxCameraManager: createVideoCapturer: using camera1enumerator, captureToTexture = true");
                this.b = a(new Camera1Enumerator(true));
            }
        }
        return this.b;
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public void enableCameraFlash(boolean z) {
        Logger.i("VoxCameraManager: enableCameraFlash: " + z);
        this.k = z;
        if (this.j == 2) {
            this.b.enableFlash(z);
        }
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public String[] getCameraDeviceNames() {
        if (Camera2Enumerator.isSupported(this.a)) {
            return new Camera2Enumerator(this.a).getDeviceNames();
        }
        return new Camera1Enumerator().getDeviceNames();
    }

    public int getCameraIndex() {
        return this.f;
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public List<CameraResolution> getCameraSupportedResolutions(String str) {
        List<CameraEnumerationAndroid.CaptureFormat> list;
        if (Camera2Enumerator.isSupported(this.a)) {
            list = new Camera2Enumerator(this.a).getSupportedFormats(str);
        } else {
            list = new Camera1Enumerator().getSupportedFormats(str);
        }
        ArrayList arrayList = new ArrayList();
        for (CameraEnumerationAndroid.CaptureFormat captureFormat : list) {
            arrayList.add(new CameraResolution(captureFormat.width, captureFormat.height));
        }
        return arrayList;
    }

    public synchronized VideoSource getCameraVideoSource(PeerConnectionFactory peerConnectionFactory, EglBase eglBase) {
        this.l = SurfaceTextureHelper.create("CaptureThread", eglBase.getEglBaseContext());
        CameraVideoCapturer b2 = b(this.a);
        this.b = b2;
        if (this.c == null && b2 != null) {
            VideoSource createVideoSource = peerConnectionFactory.createVideoSource(false);
            this.c = createVideoSource;
            if (createVideoSource == null) {
                Logger.w("VoxCameraManager: getCameraVideoSource: camera video source is null");
                return null;
            }
            this.j = 1;
            this.b.initialize(this.l, this.a, createVideoSource.getCapturerObserver());
            startCapture();
        } else if (this.j == 4) {
            startCapture();
        }
        this.e++;
        return this.c;
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraClosed() {
        Logger.i("VoxCameraManager: onCameraClosed");
        int i2 = this.j;
        if (i2 != 3 && i2 != 4) {
            this.j = 0;
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraDisconnected() {
        Logger.i("VoxCameraManager: onCameraDisconnected");
        this.j = 0;
        Iterator<ICameraEventsListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onCameraDisconnected();
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraError(String str) {
        Logger.e("VoxCameraManager: onCameraError: " + str);
        this.j = 0;
        Iterator<ICameraEventsListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onCameraError(str);
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraFreezed(String str) {
        Logger.e("VoxCameraManager: onCameraFreezed: " + str);
        Iterator<ICameraEventsListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onCameraError(str);
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraOpening(String str) {
        Logger.i("VoxCameraManager: onCameraOpening: " + str);
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
    public void onCameraSwitchDone(boolean z) {
        Logger.i("VoxCameraManager: onCameraSwitchDone: front camera: " + z);
        Iterator<ICameraEventsListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onCameraSwitchDone(z);
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
    public void onCameraSwitchError(String str) {
        Logger.i("VoxCameraManager: onCameraSwitchError: error: " + str);
        Iterator<ICameraEventsListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onCameraSwitchError(str);
        }
    }

    @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onFirstFrameAvailable() {
        Logger.i("VoxCameraManager: onFirstFrameAvailable");
        this.j = 2;
        int i2 = this.g;
        if (i2 != -1) {
            setCamera(i2, this.h, this.i);
            this.g = -1;
        }
    }

    public synchronized void releaseCameraVideoSource() {
        Logger.i("VoxCameraManager: releaseCameraVideoSource");
        int i2 = this.e;
        if (i2 == 0) {
            Logger.i("VoxCameraManager: camera is not used");
        } else if (i2 == 1) {
            if (this.j != 0) {
                stopCapture();
                Logger.i("VoxCameraManager: releaseCamera");
                CameraVideoCapturer cameraVideoCapturer = this.b;
                if (cameraVideoCapturer != null) {
                    cameraVideoCapturer.dispose();
                    this.b = null;
                }
                Logger.i("VoxCameraManager: releaseCamera: done");
            }
            VideoSource videoSource = this.c;
            if (videoSource != null) {
                videoSource.dispose();
                this.c = null;
            }
            SurfaceTextureHelper surfaceTextureHelper = this.l;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.dispose();
                this.l = null;
            }
            this.e = 0;
            Logger.i("VoxCameraManager: camera video source is disposed");
        } else {
            this.e = i2 - 1;
            Logger.i("VoxCameraManager: do not dispose camera video source as it is used by another pc");
        }
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public void removeCameraEventsListener(ICameraEventsListener iCameraEventsListener) {
        this.d.remove(iCameraEventsListener);
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public void setCamera(int i2, int i3, int i4) {
        CameraVideoCapturer cameraVideoCapturer;
        StringBuilder N = a.N("VoxCameraManager: setCamera: mCameraIndex: ", i2, ", width: ", i3, ", height : ");
        N.append(i4);
        Logger.i(N.toString());
        if (i2 == 1 || i2 == 0) {
            if (this.f != i2) {
                int i5 = this.j;
                if (i5 == 2 && this.b != null) {
                    Logger.i("VoxCameraManager: setCamera: going to switch camera");
                    this.j = 3;
                    this.b.switchCamera(this);
                    this.f = i2;
                } else if (i5 == 1 || i5 == 3) {
                    Logger.i("VoxCameraManager: setCamera: camera is in opening state, will be switched once opened");
                    this.g = i2;
                } else {
                    Logger.i("VoxCameraManager: setCamera: camera is in idle state. Camera " + i2 + " will start on next call");
                    this.f = i2;
                }
            }
            if (this.i != i4 && this.h != i3) {
                this.h = i3;
                this.i = i4;
                if (this.j == 2 && (cameraVideoCapturer = this.b) != null) {
                    cameraVideoCapturer.changeCaptureFormat(i3, i4, 30, this.k);
                    return;
                }
                return;
            }
            return;
        }
        Logger.e("VoxCameraManager: setCamera: mCameraIndex = " + i2 + "is incorrect");
    }

    public synchronized boolean startCapture() {
        Logger.i("VoxCameraManager: startCapture");
        CameraVideoCapturer cameraVideoCapturer = this.b;
        if (cameraVideoCapturer != null && this.j != 2) {
            cameraVideoCapturer.startCapture(this.h, this.i, 30, this.k);
            this.j = 2;
            Logger.i("VoxCameraManager: startCapture - started successfully");
            return true;
        } else if (this.j != 2 || this.e <= 1) {
            Logger.w("VoxCameraManager: startCapture - failed to start, state: " + this.j);
            return false;
        } else {
            Logger.i("VoxCameraManager: startCapture: camera is running and used by another pc");
            return true;
        }
    }

    public synchronized void stopCapture() {
        Logger.i("VoxCameraManager: stopCapture, state: " + this.j);
        if (this.e > 1) {
            Logger.w("VoxCameraManager: stopCapture: camera is used by another pc");
            return;
        }
        CameraVideoCapturer cameraVideoCapturer = this.b;
        if (cameraVideoCapturer != null) {
            try {
                cameraVideoCapturer.stopCapture();
                this.j = 4;
                Logger.i("VoxCameraManager: stopCapture: successfully stopped");
            } catch (InterruptedException e2) {
                Logger.e("VoxCameraManager: stopCapture: failed to stop capture: " + e2.getMessage());
            }
        }
    }

    @Override // com.voximplant.sdk.hardware.ICameraManager
    public void setCamera(int i2, VideoQuality videoQuality) {
        Logger.i("VoxCameraManager: setCamera: mCameraIndex: " + i2 + ", quality: " + videoQuality);
        if (i2 == 1 || i2 == 0) {
            int ordinal = videoQuality.ordinal();
            if (ordinal == 0) {
                setCamera(i2, 320, 240);
            } else if (ordinal != 2) {
                setCamera(i2, 640, 480);
            } else {
                setCamera(i2, 1280, 720);
            }
        } else {
            Logger.e("VoxCameraManager: setCamera with quality: mCameraIndex = " + i2 + "is incorrect");
        }
    }
}
