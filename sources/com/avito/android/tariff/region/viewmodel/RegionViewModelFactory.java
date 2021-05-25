package com.avito.android.tariff.region.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/region/viewmodel/RegionViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "c", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "converter", "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;", "repository", "Lcom/avito/android/util/Kundle;", "f", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/tariff/StringProvider;", "e", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/region/viewmodel/TariffRegionRepository;Lcom/avito/android/tariff/region/viewmodel/RegionConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/util/Kundle;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final TariffRegionRepository b;
    public final RegionConverter c;
    public final SchedulersFactory d;
    public final StringProvider e;
    public final Kundle f;

    @Inject
    public RegionViewModelFactory(@NotNull String str, @NotNull TariffRegionRepository tariffRegionRepository, @NotNull RegionConverter regionConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(tariffRegionRepository, "repository");
        Intrinsics.checkNotNullParameter(regionConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        this.a = str;
        this.b = tariffRegionRepository;
        this.c = regionConverter;
        this.d = schedulersFactory;
        this.e = stringProvider;
        this.f = kundle;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(RegionViewModelImpl.class)) {
            return new RegionViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
