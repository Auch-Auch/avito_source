package com.avito.android.tariff.tariff_package_info.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.di.ContractId;
import com.avito.android.util.SchedulersFactory3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "c", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;", "converter", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "packageId", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", "d", "Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", AuthSource.SEND_ABUSE, "contractId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoConverter;Lcom/avito/android/tariff/tariff_package_info/viewmodel/TariffPackageInfoRepository;Lcom/avito/android/util/SchedulersFactory3;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageInfoViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final TariffPackageInfoConverter c;
    public final TariffPackageInfoRepository d;
    public final SchedulersFactory3 e;

    @Inject
    public TariffPackageInfoViewModelFactory(@ContractId @NotNull String str, @NotNull String str2, @NotNull TariffPackageInfoConverter tariffPackageInfoConverter, @NotNull TariffPackageInfoRepository tariffPackageInfoRepository, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "contractId");
        Intrinsics.checkNotNullParameter(str2, "packageId");
        Intrinsics.checkNotNullParameter(tariffPackageInfoConverter, "converter");
        Intrinsics.checkNotNullParameter(tariffPackageInfoRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = str;
        this.b = str2;
        this.c = tariffPackageInfoConverter;
        this.d = tariffPackageInfoRepository;
        this.e = schedulersFactory3;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(TariffPackageInfoViewModelImpl.class)) {
            return new TariffPackageInfoViewModelImpl(this.b, this.a, this.c, this.d, this.e);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
