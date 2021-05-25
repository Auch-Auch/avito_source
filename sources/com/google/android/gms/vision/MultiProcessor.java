package com.google.android.gms.vision;

import a2.b.a.a.a;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;
import java.util.Iterator;
public class MultiProcessor<T> implements Detector.Processor<T> {
    private int zzat;
    private Factory<T> zzbe;
    private SparseArray<zza> zzbf;

    public static class Builder<T> {
        private MultiProcessor<T> zzbh;

        public Builder(Factory<T> factory) {
            MultiProcessor<T> multiProcessor = new MultiProcessor<>();
            this.zzbh = multiProcessor;
            if (factory != null) {
                ((MultiProcessor) multiProcessor).zzbe = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public MultiProcessor<T> build() {
            return this.zzbh;
        }

        public Builder<T> setMaxGapFrames(int i) {
            if (i >= 0) {
                ((MultiProcessor) this.zzbh).zzat = i;
                return this;
            }
            throw new IllegalArgumentException(a.m2(28, "Invalid max gap: ", i));
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    public class zza {
        private Tracker<T> zzas;
        private int zzaw;

        private zza(MultiProcessor multiProcessor) {
            this.zzaw = 0;
        }

        public static /* synthetic */ int zzb(zza zza) {
            int i = zza.zzaw;
            zza.zzaw = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzbf = new SparseArray<>();
        this.zzat = 3;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            if (this.zzbf.get(keyAt) == null) {
                zza zza2 = new zza();
                zza2.zzas = this.zzbe.create(valueAt);
                zza2.zzas.onNewItem(keyAt, valueAt);
                this.zzbf.append(keyAt, zza2);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.zzbf.size(); i2++) {
            int keyAt2 = this.zzbf.keyAt(i2);
            if (detectedItems2.get(keyAt2) == null) {
                zza valueAt2 = this.zzbf.valueAt(i2);
                zza.zzb(valueAt2);
                if (valueAt2.zzaw >= this.zzat) {
                    valueAt2.zzas.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.zzas.onMissing(detections);
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.zzbf.delete(((Integer) it.next()).intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i3 = 0; i3 < detectedItems3.size(); i3++) {
            int keyAt3 = detectedItems3.keyAt(i3);
            T valueAt3 = detectedItems3.valueAt(i3);
            zza zza3 = this.zzbf.get(keyAt3);
            zza3.zzaw = 0;
            zza3.zzas.onUpdate(detections, valueAt3);
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        for (int i = 0; i < this.zzbf.size(); i++) {
            this.zzbf.valueAt(i).zzas.onDone();
        }
        this.zzbf.clear();
    }
}
