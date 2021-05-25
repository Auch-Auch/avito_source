package com.yandex.runtime.bindings;

import java.lang.Enum;
public class EnumHandler<T extends Enum<T>> implements ArchivingHandler<T> {
    private Class<T> enumClass;
    private final boolean isOptional;

    public EnumHandler(Class<T> cls) {
        this(false, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.runtime.bindings.EnumHandler<T extends java.lang.Enum<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.runtime.bindings.ArchivingHandler
    public /* bridge */ /* synthetic */ Object add(Object obj, Archive archive) {
        return add((EnumHandler<T>) ((Enum) obj), archive);
    }

    public EnumHandler(boolean z, Class<T> cls) {
        this.isOptional = z;
        this.enumClass = cls;
    }

    public T add(T t, Archive archive) {
        return (T) archive.add((Archive) t, this.isOptional, (Class<Archive>) this.enumClass);
    }
}
