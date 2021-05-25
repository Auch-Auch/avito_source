package hu.akarnokd.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.Objects;
import org.reactivestreams.Processor;
import r6.a.b.k.a;
import r6.a.b.k.b;
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
        Objects.requireNonNull(flowableProcessor, "processor is null");
        return new b(flowableProcessor);
    }

    public static <T> FlowableProcessor<T> wrap(Processor<T, T> processor) {
        if (processor instanceof FlowableProcessor) {
            return (FlowableProcessor) processor;
        }
        Objects.requireNonNull(processor, "processor is null");
        return new a(processor);
    }
}
