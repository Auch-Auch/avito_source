package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import javax.annotation.concurrent.GuardedBy;
public abstract class Detector<T> {
    private final Object zzah = new Object();
    @GuardedBy("processorLock")
    private Processor<T> zzai;

    public static class Detections<T> {
        private final SparseArray<T> zzal;
        private final Frame.Metadata zzam;
        private final boolean zzan;

        public Detections(SparseArray<T> sparseArray, Frame.Metadata metadata, boolean z) {
            this.zzal = sparseArray;
            this.zzam = metadata;
            this.zzan = z;
        }

        public boolean detectorIsOperational() {
            return this.zzan;
        }

        public SparseArray<T> getDetectedItems() {
            return this.zzal;
        }

        public Frame.Metadata getFrameMetadata() {
            return this.zzam;
        }
    }

    public interface Processor<T> {
        void receiveDetections(Detections<T> detections);

        void release();
    }

    public abstract SparseArray<T> detect(Frame frame);

    public boolean isOperational() {
        return true;
    }

    public void receiveFrame(Frame frame) {
        Frame.Metadata metadata = new Frame.Metadata(frame.getMetadata());
        metadata.zzf();
        Detections<T> detections = new Detections<>(detect(frame), metadata, isOperational());
        synchronized (this.zzah) {
            Processor<T> processor = this.zzai;
            if (processor != null) {
                processor.receiveDetections(detections);
            } else {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
        }
    }

    public void release() {
        synchronized (this.zzah) {
            Processor<T> processor = this.zzai;
            if (processor != null) {
                processor.release();
                this.zzai = null;
            }
        }
    }

    public boolean setFocus(int i) {
        return true;
    }

    public void setProcessor(Processor<T> processor) {
        synchronized (this.zzah) {
            Processor<T> processor2 = this.zzai;
            if (processor2 != null) {
                processor2.release();
            }
            this.zzai = processor;
        }
    }
}
