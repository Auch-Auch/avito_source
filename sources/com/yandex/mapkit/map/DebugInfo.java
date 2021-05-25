package com.yandex.mapkit.map;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class DebugInfo implements Serializable {
    private long memUsage;

    public DebugInfo(long j) {
        this.memUsage = j;
    }

    public long getMemUsage() {
        return this.memUsage;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.memUsage = archive.add(this.memUsage);
    }

    public DebugInfo() {
    }
}
