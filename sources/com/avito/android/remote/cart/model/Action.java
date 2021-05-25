package com.avito.android.remote.cart.model;

import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/cart/model/Action;", "", "<init>", "()V", "LogEvent", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/cart/model/Action$LogEvent;", "Lcom/avito/android/remote/cart/model/Action$Unknown;", "cart_release"}, k = 1, mv = {1, 4, 2})
public abstract class Action {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/cart/model/Action$LogEvent;", "Lcom/avito/android/remote/cart/model/Action;", "", "id", "I", "getId", "()I", "version", "getVersion", "", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "<init>", "(IILjava/util/Map;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class LogEvent extends Action {
        @SerializedName("id")
        private final int id;
        @SerializedName("params")
        @Nullable
        private final Map<String, String> params;
        @SerializedName("version")
        private final int version;

        public LogEvent(int i, int i2, @Nullable Map<String, String> map) {
            super(null);
            this.id = i;
            this.version = i2;
            this.params = map;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Map<String, String> getParams() {
            return this.params;
        }

        public final int getVersion() {
            return this.version;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/cart/model/Action$Unknown;", "Lcom/avito/android/remote/cart/model/Action;", "<init>", "()V", "cart_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends Action {
        @NotNull
        public static final Unknown INSTANCE = new Unknown();

        public Unknown() {
            super(null);
        }
    }

    public Action() {
    }

    public Action(j jVar) {
    }
}
