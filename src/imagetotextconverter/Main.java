/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagetotextconverter;

/**
 *
 * @author Manvendra
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Main {

    /**
     * @param args the command line arguments
     */

        static double Tmatch = 0.0;
    static double Tmismatch = 0.0;
    static double Tintensity = 0.0;

static int x1 = 0,y1 = 0;

 static long a[] = new long[10000];
static long b[] =  new long[10000];

    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }



    private void colormodifiedImage(BufferedImage image) {
int wd = image.getWidth();
int hd = image.getHeight();
System.out.println("Image width, height: " + wd + ", " + hd);
int alphas;
int reds;
int greens;
int blues;

int min[] = new int[10000];
int y =0;
int c = 0;
int s = 0;
int i,j;
int arr[] = new int[10000];
 min[y] = wd+100;
for( i = 0 ; i < hd ; i++)
{
    for ( j = 0; j < wd; j++) {
    int pixels = image.getRGB(j, i);
     alphas = (pixels >> 24) & 0xff;
 reds = (pixels >> 16) & 0xff;
 greens = (pixels >> 8) & 0xff;
 blues = (pixels) & 0xff;

if( reds < 50 && greens < 50 && blues < 50 )
{

    c++;


}
}

    min[s] = c;
if(c == wd)
{
    Color myWhite = new Color(255, 255, 255); // Color white
int rgb=myWhite.getRGB();
for (int k = 0; k < j; k++) {
image.setRGB(k, i, rgb);
}
}



    if( j != 0 && s != 0 && min[s] == 0 && min[s-1] != 0 )
    {
        arr[y] = i;
        System.out.println(arr[y] + " " + y);
       y++;


    }

     s++;


c = 0;

}
System.out.println(y);

int count = 0;
BufferedImage imgs[] = new BufferedImage[y]; //Image array to hold image ch
 for(int m = 0 ; m < y ; m++)
 {

int letterHeight = arr[m]+2;
int k = 0;
int l = arr[m]+2;
if( m > 0)
{
    letterHeight = (arr[m]+2)-(arr[m-1]+2);
     k = arr[m-1]+2;

}
int letterWidth = image.getWidth();
System.out.println("Letter size " + letterWidth + " "+ letterHeight);


 imgs[count] = new BufferedImage(letterWidth, letterHeight, image.getType()
);

 // draws the image chunk

 if(count > 0)
 {
     Graphics2D gr = imgs[count].createGraphics();
 gr.drawImage(image, 0, k, letterWidth, l, 0, k, letterWidth, l, null);
 imgs[count] = image.getSubimage(0, k, letterWidth, letterHeight);
      count++;
 gr.dispose();

 }
 else
 {
     Graphics2D gr = imgs[count++].createGraphics();
  gr.drawImage(image, 0, 0, letterWidth, letterHeight, 0, 0, letterWidth, letterHeight, null);
 gr.dispose();

 }
 }

System.out.println("Splitting done");

for(int p = 0 ; p < imgs.length ; p++)
{
 int letterWidth = imgs[p].getWidth();
int letterHeight = imgs[p].getHeight();
System.out.println("Letter size " + letterWidth + " "+ letterHeight);
}




 System.out.println("Mini images created " + y);

 if(y > 1)
 {
     for(int p = 0 ; p < y ; p++)
{
     horizontalCropped(imgs[p]);
}
 }
 else
 {
    horizontalCropped(image);
 }

}


    public void horizontalCropped(BufferedImage image) {

   int wd = image.getWidth();
int hd = image.getHeight();
System.out.println("Image width, height: " + wd + ", " + hd);
int alphas;
int reds;
int greens;
int blues;

int min[] = new int[10000];
int y =0;
int c = 0;
int s = 0;

int arr[] = new int[10000];
int arr2[] = new int[10000];
 min[y] = wd+100;
 int min2[] = new int[10000];
int y2 =0;
int c2 = 0;
int c3 = 0;
int i,j,t=0;

 min2[y2] = wd+100;
 int r = wd+100;
for( i = 0 ; i < wd ; i++)
{
    for ( j = 0; j < hd; j++) {
    int pixels = image.getRGB(i, j);
     alphas = (pixels >> 24) & 0xff;
 reds = (pixels >> 16) & 0xff;
 greens = (pixels >> 8) & 0xff;
 blues = (pixels) & 0xff;

if( reds < 50 && greens < 50 && blues < 50 )
{

    c++;
    c2++;


}


 if(c2 != 0 && c2 < r)
{
    r = c2;
}


}



    min[s] = c;

        if(r < 10)
    r = 10;
    if(r > 10)
        r = r+10;


        if( c2 != 0 && c2 <= r )
    {
        min2[y2] = c2;
        arr2[y2] = i;


        y2++;


    }

    else if( i != 0 && s != 0 && min[s] == 0 && min[s-1] != 0 )
    {
        arr[y] = i;
System.out.println("arr value : "+arr[y]+" "+y);
       y++;


    }


     s++;


c = 0;
c2=0;
}
System.out.println("y value : "+y);
System.out.println("y2 value : "+y2);
int count = 0;
BufferedImage imgs0[] = new BufferedImage[y];
int count2 = 0;
int m2[] = new int[10000];
int p = 0;
BufferedImage imgs2[] = new BufferedImage[y2];
BufferedImage imgs3[] = new BufferedImage[wd+100];
int q2=0;
int z1 = 0;
 int z2 = 0;


 //working on font text

if(y > 1)
{

 //Image array to hold image ch
 for(int m = 0 ; m < y ; m++)
 {

int letterWidth = arr[m]+1;
int l = arr[m]+1;
int o = 0;
int k = 0;
if( m > 0)
{
    letterWidth = (arr[m]+1)-(arr[m-1]+1);
    k = arr[m-1]+1;
     o = arr[m]+1;
     System.out.println("value of k "+k);
}
int letterHeight = image.getHeight();



 imgs0[count] = new BufferedImage(letterWidth, letterHeight, image.getType()
);
/*int letterWidth1 = imgs0[count].getWidth();
int letterHeight1 = imgs0[count].getHeight();
System.out.println("Letter size img000000 " + letterWidth1 + " "+ letterHeight1);
count++;*/
 // draws the image chunk



 if(count > 0)
 {
     Graphics2D gr = imgs0[count].createGraphics();
      gr.drawImage(image, k, 0, letterWidth, letterHeight, k, 0, letterWidth, letterHeight, null);
      imgs0[count] = image.getSubimage(k, 0, letterWidth, letterHeight);
      count++;
     gr.dispose();

 }

 else
 {
     Graphics2D gr = imgs0[count++].createGraphics();
  gr.drawImage(image, 0, 0, letterWidth, letterHeight, 0, 0, letterWidth, letterHeight, null);
 gr.dispose();

 }


 }
 System.out.println("Splitting done");

 for ( i = 0; i < imgs0.length; i++) {
                try {
                    ImageIO.write(imgs0[i], "jpg", new File("img" + i + ".jpg"));

                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
 }


for(int q = 0 ; q < imgs0.length ; q++)
{
 int letterWidth1 = imgs0[q].getWidth();
int letterHeight1 = imgs0[q].getHeight();
System.out.println("Letter size " + letterWidth1 + " "+ letterHeight1);
}
 System.out.println("Mini images created");
}



// working on handwritten
 if(y2 > 0 && imgs0.length == 1)
{
   for(i = 0 ; i < y2 ; i++)
{
    System.out.println("unit: "+min2[i]+" " +arr2[i]+" "+i);
}



 int arr3[] = new int[10000];

 System.out.println();
for( i = 0 ; i < wd ; i++)
{

    if(i == arr2[z1])
        {

    for ( j = 0; j < hd; j++) {


       int  pixels = image.getRGB(i+1, j);
     alphas = (pixels >> 24) & 0xff;
 reds = (pixels >> 16) & 0xff;
 greens = (pixels >> 8) & 0xff;
 blues = (pixels) & 0xff;

if( reds < 50 && greens < 50 && blues < 50 )
{

    c2++;

}


 if(c2 != 0 && c2 < r)
{
    r = c2;
}


        }

    if(r <= 10)
    r = 10;
    if(r > 10)
        r = r+10;



       if(c2 > r)
       {
           arr3[z2] = i;
           System.out.println("split : "+arr3[z2]+" " +z2 +" "+c2+" "+r);
           z2++;
       }
z1++;
    }

    c2 = 0;
}

 if(wd < 1000)
 {
for(i = 0 ; i < z2 ; i++)
{
    if(arr3[i] > 10)
    {
        arr3[i] = arr3[i]-10;
    }
    System.out.println("Mod : "+arr3[i]+" "+i);
}
 }
 else if(wd > 1000)
 {
    for(i = 0 ; i < z2 ; i++)
{
    if(arr3[i] > 5)
    {
        arr3[i] = arr3[i]-5;
    }
    System.out.println("Mod : "+arr3[i]+" "+i);
}
 }

 if(i == z2)
 {
  arr3[i] = wd;
  System.out.println("Mod : "+arr3[i]+" "+i);
  i++;
 }



int letterWidth = 0;
int letterHeight = 0;
for(int n = 0 ; n < i ; n++)
{



 letterWidth = arr3[n];
 int l = arr3[n];
int k = 0;
if( n > 0)
{
    letterWidth = (arr3[n])-(arr3[n-1]);
    k = arr3[n-1];
}


 letterHeight = image.getHeight();



 imgs2[count2] = new BufferedImage(letterWidth, letterHeight, image.getType()
);

 // draws the image chunk

 if(count2 > 0)
 {
     Graphics2D gr = imgs2[count2++].createGraphics();
 gr.drawImage(image, 0, 0, letterWidth, letterHeight, 0, k, letterWidth, l, null);
 gr.dispose();

 }
 else
 {
     Graphics2D gr = imgs2[count2++].createGraphics();
  gr.drawImage(image, 0, 0, letterWidth, letterHeight, 0, 0, letterWidth, letterHeight, null);
 gr.dispose();

 }

}

System.out.println("Splitting done "+p);



for(int q = 0 ; q < count2 ; q++)
{
  letterWidth = imgs2[q].getWidth();
 letterHeight = imgs2[q].getHeight();
System.out.println("Letter size of img2 " + letterWidth + " "+ letterHeight);
if(letterWidth > 10 )
{
    imgs3[q2] = imgs2[q];
    q2++;
}


}


for(int q1 = 0 ; q1 < q2 ; q1++)
{
    letterWidth = imgs3[q1].getWidth();
    letterHeight = imgs3[q1].getHeight();
System.out.println("Letter size of img3 " + letterWidth + " "+ letterHeight);

}
System.out.println("Mini images created"+" "+z2+" "+q2);
}




 if(y > 1)
 {
     for(int q = 0 ; q < y ; q++)
{
     verticalCroppedText(imgs0[q]);
}
 }


 else if(z2 > 0 || q2 > 0)
{

     if(z2 > 0 && q2 == 0)
             {
         for(int q = 0 ; q < z2 ; q++)
{

     verticalCroppedText(imgs2[q]);
             }
     }

             else if(z2 > 0 && q2 > 0)
             {
                 for(int q = 0 ; q < q2 ; q++)
                 {
     verticalCroppedText(imgs3[q]);
             }
}
}


 else
 {
    verticalCroppedText(image);
 }

}

private void verticalCroppedText(BufferedImage image) {

    int w = image.getWidth();
int h = image.getHeight();
System.out.println("Text width, height: " + w + ", " + h);

BufferedImage imagesamplecrop = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
imagesamplecrop.createGraphics().drawImage(image, 0, 0, 100, 100, null);
int ws = imagesamplecrop.getWidth();
int hs = imagesamplecrop.getHeight();
System.out.println("Cropped width, height: " + ws + ", " + hs);
int i , j;
for ( i = 0; i < 100; i++) {
for ( j = 0; j < 100; j++) {

int pixels = imagesamplecrop.getRGB(i, j);

int alphas = (pixels >> 24) & 0xff;
int reds = (pixels >> 16) & 0xff;
int greens = (pixels >> 8) & 0xff;
int blues = (pixels) & 0xff;



//int avgs = (reds+greens+blues)/4;

/*if( blued <= 10 && blues <= 10)
{
    match++;
}
else if(blued < 200 && blues < 200 &&  blued > 50 && blues > 50 )
{
    mismatch++;
}*/

if( reds < 50 && greens < 50 && blues < 50 )
{


    a[x1] = i;
    b[y1] = j;
x1++;
y1++;
}

}
}

/*for(int m = 0 ; m < x1 ; m++ )
{
    System.out.print(a[m] +" ");

}
System.out.println();
for(int n = 0 ; n < y1 ; n++ )
{
    System.out.print(b[n] + " ");
}*/

int c=0;
int d = 0;

//for A

for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] == 50 && b[k] <= 35 && b[k] >= 0 )
    {
        c++;
        System.out.println("1");
        break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] == 45 && b[k] <= 35 && b[k] >= 0 )
    {
        c++;
        System.out.println("2");
        break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] == 55 && b[k] <= 35 && b[k] >= 0 )
    {
        c++;
        System.out.println("3");
        break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 45 && a[k] <= 45 && a[k] >= 0 )
    {
        c++;
        System.out.println("4");
         break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 45 && a[k] >= 55 && a[k] < 100 )
    {
        c++;
        System.out.println("5");
         break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 50 && b[k] <= 85 && a[k] == 50 )
    {
        c++;
        System.out.println("6");
         break;
    }
}
for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 90 && a[k] >= 0 && a[k] < 100 )
    {
        c++;
        System.out.println("7");
         break;
    }
}

