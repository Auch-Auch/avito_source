package com.avito.android.in_app_calls.di;

import com.avito.android.Features;
import com.avito.android.calls.audio.CallAudioManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InAppCallsModule_ProvideCallAudioManagerFactory implements Factory<CallAudioManager> {
    public final InAppCallsModule a;
    public final Provider<Features> b;

    public InAppCallsModule_ProvideCallAudioManagerFactory(InAppCallsModule inAppCallsModule, Provider<Features> provider) {
        this.a = inAppCallsModule;
        this.b = provider;
    }

    public static InAppCallsModule_ProvideCallAudioManagerFactory create(InAppCallsModule inAppCallsModule, Provider<Features> provider) {
        return new InAppCallsModule_ProvideCallAudioManagerFactory(inAppCallsModule, provider);
    }

    public static CallAudioManager provideCallAudioManager(InAppCallsModule inAppCallsModule, Features features) {
        return (CallAudioManager) Preconditions.checkNotNullFromProvides(inAppCallsModule.provideCallAudioManager(features));
    }

    @Override // javax.inject.Provider
    public CallAudioManager get() {
        return provideCallAudioManager(this.a, this.b.get());
    }
}
