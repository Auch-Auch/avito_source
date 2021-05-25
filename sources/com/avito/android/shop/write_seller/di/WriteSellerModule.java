package com.avito.android.shop.write_seller.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.shop.write_seller.WriteSellerInteractor;
import com.avito.android.shop.write_seller.WriteSellerInteractorImpl;
import com.avito.android.shop.write_seller.WriteSellerPresenter;
import com.avito.android.shop.write_seller.WriteSellerPresenterImpl;
import com.avito.android.shop.write_seller.WriteSellerPresenterResourceProviderImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/shop/write_seller/di/WriteSellerModule;", "", "Lcom/avito/android/shop/remote/ShopsApi;", "api", "Lcom/avito/android/shop/write_seller/WriteSellerInteractor;", "provideWriteSellerInteractor", "(Lcom/avito/android/shop/remote/ShopsApi;)Lcom/avito/android/shop/write_seller/WriteSellerInteractor;", "interactor", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "provideWriteSellerPresenter", "(Lcom/avito/android/shop/write_seller/WriteSellerInteractor;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/shop/write_seller/WriteSellerPresenter;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "shopId", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "state", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class WriteSellerModule {
    public final Context a;
    public final String b;
    public final Bundle c;

    public WriteSellerModule(@NotNull Context context, @NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.a = context;
        this.b = str;
        this.c = bundle;
    }

    @Provides
    @PerActivity
    @NotNull
    public final WriteSellerInteractor provideWriteSellerInteractor(@NotNull ShopsApi shopsApi) {
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        return new WriteSellerInteractorImpl(shopsApi);
    }

    @Provides
    @PerActivity
    @NotNull
    public final WriteSellerPresenter provideWriteSellerPresenter(@NotNull WriteSellerInteractor writeSellerInteractor, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(writeSellerInteractor, "interactor");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        String str = this.b;
        WriteSellerPresenterResourceProviderImpl writeSellerPresenterResourceProviderImpl = new WriteSellerPresenterResourceProviderImpl(this.a);
        Resources resources = this.a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return new WriteSellerPresenterImpl(str, writeSellerInteractor, schedulersFactory3, writeSellerPresenterResourceProviderImpl, new ErrorFormatterImpl(resources), accountStorageInteractor.toBlocking().getProfile(), this.c);
    }
}
