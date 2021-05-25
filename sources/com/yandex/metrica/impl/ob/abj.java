package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONException;
public class abj extends HashMap<String, String> {
    private int a = 0;

    public abj() {
    }

    @Nullable
    /* renamed from: a */
    public String put(@NonNull String str, @Nullable String str2) {
        if (containsKey(str)) {
            if (str2 == null) {
                return remove(str);
            }
            String str3 = (String) get(str);
            this.a = (str2.length() - (str3 == null ? 0 : str3.length())) + this.a;
            return (String) super.put(str, str2);
        } else if (str2 == null) {
            return null;
        } else {
            this.a = str2.length() + str.length() + this.a;
            return (String) super.put(str, str2);
        }
    }

    public abj(@NonNull String str) throws JSONException {
        super(abc.b(str));
        for (String str2 : keySet()) {
            String str3 = (String) get(str2);
            this.a = str2.length() + (str3 == null ? 0 : str3.length()) + this.a;
        }
    }

    @Nullable
    /* renamed from: a */
    public String remove(@NonNull Object obj) {
        int i;
        if (containsKey(obj)) {
            String str = (String) get(obj);
            int i2 = this.a;
            int length = ((String) obj).length();
            if (str == null) {
                i = 0;
            } else {
                i = str.length();
            }
            this.a = i2 - (length + i);
        }
        return (String) super.remove(obj);
    }

    public int a() {
        return this.a;
    }
}
