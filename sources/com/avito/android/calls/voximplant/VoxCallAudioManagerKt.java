package com.avito.android.calls.voximplant;

import com.avito.android.calls.audio.AudioDevice;
import com.voximplant.sdk.hardware.AudioDevice;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"calls_release"}, k = 2, mv = {1, 4, 2})
public final class VoxCallAudioManagerKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AudioDevice.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            iArr[4] = 5;
        }
    }

    public static final com.avito.android.calls.audio.AudioDevice access$convert(AudioDevice audioDevice) {
        int ordinal = audioDevice.ordinal();
        if (ordinal == 0) {
            return AudioDevice.Bluetooth.INSTANCE;
        }
        if (ordinal == 1) {
            return AudioDevice.Earpiece.INSTANCE;
        }
        if (ordinal == 2) {
            return AudioDevice.None.INSTANCE;
        }
        if (ordinal == 3) {
            return AudioDevice.Speaker.INSTANCE;
        }
        if (ordinal == 4) {
            return AudioDevice.WiredHeadset.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
