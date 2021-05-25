package defpackage;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: x1  reason: default package */
public final class x1<T, R> implements Function<Throwable, List<? extends LocalMessage>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public x1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final List<? extends LocalMessage> apply(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(th, "it");
            return (List) this.b;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(th, "it");
            return (List) this.b;
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(th, "it");
            return (List) this.b;
        } else if (i == 3) {
            Intrinsics.checkNotNullParameter(th, "it");
            return (List) this.b;
        } else {
            throw null;
        }
    }
}
