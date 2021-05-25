package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.widget.TextView;
public final class mj extends mk<TextView, String> {
    public mj(@NonNull TextView textView) {
        super(textView);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void a(@NonNull TextView textView) {
        TextView textView2 = textView;
        textView2.setText("");
        super.a(textView2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ void b(@NonNull TextView textView, @NonNull String str) {
        textView.setText(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull TextView textView, @NonNull String str) {
        return textView.getText().toString().equalsIgnoreCase(str);
    }
}
