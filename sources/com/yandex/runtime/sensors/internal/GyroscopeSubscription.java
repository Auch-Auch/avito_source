package com.yandex.runtime.sensors.internal;

import android.hardware.SensorEvent;
import com.yandex.runtime.NativeObject;
public class GyroscopeSubscription implements SensorDataConsumer {
    private NativeObject nativeObject;
    private SensorSubscription sensorSubscription;

    public GyroscopeSubscription(NativeObject nativeObject2, int i) {
        this.nativeObject = nativeObject2;
        this.sensorSubscription = new SensorSubscription(this, 4, i);
    }

    private static native void angularSpeedChanged(NativeObject nativeObject2, float f, float f2, float f3, int i, long j, long j2);

    private static native void gyroscopeUnavailable(NativeObject nativeObject2);

    public static boolean isGyroscopeAvailable() {
        return SensorSubscription.isSensorAvailable(4);
    }

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void consume(SensorEvent sensorEvent) {
        long eventNanosToTimestampMills = TimeHelpers.eventNanosToTimestampMills(sensorEvent.timestamp);
        long eventNanosToMills = TimeHelpers.eventNanosToMills(sensorEvent.timestamp);
        NativeObject nativeObject2 = this.nativeObject;
        float[] fArr = sensorEvent.values;
        angularSpeedChanged(nativeObject2, fArr[0], fArr[1], fArr[2], sensorEvent.accuracy, eventNanosToTimestampMills, eventNanosToMills);
    }

    @Override // com.yandex.runtime.sensors.internal.SensorDataConsumer
    public void sensorUnavailable() {
        gyroscopeUnavailable(this.nativeObject);
    }

    public void stop() {
        this.sensorSubscription.stop();
    }
}
