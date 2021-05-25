package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
public abstract class Key {
    public static int UNSET = -1;
    public int a;
    public int b;
    public String c = null;
    public HashMap<String, ConstraintAttribute> d;
    public int mType;

    public Key() {
        int i = UNSET;
        this.a = i;
        this.b = i;
    }

    public float a(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    public int b(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }

    public abstract void getAttributeNames(HashSet<String> hashSet);

    public abstract void load(Context context, AttributeSet attributeSet);

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public abstract void setValue(String str, Object obj);
}
