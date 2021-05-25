package com.avito.android.component.profile_snippet;

import dagger.internal.Factory;
public final class AdvertSellerAvatarRenderer_Factory implements Factory<AdvertSellerAvatarRenderer> {

    public static final class a {
        public static final AdvertSellerAvatarRenderer_Factory a = new AdvertSellerAvatarRenderer_Factory();
    }

    public static AdvertSellerAvatarRenderer_Factory create() {
        return a.a;
    }

    public static AdvertSellerAvatarRenderer newInstance() {
        return new AdvertSellerAvatarRenderer();
    }

    @Override // javax.inject.Provider
    public AdvertSellerAvatarRenderer get() {
        return newInstance();
    }
}
