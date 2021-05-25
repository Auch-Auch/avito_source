package pl.droidsonroids.gif;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.IOException;
public class GifTexImage2D {
    public final GifInfoHandle a;

    public GifTexImage2D(InputSource inputSource, @Nullable GifOptions gifOptions) throws IOException {
        gifOptions = gifOptions == null ? new GifOptions() : gifOptions;
        GifInfoHandle a3 = inputSource.a();
        this.a = a3;
        a3.J(gifOptions.a, gifOptions.b);
        a3.s();
    }

    public final void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    public int getCurrentFrameIndex() {
        return this.a.d();
    }

    public int getDuration() {
        return this.a.g();
    }

    public int getFrameDuration(@IntRange(from = 0) int i) {
        return this.a.h(i);
    }

    public int getHeight() {
        return this.a.i();
    }

    public int getNumberOfFrames() {
        return this.a.m();
    }

    public int getWidth() {
        return this.a.p();
    }

    public void glTexImage2D(int i, int i2) {
        this.a.q(i, i2);
    }

    public void glTexSubImage2D(int i, int i2) {
        this.a.r(i, i2);
    }

    public void recycle() {
        GifInfoHandle gifInfoHandle = this.a;
        if (gifInfoHandle != null) {
            gifInfoHandle.z();
        }
    }

    public void seekToFrame(@IntRange(from = 0) int i) {
        this.a.G(i);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.a.K(f);
    }

    public void startDecoderThread() {
        this.a.L();
    }

    public void stopDecoderThread() {
        this.a.M();
    }
}
