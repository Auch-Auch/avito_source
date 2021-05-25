package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    public final ViewPropertyTransition.Animator a;
    public ViewPropertyTransition<R> b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.a = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.b == null) {
            this.b = new ViewPropertyTransition<>(this.a);
        }
        return this.b;
    }
}
