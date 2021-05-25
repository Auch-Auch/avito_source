package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzao;
import java.util.ArrayList;
import java.util.List;
public class Element implements Text {
    private zzao zzee;

    public Element(zzao zzao) {
        this.zzee = zzao;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        return zzc.zza(this);
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        return zzc.zza(this.zzee.zzep);
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        return this.zzee.zzej;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        return this.zzee.zzes;
    }
}
