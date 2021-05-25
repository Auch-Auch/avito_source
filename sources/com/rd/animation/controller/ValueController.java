package com.rd.animation.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.data.Value;
import com.rd.animation.type.ColorAnimation;
import com.rd.animation.type.DropAnimation;
import com.rd.animation.type.FillAnimation;
import com.rd.animation.type.ScaleAnimation;
import com.rd.animation.type.ScaleDownAnimation;
import com.rd.animation.type.SlideAnimation;
import com.rd.animation.type.SwapAnimation;
import com.rd.animation.type.ThinWormAnimation;
import com.rd.animation.type.WormAnimation;
public class ValueController {
    public ColorAnimation a;
    public ScaleAnimation b;
    public WormAnimation c;
    public SlideAnimation d;
    public FillAnimation e;
    public ThinWormAnimation f;
    public DropAnimation g;
    public SwapAnimation h;
    public ScaleDownAnimation i;
    public UpdateListener j;

    public interface UpdateListener {
        void onValueUpdated(@Nullable Value value);
    }

    public ValueController(@Nullable UpdateListener updateListener) {
        this.j = updateListener;
    }

    @NonNull
    public ColorAnimation color() {
        if (this.a == null) {
            this.a = new ColorAnimation(this.j);
        }
        return this.a;
    }

    @NonNull
    public DropAnimation drop() {
        if (this.g == null) {
            this.g = new DropAnimation(this.j);
        }
        return this.g;
    }

    @NonNull
    public FillAnimation fill() {
        if (this.e == null) {
            this.e = new FillAnimation(this.j);
        }
        return this.e;
    }

    @NonNull
    public ScaleAnimation scale() {
        if (this.b == null) {
            this.b = new ScaleAnimation(this.j);
        }
        return this.b;
    }

    @NonNull
    public ScaleDownAnimation scaleDown() {
        if (this.i == null) {
            this.i = new ScaleDownAnimation(this.j);
        }
        return this.i;
    }

    @NonNull
    public SlideAnimation slide() {
        if (this.d == null) {
            this.d = new SlideAnimation(this.j);
        }
        return this.d;
    }

    @NonNull
    public SwapAnimation swap() {
        if (this.h == null) {
            this.h = new SwapAnimation(this.j);
        }
        return this.h;
    }

    @NonNull
    public ThinWormAnimation thinWorm() {
        if (this.f == null) {
            this.f = new ThinWormAnimation(this.j);
        }
        return this.f;
    }

    @NonNull
    public WormAnimation worm() {
        if (this.c == null) {
            this.c = new WormAnimation(this.j);
        }
        return this.c;
    }
}
