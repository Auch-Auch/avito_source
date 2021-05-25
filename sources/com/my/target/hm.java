package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.hj;
@SuppressLint({"ViewConstructor"})
public class hm extends hk {
    public hm(@NonNull View view, @NonNull View view2, @NonNull hj.a aVar, @Nullable View view3, @NonNull ho hoVar, @NonNull Context context) {
        super(view, view2, aVar, view3, hoVar, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0196  */
    @Override // com.my.target.hk, android.view.ViewGroup, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 668
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hm.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0155: APUT  (r0v9 int[]), (0 ??[int, short, byte, char]), (r4v4 int) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009d, code lost:
        if (android.text.TextUtils.isEmpty(r10.r.getText()) == false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0120  */
    @Override // com.my.target.hk, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 412
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hm.onMeasure(int, int):void");
    }

    @Override // com.my.target.hk, com.my.target.hj
    public void setBanner(@NonNull ce ceVar) {
        super.setBanner(ceVar);
        View view = this.L;
        if (view != null) {
            view.setVisibility(8);
        }
        this.m.setVisibility(8);
    }
}
