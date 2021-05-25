package l6.s;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
public final class g extends DiffUtil.Callback {
    public final /* synthetic */ f a;
    public final /* synthetic */ int b;
    public final /* synthetic */ f c;
    public final /* synthetic */ DiffUtil.ItemCallback d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    public g(f fVar, int i, f fVar2, DiffUtil.ItemCallback itemCallback, int i2, int i3) {
        this.a = fVar;
        this.b = i;
        this.c = fVar2;
        this.d = itemCallback;
        this.e = i2;
        this.f = i3;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        Object obj = this.a.get(i + this.b);
        f fVar = this.c;
        Object obj2 = fVar.get(i2 + fVar.a);
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return this.d.areContentsTheSame(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        Object obj = this.a.get(i + this.b);
        f fVar = this.c;
        Object obj2 = fVar.get(i2 + fVar.a);
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return this.d.areItemsTheSame(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    @Nullable
    public Object getChangePayload(int i, int i2) {
        Object obj = this.a.get(i + this.b);
        f fVar = this.c;
        Object obj2 = fVar.get(i2 + fVar.a);
        if (obj == null || obj2 == null) {
            return null;
        }
        return this.d.getChangePayload(obj, obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.e;
    }
}
