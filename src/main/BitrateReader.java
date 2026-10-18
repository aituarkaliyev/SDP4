package main;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        try {
            System.out.println("main.BitrateReader: Reading stream for " + file.getName() + " [main.Codec: " + codec.getType() + "]");
            return file;
        } catch (Exception e) {
            throw new RuntimeException("main.BitrateReader failed to read stream", e);
        }
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("main.BitrateReader: Rewriting stream to target codec...");
        return buffer;
    }
}