package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import org.spongycastle.asn1.cmc.BodyPartID;
public class ExifInterface {
    public static final byte[] A = {109, 105, 102, 49};
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final byte[] B = {104, 101, 105, 99};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final byte[] C = {79, 76, 89, 77, 80, 0};
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final byte[] D = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    public static final byte[] E = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final byte[] F = {101, 88, 73, 102};
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final byte[] G = {73, 72, 68, 82};
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    public static final byte[] H = {73, 69, 78, 68};
    public static final byte[] I = {82, 73, 70, 70};
    public static final byte[] J = {87, 69, 66, 80};
    public static final byte[] K = {69, 88, 73, 70};
    public static final byte[] L = {-99, 1, 42};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte[] M = "VP8X".getBytes(Charset.defaultCharset());
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    public static final byte[] N = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] O = "VP8 ".getBytes(Charset.defaultCharset());
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    public static final byte[] P = "ANIM".getBytes(Charset.defaultCharset());
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    public static final byte[] Q = "ANMF".getBytes(Charset.defaultCharset());
    public static SimpleDateFormat R = null;
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    public static SimpleDateFormat S = null;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    public static final String[] T = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    public static final int[] U = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] V = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final e[] W;
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final e[] X;
    public static final e[] Y;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    public static final e[] Z;
    public static final e[] a0;
    public static final e b0 = new e(TAG_STRIP_OFFSETS, 273, 3);
    public static final e[] c0;
    public static final e[] d0;
    public static final e[] e0;
    public static final e[] f0;
    public static final e[][] g0;
    public static final e[] h0 = {new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
    public static final e i0 = new e(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
    public static final e j0 = new e(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
    public static final HashMap<Integer, e>[] k0;
    public static final HashMap<String, e>[] l0;
    public static final HashSet<String> m0 = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
    public static final HashMap<Integer, Integer> n0 = new HashMap<>();
    public static final Charset o0;
    public static final byte[] p0;
    public static final byte[] q0;
    public static final Pattern r0 = Pattern.compile(".*[1-9].*");
    public static final Pattern s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final Pattern t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final Pattern u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    public static final boolean v = Log.isLoggable("ExifInterface", 3);
    public static final List<Integer> w = Arrays.asList(1, 6, 3, 8);
    public static final List<Integer> x = Arrays.asList(2, 7, 4, 5);
    public static final byte[] y = {-1, -40, -1};
    public static final byte[] z = {102, 116, 121, 112};
    public String a;
    public FileDescriptor b;
    public AssetManager.AssetInputStream c;
    public int d;
    public boolean e;
    public final HashMap<String, d>[] f;
    public Set<Integer> g;
    public ByteOrder h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public byte[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IfdType {
    }

    public class a extends MediaDataSource {
        public long a;
        public final /* synthetic */ b b;

        public a(ExifInterface exifInterface, b bVar) {
            this.b = bVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.a;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + ((long) this.b.available())) {
                        return -1;
                    }
                    this.b.b(j);
                    this.a = j;
                }
                if (i2 > this.b.available()) {
                    i2 = this.b.available();
                }
                b bVar = this.b;
                int read = bVar.a.read(bArr, i, i2);
                bVar.d += read;
                if (read >= 0) {
                    this.a += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.a = -1;
            return -1;
        }
    }

    public static class c extends FilterOutputStream {
        public final OutputStream a;
        public ByteOrder b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.a = outputStream;
            this.b = byteOrder;
        }

        public void a(int i) throws IOException {
            ByteOrder byteOrder = this.b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.a.write((i >>> 0) & 255);
                this.a.write((i >>> 8) & 255);
                this.a.write((i >>> 16) & 255);
                this.a.write((i >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.a.write((i >>> 24) & 255);
                this.a.write((i >>> 16) & 255);
                this.a.write((i >>> 8) & 255);
                this.a.write((i >>> 0) & 255);
            }
        }

        public void b(short s) throws IOException {
            ByteOrder byteOrder = this.b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.a.write((s >>> 0) & 255);
                this.a.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.a.write((s >>> 8) & 255);
                this.a.write((s >>> 0) & 255);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }
    }

    public static class f {
        public final long a;
        public final long b;

        public f(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        public String toString() {
            return this.a + "/" + this.b;
        }

        public f(long j, long j2) {
            if (j2 == 0) {
                this.a = 0;
                this.b = 1;
                return;
            }
            this.a = j;
            this.b = j2;
        }
    }

    static {
        e[] eVarArr = {new e(TAG_NEW_SUBFILE_TYPE, 254, 4), new e(TAG_SUBFILE_TYPE, 255, 4), new e(TAG_IMAGE_WIDTH, 256, 3, 4), new e(TAG_IMAGE_LENGTH, 257, 3, 4), new e(TAG_BITS_PER_SAMPLE, 258, 3), new e(TAG_COMPRESSION, 259, 3), new e(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new e(TAG_IMAGE_DESCRIPTION, 270, 2), new e(TAG_MAKE, 271, 2), new e(TAG_MODEL, 272, 2), new e(TAG_STRIP_OFFSETS, 273, 3, 4), new e(TAG_ORIENTATION, 274, 3), new e(TAG_SAMPLES_PER_PIXEL, 277, 3), new e(TAG_ROWS_PER_STRIP, 278, 3, 4), new e(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new e(TAG_X_RESOLUTION, 282, 5), new e(TAG_Y_RESOLUTION, 283, 5), new e(TAG_PLANAR_CONFIGURATION, 284, 3), new e(TAG_RESOLUTION_UNIT, 296, 3), new e(TAG_TRANSFER_FUNCTION, 301, 3), new e(TAG_SOFTWARE, 305, 2), new e(TAG_DATETIME, 306, 2), new e(TAG_ARTIST, 315, 2), new e(TAG_WHITE_POINT, 318, 5), new e(TAG_PRIMARY_CHROMATICITIES, 319, 5), new e("SubIFDPointer", 330, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new e(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new e(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new e(TAG_Y_CB_CR_POSITIONING, 531, 3), new e(TAG_REFERENCE_BLACK_WHITE, 532, 5), new e(TAG_COPYRIGHT, 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new e(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new e(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new e(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new e(TAG_RW2_ISO, 23, 3), new e(TAG_RW2_JPG_FROM_RAW, 46, 7), new e(TAG_XMP, 700, 1)};
        W = eVarArr;
        e[] eVarArr2 = {new e(TAG_EXPOSURE_TIME, 33434, 5), new e(TAG_F_NUMBER, 33437, 5), new e(TAG_EXPOSURE_PROGRAM, 34850, 3), new e(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new e(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new e(TAG_OECF, 34856, 7), new e(TAG_SENSITIVITY_TYPE, 34864, 3), new e(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new e(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new e(TAG_ISO_SPEED, 34867, 4), new e(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new e(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new e(TAG_EXIF_VERSION, 36864, 2), new e(TAG_DATETIME_ORIGINAL, 36867, 2), new e(TAG_DATETIME_DIGITIZED, 36868, 2), new e(TAG_OFFSET_TIME, 36880, 2), new e(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new e(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new e(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new e(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new e(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new e(TAG_APERTURE_VALUE, 37378, 5), new e(TAG_BRIGHTNESS_VALUE, 37379, 10), new e(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new e(TAG_MAX_APERTURE_VALUE, 37381, 5), new e(TAG_SUBJECT_DISTANCE, 37382, 5), new e(TAG_METERING_MODE, 37383, 3), new e(TAG_LIGHT_SOURCE, 37384, 3), new e(TAG_FLASH, 37385, 3), new e(TAG_FOCAL_LENGTH, 37386, 5), new e(TAG_SUBJECT_AREA, 37396, 3), new e(TAG_MAKER_NOTE, 37500, 7), new e(TAG_USER_COMMENT, 37510, 7), new e(TAG_SUBSEC_TIME, 37520, 2), new e(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new e(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new e(TAG_FLASHPIX_VERSION, 40960, 7), new e(TAG_COLOR_SPACE, 40961, 3), new e(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new e(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new e(TAG_RELATED_SOUND_FILE, 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e(TAG_FLASH_ENERGY, 41483, 5), new e(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new e(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new e(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new e(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new e(TAG_SUBJECT_LOCATION, 41492, 3), new e(TAG_EXPOSURE_INDEX, 41493, 5), new e(TAG_SENSING_METHOD, 41495, 3), new e(TAG_FILE_SOURCE, 41728, 7), new e(TAG_SCENE_TYPE, 41729, 7), new e(TAG_CFA_PATTERN, 41730, 7), new e(TAG_CUSTOM_RENDERED, 41985, 3), new e(TAG_EXPOSURE_MODE, 41986, 3), new e(TAG_WHITE_BALANCE, 41987, 3), new e(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new e(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new e(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new e(TAG_GAIN_CONTROL, 41991, 3), new e(TAG_CONTRAST, 41992, 3), new e(TAG_SATURATION, 41993, 3), new e(TAG_SHARPNESS, 41994, 3), new e(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new e(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new e(TAG_IMAGE_UNIQUE_ID, 42016, 2), new e("CameraOwnerName", 42032, 2), new e(TAG_BODY_SERIAL_NUMBER, 42033, 2), new e(TAG_LENS_SPECIFICATION, 42034, 5), new e(TAG_LENS_MAKE, 42035, 2), new e(TAG_LENS_MODEL, 42036, 2), new e(TAG_GAMMA, 42240, 5), new e(TAG_DNG_VERSION, 50706, 1), new e(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        X = eVarArr2;
        e[] eVarArr3 = {new e(TAG_GPS_VERSION_ID, 0, 1), new e(TAG_GPS_LATITUDE_REF, 1, 2), new e(TAG_GPS_LATITUDE, 2, 5, 10), new e(TAG_GPS_LONGITUDE_REF, 3, 2), new e(TAG_GPS_LONGITUDE, 4, 5, 10), new e(TAG_GPS_ALTITUDE_REF, 5, 1), new e(TAG_GPS_ALTITUDE, 6, 5), new e(TAG_GPS_TIMESTAMP, 7, 5), new e(TAG_GPS_SATELLITES, 8, 2), new e(TAG_GPS_STATUS, 9, 2), new e(TAG_GPS_MEASURE_MODE, 10, 2), new e(TAG_GPS_DOP, 11, 5), new e(TAG_GPS_SPEED_REF, 12, 2), new e(TAG_GPS_SPEED, 13, 5), new e(TAG_GPS_TRACK_REF, 14, 2), new e(TAG_GPS_TRACK, 15, 5), new e(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new e(TAG_GPS_IMG_DIRECTION, 17, 5), new e(TAG_GPS_MAP_DATUM, 18, 2), new e(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new e(TAG_GPS_DEST_LATITUDE, 20, 5), new e(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new e(TAG_GPS_DEST_LONGITUDE, 22, 5), new e(TAG_GPS_DEST_BEARING_REF, 23, 2), new e(TAG_GPS_DEST_BEARING, 24, 5), new e(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new e(TAG_GPS_DEST_DISTANCE, 26, 5), new e(TAG_GPS_PROCESSING_METHOD, 27, 7), new e(TAG_GPS_AREA_INFORMATION, 28, 7), new e(TAG_GPS_DATESTAMP, 29, 2), new e(TAG_GPS_DIFFERENTIAL, 30, 3), new e(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        Y = eVarArr3;
        e[] eVarArr4 = {new e(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        Z = eVarArr4;
        e[] eVarArr5 = {new e(TAG_NEW_SUBFILE_TYPE, 254, 4), new e(TAG_SUBFILE_TYPE, 255, 4), new e(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new e(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new e(TAG_BITS_PER_SAMPLE, 258, 3), new e(TAG_COMPRESSION, 259, 3), new e(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new e(TAG_IMAGE_DESCRIPTION, 270, 2), new e(TAG_MAKE, 271, 2), new e(TAG_MODEL, 272, 2), new e(TAG_STRIP_OFFSETS, 273, 3, 4), new e(TAG_THUMBNAIL_ORIENTATION, 274, 3), new e(TAG_SAMPLES_PER_PIXEL, 277, 3), new e(TAG_ROWS_PER_STRIP, 278, 3, 4), new e(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new e(TAG_X_RESOLUTION, 282, 5), new e(TAG_Y_RESOLUTION, 283, 5), new e(TAG_PLANAR_CONFIGURATION, 284, 3), new e(TAG_RESOLUTION_UNIT, 296, 3), new e(TAG_TRANSFER_FUNCTION, 301, 3), new e(TAG_SOFTWARE, 305, 2), new e(TAG_DATETIME, 306, 2), new e(TAG_ARTIST, 315, 2), new e(TAG_WHITE_POINT, 318, 5), new e(TAG_PRIMARY_CHROMATICITIES, 319, 5), new e("SubIFDPointer", 330, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new e(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new e(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new e(TAG_Y_CB_CR_POSITIONING, 531, 3), new e(TAG_REFERENCE_BLACK_WHITE, 532, 5), new e(TAG_COPYRIGHT, 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e(TAG_DNG_VERSION, 50706, 1), new e(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        a0 = eVarArr5;
        e[] eVarArr6 = {new e(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        c0 = eVarArr6;
        e[] eVarArr7 = {new e(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new e(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        d0 = eVarArr7;
        e[] eVarArr8 = {new e(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        e0 = eVarArr8;
        e[] eVarArr9 = {new e(TAG_COLOR_SPACE, 55, 3)};
        f0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        g0 = eVarArr10;
        k0 = new HashMap[eVarArr10.length];
        l0 = new HashMap[eVarArr10.length];
        Charset forName = Charset.forName(C.ASCII_NAME);
        o0 = forName;
        p0 = "Exif\u0000\u0000".getBytes(forName);
        q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        R = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        S = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            e[][] eVarArr11 = g0;
            if (i2 < eVarArr11.length) {
                k0[i2] = new HashMap<>();
                l0[i2] = new HashMap<>();
                e[] eVarArr12 = eVarArr11[i2];
                for (e eVar : eVarArr12) {
                    k0[i2].put(Integer.valueOf(eVar.a), eVar);
                    l0[i2].put(eVar.b, eVar);
                }
                i2++;
            } else {
                HashMap<Integer, Integer> hashMap = n0;
                e[] eVarArr13 = h0;
                hashMap.put(Integer.valueOf(eVarArr13[0].a), 5);
                hashMap.put(Integer.valueOf(eVarArr13[1].a), 1);
                hashMap.put(Integer.valueOf(eVarArr13[2].a), 2);
                hashMap.put(Integer.valueOf(eVarArr13[3].a), 3);
                hashMap.put(Integer.valueOf(eVarArr13[4].a), 7);
                hashMap.put(Integer.valueOf(eVarArr13[5].a), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        e[][] eVarArr = g0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(file, "file cannot be null");
        x(file.getAbsolutePath());
    }

    public static Long B(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null && r0.matcher(str).matches()) {
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date parse = R.parse(str, parsePosition);
                if (parse == null && (parse = S.parse(str, parsePosition)) == null) {
                    return null;
                }
                long time = parse.getTime();
                if (str3 != null) {
                    int i2 = 1;
                    String substring = str3.substring(0, 1);
                    int parseInt = Integer.parseInt(str3.substring(1, 3));
                    int parseInt2 = Integer.parseInt(str3.substring(4, 6));
                    if (("+".equals(substring) || "-".equals(substring)) && ":".equals(str3.substring(3, 4)) && parseInt <= 14) {
                        int i3 = ((parseInt * 60) + parseInt2) * 60 * 1000;
                        if (!"-".equals(substring)) {
                            i2 = -1;
                        }
                        time += (long) (i3 * i2);
                    }
                }
                if (str2 != null) {
                    try {
                        long parseLong = Long.parseLong(str2);
                        while (parseLong > 1000) {
                            parseLong /= 10;
                        }
                        time += parseLong;
                    } catch (NumberFormatException unused) {
                    }
                }
                return Long.valueOf(time);
            } catch (IllegalArgumentException unused2) {
            }
        }
        return null;
    }

    public static boolean M(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return sb.toString();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static double e(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble2 = ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + parseDouble;
            if (!str2.equals(LATITUDE_SOUTH)) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble2;
                }
            }
            return -parseDouble2;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static long[] f(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public static int g(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    public static void h(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[8192];
        while (i2 > 0) {
            int min = Math.min(i2, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i2 -= read;
                ((c) outputStream).a.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        Objects.requireNonNull(str, "mimeType shouldn't be null");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        char c2 = 65535;
        switch (lowerCase.hashCode()) {
            case -1875291391:
                if (lowerCase.equals("image/x-fuji-raf")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1635437028:
                if (lowerCase.equals("image/x-samsung-srw")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1594371159:
                if (lowerCase.equals("image/x-sony-arw")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1487464693:
                if (lowerCase.equals("image/heic")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1487464690:
                if (lowerCase.equals("image/heif")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1487394660:
                if (lowerCase.equals("image/jpeg")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1487018032:
                if (lowerCase.equals("image/webp")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1423313290:
                if (lowerCase.equals("image/x-adobe-dng")) {
                    c2 = 7;
                    break;
                }
                break;
            case -985160897:
                if (lowerCase.equals("image/x-panasonic-rw2")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -879258763:
                if (lowerCase.equals("image/png")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -332763809:
                if (lowerCase.equals("image/x-pentax-pef")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1378106698:
                if (lowerCase.equals("image/x-olympus-orf")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2099152104:
                if (lowerCase.equals("image/x-nikon-nef")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 2099152524:
                if (lowerCase.equals("image/x-nikon-nrw")) {
                    c2 = '\r';
                    break;
                }
                break;
            case 2111234748:
                if (lowerCase.equals("image/x-canon-cr2")) {
                    c2 = 14;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
                return true;
            default:
                return false;
        }
    }

    public static Pair<Integer, Integer> v(String str) {
        int i2;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> v2 = v(split[0]);
            if (((Integer) v2.first).intValue() == 2) {
                return v2;
            }
            for (int i3 = 1; i3 < split.length; i3++) {
                Pair<Integer, Integer> v3 = v(split[i3]);
                if (((Integer) v3.first).equals(v2.first) || ((Integer) v3.second).equals(v2.first)) {
                    i2 = ((Integer) v2.first).intValue();
                } else {
                    i2 = -1;
                }
                int intValue = (((Integer) v2.second).intValue() == -1 || (!((Integer) v3.first).equals(v2.second) && !((Integer) v3.second).equals(v2.second))) ? -1 : ((Integer) v2.second).intValue();
                if (i2 == -1 && intValue == -1) {
                    return new Pair<>(2, -1);
                }
                if (i2 == -1) {
                    v2 = new Pair<>(Integer.valueOf(intValue), -1);
                } else if (intValue == -1) {
                    v2 = new Pair<>(Integer.valueOf(i2), -1);
                }
            }
            return v2;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0) {
                        if (parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L) {
                                if (parseDouble2 <= 2147483647L) {
                                    return new Pair<>(10, 5);
                                }
                            }
                            return new Pair<>(5, -1);
                        }
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    return new Pair<>(3, 4);
                }
                if (valueOf.longValue() < 0) {
                    return new Pair<>(9, -1);
                }
                return new Pair<>(4, -1);
            } catch (NumberFormatException unused2) {
                try {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                } catch (NumberFormatException unused3) {
                    return new Pair<>(2, -1);
                }
            }
        }
    }

    public static boolean y(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            boolean z2 = v;
            return false;
        }
    }

    public final void A(@NonNull InputStream inputStream) {
        for (int i2 = 0; i2 < g0.length; i2++) {
            try {
                this.f[i2] = new HashMap<>();
            } catch (IOException unused) {
                boolean z2 = v;
                a();
                if (!z2) {
                    return;
                }
            } catch (Throwable th) {
                a();
                if (v) {
                    D();
                }
                throw th;
            }
        }
        if (!this.e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.d = n(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        b bVar = new b(inputStream, ByteOrder.BIG_ENDIAN);
        if (!this.e) {
            switch (this.d) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    r(bVar);
                    break;
                case 4:
                    m(bVar, 0, 0);
                    a();
                    if (v) {
                        D();
                        return;
                    }
                    return;
                case 7:
                    o(bVar);
                    break;
                case 9:
                    q(bVar);
                    a();
                    if (v) {
                        D();
                        return;
                    }
                    return;
                case 10:
                    s(bVar);
                    a();
                    if (v) {
                        D();
                        return;
                    }
                    return;
                case 12:
                    l(bVar);
                    break;
                case 13:
                    p(bVar);
                    a();
                    if (v) {
                        D();
                        return;
                    }
                    return;
                case 14:
                    u(bVar);
                    a();
                    if (v) {
                        D();
                        return;
                    }
                    return;
            }
        } else {
            t(bVar);
        }
        bVar.b((long) this.p);
        L(bVar);
        a();
        if (!v) {
            return;
        }
        D();
    }

    public final void C(b bVar, int i2) throws IOException {
        ByteOrder E2 = E(bVar);
        this.h = E2;
        bVar.b = E2;
        int readUnsignedShort = bVar.readUnsignedShort();
        int i3 = this.d;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException(a2.b.a.a.a.M2("Invalid first Ifd offset: ", readInt));
            }
            int i4 = readInt - 8;
            if (i4 > 0 && bVar.skipBytes(i4) != i4) {
                throw new IOException(a2.b.a.a.a.M2("Couldn't jump to first Ifd: ", i4));
            }
            return;
        }
        StringBuilder L2 = a2.b.a.a.a.L("Invalid start code: ");
        L2.append(Integer.toHexString(readUnsignedShort));
        throw new IOException(L2.toString());
    }

    public final void D() {
        int i2 = 0;
        while (true) {
            HashMap<String, d>[] hashMapArr = this.f;
            if (i2 < hashMapArr.length) {
                hashMapArr[i2].size();
                for (Map.Entry<String, d> entry : this.f[i2].entrySet()) {
                    d value = entry.getValue();
                    entry.getKey();
                    value.toString();
                    value.i(this.h);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final ByteOrder E(b bVar) throws IOException {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        StringBuilder L2 = a2.b.a.a.a.L("Invalid byte order: ");
        L2.append(Integer.toHexString(readShort));
        throw new IOException(L2.toString());
    }

    public final void F(byte[] bArr, int i2) throws IOException {
        b bVar = new b(bArr);
        C(bVar, bArr.length);
        G(bVar, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(androidx.exifinterface.media.ExifInterface.b r28, int r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 791
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.G(androidx.exifinterface.media.ExifInterface$b, int):void");
    }

    public final void H(String str) {
        for (int i2 = 0; i2 < g0.length; i2++) {
            this.f[i2].remove(str);
        }
    }

    public final void I(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (v) {
            String str = "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")";
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            cVar.a.write(-1);
            if (dataInputStream.readByte() == -40) {
                cVar.a.write(-40);
                d dVar = null;
                if (getAttribute(TAG_XMP) != null && this.u) {
                    dVar = this.f[0].remove(TAG_XMP);
                }
                cVar.a.write(-1);
                cVar.a.write(-31);
                Q(cVar);
                if (dVar != null) {
                    this.f[0].put(TAG_XMP, dVar);
                }
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.a.write(-1);
                        cVar.a.write(readByte);
                        g(dataInputStream, cVar);
                        return;
                    } else if (readByte != -31) {
                        cVar.a.write(-1);
                        cVar.a.write(readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        cVar.b((short) readUnsignedShort);
                        int i2 = readUnsignedShort - 2;
                        if (i2 >= 0) {
                            while (i2 > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                                if (read < 0) {
                                    break;
                                }
                                cVar.a.write(bArr, 0, read);
                                i2 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, p0)) {
                                    int i3 = readUnsignedShort2 - 6;
                                    if (dataInputStream.skipBytes(i3) != i3) {
                                        throw new IOException("Invalid length");
                                    }
                                }
                            }
                            cVar.a.write(-1);
                            cVar.a.write(readByte);
                            cVar.b((short) (readUnsignedShort2 + 2));
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                cVar.a.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.a.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    public final void J(InputStream inputStream, OutputStream outputStream) throws IOException {
        Throwable th;
        if (v) {
            String str = "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")";
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = E;
        h(dataInputStream, cVar, bArr.length);
        int i2 = this.p;
        if (i2 == 0) {
            int readInt = dataInputStream.readInt();
            cVar.a(readInt);
            h(dataInputStream, cVar, readInt + 4 + 4);
        } else {
            h(dataInputStream, cVar, ((i2 - bArr.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                Q(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.a).toByteArray();
                cVar.a.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.a((int) crc32.getValue());
                c(byteArrayOutputStream2);
                g(dataInputStream, cVar);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ac A[Catch:{ Exception -> 0x01f6, all -> 0x01f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01bc A[Catch:{ Exception -> 0x01f6, all -> 0x01f4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(java.io.InputStream r20, java.io.OutputStream r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 521
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.K(java.io.InputStream, java.io.OutputStream):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(androidx.exifinterface.media.ExifInterface.b r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.L(androidx.exifinterface.media.ExifInterface$b):void");
    }

    public final void N(int i2, int i3) throws IOException {
        if (this.f[i2].isEmpty() || this.f[i3].isEmpty()) {
            boolean z2 = v;
            return;
        }
        d dVar = this.f[i2].get(TAG_IMAGE_LENGTH);
        d dVar2 = this.f[i2].get(TAG_IMAGE_WIDTH);
        d dVar3 = this.f[i3].get(TAG_IMAGE_LENGTH);
        d dVar4 = this.f[i3].get(TAG_IMAGE_WIDTH);
        if (dVar == null || dVar2 == null) {
            boolean z3 = v;
        } else if (dVar3 == null || dVar4 == null) {
            boolean z4 = v;
        } else {
            int h2 = dVar.h(this.h);
            int h3 = dVar2.h(this.h);
            int h4 = dVar3.h(this.h);
            int h5 = dVar4.h(this.h);
            if (h2 < h4 && h3 < h5) {
                HashMap<String, d>[] hashMapArr = this.f;
                HashMap<String, d> hashMap = hashMapArr[i2];
                hashMapArr[i2] = hashMapArr[i3];
                hashMapArr[i3] = hashMap;
            }
        }
    }

    public final void O(b bVar, int i2) throws IOException {
        d dVar;
        d dVar2;
        d dVar3 = this.f[i2].get(TAG_DEFAULT_CROP_SIZE);
        d dVar4 = this.f[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
        d dVar5 = this.f[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
        d dVar6 = this.f[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        d dVar7 = this.f[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (dVar3 != null) {
            if (dVar3.a == 5) {
                f[] fVarArr = (f[]) dVar3.j(this.h);
                if (fVarArr == null || fVarArr.length != 2) {
                    Arrays.toString(fVarArr);
                    return;
                }
                dVar2 = d.d(new f[]{fVarArr[0]}, this.h);
                dVar = d.d(new f[]{fVarArr[1]}, this.h);
            } else {
                int[] iArr = (int[]) dVar3.j(this.h);
                if (iArr == null || iArr.length != 2) {
                    Arrays.toString(iArr);
                    return;
                } else {
                    dVar2 = d.e(iArr[0], this.h);
                    dVar = d.e(iArr[1], this.h);
                }
            }
            this.f[i2].put(TAG_IMAGE_WIDTH, dVar2);
            this.f[i2].put(TAG_IMAGE_LENGTH, dVar);
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            d dVar8 = this.f[i2].get(TAG_IMAGE_LENGTH);
            d dVar9 = this.f[i2].get(TAG_IMAGE_WIDTH);
            if (dVar8 == null || dVar9 == null) {
                d dVar10 = this.f[i2].get(TAG_JPEG_INTERCHANGE_FORMAT);
                d dVar11 = this.f[i2].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                if (dVar10 != null && dVar11 != null) {
                    int h2 = dVar10.h(this.h);
                    int h3 = dVar10.h(this.h);
                    bVar.b((long) h2);
                    byte[] bArr = new byte[h3];
                    bVar.read(bArr);
                    m(new b(bArr), h2, i2);
                }
            }
        } else {
            int h4 = dVar4.h(this.h);
            int h5 = dVar6.h(this.h);
            int h6 = dVar7.h(this.h);
            int h7 = dVar5.h(this.h);
            if (h5 > h4 && h6 > h7) {
                d e2 = d.e(h5 - h4, this.h);
                d e3 = d.e(h6 - h7, this.h);
                this.f[i2].put(TAG_IMAGE_LENGTH, e2);
                this.f[i2].put(TAG_IMAGE_WIDTH, e3);
            }
        }
    }

    public final void P() throws IOException {
        N(0, 5);
        N(0, 4);
        N(5, 4);
        d dVar = this.f[1].get(TAG_PIXEL_X_DIMENSION);
        d dVar2 = this.f[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(dVar == null || dVar2 == null)) {
            this.f[0].put(TAG_IMAGE_WIDTH, dVar);
            this.f[0].put(TAG_IMAGE_LENGTH, dVar2);
        }
        if (this.f[4].isEmpty() && z(this.f[5])) {
            HashMap<String, d>[] hashMapArr = this.f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        z(this.f[4]);
    }

    public final int Q(c cVar) throws IOException {
        e[][] eVarArr = g0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : h0) {
            H(eVar.b);
        }
        H(i0.b);
        H(j0.b);
        for (int i2 = 0; i2 < g0.length; i2++) {
            for (Object obj : this.f[i2].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(h0[1].b, d.b(0, this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(h0[2].b, d.b(0, this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(h0[3].b, d.b(0, this.h));
        }
        if (this.i) {
            this.f[4].put(i0.b, d.b(0, this.h));
            this.f[4].put(j0.b, d.b((long) this.m, this.h));
        }
        for (int i3 = 0; i3 < g0.length; i3++) {
            int i4 = 0;
            for (Map.Entry<String, d> entry2 : this.f[i3].entrySet()) {
                d value = entry2.getValue();
                Objects.requireNonNull(value);
                int i5 = U[value.a] * value.b;
                if (i5 > 4) {
                    i4 += i5;
                }
            }
            iArr2[i3] = iArr2[i3] + i4;
        }
        int i6 = 8;
        for (int i7 = 0; i7 < g0.length; i7++) {
            if (!this.f[i7].isEmpty()) {
                iArr[i7] = i6;
                i6 = (this.f[i7].size() * 12) + 2 + 4 + iArr2[i7] + i6;
            }
        }
        if (this.i) {
            this.f[4].put(i0.b, d.b((long) i6, this.h));
            this.l = i6;
            i6 += this.m;
        }
        if (this.d == 4) {
            i6 += 8;
        }
        if (v) {
            for (int i8 = 0; i8 < g0.length; i8++) {
                String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i8), Integer.valueOf(iArr[i8]), Integer.valueOf(this.f[i8].size()), Integer.valueOf(iArr2[i8]), Integer.valueOf(i6));
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(h0[1].b, d.b((long) iArr[1], this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(h0[2].b, d.b((long) iArr[2], this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(h0[3].b, d.b((long) iArr[3], this.h));
        }
        int i9 = this.d;
        if (i9 == 4) {
            cVar.b((short) i6);
            cVar.a.write(p0);
        } else if (i9 == 13) {
            cVar.a(i6);
            cVar.a.write(F);
        } else if (i9 == 14) {
            cVar.a.write(K);
            cVar.a(i6);
        }
        cVar.b(this.h == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        cVar.b = this.h;
        cVar.b((short) 42);
        cVar.a((int) 8);
        for (int i10 = 0; i10 < g0.length; i10++) {
            if (!this.f[i10].isEmpty()) {
                cVar.b((short) this.f[i10].size());
                int size = (this.f[i10].size() * 12) + iArr[i10] + 2 + 4;
                for (Map.Entry<String, d> entry3 : this.f[i10].entrySet()) {
                    int i11 = l0[i10].get(entry3.getKey()).a;
                    d value2 = entry3.getValue();
                    Objects.requireNonNull(value2);
                    int i12 = U[value2.a] * value2.b;
                    cVar.b((short) i11);
                    cVar.b((short) value2.a);
                    cVar.a(value2.b);
                    if (i12 > 4) {
                        cVar.a((int) ((long) size));
                        size += i12;
                    } else {
                        cVar.a.write(value2.d);
                        if (i12 < 4) {
                            while (i12 < 4) {
                                cVar.a.write(0);
                                i12++;
                            }
                        }
                    }
                }
                if (i10 != 0 || this.f[4].isEmpty()) {
                    cVar.a((int) 0);
                } else {
                    cVar.a((int) ((long) iArr[4]));
                }
                for (Map.Entry<String, d> entry4 : this.f[i10].entrySet()) {
                    byte[] bArr = entry4.getValue().d;
                    if (bArr.length > 4) {
                        cVar.a.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.i) {
            cVar.a.write(getThumbnailBytes());
        }
        if (this.d == 14 && i6 % 2 == 1) {
            cVar.a.write(0);
        }
        cVar.b = ByteOrder.BIG_ENDIAN;
        return i6;
    }

    public final void a() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.f[0].put(TAG_DATETIME, d.a(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.f[0].put(TAG_IMAGE_WIDTH, d.b(0, this.h));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.f[0].put(TAG_IMAGE_LENGTH, d.b(0, this.h));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.f[0].put(TAG_ORIENTATION, d.b(0, this.h));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.f[1].put(TAG_LIGHT_SOURCE, d.b(0, this.h));
        }
    }

    public final String d(double d2) {
        long j2 = (long) d2;
        double d3 = d2 - ((double) j2);
        long j3 = (long) (d3 * 60.0d);
        long round = Math.round((d3 - (((double) j3) / 60.0d)) * 3600.0d * 1.0E7d);
        return j2 + "/1," + j3 + "/1," + round + "/10000000";
    }

    public void flipHorizontally() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 2;
                break;
            case 2:
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public void flipVertically() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public double getAltitude(double d2) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i2 = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d2;
        }
        if (attributeInt != 1) {
            i2 = 1;
        }
        return attributeDouble * ((double) i2);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d k2 = k(str);
        if (k2 != null) {
            if (!m0.contains(str)) {
                return k2.i(this.h);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i2 = k2.a;
                if (i2 != 5 && i2 != 10) {
                    return null;
                }
                f[] fVarArr = (f[]) k2.j(this.h);
                if (fVarArr != null && fVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) fVarArr[0].a) / ((float) fVarArr[0].b))), Integer.valueOf((int) (((float) fVarArr[1].a) / ((float) fVarArr[1].b))), Integer.valueOf((int) (((float) fVarArr[2].a) / ((float) fVarArr[2].b))));
                }
                Arrays.toString(fVarArr);
                return null;
            }
            try {
                return Double.toString(k2.g(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d k2 = k(str);
        if (k2 != null) {
            return k2.d;
        }
        return null;
    }

    public double getAttributeDouble(@NonNull String str, double d2) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d k2 = k(str);
        if (k2 == null) {
            return d2;
        }
        try {
            return k2.g(this.h);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public int getAttributeInt(@NonNull String str, int i2) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d k2 = k(str);
        if (k2 == null) {
            return i2;
        }
        try {
            return k2.h(this.h);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (!this.t) {
            d k2 = k(str);
            if (k2 != null) {
                return new long[]{k2.c, (long) k2.d.length};
            }
            return null;
        }
        throw new IllegalStateException("The underlying file has been modified since being parsed");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTime() {
        return B(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return B(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return B(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @Nullable
    @SuppressLint({"AutoBoxing"})
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = r0;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String L2 = a2.b.a.a.a.L2(attribute, ' ', attribute2);
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = R.parse(L2, parsePosition);
                    if (parse == null && (parse = S.parse(L2, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i2 = this.o;
        if (i2 == 6 || i2 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.i) {
            return null;
        }
        if (this.n == null) {
            this.n = getThumbnailBytes();
        }
        int i2 = this.o;
        if (i2 == 6 || i2 == 7) {
            return BitmapFactory.decodeByteArray(this.n, 0, this.m);
        }
        if (i2 == 1) {
            int length = this.n.length / 3;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                byte[] bArr = this.n;
                int i4 = i3 * 3;
                iArr[i3] = (bArr[i4] << Ascii.DLE) + 0 + (bArr[i4 + 1] << 8) + bArr[i4 + 2];
            }
            d dVar = this.f[4].get(TAG_IMAGE_LENGTH);
            d dVar2 = this.f[4].get(TAG_IMAGE_WIDTH);
            if (!(dVar == null || dVar2 == null)) {
                return Bitmap.createBitmap(iArr, dVar2.h(this.h), dVar.h(this.h), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x004b A[SYNTHETIC, Splitter:B:28:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e A[SYNTHETIC, Splitter:B:57:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00a9 A[SYNTHETIC, Splitter:B:66:0x00a9] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r10 = this;
            boolean r0 = r10.i
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            byte[] r0 = r10.n
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.res.AssetManager$AssetInputStream r0 = r10.c     // Catch:{ Exception -> 0x00a2, all -> 0x0096 }
            if (r0 == 0) goto L_0x0028
            boolean r2 = r0.markSupported()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r0.reset()     // Catch:{ Exception -> 0x0025, all -> 0x001e }
        L_0x0018:
            r2 = r1
            goto L_0x0049
        L_0x001a:
            c(r0)
            return r1
        L_0x001e:
            r2 = move-exception
            r9 = r1
            r1 = r0
            r0 = r2
            r2 = r9
            goto L_0x0099
        L_0x0025:
            r2 = r1
            goto L_0x00a4
        L_0x0028:
            java.lang.String r0 = r10.a
            if (r0 == 0) goto L_0x0034
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.lang.String r2 = r10.a
            r0.<init>(r2)
            goto L_0x0018
        L_0x0034:
            java.io.FileDescriptor r0 = r10.b
            java.io.FileDescriptor r0 = android.system.Os.dup(r0)
            r2 = 0
            int r4 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0093, all -> 0x008f }
            android.system.Os.lseek(r0, r2, r4)     // Catch:{ Exception -> 0x0093, all -> 0x008f }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0093, all -> 0x008f }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0093, all -> 0x008f }
            r9 = r2
            r2 = r0
            r0 = r9
        L_0x0049:
            if (r0 == 0) goto L_0x0089
            int r3 = r10.l     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            int r4 = r10.p     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            int r3 = r3 + r4
            long r3 = (long) r3     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            long r3 = r0.skip(r3)     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            int r5 = r10.l     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            int r6 = r10.p     // Catch:{ Exception -> 0x00a4, all -> 0x0084 }
            int r5 = r5 + r6
            long r5 = (long) r5
            java.lang.String r7 = "Corrupted image"
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x007e
            int r3 = r10.m
            byte[] r3 = new byte[r3]
            int r4 = r0.read(r3)
            int r5 = r10.m
            if (r4 != r5) goto L_0x0078
            r10.n = r3
            c(r0)
            if (r2 == 0) goto L_0x0077
            android.system.Os.close(r2)     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            return r3
        L_0x0078:
            java.io.IOException r3 = new java.io.IOException
            r3.<init>(r7)
            throw r3
        L_0x007e:
            java.io.IOException r3 = new java.io.IOException
            r3.<init>(r7)
            throw r3
        L_0x0084:
            r1 = move-exception
            r9 = r1
            r1 = r0
        L_0x0087:
            r0 = r9
            goto L_0x0099
        L_0x0089:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            r3.<init>()
            throw r3
        L_0x008f:
            r2 = move-exception
            r9 = r2
            r2 = r0
            goto L_0x0087
        L_0x0093:
            r2 = r0
            r0 = r1
            goto L_0x00a4
        L_0x0096:
            r2 = move-exception
            r0 = r2
            r2 = r1
        L_0x0099:
            c(r1)
            if (r2 == 0) goto L_0x00a1
            android.system.Os.close(r2)     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            throw r0
        L_0x00a2:
            r0 = r1
            r2 = r0
        L_0x00a4:
            c(r0)
            if (r2 == 0) goto L_0x00ac
            android.system.Os.close(r2)     // Catch:{ Exception -> 0x00ac }
        L_0x00ac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.t) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.i) {
            return null;
        } else {
            if (!this.j || this.k) {
                return new long[]{(long) (this.l + this.p), (long) this.m};
            }
            return null;
        }
    }

    public boolean hasAttribute(@NonNull String str) {
        return k(str) != null;
    }

    public boolean hasThumbnail() {
        return this.i;
    }

    public final void i(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder L2 = a2.b.a.a.a.L("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = o0;
                L2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    StringBuilder L3 = a2.b.a.a.a.L(" or ");
                    L3.append(new String(bArr2, charset));
                    str = L3.toString();
                }
                L2.append(str);
                throw new IOException(L2.toString());
            }
            j(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        if (!this.i) {
            return false;
        }
        int i2 = this.o;
        if (i2 == 6 || i2 == 7) {
            return true;
        }
        return false;
    }

    public final void j(b bVar, c cVar, byte[] bArr) throws IOException {
        int readInt = bVar.readInt();
        cVar.a.write(bArr);
        cVar.a(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        h(bVar, cVar, readInt);
    }

    @Nullable
    public final d k(@NonNull String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            boolean z2 = v;
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < g0.length; i2++) {
            d dVar = this.f[i2].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public final void l(b bVar) throws IOException {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new a(this, bVar));
            } else {
                FileDescriptor fileDescriptor = this.b;
                if (fileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                } else {
                    String str3 = this.a;
                    if (str3 != null) {
                        mediaMetadataRetriever.setDataSource(str3);
                    } else {
                        mediaMetadataRetriever.release();
                        return;
                    }
                }
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str4 = null;
            if ("yes".equals(extractMetadata3)) {
                str4 = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str4 = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str2 = null;
                str = null;
            }
            if (str4 != null) {
                this.f[0].put(TAG_IMAGE_WIDTH, d.e(Integer.parseInt(str4), this.h));
            }
            if (str2 != null) {
                this.f[0].put(TAG_IMAGE_LENGTH, d.e(Integer.parseInt(str2), this.h));
            }
            if (str != null) {
                int i2 = 1;
                int parseInt = Integer.parseInt(str);
                if (parseInt == 90) {
                    i2 = 6;
                } else if (parseInt == 180) {
                    i2 = 3;
                } else if (parseInt == 270) {
                    i2 = 8;
                }
                this.f[0].put(TAG_ORIENTATION, d.e(i2, this.h));
            }
            if (!(extractMetadata == null || extractMetadata2 == null)) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    bVar.b((long) parseInt2);
                    byte[] bArr = new byte[6];
                    if (bVar.read(bArr) == 6) {
                        int i3 = parseInt2 + 6;
                        int i4 = parseInt3 - 6;
                        if (Arrays.equals(bArr, p0)) {
                            byte[] bArr2 = new byte[i4];
                            if (bVar.read(bArr2) == i4) {
                                this.p = i3;
                                F(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0149 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(androidx.exifinterface.media.ExifInterface.b r18, int r19, int r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 460
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.m(androidx.exifinterface.media.ExifInterface$b, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x017b, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c6, code lost:
        if (r6 != null) goto L_0x00c8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x010f A[SYNTHETIC, Splitter:B:100:0x010f] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0140 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x010d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n(java.io.BufferedInputStream r18) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 391
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.n(java.io.BufferedInputStream):int");
    }

    public final void o(b bVar) throws IOException {
        r(bVar);
        d dVar = this.f[1].get(TAG_MAKER_NOTE);
        if (dVar != null) {
            b bVar2 = new b(dVar.d);
            bVar2.b = this.h;
            byte[] bArr = C;
            byte[] bArr2 = new byte[bArr.length];
            bVar2.readFully(bArr2);
            bVar2.b(0);
            byte[] bArr3 = D;
            byte[] bArr4 = new byte[bArr3.length];
            bVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                bVar2.b(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                bVar2.b(12);
            }
            G(bVar2, 6);
            d dVar2 = this.f[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            d dVar3 = this.f[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(dVar2 == null || dVar3 == null)) {
                this.f[5].put(TAG_JPEG_INTERCHANGE_FORMAT, dVar2);
                this.f[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, dVar3);
            }
            d dVar4 = this.f[8].get(TAG_ORF_ASPECT_FRAME);
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.j(this.h);
                if (iArr == null || iArr.length != 4) {
                    Arrays.toString(iArr);
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    d e2 = d.e(i2, this.h);
                    d e3 = d.e(i3, this.h);
                    this.f[0].put(TAG_IMAGE_WIDTH, e2);
                    this.f[0].put(TAG_IMAGE_LENGTH, e3);
                }
            }
        }
    }

    public final void p(b bVar) throws IOException {
        if (v) {
            String str = "getPngAttributes starting with: " + bVar;
        }
        bVar.mark(0);
        bVar.b = ByteOrder.BIG_ENDIAN;
        byte[] bArr = E;
        bVar.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i2 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i3 = i2 + 4;
                    if (i3 == 16) {
                        if (!Arrays.equals(bArr2, G)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, H)) {
                        if (Arrays.equals(bArr2, F)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.p = i3;
                                    F(bArr3, 0);
                                    P();
                                    L(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr2));
                        }
                        int i4 = readInt + 4;
                        bVar.skipBytes(i4);
                        length = i3 + i4;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void q(b bVar) throws IOException {
        if (v) {
            String str = "getRafAttributes starting with: " + bVar;
        }
        bVar.mark(0);
        bVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        bVar.b((long) i2);
        bVar.read(bArr4);
        m(new b(bArr4), i2, 5);
        bVar.b((long) i4);
        bVar.b = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        for (int i5 = 0; i5 < readInt; i5++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == b0.a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d e2 = d.e(readShort, this.h);
                d e3 = d.e(readShort2, this.h);
                this.f[0].put(TAG_IMAGE_LENGTH, e2);
                this.f[0].put(TAG_IMAGE_WIDTH, e3);
                return;
            }
            bVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void r(b bVar) throws IOException {
        d dVar;
        C(bVar, bVar.available());
        G(bVar, 0);
        O(bVar, 0);
        O(bVar, 5);
        O(bVar, 4);
        P();
        if (this.d == 8 && (dVar = this.f[1].get(TAG_MAKER_NOTE)) != null) {
            b bVar2 = new b(dVar.d);
            bVar2.b = this.h;
            bVar2.b(6);
            G(bVar2, 9);
            d dVar2 = this.f[9].get(TAG_COLOR_SPACE);
            if (dVar2 != null) {
                this.f[1].put(TAG_COLOR_SPACE, dVar2);
            }
        }
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i2) {
        if (i2 % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            List<Integer> list = w;
            int i3 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = ((i2 / 90) + list.indexOf(Integer.valueOf(attributeInt))) % 4;
                if (indexOf < 0) {
                    i3 = 4;
                }
                i3 = list.get(indexOf + i3).intValue();
            } else {
                List<Integer> list2 = x;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = ((i2 / 90) + list2.indexOf(Integer.valueOf(attributeInt))) % 4;
                    if (indexOf2 < 0) {
                        i3 = 4;
                    }
                    i3 = list2.get(indexOf2 + i3).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i3));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public final void s(b bVar) throws IOException {
        if (v) {
            String str = "getRw2Attributes starting with: " + bVar;
        }
        r(bVar);
        d dVar = this.f[0].get(TAG_RW2_JPG_FROM_RAW);
        if (dVar != null) {
            m(new b(dVar.d), (int) dVar.c, 5);
        }
        d dVar2 = this.f[0].get(TAG_RW2_ISO);
        d dVar3 = this.f[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (dVar2 != null && dVar3 == null) {
            this.f[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, dVar2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b3, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b4, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b6, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b7, code lost:
        r10 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b9, code lost:
        r12 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bc, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bd, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cd, code lost:
        android.system.Os.lseek(r14.b, 0, android.system.OsConstants.SEEK_SET);
        r0 = new java.io.FileOutputStream(r14.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00dc, code lost:
        r0 = new java.io.FileOutputStream(r14.a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012e, code lost:
        r6.delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:24:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd A[Catch:{ Exception -> 0x00f7, all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dc A[Catch:{ Exception -> 0x00f7, all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public void setAltitude(double d2) {
        String str = d2 >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new f(Math.abs(d2)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        e eVar;
        int i2;
        d dVar;
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ((TAG_DATETIME.equals(str) || TAG_DATETIME_ORIGINAL.equals(str) || TAG_DATETIME_DIGITIZED.equals(str)) && str2 != null) {
            boolean find = t0.matcher(str2).find();
            boolean find2 = u0.matcher(str2).find();
            if (str2.length() != 19) {
                return;
            }
            if (!(find || find2)) {
                return;
            }
            if (find2) {
                str2 = str2.replaceAll("-", ":");
            }
        }
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        int i3 = 2;
        int i4 = 1;
        if (str2 != null && m0.contains(str)) {
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = s0.matcher(str2);
                if (matcher.find()) {
                    str2 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
                } else {
                    return;
                }
            } else {
                try {
                    str2 = new f(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    return;
                }
            }
        }
        char c2 = 0;
        int i5 = 0;
        while (i5 < g0.length) {
            if ((i5 != 4 || this.i) && (eVar = l0[i5].get(str)) != null) {
                if (str2 == null) {
                    this.f[i5].remove(str);
                } else {
                    Pair<Integer, Integer> v2 = v(str2);
                    if (eVar.c == ((Integer) v2.first).intValue() || eVar.c == ((Integer) v2.second).intValue()) {
                        i2 = eVar.c;
                    } else {
                        int i6 = eVar.d;
                        if (i6 == -1 || !(i6 == ((Integer) v2.first).intValue() || eVar.d == ((Integer) v2.second).intValue())) {
                            int i7 = eVar.c;
                            if (i7 == i4 || i7 == 7 || i7 == i3) {
                                i2 = i7;
                            } else if (v) {
                                String[] strArr = T;
                                String str3 = strArr[i7];
                                if (eVar.d != -1) {
                                    StringBuilder L2 = a2.b.a.a.a.L(", ");
                                    L2.append(strArr[eVar.d]);
                                    L2.toString();
                                }
                                String str4 = strArr[((Integer) v2.first).intValue()];
                                if (((Integer) v2.second).intValue() != -1) {
                                    StringBuilder L3 = a2.b.a.a.a.L(", ");
                                    L3.append(strArr[((Integer) v2.second).intValue()]);
                                    L3.toString();
                                }
                            }
                        } else {
                            i2 = eVar.d;
                        }
                    }
                    switch (i2) {
                        case 1:
                            HashMap<String, d> hashMap = this.f[i5];
                            if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '1') {
                                byte[] bytes = str2.getBytes(o0);
                                dVar = new d(1, bytes.length, bytes);
                            } else {
                                dVar = new d(1, 1, new byte[]{(byte) (str2.charAt(0) - '0')});
                            }
                            hashMap.put(str, dVar);
                            continue;
                        case 2:
                        case 7:
                            this.f[i5].put(str, d.a(str2));
                            continue;
                        case 3:
                            String[] split = str2.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i8 = 0; i8 < split.length; i8++) {
                                iArr[i8] = Integer.parseInt(split[i8]);
                            }
                            this.f[i5].put(str, d.f(iArr, this.h));
                            continue;
                        case 4:
                            String[] split2 = str2.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i9 = 0; i9 < split2.length; i9++) {
                                jArr[i9] = Long.parseLong(split2[i9]);
                            }
                            this.f[i5].put(str, d.c(jArr, this.h));
                            continue;
                        case 5:
                            String[] split3 = str2.split(",", -1);
                            f[] fVarArr = new f[split3.length];
                            for (int i10 = 0; i10 < split3.length; i10++) {
                                String[] split4 = split3[i10].split("/", -1);
                                fVarArr[i10] = new f((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                            }
                            this.f[i5].put(str, d.d(fVarArr, this.h));
                            continue;
                        case 9:
                            String[] split5 = str2.split(",", -1);
                            int length = split5.length;
                            int[] iArr2 = new int[length];
                            for (int i11 = 0; i11 < split5.length; i11++) {
                                iArr2[i11] = Integer.parseInt(split5[i11]);
                            }
                            HashMap<String, d> hashMap2 = this.f[i5];
                            ByteOrder byteOrder = this.h;
                            ByteBuffer wrap = ByteBuffer.wrap(new byte[(U[9] * length)]);
                            wrap.order(byteOrder);
                            for (int i12 = 0; i12 < length; i12++) {
                                wrap.putInt(iArr2[i12]);
                            }
                            hashMap2.put(str, new d(9, length, wrap.array()));
                            continue;
                        case 10:
                            String[] split6 = str2.split(",", -1);
                            int length2 = split6.length;
                            f[] fVarArr2 = new f[length2];
                            int i13 = 0;
                            while (i13 < split6.length) {
                                String[] split7 = split6[i13].split("/", -1);
                                fVarArr2[i13] = new f((long) Double.parseDouble(split7[c2]), (long) Double.parseDouble(split7[i4]));
                                i13++;
                                i4 = 1;
                                c2 = 0;
                            }
                            HashMap<String, d> hashMap3 = this.f[i5];
                            ByteOrder byteOrder2 = this.h;
                            ByteBuffer wrap2 = ByteBuffer.wrap(new byte[(U[10] * length2)]);
                            wrap2.order(byteOrder2);
                            for (int i14 = 0; i14 < length2; i14++) {
                                f fVar = fVarArr2[i14];
                                wrap2.putInt((int) fVar.a);
                                wrap2.putInt((int) fVar.b);
                            }
                            hashMap3.put(str, new d(10, length2, wrap2.array()));
                            continue;
                        case 12:
                            String[] split8 = str2.split(",", -1);
                            int length3 = split8.length;
                            double[] dArr = new double[length3];
                            for (int i15 = 0; i15 < split8.length; i15++) {
                                dArr[i15] = Double.parseDouble(split8[i15]);
                            }
                            HashMap<String, d> hashMap4 = this.f[i5];
                            ByteOrder byteOrder3 = this.h;
                            ByteBuffer wrap3 = ByteBuffer.wrap(new byte[(U[12] * length3)]);
                            wrap3.order(byteOrder3);
                            for (int i16 = 0; i16 < length3; i16++) {
                                wrap3.putDouble(dArr[i16]);
                            }
                            hashMap4.put(str, new d(12, length3, wrap3.array()));
                            continue;
                    }
                }
            }
            i5++;
            i3 = 2;
            i4 = 1;
            c2 = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(@NonNull Long l2) {
        setAttribute(TAG_DATETIME, R.format(new Date(l2.longValue())));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(l2.longValue() % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new f((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = R.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d2, double d3) {
        if (d2 < -90.0d || d2 > 90.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
        } else if (d3 < -180.0d || d3 > 180.0d || Double.isNaN(d3)) {
            throw new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
        } else {
            setAttribute(TAG_GPS_LATITUDE_REF, d2 >= 0.0d ? "N" : LATITUDE_SOUTH);
            setAttribute(TAG_GPS_LATITUDE, d(Math.abs(d2)));
            setAttribute(TAG_GPS_LONGITUDE_REF, d3 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
            setAttribute(TAG_GPS_LONGITUDE, d(Math.abs(d3)));
        }
    }

    public final void t(b bVar) throws IOException {
        byte[] bArr = p0;
        bVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[bVar.available()];
        bVar.readFully(bArr2);
        this.p = bArr.length;
        F(bArr2, 0);
    }

    public final void u(b bVar) throws IOException {
        if (v) {
            String str = "getWebpAttributes starting with: " + bVar;
        }
        bVar.mark(0);
        bVar.b = ByteOrder.LITTLE_ENDIAN;
        bVar.skipBytes(I.length);
        int readInt = bVar.readInt() + 8;
        int skipBytes = bVar.skipBytes(J.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (bVar.read(bArr) == 4) {
                    int readInt2 = bVar.readInt();
                    int i2 = skipBytes + 4 + 4;
                    if (Arrays.equals(K, bArr)) {
                        byte[] bArr2 = new byte[readInt2];
                        if (bVar.read(bArr2) == readInt2) {
                            this.p = i2;
                            F(bArr2, 0);
                            L(new b(bArr2));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    int i3 = i2 + readInt2;
                    if (i3 != readInt) {
                        if (i3 <= readInt) {
                            int skipBytes2 = bVar.skipBytes(readInt2);
                            if (skipBytes2 == readInt2) {
                                skipBytes = i2 + skipBytes2;
                            } else {
                                throw new IOException("Encountered WebP file with invalid chunk size");
                            }
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void w(b bVar, HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        d dVar2 = (d) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (dVar != null && dVar2 != null) {
            int h2 = dVar.h(this.h);
            int h3 = dVar2.h(this.h);
            if (this.d == 7) {
                h2 += this.q;
            }
            int min = Math.min(h3, bVar.c - h2);
            if (h2 > 0 && min > 0) {
                this.i = true;
                if (this.a == null && this.c == null && this.b == null) {
                    byte[] bArr = new byte[min];
                    bVar.skip((long) h2);
                    bVar.read(bArr);
                    this.n = bArr;
                }
                this.l = h2;
                this.m = min;
            }
        }
    }

    public final void x(String str) throws IOException {
        Throwable th;
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream = null;
        this.c = null;
        this.a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (y(fileInputStream2.getFD())) {
                    this.b = fileInputStream2.getFD();
                } else {
                    this.b = null;
                }
                A(fileInputStream2);
                c(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c(fileInputStream);
            throw th;
        }
    }

    public final boolean z(HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get(TAG_IMAGE_LENGTH);
        d dVar2 = (d) hashMap.get(TAG_IMAGE_WIDTH);
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.h(this.h) <= 512 && dVar2.h(this.h) <= 512;
    }

    public static class b extends InputStream implements DataInput {
        public static final ByteOrder e = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder f = ByteOrder.BIG_ENDIAN;
        public DataInputStream a;
        public ByteOrder b;
        public final int c;
        public int d;

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.a = dataInputStream;
            int available = dataInputStream.available();
            this.c = available;
            this.d = 0;
            this.a.mark(available);
            this.b = byteOrder;
        }

        public long a() throws IOException {
            return ((long) readInt()) & BodyPartID.bodyIdMax;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.a.available();
        }

        public void b(long j) throws IOException {
            int i = this.d;
            if (((long) i) > j) {
                this.d = 0;
                this.a.reset();
                this.a.mark(this.c);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.a.mark(i);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.d++;
            return this.a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.d++;
            return this.a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.d + 1;
            this.d = i;
            if (i <= this.c) {
                int read = this.a.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.d += 2;
            return this.a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.d + i2;
            this.d = i3;
            if (i3 > this.c) {
                throw new EOFException();
            } else if (this.a.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.d + 4;
            this.d = i;
            if (i <= this.c) {
                int read = this.a.read();
                int read2 = this.a.read();
                int read3 = this.a.read();
                int read4 = this.a.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.b;
                    if (byteOrder == e) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder L = a2.b.a.a.a.L("Invalid byte order: ");
                    L.append(this.b);
                    throw new IOException(L.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.d + 8;
            this.d = i;
            if (i <= this.c) {
                int read = this.a.read();
                int read2 = this.a.read();
                int read3 = this.a.read();
                int read4 = this.a.read();
                int read5 = this.a.read();
                int read6 = this.a.read();
                int read7 = this.a.read();
                int read8 = this.a.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.b;
                    if (byteOrder == e) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == f) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    StringBuilder L = a2.b.a.a.a.L("Invalid byte order: ");
                    L.append(this.b);
                    throw new IOException(L.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.d + 2;
            this.d = i;
            if (i <= this.c) {
                int read = this.a.read();
                int read2 = this.a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.b;
                    if (byteOrder == e) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder L = a2.b.a.a.a.L("Invalid byte order: ");
                    L.append(this.b);
                    throw new IOException(L.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.d += 2;
            return this.a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.d++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.d + 2;
            this.d = i;
            if (i <= this.c) {
                int read = this.a.read();
                int read2 = this.a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.b;
                    if (byteOrder == e) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f) {
                        return (read << 8) + read2;
                    }
                    StringBuilder L = a2.b.a.a.a.L("Invalid byte order: ");
                    L.append(this.b);
                    throw new IOException(L.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.c - this.d);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.a.skipBytes(min - i2);
            }
            this.d += i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.a.read(bArr, i, i2);
            this.d += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.d + bArr.length;
            this.d = length;
            if (length > this.c) {
                throw new EOFException();
            } else if (this.a.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{e(attribute, attribute2), e(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4);
            return null;
        }
    }

    public static class d {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;

        public d(int i, int i2, long j, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }

        public static d a(String str) {
            byte[] bytes = a2.b.a.a.a.K2(str, 0).getBytes(ExifInterface.o0);
            return new d(2, bytes.length, bytes);
        }

        public static d b(long j, ByteOrder byteOrder) {
            return c(new long[]{j}, byteOrder);
        }

        public static d c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.U[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.U[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.a);
                wrap.putInt((int) fVar.b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d e(int i, ByteOrder byteOrder) {
            return f(new int[]{i}, byteOrder);
        }

        public static d f(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.U[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double g(ByteOrder byteOrder) {
            Object j = j(byteOrder);
            if (j == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (j instanceof String) {
                return Double.parseDouble((String) j);
            } else {
                if (j instanceof long[]) {
                    long[] jArr = (long[]) j;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (j instanceof int[]) {
                    int[] iArr = (int[]) j;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (j instanceof double[]) {
                    double[] dArr = (double[]) j;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (j instanceof f[]) {
                    f[] fVarArr = (f[]) j;
                    if (fVarArr.length == 1) {
                        f fVar = fVarArr[0];
                        return ((double) fVar.a) / ((double) fVar.b);
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int h(ByteOrder byteOrder) {
            Object j = j(byteOrder);
            if (j == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (j instanceof String) {
                return Integer.parseInt((String) j);
            } else {
                if (j instanceof long[]) {
                    long[] jArr = (long[]) j;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (j instanceof int[]) {
                    int[] iArr = (int[]) j;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String i(ByteOrder byteOrder) {
            Object j = j(byteOrder);
            if (j == null) {
                return null;
            }
            if (j instanceof String) {
                return (String) j;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (j instanceof long[]) {
                long[] jArr = (long[]) j;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (j instanceof int[]) {
                int[] iArr = (int[]) j;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (j instanceof double[]) {
                double[] dArr = (double[]) j;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(j instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) j;
                while (i < fVarArr.length) {
                    sb.append(fVarArr[i].a);
                    sb.append('/');
                    sb.append(fVarArr[i].b);
                    i++;
                    if (i != fVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:122:0x014e A[SYNTHETIC, Splitter:B:122:0x014e] */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x0155 A[SYNTHETIC, Splitter:B:130:0x0155] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object j(java.nio.ByteOrder r9) {
            /*
            // Method dump skipped, instructions count: 374
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.d.j(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("(");
            L.append(ExifInterface.T[this.a]);
            L.append(", data length:");
            return a2.b.a.a.a.j(L, this.d.length, ")");
        }

        public d(int i, int i2, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = -1;
            this.d = bArr;
        }
    }

    public static class e {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        public e(String str, int i, int i2) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        public e(String str, int i, int i2, int i3) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        e[][] eVarArr = g0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        x(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[SYNTHETIC, Splitter:B:24:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>()
            androidx.exifinterface.media.ExifInterface$e[][] r0 = androidx.exifinterface.media.ExifInterface.g0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r4.f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r4.g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r4.h = r0
            java.lang.String r0 = "fileDescriptor cannot be null"
            java.util.Objects.requireNonNull(r5, r0)
            r0 = 0
            r4.c = r0
            r4.a = r0
            r1 = 0
            boolean r2 = y(r5)
            if (r2 == 0) goto L_0x0038
            r4.b = r5
            java.io.FileDescriptor r5 = android.system.Os.dup(r5)     // Catch:{ Exception -> 0x002f }
            r1 = 1
            goto L_0x003a
        L_0x002f:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r5)
            throw r0
        L_0x0038:
            r4.b = r0
        L_0x003a:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004d }
            r2.<init>(r5)     // Catch:{ all -> 0x004d }
            r4.A(r2)     // Catch:{ all -> 0x004b }
            c(r2)
            if (r1 == 0) goto L_0x004a
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            return
        L_0x004b:
            r0 = move-exception
            goto L_0x0051
        L_0x004d:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x0051:
            c(r2)
            if (r1 == 0) goto L_0x0059
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i2) throws IOException {
        e[][] eVarArr = g0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.a = null;
        boolean z2 = false;
        if (i2 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            byte[] bArr = p0;
            bufferedInputStream.mark(bArr.length);
            byte[] bArr2 = new byte[bArr.length];
            bufferedInputStream.read(bArr2);
            bufferedInputStream.reset();
            int i3 = 0;
            while (true) {
                byte[] bArr3 = p0;
                if (i3 >= bArr3.length) {
                    z2 = true;
                    break;
                } else if (bArr2[i3] != bArr3[i3]) {
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                this.e = true;
                this.c = null;
                this.b = null;
                inputStream = bufferedInputStream;
            } else {
                return;
            }
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.c = (AssetManager.AssetInputStream) inputStream;
            this.b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (y(fileInputStream.getFD())) {
                    this.c = null;
                    this.b = fileInputStream.getFD();
                }
            }
            this.c = null;
            this.b = null;
        }
        A(inputStream);
    }
}
