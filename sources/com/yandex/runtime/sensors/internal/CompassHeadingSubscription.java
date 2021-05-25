package com.yandex.runtime.sensors.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.Runtime;
public class CompassHeadingSubscription implements SensorEventListener {
    private static final String LOG_TAG = CompassHeadingSubscription.class.getCanonicalName();
    private static final boolean compassAvailable = checkCompassAvailable();
    private float[] gravityData = new float[3];
    private float[] iMatrix = new float[16];
    private float[] magneticData = new float[3];
    private SensorManager manager;
    private NativeObject nativeObject;
    private float[] orientation = new float[3];
    private float[] rMatrix = new float[16];

    public CompassHeadingSubscription(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
        this.manager = getSensorManager();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.CompassHeadingSubscription.1
            @Override // java.lang.Runnable
            public void run() {
                CompassHeadingSubscription.this.start();
            }
        });
    }

    private static boolean checkCompassAvailable() {
        SensorManager sensorManager = getSensorManager();
        if (sensorManager.getDefaultSensor(1) == null || sensorManager.getDefaultSensor(2) == null) {
            return false;
        }
        return true;
    }

    private static SensorManager getSensorManager() {
        SensorManager sensorManager = (SensorManager) Runtime.getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            return sensorManager;
        }
        throw new RuntimeException("Can't get SensorManager.");
    }

    private static native void headingChanged(NativeObject nativeObject2, float f, float f2, float f3);

    private static native void headingUnavailable(NativeObject nativeObject2);

    public static boolean isCompassAvailable() {
        return compassAvailable;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void start() {
        Sensor defaultSensor = this.manager.getDefaultSensor(1);
        Sensor defaultSensor2 = this.manager.getDefaultSensor(2);
        if (defaultSensor == null || defaultSensor2 == null) {
            headingUnavailable(this.nativeObject);
            return;
        }
        this.manager.registerListener(this, defaultSensor, 3);
        this.manager.registerListener(this, defaultSensor2, 3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            fArr = this.gravityData;
        } else if (type == 2) {
            fArr = this.magneticData;
        } else {
            return;
        }
        for (int i = 0; i < 3; i++) {
            fArr[i] = sensorEvent.values[i];
        }
        SensorManager.getRotationMatrix(this.rMatrix, this.iMatrix, this.gravityData, this.magneticData);
        SensorManager.getOrientation(this.rMatrix, this.orientation);
        headingChanged(this.nativeObject, (float) Math.toDegrees((double) this.orientation[0]), (float) Math.toDegrees((double) SensorManager.getInclination(this.iMatrix)), 0.0f);
    }

    public void stop() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yandex.runtime.sensors.internal.CompassHeadingSubscription.2
            @Override // java.lang.Runnable
            public void run() {
                CompassHeadingSubscription.this.manager.unregisterListener(this);
            }
        });
    }
}
