package com.avito.android.in_app_calls.ui;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.calls.audio.AudioDevice;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.in_app_calls.R;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ToastsKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/in_app_calls/ui/AudioDeviceChooserImpl;", "Lcom/avito/android/in_app_calls/ui/AudioDeviceChooser;", "", "selectAudioDevice", "()V", "Lcom/avito/android/calls/audio/AudioDevice;", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/calls/audio/AudioDevice;)Ljava/lang/String;", "Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/calls/audio/CallAudioManager;", "audioManager", "Landroidx/fragment/app/FragmentActivity;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/FragmentActivity;", "context", "<init>", "(Lcom/avito/android/calls/audio/CallAudioManager;Landroidx/fragment/app/FragmentActivity;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class AudioDeviceChooserImpl implements AudioDeviceChooser {
    public final CallAudioManager a;
    public final FragmentActivity b;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ AudioDeviceChooserImpl a;
        public final /* synthetic */ List b;

        public a(AudioDeviceChooserImpl audioDeviceChooserImpl, List list) {
            this.a = audioDeviceChooserImpl;
            this.b = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            AudioDevice audioDevice = (AudioDevice) this.b.get(i);
            if (this.a.a.availableDevices().contains(audioDevice)) {
                this.a.a.selectAudioDevice(audioDevice);
            } else {
                ToastsKt.showToast$default(this.a.b, R.string.calls_audio_device_chooser_device_is_not_available, 0, 2, (Object) null);
            }
            LastClick.Updater.update();
            dialogInterface.dismiss();
        }
    }

    @Inject
    public AudioDeviceChooserImpl(@NotNull CallAudioManager callAudioManager, @NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(callAudioManager, "audioManager");
        Intrinsics.checkNotNullParameter(fragmentActivity, "context");
        this.a = callAudioManager;
        this.b = fragmentActivity;
    }

    public static final int access$sortPriority(AudioDeviceChooserImpl audioDeviceChooserImpl, AudioDevice audioDevice) {
        Objects.requireNonNull(audioDeviceChooserImpl);
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Earpiece.INSTANCE)) {
            return 0;
        }
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Speaker.INSTANCE)) {
            return 1;
        }
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Bluetooth.INSTANCE)) {
            return 2;
        }
        if (Intrinsics.areEqual(audioDevice, AudioDevice.WiredHeadset.INSTANCE)) {
            return 3;
        }
        if (Intrinsics.areEqual(audioDevice, AudioDevice.None.INSTANCE)) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String a(AudioDevice audioDevice) {
        if (Intrinsics.areEqual(audioDevice, AudioDevice.Earpiece.INSTANCE)) {
            String string = this.b.getString(R.string.calls_audio_device_earpiece);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ls_audio_device_earpiece)");
            return string;
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.Speaker.INSTANCE)) {
            String string2 = this.b.getString(R.string.calls_audio_device_speaker);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…lls_audio_device_speaker)");
            return string2;
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.Bluetooth.INSTANCE)) {
            String string3 = this.b.getString(R.string.calls_audio_device_bluetooth);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…s_audio_device_bluetooth)");
            return string3;
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.WiredHeadset.INSTANCE)) {
            String string4 = this.b.getString(R.string.calls_audio_device_wired_headset);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…dio_device_wired_headset)");
            return string4;
        } else if (Intrinsics.areEqual(audioDevice, AudioDevice.None.INSTANCE)) {
            String string5 = this.b.getString(R.string.calls_audio_device_none);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri….calls_audio_device_none)");
            return string5;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.in_app_calls.ui.AudioDeviceChooser
    public void selectAudioDevice() {
        AudioDevice currentAudioDevice = this.a.currentAudioDevice();
        List<AudioDevice> availableDevices = this.a.availableDevices();
        T t = null;
        if (availableDevices.isEmpty()) {
            ToastsKt.showToast$default(this.b, R.string.calls_audio_device_chooser_no_devices, 0, 2, (Object) null);
        } else if (availableDevices.size() == 1) {
            AudioDevice audioDevice = (AudioDevice) CollectionsKt___CollectionsKt.first((List<? extends Object>) availableDevices);
            if (Intrinsics.areEqual(audioDevice, AudioDevice.WiredHeadset.INSTANCE)) {
                ToastsKt.showToast$default(this.b, R.string.calls_audio_device_chooser_disconnect_wired_headset, 0, 2, (Object) null);
                return;
            }
            FragmentActivity fragmentActivity = this.b;
            String string = fragmentActivity.getString(R.string.calls_audio_device_chooser_only_single_device_available, new Object[]{a(audioDevice)});
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …                        )");
            ToastsKt.showToast$default(fragmentActivity, string, 0, 2, (Object) null);
        } else if (availableDevices.size() != 2 || !availableDevices.contains(AudioDevice.Speaker.INSTANCE)) {
            List<AudioDevice> sortedWith = CollectionsKt___CollectionsKt.sortedWith(availableDevices, new Comparator<T>(this) { // from class: com.avito.android.in_app_calls.ui.AudioDeviceChooserImpl$selectAudioDevice$$inlined$sortedBy$1
                public final /* synthetic */ AudioDeviceChooserImpl a;

                {
                    this.a = r1;
                }

                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return a.compareValues(Integer.valueOf(AudioDeviceChooserImpl.access$sortPriority(this.a, t2)), Integer.valueOf(AudioDeviceChooserImpl.access$sortPriority(this.a, t3)));
                }
            });
            int indexOf = sortedWith.indexOf(currentAudioDevice);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(sortedWith, 10));
            for (AudioDevice audioDevice2 : sortedWith) {
                arrayList.add(a(audioDevice2));
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            new AlertDialog.Builder(this.b).setTitle("Доступные аудио-устройства").setSingleChoiceItems((String[]) array, indexOf, new a(this, sortedWith)).show();
        } else {
            Iterator<T> it = availableDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (!Intrinsics.areEqual(next, currentAudioDevice)) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 == null) {
                t2 = (AudioDevice) CollectionsKt___CollectionsKt.last((List<? extends Object>) availableDevices);
            }
            this.a.selectAudioDevice(t2);
        }
    }
}
