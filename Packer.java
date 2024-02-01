import java.util.*;
import java.io.*;

class Program327
{
    public static void main(String args[]) throws Exception
    {
        boolean bRet = false;
        byte Buffer[] = new byte[1024];
        int iRet = 0;

        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------Marvellous Packer Unpacker-----------------------");
        System.out.println("-------------------------------------------------------------------");

        Scanner sobj = new Scanner(System.in);

       System.out.println("Enter the name of Directory : ");
       String DirectoryName = sobj.nextLine();

       System.out.println("Enter the name of packed file that you want to store another file");
       String PackedFile = sobj.nextLine();

       File fobjPack = new File(PackedFile);
       bRet = fobjPack.createNewFile();

       if(bRet == false)
       {
            System.out.println("Unable to packed file...");
            System.exit(0);
       }

        System.out.println("Packed file is successfully created in current directory");

       File fobj = new File(DirectoryName);     
       bRet = fobj.isDirectory();

       if(bRet == true)
       {
            System.out.println("Directory is present");

            File Arr[] = fobj.listFiles();
            System.out.println("Number of files in the directory are : "+Arr.length);

            String Header = null;

            FileOutputStream fCombine = new FileOutputStream(PackedFile);

            System.out.println("Packing activity is started");
            System.out.println("-------------------------------------------------------------------");


            for(int i=0; i<Arr.length; i++)
            {
                Header = Arr[i].getName()+ " " + Arr[i].length();
                
                for(int j=Header.length(); j<100; j++)              
                {
                    Header = Header + " ";                          
                }

                byte hArr[] = Header.getBytes();

                fCombine.write(hArr,0,100);

                FileInputStream fiobj = new FileInputStream(Arr[i]);

                while((iRet = fiobj.read(Buffer)) != -1)
                {
                    fCombine.write(Buffer,0,iRet);
                }

                System.out.println("Packed file is : "+Arr[i].getName());

                 fiobj.close();
            }

            System.out.println("Packing activity is completed");
            System.out.println("Total files packed successfully : " +Arr.length); 

            System.out.println("-------------------------------------------------------------------");
            System.out.println("------------Thank You For Using Marvellous Packer Unpacker-----------");
            System.out.println("-------------------------------------------------------------------");

            fCombine.close();
       }
       else
       {
            System.out.println("There is no such a directory");
       }

       sobj.close();
    }
}
