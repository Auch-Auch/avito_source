package a2.t.a.c.p0;

import com.voximplant.sdk.hardware.AudioDevice;
import com.voximplant.sdk.internal.Logger;
import java.util.Comparator;
public class t implements Comparator<AudioDevice> {
    public boolean a = false;
    public AudioDevice b;
    public AudioDevice c;
    public boolean d;

    public t() {
        AudioDevice audioDevice = AudioDevice.NONE;
        this.b = audioDevice;
        this.c = audioDevice;
        this.d = false;
    }

    public void a(AudioDevice audioDevice) {
        Logger.i("AudioDeviceComparator: setNewConnectedAudioDevice: " + audioDevice);
        this.c = audioDevice;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public int compare(AudioDevice audioDevice, AudioDevice audioDevice2) {
        AudioDevice audioDevice3 = audioDevice;
        AudioDevice audioDevice4 = audioDevice2;
        AudioDevice audioDevice5 = this.c;
        if (audioDevice3 == audioDevice5 && this.a) {
            return -1;
        }
        if (audioDevice4 != audioDevice5 || !this.a) {
            AudioDevice audioDevice6 = this.b;
            if (audioDevice3 == audioDevice6 && this.d) {
                return -1;
            }
            if (audioDevice4 != audioDevice6 || !this.d) {
                int ordinal = audioDevice3.ordinal();
                if (ordinal == 0) {
                    return -1;
                }
                if (ordinal != 1) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            return 0;
                        }
                        if (audioDevice4 != AudioDevice.BLUETOOTH) {
                            return -1;
                        }
                    } else if (this.d && this.b == AudioDevice.SPEAKER) {
                        return -1;
                    } else {
                        if (audioDevice4 != AudioDevice.BLUETOOTH && audioDevice4 != AudioDevice.WIRED_HEADSET && this.b == AudioDevice.SPEAKER) {
                            return -1;
                        }
                    }
                } else if (audioDevice4 != AudioDevice.BLUETOOTH && audioDevice4 != AudioDevice.WIRED_HEADSET) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
