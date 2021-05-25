package com.avito.android.util.rx3;

import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0006\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\u0006\u001a,\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\b\u001a\u00028\u0000H\n¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "T", "defaultValue", "Lcom/jakewharton/rxrelay3/Relay;", "serializedBehaviorRelay", "(Ljava/lang/Object;)Lcom/jakewharton/rxrelay3/Relay;", "()Lcom/jakewharton/rxrelay3/Relay;", "serializedPublishRelay", "value", "", "plusAssign", "(Lcom/jakewharton/rxrelay3/Relay;Ljava/lang/Object;)V", "rx"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "RxRelays")
public final class RxRelays {
    public static final <T> void plusAssign(@NotNull Relay<T> relay, @NotNull T t) {
        Intrinsics.checkNotNullParameter(relay, "$this$plusAssign");
        Intrinsics.checkNotNullParameter(t, "value");
        relay.accept(t);
    }

    @NotNull
    public static final <T> Relay<T> serializedBehaviorRelay(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "defaultValue");
        Relay<T> serialized = BehaviorRelay.createDefault(t).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        return serialized;
    }

    @NotNull
    public static final <T> Relay<T> serializedPublishRelay() {
        Relay<T> serialized = PublishRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "PublishRelay.create<T>().toSerialized()");
        return serialized;
    }

    @NotNull
    public static final <T> Relay<T> serializedBehaviorRelay() {
        Relay<T> serialized = BehaviorRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.create<T>().toSerialized()");
        return serialized;
    }
}
