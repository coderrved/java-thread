package yazlab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import static yazlab.ChildThread.deger;
import static yazlab.Graf.AltThread1CevapVermeSuresi;
import static yazlab.Graf.AltThread1DolmaSuresi;
import static yazlab.Graf.AltThread2CevapVermeSuresi;
import static yazlab.Graf.AltThread2DolmaSuresi;
import static yazlab.Graf.AnaThreadCevapVermeSuresi;
import static yazlab.Graf.AnaThreadUretmeSuresi;
import static yazlab.Graf.ChildThreadCevapVermeSuresi;
import static yazlab.Graf.ChildThreadDolmaSuresi;
import static yazlab.Graf.calistir;
import static yazlab.Graf.grafKontrol;
import static yazlab.Graf.rastgeleAnaThreadBosalt;
import static yazlab.Graf.rastgeleAnaThreadDoldur;
import static yazlab.Graf.rastgeleChildThreadBosalt;
import static yazlab.Graf.rastgeleChildThreadDoldur;
import static yazlab.Graf.rastgeleThread1Bosalt;
import static yazlab.Graf.rastgeleThread1Doldur;
import static yazlab.Graf.rastgeleThread2Bosalt;
import static yazlab.Graf.rastgeleThread2Doldur;
import static yazlab.Yazlab.altThreadCount;
import static yazlab.Yazlab.altThreadCount1;
import static yazlab.Yazlab.arrayList;
import static yazlab.Yazlab.arrayListCount;
import static yazlab.Yazlab.count;
import static yazlab.Yazlab.flag;
import static yazlab.Yazlab.childThreadKontrol1;
import static yazlab.Yazlab.childThreadKontrol2;
import static yazlab.Yazlab.childThreadKontrol3;
import static yazlab.Yazlab.i;
import static yazlab.Yazlab.j;
import static yazlab.Yazlab.i;
import static yazlab.Yazlab.arraySırası;
import static yazlab.Yazlab.zamanGenel;

public class Yazlab extends JFrame {

    static JFrame f;
    static JProgressBar jb = new JProgressBar();
    public static int count = 0;
    public static int count1 = 0;
    public static long sayac = System.currentTimeMillis();
    public static long sayacFark = sayac;
    public static int k = 1, k1 = 0, i = 0, j = 0, arraySırası = 0;
    public static int flag = 0, altThreadCount = 0, altThreadCount1 = 0;
    public static boolean threadKontrol = false;
    public static boolean childThreadKontrol1 = false;
    public static boolean childThreadKontrol2 = false;
    public static boolean childThreadKontrol3 = false;
    public static ArrayList<ChildThread> arrayList = new ArrayList<ChildThread>();
    public static Thread t;
    public static long zamanGenel = 0;
    public static int valueDeger = 0, arttirmaSayisi = 0, azaltmaSayisi = 0;
    public JPanel p = new JPanel();
    public static ArrayList<Integer> arrayListCount = new ArrayList<Integer>();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private Object lock3 = new Object();
    private Object lock4 = new Object();
    private Object lock5 = new Object();
    private Object lock6 = new Object();
    private Object lock7 = new Object();
    private Object lock8 = new Object();
    
    public void arttir(int sayi) {
        
        synchronized(lock1){
        count += sayi;
        if (count > 10000) {
            System.out.println("Genel Sayac Count: " + count);
            count = 10000;

        }
        }
    }

    public void azalt(int sayi) {
        
        synchronized(lock2){
        count -= sayi;
        if (count < 0) {
            count = 0;
            }
        }
    }

    public void AltThreadarttir(int sayi) {
        
        synchronized(lock3){
        altThreadCount += sayi;
        if (altThreadCount > 5000) {
            altThreadCount = 5000;
        }
        }
    }

    public void AltThreadazalt(int sayi) {
        
        synchronized(lock4){
        altThreadCount -= sayi;
        if (altThreadCount < 0) {
            altThreadCount = 0;
            }
        }
    }

