package com.avito.android.autodeal_details;

import a2.a.a.n.f;
import a2.g.r.g;
import android.webkit.CookieManager;
import androidx.lifecycle.ViewModel;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/autodeal_details/AutoDealDetailsViewModel;", "", "onCleared", "()V", "Lcom/avito/android/cookie_provider/CookieProvider;", "h", "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getUrlChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "urlChanges", "Lcom/avito/android/autodeal_details/WebViewAction;", "d", "getWebViewAction", "webViewAction", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "f", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "jsInterface", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "jsInterfaceDisposable", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroid/webkit/CookieManager;", "i", "Landroid/webkit/CookieManager;", "cookieManager", "url", "<init>", "(Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/cookie_provider/CookieProvider;Landroid/webkit/CookieManager;Ljava/lang/String;)V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsViewModelImpl extends ViewModel implements AutoDealDetailsViewModel {
    @NotNull
    public final SingleLiveEvent<String> c = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<WebViewAction> d = new SingleLiveEvent<>();
    public Disposable e;
    public final AutoDealDetailsJSInterface f;
    public final SchedulersFactory g;
    public final CookieProvider h;
    public final CookieManager i;

    public AutoDealDetailsViewModelImpl(@NotNull AutoDealDetailsJSInterface autoDealDetailsJSInterface, @NotNull SchedulersFactory schedulersFactory, @NotNull CookieProvider cookieProvider, @NotNull CookieManager cookieManager, @NotNull String str) {
        Intrinsics.checkNotNullParameter(autoDealDetailsJSInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(cookieProvider, "cookieProvider");
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        Intrinsics.checkNotNullParameter(str, "url");
        this.f = autoDealDetailsJSInterface;
        this.g = schedulersFactory;
        this.h = cookieProvider;
        this.i = cookieManager;
        Iterator<T> it = cookieProvider.getCookies().iterator();
        while (it.hasNext()) {
            this.i.setCookie(".avito.ru", it.next());
        }
        this.e = this.f.getEvents().observeOn(this.g.mainThread()).subscribe(new f(this));
        getUrlChanges().setValue(str);
    }

    @Override // com.avito.android.autodeal_details.AutoDealDetailsViewModel
    @NotNull
    public SingleLiveEvent<String> getUrlChanges() {
        return this.c;
    }

    @Override // com.avito.android.autodeal_details.AutoDealDetailsViewModel
    @NotNull
    public SingleLiveEvent<WebViewAction> getWebViewAction() {
        return this.d;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
        super.onCleared();
    }
}
