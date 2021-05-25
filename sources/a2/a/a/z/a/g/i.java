package a2.a.a.z.a.g;

import com.avito.android.calls.voximplant.rx.VoxCallClientPushTokenRegistration;
import com.avito.android.calls_shared.LogTagsKt;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Action;
import kotlin.jvm.internal.Intrinsics;
public final class i implements Action {
    public final /* synthetic */ VoxCallClientPushTokenRegistration.a a;
    public final /* synthetic */ String b;

    public i(VoxCallClientPushTokenRegistration.a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Logs.debug$default(LogTagsKt.TAG_IAC, "Register push token: update lastRegisteredPushToken", null, 4, null);
        CallStorage callStorage = this.a.a.a;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(str, "actualToken");
        callStorage.setLastRegisteredPushToken(str);
    }
}
