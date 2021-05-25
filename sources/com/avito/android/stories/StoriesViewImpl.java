package com.avito.android.stories;

import a2.a.a.a3.a;
import a2.a.a.a3.b;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Outline;
import android.net.Uri;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.DecelerateInterpolator;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.serp.R;
import com.avito.android.ui.view.PowerWebViewWrapper;
import com.avito.android.ui.view.PowerWebViewWrapperImpl;
import com.avito.android.util.Contexts;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Views;
import com.facebook.share.internal.ShareConstants;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.yatatsu.powerwebview.HttpErrorHandlerDelegate;
import com.yatatsu.powerwebview.PowerWebView;
import com.yatatsu.powerwebview.PowerWebViewInterceptor;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0004<=>?B\u0017\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0019\u001a\u00060\u0016R\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0010R\u0016\u00106\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0010R(\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u00101¨\u0006@"}, d2 = {"Lcom/avito/android/stories/StoriesViewImpl;", "Lcom/avito/android/stories/StoriesView;", "", "url", "", "loadUrl", "(Ljava/lang/String;)V", "destroy", "()V", "animateShow", "Lcom/avito/android/stories/State;", "state", "setState", "(Lcom/avito/android/stories/State;)V", "Landroid/view/View;", "e", "Landroid/view/View;", "loading", "Lcom/avito/android/stories/StoriesJSInterface;", "j", "Lcom/avito/android/stories/StoriesJSInterface;", "jsInterface", "Lcom/avito/android/stories/StoriesViewImpl$StoriesWebViewInterceptor;", "i", "Lcom/avito/android/stories/StoriesViewImpl$StoriesWebViewInterceptor;", "urlInterceptor", AuthSource.SEND_ABUSE, "content", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/util/LoadingState;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "loadStatesRelay", "Lcom/avito/android/stories/StoriesPresenter;", "l", "Lcom/avito/android/stories/StoriesPresenter;", "presenter", "Lcom/yatatsu/powerwebview/PowerWebView;", AuthSource.BOOKING_ORDER, "Lcom/yatatsu/powerwebview/PowerWebView;", "webView", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "c", "Lcom/avito/android/ui/view/PowerWebViewWrapper;", "powerWebView", "Lio/reactivex/rxjava3/core/Observable;", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getCloseClicks", "()Lio/reactivex/rxjava3/core/Observable;", "closeClicks", "k", "view", "d", "closeButton", "h", "getLoadStates", "loadStates", "<init>", "(Landroid/view/View;Lcom/avito/android/stories/StoriesPresenter;)V", "StoriesHttpErrorHandlerDelegate", "StoriesJSInterfaceImpl", "StoriesWebViewInterceptor", "StoryViewOutlineProvider", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesViewImpl implements StoriesView {
    public final View a;
    public final PowerWebView b;
    public final PowerWebViewWrapper c;
    public final View d;
    public final View e;
    public final PublishRelay<LoadingState<Unit>> f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<LoadingState<Unit>> h;
    public final StoriesWebViewInterceptor i;
    public final StoriesJSInterface j;
    public final View k;
    public final StoriesPresenter l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/stories/StoriesViewImpl$StoriesHttpErrorHandlerDelegate;", "Lcom/yatatsu/powerwebview/HttpErrorHandlerDelegate;", "Landroid/webkit/WebView;", "view", "Landroid/webkit/WebResourceRequest;", "request", "Landroid/webkit/WebResourceResponse;", "errorResponse", "", "onReceivedHttpError", "(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceResponse;)V", "", "error", "onReceivedJsError", "(Ljava/lang/String;)V", "<init>", "(Lcom/avito/android/stories/StoriesViewImpl;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public final class StoriesHttpErrorHandlerDelegate implements HttpErrorHandlerDelegate {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StoriesHttpErrorHandlerDelegate() {
        }

        @Override // com.yatatsu.powerwebview.HttpErrorHandlerDelegate
        public void onReceivedHttpError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceResponse webResourceResponse) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(webResourceRequest, "request");
            Intrinsics.checkNotNullParameter(webResourceResponse, "errorResponse");
            StoriesViewImpl.this.f.accept(new LoadingState.Error(new ErrorWithMessage.NetworkError(String.valueOf(webResourceResponse.getStatusCode()))));
        }

        @Override // com.yatatsu.powerwebview.HttpErrorHandlerDelegate
        public void onReceivedJsError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            StoriesViewImpl.this.f.accept(new LoadingState.Error(new ErrorWithMessage.NetworkError(str)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/stories/StoriesViewImpl$StoriesJSInterfaceImpl;", "Lcom/avito/android/stories/StoriesJSInterface;", "", "id", "", "storyViewed", "(I)V", "", "arg", "viewReady", "(Z)V", "closeView", "<init>", "(Lcom/avito/android/stories/StoriesViewImpl;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public final class StoriesJSInterfaceImpl implements StoriesJSInterface {

        public static final class a implements Runnable {
            public final /* synthetic */ StoriesJSInterfaceImpl a;

            public a(StoriesJSInterfaceImpl storiesJSInterfaceImpl) {
                this.a = storiesJSInterfaceImpl;
            }

            @Override // java.lang.Runnable
            public final void run() {
                StoriesViewImpl.this.l.closeView();
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ StoriesJSInterfaceImpl a;

            public b(StoriesJSInterfaceImpl storiesJSInterfaceImpl) {
                this.a = storiesJSInterfaceImpl;
            }

            @Override // java.lang.Runnable
            public final void run() {
                StoriesViewImpl.this.l.viewReady();
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StoriesJSInterfaceImpl() {
        }

        @Override // com.avito.android.stories.StoriesJSInterface
        @JavascriptInterface
        public void closeView(boolean z) {
            StoriesViewImpl.this.k.post(new a(this));
        }

        @Override // com.avito.android.stories.StoriesJSInterface
        @JavascriptInterface
        public void storyViewed(int i) {
            StoriesViewImpl.this.l.storyViewed(i);
        }

        @Override // com.avito.android.stories.StoriesJSInterface
        @JavascriptInterface
        public void viewReady(boolean z) {
            StoriesViewImpl.this.k.post(new b(this));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/stories/StoriesViewImpl$StoriesWebViewInterceptor;", "Lcom/yatatsu/powerwebview/PowerWebViewInterceptor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "intercept", "(Landroid/net/Uri;)Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getIgnoredUrl", "()Ljava/lang/String;", "setIgnoredUrl", "(Ljava/lang/String;)V", "ignoredUrl", "<init>", "(Lcom/avito/android/stories/StoriesViewImpl;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public final class StoriesWebViewInterceptor implements PowerWebViewInterceptor {
        @Nullable
        public String a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StoriesWebViewInterceptor() {
        }

        @Nullable
        public final String getIgnoredUrl() {
            return this.a;
        }

        @Override // com.yatatsu.powerwebview.PowerWebViewInterceptor
        public boolean intercept(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            if (Intrinsics.areEqual(uri.toString(), this.a)) {
                return false;
            }
            return StoriesViewImpl.this.l.handleUrl(uri);
        }

        public final void setIgnoredUrl(@Nullable String str) {
            this.a = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/stories/StoriesViewImpl$StoryViewOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "", AuthSource.SEND_ABUSE, "I", "radius", "<init>", "(Lcom/avito/android/stories/StoriesViewImpl;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public final class StoryViewOutlineProvider extends ViewOutlineProvider {
        public int a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public StoryViewOutlineProvider(StoriesViewImpl storiesViewImpl) {
            this.a = Views.dpToPx(storiesViewImpl.k, 15);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) this.a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            State.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            PowerWebViewStateChangeEvent.State.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[3] = 1;
            iArr2[1] = 2;
        }
    }

    public StoriesViewImpl(@NotNull View view, @NotNull StoriesPresenter storiesPresenter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(storiesPresenter, "presenter");
        this.k = view;
        this.l = storiesPresenter;
        View findViewById = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.web_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.yatatsu.powerwebview.PowerWebView");
        PowerWebView powerWebView = (PowerWebView) findViewById2;
        this.b = powerWebView;
        PowerWebViewWrapperImpl powerWebViewWrapperImpl = new PowerWebViewWrapperImpl(powerWebView);
        this.c = powerWebViewWrapperImpl;
        View findViewById3 = view.findViewById(R.id.close);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(R.id.loading);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        PublishRelay<LoadingState<Unit>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        this.g = RxView.clicks(findViewById3);
        Observable<R> startWithItem = powerWebViewWrapperImpl.getStateChangeEvents().filter(a.a).map(b.a).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "filter { it.state == Pow…tem(LoadingState.Loading)");
        Observable<LoadingState<Unit>> mergeWith = create.mergeWith(startWithItem);
        Intrinsics.checkNotNullExpressionValue(mergeWith, "loadStatesRelay.mergeWit…ngeEvents.toLoadStates())");
        this.h = mergeWith;
        StoriesWebViewInterceptor storiesWebViewInterceptor = new StoriesWebViewInterceptor();
        this.i = storiesWebViewInterceptor;
        StoriesJSInterfaceImpl storiesJSInterfaceImpl = new StoriesJSInterfaceImpl();
        this.j = storiesJSInterfaceImpl;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        powerWebView.setBackgroundColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.transparentBlack));
        powerWebView.setLayerType(2, null);
        powerWebView.setHorizontalScrollBarEnabled(false);
        powerWebView.setVerticalScrollBarEnabled(false);
        findViewById.setClipToOutline(true);
        findViewById.setOutlineProvider(new StoryViewOutlineProvider(this));
        powerWebView.setHttpErrorHandlerDelegate(new StoriesHttpErrorHandlerDelegate());
        powerWebViewWrapperImpl.addInterceptor(storiesWebViewInterceptor);
        powerWebViewWrapperImpl.addJavascriptInterface(storiesJSInterfaceImpl, StoriesJSInterfaceKt.STORIES_JS_INTERFACE);
    }

    @Override // com.avito.android.stories.StoriesView
    public void animateShow() {
        View view = this.a;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "content.resources");
        view.setTranslationY((float) resources.getDisplayMetrics().heightPixels);
        this.a.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(350).start();
    }

    @Override // com.avito.android.stories.StoriesView
    public void destroy() {
        this.c.removeJavascriptInterface(StoriesJSInterfaceKt.STORIES_JS_INTERFACE);
        this.c.removeInterceptor(this.i);
        this.b.destroy();
    }

    @Override // com.avito.android.stories.StoriesView
    @NotNull
    public Observable<Unit> getCloseClicks() {
        return this.g;
    }

    @Override // com.avito.android.stories.StoriesView
    @NotNull
    public Observable<LoadingState<Unit>> getLoadStates() {
        return this.h;
    }

    @Override // com.avito.android.stories.StoriesView
    public void loadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.i.setIgnoredUrl(str);
        this.c.loadUrl(str);
    }

    @Override // com.avito.android.stories.StoriesView
    public void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int ordinal = state.ordinal();
        if (ordinal == 0) {
            Views.conceal(this.b);
            Views.show(this.e);
        } else if (ordinal == 1) {
            Views.hide(this.e);
            Views.show(this.b);
            this.b.setAlpha(0.0f);
            this.b.animate().setDuration(250).alpha(1.0f).start();
        }
    }
}
