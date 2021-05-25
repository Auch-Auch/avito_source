package org.webrtc;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.webrtc.VideoFrame;
public class CustomCapturerAndroid implements VideoCapturer, VideoSink {
    private static final String TAG = "CustomCapturerAndroid";
    private CapturerObserver capturerObserver;
    private boolean isDisposed;
    @Nullable
    private CustomCapturerAndroidListener listener;
    private Handler mCapturerHandler = new Handler();
    private SurfaceTextureHelper mSurfaceTextureHelper;
    private YuvConverter mYuvConverter = new YuvConverter();

    public interface CustomCapturerAndroidListener {
        void onStarted();

        void onStopped();
    }

    public CustomCapturerAndroid(CustomCapturerAndroidListener customCapturerAndroidListener) {
        Logging.d(TAG, TAG);
        this.listener = customCapturerAndroidListener;
    }

    private VideoFrame.Buffer copyI420Buffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        int i5 = i / 2;
        int i6 = (i * i2) + 0;
        int i7 = (i2 / 2) * i5;
        int i8 = i6 + i7;
        int i9 = i7 + i8;
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i3, i4);
        ByteBuffer dataY = allocate.getDataY();
        byteBuffer.position(0);
        byteBuffer.limit(i6);
        dataY.put(byteBuffer);
        ByteBuffer dataU = allocate.getDataU();
        byteBuffer.position(i6);
        byteBuffer.limit(i8);
        dataU.put(byteBuffer);
        int i10 = i2 % 2;
        if (i10 != 0) {
            byteBuffer.position(i8 - i5);
            dataU.put(byteBuffer);
        }
        ByteBuffer dataV = allocate.getDataV();
        byteBuffer.position(i8);
        byteBuffer.limit(i9);
        dataV.put(byteBuffer);
        if (i10 != 0) {
            byteBuffer.position(i9 - i5);
            dataV.put(byteBuffer);
        }
        return allocate;
    }

    public synchronized void addFrame(byte[] bArr, int i, int i2) throws IllegalArgumentException {
        if (!this.isDisposed) {
            this.capturerObserver.onFrameCaptured(new VideoFrame(copyI420Buffer(ByteBuffer.wrap(bArr), i, i2, i, i2), 0, TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime())));
        } else {
            Logging.e(TAG, "addFrame failed: capturer is disposed");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i, int i2, int i3) {
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void dispose() {
        Logging.d(TAG, "dispose");
        this.isDisposed = true;
        this.listener = null;
        this.mSurfaceTextureHelper = null;
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver2) {
        Logging.d(TAG, "initialize: surfaceTextureHelper = " + surfaceTextureHelper + " capturerObserver = " + capturerObserver2);
        if (this.isDisposed || capturerObserver2 == null) {
            throw new RuntimeException("Capturer is disposed or capturerObserver not set.");
        }
        this.capturerObserver = capturerObserver2;
        this.mSurfaceTextureHelper = surfaceTextureHelper;
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        CapturerObserver capturerObserver2 = this.capturerObserver;
        if (capturerObserver2 != null) {
            capturerObserver2.onFrameCaptured(videoFrame);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3) {
        Logging.d(TAG, "startCapture: ");
        if (!this.isDisposed) {
            CapturerObserver capturerObserver2 = this.capturerObserver;
            if (capturerObserver2 != null) {
                capturerObserver2.onCapturerStarted(true);
            }
            SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.startListening(this);
            }
            CustomCapturerAndroidListener customCapturerAndroidListener = this.listener;
            if (customCapturerAndroidListener != null) {
                customCapturerAndroidListener.onStarted();
            }
        } else {
            Logging.e(TAG, "startCapture failed: capturer is diposed on listener is null");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void stopCapture() {
        Logging.d(TAG, "stopCapture: ");
        if (this.isDisposed) {
            Logging.e(TAG, "stopCapture failed: capturer is diposed on listener is null");
            return;
        }
        SurfaceTextureHelper surfaceTextureHelper = this.mSurfaceTextureHelper;
        if (surfaceTextureHelper != null && surfaceTextureHelper.isTextureInUse()) {
            this.mSurfaceTextureHelper.stopListening();
        }
        CapturerObserver capturerObserver2 = this.capturerObserver;
        if (capturerObserver2 != null) {
            capturerObserver2.onCapturerStopped();
        }
        CustomCapturerAndroidListener customCapturerAndroidListener = this.listener;
        if (customCapturerAndroidListener != null) {
            customCapturerAndroidListener.onStopped();
        }
    }

    public synchronized void addFrame(int i, int i2, int i3) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(i);
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        surfaceTexture.release();
        this.capturerObserver.onFrameCaptured(new VideoFrame(new TextureBufferImpl(i2, i3, VideoFrame.TextureBuffer.Type.RGB, i, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.mCapturerHandler, this.mYuvConverter, (Runnable) null), 0, TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime())));
    }
}
