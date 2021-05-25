package com.avito.android.express_cv.existed_cv;

import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ExistedCvFragment_MembersInjector implements MembersInjector<ExistedCvFragment> {
    public final Provider<ExistedCvDataProvider> a;
    public final Provider<ItemBinder> b;
    public final Provider<DeviceMetrics> c;
    public final Provider<AdapterPresenter> d;

    public ExistedCvFragment_MembersInjector(Provider<ExistedCvDataProvider> provider, Provider<ItemBinder> provider2, Provider<DeviceMetrics> provider3, Provider<AdapterPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<ExistedCvFragment> create(Provider<ExistedCvDataProvider> provider, Provider<ItemBinder> provider2, Provider<DeviceMetrics> provider3, Provider<AdapterPresenter> provider4) {
        return new ExistedCvFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.express_cv.existed_cv.ExistedCvFragment.adapterPresenter")
    public static void injectAdapterPresenter(ExistedCvFragment existedCvFragment, AdapterPresenter adapterPresenter) {
        existedCvFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.existed_cv.ExistedCvFragment.deviceMetrics")
    public static void injectDeviceMetrics(ExistedCvFragment existedCvFragment, DeviceMetrics deviceMetrics) {
        existedCvFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.existed_cv.ExistedCvFragment.itemBinder")
    public static void injectItemBinder(ExistedCvFragment existedCvFragment, ItemBinder itemBinder) {
        existedCvFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.existed_cv.ExistedCvFragment.viewModel")
    public static void injectViewModel(ExistedCvFragment existedCvFragment, ExistedCvDataProvider existedCvDataProvider) {
        existedCvFragment.viewModel = existedCvDataProvider;
    }

    public void injectMembers(ExistedCvFragment existedCvFragment) {
        injectViewModel(existedCvFragment, this.a.get());
        injectItemBinder(existedCvFragment, this.b.get());
        injectDeviceMetrics(existedCvFragment, this.c.get());
        injectAdapterPresenter(existedCvFragment, this.d.get());
    }
}
