package com.avito.android.calls.quality;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue;", "", "<init>", "()V", "CodecMismatch", "HighMediaLatency", "IceDisconnected", "LowBandwidth", "NoAudioSignal", "PacketLoss", "Lcom/avito/android/calls/quality/CallQualityIssue$CodecMismatch;", "Lcom/avito/android/calls/quality/CallQualityIssue$PacketLoss;", "Lcom/avito/android/calls/quality/CallQualityIssue$IceDisconnected;", "Lcom/avito/android/calls/quality/CallQualityIssue$NoAudioSignal;", "Lcom/avito/android/calls/quality/CallQualityIssue$HighMediaLatency;", "Lcom/avito/android/calls/quality/CallQualityIssue$LowBandwidth;", "calls_release"}, k = 1, mv = {1, 4, 2})
public abstract class CallQualityIssue {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$CodecMismatch;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class CodecMismatch extends CallQualityIssue {
        @NotNull
        public static final CodecMismatch INSTANCE = new CodecMismatch();

        public CodecMismatch() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$HighMediaLatency;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class HighMediaLatency extends CallQualityIssue {
        @NotNull
        public static final HighMediaLatency INSTANCE = new HighMediaLatency();

        public HighMediaLatency() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$IceDisconnected;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class IceDisconnected extends CallQualityIssue {
        @NotNull
        public static final IceDisconnected INSTANCE = new IceDisconnected();

        public IceDisconnected() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$LowBandwidth;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class LowBandwidth extends CallQualityIssue {
        @NotNull
        public static final LowBandwidth INSTANCE = new LowBandwidth();

        public LowBandwidth() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$NoAudioSignal;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class NoAudioSignal extends CallQualityIssue {
        @NotNull
        public static final NoAudioSignal INSTANCE = new NoAudioSignal();

        public NoAudioSignal() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls/quality/CallQualityIssue$PacketLoss;", "Lcom/avito/android/calls/quality/CallQualityIssue;", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class PacketLoss extends CallQualityIssue {
        @NotNull
        public static final PacketLoss INSTANCE = new PacketLoss();

        public PacketLoss() {
            super(null);
        }
    }

    public CallQualityIssue() {
    }

    public CallQualityIssue(j jVar) {
    }
}
