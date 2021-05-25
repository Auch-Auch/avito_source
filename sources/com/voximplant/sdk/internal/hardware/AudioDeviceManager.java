package com.voximplant.sdk.internal.hardware;

import com.voximplant.sdk.hardware.AudioDevice;
import com.voximplant.sdk.hardware.IAudioDeviceEventsListener;
import com.voximplant.sdk.hardware.IAudioDeviceManager;
import com.voximplant.sdk.hardware.IAudioFocusChangeListener;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.hardware.VoxAudioManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class AudioDeviceManager implements IAudioDeviceManager {
    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public void addAudioDeviceEventsListener(IAudioDeviceEventsListener iAudioDeviceEventsListener) {
        VoxAudioManager.getInstance().q.add(iAudioDeviceEventsListener);
    }

    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public AudioDevice getActiveDevice() {
        VoxAudioManager instance = VoxAudioManager.getInstance();
        Objects.requireNonNull(instance);
        Logger.i("VoxAudioManager: getSelectedAudioDevice: " + instance.i);
        return instance.i;
    }

    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public List<AudioDevice> getAudioDevices() {
        VoxAudioManager instance = VoxAudioManager.getInstance();
        Objects.requireNonNull(instance);
        Logger.i("VoxAudioManager: getAudioDevices: " + instance.l);
        return Collections.unmodifiableList(new ArrayList(instance.l));
    }

    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public void removeAudioDeviceEventsListener(IAudioDeviceEventsListener iAudioDeviceEventsListener) {
        VoxAudioManager.getInstance().q.remove(iAudioDeviceEventsListener);
    }

    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public void selectAudioDevice(AudioDevice audioDevice) {
        AudioDevice audioDevice2;
        VoxAudioManager instance = VoxAudioManager.getInstance();
        Objects.requireNonNull(instance);
        Logger.i("VoxAudioManager: selectAudioDevice: " + audioDevice);
        if (instance.l.isEmpty() || (!instance.l.contains(audioDevice) && audioDevice != AudioDevice.NONE)) {
            Logger.e("VoxAudioManager: selectAudioDevice: Can not select " + audioDevice + " from available " + instance.l);
        } else if (audioDevice != AudioDevice.EARPIECE || (instance.i != (audioDevice2 = AudioDevice.WIRED_HEADSET) && !instance.l.contains(audioDevice2))) {
            instance.o.post(new Runnable(audioDevice) { // from class: a2.t.a.c.p0.n
                public final /* synthetic */ AudioDevice b;

                {
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VoxAudioManager voxAudioManager = VoxAudioManager.this;
                    AudioDevice audioDevice3 = this.b;
                    AudioDevice audioDevice4 = voxAudioManager.l.get(0);
                    AudioDevice audioDevice5 = AudioDevice.SPEAKER;
                    if (audioDevice4 != audioDevice5 || audioDevice3 != AudioDevice.NONE) {
                        voxAudioManager.j = audioDevice3;
                    } else if (voxAudioManager.a() && voxAudioManager.l.size() > 2 && voxAudioManager.l.get(1) == AudioDevice.EARPIECE) {
                        voxAudioManager.j = voxAudioManager.l.get(2);
                    } else if (voxAudioManager.l.size() > 1) {
                        voxAudioManager.j = voxAudioManager.l.get(1);
                    } else {
                        Logger.w("VoxAudioManager: selectAudioDevice: SPEAKER is the only one available device, can not select another");
                        voxAudioManager.j = audioDevice5;
                    }
                    t tVar = voxAudioManager.r;
                    Objects.requireNonNull(tVar);
                    Logger.i("AudioDeviceComparator: setPriorityForSelectedDevice: true");
                    tVar.d = true;
                    t tVar2 = voxAudioManager.r;
                    AudioDevice audioDevice6 = voxAudioManager.j;
                    Objects.requireNonNull(tVar2);
                    Logger.i("AudioDeviceComparator: setUserSelectedAudioDevice: " + audioDevice6);
                    tVar2.b = audioDevice6;
                    voxAudioManager.d();
                }
            });
        } else {
            Logger.e("VoxAudioManager: selectAudioDevice: Can not select " + audioDevice + " while wired headset is connected");
        }
    }

    @Override // com.voximplant.sdk.hardware.IAudioDeviceManager
    public void setAudioFocusChangeListener(IAudioFocusChangeListener iAudioFocusChangeListener) {
        VoxAudioManager.getInstance().p = iAudioFocusChangeListener;
    }
}
