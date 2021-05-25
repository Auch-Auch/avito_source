package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class ConstraintLayoutStates {
    public static final String TAG = "ConstraintLayoutStates";
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;
    public SparseArray<a> d = new SparseArray<>();
    public SparseArray<ConstraintSet> e = new SparseArray<>();
    public ConstraintsChangedListener f;

    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c = -1;
        public ConstraintSet d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == R.styleable.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.d = constraintSet;
                        constraintSet.clone(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int a(float f, float f2) {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class b {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;
        public float d = Float.NaN;
        public int e = -1;
        public ConstraintSet f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f = constraintSet;
                        constraintSet.clone(context, this.e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.a) && f2 < this.a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f3 < this.b) {
                return false;
            }
            if (!Float.isNaN(this.c) && f2 > this.c) {
                return false;
            }
            if (Float.isNaN(this.d) || f3 <= this.d) {
                return true;
            }
            return false;
        }
    }

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        char c2;
        a aVar = null;
        this.f = null;
        this.a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            a aVar2 = new a(context, xml);
                            this.d.put(aVar2.a, aVar2);
                            aVar = aVar2;
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        } else if (c2 == 4) {
                            a(context, xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public final void a(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(a2.b.a.a.a.N2(attributeValue, 47, 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                constraintSet.load(context, xmlPullParser);
                this.e.put(identifier, constraintSet);
                return;
            }
        }
    }

    public boolean needsToChange(int i, float f2, float f3) {
        int i2 = this.b;
        if (i2 != i) {
            return true;
        }
        a valueAt = i == -1 ? this.d.valueAt(0) : this.d.get(i2);
        int i3 = this.c;
        return (i3 == -1 || !valueAt.b.get(i3).a(f2, f3)) && this.c != valueAt.a(f2, f3);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.f = constraintsChangedListener;
    }

    public void updateConstraints(int i, float f2, float f3) {
        ConstraintSet constraintSet;
        int i2;
        a aVar;
        int a3;
        ConstraintSet constraintSet2;
        int i3;
        int i4 = this.b;
        if (i4 == i) {
            if (i == -1) {
                aVar = this.d.valueAt(0);
            } else {
                aVar = this.d.get(i4);
            }
            int i5 = this.c;
            if ((i5 == -1 || !aVar.b.get(i5).a(f2, f3)) && this.c != (a3 = aVar.a(f2, f3))) {
                if (a3 == -1) {
                    constraintSet2 = null;
                } else {
                    constraintSet2 = aVar.b.get(a3).f;
                }
                if (a3 == -1) {
                    i3 = aVar.c;
                } else {
                    i3 = aVar.b.get(a3).e;
                }
                if (constraintSet2 != null) {
                    this.c = a3;
                    ConstraintsChangedListener constraintsChangedListener = this.f;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i3);
                    }
                    constraintSet2.applyTo(this.a);
                    ConstraintsChangedListener constraintsChangedListener2 = this.f;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.b = i;
        a aVar2 = this.d.get(i);
        int a4 = aVar2.a(f2, f3);
        if (a4 == -1) {
            constraintSet = aVar2.d;
        } else {
            constraintSet = aVar2.b.get(a4).f;
        }
        if (a4 == -1) {
            i2 = aVar2.c;
        } else {
            i2 = aVar2.b.get(a4).e;
        }
        if (constraintSet != null) {
            this.c = a4;
            ConstraintsChangedListener constraintsChangedListener3 = this.f;
            if (constraintsChangedListener3 != null) {
                constraintsChangedListener3.preLayoutChange(i, i2);
            }
            constraintSet.applyTo(this.a);
            ConstraintsChangedListener constraintsChangedListener4 = this.f;
            if (constraintsChangedListener4 != null) {
                constraintsChangedListener4.postLayoutChange(i, i2);
            }
        }
    }
}
