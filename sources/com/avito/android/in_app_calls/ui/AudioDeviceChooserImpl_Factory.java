package com.avito.android.in_app_calls.ui;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.calls.audio.CallAudioManager;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AudioDeviceChooserImpl_Factory implements Factory<AudioDeviceChooserImpl> {
    public final Provider<CallAudioManager> a;
    public final Provider<FragmentActivity> b;

    public AudioDeviceChooserImpl_Factory(Provider<CallAudioManager> provider, Provider<FragmentActivity> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AudioDeviceChooserImpl_Factory create(Provider<CallAudioManager> provider, Provider<FragmentActivity> provider2) {
        return new AudioDeviceChooserImpl_Factory(provider, provider2);
    }

    public static AudioDeviceChooserImpl newInstance(CallAudioManager callAudioManager, FragmentActivity fragmentActivity) {
        return new AudioDeviceChooserImpl(callAudioManager, fragmentActivity);
    }

    @Override // javax.inject.Provider
    public AudioDeviceChooserImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
