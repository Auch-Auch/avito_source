package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
public abstract class InputSource {

    public static class AssetFileDescriptorSource extends InputSource {
        public final AssetFileDescriptor a;

        public AssetFileDescriptorSource(@NonNull AssetFileDescriptor assetFileDescriptor) {
            super(null);
            this.a = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    public static final class AssetSource extends InputSource {
        public final AssetManager a;
        public final String b;

        public AssetSource(@NonNull AssetManager assetManager, @NonNull String str) {
            super(null);
            this.a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openFd(this.b));
        }
    }

    public static final class ByteArraySource extends InputSource {
        public final byte[] a;

        public ByteArraySource(@NonNull byte[] bArr) {
            super(null);
            this.a = bArr;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }
    }

    public static final class DirectByteBufferSource extends InputSource {
        public final ByteBuffer a;

        public DirectByteBufferSource(@NonNull ByteBuffer byteBuffer) {
            super(null);
            this.a = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }
    }

    public static final class FileDescriptorSource extends InputSource {
        public final FileDescriptor a;

        public FileDescriptorSource(@NonNull FileDescriptor fileDescriptor) {
            super(null);
            this.a = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    public static final class InputStreamSource extends InputSource {
        public final InputStream a;

        public InputStreamSource(@NonNull InputStream inputStream) {
            super(null);
            this.a = inputStream;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a);
        }
    }

    public static class ResourcesSource extends InputSource {
        public final Resources a;
        public final int b;

        public ResourcesSource(@NonNull Resources resources, @DrawableRes @RawRes int i) {
            super(null);
            this.a = resources;
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return new GifInfoHandle(this.a.openRawResourceFd(this.b));
        }
    }

    public static final class UriSource extends InputSource {
        public final ContentResolver a;
        public final Uri b;

        public UriSource(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
            super(null);
            this.a = contentResolver;
            this.b = uri;
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws IOException {
            return GifInfoHandle.x(this.a, this.b);
        }
    }

    public InputSource() {
    }

    public abstract GifInfoHandle a() throws IOException;

    public static final class FileSource extends InputSource {
        public final String a;

        public FileSource(@NonNull File file) {
            super(null);
            this.a = file.getPath();
        }

        @Override // pl.droidsonroids.gif.InputSource
        public GifInfoHandle a() throws GifIOException {
            return new GifInfoHandle(this.a);
        }

        public FileSource(@NonNull String str) {
            super(null);
            this.a = str;
        }
    }

    public InputSource(a aVar) {
    }
}
