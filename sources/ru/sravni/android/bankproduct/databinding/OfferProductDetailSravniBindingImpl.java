package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
public class OfferProductDetailSravniBindingImpl extends OfferProductDetailSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductDetailSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            r0 = 5
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r0, r1, r1)
            r2 = 4
            r2 = r0[r2]
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            android.widget.TextView r8 = (android.widget.TextView) r8
            r3 = 2
            r3 = r0[r3]
            r9 = r3
            android.widget.TextView r9 = (android.widget.TextView) r9
            r3 = 3
            r3 = r0[r3]
            r10 = r3
            android.widget.TextView r10 = (android.widget.TextView) r10
            r6 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.A = r3
            android.widget.ImageView r12 = r11.imgGoUrl
            r12.setTag(r1)
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.y = r12
            r12.setTag(r1)
            android.widget.TextView r12 = r11.tvDescription
            r12.setTag(r1)
            android.widget.TextView r12 = r11.tvText
            r12.setTag(r1)
            android.widget.TextView r12 = r11.tvUrl
            r12.setTag(r1)
            r11.setRootTag(r13)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r12 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r12.<init>(r11, r2)
            r11.z = r12
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        OfferProductActionInfo offerProductActionInfo = this.mOfferProductStatusInfo;
        IProductActionGetter iProductActionGetter = this.mProductActionGetter;
        if (iProductActionGetter != null) {
            iProductActionGetter.getProductActionClick(offerProductActionInfo);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z2;
        int i;
        int i2;
        String str;
        int i3;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        OfferProductActionInfo offerProductActionInfo = this.mOfferProductStatusInfo;
        int i4 = 0;
        int i5 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i5 != 0) {
            if (offerProductActionInfo != null) {
                z3 = offerProductActionInfo.getNeedStatusOfferText();
                str = offerProductActionInfo.getUrlText();
                i2 = offerProductActionInfo.getInfoText();
                z4 = offerProductActionInfo.isMicroCredit();
            } else {
                str = null;
                z4 = false;
                z3 = false;
                i2 = 0;
            }
            if (i5 != 0) {
                j |= z3 ? 256 : 128;
            }
            if ((j & 6) != 0) {
                j |= z4 ? 64 : 32;
            }
            i = 8;
            i3 = z3 ? 0 : 8;
            z2 = i2 > 0;
            if (z4) {
                i = 0;
            }
            if ((j & 6) != 0) {
                j = z2 ? j | 16 : j | 8;
            }
        } else {
            str = null;
            i3 = 0;
            i2 = 0;
            i = 0;
            z2 = false;
        }
        int i6 = (8 & j) != 0 ? R.string.empty_string : 0;
        int i7 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i7 != 0) {
            i4 = z2 ? i2 : i6;
        }
        if (i7 != 0) {
            this.imgGoUrl.setVisibility(i);
            this.tvDescription.setVisibility(i3);
            this.tvText.setText(i4);
            TextViewBindingAdapter.setText(this.tvUrl, str);
            this.tvUrl.setVisibility(i);
        }
        if ((j & 4) != 0) {
            this.y.setOnClickListener(this.z);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding
    public void setOfferProductStatusInfo(@Nullable OfferProductActionInfo offerProductActionInfo) {
        this.mOfferProductStatusInfo = offerProductActionInfo;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.offerProductStatusInfo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding
    public void setProductActionGetter(@Nullable IProductActionGetter iProductActionGetter) {
        this.mProductActionGetter = iProductActionGetter;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.productActionGetter);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.productActionGetter == i) {
            setProductActionGetter((IProductActionGetter) obj);
        } else if (BR.offerProductStatusInfo != i) {
            return false;
        } else {
            setOfferProductStatusInfo((OfferProductActionInfo) obj);
        }
        return true;
    }
}
