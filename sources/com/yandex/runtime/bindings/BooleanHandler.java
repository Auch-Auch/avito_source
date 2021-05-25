package com.yandex.runtime.bindings;
public class BooleanHandler implements ArchivingHandler<Boolean> {
    private final boolean isOptional;

    public BooleanHandler() {
        this(false);
    }

    public BooleanHandler(boolean z) {
        this.isOptional = z;
    }

    public Boolean add(Boolean bool, Archive archive) {
        return archive.add(bool, this.isOptional);
    }
}
