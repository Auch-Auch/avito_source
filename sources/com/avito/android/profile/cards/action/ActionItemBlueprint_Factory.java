package com.avito.android.profile.cards.action;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ActionItemBlueprint_Factory implements Factory<ActionItemBlueprint> {
    public final Provider<ActionItemPresenter> a;

    public ActionItemBlueprint_Factory(Provider<ActionItemPresenter> provider) {
        this.a = provider;
    }

    public static ActionItemBlueprint_Factory create(Provider<ActionItemPresenter> provider) {
        return new ActionItemBlueprint_Factory(provider);
    }

    public static ActionItemBlueprint newInstance(ActionItemPresenter actionItemPresenter) {
        return new ActionItemBlueprint(actionItemPresenter);
    }

    @Override // javax.inject.Provider
    public ActionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
