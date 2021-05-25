package kotlin.collections;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import t6.n.a0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH$¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0004¢\u0006\u0004\b\u000e\u0010\nR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "computeNext", "()V", "value", "setNext", "(Ljava/lang/Object;)V", PaymentStateKt.PAYMENT_STATE_DONE, "Lt6/n/a0;", AuthSource.SEND_ABUSE, "Lt6/n/a0;", "state", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "nextValue", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public a0 a = a0.NotReady;
    public T b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            a0.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[0] = 2;
        }
    }

    public abstract void computeNext();

    public final void done() {
        this.a = a0.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        a0 a0Var = this.a;
        a0 a0Var2 = a0.Failed;
        if (a0Var != a0Var2) {
            int ordinal = a0Var.ordinal();
            if (ordinal == 0) {
                return true;
            }
            if (ordinal != 2) {
                this.a = a0Var2;
                computeNext();
                if (this.a == a0.Ready) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.a = a0.NotReady;
            return this.b;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T t) {
        this.b = t;
        this.a = a0.Ready;
    }
}
