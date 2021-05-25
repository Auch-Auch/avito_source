package com.avito.android.remote.model.delivery;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryContactParametersPretendResponse;", "", "", "", "messages", "Ljava/util/Map;", "getMessages", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryContactParametersPretendResponse {
    @SerializedName("messages")
    @Nullable
    private final Map<String, String> messages;

    public DeliveryContactParametersPretendResponse(@Nullable Map<String, String> map) {
        this.messages = map;
    }

    @Nullable
    public final Map<String, String> getMessages() {
        return this.messages;
    }
}
