package com.avito.android.messenger.channels.mvi.common;

import com.avito.android.messenger.channels.mvi.common.Loading;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aJ\u0010\u0007\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0004¢\u0006\u0002\b\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\b¢\u0006\u0004\b\u0007\u0010\t\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\b¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"(\u0010\u0011\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"(\u0010\u0013\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012\"(\u0010\u0014\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"(\u0010\u0015\u001a\u00020\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"", "T", "R", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "asSuccess", "(Lcom/avito/android/messenger/channels/mvi/common/Loading;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lcom/avito/android/messenger/channels/mvi/common/Loading;)Ljava/lang/Object;", "Lcom/avito/android/messenger/channels/mvi/common/Loading$Success;", "toLoadingSuccess", "(Ljava/lang/Object;)Lcom/avito/android/messenger/channels/mvi/common/Loading$Success;", "mapper", "map", "(Lcom/avito/android/messenger/channels/mvi/common/Loading;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "isSuccess", "(Lcom/avito/android/messenger/channels/mvi/common/Loading;)Z", "isEmpty", "isError", "isInProgress", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class LoadingKt {
    @Nullable
    public static final <T, R> R asSuccess(@NotNull Loading<T> loading, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(loading, "$this$asSuccess");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (loading instanceof Loading.Success) {
            return (R) function1.invoke((Object) ((Loading.Success) loading).getValue());
        }
        return null;
    }

    public static final <T> boolean isEmpty(@NotNull Loading<T> loading) {
        Intrinsics.checkNotNullParameter(loading, "$this$isEmpty");
        return loading instanceof Loading.Empty;
    }

    public static final <T> boolean isError(@NotNull Loading<T> loading) {
        Intrinsics.checkNotNullParameter(loading, "$this$isError");
        return loading instanceof Loading.Error;
    }

    public static final <T> boolean isInProgress(@NotNull Loading<T> loading) {
        Intrinsics.checkNotNullParameter(loading, "$this$isInProgress");
        return loading instanceof Loading.InProgress;
    }

    public static final <T> boolean isSuccess(@NotNull Loading<T> loading) {
        Intrinsics.checkNotNullParameter(loading, "$this$isSuccess");
        return loading instanceof Loading.Success;
    }

    @NotNull
    public static final <T, R> Loading<R> map(@NotNull Loading<T> loading, @NotNull Function1<? super T, ? extends R> function1) {
        Loading<R> error;
        Intrinsics.checkNotNullParameter(loading, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "mapper");
        if (loading instanceof Loading.Empty) {
            return new Loading.Empty();
        }
        if (loading instanceof Loading.InProgress) {
            error = new Loading.InProgress<>(((Loading.InProgress) loading).getId());
        } else if (loading instanceof Loading.Success) {
            return new Loading.Success(function1.invoke((Object) ((Loading.Success) loading).getValue()));
        } else {
            if (loading instanceof Loading.Error) {
                error = new Loading.Error<>(((Loading.Error) loading).getError());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return error;
    }

    @NotNull
    public static final <T> Loading.Success<T> toLoadingSuccess(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "$this$toLoadingSuccess");
        return new Loading.Success<>(t);
    }

    @Nullable
    public static final <T> T asSuccess(@NotNull Loading<T> loading) {
        Intrinsics.checkNotNullParameter(loading, "$this$asSuccess");
        if (!(loading instanceof Loading.Success)) {
            loading = null;
        }
        Loading.Success success = (Loading.Success) loading;
        if (success != null) {
            return (T) success.getValue();
        }
        return null;
    }
}
