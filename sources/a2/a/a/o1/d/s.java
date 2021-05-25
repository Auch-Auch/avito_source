package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class s<T> implements Predicate<PlatformActionsCoordinator.CoordinatorState> {
    public static final s a = new s();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(PlatformActionsCoordinator.CoordinatorState coordinatorState) {
        PlatformActionsCoordinator.CoordinatorState coordinatorState2 = coordinatorState;
        Intrinsics.checkNotNullParameter(coordinatorState2, "coordinatorState");
        return !coordinatorState2.getStateProducersByKey().isEmpty();
    }
}
