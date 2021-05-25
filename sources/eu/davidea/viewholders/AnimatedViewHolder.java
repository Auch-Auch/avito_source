package eu.davidea.viewholders;

import androidx.core.view.ViewPropertyAnimatorListener;
public interface AnimatedViewHolder {
    boolean animateAddImpl(ViewPropertyAnimatorListener viewPropertyAnimatorListener, long j, int i);

    boolean animateRemoveImpl(ViewPropertyAnimatorListener viewPropertyAnimatorListener, long j, int i);

    boolean preAnimateAddImpl();

    boolean preAnimateRemoveImpl();
}
