package com.avito.android.user_adverts.tab_screens.advert_list;

import com.avito.android.conveyor_shared_item.single_text.SingleTextPresenter;
import com.avito.android.user_adverts.tab_screens.advert_list.disclaimer.DisclaimerBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory implements Factory<DisclaimerBlueprint> {
    public final UserAdvertsListAdapterModule a;
    public final Provider<SingleTextPresenter> b;

    public UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<SingleTextPresenter> provider) {
        this.a = userAdvertsListAdapterModule;
        this.b = provider;
    }

    public static UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory create(UserAdvertsListAdapterModule userAdvertsListAdapterModule, Provider<SingleTextPresenter> provider) {
        return new UserAdvertsListAdapterModule_ProvideDisclaimerBlueprint$user_adverts_releaseFactory(userAdvertsListAdapterModule, provider);
    }

    public static DisclaimerBlueprint provideDisclaimerBlueprint$user_adverts_release(UserAdvertsListAdapterModule userAdvertsListAdapterModule, SingleTextPresenter singleTextPresenter) {
        return (DisclaimerBlueprint) Preconditions.checkNotNullFromProvides(userAdvertsListAdapterModule.provideDisclaimerBlueprint$user_adverts_release(singleTextPresenter));
    }

    @Override // javax.inject.Provider
    public DisclaimerBlueprint get() {
        return provideDisclaimerBlueprint$user_adverts_release(this.a, this.b.get());
    }
}
