package com.google.android.exoplayer2.drm;

import a2.b.a.a.a;
import a2.j.b.b.t0.h;
import a2.j.b.b.t0.i;
import a2.j.b.b.t0.j;
import a2.j.b.b.t0.k;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RequiresApi(18)
public final class FrameworkMediaDrm implements ExoMediaDrm {
    public static final ExoMediaDrm.Provider DEFAULT_PROVIDER = i.a;
    public final UUID a;
    public final MediaDrm b;
    public int c = 1;

    public FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        MediaDrm mediaDrm = new MediaDrm(a(uuid));
        this.b = mediaDrm;
        if (C.WIDEVINE_UUID.equals(uuid) && "ASUS_Z00AD".equals(Util.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    public static UUID a(UUID uuid) {
        return (Util.SDK_INT >= 27 || !C.CLEARKEY_UUID.equals(uuid)) ? uuid : C.COMMON_PSSH_UUID;
    }

    public static boolean isCryptoSchemeSupported(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(a(uuid));
    }

    public static FrameworkMediaDrm newInstance(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void acquire() {
        Assertions.checkState(this.c > 0);
        this.c++;
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] bArr) {
        this.b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Class<FrameworkMediaCrypto> getExoMediaCryptoType() {
        return FrameworkMediaCrypto.class;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019f, code lost:
        if ("AFTT".equals(r3) == false) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a5, code lost:
        if (r1 != null) goto L_0x01a9;
     */
    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] r15, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> r16, int r17, @androidx.annotation.Nullable java.util.HashMap<java.lang.String, java.lang.String> r18) throws android.media.NotProvisionedException {
        /*
        // Method dump skipped, instructions count: 560
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.FrameworkMediaDrm.getKeyRequest(byte[], java.util.List, int, java.util.HashMap):com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest");
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public PersistableBundle getMetrics() {
        if (Util.SDK_INT < 28) {
            return null;
        }
        return this.b.getMetrics();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String str) {
        return this.b.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String str) {
        return this.b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() throws MediaDrmException {
        return this.b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.CLEARKEY_UUID.equals(this.a) && Util.SDK_INT < 27) {
            try {
                JSONObject jSONObject = new JSONObject(Util.fromUtf8Bytes(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = Util.getUtf8Bytes(sb.toString());
            } catch (JSONException e) {
                StringBuilder L = a.L("Failed to adjust response data: ");
                L.append(Util.fromUtf8Bytes(bArr2));
                Log.e("ClearKeyUtil", L.toString(), e);
            }
        }
        return this.b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public synchronized void release() {
        int i = this.c - 1;
        this.c = i;
        if (i == 0) {
            this.b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(@Nullable ExoMediaDrm.OnEventListener onEventListener) {
        j jVar;
        MediaDrm mediaDrm = this.b;
        if (onEventListener == null) {
            jVar = null;
        } else {
            jVar = new MediaDrm.OnEventListener(onEventListener) { // from class: a2.j.b.b.t0.j
                public final /* synthetic */ ExoMediaDrm.OnEventListener b;

                {
                    this.b = r2;
                }

                @Override // android.media.MediaDrm.OnEventListener
                public final void onEvent(MediaDrm mediaDrm2, byte[] bArr, int i, int i2, byte[] bArr2) {
                    FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                    ExoMediaDrm.OnEventListener onEventListener2 = this.b;
                    Objects.requireNonNull(frameworkMediaDrm);
                    onEventListener2.onEvent(frameworkMediaDrm, bArr, i, i2, bArr2);
                }
            };
        }
        mediaDrm.setOnEventListener(jVar);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnExpirationUpdateListener(@Nullable ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        k kVar;
        if (Util.SDK_INT >= 23) {
            MediaDrm mediaDrm = this.b;
            if (onExpirationUpdateListener == null) {
                kVar = null;
            } else {
                kVar = new MediaDrm.OnExpirationUpdateListener(onExpirationUpdateListener) { // from class: a2.j.b.b.t0.k
                    public final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener b;

                    {
                        this.b = r2;
                    }

                    @Override // android.media.MediaDrm.OnExpirationUpdateListener
                    public final void onExpirationUpdate(MediaDrm mediaDrm2, byte[] bArr, long j) {
                        FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                        ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener2 = this.b;
                        Objects.requireNonNull(frameworkMediaDrm);
                        onExpirationUpdateListener2.onExpirationUpdate(frameworkMediaDrm, bArr, j);
                    }
                };
            }
            mediaDrm.setOnExpirationUpdateListener(kVar, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    @RequiresApi(23)
    public void setOnKeyStatusChangeListener(@Nullable ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        h hVar;
        if (Util.SDK_INT >= 23) {
            MediaDrm mediaDrm = this.b;
            if (onKeyStatusChangeListener == null) {
                hVar = null;
            } else {
                hVar = new MediaDrm.OnKeyStatusChangeListener(onKeyStatusChangeListener) { // from class: a2.j.b.b.t0.h
                    public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener b;

                    {
                        this.b = r2;
                    }

                    @Override // android.media.MediaDrm.OnKeyStatusChangeListener
                    public final void onKeyStatusChange(MediaDrm mediaDrm2, byte[] bArr, List list, boolean z) {
                        FrameworkMediaDrm frameworkMediaDrm = FrameworkMediaDrm.this;
                        ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2 = this.b;
                        Objects.requireNonNull(frameworkMediaDrm);
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it.next();
                            arrayList.add(new ExoMediaDrm.KeyStatus(keyStatus.getStatusCode(), keyStatus.getKeyId()));
                        }
                        onKeyStatusChangeListener2.onKeyStatusChange(frameworkMediaDrm, bArr, arrayList, z);
                    }
                };
            }
            mediaDrm.setOnKeyStatusChangeListener(hVar, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String str, byte[] bArr) {
        this.b.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String str, String str2) {
        this.b.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.ExoMediaDrm
    public FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        return new FrameworkMediaCrypto(a(this.a), bArr, Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.a) && "L3".equals(getPropertyString("securityLevel")));
    }
}
