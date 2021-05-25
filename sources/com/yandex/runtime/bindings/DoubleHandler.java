package com.yandex.runtime.bindings;
public class DoubleHandler implements ArchivingHandler<Double> {
    private final boolean isOptional;

    public DoubleHandler() {
        this(false);
    }

    public DoubleHandler(boolean z) {
        this.isOptional = z;
    }

    public Double add(Double d, Archive archive) {
        return archive.add(d, this.isOptional);
    }
}
