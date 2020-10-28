package pl.backlog.green;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.core.Core.addWeighted;
import static org.opencv.imgcodecs.Imgcodecs.*;
import static org.opencv.imgproc.Imgproc.*;

public class Watermak {
    public static void main(String[] args) {
        nu.pattern.OpenCV.loadLocally();

        String imagePath = args[0];
        String watermarkPath = args[1];
        String finalImagePath = args[2];

        Mat image = Imgcodecs.imread(imagePath, IMREAD_COLOR);
        Size inSize = image.size();
        Size outSize = new Size(inSize.width/2.5, inSize.height/2.5);

        resize(image, image, outSize);
        cvtColor(image, image, COLOR_BGR2BGRA);

        Mat watermark = imread(watermarkPath, IMREAD_UNCHANGED);
        Mat transparentLayer = new Mat(outSize, CvType.CV_8UC4);
        Rect roi = new Rect(
                image.cols() - watermark.cols() - 10,
                image.rows() - watermark.rows() - 10,
                watermark.cols(),
                watermark.rows());
        watermark.copyTo(transparentLayer.submat(roi));

        Mat result = new Mat();
        addWeighted(image, 1, transparentLayer, 0.35, 0, result);
        imwrite(finalImagePath, result);
    }
}
