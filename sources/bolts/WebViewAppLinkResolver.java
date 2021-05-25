package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import o6.g;
import o6.h;
import org.json.JSONArray;
public class WebViewAppLinkResolver implements AppLinkResolver {
    public final Context a;

    public class a implements Continuation<JSONArray, AppLink> {
        public final /* synthetic */ Uri a;

        public a(WebViewAppLinkResolver webViewAppLinkResolver, Uri uri) {
            this.a = uri;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x0068 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v5, types: [android.net.Uri] */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r10v10, types: [java.util.Map] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // bolts.Continuation
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public bolts.AppLink then(bolts.Task<org.json.JSONArray> r17) throws java.lang.Exception {
            /*
            // Method dump skipped, instructions count: 458
            */
            throw new UnsupportedOperationException("Method not decompiled: bolts.WebViewAppLinkResolver.a.then(bolts.Task):java.lang.Object");
        }
    }

    public class b implements Continuation<Void, Task<JSONArray>> {
        public final /* synthetic */ Capture a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ Capture c;

        public b(Capture capture, Uri uri, Capture capture2) {
            this.a = capture;
            this.b = uri;
            this.c = capture2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Task<JSONArray> then(Task<Void> task) throws Exception {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            WebView webView = new WebView(WebViewAppLinkResolver.this.a);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setNetworkAvailable(false);
            webView.setWebViewClient(new g(this));
            webView.addJavascriptInterface(new h(this, taskCompletionSource), "boltsWebViewAppLinkResolverResult");
            webView.loadDataWithBaseURL(this.b.toString(), (String) this.c.get(), this.a.get() != null ? ((String) this.a.get()).split(";")[0] : null, null, null);
            return taskCompletionSource.getTask();
        }
    }

    public class c implements Callable<Void> {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ Capture b;
        public final /* synthetic */ Capture c;

        public c(WebViewAppLinkResolver webViewAppLinkResolver, Uri uri, Capture capture, Capture capture2) {
            this.a = uri;
            this.b = capture;
            this.c = capture2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            URL url = new URL(this.a.toString());
            URLConnection uRLConnection = null;
            while (url != null) {
                uRLConnection = url.openConnection();
                if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                }
                uRLConnection.setRequestProperty("Prefer-Html-Meta-Tags", "al");
                uRLConnection.connect();
                if (uRLConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                    if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() < 400) {
                        URL url2 = new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
                        httpURLConnection.disconnect();
                        url = url2;
                    }
                }
                url = null;
            }
            try {
                this.b.set(WebViewAppLinkResolver.a(uRLConnection));
                this.c.set(uRLConnection.getContentType());
                return null;
            } finally {
                if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
            }
        }
    }

    public WebViewAppLinkResolver(Context context) {
        this.a = context;
    }

    public static String a(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        int i;
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Exception unused) {
                inputStream = httpURLConnection.getErrorStream();
            }
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                i = 0;
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                String[] split = uRLConnection.getContentType().split(";");
                int length = split.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.startsWith("charset=")) {
                        contentEncoding = trim.substring(8);
                        break;
                    }
                    i++;
                }
                if (contentEncoding == null) {
                    contentEncoding = "UTF-8";
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), contentEncoding);
        } finally {
            inputStream.close();
        }
    }

    public static List<Map<String, Object>> b(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // bolts.AppLinkResolver
    public Task<AppLink> getAppLinkFromUrlInBackground(Uri uri) {
        Capture capture = new Capture();
        Capture capture2 = new Capture();
        return Task.callInBackground(new c(this, uri, capture, capture2)).onSuccessTask(new b(capture2, uri, capture), Task.UI_THREAD_EXECUTOR).onSuccess(new a(this, uri));
    }
}
