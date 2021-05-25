package com.yandex.runtime.bindings;
public class LongHandler implements ArchivingHandler<Long> {
    private final boolean isOptional;

    public LongHandler() {
        this(false);
    }

    public LongHandler(boolean z) {
        this.isOptional = z;
    }

    public Long add(Long l, Archive archive) {
        return archive.add(l, this.isOptional);
    }
}
