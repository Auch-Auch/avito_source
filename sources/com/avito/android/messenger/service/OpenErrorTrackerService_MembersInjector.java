package com.avito.android.messenger.service;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class OpenErrorTrackerService_MembersInjector implements MembersInjector<OpenErrorTrackerService> {
    public final Provider<OpenErrorTracker> a;

    public OpenErrorTrackerService_MembersInjector(Provider<OpenErrorTracker> provider) {
        this.a = provider;
    }

    public static MembersInjector<OpenErrorTrackerService> create(Provider<OpenErrorTracker> provider) {
        return new OpenErrorTrackerService_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.messenger.service.OpenErrorTrackerService.openErrorTracker")
    public static void injectOpenErrorTracker(OpenErrorTrackerService openErrorTrackerService, OpenErrorTracker openErrorTracker) {
        openErrorTrackerService.openErrorTracker = openErrorTracker;
    }

    public void injectMembers(OpenErrorTrackerService openErrorTrackerService) {
        injectOpenErrorTracker(openErrorTrackerService, this.a.get());
    }
}
