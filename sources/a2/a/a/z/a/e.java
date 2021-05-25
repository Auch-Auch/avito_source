package a2.a.a.z.a;

import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ VoxCallClient a;

    public e(VoxCallClient voxCallClient) {
        this.a = voxCallClient;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Failed to get username", th);
        this.a.disconnect(false);
    }
}
