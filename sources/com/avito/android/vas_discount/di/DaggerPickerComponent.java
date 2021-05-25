package com.avito.android.vas_discount.di;

import androidx.lifecycle.ViewModelProvider;
import com.avito.android.component.user_advert.SimpleUserAdvertItemClickListener_Factory;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.component.user_advert.UserAdvertItemPresenter;
import com.avito.android.conveyor_shared_item.bottom_sheet.title.TitlePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_discount.business.DiscountToItemConverter;
import com.avito.android.vas_discount.business.DiscountToItemConverterImpl_Factory;
import com.avito.android.vas_discount.di.PickerComponent;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment_MembersInjector;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelFactory;
import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelFactory_Factory;
import com.avito.android.vas_discount.ui.items.button.ButtonItemBlueprint;
import com.avito.android.vas_discount.ui.items.button.ButtonItemBlueprint_Factory;
import com.avito.android.vas_discount.ui.items.button.ButtonItemPresenter;
import com.avito.android.vas_discount.ui.items.button.ButtonItemPresenter_Factory;
import com.avito.android.vas_discount.ui.items.description.DescriptionItemBlueprint;
import com.avito.android.vas_discount.ui.items.description.DescriptionItemBlueprint_Factory;
import com.avito.android.vas_discount.ui.items.description.DescriptionPresenter_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerPickerComponent implements PickerComponent {
    public Provider<UserAdvertItemClickListener> a;
    public Provider<UserAdvertItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<TitlePresenter> d;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<Set<ItemBlueprint<?, ?>>> f = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<DescriptionItemBlueprint> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<ButtonItemPresenter> i;
    public Provider<ButtonItemBlueprint> j;
    public Provider<ItemBlueprint<?, ?>> k;
    public Provider<Set<ItemBlueprint<?, ?>>> l;
    public Provider<ItemBinder> m;
    public Provider<AdapterPresenter> n;
    public Provider<DiscountResponse> o;
    public Provider<DiscountToItemConverter> p;
    public Provider<DeepLinkIntentFactory> q;
    public Provider<SchedulersFactory> r;
    public Provider<DiscountPickerViewModelFactory> s;
    public Provider<ViewModelProvider.Factory> t;
    public Provider<DiscountPickerViewModel> u;
    public Provider<ItemPresenter<?, ?>> v;

    public static final class b implements PickerComponent.Builder {
        public PickerDependencies a;
        public PickerModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.vas_discount.di.PickerComponent.Builder
        public PickerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PickerDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, PickerModule.class);
            return new DaggerPickerComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.vas_discount.di.PickerComponent.Builder
        public PickerComponent.Builder dependencies(PickerDependencies pickerDependencies) {
            this.a = (PickerDependencies) Preconditions.checkNotNull(pickerDependencies);
            return this;
        }

        @Override // com.avito.android.vas_discount.di.PickerComponent.Builder
        public PickerComponent.Builder discountModule(PickerModule pickerModule) {
            this.b = (PickerModule) Preconditions.checkNotNull(pickerModule);
            return this;
        }
    }

    public static class c implements Provider<DeepLinkIntentFactory> {
        public final PickerDependencies a;

        public c(PickerDependencies pickerDependencies) {
            this.a = pickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final PickerDependencies a;

        public d(PickerDependencies pickerDependencies) {
            this.a = pickerDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPickerComponent(PickerModule pickerModule, PickerDependencies pickerDependencies, a aVar) {
        Provider<UserAdvertItemClickListener> provider = DoubleCheck.provider(SimpleUserAdvertItemClickListener_Factory.create());
        this.a = provider;
        Provider<UserAdvertItemPresenter> provider2 = DoubleCheck.provider(PickerModule_ProvideUserAdvertPresenterFactory.create(pickerModule, provider));
        this.b = provider2;
        this.c = DoubleCheck.provider(PickerModule_ProvideUserAdvertItemListBlueprintFactory.create(pickerModule, provider2));
        Provider<TitlePresenter> provider3 = DoubleCheck.provider(PickerModule_ProvideTitlePresenterFactory.create(pickerModule));
        this.d = provider3;
        this.e = DoubleCheck.provider(PickerModule_ProvideTitleBlueprintFactory.create(pickerModule, provider3));
        DescriptionItemBlueprint_Factory create = DescriptionItemBlueprint_Factory.create(DescriptionPresenter_Factory.create());
        this.g = create;
        this.h = DoubleCheck.provider(create);
        Provider<ButtonItemPresenter> provider4 = DoubleCheck.provider(ButtonItemPresenter_Factory.create());
        this.i = provider4;
        ButtonItemBlueprint_Factory create2 = ButtonItemBlueprint_Factory.create(provider4);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(4, 1).addProvider(this.c).addProvider(this.e).addCollectionProvider(this.f).addProvider(this.h).addProvider(this.k).build();
        this.l = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.m = provider5;
        this.n = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        this.o = DoubleCheck.provider(PickerModule_ProvideDiscountResponseFactory.create(pickerModule));
        Provider<DiscountToItemConverter> provider6 = DoubleCheck.provider(DiscountToItemConverterImpl_Factory.create());
        this.p = provider6;
        c cVar = new c(pickerDependencies);
        this.q = cVar;
        d dVar = new d(pickerDependencies);
        this.r = dVar;
        DiscountPickerViewModelFactory_Factory create3 = DiscountPickerViewModelFactory_Factory.create(this.o, provider6, cVar, dVar);
        this.s = create3;
        Provider<ViewModelProvider.Factory> provider7 = DoubleCheck.provider(create3);
        this.t = provider7;
        this.u = DoubleCheck.provider(PickerModule_ProvideViewModelFactory.create(pickerModule, provider7));
        this.v = DoubleCheck.provider(DescriptionPresenter_Factory.create());
    }

    public static PickerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.vas_discount.di.PickerComponent
    public void inject(DiscountDialogFragment discountDialogFragment) {
        DiscountDialogFragment_MembersInjector.injectItemBinder(discountDialogFragment, this.m.get());
        DiscountDialogFragment_MembersInjector.injectAdapterPresenter(discountDialogFragment, this.n.get());
        DiscountDialogFragment_MembersInjector.injectViewModel(discountDialogFragment, this.u.get());
        DiscountDialogFragment_MembersInjector.injectItemPresenterSet(discountDialogFragment, SetBuilder.newSetBuilder(4).add(this.b.get()).add(this.v.get()).add(this.i.get()).add(this.d.get()).build());
    }
}
