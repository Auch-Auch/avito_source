package a2.a.a.z.a;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.NoWhenBranchMatchedException;
public final class c<T> implements Consumer<Option<? extends String>> {
    public final /* synthetic */ VoxCallClient a;
    public final /* synthetic */ String b;

    public c(VoxCallClient voxCallClient, String str) {
        this.a = voxCallClient;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Option<? extends String> option) {
        Option<? extends String> option2 = option;
        if (option2 instanceof None) {
            Logs.error$default(LogTagsKt.TAG_VOX_CLIENT, "Failed to get one-time login key", null, 4, null);
            this.a.disconnect(false);
        } else if (option2 instanceof Some) {
            try {
                this.a.i.loginWithOneTimeKey(this.b, (String) ((Some) option2).getT());
            } catch (Exception e) {
                Logs.error(LogTagsKt.TAG_VOX_CLIENT, "Failed to login with one-time key", e);
                this.a.disconnect(true);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