for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 85 && b[k] < 100 && a[k] == 50 )
    {
        d++;
         break;
    }
}



System.out.println("value of c,d for A :"+c+" "+d);
if(c >= 7 && d == 0)
{
for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] >= 0 && a[k] < 100 && b[k] <= 35 )
    {
        Tmatch++;
    }
    if(b[k] > 35 && b[k] <= 50 && a[k] <= 45 && a[k] >= 0 )
    {
        Tmatch++;
    }
    if(b[k] > 35 && b[k] <= 50 && a[k] >= 55 && a[k] < 100 )
    {
        Tmatch++;
    }
     if(b[k] > 50 && b[k] <= 85 && a[k] >= 0 && a[k] < 100 )
    {
        Tmatch++;
    }
     if(b[k] >= 85 && a[k] <= 45 && a[k] >= 0 )
    {
        Tmatch++;
    }
    if(b[k] >= 85 && a[k] >= 55 )
    {
        Tmatch++;
    }
}

Tmismatch = x1 - Tmatch;
System.out.println(x1 + " " + y1);
System.out.println("TMatch: " + Tmatch);
System.out.println("TMismatch: " + Tmismatch);
if(Tmatch >= Tmismatch )
{
System.out.println("letter A");
}
System.out.println();
System.out.println();
}

