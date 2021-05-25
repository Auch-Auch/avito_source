package com.vk.sdk.dialogs;

import a2.s.a.b.c;
import a2.s.a.b.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.vk.sdk.R;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKImageOperation;
import com.vk.sdk.api.model.VKApiLink;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;
import com.vk.sdk.dialogs.VKShareDialogBuilder;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
public class VKShareDialogDelegate {
    public EditText a;
    public Button b;
    public ProgressBar c;
    public LinearLayout d;
    public HorizontalScrollView e;
    public b f;
    public VKUploadImage[] g;
    public VKPhotoArray h;
    public CharSequence i;
    public VKShareDialogBuilder.VKShareDialogListener j;
    public final DialogFragmentI k;
    public View.OnClickListener l = new a();

    public interface DialogFragmentI {
        void dismissAllowingStateLoss();

        Activity getActivity();

        Dialog getDialog();

        Resources getResources();
    }

    public class a implements View.OnClickListener {

        /* renamed from: com.vk.sdk.dialogs.VKShareDialogDelegate$a$a  reason: collision with other inner class name */
        public class C0325a extends VKRequest.VKRequestListener {
            public C0325a() {
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                VKShareDialogDelegate.c(VKShareDialogDelegate.this, new VKAttachments((VKPhotoArray) vKResponse.parsedModel));
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                VKShareDialogDelegate.b(VKShareDialogDelegate.this, false);
                VKShareDialogBuilder.VKShareDialogListener vKShareDialogListener = VKShareDialogDelegate.this.j;
                if (vKShareDialogListener != null) {
                    vKShareDialogListener.onVkShareError(vKError);
                }
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VKShareDialogDelegate.b(VKShareDialogDelegate.this, true);
            if (VKShareDialogDelegate.this.g == null || VKSdk.getAccessToken() == null) {
                VKShareDialogDelegate.c(VKShareDialogDelegate.this, null);
                return;
            }
            new VKUploadWallPhotoRequest(VKShareDialogDelegate.this.g, Long.valueOf(Long.parseLong(VKSdk.getAccessToken().userId)).longValue(), 0).executeWithListener(new C0325a());
        }
    }

    public VKShareDialogDelegate(DialogFragmentI dialogFragmentI) {
        this.k = dialogFragmentI;
    }

    public static void a(VKShareDialogDelegate vKShareDialogDelegate, String str) {
        Objects.requireNonNull(vKShareDialogDelegate);
        VKImageOperation vKImageOperation = new VKImageOperation(str);
        vKImageOperation.setImageOperationListener(new c(vKShareDialogDelegate, str, 0));
        VKHttpClient.enqueueOperation(vKImageOperation);
    }

    public static void b(VKShareDialogDelegate vKShareDialogDelegate, boolean z) {
        if (z) {
            vKShareDialogDelegate.b.setVisibility(8);
            vKShareDialogDelegate.c.setVisibility(0);
            vKShareDialogDelegate.a.setEnabled(false);
            vKShareDialogDelegate.d.setEnabled(false);
            return;
        }
        vKShareDialogDelegate.b.setVisibility(0);
        vKShareDialogDelegate.c.setVisibility(8);
        vKShareDialogDelegate.a.setEnabled(true);
        vKShareDialogDelegate.d.setEnabled(true);
    }

    public static void c(VKShareDialogDelegate vKShareDialogDelegate, VKAttachments vKAttachments) {
        Objects.requireNonNull(vKShareDialogDelegate);
        if (vKAttachments == null) {
            vKAttachments = new VKAttachments();
        }
        VKPhotoArray vKPhotoArray = vKShareDialogDelegate.h;
        if (vKPhotoArray != null) {
            vKAttachments.addAll(vKPhotoArray);
        }
        b bVar = vKShareDialogDelegate.f;
        if (bVar != null) {
            vKAttachments.add((VKAttachments) new VKApiLink(bVar.b));
        }
        String obj = vKShareDialogDelegate.a.getText().toString();
        VKApi.wall().post(VKParameters.from(VKApiConst.OWNER_ID, Long.valueOf(Long.parseLong(VKSdk.getAccessToken().userId)), "message", obj, VKApiConst.ATTACHMENTS, vKAttachments.toAttachmentsString())).executeWithListener(new d(vKShareDialogDelegate));
    }

