package com.sumsub.sns.core.data.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\u001a'\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\r\u001a\u0019\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\r\u001a\u0019\u0010\u0011\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\r\"%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\"%\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013\"%\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013\"%\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/data/model/AppConfig;", "Lcom/google/gson/Gson;", "gson", "", "", "", "documentsByCountries", "(Lcom/sumsub/sns/core/data/model/AppConfig;Lcom/google/gson/Gson;)Ljava/util/Map;", "documentType", "", "shouldSkipSelector", "(Lcom/sumsub/sns/core/data/model/AppConfig;Lcom/google/gson/Gson;Ljava/lang/String;)Z", "disableStepsScreen", "(Lcom/sumsub/sns/core/data/model/AppConfig;Lcom/google/gson/Gson;)Z", "disablePendingScreen", "disableFinalStateStatusScreen", "disableTemporarilyDeclinedStatusScreen", "livenessSaveMode", "getGenders", "(Lcom/sumsub/sns/core/data/model/AppConfig;)Ljava/util/Map;", "genders", "getErrors", "errors", "getErrorCodes", "errorCodes", "getCountries", "countries", "getWarnings", "warnings", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class AppConfigKt {
    public static final boolean disableFinalStateStatusScreen(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$disableFinalStateStatusScreen");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$disableFinalStateStatusScreen$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = d.listOf("disableFinalStateStatusScreen");
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof Boolean) {
                        obj = obj3;
                    }
                    obj = (Boolean) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    public static final boolean disablePendingScreen(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$disablePendingScreen");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$disablePendingScreen$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = d.listOf("disablePendingScreen");
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof Boolean) {
                        obj = obj3;
                    }
                    obj = (Boolean) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    public static final boolean disableStepsScreen(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$disableStepsScreen");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$disableStepsScreen$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = d.listOf("disableStepsScreen");
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof Boolean) {
                        obj = obj3;
                    }
                    obj = (Boolean) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    public static final boolean disableTemporarilyDeclinedStatusScreen(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$disableTemporarilyDeclinedStatusScreen");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$disableTemporarilyDeclinedStatusScreen$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = d.listOf("disableTemporarilyDeclinedStatusScreen");
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof Boolean) {
                        obj = obj3;
                    }
                    obj = (Boolean) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    @Nullable
    public static final Map<String, Object> documentsByCountries(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$documentsByCountries");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return (Map) gson.fromJson(appConfig.getDocumentsByCountriesMap(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$documentsByCountries$1
        }.getType());
    }

    @Nullable
    public static final Map<String, String> getCountries(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$countries");
        Map<String, Map<String, String>> sdkDict = appConfig.getSdkDict();
        if (sdkDict != null) {
            return sdkDict.get("countries");
        }
        return null;
    }

    @Nullable
    public static final Map<String, String> getErrorCodes(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$errorCodes");
        Map<String, Map<String, String>> sdkDict = appConfig.getSdkDict();
        if (sdkDict != null) {
            return sdkDict.get("errorCodes");
        }
        return null;
    }

    @Nullable
    public static final Map<String, String> getErrors(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$errors");
        Map<String, Map<String, String>> sdkDict = appConfig.getSdkDict();
        if (sdkDict != null) {
            return sdkDict.get("idDocErrors");
        }
        return null;
    }

    @Nullable
    public static final Map<String, String> getGenders(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$genders");
        Map<String, Map<String, String>> sdkDict = appConfig.getSdkDict();
        if (sdkDict != null) {
            return sdkDict.get("genders");
        }
        return null;
    }

    @Nullable
    public static final Map<String, String> getWarnings(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$warnings");
        Map<String, Map<String, String>> sdkDict = appConfig.getSdkDict();
        if (sdkDict != null) {
            return sdkDict.get("idDocWarnings");
        }
        return null;
    }

    public static final boolean livenessSaveMode(@NotNull AppConfig appConfig, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$livenessSaveMode");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$livenessSaveMode$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = d.listOf("livenessSaveMode");
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof Boolean) {
                        obj = obj3;
                    }
                    obj = (Boolean) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, Boolean.TRUE);
    }

    public static final boolean shouldSkipSelector(@NotNull AppConfig appConfig, @NotNull Gson gson, @NotNull String str) {
        Intrinsics.checkNotNullParameter(appConfig, "$this$shouldSkipSelector");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(str, "documentType");
        Map map = (Map) gson.fromJson(appConfig.getUiConf(), new TypeToken<Map<String, ? extends Object>>() { // from class: com.sumsub.sns.core.data.model.AppConfigKt$shouldSkipSelector$documentSelectorMode$1
        }.getType());
        Object obj = null;
        if (map != null) {
            List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"steps", str, "documentSelectorMode"});
            Iterator it = e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj2 = map.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj3 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (obj3 instanceof String) {
                        obj = obj3;
                    }
                    obj = (String) obj;
                }
            }
        }
        return Intrinsics.areEqual(obj, "disabled");
    }
}
