package com.yandex.mapkit.glyphs;

import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class GlyphIdRange implements Serializable {
    private int firstGlyphId;
    private int lastGlyphId;

    public GlyphIdRange(int i, int i2) {
        this.firstGlyphId = i;
        this.lastGlyphId = i2;
    }

    public int getFirstGlyphId() {
        return this.firstGlyphId;
    }

    public int getLastGlyphId() {
        return this.lastGlyphId;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.firstGlyphId = archive.add(this.firstGlyphId);
        this.lastGlyphId = archive.add(this.lastGlyphId);
    }

    public GlyphIdRange() {
    }
}
