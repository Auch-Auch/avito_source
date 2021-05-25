package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import l6.z.j;
import l6.z.k;
import l6.z.m;
import l6.z.p;
import l6.z.v;
import l6.z.w;
import l6.z.x;
public abstract class Transition implements Cloneable {
    public static final int[] G = {2, 1, 3, 4};
    public static final PathMotion H = new a();
    public static ThreadLocal<ArrayMap<Animator, c>> I = new ThreadLocal<>();
    public static final int MATCH_ID = 3;
    public static final int MATCH_INSTANCE = 1;
    public static final int MATCH_ITEM_ID = 4;
    public static final int MATCH_NAME = 2;
    public boolean A = false;
    public ArrayList<TransitionListener> B = null;
    public ArrayList<Animator> C = new ArrayList<>();
    public TransitionPropagation D;
    public EpicenterCallback E;
    public PathMotion F = H;
    public String a = getClass().getName();
    public long b = -1;
    public long c = -1;
    public TimeInterpolator d = null;
    public ArrayList<Integer> e = new ArrayList<>();
    public ArrayList<View> f = new ArrayList<>();
    public ArrayList<String> g = null;
    public ArrayList<Class<?>> h = null;
    public ArrayList<Integer> i = null;
    public ArrayList<View> j = null;
    public ArrayList<Class<?>> k = null;
    public ArrayList<String> l = null;
    public ArrayList<Integer> m = null;
    public ArrayList<View> n = null;
    public ArrayList<Class<?>> o = null;
    public m p = new m();
    public m q = new m();
    public TransitionSet r = null;
    public int[] s = G;
    public ArrayList<TransitionValues> t;
    public ArrayList<TransitionValues> u;
    public ViewGroup v;
    public boolean w = false;
    public ArrayList<Animator> x = new ArrayList<>();
    public int y = 0;
    public boolean z = false;

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    public static class a extends PathMotion {
        @Override // androidx.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    public static class c {
        public View a;
        public String b;
        public TransitionValues c;
        public x d;
        public Transition e;

        public c(View view, String str, Transition transition, x xVar, TransitionValues transitionValues) {
            this.a = view;
            this.b = str;
            this.c = transitionValues;
            this.d = xVar;
            this.e = transition;
        }
    }

    public Transition() {
    }

