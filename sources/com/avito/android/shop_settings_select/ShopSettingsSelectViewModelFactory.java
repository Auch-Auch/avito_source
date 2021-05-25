package com.avito.android.shop_settings_select;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;", "converter", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/Kundle;", "d", "Lcom/avito/android/util/Kundle;", "savedState", "<init>", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectRepository;Lcom/avito/android/shop_settings_select/ShopSettingsSelectConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectViewModelFactory implements ViewModelProvider.Factory {
    public final ShopSettingsSelectRepository a;
    public final ShopSettingsSelectConverter b;
    public final SchedulersFactory c;
    public final Kundle d;

    @Inject
    public ShopSettingsSelectViewModelFactory(@NotNull ShopSettingsSelectRepository shopSettingsSelectRepository, @NotNull ShopSettingsSelectConverter shopSettingsSelectConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectRepository, "repository");
        Intrinsics.checkNotNullParameter(shopSettingsSelectConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.a = shopSettingsSelectRepository;
        this.b = shopSettingsSelectConverter;
        this.c = schedulersFactory;
        this.d = kundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ShopSettingsSelectViewModelImpl.class)) {
            return new ShopSettingsSelectViewModelImpl(this.a, this.b, this.c, this.d);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
