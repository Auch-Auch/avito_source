package com.yandex.runtime.bindings;
public class FloatHandler implements ArchivingHandler<Float> {
    private final boolean isOptional;

    public FloatHandler() {
        this(false);
    }

    public FloatHandler(boolean z) {
        this.isOptional = z;
    }

    public Float add(Float f, Archive archive) {
        return archive.add(f, this.isOptional);
    }
}
