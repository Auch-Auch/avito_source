package com.avito.android.jsonrpc.client;

import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/jsonrpc/client/Deserializer;", "T", "", "Ljava/lang/reflect/Type;", "type", "data", "deserialize", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", "jsonrpc"}, k = 1, mv = {1, 4, 2})
public interface Deserializer<T> {
    @Nullable
    Object deserialize(@NotNull Type type, T t);
}
