package a2.a.a.k0.e;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
public final /* synthetic */ class h extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public h(Consumer consumer) {
        super(1, consumer, Consumer.class, "accept", "accept(Ljava/lang/Object;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        ((Consumer) this.receiver).accept(num);
        return Unit.INSTANCE;
    }
}
