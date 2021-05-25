package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.util.SchedulersFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BlacklistReasonsFragment_MembersInjector implements MembersInjector<BlacklistReasonsFragment> {
    public final Provider<SchedulersFactory> a;
    public final Provider<BlacklistReasonsPresenter> b;

    public BlacklistReasonsFragment_MembersInjector(Provider<SchedulersFactory> provider, Provider<BlacklistReasonsPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<BlacklistReasonsFragment> create(Provider<SchedulersFactory> provider, Provider<BlacklistReasonsPresenter> provider2) {
        return new BlacklistReasonsFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment.presenter")
    public static void injectPresenter(BlacklistReasonsFragment blacklistReasonsFragment, BlacklistReasonsPresenter blacklistReasonsPresenter) {
        blacklistReasonsFragment.presenter = blacklistReasonsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist_reasons.BlacklistReasonsFragment.schedulers")
    public static void injectSchedulers(BlacklistReasonsFragment blacklistReasonsFragment, SchedulersFactory schedulersFactory) {
        blacklistReasonsFragment.schedulers = schedulersFactory;
    }

    public void injectMembers(BlacklistReasonsFragment blacklistReasonsFragment) {
        injectSchedulers(blacklistReasonsFragment, this.a.get());
        injectPresenter(blacklistReasonsFragment, this.b.get());
    }
}
