package NormalTest;


import com.JavaMLVisualizer.UI.Image.backend.JMLImage;

import java.io.File;


/**
 * @author Akshay Kumar
 */
public class ImageViewTest {

    public static void main(String[] args) {
        JMLImage test2 = new JMLImage();
        File file = new File("Data/rubiks_cube.jpg");

        test2.setImage(file,file,file);

        test2.setImageWidth(100,100,100);
        test2.setImageHeights(100,100,100);

        test2.setGapBetweenImages(10,10);

        test2.setInitialX(100);
        test2.setInitialY(100);

        test2.setImagesDirection(JMLImage.DIRECTION_X);

        test2.setWindowLabel("Testing");
        test2.showImage();
    }

}
