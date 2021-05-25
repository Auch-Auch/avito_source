package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;
public class VerticalChainReference extends ChainReference {
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = this.c;
                if (obj != null) {
                    constraints.topToTop(obj);
                } else {
                    Object obj2 = this.d;
                    if (obj2 != null) {
                        constraints.topToBottom(obj2);
                    } else {
                        constraints.topToTop(State.PARENT);
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.e;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3);
            } else {
                Object obj4 = this.f;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4);
                } else {
                    constraintReference.bottomToBottom(State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f2 = this.mBias;
            if (f2 != 0.5f) {
                constraintReference2.verticalBias(f2);
            }
        }
        int ordinal = this.mStyle.ordinal();
        if (ordinal == 0) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (ordinal == 1) {
            constraintReference2.setVerticalChainStyle(1);
        } else if (ordinal == 2) {
            constraintReference2.setVerticalChainStyle(2);
        }
    }

    public void bottomToBottom(Object obj) {
        this.f = obj;
    }

    public void bottomToTop(Object obj) {
        this.e = obj;
    }

    public void topToBottom(Object obj) {
        this.d = obj;
    }

    public void topToTop(Object obj) {
        this.c = obj;
    }
}
