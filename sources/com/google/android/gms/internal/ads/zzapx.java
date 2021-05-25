package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
public final class zzapx extends zzaqg {
    private final Map<String, String> zzcyu;
    private final Context zzvr;

    public zzapx(zzbfq zzbfq, Map<String, String> map) {
        super(zzbfq, "storePicture");
        this.zzcyu = map;
        this.zzvr = zzbfq.zzzq();
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdx("Activity context is not available");
            return;
        }
        zzp.zzkp();
        if (!zzayh.zzat(this.zzvr).zzra()) {
            zzdx("Feature is not supported by the device.");
            return;
        }
        String str = this.zzcyu.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdx("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdx(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzp.zzkp();
            if (!zzayh.zzeo(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdx(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzp.zzkt().getResources();
            zzp.zzkp();
            AlertDialog.Builder zzas = zzayh.zzas(this.zzvr);
            zzas.setTitle(resources != null ? resources.getString(R.string.s1) : "Save image");
            zzas.setMessage(resources != null ? resources.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
            zzas.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzaqa(this, str, lastPathSegment));
            zzas.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzapz(this));
            zzas.create().show();
        }
    }
}
