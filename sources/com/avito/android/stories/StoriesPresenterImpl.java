package com.avito.android.stories;

import a2.g.r.g;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.CookieManager;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.serp.R;
import com.avito.android.stories.StoriesPresenter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010-R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/avito/android/stories/StoriesPresenterImpl;", "Lcom/avito/android/stories/StoriesPresenter;", "Lcom/avito/android/stories/StoriesView;", "view", "", "attachView", "(Lcom/avito/android/stories/StoriesView;)V", "", "getLastViewed", "()Ljava/lang/String;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "handleUrl", "(Landroid/net/Uri;)Z", "", "id", "storyViewed", "(I)V", "viewReady", "()V", "closeView", "detachView", "Lcom/avito/android/stories/StoriesPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/stories/StoriesPresenter$Router;)V", "detachRouter", "Lcom/avito/android/stories/StoriesArguments;", "j", "Lcom/avito/android/stories/StoriesArguments;", "arguments", "Landroid/webkit/CookieManager;", g.a, "Landroid/webkit/CookieManager;", "cookieManager", AuthSource.SEND_ABUSE, "Lcom/avito/android/stories/StoriesView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/stories/StoriesPresenter$Router;", "Lcom/avito/android/stories/StoriesInteractor;", "f", "Lcom/avito/android/stories/StoriesInteractor;", "storiesInteractor", "d", "Ljava/lang/String;", "url", "Landroid/content/res/Resources;", "k", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "i", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "e", "lastViewedId", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/cookie_provider/CookieProvider;", "h", "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "<init>", "(Lcom/avito/android/stories/StoriesInteractor;Landroid/webkit/CookieManager;Lcom/avito/android/cookie_provider/CookieProvider;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/stories/StoriesArguments;Landroid/content/res/Resources;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesPresenterImpl implements StoriesPresenter {
    public StoriesView a;
    public StoriesPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final String d;
    public String e;
    public final StoriesInteractor f;
    public final CookieManager g;
    public final CookieProvider h;
    public final DeepLinkFactory i;
    public final StoriesArguments j;
    public final Resources k;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ StoriesPresenterImpl a;

        public a(StoriesPresenterImpl storiesPresenterImpl) {
            this.a = storiesPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            StoriesPresenter.Router router = this.a.b;
            if (router != null) {
                StoriesPresenter.Router.DefaultImpls.close$default(router, null, 1, null);
            }
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ StoriesPresenterImpl a;
        public final /* synthetic */ StoriesView b;

        public b(StoriesPresenterImpl storiesPresenterImpl, StoriesView storiesView) {
            this.a = storiesPresenterImpl;
            this.b = storiesView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.b.setState(State.LOADING);
            } else if (loadingState2 instanceof LoadingState.Error) {
                StoriesPresenter.Router router = this.a.b;
                if (router != null) {
                    router.close(this.a.k.getString(R.string.network_unavailable_message));
                }
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorWithMessage) {
                    Logs.error$default("StoriesPresenter load error", ((ErrorWithMessage) error).getMessage(), null, 4, null);
                }
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("StoriesPresenter", "LoadStatesError", th);
        }
    }

    @Inject
    public StoriesPresenterImpl(@NotNull StoriesInteractor storiesInteractor, @NotNull CookieManager cookieManager, @NotNull CookieProvider cookieProvider, @NotNull DeepLinkFactory deepLinkFactory, @NotNull StoriesArguments storiesArguments, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(storiesInteractor, "storiesInteractor");
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        Intrinsics.checkNotNullParameter(cookieProvider, "cookieProvider");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(storiesArguments, "arguments");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f = storiesInteractor;
        this.g = cookieManager;
        this.h = cookieProvider;
        this.i = deepLinkFactory;
        this.j = storiesArguments;
        this.k = resources;
        String builder = Uri.parse(storiesArguments.getUrl()).buildUpon().appendQueryParameter("selectedId", storiesArguments.getCurrentStoryId()).appendQueryParameter("storyIds", CollectionsKt___CollectionsKt.joinToString$default(storiesArguments.getStories(), "-", null, null, 0, null, null, 62, null)).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "Uri.parse(arguments.url)…)\n            .toString()");
        this.d = builder;
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void attachRouter(@NotNull StoriesPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void attachView(@NotNull StoriesView storiesView) {
        Intrinsics.checkNotNullParameter(storiesView, "view");
        this.a = storiesView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = storiesView.getCloseClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.closeClicks.subscribe { router?.close() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = storiesView.getLoadStates().subscribe(new b(this, storiesView), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.loadStates.subscrib…\"LoadStatesError\", it) })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        this.f.resetLastUpdatedTimestamp();
        CookieManager cookieManager = this.g;
        cookieManager.setAcceptCookie(true);
        Iterator<T> it = this.h.getCookies().iterator();
        while (it.hasNext()) {
            cookieManager.setCookie(".avito.ru", it.next());
        }
        storiesView.loadUrl(this.d);
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void closeView() {
        StoriesPresenter.Router router = this.b;
        if (router != null) {
            StoriesPresenter.Router.DefaultImpls.close$default(router, null, 1, null);
        }
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void detachView() {
        StoriesView storiesView = this.a;
        if (storiesView != null) {
            storiesView.destroy();
        }
        this.a = null;
        this.c.clear();
    }

    @Override // com.avito.android.stories.StoriesPresenter
    @Nullable
    public String getLastViewed() {
        return this.e;
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public boolean handleUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.i.createFromUri(uri);
        if (!(createFromUri instanceof NoMatchLink)) {
            try {
                StoriesPresenter.Router router = this.b;
                if (router == null) {
                    return true;
                }
                router.openDeepLink(createFromUri);
                return true;
            } catch (Exception e2) {
                Logs.error("StoriesPresenter", "openDeepLinkError", e2);
                return false;
            }
        } else {
            StoriesPresenter.Router router2 = this.b;
            if (router2 == null) {
                return true;
            }
            router2.openUrl(uri);
            return true;
        }
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void storyViewed(int i2) {
        this.e = String.valueOf(i2);
        this.f.markStoryViewed(i2);
    }

    @Override // com.avito.android.stories.StoriesPresenter
    public void viewReady() {
        StoriesView storiesView = this.a;
        if (storiesView != null) {
            storiesView.setState(State.READY);
        }
    }
}
