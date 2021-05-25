package org.webrtc.audio;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Arrays;
import org.webrtc.Logging;
public final class WebRtcAudioUtils {
    private static final String TAG = "WebRtcAudioUtilsExternal";

    @TargetApi(24)
    public static String audioEncodingToString(int i) {
        if (i == 0) {
            return "INVALID";
        }
        switch (i) {
            case 2:
                return "PCM_16BIT";
            case 3:
                return "PCM_8BIT";
            case 4:
                return "PCM_FLOAT";
            case 5:
            case 6:
                return "AC3";
            case 7:
                return "DTS";
            case 8:
                return "DTS_HD";
            case 9:
                return "MP3";
            default:
                return a.M2("Invalid encoding: ", i);
        }
    }

    @TargetApi(24)
    public static String audioSourceToString(int i) {
        switch (i) {
            case 0:
                return MessengerShareContentUtility.PREVIEW_DEFAULT;
            case 1:
                return "MIC";
            case 2:
                return "VOICE_UPLINK";
            case 3:
                return "VOICE_DOWNLINK";
            case 4:
                return "VOICE_CALL";
            case 5:
                return "CAMCORDER";
            case 6:
                return "VOICE_RECOGNITION";
            case 7:
                return "VOICE_COMMUNICATION";
            case 8:
            default:
                return "INVALID";
            case 9:
                return "UNPROCESSED";
            case 10:
                return "VOICE_PERFORMANCE";
        }
    }

    public static String channelMaskToString(int i) {
        return i != 12 ? i != 16 ? "INVALID" : "IN_MONO" : "IN_STEREO";
    }

    public static String deviceTypeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static String getThreadInfo() {
        StringBuilder L = a.L("@[name=");
        L.append(Thread.currentThread().getName());
        L.append(", id=");
        L.append(Thread.currentThread().getId());
        L.append("]");
        return L.toString();
    }

    private static boolean hasMicrophone(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        return audioManager.isVolumeFixed();
    }

    private static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        if (Build.VERSION.SDK_INT >= 23) {
            AudioDeviceInfo[] devices = audioManager.getDevices(3);
            if (devices.length != 0) {
                Logging.d(str, "Audio Devices: ");
                for (AudioDeviceInfo audioDeviceInfo : devices) {
                    StringBuilder L = a.L("  ");
                    L.append(deviceTypeToString(audioDeviceInfo.getType()));
                    L.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
                    if (audioDeviceInfo.getChannelCounts().length > 0) {
                        L.append("channels=");
                        L.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                        L.append(", ");
                    }
                    if (audioDeviceInfo.getEncodings().length > 0) {
                        L.append("encodings=");
                        L.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                        L.append(", ");
                    }
                    if (audioDeviceInfo.getSampleRates().length > 0) {
                        L.append("sample rates=");
                        L.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                        L.append(", ");
                    }
                    L.append("id=");
                    L.append(audioDeviceInfo.getId());
                    Logging.d(str, L.toString());
                }
            }
        }
    }

    public static void logAudioState(String str, Context context, AudioManager audioManager) {
        logDeviceInfo(str);
        logAudioStateBasic(str, context, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, Context context, AudioManager audioManager) {
        StringBuilder L = a.L("Audio State: audio mode: ");
        L.append(modeToString(audioManager.getMode()));
        L.append(", has mic: ");
        L.append(hasMicrophone(context));
        L.append(", mic muted: ");
        L.append(audioManager.isMicrophoneMute());
        L.append(", music active: ");
        L.append(audioManager.isMusicActive());
        L.append(", speakerphone: ");
        L.append(audioManager.isSpeakerphoneOn());
        L.append(", BT SCO: ");
        L.append(audioManager.isBluetoothScoOn());
        Logging.d(str, L.toString());
    }

    private static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(str, "Audio State: ");
        boolean isVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(str, "  fixed volume=" + isVolumeFixed);
        if (!isVolumeFixed) {
            for (int i = 0; i < 6; i++) {
                int i2 = iArr[i];
                StringBuilder sb = new StringBuilder();
                StringBuilder L = a.L("  ");
                L.append(streamTypeToString(i2));
                L.append(": ");
                sb.append(L.toString());
                sb.append("volume=");
                sb.append(audioManager.getStreamVolume(i2));
                sb.append(", max=");
                sb.append(audioManager.getStreamMaxVolume(i2));
                logIsStreamMute(str, audioManager, i2, sb);
                Logging.d(str, sb.toString());
            }
        }
    }

    public static void logDeviceInfo(String str) {
        StringBuilder L = a.L("Android SDK: ");
        L.append(Build.VERSION.SDK_INT);
        L.append(", Release: ");
        L.append(Build.VERSION.RELEASE);
        L.append(", Brand: ");
        L.append(Build.BRAND);
        L.append(", Device: ");
        L.append(Build.DEVICE);
        L.append(", Id: ");
        L.append(Build.ID);
        L.append(", Hardware: ");
        L.append(Build.HARDWARE);
        L.append(", Manufacturer: ");
        L.append(Build.MANUFACTURER);
        L.append(", Model: ");
        L.append(Build.MODEL);
        L.append(", Product: ");
        L.append(Build.PRODUCT);
        Logging.d(str, L.toString());
    }

    private static void logIsStreamMute(String str, AudioManager audioManager, int i, StringBuilder sb) {
        if (Build.VERSION.SDK_INT >= 23) {
            sb.append(", muted=");
            sb.append(audioManager.isStreamMute(i));
        }
    }

    public static String modeToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    private static String streamTypeToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }
}
