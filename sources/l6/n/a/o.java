package l6.n.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
public class o {
    public final i a;
    @NonNull
    public final Fragment b;
    public int c = -1;

    public o(@NonNull i iVar, @NonNull Fragment fragment) {
        this.a = iVar;
        this.b = fragment;
    }

    public void a(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.b.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.b;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.b;
            fragment2.mTargetWho = fragment2.mSavedFragmentState.getString("android:target_state");
            Fragment fragment3 = this.b;
            if (fragment3.mTargetWho != null) {
                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment4 = this.b;
            Boolean bool = fragment4.mSavedUserVisibleHint;
            if (bool != null) {
                fragment4.mUserVisibleHint = bool.booleanValue();
                this.b.mSavedUserVisibleHint = null;
            } else {
                fragment4.mUserVisibleHint = fragment4.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment5 = this.b;
            if (!fragment5.mUserVisibleHint) {
                fragment5.mDeferStart = true;
            }
        }
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        this.b.performSaveInstanceState(bundle);
        this.a.j(this.b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.b.mView != null) {
            c();
        }
        if (this.b.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.b.mSavedViewState);
        }
        if (!this.b.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.b.mUserVisibleHint);
        }
        return bundle;
    }

    public void c() {
        if (this.b.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.b.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.b.mSavedViewState = sparseArray;
            }
        }
    }

    public o(@NonNull i iVar, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull n nVar) {
        this.a = iVar;
        Fragment instantiate = fragmentFactory.instantiate(classLoader, nVar.a);
        this.b = instantiate;
        Bundle bundle = nVar.j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(nVar.j);
        instantiate.mWho = nVar.b;
        instantiate.mFromLayout = nVar.c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = nVar.d;
        instantiate.mContainerId = nVar.e;
        instantiate.mTag = nVar.f;
        instantiate.mRetainInstance = nVar.g;
        instantiate.mRemoving = nVar.h;
        instantiate.mDetached = nVar.i;
        instantiate.mHidden = nVar.k;
        instantiate.mMaxState = Lifecycle.State.values()[nVar.l];
        Bundle bundle2 = nVar.m;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.L(2)) {
            String str = "Instantiated fragment " + instantiate;
        }
    }

    public o(@NonNull i iVar, @NonNull Fragment fragment, @NonNull n nVar) {
        this.a = iVar;
        this.b = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = nVar.m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
