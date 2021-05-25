package defpackage;

import android.content.Context;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import com.avito.android.util.ToastsKt;
import io.reactivex.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: b3  reason: default package */
public final class b3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public b3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            ((ChannelsFragment) this.b).getDatabase$messenger_release().clearAllTables();
        } else if (i == 1) {
            Context context = ((ChannelsFragment) this.b).getContext();
            if (context != null) {
                ToastsKt.showToast(context, "Messenger database cleared", 0);
            }
        } else {
            throw null;
        }
    }
}
