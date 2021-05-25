package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0005\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "CommandT", "Lcom/avito/android/messenger/channels/mvi/common/v3/CommandQueue;", "command", "plusAssign", "(Lcom/avito/android/messenger/channels/mvi/common/v3/CommandQueue;Lkotlin/jvm/functions/Function0;)V", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class CommandQueueKt {
    public static final <CommandT extends Function0<? extends Unit>> void plusAssign(@NotNull CommandQueue<CommandT> commandQueue, @NotNull CommandT commandt) {
        Intrinsics.checkNotNullParameter(commandQueue, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(commandt, "command");
        commandQueue.add(commandt);
    }
}
