public class ImageDriver {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Error.");
			System.exit(0);
		}

		String directory = args[0];

		ImageManipulator im = new ImageManipulator();

		im.removePhotobomb(directory, "nophotobomb.jpg");

		im.zoomMiddle("nophotobomb.jpg", "zoomed.jpg");
	}
}
