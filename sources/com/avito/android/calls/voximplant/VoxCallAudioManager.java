package com.avito.android.calls.voximplant;

import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.remote.auth.AuthSource;
import com.voximplant.sdk.Voximplant;
import com.voximplant.sdk.hardware.IAudioDeviceEventsListener;
import com.voximplant.sdk.hardware.IAudioDeviceManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001a\u0010B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R%\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallAudioManager;", "Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/calls/audio/AudioDevice;", "currentAudioDevice", "()Lcom/avito/android/calls/audio/AudioDevice;", "", "availableDevices", "()Ljava/util/List;", "Lio/reactivex/Observable;", "currentAudioDeviceChanges", "()Lio/reactivex/Observable;", "availableDevicesChanges", "device", "", "selectAudioDevice", "(Lcom/avito/android/calls/audio/AudioDevice;)V", AuthSource.SEND_ABUSE, "(Ljava/util/List;)Ljava/util/List;", "Lcom/voximplant/sdk/hardware/IAudioDeviceManager;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", AuthSource.BOOKING_ORDER, "()Lcom/voximplant/sdk/hardware/IAudioDeviceManager;", "instance", "<init>", "()V", "AudioDeviceEvent", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallAudioManager implements CallAudioManager {
    public final Lazy a = t6.c.lazy(d.a);

    public static abstract class AudioDeviceEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallAudioManager$AudioDeviceEvent$DeviceChanged;", "Lcom/avito/android/calls/voximplant/VoxCallAudioManager$AudioDeviceEvent;", "Lcom/avito/android/calls/audio/AudioDevice;", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/audio/AudioDevice;", "getDevice", "()Lcom/avito/android/calls/audio/AudioDevice;", "device", "<init>", "(Lcom/avito/android/calls/audio/AudioDevice;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class DeviceChanged extends AudioDeviceEvent {
            @NotNull
            public final AudioDevice a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeviceChanged(@NotNull AudioDevice audioDevice) {
                super(null);
                Intrinsics.checkNotNullParameter(audioDevice, "device");
                this.a = audioDevice;
            }

            @NotNull
            public final AudioDevice getDevice() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallAudioManager$AudioDeviceEvent$DeviceListChanged;", "Lcom/avito/android/calls/voximplant/VoxCallAudioManager$AudioDeviceEvent;", "", "Lcom/avito/android/calls/audio/AudioDevice;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDevices", "()Ljava/util/List;", "devices", "<init>", "(Ljava/util/List;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
        public static final class DeviceListChanged extends AudioDeviceEvent {
            @NotNull
            public final List<AudioDevice> a;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.calls.audio.AudioDevice> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeviceListChanged(@NotNull List<? extends AudioDevice> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "devices");
                this.a = list;
            }

            @NotNull
            public final List<AudioDevice> getDevices() {
                return this.a;
            }
        }

        public AudioDeviceEvent(j jVar) {
        }
    }

    public static final class a implements IAudioDeviceEventsListener {
        @NotNull
        public final ObservableEmitter<AudioDeviceEvent> a;

        public a(@NotNull ObservableEmitter<AudioDeviceEvent> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a = observableEmitter;
        }

        @Override // com.voximplant.sdk.hardware.IAudioDeviceEventsListener
        public void onAudioDeviceChanged(@NotNull com.voximplant.sdk.hardware.AudioDevice audioDevice) {
            Intrinsics.checkNotNullParameter(audioDevice, "device");
            AudioDevice access$convert = VoxCallAudioManagerKt.access$convert(audioDevice);
            if (!this.a.isDisposed()) {
                this.a.onNext(new AudioDeviceEvent.DeviceChanged(access$convert));
            }
        }

        @Override // com.voximplant.sdk.hardware.IAudioDeviceEventsListener
        public void onAudioDeviceListChanged(@NotNull List<com.voximplant.sdk.hardware.AudioDevice> list) {
            Intrinsics.checkNotNullParameter(list, "devices");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(VoxCallAudioManagerKt.access$convert(it.next()));
            }
            if (!this.a.isDisposed()) {
                this.a.onNext(new AudioDeviceEvent.DeviceListChanged(arrayList));
            }
        }
    }

    public static final class b<T, R> implements Function<AudioDeviceEvent.DeviceListChanged, List<? extends AudioDevice>> {
        public final /* synthetic */ VoxCallAudioManager a;

        public b(VoxCallAudioManager voxCallAudioManager) {
            this.a = voxCallAudioManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends AudioDevice> apply(AudioDeviceEvent.DeviceListChanged deviceListChanged) {
            AudioDeviceEvent.DeviceListChanged deviceListChanged2 = deviceListChanged;
            Intrinsics.checkNotNullParameter(deviceListChanged2, "it");
            return this.a.a(deviceListChanged2.getDevices());
        }
    }

    public static final class c<T, R> implements Function<AudioDeviceEvent.DeviceChanged, AudioDevice> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public AudioDevice apply(AudioDeviceEvent.DeviceChanged deviceChanged) {
            AudioDeviceEvent.DeviceChanged deviceChanged2 = deviceChanged;
            Intrinsics.checkNotNullParameter(deviceChanged2, "it");
            return deviceChanged2.getDevice();
        }
    }

    public static final class d extends Lambda implements Function0<IAudioDeviceManager> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public IAudioDeviceManager invoke() {
            return Voximplant.getAudioDeviceManager();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.calls.audio.AudioDevice> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<AudioDevice> a(List<? extends AudioDevice> list) {
        AudioDevice currentAudioDevice = currentAudioDevice();
        AudioDevice.WiredHeadset wiredHeadset = AudioDevice.WiredHeadset.INSTANCE;
        if (!(Intrinsics.areEqual(currentAudioDevice, wiredHeadset) || list.contains(wiredHeadset))) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual((AudioDevice) obj, AudioDevice.Earpiece.INSTANCE)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.calls.audio.CallAudioManager
    @NotNull
    public List<AudioDevice> availableDevices() {
        IAudioDeviceManager b2 = b();
        Intrinsics.checkNotNullExpressionValue(b2, "instance");
        List<com.voximplant.sdk.hardware.AudioDevice> audioDevices = b2.getAudioDevices();
        if (audioDevices == null) {
            audioDevices = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(audioDevices, 10));
        for (T t : audioDevices) {
            Intrinsics.checkNotNullExpressionValue(t, "device");
            arrayList.add(VoxCallAudioManagerKt.access$convert(t));
        }
        return a(arrayList);
    }

    @Override // com.avito.android.calls.audio.CallAudioManager
    @NotNull
    public Observable<List<AudioDevice>> availableDevicesChanges() {
        Observable create = Observable.create(new a2.a.a.z.a.a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ner(listener) }\n        }");
        Observable ofType = create.ofType(AudioDeviceEvent.DeviceListChanged.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<List<AudioDevice>> map = ofType.map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "observeAudioDeviceEvents…ices.filterSelectable() }");
        return map;
    }

    public final IAudioDeviceManager b() {
        return (IAudioDeviceManager) this.a.getValue();
    }

    @Override // com.avito.android.calls.audio.CallAudioManager
    @NotNull
    public AudioDevice currentAudioDevice() {
        AudioDevice access$convert;
        IAudioDeviceManager b2 = b();
        Intrinsics.checkNotNullExpressionValue(b2, "instance");
        com.voximplant.sdk.hardware.AudioDevice activeDevice = b2.getActiveDevice();
        return (activeDevice == null || (access$convert = VoxCallAudioManagerKt.access$convert(activeDevice)) == null) ? AudioDevice.None.INSTANCE : access$convert;
    }

    @Override // com.avito.android.calls.audio.CallAudioManager
    @NotNull
    public Observable<AudioDevice> currentAudioDeviceChanges() {
        Observable create = Observable.create(new a2.a.a.z.a.a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ner(listener) }\n        }");
        Observable ofType = create.ofType(AudioDeviceEvent.DeviceChanged.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<AudioDevice> map = ofType.map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "observeAudioDeviceEvents…       .map { it.device }");
        return map;
    }

    @Override // com.avito.android.calls.audio.CallAudioManager
    public void selectAudioDevice(@NotNull AudioDevice audioDevice) {
        Intrinsics.checkNotNullParameter(audioDevice, "device");
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Earpiece.INSTANCE)) {
            b().selectAudioDevice(com.voximplant.sdk.hardware.AudioDevice.EARPIECE);
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.Speaker.INSTANCE)) {
            b().selectAudioDevice(com.voximplant.sdk.hardware.AudioDevice.SPEAKER);
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.Bluetooth.INSTANCE)) {
            b().selectAudioDevice(com.voximplant.sdk.hardware.AudioDevice.BLUETOOTH);
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.WiredHeadset.INSTANCE)) {
            b().selectAudioDevice(com.voximplant.sdk.hardware.AudioDevice.WIRED_HEADSET);
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.None.INSTANCE)) {
            b().selectAudioDevice(com.voximplant.sdk.hardware.AudioDevice.NONE);
        }
    }
}
