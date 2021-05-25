package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
@BindingMethods({@BindingMethod(attribute = "android:alwaysDrawnWithCache", method = "setAlwaysDrawnWithCacheEnabled", type = ViewGroup.class), @BindingMethod(attribute = "android:animationCache", method = "setAnimationCacheEnabled", type = ViewGroup.class), @BindingMethod(attribute = "android:splitMotionEvents", method = "setMotionEventSplittingEnabled", type = ViewGroup.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ViewGroupBindingAdapter {

    public interface OnAnimationEnd {
        void onAnimationEnd(Animation animation);
    }

    public interface OnAnimationRepeat {
        void onAnimationRepeat(Animation animation);
    }

    public interface OnAnimationStart {
        void onAnimationStart(Animation animation);
    }

    public interface OnChildViewAdded {
        void onChildViewAdded(View view, View view2);
    }

    public interface OnChildViewRemoved {
        void onChildViewRemoved(View view, View view2);
    }

    public static class a implements ViewGroup.OnHierarchyChangeListener {
        public final /* synthetic */ OnChildViewAdded a;
        public final /* synthetic */ OnChildViewRemoved b;

        public a(OnChildViewAdded onChildViewAdded, OnChildViewRemoved onChildViewRemoved) {
            this.a = onChildViewAdded;
            this.b = onChildViewRemoved;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            OnChildViewAdded onChildViewAdded = this.a;
            if (onChildViewAdded != null) {
                onChildViewAdded.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            OnChildViewRemoved onChildViewRemoved = this.b;
            if (onChildViewRemoved != null) {
                onChildViewRemoved.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class b implements Animation.AnimationListener {
        public final /* synthetic */ OnAnimationStart a;
        public final /* synthetic */ OnAnimationEnd b;
        public final /* synthetic */ OnAnimationRepeat c;

        public b(OnAnimationStart onAnimationStart, OnAnimationEnd onAnimationEnd, OnAnimationRepeat onAnimationRepeat) {
            this.a = onAnimationStart;
            this.b = onAnimationEnd;
            this.c = onAnimationRepeat;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            OnAnimationEnd onAnimationEnd = this.b;
            if (onAnimationEnd != null) {
                onAnimationEnd.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            OnAnimationRepeat onAnimationRepeat = this.c;
            if (onAnimationRepeat != null) {
                onAnimationRepeat.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            OnAnimationStart onAnimationStart = this.a;
            if (onAnimationStart != null) {
                onAnimationStart.onAnimationStart(animation);
            }
        }
    }

    @BindingAdapter({"android:animateLayoutChanges"})
    @TargetApi(11)
    public static void setAnimateLayoutChanges(ViewGroup viewGroup, boolean z) {
        if (z) {
            viewGroup.setLayoutTransition(new LayoutTransition());
        } else {
            viewGroup.setLayoutTransition(null);
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onChildViewAdded", "android:onChildViewRemoved"})
    public static void setListener(ViewGroup viewGroup, OnChildViewAdded onChildViewAdded, OnChildViewRemoved onChildViewRemoved) {
        if (onChildViewAdded == null && onChildViewRemoved == null) {
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            viewGroup.setOnHierarchyChangeListener(new a(onChildViewAdded, onChildViewRemoved));
        }
    }

    @BindingAdapter(requireAll = false, value = {"android:onAnimationStart", "android:onAnimationEnd", "android:onAnimationRepeat"})
    public static void setListener(ViewGroup viewGroup, OnAnimationStart onAnimationStart, OnAnimationEnd onAnimationEnd, OnAnimationRepeat onAnimationRepeat) {
        if (onAnimationStart == null && onAnimationEnd == null && onAnimationRepeat == null) {
            viewGroup.setLayoutAnimationListener(null);
        } else {
            viewGroup.setLayoutAnimationListener(new b(onAnimationStart, onAnimationEnd, onAnimationRepeat));
        }
    }
}
