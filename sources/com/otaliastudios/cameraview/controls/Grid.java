package com.otaliastudios.cameraview.controls;
public enum Grid implements Control {
    OFF(0),
    DRAW_3X3(1),
    DRAW_4X4(2),
    DRAW_PHI(3);
    
    public int a;

    /* access modifiers changed from: public */
    Grid(int i) {
        this.a = i;
    }
}
