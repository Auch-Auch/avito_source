package com.avito.android.license;
public interface LicenseView {

    public static class Simple implements LicenseView {
        @Override // com.avito.android.license.LicenseView
        public void handleError(Exception exc) {
        }

        @Override // com.avito.android.license.LicenseView
        public void onLoadingFinish() {
        }

        @Override // com.avito.android.license.LicenseView
        public void onLoadingStart() {
        }

        @Override // com.avito.android.license.LicenseView
        public void showLicense(String str) {
        }
    }

    void handleError(Exception exc);

    void onLoadingFinish();

    void onLoadingStart();

    void showLicense(String str);
}
