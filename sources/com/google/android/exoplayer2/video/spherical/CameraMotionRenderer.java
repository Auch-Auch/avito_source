package com.google.android.exoplayer2.video.spherical;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
public final class CameraMotionRenderer extends BaseRenderer {
    public final DecoderInputBuffer m = new DecoderInputBuffer(1);
    public final ParsableByteArray n = new ParsableByteArray();
    public long o;
    @Nullable
    public CameraMotionListener p;
    public long q;

    public CameraMotionRenderer() {
        super(5);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 7) {
            this.p = (CameraMotionListener) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        CameraMotionListener cameraMotionListener = this.p;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.q = Long.MIN_VALUE;
        CameraMotionListener cameraMotionListener = this.p;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.o = j2;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        float[] fArr;
        while (!hasReadStreamToEnd() && this.q < 100000 + j) {
            this.m.clear();
            if (readSource(getFormatHolder(), this.m, false) == -4 && !this.m.isEndOfStream()) {
                DecoderInputBuffer decoderInputBuffer = this.m;
                this.q = decoderInputBuffer.timeUs;
                if (this.p != null && !decoderInputBuffer.isDecodeOnly()) {
                    this.m.flip();
                    ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(this.m.data);
                    if (byteBuffer.remaining() != 16) {
                        fArr = null;
                    } else {
                        this.n.reset(byteBuffer.array(), byteBuffer.limit());
                        this.n.setPosition(byteBuffer.arrayOffset() + 4);
                        float[] fArr2 = new float[3];
                        for (int i = 0; i < 3; i++) {
                            fArr2[i] = Float.intBitsToFloat(this.n.readLittleEndianInt());
                        }
                        fArr = fArr2;
                    }
                    if (fArr != null) {
                        ((CameraMotionListener) Util.castNonNull(this.p)).onCameraMotion(this.q - this.o, fArr);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(format.sampleMimeType) ? 4 : 0;
    }
}
