package com.bumptech.glide.load.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class LazyHeaders implements Headers {
    public final Map<String, List<LazyHeaderFactory>> a;
    public volatile Map<String, String> b;

    public static final class Builder {
        public static final String d;
        public static final Map<String, List<LazyHeaderFactory>> e;
        public boolean a = true;
        public Map<String, List<LazyHeaderFactory>> b = e;
        public boolean c = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            d = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", Collections.singletonList(new a(property)));
            }
            e = Collections.unmodifiableMap(hashMap);
        }

        public final void a() {
            if (this.a) {
                this.a = false;
                HashMap hashMap = new HashMap(this.b.size());
                for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.b.entrySet()) {
                    hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
                }
                this.b = hashMap;
            }
        }

        public Builder addHeader(@NonNull String str, @NonNull String str2) {
            return addHeader(str, new a(str2));
        }

        public LazyHeaders build() {
            this.a = true;
            return new LazyHeaders(this.b);
        }

        public Builder setHeader(@NonNull String str, @Nullable String str2) {
            return setHeader(str, str2 == null ? null : new a(str2));
        }

        public Builder addHeader(@NonNull String str, @NonNull LazyHeaderFactory lazyHeaderFactory) {
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                return setHeader(str, lazyHeaderFactory);
            }
            a();
            List<LazyHeaderFactory> list = this.b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.b.put(str, list);
            }
            list.add(lazyHeaderFactory);
            return this;
        }

        public Builder setHeader(@NonNull String str, @Nullable LazyHeaderFactory lazyHeaderFactory) {
            a();
            if (lazyHeaderFactory == null) {
                this.b.remove(str);
            } else {
                List<LazyHeaderFactory> list = this.b.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.b.put(str, list);
                }
                list.clear();
                list.add(lazyHeaderFactory);
            }
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                this.c = false;
            }
            return this;
        }
    }

    public static final class a implements LazyHeaderFactory {
        @NonNull
        public final String a;

        public a(@NonNull String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public String buildHeader() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.a.equals(((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("StringHeaderFactory{value='");
            L.append(this.a);
            L.append('\'');
            L.append('}');
            return L.toString();
        }
    }

    public LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.a = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.a.entrySet()) {
            List<LazyHeaderFactory> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                String buildHeader = value.get(i).buildHeader();
                if (!TextUtils.isEmpty(buildHeader)) {
                    sb.append(buildHeader);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.a.equals(((LazyHeaders) obj).a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.Headers
    public Map<String, String> getHeaders() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.unmodifiableMap(a());
                }
            }
        }
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("LazyHeaders{headers=");
        L.append(this.a);
        L.append('}');
        return L.toString();
    }
}
