package com.google.android.play.core.assetpacks;

import a2.j.b.e.a.b.f0;
import a2.j.b.e.a.b.t0;
import a2.j.b.e.a.b.x;
import android.os.Bundle;
import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.h;
public abstract class AssetPackState {
    public static AssetPackState a(Bundle bundle, String str, t0 t0Var, x xVar) {
        return a(str, xVar.a(bundle.getInt(h.a("status", str)), str), bundle.getInt(h.a("error_code", str)), bundle.getLong(h.a("bytes_downloaded", str)), bundle.getLong(h.a("total_bytes_to_download", str)), t0Var.b(str));
    }

    public static AssetPackState a(String str, @AssetPackStatus int i, @AssetPackErrorCode int i2, long j, long j2, double d) {
        return new f0(str, i, i2, j, j2, (int) Math.rint(100.0d * d));
    }

    public abstract long bytesDownloaded();

    @AssetPackErrorCode
    public abstract int errorCode();

    public abstract String name();

    @AssetPackStatus
    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}
