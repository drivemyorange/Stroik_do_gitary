

class Main {

    public static void run(Audio audio,int N) {


        float Fs = audio.audioFormat.getSampleRate();
        double[] freq = new double[N];
        freq = Frequencies.wczytaj_f(N);






        while (true) { // nieskończona pętla, działa do zamknięcia programu,
            //System.out.println(audio.tempBuffer[50]);

            double[] im = new double[N]; // tworzenie wektora liczb zespolonych składa się z samych zer
            double[] re = Convert.toDoubleA(audio.tempBuffer); // wektor liczb rzeczywistych, składa się z naszego sygnału który znajduje się w tempBuffer - dodatkowo jest konwertowany na double array
            //FFT2.printReIm(re, im);
            FFT2 fft = new FFT2(N); // tworzenie nowego obiektu FFT
            fft.fft(re, im); // liczenie fft
            double czestotliwosc=Frequencies.czestotliwosc(re,im,freq); // wyznaczanie częstotliwości w której amplituda jest największa

            Frequencies.whatnote(czestotliwosc); // sprawdzanie jakiej nucie odpowiada wyliczona częstotliwosc




        }
    } // metoda która uruchamia wyznaczanie częstotliwości

    public static void main(String[] args) {

        Audio audio = new Audio(); // tworzenie nowego obiektu audio
        audio.captureAudio(); // przechwytywanie dźwięku do buffera
        Main.run(audio,64); // wywołanie metody run, liczba N zależna od rozmiaru buffera audio - powinna być 8 razy mniejsza


        //Frequencies.whatnote(1680);


        }

    }




