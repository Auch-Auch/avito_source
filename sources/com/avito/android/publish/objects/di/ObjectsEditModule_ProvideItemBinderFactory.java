package com.avito.android.publish.objects.di;

import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Set;
import javax.inject.Provider;
public final class ObjectsEditModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<Set<ItemBlueprint<?, ?>>> a;
    public final Provider<MultiStateSwitcherItemBlueprint> b;
    public final Provider<MultiStateInputItemBlueprint> c;
    public final Provider<ChipsSelectItemBlueprint> d;
    public final Provider<ChipsMultiselectItemBlueprint> e;
    public final Provider<RadioGroupSelectItemBlueprint> f;

    public ObjectsEditModule_ProvideItemBinderFactory(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<MultiStateSwitcherItemBlueprint> provider2, Provider<MultiStateInputItemBlueprint> provider3, Provider<ChipsSelectItemBlueprint> provider4, Provider<ChipsMultiselectItemBlueprint> provider5, Provider<RadioGroupSelectItemBlueprint> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ObjectsEditModule_ProvideItemBinderFactory create(Provider<Set<ItemBlueprint<?, ?>>> provider, Provider<MultiStateSwitcherItemBlueprint> provider2, Provider<MultiStateInputItemBlueprint> provider3, Provider<ChipsSelectItemBlueprint> provider4, Provider<ChipsMultiselectItemBlueprint> provider5, Provider<RadioGroupSelectItemBlueprint> provider6) {
        return new ObjectsEditModule_ProvideItemBinderFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ItemBinder provideItemBinder(Set<ItemBlueprint<?, ?>> set, MultiStateSwitcherItemBlueprint multiStateSwitcherItemBlueprint, MultiStateInputItemBlueprint multiStateInputItemBlueprint, ChipsSelectItemBlueprint chipsSelectItemBlueprint, ChipsMultiselectItemBlueprint chipsMultiselectItemBlueprint, RadioGroupSelectItemBlueprint radioGroupSelectItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(ObjectsEditModule.INSTANCE.provideItemBinder(set, multiStateSwitcherItemBlueprint, multiStateInputItemBlueprint, chipsSelectItemBlueprint, chipsMultiselectItemBlueprint, radioGroupSelectItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
