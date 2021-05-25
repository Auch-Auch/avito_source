package kotlin.jvm.internal;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\tJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/jvm/internal/IntSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "getSize", "([I)I", "value", "", ProductAction.ACTION_ADD, "(I)V", "toArray", "()[I", "d", "[I", ResidentialComplexModuleKt.VALUES, "size", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class IntSpreadBuilder extends PrimitiveSpreadBuilder<int[]> {
    public final int[] d;

    public IntSpreadBuilder(int i) {
        super(i);
        this.d = new int[i];
    }

    public final void add(int i) {
        int[] iArr = this.d;
        int position = getPosition();
        setPosition(position + 1);
        iArr[position] = i;
    }

    @NotNull
    public final int[] toArray() {
        return (int[]) toArray(this.d, new int[size()]);
    }

    public int getSize(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$getSize");
        return iArr.length;
    }
}