    public void AltThread1arttir(int sayi) {
        
        synchronized(lock5){
        altThreadCount1 += sayi;
        if (altThreadCount1 > 5000) {
            altThreadCount1 = 5000;
            }
        }
    }

    public void AltThread1azalt(int sayi) {

        synchronized(lock6){
        altThreadCount1 -= sayi;
        if (altThreadCount1 < 0) {
            altThreadCount1 = 0;
            }
        }
    }

    public void ChildThreadarttir(int sıraNo, int sayi) {
        
        synchronized(lock7){
        arrayListCount.set(sıraNo, (arrayListCount.get(sıraNo) + sayi));
        if (arrayListCount.get(sıraNo) > 5000) {
            arrayListCount.set(sıraNo, 5000);
            }
        }
    }

    public void ChildThreadazalt(int sıraNo, int sayi) {

        synchronized(lock8){
        arrayListCount.set(sıraNo, (arrayListCount.get(sıraNo) - sayi));
        if (arrayListCount.get(sıraNo) < 0) {
            arrayListCount.set(sıraNo, 0);
            }
        }

    }

    public Yazlab() {

        
    }

    public void grafikOlustur() {

        jb.setBounds(100, 100, 160, 30);
        jb.setValue(k1);
        jb.setStringPainted(true);
        p.add(jb);
        f.add(p);
        setSize(500, 500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        k1 += 20;
        jb.setValue(k1);
        if (jb.getValue() == 1000) {
            System.out.println("TAMAMLANDI..");
        }
    }

    public static void main(String[] args) {
        
        Yazlab yz = new Yazlab();
        
        Random r = new Random();
        boolean grafControl = false;
        Graf g = new Graf();
        Scanner scan = new Scanner(System.in);

        int kt = scan.nextInt();

        ThreadGrafik tg = new ThreadGrafik();
        long sayi = System.currentTimeMillis();
        long sayi1 = sayi;
        long sonuc;
        int flagKontrol = 0, arrayLong = 0;
        boolean kontrol = false;

        while (true) {

            try {

                Thread.sleep(50);
                sayi += 50;

                System.out.println("Genel Sayac Count: " + count);
                tg.gonder(arrayLong);
                arrayLong++;
                valueDeger++;
                sonuc = (sayi - sayi1);
                zamanGenel = sonuc;
                Thread t3;
                arrayList.add(i, new ChildThread(childThreadKontrol1, childThreadKontrol2, childThreadKontrol3, flagKontrol));
                t3 = new Thread(arrayList.get(i));
                i++;
                t3.start();
                

                Thread t1 = new Thread(new SabitThread(sonuc, flagKontrol));
                Thread t2 = new Thread(new SabitThread1(sonuc, flagKontrol));
                System.out.println("ZAMAN: " + sonuc);

                if (sonuc % AnaThreadUretmeSuresi == 0) {

                    arttirmaSayisi = r.nextInt(rastgeleAnaThreadDoldur);
                    yz.arttir(arttirmaSayisi);
                    System.out.println("Ana Thread Arttiriyor: " + arttirmaSayisi);

                }
                if (sonuc % AnaThreadCevapVermeSuresi == 0) {

                    azaltmaSayisi = r.nextInt(rastgeleAnaThreadBosalt);
                    yz.azalt(azaltmaSayisi);
                    System.out.println("Ana Thread Azaltiliyor: " + azaltmaSayisi);
                    kontrol = true;

                }
                if (kontrol) {
                    flagKontrol++;
                }

                t1.start();
                t2.start();

            } catch (InterruptedException ex) {
                System.out.println("main hata");
            }
        }

    }

}

class SabitThread implements Runnable {
    
    Yazlab yz = new Yazlab();
    Random r = new Random();
    private long zaman;
    private int flag, rastgeleSayi1 = 0;
    private int rastgeleSayi = 0;

    public SabitThread(long zaman, int flag) {
        this.zaman = zaman;
        this.flag = flag;
    }

