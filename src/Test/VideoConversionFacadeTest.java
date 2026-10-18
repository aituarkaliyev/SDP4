import main.SubsystemException;
import main.VideoConversionFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VideoConversionFacadeTest {

    private VideoConversionFacade facade;

    @BeforeEach
    void setUp() {
        facade = new VideoConversionFacade();
    }

    @Test
    void testSuccessfulConversion() {
        String result = facade.convertVideo("input.ogg", "mp4");
        assertNotNull(result);
        assertTrue(result.contains("Successfully processed"));
        assertTrue(result.contains("MP4"));
    }

    @Test
    void testUnsupportedFormatThrowsException() {
        assertThrows(SubsystemException.class, () -> {
            facade.convertVideo("input.unknown", "mp4");
        });
    }
}