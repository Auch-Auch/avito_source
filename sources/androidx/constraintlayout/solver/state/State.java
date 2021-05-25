package androidx.constraintlayout.solver.state;

import a2.b.a.a.a;
import androidx.constraintlayout.solver.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.solver.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.state.helpers.GuidelineReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;
import java.util.Iterator;
public class State {
    public static final Integer PARENT = 0;
    public int a;
    public HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();
    public final ConstraintReference mParent;
    public HashMap<Object, Reference> mReferences = new HashMap<>();

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.a = 0;
        this.mReferences.put(PARENT, constraintReference);
    }

    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (Object obj : this.mHelperReferences.keySet()) {
            HelperWidget helperWidget = this.mHelperReferences.get(obj).getHelperWidget();
            if (helperWidget != null) {
                Reference reference = this.mReferences.get(obj);
                if (reference == null) {
                    reference = constraints(obj);
                }
                reference.setConstraintWidget(helperWidget);
            }
        }
        for (Object obj2 : this.mReferences.keySet()) {
            Reference reference2 = this.mReferences.get(obj2);
            if (reference2 != this.mParent) {
                ConstraintWidget constraintWidget = reference2.getConstraintWidget();
                constraintWidget.setParent(null);
                if (reference2 instanceof GuidelineReference) {
                    reference2.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                reference2.setConstraintWidget(constraintWidgetContainer);
            }
        }
        for (Object obj3 : this.mHelperReferences.keySet()) {
            HelperReference helperReference = this.mHelperReferences.get(obj3);
            if (helperReference.getHelperWidget() != null) {
                Iterator<Object> it = helperReference.mReferences.iterator();
                while (it.hasNext()) {
                    helperReference.getHelperWidget().add(this.mReferences.get(it.next()).getConstraintWidget());
                }
                helperReference.apply();
            }
        }
        for (Object obj4 : this.mReferences.keySet()) {
            this.mReferences.get(obj4).apply();
        }
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        BarrierReference barrierReference = (BarrierReference) helper(obj, Helper.BARRIER);
        barrierReference.setBarrierDirection(direction);
        return barrierReference;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper(null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper(null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object obj : this.mReferences.keySet()) {
            constraints(obj).setView(obj);
        }
    }

    public GuidelineReference guideline(Object obj, int i) {
        Reference reference = this.mReferences.get(obj);
        GuidelineReference guidelineReference = reference;
        if (reference == null) {
            GuidelineReference guidelineReference2 = new GuidelineReference(this);
            guidelineReference2.setOrientation(i);
            guidelineReference2.setKey(obj);
            this.mReferences.put(obj, guidelineReference2);
            guidelineReference = guidelineReference2;
        }
        return (GuidelineReference) guidelineReference;
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public HelperReference helper(Object obj, Helper helper) {
        HelperReference helperReference;
        if (obj == null) {
            StringBuilder L = a.L("__HELPER_KEY_");
            int i = this.a;
            this.a = i + 1;
            obj = a.j(L, i, "__");
        }
        HelperReference helperReference2 = this.mHelperReferences.get(obj);
        if (helperReference2 == null) {
            int ordinal = helper.ordinal();
            if (ordinal == 0) {
                helperReference = new HorizontalChainReference(this);
            } else if (ordinal == 1) {
                helperReference = new VerticalChainReference(this);
            } else if (ordinal == 2) {
                helperReference = new AlignHorizontallyReference(this);
            } else if (ordinal == 3) {
                helperReference = new AlignVerticallyReference(this);
            } else if (ordinal != 4) {
                helperReference2 = new HelperReference(this, helper);
                this.mHelperReferences.put(obj, helperReference2);
            } else {
                helperReference = new BarrierReference(this);
            }
            helperReference2 = helperReference;
            this.mHelperReferences.put(obj, helperReference2);
        }
        return helperReference2;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper(null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public void map(Object obj, Object obj2) {
        constraints(obj).setView(obj2);
    }

    public void reset() {
        this.mHelperReferences.clear();
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) helper(null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }
}
