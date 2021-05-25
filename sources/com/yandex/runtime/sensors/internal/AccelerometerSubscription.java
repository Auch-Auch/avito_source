package com.yandex.runtime.sensors.internal;

import android.hardware.SensorEvent;
import com.yandex.runtime.NativeObject;
public class AccelerometerSubscription implements SensorDataConsumer {
    private NativeObject nativeObject;
    private SensorSubscription sensorSubscription;

    public AccelerometerSubscription(NativeObject nativeObject2, int i) {
        this.nativeObject = nativeObject2;
        this.sensorSubscription = new SensorSubscription(this, 1, i);
    }

    private static native void accelerationChanged(NativeObject nativeObject2, float f, float f2, float f3, int i, long j, long j2);

    private static native void accelerometerUnavailable(NativeObject nativeObject2);

    public static boolean isAccelerometerAvailable() {
        return SensorSubscription.isSensorAvailable(1);
    }

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void consume(SensorEvent sensorEvent) {
        long eventNanosToTimestampMills = TimeHelpers.eventNanosToTimestampMills(sensorEvent.timestamp);
        long eventNanosToMills = TimeHelpers.eventNanosToMills(sensorEvent.timestamp);
        NativeObject nativeObject2 = this.nativeObject;
        float[] fArr = sensorEvent.values;
        accelerationChanged(nativeObject2, fArr[0], fArr[1], fArr[2], sensorEvent.accuracy, eventNanosToTimestampMills, eventNanosToMills);
    }

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void sensorUnavailable() {
        accelerometerUnavailable(this.nativeObject);
    }

    public void stop() {
        this.sensorSubscription.stop();
    }
}
