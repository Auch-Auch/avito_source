package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public abstract class ResourceCursorAdapter extends CursorAdapter {
    public int a;
    public int b;
    public LayoutInflater c;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.b = i;
        this.a = i;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.c.inflate(this.b, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.c.inflate(this.a, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.b = i;
    }

    public void setViewResource(int i) {
        this.a = i;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.b = i;
        this.a = i;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.b = i;
        this.a = i;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
