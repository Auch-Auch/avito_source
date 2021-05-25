package com.avito.android.social_management.adapter;

import dagger.internal.Factory;
public final class SocialEqualityComparator_Factory implements Factory<SocialEqualityComparator> {

    public static final class a {
        public static final SocialEqualityComparator_Factory a = new SocialEqualityComparator_Factory();
    }

    public static SocialEqualityComparator_Factory create() {
        return a.a;
    }

    public static SocialEqualityComparator newInstance() {
        return new SocialEqualityComparator();
    }

    @Override // javax.inject.Provider
    public SocialEqualityComparator get() {
        return newInstance();
    }
}
