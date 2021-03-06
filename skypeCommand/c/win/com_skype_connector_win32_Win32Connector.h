/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_skype_connector_win32_Win32Connector */

#ifndef _Included_com_skype_connector_win32_Win32Connector
#define _Included_com_skype_connector_win32_Win32Connector
#ifdef __cplusplus
extern "C" {
#endif
#undef com_skype_connector_win32_Win32Connector_ATTACH_SUCCESS
#define com_skype_connector_win32_Win32Connector_ATTACH_SUCCESS 0L
#undef com_skype_connector_win32_Win32Connector_ATTACH_PENDING_AUTHORIZATION
#define com_skype_connector_win32_Win32Connector_ATTACH_PENDING_AUTHORIZATION 1L
#undef com_skype_connector_win32_Win32Connector_ATTACH_REFUSED
#define com_skype_connector_win32_Win32Connector_ATTACH_REFUSED 2L
#undef com_skype_connector_win32_Win32Connector_ATTACH_NOT_AVAILABLE
#define com_skype_connector_win32_Win32Connector_ATTACH_NOT_AVAILABLE 3L
#undef com_skype_connector_win32_Win32Connector_ATTACH_API_AVAILABLE
#define com_skype_connector_win32_Win32Connector_ATTACH_API_AVAILABLE 32769L
/*
 * Class:     com_skype_connector_win32_Win32Connector
 * Method:    jni_init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_skype_connector_win32_Win32Connector_jni_1init
  (JNIEnv *, jobject);

/*
 * Class:     com_skype_connector_win32_Win32Connector
 * Method:    jni_windowProc
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_skype_connector_win32_Win32Connector_jni_1windowProc
  (JNIEnv *, jobject);

/*
 * Class:     com_skype_connector_win32_Win32Connector
 * Method:    jni_sendMessage
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_skype_connector_win32_Win32Connector_jni_1sendMessage
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_skype_connector_win32_Win32Connector
 * Method:    jni_connect
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_skype_connector_win32_Win32Connector_jni_1connect
  (JNIEnv *, jobject);

/*
 * Class:     com_skype_connector_win32_Win32Connector
 * Method:    jni_getInstalledPath
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_skype_connector_win32_Win32Connector_jni_1getInstalledPath
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
