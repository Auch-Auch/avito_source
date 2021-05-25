package com.voximplant.sdk.hardware;

import androidx.annotation.Nullable;
public interface IAudioFile {
    void play(boolean z);

    void release();

    void setAudioFileListener(@Nullable IAudioFileListener iAudioFileListener);

    void stop(boolean z);
}
