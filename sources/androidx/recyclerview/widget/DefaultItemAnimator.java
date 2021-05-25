package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l6.v.a.f;
import l6.v.a.g;
public class DefaultItemAnimator extends SimpleItemAnimator {
    public static TimeInterpolator s;
    public ArrayList<RecyclerView.ViewHolder> h = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> i = new ArrayList<>();
    public ArrayList<e> j = new ArrayList<>();
    public ArrayList<d> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> l = new ArrayList<>();
    public ArrayList<ArrayList<e>> m = new ArrayList<>();
    public ArrayList<ArrayList<d>> n = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> o = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> p = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> q = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> r = new ArrayList<>();

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                RecyclerView.ViewHolder viewHolder = eVar.a;
                int i = eVar.b;
                int i2 = eVar.c;
                int i3 = eVar.d;
                int i4 = eVar.e;
                Objects.requireNonNull(defaultItemAnimator);
                View view = viewHolder.itemView;
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (i5 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i6 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                defaultItemAnimator.p.add(viewHolder);
                animate.setDuration(defaultItemAnimator.getMoveDuration()).setListener(new l6.v.a.e(defaultItemAnimator, viewHolder, i5, view, i6, animate)).start();
            }
            this.a.clear();
            DefaultItemAnimator.this.m.remove(this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                Objects.requireNonNull(defaultItemAnimator);
                RecyclerView.ViewHolder viewHolder = dVar.a;
                View view2 = null;
                if (viewHolder == null) {
                    view = null;
                } else {
                    view = viewHolder.itemView;
                }
                RecyclerView.ViewHolder viewHolder2 = dVar.b;
                if (viewHolder2 != null) {
                    view2 = viewHolder2.itemView;
                }
                if (view != null) {
                    ViewPropertyAnimator duration = view.animate().setDuration(defaultItemAnimator.getChangeDuration());
                    defaultItemAnimator.r.add(dVar.a);
                    duration.translationX((float) (dVar.e - dVar.c));
                    duration.translationY((float) (dVar.f - dVar.d));
                    duration.alpha(0.0f).setListener(new f(defaultItemAnimator, dVar, duration, view)).start();
                }
                if (view2 != null) {
                    ViewPropertyAnimator animate = view2.animate();
                    defaultItemAnimator.r.add(dVar.b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(defaultItemAnimator.getChangeDuration()).alpha(1.0f).setListener(new g(defaultItemAnimator, dVar, animate, view2)).start();
                }
            }
            this.a.clear();
            DefaultItemAnimator.this.n.remove(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
                DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                Objects.requireNonNull(defaultItemAnimator);
                View view = viewHolder.itemView;
                ViewPropertyAnimator animate = view.animate();
                defaultItemAnimator.o.add(viewHolder);
                animate.alpha(1.0f).setDuration(defaultItemAnimator.getAddDuration()).setListener(new l6.v.a.d(defaultItemAnimator, viewHolder, view, animate)).start();
            }
            this.a.clear();
            DefaultItemAnimator.this.l.remove(this.a);
        }
    }

    public static class d {
        public RecyclerView.ViewHolder a;
        public RecyclerView.ViewHolder b;
        public int c;
        public int d;
        public int e;
        public int f;

        public d(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this.a = viewHolder;
            this.b = viewHolder2;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ChangeInfo{oldHolder=");
            L.append(this.a);
            L.append(", newHolder=");
            L.append(this.b);
            L.append(", fromX=");
            L.append(this.c);
            L.append(", fromY=");
            L.append(this.d);
            L.append(", toX=");
            L.append(this.e);
            L.append(", toY=");
            return a2.b.a.a.a.i(L, this.f, '}');
        }
    }

    public static class e {
        public RecyclerView.ViewHolder a;
        public int b;
        public int c;
        public int d;
        public int e;

        public e(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.a = viewHolder;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateAdd */
    public boolean mo732animateAdd(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.i.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return mo733animateMove(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        f(viewHolder);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            f(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i6));
            viewHolder2.itemView.setTranslationY((float) (-i7));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.k.add(new d(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateMove */
    public boolean mo733animateMove(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        f(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.j.add(new e(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: animateRemove */
    public boolean mo734animateRemove(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
        this.h.add(viewHolder);
        return true;
    }

    public void b(List<RecyclerView.ViewHolder> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                list.get(size).itemView.animate().cancel();
            } else {
                return;
            }
        }
    }

    public void c() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    public final void d(List<d> list, RecyclerView.ViewHolder viewHolder) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = list.get(size);
                if (e(dVar, viewHolder) && dVar.a == null && dVar.b == null) {
                    list.remove(dVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean e(d dVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (dVar.b == viewHolder) {
            dVar.b = null;
        } else if (dVar.a != viewHolder) {
            return false;
        } else {
            dVar.a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.j.remove(size);
            }
        }
        d(this.k, viewHolder);
        if (this.h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<d> arrayList = this.n.get(size2);
            d(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<e> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(viewHolder);
        this.o.remove(viewHolder);
        this.r.remove(viewHolder);
        this.p.remove(viewHolder);
        c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = this.j.get(size);
            View view = eVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(eVar.a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            dispatchRemoveFinished(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.i.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = this.k.get(size4);
            RecyclerView.ViewHolder viewHolder2 = dVar.a;
            if (viewHolder2 != null) {
                e(dVar, viewHolder2);
            }
            RecyclerView.ViewHolder viewHolder3 = dVar.b;
            if (viewHolder3 != null) {
                e(dVar, viewHolder3);
            }
        }
        this.k.clear();
        if (isRunning()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList<e> arrayList = this.m.get(size5);
                int size6 = arrayList.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        e eVar2 = arrayList.get(size6);
                        View view2 = eVar2.a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        dispatchMoveFinished(eVar2.a);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.m.remove(arrayList);
                        }
                    }
                }
            }
            int size7 = this.l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.l.get(size7);
                int size8 = arrayList2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.ViewHolder viewHolder4 = arrayList2.get(size8);
                        viewHolder4.itemView.setAlpha(1.0f);
                        dispatchAddFinished(viewHolder4);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.l.remove(arrayList2);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList<d> arrayList3 = this.n.get(size9);
                    int size10 = arrayList3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            d dVar2 = arrayList3.get(size10);
                            RecyclerView.ViewHolder viewHolder5 = dVar2.a;
                            if (viewHolder5 != null) {
                                e(dVar2, viewHolder5);
                            }
                            RecyclerView.ViewHolder viewHolder6 = dVar2.b;
                            if (viewHolder6 != null) {
                                e(dVar2, viewHolder6);
                            }
                            if (arrayList3.isEmpty()) {
                                this.n.remove(arrayList3);
                            }
                        }
                    }
                } else {
                    b(this.q);
                    b(this.p);
                    b(this.o);
                    b(this.r);
                    dispatchAnimationsFinished();
                    return;
                }
            }
        }
    }

    public final void f(RecyclerView.ViewHolder viewHolder) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(s);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.h.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                View view = next.itemView;
                ViewPropertyAnimator animate = view.animate();
                this.q.add(next);
                animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new l6.v.a.c(this, next, animate, view)).start();
            }
            this.h.clear();
            if (z2) {
                ArrayList<e> arrayList = new ArrayList<>();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                c cVar = new c(arrayList3);
                if (z || z2 || z3) {
                    long j2 = 0;
                    long removeDuration = z ? getRemoveDuration() : 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j2 = getChangeDuration();
                    }
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, cVar, Math.max(moveDuration, j2) + removeDuration);
                    return;
                }
                cVar.run();
            }
        }
    }
}
