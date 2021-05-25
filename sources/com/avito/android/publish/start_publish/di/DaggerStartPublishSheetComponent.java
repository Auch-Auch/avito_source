package com.avito.android.publish.start_publish.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.publish.start_publish.StartPublishSheet_MembersInjector;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemBlueprint;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemBlueprintImpl;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemBlueprintImpl_Factory;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenterImpl_Factory;
import com.avito.android.publish.start_publish.di.StartPublishSheetComponent;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;
public final class DaggerStartPublishSheetComponent implements StartPublishSheetComponent {
    public Provider<CategoryShortcutItemPresenter> a;
    public Provider<CategoryShortcutItemBlueprintImpl> b;
    public Provider<CategoryShortcutItemBlueprint> c;
    public Provider<ItemBinder> d;
    public Provider<AdapterPresenter> e;
    public Provider<RecyclerView.Adapter<?>> f;

    public static final class b implements StartPublishSheetComponent.Builder {
        public b(a aVar) {
        }

        @Override // com.avito.android.publish.start_publish.di.StartPublishSheetComponent.Builder
        public StartPublishSheetComponent build() {
            return new DaggerStartPublishSheetComponent(new StartPublishSheetModule(), null);
        }
    }

    public DaggerStartPublishSheetComponent(StartPublishSheetModule startPublishSheetModule, a aVar) {
        Provider<CategoryShortcutItemPresenter> provider = DoubleCheck.provider(CategoryShortcutItemPresenterImpl_Factory.create());
        this.a = provider;
        CategoryShortcutItemBlueprintImpl_Factory create = CategoryShortcutItemBlueprintImpl_Factory.create(provider);
        this.b = create;
        Provider<CategoryShortcutItemBlueprint> provider2 = DoubleCheck.provider(create);
        this.c = provider2;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(StartPublishSheetModule_ProvideItemBinder$publish_releaseFactory.create(startPublishSheetModule, provider2));
        this.d = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(StartPublishSheetModule_ProvideAdapterPresenter$publish_releaseFactory.create(startPublishSheetModule, provider3));
        this.e = provider4;
        this.f = DoubleCheck.provider(StartPublishSheetModule_ProvideAdapterFactory.create(startPublishSheetModule, provider4, this.d));
    }

    public static StartPublishSheetComponent.Builder builder() {
        return new b(null);
    }

    public static StartPublishSheetComponent create() {
        return new DaggerStartPublishSheetComponent(new StartPublishSheetModule(), null);
    }

    @Override // com.avito.android.publish.start_publish.di.StartPublishSheetComponent
    public void inject(StartPublishSheet startPublishSheet) {
        StartPublishSheet_MembersInjector.injectAdapter(startPublishSheet, this.f.get());
        StartPublishSheet_MembersInjector.injectAdapterPresenter(startPublishSheet, this.e.get());
        StartPublishSheet_MembersInjector.injectCategoryShortcutItemPresenter(startPublishSheet, this.a.get());
    }
}
