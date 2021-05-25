package com.avito.android.calls.audio;

import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls.voximplant.VoxCallAudioManager;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/calls/audio/CallAudioManager;", "", "Lcom/avito/android/calls/audio/AudioDevice;", "currentAudioDevice", "()Lcom/avito/android/calls/audio/AudioDevice;", "", "availableDevices", "()Ljava/util/List;", "Lio/reactivex/Observable;", "currentAudioDeviceChanges", "()Lio/reactivex/Observable;", "availableDevicesChanges", "device", "", "selectAudioDevice", "(Lcom/avito/android/calls/audio/AudioDevice;)V", "Companion", "Dummy", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallAudioManager {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/calls/audio/CallAudioManager$Companion;", "", "Lcom/avito/android/calls/audio/CallAudioManager;", "getVoximplantInstance", "()Lcom/avito/android/calls/audio/CallAudioManager;", "getDummyInstance", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final CallAudioManager getDummyInstance() {
            return new Dummy();
        }

        @NotNull
        public final CallAudioManager getVoximplantInstance() {
            return new VoxCallAudioManager();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/calls/audio/CallAudioManager$Dummy;", "Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/calls/audio/AudioDevice;", "currentAudioDevice", "()Lcom/avito/android/calls/audio/AudioDevice;", "", "availableDevices", "()Ljava/util/List;", "Lio/reactivex/Observable;", "currentAudioDeviceChanges", "()Lio/reactivex/Observable;", "availableDevicesChanges", "device", "", "selectAudioDevice", "(Lcom/avito/android/calls/audio/AudioDevice;)V", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Dummy implements CallAudioManager {
        @Override // com.avito.android.calls.audio.CallAudioManager
        @NotNull
        public List<AudioDevice> availableDevices() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @Override // com.avito.android.calls.audio.CallAudioManager
        @NotNull
        public Observable<List<AudioDevice>> availableDevicesChanges() {
            Observable<List<AudioDevice>> never = Observable.never();
            Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
            return never;
        }

        @Override // com.avito.android.calls.audio.CallAudioManager
        @NotNull
        public AudioDevice currentAudioDevice() {
            return AudioDevice.None.INSTANCE;
        }

        @Override // com.avito.android.calls.audio.CallAudioManager
        @NotNull
        public Observable<AudioDevice> currentAudioDeviceChanges() {
            Observable<AudioDevice> never = Observable.never();
            Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
            return never;
        }

        @Override // com.avito.android.calls.audio.CallAudioManager
        public void selectAudioDevice(@NotNull AudioDevice audioDevice) {
            Intrinsics.checkNotNullParameter(audioDevice, "device");
        }
    }

    @NotNull
    List<AudioDevice> availableDevices();

    @NotNull
    Observable<List<AudioDevice>> availableDevicesChanges();

    @NotNull
    AudioDevice currentAudioDevice();

    @NotNull
    Observable<AudioDevice> currentAudioDeviceChanges();

    void selectAudioDevice(@NotNull AudioDevice audioDevice);
}
