package com.avito.android.analytics.statsd;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdRecord;", "Ljava/io/Serializable;", "Lcom/avito/android/analytics/statsd/StatsdType;", "type", "Lcom/avito/android/analytics/statsd/StatsdType;", "getType", "()Lcom/avito/android/analytics/statsd/StatsdType;", "", "value", "Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/statsd/StatsdType;Ljava/lang/Number;)V", "Companion", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
public final class StatsdRecord implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 1;
    @SerializedName("key")
    @NotNull
    private final String key;
    @SerializedName("type")
    @NotNull
    private final StatsdType type;
    @SerializedName("value")
    @NotNull
    private final Number value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0002@\u0003XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/statsd/StatsdRecord$Companion;", "", "", "serialVersionUID", "J", "getSerialVersionUID$annotations", "()V", "<init>", "analytics-statsd_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public StatsdRecord(@NotNull String str, @NotNull StatsdType statsdType, @NotNull Number number) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(statsdType, "type");
        Intrinsics.checkNotNullParameter(number, "value");
        this.key = str;
        this.type = statsdType;
        this.value = number;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final StatsdType getType() {
        return this.type;
    }

    @NotNull
    public final Number getValue() {
        return this.value;
    }
}
