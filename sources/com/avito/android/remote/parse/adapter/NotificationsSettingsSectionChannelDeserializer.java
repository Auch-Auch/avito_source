package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/NotificationsSettingsSectionChannelDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/notifications_settings/NotificationsSettings$Section$Channel;", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsSectionChannelDeserializer implements JsonDeserializer<NotificationsSettings.Section.Channel> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    public NotificationsSettings.Section.Channel deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        JsonObject I1 = a.I1(jsonElement, "json", type, "typeOfT", jsonDeserializationContext, "context");
        String x2 = a.x2(I1, "type", "jsonObject[\"type\"]");
        String x22 = a.x2(I1, "title", "jsonObject[\"title\"]");
        JsonElement jsonElement2 = I1.get("value");
        Intrinsics.checkNotNullExpressionValue(jsonElement2, "jsonObject[\"value\"]");
        boolean asBoolean = jsonElement2.getAsBoolean();
        if (x2 != null) {
            int hashCode = x2.hashCode();
            if (hashCode != 3452698) {
                if (hashCode == 96619420 && x2.equals("email")) {
                    Intrinsics.checkNotNullExpressionValue(x22, "title");
                    return new NotificationsSettings.Section.Channel.Email(x2, x22, asBoolean);
                }
            } else if (x2.equals("push")) {
                Intrinsics.checkNotNullExpressionValue(x22, "title");
                return new NotificationsSettings.Section.Channel.Push(x2, x22, asBoolean);
            }
        }
        Intrinsics.checkNotNullExpressionValue(x2, "type");
        Intrinsics.checkNotNullExpressionValue(x22, "title");
        return new NotificationsSettings.Section.Channel.Other(x2, x22, asBoolean);
    }
}
