package defpackage;

import com.avito.android.in_app_calls.ui.call.CallFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: l2  reason: default package */
public final class l2<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public l2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((CallFragment) this.b).getCallPresenter().answer();
        } else if (i == 1) {
            ((CallFragment) this.b).getCallPresenter().decline();
        } else if (i == 2) {
            ((CallFragment) this.b).getCallPresenter().hangup();
        } else if (i == 3) {
            CallFragment.access$finish((CallFragment) this.b);
        } else if (i == 4) {
            ((CallFragment) this.b).getAudioDeviceChooser().selectAudioDevice();
        } else if (i == 5) {
            ((CallFragment) this.b).getCallPresenter().toggleMic();
        } else {
            throw null;
        }
    }
}
