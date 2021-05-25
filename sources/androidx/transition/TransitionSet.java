package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import l6.z.j;
import l6.z.m;
public class TransitionSet extends Transition {
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    public ArrayList<Transition> J = new ArrayList<>();
    public boolean K = true;
    public int L;
    public boolean M = false;
    public int N = 0;

    public class a extends TransitionListenerAdapter {
        public final /* synthetic */ Transition a;

        public a(TransitionSet transitionSet, Transition transition) {
            this.a = transition;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            this.a.runAnimators();
            transition.removeListener(this);
        }
    }

    public static class b extends TransitionListenerAdapter {
        public TransitionSet a;

        public b(TransitionSet transitionSet) {
            this.a = transitionSet;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.a;
            int i = transitionSet.L - 1;
            transitionSet.L = i;
            if (i == 0) {
                transitionSet.M = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.a;
            if (!transitionSet.M) {
                transitionSet.start();
                this.a.M = true;
            }
        }
    }

    public TransitionSet() {
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        this.J.add(transition);
        transition.r = this;
        long j = this.c;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.N & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.N & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.N & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.N & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void c(TransitionValues transitionValues) {
        super.c(transitionValues);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).c(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (j(transitionValues.view)) {
            Iterator<Transition> it = this.J.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.j(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (j(transitionValues.view)) {
            Iterator<Transition> it = this.J.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.j(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.a.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, m mVar, m mVar2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.J.get(i);
            if (startDelay > 0 && (this.K || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, mVar, mVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void g(ViewGroup viewGroup) {
        super.g(viewGroup);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).g(viewGroup);
        }
    }

    public int getOrdering() {
        return !this.K ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.J.size()) {
            return null;
        }
        return this.J.get(i);
    }

    public int getTransitionCount() {
        return this.J.size();
    }

    @Override // androidx.transition.Transition
    public void l(boolean z) {
        this.w = z;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).l(z);
        }
    }

    @Override // androidx.transition.Transition
    public Transition m(ViewGroup viewGroup) {
        this.v = viewGroup;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).m(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public String n(String str) {
        String n = super.n(str);
        for (int i = 0; i < this.J.size(); i++) {
            StringBuilder Q = a2.b.a.a.a.Q(n, "\n");
            Q.append(this.J.get(i).n(str + "  "));
            n = Q.toString();
        }
        return n;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).pause(view);
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.J.remove(transition);
        transition.r = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.J.isEmpty()) {
            start();
            end();
            return;
        }
        b bVar = new b(this);
        Iterator<Transition> it = this.J.iterator();
        while (it.hasNext()) {
            it.next().addListener(bVar);
        }
        this.L = this.J.size();
        if (!this.K) {
            for (int i = 1; i < this.J.size(); i++) {
                this.J.get(i - 1).addListener(new a(this, this.J.get(i)));
            }
            Transition transition = this.J.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.J.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.N |= 8;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    @NonNull
    public TransitionSet setOrdering(int i) {
        if (i == 0) {
            this.K = true;
        } else if (i == 1) {
            this.K = false;
        } else {
            throw new AndroidRuntimeException(a2.b.a.a.a.M2("Invalid parameter for TransitionSet ordering: ", i));
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.N |= 4;
        if (this.J != null) {
            for (int i = 0; i < this.J.size(); i++) {
                this.J.get(i).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.N |= 2;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            this.J.get(i).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition, java.lang.Object
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.J = new ArrayList<>();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            Transition clone = this.J.get(i).clone();
            transitionSet.J.add(clone);
            clone.r = transitionSet;
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.c >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList<Transition> arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.J.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.J.size(); i2++) {
            this.J.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.i);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.J.size(); i2++) {
            this.J.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i) {
        for (int i2 = 0; i2 < this.J.size(); i2++) {
            this.J.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i = 0; i < this.J.size(); i++) {
            this.J.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
