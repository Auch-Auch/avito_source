package com.avito.android.util;

import android.os.Bundle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.n.r;
import t6.n.y;
import t6.v.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J/\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\rJ3\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010#\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!H\u0002¢\u0006\u0004\b#\u0010$R\u001d\u0010)\u001a\u00020%8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u001d\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/util/RequestUtils;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "key", "value", "", "appendEncodedParam", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/Object;)V", Types.STRING, "md5", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "params", "getUrlEncodedParams", "(Landroid/os/Bundle;)Ljava/lang/String;", "stringToEncode", "encodeString", "", "receiver", "", "toArrayQueryParams", "(Ljava/util/Set;Ljava/lang/String;)Ljava/util/Map;", "any", "name", "toMapQueryParams", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/util/Map;", AuthSource.SEND_ABUSE, "(Ljava/lang/StringBuilder;)V", "Lcom/google/gson/JsonElement;", "jsonObject", "", "result", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Lcom/google/gson/JsonElement;Ljava/util/Map;)V", "Lcom/google/gson/Gson;", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class RequestUtils {
    @NotNull
    public static final RequestUtils INSTANCE = new RequestUtils();
    public static final Lazy a = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<Gson> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Gson invoke() {
            return new Gson();
        }
    }

    @JvmStatic
    public static final void appendEncodedParam(@NotNull StringBuilder sb, @Nullable String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(sb, "builder");
        if (obj == null) {
            RequestUtils requestUtils = INSTANCE;
            requestUtils.a(sb);
            sb.append(requestUtils.encodeString(str));
            sb.append("=");
            Intrinsics.checkNotNullExpressionValue(sb, "builder.append(encodeString(key)).append(\"=\")");
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                appendEncodedParam(sb, a2.b.a.a.a.H(new Object[]{str, Integer.valueOf(i)}, 2, UrlParams.ARRAY_TEMPLATE, "java.lang.String.format(format, *args)"), Array.get(obj, i));
            }
        } else if (obj instanceof Boolean) {
            RequestUtils requestUtils2 = INSTANCE;
            requestUtils2.a(sb);
            sb.append(requestUtils2.encodeString(str));
            sb.append("=");
            sb.append(requestUtils2.encodeString(((Boolean) obj).booleanValue() ? "1" : "0"));
        } else {
            RequestUtils requestUtils3 = INSTANCE;
            requestUtils3.a(sb);
            sb.append(requestUtils3.encodeString(str));
            sb.append("=");
            sb.append(requestUtils3.encodeString(obj.toString()));
        }
    }

    public final void a(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append("&");
        }
    }

    public final void b(String str, JsonElement jsonElement, Map<String, String> map) {
        JsonArray asJsonArray;
        JsonObject asJsonObject;
        Set<Map.Entry<String, JsonElement>> entrySet;
        String asString;
        if (jsonElement.isJsonPrimitive()) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (!(asJsonPrimitive == null || (asString = asJsonPrimitive.getAsString()) == null)) {
                map.put(str, asString);
                return;
            }
            return;
        }
        if (!(!jsonElement.isJsonObject() || (asJsonObject = jsonElement.getAsJsonObject()) == null || (entrySet = asJsonObject.entrySet()) == null)) {
            for (T t : entrySet) {
                String format = String.format(Locale.getDefault(), UrlParams.ARRAY_TEMPLATE, Arrays.copyOf(new Object[]{str, t.getKey()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                RequestUtils requestUtils = INSTANCE;
                Object value = t.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                requestUtils.b(format, (JsonElement) value, map);
            }
        }
        if (jsonElement.isJsonArray() && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
            Iterator it = e.until(0, asJsonArray.size()).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String format2 = String.format(Locale.getDefault(), UrlParams.ARRAY_TEMPLATE, Arrays.copyOf(new Object[]{str, String.valueOf(nextInt)}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                RequestUtils requestUtils2 = INSTANCE;
                JsonElement jsonElement2 = asJsonArray.get(nextInt);
                Intrinsics.checkNotNullExpressionValue(jsonElement2, "array[index]");
                requestUtils2.b(format2, jsonElement2, map);
            }
        }
    }

    @Nullable
    public final String encodeString(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        String str2 = null;
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            try {
                Intrinsics.checkNotNullExpressionValue(encode, "result");
                return StringsKt__StringsKt.contains$default(encode, "*", false, 2, null) ? m.replace$default(encode, "*", "%2A", false, 4, (Object) null) : encode;
            } catch (UnsupportedEncodingException unused) {
                str2 = encode;
                return str2;
            }
        } catch (UnsupportedEncodingException unused2) {
            return str2;
        }
    }

    @NotNull
    public final String getUrlEncodedParams(@Nullable Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bundle.size() * 8);
        for (String str : new TreeSet(bundle.keySet())) {
            appendEncodedParam(sb, str, bundle.get(str));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    @Deprecated(message = "use {@link Strings#md5(String)}")
    @NotNull
    public final String md5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        try {
            return Strings.md5(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public final Map<String, String> toArrayQueryParams(@Nullable Set<String> set, @Nullable String str) {
        HashMap hashMap = new HashMap();
        if (set == null) {
            set = y.emptySet();
        }
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            hashMap.put(format, arrayList.get(i));
        }
        return hashMap;
    }

    @NotNull
    public final Map<String, String> toMapQueryParams(@NotNull Object obj, @NotNull String str) {
        Intrinsics.checkNotNullParameter(obj, "any");
        Intrinsics.checkNotNullParameter(str, "name");
        JsonElement jsonTree = ((Gson) a.getValue()).toJsonTree(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Intrinsics.checkNotNullExpressionValue(jsonTree, "jsonTree");
        b(str, jsonTree, linkedHashMap);
        return r.toMap(linkedHashMap);
    }
}
