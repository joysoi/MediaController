#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_nikola_assignmentprojectverison_MainActivity_onStartFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string play = "Play";
    return env->NewStringUTF(play.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_nikola_assignmentprojectverison_MainActivity_onPauseFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string pause = "Pause";
    return env->NewStringUTF(pause.c_str());
}


