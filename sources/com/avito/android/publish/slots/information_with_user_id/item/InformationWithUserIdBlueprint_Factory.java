package com.avito.android.publish.slots.information_with_user_id.item;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InformationWithUserIdBlueprint_Factory implements Factory<InformationWithUserIdBlueprint> {
    public final Provider<InformationWithUserIdItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public InformationWithUserIdBlueprint_Factory(Provider<InformationWithUserIdItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InformationWithUserIdBlueprint_Factory create(Provider<InformationWithUserIdItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new InformationWithUserIdBlueprint_Factory(provider, provider2);
    }

    public static InformationWithUserIdBlueprint newInstance(InformationWithUserIdItemPresenter informationWithUserIdItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new InformationWithUserIdBlueprint(informationWithUserIdItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public InformationWithUserIdBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
