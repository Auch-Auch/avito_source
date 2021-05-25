package defpackage;

import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.profile.sessions.list.SessionsMenuViewImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: f0  reason: default package */
public final class f0<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public f0(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX DEBUG: Multi-variable search result rejected for r3v9, resolved type: com.jakewharton.rxrelay3.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            ((SessionsMenuViewImpl) this.b).a.accept(((SessionItem.Action) this.c).getDeeplink());
        } else if (i == 1) {
            ((SessionsMenuViewImpl) this.b).a.accept(((SessionItem.Action) this.c).getDeeplink());
        } else {
            throw null;
        }
    }
}
