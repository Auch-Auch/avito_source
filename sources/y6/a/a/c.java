package y6.a.a;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import pl.droidsonroids.gif.GifDrawable;
public class c extends View.BaseSavedState {
    public static final Parcelable.Creator<c> CREATOR = new a();
    public final long[][] a;

    public static class a implements Parcelable.Creator<c> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public c createFromParcel(Parcel parcel) {
            return new c(parcel, (a) null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    public c(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.a = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof GifDrawable) {
                this.a[i] = ((GifDrawable) drawable).f.n();
            } else {
                this.a[i] = null;
            }
        }
    }

    public void a(Drawable drawable, int i) {
        long[][] jArr = this.a;
        if (jArr[i] != null && (drawable instanceof GifDrawable)) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            gifDrawable.a((long) gifDrawable.f.D(jArr[i], gifDrawable.e));
        }
    }

    @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.a.length);
        for (long[] jArr : this.a) {
            parcel.writeLongArray(jArr);
        }
    }

    public c(Parcel parcel, a aVar) {
        super(parcel);
        this.a = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.a;
            if (i < jArr.length) {
                jArr[i] = parcel.createLongArray();
                i++;
            } else {
                return;
            }
        }
    }

    public c(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        long[][] jArr2 = new long[1][];
        this.a = jArr2;
        jArr2[0] = jArr;
    }
}
