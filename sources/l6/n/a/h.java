package l6.n.a;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentHostCallback;
import androidx.fragment.app.FragmentManager;
public class h implements LayoutInflater.Factory2 {
    public final FragmentManager a;

    public h(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        boolean z;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            ClassLoader classLoader = context.getClassLoader();
            SimpleArrayMap<String, Class<?>> simpleArrayMap = FragmentFactory.a;
            int i = 0;
            try {
                SimpleArrayMap<String, Class<?>> simpleArrayMap2 = FragmentFactory.a;
                Class<?> cls = simpleArrayMap2.get(attributeValue);
                if (cls == null) {
                    cls = Class.forName(attributeValue, false, classLoader);
                    simpleArrayMap2.put(attributeValue, cls);
                }
                z = Fragment.class.isAssignableFrom(cls);
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                if (view != null) {
                    i = view.getId();
                }
                if (i == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                if (resourceId != -1) {
                    fragment = this.a.findFragmentById(resourceId);
                }
                if (fragment == null && string != null) {
                    fragment = this.a.findFragmentByTag(string);
                }
                if (fragment == null && i != -1) {
                    fragment = this.a.findFragmentById(i);
                }
                if (FragmentManager.L(2)) {
                    StringBuilder L = a.L("onCreateView: id=0x");
                    L.append(Integer.toHexString(resourceId));
                    L.append(" fname=");
                    L.append(attributeValue);
                    L.append(" existing=");
                    L.append(fragment);
                    L.toString();
                }
                if (fragment == null) {
                    fragment = this.a.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                    fragment.mFromLayout = true;
                    fragment.mFragmentId = resourceId != 0 ? resourceId : i;
                    fragment.mContainerId = i;
                    fragment.mTag = string;
                    fragment.mInLayout = true;
                    FragmentManager fragmentManager = this.a;
                    fragment.mFragmentManager = fragmentManager;
                    FragmentHostCallback<?> fragmentHostCallback = fragmentManager.o;
                    fragment.mHost = fragmentHostCallback;
                    fragment.onInflate(fragmentHostCallback.b, attributeSet, fragment.mSavedFragmentState);
                    this.a.b(fragment);
                    FragmentManager fragmentManager2 = this.a;
                    fragmentManager2.R(fragment, fragmentManager2.n);
                } else if (!fragment.mInLayout) {
                    fragment.mInLayout = true;
                    FragmentHostCallback<?> fragmentHostCallback2 = this.a.o;
                    fragment.mHost = fragmentHostCallback2;
                    fragment.onInflate(fragmentHostCallback2.b, attributeSet, fragment.mSavedFragmentState);
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
                }
                FragmentManager fragmentManager3 = this.a;
                int i2 = fragmentManager3.n;
                if (i2 >= 1 || !fragment.mFromLayout) {
                    fragmentManager3.R(fragment, i2);
                } else {
                    fragmentManager3.R(fragment, 1);
                }
                View view2 = fragment.mView;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.mView.getTag() == null) {
                        fragment.mView.setTag(string);
                    }
                    return fragment.mView;
                }
                throw new IllegalStateException(a.e3("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }
}
