package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import kotlin.Metadata;
import kotlin.text.Typography;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"api_release"}, k = 2, mv = {1, 4, 2})
public final class TypedResultDeserializerKt {
    public static final JsonElement access$getMandatoryKey(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new JsonParseException(a.d3("Could not find mandatory key \"", str, Typography.quote));
    }
}
