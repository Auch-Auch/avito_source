package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.PublishDetailsPresenterKt;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import io.reactivex.functions.Consumer;
public final class l0<T> implements Consumer<ConsumeValueChangeResult> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public l0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0015: APUT  
      (r1v1 com.avito.android.publish.details.analytics.PublishDetailsFlowTracker$FlowContext[])
      (0 ??[int, short, byte, char])
      (r4v5 com.avito.android.publish.details.analytics.PublishDetailsFlowTracker$FlowContext)
     */
    @Override // io.reactivex.functions.Consumer
    public void accept(ConsumeValueChangeResult consumeValueChangeResult) {
        ConsumeValueChangeResult consumeValueChangeResult2 = consumeValueChangeResult;
        if (consumeValueChangeResult2 instanceof ConsumeValueChangeResult.NeedViewUpdate) {
            PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
            PublishDetailsFlowTracker.FlowContext[] flowContextArr = new PublishDetailsFlowTracker.FlowContext[1];
            PublishDetailsFlowTracker.FlowContext access$toFlowContext = PublishDetailsPresenterKt.access$toFlowContext(consumeValueChangeResult2);
            if (access$toFlowContext == null) {
                access$toFlowContext = PublishDetailsFlowTracker.FlowContext.UNKNOWN;
            }
            flowContextArr[0] = access$toFlowContext;
            publishDetailsPresenterImpl.c(flowContextArr);
        } else if (consumeValueChangeResult2 instanceof ConsumeValueChangeResult.NeedValueExpose) {
            PublishDetailsPresenterImpl.access$observeSlotValueChangesBySlots(this.a, ((ConsumeValueChangeResult.NeedValueExpose) consumeValueChangeResult2).getSlot());
        }
    }
}
