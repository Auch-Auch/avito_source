package com.avito.android.short_term_rent.di.module;

import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.conveyor_shared_item.notification.NotificationItemBlueprint;
import com.avito.android.short_term_rent.confirm_booking.items.link.LinkItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<InputItemBlueprint> a;
    public final Provider<NotificationItemBlueprint> b;
    public final Provider<ButtonItemBlueprint> c;
    public final Provider<SummaryItemBlueprint> d;
    public final Provider<LinkItemBlueprint> e;
    public final Provider<DisclaimerItemBlueprint> f;

    public StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory(Provider<InputItemBlueprint> provider, Provider<NotificationItemBlueprint> provider2, Provider<ButtonItemBlueprint> provider3, Provider<SummaryItemBlueprint> provider4, Provider<LinkItemBlueprint> provider5, Provider<DisclaimerItemBlueprint> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory create(Provider<InputItemBlueprint> provider, Provider<NotificationItemBlueprint> provider2, Provider<ButtonItemBlueprint> provider3, Provider<SummaryItemBlueprint> provider4, Provider<LinkItemBlueprint> provider5, Provider<DisclaimerItemBlueprint> provider6) {
        return new StrConfirmBookingBlueprintsModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ItemBinder provideItemBinder(InputItemBlueprint inputItemBlueprint, NotificationItemBlueprint notificationItemBlueprint, ButtonItemBlueprint buttonItemBlueprint, SummaryItemBlueprint summaryItemBlueprint, LinkItemBlueprint linkItemBlueprint, DisclaimerItemBlueprint disclaimerItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(StrConfirmBookingBlueprintsModule.provideItemBinder(inputItemBlueprint, notificationItemBlueprint, buttonItemBlueprint, summaryItemBlueprint, linkItemBlueprint, disclaimerItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
