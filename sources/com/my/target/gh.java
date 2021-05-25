package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
public class gh extends View {
    @Nullable
    public a a;
    @NonNull
    public final b b = new b();

    public interface a {
        void h(boolean z);
    }

    public static class b {
        public boolean a;
        public boolean b;

        public boolean a() {
            return this.a && this.b;
        }
    }

    public gh(Context context) {
        super(context);
    }

    public final void a(boolean z) {
        a aVar;
        boolean z2;
        b bVar = this.b;
        bVar.a = z;
        bVar.b = hasWindowFocus();
        if (this.b.a()) {
            aVar = this.a;
            if (aVar != null) {
                z2 = true;
            } else {
                return;
            }
        } else if (!z && (aVar = this.a) != null) {
            z2 = false;
        } else {
            return;
        }
        aVar.h(z2);
    }

    public boolean ef() {
        return this.b.a();
    }

    @NonNull
    @VisibleForTesting
    public b getViewabilityState() {
        return this.b;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(1, 1);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        a aVar;
        boolean z2;
        super.onWindowFocusChanged(z);
        b bVar = this.b;
        bVar.b = z;
        if (bVar.a()) {
            aVar = this.a;
            if (aVar != null) {
                z2 = true;
            } else {
                return;
            }
        } else if (!z && (aVar = this.a) != null) {
            z2 = false;
        } else {
            return;
        }
        aVar.h(z2);
    }

    public void setViewabilityListener(@Nullable a aVar) {
        this.a = aVar;
    }
}
