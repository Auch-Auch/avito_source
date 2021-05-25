package com.avito.android.messenger.channels.mvi.common.v4;

import a2.a.a.o1.b.b.a.d.i;
import a2.a.a.o1.b.b.a.d.j;
import a2.a.a.o1.b.b.a.d.k;
import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0004\u0010\u0007\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "toMutatorSingle", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;)Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Action;", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Action;)Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;", "(Lcom/avito/android/messenger/channels/mvi/common/v4/ActionSingle;)Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class ReducibleKt {

    public static final class a extends Lambda implements Function1<S, Single<S>> {
        public final /* synthetic */ Action a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Action action) {
            super(1);
            this.a = action;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "oldState");
            Single fromCallable = Single.fromCallable(new i(this, obj));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …       oldState\n        }");
            return fromCallable;
        }
    }

    public static final class b extends Lambda implements Function1<S, Single<S>> {
        public final /* synthetic */ ActionSingle a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ActionSingle actionSingle) {
            super(1);
            this.a = actionSingle;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "oldState");
            Single onErrorReturn = ((Single) this.a.getBlock().invoke(obj)).map(new j(obj)).onErrorReturn(new k(this, obj));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "block(oldState)\n        …   oldState\n            }");
            return onErrorReturn;
        }
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull Mutator<S> mutator) {
        Intrinsics.checkNotNullParameter(mutator, "$this$toMutatorSingle");
        return new MutatorSingle<>(mutator.getName(), mutator.getParams(), new ReducibleKt$toMutatorSingle$1(mutator));
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull Action<S> action) {
        Intrinsics.checkNotNullParameter(action, "$this$toMutatorSingle");
        return new MutatorSingle<>(action.getName(), action.getParams(), new a(action));
    }

    @NotNull
    public static final <S> MutatorSingle<S> toMutatorSingle(@NotNull ActionSingle<S> actionSingle) {
        Intrinsics.checkNotNullParameter(actionSingle, "$this$toMutatorSingle");
        return new MutatorSingle<>(actionSingle.getName(), actionSingle.getParams(), new b(actionSingle));
    }
}
