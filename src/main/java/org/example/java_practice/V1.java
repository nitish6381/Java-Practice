//package org.example.java_practice;
//
//public class V1 {
//}
//
//public class ImageProcessing {
//
//    static {
//        // Load OpenCV native library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }
//
//    public static void main(String[] args) {
//        // Assuming blur.png is the image file you want to process
//        String imagePath = "./blur.png";
//
//        // Initialize OpenCV
//        installDOM();
//
//        try {
//            onRuntimeInitialized(imagePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//    public class ImageQualityEvaluator {
//
//        static {
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        }
//
//        // Method to evaluate the quality of an image
//        public static double evaluateImageQuality(String imagePath) {
//            Mat image = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);
//            double blurScore = calculateBlurScore(image);
//            double skewScore = calculateSkewScore(image);
//            double exposureScore = calculateExposureScore(image);
//
//            return (blurScore + skewScore + exposureScore) / 3.0; // Simple average
//        }
//
//        // Method to calculate blur score using variance of Laplacian
//        private static double calculateBlurScore(Mat image) {
//            Mat laplacianImage = new Mat();
//            Imgproc.Laplacian(image, laplacianImage, CvType.CV_64F);
//            MatOfDouble mean = new MatOfDouble();
//            MatOfDouble stddev = new MatOfDouble();
//            Core.meanStdDev(laplacianImage, mean, stddev);
//            double variance = stddev.get(0, 0)[0] * stddev.get(0, 0)[0];
//            return variance; // Lower variance indicates more blur
//        }
//
//        // Method to calculate skew score (simplified example)
//        private static double calculateSkewScore(Mat image) {
//            // Example skew calculation (can be complex)
//            // This is just a placeholder for actual skew detection logic
//            return 1.0; // Placeholder score
//        }
//
//        // Method to calculate exposure score (simplified example)
//        private static double calculateExposureScore(Mat image) {
//            Mat hist = new Mat();
//            Imgproc.calcHist(List.of(image), new MatOfInt(0), new Mat(), hist, new MatOfInt(256), new MatOfFloat(0, 256));
//            // Exposure score calculation logic
//            return 1.0; // Placeholder score
//        }
//
//        // Method to evaluate the quality of a PDF
//        public static List<Double> evaluatePdfQuality(String pdfPath) throws IOException {
//            List<Double> scores = new ArrayList<>();
//            try (PDDocument document = PDDocument.load(new File(pdfPath))) {
//                PDFRenderer renderer = new PDFRenderer(document);
//                for (int page = 0; page < document.getNumberOfPages(); page++) {
//                    BufferedImage image = renderer.renderImageWithDPI(page, 300);
//                    Mat matImage = bufferedImageToMat(image);
//                    double score = evaluateImageQuality(matImage);
//                    scores.add(score);
//                }
//            }
//            return scores;
//        }
//
//        // Helper method to convert BufferedImage to Mat
//        private static Mat bufferedImageToMat(BufferedImage bi) {
//            Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
//            byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
//            mat.put(0, 0, data);
//            return mat;
//        }
//
//        // Overloaded method for evaluating Mat objects directly
//        public static double evaluateImageQuality(Mat image) {
//            double blurScore = calculateBlurScore(image);
//            double skewScore = calculateSkewScore(image);
//            double exposureScore = calculateExposureScore(image);
//
//            return (blurScore + skewScore + exposureScore) / 3.0; // Simple average
//        }
//
//        public static void main(String[] args) {
//            String imagePath = "path/to/your/image.jpg";
//            String pdfPath = "path/to/your/document.pdf";
//
//            try {
//                // Evaluate single image
//                double imageQualityScore = evaluateImageQuality(imagePath);
//                System.out.println("Image Quality Score: " + imageQualityScore);
//
//                // Evaluate PDF document
//                List<Double> pdfQualityScores = evaluatePdfQuality(pdfPath);
//                for (int i = 0; i < pdfQualityScores.size(); i++) {
//                    System.out.println("Page " + (i + 1) + " Quality Score: " + pdfQualityScores.get(i));
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
//
//
