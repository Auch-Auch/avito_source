package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;
public final class OrientationListener implements SensorEventListener {
    public final float[] a = new float[16];
    public final float[] b = new float[16];
    public final float[] c = new float[16];
    public final float[] d = new float[3];
    public final Display e;
    public final Listener[] f;
    public boolean g;

    public interface Listener {
        void onOrientationChange(float[] fArr, float f);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.e = display;
        this.f = listenerArr;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.a, sensorEvent.values);
        float[] fArr = this.a;
        int rotation = this.e.getRotation();
        if (rotation != 0) {
            int i = 129;
            int i2 = 130;
            if (rotation == 1) {
                i = 2;
                i2 = 129;
            } else if (rotation != 2) {
                if (rotation == 3) {
                    i = 130;
                    i2 = 1;
                } else {
                    throw new IllegalStateException();
                }
            }
            float[] fArr2 = this.b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.b, i, i2, fArr);
        }
        SensorManager.remapCoordinateSystem(this.a, 1, 131, this.b);
        SensorManager.getOrientation(this.b, this.d);
        float f2 = this.d[2];
        Matrix.rotateM(this.a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr3 = this.a;
        if (!this.g) {
            FrameRotationQueue.computeRecenterMatrix(this.c, fArr3);
            this.g = true;
        }
        float[] fArr4 = this.b;
        System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
        Matrix.multiplyMM(fArr3, 0, this.b, 0, this.c, 0);
        float[] fArr5 = this.a;
        for (Listener listener : this.f) {
            listener.onOrientationChange(fArr5, f2);
        }
    }
}
