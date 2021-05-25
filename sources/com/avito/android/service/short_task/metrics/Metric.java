package com.avito.android.service.short_task.metrics;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/avito/android/service/short_task/metrics/Metric;", "", "", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/avito/android/service/short_task/metrics/Metric;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class Metric {
    @NotNull
    public final String a;
    @NotNull
    public final Object b;

    public Metric(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(obj, "value");
        this.a = str;
        this.b = obj;
    }

    public static /* synthetic */ Metric copy$default(Metric metric, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = metric.a;
        }
        if ((i & 2) != 0) {
            obj = metric.b;
        }
        return metric.copy(str, obj);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final Object component2() {
        return this.b;
    }

    @NotNull
    public final Metric copy(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(obj, "value");
        return new Metric(str, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        return Intrinsics.areEqual(this.a, metric.a) && Intrinsics.areEqual(this.b, metric.b);
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    @NotNull
    public final Object getValue() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.b;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Metric(name=");
        L.append(this.a);
        L.append(", value=");
        return a.r(L, this.b, ")");
    }
}
