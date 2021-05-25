package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.exifinterface.media.ExifInterface;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\n¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\n¢\u0006\u0004\b\u0007\u0010\n\u001a8\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\n¢\u0006\u0004\b\u0007\u0010\f¨\u0006\r"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "value", "", "plusAssign", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/messenger/channels/mvi/common/v2/Action;)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "(Lcom/jakewharton/rxrelay2/Relay;Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;)V", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class BaseMviEntityWithMutatorsRelayKt {
    public static final <S> void plusAssign(@NotNull Relay<MutatorSingle<S>> relay, @NotNull Mutator<S> mutator) {
        Intrinsics.checkNotNullParameter(relay, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(mutator, "value");
        relay.accept(new MutatorSingle<>(mutator.getName(), new BaseMviEntityKt$toMutatorSingle$1(mutator)));
    }

    public static final <S> void plusAssign(@NotNull Relay<MutatorSingle<S>> relay, @NotNull Action<S> action) {
        Intrinsics.checkNotNullParameter(relay, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(action, "value");
        relay.accept(new MutatorSingle<>(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action)));
    }

    public static final <S> void plusAssign(@NotNull Relay<MutatorSingle<S>> relay, @NotNull ActionSingle<S> actionSingle) {
        Intrinsics.checkNotNullParameter(relay, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(actionSingle, "value");
        relay.accept(new MutatorSingle<>(actionSingle.getName(), new BaseMviEntityKt$toMutatorSingle$3(actionSingle)));
    }
}
