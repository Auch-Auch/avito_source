package org.spongycastle.crypto;
public enum PasswordConverter implements CharToByteConverter {
    ASCII {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(cArr);
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "ASCII";
        }
    },
    UTF8 {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "UTF8";
        }
    },
    PKCS12 {
        @Override // org.spongycastle.crypto.CharToByteConverter
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        }

        @Override // org.spongycastle.crypto.CharToByteConverter
        public String getType() {
            return "PKCS12";
        }
    };

    /* access modifiers changed from: public */
    PasswordConverter(a aVar) {
    }
}
