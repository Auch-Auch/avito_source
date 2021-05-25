package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.avito.android.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l6.g.a.b.f;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class MotionScene {
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final String TAG = "MotionScene";
    public static final int UNSET = -1;
    public final MotionLayout a;
    public StateSet b = null;
    public Transition c = null;
    public boolean d = false;
    public ArrayList<Transition> e = new ArrayList<>();
    public Transition f = null;
    public ArrayList<Transition> g = new ArrayList<>();
    public SparseArray<ConstraintSet> h = new SparseArray<>();
    public HashMap<String, Integer> i = new HashMap<>();
    public SparseIntArray j = new SparseIntArray();
    public int k = 400;
    public int l = 0;
    public MotionEvent m;
    public boolean n = false;
    public boolean o = false;
    public MotionLayout.MotionTracker p;
    public boolean q;
    public float r;
    public float s;

    public class a implements Interpolator {
        public final /* synthetic */ Easing a;

        public a(MotionScene motionScene, Easing easing) {
            this.a = easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.get((double) f);
        }
    }

    public MotionScene(MotionLayout motionLayout) {
        this.a = motionLayout;
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public boolean a(MotionLayout motionLayout, int i2) {
        MotionLayout.g gVar = MotionLayout.g.FINISHED;
        MotionLayout.g gVar2 = MotionLayout.g.MOVING;
        MotionLayout.g gVar3 = MotionLayout.g.SETUP;
        if ((this.p != null) || this.d) {
            return false;
        }
        Iterator<Transition> it = this.e.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            int i3 = next.n;
            if (!(i3 == 0 || this.c == next)) {
                if (i2 == next.d && (i3 == 4 || i3 == 2)) {
                    motionLayout.setState(gVar);
                    motionLayout.setTransition(next);
                    if (next.n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(gVar3);
                        motionLayout.setState(gVar2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.c(true);
                        motionLayout.setState(gVar3);
                        motionLayout.setState(gVar2);
                        motionLayout.setState(gVar);
                        motionLayout.i();
                    }
                    return true;
                } else if (i2 == next.c && (i3 == 3 || i3 == 1)) {
                    motionLayout.setState(gVar);
                    motionLayout.setTransition(next);
                    if (next.n == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(gVar3);
                        motionLayout.setState(gVar2);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.c(true);
                        motionLayout.setState(gVar3);
                        motionLayout.setState(gVar2);
                        motionLayout.setState(gVar);
                        motionLayout.i();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i2) {
        Iterator<Transition> it = this.e.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.m.size() > 0) {
                Iterator<Transition.a> it2 = next.m.iterator();
                while (it2.hasNext()) {
                    it2.next().b(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.g.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.m.size() > 0) {
                Iterator<Transition.a> it4 = next2.m.iterator();
                while (it4.hasNext()) {
                    it4.next().b(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.e.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.m.size() > 0) {
                Iterator<Transition.a> it6 = next3.m.iterator();
                while (it6.hasNext()) {
                    it6.next().a(motionLayout, i2, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.g.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.m.size() > 0) {
                Iterator<Transition.a> it8 = next4.m.iterator();
                while (it8.hasNext()) {
                    it8.next().a(motionLayout, i2, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int e2 = e(transition);
        if (e2 == -1) {
            this.e.add(transition);
        } else {
            this.e.set(e2, transition);
        }
    }

    public ConstraintSet b(int i2) {
        int stateGetConstraintID;
        StateSet stateSet = this.b;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i2, -1, -1)) == -1)) {
            i2 = stateGetConstraintID;
        }
        if (this.h.get(i2) != null) {
            return this.h.get(i2);
        }
        Debug.getName(this.a.getContext(), i2);
        SparseArray<ConstraintSet> sparseArray = this.h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public Transition bestTransitionFor(int i2, float f2, float f3, MotionEvent motionEvent) {
        f fVar;
        if (i2 == -1) {
            return this.c;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i2);
        float f4 = 0.0f;
        Transition transition = null;
        RectF rectF = new RectF();
        for (Transition transition2 : transitionsWithState) {
            if (!transition2.o && (fVar = transition2.l) != null) {
                fVar.b(this.q);
                RectF a3 = transition2.l.a(this.a, rectF);
                if (a3 == null || motionEvent == null || a3.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF a4 = transition2.l.a(this.a, rectF);
                    if (a4 == null || motionEvent == null || a4.contains(motionEvent.getX(), motionEvent.getY())) {
                        f fVar2 = transition2.l;
                        float f5 = ((fVar2.j * f3) + (fVar2.i * f2)) * (transition2.c == i2 ? -1.0f : 1.1f);
                        if (f5 > f4) {
                            transition = transition2;
                            f4 = f5;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public int c() {
        Transition transition = this.c;
        if (transition == null) {
            return -1;
        }
        return transition.c;
    }

    public final int d(Context context, String str) {
        int identifier = str.contains("/") ? context.getResources().getIdentifier(a2.b.a.a.a.N2(str, 47, 1), "id", context.getPackageName()) : -1;
        return (identifier != -1 || str.length() <= 1) ? identifier : Integer.parseInt(str.substring(1));
    }

    public void disableAutoTransition(boolean z) {
        this.d = z;
    }

    public final int e(Transition transition) {
        int i2 = transition.a;
        if (i2 != -1) {
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                if (this.e.get(i3).a == i2) {
                    return i3;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    public Key f(int i2, int i3, int i4) {
        Transition transition = this.c;
        if (transition == null) {
            return null;
        }
        Iterator<KeyFrames> it = transition.k.iterator();
        while (it.hasNext()) {
            KeyFrames next = it.next();
            Iterator<Integer> it2 = next.getKeys().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Integer next2 = it2.next();
                    if (i3 == next2.intValue()) {
                        Iterator<Key> it3 = next.getKeyFramesForView(next2.intValue()).iterator();
                        while (it3.hasNext()) {
                            Key next3 = it3.next();
                            if (next3.a == i4 && next3.mType == i2) {
                                return next3;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public float g() {
        f fVar;
        Transition transition = this.c;
        if (transition == null || (fVar = transition.l) == null) {
            return 0.0f;
        }
        return fVar.q;
    }

    public int gatPathMotionArc() {
        Transition transition = this.c;
        if (transition != null) {
            return transition.p;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            int keyAt = this.h.keyAt(i2);
            if (str.equals(context.getResources().getResourceName(keyAt))) {
                return this.h.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.h.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.h.keyAt(i2);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.e;
    }

    public int getDuration() {
        Transition transition = this.c;
        if (transition != null) {
            return transition.h;
        }
        return this.k;
    }

    public Interpolator getInterpolator() {
        Transition transition = this.c;
        int i2 = transition.e;
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(this.a.getContext(), this.c.g);
        }
        if (i2 == -1) {
            return new a(this, Easing.getInterpolator(transition.f));
        }
        if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i2 == 1) {
            return new AccelerateInterpolator();
        }
        if (i2 == 2) {
            return new DecelerateInterpolator();
        }
        if (i2 == 4) {
            return new AnticipateInterpolator();
        }
        if (i2 != 5) {
            return null;
        }
        return new BounceInterpolator();
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.c;
        if (transition == null) {
            Transition transition2 = this.f;
            if (transition2 != null) {
                Iterator<KeyFrames> it = transition2.k.iterator();
                while (it.hasNext()) {
                    it.next().addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator<KeyFrames> it2 = transition.k.iterator();
        while (it2.hasNext()) {
            it2.next().addFrames(motionController);
        }
    }

    public float getPathPercent(View view, int i2) {
        return 0.0f;
    }

    public float getStaggered() {
        Transition transition = this.c;
        if (transition != null) {
            return transition.i;
        }
        return 0.0f;
    }

    public Transition getTransitionById(int i2) {
        Iterator<Transition> it = this.e.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.a == i2) {
                return next;
            }
        }
        return null;
    }

    public List<Transition> getTransitionsWithState(int i2) {
        int stateGetConstraintID;
        StateSet stateSet = this.b;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i2, -1, -1)) == -1)) {
            i2 = stateGetConstraintID;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.e.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.d == i2 || next.c == i2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int h() {
        Transition transition = this.c;
        if (transition == null) {
            return -1;
        }
        return transition.d;
    }

    public final void i(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser.getAttributeName(i4);
            String attributeValue = xmlPullParser.getAttributeValue(i4);
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i3 = d(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i2 = d(context, attributeValue);
                this.i.put(stripID(attributeValue), Integer.valueOf(i2));
            }
        }
        if (i2 != -1) {
            if (this.a.L != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i3 != -1) {
                this.j.put(i2, i3);
            }
            this.h.put(i2, constraintSet);
        }
    }

    public final void j(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.k = obtainStyledAttributes.getInt(index, this.k);
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.l = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void k(int i2) {
        int i3 = this.j.get(i2);
        if (i3 > 0) {
            k(this.j.get(i2));
            ConstraintSet constraintSet = this.h.get(i2);
            ConstraintSet constraintSet2 = this.h.get(i3);
            if (constraintSet2 == null) {
                Debug.getName(this.a.getContext(), i3);
                return;
            }
            constraintSet.readFallback(constraintSet2);
            this.j.put(i2, -1);
        }
    }

    public void l(MotionLayout motionLayout) {
        boolean z;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            int keyAt = this.h.keyAt(i2);
            int i3 = this.j.get(keyAt);
            int size = this.j.size();
            while (true) {
                if (i3 <= 0) {
                    z = false;
                    break;
                } else if (i3 == keyAt) {
                    break;
                } else {
                    int i4 = size - 1;
                    if (size < 0) {
                        break;
                    }
                    i3 = this.j.get(i3);
                    size = i4;
                }
            }
            z = true;
            if (!z) {
                k(keyAt);
            } else {
                return;
            }
        }
        for (int i5 = 0; i5 < this.h.size(); i5++) {
            this.h.valueAt(i5).readFallback(motionLayout);
        }
    }

    public int lookUpConstraintId(String str) {
        return this.i.get(str).intValue();
    }

    public String lookUpConstraintName(int i2) {
        for (Map.Entry<String, Integer> entry : this.i.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(int r8, int r9) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.StateSet r0 = r7.b
            r1 = -1
            if (r0 == 0) goto L_0x0016
            int r0 = r0.stateGetConstraintID(r8, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r8
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r7.b
            int r2 = r2.stateGetConstraintID(r9, r1, r1)
            if (r2 == r1) goto L_0x0017
            goto L_0x0018
        L_0x0016:
            r0 = r8
        L_0x0017:
            r2 = r9
        L_0x0018:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r7.e
            java.util.Iterator r3 = r3.iterator()
        L_0x001e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.c
            if (r5 != r2) goto L_0x0032
            int r6 = r4.d
            if (r6 == r0) goto L_0x0038
        L_0x0032:
            if (r5 != r9) goto L_0x001e
            int r5 = r4.d
            if (r5 != r8) goto L_0x001e
        L_0x0038:
            r7.c = r4
            l6.g.a.b.f r8 = r4.l
            if (r8 == 0) goto L_0x0043
            boolean r9 = r7.q
            r8.b(r9)
        L_0x0043:
            return
        L_0x0044:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r7.f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r7.g
            java.util.Iterator r3 = r3.iterator()
        L_0x004c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.c
            if (r5 != r9) goto L_0x004c
            r8 = r4
            goto L_0x004c
        L_0x005e:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r9 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r9.<init>(r7, r8)
            r9.d = r0
            r9.c = r2
            if (r0 == r1) goto L_0x006e
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r8 = r7.e
            r8.add(r9)
        L_0x006e:
            r7.c = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.m(int, int):void");
    }

    public boolean n() {
        Iterator<Transition> it = this.e.iterator();
        while (it.hasNext()) {
            if (it.next().l != null) {
                return true;
            }
        }
        Transition transition = this.c;
        if (transition == null || transition.l == null) {
            return false;
        }
        return true;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public void removeTransition(Transition transition) {
        int e2 = e(transition);
        if (e2 != -1) {
            this.e.remove(e2);
        }
    }

    public void setConstraintSet(int i2, ConstraintSet constraintSet) {
        this.h.put(i2, constraintSet);
    }

    public void setDuration(int i2) {
        Transition transition = this.c;
        if (transition != null) {
            transition.setDuration(i2);
        } else {
            this.k = i2;
        }
    }

    public void setKeyframe(View view, int i2, String str, Object obj) {
        Transition transition = this.c;
        if (transition != null) {
            Iterator<KeyFrames> it = transition.k.iterator();
            while (it.hasNext()) {
                Iterator<Key> it2 = it.next().getKeyFramesForView(view.getId()).iterator();
                while (it2.hasNext()) {
                    if (it2.next().a == i2) {
                        int i3 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                        str.equalsIgnoreCase("app:PerpendicularPath_percent");
                    }
                }
            }
        }
    }

    public void setRtl(boolean z) {
        f fVar;
        this.q = z;
        Transition transition = this.c;
        if (transition != null && (fVar = transition.l) != null) {
            fVar.b(z);
        }
    }

    public void setTransition(Transition transition) {
        f fVar;
        this.c = transition;
        if (transition != null && (fVar = transition.l) != null) {
            fVar.b(this.q);
        }
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.a && motionLayout.q == this;
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i2) {
        Transition transition = null;
        this.a = motionLayout;
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c2 = 1;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1239391468:
                                if (name.equals("KeyFrameSet")) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 269306229:
                                if (name.equals("Transition")) {
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 312750793:
                                if (name.equals("OnClick")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 327855227:
                                if (name.equals("OnSwipe")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 793277014:
                                if (name.equals(TAG)) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                j(context, xml);
                                continue;
                            case 1:
                                ArrayList<Transition> arrayList = this.e;
                                Transition transition2 = new Transition(this, context, xml);
                                arrayList.add(transition2);
                                if (this.c == null && !transition2.b) {
                                    this.c = transition2;
                                    f fVar = transition2.l;
                                    if (fVar != null) {
                                        fVar.b(this.q);
                                    }
                                }
                                if (transition2.b) {
                                    if (transition2.c == -1) {
                                        this.f = transition2;
                                    } else {
                                        this.g.add(transition2);
                                    }
                                    this.e.remove(transition2);
                                }
                                transition = transition2;
                                continue;
                            case 2:
                                if (transition == null) {
                                    context.getResources().getResourceEntryName(i2);
                                    xml.getLineNumber();
                                }
                                transition.l = new f(context, this.a, xml);
                                continue;
                            case 3:
                                transition.addOnClick(context, xml);
                                continue;
                            case 4:
                                this.b = new StateSet(context, xml);
                                continue;
                            case 5:
                                i(context, xml);
                                continue;
                            case 6:
                                transition.k.add(new KeyFrames(context, xml));
                                continue;
                            default:
                                continue;
                        }
                    }
                    eventType = xml.next();
                } else {
                    SparseArray<ConstraintSet> sparseArray = this.h;
                    int i3 = R.id.motion_base;
                    sparseArray.put(i3, new ConstraintSet());
                    this.i.put("motion_base", Integer.valueOf(i3));
                    return;
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public int a = -1;
        public boolean b = false;
        public int c = -1;
        public int d = -1;
        public int e = 0;
        public String f = null;
        public int g = -1;
        public int h = 400;
        public float i = 0.0f;
        public final MotionScene j;
        public ArrayList<KeyFrames> k = new ArrayList<>();
        public f l = null;
        public ArrayList<a> m = new ArrayList<>();
        public int n = 0;
        public boolean o = false;
        public int p = -1;
        public int q = 0;
        public int r = 0;

        public static class a implements View.OnClickListener {
            public final Transition a;
            public int b = -1;
            public int c = 17;

            public a(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.a = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.b = obtainStyledAttributes.getResourceId(index, this.b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.c = obtainStyledAttributes.getInt(index, this.c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(androidx.constraintlayout.motion.widget.MotionLayout r8, int r9, androidx.constraintlayout.motion.widget.MotionScene.Transition r10) {
                /*
                    r7 = this;
                    int r0 = r7.b
                    r1 = -1
                    if (r0 != r1) goto L_0x0006
                    goto L_0x000a
                L_0x0006:
                    android.view.View r8 = r8.findViewById(r0)
                L_0x000a:
                    if (r8 != 0) goto L_0x000d
                    return
                L_0x000d:
                    int r0 = r10.d
                    int r10 = r10.c
                    if (r0 != r1) goto L_0x0017
                    r8.setOnClickListener(r7)
                    return
                L_0x0017:
                    int r1 = r7.c
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 == 0) goto L_0x0023
                    if (r9 != r0) goto L_0x0023
                    r5 = 1
                    goto L_0x0024
                L_0x0023:
                    r5 = 0
                L_0x0024:
                    r6 = r1 & 256(0x100, float:3.59E-43)
                    if (r6 == 0) goto L_0x002c
                    if (r9 != r0) goto L_0x002c
                    r6 = 1
                    goto L_0x002d
                L_0x002c:
                    r6 = 0
                L_0x002d:
                    r5 = r5 | r6
                    if (r2 == 0) goto L_0x0034
                    if (r9 != r0) goto L_0x0034
                    r0 = 1
                    goto L_0x0035
                L_0x0034:
                    r0 = 0
                L_0x0035:
                    r0 = r0 | r5
                    r2 = r1 & 16
                    if (r2 == 0) goto L_0x003e
                    if (r9 != r10) goto L_0x003e
                    r2 = 1
                    goto L_0x003f
                L_0x003e:
                    r2 = 0
                L_0x003f:
                    r0 = r0 | r2
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x0047
                    if (r9 != r10) goto L_0x0047
                    r3 = 1
                L_0x0047:
                    r9 = r0 | r3
                    if (r9 == 0) goto L_0x004e
                    r8.setOnClickListener(r7)
                L_0x004e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.a.a(androidx.constraintlayout.motion.widget.MotionLayout, int, androidx.constraintlayout.motion.widget.MotionScene$Transition):void");
            }

            public void b(MotionLayout motionLayout) {
                View findViewById;
                int i = this.b;
                if (i != -1 && (findViewById = motionLayout.findViewById(i)) != null) {
                    findViewById.setOnClickListener(null);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.a.j.a;
                if (motionLayout.isInteractionEnabled()) {
                    Transition transition = this.a;
                    if (transition.d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.a.c);
                            return;
                        }
                        Transition transition2 = this.a;
                        Transition transition3 = new Transition(transition2.j, transition2);
                        transition3.d = currentState;
                        transition3.c = this.a.c;
                        motionLayout.setTransition(transition3);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    Transition transition4 = transition.j.c;
                    int i = this.c;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    boolean z3 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        if (transition4 != transition) {
                            motionLayout.setTransition(transition);
                        }
                        if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                            z2 = false;
                        } else {
                            z3 = false;
                        }
                    }
                    Transition transition5 = this.a;
                    if (transition5 != transition4) {
                        int i2 = transition5.c;
                        int i3 = transition5.d;
                        if (i3 != -1) {
                        }
                    }
                    z = true;
                    if (!z) {
                        return;
                    }
                    if (z2 && (this.c & 1) != 0) {
                        motionLayout.setTransition(transition5);
                        motionLayout.transitionToEnd();
                    } else if (z3 && (this.c & 16) != 0) {
                        motionLayout.setTransition(transition5);
                        motionLayout.transitionToStart();
                    } else if (z2 && (this.c & 256) != 0) {
                        motionLayout.setTransition(transition5);
                        motionLayout.setProgress(1.0f);
                    } else if (z3 && (this.c & 4096) != 0) {
                        motionLayout.setTransition(transition5);
                        motionLayout.setProgress(0.0f);
                    }
                }
            }
        }

        public Transition(MotionScene motionScene, Transition transition) {
            this.j = motionScene;
            if (transition != null) {
                this.p = transition.p;
                this.e = transition.e;
                this.f = transition.f;
                this.g = transition.g;
                this.h = transition.h;
                this.k = transition.k;
                this.i = transition.i;
                this.q = transition.q;
            }
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new a(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String str;
            if (this.d == -1) {
                str = BuildConfig.ADJUST_DEFAULT_TRACKER;
            } else {
                str = context.getResources().getResourceEntryName(this.d);
            }
            if (this.c == -1) {
                return a2.b.a.a.a.c3(str, " -> null");
            }
            StringBuilder Q = a2.b.a.a.a.Q(str, " -> ");
            Q.append(context.getResources().getResourceEntryName(this.c));
            return Q.toString();
        }

        public int getAutoTransition() {
            return this.n;
        }

        public int getDuration() {
            return this.h;
        }

        public int getEndConstraintSetId() {
            return this.c;
        }

        public int getId() {
            return this.a;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.k;
        }

        public int getLayoutDuringTransition() {
            return this.q;
        }

        public List<a> getOnClickList() {
            return this.m;
        }

        public int getPathMotionArc() {
            return this.p;
        }

        public float getStagger() {
            return this.i;
        }

        public int getStartConstraintSetId() {
            return this.d;
        }

        public f getTouchResponse() {
            return this.l;
        }

        public boolean isEnabled() {
            return !this.o;
        }

        public boolean isTransitionFlag(int i2) {
            return (i2 & this.r) != 0;
        }

        public void setAutoTransition(int i2) {
            this.n = i2;
        }

        public void setDuration(int i2) {
            this.h = i2;
        }

        public void setEnable(boolean z) {
            this.o = !z;
        }

        public void setPathMotionArc(int i2) {
            this.p = i2;
        }

        public void setStagger(float f2) {
            this.i = f2;
        }

        public Transition(int i2, MotionScene motionScene, int i3, int i4) {
            this.a = i2;
            this.j = motionScene;
            this.d = i3;
            this.c = i4;
            this.h = motionScene.k;
            this.q = motionScene.l;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.h = motionScene.k;
            this.q = motionScene.l;
            this.j = motionScene;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Transition);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.c))) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.c);
                        motionScene.h.append(this.c, constraintSet);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.d = obtainStyledAttributes.getResourceId(index, this.d);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.d))) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.d);
                        motionScene.h.append(this.d, constraintSet2);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i3 = obtainStyledAttributes.peekValue(index).type;
                    if (i3 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.g = resourceId;
                        if (resourceId != -1) {
                            this.e = -2;
                        }
                    } else if (i3 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f = string;
                        if (string.indexOf("/") > 0) {
                            this.g = obtainStyledAttributes.getResourceId(index, -1);
                            this.e = -2;
                        } else {
                            this.e = -1;
                        }
                    } else {
                        this.e = obtainStyledAttributes.getInteger(index, this.e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.h = obtainStyledAttributes.getInt(index, this.h);
                } else if (index == R.styleable.Transition_staggered) {
                    this.i = obtainStyledAttributes.getFloat(index, this.i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.n = obtainStyledAttributes.getInteger(index, this.n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.o = obtainStyledAttributes.getBoolean(index, this.o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.p = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.q = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.r = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
            obtainStyledAttributes.recycle();
        }
    }
}
