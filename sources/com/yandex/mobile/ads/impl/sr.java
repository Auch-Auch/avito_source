package com.yandex.mobile.ads.impl;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
public final class sr implements sq {
    private final a a;
    private final SSLSocketFactory b;

    public interface a {
        String a();
    }

    public sr() {
        this((byte) 0);
    }

    @Override // com.yandex.mobile.ads.impl.sq
    public final HttpResponse a(ry<?> ryVar, Map<String, String> map) throws IOException, se {
        SSLSocketFactory sSLSocketFactory;
        String b2 = ryVar.b();
        HashMap hashMap = new HashMap();
        hashMap.putAll(ryVar.a());
        hashMap.putAll(map);
        a aVar = this.a;
        if (aVar != null) {
            String a3 = aVar.a();
            if (a3 != null) {
                b2 = a3;
            } else {
                throw new IOException("URL blocked by rewriter: ".concat(String.valueOf(b2)));
            }
        }
        URL url = new URL(b2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int p = ryVar.p();
        httpURLConnection.setConnectTimeout(p);
        httpURLConnection.setReadTimeout(p);
        httpURLConnection.setUseCaches(false);
        boolean z = true;
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        for (String str : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(str, (String) hashMap.get(str));
        }
        switch (ryVar.d()) {
            case -1:
                break;
            case 0:
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                break;
            case 1:
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                a(httpURLConnection, ryVar);
                break;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                a(httpURLConnection, ryVar);
                break;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                break;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                break;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                break;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                break;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                a(httpURLConnection, ryVar);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnection.getResponseCode() != -1) {
            BasicStatusLine basicStatusLine = new BasicStatusLine(protocolVersion, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage());
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
            int d = ryVar.d();
            int statusCode = basicStatusLine.getStatusCode();
            if (d == 4 || ((100 <= statusCode && statusCode < 200) || statusCode == 204 || statusCode == 304)) {
                z = false;
            }
            if (z) {
                basicHttpResponse.setEntity(a(httpURLConnection));
            }
            for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    private sr(byte b2) {
        this((SSLSocketFactory) null);
    }

    public sr(SSLSocketFactory sSLSocketFactory) {
        this.a = null;
        this.b = sSLSocketFactory;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private static void a(HttpURLConnection httpURLConnection, ry<?> ryVar) throws IOException, se {
        byte[] c = ryVar.c();
        if (c != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", ry.k());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(c);
            dataOutputStream.close();
        }
    }
}
