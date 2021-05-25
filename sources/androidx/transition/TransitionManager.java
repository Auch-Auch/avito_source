package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
public class TransitionManager {
    public static Transition c = new AutoTransition();
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> d = new ThreadLocal<>();
    public static ArrayList<ViewGroup> e = new ArrayList<>();
    public ArrayMap<Scene, Transition> a = new ArrayMap<>();
    public ArrayMap<Scene, ArrayMap<Scene, Transition>> b = new ArrayMap<>();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public Transition a;
        public ViewGroup b;

        /* renamed from: androidx.transition.TransitionManager$a$a  reason: collision with other inner class name */
        public class C0124a extends TransitionListenerAdapter {
            public final /* synthetic */ ArrayMap a;

            public C0124a(ArrayMap arrayMap) {
                this.a = arrayMap;
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ((ArrayList) this.a.get(a.this.b)).remove(transition);
                transition.removeListener(this);
            }
        }

        public a(Transition transition, ViewGroup viewGroup) {
            this.a = transition;
            this.b = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x024a  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x01ef A[EDGE_INSN: B:134:0x01ef->B:88:0x01ef ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01f6  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0219  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onPreDraw() {
            /*
            // Method dump skipped, instructions count: 699
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionManager.a.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
            TransitionManager.e.remove(this.b);
            ArrayList<Transition> arrayList = TransitionManager.b().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.b);
                }
            }
            this.a.e(true);
        }
    }

    public static void a(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (!e.contains(sceneRoot)) {
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (transition == null) {
                if (currentScene != null) {
                    currentScene.exit();
                }
                scene.enter();
                return;
            }
            e.add(sceneRoot);
            Transition clone = transition.clone();
            clone.m(sceneRoot);
            if (currentScene != null) {
                if (currentScene.b > 0) {
                    clone.l(true);
                }
            }
            c(sceneRoot, clone);
            scene.enter();
            if (sceneRoot != null) {
                a aVar = new a(clone, sceneRoot);
                sceneRoot.addOnAttachStateChangeListener(aVar);
                sceneRoot.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> b() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = d.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        d.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.d(viewGroup, true);
        }
        Scene currentScene = Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        e.remove(viewGroup);
        ArrayList<Transition> arrayList = b().get(viewGroup);
        if (!(arrayList == null || arrayList.isEmpty())) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).g(viewGroup);
            }
        }
    }

    public static void go(@NonNull Scene scene) {
        a(scene, c);
    }

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.a.put(scene, transition);
    }

    public void transitionTo(@NonNull Scene scene) {
        Transition transition;
        Scene currentScene;
        ArrayMap<Scene, Transition> arrayMap;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if ((sceneRoot == null || (currentScene = Scene.getCurrentScene(sceneRoot)) == null || (arrayMap = this.b.get(scene)) == null || (transition = arrayMap.get(currentScene)) == null) && (transition = this.a.get(scene)) == null) {
            transition = c;
        }
        a(scene, transition);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!e.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            e.add(viewGroup);
            if (transition == null) {
                transition = c;
            }
            Transition clone = transition.clone();
            c(viewGroup, clone);
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (clone != null) {
                a aVar = new a(clone, viewGroup);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        a(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap<Scene, Transition> arrayMap = this.b.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap<>();
            this.b.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }
}
