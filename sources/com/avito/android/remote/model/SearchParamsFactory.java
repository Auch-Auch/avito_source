package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.SplitSearchParam;
import com.avito.android.util.UrlParams;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SearchParamsFactory {
    private static final String COMPANY = "company";
    private static final String FORCE_LOCATION = "forceLocation";
    private static final String OWNER = "owner";
    private static final String OWNER_REGEX = "owner\\[([^]]+)\\]";
    private static final String PRIVATE = "private";
    private static final String RADIUS = "radius";
    private static final String SEARCH_RADIUS = "searchRadius";

    private static void addSearchParam(Map<String, SearchParamElement> map, String str, String str2) {
        Matcher matcher = Pattern.compile(UrlParams.PARAMS_REGEX).matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                map.get(group).add(str, str2);
                return;
            }
            SearchParamElement searchParamElement = new SearchParamElement();
            searchParamElement.add(str, str2);
            map.put(group, searchParamElement);
        }
    }

    private static String decodeString(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            return str;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011d, code lost:
        if (r6.equals(com.avito.android.util.UrlParams.PRICE_MAX) == false) goto L_0x003a;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.avito.android.remote.model.SearchParams fromString(@androidx.annotation.Nullable java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 678
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.SearchParamsFactory.fromString(java.lang.String):com.avito.android.remote.model.SearchParams");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0137, code lost:
        if (r7.equals(com.avito.android.util.UrlParams.PRICE_MIN) == false) goto L_0x006a;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.avito.android.remote.model.SearchParams fromUri(@androidx.annotation.NonNull android.net.Uri r19) {
        /*
        // Method dump skipped, instructions count: 786
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.SearchParamsFactory.fromUri(android.net.Uri):com.avito.android.remote.model.SearchParams");
    }

    @NonNull
    private static String getParamIdFromSplitId(@NonNull String str) {
        if (str.endsWith(SplitSearchParamKt.SPLIT_FROM)) {
            return a.O2(str, -5, 0);
        }
        return str.endsWith(SplitSearchParamKt.SPLIT_TO) ? a.O2(str, -3, 0) : str;
    }

    @NonNull
    private static Map<String, SearchParam<?>> paramsStringMapToSearchParamMap(@NonNull Map<String, SearchParamElement> map) {
        SplitSearchParam.Split split;
        HashMap hashMap = new HashMap(map.size());
        for (String str : map.keySet()) {
            SearchParamElement searchParamElement = map.get(str);
            if (searchParamElement.isMultiselect()) {
                hashMap.put(str, new MultiSelectSearchParam(searchParamElement.getAll()));
            } else {
                String str2 = searchParamElement.get(0);
                if (str.endsWith(SplitSearchParamKt.SPLIT_FROM) || str.endsWith(SplitSearchParamKt.SPLIT_TO)) {
                    String paramIdFromSplitId = getParamIdFromSplitId(str);
                    if (!hashMap.containsKey(paramIdFromSplitId)) {
                        String str3 = null;
                        if (str.endsWith(SplitSearchParamKt.SPLIT_FROM)) {
                            SearchParamElement searchParamElement2 = map.get(paramIdFromSplitId + SplitSearchParamKt.SPLIT_TO);
                            if (searchParamElement2 != null) {
                                str3 = searchParamElement2.get(0);
                            }
                            split = new SplitSearchParam.Split(str2, str3);
                        } else {
                            SearchParamElement searchParamElement3 = map.get(paramIdFromSplitId + SplitSearchParamKt.SPLIT_FROM);
                            if (searchParamElement3 != null) {
                                str3 = searchParamElement3.get(0);
                            }
                            split = new SplitSearchParam.Split(str3, str2);
                        }
                        hashMap.put(paramIdFromSplitId, new SplitSearchParam(split));
                    }
                } else {
                    hashMap.put(str, new StringSearchParam(str2));
                }
            }
        }
        return hashMap;
    }

    @Nullable
    private static Boolean parseBoolean(@Nullable String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("0")) {
            return Boolean.FALSE;
        }
        if (!str.equals("1")) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        return Boolean.TRUE;
    }

    @Nullable
    private static Coordinates parseGeoCoords(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length == 2) {
                try {
                    return new Coordinates(Double.parseDouble(split[0].trim()), Double.parseDouble(split[1].trim()));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    @Nullable
    private static List<String> parseSubLocationIds(String str) {
        String[] split = (!str.startsWith("[") || !str.endsWith("]")) ? new String[]{str} : str.substring(1, str.length() - 1).split(",");
        if (split.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(split.length);
        Collections.addAll(arrayList, split);
        return arrayList;
    }
}
