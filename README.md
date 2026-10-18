# Assignment #4 — Facade Pattern

**Course:** Software Design Patterns (OP 6B06102)  
**Institution:** Astana IT University — School of Computer Engineering  
**Language:** Java 17  
**IDE:** IntelliJ IDEA  

---

## 📌 Project Overview
This project implements the **Facade structural design pattern** based on **Option A (Media/Video Conversion Facade)**. 

The primary goal of the Facade pattern here is to hide the complexity of a multi-step media conversion subsystem behind a simple, unified interface for standard clients, while allowing advanced clients to interact with subsystem components directly if needed.

---

## 🏗 Subsystem Architecture
The subsystem consists of 3+ collaborating components with distinct responsibilities:

1. **`VideoFile`**: Represents the input/output video stream and format metadata.
2. **`CodecFactory`**: Extracts and identifies the source/target video codecs (`Mp4Codec`, `OggCodec`).
3. **`BitrateReader`**: Reads the video stream buffer and rewrites it into the target format.
4. **`AudioMixer`**: Normalizes and cleans up the audio tracks after video conversion.
5. **`VideoConversionFacade`**: Coordinates all subsystem classes in the correct sequence via a single simplified method: `convertVideo(fileName, targetFormat)`.

---

## ✨ Clean Code Principles Applied

* **Meaningful Names:** Method names like `convertVideo` clearly state their purpose without exposing subsystem jargon.
* **Single Responsibility Principle (SRP):** The Facade only orchestrates the process, delegating specialized operations to `CodecFactory`, `BitrateReader`, and `AudioMixer`.
* **Subsystem Encapsulation:** High-level clients interact only with the Facade without needing to handle low-level buffer streams.
* **Robust Error Handling:** Low-level failures are caught and wrapped into domain-specific exceptions (`SubsystemException`, `UnsupportedFormatException`).
* **Independent Subsystems:** Subsystem classes hold no back-references to the Facade and remain fully functional independently.

---

## 🚀 How to Run

1. **Open Project:** Load the project in IntelliJ IDEA.
2. **Main Application:** Execute `src/main/Main.java` to observe:
   - Standard client execution via `VideoConversionFacade`.
   - Advanced client bypassing the Facade to call `CodecFactory` directly.
3. **Run Unit Tests:** Run `src/Test/VideoConversionFacadeTest.java` to execute JUnit 5 automated test cases.
