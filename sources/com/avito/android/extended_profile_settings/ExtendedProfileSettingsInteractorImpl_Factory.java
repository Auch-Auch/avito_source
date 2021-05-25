package com.avito.android.extended_profile_settings;

import dagger.internal.Factory;
public final class ExtendedProfileSettingsInteractorImpl_Factory implements Factory<ExtendedProfileSettingsInteractorImpl> {

    public static final class a {
        public static final ExtendedProfileSettingsInteractorImpl_Factory a = new ExtendedProfileSettingsInteractorImpl_Factory();
    }

    public static ExtendedProfileSettingsInteractorImpl_Factory create() {
        return a.a;
    }

    public static ExtendedProfileSettingsInteractorImpl newInstance() {
        return new ExtendedProfileSettingsInteractorImpl();
    }

    @Override // javax.inject.Provider
    public ExtendedProfileSettingsInteractorImpl get() {
        return newInstance();
    }
}
