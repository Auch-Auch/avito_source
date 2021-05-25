package com.avito.android.payment.form;

import com.jakewharton.rxrelay2.Relay;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "arg", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class PaymentGenericFormPresenterImpl$asLambda$1 extends Lambda implements Function1<T, Unit> {
    public final /* synthetic */ Relay a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentGenericFormPresenterImpl$asLambda$1(Relay relay) {
        super(1);
        this.a = relay;
    }

    @Override // kotlin.jvm.functions.Function1
    public final void invoke(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "arg");
        this.a.accept(t);
    }
}
