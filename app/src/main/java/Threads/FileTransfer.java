package Threads;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class FileTransfer {

    private Socket socket;

    public FileTransfer(Socket socket) {
        this.socket = socket;
        try {
            this.socket.setKeepAlive(false);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void receive(){
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            int number = dis.readInt();
            ArrayList<File> files = new ArrayList<File>(number);
            Log.d("MSG","Number of Files to be received: " +number);
            long fileSize = 0;
            long FILE_SIZE=0;
            for(int i = 0; i< number;i++){
                File file = new File(dis.readUTF());
                fileSize= dis.readLong();
                FILE_SIZE=fileSize;
                files.add(file);
            }
            final byte[]BUF = new byte[1024];
            for(int i = 0; i < files.size();i++){
                int read = 0;
                System.out.print("\n"+"Receiving file: " + files.get(i).getName());
                FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+files.get(i).getName());
                while ((fileSize > 0) && ((read = dis.read(BUF, 0, (int) Math.min(BUF.length, fileSize))) != -1))
                {
                    System.out.println((float)(FILE_SIZE-fileSize)/(FILE_SIZE/100)+"%");
                    fos.write(BUF,0,read);
                    fileSize -= read;
                }
                Log.d("MSG",files.get(i).getName()+": DONE.");
                fos.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void send(ArrayList<File> files){
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println(files.size());
            dos.writeInt(files.size());
            dos.flush();
            for(int i = 0 ; i < files.size();i++){
                dos.writeUTF(files.get(i).getName());
                System.out.println("Sending size: "+files.get(i).length());
                dos.writeLong(files.get(i).length());
                dos.flush();
            }
            int n = 0;
            byte[]buf = new byte[1024];
            for(int i =0; i < files.size(); i++){
                System.out.println(files.get(i).getName());
                FileInputStream fis = new FileInputStream(files.get(i));
                int j=0;
                while(((n =fis.read(buf)) != -1)){
                    System.out.println("cislo:	"+j);
                    dos.write(buf,0,n);
                    dos.flush();
                    j++;
                }
                fis.close();
            }
            dos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}