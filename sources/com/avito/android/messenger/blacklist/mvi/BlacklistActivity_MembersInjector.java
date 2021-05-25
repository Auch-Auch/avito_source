package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.ActivityIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BlacklistActivity_MembersInjector implements MembersInjector<BlacklistActivity> {
    public final Provider<ActivityIntentFactory> a;

    public BlacklistActivity_MembersInjector(Provider<ActivityIntentFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<BlacklistActivity> create(Provider<ActivityIntentFactory> provider) {
        return new BlacklistActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.blacklist.mvi.BlacklistActivity.activityIntentFactory")
    public static void injectActivityIntentFactory(BlacklistActivity blacklistActivity, ActivityIntentFactory activityIntentFactory) {
        blacklistActivity.activityIntentFactory = activityIntentFactory;
    }

    public void injectMembers(BlacklistActivity blacklistActivity) {
        injectActivityIntentFactory(blacklistActivity, this.a.get());
    }
}