//for B

else if(c < 7 || d > 0)
{
    c = 0;
    d = 0;

for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] <= 25 && a[k] == 50 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] <= 25 && a[k] == 45 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] <= 25 && a[k] == 55 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 75 && a[k] == 50 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 75 && a[k] == 45 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 75 && a[k] == 55 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 25 && a[k] <= 45 && a[k] >= 0 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 25 && a[k] >= 55 && a[k] < 100 )
    {
        c++;
         break;
    }
}
      for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 40 && a[k] <= 45 && a[k] >= 0 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 40 && a[k] >= 55 && a[k] < 100 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 60 && a[k] <= 45 && a[k] >= 0 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 60 && a[k] >= 55 && a[k] < 100 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 75 && a[k] <= 45 && a[k] >= 0 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 75 && a[k] >= 55 && a[k] < 100 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 40 && b[k] <= 60 && a[k] == 50 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 40 && b[k] <= 60 && a[k] == 45 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] >= 40 && b[k] <= 60 && a[k] == 55 )
    {
        c++;
         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 25 && b[k] < 40 && a[k] == 50 )
    {
        d++;

         break;
    }
}
    for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 60 && b[k] < 75 && a[k] == 50 )
    {
        d++;
         break;
    }
}


System.out.println("value of c,d for B :"+c+" "+d);

