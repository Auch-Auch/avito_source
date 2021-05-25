package com.voximplant.sdk.hardware;

import java.util.List;
public interface IAudioDeviceEventsListener {
    void onAudioDeviceChanged(AudioDevice audioDevice);

    void onAudioDeviceListChanged(List<AudioDevice> list);
}
