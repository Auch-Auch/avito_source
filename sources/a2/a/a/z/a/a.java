package a2.a.a.z.a;

import com.avito.android.calls.voximplant.VoxCallAudioManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a<T> implements ObservableOnSubscribe<VoxCallAudioManager.AudioDeviceEvent> {
    public final /* synthetic */ VoxCallAudioManager a;

    /* renamed from: a2.a.a.z.a.a$a  reason: collision with other inner class name */
    public static final class C0011a implements Cancellable {
        public final /* synthetic */ a a;
        public final /* synthetic */ VoxCallAudioManager.a b;

        public C0011a(a aVar, VoxCallAudioManager.a aVar2) {
            this.a = aVar;
            this.b = aVar2;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.b().removeAudioDeviceEventsListener(this.b);
        }
    }

    public a(VoxCallAudioManager voxCallAudioManager) {
        this.a = voxCallAudioManager;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<VoxCallAudioManager.AudioDeviceEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        VoxCallAudioManager.a aVar = new VoxCallAudioManager.a(observableEmitter);
        this.a.b().addAudioDeviceEventsListener(aVar);
        observableEmitter.setCancellable(new C0011a(this, aVar));
    }
}
