package a2.j.a.a;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.reward.AdMetadataListener;
public final class a extends AdMetadataListener {
    public final /* synthetic */ AbstractAdViewAdapter a;

    public a(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.a.zzmm != null && this.a.zzmn != null) {
            this.a.zzmn.zzb(this.a.zzmm.getAdMetadata());
        }
    }
}
