package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;
public class HelperReference {
    public final State.Helper a;
    public HelperWidget b;
    public ArrayList<Object> mReferences = new ArrayList<>();
    public final State mState;

    public HelperReference(State state, State.Helper helper) {
        this.mState = state;
        this.a = helper;
    }

    public HelperReference add(Object... objArr) {
        for (Object obj : objArr) {
            this.mReferences.add(obj);
        }
        return this;
    }

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.b;
    }

    public State.Helper getType() {
        return this.a;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.b = helperWidget;
    }
}
