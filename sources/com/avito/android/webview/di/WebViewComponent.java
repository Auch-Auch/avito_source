package com.avito.android.webview.di;

import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.di.PerActivity;
import com.avito.android.webview.WebViewActivity;
import com.facebook.share.internal.ShareConstants;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/webview/di/WebViewComponent;", "", "Lcom/avito/android/webview/WebViewActivity;", "activity", "", "inject", "(Lcom/avito/android/webview/WebViewActivity;)V", "Builder", "webview_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {WebViewDependencies.class}, modules = {WebViewModule.class})
@PerActivity
public interface WebViewComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\tH'¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/webview/di/WebViewComponent$Builder;", "", "Lcom/avito/android/webview/di/WebViewDependencies;", "dependencies", "(Lcom/avito/android/webview/di/WebViewDependencies;)Lcom/avito/android/webview/di/WebViewComponent$Builder;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "withUri", "(Landroid/net/Uri;)Lcom/avito/android/webview/di/WebViewComponent$Builder;", "", "fullScreen", "withFullScreen", "(Z)Lcom/avito/android/webview/di/WebViewComponent$Builder;", "withAuthorization", "Lcom/avito/android/CalledFrom;", "calledFrom", "withCalledFrom", "(Lcom/avito/android/CalledFrom;)Lcom/avito/android/webview/di/WebViewComponent$Builder;", "Lcom/avito/android/webview/di/WebViewComponent;", "build", "()Lcom/avito/android/webview/di/WebViewComponent;", "webview_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        WebViewComponent build();

        @NotNull
        Builder dependencies(@NotNull WebViewDependencies webViewDependencies);

        @BindsInstance
        @NotNull
        Builder withAuthorization(@Named("withAuthorization") boolean z);

        @BindsInstance
        @NotNull
        Builder withCalledFrom(@Nullable CalledFrom calledFrom);

        @BindsInstance
        @NotNull
        Builder withFullScreen(@Named("fullScreen") boolean z);

        @BindsInstance
        @NotNull
        Builder withUri(@NotNull Uri uri);
    }

    void inject(@NotNull WebViewActivity webViewActivity);
}
