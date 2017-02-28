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

    double count = cap.get(CV_CAP_PROP_FRAME_COUNT);
    cout << "Frames loaded: " << count <<"\n";
    cap.set(CV_CAP_PROP_POS_FRAMES, count - 1);
    cv::namedWindow("MyVideo", CV_WINDOW_AUTOSIZE);

    while (1) {
        cv::Mat frame;
        bool success = cap.read(frame);
        if (!success) {
            cout << "Cannot read  frame " << endl;
            break;
        }
        cv::imshow("MyVideo", frame);
        if (cv::waitKey(0) == 27) break;
    }

    return 0;
}