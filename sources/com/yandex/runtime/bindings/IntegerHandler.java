package com.yandex.runtime.bindings;
public class IntegerHandler implements ArchivingHandler<Integer> {
    private final boolean isOptional;

    public IntegerHandler() {
        this(false);
    }

    public IntegerHandler(boolean z) {
        this.isOptional = z;
    }

    public Integer add(Integer num, Archive archive) {
        return archive.add(num, this.isOptional);
    }
}
