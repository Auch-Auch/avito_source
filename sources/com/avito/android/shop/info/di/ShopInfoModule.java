package com.avito.android.shop.info.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.info.ShopInfoInteractor;
import com.avito.android.shop.info.ShopInfoInteractorImpl;
import com.avito.android.shop.info.ShopInfoPresenter;
import com.avito.android.shop.info.ShopInfoPresenterImpl;
import com.avito.android.shop.info.ShopInfoResourceProvider;
import com.avito.android.shop.info.ShopInfoResourceProviderImpl;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/shop/info/di/ShopInfoModule;", "", "Lcom/avito/android/shop/info/ShopInfoInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/shop/info/ShopInfoResourceProvider;", "shopInfoResourceProvider", "Lcom/avito/android/shop/info/ShopInfoPresenter;", "providePresenter", "(Lcom/avito/android/shop/info/ShopInfoInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/info/ShopInfoResourceProvider;)Lcom/avito/android/shop/info/ShopInfoPresenter;", "Lcom/avito/android/shop/remote/ShopsApi;", "api", "provideInteractor", "(Lcom/avito/android/shop/remote/ShopsApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/shop/info/ShopInfoInteractor;", "provideResourceProvider", "()Lcom/avito/android/shop/info/ShopInfoResourceProvider;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Kundle;", "c", "Lcom/avito/android/util/Kundle;", "presenterState", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "shopId", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ShopInfoModule {
    public final Resources a;
    public final String b;
    public final Kundle c;

    public ShopInfoModule(@NotNull Resources resources, @NotNull String str, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.a = resources;
        this.b = str;
        this.c = kundle;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShopInfoInteractor provideInteractor(@NotNull ShopsApi shopsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new ShopInfoInteractorImpl(shopsApi, schedulersFactory3);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShopInfoPresenter providePresenter(@NotNull ShopInfoInteractor shopInfoInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ShopInfoResourceProvider shopInfoResourceProvider) {
        Intrinsics.checkNotNullParameter(shopInfoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(shopInfoResourceProvider, "shopInfoResourceProvider");
        return new ShopInfoPresenterImpl(this.b, shopInfoInteractor, schedulersFactory3, shopInfoResourceProvider, this.c);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShopInfoResourceProvider provideResourceProvider() {
        return new ShopInfoResourceProviderImpl(this.a);
    }
}
