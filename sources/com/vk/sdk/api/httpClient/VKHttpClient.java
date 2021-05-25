package com.vk.sdk.api.httpClient;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdkVersion;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.util.VKUtil;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
public class VKHttpClient {
    public static final ExecutorService a = Executors.newFixedThreadPool(3);
    public static final ExecutorService b = Executors.newSingleThreadExecutor();
    public static final String sDefaultStringEncoding = "UTF-8";

    public static class VKHTTPRequest {
        public HttpURLConnection connection;
        public VKMultipartEntity entity = null;
        public Map<String, String> headers = null;
        public boolean isAborted = false;
        public URL methodUrl = null;
        public List<Pair<String, String>> parameters = null;
        public int timeout = 20000;

        public VKHTTPRequest(@Nullable String str) {
            if (str != null) {
                try {
                    this.methodUrl = new URL(str);
                } catch (MalformedURLException unused) {
                }
            }
        }

        public void abort() {
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.isAborted = true;
        }

        public String getQuery() throws UnsupportedEncodingException {
            if (this.parameters == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.parameters.size());
            for (Pair<String, String> pair : this.parameters) {
                Object obj = pair.first;
                if (!(obj == null || pair.second == null)) {
                    arrayList.add(String.format("%s=%s", URLEncoder.encode((String) obj, "UTF-8"), URLEncoder.encode((String) pair.second, "UTF-8")));
                }
            }
            return TextUtils.join("&", arrayList);
        }
    }

    public interface VKHttpProgressCallback {
        void onProgress(long j, long j2);
    }

    public static class VKHttpResponse {
        public final long contentLength;
        public final byte[] responseBytes;
        public Map<String, String> responseHeaders = null;
        public final int statusCode;

