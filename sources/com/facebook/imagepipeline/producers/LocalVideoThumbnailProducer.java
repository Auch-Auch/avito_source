package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    public final Executor a;
    public final ContentResolver b;

    public class a extends StatefulProducerRunnable<CloseableReference<CloseableImage>> {
        public final /* synthetic */ ProducerListener2 e;
        public final /* synthetic */ ProducerContext f;
        public final /* synthetic */ ImageRequest g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener22, ProducerContext producerContext2, ImageRequest imageRequest) {
            super(consumer, producerListener2, producerContext, str);
            this.e = producerListener22;
            this.f = producerContext2;
            this.g = imageRequest;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(Object obj) {
            CloseableReference.closeSafely((CloseableReference) obj);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
        public Map getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
            return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        @Nullable
        public Object getResult() throws Exception {
            String str;
            Bitmap bitmap;
            try {
                str = LocalVideoThumbnailProducer.a(LocalVideoThumbnailProducer.this, this.g);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ImageRequest imageRequest = this.g;
                bitmap = ThumbnailUtils.createVideoThumbnail(str, (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3);
            } else {
                try {
                    ParcelFileDescriptor openFileDescriptor = LocalVideoThumbnailProducer.this.b.openFileDescriptor(this.g.getSourceUri(), "r");
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                    bitmap = mediaMetadataRetriever.getFrameAtTime(-1);
                } catch (FileNotFoundException unused2) {
                    bitmap = null;
                }
            }
            if (bitmap == null) {
                return null;
            }
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(bitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
            this.f.setExtra("image_format", "thumbnail");
            closeableStaticBitmap.setImageExtras(this.f.getExtras());
            return CloseableReference.of(closeableStaticBitmap);
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onFailure(Exception exc) {
            super.onFailure(exc);
            this.e.onUltimateProducerReached(this.f, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
            this.f.putOriginExtra(ImagesContract.LOCAL);
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onSuccess(Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            super.onSuccess(closeableReference);
            this.e.onUltimateProducerReached(this.f, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
            this.f.putOriginExtra(ImagesContract.LOCAL);
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ StatefulProducerRunnable a;

        public b(LocalVideoThumbnailProducer localVideoThumbnailProducer, StatefulProducerRunnable statefulProducerRunnable) {
            this.a = statefulProducerRunnable;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            this.a.cancel();
        }
    }

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.b = contentResolver;
    }

    public static String a(LocalVideoThumbnailProducer localVideoThumbnailProducer, ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri uri;
        Objects.requireNonNull(localVideoThumbnailProducer);
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalFileUri(sourceUri)) {
            return imageRequest.getSourceFile().getPath();
        }
        if (UriUtil.isLocalContentUri(sourceUri)) {
            if ("com.android.providers.media.documents".equals(sourceUri.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(sourceUri);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            } else {
                uri = sourceUri;
                str = null;
                strArr = null;
            }
            Cursor query = localVideoThumbnailProducer.b.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, "video");
        a aVar = new a(consumer, producerListener, producerContext, PRODUCER_NAME, producerListener, producerContext, imageRequest);
        producerContext.addCallbacks(new b(this, aVar));
        this.a.execute(aVar);
    }
}
