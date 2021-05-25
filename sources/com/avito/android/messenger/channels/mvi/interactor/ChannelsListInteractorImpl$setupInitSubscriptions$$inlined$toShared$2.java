package com.avito.android.messenger.channels.mvi.interactor;

import hu.akarnokd.rxjava2.schedulers.SharedScheduler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/avito/android/util/rx/SchedulersKt$toShared$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelsListInteractorImpl$setupInitSubscriptions$$inlined$toShared$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public ChannelsListInteractorImpl$setupInitSubscriptions$$inlined$toShared$2(SharedScheduler sharedScheduler) {
        super(0, sharedScheduler, SharedScheduler.class, "shutdown", "shutdown()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ((SharedScheduler) this.receiver).shutdown();
    }
}