if( c >= 17 && d == 0)
{
    for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] >= 0 && a[k] < 100 && b[k] <= 25 )
    {
        Tmatch++;
    }
    if(b[k] > 25 && b[k] <= 40 && a[k] <=45 && a[k] >= 0 )
    {
      Tmatch++;
    }
     if(b[k] > 25 && b[k] <= 40 && a[k] >=55 && a[k] < 100 )
    {
      Tmatch++;
    }
    if(b[k] >= 60 && b[k] < 75 && a[k] <=45 && a[k] >= 0 )
    {
      Tmatch++;
    }
     if(b[k] >= 60 && b[k] < 75 && a[k] >=55 && a[k] < 100 )
    {
      Tmatch++;
    }
     if(a[k] >= 0 && a[k] < 100 && b[k] >= 75 )
    {
        Tmatch++;
    }
}

Tmismatch = x1 - Tmatch;
System.out.println(x1 + " " + y1);
System.out.println("TMatch: " + Tmatch);
System.out.println("TMismatch: " + Tmismatch);
if(Tmatch >= Tmismatch )
{
System.out.println("letter B");
}
System.out.println();
System.out.println();

}

// for C
else if( c < 17 || d > 0)
{
   c = 0;
   d = 0;

      for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 20 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 50 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 80 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 20 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 50 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 80 )
    {
        c++;
         break;
    }
}
      for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 30 && a[k] < 20 )
    {
        c++;
         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 50 && a[k] < 20 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 70 && a[k] < 20 )
    {
        c++;
         break;
    }
}




      for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 45 && a[k] > 90 )
    {
        d++;

         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 50 && a[k] > 90 )
    {
        d++;

         break;
    }
}
         for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 55 && a[k] > 90 )
    {
        d++;

         break;
    }
}
            for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 50 && a[k] > 30 && a[k] < 70 )
    {
        d++;
         break;
    }
}
               for(int k = 0 ; k < x1 ; k++)
{
      if(a[k] == 50 && b[k] > 45 && b[k] < 55 )
    {
        d++;
         break;
    }
}

   System.out.println("value of c, d for C :"+c+" "+d);
   if(c >= 9 && d == 0)
   {
for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] < 20 && b[k] >= 0 && b[k] < 100 )
    {
        Tmatch++;
    }
    if(b[k] <  30 && a[k] >= 0 && a[k] < 100 )

    {
      Tmatch++;
    }
    if(b[k] >  70 && a[k] >= 0 && a[k] < 100 )
    {
      Tmatch++;
    }
}

