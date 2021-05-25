package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Deprecated
public class RequestManagerFragment extends Fragment {
    public final a2.d.a.e.a a;
    public final RequestManagerTreeNode b = new a();
    public final Set<RequestManagerFragment> c = new HashSet();
    @Nullable
    public RequestManager d;
    @Nullable
    public RequestManagerFragment e;
    @Nullable
    public Fragment f;

    public class a implements RequestManagerTreeNode {
        public a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> a3 = RequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(a3.size());
            for (RequestManagerFragment requestManagerFragment : a3) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        a2.d.a.e.a aVar = new a2.d.a.e.a();
        this.a = aVar;
    }

    @NonNull
    @TargetApi(17)
    public Set<RequestManagerFragment> a() {
        boolean z;
        if (equals(this.e)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.e.a()) {
            Fragment parentFragment = requestManagerFragment.getParentFragment();
            Fragment parentFragment2 = getParentFragment();
            while (true) {
                Fragment parentFragment3 = parentFragment.getParentFragment();
                if (parentFragment3 == null) {
                    z = false;
                    break;
                } else if (parentFragment3.equals(parentFragment2)) {
                    z = true;
                    break;
                } else {
                    parentFragment = parentFragment.getParentFragment();
                }
            }
            if (z) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final void b(@NonNull Activity activity) {
        d();
        RequestManagerRetriever requestManagerRetriever = Glide.get(activity).getRequestManagerRetriever();
        Objects.requireNonNull(requestManagerRetriever);
        RequestManagerFragment e2 = requestManagerRetriever.e(activity.getFragmentManager(), null, RequestManagerRetriever.g(activity));
        this.e = e2;
        if (!equals(e2)) {
            this.e.c.add(this);
        }
    }

    public void c(@Nullable Fragment fragment) {
        this.f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            b(fragment.getActivity());
        }
    }

    public final void d() {
        RequestManagerFragment requestManagerFragment = this.e;
        if (requestManagerFragment != null) {
            requestManagerFragment.c.remove(this);
            this.e = null;
        }
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.d;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            b(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.a();
        d();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        d();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.c();
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.d = requestManager;
    }

    @Override // android.app.Fragment, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
