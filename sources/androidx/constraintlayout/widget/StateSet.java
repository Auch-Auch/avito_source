package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class StateSet {
    public static final String TAG = "ConstraintLayoutStates";
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public SparseArray<a> d = new SparseArray<>();

    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c = -1;

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
                    "layout".equals(resourceTypeName);
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

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    "layout".equals(resourceTypeName);
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

        public boolean a(float f, float f2) {
            if (!Float.isNaN(this.a) && f < this.a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f2 < this.b) {
                return false;
            }
            if (!Float.isNaN(this.c) && f > this.c) {
                return false;
            }
            if (Float.isNaN(this.d) || f2 <= this.d) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public StateSet(Context context, XmlPullParser xmlPullParser) {
        char c2;
        new SparseArray();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.StateSet_defaultState) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            }
        }
        obtainStyledAttributes.recycle();
        a aVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c2 = 0;
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
                            aVar = new a(context, xmlPullParser);
                            this.d.put(aVar.a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xmlPullParser);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        }
                    }
                } else if (eventType == 3 && "StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        a aVar = this.d.get(i2);
        if (aVar == null) {
            return i2;
        }
        if (f != -1.0f && f2 != -1.0f) {
            b bVar = null;
            Iterator<b> it = aVar.b.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a(f, f2)) {
                    if (i == next.e) {
                        return i;
                    }
                    bVar = next;
                }
            }
            if (bVar != null) {
                return bVar.e;
            }
            return aVar.c;
        } else if (aVar.c == i) {
            return i;
        } else {
            Iterator<b> it2 = aVar.b.iterator();
            while (it2.hasNext()) {
                if (i == it2.next().e) {
                    return i;
                }
            }
            return aVar.c;
        }
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.b;
        if (i2 != i) {
            return true;
        }
        a valueAt = i == -1 ? this.d.valueAt(0) : this.d.get(i2);
        int i3 = this.c;
        return (i3 == -1 || !valueAt.b.get(i3).a(f, f2)) && this.c != valueAt.a(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, (float) i2, (float) i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        a aVar;
        int a3;
        if (i == i2) {
            if (i2 == -1) {
                aVar = this.d.valueAt(0);
            } else {
                aVar = this.d.get(this.b);
            }
            if (aVar == null) {
                return -1;
            }
            if ((this.c == -1 || !aVar.b.get(i).a(f, f2)) && i != (a3 = aVar.a(f, f2))) {
                return a3 == -1 ? aVar.c : aVar.b.get(a3).e;
            }
            return i;
        }
        a aVar2 = this.d.get(i2);
        if (aVar2 == null) {
            return -1;
        }
        int a4 = aVar2.a(f, f2);
        return a4 == -1 ? aVar2.c : aVar2.b.get(a4).e;
    }
}
