package androidx.navigation.fragment;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
@Navigator.Name("dialog")
public final class DialogFragmentNavigator extends Navigator<Destination> {
    public final Context a;
    public final FragmentManager b;
    public int c = 0;
    public LifecycleEventObserver d = new LifecycleEventObserver(this) { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP) {
                DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
                if (!dialogFragment.requireDialog().isShowing()) {
                    NavHostFragment.findNavController(dialogFragment).popBackStack();
                }
            }
        }
    };

    @NavDestination.ClassType(DialogFragment.class)
    public static class Destination extends NavDestination implements FloatingWindow {
        public String j;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this(navigatorProvider.getNavigator(DialogFragmentNavigator.class));
        }

        @NonNull
        public final String getClassName() {
            String str = this.j;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }

        @NonNull
        public final Destination setClassName(@NonNull String str) {
            this.j = str;
            return this;
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }
    }

    public DialogFragmentNavigator(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        this.a = context;
        this.b = fragmentManager;
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i = 0; i < this.c; i++) {
                FragmentManager fragmentManager = this.b;
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag("androidx-nav-fragment:navigator:dialog:" + i);
                if (dialogFragment != null) {
                    dialogFragment.getLifecycle().addObserver(this.d);
                } else {
                    throw new IllegalStateException(a.Q2("DialogFragment ", i, " doesn't exist in the FragmentManager"));
                }
            }
        }
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public Bundle onSaveState() {
        if (this.c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.c);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        if (this.c == 0 || this.b.isStateSaved()) {
            return false;
        }
        FragmentManager fragmentManager = this.b;
        StringBuilder L = a.L("androidx-nav-fragment:navigator:dialog:");
        int i = this.c - 1;
        this.c = i;
        L.append(i);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(L.toString());
        if (findFragmentByTag != null) {
            findFragmentByTag.getLifecycle().removeObserver(this.d);
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    @Nullable
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        if (this.b.isStateSaved()) {
            return null;
        }
        String className = destination.getClassName();
        if (className.charAt(0) == '.') {
            className = this.a.getPackageName() + className;
        }
        Fragment instantiate = this.b.getFragmentFactory().instantiate(this.a.getClassLoader(), className);
        if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) instantiate;
            dialogFragment.setArguments(bundle);
            dialogFragment.getLifecycle().addObserver(this.d);
            FragmentManager fragmentManager = this.b;
            StringBuilder L = a.L("androidx-nav-fragment:navigator:dialog:");
            int i = this.c;
            this.c = i + 1;
            L.append(i);
            dialogFragment.show(fragmentManager, L.toString());
            return destination;
        }
        StringBuilder L2 = a.L("Dialog destination ");
        L2.append(destination.getClassName());
        L2.append(" is not an instance of DialogFragment");
        throw new IllegalArgumentException(L2.toString());
    }
}
