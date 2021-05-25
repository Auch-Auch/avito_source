package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.avito.android.BuildConfig;
import com.avito.android.remote.model.Sort;
import com.avito.android.util.UrlParams;
import com.avito.android.util.preferences.Names;
import com.facebook.GraphRequestBatch;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.common.net.HttpHeaders;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiCommunityFull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class GraphRequest {
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final String FIELDS_PARAM = "fields";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    public static final String TAG = "GraphRequest";
    public static final String n;
    public static String o;
    public static Pattern p = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    public static volatile String q;
    @Nullable
    public AccessToken a;
    public HttpMethod b;
    public String c;
    public JSONObject d;
    public String e;
    public String f;
    public boolean g;
    public Bundle h;
    public Callback i;
    public String j;
    public Object k;
    public String l;
    public boolean m;

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    public static class a implements Callback {
        public final /* synthetic */ GraphJSONObjectCallback a;

        public a(GraphJSONObjectCallback graphJSONObjectCallback) {
            this.a = graphJSONObjectCallback;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            GraphJSONObjectCallback graphJSONObjectCallback = this.a;
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
            }
        }
    }

    public static class b implements Callback {
        public final /* synthetic */ GraphJSONArrayCallback a;

        public b(GraphJSONArrayCallback graphJSONArrayCallback) {
            this.a = graphJSONArrayCallback;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            if (this.a != null) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                this.a.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
            }
        }
    }

    public static class c implements Callback {
        public final /* synthetic */ GraphJSONArrayCallback a;

        public c(GraphJSONArrayCallback graphJSONArrayCallback) {
            this.a = graphJSONArrayCallback;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            if (this.a != null) {
                JSONObject jSONObject = graphResponse.getJSONObject();
                this.a.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
            }
        }
    }

    public class d implements Callback {
        public final /* synthetic */ Callback a;

        public d(GraphRequest graphRequest, Callback callback) {
            this.a = callback;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
            JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject2 != null ? optJSONObject2.optString("message") : null;
                    String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                    String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                    if (!(optString == null || optString2 == null)) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (optString2.equals("warning")) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!Utility.isNullOrEmpty(optString3)) {
                            optString = a2.b.a.a.a.e3(optString, " Link: ", optString3);
                        }
                        Logger.log(loggingBehavior, GraphRequest.TAG, optString);
                    }
                }
            }
            Callback callback = this.a;
            if (callback != null) {
                callback.onCompleted(graphResponse);
            }
        }
    }

    public static class e implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ GraphRequestBatch b;

        public e(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
            this.a = arrayList;
            this.b = graphRequestBatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                ((Callback) pair.first).onCompleted((GraphResponse) pair.second);
            }
            for (GraphRequestBatch.Callback callback : this.b.e) {
                callback.onBatchCompleted(this.b);
            }
        }
    }

    public static class f {
        public final GraphRequest a;
        public final Object b;

        public f(GraphRequest graphRequest, Object obj) {
            this.a = graphRequest;
            this.b = obj;
        }
    }

    public interface g {
        void a(String str, String str2) throws IOException;
    }

    public static class h implements g {
        public final OutputStream a;
        public final Logger b;
        public boolean c = true;
        public boolean d = false;

        public h(OutputStream outputStream, Logger logger, boolean z) {
            this.a = outputStream;
            this.b = logger;
            this.d = z;
        }

        @Override // com.facebook.GraphRequest.g
        public void a(String str, String str2) throws IOException {
            c(str, null, null);
            f("%s", str2);
            h();
            Logger logger = this.b;
            if (logger != null) {
                logger.appendKeyValue("    " + str, str2);
            }
        }

        public void b(String str, Object... objArr) throws IOException {
            if (!this.d) {
                if (this.c) {
                    this.a.write("--".getBytes());
                    this.a.write(GraphRequest.n.getBytes());
                    this.a.write("\r\n".getBytes());
                    this.c = false;
                }
                this.a.write(String.format(str, objArr).getBytes());
                return;
            }
            this.a.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
        }

        public void c(String str, String str2, String str3) throws IOException {
            if (!this.d) {
                b("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    b("; filename=\"%s\"", str2);
                }
                f("", new Object[0]);
                if (str3 != null) {
                    f("%s: %s", "Content-Type", str3);
                }
                f("", new Object[0]);
                return;
            }
            this.a.write(String.format("%s=", str).getBytes());
        }

        public void d(String str, Uri uri, String str2) throws IOException {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            c(str, str, str2);
            if (this.a instanceof a2.g.f) {
                ((a2.g.f) this.a).b(Utility.getContentSize(uri));
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), this.a) + 0;
            }
            f("", new Object[0]);
            h();
            Logger logger = this.b;
            if (logger != null) {
                logger.appendKeyValue(a2.b.a.a.a.c3("    ", str), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(i)));
            }
        }

        public void e(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            c(str, str, str2);
            OutputStream outputStream = this.a;
            if (outputStream instanceof a2.g.f) {
                ((a2.g.f) outputStream).b(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.a) + 0;
            }
            f("", new Object[0]);
            h();
            Logger logger = this.b;
            if (logger != null) {
                logger.appendKeyValue(a2.b.a.a.a.c3("    ", str), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(i)));
            }
        }

        public void f(String str, Object... objArr) throws IOException {
            b(str, objArr);
            if (!this.d) {
                b("\r\n", new Object[0]);
            }
        }

        public void g(String str, Object obj, GraphRequest graphRequest) throws IOException {
            OutputStream outputStream = this.a;
            if (outputStream instanceof a2.g.h) {
                ((a2.g.h) outputStream).a(graphRequest);
            }
            if (GraphRequest.g(obj)) {
                a(str, GraphRequest.h(obj));
            } else if (obj instanceof Bitmap) {
                c(str, str, "image/png");
                ((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, this.a);
                f("", new Object[0]);
                h();
                Logger logger = this.b;
                if (logger != null) {
                    logger.appendKeyValue("    " + str, "<Image>");
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                c(str, str, "content/unknown");
                this.a.write(bArr);
                f("", new Object[0]);
                h();
                Logger logger2 = this.b;
                if (logger2 != null) {
                    logger2.appendKeyValue(a2.b.a.a.a.c3("    ", str), String.format(Locale.ROOT, "<Data: %d>", Integer.valueOf(bArr.length)));
                }
            } else if (obj instanceof Uri) {
                d(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                e(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    e(str, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    d(str, (Uri) resource, mimeType);
                } else {
                    throw new IllegalArgumentException("value is not a supported type.");
                }
            } else {
                throw new IllegalArgumentException("value is not a supported type.");
            }
        }

        public void h() throws IOException {
            if (!this.d) {
                f("--%s", GraphRequest.n);
            } else {
                this.a.write("&".getBytes());
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i2 = 0; i2 < nextInt; i2++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        n = sb.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public static HttpURLConnection c(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (q == null) {
            q = String.format("%s.%s", "FBAndroidSDK", "8.1.0");
            String customUserAgent = InternalSettings.getCustomUserAgent();
            if (!Utility.isNullOrEmpty(customUserAgent)) {
                q = String.format(Locale.ROOT, "%s/%s", q, customUserAgent);
            }
        }
        httpURLConnection.setRequestProperty("User-Agent", q);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAndWait(Arrays.asList(graphRequestArr));
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAsync(Arrays.asList(graphRequestArr));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bc, code lost:
        if ((r11.longValue() - r10.c.getLastRefresh().getTime()) > 86400000) goto L_0x00c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.facebook.GraphResponse> executeConnectionAndWait(java.net.HttpURLConnection r10, com.facebook.GraphRequestBatch r11) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.executeConnectionAndWait(java.net.HttpURLConnection, com.facebook.GraphRequestBatch):java.util.List");
    }

    public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
    }

    public static boolean f(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    public static boolean g(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static final String getDefaultBatchApplicationId() {
        return o;
    }

    public static String h(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(org.json.JSONObject r6, java.lang.String r7, com.facebook.GraphRequest.g r8) throws java.io.IOException {
        /*
            java.util.regex.Pattern r0 = com.facebook.GraphRequest.p
            java.util.regex.Matcher r0 = r0.matcher(r7)
            boolean r1 = r0.matches()
            r2 = 1
            if (r1 == 0) goto L_0x0012
            java.lang.String r0 = r0.group(r2)
            goto L_0x0013
        L_0x0012:
            r0 = r7
        L_0x0013:
            java.lang.String r1 = "me/"
            boolean r1 = r0.startsWith(r1)
            r3 = 0
            if (r1 != 0) goto L_0x0027
            java.lang.String r1 = "/me/"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = 0
            goto L_0x0028
        L_0x0027:
            r0 = 1
        L_0x0028:
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = ":"
            int r0 = r7.indexOf(r0)
            java.lang.String r1 = "?"
            int r7 = r7.indexOf(r1)
            r1 = 3
            if (r0 <= r1) goto L_0x0040
            r1 = -1
            if (r7 == r1) goto L_0x003e
            if (r0 >= r7) goto L_0x0040
        L_0x003e:
            r7 = 1
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            java.util.Iterator r0 = r6.keys()
        L_0x0045:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r6.opt(r1)
            if (r7 == 0) goto L_0x0061
            java.lang.String r5 = "image"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0061
            r5 = 1
            goto L_0x0062
        L_0x0061:
            r5 = 0
        L_0x0062:
            j(r1, r4, r8, r5)
            goto L_0x0045
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.i(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$g):void");
    }

    public static void j(String str, Object obj, g gVar, boolean z) throws IOException {
        Class<?> cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    j(String.format(UrlParams.ARRAY_TEMPLATE, str, next), jSONObject.opt(next), gVar, z);
                }
            } else if (jSONObject.has("id")) {
                j(str, jSONObject.optString("id"), gVar, z);
            } else if (jSONObject.has("url")) {
                j(str, jSONObject.optString("url"), gVar, z);
            } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                j(str, jSONObject.toString(), gVar, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                j(String.format(Locale.ROOT, "%s[%d]", str, Integer.valueOf(i2)), jSONArray.opt(i2), gVar, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            gVar.a(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            gVar.a(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    public static void k(GraphRequestBatch graphRequestBatch, Logger logger, int i2, URL url, OutputStream outputStream, boolean z) throws IOException, JSONException {
        String str;
        String applicationId;
        h hVar = new h(outputStream, logger, z);
        char c2 = 1;
        if (i2 == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String str2 : graphRequest.h.keySet()) {
                Object obj = graphRequest.h.get(str2);
                if (f(obj)) {
                    hashMap.put(str2, new f(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            Bundle bundle = graphRequest.h;
            for (String str3 : bundle.keySet()) {
                Object obj2 = bundle.get(str3);
                if (g(obj2)) {
                    hVar.g(str3, obj2, graphRequest);
                }
            }
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            m(hashMap, hVar);
            JSONObject jSONObject = graphRequest.d;
            if (jSONObject != null) {
                i(jSONObject, url.getPath(), hVar);
                return;
            }
            return;
        }
        if (!Utility.isNullOrEmpty(graphRequestBatch.getBatchApplicationId())) {
            str = graphRequestBatch.getBatchApplicationId();
        } else {
            Iterator it = graphRequestBatch.iterator();
            while (true) {
                if (it.hasNext()) {
                    AccessToken accessToken = ((GraphRequest) it.next()).a;
                    if (!(accessToken == null || (applicationId = accessToken.getApplicationId()) == null)) {
                        str = applicationId;
                        break;
                    }
                } else if (!Utility.isNullOrEmpty(o)) {
                    str = o;
                } else {
                    str = FacebookSdk.getApplicationId();
                }
            }
        }
        if (!Utility.isNullOrEmpty(str)) {
            hVar.a("batch_app_id", str);
            HashMap hashMap2 = new HashMap();
            JSONArray jSONArray = new JSONArray();
            Iterator it2 = graphRequestBatch.iterator();
            while (it2.hasNext()) {
                GraphRequest graphRequest2 = (GraphRequest) it2.next();
                Objects.requireNonNull(graphRequest2);
                JSONObject jSONObject2 = new JSONObject();
                String str4 = graphRequest2.e;
                if (str4 != null) {
                    jSONObject2.put("name", str4);
                    jSONObject2.put("omit_response_on_success", graphRequest2.g);
                }
                String str5 = graphRequest2.f;
                if (str5 != null) {
                    jSONObject2.put("depends_on", str5);
                }
                if (graphRequest2.j == null) {
                    int i3 = 2;
                    Object[] objArr = new Object[2];
                    objArr[0] = ServerProtocol.getGraphUrlBase();
                    objArr[c2] = graphRequest2.d();
                    String format = String.format("%s/%s", objArr);
                    graphRequest2.a();
                    Uri parse = Uri.parse(graphRequest2.b(format, Boolean.TRUE));
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = parse.getPath();
                    objArr2[c2] = parse.getQuery();
                    String format2 = String.format("%s?%s", objArr2);
                    jSONObject2.put("relative_url", format2);
                    jSONObject2.put("method", graphRequest2.b);
                    AccessToken accessToken2 = graphRequest2.a;
                    if (accessToken2 != null) {
                        Logger.registerAccessToken(accessToken2.getToken());
                    }
                    ArrayList arrayList = new ArrayList();
                    for (String str6 : graphRequest2.h.keySet()) {
                        Object obj3 = graphRequest2.h.get(str6);
                        if (f(obj3)) {
                            Locale locale = Locale.ROOT;
                            Object[] objArr3 = new Object[i3];
                            objArr3[0] = "file";
                            objArr3[1] = Integer.valueOf(hashMap2.size());
                            String format3 = String.format(locale, "%s%d", objArr3);
                            arrayList.add(format3);
                            hashMap2.put(format3, new f(graphRequest2, obj3));
                            i3 = 2;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2.put("attached_files", TextUtils.join(",", arrayList));
                    }
                    if (graphRequest2.d != null) {
                        ArrayList arrayList2 = new ArrayList();
                        i(graphRequest2.d, format2, new a2.g.c(graphRequest2, arrayList2));
                        jSONObject2.put(SDKConstants.PARAM_A2U_BODY, TextUtils.join("&", arrayList2));
                    }
                    jSONArray.put(jSONObject2);
                    c2 = 1;
                } else {
                    throw new FacebookException("Can't override URL for a batch request");
                }
            }
            OutputStream outputStream2 = hVar.a;
            if (!(outputStream2 instanceof a2.g.h)) {
                hVar.a("batch", jSONArray.toString());
            } else {
                a2.g.h hVar2 = (a2.g.h) outputStream2;
                hVar.c("batch", null, null);
                hVar.b("[", new Object[0]);
                Iterator it3 = graphRequestBatch.iterator();
                int i4 = 0;
                while (it3.hasNext()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                    hVar2.a((GraphRequest) it3.next());
                    if (i4 > 0) {
                        hVar.b(",%s", jSONObject3.toString());
                    } else {
                        hVar.b("%s", jSONObject3.toString());
                    }
                    i4++;
                }
                hVar.b("]", new Object[0]);
                Logger logger2 = hVar.b;
                if (logger2 != null) {
                    logger2.appendKeyValue("    batch", jSONArray.toString());
                }
            }
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            m(hashMap2, hVar);
            return;
        }
        throw new FacebookException("App ID was not specified at the request or Settings.");
    }

    public static void l(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        int size = graphRequestBatch.size();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            GraphRequest graphRequest = graphRequestBatch.get(i2);
            if (graphRequest.i != null) {
                arrayList.add(new Pair(graphRequest.i, list.get(i2)));
            }
        }
        if (arrayList.size() > 0) {
            e eVar = new e(arrayList, graphRequestBatch);
            Handler handler = graphRequestBatch.a;
            if (handler == null) {
                eVar.run();
            } else {
                handler.post(eVar);
            }
        }
    }

    public static void m(Map<String, f> map, h hVar) throws IOException {
        for (String str : map.keySet()) {
            f fVar = map.get(str);
            if (f(fVar.b)) {
                hVar.g(str, fVar.b, fVar.a);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void n(com.facebook.GraphRequestBatch r14, java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 323
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.n(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, Context context, String str, Callback callback) {
        String str2;
        if (str == null && accessToken != null) {
            str = accessToken.getApplicationId();
        }
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        if (str != null) {
            String c3 = a2.b.a.a.a.c3(str, "/custom_audience_third_party_id");
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            Bundle bundle = new Bundle();
            if (accessToken == null) {
                if (attributionIdentifiers != null) {
                    if (attributionIdentifiers.getAttributionId() != null) {
                        str2 = attributionIdentifiers.getAttributionId();
                    } else {
                        str2 = attributionIdentifiers.getAndroidAdvertiserId();
                    }
                    if (attributionIdentifiers.getAttributionId() != null) {
                        bundle.putString("udid", str2);
                    }
                } else {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
            }
            if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                bundle.putString("limit_event_usage", "1");
            }
            return new GraphRequest(accessToken, c3, bundle, HttpMethod.GET, callback);
        }
        throw new FacebookException("Facebook App ID cannot be determined");
    }

    public static GraphRequest newDeleteObjectRequest(@Nullable AccessToken accessToken, String str, Callback callback) {
        return new GraphRequest(accessToken, str, null, HttpMethod.DELETE, callback);
    }

    public static GraphRequest newGraphPathRequest(@Nullable AccessToken accessToken, String str, Callback callback) {
        return new GraphRequest(accessToken, str, null, null, callback);
    }

    public static GraphRequest newMeRequest(@Nullable AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
        return new GraphRequest(accessToken, "me", null, null, new a(graphJSONObjectCallback));
    }

    public static GraphRequest newMyFriendsRequest(@Nullable AccessToken accessToken, GraphJSONArrayCallback graphJSONArrayCallback) {
        return new GraphRequest(accessToken, "me/friends", null, null, new b(graphJSONArrayCallback));
    }

    public static GraphRequest newPlacesSearchRequest(@Nullable AccessToken accessToken, Location location, int i2, int i3, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
        if (location != null || !Utility.isNullOrEmpty(str)) {
            Bundle bundle = new Bundle(5);
            bundle.putString("type", VKApiCommunityFull.PLACE);
            bundle.putInt("limit", i3);
            if (location != null) {
                bundle.putString("center", String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
                bundle.putInt(Sort.DISTANCE, i2);
            }
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString(VKApiConst.Q, str);
            }
            return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new c(graphJSONArrayCallback));
        }
        throw new FacebookException("Either location or searchText must be specified.");
    }

    public static GraphRequest newPostRequest(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, Callback callback) {
        GraphRequest graphRequest = new GraphRequest(accessToken, str, null, HttpMethod.POST, callback);
        graphRequest.setGraphObject(jSONObject);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
        if (str == null) {
            str = ShareInternalUtility.MY_PHOTOS;
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
        }
        return new GraphRequest(accessToken, str, bundle2, HttpMethod.POST, callback);
    }

    public static final void setDefaultBatchApplicationId(String str) {
        o = str;
    }

    public static HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return toHttpConnection(Arrays.asList(graphRequestArr));
    }

    public final void a() {
        if (this.a != null) {
            if (!this.h.containsKey("access_token")) {
                String token = this.a.getToken();
                Logger.registerAccessToken(token);
                this.h.putString("access_token", token);
            }
        } else if (!this.m && !this.h.containsKey("access_token")) {
            String applicationId = FacebookSdk.getApplicationId();
            String clientToken = FacebookSdk.getClientToken();
            if (Utility.isNullOrEmpty(applicationId) || Utility.isNullOrEmpty(clientToken)) {
                Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            } else {
                this.h.putString("access_token", a2.b.a.a.a.e3(applicationId, "|", clientToken));
            }
        }
        this.h.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "android");
        this.h.putString("format", "json");
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.h.putString(Names.DEBUG, "info");
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.h.putString(Names.DEBUG, "warning");
        }
    }

    public final String b(String str, Boolean bool) {
        if (!bool.booleanValue() && this.b == HttpMethod.POST) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.h.keySet()) {
            Object obj = this.h.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (g(obj)) {
                buildUpon.appendQueryParameter(str2, h(obj).toString());
            } else if (this.b == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", obj.getClass().getSimpleName()));
            }
        }
        return buildUpon.toString();
    }

    public final String d() {
        if (p.matcher(this.c).matches()) {
            return this.c;
        }
        return String.format("%s/%s", this.l, this.c);
    }

    public final String e() {
        String str;
        String str2;
        String str3 = this.j;
        if (str3 != null) {
            return str3.toString();
        }
        if (getHttpMethod() != HttpMethod.POST || (str2 = this.c) == null || !str2.endsWith("/videos")) {
            str = ServerProtocol.getGraphUrlBase();
        } else {
            str = ServerProtocol.getGraphVideoUrlBase();
        }
        String format = String.format("%s/%s", str, d());
        a();
        return b(format, Boolean.FALSE);
    }

    public final GraphResponse executeAndWait() {
        return executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    @Nullable
    public final AccessToken getAccessToken() {
        return this.a;
    }

    public final String getBatchEntryDependsOn() {
        return this.f;
    }

    public final String getBatchEntryName() {
        return this.e;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.g;
    }

    public final Callback getCallback() {
        return this.i;
    }

    public final JSONObject getGraphObject() {
        return this.d;
    }

    public final String getGraphPath() {
        return this.c;
    }

    public final HttpMethod getHttpMethod() {
        return this.b;
    }

    public final Bundle getParameters() {
        return this.h;
    }

    public final Object getTag() {
        return this.k;
    }

    public final String getVersion() {
        return this.l;
    }

    public final void setAccessToken(AccessToken accessToken) {
        this.a = accessToken;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.f = str;
    }

    public final void setBatchEntryName(String str) {
        this.e = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.g = z;
    }

    public final void setCallback(Callback callback) {
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.i = new d(this, callback);
        } else {
            this.i = callback;
        }
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final void setGraphPath(String str) {
        this.c = str;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.j == null || httpMethod == HttpMethod.GET) {
            if (httpMethod == null) {
                httpMethod = HttpMethod.GET;
            }
            this.b = httpMethod;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final void setParameters(Bundle bundle) {
        this.h = bundle;
    }

    public final void setSkipClientToken(boolean z) {
        this.m = z;
    }

    public final void setTag(Object obj) {
        this.k = obj;
    }

    public final void setVersion(String str) {
        this.l = str;
    }

    public String toString() {
        StringBuilder Q = a2.b.a.a.a.Q("{Request: ", " accessToken: ");
        Object obj = this.a;
        if (obj == null) {
            obj = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        Q.append(obj);
        Q.append(", graphPath: ");
        Q.append(this.c);
        Q.append(", graphObject: ");
        Q.append(this.d);
        Q.append(", httpMethod: ");
        Q.append(this.b);
        Q.append(", parameters: ");
        Q.append(this.h);
        Q.append("}");
        return Q.toString();
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str) {
        this(accessToken, str, null, null, null);
    }

    public static GraphResponse executeAndWait(GraphRequest graphRequest) {
        List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait != null && executeBatchAndWait.size() == 1) {
            return executeBatchAndWait.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.a = handler;
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    public static HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new GraphRequestBatch(collection));
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new a();
        public final String a;
        public final RESOURCE b;

        public static class a implements Parcelable.Creator<ParcelableResourceWithMimeType> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel, (a) null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public ParcelableResourceWithMimeType[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.a = str;
            this.b = resource;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public String getMimeType() {
            return this.a;
        }

        public RESOURCE getResource() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
        }

        public ParcelableResourceWithMimeType(Parcel parcel, a aVar) {
            this.a = parcel.readString();
            this.b = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod) {
        this(accessToken, str, bundle, httpMethod, null);
    }

    public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return executeBatchAndWait(new GraphRequestBatch(collection));
    }

    public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return executeBatchAsync(new GraphRequestBatch(collection));
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback) {
        this(accessToken, str, bundle, httpMethod, callback, null);
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        try {
            HttpURLConnection httpConnection = toHttpConnection(graphRequestBatch);
            try {
                return executeConnectionAndWait(httpConnection, graphRequestBatch);
            } finally {
                Utility.disconnectQuietly(httpConnection);
            }
        } catch (Exception e2) {
            List<GraphResponse> a3 = GraphResponse.a(graphRequestBatch.b, null, new FacebookException(e2));
            l(graphRequestBatch, a3);
            Utility.disconnectQuietly(null);
            return a3;
        }
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x005d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.HttpURLConnection toHttpConnection(com.facebook.GraphRequestBatch r7) {
        /*
            java.util.Iterator r0 = r7.iterator()
        L_0x0004:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0087
            java.lang.Object r1 = r0.next()
            com.facebook.GraphRequest r1 = (com.facebook.GraphRequest) r1
            com.facebook.HttpMethod r4 = com.facebook.HttpMethod.GET
            com.facebook.HttpMethod r5 = r1.getHttpMethod()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0004
            java.lang.String r4 = r1.getVersion()
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r4)
            if (r5 == 0) goto L_0x0029
            goto L_0x0058
        L_0x0029:
            java.lang.String r5 = "v"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0035
            java.lang.String r4 = r4.substring(r3)
        L_0x0035:
            java.lang.String r5 = "\\."
            java.lang.String[] r4 = r4.split(r5)
            int r5 = r4.length
            r6 = 2
            if (r5 < r6) goto L_0x0047
            r5 = r4[r2]
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 > r6) goto L_0x0058
        L_0x0047:
            r5 = r4[r2]
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 < r6) goto L_0x005a
            r4 = r4[r3]
            int r4 = java.lang.Integer.parseInt(r4)
            r5 = 4
            if (r4 < r5) goto L_0x005a
        L_0x0058:
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            if (r4 == 0) goto L_0x0004
            android.os.Bundle r4 = r1.getParameters()
            java.lang.String r5 = "fields"
            boolean r6 = r4.containsKey(r5)
            if (r6 == 0) goto L_0x0073
            java.lang.String r4 = r4.getString(r5)
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r4)
            if (r4 == 0) goto L_0x0004
        L_0x0073:
            com.facebook.LoggingBehavior r4 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r5 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r1 = r1.getGraphPath()
            r3[r2] = r1
            java.lang.String r1 = "Request"
            java.lang.String r2 = "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter."
            com.facebook.internal.Logger.log(r4, r5, r1, r2, r3)
            goto L_0x0004
        L_0x0087:
            int r0 = r7.size()     // Catch:{ MalformedURLException -> 0x00bb }
            if (r0 != r3) goto L_0x009b
            com.facebook.GraphRequest r0 = r7.get(r2)     // Catch:{ MalformedURLException -> 0x00bb }
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00bb }
            java.lang.String r0 = r0.e()     // Catch:{ MalformedURLException -> 0x00bb }
            r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x00bb }
            goto L_0x00a4
        L_0x009b:
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00bb }
            java.lang.String r0 = com.facebook.internal.ServerProtocol.getGraphUrlBase()     // Catch:{ MalformedURLException -> 0x00bb }
            r1.<init>(r0)     // Catch:{ MalformedURLException -> 0x00bb }
        L_0x00a4:
            r0 = 0
            java.net.HttpURLConnection r0 = c(r1)     // Catch:{ IOException -> 0x00af, JSONException -> 0x00ad }
            n(r7, r0)     // Catch:{ IOException -> 0x00af, JSONException -> 0x00ad }
            return r0
        L_0x00ad:
            r7 = move-exception
            goto L_0x00b0
        L_0x00af:
            r7 = move-exception
        L_0x00b0:
            com.facebook.internal.Utility.disconnectQuietly(r0)
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "could not construct request body"
            r0.<init>(r1, r7)
            throw r0
        L_0x00bb:
            r7 = move-exception
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "could not construct URL for request"
            r0.<init>(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.toHttpConnection(com.facebook.GraphRequestBatch):java.net.HttpURLConnection");
    }

    public GraphRequest(@Nullable AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.g = true;
        this.m = false;
        this.a = accessToken;
        this.c = str;
        this.l = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.h = new Bundle(bundle);
        } else {
            this.h = new Bundle();
        }
        if (this.l == null) {
            this.l = FacebookSdk.getGraphApiVersion();
        }
    }

    public static GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
        if (str == null) {
            str = ShareInternalUtility.MY_PHOTOS;
        }
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
        }
        return new GraphRequest(accessToken, str, bundle2, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadPhotoRequest(@Nullable AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
        if (str == null) {
            str = ShareInternalUtility.MY_PHOTOS;
        }
        if (Utility.isFileUri(uri)) {
            return newUploadPhotoRequest(accessToken, str, new File(uri.getPath()), str2, bundle, callback);
        }
        if (Utility.isContentUri(uri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", uri);
            if (str2 != null && !str2.isEmpty()) {
                bundle2.putString(ShareConstants.FEED_CAPTION_PARAM, str2);
            }
            return new GraphRequest(accessToken, str, bundle2, HttpMethod.POST, callback);
        }
        throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
    }

    public GraphRequest(@Nullable AccessToken accessToken, URL url) {
        this.g = true;
        this.m = false;
        this.a = accessToken;
        this.j = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.h = new Bundle();
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(@Nullable AccessToken accessToken, Context context, Callback callback) {
        return newCustomAudienceThirdPartyIdRequest(accessToken, context, null, callback);
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
    }
}
