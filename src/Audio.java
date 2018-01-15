import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


class Audio {

    // parametry audio, potrzebne do przechwycenia dźwięku
    boolean stopCapture = false;
    ByteArrayOutputStream byteArrayOutputStream;
    AudioFormat audioFormat;
    TargetDataLine targetDataLine;
    SourceDataLine sourceDataLine;
    byte tempBuffer[] = new byte[512];

    public AudioFormat getAudioFormat() {
        float sampleRate = 44100.0F;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    } //metoda która ustala parametry audio,

    public void captureAudio() {
        try {

            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();    //get available mixers
            System.out.println("Available mixers:");
            Mixer mixer = null;
            for (int cnt = 0; cnt < mixerInfo.length; cnt++) {
                System.out.println(cnt + " " + mixerInfo[cnt].getName());
                mixer = AudioSystem.getMixer(mixerInfo[cnt]);

                Line.Info[] lineInfos = mixer.getTargetLineInfo();
                if (lineInfos.length >= 1 && lineInfos[0].getLineClass().equals(TargetDataLine.class)) {
                    System.out.println(cnt + " Mic is supported!");
                    break;
                }
            }

            audioFormat = getAudioFormat();     //get the audio format
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);


            targetDataLine = (TargetDataLine) mixer.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            DataLine.Info dataLineInfo1 = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo1);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            Thread captureAndPlayThread = new captureThread();   //thread to capture and play audio
            captureAndPlayThread.start();

        } catch (LineUnavailableException e) {
            System.out.println(e);
            System.exit(0);
        }
    } // metoda która sprawdza mikrofon i karte graficzną, uruchamia przechwytywanie audio

    class captureThread extends Thread {

        @Override
        public void run() {
            byteArrayOutputStream = new ByteArrayOutputStream();
            stopCapture = false;
            try {
                int readCount;
                while (!stopCapture) {
                    readCount = targetDataLine.read(tempBuffer, 0, tempBuffer.length);  //capture sound into tempBuffer
                    //if (readCount > 0) {
                        //byteArrayOutputStream.write(tempBuffer, 0, readCount);
                        //sourceDataLine.write(tempBuffer, 0, 512);   //playing audio available in tempBuffer

                    //}
                }
                byteArrayOutputStream.close();

            } catch (IOException e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    } // klasa która zapisuje dźwięk do buffera tempBuffer (nasze dane), może też odtwarzać dźwięk

}
