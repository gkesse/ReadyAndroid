#include <string.h>
#include <jni.h>

jstring Java_com_pkg_app_MainActivity_sayHello(JNIEnv* pEnv, jobject pObj) {
	return (*pEnv)->NewStringUTF(pEnv, "Hello NDK!");
}

