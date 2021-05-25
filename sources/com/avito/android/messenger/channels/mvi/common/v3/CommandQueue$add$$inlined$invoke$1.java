package com.avito.android.messenger.channels.mvi.common.v3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "run", "()V", "com/avito/android/util/rx/concurrent/RxExecutor$invoke$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CommandQueue$add$$inlined$invoke$1 implements Runnable {
    public final /* synthetic */ CommandQueue a;
    public final /* synthetic */ Function0 b;

    public static final class a extends Lambda implements Function1<CommandT, Boolean> {
        public final /* synthetic */ CommandQueue$add$$inlined$invoke$1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CommandQueue$add$$inlined$invoke$1 commandQueue$add$$inlined$invoke$1) {
            super(1);
            this.a = commandQueue$add$$inlined$invoke$1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            Function0 function0 = (Function0) obj;
            Intrinsics.checkNotNullParameter(function0, "cmd");
            return Boolean.valueOf(CommandQueue.access$getShouldCancelChecker$p(this.a.a).shouldCancel(this.a.b, function0));
        }
    }

    public CommandQueue$add$$inlined$invoke$1(CommandQueue commandQueue, Function0 function0) {
        this.a = commandQueue;
        this.b = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h.removeAll((List) CommandQueue.access$getQueue$p(this.a), (Function1) new a(this));
        CommandQueue.access$getQueue$p(this.a).add(this.b);
        CommandQueue.access$processQueue(this.a);
    }
}
