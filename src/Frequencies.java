public class Frequencies {


    public static void whatnote(double freq){

        char note='n';
        String nuta="nnn";

        // A

        int Adol = 105;
        int Agora = 112;

        if (freq >Adol && freq <Agora || freq >Adol*2 && freq <Agora*2 || freq >Adol*4 && freq <Agora*4 || freq >Adol*8 && freq <Agora*8) {
            note = 'A';
            System.out.println(note);
        }

        // As

        int As_dol = 113;
        int As_gora = 120;

        if (freq >As_dol && freq <As_gora || freq >As_dol*2 && freq <As_gora*2 || freq >As_dol*4 && freq <As_gora*4 || freq >As_dol*8 && freq <As_gora*8) {
            nuta = "As";
            System.out.println(nuta);
        }

        // B

        int B_dol = 121;
        int B_gora = 128;
        if (freq >B_dol && freq <B_gora || freq >B_dol*2 && freq <B_gora*2 || freq >B_dol*4 && freq <B_gora*4 || freq >B_dol*8 && freq <B_gora*8) {
            note = 'B';
            System.out.println(note);
        }

        // C

        int C_dol = 128;
        int C_gora = 135;
        if (freq >C_dol && freq <C_gora || freq >C_dol*2 && freq <C_gora*2 || freq >C_dol*4 && freq <C_gora*4 || freq >C_dol*8 && freq <C_gora*8) {
            note = 'C';
            System.out.println(note);
        }

        //Cis
        int Cis_dol = 135;
        int Cis_gora = 143;

        if (freq >Cis_dol && freq <Cis_gora || freq >Cis_dol*2 && freq <Cis_gora*2 || freq >Cis_dol*4 && freq <Cis_gora*4 || freq >Cis_dol*8 && freq <Cis_gora*8) {
            nuta = "Cis";
            System.out.println(nuta);
        }

        // D

        int D_dol = 143;
        int D_gora = 151;

        if (freq >D_dol && freq <D_gora || freq >D_dol*2 && freq <D_gora*2 || freq >D_dol*4 && freq <D_gora*4 || freq >D_dol*8 && freq <D_gora*8) {
            note = 'D';
            System.out.println(note);
        }

        // Dis

        int Dis_dol = 151;
        int Dis_gora = 160;

        if (freq >Dis_dol && freq <Dis_gora || freq >Dis_dol*2 && freq <Dis_gora*2 || freq >Dis_dol*4 && freq <Dis_gora*4 || freq >Dis_dol*8 && freq <Dis_gora*8) {
            nuta = "Dis";
            System.out.println(nuta);
        }

        // E

        int E_dol = 160;
        int E_gora = 169;

        if (freq >E_dol && freq <E_gora || freq >E_dol*2 && freq <E_gora*2 || freq >E_dol*4 && freq <E_gora*4 || freq >E_dol*8 && freq <E_gora*8) {
            note = 'E';
            System.out.println(note);
        }

        // F

        int F_dol = 169;
        int F_gora = 179;

        if (freq >F_dol && freq <F_gora || freq >F_dol*2 && freq <F_gora*2 || freq >F_dol*4 && freq <F_gora*4 || freq >F_dol*8 && freq <F_gora*8) {
            note = 'F';
            System.out.println(note);
        }

        // Fis

        int Fis_dol = 179;
        int Fis_gora = 190;

        if (freq >Fis_dol && freq <Fis_gora || freq >Fis_dol*2 && freq <Fis_gora*2 || freq >Fis_dol*4 && freq <Fis_gora*4 || freq >Fis_dol*8 && freq <Fis_gora*8) {
            nuta = "Fis";
            System.out.println(nuta);
        }

        // G

        int G_dol = 190;
        int G_gora = 202;

        if (freq >G_dol && freq <G_gora || freq >G_dol*2 && freq <G_gora*2 || freq >G_dol*4 && freq <G_gora*4 || freq >G_dol*8 && freq <G_gora*8) {
            note = 'G';
            System.out.println(note);
        }



        // Gis

        int Gis_dol = 202;
        int Gis_gora = 214;

        if (freq >Gis_dol && freq <Gis_gora || freq >Gis_dol*2 && freq <Gis_gora*2 || freq >Gis_dol*4 && freq <Gis_gora*4 || freq >Gis_dol*8 && freq <Gis_gora*8) {
            nuta = "Gis";
            System.out.println(nuta);

        }

        else{System.out.println("Brak");}


    } // metoda która sprawdza jakiej nucie odpowiada dana częstotliwość

    public static double[] wczytaj_f(int N) {
        double[] frequency = new double[N];
        frequency[0] = 0;
        for (int i = 1; i < N; i++) {
            frequency[i] = frequency[i - 1] + (44100 / N);
            System.out.println(frequency[i - 1]);
        }
        return frequency;
    } // metoda która wczytuje nam wektor częstotliwości zależny od f próbkowania i rozmiaru buffera

    public static double czestotliwosc(double[] re, double[] im, double[] frequencies) {

        double max=0;
        int index = 0;
        for(int i=0; i<re.length; i++) {
            double x = Math.pow(re[i], 2);
            double y = Math.pow(im[i], 2);

            double suma = x + y;
            if (suma >= max) {
                index = i;
            }

        }
        //System.out.println(frequencies[index]);
        return frequencies[index];



    } // metoda która sprawdza dla jakiej częstotliwości otrzymujemy max amplitude energii
}
