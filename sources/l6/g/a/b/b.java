package l6.g.a.b;

import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
public class b implements Comparable<b> {
    public float a = 1.0f;
    public int b = 0;
    public int c;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public float g = 0.0f;
    public float h = 1.0f;
    public float i = 1.0f;
    public float j = Float.NaN;
    public float k = Float.NaN;
    public float l = 0.0f;
    public float m = 0.0f;
    public float n = 0.0f;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public LinkedHashMap<String, ConstraintAttribute> q = new LinkedHashMap<>();

    public void a(HashMap<String, SplineSet> hashMap, int i2) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = '\r';
                        break;
                    }
                    break;
            }
            float f2 = 1.0f;
            float f3 = 0.0f;
            switch (c2) {
                case 0:
                    if (!Float.isNaN(this.f)) {
                        f3 = this.f;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 1:
                    if (!Float.isNaN(this.g)) {
                        f3 = this.g;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 2:
                    if (!Float.isNaN(this.l)) {
                        f3 = this.l;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 3:
                    if (!Float.isNaN(this.m)) {
                        f3 = this.m;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 4:
                    if (!Float.isNaN(this.n)) {
                        f3 = this.n;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 5:
                    if (!Float.isNaN(this.p)) {
                        f3 = this.p;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 6:
                    if (!Float.isNaN(this.h)) {
                        f2 = this.h;
                    }
                    splineSet.setPoint(i2, f2);
                    break;
                case 7:
                    if (!Float.isNaN(this.i)) {
                        f2 = this.i;
                    }
                    splineSet.setPoint(i2, f2);
                    break;
                case '\b':
                    if (!Float.isNaN(this.j)) {
                        f3 = this.j;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case '\t':
                    if (!Float.isNaN(this.k)) {
                        f3 = this.k;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case '\n':
                    if (!Float.isNaN(this.e)) {
                        f3 = this.e;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case 11:
                    if (!Float.isNaN(this.d)) {
                        f3 = this.d;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case '\f':
                    if (!Float.isNaN(this.o)) {
                        f3 = this.o;
                    }
                    splineSet.setPoint(i2, f3);
                    break;
                case '\r':
                    if (!Float.isNaN(this.a)) {
                        f2 = this.a;
                    }
                    splineSet.setPoint(i2, f2);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.q.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.q.get(str2);
                            if (splineSet instanceof SplineSet.b) {
                                ((SplineSet.b) splineSet).c.append(i2, constraintAttribute);
                                break;
                            } else {
                                String str3 = str + " splineSet not a CustomSet frame = " + i2 + ", value" + constraintAttribute.getValueToInterpolate() + splineSet;
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
            }
        }
    }

    public final boolean b(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (Float.isNaN(f2) != Float.isNaN(f3)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f3) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void c(ConstraintWidget constraintWidget, ConstraintSet constraintSet, int i2) {
        float f2;
        constraintWidget.getX();
        constraintWidget.getY();
        constraintWidget.getWidth();
        constraintWidget.getHeight();
        ConstraintSet.Constraint parameters = constraintSet.getParameters(i2);
        ConstraintSet.PropertySet propertySet = parameters.propertySet;
        int i3 = propertySet.mVisibilityMode;
        this.b = i3;
        int i4 = propertySet.visibility;
        this.c = i4;
        if (i4 == 0 || i3 != 0) {
            f2 = propertySet.alpha;
        } else {
            f2 = 0.0f;
        }
        this.a = f2;
        ConstraintSet.Transform transform = parameters.transform;
        boolean z = transform.applyElevation;
        this.d = transform.elevation;
        this.e = transform.rotation;
        this.f = transform.rotationX;
        this.g = transform.rotationY;
        this.h = transform.scaleX;
        this.i = transform.scaleY;
        this.j = transform.transformPivotX;
        this.k = transform.transformPivotY;
        this.l = transform.translationX;
        this.m = transform.translationY;
        this.n = transform.translationZ;
        Easing.getInterpolator(parameters.motion.mTransitionEasing);
        this.o = parameters.motion.mPathRotate;
        this.p = parameters.propertySet.mProgress;
        for (String str : parameters.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = parameters.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.q.put(str, constraintAttribute);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        Objects.requireNonNull(bVar);
        return Float.compare(0.0f, 0.0f);
    }
}
