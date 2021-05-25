package com.avito.android.social_management.adapter;

import dagger.internal.Factory;
public final class SocialContentsComparator_Factory implements Factory<SocialContentsComparator> {

    public static final class a {
        public static final SocialContentsComparator_Factory a = new SocialContentsComparator_Factory();
    }

    public static SocialContentsComparator_Factory create() {
        return a.a;
    }

    public static SocialContentsComparator newInstance() {
        return new SocialContentsComparator();
    }

    @Override // javax.inject.Provider
    public SocialContentsComparator get() {
        return newInstance();
    }
}
