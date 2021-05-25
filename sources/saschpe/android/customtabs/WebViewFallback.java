package saschpe.android.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import saschpe.android.customtabs.CustomTabsHelper;
public final class WebViewFallback implements CustomTabsHelper.CustomTabFallback {
    @Override // saschpe.android.customtabs.CustomTabsHelper.CustomTabFallback
    public void openUri(Context context, Uri uri) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, uri.toString());
        context.startActivity(intent);
    }
}
