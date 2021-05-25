package com.avito.android.remote.parse.adapter.stream_gson;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.util.JsonNullParsingException;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/stream_gson/NewActionTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/Action;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/Action;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/Action;)V", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class NewActionTypeAdapter extends TypeAdapter<Action> {
    public final Gson a;

    public NewActionTypeAdapter(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public Action read(@NotNull JsonReader jsonReader) {
        NoMatchLink noMatchLink;
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                DeepLink deepLink = null;
                String str = null;
                Action.Confirmation confirmation = null;
                String str2 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        switch (nextName.hashCode()) {
                            case 116076:
                                if (!nextName.equals(ShareConstants.MEDIA_URI)) {
                                    break;
                                } else {
                                    deepLink = (DeepLink) this.a.getAdapter(DeepLink.class).read(jsonReader);
                                    continue;
                                }
                            case 3575610:
                                if (!nextName.equals("type")) {
                                    break;
                                } else {
                                    String nextString = jsonReader.nextString();
                                    if (nextString == null) {
                                        str2 = null;
                                        continue;
                                    } else {
                                        if (!(nextString.length() == 0) && nextString.charAt(0) != '/') {
                                            nextString = '/' + nextString;
                                        }
                                        str2 = nextString;
                                    }
                                }
                            case 110371416:
                                if (!nextName.equals("title")) {
                                    break;
                                } else {
                                    str = jsonReader.nextString();
                                    Intrinsics.checkNotNullExpressionValue(str, "nextString()");
                                    continue;
                                }
                            case 2099153973:
                                if (!nextName.equals("confirmation")) {
                                    break;
                                } else {
                                    confirmation = (Action.Confirmation) this.a.getAdapter(Action.Confirmation.class).read(jsonReader);
                                    continue;
                                }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                }
                if (deepLink != null) {
                    noMatchLink = deepLink;
                } else {
                    noMatchLink = new NoMatchLink();
                }
                return new Action(str, noMatchLink, confirmation, str2, null, null, 48, null);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    public void write(@Nullable JsonWriter jsonWriter, @Nullable Action action) {
        throw new UnsupportedOperationException();
    }
}
