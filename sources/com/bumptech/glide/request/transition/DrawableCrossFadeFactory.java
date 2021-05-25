package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    public final int a;
    public final boolean b;
    public DrawableCrossFadeTransition c;

    public static class Builder {
        public final int a;
        public boolean b;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.a, this.b);
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.b = z;
            return this;
        }

        public Builder(int i) {
            this.a = i;
        }
    }

    public DrawableCrossFadeFactory(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.get();
        }
        if (this.c == null) {
            this.c = new DrawableCrossFadeTransition(this.a, this.b);
        }
        return this.c;
    }
}
