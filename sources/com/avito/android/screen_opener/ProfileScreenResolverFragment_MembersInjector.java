package com.avito.android.screen_opener;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ProfileScreenResolverFragment_MembersInjector implements MembersInjector<ProfileScreenResolverFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<ProfileScreenResolverPresenter> b;
    public final Provider<UnknownScreenTracker> c;

    public ProfileScreenResolverFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<ProfileScreenResolverPresenter> provider2, Provider<UnknownScreenTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MembersInjector<ProfileScreenResolverFragment> create(Provider<ActivityIntentFactory> provider, Provider<ProfileScreenResolverPresenter> provider2, Provider<UnknownScreenTracker> provider3) {
        return new ProfileScreenResolverFragment_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.avito.android.screen_opener.ProfileScreenResolverFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ProfileScreenResolverFragment profileScreenResolverFragment, ActivityIntentFactory activityIntentFactory) {
        profileScreenResolverFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.screen_opener.ProfileScreenResolverFragment.performanceTracker")
    public static void injectPerformanceTracker(ProfileScreenResolverFragment profileScreenResolverFragment, UnknownScreenTracker unknownScreenTracker) {
        profileScreenResolverFragment.performanceTracker = unknownScreenTracker;
    }

    @InjectedFieldSignature("com.avito.android.screen_opener.ProfileScreenResolverFragment.presenter")
    public static void injectPresenter(ProfileScreenResolverFragment profileScreenResolverFragment, ProfileScreenResolverPresenter profileScreenResolverPresenter) {
        profileScreenResolverFragment.presenter = profileScreenResolverPresenter;
    }

    public void injectMembers(ProfileScreenResolverFragment profileScreenResolverFragment) {
        injectActivityIntentFactory(profileScreenResolverFragment, this.a.get());
        injectPresenter(profileScreenResolverFragment, this.b.get());
        injectPerformanceTracker(profileScreenResolverFragment, this.c.get());
    }
}
