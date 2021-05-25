package com.avito.android.di;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u000028\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0001j\u001b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u0004`\u00052\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0006j\u0002`\u0007BU\u0012L\u0010\t\u001a'\u0012#\b\u0001\u0012\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0006j\u0002`\u00070\b\"\u001f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0006j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/CompositeComponentDependenciesProvider;", "Ljava/util/LinkedHashMap;", "Ljava/lang/Class;", "Lcom/avito/android/di/ComponentDependencies;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/collections/LinkedHashMap;", "", "Lcom/avito/android/di/ComponentDependenciesProvider;", "", "providers", "<init>", "([Ljava/util/Map;)V", "dagger-scopes_release"}, k = 1, mv = {1, 4, 2})
public final class CompositeComponentDependenciesProvider extends LinkedHashMap<Class<? extends ComponentDependencies>, ComponentDependencies> implements Map<Class<? extends ComponentDependencies>, ComponentDependencies>, KMappedMarker {
    public CompositeComponentDependenciesProvider(@NotNull Map<Class<? extends ComponentDependencies>, ComponentDependencies>... mapArr) {
        Intrinsics.checkNotNullParameter(mapArr, "providers");
        for (Map<Class<? extends ComponentDependencies>, ComponentDependencies> map : mapArr) {
            putAll(map);
        }
    }

    public /* bridge */ boolean containsKey(Class cls) {
        return super.containsKey((Object) cls);
    }

    public /* bridge */ boolean containsValue(ComponentDependencies componentDependencies) {
        return super.containsValue((Object) componentDependencies);
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ Set<Map.Entry<Class<? extends ComponentDependencies>, ComponentDependencies>> entrySet() {
        return getEntries();
    }

    public /* bridge */ ComponentDependencies get(Class cls) {
        return (ComponentDependencies) super.get((Object) cls);
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ ComponentDependencies getOrDefault(Class cls, ComponentDependencies componentDependencies) {
        return (ComponentDependencies) super.getOrDefault((Object) cls, (Class) componentDependencies);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ Set<Class<? extends ComponentDependencies>> keySet() {
        return getKeys();
    }

    public /* bridge */ ComponentDependencies remove(Class cls) {
        return (ComponentDependencies) super.remove((Object) cls);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ Collection<ComponentDependencies> values() {
        return getValues();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Class) {
            return containsKey((Class) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof ComponentDependencies) {
            return containsValue((ComponentDependencies) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ ComponentDependencies get(Object obj) {
        if (obj instanceof Class) {
            return get((Class) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.Map, java.util.HashMap
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj instanceof Class ? getOrDefault((Class) obj, (ComponentDependencies) obj2) : obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final /* bridge */ ComponentDependencies remove(Object obj) {
        if (obj instanceof Class) {
            return remove((Class) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(Class cls, ComponentDependencies componentDependencies) {
        return super.remove((Object) cls, (Object) componentDependencies);
    }

    @Override // java.util.Map, java.util.HashMap
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        boolean z = true;
        if (!(obj != null ? obj instanceof Class : true)) {
            return false;
        }
        if (obj2 != null) {
            z = obj2 instanceof ComponentDependencies;
        }
        if (z) {
            return remove((Class) obj, (ComponentDependencies) obj2);
        }
        return false;
    }
}
