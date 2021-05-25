package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
public class ConstraintReference implements Reference {
    public Object A = null;
    public Object B = null;
    public Object C = null;
    public Object D = null;
    public Object E = null;
    public State.Constraint F = null;
    public Dimension G;
    public Dimension H;
    public Object I;
    public ConstraintWidget J;
    public Object a;
    public final State b;
    public int c = 0;
    public int d = 0;
    public float e = 0.5f;
    public float f = 0.5f;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public Object s = null;
    public Object t = null;
    public Object u = null;
    public Object v = null;
    public Object w = null;
    public Object x = null;
    public Object y = null;
    public Object z = null;

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            State.Constraint.values();
            int[] iArr = new int[15];
            a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[9] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[10] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[11] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[12] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[13] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[14] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public class b extends Exception {
        public final ArrayList<String> a;

        public b(ConstraintReference constraintReference, ArrayList<String> arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Throwable, java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("IncorrectConstraintException: ");
            L.append(this.a.toString());
            return L.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.WRAP_DIMENSION;
        this.G = Dimension.Fixed(obj);
        this.H = Dimension.Fixed(obj);
        this.b = state;
    }

    public final void a(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget constraintWidget2 = obj instanceof Reference ? ((Reference) obj).getConstraintWidget() : null;
        if (constraintWidget2 != null) {
            int i2 = a.a[constraint.ordinal()];
            switch (constraint.ordinal()) {
                case 0:
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type).connect(constraintWidget2.getAnchor(type), this.g, this.m, false);
                    return;
                case 1:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT), this.g, this.m, false);
                    return;
                case 2:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.h, this.n, false);
                    return;
                case 3:
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type2).connect(constraintWidget2.getAnchor(type2), this.h, this.n, false);
                    return;
                case 4:
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type3).connect(constraintWidget2.getAnchor(type3), this.i, this.o, false);
                    return;
                case 5:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT), this.i, this.o, false);
                    return;
                case 6:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.j, this.p, false);
                    return;
                case 7:
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type4).connect(constraintWidget2.getAnchor(type4), this.j, this.p, false);
                    return;
                case 8:
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                    constraintWidget.getAnchor(type5).connect(constraintWidget2.getAnchor(type5), this.k, this.q, false);
                    return;
                case 9:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM), this.k, this.q, false);
                    return;
                case 10:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP), this.l, this.r, false);
                    return;
                case 11:
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.getAnchor(type6).connect(constraintWidget2.getAnchor(type6), this.l, this.r, false);
                    return;
                case 12:
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                    constraintWidget.immediateConnect(type7, constraintWidget2, type7, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        ConstraintWidget constraintWidget = this.J;
        if (constraintWidget != null) {
            this.G.apply(this.b, constraintWidget, 0);
            this.H.apply(this.b, this.J, 1);
            this.s = b(this.s);
            this.t = b(this.t);
            this.u = b(this.u);
            this.v = b(this.v);
            this.w = b(this.w);
            this.x = b(this.x);
            this.y = b(this.y);
            this.z = b(this.z);
            this.A = b(this.A);
            this.B = b(this.B);
            this.C = b(this.C);
            this.D = b(this.D);
            this.E = b(this.E);
            a(this.J, this.s, State.Constraint.LEFT_TO_LEFT);
            a(this.J, this.t, State.Constraint.LEFT_TO_RIGHT);
            a(this.J, this.u, State.Constraint.RIGHT_TO_LEFT);
            a(this.J, this.v, State.Constraint.RIGHT_TO_RIGHT);
            a(this.J, this.w, State.Constraint.START_TO_START);
            a(this.J, this.x, State.Constraint.START_TO_END);
            a(this.J, this.y, State.Constraint.END_TO_START);
            a(this.J, this.z, State.Constraint.END_TO_END);
            a(this.J, this.A, State.Constraint.TOP_TO_TOP);
            a(this.J, this.B, State.Constraint.TOP_TO_BOTTOM);
            a(this.J, this.C, State.Constraint.BOTTOM_TO_TOP);
            a(this.J, this.D, State.Constraint.BOTTOM_TO_BOTTOM);
            a(this.J, this.E, State.Constraint.BASELINE_TO_BASELINE);
            int i2 = this.c;
            if (i2 != 0) {
                this.J.setHorizontalChainStyle(i2);
            }
            int i3 = this.d;
            if (i3 != 0) {
                this.J.setVerticalChainStyle(i3);
            }
            this.J.setHorizontalBiasPercent(this.e);
            this.J.setVerticalBiasPercent(this.f);
        }
    }

    public final Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.b.mReferences.get(obj) : obj;
    }

    public ConstraintReference baseline() {
        this.F = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.F = State.Constraint.BASELINE_TO_BASELINE;
        this.E = obj;
        return this;
    }

    public ConstraintReference bias(float f2) {
        State.Constraint constraint = this.F;
        if (constraint == null) {
            return this;
        }
        switch (constraint.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 13:
                this.e = f2;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 14:
                this.f = f2;
                break;
        }
        return this;
    }

    public ConstraintReference bottom() {
        if (this.C != null) {
            this.F = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.F = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.F = State.Constraint.BOTTOM_TO_BOTTOM;
        this.D = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.F = State.Constraint.BOTTOM_TO_TOP;
        this.C = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object b2 = b(obj);
        this.w = b2;
        this.z = b2;
        this.F = State.Constraint.CENTER_HORIZONTALLY;
        this.e = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object b2 = b(obj);
        this.A = b2;
        this.D = b2;
        this.F = State.Constraint.CENTER_VERTICALLY;
        this.f = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint constraint = this.F;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.s = null;
                    this.t = null;
                    this.g = 0;
                    this.m = 0;
                    break;
                case 2:
                case 3:
                    this.u = null;
                    this.v = null;
                    this.h = 0;
                    this.n = 0;
                    break;
                case 4:
                case 5:
                    this.w = null;
                    this.x = null;
                    this.i = 0;
                    this.o = 0;
                    break;
                case 6:
                case 7:
                    this.y = null;
                    this.z = null;
                    this.j = 0;
                    this.p = 0;
                    break;
                case 8:
                case 9:
                    this.A = null;
                    this.B = null;
                    this.k = 0;
                    this.q = 0;
                    break;
                case 10:
                case 11:
                    this.C = null;
                    this.D = null;
                    this.l = 0;
                    this.r = 0;
                    break;
                case 12:
                    this.E = null;
                    break;
            }
        } else {
            this.s = null;
            this.t = null;
            this.g = 0;
            this.u = null;
            this.v = null;
            this.h = 0;
            this.w = null;
            this.x = null;
            this.i = 0;
            this.y = null;
            this.z = null;
            this.j = 0;
            this.A = null;
            this.B = null;
            this.k = 0;
            this.C = null;
            this.D = null;
            this.l = 0;
            this.E = null;
            this.e = 0.5f;
            this.f = 0.5f;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = 0;
        }
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().d, getHeight().d);
    }

    public ConstraintReference end() {
        if (this.y != null) {
            this.F = State.Constraint.END_TO_START;
        } else {
            this.F = State.Constraint.END_TO_END;
        }
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.F = State.Constraint.END_TO_END;
        this.z = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.F = State.Constraint.END_TO_START;
        this.y = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.J == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.J = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.I);
        }
        return this.J;
    }

    public Dimension getHeight() {
        return this.H;
    }

    public int getHorizontalChainStyle() {
        return this.c;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.a;
    }

    public int getVerticalChainStyle(int i2) {
        return this.d;
    }

    public Object getView() {
        return this.I;
    }

    public Dimension getWidth() {
        return this.G;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f2) {
        this.e = f2;
        return this;
    }

    public ConstraintReference left() {
        if (this.s != null) {
            this.F = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.F = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.F = State.Constraint.LEFT_TO_LEFT;
        this.s = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.F = State.Constraint.LEFT_TO_RIGHT;
        this.t = obj;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.b.convertDimension(obj));
    }

    public ConstraintReference marginGone(int i2) {
        State.Constraint constraint = this.F;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.m = i2;
                    break;
                case 2:
                case 3:
                    this.n = i2;
                    break;
                case 4:
                case 5:
                    this.o = i2;
                    break;
                case 6:
                case 7:
                    this.p = i2;
                    break;
                case 8:
                case 9:
                    this.q = i2;
                    break;
                case 10:
                case 11:
                    this.r = i2;
                    break;
            }
        } else {
            this.m = i2;
            this.n = i2;
            this.o = i2;
            this.p = i2;
            this.q = i2;
            this.r = i2;
        }
        return this;
    }

    public ConstraintReference right() {
        if (this.u != null) {
            this.F = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.F = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.F = State.Constraint.RIGHT_TO_LEFT;
        this.u = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.F = State.Constraint.RIGHT_TO_RIGHT;
        this.v = obj;
        return this;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget != null) {
            this.J = constraintWidget;
            constraintWidget.setCompanionWidget(this.I);
        }
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.H = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i2) {
        this.c = i2;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object obj) {
        this.a = obj;
    }

    public void setVerticalChainStyle(int i2) {
        this.d = i2;
    }

    public void setView(Object obj) {
        this.I = obj;
        ConstraintWidget constraintWidget = this.J;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.G = dimension;
        return this;
    }

    public ConstraintReference start() {
        if (this.w != null) {
            this.F = State.Constraint.START_TO_START;
        } else {
            this.F = State.Constraint.START_TO_END;
        }
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.F = State.Constraint.START_TO_END;
        this.x = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.F = State.Constraint.START_TO_START;
        this.w = obj;
        return this;
    }

    public ConstraintReference top() {
        if (this.A != null) {
            this.F = State.Constraint.TOP_TO_TOP;
        } else {
            this.F = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.F = State.Constraint.TOP_TO_BOTTOM;
        this.B = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.F = State.Constraint.TOP_TO_TOP;
        this.A = obj;
        return this;
    }

    public void validate() throws b {
        ArrayList arrayList = new ArrayList();
        if (!(this.s == null || this.t == null)) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (!(this.u == null || this.v == null)) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (!(this.w == null || this.x == null)) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (!(this.y == null || this.z == null)) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if (!((this.s == null && this.t == null && this.u == null && this.v == null) || (this.w == null && this.x == null && this.y == null && this.z == null))) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new b(this, arrayList);
        }
    }

    public ConstraintReference verticalBias(float f2) {
        this.f = f2;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }

    public ConstraintReference margin(int i2) {
        State.Constraint constraint = this.F;
        if (constraint != null) {
            switch (constraint.ordinal()) {
                case 0:
                case 1:
                    this.g = i2;
                    break;
                case 2:
                case 3:
                    this.h = i2;
                    break;
                case 4:
                case 5:
                    this.i = i2;
                    break;
                case 6:
                case 7:
                    this.j = i2;
                    break;
                case 8:
                case 9:
                    this.k = i2;
                    break;
                case 10:
                case 11:
                    this.l = i2;
                    break;
            }
        } else {
            this.g = i2;
            this.h = i2;
            this.i = i2;
            this.j = i2;
            this.k = i2;
            this.l = i2;
        }
        return this;
    }
}
