package com.facebook.imagepipeline.backends.okhttp3;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    public final Call.Factory a;
    @Nullable
    public final CacheControl b;
    public Executor c;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public class a extends BaseProducerContextCallbacks {
        public final /* synthetic */ Call a;

        /* renamed from: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$a$a  reason: collision with other inner class name */
        public class RunnableC0180a implements Runnable {
            public RunnableC0180a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.cancel();
            }
        }

        public a(Call call) {
            this.a = call;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.a.cancel();
            } else {
                OkHttpNetworkFetcher.this.c.execute(new RunnableC0180a());
            }
        }
    }

    public class b implements Callback {
        public final /* synthetic */ OkHttpNetworkFetchState a;
        public final /* synthetic */ NetworkFetcher.Callback b;

        public b(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
            this.a = okHttpNetworkFetchState;
            this.b = callback;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            OkHttpNetworkFetcher.a(OkHttpNetworkFetcher.this, call, iOException, this.b);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            this.a.responseTime = SystemClock.elapsedRealtime();
            ResponseBody body = response.body();
            try {
                if (!response.isSuccessful()) {
                    OkHttpNetworkFetcher.a(OkHttpNetworkFetcher.this, call, new IOException("Unexpected HTTP code " + response), this.b);
                    body.close();
                    return;
                }
                BytesRange fromContentRangeHeader = BytesRange.fromContentRangeHeader(response.header(HttpHeaders.CONTENT_RANGE));
                if (!(fromContentRangeHeader == null || (fromContentRangeHeader.from == 0 && fromContentRangeHeader.to == Integer.MAX_VALUE))) {
                    this.a.setResponseBytesRange(fromContentRangeHeader);
                    this.a.setOnNewResultStatusFlags(8);
                }
                long contentLength = body.contentLength();
                if (contentLength < 0) {
                    contentLength = 0;
                }
                this.b.onResponse(body.byteStream(), (int) contentLength);
                body.close();
            } catch (Exception e) {
                OkHttpNetworkFetcher.a(OkHttpNetworkFetcher.this, call, e, this.b);
            } catch (Throwable th) {
                body.close();
                throw th;
            }
        }
    }

    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public static void a(OkHttpNetworkFetcher okHttpNetworkFetcher, Call call, Exception exc, NetworkFetcher.Callback callback) {
        Objects.requireNonNull(okHttpNetworkFetcher);
        if (call.isCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }

    public void fetchWithRequest(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback, Request request) {
        Call newCall = this.a.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new a(newCall));
        newCall.enqueue(new b(okHttpNetworkFetchState, callback));
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor) {
        this(factory, executor, true);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        try {
            Request.Builder builder = new Request.Builder().url(okHttpNetworkFetchState.getUri().toString()).get();
            CacheControl cacheControl = this.b;
            if (cacheControl != null) {
                builder.cacheControl(cacheControl);
            }
            BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader(HttpHeaders.RANGE, bytesRange.toHttpRangeHeaderValue());
            }
            fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        hashMap.put("fetch_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        hashMap.put("total_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        hashMap.put("image_size", Integer.toString(i));
        return hashMap;
    }

    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor, boolean z) {
        this.a = factory;
        this.c = executor;
        this.b = z ? new CacheControl.Builder().noStore().build() : null;
    }
}
