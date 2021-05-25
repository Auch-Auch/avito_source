package com.yandex.runtime.bindings;

import com.yandex.runtime.bindings.Serializable;
public class ClassHandler<T extends Serializable> implements ArchivingHandler<T> {
    private final boolean isOptional;
    private Class<T> itemClass;

    public ClassHandler(Class<T> cls) {
        this(false, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.runtime.bindings.ClassHandler<T extends com.yandex.runtime.bindings.Serializable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.runtime.bindings.ArchivingHandler
    public /* bridge */ /* synthetic */ Object add(Object obj, Archive archive) {
        return add((ClassHandler<T>) ((Serializable) obj), archive);
    }

    public ClassHandler(boolean z, Class<T> cls) {
        this.isOptional = z;
        this.itemClass = cls;
    }

    public T add(T t, Archive archive) {
        return (T) archive.add((Archive) t, this.isOptional, (Class<Archive>) this.itemClass);
    }
}
