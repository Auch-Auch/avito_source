package o6;

import android.webkit.JavascriptInterface;
import bolts.TaskCompletionSource;
import bolts.WebViewAppLinkResolver;
import org.json.JSONArray;
import org.json.JSONException;
public class h {
    public final /* synthetic */ TaskCompletionSource a;

    public h(WebViewAppLinkResolver.b bVar, TaskCompletionSource taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @JavascriptInterface
    public void setValue(String str) {
        try {
            this.a.trySetResult(new JSONArray(str));
        } catch (JSONException e) {
            this.a.trySetError(e);
        }
    }
}
