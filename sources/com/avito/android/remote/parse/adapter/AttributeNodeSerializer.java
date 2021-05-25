package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AttributeNodeSerializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/remote/model/category_parameters/AttributeNode;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class AttributeNodeSerializer implements JsonSerializer<AttributeNode> {
    @NotNull
    public JsonElement serialize(@NotNull AttributeNode attributeNode, @Nullable Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(attributeNode, "src");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (attributeNode instanceof AttributeNode.ListNode) {
            JsonElement serialize = jsonSerializationContext.serialize(attributeNode);
            Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src)");
            return serialize;
        } else if (attributeNode instanceof AttributeNode.StringNode) {
            JsonElement serialize2 = jsonSerializationContext.serialize(attributeNode);
            Intrinsics.checkNotNullExpressionValue(serialize2, "context.serialize(src)");
            return serialize2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
