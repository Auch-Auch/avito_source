package pl.droidsonroids.gif;

import a2.b.a.a.a;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.text.Typography;
import pl.droidsonroids.relinker.ReLinker;
public final class GifInfoHandle {
    public volatile long a;

    static {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (LibraryLoader.a == null) {
                try {
                    LibraryLoader.a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
                }
            }
            ReLinker.loadLibrary(LibraryLoader.a, "pl_droidsonroids_gif");
        }
    }

    public GifInfoHandle() {
    }

    private static native void bindSurface(long j, Surface surface, long[] jArr);

    public static native int createTempNativeFileDescriptor() throws GifIOException;

    public static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z) throws GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    public static native long openByteArray(byte[] bArr) throws GifIOException;

    public static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    public static native long openFile(String str) throws GifIOException;

    public static native long openNativeFileDescriptor(int i, long j) throws GifIOException;

    public static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    public static long w(FileDescriptor fileDescriptor, long j, boolean z) throws GifIOException {
        int i;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                i = createTempNativeFileDescriptor();
                Os.dup2(fileDescriptor, i);
                if (z) {
                    Os.close(fileDescriptor);
                }
            } catch (Exception e) {
                throw new GifIOException(GifError.OPEN_FAILED.a, e.getMessage());
            } catch (Throwable th) {
                if (z) {
                    Os.close(fileDescriptor);
                }
                throw th;
            }
        } else {
            i = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(i, j);
    }

    public static GifInfoHandle x(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException(a.W2("Could not open AssetFileDescriptor for ", uri));
    }

    public synchronized long A(Bitmap bitmap) {
        return renderFrame(this.a, bitmap);
    }

    public synchronized boolean B() {
        return reset(this.a);
    }

    public synchronized long C() {
        return restoreRemainder(this.a);
    }

    public synchronized int D(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.a, jArr, bitmap);
    }

    public synchronized void E() {
        saveRemainder(this.a);
    }

    public synchronized void F(@IntRange(from = 0, to = 2147483647L) int i, Bitmap bitmap) {
        seekToFrame(this.a, i, bitmap);
    }

    public void G(@IntRange(from = 0) int i) {
        N(i);
        seekToFrameGL(this.a, i);
    }

    public synchronized void H(@IntRange(from = 0, to = 2147483647L) int i, Bitmap bitmap) {
        seekToTime(this.a, i, bitmap);
    }

    public void I(@IntRange(from = 0, to = 65535) int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.a, (char) i);
        }
    }

    public void J(char c, boolean z) {
        setOptions(this.a, c, z);
    }

    public void K(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f || Float.isNaN(f)) {
            throw new IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.a, f);
        }
    }

    public void L() {
        startDecoderThread(this.a);
    }

    public void M() {
        stopDecoderThread(this.a);
    }

    public final void N(@IntRange(from = 0) int i) {
        int numberOfFrames = getNumberOfFrames(this.a);
        if (i < 0 || i >= numberOfFrames) {
            throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + Typography.greater);
        }
    }

    public void a(Surface surface, long[] jArr) {
        bindSurface(this.a, surface, jArr);
    }

    public synchronized long b() {
        return getAllocationByteCount(this.a);
    }

    public synchronized String c() {
        return getComment(this.a);
    }

    public synchronized int d() {
        return getCurrentFrameIndex(this.a);
    }

    public synchronized int e() {
        return getCurrentLoop(this.a);
    }

    public synchronized int f() {
        return getCurrentPosition(this.a);
    }

    public void finalize() throws Throwable {
        try {
            z();
        } finally {
            super.finalize();
        }
    }

    public synchronized int g() {
        return getDuration(this.a);
    }

    public synchronized int h(@IntRange(from = 0) int i) {
        N(i);
        return getFrameDuration(this.a, i);
    }

    public synchronized int i() {
        return getHeight(this.a);
    }

    public synchronized int j() {
        return getLoopCount(this.a);
    }

    public synchronized long k() {
        return getMetadataByteCount(this.a);
    }

    public synchronized int l() {
        return getNativeErrorCode(this.a);
    }

    public synchronized int m() {
        return getNumberOfFrames(this.a);
    }

    public synchronized long[] n() {
        return getSavedState(this.a);
    }

    public synchronized long o() {
        return getSourceLength(this.a);
    }

    public synchronized int p() {
        return getWidth(this.a);
    }

    public void q(int i, int i2) {
        glTexImage2D(this.a, i, i2);
    }

    public void r(int i, int i2) {
        glTexSubImage2D(this.a, i, i2);
    }

    public void s() {
        initTexImageDescriptor(this.a);
    }

    public synchronized boolean t() {
        return isAnimationCompleted(this.a);
    }

    public synchronized boolean u() {
        return isOpaque(this.a);
    }

    public synchronized boolean v() {
        return this.a == 0;
    }

    public synchronized void y() {
        postUnbindSurface(this.a);
    }

    public synchronized void z() {
        free(this.a);
        this.a = 0;
    }

    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.a = w(fileDescriptor, 0, true);
    }

    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.a = openByteArray(bArr);
    }

    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.a = openDirectByteBuffer(byteBuffer);
    }

    public GifInfoHandle(String str) throws GifIOException {
        this.a = openFile(str);
    }

    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.a = w(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
