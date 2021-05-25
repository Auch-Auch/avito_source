package hu.akarnokd.rxjava2.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.processors.FlowableProcessor;
import org.reactivestreams.Processor;
import r6.a.a.j.a;
import r6.a.a.j.b;
public final class FlowableProcessors {
    public FlowableProcessors() {
        throw new IllegalStateException("No instances!");
    }

    @CheckReturnValue
    @NonNull
    public static <T> FlowableProcessor<T> refCount(FlowableProcessor<T> flowableProcessor) {
        if (flowableProcessor instanceof b) {
            return flowableProcessor;
        }
        return new b((FlowableProcessor) ObjectHelper.requireNonNull(flowableProcessor, "processor is null"));
    }

    public static <T> FlowableProcessor<T> wrap(Processor<T, T> processor) {
        if (processor instanceof FlowableProcessor) {
            return (FlowableProcessor) processor;
        }
        return new a((Processor) ObjectHelper.requireNonNull(processor, "processor is null"));
    }
}
