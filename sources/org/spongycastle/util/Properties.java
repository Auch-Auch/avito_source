package org.spongycastle.util;

import com.facebook.internal.ServerProtocol;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
public class Properties {
    public static final ThreadLocal a = new ThreadLocal();

    public static class a implements PrivilegedAction {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Map map = (Map) Properties.a.get();
            if (map != null) {
                return map.get(this.a);
            }
            return System.getProperty(this.a);
        }
    }

    public static String a(String str) {
        return (String) AccessController.doPrivileged(new a(str));
    }

    public static BigInteger asBigInteger(String str) {
        String a3 = a(str);
        if (a3 != null) {
            return new BigInteger(a3);
        }
        return null;
    }

    public static Set<String> asKeySet(String str) {
        HashSet hashSet = new HashSet();
        String a3 = a(str);
        if (a3 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(a3, ",");
            while (stringTokenizer.hasMoreElements()) {
                hashSet.add(Strings.toLowerCase(stringTokenizer.nextToken()).trim());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static boolean isOverrideSet(String str) {
        try {
            String a3 = a(str);
            if (a3 != null) {
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(Strings.toLowerCase(a3));
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }

    public static boolean removeThreadOverride(String str) {
        boolean isOverrideSet = isOverrideSet(str);
        ThreadLocal threadLocal = a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            return false;
        }
        map.remove(str);
        if (map.isEmpty()) {
            threadLocal.remove();
        } else {
            threadLocal.set(map);
        }
        return isOverrideSet;
    }

    public static boolean setThreadOverride(String str, boolean z) {
        boolean isOverrideSet = isOverrideSet(str);
        ThreadLocal threadLocal = a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
        }
        map.put(str, z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        threadLocal.set(map);
        return isOverrideSet;
    }
}
