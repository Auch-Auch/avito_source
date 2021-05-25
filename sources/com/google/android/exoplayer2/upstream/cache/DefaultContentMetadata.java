package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public final class DefaultContentMetadata implements ContentMetadata {
    public static final DefaultContentMetadata EMPTY = new DefaultContentMetadata(Collections.emptyMap());
    public int a;
    public final Map<String, byte[]> b;

    public DefaultContentMetadata() {
        this(Collections.emptyMap());
    }

    public static boolean a(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(String str) {
        return this.b.containsKey(str);
    }

    public DefaultContentMetadata copyWithMutationsApplied(ContentMetadataMutations contentMetadataMutations) {
        byte[] bArr;
        HashMap hashMap = new HashMap(this.b);
        List<String> removedValues = contentMetadataMutations.getRemovedValues();
        for (int i = 0; i < removedValues.size(); i++) {
            hashMap.remove(removedValues.get(i));
        }
        for (Map.Entry<String, Object> entry : contentMetadataMutations.getEditedValues().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Long) {
                bArr = ByteBuffer.allocate(8).putLong(((Long) value).longValue()).array();
            } else if (value instanceof String) {
                bArr = ((String) value).getBytes(Charsets.UTF_8);
            } else if (value instanceof byte[]) {
                bArr = (byte[]) value;
            } else {
                throw new IllegalArgumentException();
            }
            hashMap.put(key, bArr);
        }
        if (a(this.b, hashMap)) {
            return this;
        }
        return new DefaultContentMetadata(hashMap);
    }

    public Set<Map.Entry<String, byte[]>> entrySet() {
        return this.b.entrySet();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DefaultContentMetadata.class != obj.getClass()) {
            return false;
        }
        return a(this.b, ((DefaultContentMetadata) obj).b);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @Nullable
    public final byte[] get(String str, @Nullable byte[] bArr) {
        byte[] bArr2 = this.b.get(str);
        return bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : bArr;
    }

    public int hashCode() {
        if (this.a == 0) {
            int i = 0;
            for (Map.Entry<String, byte[]> entry : this.b.entrySet()) {
                i += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.a = i;
        }
        return this.a;
    }

    public DefaultContentMetadata(Map<String, byte[]> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    @Nullable
    public final String get(String str, @Nullable String str2) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? new String(bArr, Charsets.UTF_8) : str2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final long get(String str, long j) {
        byte[] bArr = this.b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j;
    }
}