    public static void a(m mVar, View view, TransitionValues transitionValues) {
        mVar.a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (mVar.b.indexOfKey(id) >= 0) {
                mVar.b.put(id, null);
            } else {
                mVar.b.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (mVar.d.containsKey(transitionName)) {
                mVar.d.put(transitionName, null);
            } else {
                mVar.d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (mVar.c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = mVar.c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        mVar.c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                mVar.c.put(itemIdAtPosition, view);
            }
        }
    }

    public static ArrayMap<Animator, c> i() {
        ArrayMap<Animator, c> arrayMap = I.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, c> arrayMap2 = new ArrayMap<>();
        I.set(arrayMap2);
        return arrayMap2;
    }

    public static boolean k(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.f.add(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(animator.getStartDelay() + getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new b());
        animator.start();
    }

    public final void b(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.i;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.j;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.k;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.k.get(i2).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z2) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.a.add(this);
                        c(transitionValues);
                        if (z2) {
                            a(this.p, view, transitionValues);
                        } else {
                            a(this.q, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.m;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.n;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.o;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        if (this.o.get(i3).isInstance(view)) {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    b(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void c(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.D != null && !transitionValues.values.isEmpty() && (propagationProperties = this.D.getPropagationProperties()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= propagationProperties.length) {
                    z2 = true;
                    break;
                } else if (!transitionValues.values.containsKey(propagationProperties[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.D.captureValues(transitionValues);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((TransitionListener) arrayList2.get(i2)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, m mVar, m mVar2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i2;
        int i3;
        Animator createAnimator;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ArrayMap<Animator, c> i4 = i();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i5 = 0;
        while (i5 < size) {
            TransitionValues transitionValues3 = arrayList.get(i5);
            TransitionValues transitionValues4 = arrayList2.get(i5);
            if (transitionValues3 != null && !transitionValues3.a.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.a.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null)) {
                if ((transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) && (createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            i3 = size;
                            TransitionValues transitionValues5 = mVar2.a.get(view);
                            if (transitionValues5 != null) {
                                int i6 = 0;
                                while (i6 < transitionProperties.length) {
                                    transitionValues2.values.put(transitionProperties[i6], transitionValues5.values.get(transitionProperties[i6]));
                                    i6++;
                                    i5 = i5;
                                    transitionValues5 = transitionValues5;
                                }
                            }
                            i2 = i5;
                            int size2 = i4.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size2) {
                                    animator2 = createAnimator;
                                    break;
                                }
                                c cVar = i4.get(i4.keyAt(i7));
                                if (cVar.c != null && cVar.a == view && cVar.b.equals(getName()) && cVar.c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i3 = size;
                            i2 = i5;
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i3 = size;
                        i2 = i5;
                        view = transitionValues3.view;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.D;
                        if (transitionPropagation != null) {
                            long startDelay = transitionPropagation.getStartDelay(viewGroup, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.C.size(), (int) startDelay);
                            j2 = Math.min(startDelay, j2);
                        }
                        String name = getName();
                        v vVar = p.a;
                        i4.put(animator, new c(view, name, this, new w(viewGroup), transitionValues));
                        this.C.add(animator);
                        j2 = j2;
                    }
                    i5 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i5;
            i5 = i2 + 1;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i8));
                animator3.setStartDelay(animator3.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - j2));
            }
        }
    }

    public void d(ViewGroup viewGroup, boolean z2) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        e(z2);
        if ((this.e.size() > 0 || this.f.size() > 0) && (((arrayList = this.g) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.e.get(i2).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z2) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.a.add(this);
                    c(transitionValues);
                    if (z2) {
                        a(this.p, findViewById, transitionValues);
                    } else {
                        a(this.q, findViewById, transitionValues);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                View view = this.f.get(i3);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z2) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.a.add(this);
                c(transitionValues2);
                if (z2) {
                    a(this.p, view, transitionValues2);
                } else {
                    a(this.q, view, transitionValues2);
                }
            }
            return;
        }
        b(viewGroup, z2);
    }

    public void e(boolean z2) {
        if (z2) {
            this.p.a.clear();
            this.p.b.clear();
            this.p.c.clear();
            return;
        }
        this.q.a.clear();
        this.q.b.clear();
        this.q.c.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int i2 = this.y - 1;
        this.y = i2;
        if (i2 == 0) {
            ArrayList<TransitionListener> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((TransitionListener) arrayList2.get(i3)).onTransitionEnd(this);
                }
            }
            for (int i4 = 0; i4 < this.p.c.size(); i4++) {
                View valueAt = this.p.c.valueAt(i4);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i5 = 0; i5 < this.q.c.size(); i5++) {
                View valueAt2 = this.q.c.valueAt(i5);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.A = true;
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z2) {
        ArrayList<View> arrayList = this.n;
        if (view != null) {
            if (z2) {
                arrayList = AppCompatDelegateImpl.i.g(arrayList, view);
            } else {
                arrayList = AppCompatDelegateImpl.i.Q1(arrayList, view);
            }
        }
        this.n = arrayList;
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z2) {
        ArrayList<View> arrayList = this.j;
        if (view != null) {
            if (z2) {
                arrayList = AppCompatDelegateImpl.i.g(arrayList, view);
            } else {
                arrayList = AppCompatDelegateImpl.i.Q1(arrayList, view);
            }
        }
        this.j = arrayList;
        return this;
    }

    public final ArrayList<Integer> f(ArrayList<Integer> arrayList, int i2, boolean z2) {
        if (i2 <= 0) {
            return arrayList;
        }
        if (z2) {
            return AppCompatDelegateImpl.i.g(arrayList, Integer.valueOf(i2));
        }
        return AppCompatDelegateImpl.i.Q1(arrayList, Integer.valueOf(i2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void g(ViewGroup viewGroup) {
        ArrayMap<Animator, c> i2 = i();
        int size = i2.size();
        if (!(viewGroup == null || size == 0)) {
            v vVar = p.a;
            w wVar = new w(viewGroup);
            ArrayMap arrayMap = new ArrayMap(i2);
            i2.clear();
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c cVar = (c) arrayMap.valueAt(i3);
                if (cVar.a != null && wVar.equals(cVar.d)) {
                    ((Animator) arrayMap.keyAt(i3)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.c;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.E;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.E;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.d;
    }

    @NonNull
    public String getName() {
        return this.a;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.F;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.D;
    }

    public long getStartDelay() {
        return this.b;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.e;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.g;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.h;
    }

    @NonNull
    public List<View> getTargets() {
        return this.f;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z2) {
        TransitionSet transitionSet = this.r;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z2);
        }
        return (z2 ? this.p : this.q).a.get(view);
    }

    public TransitionValues h(View view, boolean z2) {
        TransitionSet transitionSet = this.r;
        if (transitionSet != null) {
            return transitionSet.h(view, z2);
        }
        ArrayList<TransitionValues> arrayList = z2 ? this.t : this.u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i3);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.u : this.t).get(i2);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!k(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        for (String str2 : transitionValues.values.keySet()) {
            if (k(transitionValues, transitionValues2, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean j(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.k.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.l == null || ViewCompat.getTransitionName(view) == null || !this.l.contains(ViewCompat.getTransitionName(view)))) {
            return false;
        }
        if ((this.e.size() == 0 && this.f.size() == 0 && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.g) == null || arrayList2.isEmpty()))) || this.e.contains(Integer.valueOf(id)) || this.f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.g;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.h != null) {
            for (int i3 = 0; i3 < this.h.size(); i3++) {
                if (this.h.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(boolean z2) {
        this.w = z2;
    }

    public Transition m(ViewGroup viewGroup) {
        this.v = viewGroup;
        return this;
    }

    public String n(String str) {
        StringBuilder L = a2.b.a.a.a.L(str);
        L.append(getClass().getSimpleName());
        L.append("@");
        L.append(Integer.toHexString(hashCode()));
        L.append(": ");
        String sb = L.toString();
        if (this.c != -1) {
            sb = a2.b.a.a.a.l(a2.b.a.a.a.Q(sb, "dur("), this.c, ") ");
        }
        if (this.b != -1) {
            sb = a2.b.a.a.a.l(a2.b.a.a.a.Q(sb, "dly("), this.b, ") ");
        }
        if (this.d != null) {
            StringBuilder Q = a2.b.a.a.a.Q(sb, "interp(");
            Q.append(this.d);
            Q.append(") ");
            sb = Q.toString();
        }
        if (this.e.size() <= 0 && this.f.size() <= 0) {
            return sb;
        }
        String c3 = a2.b.a.a.a.c3(sb, "tgts(");
        if (this.e.size() > 0) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                if (i2 > 0) {
                    c3 = a2.b.a.a.a.c3(c3, ", ");
                }
                StringBuilder L2 = a2.b.a.a.a.L(c3);
                L2.append(this.e.get(i2));
                c3 = L2.toString();
            }
        }
        if (this.f.size() > 0) {
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                if (i3 > 0) {
                    c3 = a2.b.a.a.a.c3(c3, ", ");
                }
                StringBuilder L3 = a2.b.a.a.a.L(c3);
                L3.append(this.f.get(i3));
                c3 = L3.toString();
            }
        }
        return a2.b.a.a.a.c3(c3, ")");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        if (!this.A) {
            ArrayMap<Animator, c> i2 = i();
            int size = i2.size();
            v vVar = p.a;
            w wVar = new w(view);
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c valueAt = i2.valueAt(i3);
                if (valueAt.a != null && wVar.equals(valueAt.d)) {
                    i2.keyAt(i3).pause();
                }
            }
            ArrayList<TransitionListener> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size2 = arrayList2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((TransitionListener) arrayList2.get(i4)).onTransitionPause(this);
                }
            }
            this.z = true;
        }
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.f.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        if (this.z) {
            if (!this.A) {
                ArrayMap<Animator, c> i2 = i();
                int size = i2.size();
                v vVar = p.a;
                w wVar = new w(view);
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    c valueAt = i2.valueAt(i3);
                    if (valueAt.a != null && wVar.equals(valueAt.d)) {
                        i2.keyAt(i3).resume();
                    }
                }
                ArrayList<TransitionListener> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((TransitionListener) arrayList2.get(i4)).onTransitionResume(this);
                    }
                }
            }
            this.z = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, c> i2 = i();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (i2.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new k(this, i2));
                    animate(next);
                }
            }
        }
        this.C.clear();
        end();
    }

    @NonNull
    public Transition setDuration(long j2) {
        this.c = j2;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.E = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.d = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.s = G;
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            boolean z2 = true;
            if (i3 >= 1 && i3 <= 4) {
                int i4 = iArr[i2];
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z2 = false;
                        break;
                    } else if (iArr[i5] == i4) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (z2) {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
            } else {
                throw new IllegalArgumentException("matches contains invalid value");
            }
        }
        this.s = (int[]) iArr.clone();
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.F = H;
        } else {
            this.F = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.D = transitionPropagation;
    }