Tmismatch = x1 - Tmatch;
System.out.println(x1 + " " + y1);
System.out.println("TMatch: " + Tmatch);
System.out.println("TMismatch: " + Tmismatch);
if(Tmatch >= Tmismatch )
{
System.out.println("letter C");
}
System.out.println();
System.out.println();



   }

   // for D
   else if(c < 9 || d > 0)
   {
       c = 0;
       d = 0;

       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 20 && a[k] < 20 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 40 && a[k] < 20 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 60 && a[k] < 20 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 80 && a[k] < 20 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 20 && a[k] > 80 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 40 && a[k] > 80 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 60 && a[k] < 80 )
    {
        c++;
         break;
    }
}
              for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] == 80 && a[k] > 80 )
    {
        c++;
         break;
    }
}
        for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 20 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 40 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 60 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] < 30 && a[k] == 80 )
    {
        c++;
         break;
    }
}
               for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 20 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 40 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 60 )
    {
        c++;
         break;
    }
}
       for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 70 && a[k] == 80 )
    {
        c++;
         break;
    }
}

     for(int k = 0 ; k < x1 ; k++)
{
      if(b[k] > 30 && b[k] < 70 && a[k] == 50 )
    {
        d++;
         break;
    }
}
            for(int k = 0 ; k < x1 ; k++)
{
      if(a[k] > 30 && a[k] < 70 && b[k] == 50 )
    {
        d++;
         break;
    }
}
       System.out.println("value of c, d for D :"+c+" "+d);

       if( c >= 16 && d == 0)
       {
           for(int k = 0 ; k < x1 ; k++)
{
    if(a[k] < 20 && b[k] >= 0 && b[k] < 100 )
    {
        Tmatch++;
    }
    if(a[k] > 80 && b[k] >= 0 && b[k] < 100 )
    {
        Tmatch++;
    }
    if(b[k] <  30 && a[k] >= 0 && a[k] < 100 )

    {
      Tmatch++;
    }
    if(b[k] >  70 && a[k] >= 0 && a[k] < 100 )
    {
      Tmatch++;
    }
}

Tmismatch = x1 - Tmatch;
System.out.println(x1 + " " + y1);
System.out.println("TMatch: " + Tmatch);
System.out.println("TMismatch: " + Tmismatch);
if(Tmatch >= Tmismatch )
{
System.out.println("letter D");
}
System.out.println();
System.out.println();



       }

       // for E
       else if( c < 16 || d > 0)
       {


       }






   }





}


}




