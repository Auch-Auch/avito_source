package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    public static final String[] d = {"_id", "_data"};
    public static final String[] e = {"_data"};
    public static final Rect f = new Rect(0, 0, 512, 384);
    public static final Rect g = new Rect(0, 0, 96, 96);
    public final ContentResolver c;

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.c = contentResolver;
    }

    @Nullable
    public final EncodedImage a(ResizeOptions resizeOptions, long j) throws IOException {
        int i;
        Cursor queryMiniThumbnail;
        int i2;
        Rect rect = g;
        if (ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions)) {
            i = 3;
        } else {
            Rect rect2 = f;
            i = ThumbnailSizeChecker.isImageBigEnough(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
        }
        if (i == 0 || (queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.c, j, i, e)) == null) {
            return null;
        }
        try {
            if (queryMiniThumbnail.moveToFirst()) {
                String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                if (new File(string).exists()) {
                    FileInputStream fileInputStream = new FileInputStream(string);
                    if (string == null) {
                        i2 = -1;
                    } else {
                        i2 = (int) new File(string).length();
                    }
                    return getEncodedImage(fileInputStream, i2);
                }
            }
            queryMiniThumbnail.close();
            return null;
        } finally {
            queryMiniThumbnail.close();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        Rect rect = f;
        return ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    @Nullable
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        ResizeOptions resizeOptions;
        Cursor query;
        EncodedImage a;
        Uri sourceUri = imageRequest.getSourceUri();
        if (!UriUtil.isLocalCameraUri(sourceUri) || (resizeOptions = imageRequest.getResizeOptions()) == null || (query = this.c.query(sourceUri, d, null, null, null)) == null) {
            return null;
        }
        try {
            if (!query.moveToFirst() || (a = a(resizeOptions, query.getLong(query.getColumnIndex("_id")))) == null) {
                query.close();
                return null;
            }
            String string = query.getString(query.getColumnIndex("_data"));
            int i = 0;
            if (string != null) {
                try {
                    i = JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(string).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                } catch (IOException e2) {
                    FLog.e(LocalContentUriThumbnailFetchProducer.class, e2, "Unable to retrieve thumbnail rotation for %s", string);
                }
            }
            a.setRotationAngle(i);
            return a;
        } finally {
            query.close();
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
