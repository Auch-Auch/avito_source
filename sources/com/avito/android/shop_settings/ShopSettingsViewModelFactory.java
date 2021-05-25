package com.avito.android.shop_settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/Kundle;", "e", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/shop_settings/ShopSettingsConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/shop_settings/ShopSettingsConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "interactor", "Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "d", "Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "stringProvider", "Lcom/avito/android/account/AccountStateProvider;", "f", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "<init>", "(Lcom/avito/android/shop_settings/ShopSettingsConverter;Lcom/avito/android/shop_settings/ShopSettingsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/shop_settings/ShopSettingsStringProvider;Lcom/avito/android/util/Kundle;Lcom/avito/android/account/AccountStateProvider;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsViewModelFactory implements ViewModelProvider.Factory {
    public final ShopSettingsConverter a;
    public final ShopSettingsInteractor b;
    public final SchedulersFactory c;
    public final ShopSettingsStringProvider d;
    public final Kundle e;
    public final AccountStateProvider f;

    @Inject
    public ShopSettingsViewModelFactory(@NotNull ShopSettingsConverter shopSettingsConverter, @NotNull ShopSettingsInteractor shopSettingsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ShopSettingsStringProvider shopSettingsStringProvider, @NotNull Kundle kundle, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(shopSettingsConverter, "converter");
        Intrinsics.checkNotNullParameter(shopSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shopSettingsStringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        this.a = shopSettingsConverter;
        this.b = shopSettingsInteractor;
        this.c = schedulersFactory;
        this.d = shopSettingsStringProvider;
        this.e = kundle;
        this.f = accountStateProvider;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ShopSettingsViewModelImpl.class)) {
            return new ShopSettingsViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
