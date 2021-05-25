package com.otaliastudios.cameraview.frame;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
public class Frame {
    public static final CameraLogger j = CameraLogger.create(Frame.class.getSimpleName());
    public final FrameManager a;
    public final Class<?> b;
    public Object c = null;
    public long d = -1;
    public long e = -1;
    public int f = 0;
    public int g = 0;
    public Size h = null;
    public int i = -1;

    public Frame(@NonNull FrameManager frameManager) {
        this.a = frameManager;
        this.b = frameManager.getFrameDataClass();
    }

    public final void a() {
        if (!(this.c != null)) {
            j.e("Frame is dead! time:", Long.valueOf(this.d), "lastTime:", Long.valueOf(this.e));
            throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Frame) && ((Frame) obj).d == this.d;
    }

    @NonNull
    @SuppressLint({"NewApi"})
    public Frame freeze() {
        a();
        Frame frame = new Frame(this.a);
        Object onCloneFrameData = this.a.onCloneFrameData(getData());
        long j2 = this.d;
        int i2 = this.f;
        int i3 = this.g;
        Size size = this.h;
        int i4 = this.i;
        frame.c = onCloneFrameData;
        frame.d = j2;
        frame.e = j2;
        frame.f = i2;
        frame.g = i3;
        frame.h = size;
        frame.i = i4;
        return frame;
    }

    @NonNull
    public <T> T getData() {
        a();
        return (T) this.c;
    }

    @NonNull
    public Class<?> getDataClass() {
        return this.b;
    }

    public int getFormat() {
        a();
        return this.i;
    }

    @Deprecated
    public int getRotation() {
        return getRotationToUser();
    }

    public int getRotationToUser() {
        a();
        return this.f;
    }

    public int getRotationToView() {
        a();
        return this.g;
    }

    @NonNull
    public Size getSize() {
        a();
        return this.h;
    }

    public long getTime() {
        a();
        return this.d;
    }

    public void release() {
        if (this.c != null) {
            j.v("Frame with time", Long.valueOf(this.d), "is being released.");
            Object obj = this.c;
            this.c = null;
            this.f = 0;
            this.g = 0;
            this.d = -1;
            this.h = null;
            this.i = -1;
            FrameManager frameManager = this.a;
            if (frameManager.isSetUp()) {
                frameManager.onFrameDataReleased(obj, frameManager.f.offer(this));
            }
        }
    }
}
