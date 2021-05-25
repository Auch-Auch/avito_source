package com.avito.android.beduin.common.actionhandler;

import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/beduin/common/actionhandler/BeduinActionHandlerWrapper;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "action", "", "handle", "(Lcom/avito/android/beduin/core/action/BeduinAction;)Z", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "handlers", "Lkotlin/Function1;", "", "Lcom/avito/android/beduin/common/actionhandler/UnhandledActionListener;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "onUnhandledAction", "<init>", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinActionHandlerWrapper implements BeduinActionHandler {
    public final Set<BeduinActionHandler> a;
    public final Function1<BeduinAction, Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends com.avito.android.beduin.core.action.BeduinActionHandler> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.beduin.core.action.BeduinAction, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinActionHandlerWrapper(@NotNull Set<? extends BeduinActionHandler> set, @NotNull Function1<? super BeduinAction, Unit> function1) {
        Intrinsics.checkNotNullParameter(set, "handlers");
        Intrinsics.checkNotNullParameter(function1, "onUnhandledAction");
        this.a = set;
        this.b = function1;
    }

    @Override // com.avito.android.beduin.core.action.BeduinActionHandler
    public boolean handle(@NotNull BeduinAction beduinAction) {
        Intrinsics.checkNotNullParameter(beduinAction, "action");
        Set<BeduinActionHandler> set = this.a;
        boolean z = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().handle(beduinAction)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!z) {
            this.b.invoke(beduinAction);
        }
        return z;
    }
}
