package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.util.JsonNullParsingException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.vk.sdk.api.VKApiConst;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u0002*\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/parse/adapter/WizardParametersTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/avito/android/remote/model/WizardParameter;", "Lcom/google/gson/stream/JsonReader;", "reader", "read", "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/WizardParameter;", "Lcom/google/gson/stream/JsonWriter;", VKApiConst.OUT, "value", "", "write", "(Lcom/google/gson/stream/JsonWriter;Lcom/avito/android/remote/model/WizardParameter;)Ljava/lang/Void;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Navigation;", AuthSource.SEND_ABUSE, "(Lcom/google/gson/stream/JsonReader;)Lcom/avito/android/remote/model/Navigation;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class WizardParametersTypeAdapter extends TypeAdapter<WizardParameter> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[6] = 2;
            iArr[7] = 3;
            JsonToken.values();
            int[] iArr2 = new int[10];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            JsonToken.values();
            int[] iArr3 = new int[10];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[0] = 1;
            iArr3[2] = 2;
        }
    }

    public static final class a extends Lambda implements Function1<JsonReader, Map<String, ? extends String>> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @NotNull
        /* renamed from: a */
        public final Map<String, String> invoke(@NotNull JsonReader jsonReader) {
            int ordinal;
            Intrinsics.checkNotNullParameter(jsonReader, "$this$readAttribute");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jsonReader.peek() != JsonToken.NULL) {
                JsonToken peek = jsonReader.peek();
                JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
                if (peek == jsonToken) {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName = jsonReader.nextName();
                        JsonToken peek2 = jsonReader.peek();
                        if (peek2 != null && ((ordinal = peek2.ordinal()) == 5 || ordinal == 6 || ordinal == 7)) {
                            Intrinsics.checkNotNullExpressionValue(nextName, "name");
                            String nextString = jsonReader.nextString();
                            Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                            linkedHashMap.put(nextName, nextString);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    return linkedHashMap;
                }
                throw new IllegalStateException(a2.b.a.a.a.z2(jsonReader, a2.b.a.a.a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
            }
            throw new JsonNullParsingException();
        }
    }

    public static final class b extends Lambda implements Function1<JsonReader, List<? extends Integer>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0027 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<java.lang.Integer> invoke(@org.jetbrains.annotations.NotNull com.google.gson.stream.JsonReader r5) {
            /*
                r4 = this;
                java.lang.String r0 = "$this$readCategoryIds"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                com.google.gson.stream.JsonToken r0 = r5.peek()
                r1 = 0
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                int r0 = r0.ordinal()
                if (r0 == 0) goto L_0x0017
            L_0x0013:
                r5.skipValue()
                goto L_0x0070
            L_0x0017:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.google.gson.stream.JsonToken r2 = r5.peek()
                com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.BEGIN_ARRAY
                if (r2 != r3) goto L_0x0071
                r5.beginArray()
            L_0x0027:
                boolean r2 = r5.hasNext()
                if (r2 == 0) goto L_0x006c
                com.google.gson.stream.JsonToken r2 = r5.peek()     // Catch:{ NumberFormatException -> 0x005d }
                if (r2 != 0) goto L_0x0034
                goto L_0x003e
            L_0x0034:
                int r2 = r2.ordinal()     // Catch:{ NumberFormatException -> 0x005d }
                r3 = 5
                if (r2 == r3) goto L_0x004b
                r3 = 6
                if (r2 == r3) goto L_0x0042
            L_0x003e:
                r5.skipValue()     // Catch:{ NumberFormatException -> 0x005d }
                goto L_0x005d
            L_0x0042:
                int r2 = r5.nextInt()     // Catch:{ NumberFormatException -> 0x005d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x005d }
                goto L_0x005e
            L_0x004b:
                java.lang.String r2 = r5.nextString()     // Catch:{ NumberFormatException -> 0x005d }
                java.lang.String r3 = "nextString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ NumberFormatException -> 0x005d }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x005d }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x005d }
                goto L_0x005e
            L_0x005d:
                r2 = r1
            L_0x005e:
                if (r2 == 0) goto L_0x0027
                int r2 = r2.intValue()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r0.add(r2)
                goto L_0x0027
            L_0x006c:
                r5.endArray()
                r1 = r0
            L_0x0070:
                return r1
            L_0x0071:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Expected "
                java.lang.String r2 = " but was "
                java.lang.StringBuilder r1 = a2.b.a.a.a.P(r1, r3, r2)
                java.lang.String r2 = " at "
                java.lang.String r5 = a2.b.a.a.a.z2(r5, r1, r2, r5)
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter.b.invoke(com.google.gson.stream.JsonReader):java.util.List");
        }
    }

    public static final class c extends Lambda implements Function1<JsonReader, List<? extends Map<String, ? extends String>>> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<java.util.Map<java.lang.String, java.lang.String>> invoke(@org.jetbrains.annotations.NotNull com.google.gson.stream.JsonReader r5) {
            /*
                r4 = this;
                java.lang.String r0 = "$this$readAttributes"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                com.google.gson.stream.JsonToken r1 = r5.peek()
                if (r1 != 0) goto L_0x0011
                goto L_0x001a
            L_0x0011:
                int r1 = r1.ordinal()
                if (r1 == 0) goto L_0x0028
                r2 = 2
                if (r1 == r2) goto L_0x001e
            L_0x001a:
                r5.skipValue()
                goto L_0x0046
            L_0x001e:
                com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter$a r1 = com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter.a.a
                java.util.Map r5 = r1.invoke(r5)
                r0.add(r5)
                goto L_0x0046
            L_0x0028:
                com.google.gson.stream.JsonToken r1 = r5.peek()
                com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.BEGIN_ARRAY
                if (r1 != r2) goto L_0x0069
                r5.beginArray()
            L_0x0033:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L_0x0043
                com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter$a r1 = com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter.a.a
                java.util.Map r1 = r1.invoke(r5)
                r0.add(r1)
                goto L_0x0033
            L_0x0043:
                r5.endArray()
            L_0x0046:
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Iterator r0 = r0.iterator()
            L_0x004f:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0068
                java.lang.Object r1 = r0.next()
                r2 = r1
                java.util.Map r2 = (java.util.Map) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x004f
                r5.add(r1)
                goto L_0x004f
            L_0x0068:
                return r5
            L_0x0069:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Expected "
                java.lang.String r3 = " but was "
                java.lang.StringBuilder r1 = a2.b.a.a.a.P(r1, r2, r3)
                java.lang.String r2 = " at "
                java.lang.String r5 = a2.b.a.a.a.z2(r5, r1, r2, r5)
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter.c.invoke(com.google.gson.stream.JsonReader):java.util.List");
        }
    }

    public final Navigation a(JsonReader jsonReader) {
        Integer valueOf;
        a aVar = a.a;
        b bVar = b.a;
        c cVar = c.a;
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                String str = null;
                Integer num = null;
                List<Integer> list = null;
                List<Map<String, String>> list2 = null;
                Map<String, String> map = null;
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName != null) {
                        switch (nextName.hashCode()) {
                            case -1354792126:
                                if (!nextName.equals(Navigation.CONFIG)) {
                                    break;
                                } else {
                                    map = a.a.invoke(jsonReader);
                                    continue;
                                }
                            case 98629247:
                                if (!nextName.equals(Navigation.GROUP)) {
                                    break;
                                } else {
                                    str = jsonReader.nextString();
                                    continue;
                                }
                            case 405645655:
                                if (!nextName.equals(Navigation.ATTRIBUTES)) {
                                    break;
                                } else {
                                    list2 = c.a.invoke(jsonReader);
                                    continue;
                                }
                            case 1296531129:
                                if (!nextName.equals("categoryId")) {
                                    break;
                                } else {
                                    try {
                                        JsonToken peek2 = jsonReader.peek();
                                        if (peek2 != null) {
                                            int ordinal = peek2.ordinal();
                                            if (ordinal == 5) {
                                                String nextString = jsonReader.nextString();
                                                Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                                                valueOf = Integer.valueOf(Integer.parseInt(nextString));
                                            } else if (ordinal == 6) {
                                                valueOf = Integer.valueOf(jsonReader.nextInt());
                                            }
                                            num = valueOf;
                                            continue;
                                        }
                                        jsonReader.skipValue();
                                    } catch (NumberFormatException unused) {
                                    }
                                    num = null;
                                }
                            case 1537759450:
                                if (!nextName.equals(Navigation.CATEGORY_IDS)) {
                                    break;
                                } else {
                                    list = b.a.invoke(jsonReader);
                                    continue;
                                }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return new Navigation(str, num, list, list2, map, null, null, 96, null);
            }
            throw new IllegalStateException(a2.b.a.a.a.z2(jsonReader, a2.b.a.a.a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r10v3, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x009b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.remote.model.WizardParameter b(com.google.gson.stream.JsonReader r14) {
        /*
        // Method dump skipped, instructions count: 298
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.parse.adapter.WizardParametersTypeAdapter.b(com.google.gson.stream.JsonReader):com.avito.android.remote.model.WizardParameter");
    }

    @Override // com.google.gson.TypeAdapter
    @NotNull
    public WizardParameter read(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        return b(jsonReader);
    }

    @NotNull
    public Void write(@NotNull JsonWriter jsonWriter, @NotNull WizardParameter wizardParameter) {
        Intrinsics.checkNotNullParameter(jsonWriter, VKApiConst.OUT);
        Intrinsics.checkNotNullParameter(wizardParameter, "value");
        throw new UnsupportedOperationException();
    }
}
