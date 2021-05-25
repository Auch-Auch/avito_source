package ru.sravni.android.bankproduct.generated.callback;

import android.view.View;
public final class OnClickListener implements View.OnClickListener {
    public final Listener a;
    public final int b;

    public interface Listener {
        void _internalCallbackOnClick(int i, View view);
    }

    public OnClickListener(Listener listener, int i) {
        this.a = listener;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a._internalCallbackOnClick(this.b, view);
    }
}
