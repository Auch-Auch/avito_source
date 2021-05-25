package defpackage;

import com.avito.android.messenger.conversation.ChannelFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: m  reason: default package */
public final class m<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public m(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((ChannelFragment) this.b).getMessageMenuPresenter().dismissMenu();
        } else if (i == 1) {
            ((ChannelFragment) this.b).getMessageMenuPresenter().onActionConfirmed();
        } else {
            throw null;
        }
    }
}
