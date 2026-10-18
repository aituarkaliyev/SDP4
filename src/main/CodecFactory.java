package main;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("main.CodecFactory: Extracting MPEG audio/video...");
            return new Mp4Codec();
        } else if (type.equals("ogg")) {
            System.out.println("main.CodecFactory: Extracting OGG audio/video...");
            return new OggCodec();
        } else {
            throw new UnsupportedFormatException("main.CodecFactory Error: Unsupported format -> " + type);
        }
    }
}