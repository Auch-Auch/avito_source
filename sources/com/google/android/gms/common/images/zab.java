package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zaj;
public abstract class zab {
    public final zaa zaa;
    public int zab = 0;
    private int zac = 0;
    private boolean zad = false;
    private boolean zae = true;
    private boolean zaf = false;
    private boolean zag = true;

    public zab(Uri uri, int i) {
        this.zaa = new zaa(uri);
        this.zab = i;
    }

    public final void zaa(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    public abstract void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3);

    public final void zaa(Context context, zaj zaj) {
        if (this.zag) {
            zaa(null, false, true, false);
        }
    }

    public final void zaa(Context context, zaj zaj, boolean z) {
        int i = this.zab;
        zaa(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    public final boolean zaa(boolean z, boolean z2) {
        return this.zae && !z2 && !z;
    }
}
