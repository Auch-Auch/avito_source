package a2.a.a.e;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Predicate<Notification<T>> {
    public final /* synthetic */ Function1 a;

    public g(Function1 function1) {
        this.a = function1;
    }

    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(Object obj) {
        Notification notification = (Notification) obj;
        Intrinsics.checkNotNullExpressionValue(notification, "it");
        if (notification.isOnError()) {
            Function1 function1 = this.a;
            Throwable error = notification.getError();
            Intrinsics.checkNotNull(error);
            if (((Boolean) function1.invoke(error)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
