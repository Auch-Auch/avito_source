package a7.a.a.e.a;

import com.jakewharton.rxbinding4.view.ViewLayoutChangeEvent;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.payments.method.PaymentMethodListCard;
public final class c<T> implements Predicate<ViewLayoutChangeEvent> {
    public final /* synthetic */ PaymentMethodListCard a;

    public c(PaymentMethodListCard paymentMethodListCard) {
        this.a = paymentMethodListCard;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(ViewLayoutChangeEvent viewLayoutChangeEvent) {
        ViewLayoutChangeEvent viewLayoutChangeEvent2 = viewLayoutChangeEvent;
        PaymentMethodListCard paymentMethodListCard = this.a;
        Intrinsics.checkNotNullExpressionValue(viewLayoutChangeEvent2, "it");
        return PaymentMethodListCard.access$oldHeight(paymentMethodListCard, viewLayoutChangeEvent2) != PaymentMethodListCard.access$newHeight(this.a, viewLayoutChangeEvent2);
    }
}
