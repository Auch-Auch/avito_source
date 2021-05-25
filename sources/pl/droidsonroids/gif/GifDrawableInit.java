package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import pl.droidsonroids.gif.GifDrawableInit;
import pl.droidsonroids.gif.InputSource;
import pl.droidsonroids.gif.annotations.Beta;
public abstract class GifDrawableInit<T extends GifDrawableInit<T>> {
    public InputSource a;
    public GifDrawable b;
    public ScheduledThreadPoolExecutor c;
    public boolean d = true;
    public GifOptions e = new GifOptions();

    public GifDrawable build() throws IOException {
        InputSource inputSource = this.a;
        Objects.requireNonNull(inputSource, "Source is not set");
        GifDrawable gifDrawable = this.b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.c;
        boolean z = this.d;
        GifOptions gifOptions = this.e;
        Objects.requireNonNull(inputSource);
        GifInfoHandle a3 = inputSource.a();
        a3.J(gifOptions.a, gifOptions.b);
        return new GifDrawable(a3, gifDrawable, scheduledThreadPoolExecutor, z);
    }

    public T from(InputStream inputStream) {
        this.a = new InputSource.InputStreamSource(inputStream);
        return self();
    }

    public ScheduledThreadPoolExecutor getExecutor() {
        return this.c;
    }

    public InputSource getInputSource() {
        return this.a;
    }

    public GifDrawable getOldDrawable() {
        return this.b;
    }

    public GifOptions getOptions() {
        return this.e;
    }

    public boolean isRenderingTriggeredOnDraw() {
        return this.d;
    }

    @Beta
    public T options(@Nullable GifOptions gifOptions) {
        GifOptions gifOptions2 = this.e;
        if (gifOptions == null) {
            gifOptions2.a = 1;
            gifOptions2.b = false;
        } else {
            gifOptions2.b = gifOptions.b;
            gifOptions2.a = gifOptions.a;
        }
        return self();
    }

    public T renderingTriggeredOnDraw(boolean z) {
        this.d = z;
        return self();
    }

    public T sampleSize(@IntRange(from = 1, to = 65535) int i) {
        this.e.setInSampleSize(i);
        return self();
    }

    public abstract T self();

    public T setRenderingTriggeredOnDraw(boolean z) {
        return renderingTriggeredOnDraw(z);
    }

    public T taskExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.c = scheduledThreadPoolExecutor;
        return self();
    }

    public T threadPoolSize(int i) {
        this.c = new ScheduledThreadPoolExecutor(i);
        return self();
    }

    public T with(GifDrawable gifDrawable) {
        this.b = gifDrawable;
        return self();
    }

    public T from(AssetFileDescriptor assetFileDescriptor) {
        this.a = new InputSource.AssetFileDescriptorSource(assetFileDescriptor);
        return self();
    }

    public T from(FileDescriptor fileDescriptor) {
        this.a = new InputSource.FileDescriptorSource(fileDescriptor);
        return self();
    }

    public T from(AssetManager assetManager, String str) {
        this.a = new InputSource.AssetSource(assetManager, str);
        return self();
    }

    public T from(ContentResolver contentResolver, Uri uri) {
        this.a = new InputSource.UriSource(contentResolver, uri);
        return self();
    }

    public T from(File file) {
        this.a = new InputSource.FileSource(file);
        return self();
    }

    public T from(String str) {
        this.a = new InputSource.FileSource(str);
        return self();
    }

    public T from(byte[] bArr) {
        this.a = new InputSource.ByteArraySource(bArr);
        return self();
    }

    public T from(ByteBuffer byteBuffer) {
        this.a = new InputSource.DirectByteBufferSource(byteBuffer);
        return self();
    }

    public T from(Resources resources, int i) {
        this.a = new InputSource.ResourcesSource(resources, i);
        return self();
    }
}
