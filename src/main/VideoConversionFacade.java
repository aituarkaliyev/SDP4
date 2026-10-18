package main;

public class VideoConversionFacade {
    private final AudioMixer audioMixer;

    public VideoConversionFacade() {
        this.audioMixer = new AudioMixer();
    }
    public String convertVideo(String fileName, String targetFormat) {
        try {
            System.out.println("\n[FACADE] Starting conversion: " + fileName + " -> " + targetFormat);

            VideoFile file = new VideoFile(fileName);
            Codec sourceCodec = CodecFactory.extract(file);

            Codec destinationCodec;
            if (targetFormat.equalsIgnoreCase("mp4")) {
                destinationCodec = new Mp4Codec();
            } else if (targetFormat.equalsIgnoreCase("ogg")) {
                destinationCodec = new OggCodec();
            } else {
                throw new IllegalArgumentException("Invalid target format: " + targetFormat);
            }

            VideoFile buffer = BitrateReader.read(file, sourceCodec);
            VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
            String report = audioMixer.fix(intermediateResult);

            System.out.println("[FACADE] Conversion completed successfully.");
            return report + " [Target: " + targetFormat.toUpperCase() + "]";

        } catch (Exception e) {
            throw new SubsystemException("Facade Error: Failed to convert video file '" + fileName + "'", e);
        }
    }
}