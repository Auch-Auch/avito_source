package com.otaliastudios.opengl.draw;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlSquare;", "Lcom/otaliastudios/opengl/draw/GlPolygon;", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlSquare extends GlPolygon {
    public GlSquare() {
        super(4);
        setRotation(45.0f);
        setRadius((float) Math.sqrt((double) 2.0f));
    }
}
