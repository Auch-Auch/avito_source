package com.avito.android.webview;

import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.webview.WebViewView;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/avito/android/webview/WebViewPresenter;", "Lcom/avito/android/webview/WebViewView$Presenter;", "Lcom/avito/android/webview/WebViewView;", "view", "", "onAttachView", "(Lcom/avito/android/webview/WebViewView;)V", "onDetachView", "()V", "Lcom/avito/android/webview/WebViewPresenter$Router;", "router", "onAttachRouter", "(Lcom/avito/android/webview/WebViewPresenter$Router;)V", "onDetachRouter", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "onNewUri", "(Landroid/net/Uri;)V", "onBackPressed", "Router", "webview_release"}, k = 1, mv = {1, 4, 2})
public interface WebViewPresenter extends WebViewView.Presenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/webview/WebViewPresenter$Router;", "", "", "leaveScreen", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "webview_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void openDeepLink(@NotNull DeepLink deepLink);

        void openUrl(@NotNull Uri uri);
    }

    void onAttachRouter(@NotNull Router router);

    void onAttachView(@NotNull WebViewView webViewView);

    void onBackPressed();

    void onDetachRouter();

    void onDetachView();

    void onNewUri(@NotNull Uri uri);
}
