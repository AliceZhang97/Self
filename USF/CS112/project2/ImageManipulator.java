/**
	A class to manipulate the images.
	@author Alice Zhang
**/
import java.io.File;
import java.util.Arrays;

public class ImageManipulator {


	//revomePhotobomb method
	public void removePhotobomb(String directory, String outputfile) {

		//create an array of files
		File[] files = (new File(directory)).listFiles();

		//get the count for .jpg
		int count = 0;
		for (File file : files) {
			String fileName = file.getAbsolutePath();
			if (fileName.endsWith(".jpg")) {
				count = count + 1;
			}
		}

		//create an array of pictures
		Picture[] pictures = new Picture[count];
		Picture picture = new Picture();
		int i = 0;

		for (File file : files) {
			String fileName = file.getAbsolutePath();
			if (fileName.endsWith(".jpg")) {
				picture = new Picture(fileName);
				pictures[i] = picture;
				i = i + 1;
			}
		}

		int width = picture.getWidth();
		int height = picture.getHeight();

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {

				//creating arrays of RGB
				int[] rArray = new int[pictures.length];
				int[] gArray = new int[pictures.length];
				int[] bArray = new int[pictures.length];

				int k = 0;

				int red;
				int green;
				int blue;

				//opening pictures
				for (Picture p : pictures) {

					//get the RGB from the pixel and store into the arrays
					Pixel pixel = p.getPixel(w,h);
					red = pixel.getRed();
					rArray[k] = red;
					green = pixel.getGreen();
					gArray[k] = green;
					blue = pixel.getBlue();
					bArray[k] = blue;
					k = k + 1;
				}

				//sorting the arrays
				Arrays.sort(rArray);
				Arrays.sort(gArray);
				Arrays.sort(bArray);

				//getting the median
				int newR = rArray[rArray.length/2];
				int newG = gArray[gArray.length/2];
				int newB = bArray[bArray.length/2];

				//set the piexel				
				picture.setPixel(w,h, new Pixel(newR, newG, newB));
			}
		}
		picture.store(outputfile);
	}


	//zooming method	
	public void zoomMiddle(String inputfile, String outputfile) {

		//open and create pictures 
		Picture picture = new Picture(inputfile);
		int width = picture.getWidth();
		int height = picture.getHeight();
		Picture p = new Picture(width, height);

		//set the quarter width and quarter height
		int quarterW = width / 4;
		int quarterH = height / 4;

		//get and set the pixels
		for (int w = quarterW; w < width - quarterW; w++) {
			for (int h = quarterH; h < height - quarterH; h++) {
				if (((w - quarterW) * 2) < width) {
					if (((h - quarterH) * 2) < height) {

						Pixel pixel = picture.getPixel(w, h);

						p.setPixel((w - quarterW) * 2, (h - quarterH) * 2, pixel);
						p.setPixel((w - quarterW) * 2, (h - quarterH) * 2 + 1, pixel);
						p.setPixel((w - quarterW) * 2 + 1, (h - quarterH) * 2, pixel);
						p.setPixel((w - quarterW) * 2 + 1, (h - quarterH) * 2 + 1, pixel);
					}
				}
			}
		}
		p.store(outputfile);
	}


}
