package com.facebook.imagepipeline.producers;

import a2.b.a.a.a;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    public static final String[] d = {"_id", "_data"};
    public final ContentResolver c;

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        InputStream inputStream;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalContactUri(sourceUri)) {
            if (sourceUri.toString().endsWith("/photo")) {
                inputStream = this.c.openInputStream(sourceUri);
            } else if (sourceUri.toString().endsWith("/display_photo")) {
                try {
                    inputStream = this.c.openAssetFileDescriptor(sourceUri, "r").createInputStream();
                } catch (IOException unused) {
                    throw new IOException(a.W2("Contact photo does not exist: ", sourceUri));
                }
            } else {
                InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.c, sourceUri);
                if (openContactPhotoInputStream != null) {
                    inputStream = openContactPhotoInputStream;
                } else {
                    throw new IOException(a.W2("Contact photo does not exist: ", sourceUri));
                }
            }
            return getEncodedImage(inputStream, -1);
        }
        if (UriUtil.isLocalCameraUri(sourceUri)) {
            Cursor query = this.c.query(sourceUri, d, null, null, null);
            EncodedImage encodedImage = null;
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (string != null) {
                            encodedImage = getEncodedImage(new FileInputStream(this.c.openFileDescriptor(sourceUri, "r").getFileDescriptor()), (int) new File(string).length());
                        }
                    }
                } finally {
                    query.close();
                }
            }
            if (encodedImage != null) {
                return encodedImage;
            }
        }
        return getEncodedImage(this.c.openInputStream(sourceUri), -1);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
