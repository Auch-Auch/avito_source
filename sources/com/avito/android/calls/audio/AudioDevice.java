package com.avito.android.calls.audio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice;", "", "<init>", "()V", "Bluetooth", "Earpiece", "None", "Speaker", "WiredHeadset", "Lcom/avito/android/calls/audio/AudioDevice$Earpiece;", "Lcom/avito/android/calls/audio/AudioDevice$Speaker;", "Lcom/avito/android/calls/audio/AudioDevice$Bluetooth;", "Lcom/avito/android/calls/audio/AudioDevice$WiredHeadset;", "Lcom/avito/android/calls/audio/AudioDevice$None;", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class AudioDevice {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice$Bluetooth;", "Lcom/avito/android/calls/audio/AudioDevice;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Bluetooth extends AudioDevice {
        @NotNull
        public static final Bluetooth INSTANCE = new Bluetooth();

        public Bluetooth() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice$Earpiece;", "Lcom/avito/android/calls/audio/AudioDevice;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Earpiece extends AudioDevice {
        @NotNull
        public static final Earpiece INSTANCE = new Earpiece();

        public Earpiece() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice$None;", "Lcom/avito/android/calls/audio/AudioDevice;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class None extends AudioDevice {
        @NotNull
        public static final None INSTANCE = new None();

        public None() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice$Speaker;", "Lcom/avito/android/calls/audio/AudioDevice;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class Speaker extends AudioDevice {
        @NotNull
        public static final Speaker INSTANCE = new Speaker();

        public Speaker() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/audio/AudioDevice$WiredHeadset;", "Lcom/avito/android/calls/audio/AudioDevice;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class WiredHeadset extends AudioDevice {
        @NotNull
        public static final WiredHeadset INSTANCE = new WiredHeadset();

        public WiredHeadset() {
            super(null);
        }
    }

    public AudioDevice() {
    }

    public AudioDevice(j jVar) {
    }
}
