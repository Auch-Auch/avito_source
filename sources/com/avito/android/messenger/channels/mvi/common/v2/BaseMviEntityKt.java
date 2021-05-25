package com.avito.android.messenger.channels.mvi.common.v2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006H\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\b¢\u0006\u0004\b\u0004\u0010\t\u001a8\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\b¢\u0006\u0004\b\u000f\u0010\u0010\"7\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e8À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"-\u0010\f\u001a\u00020\u000b*\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\rj\u0006\u0012\u0002\b\u0003`\u000e8À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015**\b\u0000\u0010\u0016\u001a\u0004\b\u0000\u0010\n\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\r¨\u0006\u0017"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;", "Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "toMutatorSingle", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Mutator;)Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Action;", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Action;)Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;", "(Lcom/avito/android/messenger/channels/mvi/common/v2/ActionSingle;)Lcom/avito/android/messenger/channels/mvi/common/v2/MutatorSingle;", "T", "", "id", "Lkotlin/Pair;", "Lcom/avito/android/messenger/channels/mvi/common/v2/HasStringId;", "withStringId", "(Ljava/lang/Object;Ljava/lang/String;)Lkotlin/Pair;", "getValue", "(Lkotlin/Pair;)Ljava/lang/Object;", "value", "getId", "(Lkotlin/Pair;)Ljava/lang/String;", "HasStringId", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class BaseMviEntityKt {
    @NotNull
    public static final String getId(@NotNull Pair<String, ?> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$id");
        return pair.getFirst();
    }

    public static final <T> T getValue(@NotNull Pair<String, ? extends T> pair) {
        Intrinsics.checkNotNullParameter(pair, "$this$value");
        return (T) pair.getSecond();
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull Mutator<S> mutator) {
        Intrinsics.checkNotNullParameter(mutator, "$this$toMutatorSingle");
        return new MutatorSingle<>(mutator.getName(), new BaseMviEntityKt$toMutatorSingle$1(mutator));
    }

    @NotNull
    public static final <T> Pair<String, T> withStringId(T t, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return TuplesKt.to(str, t);
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull Action<S> action) {
        Intrinsics.checkNotNullParameter(action, "$this$toMutatorSingle");
        return new MutatorSingle<>(action.getName(), new BaseMviEntityKt$toMutatorSingle$2(action));
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull ActionSingle<S> actionSingle) {
        Intrinsics.checkNotNullParameter(actionSingle, "$this$toMutatorSingle");
        return new MutatorSingle<>(actionSingle.getName(), new BaseMviEntityKt$toMutatorSingle$3(actionSingle));
    }
}
