package com.otaliastudios.cameraview;
public class CameraException extends RuntimeException {
    public static final int REASON_DISCONNECTED = 3;
    public static final int REASON_FAILED_TO_CONNECT = 1;
    public static final int REASON_FAILED_TO_START_PREVIEW = 2;
    public static final int REASON_NO_CAMERA = 6;
    public static final int REASON_PICTURE_FAILED = 4;
    public static final int REASON_UNKNOWN = 0;
    public static final int REASON_VIDEO_FAILED = 5;
    public int a = 0;

    public CameraException(Throwable th) {
        super(th);
    }

    public int getReason() {
        return this.a;
    }

    public boolean isUnrecoverable() {
        int reason = getReason();
        return reason == 1 || reason == 2 || reason == 3;
    }

    public CameraException(Throwable th, int i) {
        super(th);
        this.a = i;
    }

    public CameraException(int i) {
        this.a = i;
    }
}
