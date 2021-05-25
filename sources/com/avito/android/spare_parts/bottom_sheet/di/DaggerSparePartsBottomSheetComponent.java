package com.avito.android.spare_parts.bottom_sheet.di;

import android.content.res.Resources;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsFormatterImpl;
import com.avito.android.spare_parts.SparePartsFormatterImpl_Factory;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl_Factory;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity_MembersInjector;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenter;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenterImpl;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetPresenterImpl_Factory;
import com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemBlueprint;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemBlueprint_Factory;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemPresenter;
import com.avito.android.spare_parts.bottom_sheet.item.SparePartsTextItemPresenter_Factory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl_Factory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSparePartsBottomSheetComponent implements SparePartsBottomSheetComponent {
    public Provider<SparePartsResponse.SparePartsGroup> a;
    public Provider<Resources> b;
    public Provider<SparePartsResourceProviderImpl> c;
    public Provider<SparePartsResourceProvider> d;
    public Provider<SparePartsTextItemPresenter> e;
    public Provider<SparePartsTextItemBlueprint> f;
    public Provider<ItemBinder> g;
    public Provider<AdapterPresenter> h;
    public Provider<AttributedTextFormatter> i;
    public Provider<SparePartsFormatterImpl> j;
    public Provider<SparePartsFormatter> k;
    public Provider<SparePartsBottomSheetPresenterImpl> l;
    public Provider<SparePartsBottomSheetPresenter> m;
    public Provider<SimpleRecyclerAdapter> n = DoubleCheck.provider(SparePartsBottomSheetModule_ProvideAdapterFactory.create(this.h, this.g));

    public static final class b implements SparePartsBottomSheetComponent.Builder {
        public SparePartsResponse.SparePartsGroup a;
        public Resources b;

        public b(a aVar) {
        }

        @Override // com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent.Builder
        public SparePartsBottomSheetComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SparePartsResponse.SparePartsGroup.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerSparePartsBottomSheetComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent.Builder
        public SparePartsBottomSheetComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent.Builder
        public SparePartsBottomSheetComponent.Builder withRootGroup(SparePartsResponse.SparePartsGroup sparePartsGroup) {
            this.a = (SparePartsResponse.SparePartsGroup) Preconditions.checkNotNull(sparePartsGroup);
            return this;
        }
    }

    public DaggerSparePartsBottomSheetComponent(SparePartsResponse.SparePartsGroup sparePartsGroup, Resources resources, a aVar) {
        this.a = InstanceFactory.create(sparePartsGroup);
        Factory create = InstanceFactory.create(resources);
        this.b = create;
        SparePartsResourceProviderImpl_Factory create2 = SparePartsResourceProviderImpl_Factory.create(create);
        this.c = create2;
        Provider<SparePartsResourceProvider> provider = DoubleCheck.provider(create2);
        this.d = provider;
        SparePartsTextItemPresenter_Factory create3 = SparePartsTextItemPresenter_Factory.create(provider);
        this.e = create3;
        SparePartsTextItemBlueprint_Factory create4 = SparePartsTextItemBlueprint_Factory.create(create3);
        this.f = create4;
        Provider<ItemBinder> provider2 = DoubleCheck.provider(SparePartsBottomSheetModule_ProvideItemBinderFactory.create(create4));
        this.g = provider2;
        this.h = DoubleCheck.provider(SparePartsBottomSheetModule_ProvideAdapterPresenterFactory.create(provider2));
        Provider<AttributedTextFormatter> provider3 = DoubleCheck.provider(AttributedTextFormatterImpl_Factory.create());
        this.i = provider3;
        SparePartsFormatterImpl_Factory create5 = SparePartsFormatterImpl_Factory.create(provider3, this.d);
        this.j = create5;
        Provider<SparePartsFormatter> provider4 = DoubleCheck.provider(create5);
        this.k = provider4;
        SparePartsBottomSheetPresenterImpl_Factory create6 = SparePartsBottomSheetPresenterImpl_Factory.create(this.a, this.h, provider4, this.d);
        this.l = create6;
        this.m = DoubleCheck.provider(create6);
    }

    public static SparePartsBottomSheetComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.di.SparePartsBottomSheetComponent
    public void inject(SparePartsBottomSheetActivity sparePartsBottomSheetActivity) {
        SparePartsBottomSheetActivity_MembersInjector.injectPresenter(sparePartsBottomSheetActivity, this.m.get());
        SparePartsBottomSheetActivity_MembersInjector.injectAdapter(sparePartsBottomSheetActivity, this.n.get());
    }
}
