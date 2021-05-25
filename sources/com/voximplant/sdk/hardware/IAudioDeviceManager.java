package com.voximplant.sdk.hardware;

import java.util.List;
public interface IAudioDeviceManager {
    void addAudioDeviceEventsListener(IAudioDeviceEventsListener iAudioDeviceEventsListener);

    AudioDevice getActiveDevice();

    List<AudioDevice> getAudioDevices();

    void removeAudioDeviceEventsListener(IAudioDeviceEventsListener iAudioDeviceEventsListener);

    void selectAudioDevice(AudioDevice audioDevice);

    void setAudioFocusChangeListener(IAudioFocusChangeListener iAudioFocusChangeListener);
}
