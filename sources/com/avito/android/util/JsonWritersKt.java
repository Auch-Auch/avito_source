package com.avito.android.util;

import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0019\b\u0004\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u000f\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0007*\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2.\b\u0004\u0010\u000e\u001a(\u0012\u0004\u0012\u00020\u0000\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"Lcom/google/gson/stream/JsonWriter;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "writer", "writeObject", "(Lcom/google/gson/stream/JsonWriter;Lkotlin/jvm/functions/Function1;)V", "T", "", "iterable", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "element", "consumer", "writeArray", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)V", "gson"}, k = 2, mv = {1, 4, 2})
public final class JsonWritersKt {
    public static final <T> void writeArray(@NotNull JsonWriter jsonWriter, @NotNull Iterable<? extends T> iterable, @NotNull Function2<? super JsonWriter, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(jsonWriter, "$this$writeArray");
        Intrinsics.checkNotNullParameter(iterable, "iterable");
        Intrinsics.checkNotNullParameter(function2, "consumer");
        jsonWriter.beginArray();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            function2.invoke(jsonWriter, (Object) it.next());
        }
        jsonWriter.endArray();
    }

    public static final void writeObject(@NotNull JsonWriter jsonWriter, @NotNull Function1<? super JsonWriter, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonWriter, "$this$writeObject");
        Intrinsics.checkNotNullParameter(function1, "writer");
        jsonWriter.beginObject();
        function1.invoke(jsonWriter);
        jsonWriter.endObject();
    }
}
