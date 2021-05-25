package com.avito.android.tns_gallery.di;

import android.app.Activity;
import com.avito.android.Features;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGalleryItemPresenterImpl;
import com.avito.android.tns_gallery.TnsGalleryItemSizeHelperImpl;
import com.avito.android.tns_gallery.TnsGallerySettings;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.tns_gallery.TnsGalleryViewImpl_MembersInjector;
import com.avito.android.tns_gallery.di.TnsGalleryComponent;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Preconditions;
import io.reactivex.rxjava3.functions.Consumer;
public final class DaggerTnsGalleryComponent implements TnsGalleryComponent {
    public final Consumer<TnsGalleryItemClickAction> a;
    public final Activity b;
    public final TnsGallerySettings c;
    public final Features d;

    public static final class b implements TnsGalleryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.tns_gallery.di.TnsGalleryComponent.Factory
        public TnsGalleryComponent create(Consumer<TnsGalleryItemClickAction> consumer, Activity activity, TnsGallerySettings tnsGallerySettings, Features features) {
            Preconditions.checkNotNull(consumer);
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(tnsGallerySettings);
            Preconditions.checkNotNull(features);
            return new DaggerTnsGalleryComponent(consumer, activity, tnsGallerySettings, features, null);
        }
    }

    public DaggerTnsGalleryComponent(Consumer consumer, Activity activity, TnsGallerySettings tnsGallerySettings, Features features, a aVar) {
        this.a = consumer;
        this.b = activity;
        this.c = tnsGallerySettings;
        this.d = features;
    }

    public static TnsGalleryComponent.Factory factory() {
        return new b(null);
    }

    public final ItemBinder a() {
        return TnsGalleryItemModule_ProvideItemBinderFactory.provideItemBinder(new TnsGalleryItemPresenterImpl(this.a, new TnsGalleryItemSizeHelperImpl(this.b, this.c)), this.d);
    }

    @Override // com.avito.android.tns_gallery.di.TnsGalleryComponent
    public void inject(TnsGalleryViewImpl tnsGalleryViewImpl) {
        TnsGalleryViewImpl_MembersInjector.injectAdapterPresenter(tnsGalleryViewImpl, TnsGalleryItemModule_ProvideAdapterPresenterFactory.provideAdapterPresenter(a()));
        TnsGalleryViewImpl_MembersInjector.injectItemBinder(tnsGalleryViewImpl, a());
        TnsGalleryViewImpl_MembersInjector.injectFeatures(tnsGalleryViewImpl, this.d);
    }
}