//for T

/*for(int k = 0 ; k < x1 ; k++)
{
    if( a[k] >= 0 && a[k] < 100 && b[k] <=  35)
    {
       Tmatch++;
    }
}
for(int l = 0 ; l < y1 ; l++)
{
    if( a[l] >= 30 && a[l] <= 70 && b[l] > 35 && b[l] < 100)
    {
        Tmatch++;
    }
}
Tmismatch = x1 - Tmatch;
System.out.println(x1 + " " + y1);
System.out.println("TMatch: " + Tmatch);
System.out.println("TMismatch: " + Tmismatch);
Tintensity = (Tmatch/(Tmatch + Tmismatch))*100.0;
System.out.println("TIntensity: " + Tintensity);
System.out.println();
System.out.println();*/




x1 = 0;
y1 = 0;
}






    public Main() {

// get the BufferedImage, using the ImageIO class

BufferedImage imagesample = null;
            try {
                imagesample = ImageIO.read(this.getClass().getResource("abcd.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

int pixels = imagesample.getRGB(0, 0);
     int alpha = (pixels >> 24) & 0xff;
 int red = (pixels >> 16) & 0xff;
 int green = (pixels >> 8) & 0xff;
 int blue = (pixels) & 0xff;

if(red > 125 && green > 125 && blue > 125)
{

 Color myWhite = new Color(255, 255, 255); // Color white
int rgb=myWhite.getRGB();
imagesample.setRGB(0, 0, rgb);
int i , j;
int wd = imagesample.getWidth();
int hd = imagesample.getHeight();
int alphas;
int reds;
int greens;
int blues;
for( i = 0 ; i < hd ; i++)
{
    for ( j = 0; j < wd; j++) {
    int pixel = imagesample.getRGB(j, i);
     alphas = (pixel >> 24) & 0xff;
 reds = (pixel >> 16) & 0xff;
 greens = (pixel >> 8) & 0xff;
 blues = (pixel) & 0xff;
    if(reds > 125 && greens > 125 && blues > 125)
{

 Color overWhite = new Color(255, 255, 255); // Color white
int rgbs=overWhite.getRGB();
imagesample.setRGB(j, i, rgbs);
    }
    else
    {
     Color overWhite = new Color(0, 0, 0); // Color white
int rgbs=overWhite.getRGB();
imagesample.setRGB(j, i, rgbs);
    }



    }
}

}
else if(red < 125 && green < 125 && blue < 125)
{

 Color myWhite = new Color(255, 255, 255); // Color white
int rgb=myWhite.getRGB();
imagesample.setRGB(0, 0, rgb);
int i , j;
int wd = imagesample.getWidth();
int hd = imagesample.getHeight();
int alphas;
int reds;
int greens;
int blues;
for( i = 0 ; i < hd ; i++)
{
    for ( j = 0; j < wd; j++) {
    int pixel = imagesample.getRGB(j, i);
     alphas = (pixel >> 24) & 0xff;
 reds = (pixel >> 16) & 0xff;
 greens = (pixel >> 8) & 0xff;
 blues = (pixel) & 0xff;
    if(reds < 125 && greens < 125 && blues < 125)
{

 Color overWhite = new Color(255, 255, 255); // Color white
int rgbs=overWhite.getRGB();
imagesample.setRGB(j, i, rgbs);
    }
    else
    {
     Color overWhite = new Color(0, 0, 0); // Color white
int rgbs=overWhite.getRGB();
imagesample.setRGB(j, i, rgbs);
    }



    }
}

}

/*int pixel = imagesample.getRGB(1, 1);
     int alph = (pixel >> 24) & 0xff;
 int re = (pixel >> 16) & 0xff;
 int gree = (pixel >> 8) & 0xff;
 int blu = (pixel) & 0xff;
 System.out.println("color : "+re+" "+gree+" "+blu);*/

colormodifiedImage(imagesample);


}

}
