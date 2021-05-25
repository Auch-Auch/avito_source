package l6.n.a;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class w {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final FragmentTransitionImpl b = new x();
    public static final FragmentTransitionImpl c;

    public interface a {
    }

    public static class b {
        public Fragment a;
        public boolean b;
        public a c;
        public Fragment d;
        public boolean e;
        public a f;
    }

    static {
        FragmentTransitionImpl fragmentTransitionImpl;
        try {
            fragmentTransitionImpl = (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            fragmentTransitionImpl = null;
        }
        c = fragmentTransitionImpl;
    }

    public static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0038, code lost:
        if (r0.mAdded != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0076, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0088, code lost:
        if (r0.mHidden == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008a, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00e6 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(l6.n.a.a r8, androidx.fragment.app.FragmentTransaction.a r9, android.util.SparseArray<l6.n.a.w.b> r10, boolean r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.n.a.w.b(l6.n.a.a, androidx.fragment.app.FragmentTransaction$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback sharedElementCallback;
        int i;
        if (z) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    public static boolean d(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static ArrayMap<String, View> e(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, b bVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String i;
        Fragment fragment = bVar.a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.c(arrayMap2, view);
        a aVar = bVar.c;
        if (bVar.b) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = aVar.p;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar.q;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback == null) {
            int size = arrayMap.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                    arrayMap.removeAt(size);
                }
            }
        } else {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                String str = arrayList.get(size2);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String i2 = i(arrayMap, str);
                    if (i2 != null) {
                        arrayMap.remove(i2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (i = i(arrayMap, str)) != null) {
                    arrayMap.put(i, ViewCompat.getTransitionName(view2));
                }
            }
        }
        return arrayMap2;
    }

    public static ArrayMap<String, View> f(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, b bVar) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = bVar.d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.c(arrayMap2, fragment.requireView());
        a aVar = bVar.f;
        if (bVar.e) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar.q;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = aVar.p;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    public static FragmentTransitionImpl g(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = b;
        if (fragmentTransitionImpl != null && d(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = c;
        if (fragmentTransitionImpl2 != null && d(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> h(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    public static String i(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    public static Object j(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    public static Object k(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    public static View l(ArrayMap<String, View> arrayMap, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        a aVar = bVar.c;
        if (obj == null || arrayMap == null || (arrayList = aVar.p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar.p.get(0);
        } else {
            str = aVar.q.get(0);
        }
        return arrayMap.get(str);
    }

    public static Object m(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(obj));
    }

    public static Object n(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    public static void o(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.p;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar.q.get(0);
            } else {
                str = aVar.p.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    public static void p(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0498 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0248 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void q(androidx.fragment.app.FragmentManager r39, java.util.ArrayList<l6.n.a.a> r40, java.util.ArrayList<java.lang.Boolean> r41, int r42, int r43, boolean r44, l6.n.a.w.a r45) {
        /*
        // Method dump skipped, instructions count: 1197
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.n.a.w.q(androidx.fragment.app.FragmentManager, java.util.ArrayList, java.util.ArrayList, int, int, boolean, l6.n.a.w$a):void");
    }
}
