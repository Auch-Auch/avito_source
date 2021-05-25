package com.voximplant.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.voximplant.sdk.client.ClientConfig;
import com.voximplant.sdk.client.IClient;
import com.voximplant.sdk.client.ILogListener;
import com.voximplant.sdk.hardware.AudioFileUsage;
import com.voximplant.sdk.hardware.IAudioDeviceManager;
import com.voximplant.sdk.hardware.IAudioFile;
import com.voximplant.sdk.hardware.ICameraManager;
import com.voximplant.sdk.hardware.ICustomVideoSource;
import com.voximplant.sdk.internal.Client;
import com.voximplant.sdk.internal.Logger;
import com.voximplant.sdk.internal.hardware.AudioDeviceManager;
import com.voximplant.sdk.internal.hardware.AudioFile;
import com.voximplant.sdk.internal.hardware.CustomVideoSource;
import com.voximplant.sdk.internal.hardware.VoxCameraManager;
import com.voximplant.sdk.internal.messaging.Messenger;
import com.voximplant.sdk.internal.messaging.MessengerPushNotificationProcessing;
import com.voximplant.sdk.messaging.IMessenger;
import com.voximplant.sdk.messaging.IMessengerPushNotificationProcessing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
public class Voximplant {
    public static IClient a;
    public static IMessenger b;
    public static IAudioDeviceManager c;
    public static String subVersion;

    @Nullable
    public static IAudioFile createAudioFile(@NonNull Context context, @NonNull Uri uri, AudioFileUsage audioFileUsage) {
        AudioFile audioFile = new AudioFile();
        if (audioFile.initialize(context, uri, audioFileUsage)) {
            return audioFile;
        }
        return null;
    }

    public static synchronized IAudioDeviceManager getAudioDeviceManager() {
        IAudioDeviceManager iAudioDeviceManager;
        synchronized (Voximplant.class) {
            if (c == null) {
                c = new AudioDeviceManager();
            }
            iAudioDeviceManager = c;
        }
        return iAudioDeviceManager;
    }

    public static synchronized ICameraManager getCameraManager(Context context) {
        VoxCameraManager instance;
        synchronized (Voximplant.class) {
            instance = VoxCameraManager.getInstance(context);
        }
        return instance;
    }

    public static synchronized IClient getClientInstance(Executor executor, Context context, ClientConfig clientConfig) {
        IClient iClient;
        synchronized (Voximplant.class) {
            if (a == null) {
                a = new Client(executor, context, clientConfig);
            }
            iClient = a;
        }
        return iClient;
    }

    public static synchronized ICustomVideoSource getCustomVideoSource() {
        CustomVideoSource customVideoSource;
        synchronized (Voximplant.class) {
            customVideoSource = new CustomVideoSource();
        }
        return customVideoSource;
    }

    public static synchronized IMessenger getMessenger() {
        IMessenger iMessenger;
        synchronized (Voximplant.class) {
            if (b == null) {
                b = new Messenger();
            }
            iMessenger = b;
        }
        return iMessenger;
    }

    public static IMessengerPushNotificationProcessing getMessengerPushNotificationProcessing() {
        return MessengerPushNotificationProcessing.getInstance();
    }

    public static List<String> getMissingPermissions(Context context, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("android.permission.INTERNET");
        arrayList2.add("android.permission.RECORD_AUDIO");
        if (z) {
            arrayList2.add("android.permission.CAMERA");
        }
        arrayList2.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList2.add("android.permission.CHANGE_NETWORK_STATE");
        arrayList2.add("android.permission.MODIFY_AUDIO_SETTINGS");
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(context.checkPermission(str, Process.myPid(), Process.myUid()) == 0)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void setLogListener(ILogListener iLogListener) {
        Logger.setLogListener(iLogListener);
    }

    @Nullable
    public static IAudioFile createAudioFile(@NonNull String str, AudioFileUsage audioFileUsage) {
        AudioFile audioFile = new AudioFile();
        if (audioFile.initialize(str, audioFileUsage)) {
            return audioFile;
        }
        return null;
    }

    @Nullable
    public static IAudioFile createAudioFile(@NonNull Context context, int i, AudioFileUsage audioFileUsage) {
        AudioFile audioFile = new AudioFile();
        if (audioFile.initialize(context, i, audioFileUsage)) {
            return audioFile;
        }
        return null;
    }
}