    @NonNull
    public Transition setStartDelay(long j2) {
        this.b = j2;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.y == 0) {
            ArrayList<TransitionListener> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList2.get(i2)).onTransitionStart(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    @Override // java.lang.Object
    public String toString() {
        return n("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i2) {
        if (i2 != 0) {
            this.e.add(Integer.valueOf(i2));
        }
        return this;
    }

    @Override // java.lang.Object
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.C = new ArrayList<>();
            transition.p = new m();
            transition.q = new m();
            transition.t = null;
            transition.u = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public Transition removeTarget(@IdRes int i2) {
        if (i2 != 0) {
            this.e.remove(Integer.valueOf(i2));
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.add(str);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.g;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i2, boolean z2) {
        this.m = f(this.m, i2, z2);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i2, boolean z2) {
        this.i = f(this.i, i2, z2);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.h;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.h.add(cls);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z2) {
        ArrayList<Class<?>> arrayList = this.o;
        if (cls != null) {
            if (z2) {
                arrayList = AppCompatDelegateImpl.i.g(arrayList, cls);
            } else {
                arrayList = AppCompatDelegateImpl.i.Q1(arrayList, cls);
            }
        }
        this.o = arrayList;
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z2) {
        ArrayList<String> arrayList = this.l;
        if (str != null) {
            if (z2) {
                arrayList = AppCompatDelegateImpl.i.g(arrayList, str);
            } else {
                arrayList = AppCompatDelegateImpl.i.Q1(arrayList, str);
            }
        }
        this.l = arrayList;
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z2) {
        ArrayList<Class<?>> arrayList = this.k;
        if (cls != null) {
            if (z2) {
                arrayList = AppCompatDelegateImpl.i.g(arrayList, cls);
            } else {
                arrayList = AppCompatDelegateImpl.i.Q1(arrayList, cls);
            }
        }
        this.k = arrayList;
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(namedString, ",");
            int[] iArr = new int[stringTokenizer.countTokens()];
            int i2 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if ("id".equalsIgnoreCase(trim)) {
                    iArr[i2] = 3;
                } else if ("instance".equalsIgnoreCase(trim)) {
                    iArr[i2] = 1;
                } else if ("name".equalsIgnoreCase(trim)) {
                    iArr[i2] = 2;
                } else if ("itemId".equalsIgnoreCase(trim)) {
                    iArr[i2] = 4;
                } else if (trim.isEmpty()) {
                    int[] iArr2 = new int[(iArr.length - 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    i2--;
                    iArr = iArr2;
                } else {
                    throw new InflateException(a2.b.a.a.a.e3("Unknown match type in matchOrder: '", trim, "'"));
                }
                i2++;
            }
            setMatchOrder(iArr);
        }
        obtainStyledAttributes.recycle();
    }
}
