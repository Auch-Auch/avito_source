package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class SupportRequestManagerFragment extends Fragment {
    public final a2.d.a.e.a a;
    public final RequestManagerTreeNode b;
    public final Set<SupportRequestManagerFragment> c;
    @Nullable
    public SupportRequestManagerFragment d;
    @Nullable
    public RequestManager e;
    @Nullable
    public Fragment f;

    public class a implements RequestManagerTreeNode {
        public a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> a3 = SupportRequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(a3.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : a3) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new a2.d.a.e.a());
    }

    @NonNull
    public Set<SupportRequestManagerFragment> a() {
        boolean z;
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.d.a()) {
            Fragment b2 = supportRequestManagerFragment2.b();
            Fragment b3 = b();
            while (true) {
                Fragment parentFragment = b2.getParentFragment();
                if (parentFragment == null) {
                    z = false;
                    break;
                } else if (parentFragment.equals(b3)) {
                    z = true;
                    break;
                } else {
                    b2 = b2.getParentFragment();
                }
            }
            if (z) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Nullable
    public final Fragment b() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    public final void c(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        d();
        RequestManagerRetriever requestManagerRetriever = Glide.get(context).getRequestManagerRetriever();
        Objects.requireNonNull(requestManagerRetriever);
        SupportRequestManagerFragment f2 = requestManagerRetriever.f(fragmentManager, null, RequestManagerRetriever.g(context));
        this.d = f2;
        if (!equals(f2)) {
            this.d.c.add(this);
        }
    }

    public final void d() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.c.remove(this);
            this.d = null;
        }
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.e;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            c(getContext(), fragmentManager);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.a();
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.c();
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.e = requestManager;
    }

    @Override // androidx.fragment.app.Fragment, java.lang.Object
    public String toString() {
        return super.toString() + "{parent=" + b() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull a2.d.a.e.a aVar) {
        this.b = new a();
        this.c = new HashSet();
        this.a = aVar;
    }
}