        public VKHttpResponse(HttpURLConnection httpURLConnection, VKHttpProgressCallback vKHttpProgressCallback) throws IOException {
            String str;
            this.statusCode = httpURLConnection.getResponseCode();
            this.contentLength = (long) httpURLConnection.getContentLength();
            if (httpURLConnection.getHeaderFields() != null) {
                this.responseHeaders = new HashMap();
                for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                    this.responseHeaders.put(entry.getKey(), TextUtils.join(",", entry.getValue()));
                }
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            Map<String, String> map = this.responseHeaders;
            if (!(map == null || (str = map.get("Content-Encoding")) == null || !str.equalsIgnoreCase("gzip"))) {
                inputStream = new GZIPInputStream(inputStream);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            long j = 0;
            vKHttpProgressCallback = this.contentLength <= 0 ? null : vKHttpProgressCallback;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    j += (long) read;
                    if (vKHttpProgressCallback != null) {
                        vKHttpProgressCallback.onProgress(j, this.contentLength);
                    }
                } else {
                    inputStream.close();
                    byteArrayOutputStream.flush();
                    this.responseBytes = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return;
                }
            }
        }
    }

    public static class a implements Runnable {
        public final /* synthetic */ VKAbstractOperation a;

        public a(VKAbstractOperation vKAbstractOperation) {
            this.a = vKAbstractOperation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.start(VKHttpClient.b);
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ VKHttpOperation a;

        public b(VKHttpOperation vKHttpOperation) {
            this.a = vKHttpOperation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.getUriRequest().abort();
        }
    }

    public static void cancelHttpOperation(VKHttpOperation vKHttpOperation) {
        a.execute(new b(vKHttpOperation));
    }

    public static VKHTTPRequest docUploadRequest(@NonNull String str, File file) {
        VKHTTPRequest vKHTTPRequest = new VKHTTPRequest(str);
        vKHTTPRequest.entity = new VKMultipartEntity(new File[]{file}, VKAttachments.TYPE_DOC);
        return vKHTTPRequest;
    }

    public static void enqueueOperation(VKAbstractOperation vKAbstractOperation) {
        a.execute(new a(vKAbstractOperation));
    }

    public static VKHttpResponse execute(VKHTTPRequest vKHTTPRequest) throws IOException {
        PackageManager packageManager;
        HttpURLConnection httpURLConnection = (HttpURLConnection) vKHTTPRequest.methodUrl.openConnection();
        vKHTTPRequest.connection = httpURLConnection;
        httpURLConnection.setReadTimeout(vKHTTPRequest.timeout);
        vKHTTPRequest.connection.setConnectTimeout(vKHTTPRequest.timeout + 5000);
        vKHTTPRequest.connection.setRequestMethod(ShareTarget.METHOD_POST);
        vKHTTPRequest.connection.setUseCaches(false);
        vKHTTPRequest.connection.setDoInput(true);
        vKHTTPRequest.connection.setDoOutput(true);
        try {
            Context applicationContext = VKUIHelper.getApplicationContext();
            if (!(applicationContext == null || (packageManager = applicationContext.getPackageManager()) == null)) {
                PackageInfo packageInfo = packageManager.getPackageInfo(applicationContext.getPackageName(), 0);
                vKHTTPRequest.connection.setRequestProperty("User-Agent", String.format(Locale.US, "%s/%s (%s; Android %d; Scale/%.2f; VK SDK %s; %s)", VKUtil.getApplicationName(applicationContext), packageInfo.versionName, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Float.valueOf(applicationContext.getResources().getDisplayMetrics().density), VKSdkVersion.SDK_VERSION, packageInfo.packageName));
            }
        } catch (Exception unused) {
        }
        vKHTTPRequest.connection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
        Map<String, String> map = vKHTTPRequest.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                vKHTTPRequest.connection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (vKHTTPRequest.entity != null) {
            HttpURLConnection httpURLConnection2 = vKHTTPRequest.connection;
            httpURLConnection2.addRequestProperty("Content-length", vKHTTPRequest.entity.getContentLength() + "");
            Pair<String, String> contentType = vKHTTPRequest.entity.getContentType();
            vKHTTPRequest.connection.addRequestProperty((String) contentType.first, (String) contentType.second);
        }
        OutputStream outputStream = vKHTTPRequest.connection.getOutputStream();
        VKMultipartEntity vKMultipartEntity = vKHTTPRequest.entity;
        if (vKMultipartEntity != null) {
            vKMultipartEntity.writeTo(outputStream);
        } else {
            String query = vKHTTPRequest.getQuery();
            if (query != null && query.length() > 0) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(query);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        }
        outputStream.close();
        vKHTTPRequest.connection.connect();
        VKHttpResponse vKHttpResponse = new VKHttpResponse(vKHTTPRequest.connection, null);
        if (vKHTTPRequest.isAborted) {
            return null;
        }
        return vKHttpResponse;
    }

    public static VKHTTPRequest fileUploadRequest(@NonNull String str, File... fileArr) {
        VKHTTPRequest vKHTTPRequest = new VKHTTPRequest(str);
        vKHTTPRequest.entity = new VKMultipartEntity(fileArr);
        return vKHTTPRequest;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001c: APUT  (r3v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r0v1 java.lang.String) */
    public static VKHTTPRequest requestWithVkRequest(@NonNull VKRequest vKRequest) {
        VKAccessToken currentToken = VKAccessToken.currentToken();
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = (vKRequest.secure || (currentToken != null && currentToken.httpsRequired)) ? "s" : "";
        objArr[1] = vKRequest.methodName;
        VKHTTPRequest vKHTTPRequest = new VKHTTPRequest(String.format(locale, "http%s://api.vk.com/method/%s", objArr));
        vKHTTPRequest.headers = new a2.s.a.a.f.a();
        VKParameters preparedParameters = vKRequest.getPreparedParameters();
        ArrayList arrayList = new ArrayList(preparedParameters.size());
        for (Map.Entry entry : preparedParameters.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof VKAttachments) {
                arrayList.add(new Pair(entry.getKey(), ((VKAttachments) value).toAttachmentsString()));
            } else if (value instanceof Collection) {
                arrayList.add(new Pair(entry.getKey(), TextUtils.join(",", (Collection) value)));
            } else {
                arrayList.add(new Pair(entry.getKey(), value == null ? null : String.valueOf(value)));
            }
        }
        vKHTTPRequest.parameters = arrayList;
        return vKHTTPRequest;
    }
}
