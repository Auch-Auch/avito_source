package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    public final ViewTransition.a a;
    public Transition<R> b;

    public static class a implements ViewTransition.a {
        public final Animation a;

        public a(Animation animation) {
            this.a = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return this.a;
        }
    }

    public static class b implements ViewTransition.a {
        public final int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.a);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this.a = new a(animation);
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.b == null) {
            this.b = new ViewTransition(this.a);
        }
        return this.b;
    }

    public ViewAnimationFactory(int i) {
        this.a = new b(i);
    }
}
