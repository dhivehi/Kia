/*
 * kia demo in java
 * dhivehi liyaahen liyey, english akuru araany
 * eg: miliyevEnIwegotaSeve
 * eg: kihAderakame
 * SPACE NULAA LIYAANY, EXCEPTION HANDLE NUKOH INNAANY
 * usage: java -jar "kia.jar"
 * change line 79, 148, 162, 193 with the full path to where this file is located before compiling
 * first ever java application :D
 */

package javaapplication0000;

/**
 *
 * @author ...
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     */
    int helo = 0;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        kia kiaxo = new kia();
        kiaxo.loadEM();
        JFrame frame;
        Container contentPane;
        JTextField textfield;
        JButton button;
        FlowLayout layout;
        frame = new JFrame();
        frame.setTitle("kia");
        contentPane = frame.getContentPane();
        textfield = new JTextField("kIkEkiyEnI",32);
        button = new JButton("kia");
        button.addActionListener(new MyActionListener(textfield,kiaxo));
        contentPane.add(textfield);
        contentPane.add(button);
        layout = new FlowLayout();
        contentPane.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
class MyActionListener implements ActionListener {

    JTextField textfield;
    kia kianvy;
    MyActionListener(JTextField textfield, kia kiabela) {
        this.textfield=textfield;
        this.kianvy=kiabela;
    }
    public void actionPerformed(ActionEvent e) {
        String txt = textfield.getText();
        try {
            kianvy.txtKia(txt);
        } catch (Exception ee) {
            System.out.print("but why?");
        }
        try {
            Runtime.getRuntime().exec("aplay <full_path_to_where_jar_is>/ttstest.wav");
            //thats for ubuntu, may change to vlc if windows?
        } catch (Exception eg) {
            System.out.print("damnit -_-");
        }
    }

}
class kia {
    byte[] data = null;
    byte[] heda = null;
    String[] afili = {"ha", "hA", "hi", "hI", "hu", "hU", "he", "hE", "ho", "hO",
    "hq", "Sa", "SA", "Si", "SI", "Su", "SU", "Se", "SE", "So", "SO", "Sq", "na",
    "nA","ni", "nI", "nu", "nU", "ne", "nE", "no", "nO", "nq", "ra", "rA", "ri",
    "rI", "ru", "rU", "re", "rE", "ro", "rO", "rq", "ba", "bA", "bi", "bI", "bu",
    "bU", "be", "bE", "bo", "bO", "bq", "La", "LA", "Li", "LI", "Lu", "LU", "Le",
    "LE", "Lo", "LO", "Lq", "ka", "kA", "ki", "kI", "ku", "kU", "ke", "kE", "ko",
    "kO", "kq", "wa", "wA", "wi", "wI", "wu", "wU", "we", "wE", "wo", "wO", "wq",
    "va", "vA", "vi", "vI", "vu", "vU", "ve", "vE","vo", "vO", "vq", "ma", "mA",
    "mi", "mI", "mu", "mU", "me", "mE", "mo", "mO", "mq", "fa", "fA", "fi", "fI",
    "fu", "fU", "fe", "fE", "fo", "fO", "fq", "da", "dA", "di", "dI", "du", "dU",
    "de", "dE", "do", "dO", "dq", "ta", "tA", "ti", "tI", "tu", "tU", "te", "tE",
    "to", "tO", "tq", "la", "lA", "li", "lI", "lu", "lU", "le", "lE", "lo", "lO",
    "lq", "ga", "gA", "gi", "gI", "gu", "gU", "ge", "gE", "go", "gO", "gq", "Na",
    "NA", "Ni", "NI", "Nu", "NU", "Ne", "NE", "No", "NO", "Nq", "sa", "sA", "si",
    "sI", "su", "sU", "se", "sE", "so", "sO", "sq", "Da", "DA", "Di", "DI", "Du",
    "DU", "De", "DE", "Do", "DO", "Dq", "Za", "ZA", "Zi", "ZI", "Zu", "ZU", "Ze",
    "ZE", "Zo", "ZO", "Zq", "Ta", "TA", "Ti", "TI", "Tu", "TU", "Te", "TE", "To",
    "TO", "Tq", "ya", "yA", "yi", "yI", "yu", "yU", "ye", "yE", "yo", "yO", "yq",
    "pa", "pA", "pi", "pI", "pu", "pU", "pe", "pE", "po", "pO", "pq", "ja", "jA",
    "ji", "jI", "ju", "jU", "je", "jE", "jo", "jO", "jq", "Ca", "CA", "Ci", "CI",
    "Cu", "CU", "Ce", "CE", "Co", "CO", "Cq"};
    // 264
    int[] kindex = {0,10816,25176,35264,45934,56550,68844,79262,93270,103748,
        119670,125836,137730,149198,160666,175724,187200,202262,213730,230590,
        242064,257126,267182,278168,292030,302630,316080,326720,340190,351228,
        367260,377092,387392,398820,409140,423272,433654,447472,458588,471466,
        481848,494306,505420,519598,528590,537516,549778,558720,570412,578916,
        590756,599322,611204,619708,631544,640048,647658,658370,665566,677472,
        687780,702258,714432,725268,737502,753530,761818,773732,786144,796790,
        811020,821348,835388,845638,858960,869288,883324,893652,901016,912452,
        919386,930764,937704,948728,956138,963078,970018,976958,983898,995544,
        1009010,1019994,1033296,1044522,1057562,1068782,1080008,1091234,1104746,
        1115972,1126234,1139794,1149676,1164086,1173992,1184300,1194608,1207770,
        1217644,1231660,1241534,1251966,1266470,1276472,1290434,1300442,1314534,
        1325012,1339126,1349134,1363222,1373230,1384606,1400072,1410720,1425326,
        1436500,1451760,1463210,1478302,1489340,1504460,1515498,1526156,1540886,
        1551114,1565302,1575536,1589854,1600558,1614898,1625132,1639446,1649680,
        1659546,1672688,1681794,1693958,1703826,1716978,1726906,1739646,1749892,
        1763062,1773308,1781426,1793262,1800948,1812240,1819930,1831352,1839518,
        1850962,1858652,1870534,1878224,1889888,1904800,1916102,1930484,1941790,
        1956282,1967992,1982954,1994224,2008736,2020006,2030334,2044734,2054610,
        2068468,2078372,2092360,2102612,2116622,2126526,2140510,2150414,2161906,
        2178454,2189502,2205772,2218910,2235710,2248844,2265668,2278806,2296066,
        2309204,2325824,2345102,2361294,2380018,2396218,2415074,2431266,2450146,
        2466344,2484576,2500774,2510840,2524620,2534734,2548432,2558548,2572376,
        2582490,2596342,2606458,2620282,2630398,2640700,2653034,2662932,2676388,
        2685886,2699022,2710424,2724806,2735876,2750242,2761312,2771116,2784634,
        2794486,2807922,2817776,2831342,2841194,2854784,2864638,2878200,2888054,
        2897852,2909834,2918196,2932512,2941866,2961922,2971260,2989486,2998812,
        3015910,3025236,3035992,3050462,3061266,3075654,3086460,3100978,3111782,
        3126324,3137130,3151644,3162450};
    public void loadEM() throws IOException {
        // load data
        this.data = getData();
        this.heda = getHeda();
        System.out.println("loading resources...");
    }
    private byte[] getData() throws IOException, FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("<full_path_to_where_jar_is>/adu.bin");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        int nx = 0;
        while (-1 != (n = inputStream.read(buffer))) {
            output.write(buffer, 0, n);
            nx+=n;
        }
        inputStream.close();
        System.out.println("getting data...");
        return output.toByteArray();
    }
    private byte[] getHeda() throws IOException, FileNotFoundException {
        FileInputStream headerS = new FileInputStream("<full_path_to_where_jar_is>/header.bin");
        ByteArrayOutputStream headerf = new ByteArrayOutputStream();
        byte[] bufferh = new byte[40];
        headerS.read(bufferh);
        headerf.write(bufferh,0,40);
        headerS.close();
        System.out.println("getting header...");
        return headerf.toByteArray();

    }
    private int dataDhigu(int[] indexx) {
        int ixx = 0;
        int lenn = 0;
        for (int i=0;i<indexx.length/2;i++) {
            // same as changed on writing
            int mi=indexx[ixx+1]-(indexx[ixx]+2024);
            lenn+=mi;
            ixx+=2;
        }
        System.out.println("getting data len... "+lenn);
        return lenn;
    }
    private void saveEM(int[] indexes) throws FileNotFoundException, IOException {
        // indexes - start,end position of each sound data part
        // datalen - length of all parts, looplen - number of parts
        // adufile = this.output
        // header file = this.headerf
        // prepare outStream
        int datalen = dataDhigu(indexes);
        int looplen = indexes.length/2;
        System.out.println("initiate saving "+looplen+" character string of "+datalen+" bytes...");
        FileOutputStream outStreamx = new FileOutputStream("<full_path_to_where_jar_is>/ttstest.wav");
        // write header
        outStreamx.write(this.heda);
        // add decoded len
        int ha = Integer.reverseBytes(datalen);
        String hahex = Integer.toHexString(ha);
        //if it gets stuck, its stuck
        while (hahex.length() != 8) {
            hahex+="0";
        }
        int ix = 0;
        for (int i=0;i<4;i++) {
            String mi="0x"+hahex.substring(ix, ix+2);
            int dat = Integer.decode(mi);
            outStreamx.write(dat);
            ix+=2;
        }

        // start main loop
        int inx = 0;
        for (int i=0;i<looplen;i++) {
            // change -2024 makes kullijehun less
            outStreamx.write(this.data,indexes[inx],(indexes[inx+1]-indexes[inx])-2024);
            inx+=2;
        }
        outStreamx.close();
        System.out.println("tadaaa!");
    }
    public void txtKia (String txt) throws FileNotFoundException, IOException {
        // NO EXCEPTION HANDLING SO CAREFUL WHAT YOU CALL IT WITH
        // call with text to turn to speech
        // get mapped indexes, call saveEM, done :)
        int[] miMap = new int[txt.length()];
        String mi = ""; // afili from txt.substring
        String thi = ""; // afili from afili array
        int ix = 0;
        for (int i=0;i<txt.length()/2;i++) {
            mi = txt.substring(ix, ix+2);
            // get akuru + fili
            // get index of afili, gets data index too
            for (int ii=0;ii<264;ii++) {
                thi = this.afili[ii];
                if (mi.equals(thi)) {
                    // akuru + fili is valid, get data index ERROR
                    miMap[ix]=this.kindex[ii];
                    miMap[ix+1]=this.kindex[ii+1];
                    break;
                }
            }
            ix+=2;
        }
        this.saveEM(miMap);
    }
}
