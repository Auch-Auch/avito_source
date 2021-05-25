package com.facebook.fresco.ui.common;

import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    public final List<ControllerListener2<I>> b = new ArrayList(2);

    public synchronized void addListener(ControllerListener2<I> controllerListener2) {
        this.b.add(controllerListener2);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.b.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.onFailure(str, th, extras);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String str, @Nullable I i, ControllerListener2.Extras extras) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2<I> controllerListener2 = this.b.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.onFinalImageSet(str, i, extras);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String str, ControllerListener2.Extras extras) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.b.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.onRelease(str, extras);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String str, Object obj, ControllerListener2.Extras extras) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.b.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.onSubmit(str, obj, extras);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    public synchronized void removeAllListeners() {
        this.b.clear();
    }

    public synchronized void removeListener(ControllerListener2<I> controllerListener2) {
        int indexOf = this.b.indexOf(controllerListener2);
        if (indexOf != -1) {
            this.b.set(indexOf, null);
        }
    }
}
