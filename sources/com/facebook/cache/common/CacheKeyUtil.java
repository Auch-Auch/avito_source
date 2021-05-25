package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public final class CacheKeyUtil {
    public static String a(CacheKey cacheKey) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes("UTF-8"));
    }

    public static String getFirstResourceId(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return a(((MultiCacheKey) cacheKey).getCacheKeys().get(0));
            }
            return a(cacheKey);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        ArrayList arrayList;
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                arrayList = new ArrayList(cacheKeys.size());
                for (int i = 0; i < cacheKeys.size(); i++) {
                    arrayList.add(a(cacheKeys.get(i)));
                }
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(cacheKey.isResourceIdForDebugging() ? cacheKey.getUriString() : a(cacheKey));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
