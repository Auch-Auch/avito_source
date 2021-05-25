package com.otaliastudios.cameraview.frame;

import android.graphics.ImageFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.size.Size;
import java.util.concurrent.LinkedBlockingQueue;
public abstract class FrameManager<T> {
    public static final CameraLogger LOG = CameraLogger.create(FrameManager.class.getSimpleName());
    public final int a;
    public int b = -1;
    public Size c = null;
    public int d = -1;
    public final Class<T> e;
    public LinkedBlockingQueue<Frame> f;
    public Angles g;

    public FrameManager(int i, @NonNull Class<T> cls) {
        this.a = i;
        this.e = cls;
        this.f = new LinkedBlockingQueue<>(i);
    }

    @Nullable
    public Frame getFrame(@NonNull T t, long j) {
        if (isSetUp()) {
            Frame poll = this.f.poll();
            if (poll != null) {
                LOG.v("getFrame for time:", Long.valueOf(j), "RECYCLING.");
                Angles angles = this.g;
                Reference reference = Reference.SENSOR;
                Reference reference2 = Reference.OUTPUT;
                Axis axis = Axis.RELATIVE_TO_SENSOR;
                int offset = angles.offset(reference, reference2, axis);
                int offset2 = this.g.offset(reference, Reference.VIEW, axis);
                Size size = this.c;
                int i = this.d;
                poll.c = t;
                poll.d = j;
                poll.e = j;
                poll.f = offset;
                poll.g = offset2;
                poll.h = size;
                poll.i = i;
                return poll;
            }
            LOG.i("getFrame for time:", Long.valueOf(j), "NOT AVAILABLE.");
            onFrameDataReleased(t, false);
            return null;
        }
        throw new IllegalStateException("Can't call getFrame() after releasing or before setUp.");
    }

    public final int getFrameBytes() {
        return this.b;
    }

    public final Class<T> getFrameDataClass() {
        return this.e;
    }

    public final int getPoolSize() {
        return this.a;
    }

    public boolean isSetUp() {
        return this.c != null;
    }

    @NonNull
    public abstract T onCloneFrameData(@NonNull T t);

    public abstract void onFrameDataReleased(@NonNull T t, boolean z);

    public void release() {
        if (!isSetUp()) {
            LOG.w("release called twice. Ignoring.");
            return;
        }
        LOG.i("release: Clearing the frame and buffer queue.");
        this.f.clear();
        this.b = -1;
        this.c = null;
        this.d = -1;
        this.g = null;
    }

    public void setUp(int i, @NonNull Size size, @NonNull Angles angles) {
        isSetUp();
        this.c = size;
        this.d = i;
        this.b = (int) Math.ceil(((double) ((long) ((size.getWidth() * size.getHeight()) * ImageFormat.getBitsPerPixel(i)))) / 8.0d);
        for (int i2 = 0; i2 < getPoolSize(); i2++) {
            this.f.offer(new Frame(this));
        }
        this.g = angles;
    }
}
