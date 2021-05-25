package com.avito.android.express_cv.new_cv;

import com.avito.android.express_cv.NewCvDataProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class NewCvFragment_MembersInjector implements MembersInjector<NewCvFragment> {
    public final Provider<NewCvDataProvider> a;
    public final Provider<ItemBinder> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<DeviceMetrics> d;

    public NewCvFragment_MembersInjector(Provider<NewCvDataProvider> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3, Provider<DeviceMetrics> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<NewCvFragment> create(Provider<NewCvDataProvider> provider, Provider<ItemBinder> provider2, Provider<AdapterPresenter> provider3, Provider<DeviceMetrics> provider4) {
        return new NewCvFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.express_cv.new_cv.NewCvFragment.adapterPresenter")
    public static void injectAdapterPresenter(NewCvFragment newCvFragment, AdapterPresenter adapterPresenter) {
        newCvFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.new_cv.NewCvFragment.deviceMetrics")
    public static void injectDeviceMetrics(NewCvFragment newCvFragment, DeviceMetrics deviceMetrics) {
        newCvFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.new_cv.NewCvFragment.itemBinder")
    public static void injectItemBinder(NewCvFragment newCvFragment, ItemBinder itemBinder) {
        newCvFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.express_cv.new_cv.NewCvFragment.viewModel")
    public static void injectViewModel(NewCvFragment newCvFragment, NewCvDataProvider newCvDataProvider) {
        newCvFragment.viewModel = newCvDataProvider;
    }

    public void injectMembers(NewCvFragment newCvFragment) {
        injectViewModel(newCvFragment, this.a.get());
        injectItemBinder(newCvFragment, this.b.get());
        injectAdapterPresenter(newCvFragment, this.c.get());
        injectDeviceMetrics(newCvFragment, this.d.get());
    }
}
