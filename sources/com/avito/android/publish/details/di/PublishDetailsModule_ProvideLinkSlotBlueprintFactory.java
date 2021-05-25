package com.avito.android.publish.details.di;

import com.avito.android.publish.slots.link.item.LinkSlotBlueprint;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDetailsModule_ProvideLinkSlotBlueprintFactory implements Factory<LinkSlotBlueprint> {
    public final PublishDetailsModule a;
    public final Provider<LinkSlotItemPresenter> b;

    public PublishDetailsModule_ProvideLinkSlotBlueprintFactory(PublishDetailsModule publishDetailsModule, Provider<LinkSlotItemPresenter> provider) {
        this.a = publishDetailsModule;
        this.b = provider;
    }

    public static PublishDetailsModule_ProvideLinkSlotBlueprintFactory create(PublishDetailsModule publishDetailsModule, Provider<LinkSlotItemPresenter> provider) {
        return new PublishDetailsModule_ProvideLinkSlotBlueprintFactory(publishDetailsModule, provider);
    }

    public static LinkSlotBlueprint provideLinkSlotBlueprint(PublishDetailsModule publishDetailsModule, LinkSlotItemPresenter linkSlotItemPresenter) {
        return (LinkSlotBlueprint) Preconditions.checkNotNullFromProvides(publishDetailsModule.provideLinkSlotBlueprint(linkSlotItemPresenter));
    }

    @Override // javax.inject.Provider
    public LinkSlotBlueprint get() {
        return provideLinkSlotBlueprint(this.a, this.b.get());
    }
}
