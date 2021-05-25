package ru.avito.messenger.internal.state_machine;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.state_machine.StateMachine;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a2\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "Lru/avito/messenger/internal/state_machine/StateMachine;", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "mutator", "", "plusAssign", "(Lru/avito/messenger/internal/state_machine/StateMachine;Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;)V", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class StateMachineKt {
    public static final <S> void plusAssign(@NotNull StateMachine<S> stateMachine, @NotNull StateMachine.Mutator<S> mutator) {
        Intrinsics.checkNotNullParameter(stateMachine, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        stateMachine.enqueue(mutator);
    }
}
