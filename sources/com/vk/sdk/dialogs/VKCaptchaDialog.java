package com.vk.sdk.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vk.sdk.R;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
public class VKCaptchaDialog {
    public final VKError a;
    public EditText b;
    public ImageView c;
    public ProgressBar d;
    public float e;

    public class a implements View.OnFocusChangeListener {
        public final /* synthetic */ AlertDialog a;

        public a(VKCaptchaDialog vKCaptchaDialog, AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.a.getWindow().setSoftInputMode(5);
            }
        }
    }

    public class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ AlertDialog a;

        public b(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            VKCaptchaDialog.a(VKCaptchaDialog.this);
            this.a.dismiss();
            return true;
        }
    }

    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            VKCaptchaDialog.a(VKCaptchaDialog.this);
            dialogInterface.dismiss();
        }
    }

    public class d implements DialogInterface.OnCancelListener {
        public final /* synthetic */ AlertDialog a;

        public d(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.a.dismiss();
            VKCaptchaDialog.this.a.request.cancel();
        }
    }

    public class e extends VKImageOperation.VKImageOperationListener {
        public e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, java.lang.Object] */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onComplete(VKImageOperation vKImageOperation, Bitmap bitmap) {
            VKCaptchaDialog.this.c.setImageBitmap(bitmap);
            VKCaptchaDialog.this.c.setVisibility(0);
            VKCaptchaDialog.this.d.setVisibility(8);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.vk.sdk.api.httpClient.VKAbstractOperation, com.vk.sdk.api.VKError] */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onError(VKImageOperation vKImageOperation, VKError vKError) {
            VKCaptchaDialog.this.b();
        }
    }

    public VKCaptchaDialog(VKError vKError) {
        this.a = vKError;
    }

    public static void a(VKCaptchaDialog vKCaptchaDialog) {
        vKCaptchaDialog.a.answerCaptcha(vKCaptchaDialog.b.getText() != null ? vKCaptchaDialog.b.getText().toString() : "");
    }

    public final void b() {
        VKImageOperation vKImageOperation = new VKImageOperation(this.a.captchaImg);
        vKImageOperation.imageDensity = this.e;
        vKImageOperation.setImageOperationListener(new e());
        VKHttpClient.enqueueOperation(vKImageOperation);
    }

    public void show(@NonNull Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        View inflate = View.inflate(context, R.layout.vk_captcha_dialog, null);
        this.b = (EditText) inflate.findViewById(R.id.captchaAnswer);
        this.c = (ImageView) inflate.findViewById(R.id.imageView);
        this.d = (ProgressBar) inflate.findViewById(R.id.progressBar);
        this.e = context.getResources().getDisplayMetrics().density;
        AlertDialog create = new AlertDialog.Builder(context).setView(inflate).create();
        this.b.setOnFocusChangeListener(new a(this, create));
        this.b.setOnEditorActionListener(new b(create));
        create.setButton(-2, context.getString(17039370), new c());
        create.setOnCancelListener(new d(create));
        if (onDismissListener != null) {
            create.setOnDismissListener(onDismissListener);
        }
        b();
        create.show();
    }
}
