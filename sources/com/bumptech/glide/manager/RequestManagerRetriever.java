package com.bumptech.glide.manager;

import a2.d.a.e.b;
import a2.d.a.e.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
public class RequestManagerRetriever implements Handler.Callback {
    public static final RequestManagerFactory i = new a();
    public volatile RequestManager a;
    @VisibleForTesting
    public final Map<FragmentManager, RequestManagerFragment> b = new HashMap();
    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> c = new HashMap();
    public final Handler d;
    public final RequestManagerFactory e;
    public final ArrayMap<View, Fragment> f = new ArrayMap<>();
    public final ArrayMap<View, android.app.Fragment> g = new ArrayMap<>();
    public final Bundle h = new Bundle();

    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public class a implements RequestManagerFactory {
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        @NonNull
        public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        this.e = requestManagerFactory == null ? i : requestManagerFactory;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    @Nullable
    public static Activity a(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void c(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment fragment : collection) {
                if (!(fragment == null || fragment.getView() == null)) {
                    map.put(fragment.getView(), fragment);
                    c(fragment.getChildFragmentManager().getFragments(), map);
                }
            }
        }
    }

    public static boolean g(Context context) {
        Activity a3 = a(context);
        return a3 == null || !a3.isFinishing();
    }

    @TargetApi(26)
    @Deprecated
    public final void b(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    b(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.h.putInt("key", i2);
            android.app.Fragment fragment2 = null;
            try {
                fragment2 = fragmentManager.getFragment(this.h, "key");
            } catch (Exception unused) {
            }
            if (fragment2 != null) {
                if (fragment2.getView() != null) {
                    arrayMap.put(fragment2.getView(), fragment2);
                    b(fragment2.getChildFragmentManager(), arrayMap);
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    @NonNull
    @Deprecated
    public final RequestManager d(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment e2 = e(fragmentManager, fragment, z);
        RequestManager requestManager = e2.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.e.build(Glide.get(context), e2.a, e2.getRequestManagerTreeNode(), context);
        e2.setRequestManager(build);
        return build;
    }

    @NonNull
    public final RequestManagerFragment e(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.c(fragment);
            if (z) {
                requestManagerFragment.a.b();
            }
            this.b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    public final SupportRequestManagerFragment f(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.f = fragment;
            if (!(fragment == null || fragment.getContext() == null)) {
                Fragment fragment2 = fragment;
                while (fragment2.getParentFragment() != null) {
                    fragment2 = fragment2.getParentFragment();
                }
                androidx.fragment.app.FragmentManager fragmentManager2 = fragment2.getFragmentManager();
                if (fragmentManager2 != null) {
                    supportRequestManagerFragment.c(fragment.getContext(), fragmentManager2);
                }
            }
            if (z) {
                supportRequestManagerFragment.a.b();
            }
            this.c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return get(contextWrapper.getBaseContext());
                    }
                }
            }
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = this.e.build(Glide.get(context.getApplicationContext()), new b(), new d(), context.getApplicationContext());
                    }
                }
            }
            return this.a;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public final RequestManager h(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment f2 = f(fragmentManager, fragment, z);
        RequestManager requestManager = f2.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager build = this.e.build(Glide.get(context), f2.a, f2.getRequestManagerTreeNode(), context);
        f2.setRequestManager(build);
        return build;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2 = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i2 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.b.remove(obj3);
        } else if (i2 != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                String str = "Failed to remove expected request manager fragment, manager: " + obj;
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.c.remove(obj3);
        }
        obj4 = obj2;
        obj = obj3;
        String str = "Failed to remove expected request manager fragment, manager: " + obj;
        return z;
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        if (!fragmentActivity.isDestroyed()) {
            return h(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, g(fragmentActivity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @NonNull
    public RequestManager get(@NonNull Fragment fragment) {
        Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        return h(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager get(@NonNull Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        if (!activity.isDestroyed()) {
            return d(activity, activity.getFragmentManager(), null, g(activity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @NonNull
    public RequestManager get(@NonNull View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity a3 = a(view.getContext());
        if (a3 == null) {
            return get(view.getContext().getApplicationContext());
        }
        android.app.Fragment fragment = null;
        Fragment fragment2 = null;
        if (a3 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) a3;
            this.f.clear();
            c(fragmentActivity.getSupportFragmentManager().getFragments(), this.f);
            View findViewById = fragmentActivity.findViewById(16908290);
            while (!view.equals(findViewById) && (fragment2 = this.f.get(view)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            this.f.clear();
            return fragment2 != null ? get(fragment2) : get(fragmentActivity);
        }
        this.g.clear();
        b(a3.getFragmentManager(), this.g);
        View findViewById2 = a3.findViewById(16908290);
        while (!view.equals(findViewById2) && (fragment = this.g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.g.clear();
        if (fragment == null) {
            return get(a3);
        }
        return get(fragment);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager get(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            return d(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }
}
