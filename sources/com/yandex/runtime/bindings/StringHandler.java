package com.yandex.runtime.bindings;
public class StringHandler implements ArchivingHandler<String> {
    private final boolean isOptional;

    public StringHandler() {
        this(false);
    }

    public StringHandler(boolean z) {
        this.isOptional = z;
    }

    public String add(String str, Archive archive) {
        return archive.add(str, this.isOptional);
    }
}
