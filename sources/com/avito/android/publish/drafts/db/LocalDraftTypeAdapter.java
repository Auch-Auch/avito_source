package com.avito.android.publish.drafts.db;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.remote.InvalidSchemaException;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/drafts/db/LocalDraftTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/avito/android/publish/drafts/LocalDraft;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/avito/android/publish/drafts/LocalDraft;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/publish/drafts/LocalDraft;", "Lcom/google/gson/JsonObject;", "", "name", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class LocalDraftTypeAdapter implements JsonSerializer<LocalDraft>, JsonDeserializer<LocalDraft> {
    public final String a(JsonObject jsonObject, String str) {
        String asString;
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
            return asString;
        }
        throw new InvalidSchemaException(a.c3(str, " must not be null"));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x00b9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00b9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0113, code lost:
        if (r1 != null) goto L_0x011c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0108  */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.publish.drafts.LocalDraft deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r25, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r26, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r27) {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.drafts.db.LocalDraftTypeAdapter.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.publish.drafts.LocalDraft");
    }

    @NotNull
    public JsonElement serialize(@NotNull LocalDraft localDraft, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(localDraft, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(SDKAnalyticsEvents.PARAMETER_SESSION_ID, localDraft.getSessionId());
        jsonObject.addProperty(LocalDraftTypeAdapterKt.DRAFT_ID, localDraft.getDraftId());
        jsonObject.addProperty("state", localDraft.getState());
        jsonObject.addProperty("version", Integer.valueOf(localDraft.getVersion()));
        jsonObject.addProperty("has_local_changes", Boolean.valueOf(localDraft.getHasLocalChanges()));
        String serverDraftId = localDraft.getServerDraftId();
        if (serverDraftId != null) {
            jsonObject.addProperty("server_draft_id", serverDraftId);
        }
        jsonObject.add("slots", jsonSerializationContext.serialize(localDraft.getSlots()));
        jsonObject.add(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, jsonSerializationContext.serialize(localDraft.getParameters()));
        jsonObject.add("navigation", jsonSerializationContext.serialize(localDraft.getNavigation()));
        String activeFieldId = localDraft.getActiveFieldId();
        if (activeFieldId != null) {
            jsonObject.addProperty("active_field_id", activeFieldId);
        }
        jsonObject.add("local_publish_state", jsonSerializationContext.serialize(localDraft.getLocalPublishState()));
        return jsonObject;
    }
}
