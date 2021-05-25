package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class Scene {
    public Context a;
    public int b = -1;
    public ViewGroup c;
    public View d;
    public Runnable e;
    public Runnable f;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i, @NonNull Context context) {
        int i2 = R.id.transition_scene_layoutid_cache;
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(i2);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(i2, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i, context);
        sparseArray.put(i, scene2);
        return scene2;
    }

    public void enter() {
        if (this.b > 0 || this.d != null) {
            getSceneRoot().removeAllViews();
            if (this.b > 0) {
                LayoutInflater.from(this.a).inflate(this.b, this.c);
            } else {
                this.c.addView(this.d);
            }
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            runnable.run();
        }
        this.c.setTag(R.id.transition_current_scene, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.c) == this && (runnable = this.f) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.c;
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.e = runnable;
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.f = runnable;
    }

    public Scene(ViewGroup viewGroup, int i, Context context) {
        this.a = context;
        this.c = viewGroup;
        this.b = i;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.c = viewGroup;
        this.d = view;
    }
}
