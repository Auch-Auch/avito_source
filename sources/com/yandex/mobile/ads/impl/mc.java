package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.av;
public final class mc extends mk<TextView, or> {
    public mc(@NonNull TextView textView) {
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
    public final /* synthetic */ void b(@NonNull TextView textView, @NonNull or orVar) {
        TextView textView2 = textView;
        or orVar2 = orVar;
        if (av.a.TEXT == orVar2.b()) {
            textView2.setText(orVar2.a());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.mk
    public final /* synthetic */ boolean a(@NonNull TextView textView, @NonNull or orVar) {
        TextView textView2 = textView;
        or orVar2 = orVar;
        if (av.a.TEXT == orVar2.b()) {
            return textView2.getText().toString().equals(orVar2.a());
        }
        return true;
    }
}
