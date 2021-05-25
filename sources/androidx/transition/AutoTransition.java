package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        o();
    }

    public final void o() {
        setOrdering(1);
        addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o();
    }
}
