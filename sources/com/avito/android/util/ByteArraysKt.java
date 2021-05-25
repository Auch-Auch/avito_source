package com.avito.android.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.ByteArrayInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0012\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "", "extractPhotoRotateDegree", "([B)F", "Lcom/avito/android/util/Dimension;", "calculatePhotoSize", "([B)Lcom/avito/android/util/Dimension;", "", DecodeProducer.SAMPLE_SIZE, "Landroid/graphics/Bitmap;", "decode", "([BI)Landroid/graphics/Bitmap;", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ByteArraysKt {
    @NotNull
    public static final Dimension calculatePhotoSize(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$calculatePhotoSize");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return new Dimension(options.outWidth, options.outHeight);
    }

    @NotNull
    public static final Bitmap decode(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$this$decode");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Intrinsics.checkNotNullExpressionValue(decodeByteArray, "BitmapFactory.decodeByte…y(this, 0, size, options)");
        return decodeByteArray;
    }

    public static /* synthetic */ Bitmap decode$default(byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return decode(bArr, i);
    }

    public static final float extractPhotoRotateDegree(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$extractPhotoRotateDegree");
        int attributeInt = new ExifInterface(new ByteArrayInputStream(bArr)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return 180.0f;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0.0f : 270.0f;
        }
        return 90.0f;
    }
}
