package com.avito.android.safedeal.delivery_courier.di.module;

import com.avito.android.safedeal.delivery_courier.summary.konveyor.button.ButtonItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServicesRadioGroupItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.extra.ExtraItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.image.ImageItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.link.LinkItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemBlueprint;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.text.TextItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<ImageItemBlueprint> a;
    public final Provider<TextItemBlueprint> b;
    public final Provider<HeaderItemBlueprint> c;
    public final Provider<LinkItemBlueprint> d;
    public final Provider<InputItemBlueprint> e;
    public final Provider<SelectItemBlueprint> f;
    public final Provider<DividerItemBlueprint> g;
    public final Provider<ButtonItemBlueprint> h;
    public final Provider<ExtraItemBlueprint> i;
    public final Provider<CourierServicesRadioGroupItemBlueprint> j;
    public final Provider<SingleCourierServiceBlueprint> k;

    public DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory(Provider<ImageItemBlueprint> provider, Provider<TextItemBlueprint> provider2, Provider<HeaderItemBlueprint> provider3, Provider<LinkItemBlueprint> provider4, Provider<InputItemBlueprint> provider5, Provider<SelectItemBlueprint> provider6, Provider<DividerItemBlueprint> provider7, Provider<ButtonItemBlueprint> provider8, Provider<ExtraItemBlueprint> provider9, Provider<CourierServicesRadioGroupItemBlueprint> provider10, Provider<SingleCourierServiceBlueprint> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory create(Provider<ImageItemBlueprint> provider, Provider<TextItemBlueprint> provider2, Provider<HeaderItemBlueprint> provider3, Provider<LinkItemBlueprint> provider4, Provider<InputItemBlueprint> provider5, Provider<SelectItemBlueprint> provider6, Provider<DividerItemBlueprint> provider7, Provider<ButtonItemBlueprint> provider8, Provider<ExtraItemBlueprint> provider9, Provider<CourierServicesRadioGroupItemBlueprint> provider10, Provider<SingleCourierServiceBlueprint> provider11) {
        return new DeliveryCourierSummaryBlueprintsModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static ItemBinder provideItemBinder(ImageItemBlueprint imageItemBlueprint, TextItemBlueprint textItemBlueprint, HeaderItemBlueprint headerItemBlueprint, LinkItemBlueprint linkItemBlueprint, InputItemBlueprint inputItemBlueprint, SelectItemBlueprint selectItemBlueprint, DividerItemBlueprint dividerItemBlueprint, ButtonItemBlueprint buttonItemBlueprint, ExtraItemBlueprint extraItemBlueprint, CourierServicesRadioGroupItemBlueprint courierServicesRadioGroupItemBlueprint, SingleCourierServiceBlueprint singleCourierServiceBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(DeliveryCourierSummaryBlueprintsModule.provideItemBinder(imageItemBlueprint, textItemBlueprint, headerItemBlueprint, linkItemBlueprint, inputItemBlueprint, selectItemBlueprint, dividerItemBlueprint, buttonItemBlueprint, extraItemBlueprint, courierServicesRadioGroupItemBlueprint, singleCourierServiceBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
