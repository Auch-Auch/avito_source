package com.sumsub.sns.core.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\b\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants;", "", "", "CLIENT_ID", "Ljava/lang/String;", "PREFERENCES_NAME", "DEFAULT_COUNTRY", "PLATFORM", "<init>", "()V", "Arguments", "ErrorCode", "Extra", "Header", "Intent", "LinkType", "Preference", "Resources", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSConstants {
    @NotNull
    public static final String CLIENT_ID = "msdk2";
    @NotNull
    public static final String DEFAULT_COUNTRY = "ATA";
    @NotNull
    public static final SNSConstants INSTANCE = new SNSConstants();
    @NotNull
    public static final String PLATFORM = "Android";
    @NotNull
    public static final String PREFERENCES_NAME = "idensic_mobile_sdk";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Arguments;", "", "", Arguments.ARGS_ACTION_ID, "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Arguments {
        @NotNull
        public static final String ARGS_ACTION_ID = "ARGS_ACTION_ID";
        @NotNull
        public static final Arguments INSTANCE = new Arguments();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$ErrorCode;", "", "", "UNSUPPORTED_FILE_FORMAT", "I", "OLD_PASSWORD_MISMATCH", "NO_UPLOAD_VERIFICATION_IN_PROGRESS", "INCORRECT_FILE_SIZE", "RECENT_PASSWORD_REUSE", "WEAK_PASSWORD", "INVALID_USER_NAME_OR_PASSWORD", "CORRUPTED_FILE", "TOO_MANY_DOCUMENTS", "EMPTY_FILE", "ACCOUNT_LOCKED", "DUPLICATE_DOCUMENT", "PASSWORD_RESET_LINK_IS_INVALID", "FILE_TOO_BIG", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorCode {
        public static final int ACCOUNT_LOCKED = 2001;
        public static final int CORRUPTED_FILE = 1004;
        public static final int DUPLICATE_DOCUMENT = 1000;
        public static final int EMPTY_FILE = 1003;
        public static final int FILE_TOO_BIG = 1002;
        public static final int INCORRECT_FILE_SIZE = 1007;
        @NotNull
        public static final ErrorCode INSTANCE = new ErrorCode();
        public static final int INVALID_USER_NAME_OR_PASSWORD = 2000;
        public static final int NO_UPLOAD_VERIFICATION_IN_PROGRESS = 1006;
        public static final int OLD_PASSWORD_MISMATCH = 2002;
        public static final int PASSWORD_RESET_LINK_IS_INVALID = 2005;
        public static final int RECENT_PASSWORD_REUSE = 2004;
        public static final int TOO_MANY_DOCUMENTS = 1001;
        public static final int UNSUPPORTED_FILE_FORMAT = 1005;
        public static final int WEAK_PASSWORD = 2003;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Extra;", "", "", Extra.DOCUMENT_RESULT, "Ljava/lang/String;", Extra.DOCUMENT_COUNTRY, "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Extra {
        @NotNull
        public static final String DOCUMENT_COUNTRY = "DOCUMENT_COUNTRY";
        @NotNull
        public static final String DOCUMENT_RESULT = "DOCUMENT_RESULT";
        @NotNull
        public static final Extra INSTANCE = new Extra();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Header;", "", "", "CLIENT_ID", "Ljava/lang/String;", "ACCESS_TOKEN", "APPLICANT_ID", "MOBILE_DEVICE_ID", "DEBUG", "MOBILE_FINGERPRINT", "MOBILE_OS_VERSION", "MOBILE_SDK_LOCALE", "VIDEO_SELFIE_PHRASE", "MOBILE_DEVICE", "MOBILE_SDK_VERSION", "MOBILE_APPLICATION_VERSION", "MOBILE_APPLICATION", "MOBILE_OS", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Header {
        @NotNull
        public static final String ACCESS_TOKEN = "X-Access-Token";
        @NotNull
        public static final String APPLICANT_ID = "X-Applicant-Id";
        @NotNull
        public static final String CLIENT_ID = "X-Client-Id";
        @NotNull
        public static final String DEBUG = "X-Debug";
        @NotNull
        public static final Header INSTANCE = new Header();
        @NotNull
        public static final String MOBILE_APPLICATION = "X-Mob-App";
        @NotNull
        public static final String MOBILE_APPLICATION_VERSION = "X-Mob-App-Ver";
        @NotNull
        public static final String MOBILE_DEVICE = "X-Mob-Dev";
        @NotNull
        public static final String MOBILE_DEVICE_ID = "X-Mob-Dev-Id";
        @NotNull
        public static final String MOBILE_FINGERPRINT = "X-Device-Fingerprint";
        @NotNull
        public static final String MOBILE_OS = "X-Mob-OS";
        @NotNull
        public static final String MOBILE_OS_VERSION = "X-Mob-OS-Ver";
        @NotNull
        public static final String MOBILE_SDK_LOCALE = "X-Mob-Sdk-Locale";
        @NotNull
        public static final String MOBILE_SDK_VERSION = "X-Mob-Sdk-Ver";
        @NotNull
        public static final String VIDEO_SELFIE_PHRASE = "X-Video-Selfie-Phrase";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Intent;", "", "", "SNS_ACTION_CLOSE", "Ljava/lang/String;", "SNS_APP", "SNS_EXTRA_DOCUMENT", "SNS_EXTRA_SESSION", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Intent {
        @NotNull
        public static final Intent INSTANCE = new Intent();
        @NotNull
        public static final String SNS_ACTION_CLOSE = "com.sumsub.sns.intent.ACTION_CLOSE";
        @NotNull
        public static final String SNS_APP = "com.sumsub.sns.presentation.screen.SNSAppActivity";
        @NotNull
        public static final String SNS_EXTRA_DOCUMENT = "sns_extra_document";
        @NotNull
        public static final String SNS_EXTRA_SESSION = "sns_extra_session";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$LinkType;", "", "", "PP", "Ljava/lang/String;", "SUPPORT", "GTC", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class LinkType {
        @NotNull
        public static final String GTC = "gtc";
        @NotNull
        public static final LinkType INSTANCE = new LinkType();
        @NotNull
        public static final String PP = "pp";
        @NotNull
        public static final String SUPPORT = "support";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Preference;", "", "", "KEY_DONT_SHOW_SETTINGS_DIALOG", "Ljava/lang/String;", "KEY_DEVICE_ID", "KEY_APPLICANT_ID", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Preference {
        @NotNull
        public static final Preference INSTANCE = new Preference();
        @NotNull
        public static final String KEY_APPLICANT_ID = "applicant_id";
        @NotNull
        public static final String KEY_DEVICE_ID = "device_id";
        @NotNull
        public static final String KEY_DONT_SHOW_SETTINGS_DIALOG = "dont_show_settings_dialog";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Resources;", "", "<init>", "()V", "Key", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Resources {
        @NotNull
        public static final Resources INSTANCE = new Resources();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/common/SNSConstants$Resources$Key;", "", "", "IDENTITY_SELECTOR_DOCUMENT_LIST_EMPTY", "Ljava/lang/String;", "DOCUMENT_TITLE", "SCAN_HELPER_FRONT_SIDE_BRIEF", "SCAN_HELPER_BACK_SIDE_DETAILS", "IDENTITY_SELECTOR_FOOTER", "SCAN_HELPER_BACK_SIDE_TITLE", "APPLICANT_FIELD_KEY", "IDENTITY_SELECTOR_DOCUMENT_TITLE", "APPLICANT_CUSTOM_FIELD_KEY", "SCAN_HELPER_FRONT_SIDE_DETAILS", "FACESCAN_TITLE_KEY", "DOCUMENT_PROMPT", "IDENTITY_SELECTOR_COUNTRY_HINT", "SCAN_HELPER_BACK_SIDE_BRIEF", "IDENTITY_SELECTOR_COUNTRY_TITLE", "IDENTITY_TITLE", "SCAN_HELPER_FRONT_SIDE_TITLE", "FACESCAN_TEXT_KEY", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Key {
            @NotNull
            public static final String APPLICANT_CUSTOM_FIELD_KEY = "sns_data_custom_field_%s";
            @NotNull
            public static final String APPLICANT_FIELD_KEY = "sns_data_field_%s";
            @NotNull
            public static final String DOCUMENT_PROMPT = "sns_step_%s_prompt";
            @NotNull
            public static final String DOCUMENT_TITLE = "sns_step_%s_title";
            @NotNull
            public static final String FACESCAN_TEXT_KEY = "sns_facescan_result_%s_text";
            @NotNull
            public static final String FACESCAN_TITLE_KEY = "sns_facescan_result_%s_title";
            @NotNull
            public static final String IDENTITY_SELECTOR_COUNTRY_HINT = "sns_step_%s_selector_country_placeholder";
            @NotNull
            public static final String IDENTITY_SELECTOR_COUNTRY_TITLE = "sns_step_%s_selector_country_prompt";
            @NotNull
            public static final String IDENTITY_SELECTOR_DOCUMENT_LIST_EMPTY = "sns_step_%s_selector_iddoc_listIsEmpty";
            @NotNull
            public static final String IDENTITY_SELECTOR_DOCUMENT_TITLE = "sns_step_%s_selector_iddoc_prompt";
            @NotNull
            public static final String IDENTITY_SELECTOR_FOOTER = "sns_step_%s_selector_footerHtml";
            @NotNull
            public static final String IDENTITY_TITLE = "sns_iddoc_type_%s";
            @NotNull
            public static final Key INSTANCE = new Key();
            @NotNull
            public static final String SCAN_HELPER_BACK_SIDE_BRIEF = "sns_step_%s_scan_backSide_brief";
            @NotNull
            public static final String SCAN_HELPER_BACK_SIDE_DETAILS = "sns_step_%s_scan_backSide_details";
            @NotNull
            public static final String SCAN_HELPER_BACK_SIDE_TITLE = "sns_step_%s_scan_backSide_title";
            @NotNull
            public static final String SCAN_HELPER_FRONT_SIDE_BRIEF = "sns_step_%s_scan_frontSide_brief";
            @NotNull
            public static final String SCAN_HELPER_FRONT_SIDE_DETAILS = "sns_step_%s_scan_frontSide_details";
            @NotNull
            public static final String SCAN_HELPER_FRONT_SIDE_TITLE = "sns_step_%s_scan_frontSide_title";
        }
    }
}
