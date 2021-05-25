package com.voximplant.sdk.hardware;
public interface IAudioFileListener {
    void onPrepared(IAudioFile iAudioFile);

    void onStart(IAudioFile iAudioFile);

    void onStop(IAudioFile iAudioFile);
}
