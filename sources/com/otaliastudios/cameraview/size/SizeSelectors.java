package com.otaliastudios.cameraview.size;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SizeSelectors {

    public interface Filter {
        boolean accepts(@NonNull Size size);
    }

    public static class a implements Filter {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getWidth() <= this.a;
        }
    }

    public static class b implements Filter {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getWidth() >= this.a;
        }
    }

    public static class c implements Filter {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getHeight() <= this.a;
        }
    }

    public static class d implements Filter {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getHeight() >= this.a;
        }
    }

    public static class e implements Filter {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        public e(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            float f = AspectRatio.of(size.getWidth(), size.getHeight()).toFloat();
            float f2 = this.a;
            float f3 = this.b;
            return f >= f2 - f3 && f <= f2 + f3;
        }
    }

    public static class f implements SizeSelector {
        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @NonNull
        public List<Size> select(@NonNull List<Size> list) {
            Collections.sort(list);
            Collections.reverse(list);
            return list;
        }
    }

    public static class g implements SizeSelector {
        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @NonNull
        public List<Size> select(@NonNull List<Size> list) {
            Collections.sort(list);
            return list;
        }
    }

    public static class h implements Filter {
        public final /* synthetic */ int a;

        public h(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getWidth() * size.getHeight() <= this.a;
        }
    }

    public static class i implements Filter {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@NonNull Size size) {
            return size.getWidth() * size.getHeight() >= this.a;
        }
    }

    public static class j implements SizeSelector {
        public SizeSelector[] a;

        public j(SizeSelector[] sizeSelectorArr, a aVar) {
            this.a = sizeSelectorArr;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @NonNull
        public List<Size> select(@NonNull List<Size> list) {
            for (SizeSelector sizeSelector : this.a) {
                list = sizeSelector.select(list);
            }
            return list;
        }
    }

    public static class k implements SizeSelector {
        public Filter a;

        public k(Filter filter, a aVar) {
            this.a = filter;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @NonNull
        public List<Size> select(@NonNull List<Size> list) {
            ArrayList arrayList = new ArrayList();
            for (Size size : list) {
                if (this.a.accepts(size)) {
                    arrayList.add(size);
                }
            }
            return arrayList;
        }
    }

    public static class l implements SizeSelector {
        public SizeSelector[] a;

        public l(SizeSelector[] sizeSelectorArr, a aVar) {
            this.a = sizeSelectorArr;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @NonNull
        public List<Size> select(@NonNull List<Size> list) {
            List<Size> list2 = null;
            for (SizeSelector sizeSelector : this.a) {
                list2 = sizeSelector.select(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new ArrayList() : list2;
        }
    }

    @NonNull
    public static SizeSelector and(SizeSelector... sizeSelectorArr) {
        return new j(sizeSelectorArr, null);
    }

    @NonNull
    public static SizeSelector aspectRatio(AspectRatio aspectRatio, float f2) {
        return withFilter(new e(aspectRatio.toFloat(), f2));
    }

    @NonNull
    public static SizeSelector biggest() {
        return new f();
    }

    @NonNull
    public static SizeSelector maxArea(int i2) {
        return withFilter(new h(i2));
    }

    @NonNull
    public static SizeSelector maxHeight(int i2) {
        return withFilter(new c(i2));
    }

    @NonNull
    public static SizeSelector maxWidth(int i2) {
        return withFilter(new a(i2));
    }

    @NonNull
    public static SizeSelector minArea(int i2) {
        return withFilter(new i(i2));
    }

    @NonNull
    public static SizeSelector minHeight(int i2) {
        return withFilter(new d(i2));
    }

    @NonNull
    public static SizeSelector minWidth(int i2) {
        return withFilter(new b(i2));
    }

    @NonNull
    public static SizeSelector or(SizeSelector... sizeSelectorArr) {
        return new l(sizeSelectorArr, null);
    }

    @NonNull
    public static SizeSelector smallest() {
        return new g();
    }

    @NonNull
    public static SizeSelector withFilter(@NonNull Filter filter) {
        return new k(filter, null);
    }
}
