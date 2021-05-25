package com.yandex.mapkit.logo;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Alignment implements Serializable {
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;

    public Alignment(@NonNull HorizontalAlignment horizontalAlignment2, @NonNull VerticalAlignment verticalAlignment2) {
        if (horizontalAlignment2 == null) {
            throw new IllegalArgumentException("Required field \"horizontalAlignment\" cannot be null");
        } else if (verticalAlignment2 != null) {
            this.horizontalAlignment = horizontalAlignment2;
            this.verticalAlignment = verticalAlignment2;
        } else {
            throw new IllegalArgumentException("Required field \"verticalAlignment\" cannot be null");
        }
    }

    @NonNull
    public HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @NonNull
    public VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.horizontalAlignment = (HorizontalAlignment) archive.add((Archive) this.horizontalAlignment, false, (Class<Archive>) HorizontalAlignment.class);
        this.verticalAlignment = (VerticalAlignment) archive.add((Archive) this.verticalAlignment, false, (Class<Archive>) VerticalAlignment.class);
    }

    public Alignment() {
    }
}
