package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;
public class HorizontalChainReference extends ChainReference {
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.solver.state.HelperReference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mState.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = this.mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = this.c;
                if (obj != null) {
                    constraints.startToStart(obj);
                } else {
                    Object obj2 = this.d;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2);
                    } else {
                        constraints.startToStart(State.PARENT);
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = this.e;
            if (obj3 != null) {
                constraintReference.endToStart(obj3);
            } else {
                Object obj4 = this.f;
                if (obj4 != null) {
                    constraintReference.endToEnd(obj4);
                } else {
                    constraintReference.endToEnd(State.PARENT);
                }
            }
        }
        if (constraintReference2 != null) {
            float f2 = this.mBias;
            if (f2 != 0.5f) {
                constraintReference2.horizontalBias(f2);
            }
        }
        int ordinal = this.mStyle.ordinal();
        if (ordinal == 0) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (ordinal == 1) {
            constraintReference2.setHorizontalChainStyle(1);
        } else if (ordinal == 2) {
            constraintReference2.setHorizontalChainStyle(2);
        }
    }

    public void endToEnd(Object obj) {
        this.f = obj;
    }

    public void endToStart(Object obj) {
        this.e = obj;
    }

    public void startToEnd(Object obj) {
        this.d = obj;
    }

    public void startToStart(Object obj) {
        this.c = obj;
    }
}
