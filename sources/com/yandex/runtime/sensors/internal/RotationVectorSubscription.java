package com.yandex.runtime.sensors.internal;

import android.hardware.SensorEvent;
import com.yandex.runtime.NativeObject;
public class RotationVectorSubscription implements SensorDataConsumer {
    private NativeObject nativeObject;
    private SensorSubscription sensorSubscription;

    public RotationVectorSubscription(NativeObject nativeObject2, int i) {
        this.nativeObject = nativeObject2;
        this.sensorSubscription = new SensorSubscription(this, 11, i);
    }

    public static boolean isRotationVectorAvailable() {
        return SensorSubscription.isSensorAvailable(11);
    }

    private static native void rotationVectorChanged(NativeObject nativeObject2, float f, float f2, float f3, int i, long j);

    private static native void rotationVectorChangedScalar(NativeObject nativeObject2, float f, float f2, float f3, float f4, int i, long j);

    private static native void rotationVectorUnavailable(NativeObject nativeObject2);

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void consume(SensorEvent sensorEvent) {
        long eventNanosToTimestampMills = TimeHelpers.eventNanosToTimestampMills(sensorEvent.timestamp);
        float[] fArr = sensorEvent.values;
        if (fArr.length == 3) {
            rotationVectorChanged(this.nativeObject, fArr[0], fArr[1], fArr[2], sensorEvent.accuracy, eventNanosToTimestampMills);
        } else {
            rotationVectorChangedScalar(this.nativeObject, fArr[0], fArr[1], fArr[2], fArr[3], sensorEvent.accuracy, eventNanosToTimestampMills);
        }
    }

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void sensorUnavailable() {
        rotationVectorUnavailable(this.nativeObject);
    }

    public void stop() {
        this.sensorSubscription.stop();
    }
}
