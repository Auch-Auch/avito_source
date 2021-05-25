package pl.droidsonroids.gif;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
public class GifDecoder {
    public final GifInfoHandle a;

    public GifDecoder(@NonNull InputSource inputSource) throws IOException {
        this(inputSource, null);
    }

    public final void a(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is recycled");
        } else if (bitmap.getWidth() < this.a.p() || bitmap.getHeight() < this.a.i()) {
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        } else if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            StringBuilder L = a.L("Only Config.ARGB_8888 is supported. Current bitmap config: ");
            L.append(bitmap.getConfig());
            throw new IllegalArgumentException(L.toString());
        }
    }

    public long getAllocationByteCount() {
        return this.a.b();
    }

    public String getComment() {
        return this.a.c();
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

    public int getLoopCount() {
        return this.a.j();
    }

    public int getNumberOfFrames() {
        return this.a.m();
    }

    public long getSourceLength() {
        return this.a.o();
    }

    public int getWidth() {
        return this.a.p();
    }

    public boolean isAnimated() {
        return this.a.m() > 1 && getDuration() > 0;
    }

    public void recycle() {
        this.a.z();
    }

    public void seekToFrame(@IntRange(from = 0, to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.a.F(i, bitmap);
    }

    public void seekToTime(@IntRange(from = 0, to = 2147483647L) int i, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.a.H(i, bitmap);
    }

    public GifDecoder(@NonNull InputSource inputSource, @Nullable GifOptions gifOptions) throws IOException {
        GifInfoHandle a3 = inputSource.a();
        this.a = a3;
        if (gifOptions != null) {
            a3.J(gifOptions.a, gifOptions.b);
        }
    }
}
