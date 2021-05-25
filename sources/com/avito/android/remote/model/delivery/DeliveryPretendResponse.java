package com.avito.android.remote.model.delivery;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse;", "", "", "success", "Z", "getSuccess", "()Z", "Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Error;", "error", "Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Error;", "getError", "()Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Error;", "<init>", "(ZLcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Error;)V", "Error", "Messages", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPretendResponse {
    @SerializedName("error")
    @Nullable
    private final Error error;
    @SerializedName("success")
    private final boolean success;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Error;", "", "Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Messages;", "messages", "Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Messages;", "getMessages", "()Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Messages;", "", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/Integer;Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Messages;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error {
        @SerializedName("code")
        @Nullable
        private final Integer code;
        @SerializedName("messages")
        @Nullable
        private final Messages messages;

        public Error(@Nullable Integer num, @Nullable Messages messages2) {
            this.code = num;
            this.messages = messages2;
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final Messages getMessages() {
            return this.messages;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPretendResponse$Messages;", "", "", "", "contacts", "Ljava/util/Map;", "getContacts", "()Ljava/util/Map;", "delivery", "getDelivery", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Messages {
        @SerializedName("contacts")
        @Nullable
        private final Map<String, String> contacts;
        @SerializedName("delivery")
        @Nullable
        private final Map<String, String> delivery;

        public Messages(@Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            this.contacts = map;
            this.delivery = map2;
        }

        @Nullable
        public final Map<String, String> getContacts() {
            return this.contacts;
        }

        @Nullable
        public final Map<String, String> getDelivery() {
            return this.delivery;
        }
    }

    public DeliveryPretendResponse(boolean z, @Nullable Error error2) {
        this.success = z;
        this.error = error2;
    }

    @Nullable
    public final Error getError() {
        return this.error;
    }

    public final boolean getSuccess() {
        return this.success;
    }
}
