package main;

public class Main {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        String result = converter.convertVideo("my-video.ogg", "mp4");
        System.out.println("Result: " + result);

        System.out.println("\n--- Advanced Client Direct Access ---");
        VideoFile directFile = new VideoFile("direct-stream.mp4");
        Codec codec = CodecFactory.extract(directFile);
        System.out.println("Extracted directly: " + codec.getType());
    }
}