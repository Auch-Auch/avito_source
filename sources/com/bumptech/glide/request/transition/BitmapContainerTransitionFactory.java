package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    public final TransitionFactory<Drawable> a;

    public final class a implements Transition<R> {
        public final Transition<Drawable> a;

        public a(Transition<Drawable> transition) {
            this.a = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
            return this.a.transition(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.a = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        return new a(this.a.build(dataSource, z));
    }

    public abstract Bitmap getBitmap(R r);
}
