package com.yandex.mapkit;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Animation implements Serializable {
    private float duration;
    private Type type;

    public enum Type {
        SMOOTH,
        LINEAR
    }

    public Animation(@NonNull Type type2, float f) {
        if (type2 != null) {
            this.type = type2;
            this.duration = f;
            return;
        }
        throw new IllegalArgumentException("Required field \"type\" cannot be null");
    }

    public float getDuration() {
        return this.duration;
    }

    @NonNull
    public Type getType() {
        return this.type;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.type = (Type) archive.add((Archive) this.type, false, (Class<Archive>) Type.class);
        this.duration = archive.add(this.duration);
    }

    public Animation() {
    }
}
