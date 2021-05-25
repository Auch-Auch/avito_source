package com.yandex.mapkit.map;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public final class ModelStyle implements Serializable {
    private float size;

    public ModelStyle(float f) {
        this.size = f;
    }

    public float getSize() {
        return this.size;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.size = archive.add(this.size);
    }

    public ModelStyle setSize(float f) {
        this.size = f;
        return this;
    }

    public ModelStyle() {
    }
}
