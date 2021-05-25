package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import l6.g.a.b.a;
import l6.g.a.b.c;
public class DesignTool {
    public static final HashMap<Pair<Integer, Integer>, String> f;
    public static final HashMap<String, String> g;
    public final MotionLayout a;
    public String b = null;
    public String c = null;
    public int d = -1;
    public int e = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        f = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        g = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.a = motionLayout;
    }

    public static void a(int i, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i2, int i3) {
        String str = f.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = g.get(str);
            constraintSet.connect(view.getId(), i2, Integer.parseInt(str2), i3, str3 != null ? b(i, hashMap.get(str3)) : 0);
        }
    }

    public static int b(int i, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) (((float) (Integer.valueOf(str.substring(0, indexOf)).intValue() * i)) / 160.0f);
    }

    public static void c(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i) {
        String str = hashMap.get(i == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str == null) {
            return;
        }
        if (i == 0) {
            constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str));
        } else if (i == 1) {
            constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str));
        }
    }

    public static void d(int i, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i2) {
        String str = hashMap.get(i2 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int i3 = -2;
            if (!str.equalsIgnoreCase("wrap_content")) {
                i3 = b(i, str);
            }
            if (i2 == 0) {
                constraintSet.constrainWidth(view.getId(), i3);
            } else {
                constraintSet.constrainHeight(view.getId(), i3);
            }
        }
    }

    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        MotionController motionController;
        View view = (View) obj;
        if (i != 0) {
            MotionLayout motionLayout = this.a;
            if (motionLayout.q == null || view == null || (motionController = motionLayout.z.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            int duration = this.a.q.getDuration() / 16;
            motionController.b(fArr2, duration);
            return duration;
        } else if (i == 2) {
            int duration2 = this.a.q.getDuration() / 16;
            motionController.a(fArr2, null);
            return duration2;
        } else if (i != 3) {
            return -1;
        } else {
            int duration3 = this.a.q.getDuration() / 16;
            SplineSet splineSet = motionController.x.get(str);
            if (splineSet == null) {
                return -1;
            }
            for (int i4 = 0; i4 < fArr2.length; i4++) {
                fArr2[i4] = splineSet.get((float) (i4 / (fArr2.length - 1)));
            }
            return fArr2.length;
        }
    }

    public void disableAutoTransition(boolean z) {
        MotionScene motionScene = this.a.q;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z);
        }
    }

    public void dumpConstraintSet(String str) {
        int i;
        MotionLayout motionLayout = this.a;
        if (motionLayout.q == null) {
            motionLayout.q = null;
        }
        MotionScene motionScene = motionLayout.q;
        if (motionScene == null) {
            i = 0;
        } else {
            i = motionScene.lookUpConstraintId(str);
        }
        PrintStream printStream = System.out;
        printStream.println(" dumping  " + str + " (" + i + ")");
        try {
            this.a.q.b(i).dump(this.a.q, new int[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        MotionScene motionScene = this.a.q;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.a.z.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.a(fArr, null);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i) {
        MotionLayout motionLayout = this.a;
        if (motionLayout.q == null) {
            return -1;
        }
        MotionController motionController = motionLayout.z.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.b(fArr, i);
        return i;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene = this.a.q;
        if (motionScene != null) {
            int duration = motionScene.getDuration() / 16;
            MotionController motionController = this.a.z.get(obj);
            if (motionController != null) {
                float f2 = 1.0f / ((float) (duration - 1));
                for (int i = 0; i < duration; i++) {
                    motionController.h[0].getPos((double) motionController.c(((float) i) * f2, null), motionController.n);
                    motionController.d.d(motionController.m, motionController.n, fArr, i * 8);
                }
            }
        }
    }

    public String getEndState() {
        int endState = this.a.getEndState();
        if (this.e == endState) {
            return this.c;
        }
        String f2 = this.a.f(endState);
        if (f2 != null) {
            this.c = f2;
            this.e = endState;
        }
        return f2;
    }

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        MotionController motionController = this.a.z.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    public float getKeyFramePosition(Object obj, int i, float f2, float f3) {
        return this.a.z.get((View) obj).e(i, f2, f3);
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.a.z.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i, int i2, int i3) {
        MotionLayout motionLayout = this.a;
        MotionScene motionScene = motionLayout.q;
        if (motionScene == null) {
            return null;
        }
        motionLayout.getContext();
        return motionScene.f(i, i2, i3);
    }

    public Object getKeyframeAtLocation(Object obj, float f2, float f3) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.a;
        if (motionLayout.q == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.z.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        RectF rectF = new RectF();
        c cVar = motionController.d;
        float f4 = cVar.e;
        rectF.left = f4;
        float f5 = cVar.f;
        rectF.top = f5;
        rectF.right = f4 + cVar.g;
        rectF.bottom = f5 + cVar.h;
        RectF rectF2 = new RectF();
        c cVar2 = motionController.e;
        float f6 = cVar2.e;
        rectF2.left = f6;
        float f7 = cVar2.f;
        rectF2.top = f7;
        rectF2.right = f6 + cVar2.g;
        rectF2.bottom = f7 + cVar2.h;
        Iterator<Key> it = motionController.v.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof a) {
                a aVar = (a) next;
                if (aVar.intersects(width, height, rectF, rectF2, f2, f3)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public Boolean getPositionKeyframe(Object obj, Object obj2, float f2, float f3, String[] strArr, float[] fArr) {
        if (!(obj instanceof a)) {
            return Boolean.FALSE;
        }
        a aVar = (a) obj;
        View view = (View) obj2;
        MotionController motionController = this.a.z.get(view);
        Objects.requireNonNull(motionController);
        RectF rectF = new RectF();
        c cVar = motionController.d;
        float f4 = cVar.e;
        rectF.left = f4;
        float f5 = cVar.f;
        rectF.top = f5;
        rectF.right = f4 + cVar.g;
        rectF.bottom = f5 + cVar.h;
        RectF rectF2 = new RectF();
        c cVar2 = motionController.e;
        float f6 = cVar2.e;
        rectF2.left = f6;
        float f7 = cVar2.f;
        rectF2.top = f7;
        rectF2.right = f6 + cVar2.g;
        rectF2.bottom = f7 + cVar2.h;
        aVar.positionAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
        this.a.rebuildScene();
        this.a.H = true;
        return Boolean.TRUE;
    }

    public float getProgress() {
        return this.a.getProgress();
    }

    public String getStartState() {
        int startState = this.a.getStartState();
        if (this.d == startState) {
            return this.b;
        }
        String f2 = this.a.f(startState);
        if (f2 != null) {
            this.b = f2;
            this.d = startState;
        }
        return this.a.f(startState);
    }

    public String getState() {
        if (!(this.b == null || this.c == null)) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.b;
            }
            if (progress >= 0.99f) {
                return this.c;
            }
        }
        return this.b;
    }

    public long getTransitionTimeMs() {
        return this.a.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        return (this.b == null || this.c == null) ? false : true;
    }

    public void setAttributes(int i, String str, Object obj, Object obj2) {
        int i2;
        View view = (View) obj;
        HashMap hashMap = (HashMap) obj2;
        MotionScene motionScene = this.a.q;
        if (motionScene == null) {
            i2 = 0;
        } else {
            i2 = motionScene.lookUpConstraintId(str);
        }
        ConstraintSet b2 = this.a.q.b(i2);
        if (b2 != null) {
            b2.clear(view.getId());
            d(i, b2, view, hashMap, 0);
            d(i, b2, view, hashMap, 1);
            a(i, b2, view, hashMap, 6, 6);
            a(i, b2, view, hashMap, 6, 7);
            a(i, b2, view, hashMap, 7, 7);
            a(i, b2, view, hashMap, 7, 6);
            a(i, b2, view, hashMap, 1, 1);
            a(i, b2, view, hashMap, 1, 2);
            a(i, b2, view, hashMap, 2, 2);
            a(i, b2, view, hashMap, 2, 1);
            a(i, b2, view, hashMap, 3, 3);
            a(i, b2, view, hashMap, 3, 4);
            a(i, b2, view, hashMap, 4, 3);
            a(i, b2, view, hashMap, 4, 4);
            a(i, b2, view, hashMap, 5, 5);
            c(b2, view, hashMap, 0);
            c(b2, view, hashMap, 1);
            String str2 = (String) hashMap.get("layout_editor_absoluteX");
            if (str2 != null) {
                b2.setEditorAbsoluteX(view.getId(), b(i, str2));
            }
            String str3 = (String) hashMap.get("layout_editor_absoluteY");
            if (str3 != null) {
                b2.setEditorAbsoluteY(view.getId(), b(i, str3));
            }
            this.a.updateState(i2, b2);
            this.a.requestLayout();
        }
    }

    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        MotionScene motionScene = this.a.q;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i, str, obj2);
            MotionLayout motionLayout = this.a;
            motionLayout.F = ((float) i) / 100.0f;
            motionLayout.D = 0.0f;
            motionLayout.rebuildScene();
            this.a.c(true);
        }
    }

    public boolean setKeyFramePosition(Object obj, int i, int i2, float f2, float f3) {
        boolean z;
        MotionLayout motionLayout = this.a;
        if (motionLayout.q != null) {
            MotionController motionController = motionLayout.z.get(obj);
            MotionLayout motionLayout2 = this.a;
            int i3 = (int) (motionLayout2.C * 100.0f);
            if (motionController != null) {
                View view = (View) obj;
                MotionScene.Transition transition = motionLayout2.q.c;
                if (transition != null) {
                    Iterator<KeyFrames> it = transition.k.iterator();
                    loop0:
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Iterator<Key> it2 = it.next().getKeyFramesForView(view.getId()).iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().a == i3) {
                                    z = true;
                                    break loop0;
                                }
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                    float e2 = motionController.e(2, f2, f3);
                    float e3 = motionController.e(5, f2, f3);
                    this.a.q.setKeyframe(view, i3, "motion:percentX", Float.valueOf(e2));
                    this.a.q.setKeyframe(view, i3, "motion:percentY", Float.valueOf(e3));
                    this.a.rebuildScene();
                    this.a.c(true);
                    this.a.invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.a.rebuildScene();
            this.a.H = true;
        }
    }

    public void setState(String str) {
        int i;
        if (str == null) {
            str = "motion_base";
        }
        if (this.b != str) {
            this.b = str;
            this.c = null;
            MotionLayout motionLayout = this.a;
            if (motionLayout.q == null) {
                motionLayout.q = null;
            }
            MotionScene motionScene = motionLayout.q;
            if (motionScene == null) {
                i = 0;
            } else {
                i = motionScene.lookUpConstraintId(str);
            }
            this.d = i;
            if (i != 0) {
                if (i == this.a.getStartState()) {
                    this.a.setProgress(0.0f);
                } else if (i == this.a.getEndState()) {
                    this.a.setProgress(1.0f);
                } else {
                    this.a.transitionToState(i);
                    this.a.setProgress(1.0f);
                }
            }
            this.a.requestLayout();
        }
    }

    public void setToolPosition(float f2) {
        MotionLayout motionLayout = this.a;
        if (motionLayout.q == null) {
            motionLayout.q = null;
        }
        motionLayout.setProgress(f2);
        this.a.c(true);
        this.a.requestLayout();
        this.a.invalidate();
    }

    public void setTransition(String str, String str2) {
        int i;
        MotionLayout motionLayout = this.a;
        if (motionLayout.q == null) {
            motionLayout.q = null;
        }
        MotionScene motionScene = motionLayout.q;
        int i2 = 0;
        if (motionScene == null) {
            i = 0;
        } else {
            i = motionScene.lookUpConstraintId(str);
        }
        MotionScene motionScene2 = this.a.q;
        if (motionScene2 != null) {
            i2 = motionScene2.lookUpConstraintId(str2);
        }
        this.a.setTransition(i, i2);
        this.d = i;
        this.e = i2;
        this.b = str;
        this.c = str2;
    }

    public void setViewDebug(Object obj, int i) {
        MotionController motionController = this.a.z.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i);
            this.a.invalidate();
        }
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        if (this.a.q == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionLayout motionLayout = this.a;
        MotionScene motionScene = motionLayout.q;
        motionLayout.getContext();
        return motionScene.f(i, id, i2);
    }
}
