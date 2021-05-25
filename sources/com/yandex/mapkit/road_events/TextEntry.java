package com.yandex.mapkit.road_events;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class TextEntry implements Serializable {
    private String text;

    public TextEntry(@NonNull String str) {
        if (str != null) {
            this.text = str;
            return;
        }
        throw new IllegalArgumentException("Required field \"text\" cannot be null");
    }

    @NonNull
    public String getText() {
        return this.text;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.text = archive.add(this.text, false);
    }

    public TextEntry() {
    }
}
