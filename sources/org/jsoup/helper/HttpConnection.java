package org.jsoup.helper;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Typography;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import org.jsoup.Connection;
import org.jsoup.UncheckedIOException;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;
public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
    public static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public Connection.Request a = new Request();
    public Connection.Response b = new Response();

    public static class KeyVal implements Connection.KeyVal {
        public String a;
        public String b;
        public InputStream c;
        public String d;

        public static KeyVal create(String str, String str2) {
            return new KeyVal().key(str).value(str2);
        }

        @Override // org.jsoup.Connection.KeyVal
        public Connection.KeyVal contentType(String str) {
            Validate.notEmpty(str);
            this.d = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public boolean hasInputStream() {
            return this.c != null;
        }

        public String toString() {
            return this.a + "=" + this.b;
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().key(str).value(str2).inputStream(inputStream);
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNull(this.b, "Data input stream must not be null");
            this.c = inputStream;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.a = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.b = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String contentType() {
            return this.d;
        }

        @Override // org.jsoup.Connection.KeyVal
        public InputStream inputStream() {
            return this.c;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String key() {
            return this.a;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String value() {
            return this.b;
        }
    }

    public static class Request extends b<Connection.Request> implements Connection.Request {
        public Proxy e;
        public int f = HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
        public int g = 2097152;
        public boolean h = true;
        public Collection<Connection.KeyVal> i = new ArrayList();
        public String j = null;
        public boolean k = false;
        public boolean l = false;
        public Parser m;
        public boolean n = false;
        public String o = "UTF-8";
        public SSLSocketFactory p;

        public Request() {
            super(null);
            this.b = Connection.Method.GET;
            addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
            addHeader("User-Agent", HttpConnection.DEFAULT_UA);
            this.m = Parser.htmlParser();
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request addHeader(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.addHeader(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.addHeader(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.Connection.Request
        public boolean followRedirects() {
            return this.h;
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreContentType() {
            return this.l;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreHttpErrors() {
            return this.k;
        }

        @Override // org.jsoup.Connection.Request
        public int maxBodySize() {
            return this.g;
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request method(org.jsoup.Connection.Method r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.method(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.method(org.jsoup.Connection$Method):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.o = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request removeCookie(java.lang.String r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.removeCookie(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.removeCookie(java.lang.String):org.jsoup.Connection$Base");
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request removeHeader(java.lang.String r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.removeHeader(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.removeHeader(java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request requestBody(String str) {
            this.j = str;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public SSLSocketFactory sslSocketFactory() {
            return this.p;
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request cookie(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.cookie(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.cookie(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Request
        public Request data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.i.add(keyVal);
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request followRedirects(boolean z) {
            this.h = z;
            return this;
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request header(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.header(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.header(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreContentType(boolean z) {
            this.l = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreHttpErrors(boolean z) {
            this.k = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request maxBodySize(int i2) {
            Validate.isTrue(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
            this.g = i2;
            return this;
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.Connection.Request
        public Request parser(Parser parser) {
            this.m = parser;
            this.n = true;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public String requestBody() {
            return this.j;
        }

        @Override // org.jsoup.Connection.Request
        public void sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.p = sSLSocketFactory;
        }

        @Override // org.jsoup.Connection.Request
        public int timeout() {
            return this.f;
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Base, org.jsoup.Connection$Request] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Request url(java.net.URL r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.url(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Request.url(java.net.URL):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Request
        public Proxy proxy() {
            return this.e;
        }

        @Override // org.jsoup.Connection.Request
        public Request timeout(int i2) {
            Validate.isTrue(i2 >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.f = i2;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Collection<Connection.KeyVal> data() {
            return this.i;
        }

        @Override // org.jsoup.Connection.Request
        public Parser parser() {
            return this.m;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(Proxy proxy) {
            this.e = proxy;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public String postDataCharset() {
            return this.o;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(String str, int i2) {
            this.e = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2));
            return this;
        }
    }

    public static class Response extends b<Connection.Response> implements Connection.Response {
        public static final Pattern p = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        public int e;
        public String f;
        public ByteBuffer g;
        public InputStream h;
        public HttpURLConnection i;
        public String j;
        public String k;
        public boolean l = false;
        public boolean m = false;
        public int n = 0;
        public Connection.Request o;

        public Response() {
            super(null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0305 A[Catch:{ IOException -> 0x03e7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x03ed  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x018f  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0198  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01e2  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0248  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0277 A[Catch:{ IOException -> 0x03ea }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0292 A[Catch:{ IOException -> 0x03e7 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static org.jsoup.helper.HttpConnection.Response b(org.jsoup.Connection.Request r16, org.jsoup.helper.HttpConnection.Response r17) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 1009
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.b(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        public static void f(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.postDataCharset()));
            if (str != null) {
                for (Connection.KeyVal keyVal : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    String key = keyVal.key();
                    String str2 = null;
                    bufferedWriter.write(key == null ? null : key.replace("\"", "%22"));
                    bufferedWriter.write("\"");
                    if (keyVal.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        String value = keyVal.value();
                        if (value != null) {
                            str2 = value.replace("\"", "%22");
                        }
                        bufferedWriter.write(str2);
                        bufferedWriter.write("\"\r\nContent-Type: ");
                        bufferedWriter.write(keyVal.contentType() != null ? keyVal.contentType() : StringExtensionsKt.APPLICATION_OCTET_STREAM);
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.flush();
                        InputStream inputStream = keyVal.inputStream();
                        Pattern pattern = DataUtil.a;
                        byte[] bArr = new byte[32768];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.requestBody() != null) {
                bufferedWriter.write(request.requestBody());
            } else {
                boolean z = true;
                for (Connection.KeyVal keyVal2 : data) {
                    if (!z) {
                        bufferedWriter.append(Typography.amp);
                    } else {
                        z = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response addHeader(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.addHeader(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.addHeader(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Response
        public String body() {
            String str;
            c();
            String str2 = this.j;
            if (str2 == null) {
                str = Charset.forName("UTF-8").decode(this.g).toString();
            } else {
                str = Charset.forName(str2).decode(this.g).toString();
            }
            this.g.rewind();
            return str;
        }

        @Override // org.jsoup.Connection.Response
        public byte[] bodyAsBytes() {
            c();
            return this.g.array();
        }

        @Override // org.jsoup.Connection.Response
        public BufferedInputStream bodyStream() {
            Validate.isTrue(this.l, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            Validate.isFalse(this.m, "Request has already been read");
            this.m = true;
            return ConstrainableInputStream.wrap(this.h, 32768, this.o.maxBodySize());
        }

        @Override // org.jsoup.Connection.Response
        public Connection.Response bufferUp() {
            c();
            return this;
        }

        public final void c() {
            Validate.isTrue(this.l, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            if (this.g == null) {
                Validate.isFalse(this.m, "Request has already been read (with .parse())");
                try {
                    this.g = DataUtil.readToByteBuffer(this.h, this.o.maxBodySize());
                    this.m = true;
                    d();
                } catch (IOException e2) {
                    throw new UncheckedIOException(e2);
                } catch (Throwable th) {
                    this.m = true;
                    d();
                    throw th;
                }
            }
        }

        @Override // org.jsoup.Connection.Response
        public String contentType() {
            return this.k;
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public final void d() {
            InputStream inputStream = this.h;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.h = null;
                    throw th;
                }
                this.h = null;
            }
            HttpURLConnection httpURLConnection = this.i;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.i = null;
            }
        }

        public final void e(HttpURLConnection httpURLConnection, Response response) throws IOException {
            this.i = httpURLConnection;
            this.b = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.a = httpURLConnection.getURL();
            this.e = httpURLConnection.getResponseCode();
            this.f = httpURLConnection.getResponseMessage();
            this.k = httpURLConnection.getContentType();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
                String headerField = httpURLConnection.getHeaderField(i2);
                if (headerFieldKey == null && headerField == null) {
                    break;
                }
                i2++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        ((List) linkedHashMap.get(headerFieldKey)).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    List<String> list = (List) entry.getValue();
                    if (str.equalsIgnoreCase(HttpHeaders.SET_COOKIE)) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    }
                    for (String str3 : list) {
                        addHeader(str, str3);
                    }
                }
            }
            if (response != null) {
                for (Map.Entry entry2 : response.cookies().entrySet()) {
                    if (!hasCookie((String) entry2.getKey())) {
                        cookie((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                response.d();
            }
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ List headers(String str) {
            return super.headers(str);
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response method(org.jsoup.Connection.Method r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.method(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.method(org.jsoup.Connection$Method):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map multiHeaders() {
            return super.multiHeaders();
        }

        @Override // org.jsoup.Connection.Response
        public Document parse() throws IOException {
            Validate.isTrue(this.l, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            if (this.g != null) {
                this.h = new ByteArrayInputStream(this.g.array());
                this.m = false;
            }
            Validate.isFalse(this.m, "Input stream already read and parsed, cannot re-read.");
            Document c = DataUtil.c(this.h, this.j, this.a.toExternalForm(), this.o.parser());
            this.j = c.outputSettings().charset().name();
            this.m = true;
            d();
            return c;
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response removeCookie(java.lang.String r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.removeCookie(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.removeCookie(java.lang.String):org.jsoup.Connection$Base");
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response removeHeader(java.lang.String r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.removeHeader(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.removeHeader(java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Response
        public int statusCode() {
            return this.e;
        }

        @Override // org.jsoup.Connection.Response
        public String statusMessage() {
            return this.f;
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        @Override // org.jsoup.Connection.Response
        public String charset() {
            return this.j;
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response cookie(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.cookie(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.cookie(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response header(java.lang.String r1, java.lang.String r2) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.header(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.header(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        /* Return type fixed from 'org.jsoup.Connection$Base' to match base method */
        /* JADX WARN: Type inference failed for: r1v1, types: [org.jsoup.Connection$Response, org.jsoup.Connection$Base] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jsoup.helper.HttpConnection.b, org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* bridge */ /* synthetic */ org.jsoup.Connection.Response url(java.net.URL r1) {
            /*
                r0 = this;
                org.jsoup.Connection$Base r1 = super.url(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.url(java.net.URL):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Response
        public Response charset(String str) {
            this.j = str;
            return this;
        }

        public Response(Response response) throws IOException {
            super(null);
            if (response != null) {
                int i2 = response.n + 1;
                this.n = i2;
                if (i2 >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", response.url()));
                }
            }
        }
    }

    public static abstract class b<T extends Connection.Base> implements Connection.Base<T> {
        public URL a;
        public Connection.Method b;
        public Map<String, List<String>> c = new LinkedHashMap();
        public Map<String, String> d = new LinkedHashMap();

        public b(a aVar) {
        }

        public final List<String> a(String str) {
            Validate.notNull(str);
            for (Map.Entry<String, List<String>> entry : this.c.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return Collections.emptyList();
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[Catch:{ UnsupportedEncodingException -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0084 A[Catch:{ UnsupportedEncodingException -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0085 A[Catch:{ UnsupportedEncodingException -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0081 A[SYNTHETIC] */
        @Override // org.jsoup.Connection.Base
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T addHeader(java.lang.String r10, java.lang.String r11) {
            /*
                r9 = this;
                org.jsoup.helper.Validate.notEmpty(r10)
                if (r11 != 0) goto L_0x0007
                java.lang.String r11 = ""
            L_0x0007:
                java.util.List r0 = r9.headers(r10)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x001b
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r1 = r9.c
                r1.put(r10, r0)
            L_0x001b:
                java.lang.String r10 = "ISO-8859-1"
                byte[] r10 = r11.getBytes(r10)     // Catch:{ UnsupportedEncodingException -> 0x008d }
                int r1 = r10.length     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r2 = 3
                r3 = 0
                r4 = 1
                if (r1 < r2) goto L_0x004a
                byte r1 = r10[r3]     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r1 = r1 & 255(0xff, float:3.57E-43)
                r5 = 239(0xef, float:3.35E-43)
                if (r1 != r5) goto L_0x004a
                byte r1 = r10[r4]     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r1 = r1 & 255(0xff, float:3.57E-43)
                r5 = 187(0xbb, float:2.62E-43)
                if (r1 != r5) goto L_0x0039
                r1 = 1
                goto L_0x003a
            L_0x0039:
                r1 = 0
            L_0x003a:
                r5 = 2
                byte r5 = r10[r5]     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r5 = r5 & 255(0xff, float:3.57E-43)
                r6 = 191(0xbf, float:2.68E-43)
                if (r5 != r6) goto L_0x0045
                r5 = 1
                goto L_0x0046
            L_0x0045:
                r5 = 0
            L_0x0046:
                r1 = r1 & r5
                if (r1 == 0) goto L_0x004a
                goto L_0x004b
            L_0x004a:
                r2 = 0
            L_0x004b:
                int r1 = r10.length     // Catch:{ UnsupportedEncodingException -> 0x008d }
            L_0x004c:
                if (r2 >= r1) goto L_0x0081
                byte r5 = r10[r2]     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r6 = r5 & 128(0x80, float:1.794E-43)
                if (r6 != 0) goto L_0x0055
                goto L_0x007f
            L_0x0055:
                r6 = r5 & 224(0xe0, float:3.14E-43)
                r7 = 192(0xc0, float:2.69E-43)
                if (r6 != r7) goto L_0x005e
                int r5 = r2 + 1
                goto L_0x006f
            L_0x005e:
                r6 = r5 & 240(0xf0, float:3.36E-43)
                r8 = 224(0xe0, float:3.14E-43)
                if (r6 != r8) goto L_0x0067
                int r5 = r2 + 2
                goto L_0x006f
            L_0x0067:
                r5 = r5 & 248(0xf8, float:3.48E-43)
                r6 = 240(0xf0, float:3.36E-43)
                if (r5 != r6) goto L_0x0082
                int r5 = r2 + 3
            L_0x006f:
                int r6 = r10.length     // Catch:{ UnsupportedEncodingException -> 0x008d }
                if (r5 < r6) goto L_0x0073
                goto L_0x0082
            L_0x0073:
                if (r2 >= r5) goto L_0x007f
                int r2 = r2 + 1
                byte r6 = r10[r2]     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r6 = r6 & r7
                r8 = 128(0x80, float:1.794E-43)
                if (r6 == r8) goto L_0x0073
                goto L_0x0082
            L_0x007f:
                int r2 = r2 + r4
                goto L_0x004c
            L_0x0081:
                r3 = 1
            L_0x0082:
                if (r3 != 0) goto L_0x0085
                goto L_0x008d
            L_0x0085:
                java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x008d }
                java.lang.String r2 = "UTF-8"
                r1.<init>(r10, r2)     // Catch:{ UnsupportedEncodingException -> 0x008d }
                r11 = r1
            L_0x008d:
                r0.add(r11)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.b.addHeader(java.lang.String, java.lang.String):org.jsoup.Connection$Base");
        }

        @Override // org.jsoup.Connection.Base
        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.d.get(str);
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> cookies() {
            return this.d;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.d.containsKey(str);
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return !a(str).isEmpty();
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeaderWithValue(String str, String str2) {
            Validate.notEmpty(str);
            Validate.notEmpty(str2);
            for (String str3 : headers(str)) {
                if (str2.equalsIgnoreCase(str3)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.jsoup.Connection.Base
        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            List<String> a3 = a(str);
            if (a3.size() > 0) {
                return StringUtil.join(a3, ", ");
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public List<String> headers(String str) {
            Validate.notEmpty(str);
            return a(str);
        }

        @Override // org.jsoup.Connection.Base
        public Connection.Method method() {
            return this.b;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, List<String>> multiHeaders() {
            return this.c;
        }

        @Override // org.jsoup.Connection.Base
        public T removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.d.remove(str);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public T removeHeader(String str) {
            Map.Entry<String, List<String>> entry;
            Validate.notEmpty(str, "Header name must not be empty");
            String lowerCase = Normalizer.lowerCase(str);
            Iterator<Map.Entry<String, List<String>>> it = this.c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    entry = null;
                    break;
                }
                entry = it.next();
                if (Normalizer.lowerCase(entry.getKey()).equals(lowerCase)) {
                    break;
                }
            }
            if (entry != null) {
                this.c.remove(entry.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public URL url() {
            return this.a;
        }

        @Override // org.jsoup.Connection.Base
        public T method(Connection.Method method) {
            Validate.notNull(method, "Method must not be null");
            this.b = method;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public T url(URL url) {
            Validate.notNull(url, "URL must not be null");
            this.a = url;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public T cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.d.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> headers() {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.c.size());
            for (Map.Entry<String, List<String>> entry : this.c.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value.size() > 0) {
                    linkedHashMap.put(key, value.get(0));
                }
            }
            return linkedHashMap;
        }

        @Override // org.jsoup.Connection.Base
        public T header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            removeHeader(str);
            addHeader(str, str2);
            return this;
        }
    }

    public static URL a(URL url) {
        try {
            return new URL(new URI(url.toExternalForm().replace(" ", "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return url;
        }
    }

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    @Override // org.jsoup.Connection
    public Connection cookie(String str, String str2) {
        this.a.cookie(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookies(Map<String, String> map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.a.cookie(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2) {
        this.a.data(KeyVal.create(str, str2));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response execute() throws IOException {
        Response b2 = Response.b(this.a, null);
        this.b = b2;
        return b2;
    }

    @Override // org.jsoup.Connection
    public Connection followRedirects(boolean z) {
        this.a.followRedirects(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document get() throws IOException {
        this.a.method(Connection.Method.GET);
        execute();
        return this.b.parse();
    }

    @Override // org.jsoup.Connection
    public Connection header(String str, String str2) {
        this.a.header(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection headers(Map<String, String> map) {
        Validate.notNull(map, "Header map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.a.header(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreContentType(boolean z) {
        this.a.ignoreContentType(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreHttpErrors(boolean z) {
        this.a.ignoreHttpErrors(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection maxBodySize(int i) {
        this.a.maxBodySize(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection method(Connection.Method method) {
        this.a.method(method);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection parser(Parser parser) {
        this.a.parser(parser);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document post() throws IOException {
        this.a.method(Connection.Method.POST);
        execute();
        return this.b.parse();
    }

    @Override // org.jsoup.Connection
    public Connection postDataCharset(String str) {
        this.a.postDataCharset(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(Proxy proxy) {
        this.a.proxy(proxy);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.a.header(HttpHeaders.REFERER, str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Request request() {
        return this.a;
    }

    @Override // org.jsoup.Connection
    public Connection requestBody(String str) {
        this.a.requestBody(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response response() {
        return this.b;
    }

    @Override // org.jsoup.Connection
    public Connection sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.a.sslSocketFactory(sSLSocketFactory);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection timeout(int i) {
        this.a.timeout(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(URL url) {
        this.a.url(url);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.a.header("User-Agent", str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream) {
        this.a.data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(String str, int i) {
        this.a.proxy(str, i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection request(Connection.Request request) {
        this.a = request;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection response(Connection.Response response) {
        this.b = response;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(String str) {
        String str2;
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            Connection.Request request = this.a;
            try {
                str2 = a(new URL(str)).toExternalForm();
            } catch (Exception unused) {
                str2 = str;
            }
            request.url(new URL(str2));
            return this;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Malformed URL: ", str), e);
        }
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream, String str3) {
        this.a.data(KeyVal.create(str, str2, inputStream).contentType(str3));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Map<String, String> map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.a.data(KeyVal.create(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.a.data(KeyVal.create(str, str2));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNull(collection, "Data collection must not be null");
        for (Connection.KeyVal keyVal : collection) {
            this.a.data(keyVal);
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.KeyVal data(String str) {
        Validate.notEmpty(str, "Data key must not be empty");
        for (Connection.KeyVal keyVal : request().data()) {
            if (keyVal.key().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }
}
