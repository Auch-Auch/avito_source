package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;
import pl.droidsonroids.gif.annotations.Beta;
public class GifAnimationMetaData implements Serializable, Parcelable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new a();
    private static final long serialVersionUID = 5692363926580237325L;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;
    public final long g;

    public static class a implements Parcelable.Creator<GifAnimationMetaData> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public GifAnimationMetaData createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel, (a) null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public GifAnimationMetaData[] newArray(int i) {
            return new GifAnimationMetaData[i];
        }
    }

    public GifAnimationMetaData(@NonNull Resources resources, @DrawableRes @RawRes int i) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getAllocationByteCount() {
        return this.f;
    }

    @Beta
    public long getDrawableAllocationByteCount(@Nullable GifDrawable gifDrawable, @IntRange(from = 1, to = 65535) int i) {
        int i2;
        if (i < 1 || i > 65535) {
            throw new IllegalStateException("Sample size " + i + " out of range <1, " + CharCompanionObject.MAX_VALUE + ">");
        }
        int i3 = i * i;
        if (gifDrawable == null || gifDrawable.e.isRecycled()) {
            i2 = ((this.d * this.c) * 4) / i3;
        } else {
            i2 = gifDrawable.e.getAllocationByteCount();
        }
        return (this.f / ((long) i3)) + ((long) i2);
    }

    public int getDuration() {
        return this.b;
    }

    public int getHeight() {
        return this.c;
    }

    public int getLoopCount() {
        return this.a;
    }

    public long getMetadataAllocationByteCount() {
        return this.g;
    }

    public int getNumberOfFrames() {
        return this.e;
    }

    public int getWidth() {
        return this.d;
    }

    public boolean isAnimated() {
        return this.e > 1 && this.b > 0;
    }

    @Override // java.lang.Object
    @NonNull
    public String toString() {
        int i = this.a;
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(this.e), i == 0 ? "Infinity" : Integer.toString(i), Integer.valueOf(this.b));
        return isAnimated() ? a2.b.a.a.a.c3("Animated ", format) : format;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeLong(this.g);
        parcel.writeLong(this.f);
    }

    public GifAnimationMetaData(@NonNull AssetManager assetManager, @NonNull String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public GifAnimationMetaData(@NonNull String str) throws IOException {
        this(new GifInfoHandle(str));
    }

    public GifAnimationMetaData(@NonNull File file) throws IOException {
        this(file.getPath());
    }

    public GifAnimationMetaData(@NonNull InputStream inputStream) throws IOException {
        this(new GifInfoHandle(inputStream));
    }

    public GifAnimationMetaData(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(new GifInfoHandle(assetFileDescriptor));
    }

    public GifAnimationMetaData(@NonNull FileDescriptor fileDescriptor) throws IOException {
        this(new GifInfoHandle(fileDescriptor));
    }

    public GifAnimationMetaData(@NonNull byte[] bArr) throws IOException {
        this(new GifInfoHandle(bArr));
    }

    public GifAnimationMetaData(@NonNull ByteBuffer byteBuffer) throws IOException {
        this(new GifInfoHandle(byteBuffer));
    }

    public GifAnimationMetaData(@Nullable ContentResolver contentResolver, @NonNull Uri uri) throws IOException {
        this(GifInfoHandle.x(contentResolver, uri));
    }

    public GifAnimationMetaData(GifInfoHandle gifInfoHandle) {
        this.a = gifInfoHandle.j();
        this.b = gifInfoHandle.g();
        this.d = gifInfoHandle.p();
        this.c = gifInfoHandle.i();
        this.e = gifInfoHandle.m();
        this.g = gifInfoHandle.k();
        this.f = gifInfoHandle.b();
        gifInfoHandle.z();
    }

    public GifAnimationMetaData(Parcel parcel, a aVar) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.g = parcel.readLong();
        this.f = parcel.readLong();
    }
}
