package com.avito.android.public_profile;

import com.avito.android.analytics.screens.Screen;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileAdvertsTabBlueprint_Factory implements Factory<ProfileAdvertsTabBlueprint> {
    public final Provider<String> a;
    public final Provider<Screen> b;
    public final Provider<Boolean> c;
    public final Provider<String> d;

    public ProfileAdvertsTabBlueprint_Factory(Provider<String> provider, Provider<Screen> provider2, Provider<Boolean> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ProfileAdvertsTabBlueprint_Factory create(Provider<String> provider, Provider<Screen> provider2, Provider<Boolean> provider3, Provider<String> provider4) {
        return new ProfileAdvertsTabBlueprint_Factory(provider, provider2, provider3, provider4);
    }

    public static ProfileAdvertsTabBlueprint newInstance(String str, Screen screen, boolean z, String str2) {
        return new ProfileAdvertsTabBlueprint(str, screen, z, str2);
    }

    @Override // javax.inject.Provider
    public ProfileAdvertsTabBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get());
    }
}
