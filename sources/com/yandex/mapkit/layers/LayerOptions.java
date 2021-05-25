package com.yandex.mapkit.layers;

import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public final class LayerOptions implements Serializable {
    private boolean active = true;
    private boolean animateOnActivation = false;
    private boolean cacheable = false;
    private boolean nightModeAvailable = true;
    private OverzoomMode overzoomMode = OverzoomMode.DISABLED;
    private long tileAppearingAnimationDuration = 400;
    private boolean transparent = false;

    public LayerOptions(boolean z, boolean z2, boolean z3, boolean z4, long j, @NonNull OverzoomMode overzoomMode2, boolean z5) {
        if (overzoomMode2 != null) {
            this.active = z;
            this.nightModeAvailable = z2;
            this.cacheable = z3;
            this.animateOnActivation = z4;
            this.tileAppearingAnimationDuration = j;
            this.overzoomMode = overzoomMode2;
            this.transparent = z5;
            return;
        }
        throw new IllegalArgumentException("Required field \"overzoomMode\" cannot be null");
    }

    public boolean getActive() {
        return this.active;
    }

    public boolean getAnimateOnActivation() {
        return this.animateOnActivation;
    }

    public boolean getCacheable() {
        return this.cacheable;
    }

    public boolean getNightModeAvailable() {
        return this.nightModeAvailable;
    }

    @NonNull
    public OverzoomMode getOverzoomMode() {
        return this.overzoomMode;
    }

    public long getTileAppearingAnimationDuration() {
        return this.tileAppearingAnimationDuration;
    }

    public boolean getTransparent() {
        return this.transparent;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.active = archive.add(this.active);
        this.nightModeAvailable = archive.add(this.nightModeAvailable);
        this.cacheable = archive.add(this.cacheable);
        this.animateOnActivation = archive.add(this.animateOnActivation);
        this.tileAppearingAnimationDuration = archive.add(this.tileAppearingAnimationDuration);
        this.overzoomMode = (OverzoomMode) archive.add((Archive) this.overzoomMode, false, (Class<Archive>) OverzoomMode.class);
        this.transparent = archive.add(this.transparent);
    }

    public LayerOptions setActive(boolean z) {
        this.active = z;
        return this;
    }

    public LayerOptions setAnimateOnActivation(boolean z) {
        this.animateOnActivation = z;
        return this;
    }

    public LayerOptions setCacheable(boolean z) {
        this.cacheable = z;
        return this;
    }

    public LayerOptions setNightModeAvailable(boolean z) {
        this.nightModeAvailable = z;
        return this;
    }

    public LayerOptions setOverzoomMode(@NonNull OverzoomMode overzoomMode2) {
        if (overzoomMode2 != null) {
            this.overzoomMode = overzoomMode2;
            return this;
        }
        throw new IllegalArgumentException("Required field \"overzoomMode\" cannot be null");
    }

    public LayerOptions setTileAppearingAnimationDuration(long j) {
        this.tileAppearingAnimationDuration = j;
        return this;
    }

    public LayerOptions setTransparent(boolean z) {
        this.transparent = z;
        return this;
    }

    public LayerOptions() {
    }
}
