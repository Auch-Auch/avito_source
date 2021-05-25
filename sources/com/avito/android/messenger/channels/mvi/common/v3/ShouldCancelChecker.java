package com.avito.android.messenger.channels.mvi.common.v3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0004J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/common/v3/ShouldCancelChecker;", "Lkotlin/Function0;", "", "CommandT", "", "command", "other", "", "shouldCancel", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Z", "mvi_release"}, k = 1, mv = {1, 4, 2})
public interface ShouldCancelChecker<CommandT extends Function0<? extends Unit>> {
    boolean shouldCancel(@NotNull CommandT commandt, @NotNull CommandT commandt2);
}
