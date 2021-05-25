package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
@VisibleForTesting
public class TagManagerPreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getData() != null) {
            zzbf.zza(getIntent(), this);
        }
    }
}
