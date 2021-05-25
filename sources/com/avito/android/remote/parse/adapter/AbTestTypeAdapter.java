package com.avito.android.remote.parse.adapter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.ab_tests.AbTest;
import com.avito.android.remote.model.ab_tests.AnalyticsParams;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AbTestTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/ab_tests/AbTest;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/ab_tests/AbTest;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/ab_tests/AbTest;)V", "Lcom/google/gson/JsonParser;", AuthSource.SEND_ABUSE, "Lcom/google/gson/JsonParser;", "parser", "<init>", "()V", "Companion", "config_release"}, k = 1, mv = {1, 4, 2})
public final class AbTestTypeAdapter extends TypeAdapter<AbTest> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final JsonParser a = new JsonParser();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/parse/adapter/AbTestTypeAdapter$Companion;", "", "", "KEY_AB_ANALYTIC_PARAMS", "Ljava/lang/String;", "KEY_AB_TEST_CONFIG", "KEY_AB_TEST_GROUP", "KEY_AP_CLIENT_EXPOSURE", "KEY_AP_TOKEN", "<init>", "()V", "config_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public void write(@NotNull JsonWriter jsonWriter, @NotNull AbTest abTest) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(abTest, "value");
    }

    @Override // com.google.gson.TypeAdapter
    @Nullable
    public AbTest read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                String str = null;
                AnalyticsParams analyticsParams = null;
                String str2 = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        int hashCode = nextName.hashCode();
                        if (hashCode != -1354792126) {
                            if (hashCode != -1202336499) {
                                if (hashCode == 273563251 && nextName.equals("analyticParams")) {
                                    if (jsonReader.peek() != JsonToken.NULL) {
                                        JsonToken peek2 = jsonReader.peek();
                                        JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                                        if (peek2 == jsonToken2) {
                                            jsonReader.beginObject();
                                            String str3 = null;
                                            Boolean bool = null;
                                            while (jsonReader.hasNext()) {
                                                String nextName2 = jsonReader.nextName();
                                                if (nextName2 != null) {
                                                    int hashCode2 = nextName2.hashCode();
                                                    if (hashCode2 != -674206503) {
                                                        if (hashCode2 == 3105 && nextName2.equals("ab")) {
                                                            str3 = jsonReader.nextString();
                                                        }
                                                    } else if (nextName2.equals("defaultEvent")) {
                                                        bool = Boolean.valueOf(jsonReader.nextBoolean());
                                                    }
                                                }
                                                jsonReader.skipValue();
                                            }
                                            jsonReader.endObject();
                                            if (str3 != null) {
                                                Intrinsics.checkNotNull(str3);
                                                analyticsParams = new AnalyticsParams(str3, bool != null ? bool.booleanValue() : false);
                                            } else {
                                                analyticsParams = null;
                                            }
                                        } else {
                                            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken2, " but was "), " at ", jsonReader));
                                        }
                                    } else {
                                        throw new JsonNullParsingException();
                                    }
                                }
                            } else if (nextName.equals("testGroup")) {
                                str = jsonReader.nextString();
                            }
                        } else if (nextName.equals(Navigation.CONFIG)) {
                            JsonElement parse = this.a.parse(jsonReader);
                            Intrinsics.checkNotNullExpressionValue(parse, "parser.parse(reader)");
                            str2 = parse.getAsJsonObject().toString();
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                if (str == null) {
                    return null;
                }
                Intrinsics.checkNotNull(str);
                return new AbTest(str, analyticsParams, str2);
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }
}
