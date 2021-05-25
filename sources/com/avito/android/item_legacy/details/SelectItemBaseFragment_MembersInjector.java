package com.avito.android.item_legacy.details;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SelectItemBaseFragment_MembersInjector implements MembersInjector<SelectItemBaseFragment> {
    public final Provider<ItemDetailsSelectResultHandler> a;

    public SelectItemBaseFragment_MembersInjector(Provider<ItemDetailsSelectResultHandler> provider) {
        this.a = provider;
    }

    public static MembersInjector<SelectItemBaseFragment> create(Provider<ItemDetailsSelectResultHandler> provider) {
        return new SelectItemBaseFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.item_legacy.details.SelectItemBaseFragment.resultHandler")
    public static void injectResultHandler(SelectItemBaseFragment selectItemBaseFragment, ItemDetailsSelectResultHandler itemDetailsSelectResultHandler) {
        selectItemBaseFragment.resultHandler = itemDetailsSelectResultHandler;
    }

    public void injectMembers(SelectItemBaseFragment selectItemBaseFragment) {
        injectResultHandler(selectItemBaseFragment, this.a.get());
    }
}
