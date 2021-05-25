package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<HttpUrlConnectionNetworkFetchState> {
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    public int a;
    @Nullable
    public String b;
    @Nullable
    public final Map<String, String> c;
    public final ExecutorService d;
    public final MonotonicClock e;

    public static class HttpUrlConnectionNetworkFetchState extends FetchState {
        public long f;
        public long g;
        public long h;

        public HttpUrlConnectionNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ HttpUrlConnectionNetworkFetchState a;
        public final /* synthetic */ NetworkFetcher.Callback b;

        public a(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, NetworkFetcher.Callback callback) {
            this.a = httpUrlConnectionNetworkFetchState;
            this.b = callback;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC, Splitter:B:21:0x003d] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004a A[SYNTHETIC, Splitter:B:27:0x004a] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher r0 = com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.this
                com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher$HttpUrlConnectionNetworkFetchState r1 = r7.a
                com.facebook.imagepipeline.producers.NetworkFetcher$Callback r2 = r7.b
                java.util.Objects.requireNonNull(r0)
                r3 = 0
                android.net.Uri r4 = r1.getUri()     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                r5 = 5
                java.net.HttpURLConnection r4 = r0.a(r4, r5)     // Catch:{ IOException -> 0x0036, all -> 0x0033 }
                com.facebook.common.time.MonotonicClock r0 = r0.e     // Catch:{ IOException -> 0x0031 }
                long r5 = r0.now()     // Catch:{ IOException -> 0x0031 }
                r1.g = r5     // Catch:{ IOException -> 0x0031 }
                if (r4 == 0) goto L_0x0025
                java.io.InputStream r3 = r4.getInputStream()     // Catch:{ IOException -> 0x0031 }
                r0 = -1
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0031 }
            L_0x0025:
                if (r3 == 0) goto L_0x002c
                r3.close()     // Catch:{ IOException -> 0x002b }
                goto L_0x002c
            L_0x002b:
            L_0x002c:
                if (r4 == 0) goto L_0x0047
                goto L_0x0044
            L_0x002f:
                r0 = move-exception
                goto L_0x0048
            L_0x0031:
                r0 = move-exception
                goto L_0x0038
            L_0x0033:
                r0 = move-exception
                r4 = r3
                goto L_0x0048
            L_0x0036:
                r0 = move-exception
                r4 = r3
            L_0x0038:
                r2.onFailure(r0)     // Catch:{ all -> 0x002f }
                if (r3 == 0) goto L_0x0042
                r3.close()     // Catch:{ IOException -> 0x0041 }
                goto L_0x0042
            L_0x0041:
            L_0x0042:
                if (r4 == 0) goto L_0x0047
            L_0x0044:
                r4.disconnect()
            L_0x0047:
                return
            L_0x0048:
                if (r3 == 0) goto L_0x004f
                r3.close()     // Catch:{ IOException -> 0x004e }
                goto L_0x004f
            L_0x004e:
            L_0x004f:
                if (r4 == 0) goto L_0x0054
                r4.disconnect()
            L_0x0054:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.a.run():void");
        }
    }

    public class b extends BaseProducerContextCallbacks {
        public final /* synthetic */ Future a;
        public final /* synthetic */ NetworkFetcher.Callback b;

        public b(HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher, Future future, NetworkFetcher.Callback callback) {
            this.a = future;
            this.b = callback;
        }

        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            if (this.a.cancel(false)) {
                this.b.onCancellation();
            }
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        this((String) null, (Map<String, String>) null, RealtimeSinceBootClock.get());
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.net.HttpURLConnection a(android.net.Uri r8, int r9) throws java.io.IOException {
        /*
            r7 = this;
            java.net.URL r0 = com.facebook.common.util.UriUtil.uriToUrl(r8)
            java.net.URLConnection r0 = r0.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            java.lang.String r1 = r7.b
            if (r1 == 0) goto L_0x0013
            java.lang.String r2 = "User-Agent"
            r0.setRequestProperty(r2, r1)
        L_0x0013:
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.c
            if (r1 == 0) goto L_0x003b
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r0.setRequestProperty(r3, r2)
            goto L_0x001f
        L_0x003b:
            int r1 = r7.a
            r0.setConnectTimeout(r1)
            int r1 = r0.getResponseCode()
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 1
            r4 = 0
            if (r1 < r2) goto L_0x0050
            r2 = 300(0x12c, float:4.2E-43)
            if (r1 >= r2) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            if (r2 == 0) goto L_0x0054
            return r0
        L_0x0054:
            r2 = 307(0x133, float:4.3E-43)
            if (r1 == r2) goto L_0x0061
            r2 = 308(0x134, float:4.32E-43)
            if (r1 == r2) goto L_0x0061
            switch(r1) {
                case 300: goto L_0x0061;
                case 301: goto L_0x0061;
                case 302: goto L_0x0061;
                case 303: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            r2 = 0
            goto L_0x0062
        L_0x0061:
            r2 = 1
        L_0x0062:
            r5 = 2
            if (r2 == 0) goto L_0x00c1
            java.lang.String r2 = "Location"
            java.lang.String r2 = r0.getHeaderField(r2)
            r0.disconnect()
            if (r2 != 0) goto L_0x0072
            r0 = 0
            goto L_0x0076
        L_0x0072:
            android.net.Uri r0 = android.net.Uri.parse(r2)
        L_0x0076:
            java.lang.String r2 = r8.getScheme()
            if (r9 <= 0) goto L_0x008e
            if (r0 == 0) goto L_0x008e
            java.lang.String r6 = r0.getScheme()
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x008e
            int r9 = r9 - r3
            java.net.HttpURLConnection r8 = r7.a(r0, r9)
            return r8
        L_0x008e:
            if (r9 != 0) goto L_0x00a3
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.String r8 = r8.toString()
            r9[r4] = r8
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r0 = "URL %s follows too many redirects"
            java.lang.String r8 = java.lang.String.format(r8, r0, r9)
            goto L_0x00bb
        L_0x00a3:
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r8 = r8.toString()
            r9[r4] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r9[r3] = r8
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r0 = "URL %s returned %d without a valid redirect"
            java.lang.String r8 = java.lang.String.format(r8, r0, r9)
        L_0x00bb:
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r8)
            throw r9
        L_0x00c1:
            r0.disconnect()
            java.io.IOException r9 = new java.io.IOException
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r8 = r8.toString()
            r0[r4] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r0[r3] = r8
            java.lang.String r8 = "Image URL %s returned HTTP code %d"
            java.lang.String r8 = java.lang.String.format(r8, r0)
            r9.<init>(r8)
            throw r9
            switch-data {300->0x0061, 301->0x0061, 302->0x0061, 303->0x0061, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.a(android.net.Uri, int):java.net.HttpURLConnection");
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this((String) null, (Map<String, String>) null, RealtimeSinceBootClock.get());
        this.a = i;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public HttpUrlConnectionNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    public void fetch(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, NetworkFetcher.Callback callback) {
        httpUrlConnectionNetworkFetchState.f = this.e.now();
        httpUrlConnectionNetworkFetchState.getContext().addCallbacks(new b(this, this.d.submit(new a(httpUrlConnectionNetworkFetchState, callback)), callback));
    }

    public Map<String, String> getExtraMap(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(httpUrlConnectionNetworkFetchState.g - httpUrlConnectionNetworkFetchState.f));
        hashMap.put("fetch_time", Long.toString(httpUrlConnectionNetworkFetchState.h - httpUrlConnectionNetworkFetchState.g));
        hashMap.put("total_time", Long.toString(httpUrlConnectionNetworkFetchState.h - httpUrlConnectionNetworkFetchState.f));
        hashMap.put("image_size", Integer.toString(i));
        return hashMap;
    }

    public void onFetchCompletion(HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        httpUrlConnectionNetworkFetchState.h = this.e.now();
    }

    public HttpUrlConnectionNetworkFetcher(String str, int i) {
        this(str, (Map<String, String>) null, RealtimeSinceBootClock.get());
        this.a = i;
    }

    public HttpUrlConnectionNetworkFetcher(String str, @Nullable Map<String, String> map, int i) {
        this(str, map, RealtimeSinceBootClock.get());
        this.a = i;
    }

    @VisibleForTesting
    public HttpUrlConnectionNetworkFetcher(@Nullable String str, @Nullable Map<String, String> map, MonotonicClock monotonicClock) {
        this.d = Executors.newFixedThreadPool(3);
        this.e = monotonicClock;
        this.c = map;
        this.b = str;
    }
}
