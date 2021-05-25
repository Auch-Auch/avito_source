package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;
public class MultiDraweeHolder<DH extends DraweeHierarchy> {
    @VisibleForTesting
    public boolean a = false;
    @VisibleForTesting
    public ArrayList<DraweeHolder<DH>> b = new ArrayList<>();

    public void add(DraweeHolder<DH> draweeHolder) {
        add(this.b.size(), draweeHolder);
    }

    public void clear() {
        if (this.a) {
            for (int i = 0; i < this.b.size(); i++) {
                this.b.get(i).onDetach();
            }
        }
        this.b.clear();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < this.b.size(); i++) {
            Drawable topLevelDrawable = get(i).getTopLevelDrawable();
            if (topLevelDrawable != null) {
                topLevelDrawable.draw(canvas);
            }
        }
    }

    public DraweeHolder<DH> get(int i) {
        return this.b.get(i);
    }

    public void onAttach() {
        if (!this.a) {
            this.a = true;
            for (int i = 0; i < this.b.size(); i++) {
                this.b.get(i).onAttach();
            }
        }
    }

    public void onDetach() {
        if (this.a) {
            this.a = false;
            for (int i = 0; i < this.b.size(); i++) {
                this.b.get(i).onDetach();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < this.b.size(); i++) {
            if (this.b.get(i).onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int i) {
        DraweeHolder<DH> draweeHolder = this.b.get(i);
        if (this.a) {
            draweeHolder.onDetach();
        }
        this.b.remove(i);
    }

    public int size() {
        return this.b.size();
    }

    public boolean verifyDrawable(Drawable drawable) {
        for (int i = 0; i < this.b.size(); i++) {
            if (drawable == get(i).getTopLevelDrawable()) {
                return true;
            }
        }
        return false;
    }

    public void add(int i, DraweeHolder<DH> draweeHolder) {
        Preconditions.checkNotNull(draweeHolder);
        Preconditions.checkElementIndex(i, this.b.size() + 1);
        this.b.add(i, draweeHolder);
        if (this.a) {
            draweeHolder.onAttach();
        }
    }
}
