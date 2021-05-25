package com.avito.android.autodeal_details;

import android.webkit.CookieManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "url", "Landroid/webkit/CookieManager;", "e", "Landroid/webkit/CookieManager;", "cookieManager", "Lcom/avito/android/cookie_provider/CookieProvider;", "d", "Lcom/avito/android/cookie_provider/CookieProvider;", "cookieProvider", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;", "jsInterface", "<init>", "(Ljava/lang/String;Lcom/avito/android/autodeal_details/AutoDealDetailsJSInterface;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/cookie_provider/CookieProvider;Landroid/webkit/CookieManager;)V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final AutoDealDetailsJSInterface b;
    public final SchedulersFactory c;
    public final CookieProvider d;
    public final CookieManager e;

    @Inject
    public AutoDealDetailsViewModelFactory(@NotNull String str, @NotNull AutoDealDetailsJSInterface autoDealDetailsJSInterface, @NotNull SchedulersFactory schedulersFactory, @NotNull CookieProvider cookieProvider, @NotNull CookieManager cookieManager) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(autoDealDetailsJSInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(cookieProvider, "cookieProvider");
        Intrinsics.checkNotNullParameter(cookieManager, "cookieManager");
        this.a = str;
        this.b = autoDealDetailsJSInterface;
        this.c = schedulersFactory;
        this.d = cookieProvider;
        this.e = cookieManager;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(AutoDealDetailsViewModelImpl.class)) {
            return new AutoDealDetailsViewModelImpl(this.b, this.c, this.d, this.e, this.a);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
