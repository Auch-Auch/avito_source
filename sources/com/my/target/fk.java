package com.my.target;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
public class fk extends Dialog {
    @NonNull
    public final a a;

    public interface a {
        void a(@NonNull fk fkVar, @NonNull FrameLayout frameLayout);

        void a(boolean z);

        void o();
    }

    public fk(@NonNull a aVar, @NonNull Context context) {
        super(context);
        this.a = aVar;
    }

    @NonNull
    public static fk a(@NonNull a aVar, @NonNull Context context) {
        return new fk(aVar, context);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.a.o();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        FrameLayout frameLayout = new FrameLayout(getContext());
        setContentView(frameLayout);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
        }
        this.a.a(this, frameLayout);
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.a.a(z);
        super.onWindowFocusChanged(z);
    }
}
