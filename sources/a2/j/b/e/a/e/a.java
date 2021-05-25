package a2.j.b.e.a.e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
public final class a implements IntentSenderForResultStarter {
    public final /* synthetic */ Function7 a;

    public a(Function7 function7) {
        this.a = function7;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        Intrinsics.checkExpressionValueIsNotNull(this.a.invoke(intentSender, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), null), "invoke(...)");
    }
}
