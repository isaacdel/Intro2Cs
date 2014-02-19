import java.io.File;

import javax.swing.filechooser.FileSystemView;

import intro.ex7.*;

/**
 * 
A class defined especially for ex7.
 Contains a single static method that iterates recursively over folders
 beginning at a certain root and prints the contents using an instance of FileDisplay.

Author:
  Yoav Wald



Constructor Summary


RecursiveLs()







Method Summary



static void
displayFileTree(int depth,
                IntroFile root,
                FileDisplay gui)


          Recursively prints the contents of root up to depth using an instance of FileDisplay.



Methods inherited from class java.lang.Object


equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait




Constructor Detail


RecursiveLspublic RecursiveLs()



Method Detail


displayFileTreepublic static void displayFileTree(int depth,
                                   IntroFile root,
                                   FileDisplay gui)
Recursively prints the contents of root up to depth using an instance of FileDisplay.
 If depth is 0, just prints root. An increase of 1 in depth means printing another level down.

Parameters:depth - The depth of the recursion.root - The file or folder whos contents this method will display.gui - The FileDisplay instance this method will use in order to print the output.







      Overview 
      Package 
    Class 
      Use 
      Tree 
      Deprecated 
      Index 
      Help 










 PREV CLASS 
 NEXT CLASS

  FRAMES   
 NO FRAMES   

  <!--
  if(window==top) {
    document.writeln('<A HREF="allclasses-noframe.html"><B>All Classes</B></A>');
  }
  //-->
All Classes


  <A HREF="allclasses-noframe.html"><B>All Classes</B></A>







  SUMMARY: NESTED | FIELD | CONSTR | METHOD

DETAIL: FIELD | CONSTR | METHOD


 */

public class RecursiveLs extends java.lang.Object{
	/**
	 * 
	 */
	public RecursiveLs(){

	}
	private static void recursiveLs(int depth,IntroFile root, FileDisplay gui,int indentation) {
		gui.addLine(indentation, root.isDirectory(), root.getName());
		if(depth<1){
			return;
		}
		if(root.isDirectory()){
			IntroFile filesArray[]=root.listFiles();


			for(int i=0;i<filesArray.length;i++){
				if(filesArray[i].isFile()){
					gui.addLine(indentation+1, filesArray[i].isDirectory(), filesArray[i].getName());
				}
				else{
					recursiveLs(depth-1, filesArray[i], gui, indentation+1);
				}
			}
		}

	}


	/**
	 * Recursively prints the contents of root up to depth using an instance of FileDisplay.
 If depth is 0, just prints root. An increase of 1 in depth means printing another level down.

	 * @param depth The depth of the recursion.
	 * @param root The file or folder whos contents this method will display.
	 * @param gui The FileDisplay instance this method will use in order to print the output.
	 */
	public static void displayFileTree(int depth, IntroFile root, FileDisplay gui) {
		recursiveLs(depth, root, gui, 0);


	}

}