    public void run() {
        try {
            if (zaman % AltThread2DolmaSuresi == 0) {

                rastgeleSayi = r.nextInt(rastgeleThread1Doldur);
                if (rastgeleSayi > count) {
                    rastgeleSayi = count;
                    yz.AltThreadarttir(rastgeleSayi);
                    yz.azalt(rastgeleSayi);
                } else {
                    yz.AltThreadarttir(rastgeleSayi);
                    yz.azalt(rastgeleSayi);
                }
                System.out.println("Alt Thread 1 Doluyor: " + rastgeleSayi);
                System.out.println("Alt Thread 1 KAPASİTE: " + altThreadCount);

                if (altThreadCount >= 3500) {
                    childThreadKontrol2 = true;
                }

            }
            if (flag % 6 == 0 && zaman >= (500 + AltThread2CevapVermeSuresi)) {
                rastgeleSayi1 = r.nextInt(rastgeleThread1Bosalt);
                yz.AltThreadazalt(rastgeleSayi1);
                if (altThreadCount < 0) {
                    altThreadCount = 0;
                }
                System.out.println("Alt Thread 1 Azaltıyor: " + rastgeleSayi1);
                System.out.println("Alt Thread 1 KAPASİTE: " + altThreadCount);
                //System.out.println("Genel Sayac Count: " + count);
            }

        } catch (Exception e) {
            System.out.println("hata");
        }
    }
}

class SabitThread1 implements Runnable {
    Yazlab yz = new Yazlab();
    Random r = new Random();
    private long zaman;
    private int flag, rastgeleSayi1 = 0;
    private int rastgeleSayi = 0;

    public SabitThread1(long zaman, int flag) {
        this.zaman = zaman;
        this.flag = flag;
    }

    public void run() {
        try {
            if (zaman % AltThread1DolmaSuresi == 0) {

                rastgeleSayi = r.nextInt(rastgeleThread2Doldur);
                if (rastgeleSayi > count) {
                    rastgeleSayi = count;
                    yz.AltThread1arttir(rastgeleSayi);
                    yz.azalt(rastgeleSayi);
                } else {
                    yz.AltThread1arttir(rastgeleSayi);
                    yz.azalt(rastgeleSayi);
                }

                System.out.println("Alt Thread 2 Doluyor: " + rastgeleSayi);
                System.out.println("Alt Thread 2 KAPASİTE: " + altThreadCount1);

                if (altThreadCount1 >= 3500) {
                    //System.out.println("YENİ THREADLER EKLE");
                    childThreadKontrol1 = true;
                    //System.out.println("CHİLD THREAD KONTROL: " + childThreadKontrol);

                }

                //System.out.println("Genel Sayac Count: " + count); 
            }
            if (flag % 6 == 0 && zaman >= (500 + AltThread1CevapVermeSuresi)) {
                rastgeleSayi1 = r.nextInt(rastgeleThread2Bosalt);
                yz.AltThread1azalt(rastgeleSayi1);
                if (altThreadCount1 < 0) {
                    altThreadCount1 = 0;
                }

                System.out.println("Alt Thread 2 Azaltıyor: " + rastgeleSayi1);
                System.out.println("Alt Thread 2 KAPASİTE: " + altThreadCount1);
                System.out.println("Genel Sayac Count: " + count);
            }

        } catch (Exception e) {
            System.out.println("hata");
        }
    }
}

class ChildThread implements Runnable {

    Yazlab yz = new Yazlab();
    Random r = new Random();

    public static int deger = 0;
    private int flag;
    private int ilk = 0, rastgeleSayi = 0, rastgeleSayi1 = 0;
    private int eklenecekDeger = 0;
    private boolean ChildThreadControl1, ChildThreadControl2, ChildThreadControl3;

