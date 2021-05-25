package com.sumsub.sns.core.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/common/Alphabet;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "key", "get", "(C)Ljava/lang/Integer;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Alphabet extends HashMap<Character, Integer> {
    public /* bridge */ boolean containsKey(Character ch) {
        return super.containsKey((Object) ch);
    }

    public /* bridge */ boolean containsValue(Integer num) {
        return super.containsValue((Object) num);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<Character, Integer>> entrySet() {
        return getEntries();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof Character) {
            return get(((Character) obj).charValue());
        }
        return null;
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ Integer getOrDefault(Character ch, Integer num) {
        return (Integer) super.getOrDefault((Object) ch, (Character) num);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Character> keySet() {
        return getKeys();
    }

    public /* bridge */ Integer remove(Character ch) {
        return (Integer) super.remove((Object) ch);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Integer> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Character) {
            return containsKey((Character) obj);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Integer) {
            return containsValue((Integer) obj);
        }
        return false;
    }

    @NotNull
    public Integer get(char c) {
        Integer num = (Integer) super.get(Character.valueOf(c));
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj instanceof Character : true ? getOrDefault((Character) obj, (Integer) obj2) : obj2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof Character) {
            return remove((Character) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(Character ch, Integer num) {
        return super.remove((Object) ch, (Object) num);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        boolean z = true;
        if (!(obj != null ? obj instanceof Character : true)) {
            return false;
        }
        if (obj2 != null) {
            z = obj2 instanceof Integer;
        }
        if (z) {
            return remove((Character) obj, (Integer) obj2);
        }
        return false;
    }
}
