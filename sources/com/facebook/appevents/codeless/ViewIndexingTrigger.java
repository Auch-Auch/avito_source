package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@AutoHandleExceptions
public class ViewIndexingTrigger implements SensorEventListener {
    public OnShakeListener a;

    public interface OnShakeListener {
        void onShake();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.a != null) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (fArr[1] / 9.80665f);
            double d3 = (double) (fArr[2] / 9.80665f);
            if (Math.sqrt((d3 * d3) + (d2 * d2) + (d * d)) > 2.299999952316284d) {
                this.a.onShake();
            }
        }
    }
}
