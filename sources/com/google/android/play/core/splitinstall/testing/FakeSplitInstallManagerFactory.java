package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.common.LocalTestingException;
import java.io.File;
public class FakeSplitInstallManagerFactory {
    public static FakeSplitInstallManager a;

    public static FakeSplitInstallManager create(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("local_testing_dir");
                if (string != null) {
                    File file = new File(context.getExternalFilesDir(null), string);
                    if (file.exists()) {
                        return create(context, file);
                    }
                    throw new LocalTestingException(String.format("Local testing directory not found: %s", string));
                }
                throw new LocalTestingException(String.format("<meta-data> element missing %s value.", "local_testing_dir"));
            }
            throw new LocalTestingException("Missing <meta-data> element in the manifest.");
        } catch (PackageManager.NameNotFoundException e) {
            throw new LocalTestingException(e);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static synchronized FakeSplitInstallManager create(Context context, File file) {
        FakeSplitInstallManager fakeSplitInstallManager;
        synchronized (FakeSplitInstallManagerFactory.class) {
            FakeSplitInstallManager fakeSplitInstallManager2 = a;
            if (fakeSplitInstallManager2 == null) {
                try {
                    a = new FakeSplitInstallManager(context, file);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (!fakeSplitInstallManager2.h.getAbsolutePath().equals(file.getAbsolutePath())) {
                throw new RuntimeException(String.format("Different module directories used to initialize FakeSplitInstallManager: '%s' and '%s'", a.h.getAbsolutePath(), file.getAbsolutePath()));
            }
            fakeSplitInstallManager = a;
        }
        return fakeSplitInstallManager;
    }
}
