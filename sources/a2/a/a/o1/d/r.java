package a2.a.a.o1.d;

import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class r<T, R> implements Function<PlatformActionsCoordinator.CoordinatorState, Map<Object, ? extends PlatformActionsStateProducer<?>>> {
    public static final r a = new r();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Map<Object, ? extends PlatformActionsStateProducer<?>> apply(PlatformActionsCoordinator.CoordinatorState coordinatorState) {
        PlatformActionsCoordinator.CoordinatorState coordinatorState2 = coordinatorState;
        Intrinsics.checkNotNullParameter(coordinatorState2, "coordinatorState");
        return coordinatorState2.getStateProducersByKey();
    }
}
