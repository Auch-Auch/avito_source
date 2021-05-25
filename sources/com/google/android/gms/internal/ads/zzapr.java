package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.spongycastle.i18n.ErrorBundle;
public final class zzapr extends zzaqg {
    private final Map<String, String> zzcyu;
    private String zzdma = zzdv("description");
    private long zzdmb = zzdw("start_ticks");
    private long zzdmc = zzdw("end_ticks");
    private String zzdmd = zzdv(ErrorBundle.SUMMARY_ENTRY);
    private String zzdme = zzdv("location");
    private final Context zzvr;

    public zzapr(zzbfq zzbfq, Map<String, String> map) {
        super(zzbfq, "createCalendarEvent");
        this.zzcyu = map;
        this.zzvr = zzbfq.zzzq();
    }

    private final String zzdv(String str) {
        return TextUtils.isEmpty(this.zzcyu.get(str)) ? "" : this.zzcyu.get(str);
    }

    private final long zzdw(String str) {
        String str2 = this.zzcyu.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdma);
        data.putExtra("eventLocation", this.zzdme);
        data.putExtra("description", this.zzdmd);
        long j = this.zzdmb;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdmc;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.zzvr == null) {
            zzdx("Activity context is not available.");
            return;
        }
        zzp.zzkp();
        if (!zzayh.zzat(this.zzvr).zzrb()) {
            zzdx("This feature is not available on the device.");
            return;
        }
        zzp.zzkp();
        AlertDialog.Builder zzas = zzayh.zzas(this.zzvr);
        Resources resources = zzp.zzkt().getResources();
        zzas.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzas.setMessage(resources != null ? resources.getString(R.string.f60s6) : "Allow Ad to create a calendar event?");
        zzas.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzapu(this));
        zzas.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzapt(this));
        zzas.create().show();
    }
}
