package com.google.android.exoplayer2.audio;
public interface AudioListener {
    void onAudioAttributesChanged(AudioAttributes audioAttributes);

    void onAudioSessionId(int i);

    void onSkipSilenceEnabledChanged(boolean z);

    void onVolumeChanged(float f);
}
