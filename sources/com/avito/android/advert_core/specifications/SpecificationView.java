package com.avito.android.advert_core.specifications;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_core.specifications.SpecificationData;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.Navigation;
import com.avito.android.ui_components.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bA\u0010BB\u001b\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\bA\u0010CB#\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\bA\u0010DB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\bA\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u001e\u0010/\u001a\n ,*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010&R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010\"R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010\"R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010\"R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010&R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010&R\u0016\u0010@\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006E"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationView;", "Landroid/view/ViewGroup;", "", "getMinColumnIndex", "()I", "columns", "", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "items", "", "setData", "(ILjava/util/List;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", AuthSource.SEND_ABUSE, "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "n", "[Ljava/lang/Integer;", "itemStartPositionsY", "k", "columnEndPositionsX", "I", "columnOffset", "c", "edgeOffset", "h", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "d", "Landroid/view/LayoutInflater;", "inflater", "i", "Ljava/util/List;", "f", "previewHeight", "j", "columnStartPositionsX", "l", "columnPositionsY", AuthSource.OPEN_CHANNEL_LIST, "itemStartPositionsX", AuthSource.BOOKING_ORDER, "rowOffset", "e", "previewWidth", g.a, "Z", "invalidate", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class SpecificationView extends ViewGroup {
    public final int a;
    public final int b;
    public int c;
    public final LayoutInflater d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public List<? extends SpecificationData> i;
    public Integer[] j;
    public Integer[] k;
    public Integer[] l;
    public Integer[] m;
    public Integer[] n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecificationView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = getResources().getDimensionPixelOffset(R.dimen.rds_column_offset);
        this.b = getResources().getDimensionPixelOffset(com.avito.android.advert_core.R.dimen.advert_specification_row_offset);
        this.c = getResources().getDimensionPixelOffset(R.dimen.rds_horizontal_edge_offset);
        this.d = LayoutInflater.from(getContext());
        this.g = true;
        this.h = 1;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = new Integer[0];
        this.k = new Integer[0];
        this.l = new Integer[0];
        this.m = new Integer[0];
        this.n = new Integer[0];
        a(context, null, 0, 0);
    }

    private final int getMinColumnIndex() {
        Integer[] numArr = this.l;
        int length = numArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        while (i2 < length) {
            int i6 = i4 + 1;
            int intValue = numArr[i2].intValue();
            if (intValue < i5) {
                i3 = i4;
                i5 = intValue;
            }
            i2++;
            i4 = i6;
        }
        return i3;
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.avito.android.advert_core.R.styleable.SpecificationView, i2, i3);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, Navigation.ATTRIBUTES);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == com.avito.android.advert_core.R.styleable.SpecificationView_edgeOffset) {
                this.c = obtainStyledAttributes.getDimensionPixelOffset(index, this.c);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int size = this.i.size();
        for (int i6 = 0; i6 < size; i6++) {
            View childAt = getChildAt(i6);
            int intValue = this.m[i6].intValue();
            int intValue2 = this.n[i6].intValue();
            Intrinsics.checkNotNullExpressionValue(childAt, "itemView");
            childAt.layout(intValue, intValue2, childAt.getMeasuredWidth() + intValue, childAt.getMeasuredHeight() + intValue2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        if (this.e != size || this.g) {
            this.e = size;
            int i4 = 0;
            this.g = false;
            int i5 = this.c;
            int i6 = this.h;
            int i7 = (size - (i5 * 2)) - ((i6 - 1) * this.a);
            int i8 = i7 / i6;
            int i9 = i7 % i6;
            this.j[0] = Integer.valueOf(i5);
            int i10 = this.h;
            int i11 = 1;
            while (i11 < i10) {
                int i12 = i11 <= i9 ? 1 : 0;
                Integer[] numArr = this.j;
                numArr[i11] = Integer.valueOf(numArr[i11 - 1].intValue() + i8 + this.a + i12);
                i11++;
            }
            Integer[] numArr2 = this.j;
            int length = numArr2.length;
            int i13 = 0;
            int i14 = 0;
            while (i13 < length) {
                this.k[i14] = Integer.valueOf(numArr2[i13].intValue() + i8);
                i13++;
                i14++;
            }
            ArraysKt___ArraysJvmKt.fill$default(this.l, Integer.valueOf(this.c), 0, 0, 6, (Object) null);
            int size2 = this.i.size();
            for (int i15 = 0; i15 < size2; i15++) {
                int span = ((SpecificationData) this.i.get(i15)).getSpan();
                int minColumnIndex = getMinColumnIndex();
                int min = Math.min(span, this.h - minColumnIndex) + minColumnIndex;
                int intValue = this.k[min - 1].intValue() - this.j[minColumnIndex].intValue();
                View childAt = getChildAt(i15);
                childAt.measure(View.MeasureSpec.makeMeasureSpec(intValue, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                int intValue2 = this.l[minColumnIndex].intValue();
                if (intValue2 > this.c) {
                    intValue2 += this.b;
                }
                this.m[i15] = this.j[minColumnIndex];
                this.n[i15] = Integer.valueOf(intValue2);
                Intrinsics.checkNotNullExpressionValue(childAt, "itemView");
                int measuredHeight = childAt.getMeasuredHeight() + intValue2;
                while (minColumnIndex < min) {
                    this.l[minColumnIndex] = Integer.valueOf(measuredHeight);
                    minColumnIndex++;
                }
            }
            Integer num = (Integer) ArraysKt___ArraysKt.max(this.l);
            int intValue3 = num != null ? num.intValue() : this.c;
            int i16 = this.c;
            if (intValue3 > i16) {
                i4 = intValue3 + i16;
            }
            this.f = i4;
        }
        setMeasuredDimension(this.e, this.f);
    }

    public final void setData(int i2, @NotNull List<? extends SpecificationData> list) {
        View view;
        Intrinsics.checkNotNullParameter(list, "items");
        if (i2 >= 1) {
            this.h = i2;
            Integer[] numArr = new Integer[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                numArr[i3] = 0;
            }
            this.j = numArr;
            Integer[] numArr2 = new Integer[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                numArr2[i4] = 0;
            }
            this.k = numArr2;
            Integer[] numArr3 = new Integer[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                numArr3[i5] = 0;
            }
            this.l = numArr3;
            removeAllViews();
            for (SpecificationData specificationData : list) {
                if (specificationData instanceof SpecificationData.BlockData) {
                    ModelSpecifications.Block data = ((SpecificationData.BlockData) specificationData).getData();
                    view = this.d.inflate(com.avito.android.advert_core.R.layout.block_item, (ViewGroup) this, false);
                    Intrinsics.checkNotNullExpressionValue(view, "blockView");
                    new BlockView(view).bindBlock$advert_core_release(data);
                } else if (specificationData instanceof SpecificationData.TitleData) {
                    String data2 = ((SpecificationData.TitleData) specificationData).getData();
                    view = this.d.inflate(com.avito.android.advert_core.R.layout.spec_title_item, (ViewGroup) this, false);
                    Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view).setText(data2);
                } else if (specificationData instanceof SpecificationData.SchemeData) {
                    ModelSpecifications.Scheme data3 = ((SpecificationData.SchemeData) specificationData).getData();
                    view = this.d.inflate(com.avito.android.advert_core.R.layout.spec_scheme_item, (ViewGroup) this, false);
                    Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.advert_core.specifications.SchemeView");
                    ((SchemeView) view).setScheme(data3);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                addView(view);
            }
            this.i = list;
            int size = list.size();
            Integer[] numArr4 = new Integer[size];
            for (int i6 = 0; i6 < size; i6++) {
                numArr4[i6] = 0;
            }
            this.m = numArr4;
            int size2 = list.size();
            Integer[] numArr5 = new Integer[size2];
            for (int i7 = 0; i7 < size2; i7++) {
                numArr5[i7] = 0;
            }
            this.n = numArr5;
            this.g = true;
            return;
        }
        throw new IllegalArgumentException(a.Q2("Column (", i2, ") not less zero"));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecificationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = getResources().getDimensionPixelOffset(R.dimen.rds_column_offset);
        this.b = getResources().getDimensionPixelOffset(com.avito.android.advert_core.R.dimen.advert_specification_row_offset);
        this.c = getResources().getDimensionPixelOffset(R.dimen.rds_horizontal_edge_offset);
        this.d = LayoutInflater.from(getContext());
        this.g = true;
        this.h = 1;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = new Integer[0];
        this.k = new Integer[0];
        this.l = new Integer[0];
        this.m = new Integer[0];
        this.n = new Integer[0];
        a(context, attributeSet, 0, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecificationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = getResources().getDimensionPixelOffset(R.dimen.rds_column_offset);
        this.b = getResources().getDimensionPixelOffset(com.avito.android.advert_core.R.dimen.advert_specification_row_offset);
        this.c = getResources().getDimensionPixelOffset(R.dimen.rds_horizontal_edge_offset);
        this.d = LayoutInflater.from(getContext());
        this.g = true;
        this.h = 1;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = new Integer[0];
        this.k = new Integer[0];
        this.l = new Integer[0];
        this.m = new Integer[0];
        this.n = new Integer[0];
        a(context, attributeSet, i2, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecificationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = getResources().getDimensionPixelOffset(R.dimen.rds_column_offset);
        this.b = getResources().getDimensionPixelOffset(com.avito.android.advert_core.R.dimen.advert_specification_row_offset);
        this.c = getResources().getDimensionPixelOffset(R.dimen.rds_horizontal_edge_offset);
        this.d = LayoutInflater.from(getContext());
        this.g = true;
        this.h = 1;
        this.i = CollectionsKt__CollectionsKt.emptyList();
        this.j = new Integer[0];
        this.k = new Integer[0];
        this.l = new Integer[0];
        this.m = new Integer[0];
        this.n = new Integer[0];
        a(context, attributeSet, i2, i3);
    }
}
