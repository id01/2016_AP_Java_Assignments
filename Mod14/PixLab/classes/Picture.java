import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 * Modified by: Gavin Lo
 * Date: 04/07/17
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to keep only blue values */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  /** Method to make grayscale */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    int myGrayShade;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        myGrayShade = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
        pixelObj.setRed(myGrayShade);
        pixelObj.setGreen(myGrayShade);
        pixelObj.setBlue(myGrayShade);
      }
    }
  }

  /** Method to fix underwater */
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    int myBlue, myGreen;
    final int expVal = 12, lightVal = 1250; // expVal = exponent value = contrast, lightval = brightness
    final double expMax = Math.pow(2, 255/(255.0/expVal));
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        myGreen = (int)(lightVal*Math.pow(2, pixelObj.getGreen()/(255.0/expVal))/expMax); // Exponent curve from 0 to 1
        pixelObj.setGreen(myGreen);
        myBlue = (int)(lightVal*Math.pow(2, pixelObj.getBlue()/(255.0/expVal))/expMax); // Exponent curve from 0 to 1
        pixelObj.setBlue(myBlue);
      }
    } // Clarity is awesome with this configuration :D
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from right to left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from top to bottom */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel upPixel = null;
    Pixel downPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[height - 1 - row][col];
        downPixel.setColor(upPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a 
    * horizontal mirror in the center of the picture
    * from bottom to top */
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel upPixel = null;
    Pixel downPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[height - 1 - row][col];
        upPixel.setColor(downPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a 
    * diagnal mirror from top-left to bottom-right */
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel upPixel = null;
    Pixel downPixel = null;
    int height = pixels.length;
    int width = pixels[0].length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < width - (int)((double)width/height*row); col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[height - 1 - row][width - 1 - col];
        downPixel.setColor(upPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println("Executed " + count + " times");
  }

  /** Mirror just part of a picture of a snowman */
  public void mirrorSnowman()
  {
    int mirrorPoint = 190;
    Pixel downPixel = null;
    Pixel upPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 155; row < mirrorPoint; row++)
    {
      // loop through columns to the left
      for (int col = 0; col < 170; col++)
      {
        upPixel = pixels[row][col];      
        downPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        downPixel.setColor(upPixel.getColor());
        count++;
      }
    }
    // loop through the rows
    for (int row = 155; row < mirrorPoint; row++)
    {
      // loop through the columns to the right
      for (int col = 239; col < 300; col++)
      {
        upPixel = pixels[row][col];      
        downPixel = pixels[mirrorPoint - row + mirrorPoint + 4][col]; // Move it slightly downward too
        downPixel.setColor(upPixel.getColor());
        count++;
      }
    }
    System.out.println("Executed " + count + " times");
  }

  /** Mirror just part of a picture of a seagull */
  public void mirrorSeagull()
  {
    int mirrorPoint = 345;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    int brightnessSubtractor;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 230; row < 325; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 230; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        brightnessSubtractor = 18*(col-mirrorPoint)/(230-mirrorPoint); // This must be done to make brightness difference
        rightPixel.setRed(rightPixel.getRed()-brightnessSubtractor); // less obvious. Decreases the color by
        rightPixel.setGreen(rightPixel.getGreen()-brightnessSubtractor); // a little bit more per pixel to the right.
        rightPixel.setBlue(rightPixel.getBlue()-brightnessSubtractor);
        count++;
      }
    }
    System.out.println("Executed " + count + " times");
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    * @param fromStartRow the start row to copy from
    * @param fromStartCol the start col to copy from
    * @param endRow the end row to copy from
    * @param endCol the end column to copy from
    */
  public void copy2(Picture fromPic, 
                 int startRow, int startCol,
                 int fromStartRow, int fromStartCol,
                 int endRow, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fromStartRow, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length &&
         fromRow < endRow; 
         fromRow++, toRow++)
    {
      for (int fromCol = fromStartCol, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length &&
           fromCol < endCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }

  public void myCollage()
  {
    Picture underwater = new Picture("water.jpg");
    underwater.fixUnderwater();
    this.copy(underwater, 0, 0);
    Picture seagull = new Picture("seagull.jpg");
    seagull.mirrorSeagull();
    this.copy2(seagull, 120, 45, 230, 230, 325, 460);
    Picture flower = new Picture("flower1.jpg");
    flower.grayscale();
    this.copy(flower, 320, 55);
    this.mirrorVertical();
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  /** Method to show large changes in color vertically
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetectionVertical(int edgeDist)
  {
    Pixel upPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color downColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[row+1][col];
        downColor = downPixel.getColor();
        if (upPixel.colorDistance(downColor) > 
            edgeDist)
          upPixel.setColor(Color.BLACK);
        else
          upPixel.setColor(Color.WHITE);
      }
    }
  }

  /** Method to show large changes in color diagnally, both up and down
    * @param edgeDist the distance for finding edges
    * @param canvasPicture an exact copy of the picture to use as a canvas
    */
  public void edgeDetection2(int edgeDist, Picture canvasPicture)
  {
    Pixel thisPixel = null;
    Pixel rightPixel = null;
    Pixel downPixel = null;
    Pixel canvasPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] canvas = canvasPicture.getPixels2D();
    Color downColor = null;
    Color rightColor = null;
    // Set pixels on canvas to white
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        canvas[row][col].setColor(Color.WHITE);
      }
    }
    // Top-left to bottom-right, change pixels to black
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        thisPixel = pixels[row][col];
        downPixel = pixels[row+1][col];
        rightPixel = pixels[row][col+1];
        canvasPixel = canvas[row][col];
        downColor = downPixel.getColor();
        rightColor = rightPixel.getColor();
        if (thisPixel.colorDistance(downColor) > edgeDist && thisPixel.colorDistance(rightColor) > edgeDist)
          canvasPixel.setColor(Color.BLACK);
      }
    }
    // Bottom-right to top-left (Note: downPixel is not on top, and rightPixel is now to the left!)
    for (int row = 1; row < pixels.length; row++)
    {
      for (int col = 1; 
           col < pixels[0].length; col++)
      {
        thisPixel = pixels[row][col];
        downPixel = pixels[row-1][col];
        rightPixel = pixels[row][col-1];
        canvasPixel = canvas[row][col];
        downColor = downPixel.getColor();
        rightColor = rightPixel.getColor();
        if (thisPixel.colorDistance(downColor) > edgeDist && thisPixel.colorDistance(rightColor) > edgeDist)
          canvasPixel.setColor(Color.BLACK);
      }
    }
    // Copy everything over from canvas
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length; col++)
      {
        thisPixel = pixels[row][col];
        canvasPixel = canvas[row][col];
        thisPixel.setColor(canvasPixel.getColor());
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this is the end of class Picture, put all new methods before this
