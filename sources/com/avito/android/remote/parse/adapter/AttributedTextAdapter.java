package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DateAttribute;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.remote.model.text.FontAttribute;
import com.avito.android.remote.model.text.FontParameter;
import com.avito.android.remote.model.text.LinkAttribute;
import com.avito.android.remote.model.text.UnknownAttribute;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AttributedTextAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/google/gson/JsonSerializer;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/text/AttributedText;", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "serialize", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AttributedTextAdapter implements JsonDeserializer<AttributedText>, JsonSerializer<AttributedText> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public AttributedText deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        List list;
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "text", "js.get(\"text\")");
        if (I1.has(Navigation.ATTRIBUTES)) {
            JsonObject asJsonObject = I1.getAsJsonObject(Navigation.ATTRIBUTES);
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "js.getAsJsonObject(\"attributes\")");
            Set<Map.Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
            if (entrySet.isEmpty()) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList(entrySet.size());
                Intrinsics.checkNotNullExpressionValue(entrySet, "entries");
                for (T t : entrySet) {
                    String str = (String) t.getKey();
                    Object value = t.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "it.value");
                    JsonObject asJsonObject2 = ((JsonElement) value).getAsJsonObject();
                    String x22 = a.x2(asJsonObject2, "type", "element.get(\"type\")");
                    JsonElement jsonElement2 = asJsonObject2.get("value");
                    Intrinsics.checkNotNullExpressionValue(jsonElement2, "element.get(\"value\")");
                    JsonObject asJsonObject3 = jsonElement2.getAsJsonObject();
                    if (x22 != null) {
                        switch (x22.hashCode()) {
                            case 3321850:
                                if (!x22.equals("link")) {
                                    break;
                                } else {
                                    String x23 = a.x2(asJsonObject3, "title", "get(\"title\")");
                                    String x24 = a.x2(asJsonObject3, "url", "get(\"url\")");
                                    JsonElement jsonElement3 = asJsonObject3.get("deepLink");
                                    String asString = jsonElement3 != null ? jsonElement3.getAsString() : null;
                                    DeepLink deepLink = (DeepLink) jsonDeserializationContext.deserialize(asJsonObject3.get("deepLink"), DeepLink.class);
                                    if (deepLink == null || (deepLink instanceof NoMatchLink)) {
                                        Intrinsics.checkNotNullExpressionValue(str, "name");
                                        Intrinsics.checkNotNullExpressionValue(x23, "title");
                                        Intrinsics.checkNotNullExpressionValue(x24, "url");
                                        arrayList.add(new LinkAttribute(str, x23, x24));
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str, "name");
                                        Intrinsics.checkNotNullExpressionValue(x23, "title");
                                        arrayList.add(new DeepLinkAttribute(str, x23, deepLink, x24, asString));
                                        continue;
                                    }
                                }
                                break;
                            case 405645655:
                                if (!x22.equals(Navigation.ATTRIBUTES)) {
                                    break;
                                } else {
                                    String x25 = a.x2(asJsonObject3, "title", "get(\"title\")");
                                    List list2 = (List) jsonDeserializationContext.deserialize(asJsonObject3.get("list"), new TypeToken<List<? extends FontParameter>>() { // from class: com.avito.android.remote.parse.adapter.AttributedTextAdapter$parseAttributes$1$1$listType$1
                                    }.getType());
                                    Intrinsics.checkNotNullExpressionValue(str, "name");
                                    Intrinsics.checkNotNullExpressionValue(x25, "title");
                                    Intrinsics.checkNotNullExpressionValue(list2, "params");
                                    arrayList.add(new FontAttribute(str, x25, list2));
                                    continue;
                                }
                            case 628280070:
                                if (!x22.equals("deepLink")) {
                                    break;
                                } else {
                                    String x26 = a.x2(asJsonObject3, "title", "get(\"title\")");
                                    JsonElement jsonElement4 = asJsonObject3.get("deepLink");
                                    String asString2 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                                    DeepLink deepLink2 = (DeepLink) jsonDeserializationContext.deserialize(asJsonObject3.get(ShareConstants.MEDIA_URI), DeepLink.class);
                                    Intrinsics.checkNotNullExpressionValue(str, "name");
                                    Intrinsics.checkNotNullExpressionValue(x26, "title");
                                    Intrinsics.checkNotNullExpressionValue(deepLink2, "link");
                                    arrayList.add(new DeepLinkAttribute(str, x26, deepLink2, null, asString2));
                                    continue;
                                }
                            case 1793702779:
                                if (!x22.equals("datetime")) {
                                    break;
                                } else {
                                    JsonElement jsonElement5 = asJsonObject3.get("format");
                                    String asString3 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                                    JsonElement jsonElement6 = asJsonObject3.get("timestamp");
                                    Long valueOf = jsonElement6 != null ? Long.valueOf(jsonElement6.getAsLong()) : null;
                                    Intrinsics.checkNotNullExpressionValue(str, "name");
                                    arrayList.add(new DateAttribute(str, Sort.DATE, asString3, valueOf));
                                    continue;
                                }
                        }
                    }
                    JsonElement jsonElement7 = asJsonObject3.get("title");
                    if (jsonElement7 != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "name");
                        String asString4 = jsonElement7.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString4, "this.asString");
                        Intrinsics.checkNotNullExpressionValue(x22, "type");
                        arrayList.add(new UnknownAttribute(str, asString4, x22));
                    }
                }
                list = arrayList;
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(x2, "text");
        return new AttributedText(x2, list);
    }

    @NotNull
    public JsonElement serialize(@Nullable AttributedText attributedText, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        if (attributedText == null) {
            JsonNull jsonNull = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(jsonNull, "JsonNull.INSTANCE");
            return jsonNull;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", attributedText.getText());
        List<Attribute> attributes = attributedText.getAttributes();
        JsonObject jsonObject2 = new JsonObject();
        for (T t : attributes) {
            String name = t.getName();
            JsonObject jsonObject3 = new JsonObject();
            JsonObject jsonObject4 = new JsonObject();
            jsonObject3.add("value", jsonObject4);
            jsonObject4.addProperty("title", t.getTitle());
            if (t instanceof LinkAttribute) {
                jsonObject3.addProperty("type", "link");
                jsonObject4.addProperty("url", t.getUrl());
            } else if (t instanceof DeepLinkAttribute) {
                T t2 = t;
                if (t2.getFallbackUrl() != null) {
                    jsonObject3.addProperty("type", "link");
                    jsonObject4.addProperty("deepLink", t2.getDeepLinkString());
                    jsonObject4.addProperty("url", t2.getFallbackUrl());
                } else {
                    jsonObject3.addProperty("type", "deepLink");
                    jsonObject4.addProperty(ShareConstants.MEDIA_URI, t2.getDeepLinkString());
                }
            } else if (t instanceof FontAttribute) {
                jsonObject3.addProperty("type", Navigation.ATTRIBUTES);
                JsonArray jsonArray = new JsonArray();
                for (T t3 : t.getParameters()) {
                    JsonObject jsonObject5 = new JsonObject();
                    if (t3 instanceof FontParameter.ColorParameter) {
                        jsonObject5.addProperty("type", "fontColor");
                        T t4 = t3;
                        jsonObject5.add("value", jsonSerializationContext.serialize(t4.getColor(), Color.class));
                        jsonObject5.addProperty("valueName", t4.getColorKey());
                        jsonObject5.add("valueDark", jsonSerializationContext.serialize(t4.getColorDark(), Color.class));
                    } else if (t3 instanceof FontParameter.StyleParameter) {
                        jsonObject5.addProperty("type", "fontStyle");
                        jsonObject5.addProperty("value", t3.getStyle());
                    } else if (t3 instanceof FontParameter.StrikethroughParameter) {
                        jsonObject5.addProperty("type", "strikeThrough");
                        jsonObject5.addProperty("value", "");
                    } else if (t3 instanceof FontParameter.TextStyleParameter) {
                        jsonObject5.addProperty("type", "textStyle");
                        T t5 = t3;
                        jsonObject5.addProperty(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, t5.getStyle());
                        jsonObject5.addProperty("value", t5.getAttribute());
                    } else if (t3 instanceof FontParameter.ParagraphSpacingRelativeParameter) {
                        jsonObject5.addProperty("value", Float.valueOf(t3.getValue()));
                    } else if (t3 instanceof FontParameter.UseParagraphingParameter) {
                        jsonObject5.addProperty("type", "useParagraphing");
                        jsonObject5.addProperty("value", "");
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    jsonArray.add(jsonObject5);
                }
                jsonObject4.add("list", jsonArray);
            } else if (t instanceof DateAttribute) {
                jsonObject3.addProperty("type", "TODO");
            } else if (t instanceof UnknownAttribute) {
                jsonObject3.addProperty("type", t.getType());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            jsonObject2.add(name, jsonObject3);
        }
        jsonObject.add(Navigation.ATTRIBUTES, jsonObject2);
        return jsonObject;
    }
}
