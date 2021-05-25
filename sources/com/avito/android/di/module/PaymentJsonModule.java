package com.avito.android.di.module;

import com.avito.android.remote.model.payment.PaymentMethod;
import com.avito.android.remote.model.payment.form.PaymentGenericFormResult;
import com.avito.android.remote.model.payment.generic.PaymentGenericResult;
import com.avito.android.remote.model.payment.history.OperationTarget;
import com.avito.android.remote.model.payment.history.OrderTarget;
import com.avito.android.remote.model.payment.history.PaymentHistoryListElement;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.remote.model.payment.status.form.PaymentStatusFormResult;
import com.avito.android.remote.parse.adapter.PaymentHistoryListElementTypeAdapter;
import com.avito.android.remote.parse.adapter.PaymentMethodTypeAdapter;
import com.avito.android.remote.parse.adapter.PaymentOperationTargetTypeAdapter;
import com.avito.android.remote.parse.adapter.PaymentOrderTargetTypeAdapter;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/di/module/PaymentJsonModule;", "", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "()Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PaymentJsonModule {
    @NotNull
    public static final PaymentJsonModule INSTANCE = new PaymentJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(new LinkedHashSet(), PaymentGenericResult.class, r.mapOf(TuplesKt.to("ok", PaymentGenericResult.Ok.class), TuplesKt.to("dublicate-payment-error", PaymentGenericResult.DuplicatePayment.class), TuplesKt.to("form-incorrect-data", PaymentGenericResult.FormIncorrectData.class), TuplesKt.to("forbidden", PaymentGenericResult.ForbiddenPayment.class))), PaymentStatusResult.class, r.mapOf(TuplesKt.to("ok", PaymentStatusResult.PaymentStatus.class), TuplesKt.to("forbidden", PaymentStatusResult.ForbiddenPayment.class))), PaymentGenericFormResult.class, q.mapOf(TuplesKt.to("ok", PaymentGenericFormResult.Ok.class))), PaymentStatusFormResult.class, q.mapOf(TuplesKt.to("ok", PaymentStatusFormResult.StatusForm.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(PaymentMethod.class, new PaymentMethodTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(PaymentHistoryListElement.class, new PaymentHistoryListElementTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(OperationTarget.class, new PaymentOperationTargetTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(OrderTarget.class, new PaymentOrderTargetTypeAdapter()));
        return linkedHashSet;
    }
}
