package com.google.android.gms.vision;

import a2.b.a.a.a;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Tracker<T> zzas;
    private int zzat = 3;
    private boolean zzau = false;
    private int zzav;
    private int zzaw = 0;
    private Detector<T> zzx;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzx = detector;
        this.zzas = tracker;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzaw == this.zzat) {
                this.zzas.onDone();
                this.zzau = false;
            } else {
                this.zzas.onMissing(detections);
            }
            this.zzaw++;
            return;
        }
        this.zzaw = 0;
        if (this.zzau) {
            T t = detectedItems.get(this.zzav);
            if (t != null) {
                this.zzas.onUpdate(detections, t);
                return;
            } else {
                this.zzas.onDone();
                this.zzau = false;
            }
        }
        int selectFocus = selectFocus(detections);
        T t2 = detectedItems.get(selectFocus);
        if (t2 != null) {
            this.zzau = true;
            this.zzav = selectFocus;
            this.zzx.setFocus(selectFocus);
            this.zzas.onNewItem(this.zzav, t2);
            this.zzas.onUpdate(detections, t2);
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        this.zzas.onDone();
    }

    public abstract int selectFocus(Detector.Detections<T> detections);

    public final void zza(int i) {
        if (i >= 0) {
            this.zzat = i;
            return;
        }
        throw new IllegalArgumentException(a.m2(28, "Invalid max gap: ", i));
    }
}