    public final void d(Bitmap bitmap) {
        Bitmap roundedCornerBitmap;
        if (this.k.getActivity() != null && (roundedCornerBitmap = VKUIHelper.getRoundedCornerBitmap(bitmap, 100, 3)) != null) {
            ImageView imageView = new ImageView(this.k.getActivity());
            imageView.setImageBitmap(roundedCornerBitmap);
            imageView.setAdjustViewBounds(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(this.d.getChildCount() > 0 ? 10 : 0, 0, 0, 0);
            this.d.addView(imageView, layoutParams);
            this.d.invalidate();
            this.e.invalidate();
        }
    }

    public Dialog e(Bundle bundle) {
        Activity activity = this.k.getActivity();
        View inflate = View.inflate(activity, R.layout.vk_share_dialog, null);
        this.b = (Button) inflate.findViewById(R.id.sendButton);
        this.c = (ProgressBar) inflate.findViewById(R.id.sendProgress);
        this.d = (LinearLayout) inflate.findViewById(R.id.imagesContainer);
        this.a = (EditText) inflate.findViewById(R.id.shareText);
        this.e = (HorizontalScrollView) inflate.findViewById(R.id.imagesScrollView);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.attachmentLinkLayout);
        this.b.setOnClickListener(this.l);
        if (bundle != null) {
            this.a.setText(bundle.getString("ShareText"));
            this.f = (b) bundle.getParcelable("ShareLink");
            this.g = (VKUploadImage[]) bundle.getParcelableArray("ShareImages");
            this.h = (VKPhotoArray) bundle.getParcelable("ShareUploadedImages");
        } else {
            CharSequence charSequence = this.i;
            if (charSequence != null) {
                this.a.setText(charSequence);
            }
        }
        this.d.removeAllViews();
        VKUploadImage[] vKUploadImageArr = this.g;
        if (vKUploadImageArr != null) {
            for (VKUploadImage vKUploadImage : vKUploadImageArr) {
                d(vKUploadImage.mImageData);
            }
            this.d.setVisibility(0);
        }
        if (this.h != null) {
            ArrayList arrayList = new ArrayList(this.h.size());
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                VKApiPhoto vKApiPhoto = (VKApiPhoto) it.next();
                StringBuilder L = a2.b.a.a.a.L("");
                L.append(vKApiPhoto.owner_id);
                L.append('_');
                L.append(vKApiPhoto.id);
                arrayList.add(L.toString());
            }
            new VKRequest("photos.getById", VKParameters.from(VKApiConst.PHOTO_SIZES, 1, "photos", VKStringJoiner.join(arrayList, ",")), VKPhotoArray.class).executeWithListener(new a2.s.a.b.a(this));
        }
        if (this.h == null && this.g == null) {
            this.d.setVisibility(8);
        }
        if (this.f != null) {
            ((TextView) linearLayout.findViewById(R.id.linkTitle)).setText(this.f.a);
            ((TextView) linearLayout.findViewById(R.id.linkHost)).setText(VKUtil.getHost(this.f.b));
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        dialog.setCancelable(true);
        return dialog;
    }

    public void f(Bundle bundle) {
        bundle.putString("ShareText", this.a.getText().toString());
        b bVar = this.f;
        if (bVar != null) {
            bundle.putParcelable("ShareLink", bVar);
        }
        VKUploadImage[] vKUploadImageArr = this.g;
        if (vKUploadImageArr != null) {
            bundle.putParcelableArray("ShareImages", vKUploadImageArr);
        }
        VKPhotoArray vKPhotoArray = this.h;
        if (vKPhotoArray != null) {
            bundle.putParcelable("ShareUploadedImages", vKPhotoArray);
        }
    }

    public void g() {
        Display defaultDisplay = ((WindowManager) this.k.getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int dimensionPixelSize = point.x - (this.k.getResources().getDimensionPixelSize(R.dimen.vk_share_dialog_view_padding) * 2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.k.getDialog().getWindow().getAttributes());
        layoutParams.height = -2;
        layoutParams.width = dimensionPixelSize;
        this.k.getDialog().getWindow().setAttributes(layoutParams);
    }

    public static class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public String a;
        public String b;

        public static class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, (a2.s.a.b.a) null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }

        public b(Parcel parcel, a2.s.a.b.a aVar) {
            this.a = parcel.readString();
            this.b = parcel.readString();
        }
    }
}
