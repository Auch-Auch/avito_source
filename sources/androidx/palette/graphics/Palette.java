package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class Palette {
    public static final Filter f = new a();
    public final List<Swatch> a;
    public final List<Target> b;
    public final Map<Target, Swatch> c = new ArrayMap();
    public final SparseBooleanArray d = new SparseBooleanArray();
    @Nullable
    public final Swatch e;

    public interface Filter {
        boolean isAllowed(@ColorInt int i, @NonNull float[] fArr);
    }

    public interface PaletteAsyncListener {
        void onGenerated(@Nullable Palette palette);
    }

    public static final class Swatch {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public boolean f;
        public int g;
        public int h;
        @Nullable
        public float[] i;

        public Swatch(@ColorInt int i2, int i3) {
            this.a = Color.red(i2);
            this.b = Color.green(i2);
            this.c = Color.blue(i2);
            this.d = i2;
            this.e = i3;
        }

        public final void a() {
            int i2;
            int i3;
            if (!this.f) {
                int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.d, 4.5f);
                int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.d, 3.0f);
                if (calculateMinimumAlpha == -1 || calculateMinimumAlpha2 == -1) {
                    int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.d, 4.5f);
                    int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.d, 3.0f);
                    if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
                        if (calculateMinimumAlpha != -1) {
                            i2 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                        } else {
                            i2 = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
                        }
                        this.h = i2;
                        if (calculateMinimumAlpha2 != -1) {
                            i3 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                        } else {
                            i3 = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
                        }
                        this.g = i3;
                        this.f = true;
                        return;
                    }
                    this.h = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
                    this.g = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
                    this.f = true;
                    return;
                }
                this.h = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                this.g = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                this.f = true;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            if (this.e == swatch.e && this.d == swatch.d) {
                return true;
            }
            return false;
        }

        @ColorInt
        public int getBodyTextColor() {
            a();
            return this.h;
        }

        @NonNull
        public float[] getHsl() {
            if (this.i == null) {
                this.i = new float[3];
            }
            ColorUtils.RGBToHSL(this.a, this.b, this.c, this.i);
            return this.i;
        }

        public int getPopulation() {
            return this.e;
        }

        @ColorInt
        public int getRgb() {
            return this.d;
        }

        @ColorInt
        public int getTitleTextColor() {
            a();
            return this.g;
        }

        public int hashCode() {
            return (this.d * 31) + this.e;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + "] [HSL: " + Arrays.toString(getHsl()) + "] [Population: " + this.e + "] [Title Text: #" + Integer.toHexString(getTitleTextColor()) + "] [Body Text: #" + Integer.toHexString(getBodyTextColor()) + ']';
        }
    }

    public static class a implements Filter {
        @Override // androidx.palette.graphics.Palette.Filter
        public boolean isAllowed(int i, float[] fArr) {
            if (fArr[2] >= 0.95f) {
                return false;
            }
            if (fArr[2] <= 0.05f) {
                return false;
            }
            if (!(fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f)) {
                return true;
            }
            return false;
        }
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        this.a = list;
        this.b = list2;
        int size = list.size();
        int i = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.a.get(i2);
            if (swatch2.getPopulation() > i) {
                i = swatch2.getPopulation();
                swatch = swatch2;
            }
        }
        this.e = swatch;
    }

    @NonNull
    public static Builder from(@NonNull Bitmap bitmap) {
        return new Builder(bitmap);
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    @ColorInt
    public int getColorForTarget(@NonNull Target target, @ColorInt int i) {
        Swatch swatchForTarget = getSwatchForTarget(target);
        return swatchForTarget != null ? swatchForTarget.getRgb() : i;
    }

    @ColorInt
    public int getDarkMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_MUTED, i);
    }

    @Nullable
    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    @ColorInt
    public int getDarkVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.DARK_VIBRANT, i);
    }

    @Nullable
    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    @ColorInt
    public int getDominantColor(@ColorInt int i) {
        Swatch swatch = this.e;
        return swatch != null ? swatch.getRgb() : i;
    }

    @Nullable
    public Swatch getDominantSwatch() {
        return this.e;
    }

    @ColorInt
    public int getLightMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_MUTED, i);
    }

    @Nullable
    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    @ColorInt
    public int getLightVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i);
    }

    @Nullable
    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    @ColorInt
    public int getMutedColor(@ColorInt int i) {
        return getColorForTarget(Target.MUTED, i);
    }

    @Nullable
    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    @Nullable
    public Swatch getSwatchForTarget(@NonNull Target target) {
        return this.c.get(target);
    }

    @NonNull
    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.a);
    }

    @NonNull
    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.b);
    }

    @ColorInt
    public int getVibrantColor(@ColorInt int i) {
        return getColorForTarget(Target.VIBRANT, i);
    }

    @Nullable
    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }

    @NonNull
    public static Palette from(@NonNull List<Swatch> list) {
        return new Builder(list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i) {
        return from(bitmap).maximumColorCount(i).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i).generate(paletteAsyncListener);
    }

    public static final class Builder {
        @Nullable
        public final List<Swatch> a;
        @Nullable
        public final Bitmap b;
        public final List<Target> c;
        public int d;
        public int e;
        public int f;
        public final List<Filter> g;
        @Nullable
        public Rect h;

        public class a extends AsyncTask<Bitmap, Void, Palette> {
            public final /* synthetic */ PaletteAsyncListener a;

            public a(PaletteAsyncListener paletteAsyncListener) {
                this.a = paletteAsyncListener;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // android.os.AsyncTask
            @Nullable
            public Palette doInBackground(Bitmap[] bitmapArr) {
                try {
                    return Builder.this.generate();
                } catch (Exception unused) {
                    return null;
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.os.AsyncTask
            public void onPostExecute(@Nullable Palette palette) {
                this.a.onGenerated(palette);
            }
        }

        public Builder(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.d = 16;
            this.e = 12544;
            this.f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.f);
            this.b = bitmap;
            this.a = null;
            arrayList.add(Target.LIGHT_VIBRANT);
            arrayList.add(Target.VIBRANT);
            arrayList.add(Target.DARK_VIBRANT);
            arrayList.add(Target.LIGHT_MUTED);
            arrayList.add(Target.MUTED);
            arrayList.add(Target.DARK_MUTED);
        }

        @NonNull
        public Builder addFilter(Filter filter) {
            if (filter != null) {
                this.g.add(filter);
            }
            return this;
        }

        @NonNull
        public Builder addTarget(@NonNull Target target) {
            if (!this.c.contains(target)) {
                this.c.add(target);
            }
            return this;
        }

        @NonNull
        public Builder clearFilters() {
            this.g.clear();
            return this;
        }

        @NonNull
        public Builder clearRegion() {
            this.h = null;
            return this;
        }

        @NonNull
        public Builder clearTargets() {
            List<Target> list = this.c;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @NonNull
        public Palette generate() {
            List<Swatch> list;
            Filter[] filterArr;
            int max;
            int i;
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                double d2 = -1.0d;
                if (this.e > 0) {
                    int height = bitmap.getHeight() * bitmap.getWidth();
                    int i2 = this.e;
                    if (height > i2) {
                        d2 = Math.sqrt(((double) i2) / ((double) height));
                    }
                } else if (this.f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i = this.f)) {
                    d2 = ((double) i) / ((double) max);
                }
                if (d2 > 0.0d) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d2), (int) Math.ceil(((double) bitmap.getHeight()) * d2), false);
                }
                Rect rect = this.h;
                if (!(bitmap == this.b || rect == null)) {
                    double width = ((double) bitmap.getWidth()) / ((double) this.b.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), bitmap.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width), bitmap.getHeight());
                }
                int width2 = bitmap.getWidth();
                int height2 = bitmap.getHeight();
                int[] iArr = new int[(width2 * height2)];
                bitmap.getPixels(iArr, 0, width2, 0, 0, width2, height2);
                Rect rect2 = this.h;
                if (rect2 != null) {
                    int width3 = rect2.width();
                    int height3 = this.h.height();
                    int[] iArr2 = new int[(width3 * height3)];
                    for (int i3 = 0; i3 < height3; i3++) {
                        Rect rect3 = this.h;
                        System.arraycopy(iArr, ((rect3.top + i3) * width2) + rect3.left, iArr2, i3 * width3, width3);
                    }
                    iArr = iArr2;
                }
                int i4 = this.d;
                if (this.g.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.g;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                l6.t.a.a aVar = new l6.t.a.a(iArr, i4, filterArr);
                if (bitmap != this.b) {
                    bitmap.recycle();
                }
                list = aVar.c;
            } else {
                list = this.a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            List<Target> list3 = this.c;
            Palette palette = new Palette(list, list3);
            int size = list3.size();
            for (int i5 = 0; i5 < size; i5++) {
                Target target = palette.b.get(i5);
                int length = target.c.length;
                float f2 = 0.0f;
                for (int i6 = 0; i6 < length; i6++) {
                    float f3 = target.c[i6];
                    if (f3 > 0.0f) {
                        f2 += f3;
                    }
                }
                if (f2 != 0.0f) {
                    int length2 = target.c.length;
                    for (int i7 = 0; i7 < length2; i7++) {
                        float[] fArr = target.c;
                        if (fArr[i7] > 0.0f) {
                            fArr[i7] = fArr[i7] / f2;
                        }
                    }
                }
                Map<Target, Swatch> map = palette.c;
                int size2 = palette.a.size();
                Swatch swatch = null;
                float f4 = 0.0f;
                for (int i8 = 0; i8 < size2; i8++) {
                    Swatch swatch2 = palette.a.get(i8);
                    float[] hsl = swatch2.getHsl();
                    if (hsl[1] >= target.getMinimumSaturation() && hsl[1] <= target.getMaximumSaturation() && hsl[2] >= target.getMinimumLightness() && hsl[2] <= target.getMaximumLightness() && !palette.d.get(swatch2.getRgb())) {
                        float[] hsl2 = swatch2.getHsl();
                        Swatch swatch3 = palette.e;
                        int population = swatch3 != null ? swatch3.getPopulation() : 1;
                        float abs = (target.getSaturationWeight() > 0.0f ? (1.0f - Math.abs(hsl2[1] - target.getTargetSaturation())) * target.getSaturationWeight() : 0.0f) + (target.getLightnessWeight() > 0.0f ? (1.0f - Math.abs(hsl2[2] - target.getTargetLightness())) * target.getLightnessWeight() : 0.0f) + (target.getPopulationWeight() > 0.0f ? (((float) swatch2.getPopulation()) / ((float) population)) * target.getPopulationWeight() : 0.0f);
                        if (swatch == null || abs > f4) {
                            f4 = abs;
                            swatch = swatch2;
                        }
                    }
                }
                if (swatch != null && target.isExclusive()) {
                    palette.d.append(swatch.getRgb(), true);
                }
                map.put(target, swatch);
            }
            palette.d.clear();
            return palette;
        }

        @NonNull
        public Builder maximumColorCount(int i) {
            this.d = i;
            return this;
        }

        @NonNull
        public Builder resizeBitmapArea(int i) {
            this.e = i;
            this.f = -1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder resizeBitmapSize(int i) {
            this.f = i;
            this.e = -1;
            return this;
        }

        @NonNull
        public Builder setRegion(@Px int i, @Px int i2, @Px int i3, @Px int i4) {
            if (this.b != null) {
                if (this.h == null) {
                    this.h = new Rect();
                }
                this.h.set(0, 0, this.b.getWidth(), this.b.getHeight());
                if (!this.h.intersect(i, i2, i3, i4)) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }

        public Builder(@NonNull List<Swatch> list) {
            this.c = new ArrayList();
            this.d = 16;
            this.e = 12544;
            this.f = -1;
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List of Swatches is not valid");
            }
            arrayList.add(Palette.f);
            this.a = list;
            this.b = null;
        }

        @NonNull
        public AsyncTask<Bitmap, Void, Palette> generate(@NonNull PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new a(paletteAsyncListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }
    }
}
