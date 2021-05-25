package com.otaliastudios.cameraview;

import a2.b.a.a.a;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.size.Size;
import java.io.File;
public class PictureResult {
    public final boolean a;
    public final Location b;
    public final int c;
    public final Size d;
    public final Facing e;
    public final byte[] f;
    public final PictureFormat g;

    public static class Stub {
        public byte[] data;
        public Facing facing;
        public PictureFormat format;
        public boolean isSnapshot;
        public Location location;
        public int rotation;
        public Size size;
    }

    public PictureResult(@NonNull Stub stub) {
        this.a = stub.isSnapshot;
        this.b = stub.location;
        this.c = stub.rotation;
        this.d = stub.size;
        this.e = stub.facing;
        this.f = stub.data;
        this.g = stub.format;
    }

    @NonNull
    public byte[] getData() {
        return this.f;
    }

    @NonNull
    public Facing getFacing() {
        return this.e;
    }

    @NonNull
    public PictureFormat getFormat() {
        return this.g;
    }

    @Nullable
    public Location getLocation() {
        return this.b;
    }

    public int getRotation() {
        return this.c;
    }

    @NonNull
    public Size getSize() {
        return this.d;
    }

    public boolean isSnapshot() {
        return this.a;
    }

    public void toBitmap(int i, int i2, @NonNull BitmapCallback bitmapCallback) {
        PictureFormat pictureFormat = this.g;
        if (pictureFormat == PictureFormat.JPEG) {
            CameraUtils.b(getData(), i, i2, new BitmapFactory.Options(), this.c, bitmapCallback);
        } else if (pictureFormat != PictureFormat.DNG || Build.VERSION.SDK_INT < 24) {
            StringBuilder L = a.L("PictureResult.toBitmap() does not support this picture format: ");
            L.append(this.g);
            throw new UnsupportedOperationException(L.toString());
        } else {
            CameraUtils.b(getData(), i, i2, new BitmapFactory.Options(), this.c, bitmapCallback);
        }
    }

    public void toFile(@NonNull File file, @NonNull FileCallback fileCallback) {
        CameraUtils.writeToFile(getData(), file, fileCallback);
    }

    public void toBitmap(@NonNull BitmapCallback bitmapCallback) {
        toBitmap(-1, -1, bitmapCallback);
    }
}
