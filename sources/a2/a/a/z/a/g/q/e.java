package a2.a.a.z.a.g.q;

import com.avito.android.calls.voximplant.rx.core.VoxSessionManager;
import io.reactivex.rxjava3.functions.Action;
public final class e implements Action {
    public final /* synthetic */ VoxSessionManager a;

    public e(VoxSessionManager voxSessionManager) {
        this.a = voxSessionManager;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.d.clearTokens();
    }
}
