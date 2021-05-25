package a2.a.a.z.a;

import a2.b.a.a.a;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preference;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<String> {
    public final /* synthetic */ VoxCallClient a;
    public final /* synthetic */ Map b;

    public d(VoxCallClient voxCallClient, Map map) {
        this.a = voxCallClient;
        this.b = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        Logs.verbose$default(LogTagsKt.TAG_VOX_CLIENT, a.c3("Username = ", str2), null, 4, null);
        if (this.a.d != VoxCallClient.Command.DISCONNECT) {
            CredentialsStorage credentialsStorage = this.a.j;
            Intrinsics.checkNotNullExpressionValue(str2, Preference.USERNAME);
            credentialsStorage.setUsername(str2);
        }
        int ordinal = this.a.d.ordinal();
        if (ordinal == 0) {
            this.a.disconnect(false);
        } else if (ordinal == 1 || ordinal == 2) {
            VoxCallClient.access$connectForPushRegistration(this.a);
        } else if (ordinal == 3) {
            this.a.connectForIncomingCall(this.b);
        } else if (ordinal == 4) {
            this.a.connectForOutgoingCall(str2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