    public ChildThread(boolean ChildThreadKontrol1, boolean ChildThreadKontrol2, boolean ChildThreadKontrol3, int flagKontrol) {
        this.ChildThreadControl1 = ChildThreadKontrol1;
        this.ChildThreadControl2 = ChildThreadKontrol2;
        this.ChildThreadControl3 = ChildThreadKontrol3;
        this.flag = flagKontrol;

        if (ChildThreadControl1) {
            if (altThreadCount1 < 3500) {

            } else {
                System.out.println("YENİ THREAD OLUSTURULUYOR..");
                arrayListCount.add(j);
                System.out.println("ALT THREAD COUNT1 ÖNCE: " + altThreadCount1);
                eklenecekDeger = altThreadCount1 / 2;
                altThreadCount1 -= eklenecekDeger;
                System.out.println(j + " EKLENECEK DEGER: " + eklenecekDeger);
                System.out.println("ALT THREAD COUNT1 SONRA: " + altThreadCount1);
                arrayListCount.set(j, eklenecekDeger);
                j++;
                childThreadKontrol1 = false;
            }
        }
        if (ChildThreadControl2) {
            if (altThreadCount < 3500) {

            } else {
                System.out.println("YENİ THREAD OLUSTURULUYOR..");
                arrayListCount.add(j);
                System.out.println("ALT THREAD COUNT ÖNCE: " + altThreadCount);
                eklenecekDeger = altThreadCount / 2;
                altThreadCount -= eklenecekDeger;
                System.out.println(j + " THREAD EKLENECEK DEGER: " + eklenecekDeger);
                System.out.println("ALT THREAD COUNT SONRA: " + altThreadCount);
                arrayListCount.set(j, eklenecekDeger);
                j++;
                childThreadKontrol2 = false;
            }
        }
        if (ChildThreadControl3) {

            if (arrayListCount.get(arraySırası) < 3500) {

            } else {
                System.out.println("YENİ THREAD OLUSTURULUYOR..");
                arrayListCount.add(j);
                System.out.println("CHİLD THREAD COUNT ÖNCE: " + arrayListCount.get(arraySırası));
                eklenecekDeger = arrayListCount.get(arraySırası) / 2;
                arrayListCount.set(arraySırası, arrayListCount.get(arraySırası) - eklenecekDeger);
                System.out.println(j + " THREAD EKLENECEK DEGER: " + eklenecekDeger);
                System.out.println("ALT THREAD COUNT SONRA: " + arrayListCount.get(arraySırası));
                arrayListCount.set(j, eklenecekDeger);
                j++;
                childThreadKontrol3 = false;
            }
        }

    }

    @Override
    public void run() {

        for (int v = 0; v < arrayListCount.size(); v++) {

            try {
                if (zamanGenel % ChildThreadDolmaSuresi == 0) {

                    rastgeleSayi = r.nextInt(rastgeleChildThreadDoldur);

                    if (rastgeleSayi > count) {
                        rastgeleSayi = count;
                        yz.ChildThreadarttir(v, rastgeleSayi);
                        yz.azalt(rastgeleSayi);
                    } else {
                        yz.ChildThreadarttir(v, rastgeleSayi);
                        yz.azalt(rastgeleSayi);
                    }

                    System.out.println("Child Thread " + v + " Doluyor: " + rastgeleSayi);
                    System.out.println("Child Thread " + v + " KAPASİTE: " + arrayListCount.get(v));

                }
                if (flag % 6 == 0 && zamanGenel >= (500 + ChildThreadCevapVermeSuresi)) {
                    rastgeleSayi1 = r.nextInt(rastgeleChildThreadBosalt);
                    yz.ChildThreadazalt(v, rastgeleSayi1);
                    if (arrayListCount.get(v) < 0) {
                        arrayListCount.set(v, 0);
                    }

                    System.out.println("Child Thread " + v + " Azaltıyor: " + rastgeleSayi1);
                    System.out.println("Child Thread " + v + " KAPASİTE: " + arrayListCount.get(v));

                }

                if (arrayListCount.get(v) >= 3500) {
                    arraySırası = v;
                    childThreadKontrol3 = true;
                }
                if (arrayListCount.get(v) <= 0) {
                    System.out.println("CHİLD THREAD " + v + " KAPASİTESİ 0 DAN KÜCÜK");
                    System.out.println(v + ". SIRADAKİ THREAD SİLİNİYOR");
                    arrayListCount.remove(v);
                    j--;
                }

            } catch (Exception e) {
                System.out.println("hata");
            }

        }
    }

}
