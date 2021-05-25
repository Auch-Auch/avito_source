package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ContactAccessPackageTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "<init>", "()V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessPackageTypeAdapter implements JsonDeserializer<ContactAccessPackage> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public ContactAccessPackage deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        JsonElement jsonElement2 = I1.get("action");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "js.get(\"action\")");
        JsonObject asJsonObject = jsonElement2.getAsJsonObject();
        String x2 = a.x2(asJsonObject, "url", "actionObject.get(\"url\")");
        JsonElement jsonElement3 = I1.get("id");
        Intrinsics.checkNotNullExpressionValue(jsonElement3, "js.get(\"id\")");
        String asString = jsonElement3.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "js.get(\"id\").asString");
        JsonElement jsonElement4 = I1.get("countDetails");
        Intrinsics.checkNotNullExpressionValue(jsonElement4, "js.get(\"countDetails\")");
        String asString2 = jsonElement4.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "js.get(\"countDetails\").asString");
        JsonElement jsonElement5 = I1.get("countPercentage");
        Intrinsics.checkNotNullExpressionValue(jsonElement5, "js.get(\"countPercentage\")");
        int asInt = jsonElement5.getAsInt();
        JsonElement jsonElement6 = I1.get(ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkNotNullExpressionValue(jsonElement6, "js.get(\"details\")");
        String asString3 = jsonElement6.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString3, "js.get(\"details\").asString");
        JsonElement jsonElement7 = asJsonObject.get("name");
        Intrinsics.checkNotNullExpressionValue(jsonElement7, "actionObject.get(\"name\")");
        String asString4 = jsonElement7.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString4, "actionObject.get(\"name\").asString");
        JsonElement jsonElement8 = asJsonObject.get("title");
        Intrinsics.checkNotNullExpressionValue(jsonElement8, "actionObject.get(\"title\")");
        String asString5 = jsonElement8.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString5, "actionObject.get(\"title\").asString");
        JsonElement jsonElement9 = asJsonObject.get("description");
        Intrinsics.checkNotNullExpressionValue(jsonElement9, "actionObject.get(\"description\")");
        String asString6 = jsonElement9.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString6, "actionObject.get(\"description\").asString");
        Intrinsics.checkNotNullExpressionValue(x2, "url");
        return new ContactAccessPackage(asString, asString2, asInt, asString3, asString4, asString5, asString6, m.replace$default(x2, "{{apiUrl}}/", "", false, 4, (Object) null));
    }
}
