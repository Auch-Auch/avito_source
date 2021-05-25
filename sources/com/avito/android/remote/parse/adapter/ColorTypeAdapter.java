package com.avito.android.remote.parse.adapter;

import androidx.core.view.ViewCompat;
import com.avito.android.remote.model.Color;
import com.avito.android.util.StringUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ColorTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/Color;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/Color;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "color", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/Color;)V", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ColorTypeAdapter extends TypeAdapter<Color> {
    @Override // com.google.gson.TypeAdapter
    @Nullable
    public Color read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        String nextString = jsonReader.nextString();
        if (m.startsWith$default(nextString, "0x", false, 2, null)) {
            nextString = m.replace$default(nextString, "0x", "#", false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(nextString, "with(reader.nextString()…s\n            }\n        }");
        Integer parseColorOrNull = StringUtils.parseColorOrNull(nextString);
        if (parseColorOrNull != null) {
            return new Color(parseColorOrNull.intValue());
        }
        return null;
    }

    public void write(@NotNull JsonWriter jsonWriter, @NotNull Color color) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(color, "color");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color.getValue() & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        jsonWriter.value(format);
    }
}
