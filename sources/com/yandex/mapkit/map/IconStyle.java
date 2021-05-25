package com.yandex.mapkit.map;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public final class IconStyle implements Serializable {
    private PointF anchor;
    private Boolean flat;
    private RotationType rotationType;
    private Float scale;
    private Rect tappableArea;
    private Boolean visible;
    private Float zIndex;

    public IconStyle(@Nullable PointF pointF, @Nullable RotationType rotationType2, @Nullable Float f, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Float f2, @Nullable Rect rect) {
        this.anchor = pointF;
        this.rotationType = rotationType2;
        this.zIndex = f;
        this.flat = bool;
        this.visible = bool2;
        this.scale = f2;
        this.tappableArea = rect;
    }

    @Nullable
    public PointF getAnchor() {
        return this.anchor;
    }

    @Nullable
    public Boolean getFlat() {
        return this.flat;
    }

    @Nullable
    public RotationType getRotationType() {
        return this.rotationType;
    }

    @Nullable
    public Float getScale() {
        return this.scale;
    }

    @Nullable
    public Rect getTappableArea() {
        return this.tappableArea;
    }

    @Nullable
    public Boolean getVisible() {
        return this.visible;
    }

    @Nullable
    public Float getZIndex() {
        return this.zIndex;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.anchor = archive.add(this.anchor, true);
        this.rotationType = (RotationType) archive.add((Archive) this.rotationType, true, (Class<Archive>) RotationType.class);
        this.zIndex = archive.add(this.zIndex, true);
        this.flat = archive.add(this.flat, true);
        this.visible = archive.add(this.visible, true);
        this.scale = archive.add(this.scale, true);
        this.tappableArea = (Rect) archive.add((Archive) this.tappableArea, true, (Class<Archive>) Rect.class);
    }

    public IconStyle setAnchor(@Nullable PointF pointF) {
        this.anchor = pointF;
        return this;
    }

    public IconStyle setFlat(@Nullable Boolean bool) {
        this.flat = bool;
        return this;
    }

    public IconStyle setRotationType(@Nullable RotationType rotationType2) {
        this.rotationType = rotationType2;
        return this;
    }

    public IconStyle setScale(@Nullable Float f) {
        this.scale = f;
        return this;
    }

    public IconStyle setTappableArea(@Nullable Rect rect) {
        this.tappableArea = rect;
        return this;
    }

    public IconStyle setVisible(@Nullable Boolean bool) {
        this.visible = bool;
        return this;
    }

    public IconStyle setZIndex(@Nullable Float f) {
        this.zIndex = f;
        return this;
    }

    public IconStyle() {
    }
}
