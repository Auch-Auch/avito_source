package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
public class Dimension {
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    public int a = 0;
    public int b = Integer.MAX_VALUE;
    public float c = 1.0f;
    public int d = 0;
    public Object e = WRAP_DIMENSION;
    public boolean f = false;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    public Dimension() {
    }

    public static Dimension Fixed(int i) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f2) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f2);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i) {
        Dimension dimension = new Dimension();
        dimension.suggested(i);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i) {
        int i2 = 2;
        if (i == 0) {
            if (this.f) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.e;
                if (obj == WRAP_DIMENSION) {
                    i2 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i2 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i2, this.a, this.b, this.c);
                return;
            }
            int i3 = this.a;
            if (i3 > 0) {
                constraintWidget.setMinWidth(i3);
            }
            int i4 = this.b;
            if (i4 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i4);
            }
            Object obj2 = this.e;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj2 == null) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(this.d);
            }
        } else if (this.f) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.e;
            if (obj3 == WRAP_DIMENSION) {
                i2 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i2 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i2, this.a, this.b, this.c);
        } else {
            int i5 = this.a;
            if (i5 > 0) {
                constraintWidget.setMinHeight(i5);
            }
            int i6 = this.b;
            if (i6 < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(i6);
            }
            Object obj4 = this.e;
            if (obj4 == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj4 == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj4 == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.d);
            }
        }
    }

    public Dimension fixed(Object obj) {
        this.e = obj;
        if (obj instanceof Integer) {
            this.d = ((Integer) obj).intValue();
            this.e = null;
        }
        return this;
    }

    public Dimension max(int i) {
        if (this.b >= 0) {
            this.b = i;
        }
        return this;
    }

    public Dimension min(int i) {
        if (i >= 0) {
            this.a = i;
        }
        return this;
    }

    public Dimension percent(Object obj, float f2) {
        this.c = f2;
        return this;
    }

    public Dimension ratio(float f2) {
        return this;
    }

    public Dimension suggested(int i) {
        this.f = true;
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.a = -2;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.e = obj;
        this.f = true;
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.f) {
            this.e = obj2;
            this.b = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension fixed(int i) {
        this.e = null;
        this.d = i;
        return this;
    }

    public Dimension(Object obj) {
        this.e = obj;
    }
}
