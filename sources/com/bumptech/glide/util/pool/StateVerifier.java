package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;
public abstract class StateVerifier {

    public static class b extends StateVerifier {
        public volatile boolean a;

        public b() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void a(boolean z) {
            this.a = z;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public StateVerifier() {
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new b();
    }

    public abstract void a(boolean z);

    public abstract void throwIfRecycled();

    public StateVerifier(a aVar) {
    }
}
