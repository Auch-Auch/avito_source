package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
public class ImageFormatChecker {
    public static ImageFormatChecker d;
    public int a;
    @Nullable
    public List<ImageFormat.FormatChecker> b;
    public final ImageFormat.FormatChecker c = new DefaultImageFormatChecker();

    public ImageFormatChecker() {
        a();
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        return getInstance().determineImageFormat(inputStream);
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (d == null) {
                d = new ImageFormatChecker();
            }
            imageFormatChecker = d;
        }
        return imageFormatChecker;
    }

    public final void a() {
        this.a = this.c.getHeaderSize();
        List<ImageFormat.FormatChecker> list = this.b;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                this.a = Math.max(this.a, formatChecker.getHeaderSize());
            }
        }
    }

    public ImageFormat determineImageFormat(InputStream inputStream) throws IOException {
        int i;
        Preconditions.checkNotNull(inputStream);
        int i2 = this.a;
        byte[] bArr = new byte[i2];
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(i2 >= i2);
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i2);
                i = ByteStreams.read(inputStream, bArr, 0, i2);
            } finally {
                inputStream.reset();
            }
        } else {
            i = ByteStreams.read(inputStream, bArr, 0, i2);
        }
        ImageFormat determineFormat = this.c.determineFormat(bArr, i);
        if (!(determineFormat == null || determineFormat == ImageFormat.UNKNOWN)) {
            return determineFormat;
        }
        List<ImageFormat.FormatChecker> list = this.b;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                ImageFormat determineFormat2 = formatChecker.determineFormat(bArr, i);
                if (!(determineFormat2 == null || determineFormat2 == ImageFormat.UNKNOWN)) {
                    return determineFormat2;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> list) {
        this.b = list;
        a();
    }

    public static ImageFormat getImageFormat(String str) {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                ImageFormat imageFormat = getImageFormat(fileInputStream2);
                Closeables.closeQuietly(fileInputStream2);
                return imageFormat;
            } catch (IOException unused) {
                fileInputStream = fileInputStream2;
                try {
                    ImageFormat imageFormat2 = ImageFormat.UNKNOWN;
                    Closeables.closeQuietly(fileInputStream);
                    return imageFormat2;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                Closeables.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException unused2) {
            ImageFormat imageFormat2 = ImageFormat.UNKNOWN;
            Closeables.closeQuietly(fileInputStream);
            return imageFormat2;
        }
    }
}
