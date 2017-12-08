//
// Created by potoyang on 2017/11/17.
//
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_potoyang_common_security_EncryptKey_getKey(
        JNIEnv *env,
        jobject /* this */) {
    std::string key = "YouCanNotCaiDaoW";
    return env->NewStringUTF(key.c_str());
}


