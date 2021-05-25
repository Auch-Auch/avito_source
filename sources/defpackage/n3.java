package defpackage;

import com.avito.android.messenger.conversation.ChannelFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: n3  reason: default package */
public final class n3<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public n3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((ChannelFragment) this.b).getMessageListPresenter().startPagination();
        } else if (i == 1) {
            ((ChannelFragment) this.b).getMessageListPresenter().callUser();
        } else if (i == 2) {
            ((ChannelFragment) this.b).getMessageListPresenter().refresh();
        } else if (i == 3) {
            ((ChannelFragment) this.b).getMessageListPresenter().userInteractedWithList();
        } else if (i == 4) {
            ((ChannelFragment) this.b).getNewMessagesPresenter().onInitialScrollPerformed();
        } else {
            throw null;
        }
    }
}
