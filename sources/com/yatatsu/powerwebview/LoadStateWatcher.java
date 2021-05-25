package com.yatatsu.powerwebview;

import android.graphics.Bitmap;
import android.webkit.WebView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/yatatsu/powerwebview/LoadStateWatcher;", "", "Landroid/webkit/WebView;", "webView", "", "url", "Landroid/graphics/Bitmap;", "favicon", "", "onStarted", "(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "onFinished", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "", CommonKt.TAG_ERROR_CODE, "description", "failingUrl", "onError", "(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", "newProgress", "onProgressChanged", "(Landroid/webkit/WebView;I)V", "powerwebview_release"}, k = 1, mv = {1, 4, 2})
public interface LoadStateWatcher {
    void onError(@NotNull WebView webView, int i, @Nullable String str, @Nullable String str2);

    void onFinished(@NotNull WebView webView, @Nullable String str);

    void onProgressChanged(@NotNull WebView webView, int i);

    void onStarted(@NotNull WebView webView, @Nullable String str, @Nullable Bitmap bitmap);
}
