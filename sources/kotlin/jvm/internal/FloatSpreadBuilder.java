package kotlin.jvm.internal;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/jvm/internal/FloatSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "getSize", "([F)I", "", "value", "", ProductAction.ACTION_ADD, "(F)V", "toArray", "()[F", "d", "[F", ResidentialComplexModuleKt.VALUES, "size", "<init>", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class FloatSpreadBuilder extends PrimitiveSpreadBuilder<float[]> {
    public final float[] d;

    public FloatSpreadBuilder(int i) {
        super(i);
        this.d = new float[i];
    }

    public final void add(float f) {
        float[] fArr = this.d;
        int position = getPosition();
        setPosition(position + 1);
        fArr[position] = f;
    }

    @NotNull
    public final float[] toArray() {
        return (float[]) toArray(this.d, new float[size()]);
    }

    public int getSize(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$getSize");
        return fArr.length;
    }
}
