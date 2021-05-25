package com.otaliastudios.cameraview.frame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.size.Size;
import java.util.concurrent.LinkedBlockingQueue;
public class ByteBufferFrameManager extends FrameManager<byte[]> {
    public LinkedBlockingQueue<byte[]> h;
    public BufferCallback i;
    public final int j;

    public interface BufferCallback {
        void onBufferAvailable(@NonNull byte[] bArr);
    }

    public ByteBufferFrameManager(int i2, @Nullable BufferCallback bufferCallback) {
        super(i2, byte[].class);
        if (bufferCallback != null) {
            this.i = bufferCallback;
            this.j = 0;
            return;
        }
        this.h = new LinkedBlockingQueue<>(i2);
        this.j = 1;
    }

    @Nullable
    public byte[] getBuffer() {
        if (this.j == 1) {
            return this.h.poll();
        }
        throw new IllegalStateException("Can't call getBuffer() when not in BUFFER_MODE_ENQUEUE.");
    }

    public void onBufferUnused(@NonNull byte[] bArr) {
        if (this.j != 1) {
            throw new IllegalStateException("Can't call onBufferUnused() when not in BUFFER_MODE_ENQUEUE.");
        } else if (isSetUp()) {
            this.h.offer(bArr);
        } else {
            FrameManager.LOG.w("onBufferUnused: buffer was returned but we're not set up anymore.");
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void release() {
        super.release();
        if (this.j == 1) {
            this.h.clear();
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public void setUp(int i2, @NonNull Size size, @NonNull Angles angles) {
        super.setUp(i2, size, angles);
        int frameBytes = getFrameBytes();
        for (int i3 = 0; i3 < getPoolSize(); i3++) {
            if (this.j == 0) {
                this.i.onBufferAvailable(new byte[frameBytes]);
            } else {
                this.h.offer(new byte[frameBytes]);
            }
        }
    }

    @NonNull
    public byte[] onCloneFrameData(@NonNull byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public void onFrameDataReleased(@NonNull byte[] bArr, boolean z) {
        if (z && bArr.length == getFrameBytes()) {
            if (this.j == 0) {
                this.i.onBufferAvailable(bArr);
            } else {
                this.h.offer(bArr);
            }
        }
    }
}
