package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_PublishReviewFromChatChannelFactory implements Factory<SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_PublishReviewFromChatChannelFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_PublishReviewFromChatChannelFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_PublishReviewFromChatChannelFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChatChannel(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.publishReviewFromChatChannel(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> get() {
        return publishReviewFromChatChannel(this.a, this.b.get());
    }
}
