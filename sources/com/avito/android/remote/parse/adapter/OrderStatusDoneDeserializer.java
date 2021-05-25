package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.OrderMessage;
import com.avito.android.remote.model.OrderStatus;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/OrderStatusDoneDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/OrderStatus$Done;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/OrderStatus$Done;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OrderStatusDoneDeserializer implements JsonDeserializer<OrderStatus.Done> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public OrderStatus.Done deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        boolean equals = m.equals(a.x2(I1, "status", "jsonObject[\"status\"]"), PaymentStateKt.PAYMENT_STATE_DONE, true);
        JsonElement jsonElement2 = I1.get("message");
        return new OrderStatus.Done(equals, (OrderMessage) (jsonElement2 != null ? jsonDeserializationContext.deserialize(jsonElement2, OrderMessage.class) : null));
    }
}
