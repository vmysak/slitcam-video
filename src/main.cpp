#include <stdio.h>
#include <opencv2/opencv.hpp>

using namespace std;

int main(int argc, char** argv) {
//    if (argc != 2) {
//        printf("usage: slitcam <Image_Path>\n");
//        return -1;
//    }

    cv::VideoCapture cap("/root/4/3.MOV");
    if (!cap.isOpened()) {
        cout << "Can't open file";
        return -1;
    }

    double fps = cap.get(CV_CAP_PROP_FPS);
    cout << "Frames per second: " << fps << endl;

    return 0;
}