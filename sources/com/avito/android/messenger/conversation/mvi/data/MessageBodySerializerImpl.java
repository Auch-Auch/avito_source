package com.avito.android.messenger.conversation.mvi.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializerImpl;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", SDKConstants.PARAM_A2U_BODY, "", "serialize", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;)Ljava/lang/String;", "serializeType", "type", "jsonBody", "deserialize", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/message/MessageBody;", "", "Ljava/lang/Class;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "classMap", AuthSource.BOOKING_ORDER, "typeMap", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageBodySerializerImpl implements MessageBodySerializer {
    public final Map<String, Class<? extends MessageBody>> a = new LinkedHashMap();
    public final Map<Class<? extends MessageBody>, String> b = new LinkedHashMap();
    public final Gson c;

    public MessageBodySerializerImpl(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.c = gson;
        if (this.a.containsKey("text") || this.b.containsKey(MessageBody.Text.Regular.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Text.Regular.class, a.R("Type is already registered: type = ", "text", ", clazz = ")));
        }
        this.a.put("text", MessageBody.Text.Regular.class);
        this.b.put(MessageBody.Text.Regular.class, "text");
        if (this.a.containsKey(MessageBody.Text.Reaction.TYPE) || this.b.containsKey(MessageBody.Text.Reaction.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Text.Reaction.class, a.R("Type is already registered: type = ", MessageBody.Text.Reaction.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.Text.Reaction.TYPE, MessageBody.Text.Reaction.class);
        this.b.put(MessageBody.Text.Reaction.class, MessageBody.Text.Reaction.TYPE);
        if (this.a.containsKey("image") || this.b.containsKey(MessageBody.ImageBody.class)) {
            throw new IllegalStateException(a.B2(MessageBody.ImageBody.class, a.R("Type is already registered: type = ", "image", ", clazz = ")));
        }
        this.a.put("image", MessageBody.ImageBody.class);
        this.b.put(MessageBody.ImageBody.class, "image");
        if (this.a.containsKey("item") || this.b.containsKey(MessageBody.Item.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Item.class, a.R("Type is already registered: type = ", "item", ", clazz = ")));
        }
        this.a.put("item", MessageBody.Item.class);
        this.b.put(MessageBody.Item.class, "item");
        if (this.a.containsKey(MessageBody.Call.TYPE) || this.b.containsKey(MessageBody.Call.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Call.class, a.R("Type is already registered: type = ", MessageBody.Call.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.Call.TYPE, MessageBody.Call.class);
        this.b.put(MessageBody.Call.class, MessageBody.Call.TYPE);
        if (this.a.containsKey(MessageBody.AppCall.TYPE) || this.b.containsKey(MessageBody.AppCall.class)) {
            throw new IllegalStateException(a.B2(MessageBody.AppCall.class, a.R("Type is already registered: type = ", MessageBody.AppCall.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.AppCall.TYPE, MessageBody.AppCall.class);
        this.b.put(MessageBody.AppCall.class, MessageBody.AppCall.TYPE);
        if (this.a.containsKey("link") || this.b.containsKey(MessageBody.Link.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Link.class, a.R("Type is already registered: type = ", "link", ", clazz = ")));
        }
        this.a.put("link", MessageBody.Link.class);
        this.b.put(MessageBody.Link.class, "link");
        if (this.a.containsKey("file") || this.b.containsKey(MessageBody.File.class)) {
            throw new IllegalStateException(a.B2(MessageBody.File.class, a.R("Type is already registered: type = ", "file", ", clazz = ")));
        }
        this.a.put("file", MessageBody.File.class);
        this.b.put(MessageBody.File.class, "file");
        if (this.a.containsKey("location") || this.b.containsKey(MessageBody.Location.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Location.class, a.R("Type is already registered: type = ", "location", ", clazz = ")));
        }
        this.a.put("location", MessageBody.Location.class);
        this.b.put(MessageBody.Location.class, "location");
        if (this.a.containsKey("deleted") || this.b.containsKey(MessageBody.Deleted.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Deleted.class, a.R("Type is already registered: type = ", "deleted", ", clazz = ")));
        }
        this.a.put("deleted", MessageBody.Deleted.class);
        this.b.put(MessageBody.Deleted.class, "deleted");
        if (this.a.containsKey(MessageBody.LocalImage.TYPE) || this.b.containsKey(MessageBody.LocalImage.class)) {
            throw new IllegalStateException(a.B2(MessageBody.LocalImage.class, a.R("Type is already registered: type = ", MessageBody.LocalImage.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.LocalImage.TYPE, MessageBody.LocalImage.class);
        this.b.put(MessageBody.LocalImage.class, MessageBody.LocalImage.TYPE);
        if (this.a.containsKey(MessageBody.ImageReference.TYPE) || this.b.containsKey(MessageBody.ImageReference.class)) {
            throw new IllegalStateException(a.B2(MessageBody.ImageReference.class, a.R("Type is already registered: type = ", MessageBody.ImageReference.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.ImageReference.TYPE, MessageBody.ImageReference.class);
        this.b.put(MessageBody.ImageReference.class, MessageBody.ImageReference.TYPE);
        if (this.a.containsKey(MessageBody.ItemReference.TYPE) || this.b.containsKey(MessageBody.ItemReference.class)) {
            throw new IllegalStateException(a.B2(MessageBody.ItemReference.class, a.R("Type is already registered: type = ", MessageBody.ItemReference.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.ItemReference.TYPE, MessageBody.ItemReference.class);
        this.b.put(MessageBody.ItemReference.class, MessageBody.ItemReference.TYPE);
        if (this.a.containsKey("unknown") || this.b.containsKey(MessageBody.Unknown.class)) {
            throw new IllegalStateException(a.B2(MessageBody.Unknown.class, a.R("Type is already registered: type = ", "unknown", ", clazz = ")));
        }
        this.a.put("unknown", MessageBody.Unknown.class);
        this.b.put(MessageBody.Unknown.class, "unknown");
        if (this.a.containsKey(MessageBody.SystemMessageBody.Platform.FromAvito.TYPE) || this.b.containsKey(MessageBody.SystemMessageBody.Platform.FromAvito.class)) {
            throw new IllegalStateException(a.B2(MessageBody.SystemMessageBody.Platform.FromAvito.class, a.R("Type is already registered: type = ", MessageBody.SystemMessageBody.Platform.FromAvito.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.SystemMessageBody.Platform.FromAvito.TYPE, MessageBody.SystemMessageBody.Platform.FromAvito.class);
        this.b.put(MessageBody.SystemMessageBody.Platform.FromAvito.class, MessageBody.SystemMessageBody.Platform.FromAvito.TYPE);
        if (this.a.containsKey(MessageBody.SystemMessageBody.Platform.FromUser.TYPE) || this.b.containsKey(MessageBody.SystemMessageBody.Platform.FromUser.class)) {
            throw new IllegalStateException(a.B2(MessageBody.SystemMessageBody.Platform.FromUser.class, a.R("Type is already registered: type = ", MessageBody.SystemMessageBody.Platform.FromUser.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.SystemMessageBody.Platform.FromUser.TYPE, MessageBody.SystemMessageBody.Platform.FromUser.class);
        this.b.put(MessageBody.SystemMessageBody.Platform.FromUser.class, MessageBody.SystemMessageBody.Platform.FromUser.TYPE);
        if (this.a.containsKey(MessageBody.SystemMessageBody.Text.TYPE) || this.b.containsKey(MessageBody.SystemMessageBody.Text.class)) {
            throw new IllegalStateException(a.B2(MessageBody.SystemMessageBody.Text.class, a.R("Type is already registered: type = ", MessageBody.SystemMessageBody.Text.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.SystemMessageBody.Text.TYPE, MessageBody.SystemMessageBody.Text.class);
        this.b.put(MessageBody.SystemMessageBody.Text.class, MessageBody.SystemMessageBody.Text.TYPE);
        if (this.a.containsKey(MessageBody.SystemMessageBody.Unknown.TYPE) || this.b.containsKey(MessageBody.SystemMessageBody.Unknown.class)) {
            throw new IllegalStateException(a.B2(MessageBody.SystemMessageBody.Unknown.class, a.R("Type is already registered: type = ", MessageBody.SystemMessageBody.Unknown.TYPE, ", clazz = ")));
        }
        this.a.put(MessageBody.SystemMessageBody.Unknown.TYPE, MessageBody.SystemMessageBody.Unknown.class);
        this.b.put(MessageBody.SystemMessageBody.Unknown.class, MessageBody.SystemMessageBody.Unknown.TYPE);
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer
    @NotNull
    public MessageBody deserialize(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "jsonBody");
        Class<? extends MessageBody> cls = this.a.get(str);
        if (cls != null) {
            Object fromJson = this.c.fromJson(str2, (Class<Object>) cls);
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(jsonBody, clazz)");
            return (MessageBody) fromJson;
        }
        throw new IllegalArgumentException(a.d("Cannot deserialize type '", str, "': json=", str2));
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer
    @NotNull
    public String serialize(@NotNull MessageBody messageBody) {
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        String json = this.c.toJson(messageBody);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(body)");
        return json;
    }

    @Override // com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer
    @NotNull
    public String serializeType(@NotNull MessageBody messageBody) {
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        String str = this.b.get(messageBody.getClass());
        if (str != null) {
            return str;
        }
        StringBuilder L = a.L("Unregistered body type, class = ");
        L.append(messageBody.getClass());
        L.append(", ");
        L.append(messageBody);
        throw new IllegalArgumentException(L.toString());
    }
}
